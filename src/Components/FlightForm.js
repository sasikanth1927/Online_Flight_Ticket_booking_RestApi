import React, { useState } from 'react';
import axios from 'axios';

const airports = [
  { code: 'PNQ', name: 'Pune' },
  { code: 'DEL', name: 'Delhi' },
  { code: 'BLR', name: 'Bengaluru' },
  { code: 'BOM', name: 'Mumbai' },
];
const prices = {
  'PNQ-DEL': 5000,
  'PNQ-BLR': 4000,
  'PNQ-BOM': 4500,
  'DEL-BLR': 5500,
  'DEL-BOM': 6000,
  'BLR-BOM': 3500,
};
const flights = [
  {
    id: 1,
    airline: 'Air India',
    duration: '2h 30m',
    arrival: '14:30',
    departure: '12:00',
    price: 5000,
    seatCount: 100,
    availability: 30,
  },
  {
    id: 2,
    airline: 'IndiGo',
    duration: '2h 45m',
    arrival: '15:15',
    departure: '12:30',
    price: 5500,
    seatCount: 120,
    availability: 40,
  },
  {
    id: 3,
    airline: 'SpiceJet',
    duration: '2h 15m',
    arrival: '14:15',
    departure: '12:00',
    price: 4500,
    seatCount: 80,
    availability: 20,
  },
];

const generatePassengerId = () => {
  const timestamp = new Date().getTime();
  return timestamp;
};

