package humansworld;

public class Demo {

	public static void main(String[] args) {
		Person[] people = new Person[10];
		int index = 0;
		Person person1 = new Person("Pesho", 20, true);
		people[index] = person1;
		index++;
		Person person2 = new Person("Penka", 21, false);
		people[index] = person2;
		index++;
		Student student1 = new Student("Gosho", 19, true, 4.5);
		people[index] = student1;
		index++;
		Student student2 = new Student("Tisho", 19, true, 3.8);
		people[index] = student2;
		index++;
		Employee employee1 = new Employee("Jack", 28, true, 30);
		people[index] = employee1;
		index++;
		Employee employee2 = new Employee("Jill", 32, false, 33);
		people[index] = employee2;
		index++;
		
		for (int i = 0; i < people.length; i++) {
			if (people[i] instanceof Student) {
				((Student) people[i]).showStudentInfo();
			} else if (people[i] instanceof Employee) {
				((Employee) people[i]).showEmployeeInfo();
			} else if (people[i] instanceof Person) {
				people[i].showPersonInfo();
			}
			
			System.out.println();
		}

		/*
		 * 	И един въпрос, какво ще стане ако дефинирате конструктор без 
			параметри Student() в класа Student ??? Възможно ли е, и ако не защо. 
			Как може да се оправи това?
			
			Отговор: И да и не. Зависи. Тъй като класът Student наследява класа Person и в класа Person нямаме
			конструктор без параметри, то сме принудени от класа Student да извикаме някой от конструкторите с 
			параметри от super класа с някави стойности. За да можем да направим конструктор без параметри в класа
			Student, то трябва от този конструктор да се извика super конструктора с параметри, и понеже
			конструктора на Student няма паремтри, които да бъдат предадени, то трябва да подадем някакви стойноси, 
			които ние преценим за default-ни. Причината за това е следната:
			При създаване на обект от тип Student в паметта първо се създава обект от тип Person. Java виртуалната
			машина няма да знае с какви параметри да извика, който и да е от конструкторите на Person, ако ние изрично 
			не ги укажем. Затова и компилотора не позволява такъв код да бъде компилиран и дава грешка.
			
			Пример за конструктор без параметри в класа Student:
			
			public Student() {
				super("Homer Simpson", 0, true); 
			}
		 */
		
		
	}

}
