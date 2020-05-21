<#import "/spring.ftl" as spring>
<#import "partials/main.ftlh" as main>

<@main.renderWith scripts=["/js/main.js"]>
    <div> Hello friend!</div>
    <h1><@spring.message "title" /></h1>
    <#if errorText?? >
        <div>
            <p>${errorText!'-- no message --'}</p>
        </div>
    </#if>
</@main.renderWith>