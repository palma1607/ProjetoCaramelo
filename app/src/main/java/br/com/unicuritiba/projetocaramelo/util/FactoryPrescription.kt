package br.com.unicuritiba.projetocaramelo.util

import br.com.unicuritiba.projetocaramelo.model.Prescription
import com.google.firebase.Timestamp
import com.google.firebase.firestore.FirebaseFirestore
import java.text.DateFormat

object FactoryPrescription {

    fun getPrescription(listener : (ArrayList<Prescription>) -> Unit) {

        val fireStore = FirebaseFirestore.getInstance()

        val collection = fireStore.collection("AnamnepetDatabase")
        val prescriptions = collection.document("prescriptions")
        val prescriptionElements = prescriptions.get()

        prescriptionElements.addOnSuccessListener {  document ->

            val prescriptionArray =  document.get("nutritional_prescription")

            val prescriptions = ArrayList<Prescription>()

            for (item in (prescriptionArray as ArrayList<*>)){

                val itemMap = item as HashMap<String, Any>

                prescriptions.add(
                    Prescription(
                        title = itemMap["title"] as String,
                        message = itemMap["message"] as String,
                    )
                )
            }
            listener(prescriptions)
        }
    }
}