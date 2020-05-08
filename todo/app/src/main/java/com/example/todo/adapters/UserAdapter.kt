package com.example.todo.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.R
import com.example.todo.TodoActivity
import com.example.todo.api.dto.User
import kotlinx.android.synthetic.main.user_item.view.*

class UserAdapter(private var users: List<User>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        init {
            itemView.setOnClickListener(this)
        }

        private lateinit var user: User

        fun bind(user: User) {
            this.user = user

            itemView.fullNameTextView.text = user.name
            itemView.emailTextView.text = user.email
        }

        override fun onClick(v: View?) {
            val context = itemView.context
            val intent = Intent(context, TodoActivity::class.java)
            intent.putExtra("USER_ID", user.id)
            context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        return UserViewHolder(v)
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(users[position])
    }

    fun updateUsers(users: List<User>) {
        this.users = users
        notifyDataSetChanged()
    }

}