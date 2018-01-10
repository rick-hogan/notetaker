# notetaker
A note-taking RESTful Java application.

# Getting Started

To run the app locally:

```bash
git clone https://github.com/rick-hogan/notetaker.git
cd notetaker
./mvnw clean install
java -jar target/notetaker-0.1.jar
open http://localhost:8080
```

</br>
</br>

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
    
</br>
    
    
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
</br>


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
 </br>

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
 </br>

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
