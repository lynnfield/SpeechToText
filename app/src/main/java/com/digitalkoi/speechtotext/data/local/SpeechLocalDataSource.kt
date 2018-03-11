package com.digitalkoi.speechtotext.data.local

import android.content.Context
import android.content.SharedPreferences
import com.digitalkoi.speechtotext.util.SingletonHolderDoubleArg
import com.digitalkoi.speechtotext.data.SpeechDataSource
import com.digitalkoi.speechtotext.util.schedulers.BaseSchedulerProvider
import com.digitalkoi.speechtotext.util.Constants
import io.reactivex.Single

/**
 * @author Taras Zhupnyk (akka DigitalKoi) on 09/03/18.
 */

class SpeechLocalDataSource private constructor(
        context: Context,
        schedulerProvider: BaseSchedulerProvider
) : SpeechDataSource {

    private val sharedPreferences: SharedPreferences
    private val fontSizeDefault = 18f
    private var fontSize: Float
    private val editor: SharedPreferences.Editor

    init {
        sharedPreferences =
                context.getSharedPreferences(Constants.APP_SETTINGS, Context.MODE_PRIVATE)!!
        fontSize =
                sharedPreferences.getFloat(Constants.FONT_SIZE_SHARED_PREFERENCES, fontSizeDefault)
        editor = sharedPreferences.edit()
    }

    override fun getSpeech(): Single<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun refreshSpeech() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun zoomIn(): Single<Float> {
        fontSize += 2f
        editor.putFloat(Constants.FONT_SIZE_SHARED_PREFERENCES, fontSize)
        editor.apply()
        return Single.just(fontSize)
    }

    override fun zoomOut(): Single<Float> {
        fontSize -= 2
        editor.putFloat(Constants.FONT_SIZE_SHARED_PREFERENCES, fontSize)
        editor.apply()
        return Single.just(fontSize)
    }

    companion object : SingletonHolderDoubleArg<SpeechLocalDataSource, Context, BaseSchedulerProvider>(
            ::SpeechLocalDataSource
    )
}