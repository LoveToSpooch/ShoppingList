package cheers.lovetospooch.shoppinglist.presentation

import androidx.recyclerview.widget.DiffUtil
import cheers.lovetospooch.shoppinglist.domain.ShopItem
import java.util.*

class ShopItemDiffCallback: DiffUtil.ItemCallback<ShopItem>() {
    override fun areItemsTheSame(oldItem: ShopItem, newItem: ShopItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ShopItem, newItem: ShopItem): Boolean {
        return oldItem == newItem
    }
}