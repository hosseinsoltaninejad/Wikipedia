package ir.hossein.wikipedia.activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import ir.hossein.wikipedia.R
import ir.hossein.wikipedia.data.ItemPost
import ir.hossein.wikipedia.databinding.ActivityDetailBinding
import ir.hossein.wikipedia.fragments.SEND_DATA_TO_DETAIL_ACTIVITY

class DetailActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar( binding.toolbarDetail )
        binding.collapsingMain.setExpandedTitleColor(
            ContextCompat.getColor(
                this,
                android.R.color.transparent
            )
        )
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val dataPost = intent.getParcelableExtra<ItemPost>(SEND_DATA_TO_DETAIL_ACTIVITY)
        if ( dataPost != null){
            showData( dataPost )
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return true
    }

    private fun showData(itemPost: ItemPost) {

        Glide
            .with(this)
            .load( itemPost.imgUrl )
            .into( binding.imgDetail )

        binding.txtDetailTitle.text = itemPost.txtTitle
        binding.txtDetailSubtitle.text = itemPost.txtSubtitle
        binding.txtDetailText.text = itemPost.txtDetail

        binding.fabDetailOpenWikipedia.setOnClickListener {

            // open wikipedia
            val url = "https://en.wikipedia.org/wiki/Main_Page"
            val intent = Intent( Intent.ACTION_VIEW , Uri.parse( url ))
            startActivity( intent )

        }
    }
}