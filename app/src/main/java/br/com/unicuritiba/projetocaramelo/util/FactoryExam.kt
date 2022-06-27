package br.com.unicuritiba.projetocaramelo.util

import br.com.unicuritiba.projetocaramelo.model.Exam
import com.google.firebase.Timestamp
import com.google.firebase.firestore.FirebaseFirestore
import java.text.DateFormat

object FactoryExam {

    fun getExam(listener : (ArrayList<Exam>) -> Unit) {

        val fireStore = FirebaseFirestore.getInstance()

        val collection = fireStore.collection("AnamnepetDatabase")
        val exams = collection.document("exams")
        val examElements = exams.get()

        examElements.addOnSuccessListener {  document ->

            val examArray =  document.get("additional_exams")

            val exams = ArrayList<Exam>()

            for (item in (examArray as ArrayList<*>)){

                val itemMap = item as HashMap<String, Any>
                val timestampDate = (itemMap["date"] as Timestamp).toDate()

                val dateFormat = DateFormat.getDateInstance()
                val date = dateFormat.format(timestampDate)

                exams.add(
                    Exam(
                        type = itemMap["type"] as String,
                        petName = itemMap["petName"] as String,
                        tutorName = itemMap["tutorName"] as String,
                        date = date
                    )
                )
            }
            listener(exams)
        }
    }
}