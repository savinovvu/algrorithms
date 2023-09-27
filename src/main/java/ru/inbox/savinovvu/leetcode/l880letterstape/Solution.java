package ru.inbox.savinovvu.leetcode.l880letterstape;

import java.math.BigInteger;

class Solution {

  public String decodeAtIndex(String s, int k) {
    Node node = getNode(s);
    Node actualNode = findActualNode(node, k);
    int mod = actualNode.text.length() + Integer.valueOf(actualNode.previous.numberOfBoarder.toString());
    int currentPosition = k % (mod + 1);
    char resultChar = findText(actualNode, currentPosition);

    String result = String.valueOf(resultChar);
    return result;
//    return "String.valueOf(result)";
  }

  private char findText(Node actualNode, int currentPosition) {
    if (actualNode.previous.numberOfBoarder.compareTo(BigInteger.valueOf(currentPosition)) >= 0) {
      findText(actualNode.previous, currentPosition);
    } else {
      int position = currentPosition - Integer.valueOf(actualNode.previous.numberOfBoarder.toString());
      return actualNode.text.toCharArray()[position - 1];
    }

    return 0;
  }

  private Node findActualNode(Node node, int k) {
    if (node.previous.numberOfBoarder.compareTo(BigInteger.valueOf(k)) < 1) {
      return node;
    } else {
      return findActualNode(node.previous, k);
    }

  }

  private static Node getNode(String s) {
    String s1 = s.replaceAll("^\\d+", "");

//    ArrayList<Node> nodes = new ArrayList<>();
    Node node = new Node("", BigInteger.ZERO, BigInteger.ONE, null);
    BigInteger multiplier = BigInteger.ONE;
    StringBuilder tmpS = new StringBuilder();
    for (Character character : s1.toCharArray()) {
      if (Character.isDigit(character)) {
        multiplier = multiplier.multiply(BigInteger.valueOf(Long.valueOf(character.toString())));
      } else {
        if (multiplier.compareTo(BigInteger.ONE) > 0) {
          node = addNode(node, multiplier, tmpS.toString());
          multiplier = BigInteger.ONE;
          tmpS = new StringBuilder();
        }
        tmpS.append(character);
      }
    }
    if (!tmpS.toString().equals("")) {
      node = addNode(node, multiplier, tmpS.toString());
    }
    return node;
  }

  private static Node addNode(Node lastNode, BigInteger multiplier, String currentString) {
    BigInteger border = lastNode.numberOfBoarder.add(BigInteger.valueOf(currentString.length())).multiply(multiplier);
    return new Node(currentString, border, multiplier, lastNode);
  }

  public static class Node {

    public String text = "";
    public BigInteger numberOfBoarder = BigInteger.ZERO;
    public BigInteger multiplier = BigInteger.ONE;

    public Node previous;

    public Node(String s, BigInteger numberOfBoarder, BigInteger multiplier, Node c) {
      this.text = s;
      this.numberOfBoarder = numberOfBoarder;
      this.multiplier = multiplier;
      this.previous = c;
    }
  }


  /*Example 1:

Input: s = "leet2code3", k = 10
Output: "o"
Explanation: The decoded string is "leetleetcodeleetleetcodeleetleetcode".
The 10th letter in the string is "o".
Example 2:

Input: s = "ha22", k = 5
Output: "h"
Explanation: The decoded string is "hahahaha".
The 5th letter is "h".
Example 3:

Input: s = "a2345678999999999999999", k = 1
Output: "a"
Explanation: The decoded string is "a" repeated 8301530446056247680 times.
The 1st letter is "a".*/
  public static void main(String[] args) {
    Solution sol = new Solution();
//    String result = sol.decodeAtIndex("123lee2code344", 9);
//    String result = sol.decodeAtIndex("leet2code3", 10);
    String result = sol.decodeAtIndex("ha22", 6);
//    String result = sol.decodeAtIndex("a2b3", 3);
//    String result = sol.decodeAtIndex("le2l", 3);
    System.out.println(result);
  }
}