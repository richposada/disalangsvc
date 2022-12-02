package com.example.servingwebcontent;

import java.util.ArrayList;
import java.util.List;

public class AnalysisModel {

    private String content;
    //private String results;
    List<SentimentModel> results = new ArrayList<SentimentModel>();
  
    public String getContent() {
      return content;
    }
  
    public void setContent(String content) {
      this.content = content;
    }

    public List<SentimentModel> getResults() {
        return results;
      }
    
      public void setResults(List<SentimentModel> results) {
        this.results = results;
      }
    
}


