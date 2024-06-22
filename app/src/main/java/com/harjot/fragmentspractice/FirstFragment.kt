package com.harjot.fragmentspractice

import android.app.Dialog
import android.content.Context
import android.content.pm.ActivityInfo.WindowLayout
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.material.textfield.TextInputLayout.LengthCounter
import com.harjot.fragmentspractice.databinding.FragmentFirstBinding
import com.harjot.fragmentspractice.databinding.TestDialogLayoutBinding
import kotlin.properties.Delegates

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment(),ActivityInterface {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var mainActivity : MainActivity?=null
    lateinit var binding : FragmentFirstBinding
    var counter=0
    private val TAG = "FirstFragment"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity = activity as MainActivity
        arguments?.let {
//            Toast.makeText(requireContext(), "onCreate", Toast.LENGTH_SHORT).show()
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        Toast.makeText(requireContext(), "onCreateView", Toast.LENGTH_SHORT).show()
        binding = FragmentFirstBinding.inflate(layoutInflater)
        mainActivity?.activityInterface = this
        // Inflate the layout for this fragment
//        binding?.btnCsDialog?.setOnClickListener {
//            mainActivity?.textChange("")
//            var dialog = Dialog(mainActivity!!)
//            var dialogBinding = TestDialogLayoutBinding.inflate(layoutInflater)
//            dialog.setContentView(dialogBinding.root)
//            dialog.window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT)
//            dialogBinding.btnOk.setOnClickListener {
//                if (dialogBinding.etText.text.toString().trim().isNullOrEmpty()){
//                    dialogBinding.etText.error = "Enter Text"
//                }else{
//                    dialog.dismiss()
//                }
//            }
//            dialog.show()
//        }
        binding.firstFragment.setOnClickListener {
            binding.firstFragment.setBackgroundColor(ContextCompat.getColor(mainActivity!!,R.color.white))

        }
        binding.btnPassValue.setOnClickListener {
            if (binding.etText.text.toString().trim().isNullOrEmpty()){
                binding.etText.error = "Enter Text"
            }else{
                mainActivity?.textChange(binding.etText.text.toString().trim())
            }
        }
        binding.btnInc.setOnClickListener {
            counter++
            mainActivity?.counterUpdate(counter)
            Log.e(TAG, "Inc: ${counter}", )
        }
        binding.btnDec.setOnClickListener {
            counter--
            mainActivity?.counterUpdate(counter)
            Log.e(TAG, "dec: ${counter} ", )
        }
        binding.btnReset.setOnClickListener {
            counter=0
            mainActivity?.counterUpdate(0)
            Log.e(TAG, "reset: $counter", )
        }
        return binding.root
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

    override fun colorChange(color: Int) {
        when(color){
            1->binding.firstFragment.setBackgroundColor(ContextCompat.getColor(mainActivity!!,R.color.red))
            2->binding.firstFragment.setBackgroundColor(ContextCompat.getColor(mainActivity!!,R.color.green))
            3->binding.firstFragment.setBackgroundColor(ContextCompat.getColor(mainActivity!!,R.color.blue))
        }
    }

    override fun textUpdate(text: String) {
        binding.etText.setText(text)
    }
}