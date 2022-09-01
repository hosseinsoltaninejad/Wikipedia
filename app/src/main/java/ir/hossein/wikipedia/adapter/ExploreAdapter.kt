package ir.hossein.wikipedia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ir.hossein.wikipedia.data.ItemPost
import ir.hossein.wikipedia.databinding.ItemExploreBinding

class ExploreAdapter(private val data: List<ItemPost>, private val itemEvents: ItemEvents) : RecyclerView.Adapter<ExploreAdapter.ExploreViewHolder>() {

    lateinit var binding: ItemExploreBinding

    inner class ExploreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindViews(itemPost: ItemPost) {

             val glide = Glide
                .with(itemView.context)
                .load(itemPost.imgUrl)
                .into(binding.imgExploreMain)

            binding.txtExploreTitle.text = itemPost.txtTitle
            binding.txtExploreSubtitle.text = itemPost.txtSubtitle
            binding.txtExploreDetail.text = itemPost.txtDetail

            itemView.setOnClickListener {
                  itemEvents.onItemClicked( itemPost )
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploreViewHolder {
        binding = ItemExploreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExploreViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ExploreViewHolder, position: Int) {
        holder.bindViews(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

}