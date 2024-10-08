package com.example.sp22_bse_6a_demo.users.adopter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sp22_bse_6a_demo.databinding.UserRowBinding
import com.example.sp22_bse_6a_demo.users.model.User

class UserAdopter(diffCallback: DiffUtil.ItemCallback<User>) :
    ListAdapter<User, UserAdopter.UserViewHolder>(diffCallback) {


    class UserViewHolder(var binding: UserRowBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = UserRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return UserViewHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val dataItem = getItem(position)
        holder.binding.user = dataItem
//        val nameTV = holder.itemView.findViewById<TextView>(R.id.user_row_name)
//        val ageTV = holder.itemView.findViewById<TextView>(R.id.user_row_age)
//        nameTV.setText(dataItem.name)
//        ageTV.setText(dataItem.age.toString())
    }


    object diffCallBack: DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return false
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return false
        }

    }
}
