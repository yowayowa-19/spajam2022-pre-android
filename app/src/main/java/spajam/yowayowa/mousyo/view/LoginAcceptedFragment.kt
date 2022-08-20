package spajam.yowayowa.mousyo.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
        binding.button.setOnClickListener {
            Toast.makeText(context, "とりあえずMainActivityに戻します", Toast.LENGTH_SHORT).show()
            startActivity(Intent(context, MainActivity::class.java))
            activity?.finish()
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
