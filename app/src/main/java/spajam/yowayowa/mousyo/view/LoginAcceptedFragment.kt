package spajam.yowayowa.mousyo.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import spajam.yowayowa.mousyo.databinding.FragmentLoginAcceptedBinding

class LoginAcceptedFragment : Fragment() {
    private var _binding: FragmentLoginAcceptedBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginAcceptedBinding.inflate(inflater, container, false)
        val root = binding.root
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
