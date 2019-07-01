package fr.armand.models;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Dictionary {

    List<String> dico = new ArrayList<String>();
    List<String> dicoParsed = new ArrayList<String>();


    public Dictionary() {
        String fichier = "fichiers/liste_francais.txt";
        java.net.URL fileURL = Dictionary.class.getClassLoader().getResource(fichier);

        try {
            InputStream fis = new FileInputStream(fileURL.getFile());
            InputStreamReader isr = new InputStreamReader(fis,"utf-8");
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                dico.add(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier");
            e.printStackTrace();
        }
    }

    public void getWords(List<String> dico){
        dico.forEach(System.out::println);
    }

    /**
     * Liste les mots de la taile de parSize
     * @param parSize
     * @return
     */
    public List<String> searchByLenght(int parSize){
        for (String data : dico) {
            if(data.length() == parSize) {
                dicoParsed.add((data));
            }
        }
        dicoParsed.forEach(System.out::println);
        return dicoParsed;
    }

    /**
     * Liste les mots commencant par parLetter
     * @param parLetter
     * @return
     */
    public List<String> searchByChar(String parLetter){
        for (String data : dico) {
            if(data.startsWith(parLetter)) {
                dicoParsed.add((data));
            }
        }
        dicoParsed.forEach(System.out::println);
        return dicoParsed;
    }

    /**
     * Liste les mots contenant un mot d'une taille donnée, contentant une lettre donnée à un index donné
     * @param parWord
     * @return
     */
    public List<String> searchByMatches(String parWord){

        for (String data : dico) {
            if(data.matches(parWord.toLowerCase())){
                dicoParsed.add(data);
            }
        }
        dicoParsed.forEach(System.out::println);
        return  dicoParsed;
    }
}
