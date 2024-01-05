package com.example.fragmentbundle

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragmentbundle.databinding.FragmentTwoBinding

class TwoFragment : Fragment() {

    private var mBinding: FragmentTwoBinding? = null
    private val binding get() = mBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_two, container, false)
        mBinding = FragmentTwoBinding.inflate(inflater, container, false)

        if(arguments != null){
            binding.tvNameFrag2.text = arguments?.getString("frag1")
        }

        binding.btnFrag2.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("frag2", "프래그먼트 프로그래밍 2")
            val fragTra = activity?.supportFragmentManager?.beginTransaction()!!
            val one = OneFragment()
            one.arguments = bundle
            fragTra.replace(R.id.frameLayout, one)
            fragTra.commit()
        }

        return binding.root
    }

    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()
    }

}