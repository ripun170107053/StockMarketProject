import React, {useState} from 'react'
// import TextField from '@material-ui/core/TextField';
// import Autocomplete from '@material-ui/lab/Autocomplete';
// import {companies} from "../../dummyData";
// import { CompanyDetails } from '../companyComponents/Company';

const UserLandingPage = () => { 
   // const [company,setCompany] = useState(null);
    return (
        <div>
          user
    {/* <Autocomplete
      id="combo-box-demo"
      options={companies}
      getOptionLabel={(option) => option.name }
      style={{ width: 400 }}
      renderInput={(params) => <TextField {...params} label="Search For a Company" placeholder="Search a Company By Name" variant="outlined"/>}
      onChange={(e,v)=>{setCompany(v)}}
      className="ml-auto mr-auto mt-3"
/>
    {company===null ? <div></div> : <CompanyDetails company={company}/>} */}
    </div>
    );
      }

export default UserLandingPage;
