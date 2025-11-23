package org.example;

public class BinaryTree {

  private TreeNode root = null;

  public BinaryTree() {
    this.root = null;
  }

  public void insert(int weight) {
    root = insertRec(root, weight);
  }

  private TreeNode insertRec(TreeNode treeNode, int weight) {
    if (treeNode == null) return new TreeNode(weight);
    if (weight < treeNode.getWeight()) {
      treeNode.setLeft(insertRec(treeNode.getLeft(), weight));
    } else if (weight > treeNode.getWeight()) {
      treeNode.setRight(insertRec(treeNode.getRight(), weight));
    } else {
    }
    return treeNode;
  }

  public boolean delete(int weight) {
    TreeNode parent = null;
    TreeNode treeNode = root;

    // case 1: search for the node to delete
    while (treeNode != null && treeNode.getWeight() != weight) {
      parent = treeNode;
      if (weight < treeNode.getWeight()) treeNode = treeNode.getLeft();
      else treeNode = treeNode.getRight();
    }

    if (treeNode == null) {
      System.out.println("Node not found: " + weight);
      return false;
    }

    // case 2: node has no right child
    if (treeNode.getRight() == null) {
      if (parent == null) {
        root = treeNode.getLeft();
      } else if (parent.getLeft() == treeNode) {
        parent.setLeft(treeNode.getLeft());
      } else {
        parent.setRight(treeNode.getLeft());
      }
      treeNode.setLeft(null);
      treeNode.setRight(null);
      System.out.println("Deleted node: " + weight);
      return true;
    }

    // case 3: node has right child
    TreeNode succParent = treeNode;
    TreeNode successor = treeNode.getRight();
    while (successor.getLeft() != null) {
      succParent = successor;
      successor = successor.getLeft();
    }

    if (succParent != treeNode) {
      succParent.setLeft(successor.getRight()); // Link successor's right child to its parent
      successor.setRight(treeNode.getRight()); // Link node's right child to successor
    }
    successor.setLeft(treeNode.getLeft()); // Link node's left child to successor

    if (parent == null) {
      root = successor; // Deleting the root node
    } else if (parent.getLeft() == treeNode) {
      parent.setLeft(successor); // Link parent to successor
    } else {
      parent.setRight(successor); // Link parent to successor
    }
    // Clean up the deleted node
    treeNode.setLeft(null);
    treeNode.setRight(null);

    System.out.println("Deleted node: " + weight);
    return true;
  }

  // search node
  public TreeNode search(int weight) {
    TreeNode current = root;
    while (current != null) {
      if (weight == current.getWeight()) {
        return current;
      } else if (weight < current.getWeight()) {
        current = current.getLeft();
      } else {
        current = current.getRight();
      }
    }
    return null;
  }

  public TreeNode setRoot(TreeNode root) {
    this.root = root;
    return root;
  }

  public String preOrder() {
    StringBuilder sb = new StringBuilder();
    preOrderRec(root, sb);
    return sb.toString();
  }

  private void preOrderRec(TreeNode treeNode, StringBuilder s) {
    if (treeNode == null) return;
    s.append(treeNode.getWeight()).append(",");
    preOrderRec(treeNode.getLeft(), s);
    preOrderRec(treeNode.getRight(), s);
  }

  public String inOrder() {
    StringBuilder sb = new StringBuilder();
    inOrderRec(root, sb);
    return sb.toString();
  }

  private void inOrderRec(TreeNode treeNode, StringBuilder s) {
    if (treeNode == null) return;
    inOrderRec(treeNode.getLeft(), s);
    s.append(treeNode.getWeight()).append(",");
    inOrderRec(treeNode.getRight(), s);
  }

  public String postOrder() {
    StringBuilder sb = new StringBuilder();
    postOrderRec(root, sb);
    return sb.toString();
  }

  private void postOrderRec(TreeNode treeNode, StringBuilder s) {
    if (treeNode == null) return;
    postOrderRec(treeNode.getLeft(), s);
    postOrderRec(treeNode.getRight(), s);
    s.append(treeNode.getWeight()).append(",");
  }

  public TreeNode getRoot() {
    return this.root;
  }
}
