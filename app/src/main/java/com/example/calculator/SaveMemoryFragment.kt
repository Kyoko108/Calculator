package com.example.calculator

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.calculator.databinding.MemoryBinding
import kotlinx.android.synthetic.main.activity_main.*

class SaveMemoryFragment : Fragment(R.layout.memory) {

    private val viewModel by activityViewModels<MemoryViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val binding = MemoryBinding.bind(view)

        binding.Save.setOnClickListener {
            val data = Input.text.toString() + "=" + Output.text.toString()
            if (data.isNotEmpty()) {
                viewModel.saveMemory(data)
            binding.meMory.text = (binding.meMory.text.toString()+data)
            }
        }
    }
}