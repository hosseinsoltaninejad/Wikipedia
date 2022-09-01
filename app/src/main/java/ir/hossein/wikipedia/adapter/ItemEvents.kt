package ir.hossein.wikipedia.adapter

import ir.hossein.wikipedia.data.ItemPost

interface ItemEvents {

    fun onItemClicked ( itemPost: ItemPost )
}