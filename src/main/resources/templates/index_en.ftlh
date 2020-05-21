<#import "/spring.ftl" as spring>
<#import "partials/main.ftlh" as main>

<@main.renderWith>
    <div> Hello friend!</div>
    <h1><@spring.message "title" /></h1>
</@main.renderWith>