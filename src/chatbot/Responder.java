/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbot;

/**
 *
 * @author K.T. Tafari
 */
public class Responder {

    String getGreeting() {

        return ("Hello I am Chatbot");

    }

    String getFarewell() {
        return ("Goodbye.");
    }

    String formNewSentenceWith(String s) {

        return "That's Interesting, I'm Sure. But I don't know about " + '"' + s + '"';
    }

    String getIdentity() {

        return "I Already told you, My Name is Chatbot";

    }

    String getFeeling() {

        return "Im feeling fine";

    }

    String getResponseToQuestion(String s) {
        return "you asked me " + '"' + s + '"';
    }

    String getStatement(String sentence) {
        return "This is what i have to say." + "\n" + sentence;
    }

}
