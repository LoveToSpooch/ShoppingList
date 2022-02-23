package cheers.lovetospooch.shoppinglist.presentation


import android.view.LayoutInflater
import android.view.ViewGroup
import cheers.lovetospooch.shoppinglist.R
import cheers.lovetospooch.shoppinglist.domain.ShopItem

class ShopListAdapter : androidx.recyclerview.widget.ListAdapter<ShopItem, ShopItemViewHolder>(ShopItemDiffCallback()) {

    var onShopLongClickListener: ((ShopItem) -> Unit)? = null
    var onShopClickListener: ((ShopItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
        val layout = when(viewType) {
            STATE_ENABLE -> R.layout.shop_item_enabled
            STATE_DISABLE -> R.layout.shop_item_disabled
            else -> throw RuntimeException("Unknown layout: $viewType")
        }
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ShopItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) {
        val shopItem = getItem(position)

        holder.itemView.setOnLongClickListener {
           onShopLongClickListener?.invoke(shopItem)
           true
       }

        holder.itemView.setOnClickListener {
            onShopClickListener?.invoke(shopItem)
        }
        holder.tvName.text = shopItem.name
        holder.tvQuantity.text = shopItem.count.toString()
    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return if(item.enabled) {
            STATE_ENABLE
        } else {
            STATE_DISABLE
        }
    }

    companion object {
        const val STATE_ENABLE = 1
        const val STATE_DISABLE = 0
        const val MAX_POOL_SIZE = 15
    }
}