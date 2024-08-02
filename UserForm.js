// src/UserForm.js
import React, { useState, useEffect } from "react";
import "./UserForm.css";

const UserForm = () => {
  const [users, setUsers] = useState([]);
  const [formData, setFormData] = useState({
    username: "",
    email: "",
    password: "",
  });

  useEffect(() => {
    // Simulate fetching data from the backend
    fetch("/api/users")
      .then((response) => response.json())
      .then((data) => setUsers(data))
      .catch((error) => console.error("Error fetching users:", error));
  }, []);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value,
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    // Simulate sending data to the backend
    console.log("Submitted:", formData);
    setUsers([...users, { ...formData, created_at: new Date().toISOString() }]);
    setFormData({ username: "", email: "", password: "" });
  };

  return (
    <div className="user-form">
      <h2>Register User</h2>
      <form onSubmit={handleSubmit}>
        <label>
          Username:
          <input
            type="text"
            name="username"
            value={formData.username}
            onChange={handleChange}
            required
          />
        </label>
        <label>
          Email:
          <input
            type="email"
            name="email"
            value={formData.email}
            onChange={handleChange}
            required
          />
        </label>
        <label>
          Password:
          <input
            type="password"
            name="password"
            value={formData.password}
            onChange={handleChange}
            required
          />
        </label>
        <button type="submit">Submit</button>
      </form>
      <h3>Users List</h3>
      <ul>
        {users.map((user, index) => (
          <li key={index}>
            {user.username} ({user.email}) - Created at: {new Date(user.created_at).toLocaleString()}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default UserForm;
