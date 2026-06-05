package com.organizacion.app.ui;

import com.organizacion.app.views.ContactosView;
import com.organizacion.app.views.InicioView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.RouterLink;

public class MainLayout extends AppLayout{
    public MainLayout(){
        H2 titulo = new H2("Mi Aplicacion");
        MenuBar menu = new MenuBar();
        menu.addItem(new RouterLink("Inicio", InicioView.class));
        menu.addItem(new RouterLink("Contactos", ContactosView.class));

        HorizontalLayout barra = new HorizontalLayout(titulo, menu);
        barra.setWidthFull();
        barra.expand(titulo);
        barra.setAlignItems(com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER);

        addToNavbar(barra);
    }
}
