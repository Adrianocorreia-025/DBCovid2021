package ar.adriano.bdasecovid

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaEnfermeiro (db: SQLiteDatabase) {
    private val db: SQLiteDatabase = db

    fun cria() {
        db.execSQL("CREATE TABLE $NOME_TABLE (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT,  $NOME_ENFERMEIRO TEXT NOT NULL,   $DATA_TESTE TEXT NOT NULL, $SEXO TEXT NOT NULL, $CIDADE TEXT NOT NULL ,$CONTACTO TEXT NOT NULL)")
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
        const val NOME_TABLE="ENFERMEIRO"
        const val NOME_ENFERMEIRO = "NOME"
        const val SEXO = "SEXO"
        const val DATA_TESTE = "DATA"
        const val CONTACTO = "CONTACTO"
        const val CIDADE = "CIDADE"
        val TODAS_COLUNAS = arrayOf(BaseColumns._ID, NOME_ENFERMEIRO )
    }
}
