<#import "/spring.ftl" as spring>
<#macro renderWith title="online shop" scripts=[] styles=[] dir="ltr">
    <!doctype html>
    <html lang="${.locale}" dir="${dir}">
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
    <div class="container">
        <div>
            <form action="" method="get">
                <label for="lang_select">
                    <@spring.message "label.language" />:
                </label>
                <select name="lang" id="lang_select">
                    <option value="">Default</option>
                    <option value="" disabled>----------</option>
                    <option value="en-GB">British English</option>
                    <option value="en-US">American English</option>
                    <option value="ru-RU">Русский</option>
                </select>
                <button type="submit">
                    <@spring.message "button.language-change.text" />
                </button>
            </form>


        <#nested>
        <p>текущая локаль: ${.locale}</p>


    <div>

        <div class="d-flex justify-content-end">
            <form class="flex box-128" action="/logout" method="post">
                <#if _csrf??>
                    <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
                </#if>
                <button class="flex box-128 logout-button"><@spring.message "log" /></button>
            </form>
        </div>
        <div class="navbar">
            <a class="active" href="/"><i class="fa fa-fw fa-home"></i> Home</a>
            <a href="/products"><i class="fa fa-fw fa-search"></i> <@spring.message "search" /></a>

            <a href="/cart"><i class="fa fa-shopping-cart"></i>  <@spring.message "cart" /></a>
            <a href="/register"><i class="fa fa-fw fa-envelope"> </i>  <@spring.message "registration" /></a>
            <a href="/profile"><i class="fa fa-fw fa-user"></i> <@spring.message "profile" /></a>
            <a href="/login"><i class="fa fa-sign-in"></i>  <@spring.message "login" /></a>
            <a class="flex box-128" href="/forgot-password">  <@spring.message "forget"/></a>
        </div>
        <#nested>

    </div>
        </div>
    <#list scripts as scriptSource>
        <script src="${scriptSource}"></script>
    </#list>

    </body>
    </html>

</#macro>