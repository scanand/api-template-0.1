
<!-- http://www.kubrynski.com/2014/01/understanding-spring-web-initialization.html -->
Java EE provides ServletContainerInitializer interface <==>  SpringServletContainerInitializer
SpringServletContainerInitializer
1. looks for all found classes implementing WebApplicationInitializer interface
2. sorting them basing on @Order annotation (non-annotated classes gets the highest possible order, so they are processed at the end) and
3. invoking onStartup() method
lowest number declares rootcontext (*00:06:18,353  info contextloader:347*)

00:06:17,999  INFO ContextLoader:307 - Root WebApplicationContext: initialization started
            00:06:18,083 DEBUG StandardServletEnvironment:109 - Adding [servletConfigInitParams] PropertySource with lowest search precedence
            00:06:18,084 DEBUG StandardServletEnvironment:109 - Adding [servletContextInitParams] PropertySource with lowest search precedence
            00:06:18,095 DEBUG StandardServletEnvironment:109 - Adding [jndiProperties] PropertySource with lowest search precedence
            00:06:18,095 DEBUG StandardServletEnvironment:109 - Adding [systemProperties] PropertySource with lowest search precedence
            00:06:18,097 DEBUG StandardServletEnvironment:109 - Adding [systemEnvironment] PropertySource with lowest search precedence
            00:06:18,098 DEBUG StandardServletEnvironment:127 - Initialized StandardServletEnvironment with PropertySources [servletConfigInitParams,servletContextInitParams,jndiProperties,systemProperties,systemEnvironment]
            00:06:18,103 DEBUG StandardServletEnvironment:174 - Replacing [servletContextInitParams] PropertySource with [servletContextInitParams]

00:06:18,104  INFO AnnotationConfigWebApplicationContext:578 - Refreshing Root WebApplicationContext: startup date [Thu Feb 25 00:06:18 EST 2016]; root of context hierarchy
00:06:18,189 DEBUG ClassPathBeanDefinitionScanner:244 - JSR-250 'javax.annotation.ManagedBean' found and supported for component scanning
00:06:18,190 DEBUG ClassPathBeanDefinitionScanner:252 - JSR-330 'javax.inject.Named' annotation found and supported for component scanning
00:06:18,191 DEBUG AnnotationConfigWebApplicationContext:612 - Bean factory for Root WebApplicationContext: org.springframework.beans.factory.support.DefaultListableBeanFactory@cd2c4c:
 defining beans [org.springframework.context.annotation.internalConfigurationAnnotationProcessor,org.springframework.context.annotation.internalAutowiredAnnotationProcessor,
 org.springframework.context.annotation.internalRequiredAnnotationProcessor,org.springframework.context.annotation.internalCommonAnnotationProcessor,org.springframework.context.event.internalEventListenerProcessor,
 org.springframework.context.event.internalEventListenerFactory]; root of factory hierarchy

    Why Refreshing and BeanDefinitionRegistry?
     =>  ** http://docs.spring.io/spring/docs/3.0.x/javadoc-api/org/springframework/context/support/GenericApplicationContext.html**
          Typical usage is to register a variety of bean definitions via the BeanDefinitionRegistry interface and then
           call Abstract\ApplicationContext.refresh() to initialize those beans with application context semantics
           (handling ApplicationContextAware, auto-detecting BeanFactoryPostProcessors, etc).

00:06:18,204 DEBUG DefaultListableBeanFactory:874 - Registering scope 'request' with implementation [org.springframework.web.context.request.RequestScope@207a06b6]
00:06:18,205 DEBUG DefaultListableBeanFactory:874 - Registering scope 'session' with implementation [org.springframework.web.context.request.SessionScope@13d8920d]
00:06:18,205 DEBUG DefaultListableBeanFactory:874 - Registering scope 'globalSession' with implementation [org.springframework.web.context.request.SessionScope@63e76976]
00:06:18,206 DEBUG DefaultListableBeanFactory:874 - Registering scope 'application' with implementation [org.springframework.web.context.support.ServletContextScope@4cb03375]

    ** Checking scope of the beans declared, for WebApplicationContexgt by default is Session, for normal spring application it is Singleton


00:06:18,213 DEBUG DefaultListableBeanFactory:221 - Creating shared instance of singleton bean 'org.springframework.context.annotation.internalConfigurationAnnotationProcessor'
00:06:18,214 DEBUG DefaultListableBeanFactory:448 - Creating instance of bean 'org.springframework.context.annotation.internalConfigurationAnnotationProcessor'
00:06:18,237 DEBUG DefaultListableBeanFactory:529 - Eagerly caching bean 'org.springframework.context.annotation.internalConfigurationAnnotationProcessor' to allow for resolving potential circular references
00:06:18,240 DEBUG DefaultListableBeanFactory:484 - Finished creating instance of bean 'org.springframework.context.annotation.internalConfigurationAnnotationProcessor'
00:06:18,253 DEBUG DefaultListableBeanFactory:221 - Creating shared instance of singleton bean 'org.springframework.context.annotation.internalAutowiredAnnotationProcessor'
00:06:18,254 DEBUG DefaultListableBeanFactory:448 - Creating instance of bean 'org.springframework.context.annotation.internalAutowiredAnnotationProcessor'
00:06:18,255  INFO AutowiredAnnotationBeanPostProcessor:153 - JSR-330 'javax.inject.Inject' annotation found and supported for autowiring
00:06:18,255 DEBUG DefaultListableBeanFactory:529 - Eagerly caching bean 'org.springframework.context.annotation.internalAutowiredAnnotationProcessor' to allow for resolving potential circular references
00:06:18,255 DEBUG DefaultListableBeanFactory:484 - Finished creating instance of bean 'org.springframework.context.annotation.internalAutowiredAnnotationProcessor'
00:06:18,255 DEBUG DefaultListableBeanFactory:221 - Creating shared instance of singleton bean 'org.springframework.context.annotation.internalRequiredAnnotationProcessor'
00:06:18,256 DEBUG DefaultListableBeanFactory:448 - Creating instance of bean 'org.springframework.context.annotation.internalRequiredAnnotationProcessor'
00:06:18,256 DEBUG DefaultListableBeanFactory:529 - Eagerly caching bean 'org.springframework.context.annotation.internalRequiredAnnotationProcessor' to allow for resolving potential circular references
00:06:18,256 DEBUG DefaultListableBeanFactory:484 - Finished creating instance of bean 'org.springframework.context.annotation.internalRequiredAnnotationProcessor'
00:06:18,257 DEBUG DefaultListableBeanFactory:221 - Creating shared instance of singleton bean 'org.springframework.context.annotation.internalCommonAnnotationProcessor'
00:06:18,257 DEBUG DefaultListableBeanFactory:448 - Creating instance of bean 'org.springframework.context.annotation.internalCommonAnnotationProcessor'
00:06:18,259 DEBUG DefaultListableBeanFactory:529 - Eagerly caching bean 'org.springframework.context.annotation.internalCommonAnnotationProcessor' to allow for resolving potential circular references
00:06:18,259 DEBUG DefaultListableBeanFactory:484 - Finished creating instance of bean 'org.springframework.context.annotation.internalCommonAnnotationProcessor'
00:06:18,260 DEBUG DefaultListableBeanFactory:221 - Creating shared instance of singleton bean 'org.springframework.context.annotation.ConfigurationClassPostProcessor.importAwareProcessor'
00:06:18,260 DEBUG DefaultListableBeanFactory:448 - Creating instance of bean 'org.springframework.context.annotation.ConfigurationClassPostProcessor.importAwareProcessor'
00:06:18,260 DEBUG DefaultListableBeanFactory:529 - Eagerly caching bean 'org.springframework.context.annotation.ConfigurationClassPostProcessor.importAwareProcessor' to allow for resolving potential circular references
00:06:18,260 DEBUG DefaultListableBeanFactory:484 - Finished creating instance of bean 'org.springframework.context.annotation.ConfigurationClassPostProcessor.importAwareProcessor'
00:06:18,260 DEBUG DefaultListableBeanFactory:221 - Creating shared instance of singleton bean 'org.springframework.context.annotation.ConfigurationClassPostProcessor.enhancedConfigurationProcessor'
00:06:18,260 DEBUG DefaultListableBeanFactory:448 - Creating instance of bean 'org.springframework.context.annotation.ConfigurationClassPostProcessor.enhancedConfigurationProcessor'
00:06:18,261 DEBUG DefaultListableBeanFactory:529 - Eagerly caching bean 'org.springframework.context.annotation.ConfigurationClassPostProcessor.enhancedConfigurationProcessor' to allow for resolving potential circular references
00:06:18,261 DEBUG DefaultListableBeanFactory:484 - Finished creating instance of bean 'org.springframework.context.annotation.ConfigurationClassPostProcessor.enhancedConfigurationProcessor'

 *** Bean Lifecycle methods

