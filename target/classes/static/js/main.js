// URL base de la API
const API_URL = "http://localhost:8080/api/v1/profes";
// Cargar lista de profesores al inicio
document.addEventListener("DOMContentLoaded", fetchProfes);

// Referencias al formulario y la tabla
const profesorForm = document.getElementById("profesor-form");
const profesTable = document.getElementById("profes-table").getElementsByTagName("tbody")[0];

// Evento para guardar un nuevo profesor
profesorForm.addEventListener("submit", async (event) => {
    event.preventDefault(); // Evitar recargar la página

    const formData = new FormData(profesorForm);
    const profesor = {
        firstName: formData.get("firstName"),
        lastName: formData.get("lastName"),
        email: formData.get("email"),
    };

    // Guardar en el backend
    const response = await fetch(API_URL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(profesor),
    });

    if (response.ok) {
        alert("Profesor registrado exitosamente");
        profesorForm.reset(); // Limpiar formulario
        fetchProfes(); // Actualizar la lista
    } else {
        alert("Error al registrar el profesor");
    }
});

// Obtener y mostrar la lista de profesores
async function fetchProfes() {
    const response = await fetch(API_URL);
    const profes = await response.json();

    // Limpiar tabla
    profesTable.innerHTML = "";

    // Insertar filas dinámicamente
    profes.forEach((profe) => {
        const row = profesTable.insertRow();
        row.innerHTML = `
            <td>${profe.profeId}</td>
            <td>${profe.firstName}</td>
            <td>${profe.lastName}</td>
            <td>${profe.email}</td>
            <td>
                <button onclick="deleteProfe(${profe.profeId})">Eliminar</button>
            </td>
        `;
    });
}
// Eliminar un profesor
async function deleteProfe(profeId) {
    const confirmDelete = confirm("¿Seguro que deseas eliminar este profesor?");
    console.log(profeId)
    if (!confirmDelete) return;

    const response = await fetch(`${API_URL}/${profeId}`, {
        method: "DELETE",
    });

    if (response.ok) {
        alert("Profesor eliminado exitosamente");
        fetchProfes(); // Actualizar la lista
    } else {
        alert("Error al eliminar el profesor");
    }
}
