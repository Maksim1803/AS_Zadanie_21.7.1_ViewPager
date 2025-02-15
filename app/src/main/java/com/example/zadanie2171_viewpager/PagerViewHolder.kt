package com.example.zadanie2171_viewpager

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.zadanie2171_viewpager.databinding.ItemBinding

class PagerViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
    //Объявление и инициализация переменной для View Binding:
    private var binding: ItemBinding = ItemBinding.bind(itemView)

    // В этом методе мы передаем данные из PagerItem в нашу верстку item.xml
    fun onBind(item: PagerItem) {

        // Устанавливаем цвет фонового элемента (обращение через биндинг)
        binding.container.setBackgroundColor(item.color)
        // Устанавливаем текстовое поле (обращение через биндинг)
        binding.textView.text = item.text
    }
}