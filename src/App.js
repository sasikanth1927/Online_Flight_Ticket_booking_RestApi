import logo from './logo.svg';
import './App.css';
import Register from './Components/Register';
import Signup from './Components/Signup';
import { BrowserRouter as Router, Route, Switch, Routes } from 'react-router-dom';
import Showdata from './Components/Showdata';
import Loginform from './Components/Login';
import FlightBookingForm from './Components/FlightForm';


function App() {
  return (

    <Router>
      <div>
        <Routes>
    
          <Route path='/' exact Component={Register}/>
          <Route path='/login' Component={Loginform}/>
         <Route path='/form' Component={FlightBookingForm}/>
          </Routes>
      </div>
    </Router>
    
    
   
   
  );
}

export default App;
