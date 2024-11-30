// URL base de la API
const API_URL = "http://localhost:8080/api/v1/profes";

// Cargar lista de profesores al inicio de la página
document.addEventListener("DOMContentLoaded", fetchProfes);

// Referencias al formulario y la tabla
const profesorForm = document.getElementById("profesor-form");  // Obtener el formulario de profesores
const profesTable = document.getElementById("profes-table").getElementsByTagName("tbody")[0];  // Obtener el cuerpo de la tabla para mostrar los profesores

// Evento para guardar un nuevo profesor o actualizar uno existente
profesorForm.addEventListener("submit", async (event) => {
    event.preventDefault(); // Evitar que el formulario recargue la página al enviarlo

    const formData = new FormData(profesorForm);  // Crear un FormData a partir del formulario
    const profesor = {
        firstName: formData.get("firstName"),  // Obtener el nombre
        lastName: formData.get("lastName"),    // Obtener el apellido
        email: formData.get("email"),          // Obtener el correo electrónico
    };

    const profeId = formData.get("profeId");  // Obtener el profeId del campo oculto (si es un profesor existente)

    let response;

    if (profeId) {
        // Si profeId existe, es una actualización
        profesor.profeId = profeId;
        response = await fetch(`${API_URL}/${profeId}`, {
            method: "PUT",  // Usamos PUT para actualizar el profesor
            headers: {
                "Content-Type": "application/json",  // Especificamos que el cuerpo será JSON
            },
            body: JSON.stringify(profesor),  // Convertimos el objeto profesor a JSON
        });
    } else {
        // Crear un nuevo profesor
        response = await fetch(API_URL, {
            method: "POST",  // Usamos POST para crear un nuevo profesor
            headers: {
                "Content-Type": "application/json",  // Especificamos que el cuerpo será JSON
            },
            body: JSON.stringify(profesor),  // Convertimos el objeto profesor a JSON
        });
    }

    if (response.ok) {
        alert(profeId ? "Profesor actualizado correctamente" : "Profesor registrado exitosamente");  // Mensaje dependiendo si es creación o actualización
        profesorForm.reset();  // Limpiar el formulario
        fetchProfes();  // Actualizar la lista de profesores
        document.getElementById("form-title").textContent = "Registrar Profesor";  // Restablecer el título del formulario
        document.querySelector("button[type='submit']").textContent = "Guardar";  // Restablecer el texto del botón de envío
    } else {
        alert("Error al registrar o actualizar el profesor");  // Mensaje de error si no se pudo guardar
    }
});

// Obtener y mostrar la lista de profesores
async function fetchProfes() {
    const response = await fetch(API_URL);  // Realizar una solicitud GET a la API
    const profes = await response.json();  // Convertir la respuesta JSON en un arreglo de profesores

    // Limpiar tabla antes de agregar los nuevos datos
    profesTable.innerHTML = "";

    // Insertar filas dinámicamente en la tabla
    profes.forEach((profe) => {
        const row = profesTable.insertRow();  // Crear una nueva fila en la tabla
        row.innerHTML = `
            <td>${profe.profeId}</td>  <!-- ID del profesor -->
            <td>${profe.firstName}</td>  <!-- Nombre del profesor -->
            <td>${profe.lastName}</td>   <!-- Apellido del profesor -->
            <td>${profe.email}</td>      <!-- Email del profesor -->
            <td>
                <button onclick="editProfe(${profe.profeId})">Editar</button>  <!-- Botón para editar -->
                <button onclick="deleteProfe(${profe.profeId})">Eliminar</button>  <!-- Botón para eliminar -->
            </td>
        `;
    });

    // Inicializar DataTables después de que los datos se hayan cargado
    $('#profes-table').DataTable();
}

// Eliminar un profesor
async function deleteProfe(profeId) {
    const confirmDelete = confirm("¿Seguro que deseas eliminar este profesor?");  // Confirmación para eliminar
    if (!confirmDelete) return;  // Si el usuario no confirma, no hacer nada

    const response = await fetch(`${API_URL}/${profeId}`, {
        method: "DELETE",  // Usamos DELETE para eliminar el profesor
    });

    if (response.ok) {
        alert("Profesor eliminado exitosamente");  // Mensaje de éxito
        fetchProfes();  // Actualizar la lista de profesores
    } else {
        alert("Error al eliminar el profesor");  // Mensaje de error si no se pudo eliminar
    }
}

// Editar un profesor
async function editProfe(profeId) {
    // Obtener los datos del profesor a editar
    const response = await fetch(`${API_URL}/${profeId}`);
    if (!response.ok) {
        alert("Error al cargar los datos del profesor");  // Si no se puede obtener los datos
        return;
    }

    const profe = await response.json();  // Convertir la respuesta JSON en un objeto de profesor

    // Rellenar el formulario con los datos del profesor
    document.getElementById("firstName").value = profe.firstName;  // Rellenar el nombre
    document.getElementById("lastName").value = profe.lastName;    // Rellenar el apellido
    document.getElementById("email").value = profe.email;          // Rellenar el correo electrónico
    document.getElementById("profeId").value = profe.profeId;      // Establecer el profeId en el campo oculto

    // Cambiar el comportamiento del formulario para actualización
    document.getElementById("form-title").textContent = "Actualizar Profesor";  // Cambiar el título del formulario
    const submitButton = document.querySelector("button[type='submit']");
    submitButton.textContent = "Actualizar";  // Cambiar el texto del botón de envío
}
