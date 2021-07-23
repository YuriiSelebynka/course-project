<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create Element</title>
</head>
<body style="text-align: center">

<h1> Creation element</h1>


<div>
    <fieldset>
        <legend> Add Element</legend>
        <form anem="element" action="" method="POST">
            name:<@spring.formInput "form.name" "" "text"/>
            <br>
            Item:<@spring.formInput "form.item" "" "text"/>
            <br>
            Description:<@spring.formInput "form.description" "" "text"/>
            <br>
            <input type="submit" value="Create"/>
        </form>
    </fieldset>
</div>

</body>
</html>