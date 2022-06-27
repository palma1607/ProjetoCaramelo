package br.com.unicuritiba.projetocaramelo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.unicuritiba.projetocaramelo.adapter.ExamAdapter
import br.com.unicuritiba.projetocaramelo.databinding.FragmentExamBinding
import br.com.unicuritiba.projetocaramelo.util.FactoryExam

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ExamFragment : Fragment() {

    private var _binding: FragmentExamBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentExamBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = view.findViewById<RecyclerView>(R.id.recycler_view_exams)
        recycler.layoutManager = LinearLayoutManager(context)
        FactoryExam.getExam { exams ->
            val adapter = ExamAdapter(exams)
            recycler.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}