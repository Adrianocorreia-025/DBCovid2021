package ar.adriano.bdcovid2021

import android.content.ContentValues
import androidx.core.content.contentValuesOf
import ar.adriano.bdasecovid.TabelaEnfermeiro

class Enfermeiro (var id :Long =-1, var nome:String, var sexo:String, var Contacto:Int = -1, var dataTeste:Int=-1, var cidade:String) {

fun toContentValues():ContentValues{
   val valores = ContentValues()

    valores.put(TabelaEnfermeiro.NOME_ENFERMEIRO,nome)
    valores.put(TabelaEnfermeiro.SEXO,sexo)
    valores.put(TabelaEnfermeiro.CONTACTO,Contacto)
     valores.put(TabelaEnfermeiro.CIDADE,cidade)
    valores.put(TabelaEnfermeiro.DATA_TESTE,dataTeste)


    return  valores
  }



}