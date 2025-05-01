package com.example.practica.Service;

import com.example.practica.Entity.Companie;
import com.example.practica.Repo.CompanieRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class CompanieService {

public final CompanieRepo companieRepo;

   public  List<Companie> findAll() {
        return companieRepo.findAll();
    }

    public Companie findById(Long id) {
        return companieRepo.findById(id).get();
    }


}
