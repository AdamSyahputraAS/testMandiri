package com.adl.testmandiri


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.adl.testmandiri.services.Movie
import com.adl.testmandiri.model.THMovie
import com.adl.testmandiri.model.THMovieResponse
import com.adl.testmandiri.services.RetrofitConfig
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_movies_list.layoutManager = LinearLayoutManager(this)
        rv_movies_list
            .setHasFixedSize(true)
        getMovieData {genres: List<THMovie>->
            rv_movies_list.adapter = GenreAdapter(genres)

        }
    }

        private fun getMovieData(callback: (List<THMovie>) -> Unit){
            val apiService = RetrofitConfig.getInstance().create(Movie::class.java)

            apiService.getMovieList().enqueue(object : Callback<THMovieResponse> {
                override fun onResponse(call: Call<THMovieResponse>, response: Response<THMovieResponse>) {
                   return callback(response.body()!!.movies)

                }
                override fun onFailure(call: Call<THMovieResponse>, t: Throwable) {
                    Toast.makeText(this@MainActivity,"notfound",Toast.LENGTH_LONG).show()
                }
        })
   }
}
