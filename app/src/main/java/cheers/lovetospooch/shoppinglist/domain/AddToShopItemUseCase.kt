package cheers.lovetospooch.shoppinglist.domain

class AddToShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun addToShopItem(shopItem: ShopItem) {
        shopListRepository.addToShopItem(shopItem)
    }
}