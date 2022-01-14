package com.example.fragmentlearning_jan13

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmentlearning_jan13.databinding.FragmentEmailBinding

class EmailFragment: Fragment() {
    private var _binding: FragmentEmailBinding? = null
    private val binding: FragmentEmailBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEmailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            backBtn.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container_view, NameFragment::class.java, Bundle())
                    .addToBackStack(null)
                    .commit()
            }
            nextBtn.setOnClickListener {
                val bundle = Bundle()
                bundle.putString(EMAIL_EXTRA, emailEt.editText?.text.toString())
                bundle.putString(FIRST_NAME_EXTRA, arguments?.getString(FIRST_NAME_EXTRA) ?: FIRST_NAME_EXTRA)
                bundle.putString(SURNAME_EXTRA, arguments?.getString(SURNAME_EXTRA) ?: SURNAME_EXTRA)
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container_view, PasswordFragment::class.java, bundle)
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