package com.thanglv.hronline.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;

@Named("commandButtonView")
@RequestScoped
public class CommandButtonView implements Serializable {

    private Logger logger = LogManager.getLogger();

    public void action() throws InterruptedException {
        Thread.sleep(5000);
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Xin trân trọng thông báo", "Cái địt con mẹ bạn luôn");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
