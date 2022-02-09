package cheers.lovetospooch.shoppinglist.data

import cheers.lovetospooch.shoppinglist.domain.ShopItem
import cheers.lovetospooch.shoppinglist.domain.ShopListRepository
import java.lang.RuntimeException

object ShopListRepositoryImpl: ShopListRepository {

    private val shopList = mutableListOf<ShopItem>()

    private var autoIncrementId = 0

    override fun addToShopItem(shopItem: ShopItem) {
        if(shopItem.id == ShopItem.UNDEFINED_ID) {
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldElement = getIdItem(shopItem.id)
        shopList.remove(oldElement)
        addToShopItem(shopItem)
    }

    override fun getIdItem(shopItemId: Int): ShopItem {
        return shopList.find { it.id == shopItemId} ?: throw RuntimeException("Can not find $shopItemId")
    }

    override fun getShopList(): List<ShopItem> {
        return shopList.toList()
    }
}