package br.com.unicuritiba.projetocaramelo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.unicuritiba.projetocaramelo.R
import br.com.unicuritiba.projetocaramelo.model.Exam

class ExamAdapter(exam: ArrayList<Exam>) : RecyclerView.Adapter<ExamAdapter.ExamViewHolder>() {

    private val examList = exam

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExamViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val layout: View = inflater.inflate(R.layout.exam_view,parent,false)
        return ExamViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ExamViewHolder, position: Int) {

        val examElement = examList[position]
        val textTitle = holder.itemView.findViewById<TextView>(R.id.text_exam_type)
        val textPetName = holder.itemView.findViewById<TextView>(R.id.text_exam_pet_name)
        val textTutorName = holder.itemView.findViewById<TextView>(R.id.text_exam_tutor_name)
        val textExamDate = holder.itemView.findViewById<TextView>(R.id.text_exam_date)
        textTitle.text = examElement.type
        textPetName.text = examElement.petName
        textTutorName.text = examElement.tutorName
        textExamDate.text = examElement.date
    }

    override fun getItemCount(): Int {
        return examList.size
    }

    inner class ExamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}