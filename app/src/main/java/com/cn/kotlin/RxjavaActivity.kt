package com.cn.kotlin

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.BottomSheetBehavior
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Button
import io.reactivex.Observable
import io.reactivex.functions.Consumer
import org.reactivestreams.Subscriber
import java.util.*


class RxjavaActivity : AppCompatActivity() {

    val subscribe: Button by lazy {
        findViewById(R.id.subscribe) as Button
    }
    val unSubscribe: Button by lazy {
        findViewById(R.id.unSubscribe) as Button
    }

    val recycler: RecyclerView by lazy {
        findViewById(R.id.forecast_list) as RecyclerView
    }

    val bsb  by lazy {
        BottomSheetBehavior.from(findViewById(R.id.forecast_list))
    }

    var words = listOf("Hello", "Hi", "Aloha")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rxjava)


        bsb.state = BottomSheetBehavior.STATE_HIDDEN

        subscribe.setOnClickListener {
            if (bsb.state == BottomSheetBehavior.STATE_HIDDEN) {
                bsb.state = BottomSheetBehavior.STATE_EXPANDED
            } else {
                bsb.state = BottomSheetBehavior.STATE_HIDDEN
            }
        }
        recycler.layoutManager = LinearLayoutManager(this)
//        recycler.adapter = NRecyclerAdapter(words)

        val students =ArrayList<Student>()

        for (i in 0..9) {
            val student = Student(if (i % 2 == 0) "小红" + i else "小明" + i, if (i % 2 == 0) "女" else "男")
            students.add(student)
        }

        recycler.adapter=StudentAdapter(students)


//        val subscriber: Subscriber<in Array<String>>? = object : Subscriber<Array <String>>() {
//            override fun onNext(t: Array<String>?) {
//                t?.map(::println)
//                println("t====${t?.get(0)}")
//            }
//
//
//            override fun onError(e: Throwable?) {
//            }
//
//
//            override fun onComplete() {
//            }
//
//        }
//        Observable.just("images/logo.png") // 输入类型 String
//                .map(Consumer<String, Bitmap> { filePath ->
//                    // 参数类型 String
//                    getBitmapFromPath(filePath) // 返回类型 Bitmap
//                })
//                .subscribe { bitmap ->
//                    // 参数类型 Bitmap
//                    showBitmap(bitmap)
//                }
//
//
//
//
//
//        subscribe.setOnClickListener {
//
////            observable1.subscribe(subscriber)
//
//        }

    }

    fun showBitmap(bitmap: Bitmap?) {

    }

    fun getBitmapFromPath(filePath: String?): Bitmap? {

        return BitmapFactory.decodeFile(filePath)
    }
}

