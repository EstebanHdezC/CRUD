// URL base de la API
const API_URL = "http://localhost:8080/api/v1/profes";

// Cargar lista de profesores al inicio
document.addEventListener("DOMContentLoaded", fetchProfes);

// Referencias al formulario y la tabla
const profesorForm = document.getElementById("profesor-form");
const profesTable = document.getElementById("profes-table").getElementsByTagName("tbody")[0];

// Obtener y mostrar la lista de profesores
async function fetchProfes() {
    try {
        const response = await fetch(API_URL);
        const profes = await response.json();

        // Verifica si la respuesta contiene datos
        if (profes.length === 0) {
            console.log("No hay datos disponibles.");
            return;
        }

        // Limpiar la tabla
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
                    <button onclick="editProfe(${profe.profeId})">Editar</button>
                    <button onclick="deleteProfe(${profe.profeId})">Eliminar</button>
                </td>
            `;
        });

        // Inicializar DataTable después de insertar los datos
        $('#profes-table').DataTable({
            "paging": true,  // Habilitar paginación
            "searching": true,  // Habilitar búsqueda
            "ordering": true,  // Habilitar ordenación de columnas
        });

    } catch (error) {
        console.error("Error al obtener los profesores:", error);
    }
}

// Eliminar un profesor
async function deleteProfe(profeId) {
    const confirmDelete = confirm("¿Seguro que deseas eliminar este profesor?");
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

// Editar un profesor
function editProfe(profeId) {
    // Puedes llenar el formulario con los datos del profesor a editar aquí
    alert(`Editar profesor con ID: ${profeId}`);
}
