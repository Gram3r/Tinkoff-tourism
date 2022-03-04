# Tourism map 

Designed and implemented an application in which you can choose the leisure categories you are interested in, budget, time of visit and get a recommended route from activities in response.

### *1. Designed a data model of sights:*

##### The sights have:

* Name
* Category (museum, gallery, walking street or bar), made a hierarchy of categories based on inheritance
* Coordinates
* Description
* The site, if there is
* Working hours
* Price if the visit is paid

### *2. Implemented API for model management (CRUD), necessary validations.*

### *3.Added a role model:*
* Only a user with the ADMIN role can edit sights (PUT, POST, DELETE requests). 
* Any user can view sights (GET requests). 
* Added two users - with and without the ADMIN role.

### *4. Implemented an API to get the recommended route:*

* The client sends a list of categories, time and budget to the input.
* The service selects the recommended route (list) from the sights.
* The sights are in order of visit by time.

### *5.Wrote junit tests:*

* Tests for sights validation.
* Tests for repositories, services, controllers.
* Tests for base authentication.
* Tests for route requests.

### *6. Made a CI/CD pipeline:*

1. Stage of tests. Running `mvn test`.
2. Stage of building. Running `mvn package -B -DskipTests`.
3. Stage of deploying. The project is assembled in docker, and then the docker image is sent to the Heroku website.
