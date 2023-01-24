import React, { useEffect, useState } from 'react'

export default function GET() {


    const [cat, setcat] = useState([])


    useEffect(() => {

        fetch('http://localhost:8080/emp/allEmps')
            .then(res => res.json())
            .then(val => {
                console.log('api called');
                console.log(val);
                setcat(val);

            })
    }, [])
    return (


        <div class='container'>
            <table class='table'>
                <tr>
                    <th>Id</th>
                    <th>name</th>
                    <th>Designation</th>
                    <th>EmailId</th>
                </tr>
                {
                    cat.map((obj) =>


                        <tr>
                            <td>{obj.id}</td>
                            <td>{obj.name}</td>
                            <td>{obj.designation}</td>
                            <td>{obj.emailId}</td>
                        </tr>


                    )
                }

            </table>
        </div>
    )
}
