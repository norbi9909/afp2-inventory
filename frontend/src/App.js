import { BrowserRouter,Switch ,Route,Link } from "react-router-dom";
import SingInSide from './SingInSide';
import React from 'react';
import logo from './logo.svg';
import './App.css';

function App() {
  return (
    <BrowserRouter>
    <div className="App">
      <Switch>
      <Route path="/SingInSide" exact component={SingInSide} />
      </Switch> 
    </div>
    </BrowserRouter>
  );
}

export default App;
