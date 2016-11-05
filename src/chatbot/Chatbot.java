package chatbot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author K.T. Tafari
 */
public class Chatbot {

    private boolean running = false;
    private String query = null;
    private Responder responder;
    private BufferedReader reader;
    private Analyzer analyzer;
    private String sentence;

    public static void main(String[] args) {

        Chatbot chatbot = new Chatbot();
        chatbot.analyzer = new Analyzer();
        chatbot.responder = new Responder();
        chatbot.reader = new BufferedReader(new InputStreamReader(System.in));
        chatbot.start();
        while (chatbot.isRunning()) {
            chatbot.parse();
        }
    }

    private void parse() {
        try {
            query = reader.readLine();
            query = query.toLowerCase();
        } catch (IOException ex) {
            Logger.getLogger(Chatbot.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //handles analytics
        if(query.startsWith("analyze")){
        sentence = "The length of this string is :" + analyzer.getWordCount("")+" units long";
        System.out.println(responder.getStatement(sentence));
        return;
        }
        
        //if statement dealing with exits
        if (query.equals("exit")) {
            exit();
            running = false;
            return;
        }

        //dealing with commands
        if(query.startsWith("count")){
            System.out.println(analyzer.getSize(query));
            return ;
        }

        if (query.startsWith("word count")){
            System.out.println(analyzer.getWordCount(query));
            return;
        }

        //handle questions
        if (query.startsWith("are")) {
            System.out.println(responder.getResponseToQuestion(query));
        }
        if (query.startsWith("can")) {
            System.out.println(responder.getResponseToQuestion(query));
        }
        if (query.startsWith("do you")) {
            System.out.println(responder.getResponseToQuestion(query));
        }

        //if statement dealing with goodbyes
        if (query.contains("goodbye")) {
            System.out.println(responder.getFarewell());
        } //if statement dealing with greetings
        else if (query.contains("hello")) {
            System.out.println(responder.getGreeting());
        } //if statement dealing with naming
        else if (query.contains("whats your name")) {
            System.out.println(responder.getIdentity());
        } //if statement dealing with feelings
        else if (query.contains("how are you")) {
            System.out.println(responder.getFeeling());
        } else {
            System.out.println(responder.formNewSentenceWith(query));
        }
    }

    private static void exit() {
        System.out.println("User has chosen to exit program.");
    }

    private boolean isRunning() {
        return running;
    }

    private void start() {
        System.out.println("System Starting....  \nChatbot Alpha V1 Online \nPlease Enter a Command");
        running = true;
    }

}
