package com.example.it_learn_app.quizSelection

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import com.example.it_learn_app.data.QuizData
import com.example.it_learn_app.data.QuizDataSource
import com.example.it_learn_app.databinding.FragmentSelectQuestionTypeListBinding


class SelectQuestionTypeListRecyclerViewAdapter(val lifecycleOwner: LifecycleOwner,val onClick: (QuizData) -> Unit) : RecyclerView.Adapter<SelectQuestionTypeListRecyclerViewAdapter.QuizDataViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizDataViewHolder {
        return QuizDataViewHolder(
            FragmentSelectQuestionTypeListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    class QuizDataViewHolder(val binding: FragmentSelectQuestionTypeListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindView(lifecycleOwner: LifecycleOwner,quizData:QuizData,callBack: (QuizData) -> Unit){
            binding.lifecycleOwner = lifecycleOwner
            binding.quizData = quizData
            binding.root.setOnClickListener{callBack(quizData)}
        }
    }

    override fun getItemCount(): Int {
        return QuizDataSource.quizSource.size
    }

    override fun onBindViewHolder(holder: QuizDataViewHolder, position: Int) {
        val item = QuizDataSource.quizSource[position]
        holder.bindView(lifecycleOwner,item,onClick)
    }
}