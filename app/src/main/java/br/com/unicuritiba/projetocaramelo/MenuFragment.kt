package br.com.unicuritiba.projetocaramelo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import br.com.unicuritiba.projetocaramelo.databinding.FragmentMenuBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MenuFragment : Fragment() {

    private var _binding: FragmentMenuBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*binding.buttonAnamnase.setOnClickListener {
            findNavController().navigate(R.id.action_MenuFragment_to_AnamnesisFragment)
        }*/

        binding.buttonPrescription.setOnClickListener {
            findNavController().navigate(R.id.action_MenuFragment_to_prescriptionFragment)
        }

        binding.buttonVaccine.setOnClickListener {
            findNavController().navigate(R.id.action_MenuFragment_to_vaccinesFragment)
        }

        binding.buttonMedicine.setOnClickListener {
            findNavController().navigate(R.id.action_MenuFragment_to_medicineFragment)
        }

        binding.buttonNews.setOnClickListener {
            findNavController().navigate(R.id.action_MenuFragment_to_infoFragment)
        }

        binding.buttonExam.setOnClickListener {
            findNavController().navigate(R.id.action_MenuFragment_to_examFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}