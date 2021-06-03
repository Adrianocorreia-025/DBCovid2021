package ar.adriano.bdcovid2021

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class TesteBdadosCovid {
    private fun getAppContext() = InstrumentationRegistry.getInstrumentation().targetContext

    @Test
    fun ConsegueAbrirBaseDados(){
        val openHelper = BdPacientesOpenHelper(getAppContext())
        val db = openHelper.readableDatabase
        assert(db.isOpen)
        db.close()

    }
}