package com.example.fragmentbundle

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragmentbundle.databinding.FragmentOneBinding

class OneFragment : Fragment() {

    private var mBinding: FragmentOneBinding? = null
    private val binding get() = mBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_one, container, false)
        mBinding = FragmentOneBinding.inflate(inflater, container, false)

        if(arguments != null){
            binding.tvNameFrag1.text = arguments?.getString("frag2")
        }

        binding.btnFrag1.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("frag1", "프래그먼트 프로그래밍 1")
            val fragTra = activity?.supportFragmentManager?.beginTransaction()!!
            val two = TwoFragment()
            two.arguments = bundle
            fragTra.replace(R.id.frameLayout, two)
            fragTra.commit()
        }

        return binding.root

    }

    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()
    }

}