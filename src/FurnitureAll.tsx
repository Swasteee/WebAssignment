import React, { useState, useEffect } from 'react';
import axios from 'axios';
import FurnitureCard from './FurnitureCard';
import './FurnitureAll.css';

interface Furniture {
    id: number;
    furnitureBrand: string;
    seat: number;
    price: string;
    furnitureImage: string;
    isBooked: boolean;
    rentalEndDateTime: string;
}

const FurnitureAll: React.FC = () => {
    const [furnitures, setFurnitures] = useState<Furniture[]>([]);
    const [error, setError] = useState<string | null>(null);

    useEffect(() => {
        const fetchFurnitures = async () => {
            try {
                const response = await axios.get('http://localhost:8080/furnitures/addlist');
                setFurnitures(response.data);
                setError(null); // Clear any previous error
            } catch (error) {
                console.error('Error fetching furnitures:', error);
                setError('Failed to fetch furniture data. Please try again later.');
            }
        };

        fetchFurnitures();
    }, []);

    const handleBook = (furnitureId: number) => {
        console.log(`Furniture ${furnitureId} booked`);
    };

    return (
        <div className="furniture-all-container">
            <h1>Furnitures Available in Kathmandu</h1>
            {error && <div className="error-message">{error}</div>}
            <div className="furniture-list">
                {furnitures.length > 0 ? (
                    furnitures.map((furniture) => (
                        <FurnitureCard key={furniture.id} furniture={furniture} onBook={handleBook} />
                    ))
                ) : (
                    <p>No furnitures available</p>
                )}
            </div>
        </div>
    );
};

export default FurnitureAll;
