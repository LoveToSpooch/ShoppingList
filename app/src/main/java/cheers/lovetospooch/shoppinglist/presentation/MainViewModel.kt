package cheers.lovetospooch.shoppinglist.presentation

import androidx.lifecycle.ViewModel
import cheers.lovetospooch.shoppinglist.data.ShopListRepositoryImpl
import cheers.lovetospooch.shoppinglist.domain.DeleteShopItemUseCase
import cheers.lovetospooch.shoppinglist.domain.EditShopItemUseCase
import cheers.lovetospooch.shoppinglist.domain.GetShopListUseCase
import cheers.lovetospooch.shoppinglist.domain.ShopItem

class MainViewModel: ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)


    val shopList = getShopListUseCase.getShopList()



    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)

    }

    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)

    }


}