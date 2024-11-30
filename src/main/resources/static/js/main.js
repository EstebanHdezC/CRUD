// URL base de la API
const API_URL = "http://localhost:8080/api/v1/profes";

// Cargar lista de profesores al inicio
document.addEventListener("DOMContentLoaded", fetchProfes);

// Referencias al formulario y la tabla
const profesorForm = document.getElementById("profesor-form");
const profesTable = document.getElementById("profes-table").getElementsByTagName("tbody")[0];

// Evento para guardar un nuevo profesor o actualizar uno existente
profesorForm.addEventListener("submit", async (event) => {
    event.preventDefault(); // Evitar recargar la página

    const formData = new FormData(profesorForm);
    const profesor = {
        firstName: formData.get("firstName"),
        lastName: formData.get("lastName"),
        email: formData.get("email"),
    };

    const profeId = formData.get("profeId");  // Obtener el profeId del formulario (campo oculto)

    let response;

    if (profeId) {
        // Si profeId existe, es una actualización
        profesor.profeId = profeId;
        response = await fetch(`${API_URL}/${profeId}`, {
            method: "PUT", // Usamos PUT para actualización
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(profesor),
        });
    } else {
        // Crear un nuevo profesor
        response = await fetch(API_URL, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(profesor),
        });
    }

    if (response.ok) {
        alert(profeId ? "Profesor actualizado correctamente" : "Profesor registrado exitosamente");
        profesorForm.reset(); // Limpiar formulario
        fetchProfes(); // Actualizar la lista
        document.getElementById("form-title").textContent = "Registrar Profesor";
        document.querySelector("button[type='submit']").textContent = "Guardar";
    } else {
        alert("Error al registrar o actualizar el profesor");
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
                <button onclick="editProfe(${profe.profeId})">Editar</button>
                <button onclick="deleteProfe(${profe.profeId})">Eliminar</button>
            </td>
        `;
    });
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
async function editProfe(profeId) {
    // Obtener los datos del profesor a editar
    const response = await fetch(`${API_URL}/${profeId}`);
    if (!response.ok) {
        alert("Error al cargar los datos del profesor");
        return;
    }

    const profe = await response.json();

    // Rellenar el formulario con los datos del profesor
    document.getElementById("firstName").value = profe.firstName;
    document.getElementById("lastName").value = profe.lastName;
    document.getElementById("email").value = profe.email;
    document.getElementById("profeId").value = profe.profeId; // Establecer el profeId en el campo oculto

    // Cambiar el comportamiento del formulario para actualizar
    document.getElementById("form-title").textContent = "Actualizar Profesor";
    const submitButton = document.querySelector("button[type='submit']");
    submitButton.textContent = "Actualizar";
}
