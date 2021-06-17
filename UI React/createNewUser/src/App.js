import React from "react";
import logo from "./logo.svg";
import "./App.css";
import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css';
class App extends React.Component {
  constructor(props) {
    super(props);

    this.state = { user: [], username: "", password: "", email: "" ,userType:"",confirmed:"",mobile:""};
    this.submit = this.submit.bind(this);
    this.changehandler1 = this.changehandler1.bind(this);
    this.fetchhttp = this.fetchhttp.bind(this);
    this.posthttpjson = this.posthttpjson.bind(this);
    this.posthttp =this.posthttp.bind(this);
    //this.changehandler2 = this.changehandler2.bind(this);
  }
  submit(e) {
    e.preventDefault();
    var usr = this.state.user;
    usr.push({
      username: this.state.username,
      password: this.state.password,
      email: this.state.email,
      userType: this.state.userType,
      confirmed: this.state.confirmed,
      mobile:this.state.mobile
    });
    this.setState({ user: usr });
    console.log(JSON.stringify(this.state.user)+"TEST");
	 // this.fetchhttp(e);
     // this.posthttp(e);
     this.posthttpjson(e);
  }

  changehandler1(e) {
    if (e.target.name === "username"){
			this.setState({ username: e.target.value });
		} 

    else if(e.target.name === "email"){
    	this.setState({ email: e.target.value });
	}
    else if  (e.target.name === "password"){
   	 
   	 this.setState({ password: e.target.value });
}     
else if  (e.target.name === "userType"){
  
  this.setState({ userType: e.target.value });
    
  }
  else if  (e.target.name === "confirmed"){
  
    this.setState({ confirmed: e.target.value });
      
    }
    else if  (e.target.name === "mobile"){
  
      this.setState({ mobile: e.target.value });
        
      }
    }
//backup get method to create users ,in case post does not work
	posthttp(e) { 

    console.log("posthttp");

   
    const myInit1  = {
			method: 'GET',
			headers: { 'Content-Type': 'application/json',
			'Access-Control-Allow-Origin' : '*',
			'Vary': 'Origin' },

	};
   
    let finalurl = 'http://127.0.0.1:8080/setuserapi?username='+this.state.name+'&password='
    +this.state.password+'&email='+this.state.email+'&userType='+this.state.userType+'&confirmed='
    +this.state.confirmed+'&mobile='+this.state.mobile+'';
    
	
		fetch(finalurl, myInit1)
      .then((response) => {
        return response.json();
      })
      .then(function (myJson) {
        console.log(myJson);
      })
      .catch((error) => console.error(error));
  } 
	posthttpjson(e) {
    

      console.log("posthttpjson");
  
      const myInit1  = 
      {
        method: 'POST',
        headers: { 'Content-Type': 'application/json',
        'Access-Control-Allow-Origin' : '*',
        'Vary': 'Origin'.replace,
        'Accept': 'application/json'
        },
        body: JSON.stringify({
    "username" :this.state.username,
    "email" :this.state.email,
      "password": this.state.password,//make sure these match with java entity class properties to avoid error
       "userType":this.state.userType,
       "confirmed":this.state.confirmed,
       "mobile": this.state.mobile   
        })
      };
    
      let finalurl = 'http://127.0.0.1:8080/setuserapi2';
      fetch(finalurl, myInit1)
        .then((response) => {
          return response.json();
        })
        .then(function (myJson) {
          console.log(myJson);
        })
        .catch((error) => console.error(error));
     
	}



  fetchhttp(e) {
  
    console.log("fetchhttp");

    const myInit1 = { method: "GET" };
         
    let finalurl = "http://127.0.0.1:8080/companies/findById/1";
    //////
    fetch(finalurl, myInit1)
      .then((response) => {
        return response.json();
      })
      .then(function (myJson) {
        console.log(myJson);
      })
      .catch((error) => console.error(error));
  } 
  
  render() 
  {
    return (
      // 
      

      <div class="table" align="center" style={{paddingTop : '50px'}}>
      <form onSubmit={this.submit}> 
        USer name :{" "}
        <input
          type="username"
          name="username"
          value={this.state.username}
          ref="username"
          onChange={this.changehandler1}
        />
        <br />
        <p></p>
        User password :{" "}
        <input
          type="password"
          name="password"
          value={this.state.password}
          ref="password"
          onChange={this.changehandler1}
        />
        <br />
        <p></p>
        User email :{" "}
        <input
          type="email"
          name="email"
          value={this.state.email}
          ref="email"
          onChange={this.changehandler1}
        />
        <br />
        USer Type :{" "}
        <select name="type" onChange={this.changehandler1}>
          <option value="Admin">Admin</option>
          <option value="Non-Admin">Normal</option>
        </select>{" "}
        <br />
        USer Confirmed :{" "}
        <input
          type="boolean"
          name="confirmed"
          value={this.state.confirmed}
          ref="confirmed"
          onChange={this.changehandler1}
        />
        <br />
        USer Mobile :{" "}
        <input
          type="Long"
          name="mobile"
          value={this.state.mobile}
          ref="mobile"
          onChange={this.changehandler1}
        />
        <br />
        <button type="submit">Save now</button>
       
        {/* <button onClick={this.posthttpjson}>
  Submit
</button> */}
      </form>
      </div>
      
    );
  }
}

export default App;
