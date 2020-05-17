<#-- импортируем основной шаблон-контейнер который содержит в себе разметку для основной структуры страницы -->
<#import "partials/main.ftlh" as main />

<#-- обрабатываем его, и передаём ему список скриптов, которые необходимо подключить-->

<@main.renderWith scripts=["/js/main.js"]>

    <#if errorText?? >
        <div>
            <p>${errorText!'-- no message --'}</p>
        </div>
    </#if>







</@main.renderWith>







