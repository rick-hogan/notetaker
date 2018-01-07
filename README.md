# notetaker
A note-taking RESTful Java application.

# Getting Started
1. Clone the current repository.

2. Unzip the downloaded zip file.

3. Open the terminal and cd to the newly unzipped folder.

4. Run the following. (Be sure you are in the notetaker-master folder) 
```
/.mvnw clean install
```
- This will generate a JAR file so that we can run the application.

7. We will now run our newly created jar file with the following command.
```
java -jar target/notetaker-0.1.jar
```

8. We can now use the api by going to http://localhost:8080/api/notes in your browser.



**Get Notes**
----
  This API call will return all notes.

* **URL**

  /api/notes

* **Method:**
  
  `GET`
  
*  **URL Params**

   **Optional:**
 
   `query=[alphanumeric]`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{ "id" : 1 , "body" : "Sample Note" }`
    
    
    
**Create a Note**
----
  This API call will create a new note.

* **URL**

  /api/notes

* **Method:**
  
  `POST`

* **Data Params**

  {"body" : "Pick up milk!"}

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{ "id" : 1 , "body" : "Pick up milk" }`    

* **Sample Call:**
```
 curl -i -H "Content-Type: application/json" -X POST -d '{"body" : "Pick up milk!"}' http://localhost:8080/api/notes
```
    
 **Get Note By Id**
----
  This API call will return a single note.

* **URL**

  /api/notes/{id}

* **Method:**
  
  `GET`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{ "id" : 1 , "body" : "Sample Note" }`
    
* **Sample Call:**
```
http://localhost:8080/api/notes/1
 ```
 
 **Update a Note**
----
  This API call will update a note.

* **URL**

  /api/notes

* **Method:**
  
  `POST`

* **Data Params**

  {"id" : "1", body" : "Pick up eggs!"}

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{ "id" : 1 , "body" : "Pick up eggs" }`    

* **Error Response:**

  * **Code:** 410 GONE <br />
    **Content:** `{ "id" : 0 : body : "Note does note exist." }`

* **Sample Call:**
```
 curl -i -H "Content-Type: application/json" -X POST -d '{"id" : "1", body" : "Pick up eggs!"}' http://localhost:8080/api/notes
 ```
 
 **Delete a Note**
----
  This API call will delete a note.

* **URL**

  /api/notes/{id}

* **Method:**
  
  `DELETE`
  
* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{ "id" : 1 , "body" : "Pick up milk" }` 
    
* **Error Response:**

  * **Code:** 410 GONE <br />

* **Sample Call:**
```
 curl -i -H "Content-Type: application/json" -X DELETE http://localhost:8080/api/notes/1
 ```
