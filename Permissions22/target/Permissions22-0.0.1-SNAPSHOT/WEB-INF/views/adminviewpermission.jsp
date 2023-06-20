<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="models.ApplyPermissions" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Permission Requests</title>
<style>
    table {
        border-collapse: collapse;
        width: 100%;
    }

    th, td {
        text-align: left;
        padding: 8px;
    }

    th {
        background-color: #f2f2f2;
    }

    tr:nth-child(even) {
        background-color: #f9f9f9;
    }

    .action-buttons {
        display: flex;
    }

    .action-buttons button {
        margin-right: 5px;
    }
</style>
</head>
<body>
    <h2>Permission Requests</h2>
    <table>
        <thead>
            <tr>
                <th>Emp ID</th>
                <th>Permission Date</th>
                <th>Start Time</th>
                <th>End Time</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <% List<ApplyPermissions> permissions = (List<ApplyPermissions>) request.getAttribute("permissions");
            if (permissions != null) {
                for (ApplyPermissions permi : permissions) {
            %>
            <tr>
                <td align="center"><%= permi.getId().getId() %></td>
                <td align="center"><%= permi.getCurrent_date() %></td> 
                <td align="center"><%= permi.getStart_time() %></td>
                <td align="center"><%= permi.getEnd_time() %></td>
                <td class="action-buttons">
                    <button class="accept-button" onclick="acceptPermission(<%= permi.getId().getId() %>)">Accept</button>
                    <button class="reject-button" onclick="rejectPermission(<%= permi.getId().getId() %>)">Reject</button>
                </td>             
            </tr>
            <% }
            }
            %>
        </tbody>
    </table>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script>
function acceptPermission(empId) {
    console.log("Accept permission for empId: " + empId);

    // Fetch the index for the given empId
    // Make the accept permission request
    $.ajax({
        url: "acceptpermissions",
        type: "POST",
        data: { empId: empId, status: 'accept' },
        success: function(response) {
            console.log("Accept permission successful");
            // TODO: Handle the success response if needed
        },
        error: function(xhr, status, error) {
            console.log("Accept permission failed");
            // TODO: Handle the error response if needed
        }
    });

}

function rejectPermission(empId) {
    console.log("Reject permission for empId: " + empId);

    // Fetch the index for the given empId
    // Make the reject permission request
    $.ajax({
        url: "rejectpermissions",
        type: "POST",
        data: { empId: empId, status: 'reject' },
        success: function(response) {
            console.log("Reject permission successful");
            // TODO: Handle the success response if needed
        },
        error: function(xhr, status, error) {
            console.log("Reject permission failed");
            // TODO: Handle the error response if needed
        }
    });
}


</script>
</body>
</html>
