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
            <th>Description</th>
            <th>Created</th>
            <th>Updated</th>
        </tr>

        <#list elements as element>
            <tr>
                <td>${element.id}</td>
                <td>${element.name}</td>
                <td>${element.description}</td>
                <td>${element.createdAt}</td>
                <td>${element.updatedAt}</td>
            </tr>
        </#list>

    </table>
</div>
</body>
</html>