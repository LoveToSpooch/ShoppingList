package cheers.lovetospooch.shoppinglist.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import cheers.lovetospooch.shoppinglist.R
import cheers.lovetospooch.shoppinglist.domain.ShopItem

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    private lateinit var shopListAdapter: ShopListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.shopList.observe(this) {
            shopListAdapter.submitList(it)
        }
    }

    private fun setupRecyclerView() {

        val shopList = findViewById<RecyclerView>(R.id.recyclerViewShopList)
        shopListAdapter = ShopListAdapter()
        shopList.adapter = shopListAdapter

        shopList.recycledViewPool.setMaxRecycledViews(ShopListAdapter.STATE_ENABLE, ShopListAdapter.MAX_POOL_SIZE)
        shopList.recycledViewPool.setMaxRecycledViews(ShopListAdapter.STATE_DISABLE  , ShopListAdapter.MAX_POOL_SIZE)

        setupLongClickListener()

        setupClickListener()

        setupSwipeListener(shopList)

    }

    private fun setupSwipeListener(shopList: RecyclerView) {
        val callback = object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val item = shopListAdapter.currentList[viewHolder.adapterPosition]
                viewModel.deleteShopItem(item)
            }
        }

        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(shopList)
    }

    private fun setupLongClickListener() {
        shopListAdapter.onShopLongClickListener = {
            viewModel.changeEnableState(it)
        }

    }

    private fun setupClickListener() {
        shopListAdapter.onShopClickListener = {
        }
    }




}