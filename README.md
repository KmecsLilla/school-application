
# **My school application**


## **1. Operations on School**

#### - GET /school Retrieves all Schools.

#### - GET /school/{id} Retrieves a School by id.

#### - PUT /school/{id} Updates a School.

#### - POST /school Creates a new School.

#### - DELETE /school/{id} Deletes a School by id.



## **2. Operations on Division**

#### - GET /division Retrieves all divisions.

#### - GET /division/{id} Retrieves a division by id.

#### - PUT /division/{id} Updates a division.

#### - POST /division Creates a new division.

#### - DELETE /division/{id} Deletes a division by id.



## **3. Common operations**

#### - GET /school/{id}/students Counts number of students of a given school

#### - GET /school/{id}/support Calculates the total general government support for a school specified by its id.

# Docker

docker build -t  school-application .
docker run -p 8080:8080 school-application
