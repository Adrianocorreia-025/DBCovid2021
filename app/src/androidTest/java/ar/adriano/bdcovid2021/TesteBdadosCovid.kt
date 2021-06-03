package ar.adriano.bdcovid2021

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import ar.adriano.bdasecovid.TabelaEnfermeiro

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class TesteBdadosCovid {
    private fun getAppContext() = InstrumentationRegistry.getInstrumentation().targetContext

    private fun getBdPacientesOpenHelper() = BdPacientesOpenHelper(getAppContext())

 //   private fun getTabelaEnfermeiro(SQLiteDatabase db) = TabelaEnfermeiro(db)


 @Before
 fun ApagarBDados(){

     getAppContext().deleteDatabase(BdPacientesOpenHelper.NOME_BASE_DADOS)
 }


    @Test
    fun ConsegueAbrirBaseDados(){
        val db = getBdPacientesOpenHelper().writableDatabase
        assert(db.isOpen)
        db.close()

    }


    fun ConsegueInserirEnfermeiros(){

        val db = getBdPacientesOpenHelper().writableDatabase
        val tabelaEnfermeiro = TabelaEnfermeiro(db)

      tabelaEnfermeiro.insert(Enfermeiro(
          nome = "Nome",
          sexo = "Sexo",
          cidade = "Cidade"
      ))

        db.close()
    }



}