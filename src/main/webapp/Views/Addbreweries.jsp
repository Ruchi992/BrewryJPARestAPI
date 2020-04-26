<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
       
    <head>
    </head>
  
        <h3>Enter the details</h3>
        
        <form method="POST" action="/breweries/edit">
                   
            <table>
                <tr>
                    <td><label name="id">ID</label></td>
                    <td><input name="id"/></td>
                </tr>
                <tr>
                    <td><label name="name">Name</label></td>
                    <td><input name="name"/></td>
                </tr>
                 <tr>
                    <td><label name="address1">ADDRESS1</label></td>
                    <td><input name="address1"/></td>
                </tr>
                <tr>
                    <td><label name="address2">ADDRESS2</label></td>
                    <td><input name="address2"/></td>
                </tr>
                <tr>
                    <td><label name="city">CITY</label></td>
                    <td><input name="city"/></td>
                </tr>
                <tr>
                    <td><label name="state">State</label></td>
                    <td><input name="state"/></td>
                </tr>
                <tr>
                    <td><label name="code">Code</label></td>
                    <td><input name="code"/></td>
                </tr>
                <tr>
                    <td><label name="country">Country</label></td>
                    <td><input name="country"/></td>
                </tr>
                <tr>
                    <td><label name="phone">Phone</label></td>
                    <td><input name="phone"/></td>
                </tr>
                <tr>
                    <td><label name="website">Website</label></td>
                    <td><input name="website"/></td>
                </tr>
                <tr>
                    <td><label name="image">Image</label></td>
                    <td><input name="image"/></td>
                </tr>
                <tr>
                    <td><label name="description">Description</label></td>
                    <td><input name="description"/></td>
                </tr>
                <tr>
                    <td><label name="addUser">Add User</label></td>
                    <td><input name="addUser"/></td>
                </tr>
                <tr>
                    <td><label name="lastmod">Last mod</label></td>
                    <td><input name="lastmod"/></td>
                </tr>
                <tr>
                    <td><label name="creditlimit">Credit Limit</label></td>
                    <td><input name="creditlimit"/></td>
                </tr>                
                <tr>
                    <td><label name="email">Email</label></td>
                    <td><input name="email"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit!"</td>
                </tr>
            </table>
        </form>

</html>