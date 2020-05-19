<#import "partials/main.ftlh" as main />


<@main.renderWith>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style>
            body {
                font-family: Arial, Helvetica, sans-serif;
            }
            * {
                box-sizing: border-box;
            }
            /* Add padding to containers */
            .container {
                padding-left: 60px;
                padding-right: 60px;
                background-color: white;
            }

            /* Full-width input fields */
            p {
                width: 50%;
                padding: 10px;
                margin: 5px 0 5px 0;
                display: inline-block;
                border: none;
                background: #f1f1f1;
            }

            hr {
                border: 1px solid #f1f1f1;
                margin-bottom: 25px;
            }

        </style>
    </head>
    <body>
    <#if dto??>
        <h1>Ваши учетные данные!</h1>
        <hr>
        <label for="name"><b>Name</b></label><br>
        <p> ${(dto.name)!'-- missing --'}</p><br>
        <label for="address"><b>Address</b></label><br>
        <p> ${(dto.address)!'-- missing --'}</p><br>
        <label for="tel"><b>PhoneNumber</b></label><br>
        <p> ${(dto.phoneNumber)!'--  missing --'}</p><br>
        <label for="email"><b>Email</b></label><br>
        <p>${(dto.email)!'-- email missing --'}</p>
        <hr>
    <#else>
        <h1>Пользователь не найден!</h1>
    </#if>
    <div class="bottom-box">
        <a href="/">На главную страницу</a>
    </div>
    </body>
</@main.renderWith>