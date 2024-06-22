package com.harjot.fragmentspractice

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import com.harjot.fragmentspractice.databinding.FragmentFirstBinding
import com.harjot.fragmentspractice.databinding.FragmentTaskBinding
import com.harjot.fragmentspractice.databinding.TestDialogLayoutBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TaskFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TaskFragment : Fragment() {
    var mainActivity : MainActivity?=null
    lateinit var binding : FragmentTaskBinding
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Toast.makeText(requireContext(), "onAttach", Toast.LENGTH_SHORT).show()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        Toast.makeText(requireContext(), "onCreate", Toast.LENGTH_SHORT).show()
        super.onCreate(savedInstanceState)
        mainActivity = activity as MainActivity
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Toast.makeText(requireContext(), "onCreateView", Toast.LENGTH_SHORT).show()
        binding = FragmentTaskBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.btnCsDialog?.setOnClickListener {
            mainActivity?.textChange("")
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

    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TaskFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TaskFragment().apply {
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