00:06:18,264 DEBUG AnnotationConfigWebApplicationContext:718 - Unable to locate MessageSource with name 'messageSource': using default [org.springframework.context.support.DelegatingMessageSource@7f547d40]
00:06:18,267 DEBUG AnnotationConfigWebApplicationContext:742 - Unable to locate ApplicationEventMulticaster with name 'applicationEventMulticaster': using default [org.springframework.context.event.SimpleApplicationEventMulticaster@310ee929]
00:06:18,270 DEBUG UiApplicationContextUtils:85 - Unable to locate ThemeSource with name 'themeSource': using default [org.springframework.ui.context.support.ResourceBundleThemeSource@5bd9689b]

*** org.springframework.web.context.support.GenericWebApplicationContext
In addition to the special beans detected by AbstractApplicationContext, this class detects a ThemeSource bean in the context, with the name "themeSource".


00:06:18,271 DEBUG DefaultListableBeanFactory:741 - Pre-instantiating singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@cd2c4c: defining beans [org.springframework.context.annotation.internalConfigurationAnnotationProcessor,org.springframework.context.annotation.internalAutowiredAnnotationProcessor,org.springframework.context.annotation.internalRequiredAnnotationProcessor,org.springframework.context.annotation.internalCommonAnnotationProcessor,org.springframework.context.event.internalEventListenerProcessor,org.springframework.context.event.internalEventListenerFactory,org.springframework.context.annotation.ConfigurationClassPostProcessor.importAwareProcessor,org.springframework.context.annotation.ConfigurationClassPostProcessor.enhancedConfigurationProcessor]; root of factory hierarchy
00:06:18,272 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'org.springframework.context.annotation.internalConfigurationAnnotationProcessor'
00:06:18,272 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'org.springframework.context.annotation.internalAutowiredAnnotationProcessor'
00:06:18,272 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'org.springframework.context.annotation.internalRequiredAnnotationProcessor'
00:06:18,272 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'org.springframework.context.annotation.internalCommonAnnotationProcessor'
00:06:18,272 DEBUG DefaultListableBeanFactory:221 - Creating shared instance of singleton bean 'org.springframework.context.event.internalEventListenerProcessor'
00:06:18,272 DEBUG DefaultListableBeanFactory:448 - Creating instance of bean 'org.springframework.context.event.internalEventListenerProcessor'
00:06:18,283 DEBUG DefaultListableBeanFactory:529 - Eagerly caching bean 'org.springframework.context.event.internalEventListenerProcessor' to allow for resolving potential circular references
00:06:18,305 DEBUG DefaultListableBeanFactory:484 - Finished creating instance of bean 'org.springframework.context.event.internalEventListenerProcessor'
00:06:18,306 DEBUG DefaultListableBeanFactory:221 - Creating shared instance of singleton bean 'org.springframework.context.event.internalEventListenerFactory'
00:06:18,306 DEBUG DefaultListableBeanFactory:448 - Creating instance of bean 'org.springframework.context.event.internalEventListenerFactory'
00:06:18,306 DEBUG DefaultListableBeanFactory:529 - Eagerly caching bean 'org.springframework.context.event.internalEventListenerFactory' to allow for resolving potential circular references
00:06:18,315 DEBUG DefaultListableBeanFactory:484 - Finished creating instance of bean 'org.springframework.context.event.internalEventListenerFactory'
00:06:18,315 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'org.springframework.context.annotation.ConfigurationClassPostProcessor.importAwareProcessor'
00:06:18,315 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'org.springframework.context.annotation.ConfigurationClassPostProcessor.enhancedConfigurationProcessor'
00:06:18,316 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'org.springframework.context.event.internalEventListenerFactory'

00:06:18,344 DEBUG AnnotationConfigWebApplicationContext:769 - Unable to locate LifecycleProcessor with name 'lifecycleProcessor': using default [org.springframework.context.support.DefaultLifecycleProcessor@35dde9f9]
00:06:18,344 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'lifecycleProcessor'
00:06:18,347 DEBUG PropertySourcesPropertyResolver:81 - Searching for key 'spring.liveBeansView.mbeanDomain' in [servletConfigInitParams]
00:06:18,347 DEBUG PropertySourcesPropertyResolver:81 - Searching for key 'spring.liveBeansView.mbeanDomain' in [servletContextInitParams]
00:06:18,347 DEBUG PropertySourcesPropertyResolver:81 - Searching for key 'spring.liveBeansView.mbeanDomain' in [jndiProperties]
00:06:18,347 DEBUG JndiTemplate:150 - Looking up JNDI object with name [java:comp/env/spring.liveBeansView.mbeanDomain]
00:06:18,349 DEBUG JndiLocatorDelegate:101 - Converted JNDI name [java:comp/env/spring.liveBeansView.mbeanDomain] not found - trying original name [spring.liveBeansView.mbeanDomain]. javax.naming.NameNotFoundException: Name [spring.liveBeansView.mbeanDomain] is not bound in this Context. Unable to find [spring.liveBeansView.mbeanDomain].
00:06:18,349 DEBUG JndiTemplate:150 - Looking up JNDI object with name [spring.liveBeansView.mbeanDomain]
00:06:18,349 DEBUG JndiPropertySource:90 - JNDI lookup for name [spring.liveBeansView.mbeanDomain] threw NamingException with message: Name [spring.liveBeansView.mbeanDomain] is not bound in this Context. Unable to find [spring.liveBeansView.mbeanDomain].. Returning null.
00:06:18,349 DEBUG PropertySourcesPropertyResolver:81 - Searching for key 'spring.liveBeansView.mbeanDomain' in [systemProperties]
00:06:18,350 DEBUG PropertySourcesPropertyResolver:81 - Searching for key 'spring.liveBeansView.mbeanDomain' in [systemEnvironment]
00:06:18,350 DEBUG PropertySourcesPropertyResolver:103 - Could not find key 'spring.liveBeansView.mbeanDomain' in any property source. Returning [null]
00:06:18,352 DEBUG ContextLoader:342 - Published root WebApplicationContext as ServletContext attribute with name [org.springframework.web.context.WebApplicationContext.ROOT]
00:06:18,353  INFO ContextLoader:347 - Root WebApplicationContext: initialization completed in 352 ms

-->  Like generic application contexts, web application contexts are hierarchical. There is a single root context per application, while each servlet in the application (including a dispatcher servlet in the MVC framework) has its own child context.
     In addition to standard application context lifecycle capabilities, WebApplicationContext implementations need to detect ServletContextAware beans and invoke the setServletContext method accordingly.



>>>>>>>>>STEP-2

00:06:18,364 DEBUG DispatcherServlet:118 - Initializing servlet 'dispatcher'
00:06:18,368 DEBUG StandardServletEnvironment:109 - Adding [servletConfigInitParams] PropertySource with lowest search precedence
00:06:18,369 DEBUG StandardServletEnvironment:109 - Adding [servletContextInitParams] PropertySource with lowest search precedence
00:06:18,369 DEBUG StandardServletEnvironment:109 - Adding [jndiProperties] PropertySource with lowest search precedence
00:06:18,369 DEBUG StandardServletEnvironment:109 - Adding [systemProperties] PropertySource with lowest search precedence
00:06:18,370 DEBUG StandardServletEnvironment:109 - Adding [systemEnvironment] PropertySource with lowest search precedence
00:06:18,370 DEBUG StandardServletEnvironment:127 - Initialized StandardServletEnvironment with PropertySources [servletConfigInitParams,servletContextInitParams,jndiProperties,systemProperties,systemEnvironment]
00:06:18,371  INFO DispatcherServlet:489 - FrameworkServlet 'dispatcher': initialization started
Feb 25, 2016 12:06:18 AM org.apache.catalina.core.ApplicationContext log
INFO: Initializing Spring FrameworkServlet 'dispatcher'
00:06:18,373 DEBUG StandardServletEnvironment:109 - Adding [servletConfigInitParams] PropertySource with lowest search precedence
00:06:18,373 DEBUG StandardServletEnvironment:109 - Adding [servletContextInitParams] PropertySource with lowest search precedence
00:06:18,374 DEBUG StandardServletEnvironment:109 - Adding [jndiProperties] PropertySource with lowest search precedence
00:06:18,374 DEBUG StandardServletEnvironment:109 - Adding [systemProperties] PropertySource with lowest search precedence
00:06:18,374 DEBUG StandardServletEnvironment:109 - Adding [systemEnvironment] PropertySource with lowest search precedence
00:06:18,375 DEBUG StandardServletEnvironment:127 - Initialized StandardServletEnvironment with PropertySources [servletConfigInitParams,servletContextInitParams,jndiProperties,systemProperties,systemEnvironment]

