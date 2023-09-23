import axios from "axios";
import React, { Component } from "react";


class Showdata extends Component {
  state = {
  data: []
  }

  componentDidMount() {
  axios.get('http://127.0.0.1:8080/show/reg')
    .then(response => {
      this.setState({ data: response.data });
      console.log(this.state.data);
    })
    .catch(error => {
      console.log(error);
    });
}


  render() {   
    return (

        
      <table border={1}>
      <thead>
        <tr>
          <th>UserName</th>
          <th>Password</th>
          <th>PhoneNumber</th>
        </tr>
      </thead>
      <tbody>
        {this.state.data.map(user => (
          <tr key={user.mobile}>
            <td>{user.username}</td>
            <td>{user.password}</td>
            <td>{user.mobile}</td>
          </tr>
        ))}
      </tbody>
    </table>
    );
  }}
  
export default Showdata;