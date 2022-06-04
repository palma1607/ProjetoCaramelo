package br.com.unicuritiba.projetocaramelo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.unicuritiba.projetocaramelo.adapter.PrescriptionAdapter
import br.com.unicuritiba.projetocaramelo.databinding.FragmentPrescriptionBinding
import br.com.unicuritiba.projetocaramelo.util.FactoryPrescription

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class PrescriptionFragment : Fragment() {

    private var _binding: FragmentPrescriptionBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentPrescriptionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = view.findViewById<RecyclerView>(R.id.recycler_view_prescriptions)
        recycler.layoutManager = LinearLayoutManager(context)
        FactoryPrescription.getPrescription { prescriptions ->
            val adapter = PrescriptionAdapter(prescriptions)
            recycler.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}