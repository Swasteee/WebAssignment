import React from 'react';
import './FurnitureCard.css'; // Ensure you create and style this CSS file accordingly

interface FurnitureCardProps {
    furniture: {
        id: number;
        furnitureBrand: string;
        seat: number;
        price: string;
        furnitureImage: string;
        isBooked: boolean;
        rentalEndDateTime: string;
    };
    onBook: (furnitureId: number) => void; // Ensure this is typed correctly
}

const FurnitureCard: React.FC<FurnitureCardProps> = ({ furniture, onBook }) => {
    return (
        <div className="furniture-Card">
            <img src={furniture.furnitureImage} alt={`${furniture.furnitureBrand} image`} className="furniture-image" />
            <h2>{furniture.furnitureBrand}</h2>
            
            <p>Price: {furniture.price}</p>
            <p>Status: {furniture.isBooked ? 'Booked' : 'Available'}</p>
            <p>Rental End: {furniture.rentalEndDateTime}</p>
            <button onClick={() => onBook(furniture.id)} disabled={furniture.isBooked}>
                {furniture.isBooked ? 'Booked' : 'Book Now'}
            </button>
        </div>
    );
};

export default FurnitureCard;
