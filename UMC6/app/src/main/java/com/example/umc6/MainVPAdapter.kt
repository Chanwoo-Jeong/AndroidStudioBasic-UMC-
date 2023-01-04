package com.example.umc6

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter

//Fragment에서 viewpage2 어뎁터를 연결하려면 getActivity를 써야한다.
//fragment: Fragment를 넣어도 됌 // 정확히 뭘 넣어야하는지 모르겟음
class MainVPAdapter(fragment: Fragment):FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0-> OneFragment()
            1-> TwoFragment()
            2-> ThreeFragment()
            else ->OneFragment()
        }
    }
}