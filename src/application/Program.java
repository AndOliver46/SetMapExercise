package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Map<String, Integer> candidates = new TreeMap<>();

		System.out.print("Digite o caminho do arquivo CSV: ");
		String path = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				String name = fields[0];
				Integer count = Integer.parseInt(fields[1]);

				if (candidates.containsKey(name)) {
					int votesSoFar = candidates.get(name);
					candidates.put(name, count + votesSoFar);
				} else {
					candidates.put(name, count);
				}
				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}

		for (String key : candidates.keySet()) {
			System.out.println(key + ":" + candidates.get(key));
		}

		sc.close();

	}
}
