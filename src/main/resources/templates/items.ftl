<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<h1> Table of items </h1>
<div>
<table style="text-align: center" border="3" bgcolor="#f0f8ff">

    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Description</th>
        <th>Created</th>
        <th>Updated</th>
    </tr>

    <#list items as item>
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.desc}</td>
            <td>${item.createdAt}</td>
            <td>${item.updatedAt}</td>
        </tr>
    </#list>

</table>
</div>
</body>
</html>