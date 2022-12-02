// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.example.servingwebcontent;


import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import com.azure.ai.textanalytics.models.DocumentSentiment;
import com.azure.ai.textanalytics.models.SentimentConfidenceScores;
import com.azure.core.credential.AzureKeyCredential;




import com.azure.ai.textanalytics.*;

/**
 * Sample demonstrates how to analyze the sentiment of document.
 */
@Configuration
public class AnalyzeSentiment {
    Integer i = 1;
    
    public List<SentimentModel> GetSentiment(String textToAnalyze) {
        

        // Instantiate a client that will be used to call the service.
        TextAnalyticsClient client = new TextAnalyticsClientBuilder()
                                        .credential(new AzureKeyCredential("a68f27cd48eb4e2d9ff095f84f646828"))
                                        .endpoint("https://langdemo.cognitiveservices.azure.us/")
                                        .buildClient();

        final DocumentSentiment documentSentiment = client.analyzeSentiment(textToAnalyze);
        SentimentConfidenceScores scores = documentSentiment.getConfidenceScores();

        List<SentimentModel> results = new ArrayList<SentimentModel>();

        SentimentModel docSentiment = new SentimentModel();
        docSentiment.setRowId(0);
        docSentiment.setSentiment(documentSentiment.getSentiment().toString());
        docSentiment.setPositiveScore(scores.getPositive());
        docSentiment.setNeutralScore(scores.getNeutral());
        docSentiment.setNegativeScore(scores.getNegative());
        results.add(docSentiment);


        //results.add(String.format("Document Sentiment: %s | Positive Score: %f | Neutral Score: %f | Negative Score: %f.%n",
            //documentSentiment.getSentiment(), scores.getPositive(), scores.getNeutral(), scores.getNegative()));

           
        documentSentiment.getSentences().forEach(sentenceSentiment -> {
            SentimentModel sentenceSentimentModel = new SentimentModel();
            SentimentConfidenceScores sentenceScores = sentenceSentiment.getConfidenceScores();

            sentenceSentimentModel.setRowId(i);
            sentenceSentimentModel.setSentiment(sentenceSentiment.getSentiment().toString());
            sentenceSentimentModel.setPositiveScore(sentenceScores.getPositive());
            sentenceSentimentModel.setNeutralScore(sentenceScores.getNeutral());
            sentenceSentimentModel.setNegativeScore(sentenceScores.getNegative());
            results.add(sentenceSentimentModel);
            i++;


            //results.add(String.format("Sentence %s Sentiment: %s | Positive Score: %f | Neutral Score: %f | Negative Score: %f.%n",
                //i.toString(), sentenceSentiment.getSentiment(), sentenceScores.getPositive(), sentenceScores.getNeutral(), sentenceScores.getNegative()));
                //i++;




                });



        return results;
    }
}