package cheers.lovetospooch.shoppinglist.domain

import androidx.lifecycle.LiveData

interface ShopListRepository {

    fun addToShopItem(shopItem: ShopItem)

    fun deleteShopItem(shopItem: ShopItem)

    fun editShopItem(shopItem: ShopItem)

    fun getIdItem(shopItemId: Int): ShopItem

    fun getShopList(): LiveData<List<ShopItem>>

}