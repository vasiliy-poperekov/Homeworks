package com.example.homeworks.homework13

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homeworks.databinding.FragmentSweetsCodesBinding
import com.example.homeworks.homework10.Sweet

class FragmentWithCodes(
    private val reverseFragment: () -> Unit
) : Fragment() {

    var binding: FragmentSweetsCodesBinding? = null
    private val viewModel: FragmentWithCodeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSweetsCodesBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sweetAdapter = SweetAdapter(click = { saveSweet(it) })

        viewModel.sweetLiveData.observe(viewLifecycleOwner, {
            sweetAdapter.updateList(it)
        })
        binding!!.sweetsRecyclerInFragment1.layoutManager =
            LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
        binding!!.sweetsRecyclerInFragment1.adapter = sweetAdapter
    }

    private fun saveSweet(sweet: Sweet) {
        val bundle = Bundle()
        bundle.putSerializable(CLICKED_SWEET, sweet)
        (activity as Homework13Activity).bundle = bundle
        reverseFragment()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        const val CLICKED_SWEET = "CLICKED_SWEET"
        const val FIRST_FRAG_TAG = "FIRST_FRAG_TAG"
    }
}