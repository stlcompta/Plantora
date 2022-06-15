import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.plantora.R
import com.example.plantora.data.classes.Post

class PostAdaptor (

    var mContext : Context,
    var ressource : Int,
    var values : ArrayList<Post>
) : ArrayAdapter<Post>(mContext,ressource, values){

    override fun getView (position : Int, convertView: View?, parent : ViewGroup) : View{
        val post = values[position]
        val itemView = LayoutInflater.from(mContext).inflate(ressource,parent,false)
        val tvTitre = itemView.findViewById<TextView>(R.id.tvTitre)
        val tvCity = itemView.findViewById<TextView>(R.id.tvCity)
        val imagepostplant = itemView.findViewById<ImageView>(R.id.imagepostplant)
        tvTitre.text = post.title
        tvTitre.text = post.city
        val bitmap = getBitmap(post.image)
        imagepostplant.setImageBitmap(bitmap)



        return itemView

    }

    fun getBitmap(byteArray: ByteArray) : Bitmap {
        val bitmap = BitmapFactory.decodeByteArray(byteArray, 0 , byteArray.size)
        return bitmap
    }



}