package br.com.estudos.contentapplicationclient

import android.database.Cursor
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.estudos.contentapplicationclient.databinding.ActivityMainBinding
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var recyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        recyclerView = binding.recyclerClienteMain
        val fabAtualiza = binding.fabAtualizarClienteMain
        getContentProvider()

        fabAtualiza.setOnClickListener {
            getContentProvider()
        }
    }

    fun getContentProvider(){
        try {
            val url = "content://br.com.estudos.contentapplicationbootcamp.provider/notas"
            val data = Uri.parse(url)
            val cursor: Cursor? = contentResolver.query(data, null, null, null, "titulo")
            recyclerView.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = ClienteAdapter(cursor as Cursor)
            }
        } catch (ex : Exception) {
            ex.printStackTrace()
        }
    }
}