const FlightBookingForm = () => {
  const [source, setSource] = useState('');
  const [destination, setDestination] = useState('');
  const [classSeating, setClassSeating] = useState(''); 
  const [date, setDate] = useState('');
  const [time, setTime] = useState('');
  const [selectedFlight, setSelectedFlight] = useState(null);
  const [price, setPrice] = useState(0);
  const [passengers, setPassengers] = useState([]);
 
  const [userDetails, setUserDetails] = useState({
    firstname: '',
    lastname: '',
    email: '',
    age: '',
    phonenumber: '',
    address: '',
  });

  const calculatePrice = () => {
    const routeKey = `${source}-${destination}`;
    if (routeKey && prices[routeKey]) {
      setPrice(prices[routeKey] * passengers.length);
    } else {
      setPrice(0);
    }
  };

  const handleFlightSelection = (flight) => {
    setSelectedFlight(flight);
  };

  const handlePassengerChange = (e, field, index) => {
    const updatedPassengers = [...passengers];
    updatedPassengers[index][field] = e.target.value;
    setPassengers(updatedPassengers);
  };

  const addPassenger = () => {
    const newSeat = passengers.length + 1;
    setPassengers([
      ...passengers,
      {
        passengerId: generatePassengerId(),
        userid: userDetails.email, 
        name:'',
        age: '',
        gender: '',
        seat: newSeat,
      },
    ]);
  };

  const removePassenger = () => {
    if (passengers.length > 1) {
      const updatedPassengers = [...passengers];
      updatedPassengers.pop();
      setPassengers(updatedPassengers);
    }
  };
  const generateId = () => {
  
    return Math.floor(100000 + Math.random() * 900000);
  }
  const handleSubmit = () => {
    
  const bookingData = {
   
    userId: {
      
      firstName: userDetails.firstname,
      lastName: userDetails.lastname,
      email: userDetails.email,
      age: parseInt(userDetails.age), 
      phoneNumber: userDetails.phonenumber,
      address: userDetails.address,
    },
    flightId: selectedFlight.id,
    numSeats: passengers.length,
    price: price,
    bookingDateAndTime: new Date().toISOString(),
    className: classSeating,
    flight: {
      flightId: selectedFlight.id,
      airline: selectedFlight.airline,
      departure: source,
      arrival: destination,
      duration: parseInt(selectedFlight.duration), 
      seatCount: selectedFlight.seatCount,
      price: selectedFlight.price,
      isAvailable: selectedFlight.availability > 0,
    },
    listPassengers: passengers.map((passenger) => ({
      
      bookId: generateId(),
      name: passenger.name,
      age: parseInt(passenger.age), 
      gender: passenger.gender,
      passSeat: passenger.seat,
    })),
  };
    
   
    
      axios.post('http://127.0.0.1:8080/add/book', bookingData, {
        headers: {
          'Content-Type': 'application/json', 
        },
      })
      .then((response) => {
        
      })
      .catch((error) => {
        console.error('Axios error:', error);
      });
     
      console.log(bookingData);
  };

  return (
    <div className='form-container'>
      <div className='Container-1-flight'>
        <h1>Flight Ticket Booking</h1>
        <form>
          <div className='form-group'>
            <label htmlFor='source'>Source:</label>
            <select
              className='custom-select'
              id='source'
              onChange={(e) => setSource(e.target.value)}
              value={source}
            >
              <option value=''>Select Source</option>
              {airports.map((airport) => (
                <option key={airport.code} value={airport.code}>
                  {airport.name}
                </option>
              ))}
            </select>
          </div>

          <div className='form-group'>
            <label htmlFor='destination'>Destination:</label>
            <select
              className='custom-select'
              id='destination'
              onChange={(e) => setDestination(e.target.value)}
              value={destination}
            >
              <option value=''>Select Destination</option>
              {airports.map((airport) => (
                <option key={airport.code} value={airport.code}>
                  {airport.name}
                </option>
              ))}
            </select>
          </div>

          <h2>User Details</h2>
          <div className='user-details'>
            <div>
              <label htmlFor='firstname'>First Name:</label>
              <input
                type='text'
                id='firstname'
                className='custom-input'
                value={userDetails.firstname}
                onChange={(e) => setUserDetails({ ...userDetails, firstname: e.target.value })}
              />
            </div>
            <div>
              <label htmlFor='lastname'>Last Name:</label>
              <input
                type='text'
                id='lastname'
                className='custom-input'
                value={userDetails.lastname}
                onChange={(e) => setUserDetails({ ...userDetails, lastname: e.target.value })}
              />
            </div>
            <div>
              <label htmlFor='email'>Email:</label>
              <input
                type='email'
                id='email'
                className='custom-input'
                value={userDetails.email}
                onChange={(e) => setUserDetails({ ...userDetails, email: e.target.value })}
              />
            </div>
            <div>
              <label htmlFor='age'>Age:</label>
              <input
                type='text'
                id='age'
                className='custom-input'
                value={userDetails.age}
                onChange={(e) => setUserDetails({ ...userDetails, age: e.target.value })}
              />
            </div>
            <div>
              <label htmlFor='phonenumber'>Phone Number:</label>
              <input
                type='text'
                id='phonenumber'
                className='custom-input'
                value={userDetails.phonenumber}
                onChange={(e) => setUserDetails({ ...userDetails, phonenumber: e.target.value })}
              />
            </div>
            <div>
              <label htmlFor='address'>Address:</label>
              <input
                type='text'
                id='address'
                className='custom-input'
                value={userDetails.address}
                onChange={(e) => setUserDetails({ ...userDetails, address: e.target.value })}
              />
            </div>
          </div>

          <div className='form-group'>
            <label htmlFor='classSeating'>Class Seating:</label>
            <select
              className='custom-select'
              id='classSeating'
              onChange={(e) => setClassSeating(e.target.value)}
              value={classSeating}
            >
              <option value=''>Select Class</option>
              <option value='Economy'>Economy</option>
              <option value='Business'>Business</option>
              <option value='First_Class'>First Class</option>
              <option value='Second_Class'>Second Class</option>
            </select>
          </div>

          <div className='form-group'>
            <label htmlFor='date'>Date:</label>
            <input
              type='date'
              className='custom-input'
              id='date'
              value={date}
              onChange={(e) => setDate(e.target.value)}
            />
          </div>

          <div className='form-group'>
            <label htmlFor='time'>Time:</label>
            <input
              type='time'
              className='custom-input'
              id='time'
              value={time}
              onChange={(e) => setTime(e.target.value)}
            />
          </div>

          <div className='form-group'>
            <button
              type='button'
              className='custom-button'
              onClick={calculatePrice}
            >
              Calculate Price
            </button>
          </div>
        </form>

        {price > 0 && (
          <div>
            <h2>Price: ${price}</h2>
          </div>
        )}

        <h2>Flight Details</h2>
        <div>
          {flights.map((flight) => (
            <div key={flight.id}>
              <input
                type='radio'
                id={flight.id}
                name='selectedFlight'
                value={flight.id}
                onChange={() => handleFlightSelection(flight)}
              />
              <label htmlFor={flight.id}>
                {flight.airline} - Flight ID: {flight.id}
              </label>
            </div>
          ))}
        </div>

        {selectedFlight && (
          <div className='selected-flight'>
            <h3>Selected Flight Details</h3>
            <p>Flight ID: {selectedFlight.id}</p>
            <p>Airline: {selectedFlight.airline}</p>
            <p>Duration: {selectedFlight.duration}</p>
            <p>Arrival: {selectedFlight.arrival}</p>
            <p>Departure: {selectedFlight.departure}</p>
            <p>Price: ${selectedFlight.price}</p>
            <p>Available Seats: {selectedFlight.availability}</p>
          </div>
        )}

        <h2>Passenger Details</h2>
        {passengers.map((passenger, index) => (
          <div className='passenger-container' key={index}>
            <h3>Passenger {index + 1}</h3>
            <div className='passenger-details'>
              <div>
                <label htmlFor={`name-${index}`}>Name:</label>
                <input
                  type='text'
                  id={`name-${index}`}
                  className='custom-input'
                  value={passenger.name}
                  onChange={(e) => handlePassengerChange(e, 'name', index)}
                />
              </div>
              <div>
                <label htmlFor={`age-${index}`}>Age:</label>
                <input
                  type='text'
                  id={`age-${index}`}
                  className='custom-input'
                  value={passenger.age}
                  onChange={(e) => handlePassengerChange(e, 'age', index)}
                />
              </div>
              <div>
                <label htmlFor={`gender-${index}`}>Gender:</label>
                <input
                  type='text'
                  id={`gender-${index}`}
                  className='custom-input'
                  value={passenger.gender}
                  onChange={(e) => handlePassengerChange(e, 'gender', index)}
                />
              </div>
              <div>
                <label htmlFor={`seat-${index}`}>Seat:</label>
                <input
                  type='text'
                  id={`seat-${index}`}
                  className='custom-input'
                  value={passenger.seat}
                  readOnly
                />
              </div>
            </div>
          </div>
        ))}

        <div className='button-container'>
          <button type='button' className='custom-button' onClick={addPassenger}>
            Add Passenger
          </button>
          {passengers.length > 1 && (
            <button
              type='button'
              className='custom-button'
              onClick={removePassenger}
            >
              Remove Passenger
            </button>
          )}
        </div>

        <div className='button-container'>
          <button
            type='button'
            className='custom-button'
            onClick={handleSubmit}
          >
            Submit Booking
          </button>
        </div>
      </div>
    </div>
  );
};
export default FlightBookingForm;