00:06:18,375 DEBUG PropertySourcesPropertyResolver:81 - Searching for key 'spring.profiles.active' in [servletConfigInitParams]
00:06:18,375 DEBUG PropertySourcesPropertyResolver:81 - Searching for key 'spring.profiles.active' in [servletContextInitParams]
00:06:18,376 DEBUG PropertySourcesPropertyResolver:81 - Searching for key 'spring.profiles.active' in [jndiProperties]
00:06:18,376 DEBUG JndiTemplate:150 - Looking up JNDI object with name [java:comp/env/spring.profiles.active]
00:06:18,376 DEBUG JndiLocatorDelegate:101 - Converted JNDI name [java:comp/env/spring.profiles.active] not found - trying original name [spring.profiles.active]. javax.naming.NameNotFoundException: Name [spring.profiles.active] is not bound in this Context. Unable to find [spring.profiles.active].
00:06:18,377 DEBUG JndiTemplate:150 - Looking up JNDI object with name [spring.profiles.active]
00:06:18,377 DEBUG JndiPropertySource:90 - JNDI lookup for name [spring.profiles.active] threw NamingException with message: Name [spring.profiles.active] is not bound in this Context. Unable to find [spring.profiles.active].. Returning null.
00:06:18,377 DEBUG PropertySourcesPropertyResolver:81 - Searching for key 'spring.profiles.active' in [systemProperties]
00:06:18,378 DEBUG PropertySourcesPropertyResolver:81 - Searching for key 'spring.profiles.active' in [systemEnvironment]
00:06:18,378 DEBUG PropertySourcesPropertyResolver:103 - Could not find key 'spring.profiles.active' in any property source. Returning [null]
00:06:18,378 DEBUG PropertySourcesPropertyResolver:81 - Searching for key 'spring.profiles.default' in [servletConfigInitParams]
00:06:18,379 DEBUG PropertySourcesPropertyResolver:81 - Searching for key 'spring.profiles.default' in [servletContextInitParams]
00:06:18,379 DEBUG PropertySourcesPropertyResolver:81 - Searching for key 'spring.profiles.default' in [jndiProperties]
00:06:18,379 DEBUG JndiTemplate:150 - Looking up JNDI object with name [java:comp/env/spring.profiles.default]
00:06:18,380 DEBUG JndiLocatorDelegate:101 - Converted JNDI name [java:comp/env/spring.profiles.default] not found - trying original name [spring.profiles.default]. javax.naming.NameNotFoundException: Name [spring.profiles.default] is not bound in this Context. Unable to find [spring.profiles.default].
00:06:18,380 DEBUG JndiTemplate:150 - Looking up JNDI object with name [spring.profiles.default]
00:06:18,380 DEBUG JndiPropertySource:90 - JNDI lookup for name [spring.profiles.default] threw NamingException with message: Name [spring.profiles.default] is not bound in this Context. Unable to find [spring.profiles.default].. Returning null.
00:06:18,380 DEBUG PropertySourcesPropertyResolver:81 - Searching for key 'spring.profiles.default' in [systemProperties]
00:06:18,381 DEBUG PropertySourcesPropertyResolver:81 - Searching for key 'spring.profiles.default' in [systemEnvironment]
00:06:18,381 DEBUG PropertySourcesPropertyResolver:103 - Could not find key 'spring.profiles.default' in any property source. Returning [null]

00:06:18,386 DEBUG StandardServletEnvironment:174 - Replacing [servletContextInitParams] PropertySource with [servletContextInitParams]
00:06:18,387 DEBUG StandardServletEnvironment:174 - Replacing [servletConfigInitParams] PropertySource with [servletConfigInitParams]
00:06:18,387  INFO AnnotationConfigWebApplicationContext:578 - Refreshing WebApplicationContext for namespace 'dispatcher-servlet': startup date [Thu Feb 25 00:06:18 EST 2016]; parent: Root WebApplicationContext


00:06:18,389 DEBUG ClassPathBeanDefinitionScanner:244 - JSR-250 'javax.annotation.ManagedBean' found and supported for component scanning
00:06:18,389 DEBUG ClassPathBeanDefinitionScanner:252 - JSR-330 'javax.inject.Named' annotation found and supported for component scanning
00:06:18,390  INFO AnnotationConfigWebApplicationContext:207 - Registering annotated classes: [class com.soagile.api.web.configuration.WebappConfiguration]
00:06:18,429 DEBUG AnnotationConfigWebApplicationContext:612 - Bean factory for WebApplicationContext for namespace 'dispatcher-servlet': org.springframework.beans.factory.support.DefaultListableBeanFactory@16609afe: defining beans [org.springframework.context.annotation.internalConfigurationAnnotationProcessor,org.springframework.context.annotation.internalAutowiredAnnotationProcessor,org.springframework.context.annotation.internalRequiredAnnotationProcessor,org.springframework.context.annotation.internalCommonAnnotationProcessor,org.springframework.context.event.internalEventListenerProcessor,org.springframework.context.event.internalEventListenerFactory,webappConfiguration]; parent: org.springframework.beans.factory.support.DefaultListableBeanFactory@cd2c4c

00:06:18,429 DEBUG DefaultListableBeanFactory:874 - Registering scope 'request' with implementation [org.springframework.web.context.request.RequestScope@5f153c1d]
00:06:18,429 DEBUG DefaultListableBeanFactory:874 - Registering scope 'session' with implementation [org.springframework.web.context.request.SessionScope@48fb2f1a]
00:06:18,430 DEBUG DefaultListableBeanFactory:874 - Registering scope 'globalSession' with implementation [org.springframework.web.context.request.SessionScope@5adefb91]
00:06:18,430 DEBUG DefaultListableBeanFactory:874 - Registering scope 'application' with implementation [org.springframework.web.context.support.ServletContextScope@49dba856]
00:06:18,430 DEBUG DefaultListableBeanFactory:221 - Creating shared instance of singleton bean 'org.springframework.context.annotation.internalConfigurationAnnotationProcessor'
00:06:18,430 DEBUG DefaultListableBeanFactory:448 - Creating instance of bean 'org.springframework.context.annotation.internalConfigurationAnnotationProcessor'
00:06:18,431 DEBUG DefaultListableBeanFactory:529 - Eagerly caching bean 'org.springframework.context.annotation.internalConfigurationAnnotationProcessor' to allow for resolving potential circular references
00:06:18,431 DEBUG DefaultListableBeanFactory:484 - Finished creating instance of bean 'org.springframework.context.annotation.internalConfigurationAnnotationProcessor'
00:06:18,451 DEBUG StandardEnvironment:109 - Adding [systemProperties] PropertySource with lowest search precedence
00:06:18,451 DEBUG StandardEnvironment:109 - Adding [systemEnvironment] PropertySource with lowest search precedence
00:06:18,452 DEBUG StandardEnvironment:127 - Initialized StandardEnvironment with PropertySources [systemProperties,systemEnvironment]
00:06:18,453 DEBUG ClassPathBeanDefinitionScanner:244 - JSR-250 'javax.annotation.ManagedBean' found and supported for component scanning
00:06:18,453 DEBUG ClassPathBeanDefinitionScanner:252 - JSR-330 'javax.inject.Named' annotation found and supported for component scanning

>>> ComponentScan

