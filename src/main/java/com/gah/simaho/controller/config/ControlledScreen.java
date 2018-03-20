package com.gah.simaho.controller.config;

import org.springframework.stereotype.Controller;

@Controller
public interface ControlledScreen {

    void setScreenParent(ScreensController screenPage);
}
