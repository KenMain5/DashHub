<h1 align='center'>
  DashHub 
</h1>


<h2>Description</h2>

DashHub is an all-in-One Daily Planner which would have the features users would need to start the day. Currently, this application would focus more on the backend
to practice my Java programming skills and show minimal React application skills. To see more of my frontend development skills, please see my other projects. 

<div align='center'>
	<img src="https://github.com/KenMain5/DashHub/blob/6f22d864f903cf7c693e5308f4ef689fb91a505b/server/dailydash/src/main/resources/githubReadMe/InitialApplicationLogic.png" height="400"> 
</div>


<h2>Features</h2>

<div>
  <ul>
    <li><strong>Weather:</strong> The application will check the weather to start your day and updates hourly </li>
    <li><strong>User Sign In:</strong> The application includes functionality for users to sign in. </li>  </ul>
</div>



# Endpoints
<details>
  <summary>GET /</summary>
  <br>
  <div>
	This is the endpoint that the client request gets sent to when initially access the website. The RestController will receive this client request and 
    at the moment will just send the daily weather information that we receive from the external API "https://openweathermap.org/". 
      - Planning to create a function that would only send back the necessary information, as well as a way to save this to the database.
      - Hourly checks so that it gets updated 
  </div>
  <br>
</details>


# Takeaway (Things I've Learned)
This is one of the projects I'm planning to put a lot of efforts on. I believe this is something I can use on my daily life and this would provide me a 
more thorough understanding of Java/Spring Framework. 
  
How to implement the MVC Design Pattern
  
How to connect to a deployed Postgres database and send data. 
    
How to do an external API call via WebClient 

