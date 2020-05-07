<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Products</title>
</head>
<body>
<h1>Products</h1>

<table>
    <thead>
    <tr>
        <th></th>
        <th>Name</th>
        <th>image</th>
        <th>price</th>
    </tr>
    </thead>
    <tbody>

        <#list products as product>
            <li>
                <p>${product.id} - ${product.name} - ${product.image}- ${product.price} -</p>
            </li>
        </#list>

    </tbody>
</table>


</body>
</html>
