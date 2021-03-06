package edu.grinnell.csc207.deweytyl.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilsTest
{

  @Test
  public void splitAtTest()
  {
    assertArrayEquals(new String[] { "a", "b", "c" },
                      StringUtils.splitAt("a:b:c", ':'));
    assertArrayEquals(new String[] { "a", "b", "c" },
                      StringUtils.splitAt("a b c", ' '));
    assertArrayEquals(new String[] { "a:b:c" },
                      StringUtils.splitAt("a:b:c", ' '));
    assertArrayEquals("one field", new String[] { "a" },
                      StringUtils.splitAt("a", ':'));
    assertArrayEquals("empty inner field", new String[] { "a", "", "c" },
                      StringUtils.splitAt("a::c", ':'));
    assertArrayEquals("leading empty field", new String[] { "", "a" },
                      StringUtils.splitAt(":a", ':'));
    assertArrayEquals("trailing empty field", new String[] { "a", "" },
                      StringUtils.splitAt("a:", ':'));
  } // splitAtTest()

  @Test
  public void splitCSVTest()
  {
    assertArrayEquals(new String[] { "a", "b", "c" },
                      StringUtils.splitCSV("a,b,c"));
    assertArrayEquals(new String[] { "a,b", "c" },
                      StringUtils.splitCSV("\"a,b\",c"));
    assertArrayEquals(new String[] { "a", "b,b\"", "c" },
                      StringUtils.splitCSV("a,\"b,b\"\"\",c"));
    assertArrayEquals(new String[] { "a", "b\"", "c" },
                      StringUtils.splitCSV("a,b\"\",c"));
  } // splitCSVTest()

  @Test
  public void deLeetTest()
  {
    assertEquals("e", StringUtils.deLeet("3"));
    assertEquals("leet", StringUtils.deLeet("133+"));
    assertEquals("eat banana", StringUtils.deLeet("3@+ |3@|\\|@|\\|@"));
    assertEquals("pwn", StringUtils.deLeet("pw|\\|"));
    assertEquals("amazingly leet", StringUtils.deLeet("@m@zing1y 133+"));
  }

}