00:06:18,459 DEBUG PathMatchingResourcePatternResolver:631 - Looking for matching resources in directory tree [D:\workspace\api-template\api-web\target\classes\com\soagile\api\web]
00:06:18,459 DEBUG PathMatchingResourcePatternResolver:693 - Searching directory [D:\workspace\api-template\api-web\target\classes\com\soagile\api\web] for files matching pattern [D:/workspace/api-template/api-web/target/classes/com/soagile/api/web/*/**/*.class]
00:06:18,461 DEBUG PathMatchingResourcePatternResolver:693 - Searching directory [D:\workspace\api-template\api-web\target\classes\com\soagile\api\web\configuration] for files matching pattern [D:/workspace/api-template/api-web/target/classes/com/soagile/api/web/*/**/*.class]
00:06:18,462 DEBUG PathMatchingResourcePatternResolver:693 - Searching directory [D:\workspace\api-template\api-web\target\classes\com\soagile\api\web\controllers] for files matching pattern [D:/workspace/api-template/api-web/target/classes/com/soagile/api/web/*/**/*.class]
00:06:18,464 DEBUG PathMatchingResourcePatternResolver:424 - Resolved location pattern [classpath*:com/soagile/api/web/*/**/*.class] to resources [file [D:\workspace\api-template\api-web\target\classes\com\soagile\api\web\configuration\WebappConfiguration.class], file [D:\workspace\api-template\api-web\target\classes\com\soagile\api\web\configuration\WebappInitialiser.class], file [D:\workspace\api-template\api-web\target\classes\com\soagile\api\web\controllers\GreetingsController.class]]
00:06:18,506 DEBUG ClassPathBeanDefinitionScanner:286 - Identified candidate component class: file [D:\workspace\api-template\api-web\target\classes\com\soagile\api\web\controllers\GreetingsController.class]
00:06:18,509 DEBUG PathMatchingResourcePatternResolver:545 - Looking for matching resources in jar file [file:/C:/Users/BMGTS/.m2/repository/com/soagile/api/common/1.0-SNAPSHOT/common-1.0-SNAPSHOT.jar]
00:06:18,510 DEBUG PathMatchingResourcePatternResolver:424 - Resolved location pattern [classpath*:com/soagile/api/common/model/**/*.class] to resources [URL [jar:file:/C:/Users/BMGTS/.m2/repository/com/soagile/api/common/1.0-SNAPSHOT/common-1.0-SNAPSHOT.jar!/com/soagile/api/common/model/Greeting.class]]

why?  -- Proxying WebappConiguration
00:06:18,561 DEBUG ConfigurationClassBeanDefinitionReader:164 - Registered bean definition for imported class 'org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration'
00:06:18,564 DEBUG ConfigurationClassBeanDefinitionReader:256 - Registering bean definition for @Bean method org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration.requestMappingHandlerMapping()
00:06:18,565 DEBUG ConfigurationClassBeanDefinitionReader:256 - Registering bean definition for @Bean method org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration.mvcContentNegotiationManager()
00:06:18,565 DEBUG ConfigurationClassBeanDefinitionReader:256 - Registering bean definition for @Bean method org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration.viewControllerHandlerMapping()
00:06:18,566 DEBUG ConfigurationClassBeanDefinitionReader:256 - Registering bean definition for @Bean method org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration.beanNameHandlerMapping()
00:06:18,567 DEBUG ConfigurationClassBeanDefinitionReader:256 - Registering bean definition for @Bean method org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration.resourceHandlerMapping()
00:06:18,568 DEBUG ConfigurationClassBeanDefinitionReader:256 - Registering bean definition for @Bean method org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration.mvcResourceUrlProvider()
00:06:18,568 DEBUG ConfigurationClassBeanDefinitionReader:256 - Registering bean definition for @Bean method org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration.defaultServletHandlerMapping()
00:06:18,569 DEBUG ConfigurationClassBeanDefinitionReader:256 - Registering bean definition for @Bean method org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration.requestMappingHandlerAdapter()
00:06:18,570 DEBUG ConfigurationClassBeanDefinitionReader:256 - Registering bean definition for @Bean method org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration.mvcConversionService()
00:06:18,571 DEBUG ConfigurationClassBeanDefinitionReader:256 - Registering bean definition for @Bean method org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration.mvcUriComponentsContributor()
00:06:18,572 DEBUG ConfigurationClassBeanDefinitionReader:256 - Registering bean definition for @Bean method org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration.httpRequestHandlerAdapter()
00:06:18,573 DEBUG ConfigurationClassBeanDefinitionReader:256 - Registering bean definition for @Bean method org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration.simpleControllerHandlerAdapter()
00:06:18,574 DEBUG ConfigurationClassBeanDefinitionReader:256 - Registering bean definition for @Bean method org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration.handlerExceptionResolver()
00:06:18,575 DEBUG ConfigurationClassBeanDefinitionReader:256 - Registering bean definition for @Bean method org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration.mvcPathMatcher()
00:06:18,576 DEBUG ConfigurationClassBeanDefinitionReader:256 - Registering bean definition for @Bean method org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration.mvcViewResolver()
00:06:18,578 DEBUG ConfigurationClassBeanDefinitionReader:256 - Registering bean definition for @Bean method org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration.mvcUrlPathHelper()
00:06:18,578 DEBUG ConfigurationClassBeanDefinitionReader:256 - Registering bean definition for @Bean method org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration.mvcValidator()
00:06:18,708 DEBUG ConfigurationClassEnhancer:109 - Successfully enhanced com.soagile.api.web.configuration.WebappConfiguration; enhanced class name is: com.soagile.api.web.configuration.WebappConfiguration$$EnhancerBySpringCGLIB$$49052ef7

Replacing with PROXY
00:06:18,708 DEBUG ConfigurationClassPostProcessor:403 - Replacing bean definition 'webappConfiguration' existing class 'com.soagile.api.web.configuration.WebappConfiguration' with enhanced class 'com.soagile.api.web.configuration.WebappConfiguration$$EnhancerBySpringCGLIB$$49052ef7'
00:06:18,738 DEBUG ConfigurationClassEnhancer:109 - Successfully enhanced org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration; enhanced class name is: org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration$$EnhancerBySpringCGLIB$$68ccd7c0
00:06:18,739 DEBUG ConfigurationClassPostProcessor:403 - Replacing bean definition 'org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration' existing class 'org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration' with enhanced class 'org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration$$EnhancerBySpringCGLIB$$68ccd7c0'


00:06:18,745 DEBUG DefaultListableBeanFactory:221 - Creating shared instance of singleton bean 'org.springframework.context.annotation.internalAutowiredAnnotationProcessor'
00:06:18,745 DEBUG DefaultListableBeanFactory:448 - Creating instance of bean 'org.springframework.context.annotation.internalAutowiredAnnotationProcessor'
00:06:18,746  INFO AutowiredAnnotationBeanPostProcessor:153 - JSR-330 'javax.inject.Inject' annotation found and supported for autowiring

