package com.example.sp22_bse_6a_demo.users.adopter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sp22_bse_6a_demo.databinding.UserRowBinding
import com.example.sp22_bse_6a_demo.users.model.User

class UserAdopter(diffCallback: DiffUtil.ItemCallback<User>) :
    ListAdapter<User, UserAdopter.UserViewHolder>(diffCallback) {
    private val tag = this@UserAdopter.javaClass.name

    class UserViewHolder(var binding: UserRowBinding, var ctx: Context) :
        RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = UserRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding = binding, ctx = parent.context)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val dataItem = getItem(position)
        holder.binding.user = dataItem

        holder.binding.root.setOnClickListener {
            Toast.makeText(holder.ctx, "Row (${position+1}) clicked", Toast.LENGTH_SHORT).show()
        }

//        val nameTV = holder.itemView.findViewById<TextView>(R.id.user_row_name)
//        val ageTV = holder.itemView.findViewById<TextView>(R.id.user_row_age)
//        nameTV.setText(dataItem.name)
//        ageTV.setText(dataItem.age.toString())
    }


    object diffCallBack : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return false
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return false
        }

    }
}
