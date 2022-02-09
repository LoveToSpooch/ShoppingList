package cheers.lovetospooch.shoppinglist.domain

interface ShopListRepository {

    fun addToShopItem(shopItem: ShopItem)

    fun deleteShopItem(shopItem: ShopItem)

    fun editShopItem(shopItem: ShopItem)

    fun getIdItem(shopItemId: Int): ShopItem

    fun getShopList(): List<ShopItem>

}