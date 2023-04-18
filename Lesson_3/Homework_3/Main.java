public class Main {
	public static void main(String[] args) {
		int[] elements = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
		RedBlackTree tree = new RedBlackTree(elements);

		// Вывод дерева в виде красно-черного дерева
		printRedBlackTree(tree.getRoot(), "", true);
	}

	// Метод для вывода дерева в виде красно-черного дерева
	private static void printRedBlackTree(RedBlackTree.Node node, String indent, boolean last) {
		if (node != null) {
			System.out.print(indent);
			if (last) {
				System.out.print("\u001B[31m" + "⬤" + "\u001B[0m" + "----");
				indent += "     ";
			} else {
				System.out.print("\u001B[30m" + "⬤" + "\u001B[0m" + "----");
				indent += "|    ";
			}

			String color = node.isRed ? "\u001B[31m" : "\u001B[30m";
			System.out.println(node.key + "(" + color + "⚫" + "\u001B[0m" + ")");
			printRedBlackTree(node.left, indent, false);
			printRedBlackTree(node.right, indent, true);
		}
	}

}
