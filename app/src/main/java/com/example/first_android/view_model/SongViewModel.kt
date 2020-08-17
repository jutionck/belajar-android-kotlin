package com.example.first_android.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.FieldPosition

class SongViewModel: ViewModel() {

    private val songList: MutableList<MutableMap<String,String>>
            =
        mutableListOf(
            mutableMapOf(
            "name" to "Bara Suara",
            "title" to "Sendu Melagu",
            "image" to "https://1.bp.blogspot.com/-z1yONm1YBSU/WMtXQzqt5UI/AAAAAAAABd0/TFG0BW4OqbQPCnTO01iTKPcIe0GlNK9QgCLcB/s1600/BARASUARA-image-1024x786.jpg"),
            mutableMapOf(
                "name" to "Danilla",
                "title" to "Berdistraksi",
                "image" to "https://pophariini.com/wp-content/uploads/2019/10/danillafingers-1.jpg"),
            mutableMapOf(
                "name" to ".feast",
                "title" to "Padi Milik Rakyat",
                "image" to "https://asset-a.grid.id/crop/0x0:0x0/700x0/photo/2018/09/27/170962345.jpg"),
            mutableMapOf(
                "name" to "FourTwnty",
                "title" to "Nematomorpha",
                "image" to "https://pophariini.com/wp-content/uploads/2018/09/Fourtwnty.jpg"))

    val songData:MutableLiveData<MutableList<MutableMap<String,String>>> = MutableLiveData(songList)

    val details:MutableMap<String,String> = mutableMapOf()

    fun addSong(name:String,title:String,image:String){
        val inputData:MutableMap<String,String> =
            mutableMapOf("name" to name,"title" to title,"image" to image)
        songList.add(inputData)
        songData.value = songList
    }

    fun detailSong(position:Int){
        val detail = songList[position]
        details["name"] = detail["name"].toString()
        details["title"] = detail["title"].toString()
        details["image"] = detail["image"].toString()
    }
}