package correa.luiz.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PalavraAdapter(private val palavras: List<Palavra>) :
    RecyclerView.Adapter<PalavraAdapter.PalavraViewHolder>() {


    inner class PalavraViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val palavrasTV: TextView = itemView.findViewById(R.id.nameTV)
        val countTV: TextView = itemView.findViewById(R.id.countTV)

        fun bind(palavra: Palavra) {
            palavrasTV.text = palavra.name
            countTV.text = palavra.count.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PalavraViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view, parent, false)
        return PalavraViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return palavras.size
    }

    override fun onBindViewHolder(holder: PalavraViewHolder, position: Int) {
        val palavra = palavras[position]
        holder.bind(palavra)
    }

    fun getItem(position: Int): Palavra {
        return palavras[position]
    }
}

