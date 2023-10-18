package correa.luiz.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rv : RecyclerView
    var palavraList = mutableListOf<Palavra>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val entradaDados = listOf("\"Marco;M\",\"Maria;F\",\"Joao;M\",\"Luis;M\",\"Ana;F\",\"Isabel;M\",\"Ana;F\",\"Rita;I\",\"Luis;M\",\"Catarina;F\",\"Paulo;M\",\"Marina;F\",\"Luisa;F\",\"Marcia;F\",\"Pedro;M\",\"Joel;I\",\"Antonio;M\",\"Marisa;F\",\"Sofia;F\",\"Jose;M\",\"Patricia;F\",\"Paulo;M\",\"Marisa;F\"")
        val dadosFormatados = entradaDados.first().replace("\"", "").split(",")

        for (item in dadosFormatados) {
            val partes = item.split(";")
            if (partes.size == 2) {
                val nome = partes[0]
                val genero = partes[1]
                val palavraExistente = palavraList.find { it.name == nome && it.genero == genero }
                if (palavraExistente != null) {
                    palavraExistente.count++
                } else {
                    val novaPalavra = Palavra(nome, genero, 1)
                            palavraList.add(novaPalavra)
                }
            }
        }

        for (palavra in palavraList) {
            println("Nome: ${palavra.name}, Gênero: ${palavra.genero}, Contagem: ${palavra.count}")
        }

        rv = findViewById(R.id.rv)

        val adapter = PalavraAdapter(palavraList)
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(this)

        val generoItemDecoration = GeneroItemDecoration()
        rv.addItemDecoration(generoItemDecoration)

    }

}