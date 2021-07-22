<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Item</title>
</head>
<body>

<h1> Updating </h1>


<div>
    <fieldset>
        <legend> Add Item</legend>
        <form anem="item" action="" method="POST">
            id:<@spring.formInput "form.id" "" "text"/>
            <br>
            name:<@spring.formInput "form.name" "" "text"/>
            <br>
            Description:<@spring.formInput "form.desc" "" "text"/>
            <br>
            Created At:<@spring.formInput "form.createdAt" "" "date"/>
            <br>
            <input type="submit" value="Update"/>
        </form>
    </fieldset>
</div>

</body>
</html>