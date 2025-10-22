package org.yourcompany.yourproject.metier;

import org.yourcompany.yourproject.dao.Idao;

public class MetierImpl implements IMetier {
    private Idao dao;
    
    public void setDao(Idao dao) {
        this.dao = dao;
    }
    
    @Override
    public double calcul() {
        return dao.getValue() * 2;
    }
}