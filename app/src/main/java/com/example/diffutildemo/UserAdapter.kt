package com.example.diffutildemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class UserAdapter : RecyclerView.Adapter<UserAdapter.VHolder>() {

    private val userList = mutableListOf<User>()

    inner class VHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(user: User) {
            itemView.apply {
                findViewById<TextView>(R.id.tv_id).text = user.id.toString()
                findViewById<TextView>(R.id.tv_name).text = user.name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return VHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: VHolder, position: Int) {
        holder.bind(userList[position])
    }

    fun swapItems(new_user_list: List<User>) {
        val user_diff_callback = UserDiffCallback(userList, new_user_list)
        val diff_result = DiffUtil.calculateDiff(user_diff_callback)

        userList.clear()
        userList.addAll(new_user_list)
        diff_result.dispatchUpdatesTo(this)
    }
}