What are these processors??
00:06:18,746 DEBUG DefaultListableBeanFactory:529 - Eagerly caching bean 'org.springframework.context.annotation.internalAutowiredAnnotationProcessor' to allow for resolving potential circular references
00:06:18,747 DEBUG DefaultListableBeanFactory:484 - Finished creating instance of bean 'org.springframework.context.annotation.internalAutowiredAnnotationProcessor'
00:06:18,747 DEBUG DefaultListableBeanFactory:221 - Creating shared instance of singleton bean 'org.springframework.context.annotation.internalRequiredAnnotationProcessor'
00:06:18,747 DEBUG DefaultListableBeanFactory:448 - Creating instance of bean 'org.springframework.context.annotation.internalRequiredAnnotationProcessor'
00:06:18,748 DEBUG DefaultListableBeanFactory:529 - Eagerly caching bean 'org.springframework.context.annotation.internalRequiredAnnotationProcessor' to allow for resolving potential circular references
00:06:18,748 DEBUG DefaultListableBeanFactory:484 - Finished creating instance of bean 'org.springframework.context.annotation.internalRequiredAnnotationProcessor'
00:06:18,748 DEBUG DefaultListableBeanFactory:221 - Creating shared instance of singleton bean 'org.springframework.context.annotation.internalCommonAnnotationProcessor'
00:06:18,748 DEBUG DefaultListableBeanFactory:448 - Creating instance of bean 'org.springframework.context.annotation.internalCommonAnnotationProcessor'
00:06:18,749 DEBUG DefaultListableBeanFactory:529 - Eagerly caching bean 'org.springframework.context.annotation.internalCommonAnnotationProcessor' to allow for resolving potential circular references
00:06:18,749 DEBUG DefaultListableBeanFactory:484 - Finished creating instance of bean 'org.springframework.context.annotation.internalCommonAnnotationProcessor'
00:06:18,749 DEBUG DefaultListableBeanFactory:221 - Creating shared instance of singleton bean 'org.springframework.context.annotation.ConfigurationClassPostProcessor.importAwareProcessor'
00:06:18,749 DEBUG DefaultListableBeanFactory:448 - Creating instance of bean 'org.springframework.context.annotation.ConfigurationClassPostProcessor.importAwareProcessor'
00:06:18,750 DEBUG DefaultListableBeanFactory:529 - Eagerly caching bean 'org.springframework.context.annotation.ConfigurationClassPostProcessor.importAwareProcessor' to allow for resolving potential circular references
00:06:18,750 DEBUG DefaultListableBeanFactory:484 - Finished creating instance of bean 'org.springframework.context.annotation.ConfigurationClassPostProcessor.importAwareProcessor'
00:06:18,750 DEBUG DefaultListableBeanFactory:221 - Creating shared instance of singleton bean 'org.springframework.context.annotation.ConfigurationClassPostProcessor.enhancedConfigurationProcessor'
00:06:18,750 DEBUG DefaultListableBeanFactory:448 - Creating instance of bean 'org.springframework.context.annotation.ConfigurationClassPostProcessor.enhancedConfigurationProcessor'
00:06:18,751 DEBUG DefaultListableBeanFactory:529 - Eagerly caching bean 'org.springframework.context.annotation.ConfigurationClassPostProcessor.enhancedConfigurationProcessor' to allow for resolving potential circular references
00:06:18,751 DEBUG DefaultListableBeanFactory:484 - Finished creating instance of bean 'org.springframework.context.annotation.ConfigurationClassPostProcessor.enhancedConfigurationProcessor'

What is this???
00:06:18,751 DEBUG AnnotationConfigWebApplicationContext:718 - Unable to locate MessageSource with name 'messageSource': using default [org.springframework.context.support.DelegatingMessageSource@7a332527]
00:06:18,752 DEBUG AnnotationConfigWebApplicationContext:742 - Unable to locate ApplicationEventMulticaster with name 'applicationEventMulticaster': using default [org.springframework.context.event.SimpleApplicationEventMulticaster@2f84236e]

??? Theme resource
00:06:18,753 DEBUG UiApplicationContextUtils:85 - Unable to locate ThemeSource with name 'themeSource': using default [org.springframework.ui.context.support.DelegatingThemeSource@5063a2b5]
00:06:18,755 DEBUG DefaultListableBeanFactory:741 - Pre-instantiating singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@16609afe: defining beans [org.springframework.context.annotation.internalConfigurationAnnotationProcessor,org.springframework.context.annotation.internalAutowiredAnnotationProcessor,org.springframework.context.annotation.internalRequiredAnnotationProcessor,org.springframework.context.annotation.internalCommonAnnotationProcessor,org.springframework.context.event.internalEventListenerProcessor,org.springframework.context.event.internalEventListenerFactory,webappConfiguration,org.springframework.context.annotation.ConfigurationClassPostProcessor.importAwareProcessor,org.springframework.context.annotation.ConfigurationClassPostProcessor.enhancedConfigurationProcessor,greetingsController,org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration,requestMappingHandlerMapping,mvcContentNegotiationManager,viewControllerHandlerMapping,beanNameHandlerMapping,resourceHandlerMapping,mvcResourceUrlProvider,defaultServletHandlerMapping,requestMappingHandlerAdapter,mvcConversionService,mvcUriComponentsContributor,httpRequestHandlerAdapter,simpleControllerHandlerAdapter,handlerExceptionResolver,mvcPathMatcher,mvcViewResolver,mvcUrlPathHelper,mvcValidator]; parent: org.springframework.beans.factory.support.DefaultListableBeanFactory@cd2c4c
00:06:18,755 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'org.springframework.context.annotation.internalConfigurationAnnotationProcessor'
00:06:18,756 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'org.springframework.context.annotation.internalAutowiredAnnotationProcessor'
00:06:18,756 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'org.springframework.context.annotation.internalRequiredAnnotationProcessor'
00:06:18,756 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'org.springframework.context.annotation.internalCommonAnnotationProcessor'
00:06:18,757 DEBUG DefaultListableBeanFactory:221 - Creating shared instance of singleton bean 'org.springframework.context.event.internalEventListenerProcessor'
00:06:18,757 DEBUG DefaultListableBeanFactory:448 - Creating instance of bean 'org.springframework.context.event.internalEventListenerProcessor'
00:06:18,757 DEBUG DefaultListableBeanFactory:529 - Eagerly caching bean 'org.springframework.context.event.internalEventListenerProcessor' to allow for resolving potential circular references
00:06:18,758 DEBUG DefaultListableBeanFactory:484 - Finished creating instance of bean 'org.springframework.context.event.internalEventListenerProcessor'
00:06:18,758 DEBUG DefaultListableBeanFactory:221 - Creating shared instance of singleton bean 'org.springframework.context.event.internalEventListenerFactory'
00:06:18,758 DEBUG DefaultListableBeanFactory:448 - Creating instance of bean 'org.springframework.context.event.internalEventListenerFactory'
00:06:18,759 DEBUG DefaultListableBeanFactory:529 - Eagerly caching bean 'org.springframework.context.event.internalEventListenerFactory' to allow for resolving potential circular references
00:06:18,759 DEBUG DefaultListableBeanFactory:484 - Finished creating instance of bean 'org.springframework.context.event.internalEventListenerFactory'
00:06:18,759 DEBUG DefaultListableBeanFactory:221 - Creating shared instance of singleton bean 'webappConfiguration'
00:06:18,759 DEBUG DefaultListableBeanFactory:448 - Creating instance of bean 'webappConfiguration'
00:06:18,761 DEBUG DefaultListableBeanFactory:529 - Eagerly caching bean 'webappConfiguration' to allow for resolving potential circular references
00:06:18,775 DEBUG DefaultListableBeanFactory:484 - Finished creating instance of bean 'webappConfiguration'

00:06:18,776 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'org.springframework.context.annotation.ConfigurationClassPostProcessor.importAwareProcessor'
00:06:18,776 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'org.springframework.context.annotation.ConfigurationClassPostProcessor.enhancedConfigurationProcessor'

00:06:18,776 DEBUG DefaultListableBeanFactory:221 - Creating shared instance of singleton bean 'greetingsController'
00:06:18,776 DEBUG DefaultListableBeanFactory:448 - Creating instance of bean 'greetingsController'
00:06:18,781 DEBUG DefaultListableBeanFactory:529 - Eagerly caching bean 'greetingsController' to allow for resolving potential circular references

00:06:18,786 DEBUG DefaultListableBeanFactory:484 - Finished creating instance of bean 'greetingsController'
00:06:18,786 DEBUG DefaultListableBeanFactory:221 - Creating shared instance of singleton bean 'org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration'
00:06:18,786 DEBUG DefaultListableBeanFactory:448 - Creating instance of bean 'org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration'
00:06:18,810 DEBUG InjectionMetadata:72 - Registered injected element on class [org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration$$EnhancerBySpringCGLIB$$68ccd7c0]: AutowiredMethodElement for public void org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration.setConfigurers(java.util.List)
00:06:18,810 DEBUG DefaultListableBeanFactory:529 - Eagerly caching bean 'org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration' to allow for resolving potential circular references

00:06:18,811 DEBUG InjectionMetadata:86 - Processing injected element of bean 'org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration': AutowiredMethodElement for public void org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration.setConfigurers(java.util.List)
00:06:18,822 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'webappConfiguration'


00:06:18,838 DEBUG AutowiredAnnotationBeanPostProcessor:492 - Autowiring by type from bean name 'org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration' to bean named 'webappConfiguration'
00:06:18,838 DEBUG DefaultListableBeanFactory:484 - Finished creating instance of bean 'org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration'

