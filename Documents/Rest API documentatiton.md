                                                         REST API Documentation
 
 <table>
  <thead>
  <tr>
    <td><b><p align="center">Service name</p></b></td>
    <td colspan=2><b><p align="center">Login</p></b></td>
  </tr>
  </thead>
  <tr> 
    <td><p align="center">Description</p></td>
    <td><p>The login operation requires two properties: one marked as user identity and the second is password.</p></td>
  </tr>
    <td><p align="center">Method</p></td>
    <td><p>POST</p></td>
  </tr>
  <tr>
    <td><p align="center">Path</p></td>
    <td><p>Inventory/login</p></td>
  </tr>
  <tr>
    <td><p align="center">Parameters</p></td>
    <td><p> Request Body:    
       <li> "login" : value,    </li>
        <li>"password" : value, </li> 
  </p></td>
  </tr>
  <tr>
    <td><p align="center">Response OK</p></td>
    <td><p>status_code : 201, description : Succesful login!</p></td>
  </tr>
  <tr>
    <td><p align="center">Response Error</p></td>
    <td><p>status_code: 401, description: Bad username or password!</p></td>
  </tr>  
  <tr>
    <td><p align="center">Curl</p></td>
    <td><p>
      <li>-H Content-Type:application/json   </li>
      <li>-X POST   </li>
      <li>-d '{"login":"admin", "password":"admin"}'  </li> 
      <li>-v https://localhost:8080/Inventory/login  </li>
  </p></td> 
  </tr>  
</table>


<table>
  <thead>
   <tr>
    <td><b><p align="center">Service name</p></b></td>
    <td colspan=2><b><p align="center">Logout</p></b></td>
  </tr>
  </thead>
  <tr> 
    <td><p align="center">Description</p></td>
    <td><p>The Logout operation terminates user session and disassociates the AuthenticatedUser role.
  </tr>
    <td><p align="center">Method</p></td>
    <td><p>GET</p></td>
  </tr>
  <tr>
    <td><p align="center">Path</p></td>
    <td><p>Inventory/logout</p></td>
  </tr>
  <tr>
    <td><p align="center">Parameters</p></td>
    <td><p> Request Headers:   
       <li> user-token: value-of-the-user-token-header-from-login  </li>       
  </p></td>
  </tr>
  <tr>
    <td><p align="center">Response OK</p></td>
    <td><p>status_code : 200,	description : Succesful logout!</p></td>
  </tr>
  <tr>
    <td><p align="center">Response Error</p></td>
    <td><p >status_code: 401, description: Invalid token!</p></td>
  </tr>  
  <tr>
    <td><p align="center">Curl</p></td>
    <td><p>
      <li>-H user-token:[`value-of-user-token-from-login`]  </li>    
      <li>-v https://localhost:8080/Inventory/logout  </li>
  </p></td> 
  </tr>  
</table>


<table>
  <thead>
  <tr>
    <td><b><p align="center">Service name</p></b></td>
    <td colspan=2><b><p align="center">ListInventoryForWorker</p></b></td>
  </tr>
  </thead>
  <tr> 
    <td><p align="center">Description</p></td>
    <td><p>Returns json data about item list for Worker.</p></td>
  </tr>
    <td><p align="center">Method</p></td>
    <td><p>GET</p></td>
  </tr>
  <tr>
    <td><p align="center">Path</p></td>
    <td><p>Inventory/Worker/List</p></td>
  </tr>
  <tr>
    <td><p align="center">Parameters</p></td>
    <td><p> Response Body:    
       <li> "id" : value,   </li>
       <li>"name" : value, </li> 
       <li> "description" : value,   </li>
       <li> "available" : value  </li>
  </p></td>
  </tr>
  <tr>
    <td><p align="center">Response OK</p></td>
    <td><p>status_code : 201, description : Succesful query!</p></td>
  </tr>
  <tr>
    <td><p align="center">Response Error</p></td>
    <td><p>status_code: 401, description: Unsuccesful query!</p></td>
  </tr>  
  <tr>
    <td><p align="center">Curl</p></td>
    <td><p>
      <li>-H Content-Type:application/json   </li>
      <li>-X GET   </li>
      <li>-d '{"id": 37853, "name": guitar, "description": Electronic guitar, "available": 5}'  </li> 
      <li>-v https://localhost:8080/Inventory/Worker/List </li>
  </p></td> 
  </tr>  
</table>


