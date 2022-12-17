package com.example.servingwebcontent;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Controller
public class SentimentController {

	@Value("${language.service.key}")
    private String langKey;

    @Value("${language.service.endpoint}")
    private String langEndpoint;


	@GetMapping("/sentiment")
	public String sentiment(Model model) {
		model.addAttribute("analysisModel", new AnalysisModel());
		return "sentiment";
	}

	@PostMapping("/sentiment")
	public String greetingSubmit(@ModelAttribute AnalysisModel analysisModel, Model model) {

		AnalyzeSentiment sentimentAnalysis = new AnalyzeSentiment();
        List<SentimentModel> results = sentimentAnalysis.GetSentiment(analysisModel.getContent(), langKey, langEndpoint);
		analysisModel.setResults(results);
		model.addAttribute("analysisModel", analysisModel);
		return "sentiment";
	}


	
}
