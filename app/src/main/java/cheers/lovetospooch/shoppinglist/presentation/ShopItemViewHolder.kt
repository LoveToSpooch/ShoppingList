package cheers.lovetospooch.shoppinglist.presentation

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cheers.lovetospooch.shoppinglist.R

class ShopItemViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val tvName = view.findViewById<TextView>(R.id.textViewName)
    val tvQuantity = view.findViewById<TextView>(R.id.textViewQuantity)
}