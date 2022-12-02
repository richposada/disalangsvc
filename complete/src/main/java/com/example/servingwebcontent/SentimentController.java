package com.example.servingwebcontent;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SentimentController {

	@GetMapping("/sentiment")
	public String sentiment(Model model) {
		model.addAttribute("analysisModel", new AnalysisModel());
		return "sentiment";
	}

	@PostMapping("/sentiment")
	public String greetingSubmit(@ModelAttribute AnalysisModel analysisModel, Model model) {

		AnalyzeSentiment sentimentAnalysis = new AnalyzeSentiment();
        List<SentimentModel> results = sentimentAnalysis.GetSentiment(analysisModel.getContent());
		analysisModel.setResults(results);
		model.addAttribute("analysisModel", analysisModel);
		return "sentiment";
	}


	
}
