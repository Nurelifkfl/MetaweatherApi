# MetaweatherApi



### TOOLS AND EXPLANATIONS

>1.The project has been prepared based on Cucumber BDD style.
> 
>2.Maven build management tool is used in this project by Java language.
>
>3.In the project that includes four scenarios, the first scenario verifies by receiving weather information from the public API server(https://www.metaweather.com/api), the second scenario verifies by receiving weather information with different locations and dates.Third scenario is negative scenario with invalid location.The last scenario is also negative scenario and considered bug(providing invalid dates gives 200 successfull status code,while expecting 404)
>
>4.A special tag(@wip,@negative,@positive,@bug) was used in the project. Thus, the desired feature can be run in Runner. 

### HOW TO RUN
> -<span style="color:red;">></span> Under the runner package "runners" choose "testRunner" class right click and run . <span style="color:brown;">"src > test > java > com > runners > testRunner"</span>
> 
> -<span style="color:red;">></span> mvn test --<span style="color:red;">></span> in the IDE console or navigate project path <span style="color:red;">in</span> <span style="color:blue;">command</span> line and run.

### HOW TO CREATE TEST REPORTS
1-) When you run tests with the **"mvn verify"** command from the console, you can see **Cucumber Html Reports** under the target file. 
**-> target -> cucumber-html-reports > overview-steps.html** (open with chrome option)

2-) Second type of report, the project is run from **testRunner** class, a Cucumber Report link is created in the IDE console automatically.(In project report 78 steps passed, 4 step fails.This failures because of bug)


### ASSESSMENT
>1.Explain why you chose to use those particular tools/frameworks in the technical
> 
> -I choosed Cucumber BDD Framework because it is reusable, centralized, easy to use, easy to maintain and less redundancy framework. And using Gherkin language, non-technical people like stakeholders and clients also can understand easily. I used RestAssured library, it can manipulate data in json,xml,html format.
> 
> 2.Describe the reason for the scope of your solution. Why did you test what you did, and why didn’t you test other
> 
> I considered all the possibilities regarding to task. I wrote positive and negative scenarios.
> I used **Scenario Outline** in order to avoid too many similar scenarios, it provides parameterized scenario script for the feature file and I can use different examples in examples table.
> 
> 
> 3.What questions would you ask your Product Owner / what information would you need to know, to be able to test the whole MetaWeather API service
> 
> There are lots of data in payload when we send a GET request regarding to getting weather. There are time intervals and weather is changing time by time. I would ask whick weather information should i extract? In this project I choosed first one. And also I would ask more details about swagger documentation in order to test all the functionalities.
> 
> 
> 4.After completing the technical challenge, what would you do differently if you were asked to do the same challenge again?
>
>I would use Karate Framework because Karate has too many capabilities include being able to run tests in parallel, HTML reports and compatibility with Continuous Integration tools.




**Nur Elif Kafali**

Software Development Engineer in Test

https://www.linkedin.com/in/nurelifkafali/

