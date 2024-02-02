import React, { useState, useEffect } from 'react';
import '../views/ExerciseList.css';

const ExerciseList = () => {
    const [exercises, setExercises] = useState([]);

    useEffect(() => {

        let apiUrl = 'http://localhost:8080/exercises';

        fetch(apiUrl)
            .then(response => response.json())
            .then(data => setExercises(data))
            .catch(error => console.error('Error fetching exercises:', error));
    }, []);

    return (
        <div>
            <h2>Exercise List:</h2>
            <table>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Exercise Name</th>
                    <th>Exercise Type</th>
                    <th>Equipment Required</th>
                    <th>Start Time</th>
                    <th>End Time</th>
                    <th>Calories Burned</th>
                    <th>Sets</th>
                    <th>Reps</th>
                    <th>Distance (km)</th>
                    <th>Weight (kg)</th>
                    <th>Description</th>
                </tr>
                </thead>
                <tbody>
                {exercises.map(exercise => (
                    <tr key={exercise.id}>
                        <td>{exercise.id}</td>
                        <td>{exercise.exerciseName}</td>
                        <td>{exercise.exerciseType}</td>
                        <td>{exercise.equipmentRequired}</td>
                        <td>{exercise.startTime}</td>
                        <td>{exercise.endTime}</td>
                        <td>{exercise.caloriesBurned}</td>
                        <td>{exercise.reps}</td>
                        <td>{exercise.sets}</td>
                        <td>{exercise.distanceInKm}</td>
                        <td>{exercise.weightInKg}</td>
                        <td>{exercise.description}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};

export default ExerciseList;
