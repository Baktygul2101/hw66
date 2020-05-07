<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Sweater</title>
    <link rel="stylesheet" href="/static/style.css" />
</head>
<body>
    <ul>
        <#list products as pdt>
            <li>
                <p>
                    ${pdt.id} - ${pdt.name} - ${pdt.description}-${pdt.price}-${pdt.quantity}</a>
                </p>
            </li>
        </#list>
    </ul>
    </body>
</html>