<table>
  <thead>
  <tr>
    <td><b><p align="center">Service name</p></b></td>
    <td colspan=2><b><p align="center">ListInventoryForAssemblyLine</p></b></td>
  </tr>
  </thead>
  <tr> 
    <td><p align="center">Description</p></td>
    <td><p>Returns json data about item list for AssemblyLine.</p></td>
  </tr>
    <td><p align="center">Method</p></td>
    <td><p>GET</p></td>
  </tr>
  <tr>
    <td><p align="center">Path</p></td>
    <td><p>Inventory/AssemblyLine/List</p></td>
  </tr>
  <tr>
    <td><p align="center">Parameters</p></td>
    <td><p> Response Body:    
       <li> "id" : value,   </li>
       <li>"name" : value, </li> 
       <li> "description" : value,   </li>
       <li> "available" : value   </li>
  </p></td>
  </tr>
  <tr>
    <td><p align="center">Response OK</p></td>
    <td><p>status_code : 201, description : Succesful query!</p></td>
  </tr>
  <tr>
    <td><p align="center">Response Error</p></td>
    <td><p>status_code: 401, description: Unsuccesful query!</p></td>
  </tr>  
  <tr>
    <td><p align="center">Curl</p></td>
    <td><p>
      <li>-H Content-Type:application/json   </li>
      <li>-X GET   </li>
      <li>-d '{"id": 17650, "name": book, "description": Clean code book, "available": 2}'  </li> 
      <li>-v https://localhost:8080/Inventory/AssemblyLine/List </li>
  </p></td> 
  </tr>  
</table>


<table>
  <thead>
  <tr>
    <td><b><p align="center">Service name</p></b></td>
    <td colspan=2><b><p align="center">ListInventoryForSalesTeam</p></b></td>
  </tr>
  </thead>
  <tr> 
    <td><p align="center">Description</p></td>
    <td><p>Returns json data about item list for SalesTeam.</p></td>
  </tr>
    <td><p align="center">Method</p></td>
    <td><p>GET</p></td>
  </tr>
  <tr>
    <td><p align="center">Path</p></td>
    <td><p>Inventory/SalesTeam/List</p></td>
  </tr>
  <tr>
    <td><p align="center">Parameters</p></td>
    <td><p> Response Body:    
       <li> "id" : value,   </li>
       <li>"name" : value, </li> 
       <li> "description" : value,   </li>
       <li> "available" : value   </li>
  </p></td>
  </tr>
  <tr>
    <td><p align="center">Response OK</p></td>
    <td><p>status_code : 201, description : Succesful query!</p></td>
  </tr>
  <tr>
    <td><p align="center">Response Error</p></td>
    <td><p>status_code: 401, description: Unsuccesful query!</p></td>
  </tr>  
  <tr>
    <td><p align="center">Curl</p></td>
    <td><p>
      <li>-H Content-Type:application/json   </li>
      <li>-X GET   </li>
      <li>-d '{"id": 02451, "name": basketball, "description": High quality, "available": 7}'  </li> 
      <li>-v https://localhost:8080/Inventory/SalesTeam/List </li>
  </p></td> 
  </tr>  
</table>


<table>
  <thead>
  <tr>
    <td><b><p align="center">Service name</p></b></td>
    <td colspan=2><b><p align="center">ListInventoryForPurchuseDepartment</p></b></td>
  </tr>
  </thead>
  <tr> 
    <td><p align="center">Description</p></td>
    <td><p>Returns json data about item list for PurchuseDepartment.</p></td>
  </tr>
    <td><p align="center">Method</p></td>
    <td><p>GET</p></td>
  </tr>
  <tr>
    <td><p align="center">Path</p></td>
    <td><p>Inventory/PurchuseDepartment/List</p></td>
  </tr>
  <tr>
    <td><p align="center">Parameters</p></td>
    <td><p> Response Body:    
       <li> "id" : value,   </li>
       <li>"name" : value, </li> 
       <li> "description" : value,   </li>
       <li> "available" : value   </li>
  </p></td>
  </tr>
  <tr>
    <td><p align="center">Response OK</p></td>
    <td><p>status_code : 201, description : Succesful query!</p></td>
  </tr>
  <tr>
    <td><p align="center">Response Error</p></td>
    <td><p>status_code: 401, description: Unsuccesful query!</p></td>
  </tr>  
  <tr>
    <td><p align="center">Curl</p></td>
    <td><p>
      <li>-H Content-Type:application/json   </li>
      <li>-X GET   </li>
      <li>-d '{"id": 92356, "name": calculator, "description": Sencor calculator, "available": 1}'  </li> 
      <li>-v https://localhost:8080/Inventory/PurchuseDepartment/List </li>
  </p></td> 
  </tr>  
</table>
