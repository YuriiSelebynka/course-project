<#import  "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Elements</title>
</head>
<body style="text-align: center">

<h1> Table of elements </h1>
<div>
    <table align="center" style="text-align: center" border="3" bgcolor="blue">

        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Item</th>
            <th>Description</th>
            <th>Created</th>
            <th>Updated</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>

        <#list elements as element>
            <tr>
                <td>${element.id}</td>
                <td>${element.name}</td>
                <td>${element.item.name}</td>
                <td>${element.description}</td>
                <td>${element.createdAt}</td>
                <td>${element.updatedAt}</td>
                <td> <a href="/gui/element/delete/${element.id}"> <input type="button" class="btn btn-danger" value="Del"> </a> </td>
                <td> <a href="/gui/element/update/${element.id}"> <input type="button" class="btn btn-dark" value="Edit"> </a> </td>

            </tr>
        </#list>

    </table>
</div>

<td> <a href="/gui/element/create"> <input type="button" class="btn btn-success" value="Create"> </a> </td>
</body>
</html>