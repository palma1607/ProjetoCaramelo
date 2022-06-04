package br.com.unicuritiba.projetocaramelo.util

import br.com.unicuritiba.projetocaramelo.model.Info
import com.google.firebase.Timestamp
import com.google.firebase.firestore.FirebaseFirestore
import java.text.DateFormat

object FactoryInfo {

    fun getInfos(listener : (ArrayList<Info>) -> Unit) {

        val fireStore = FirebaseFirestore.getInstance()

        val collection = fireStore.collection("AnamnepetDatabase")
        val informations = collection.document("informations")
        val infoElements = informations.get()

        infoElements.addOnSuccessListener {  document ->

            val infoArray =  document.get("infos")

            val infos = ArrayList<Info>()

            for (item in (infoArray as ArrayList<*>)){

                val itemMap = item as HashMap<String, Any>
                val timestampDate = (itemMap["date"] as Timestamp).toDate()

                val dateFormat = DateFormat.getDateInstance()
                val date = dateFormat.format(timestampDate)

                infos.add(
                    Info(
                        image = itemMap["image"] as String,
                        title = itemMap["title"] as String,
                        message = itemMap["message"] as String,
                        date = date
                    )
                )
            }
            listener(infos)
        }
    }
}