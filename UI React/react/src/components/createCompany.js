import React, { Component } from 'react';
import Select from 'react-select';
import exportFromJSON from 'export-from-json';
import axios from 'axios';

 class createCompany extends Component
 {
    constructor(props) {
      super(props);
  
      this.state = { Company: [], companyName: "", turnover: "", ceo: "" ,stockExchange:"",boardDirector:"",sector:"",writeup:"",companyCode:""};
      this.submit = this.submit.bind(this);
      this.changehandler1 = this.changehandler1.bind(this);
      this.fetchhttp = this.fetchhttp.bind(this);
      this.posthttpjson = this.posthttpjson.bind(this);
      //this.popSE=this.popSE.bind(this);
      //this.posthttp =this.posthttp.bind(this);
      //this.changehandler2 = this.changehandler2.bind(this);
    }
   
    submit(e) {
      e.preventDefault();
      var usr = this.state.Company;
      usr.push({
        companyName: this.state.companyName,
        turnover: this.state.turnover,
        ceo: this.state.ceo,
        stockExchange: this.state.stockExchange,
        boardDirector: this.state.boardDirector,
        sector:this.state.sector,
        writeup:this.state.writeup,
        companyCode:this.state.companyCode,
        
        
      });
      this.setState({ Company: usr });
      console.log(JSON.stringify(this.state.Company)+"TEST");
       // this.fetchhttp(e);
       // this.posthttp(e);
       this.posthttpjson(e);
    }
  
    changehandler1(e) {
      if (e.target.name === "companyName"){
              this.setState({ companyName: e.target.value });
          } 
  
      else if(e.target.name === "ceo"){
          this.setState({ ceo: e.target.value });
      }
      else if  (e.target.name === "turnover"){
          
          this.setState({ turnover: e.target.value });
  }     
  else if  (e.target.name === "stockExchange"){
    
    this.setState({ stockExchange: e.target.value });
      
    }
    else if  (e.target.name === "boardDirector"){
    
      this.setState({ boardDirector: e.target.value });
        
      }
      else if  (e.target.name === "sector"){
    
        this.setState({ sector: e.target.value });
          
        }
        else if  (e.target.name === "writeup"){
    
            this.setState({ writeup: e.target.value });
              
            }
            else if  (e.target.name === "companyCode"){
    
                this.setState({ companyCode: e.target.value });
                  
                }
      }

      posthttpjson(e) {
      
  
        console.log("posthttpjson");
    
        const myInit1  = 
        {
          method: 'POST',
          headers: { 
              'Content-Type': 'application/json; charset=UTF-8',
          'Access-Control-Allow-Origin' : '*',
          'Vary': 'Origin'.replace,
          'Accept': 'application/json',
          },
          //mode:'no-cors',
          body: JSON.stringify({
        "companyName" :this.state.companyName,
        "ceo" :this.state.ceo,
        "turnover": this.state.turnover,
         "stockExchange":this.state.stockExchange,
         "boardDirector":this.state.boardDirector,
         "sector": this.state.sector,
         "writeup": this.state.sector,
         "companyCode": this.state.sector   
          }),
        };
        console.log(myInit1+"body")
        alert("Company created successfully");
        let finalurl = 'http://127.0.0.1:8080/companies/add';
        fetch(finalurl, myInit1)
          .then((response) => 
          {
            this.setState({ companyName: '' });
            this.setState({ turnover: '' });
            this.setState({ ceo: '' });
            this.setState({ boardDirector: '' });
            this.setState({ stockExchange:''});
            this.setState({ sector: '' });
            this.setState({ writeup: '' });
            this.setState({ companyCode: '' });
            
            return response.json();
            
          })
          .then(function (myJson) {
            console.log(myJson);
          })
          .catch((error) => console.error(error));
       
      }
  
  
  
    fetchhttp(e) {
    
      console.log("fetchhttp");
  
      const myInit1 = { method: "GET"  };
           
      let finalurl = "http://127.0.0.1:8080/stockExchange/";
      
      fetch(finalurl, myInit1)
        .then((response) => {
            
           return response.json();
        })
        .then(function (myJson) 
        {
            
          
        })
        .catch((error) => console.error(error));
    } ;
   
    render() 
    {
        
      //this.fetchhttp();
      return (
        // 
        
        <div className="table" align="center" style={{paddingTop : '50px'}}>
        <form onSubmit={this.submit}> 
          Company name :{" "}
          <input
            type="companyName"
            name="companyName"
            value={this.state.companyName}
            ref="companyName"
            onChange={this.changehandler1}
          />
          <br />
          <p></p>
          Company turnover :{" "}
          <input
            type="turnover"
            name="turnover"
            value={this.state.turnover}
            ref="turnover"
            onChange={this.changehandler1}
          />
          <br />
          <p></p>
          Company ceo :{" "}
          <input
            type="ceo"
            name="ceo"
            value={this.state.ceo}
            ref="ceo"
            onChange={this.changehandler1}
          />
          <br />
          <p></p>
          Company writeup :{" "}
          <input
            type="writeup"
            name="writeup"
            value={this.state.writeup}
            ref="writeup"
            onChange={this.changehandler1}
          />
          <br />
          Company stockExchange :{" "}
          
          <input
            type="stockExchange"
            name="stockExchange"
            value={this.state.stockExchange}
            ref="stockExchange"
            onChange={this.changehandler1}
          />
          <br />
          Company boardDirector :{" "}
          <input
            type="boardDirector"
            name="boardDirector"
            value={this.state.boardDirector}
            ref="boardDirector"
            onChange={this.changehandler1}
          />
          <br />
          Company sector :{" "}
          <input
            type="sector"
            name="sector"
            value={this.state.sector}
            ref="sector"
            onChange={this.changehandler1}
          />
          <br />
          Company code :{" "}
          <input
            type="companyCode"
            name="companyCode"
            value={this.state.companyCode}
            ref="companyCode"
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
// {
     
    
//     constructor()
//     {
//         super();
        
//         this.state = {
//             companyName:"",
//             ceo:"",
//             boardDirector:"",
//             turnover: 0,
//             stockExchange:"",
//             writeup:"",
//             sector:"",
//             companyCode:"",
            
//         }
        
//     }
    

//     render() 
//     {
        
//         getSE();
//         {console.log(sen + "outside")};
        
//         return (
            
//             <div >
                
                
                
//                 <br></br>
//                <h2 align="center">Add Company Details</h2>
//                <br></br>
               
//                 <form>
//                     <div>
                    
                    
//                     <label htmlFor="companyName">Company Name</label>
//                     <input type="text" className="form-control" name="companyName" value={this.state.companyName}  onChange={this.handleChange} id="companyName" />
//                     </div>
//                     <div className="form-group mb-3 ">
//                     <label htmlFor="CEOname">CEO Name</label>
//                     <input type="text" className="form-control" name="ceo" value={this.state.ceo}  onChange={this.handleChange}  id="CEOname"/>
//                     </div>
//                     <div className="form-group mb-3 ">
//                     <label htmlFor="boardDirector">Board Of Directors</label>
//                     <input type="text"  className="form-control"  name="boardDirector" value={this.state.boardDirector} onChange={this.handleChange} id="boardDirector"/>
//                     </div>
//                     <div className="form-group mb-3">
//                     <label htmlFor="turnover">Turn Over in $</label>
//                     <input type="number" className="form-control" name="turnover" value={this.state.turnover} onChange={this.handleChange} id="turnover"/>
//                     </div>
//                     <div className="form-group">
//                     <label htmlFor="writeupription">Writeup</label>
//                     <input type="textbox" className="form-control rounded" name="writeup" value={this.state.writeup}onChange={this.handleChange} id="writeupription"/>
//                     </div>
//                     <div className="form-group">
//                     <label htmlFor="companyCode">companyCode</label>
//                     <input type="textbox" className="form-control rounded" name="companyCode" value={this.state.companyCode}onChange={this.handleChange} id="companyCode"/>
//                     </div>
                    
//                     <div className="form-group">
//                     <label htmlFor="stockExchange">stockExchange</label>
//                     <Select
                        
//                     />
//                     </div>

//                     <div className="form-group">
//                     <label htmlFor="sector">sector</label>
//                     <input type="textbox" className="form-control rounded" name="sector" value={this.state.sector}onChange={this.handleChange} id="sector"/>
//                     </div> 

                    
//                     <button type="submit" className="btn btn-md btn-success">Submit</button>
//                 </form>
//             </div>
//         )
//     }
//      getSE()
//         {
//             fetch('http://localhost:8080/stockExchange/').then(response => response.json())
//             .then((jsonData) => {
//               // jsonData is parsed json object received from url
//               this.sen=jsonData.map(function(item)
//               {
//                   return item.stockExchange;
//               });
//               console.log(sen + "inside")
//             })
//             .catch((error) => {
//               // handle your errors here
//               console.error(error)
//             });
//         };
// }

export default createCompany;