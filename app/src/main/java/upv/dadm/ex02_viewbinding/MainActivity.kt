/*
 * Copyright (c) 2022-2023 Universitat Politècnica de València
 * Authors: David de Andrés and Juan Carlos Ruiz
 *          Fault-Tolerant Systems
 *          Instituto ITACA
 *          Universitat Politècnica de València
 *
 * Distributed under MIT license
 * (See accompanying file LICENSE.txt)
 */

package upv.dadm.ex02_viewbinding

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import upv.dadm.ex02_viewbinding.databinding.ActivityMainBinding

/**
 * Displays some TextView whose text is set in the layout resource,
 * or at runtime from available string resources.
 * References to View objects are obtained via ViewBinding.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enable edge-to-edge display (default for API 35+)
        enableEdgeToEdge()

        // Get the automatically generated view binding for the layout resource,
        val binding = ActivityMainBinding.inflate(layoutInflater)
        // Set the activity content to the root element of the generated view
        setContentView(binding.root)

        // Get side margins in pixels
        val sideMarginPx = resources.getDimensionPixelSize(R.dimen.main_side_margins)
        // Prevent the layout from overlapping with system bars in edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(sideMarginPx, systemBars.top, sideMarginPx, systemBars.bottom)
            insets
        }

        // Change the View (TextView) properties at runtime: resource ID as parameter
        binding.tvRuntimeId.setText(R.string.going_on)

        // Change View (TextView) properties at runtime: String as parameter
        binding.tvRuntimeString.text = getString(R.string.anything_new)
    }
}