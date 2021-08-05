package com.my_shop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("-----------------------WELCOME TO XYZ BOOK SHOP----------------------");
		boolean flag=true;
		while(flag) {
			System.out.println(" 1. Insert Book \n 2. Delete Book \n 3. Update Book Data \n 4. Check Book \n 5. Sale Book \n 6. Exit \n");
			System.out.println("Enter Your Choice..");
			int choose=Integer.parseInt(br.readLine());
			switch(choose) {
			case 1:
				//Insert Book
				System.out.println("Enter Book Name ");
				String name=br.readLine();
				System.out.println("Enter Book Author Name ");
				String author=br.readLine();
				System.out.println("Enter Book Price ");
				float price =Float.parseFloat(br.readLine());
				System.out.println("Enter Publisher Name ");
				String publisher=br.readLine();
				System.out.println("Enter Book Stock ");
				int stock=Integer.parseInt(br.readLine());
				
				Book b=new Book(name,author,price,publisher,stock);
				boolean answer=BookDao.insert(b);
				if(answer)
					System.out.println("Insert Successfully....\n");
				else
					System.out.println("Something went wrong.\n");
				break;
			case 2:
				//Delete Book
				System.out.println("Enter Book Name ");
				String name1=br.readLine();
				System.out.println("Enter Book Author Name ");
				String author1=br.readLine();
				boolean ans=BookDao.delete(name1, author1);
				if(ans)
					System.out.println("Delete Successfully..\n");
				else
					System.out.println("Book is not available.\n");
				break;
			case 3:
				//Update Book
				System.out.println("Enter Book Name ");
				String name2=br.readLine();
				System.out.println("Enter Book Author Name ");
				String author2=br.readLine();
				boolean ans1=BookDao.updateStock(name2, author2);
				if(ans1)
					System.out.println("Update Successfully..\n");
				else
					System.out.println("Book is not available.\n");
				break;
			case 4:
				//Check Book
				System.out.println("Enter Book Name ");
				String name3=br.readLine();
				System.out.println("Enter Book Author name ");
				String author3=br.readLine();
				boolean ans2=BookDao.checkBook(name3, author3);
				if(ans2!=true) {
					System.out.println("Book is not Available.\n ");
				}
				break;
			case 5:
				//Sale Book
				System.out.println("Enter Book Name ");
				String name4=br.readLine();
				System.out.println("Enter Book Author Name ");
				String author4=br.readLine();
				boolean ans4=BookDao.saleBook(name4, author4);
				if(ans4!=true) {
					System.out.println("Book is not available.\n");
				}
				break;
			case 6:
				//Exit
				flag=false;
				break;
				
			default:
				System.out.println("You Enter wrong choice .. \n Please try again\n");
			}
			
		}
		System.out.println("Thank You for Using BOOK-SHOP APPLICATION....");
		System.out.println("See You Soon.. Bye..");
	}
}
