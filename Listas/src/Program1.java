import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Program1 {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();

		list.add("Elksandro");
		list.add("Anna");
		list.add("José");
		list.add("Gabi");
		list.add(2, "Java");
		list.add(4, "Astro");
		
		System.out.println(list.size());
		
		for (String x : list) {
			System.out.println(x);
		}
		
		System.out.println("=".repeat(30));
		
		//list.remove("Java");
		list.remove(2);
		list.removeIf(x -> x.charAt(0) == 'M'); // se x na posição 0 for igual a M ele irá remover o nome da lista
		
		for (String x : list) {
			System.out.println(x);
		}
		
		System.out.println("=".repeat(30));
		System.out.println("Index of Elksandro: " + list.indexOf("Elksandro"));
		System.out.println("Index of Anna: " + list.indexOf("Anna"));
		System.out.println("=".repeat(30));
		
		
		List<String> result = list.stream().filter(x -> x.charAt(0) == 'A').collect(Collectors.toList());
		
		for (String x : result) {
			System.out.println(x);
		}
		System.out.println("=".repeat(30));
		
		String name = list.stream().filter(x -> x.charAt(0) == 'A').findFirst().orElse(null);
		System.out.println("Primeiro elemento que começa com a letra A: " + name);
		
	}

}
