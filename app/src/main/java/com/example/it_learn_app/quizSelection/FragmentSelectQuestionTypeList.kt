package com.example.it_learn_app.quizSelection

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.it_learn_app.R
import com.example.it_learn_app.databinding.FragmentSelectQuestionTypeListListBinding
import com.example.it_learn_app.model.QuestionManagerViewModel

/**
 * A fragment representing a list of Items.
 */
class FragmentSelectQuestionTypeList : Fragment() {

    val questionManagerViewModel: QuestionManagerViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = FragmentSelectQuestionTypeListListBinding.inflate(layoutInflater,container,false).
        apply {
            list.adapter = SelectQuestionTypeListRecyclerViewAdapter(this@FragmentSelectQuestionTypeList){
                questionManagerViewModel.setQuestData(it.questionCreator)
                findNavController().navigate(R.id.action_fragmentSelectQuestionTypeList_to_quizGame)
            }
        }

        return view.root
    }
}