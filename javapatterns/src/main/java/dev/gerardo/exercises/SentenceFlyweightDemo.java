package dev.gerardo.exercises;

import java.util.*;
import java.util.stream.Collectors;

class Sentence
{

  private List<WordToken> words;

  public Sentence(String plainText)
  {
    List<String> splitWords = List.of(plainText.split(" "));
    words = splitWords.stream().map(word -> new WordToken(word)).collect(Collectors.toList());
  }

  public WordToken getWord(int index)
  {
    return words.get(index);
  }

  @Override
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    
    for (WordToken wordToken : words) 
    {
      if (wordToken.capitalize) 
      {
        sb.append(wordToken.word.toUpperCase());
      } else 
      {
        sb.append(wordToken.word.toLowerCase());
      }

      sb.append(" ");
    }

    return sb.toString().trim();
  }

  class WordToken
  {
    public boolean capitalize;
    private String word;

    public WordToken(String word) {
      this.word = word;
    }
  }
}

public class SentenceFlyweightDemo {
  public static void main(String[] args) {
    Sentence sentence = new Sentence("hello world");
    sentence.getWord(1).capitalize = true;
    System.out.println(sentence);
  }
}
