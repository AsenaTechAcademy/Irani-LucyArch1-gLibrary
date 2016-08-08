package service;


import java.util.List;

import common.model.Amanat;


public interface AmanatService
{
    public Amanat AddNewAmanat(Amanat a, int bookID, int memberID) throws Exception;

    public List<Amanat> GetAllAmanat();
} 
