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
            input[type=text], input[type=password],input[type=tel],input[type=email]  {
                width: 100%;
                padding: 10px;
                margin: 5px 0 15px 0;
                display: inline-block;
                border: none;
                background: #f1f1f1;
            }

            input[type=text]:focus, input[type=password]:focus,input[type=tel]:focus ,input[type=email]:focus{
                background-color: #ddd;
                outline: none;
            }

            /* Overwrite default styles of hr */
            hr {
                border: 1px solid #f1f1f1;
                margin-bottom: 25px;
            }

            /* Set a style for the submit button */
            .registerbtn {
                background-color: #4CAF50;
                color: white;
                padding: 16px 15px;
                margin: 8px 0;
                border: none;
                cursor: pointer;
                width: 100%;
                opacity: 0.9;
            }

            .registerbtn:hover {
                opacity: 1;
            }

            /* Add a blue text color to links */
            a {
                color: dodgerblue;
            }

            /* Set a grey background color and center the text of the "sign in" section */
            .signin {
                background-color: #f1f1f1;
                text-align: center;
            }
        </style>
    </head>
    <body>

    <form action="/register" method="post" id="registration-form">
        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
        </#if>
        <div class="container">
            <h1>Register</h1>
            <p>Please fill in this form to create an account.</p>
            <hr>

            <label for="email"><b>Email</b></label>
            <input type="email" name="email" class="form-control mb-1" placeholder="Email" value="${(dto.email)!''}" ><br>
            <label for="name"><b>Name</b></label>
            <input type="text" name="name" class="form-control mb-1" placeholder="Name"  value="${(dto.name)!''}"><br>
            <label for="address"><b>Address</b></label>
            <input type="text" name="address" class="form-control mb-1" placeholder="address" value="${(dto.address)!''}"><br>
            <label for="tel"><b>PhoneNumber</b></label>
            <input type="tel" name="phoneNumber" class="form-control mb-1" placeholder="phoneNumber" value="${(dto.phoneNumber)!''}">><br>
            <label for="psw"><b>Password</b></label>
            <input type="password" name="password" class="form-control mb-1" placeholder="Пароль"  value=""> <br>
            <hr>
            <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>

            <button type="submit" class="registerbtn">Register</button>
        </div>

        <div class="container signin">
            <p>Already have an account? <a href="/login">Sign in</a>.</p>
        </div>
        <div>
            <#if errors?? >
                <p>Входные данные с ошибками!</p>
                <#list errors as fieldError>
                    <p>${fieldError.field} - ${fieldError.defaultMessage!'-- no message --'}</p>
                </#list>
            </#if>
        </div>
    </form>

    </body>

    <div class="bottom-box">
        <a href="/">На главную страницу</a>
    </div>


</@main.renderWith>