package menu;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import model.services.FileConverter;
import model.structures.AVLTree;
import model.structures.Person;
import model.structures.PersonAVLTree;

public class Tela {

	public void imprime(String teste) throws ParseException {

		String filePath = "C:\\Users\\bruno\\OneDrive\\Área de Trabalho\\AVLTree-trabalho2-main\\Trees\\src\\teste.csv";
		List<Person> people = FileConverter.toPeopleList(filePath);
		System.out.println(new PersonAVLTree().toString());

		PersonAVLTree<Long> cpf = new PersonAVLTree<>();
		PersonAVLTree<Date> data = new PersonAVLTree<>();
		PersonAVLTree<String> nome = new PersonAVLTree<>();

		for (int i = 0; i < people.size(); i++) {
			cpf.add(people.get(i).getCPF(), i);
			data.add(people.get(i).getBirthDay(), i);
			nome.add(people.get(i).getName(), i);
		}

		System.out.println("digita");
		Scanner entrada = new Scanner(System.in);
		int base = entrada.nextInt();

		System.out.println("Digite 1 para buscar CPF");
		System.out.println("Digite 1 para buscar por NOME");
		System.out.println("Digite 1 para buscar DATA DE NASCIMENTO");

		switch (base) {
		case 1:

			System.out.println("Digite o CPF");
			Scanner cpfInput = new Scanner(System.in);
			long cpfPessoa = cpfInput.nextLong();

			List<Integer> indexes = cpf.searchForKey(cpfPessoa);
			System.out.println(indexes);

			break;
		case 2:

			System.out.println("Digite o CPF");
			Scanner nameInput = new Scanner(System.in);
			String name = nameInput.nextLine();

			List<Integer> nomes = nome.lookForTheString(name);
			System.out.println(nomes);

			break;
		case 3:

			System.out.println("Digite o CPF");
			Scanner dateInitialInput = new Scanner(System.in);
			Scanner dateFinalInput = new Scanner(System.in);
			String date = dateInitialInput.nextLine();
			String dateFinal = dateFinalInput.nextLine();

			List<Integer> dates = nome.lookForDate(date, dateFinal);
			System.out.println(dates);

		default:
			System.out.println("default");

		}
	}

}
