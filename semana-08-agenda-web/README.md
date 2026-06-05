# Semana 08 - Agenda Web con Vaadin

## Descripción

Esta aplicación web permite gestionar una agenda de contactos mediante una interfaz desarrollada con Vaadin. Incluye una vista de inicio con información general de la aplicación y una vista de contactos donde se muestran tarjetas con datos de ejemplo. La navegación entre vistas se realiza mediante una barra superior sin recargar la página. :contentReference[oaicite:0]{index=0}

## Componentes utilizados

### 1. AppLayout
Contenedor principal de la aplicación que mantiene una barra de navegación visible en todas las vistas. :contentReference[oaicite:1]{index=1}

### 2. MenuBar
Componente utilizado para mostrar las opciones de navegación entre las vistas Inicio y Contactos. :contentReference[oaicite:2]{index=2}

### 3. RouterLink
Permite cambiar de vista mediante enlaces sin recargar la aplicación web. :contentReference[oaicite:3]{index=3}

### 4. Avatar
Muestra las iniciales de cada contacto dentro de las tarjetas de información. :contentReference[oaicite:4]{index=4}

### 5. VaadinIcon
Se utiliza para representar visualmente el teléfono y correo electrónico de cada contacto. :contentReference[oaicite:5]{index=5}

### 6. Div
Componente contenedor utilizado para construir la clase reutilizable `TarjetaContacto`. :contentReference[oaicite:6]{index=6}

## Cómo ejecutar la aplicacion

### 1. Ejecutar la aplicación

```bash
mvn spring-boot:run
```

### 2. Abrir en el navegador

```text
http://localhost:8080
```

## Captura de pantalla

### Vista Principal

![Vista Principal](capturas/Agenda.1.png)

### Vista de Contactos

![Vista de Contactos](capturas/Agenda.2.png)

### Navegacion Inicio y Contactos

![Inicio y Contactos](capturas/Agenda.3.png)

### Pie de pagina

![Pie de pagina](capturas/Agenda.4.png)
