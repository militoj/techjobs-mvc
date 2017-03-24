package org.launchcode.controllers;

import org.launchcode.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", ListController.columnChoices);
        return "search";
    }

    @RequestMapping(value = "results")
    public String search(Model model, String searchType, String searchTerm) {
        if (searchType.equals("All")) {
            ArrayList<HashMap<String, String>> allJobs = JobData.findAll();

            model.addAttribute("jobs", allJobs);

        } else {
            ArrayList<HashMap<String, String>> allJobs = JobData.findByColumnAndValue(searchType, searchTerm);

            model.addAttribute("jobs", allJobs);

        }
        model.addAttribute("columns", ListController.columnChoices);
        return "search";

    }

    // TODO #1 - Create handler to process search request and display results

}
