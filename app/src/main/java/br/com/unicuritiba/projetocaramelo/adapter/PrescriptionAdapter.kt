package br.com.unicuritiba.projetocaramelo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.unicuritiba.projetocaramelo.R
import br.com.unicuritiba.projetocaramelo.model.Prescription

class PrescriptionAdapter(prescription: ArrayList<Prescription>) : RecyclerView.Adapter<PrescriptionAdapter.PrescriptionViewHolder>() {

    private val prescriptionList = prescription

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrescriptionViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val layout: View = inflater.inflate(R.layout.prescription_view,parent,false)
        return PrescriptionViewHolder(layout)
    }

    override fun onBindViewHolder(holder: PrescriptionViewHolder, position: Int) {

        val prescriptionElement = prescriptionList[position]
        val textTitle = holder.itemView.findViewById<TextView>(R.id.text_prescription_title)
        val textContent = holder.itemView.findViewById<TextView>(R.id.text_prescription_content)
        textTitle.text = prescriptionElement.title
        textContent.text = prescriptionElement.message
    }

    override fun getItemCount(): Int {
        return prescriptionList.size
    }

    inner class PrescriptionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}