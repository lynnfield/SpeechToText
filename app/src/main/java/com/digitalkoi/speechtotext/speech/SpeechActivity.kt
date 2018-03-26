package com.digitalkoi.speechtotext.speech

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.digitalkoi.speechtotext.R
import com.digitalkoi.speechtotext.history.HistoryActivity
import com.digitalkoi.speechtotext.history.HistoryFragment
import com.digitalkoi.speechtotext.util.addFragmentToActivity

class SpeechActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.speech_act)

    if (supportFragmentManager.findFragmentById(R.id.speechContainer) == null) {
      addFragmentToActivity(supportFragmentManager, SpeechFragment(), R.id.speechContainer)
    }
  }

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.menu_speech, menu)
    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    if (item.itemId == R.id.menu_history) {
      val intent = Intent(this, HistoryActivity::class.java)
      startActivity(intent)
      return true
    }
    return super.onOptionsItemSelected(item)
  }

}
