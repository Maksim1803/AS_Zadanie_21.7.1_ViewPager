package com.example.zadanie2171_viewpager

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.zadanie2171_viewpager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Объявляем переменную для ViewBinding:
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Инициализируем binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Создаем адаптер
        val pagerAdapter = ViewPagerAdapter()

        //Привязываем созданный адаптер к нашему ViewPager, который у нас в разметке
        binding.viewPager2.adapter = pagerAdapter

        //Создаем список элементов, который передадим в адаптер
        val pagerItems = listOf<PagerItem>(
            PagerItem(ContextCompat.getColor(this, R.color.colorRed), "Red"),
            PagerItem(ContextCompat.getColor(this, R.color.colorGreen), "Green"),
            PagerItem(ContextCompat.getColor(this, R.color.colorYellow), "Yellow")
        )

        //Передаем список в адаптер
        pagerAdapter.setItems(pagerItems)

        //Визуальный эффект с запаздыванием при листании:
        binding.viewPager2.setPageTransformer { page, position ->
            val pagerWidth = page.width
        page.findViewById<TextView>(R.id.textView).translationX = -position * (pagerWidth / 2)
        }
    }
}
