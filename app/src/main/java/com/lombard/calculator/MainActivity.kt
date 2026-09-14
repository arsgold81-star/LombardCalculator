package com.lombard.calculator

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.widget.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.setPadding(32, 32, 32, 32)

        val title = TextView(this)
        title.text = "ЛОМБАРД"
        title.textSize = 28f
        title.setTextColor(Color.BLACK)
        title.gravity = Gravity.CENTER
        layout.addView(title)

        val amount = EditText(this)
        amount.hint = "Сумма займа, ₽"
        amount.inputType = 2
        layout.addView(amount)

        val percent = EditText(this)
        percent.hint = "Процент в день, %"
        percent.inputType = 8194
        layout.addView(percent)

        val days = EditText(this)
        days.hint = "Количество дней"
        days.inputType = 2
        layout.addView(days)

        val button = Button(this)
        button.text = "РАССЧИТАТЬ"
        layout.addView(button)

        val result = TextView(this)
        result.textSize = 20f
        result.setPadding(0, 30, 0, 0)
        layout.addView(result)

        button.setOnClickListener {
            val sum = amount.text.toString().toDoubleOrNull() ?: 0.0
            val rate = percent.text.toString().toDoubleOrNull() ?: 0.0
            val dayCount = days.text.toString().toIntOrNull() ?: 0

            val interest = sum * rate / 100 * dayCount
            val total = sum + interest

            result.text = """
                Начальная сумма: %.2f ₽
                Начислено процентов: %.2f ₽
                К возврату: %.2f ₽
            """.trimIndent().format(sum, interest, total)
        }

        setContentView(layout)
    }
}
