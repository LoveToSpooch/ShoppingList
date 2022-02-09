package cheers.lovetospooch.shoppinglist.domain

class GetItemIdUseCase(private val shopListRepository: ShopListRepository) {

    fun getIdItem(shopItemId: Int): ShopItem {
        return shopListRepository.getIdItem(shopItemId)
    }
}