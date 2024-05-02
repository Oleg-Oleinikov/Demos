package org.alohome.rates.controller;

import org.alohome.rates.APIClient;
import org.alohome.rates.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

public abstract class AbstractController {

	@Autowired
    protected Util util;

	@Autowired
    protected APIClient client;

	protected String userResponse(String returnPage, String message, String description, Model model) {
		model.addAttribute("errorMessage", message);
		model.addAttribute("errorDescription", description);
		return returnPage;
    }
}