STEP ?? - Request Handle Mapping

00:06:18,838 DEBUG DefaultListableBeanFactory:221 - Creating shared instance of singleton bean 'requestMappingHandlerMapping'
00:06:18,839 DEBUG DefaultListableBeanFactory:448 - Creating instance of bean 'requestMappingHandlerMapping'
00:06:18,842 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration'
00:06:18,921 DEBUG DefaultListableBeanFactory:221 - Creating shared instance of singleton bean 'mvcConversionService'
00:06:18,922 DEBUG DefaultListableBeanFactory:448 - Creating instance of bean 'mvcConversionService'
00:06:18,923 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration'
00:06:18,995 DEBUG DefaultListableBeanFactory:529 - Eagerly caching bean 'mvcConversionService' to allow for resolving potential circular references
00:06:19,007 DEBUG DefaultListableBeanFactory:484 - Finished creating instance of bean 'mvcConversionService'
00:06:19,009 DEBUG DefaultListableBeanFactory:221 - Creating shared instance of singleton bean 'mvcResourceUrlProvider'
00:06:19,009 DEBUG DefaultListableBeanFactory:448 - Creating instance of bean 'mvcResourceUrlProvider'
00:06:19,009 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration'
00:06:19,012 DEBUG DefaultListableBeanFactory:529 - Eagerly caching bean 'mvcResourceUrlProvider' to allow for resolving potential circular references
00:06:19,021 DEBUG DefaultListableBeanFactory:484 - Finished creating instance of bean 'mvcResourceUrlProvider'
00:06:19,022 DEBUG DefaultListableBeanFactory:221 - Creating shared instance of singleton bean 'mvcContentNegotiationManager'
00:06:19,022 DEBUG DefaultListableBeanFactory:448 - Creating instance of bean 'mvcContentNegotiationManager'
00:06:19,023 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration'
00:06:19,030 DEBUG DefaultListableBeanFactory:529 - Eagerly caching bean 'mvcContentNegotiationManager' to allow for resolving potential circular references
00:06:19,037 DEBUG DefaultListableBeanFactory:484 - Finished creating instance of bean 'mvcContentNegotiationManager'
00:06:19,047 DEBUG DefaultListableBeanFactory:529 - Eagerly caching bean 'requestMappingHandlerMapping' to allow for resolving potential circular references

00:06:19,077 DEBUG DefaultListableBeanFactory:1620 - Invoking afterPropertiesSet() on bean with name 'requestMappingHandlerMapping'


