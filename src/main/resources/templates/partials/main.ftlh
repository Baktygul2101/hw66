<#macro renderWith title="online shop" scripts=[] styles=[]>
    <!doctype html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>${title}</title>
            <link rel="stylesheet" href="/css/style.css">

        <#list styles as styleSource>
            <link rel="stylesheet" href="${styleSource}">
        </#list>
    </head>
    <body>

    <div>
        <h1>Online shop</h1>
        <div class="d-flex justify-content-end">
            <form class="flex box-128" action="/logout" method="post">
                <#if _csrf??>
                    <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
                </#if>
                <button class="flex box-128 logout-button">Выйти </button>
            </form>
        </div>
        <div class="navbar">
            <a class="active" href="/"><i class="fa fa-fw fa-home"></i> Home</a>
            <a href="/products"><i class="fa fa-fw fa-search"></i> Search</a>
            <a href="/register"><i class="fa fa-fw fa-envelope"></i> Registration</a>
            <a href="/profile"><i class="fa fa-fw fa-user"></i> Profile</a>
            <a href="/login"><i class="fa fa-sign-in"></i> Login</a>
            <a href="/session"><i class="fa fa-shopping-cart"></i> My orders</a>

        </div>
        <#nested>

    </div>

    <#list scripts as scriptSource>
        <script src="${scriptSource}"></script>
    </#list>

    </body>
    </html>

</#macro>