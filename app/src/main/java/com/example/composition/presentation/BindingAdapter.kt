package com.example.composition.presentation

import android.content.Context
import android.content.res.ColorStateList
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.example.composition.R
import com.example.composition.domain.entity.GameResult

interface OnOptionClickListener {
    fun onOptionClickListener(option: Int)
}

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

@BindingAdapter("progressBar")
fun bindProgressBar(progressBar: ProgressBar, percent: Int){
    progressBar.setProgress(percent, true)
}

@BindingAdapter("enoughCount")
fun bindEnoughCount(textView: TextView, state : Boolean) {
    val color = getColorByState(textView.context, state)
    textView.setTextColor(color)
}

@BindingAdapter("enoughPercent")
fun bindEnoughPercent(progressBar: ProgressBar, state : Boolean) {
    val color = getColorByState(progressBar.context, state)
    progressBar.progressTintList = ColorStateList.valueOf(color)
}

private fun getColorByState(context : Context, state : Boolean) : Int {
    val colorId = when (state) {
        true -> R.color.green
        false -> R.color.red
    }
    return ContextCompat.getColor(context, colorId)
}

@BindingAdapter("numberAsText")
fun bindNumberAsText(textView: TextView, number : Int) {
    textView.text = number.toString()
}

@BindingAdapter("onOptionClickListener")
fun bindOnOptionClickListener(textView: TextView, clickable: OnOptionClickListener) {
    textView.setOnClickListener {
        clickable.onOptionClickListener(textView.text.toString().toInt())
    }
}