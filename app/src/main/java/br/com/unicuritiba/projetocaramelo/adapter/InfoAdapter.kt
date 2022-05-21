package br.com.unicuritiba.projetocaramelo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.unicuritiba.projetocaramelo.R
import br.com.unicuritiba.projetocaramelo.model.Info

class InfoAdapter(info: ArrayList<Info>) : RecyclerView.Adapter<InfoAdapter.InfoViewHolder>() {

    private val infoList = info

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val layout: View = inflater.inflate(R.layout.info_view,parent,false)
        return InfoViewHolder(layout)
    }

    override fun onBindViewHolder(holder: InfoViewHolder, position: Int) {

        val infoElement = infoList[position]
        val textTitle = holder.itemView.findViewById<TextView>(R.id.text_info_title)

        textTitle.text = infoElement.title

        // Todo adicionar elementos da mensagem e data, além da customização da celula


    }

    override fun getItemCount(): Int {
        return infoList.size
    }

    inner class InfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}