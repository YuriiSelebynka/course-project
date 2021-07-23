<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Element</title>
</head>
<body style="text-align: center">

<h1> Updating element</h1>


<div>
    <fieldset>
        <legend> Add Element</legend>
        <form anem="element" action="" method="POST">
<#--            id:<@spring.formInput "form.id" "" "text"/>-->
<#--            <br>-->
            name:<@spring.formInput "form.name" "" "text"/>
            <br>
            Item:<@spring.formInput "form.item" "" "text"/>
            <br>
            Description:<@spring.formInput "form.description" "" "text"/>
            <br>
            Created At:<@spring.formInput "form.createdAt" "" "date"/>
            <br>
            <input type="submit" value="Update"/>
        </form>
    </fieldset>
</div>

</body>
</html>