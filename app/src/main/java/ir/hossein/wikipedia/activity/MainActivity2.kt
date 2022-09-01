package ir.hossein.wikipedia.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import ir.hossein.wikipedia.R
import ir.hossein.wikipedia.databinding.ActivityMain2Binding
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

class MainActivity2 : AppCompatActivity() {

    lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide
            .with( this )
            .load( R.drawable.img_translator )
            .transform( RoundedCornersTransformation( 32 , 8 ) )
            .into( binding.imgTranslator )
    }
}