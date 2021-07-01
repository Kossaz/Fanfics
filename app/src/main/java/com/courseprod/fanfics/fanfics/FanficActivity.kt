package com.courseprod.fanfics.fanfics

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.EditText
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.courseprod.fanfics.util.Resource
import com.courseprod.fanfics.databinding.ActivityFanficBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FanficActivity : AppCompatActivity() {

    private val viewModel: FanficViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFanficBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fanficAdapter = FanficAdapter()
        binding.apply {
            recyclerView.apply {
                adapter = fanficAdapter
                layoutManager = LinearLayoutManager(this@FanficActivity)
                viewModel.fanfics.observe(this@FanficActivity) { result ->
                    fanficAdapter.submitList(result.data)

                    progressBar.isVisible =
                        result is Resource.Loading && result.data.isNullOrEmpty()
                    textViewError.isVisible =
                        result is Resource.Error && result.data.isNullOrEmpty()
                    textViewError.text = result.error?.localizedMessage
                }
            }
        }
    }
}