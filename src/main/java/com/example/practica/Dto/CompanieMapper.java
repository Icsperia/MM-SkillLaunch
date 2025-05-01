package com.example.practica.DTO;

import com.example.practica.Entity.Companie;
import org.springframework.stereotype.Component;

@Component
public class CompanieMapper
{
   public CompanieDto toDto(Companie companie){
       CompanieDto companieDto = new CompanieDto();
       companieDto.setId(companie.getId());
       companieDto.setName(companie.getName());
       companieDto.setEmail(companie.getEmail());
       return companieDto;


   }
public Companie toEntity(CompanieDto companieDto){
       Companie companie = new Companie();
       companie.setId(companieDto.getId());
       companie.setName(companieDto.getName());
       companie.setEmail(companieDto.getEmail());
       return companie;
}

}
