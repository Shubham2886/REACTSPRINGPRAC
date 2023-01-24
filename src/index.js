import React from 'react';
import ReactDOM from 'react-dom/client';
import {createBrowserRouter, RouterProvider} from 'react-router-dom'
import GET from './component/GET';
import Home from './component/Home';
import Link from './component/Login';
const router123 = createBrowserRouter([
  {
    path:"/",
    element: <Home/>,
    children:[
      {
      path:"/Login",
      element:<Link/>
      },
      {
        path:"/Get",
        element:<GET/>
      }
    ]

  }


])
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <RouterProvider router={router123}/>
);