00:06:19,078 DEBUG RequestMappingHandlerMapping:172 - Looking for request mappings in application context: WebApplicationContext for namespace 'dispatcher-servlet': startup date [Thu Feb 25 00:06:18 EST 2016]; parent: Root WebApplicationContext
00:06:19,097 DEBUG RequestMappingHandlerMapping:223 - 1 request handler methods found on class com.soagile.api.web.controllers.GreetingsController: {public com.soagile.api.common.model.Greeting com.soagile.api.web.controllers.GreetingsController.greeting(java.lang.String)={[/greeting]}}
00:06:19,098  INFO RequestMappingHandlerMapping:527 - Mapped "{[/greeting]}" onto public com.soagile.api.common.model.Greeting com.soagile.api.web.controllers.GreetingsController.greeting(java.lang.String)
00:06:19,100 DEBUG DefaultListableBeanFactory:484 - Finished creating instance of bean 'requestMappingHandlerMapping'
00:06:19,100 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'mvcContentNegotiationManager'
00:06:19,100 DEBUG DefaultListableBeanFactory:221 - Creating shared instance of singleton bean 'viewControllerHandlerMapping'
00:06:19,101 DEBUG DefaultListableBeanFactory:448 - Creating instance of bean 'viewControllerHandlerMapping'
00:06:19,101 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration'
00:06:19,103 DEBUG DefaultListableBeanFactory:221 - Creating shared instance of singleton bean 'mvcPathMatcher'
00:06:19,103 DEBUG DefaultListableBeanFactory:448 - Creating instance of bean 'mvcPathMatcher'
00:06:19,103 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration'
00:06:19,104 DEBUG DefaultListableBeanFactory:529 - Eagerly caching bean 'mvcPathMatcher' to allow for resolving potential circular references
00:06:19,108 DEBUG DefaultListableBeanFactory:484 - Finished creating instance of bean 'mvcPathMatcher'
00:06:19,109 DEBUG DefaultListableBeanFactory:221 - Creating shared instance of singleton bean 'mvcUrlPathHelper'
00:06:19,109 DEBUG DefaultListableBeanFactory:448 - Creating instance of bean 'mvcUrlPathHelper'
00:06:19,110 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration'
00:06:19,111 DEBUG DefaultListableBeanFactory:529 - Eagerly caching bean 'mvcUrlPathHelper' to allow for resolving potential circular references
00:06:19,115 DEBUG DefaultListableBeanFactory:484 - Finished creating instance of bean 'mvcUrlPathHelper'
00:06:19,116 DEBUG DefaultListableBeanFactory:529 - Eagerly caching bean 'viewControllerHandlerMapping' to allow for resolving potential circular references
00:06:19,121 DEBUG DefaultListableBeanFactory:484 - Finished creating instance of bean 'viewControllerHandlerMapping'
00:06:19,121 DEBUG DefaultListableBeanFactory:221 - Creating shared instance of singleton bean 'beanNameHandlerMapping'
00:06:19,121 DEBUG DefaultListableBeanFactory:448 - Creating instance of bean 'beanNameHandlerMapping'
00:06:19,121 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration'
00:06:19,124 DEBUG DefaultListableBeanFactory:529 - Eagerly caching bean 'beanNameHandlerMapping' to allow for resolving potential circular references
00:06:19,140 DEBUG BeanNameUrlHandlerMapping:71 - Looking for URL mappings in application context: WebApplicationContext for namespace 'dispatcher-servlet': startup date [Thu Feb 25 00:06:18 EST 2016]; parent: Root WebApplicationContext
00:06:19,140 DEBUG BeanNameUrlHandlerMapping:86 - Rejected bean name 'org.springframework.context.annotation.internalConfigurationAnnotationProcessor': no URL paths identified
00:06:19,141 DEBUG BeanNameUrlHandlerMapping:86 - Rejected bean name 'org.springframework.context.annotation.internalAutowiredAnnotationProcessor': no URL paths identified
00:06:19,141 DEBUG BeanNameUrlHandlerMapping:86 - Rejected bean name 'org.springframework.context.annotation.internalRequiredAnnotationProcessor': no URL paths identified
00:06:19,141 DEBUG BeanNameUrlHandlerMapping:86 - Rejected bean name 'org.springframework.context.annotation.internalCommonAnnotationProcessor': no URL paths identified
00:06:19,141 DEBUG BeanNameUrlHandlerMapping:86 - Rejected bean name 'org.springframework.context.event.internalEventListenerProcessor': no URL paths identified
00:06:19,142 DEBUG BeanNameUrlHandlerMapping:86 - Rejected bean name 'org.springframework.context.event.internalEventListenerFactory': no URL paths identified
00:06:19,142 DEBUG BeanNameUrlHandlerMapping:86 - Rejected bean name 'webappConfiguration': no URL paths identified
00:06:19,142 DEBUG BeanNameUrlHandlerMapping:86 - Rejected bean name 'org.springframework.context.annotation.ConfigurationClassPostProcessor.importAwareProcessor': no URL paths identified
00:06:19,142 DEBUG BeanNameUrlHandlerMapping:86 - Rejected bean name 'org.springframework.context.annotation.ConfigurationClassPostProcessor.enhancedConfigurationProcessor': no URL paths identified
00:06:19,143 DEBUG BeanNameUrlHandlerMapping:86 - Rejected bean name 'greetingsController': no URL paths identified
00:06:19,143 DEBUG BeanNameUrlHandlerMapping:86 - Rejected bean name 'org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration': no URL paths identified
00:06:19,143 DEBUG BeanNameUrlHandlerMapping:86 - Rejected bean name 'requestMappingHandlerMapping': no URL paths identified
00:06:19,143 DEBUG BeanNameUrlHandlerMapping:86 - Rejected bean name 'mvcContentNegotiationManager': no URL paths identified
00:06:19,144 DEBUG BeanNameUrlHandlerMapping:86 - Rejected bean name 'viewControllerHandlerMapping': no URL paths identified
00:06:19,144 DEBUG BeanNameUrlHandlerMapping:86 - Rejected bean name 'beanNameHandlerMapping': no URL paths identified
00:06:19,144 DEBUG BeanNameUrlHandlerMapping:86 - Rejected bean name 'resourceHandlerMapping': no URL paths identified
00:06:19,144 DEBUG BeanNameUrlHandlerMapping:86 - Rejected bean name 'mvcResourceUrlProvider': no URL paths identified
00:06:19,145 DEBUG BeanNameUrlHandlerMapping:86 - Rejected bean name 'defaultServletHandlerMapping': no URL paths identified
00:06:19,145 DEBUG BeanNameUrlHandlerMapping:86 - Rejected bean name 'requestMappingHandlerAdapter': no URL paths identified
00:06:19,145 DEBUG BeanNameUrlHandlerMapping:86 - Rejected bean name 'mvcConversionService': no URL paths identified
00:06:19,145 DEBUG BeanNameUrlHandlerMapping:86 - Rejected bean name 'mvcUriComponentsContributor': no URL paths identified
00:06:19,145 DEBUG BeanNameUrlHandlerMapping:86 - Rejected bean name 'httpRequestHandlerAdapter': no URL paths identified
00:06:19,146 DEBUG BeanNameUrlHandlerMapping:86 - Rejected bean name 'simpleControllerHandlerAdapter': no URL paths identified
00:06:19,146 DEBUG BeanNameUrlHandlerMapping:86 - Rejected bean name 'handlerExceptionResolver': no URL paths identified
00:06:19,146 DEBUG BeanNameUrlHandlerMapping:86 - Rejected bean name 'mvcPathMatcher': no URL paths identified
00:06:19,146 DEBUG BeanNameUrlHandlerMapping:86 - Rejected bean name 'mvcViewResolver': no URL paths identified
00:06:19,147 DEBUG BeanNameUrlHandlerMapping:86 - Rejected bean name 'mvcUrlPathHelper': no URL paths identified
00:06:19,147 DEBUG BeanNameUrlHandlerMapping:86 - Rejected bean name 'mvcValidator': no URL paths identified
00:06:19,147 DEBUG BeanNameUrlHandlerMapping:86 - Rejected bean name 'environment': no URL paths identified
00:06:19,147 DEBUG BeanNameUrlHandlerMapping:86 - Rejected bean name 'systemProperties': no URL paths identified
00:06:19,148 DEBUG BeanNameUrlHandlerMapping:86 - Rejected bean name 'systemEnvironment': no URL paths identified
00:06:19,148 DEBUG BeanNameUrlHandlerMapping:86 - Rejected bean name 'servletConfig': no URL paths identified
00:06:19,148 DEBUG BeanNameUrlHandlerMapping:86 - Rejected bean name 'org.springframework.context.annotation.ConfigurationClassPostProcessor.importRegistry': no URL paths identified
00:06:19,148 DEBUG BeanNameUrlHandlerMapping:86 - Rejected bean name 'messageSource': no URL paths identified
00:06:19,148 DEBUG BeanNameUrlHandlerMapping:86 - Rejected bean name 'applicationEventMulticaster': no URL paths identified
00:06:19,149 DEBUG DefaultListableBeanFactory:484 - Finished creating instance of bean 'beanNameHandlerMapping'
00:06:19,149 DEBUG DefaultListableBeanFactory:221 - Creating shared instance of singleton bean 'resourceHandlerMapping'
00:06:19,149 DEBUG DefaultListableBeanFactory:448 - Creating instance of bean 'resourceHandlerMapping'
00:06:19,149 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration'
00:06:19,151 DEBUG DefaultListableBeanFactory:529 - Eagerly caching bean 'resourceHandlerMapping' to allow for resolving potential circular references
00:06:19,151 DEBUG DefaultListableBeanFactory:484 - Finished creating instance of bean 'resourceHandlerMapping'
00:06:19,151 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'mvcResourceUrlProvider'
00:06:19,152 DEBUG DefaultListableBeanFactory:221 - Creating shared instance of singleton bean 'defaultServletHandlerMapping'
00:06:19,152 DEBUG DefaultListableBeanFactory:448 - Creating instance of bean 'defaultServletHandlerMapping'
00:06:19,152 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration'
00:06:19,157 DEBUG DefaultListableBeanFactory:529 - Eagerly caching bean 'defaultServletHandlerMapping' to allow for resolving potential circular references
00:06:19,164  INFO SimpleUrlHandlerMapping:341 - Mapped URL path [/**] onto handler of type [class org.springframework.web.servlet.resource.DefaultServletHttpRequestHandler]
00:06:19,165 DEBUG DefaultListableBeanFactory:484 - Finished creating instance of bean 'defaultServletHandlerMapping'
00:06:19,165 DEBUG DefaultListableBeanFactory:221 - Creating shared instance of singleton bean 'requestMappingHandlerAdapter'
00:06:19,166 DEBUG DefaultListableBeanFactory:448 - Creating instance of bean 'requestMappingHandlerAdapter'
00:06:19,166 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration'
00:06:19,560 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'mvcContentNegotiationManager'
00:06:19,585 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'mvcConversionService'
00:06:19,586 DEBUG DefaultListableBeanFactory:221 - Creating shared instance of singleton bean 'mvcValidator'
00:06:19,586 DEBUG DefaultListableBeanFactory:448 - Creating instance of bean 'mvcValidator'
00:06:19,587 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration'
00:06:19,590 DEBUG DefaultListableBeanFactory:529 - Eagerly caching bean 'mvcValidator' to allow for resolving potential circular references
00:06:19,594 DEBUG DefaultListableBeanFactory:484 - Finished creating instance of bean 'mvcValidator'
00:06:19,604 DEBUG DefaultListableBeanFactory:529 - Eagerly caching bean 'requestMappingHandlerAdapter' to allow for resolving potential circular references
00:06:19,621 DEBUG DefaultListableBeanFactory:1620 - Invoking afterPropertiesSet() on bean with name 'requestMappingHandlerAdapter'
00:06:19,621  INFO RequestMappingHandlerAdapter:532 - Looking for @ControllerAdvice: WebApplicationContext for namespace 'dispatcher-servlet': startup date [Thu Feb 25 00:06:18 EST 2016]; parent: Root WebApplicationContext
00:06:19,667 DEBUG DefaultListableBeanFactory:484 - Finished creating instance of bean 'requestMappingHandlerAdapter'
00:06:19,667 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'mvcConversionService'
00:06:19,667 DEBUG DefaultListableBeanFactory:221 - Creating shared instance of singleton bean 'mvcUriComponentsContributor'
00:06:19,667 DEBUG DefaultListableBeanFactory:448 - Creating instance of bean 'mvcUriComponentsContributor'
00:06:19,668 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration'
00:06:19,668 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'requestMappingHandlerAdapter'
00:06:19,669 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'mvcConversionService'
00:06:19,670 DEBUG DefaultListableBeanFactory:529 - Eagerly caching bean 'mvcUriComponentsContributor' to allow for resolving potential circular references
00:06:19,675 DEBUG DefaultListableBeanFactory:484 - Finished creating instance of bean 'mvcUriComponentsContributor'
00:06:19,676 DEBUG DefaultListableBeanFactory:221 - Creating shared instance of singleton bean 'httpRequestHandlerAdapter'
00:06:19,676 DEBUG DefaultListableBeanFactory:448 - Creating instance of bean 'httpRequestHandlerAdapter'
00:06:19,676 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration'
00:06:19,677 DEBUG DefaultListableBeanFactory:529 - Eagerly caching bean 'httpRequestHandlerAdapter' to allow for resolving potential circular references
00:06:19,682 DEBUG DefaultListableBeanFactory:484 - Finished creating instance of bean 'httpRequestHandlerAdapter'
00:06:19,682 DEBUG DefaultListableBeanFactory:221 - Creating shared instance of singleton bean 'simpleControllerHandlerAdapter'
00:06:19,683 DEBUG DefaultListableBeanFactory:448 - Creating instance of bean 'simpleControllerHandlerAdapter'
00:06:19,683 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration'
00:06:19,684 DEBUG DefaultListableBeanFactory:529 - Eagerly caching bean 'simpleControllerHandlerAdapter' to allow for resolving potential circular references
00:06:19,689 DEBUG DefaultListableBeanFactory:484 - Finished creating instance of bean 'simpleControllerHandlerAdapter'
00:06:19,689 DEBUG DefaultListableBeanFactory:221 - Creating shared instance of singleton bean 'handlerExceptionResolver'
00:06:19,689 DEBUG DefaultListableBeanFactory:448 - Creating instance of bean 'handlerExceptionResolver'
00:06:19,690 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration'
00:06:19,706 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'mvcContentNegotiationManager'
00:06:19,707 DEBUG ExceptionHandlerExceptionResolver:257 - Looking for exception mappings: WebApplicationContext for namespace 'dispatcher-servlet': startup date [Thu Feb 25 00:06:18 EST 2016]; parent: Root WebApplicationContext
00:06:19,712 DEBUG DefaultListableBeanFactory:529 - Eagerly caching bean 'handlerExceptionResolver' to allow for resolving potential circular references
00:06:19,716 DEBUG DefaultListableBeanFactory:484 - Finished creating instance of bean 'handlerExceptionResolver'
00:06:19,717 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'mvcPathMatcher'
00:06:19,717 DEBUG DefaultListableBeanFactory:221 - Creating shared instance of singleton bean 'mvcViewResolver'
00:06:19,717 DEBUG DefaultListableBeanFactory:448 - Creating instance of bean 'mvcViewResolver'
00:06:19,717 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration'
00:06:19,723 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'mvcContentNegotiationManager'
00:06:19,731 DEBUG DefaultListableBeanFactory:529 - Eagerly caching bean 'mvcViewResolver' to allow for resolving potential circular references
00:06:19,735 DEBUG DefaultListableBeanFactory:1620 - Invoking afterPropertiesSet() on bean with name 'mvcViewResolver'
00:06:19,735 DEBUG DefaultListableBeanFactory:484 - Finished creating instance of bean 'mvcViewResolver'
00:06:19,735 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'mvcUrlPathHelper'
00:06:19,735 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'mvcValidator'
00:06:19,736 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'org.springframework.context.event.internalEventListenerFactory'
00:06:19,770 DEBUG AnnotationConfigWebApplicationContext:769 - Unable to locate LifecycleProcessor with name 'lifecycleProcessor': using default [org.springframework.context.support.DefaultLifecycleProcessor@45ad6151]
00:06:19,771 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'lifecycleProcessor'
00:06:19,771 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'mvcResourceUrlProvider'
00:06:19,775 DEBUG DispatcherServlet:506 - Unable to locate MultipartResolver with name 'multipartResolver': no multipart request handling provided
00:06:19,776 DEBUG DefaultListableBeanFactory:448 - Creating instance of bean 'org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver'
00:06:19,780 DEBUG DefaultListableBeanFactory:484 - Finished creating instance of bean 'org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver'
00:06:19,780 DEBUG DispatcherServlet:528 - Unable to locate LocaleResolver with name 'localeResolver': using default [org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver@25d55bff]
00:06:19,782 DEBUG DefaultListableBeanFactory:448 - Creating instance of bean 'org.springframework.web.servlet.theme.FixedThemeResolver'
00:06:19,787 DEBUG DefaultListableBeanFactory:484 - Finished creating instance of bean 'org.springframework.web.servlet.theme.FixedThemeResolver'
00:06:19,788 DEBUG DispatcherServlet:550 - Unable to locate ThemeResolver with name 'themeResolver': using default [org.springframework.web.servlet.theme.FixedThemeResolver@2194d7ae]
00:06:19,788 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'requestMappingHandlerMapping'
00:06:19,788 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'viewControllerHandlerMapping'
00:06:19,788 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'beanNameHandlerMapping'
00:06:19,788 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'resourceHandlerMapping'
00:06:19,789 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'defaultServletHandlerMapping'
00:06:19,789 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'requestMappingHandlerAdapter'
00:06:19,790 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'httpRequestHandlerAdapter'
00:06:19,790 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'simpleControllerHandlerAdapter'
00:06:19,790 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'handlerExceptionResolver'
00:06:19,792 DEBUG DefaultListableBeanFactory:448 - Creating instance of bean 'org.springframework.web.servlet.view.DefaultRequestToViewNameTranslator'
00:06:19,796 DEBUG DefaultListableBeanFactory:484 - Finished creating instance of bean 'org.springframework.web.servlet.view.DefaultRequestToViewNameTranslator'
00:06:19,796 DEBUG DispatcherServlet:688 - Unable to locate RequestToViewNameTranslator with name 'viewNameTranslator': using default [org.springframework.web.servlet.view.DefaultRequestToViewNameTranslator@77123d8d]
00:06:19,796 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'mvcViewResolver'
00:06:19,799 DEBUG DefaultListableBeanFactory:448 - Creating instance of bean 'org.springframework.web.servlet.support.SessionFlashMapManager'
00:06:19,810 DEBUG DefaultListableBeanFactory:484 - Finished creating instance of bean 'org.springframework.web.servlet.support.SessionFlashMapManager'
00:06:19,810 DEBUG DispatcherServlet:750 - Unable to locate FlashMapManager with name 'flashMapManager': using default [org.springframework.web.servlet.support.SessionFlashMapManager@6f2354b3]
00:06:19,811 DEBUG ResourceUrlProvider:139 - Looking for resource handler mappings
00:06:19,811 DEBUG DefaultListableBeanFactory:251 - Returning cached instance of singleton bean 'defaultServletHandlerMapping'
00:06:19,811 DEBUG ResourceUrlProvider:130 - No resource handling mappings found
00:06:19,812 DEBUG PropertySourcesPropertyResolver:81 - Searching for key 'spring.liveBeansView.mbeanDomain' in [servletConfigInitParams]
00:06:19,812 DEBUG PropertySourcesPropertyResolver:81 - Searching for key 'spring.liveBeansView.mbeanDomain' in [servletContextInitParams]
00:06:19,812 DEBUG PropertySourcesPropertyResolver:81 - Searching for key 'spring.liveBeansView.mbeanDomain' in [jndiProperties]
00:06:19,813 DEBUG JndiTemplate:150 - Looking up JNDI object with name [java:comp/env/spring.liveBeansView.mbeanDomain]
00:06:19,813 DEBUG JndiLocatorDelegate:101 - Converted JNDI name [java:comp/env/spring.liveBeansView.mbeanDomain] not found - trying original name [spring.liveBeansView.mbeanDomain]. javax.naming.NameNotFoundException: Name [spring.liveBeansView.mbeanDomain] is not bound in this Context. Unable to find [spring.liveBeansView.mbeanDomain].
00:06:19,813 DEBUG JndiTemplate:150 - Looking up JNDI object with name [spring.liveBeansView.mbeanDomain]
00:06:19,814 DEBUG JndiPropertySource:90 - JNDI lookup for name [spring.liveBeansView.mbeanDomain] threw NamingException with message: Name [spring.liveBeansView.mbeanDomain] is not bound in this Context. Unable to find [spring.liveBeansView.mbeanDomain].. Returning null.
00:06:19,814 DEBUG PropertySourcesPropertyResolver:81 - Searching for key 'spring.liveBeansView.mbeanDomain' in [systemProperties]
00:06:19,814 DEBUG PropertySourcesPropertyResolver:81 - Searching for key 'spring.liveBeansView.mbeanDomain' in [systemEnvironment]
00:06:19,814 DEBUG PropertySourcesPropertyResolver:103 - Could not find key 'spring.liveBeansView.mbeanDomain' in any property source. Returning [null]
00:06:19,815 DEBUG DispatcherServlet:568 - Published WebApplicationContext of servlet 'dispatcher' as ServletContext attribute with name [org.springframework.web.servlet.FrameworkServlet.CONTEXT.dispatcher]
00:06:19,815  INFO DispatcherServlet:508 - FrameworkServlet 'dispatcher': initialization completed in 1443 ms
00:06:19,815 DEBUG DispatcherServlet:139 - Servlet 'dispatcher' configured successfully
Feb 25, 2016 12:06:19 AM org.apache.coyote.AbstractProtocol start
INFO: Starting ProtocolHandler ["http-bio-8070"]
