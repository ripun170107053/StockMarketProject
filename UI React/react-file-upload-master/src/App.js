import React from "react";
import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";

import UploadFiles from "./components/upload-files.component";
function refreshPage()
{
  window.location.reload();
  return;
} 
function App() {
  return (
    <div className="container" style={{ width: "600px" }}>
      <div style={{ margin: "20px" }}>
        <h3>Upload Stock Data Excel File</h3>
        <h11>The file has to be in valid format</h11>
      </div>

      <UploadFiles />;
      <button  onClick={refreshPage}>Refresh Button</button>
    </div>
  );
}

export default App;
