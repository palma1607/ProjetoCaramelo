package br.com.unicuritiba.projetocaramelo.util

import br.com.unicuritiba.projetocaramelo.model.Info

object FactoryInfo {

    fun getInfos() : ArrayList<Info>{

        val infos = ArrayList<Info>()

        infos.add(Info( title= "Não seria interessante ter lembretes de saúde para" +
                " auxiliar na criação do seu Pet? Pois na AnamnePet têm! :)",
                    message = " - Não descuide da higiene bucal do seu cão, isso leva a doenças " +
                            "infecciosas sérias, como a endocardite. " +
                            "Escove regularmente os dentes do seu melhor amigo!" +
                            " Procure seu veterinário.",
                    date = "14/05/2022"
        ))

        return infos
    }
}