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
    <td><p>status_code : 201, description : Sikeres bejelentkezés!</p></td>
  </tr>
  <tr>
    <td><p align="center">Response Error</p></td>
    <td><p>status_code: 401, description: Sikertelen bejelentkezés!</p></td>
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
    <td><p>status_code : 200,	description : Sikeres kijelentkezés!</p></td>
  </tr>
  <tr>
    <td><p align="center">Response Error</p></td>
    <td><p >status_code: 401, description: Helytelen token!</p></td>
  </tr>  
  <tr>
    <td><p align="center">Curl</p></td>
    <td><p>
      <li>-H user-token:[`value-of-user-token-from-login`]  </li>    
      <li>-v https://localhost:8080/Inventory/logout  </li>
  </p></td> 
  </tr>  
</table>

