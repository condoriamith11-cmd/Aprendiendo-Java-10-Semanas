package com.organizacion.app.views;

import com.organizacion.app.modelo.Contacto;
import com.organizacion.app.ui.MainLayout;
import com.organizacion.app.service.ContactoService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.Route;

@Route(value = "contactos", layout = MainLayout.class)
public class ContactosView extends VerticalLayout {

    private final ContactoService servicio;
    private TextField campoNombre = new TextField("Nombre completo");
    private EmailField campoEmail = new EmailField("Correo electronico");
    private NumberField campoTelef = new NumberField("Teledono");
    private Binder<Contacto> binder = new Binder<>(Contacto.class);
    public ContactosView (ContactoService servicio){
        this.servicio = servicio;

        campoNombre.setPlaceholder("Ej: Ana Quispe");
        campoEmail.setPlaceholder("ej: ana@correo.com");
        campoTelef.setPlaceholder("Ej: 71234567");
        campoNombre.setWidthFull();
        campoEmail.setWidthFull();
        campoTelef.setWidthFull();

        configurarBinder();

        FormLayout formulario = new FormLayout();
        formulario.add(campoNombre, campoEmail, campoTelef);
        formulario.setColspan(campoNombre, 2);
        formulario.setWidthFull();

        Button btnGuardar = new Button("Guardar contacto");
        Button btnLimpiar = new Button("Limpiar");

        btnGuardar.addClickListener(e -> guardar());
        btnLimpiar.addClickListener(e -> limpiar());

        HorizontalLayout botones = new HorizontalLayout(btnGuardar, btnLimpiar);
        add(formulario, botones);
        setWidthFull();
    }

    private void configurarBinder(){
        binder.forField(campoNombre).asRequired("El nombre on puede estar vacio").bind(Contacto::getNombre, Contacto::setNombre);
        binder.forField(campoEmail).bind(Contacto::getEmail, Contacto::setEmail);
        binder.forField(campoTelef).whithConverter(v -> v == null ? "" : String.valueOf(v.intValue()), t->t == null || t.isEmpty() ? null : Double.valueOf(t)).bind(Contacto::getTelefono, Contacto:: setTelefono);
    }
    private void guardar(){
        Contacto contacto = new Contacto();
        try{
            binder.writeBean(Contacto);
            servicio.guardar(contacto);
            Notificacion.show("Guardado: " + contacto.getNombre());
            limpiar();
        } catch (ValidationException e){
            // Binder marca los campos con error automaticamente
        }
    }
    private void limpiar(){
        binder.readBean(new Contacto());
    }
}
