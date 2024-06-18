package com.harjot.fragmentspractice

import android.app.Dialog
import android.content.Context
import android.content.pm.ActivityInfo.WindowLayout
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import com.harjot.fragmentspractice.databinding.FragmentFirstBinding
import com.harjot.fragmentspractice.databinding.TestDialogLayoutBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var mainActivity : MainActivity?=null
    var binding : FragmentFirstBinding?= null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Toast.makeText(requireContext(), "onAttach", Toast.LENGTH_SHORT).show()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            Toast.makeText(requireContext(), "onCreate", Toast.LENGTH_SHORT).show()
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Toast.makeText(requireContext(), "onCreateView", Toast.LENGTH_SHORT).show()
        mainActivity = activity as MainActivity
        binding = FragmentFirstBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        binding?.btnCsDialog?.setOnClickListener {
            var dialog = Dialog(mainActivity!!)
            var dialogBinding = TestDialogLayoutBinding.inflate(layoutInflater)
            dialog.setContentView(dialogBinding.root)
            dialog.window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT)
            dialogBinding.btnOk.setOnClickListener {
                if (dialogBinding.etText.text.toString().trim().isNullOrEmpty()){
                    dialogBinding.etText.error = "Enter Text"
                }else{
                    dialog.dismiss()
                }
            }
            dialog.show()
        }
        return binding?.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FirstFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(mainActivity, "onResume", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(mainActivity, "onDestroy", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Toast.makeText(mainActivity, "onDestroyedView", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(mainActivity, "onPause", Toast.LENGTH_SHORT).show()
    }

    override fun onDetach() {
        super.onDetach()
        Toast.makeText(mainActivity, "onDetach", Toast.LENGTH_SHORT).show()
    }
}