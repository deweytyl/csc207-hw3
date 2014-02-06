package edu.grinnell.csc207.deweytyl.utils;

import java.util.ArrayList;

public class StringUtils
{

  /******************************
   * Part A: Segmenting Strings * time: ~1h 
   ******************************/

  /**
   * splitAt
   * 
   * @param str
   * @param ch
   * @return
   */
  public static String[] splitAt(String str, char ch)
  {
    /**
     * Start each new substring with an empty string, then append what you find
     * onto it if it's not the separator. Put the last bit on when you've gone
     * through the whole thing.
     */
    ArrayList<String> splitStrings = new ArrayList<String>();
    String storageString = "";

    for (int i = 0; i < str.length(); i++)
      {
        if (str.charAt(i) != ch)
          {
            storageString += str.charAt(i);
          } // if
        else
          {
            splitStrings.add(storageString);
            storageString = ""; // Reset storageString
          } // else
      } // for

    splitStrings.add(storageString);

    String[] splitStringsArray = new String[splitStrings.size()];
    return splitStrings.toArray(splitStringsArray);
  } // splitAt(String, char)

  /****************************************
   * Part B: Segmenting Strings Revisited * time: ~2h 
   ****************************************/

  /**
   * parseElementInQuotes
   * 
   * @param str
   * @return
   */
  private static String parseElementInQuotes(String str)
  {
    String storageString = "";
    for (int i = 0; i < str.length(); i++)
      {
        if ((str.charAt(i) == '\"') && (str.charAt(i + 1) == '\"'))
          {
            storageString += '\"';
            i++;
          } // if
        else if (str.charAt(i) == '\"')
          { 
            return storageString;
          } // else if
        else
          {
            storageString += str.charAt(i);
          } // else
      } // for
    return storageString;
  } // parseElementInQuotes (String)

  /**
   * splitCSV
   * 
   * @param str
   * @return
   */
  public static String[] splitCSV(String str)
  {
    ArrayList<String> splitStrings = new ArrayList<String>();
    String storageString = "";

    for (int i = 0; i < str.length(); i++)
      {

        if (str.charAt(i) == '\"')
          {

            switch (str.charAt(i + 1))
              {
                case ',':
                  splitStrings.add(storageString);
                  storageString = ""; // Reset storageString
                  i++;
                  break;
                case '\"':
                  storageString += "\"";
                  i++;
                  break;
                default:
                  storageString = parseElementInQuotes(str.substring(i + 1));
                  i += storageString.length(); // add 3 for opening quote,
                  // closing quote and comma
                  if (str.charAt(i) == '\"')
                    i++;
                  break;
              } // switch
          } // if
        else if (str.charAt(i) != ',')
          {
            storageString += str.charAt(i);
          } // else if
        else
          {
            splitStrings.add(storageString);
            storageString = ""; // Reset storageString
          } // else
      } // for

    splitStrings.add(storageString);

    String[] splitStringsArray = new String[splitStrings.size()];
    return splitStrings.toArray(splitStringsArray);
  } // splitCSV(String)

  /*********************************
   * Part C: Isn't it De-leet-ful? * time: ~30min
   *********************************/

  /**
   * deLeet
   * 
   * @param String
   * @return
   */
  public static String deLeet(String str)
  {
    String leetStr = new String();

    for (int i = 0; i < str.length(); i++)
      {
        switch (str.charAt(i))
          {
            case '1':
              leetStr += "l";
              break;
            case '3':
              leetStr += "e";
              break;
            case '@':
              leetStr += "a";
              break;
            case '+':
              leetStr += "t";
              break;
            case '|':
              if (str.charAt(i + 1) == '3')
                {
                  leetStr += "b";
                  i++;
                } // if
              else if ((str.charAt(i + 1) == '\\')
                       && (str.charAt(i + 2) == '|'))
                {
                  leetStr += "n";
                  i += 2;
                } // else if
              break;
            default:
              leetStr += Character.toString(str.charAt(i));
              break;
          } // switch
      } // for

    return leetStr;
  } // deLeet (String)

  /*************************
   * Part D: The Name Game * time: ~45min 
   *************************/

  /**
   * isConsonant
   * 
   * @param c
   * @return
   */
  private static boolean isConsonant(char c)
  {
    switch (Character.toLowerCase(c))
      {
        case 'a':
        case 'e':
        case 'i':
        case 'o':
        case 'u':
        case 'y':
          return false;
        default:
          return true;
      } // switch
  } // isConsonant (char)

  /**
   * nameGame
   * 
   * @param String
   * @return
   */
  public static void nameGame(String name)
  {
    int i = 0;
    while (isConsonant(name.charAt(i)))
      i++;
    String stem = name.substring(i);
    stem = stem.toLowerCase();

    java.io.PrintWriter pen = new java.io.PrintWriter(System.out, true);

    pen.print(name + "!\n" + name + ", " + name + "bo B" + stem
              + " Bonana fanna fo F" + stem + "\n" + "Fee fy mo M" + stem
              + ", " + name + "!\n");
    pen.flush();

    pen.close();
  } // nameGame (String name)

} // StringUtils
