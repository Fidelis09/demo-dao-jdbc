package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.dao.impl.SellerDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Department obj = new Department(1, "Books");

        //Seller seller = new Seller(21, "bob", "bob@gmail.com", new Date(), 3000.0, obj);

        SellerDao sellerDao = DaoFactory.createSellerDao();


        System.out.println("==== TESTE 1: seller findById ====");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n==== TESTE 2: seller findByDepartment ====");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj: list){
            System.out.println(obj);
        }

        System.out.println("\n==== TESTE 3: seller findAll ====");
        list = sellerDao.findAll();
        for (Seller obj: list){
            System.out.println(obj);
        }

        System.out.println("\n==== TESTE 4: seller insert ====");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! new id= " + newSeller.getId());

        System.out.println("\n==== TESTE 5: seller update ====");
        seller = sellerDao.findById(1);
        seller.setName("Martha WAAAAAAAAAAA");
        sellerDao.update(seller);
        System.out.println("update Completed!");

        System.out.println("\n==== TESTE 5: seller delete ====");
        System.out.println("\nDigite o id de exlusão: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete completed");

        sc.close();
    }
}
