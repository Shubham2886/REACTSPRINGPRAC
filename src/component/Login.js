import React, { useState } from 'react'

export default function Login() {


  const[id,setId]=useState()
  const[pass,setPwd]=useState()



var m1 =(e)=>{

  // alert();
fetch("http://localhost:8080/emp/login",{
  method: 'POST',
  headers:{
    'Content-Type': 'application/json'
  },
  body:JSON.stringify({
    id:id, pwd:pass
  })
})
.then((response) => response.json())
.then((data) => {
  console.log(data)
  // xyz("/user-page")
})
.catch(
  (e)=>{
    console.log(e);
  }
)


}
var m2=(e)=>{
  // console.log(e.target.value+"Test");
  setId(e.target.value)
}
var m3=(e)=>{
  // console.log(e.target.value+"Test");
  setPwd(e.target.value)
}


console.log(id,pass);

  return (
    <div class="container-fluid" >
    <div class="input-group flex-nowrap">
    <span class="input-group-text" id="addon-wrapping">Id</span>
    <input type="text" id="id" class="form-control" placeholder="Username" onChange={m2} aria-label="Username" aria-describedby="addon-wrapping"/>
    </div>
    <br/>
    <div class="input-group flex-nowrap">
    <span class="input-group-text" id="addon-wrapping">Password</span>
    <input type="Password" id="pwd" class="form-control"  placeholder=" Enter Password" onChange={m3} aria-label="Username" aria-describedby="addon-wrapping"/>
    
    </div>
    <br/>
    <button type="Sumbit" onClick={m1} class="btn btn-info">Sumbit</button>



    
    </div>
  )
}
//}
