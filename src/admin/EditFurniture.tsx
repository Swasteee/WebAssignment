import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './EditFurniture.css';

interface EditFurnitureModalProps {
    isOpen: boolean;
    onClose: () => void;
    furniture: { id: number; furnitureBrand: string; seat: number; price: string; furnitureImage: string } | null;
    onSave: (updatedFurniture: { id: number; furnitureBrand: string; seat: number; price: string; furnitureImage: string }) => void;
}

const EditFurnitureModal: React.FC<EditFurnitureModalProps> = ({ isOpen, onClose, furniture, onSave }) => {
    const [furnitureBrand, setFurnitureBrand] = useState('');
    const [seat, setSeats] = useState<number | ''>('');
    const [price, setPrice] = useState('');
    const [imageFile, setImageFile] = useState<File | null>(null);

    useEffect(() => {
        if (furniture) {
            setFurnitureBrand(furniture.furnitureBrand);

            setPrice(furniture.price);
        }
    }, [furniture]);

    const handleFileChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        if (e.target.files && e.target.files.length > 0) {
            const file = e.target.files[0];
            setImageFile(file);
        }
    };

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
        if (furniture) {
            try {
                const formData = new FormData();
                formData.append('furnitureBrand', furnitureBrand);

                formData.append('price', price);

                // Append the image file if it was selected
                if (imageFile) {
                    formData.append('furnitureImage', imageFile);
                }

                // Make the PUT request to update the furniture
                const response = await axios.put(`http://localhost:8080/furnitures/furniture/${furniture.id}`, formData, {
                    headers: {
                        'Content-Type': 'multipart/form-data',
                    },
                });

                console.log('Response:', response);

                // Update the furniture object and pass it back via onSave
                const updatedFurniture = {
                    ...furniture,
                    furnitureBrand,
                    seat,
                    price,
                    furnitureImage: imageFile ? URL.createObjectURL(imageFile) : furniture.furnitureImage,
                };

                // @ts-ignore
                onSave(updatedFurniture);
                onClose();
            } catch (error) {
                // @ts-ignore
                console.error('Error updating furniture:', error.response?.data || error.message);
            }
        }
    };

    if (!isOpen || !furniture) return null;

    return (
        <div className="modal-overlay">
            <div className="modal-content">
                <button className="modal-close" onClick={onClose}>×</button>
                <h2>Edit Furniture</h2>
                <form onSubmit={handleSubmit}>
                    <div className="form-group">
                        <label htmlFor="furnitureBrand">Furniture Brand:</label>
                        <input
                            type="text"
                            id="furnitureBrand"
                            value={furnitureBrand}
                            onChange={(e) => setFurnitureBrand(e.target.value)}
                            required
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="seats">Seats:</label>
                        <input
                            type="number"
                            id="seats"
                            value={seat}
                            onChange={(e) => setSeats(Number(e.target.value))}
                            required
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="price">Price:</label>
                        <input
                            type="text"
                            id="price"
                            value={price}
                            onChange={(e) => setPrice(e.target.value)}
                            required
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="image">Furniture Image:</label>
                        <input
                            type="file"
                            id="image"
                            onChange={handleFileChange}
                        />
                    </div>
                    <button type="submit" className="submit-button">Save Changes</button>
                </form>
            </div>
        </div>
    );
};

export default EditFurnitureModal;

