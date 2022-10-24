package com.example.aplication_jp_compose.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import com.example.aplication_jp_compose.R
import com.example.aplication_jp_compose.databinding.FragmentUnoBinding


private const val ARG_PARAM1 = "param1"

class Uno_Fragment : Fragment() {

    private var _binding: FragmentUnoBinding? = null
    private val binding get() = _binding!!
    private var param1: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUnoBinding.inflate(inflater, container, false)
        val view = binding.root

        return view.apply {
            binding.composeView.setContent {
                FunInFragmentUno(name = "Hola Fragment UNO")
            }
        }

        /*
        // Vistas xml y compose. Sin binding.
        return inflater.inflate(R.layout.fragment_uno_, container, false).apply {
            findViewById<ComposeView>(R.id.compose_view).setContent {
            }
        }*/

        /*
        // Cuando la vista es solo con Compose
        return ComposeView(requireContext()).apply {
            setContent {
                FunInFragmentUno(name = "Hola Fragment UNO")
            }
        }*/
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Uno_Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)

                }
            }
    }
}


@Composable
fun FunInFragmentUno(name: String) {
    Text(text = "Hello $name!")
}