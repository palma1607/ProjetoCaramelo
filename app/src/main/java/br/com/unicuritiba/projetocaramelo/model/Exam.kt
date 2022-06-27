package br.com.unicuritiba.projetocaramelo.model

data class Exam (
    val petName: String,
    val tutorName: String,
    val type: String,
    val description: String? = null,
    val date:String
    )