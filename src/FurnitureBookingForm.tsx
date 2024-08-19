import React, { useState } from 'react';
import './FurnitureBookingForm.css';
import furniturebooking from "./assets/furnitureform.png";
import {Link} from "react-router-dom";

const FurnitureBookingForm: React.FC = () => {
    const [showPopup, setShowPopup] = useState(false);

    const handleSubmit = (event: React.FormEvent) => {
        event.preventDefault();
        // Add your form submission logic here
        setShowPopup(true);
    };

    const handleClosePopup = () => {
        setShowPopup(false);
    };

    return (
        <div className="furniturebooking-body" style={{ background: `url(${furniturebooking})no-repeat center center/cover` }}>
            <div className="furniturebooking-main">
                <h2>Book Your Furniture Today!</h2>
                <form id="furnitureBookingForm" onSubmit={handleSubmit}>
                    <label htmlFor="pickup">Pickup</label>
                    <input type="datetime-local" id="pickup" name="pickup" />

                    <label htmlFor="dropoff">Drop off</label>
                    <input type="datetime-local" id="dropoff" name="dropoff" required />

                    <label htmlFor="name">Your name</label>
                    <input type="text" id="name" name="name" required />

                    <label htmlFor="phone">Phone number</label>
                    <input type="tel" id="phone" name="phone" required />

                    <label htmlFor="email">Email address</label>
                    <input type="email" id="email" name="email" required />

                    <div className="furniturebooking-policy">
                        <Link to='/contract' target="-blank"><h4>Before Booking Read Our Terms And Conditions</h4></Link>
                    </div>

                    <div className="furniturebooking-checkbox-container">
                        <input type="checkbox" id="terms" name="terms" />
                        <label htmlFor="terms">I have read all terms & conditions</label>
                    </div>

                    <button type="submit" id="furniturebooking-confirmBookingButton">CONFIRM CAR BOOKING</button>
                </form>
            </div>

            {showPopup && (
                <div id="furniturebooking-popup" className="furniturebooking-popup">
                    <div className="furniturebooking-popup-content">
                        <span className="furniturebooking-close-btn" onClick={handleClosePopup}>&times;</span>
                        <p>Booking Successful!</p>
                    </div>
                </div>
            )}
        </div>
    );
};

export default FurnitureBookingForm;
