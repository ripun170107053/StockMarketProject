import { lineBreak } from 'acorn';
import React, { Component } from 'react';


class getAllSE extends Component {
  // initially data is empty in state
  state = { data: [] };

  componentDidMount() {
    // when component mounted, start a GET request
    // to specified URL
    const myInit1  = {
        method: 'GET',
        headers: { 'Content-Type': 'application/json',
        'Access-Control-Allow-Origin' : '*',
        'Vary': 'Origin' ,
    'mode':'no-cors'},

}
    fetch('http://localhost:8080/stockExchange/allStockExchanges/{id}',
    myInit1).then(response => response.json())
      // and update the state data to said json
      .then(data => this.setState({ data }));
  }


  render() 
  {
    var cn=[];
    let xx=new Map();
    var z = JSON.stringify(this.state.data);
    console.log(z);
   // this.state.data.map();
    
        
    //console.log(cn);
    return (
        <div align="center">
        
          {
            cn.map(x=>(<p>{x}</p>))
          }
        
        
        <ul>
        {
          
          
        }
        </ul>
        </div>
    );
  }
}

export default getAllSE;