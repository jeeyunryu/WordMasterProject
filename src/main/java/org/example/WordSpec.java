package org.example;

public class WordSpec {

    private String meaning;
    private String word;
    private int level;

    public WordSpec(int level, String word, String meaning) {
        this.level = level;
        this.word = word;
        this.meaning = meaning;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
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
