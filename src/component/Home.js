import React from 'react'
import {  Link,  Outlet } from 'react-router-dom'

export default function Home() {
  return (<div>
    <nav class="navbar navbar-expand-lg bg-body-tertiary ">
  <div class="container-fluid navbar bg-dark" data-bs-theme="dark" >
   
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <Link class="nav-link active" aria-current="page" to={"/"} >Home</Link>
        </li>
        <li class="nav-item">
          <Link class="nav-link" to={"/Login"}>Login</Link>
        </li>
        <li class="nav-item">
        <Link class="nav-link" to={"/GET"}>Get</Link>
      </li>
       
       
      </ul>
    </div>
  </div>
</nav>
<Outlet/>
</div>

        
  )
}
