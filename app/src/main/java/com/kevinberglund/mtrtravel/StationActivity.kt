package com.kevinberglund.mtrtravel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import com.kevinberglund.mtrtravel.databinding.ActivityStationSelectorBinding
import com.kevinberglund.mtrtravel.extension.lifecycleAwareViewModel
import com.kevinberglund.mtrtravel.viewmodel.StationViewModel

class StationActivity : AppCompatActivity() {

    private val stationViewModel by lifecycleAwareViewModel {
        StationViewModel(MtrApplication.INSTANCE.useCaseFactory)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DataBindingUtil.setContentView<ActivityStationSelectorBinding>(
            this,
            R.layout.activity_station_selector
        ).apply {
            lifecycleOwner = this@StationActivity
            viewModel = stationViewModel
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}