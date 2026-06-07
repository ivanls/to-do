import { useState } from "react";

function Frontend() {
  const [todos, setTodos] = useState([]);

  const cargarTodos = async () => {
    const response = await fetch("http://localhost:8080/api/todos");
    const data = await response.json();
    setTodos(data);
  };

  return (
    <div>
      <button onClick={cargarTodos}>
        Cargar todos
      </button>

      <ul>
        {todos.map(todo => (
          <li key={todo.id}>
            {todo.titulo || todo.title} 
          </li>
        ))}
      </ul>
    </div>
  );
}

export default Frontend;