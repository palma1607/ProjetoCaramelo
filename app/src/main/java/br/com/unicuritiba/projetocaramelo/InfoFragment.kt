package br.com.unicuritiba.projetocaramelo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.unicuritiba.projetocaramelo.databinding.FragmentInfoBinding
import br.com.unicuritiba.projetocaramelo.util.FactoryInfo

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class InfoFragment : Fragment() {

    private var _binding: FragmentInfoBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val infos = FactoryInfo.getInfos()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}