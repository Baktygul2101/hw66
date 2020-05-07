<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Search by product</title>
</head>
<body>

    <div class="form-row text-center">
        <div class="form-group col-md-6">
            <form method="get" action="/search" class="form-inline">
                <input type="text" name="filter" class="form-control" value="${filter?ifExists}" placeholder="Search by product name" />
                <button type="submit" class="btn btn-primary ml-2">Search</button>
            </form>
        </div>
    </div>




</body>
</html>
