package com.example.servingwebcontent;

//import com.azure.ai.textanalytics.models.TextSentiment;

public class SentimentModel{
    private Integer rowId;
    private String sentiment;
    private Double positiveScore;
    private Double neutralScore;
    private Double negativeScore;

    public Integer getRowId(){
        return rowId;
    }
    public void setRowId(Integer i){
        this.rowId = i;
    }

    public String getSentiment() {
        return sentiment.toUpperCase();
      }
    
      
    public void setSentiment(String sentiment) {
        this.sentiment = sentiment;
        }

    public Double getPositiveScore() {
        return positiveScore;
        }
    
    public void setPositiveScore(Double positiveScore) {
        this.positiveScore = positiveScore;
        }


    public Double getNeutralScore() {
        return neutralScore;
        }
    
    public void setNeutralScore(Double neutralScore) {
        this.neutralScore = neutralScore;
        }


    public Double getNegativeScore() {
        return negativeScore;
        }
    
    public void setNegativeScore(Double negativeScore) {
        this.negativeScore = negativeScore;
        }
    
}