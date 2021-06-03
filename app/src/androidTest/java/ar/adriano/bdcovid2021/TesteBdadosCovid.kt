package ar.adriano.bdcovid2021

import android.provider.BaseColumns
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import ar.adriano.bdasecovid.TabelaEnfermeiro

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import pt.ipg.livros.Categoria

@RunWith(AndroidJUnit4::class)
class TesteBdadosCovid {
    private fun getAppContext() = InstrumentationRegistry.getInstrumentation().targetContext

    private fun getBdPacientesOpenHelper() = BdPacientesOpenHelper(getAppContext())

    private fun insereEnfermeiroNaBd(tabela: TabelaCategoriaEnfermeiro, categoria: Categoria): Long {
    val id = tabela.insert(categoria.toContentValues())
        assertNotEquals(-1,id)

        return id

    }

    private fun insereCategoria(tabela: TabelaCategoriaEnfermeiro, categoria: Categoria): Long {
        val id =  tabela.insert(categoria.toContentValues())
        assertNotEquals(-1,id)
        return id

    }

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


@Test
    fun ConsegueInserirCategoriaEnfermeiros(){
        //Escrever na BD

        val db = getBdPacientesOpenHelper().writableDatabase
        val tabelaCategoriaEnfermeiro = TabelaCategoriaEnfermeiro(db)

    val categoria = Categoria(nome = "Contratados")
    categoria.id = insereCategoria(tabelaCategoriaEnfermeiro,categoria )

        db.close()
    }


    fun ConsegueAlterarDadosEnfermeiros(){

        // Alterar
        val db = getBdPacientesOpenHelper().writableDatabase
        val tabelaCategoriaEnfermeiro = TabelaCategoriaEnfermeiro(db)
        val categoria = Categoria(nome = "Estagiaria")
         categoria.id = insereCategoria(tabelaCategoriaEnfermeiro,categoria )


        // Alterar para
        categoria.nome = "Efectiva"

        val AlterarRgidtos  = tabelaCategoriaEnfermeiro.update(
            categoria.toContentValues(),
            "${BaseColumns._ID}=?",
            arrayOf(categoria.id.toString())
        )
        assertEquals(1,AlterarRgidtos)

        db.close()
    }


/*
    @Test
    fun ConsegueAlterarDadosEnfermeiros(){

        val db = getBdPacientesOpenHelper().writableDatabase
        val tabelaCategoriaEnfermeiro = TabelaCategoriaEnfermeiro(db)

        val enfermeiro = Enfermeiro(nome = "Enfemeiro",sexo = "M",cidade = "Cidade")
        enfermeiro.id = insereEnfermeiroNaBd(tabelaEnfermeiro,enfermeiro)

        enfermeiro.nome = "nome"
        enfermeiro.sexo= "sexo"
        enfermeiro.cidade = "nome"

        val AlterarRegistos  = tabelaEnfermeiro.update(
            enfermeiro.toContentValues(),
            "${BaseColumns._ID}=?",
            arrayOf(enfermeiro.id.toString())
        )

        assertEquals(1,AlterarRegistos)

        db.close()
    }


    /*



    fun ConsegueInserirDadosEnfermeiros(){

        //Escrever na BD

        val db = getBdPacientesOpenHelper().writableDatabase
        val tabelaEnfermeiro = TabelaEnfermeiro(db)

        val enfermeiro = Enfermeiro(nome = "Enfe",sexo = "F",cidade = "City")
        enfermeiro.id = insereEnfermeiroNaBd(tabelaEnfermeiro,enfermeiro)

        db.close()
    }


    @Test
    fun ConsegueAlterarDadosEnfermeiros(){

        val db = getBdPacientesOpenHelper().writableDatabase
        val tabelaEnfermeiro = TabelaEnfermeiro(db)

        val enfermeiro = Enfermeiro(nome = "Enfemeiro",sexo = "M",cidade = "Cidade")
        enfermeiro.id = insereEnfermeiroNaBd(tabelaEnfermeiro,enfermeiro)

        enfermeiro.nome = "nome"
        enfermeiro.sexo= "sexo"
        enfermeiro.cidade = "nome"

        val AlterarRegistos  = tabelaEnfermeiro.update(
            enfermeiro.toContentValues(),
            "${BaseColumns._ID}=?",
            arrayOf(enfermeiro.id.toString())
        )

        assertEquals(1,AlterarRegistos)

        db.close()
    }

    fun ConsegueEliminarDadosEnfermeiros(){

        val db = getBdPacientesOpenHelper().writableDatabase
        val tabelaEnfermeiro = TabelaEnfermeiro(db)

        val enfermeiro = Enfermeiro(nome = "Enfemeiro",sexo = "M",cidade = "Cidade")
        enfermeiro.id = insereEnfermeiroNaBd(tabelaEnfermeiro,enfermeiro)


    }
*/
*/

}