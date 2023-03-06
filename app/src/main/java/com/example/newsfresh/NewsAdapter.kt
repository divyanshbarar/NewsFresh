package com.example.newsfresh

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.newsfresh.models.Article

class NewsAdapter(val context: Context, val articles: List<Article>, private val listener: MainActivity):Adapter<NewsAdapter.ArticleViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false)
        val viewHolder= ArticleViewHolder(view)
        view.setOnClickListener {
            listener.onItemClicked(articles[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article=articles[position]
        holder.author.text=article.author
        holder.title.text=article.title

        Glide.with(holder.itemView.context).load(article.urlToImage).into(holder.image)
    }
    class ArticleViewHolder(itemView: View) :ViewHolder(itemView)
    {
        var title=itemView.findViewById<TextView>(R.id.title)
        var author=itemView.findViewById<TextView>(R.id.author)
        var image: ImageView = itemView.findViewById(R.id.image)
    }

}

interface NewsItemClicked {
    fun onItemClicked(item: Article)
}