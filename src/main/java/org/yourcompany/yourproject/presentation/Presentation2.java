package org.yourcompany.yourproject.presentation;


import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

import org.yourcompany.yourproject.dao.Idao;
import org.yourcompany.yourproject.metier.IMetier;

public class Presentation2 {
    public static void main(String[] args) throws Exception {
        // Lecture du nom de la classe DAO depuis le fichier de configuration
        Scanner scanner = new Scanner(new File("config.txt"));
        String daoClassName = scanner.nextLine();
        
        // Utilisation de la réflexion pour charger la classe DAO et créer une instance
        Class<?> cDao = Class.forName(daoClassName);
        Idao dao = (Idao) cDao.getDeclaredConstructor().newInstance();
        
        // Lecture du nom de la classe Métier depuis le fichier de configuration
        String metierClassName = scanner.nextLine();
        Class<?> cMetier = Class.forName(metierClassName);
        IMetier metier = (IMetier) cMetier.getDeclaredConstructor().newInstance();
        
        // Injection de la DAO dans le Métier à l'aide de la réflexion
        Method setDaoMethod = cMetier.getMethod("setDao", Idao.class);
        setDaoMethod.invoke(metier, dao);
        
        // Invocation d'une méthode sur l'instance de Métier et affichage du résultat
        System.out.println("Résultats = " + metier.calcul());
        
        scanner.close();
    }
}