关于视图映射
1.静态页面的return默认是跳转到/static/index.html，当在pom.xml中引入了thymeleaf组件，动态跳转会覆盖默认的静态跳转，
默认就会跳转到/templates/index.html，注意看两者return代码也有区别，静态返回/index.html,动态返回/index。