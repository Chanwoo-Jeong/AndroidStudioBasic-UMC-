package com.example.umc7

import android.media.AudioManager
import android.media.SoundPool
import android.os.Build.VERSION_CODES.M
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.PointerIcon.load
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.umc7.databinding.ActivityMainBinding
import java.text.BreakIterator
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        var total = 0
        var started = false
        val handler = Handler(Looper.getMainLooper())

        var SoundPool = SoundPool.Builder()
            .setMaxStreams(1)
            .build()
        var SoundId= SoundPool.load(this, R.raw.sound2, 1)

        viewBinding.StartButton.setOnClickListener {
            var M = viewBinding.Minute.getText().toString().toInt()
            var S = viewBinding.Second.getText().toString().toInt()

            if (M === 0 && S === 0) {
                started = false
            } else {
                    if (started === false) { // started 값이 false일 경우
                        started = true // started 값을 true로 변경하면서 시작
                        viewBinding.Minute.clearFocus()
                        viewBinding.Second.clearFocus()
                        total = M*60 + S

                        thread() { // 스레드 생성
                            while (started) { // started 값이true일 경우 반복
                                Thread.sleep(1000) // 1초 지연
                                if (started) { // started 값이 true일 경우
                                    total -= 1 // 1초씩 감소
                                    handler.post {
                                        val minute = String.format("%02d", total / 60) // 분
                                        val second = String.format("%02d", total % 60) // 초

                                        viewBinding.Minute.setText(minute)
                                        viewBinding.Second.setText(second)

                                        if (minute === "00") {
                                            if (second === "00") {
                                                started = false
                                                SoundPool.play(SoundId, 1f, 1f, 0, 0, 1f)
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

        }

        viewBinding.StopButton.setOnClickListener {
            started =false
         }

        viewBinding.ResetButton.setOnClickListener {
            started=false
            viewBinding.Minute.setText("00")
            viewBinding.Second.setText("00")
        }
    }
}