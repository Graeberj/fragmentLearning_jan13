package com.example.fragmentlearning_jan13

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmentlearning_jan13.databinding.FragmentDisplayBinding

class DisplayFragment : Fragment() {
    private var _binding: FragmentDisplayBinding? = null
    private val binding: FragmentDisplayBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDisplayBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            nameTv.text = arguments?.getString(FIRST_NAME_EXTRA) ?: FIRST_NAME_EXTRA
            surnameTv.text = arguments?.getString(SURNAME_EXTRA) ?: SURNAME_EXTRA
            passwordTv.text = arguments?.getString(PASSWORD_EXTRA) ?: PASSWORD_EXTRA
            emailTv.text = arguments?.getString(EMAIL_EXTRA) ?: EMAIL_EXTRA
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}