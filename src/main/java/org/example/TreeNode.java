package org.example;

import javafx.scene.control.Button;

public class TreeNode {
  private int weight;
  private TreeNode left;
  private TreeNode right;
  private Button visual;

  public TreeNode(int peso) {
    this.weight = peso;
  }

  public int getWeight() {
    return this.weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public TreeNode getLeft() {
    return this.left;
  }

  public void setLeft(TreeNode left) {
    this.left = left;
  }

  public TreeNode getRight() {
    return this.right;
  }

  public void setRight(TreeNode right) {
    this.right = right;
  }

  public Button getVisual() {
    return this.visual;
  }

  public void setVisual(Button visual) {
    this.visual = visual;
  }
}
