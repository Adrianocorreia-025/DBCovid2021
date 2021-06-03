package pt.ipg.livros

import android.content.ContentValues
import android.database.Cursor
import android.provider.BaseColumns
import ar.adriano.bdcovid2021.TabelaCategoriaEnfermeiro

data class Categoria(var id: Long = -1, var nome: String) {
    fun toContentValues(): ContentValues {
        val valores = ContentValues()
        valores.put(TabelaCategoriaEnfermeiro.CAMPO_NOME, nome)
        return valores
    }

    companion object {
        fun fromCursor(cursor: Cursor): Categoria {
            val colId = cursor.getColumnIndex(BaseColumns._ID)
            val colNome = cursor.getColumnIndex(TabelaCategoriaEnfermeiro.CAMPO_NOME)

            val id = cursor.getLong(colId)
            val nome = cursor.getString(colNome)

            return Categoria(id, nome)
        }
    }
}