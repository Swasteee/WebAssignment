import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './FurnitureList.css'; // Create and style this CSS file accordingly
import AddFurnitureModal from './AddFurniture'; // Adjust the path according to your file structure
import EditFurnitureModal from './EditFurniture'; // Adjust the path according to your file structure

interface Furniture {
    id: number;
    FurnitureBrand: string;
    seat: number;
    price: string;
    FurnitureImage: string; // Base64 encoded image string
}

const FurnitureList: React.FC = () => {
    const [isAddModalOpen, setIsAddModalOpen] = useState(false);
    const [isEditModalOpen, setIsEditModalOpen] = useState(false);
    const [selectedFurnitureIndex, setSelectedFurnitureIndex] = useState<number | null>(null);
    const [Furnitures, setFurnitures] = useState<Furniture[]>([]);

    useEffect(() => {
        const fetchFurnitures = async () => {
            try {
                const response = await axios.get('http://localhost:8080/Furnitures/addlist');
                setFurnitures(response.data);
            } catch (error) {
                console.error('Error fetching Furnitures:', error);
            }
        };

        fetchFurnitures();
    }, []);

    const openAddModal = () => setIsAddModalOpen(true);
    const closeAddModal = () => setIsAddModalOpen(false);
    const openEditModal = (index: number) => {
        setSelectedFurnitureIndex(index);
        setIsEditModalOpen(true);
    };
    const closeEditModal = () => setIsEditModalOpen(false);

    const handleEditSave = (updatedFurniture: Furniture) => {
        if (selectedFurnitureIndex !== null) {
            const updatedFurnitures = [...Furnitures];
            updatedFurnitures[selectedFurnitureIndex] = updatedFurniture;
            setFurnitures(updatedFurnitures);
        }
    };

    const handleDelete = async (index: number) => {
        const FurnitureToDelete = Furnitures[index];
        try {
            await axios.delete(`http://localhost:8080/Furnitures/addlist/${FurnitureToDelete.id}`);
            const updatedFurnitures = Furnitures.filter((_, i) => i !== index);
            setFurnitures(updatedFurnitures);
        } catch (error) {
            console.error('Error deleting Furniture:', error);
        }
    };

    return (
        <div className="Furniture-list-container">
            <button className="add-Furniture-button" onClick={openAddModal}>Add Furniture</button>
            <table className="Furniture-list-table">
                <thead>
                <tr>
                    <th>Furniture ID</th>
                    <th>Furniture Image</th>
                    <th>Furniture Brand</th>
                    <th>Seat</th>
                    <th>Price</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                {Furnitures.map((Furniture, index) => (
                    <tr key={Furniture.id}>
                        <td>{Furniture.id}</td>
                        <td>
                            <img src={`data:image/jpeg;base64,${Furniture.FurnitureImage}`} alt={`Furniture ${index}`} className="Furniture-image" />
                        </td>
                        <td>{Furniture.FurnitureBrand}</td>
                        <td>{Furniture.seat}</td>
                        <td>{Furniture.price}</td>
                        <td>
                            <button className="action-button edit-button" onClick={() => openEditModal(index)}>Edit</button>
                            <button className="action-button delete-button" onClick={() => handleDelete(index)}>Delete</button>
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>
            <AddFurnitureModal isOpen={isAddModalOpen} onClose={closeAddModal} />
            {selectedFurnitureIndex !== null && (
                <EditFurnitureModal
                    isOpen={isEditModalOpen}
                    onClose={closeEditModal}
                    Furniture={Furnitures[selectedFurnitureIndex]}
                    onSave={handleEditSave}
                />
            )}
        </div>
    );
};

export default FurnitureList;