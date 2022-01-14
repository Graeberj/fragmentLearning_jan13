package com.example.fragmentlearning_jan13

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmentlearning_jan13.databinding.FragmentPasswordBinding

class PasswordFragment : Fragment() {
    private var _binding: FragmentPasswordBinding? = null
    private val binding: FragmentPasswordBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            backBtn.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container_view, EmailFragment::class.java, Bundle())
                    .addToBackStack(null)
                    .commit()
            }
            nextBtn.setOnClickListener {
                val bundle = Bundle()
                bundle.putString(PASSWORD_EXTRA, passwordEt.editText?.text.toString())
                bundle.putString(FIRST_NAME_EXTRA, arguments?.getString(FIRST_NAME_EXTRA) ?: FIRST_NAME_EXTRA)
                bundle.putString(SURNAME_EXTRA, arguments?.getString(SURNAME_EXTRA) ?: SURNAME_EXTRA)
                bundle.putString(EMAIL_EXTRA, arguments?.getString(EMAIL_EXTRA) ?: EMAIL_EXTRA)
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container_view, DisplayFragment::class.java, bundle)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}