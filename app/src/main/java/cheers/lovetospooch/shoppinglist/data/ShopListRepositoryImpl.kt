package cheers.lovetospooch.shoppinglist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cheers.lovetospooch.shoppinglist.domain.ShopItem
import cheers.lovetospooch.shoppinglist.domain.ShopListRepository
import java.lang.RuntimeException
import kotlin.random.Random

object ShopListRepositoryImpl: ShopListRepository {

    private val shopListLD = MutableLiveData<List<ShopItem>>()


    private val shopList = sortedSetOf<ShopItem>({ p0, p1 -> p0.id.compareTo(p1.id) })

    private var autoIncrementId = 0

    init {
        for (i in 0 until 10) {
            val item = ShopItem("Name $i", i, Random.nextBoolean())
            addToShopItem(item)
        }
    }

    override fun addToShopItem(shopItem: ShopItem) {
        if(shopItem.id == ShopItem.UNDEFINED_ID) {
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
        updateShopList()
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
        updateShopList()
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldElement = getIdItem(shopItem.id)
        shopList.remove(oldElement)
        addToShopItem(shopItem)
    }

    override fun getIdItem(shopItemId: Int): ShopItem {
        return shopList.find { it.id == shopItemId} ?: throw RuntimeException("Can not find $shopItemId")
    }

    override fun getShopList(): LiveData<List<ShopItem>> {
        return shopListLD
    }

    private fun updateShopList() {
        shopListLD.value = shopList.toList()
    }
}