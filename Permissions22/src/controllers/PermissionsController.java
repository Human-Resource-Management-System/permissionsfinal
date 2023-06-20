package controllers;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import DAO.ApplyPermissionDaoImpl;
import models.ApplyPermissions;
import models.Employee;
import models.PermissionAdminModel;
import models.PermissionCompositeKey;
import models.PermissionInputModel;

@Controller
public class PermissionsController {

	private ApplyPermissionDaoImpl apd;
	private ApplyPermissions ap;
	private PermissionCompositeKey pcompositeKey;

	@Autowired
	public PermissionsController(ApplyPermissionDaoImpl apdi, ApplyPermissions app, PermissionCompositeKey cKey) {
		apd = apdi;
		ap = app;
		pcompositeKey = cKey;
	}

	@RequestMapping(value = "/getpermissions")
	public String applypermission(Model model) {
		Long count = apd.getEmployeeAndPermissionRequestDataCount(302, Date.valueOf(LocalDate.now()));
		System.out.println(count);
		model.addAttribute("PermissionCount", count);
		return "emppermission";
	}

	@RequestMapping(value = "/applyPermission", method = RequestMethod.POST)
	public ResponseEntity<String> applyPermission(@ModelAttribute PermissionInputModel permissionInput) {
		try {

			ap.setCurrent_date(Date.valueOf(permissionInput.getCurrent_date()));
			// Convert the start and end time strings to Time objects
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
			LocalTime startTime = LocalTime.parse(permissionInput.getStart_time(), formatter);
			LocalTime endTime = LocalTime.parse(permissionInput.getEnd_time(), formatter);

			ap.setStart_time(Time.valueOf(startTime));
			ap.setEnd_time(Time.valueOf(endTime));
			ap.setReason(permissionInput.getReason());

			pcompositeKey.setId(permissionInput.getId());
			int index = apd.getNextPermissionIndex(permissionInput.getId());
			pcompositeKey.setEp_index(index);

			ap.setId(pcompositeKey);

			apd.persist(ap);

			return ResponseEntity.ok("success");
		} catch (Exception e) {
			e.printStackTrace();
			String errorMessage = "Internal Server Error";
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
		}
	}

	@RequestMapping(value = "/adminviewpermissions")
	public String adminViewpermission(Model model) {

		// List<ApplyPermissions> permissions = apd.adminViewPermission();

		List<Employee> employees = apd.getEmployeesByHRAndManager(600);
		List<ApplyPermissions> outputmodel = new ArrayList<>();
		for (Employee employee : employees) {
			System.out.println(employee.getEmplId());
			ApplyPermissions permission = apd.getEmployeeAndPermissionRequestData(employee.getEmplId(),
					Date.valueOf(LocalDate.now()));

			System.out.println(permission);
			if (permission != null)
				outputmodel.add(permission);
		}
		model.addAttribute("permissions", outputmodel);
		return "adminviewpermission";
	}

	@RequestMapping(value = "/acceptpermissions")
	@Transactional
	public ResponseEntity<String> acceptPermission(@ModelAttribute PermissionAdminModel pm) {
		try {
			System.out.println(pm.getId());
			ApplyPermissions permission = apd.getPermissionByIdAndIndex(pm.getId(), pm.getIndex());

			System.out.println(permission);
			if (permission != null) {
				permission.setEprq_status("accept");
				// Set other properties if needed
				permission.setEprq_approvedby(123 + "");
				apd.persist(permission);
				return ResponseEntity.ok("success");
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Permission not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			String errorMessage = "Internal Server Error";
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
		}
	}

	@RequestMapping(value = "/rejectpermissions")
	@Transactional
	public ResponseEntity<String> rejectPermission(@ModelAttribute PermissionAdminModel pm) {
		try {

			ApplyPermissions permission = apd.getPermissionByIdAndIndex(pm.getId(), pm.getIndex());
			if (permission != null) {
				permission.setEprq_status("reject");
				// Set other properties if needed
				apd.persist(permission);
				return ResponseEntity.ok("success");
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Permission not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			String errorMessage = "Internal Server Error";
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
		}
	}

}
