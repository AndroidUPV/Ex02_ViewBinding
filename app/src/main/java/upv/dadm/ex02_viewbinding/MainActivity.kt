/*
 * Copyright (c) 2022
 * David de Andrés and Juan Carlos Ruiz
 * Development of apps for mobile devices
 * Universitat Politècnica de València
 */

package upv.dadm.ex02_viewbinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import upv.dadm.ex02_viewbinding.databinding.ActivityMainBinding

/**
 * Displays some TextView whose text is set in the layout resource,
 * or at runtime from available string resources.
 * References to View objects are obtained via ViewBinding.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Get the automatically generated view binding for the layout resource,
        val binding = ActivityMainBinding.inflate(layoutInflater)
        // Set the activity content to the root element of the generated view
        setContentView(binding.root)

        // Change the View (TextView) properties at runtime: resource ID as parameter
        binding.tvRuntimeId.setText(R.string.going_on)

        // Change View (TextView) properties at runtime: String as parameter
        binding.tvRuntimeString.text = getString(R.string.anything_new)
    }
}