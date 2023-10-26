package com.example.practicerecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = listOf(
            DataModel("SDU University", "This email is about...", "Lessons Schedule", "25 Oct", R.drawable.logo_sdu),
            DataModel("LeetCode", "This email is about...", "Daily Challenges", "24 Oct", R.drawable.no_profile),
            DataModel("Google", "This email is about...", "Account Verification", "14 Sep", R.drawable.google_logo),
            DataModel("Microsoft", "This email is about...", "Lessons Schedule", "24 Oct", R.drawable.microsoft_logo),
            DataModel("GitHub", "This email is about...", "Security Advisory", "24 Oct", R.drawable.github_logo),
            DataModel("SDU Library", "This email is about...", "Lessons Schedule", "24 Oct", R.drawable.sdu_library),
            DataModel("Pinterest", "This email is about...", "New Boards", "24 Oct", R.drawable.pinterest_logo),
            DataModel("SDU Library", "This email is about...", "Lessons Schedule", "24 Oct", R.drawable.sdu_library),
            DataModel("Figma ", "This email is about...", "Lessons Schedule", "24 Oct", R.drawable.no_profile),
            DataModel("Amazon", "This email is about...", "Lessons Schedule", "24 Oct", R.drawable.amazon_logo),
            DataModel("Amazon AWS", "This email is about...", "Lessons Schedule", "24 Oct", R.drawable.no_profile),
            DataModel("SDU University", "This email is about...", "Lessons Schedule", "25 Oct", R.drawable.logo_sdu),
            )

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = RecyclerViewAdapter(data) { dataModel ->
            supportFragmentManager.beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .addToBackStack(null)
                .commit()
        }
        recyclerView.adapter = adapter
    }
}
