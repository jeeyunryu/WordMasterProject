package org.example;

public class WordSpec {

    private String meaning;
    private String word;
    private String level;

    public WordSpec(String level, String word, String meaning) {
        this.level = level;
        this.word = word;
        this.meaning = meaning;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }



    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }



    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }


}
