package ar.adriano.bdasecovid

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaPacientes (db: SQLiteDatabase) {
    private val db: SQLiteDatabase = db

    fun cria() {
        db.execSQL("CREATE TABLE $NOME_TABLE (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT, $NOME_PACIENTE TEXT NOT NULL ,$DATA_NASCIMENTO DATE NOT NULL, $CONTACTO TEXT NOT NULL,$SEXO CHAR NOT NULL, $DATA_DO_TESTE DATE NOT NULL,  $IDENFERMEIRO INTEGER NOT NULL ,FOREIGN KEY($IDENFERMEIRO ) REFERENCES ${TabelaEnfermeiro.NOME_TABLE})")
    }

    fun insert(values: ContentValues): Long {
        return db.insert(NOME_TABLE, null, values)
    }

    fun update(values: ContentValues, whereClause: String, whereArgs: Array<String>): Int {
        return db.update(NOME_TABLE, values, whereClause, whereArgs)
    }

    fun delete(whereClause: String, whereArgs: Array<String>): Int {
        return db.delete(NOME_TABLE, whereClause, whereArgs)
    }

    fun query(
        columns: Array<String>,
        selection: String?,
        selectionArgs: Array<String>,
        groupBy: String?,
        having: String?,
        orderBy: String?
    ): Cursor? {
        return db.query(NOME_TABLE, columns, selection, selectionArgs, groupBy, having, orderBy)
    }

    companion object {
        const val NOME_TABLE = "PACIENTE"
        const val NOME_PACIENTE = "NOME"
        const val SEXO = "SEXO"
        const val DATA_NASCIMENTO = "DATA_NASCIMENTO"
        const val CONTACTO = "CONTACTO"
        const val DATA_DO_TESTE = "DATA_DO_TESTE"
        const val IDENFERMEIRO = "ID"

        val TODAS_COLUNAS = arrayOf(BaseColumns._ID, TabelaPacientes.NOME_PACIENTE)
    }

}
