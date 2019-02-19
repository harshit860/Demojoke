package com.example.harshitgakhar.multii

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerView.layoutManager = LinearLayoutManager(this)
       // recyclerView.adapter =  MainAdapter()

        fetchJson()



    }

    fun fetchJson(){
        println("Attempting to fetch json ")

       // val url = "http://api.icndb.com/jokes/"
val url = "http://api.icndb.com/jokes/random/10?limitTo=[nerdy]"
        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()

        client.newCall(request).enqueue(object: Callback
        {

            override fun onResponse(call: Call?, response: Response?) {
                val body= response?.body()?.string()
                println(body)

                val gson = GsonBuilder().create()

               val home= gson.fromJson(body,Home::class.java)


                runOnUiThread {
                    recyclerView.adapter=MainAdapter(home)


                }
            }



            override fun onFailure(call: Call?, e: IOException?) {
println("failed to execute")            }

        }
        )
    }


}

class Home(val value:List<valueee>)

class valueee(val id:Int, val joke:String)