package correa.luiz.myapplication

import android.graphics.Canvas
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class GeneroItemDecoration : RecyclerView.ItemDecoration() {

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        val generoColors = mapOf(
            "M" to 0xFF00BFFF, // Azul
            "F" to 0xFFDDA0DD, // Vermelho
            "I" to 0xFFFFFFE0  // Verde
        )

        for (i in 0 until parent.childCount) {
            val view = parent.getChildAt(i)
            val position = parent.getChildAdapterPosition(view)
            val adapter = parent.adapter as PalavraAdapter
            val palavra = adapter.getItem(position)

            val genero = palavra.genero
            val backgroundColor = generoColors[genero]

            // Acesse o elemento linha no layout do item
            val linha = view.findViewById<View>(R.id.linha)

            // Define a cor de fundo com base no gênero
            backgroundColor?.let {
                linha.setBackgroundColor(it.toInt())
            }
        }
    }
}
