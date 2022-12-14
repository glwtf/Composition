package com.example.composition.presentation

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.composition.R
import com.example.composition.domain.entity.GameResult

@BindingAdapter("requiredAnswers")
fun bindRequiredAnswers(textView: TextView, count : Int) {
    textView.text = String.format(
        textView.context.getString(R.string.required_score),
        count
    )
}

@BindingAdapter("scoreAnswers")
fun bindScoreAnswers(textView: TextView, count : Int) {
    textView.text = String.format(
        textView.context.getString(R.string.score_answers),
        count
    )
}

@BindingAdapter("requiredPercent")
fun bindRequiredPercent(textView: TextView, percent : Int) {
    textView.text = String.format(
        textView.context.getString(R.string.required_percentage),
        percent
    )
}

@BindingAdapter("scorePercent")
fun bindScorePercent(textView: TextView, gameResult: GameResult, ) {
    val percentValue = if (gameResult.countOfQuestions == 0) 0
    else ((gameResult.countOfRightAnswers / gameResult.countOfQuestions.toDouble()) * 100).toInt()

    textView.text = String.format(
        textView.context.getString(R.string.score_percentage),
        percentValue
    )
}

@BindingAdapter("emoji")
fun bindEmoji(imageView: ImageView, winner: Boolean, ) {
   val resourceId = when (winner) {
       true -> R.drawable.ic_smile
       false -> R.drawable.ic_sad
   }
   imageView.setImageResource(resourceId)
}