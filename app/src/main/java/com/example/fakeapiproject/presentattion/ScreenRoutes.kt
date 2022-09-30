package com.example.fakeapiproject.presentattion

import com.example.fakeapiproject.R

sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String){

    object Home : BottomNavItem("Home", R.drawable.ic_home,"home")
    object MyNetwork: BottomNavItem("My Network",R.drawable.ic_my_network,"my_network")
    object AddPost: BottomNavItem("Post",R.drawable.ic_post,"add_post")
    object Notification: BottomNavItem("Notification",R.drawable.ic_notification,"notification")
    object Jobs: BottomNavItem("Jobs",R.drawable.ic_job,"jobs")
}

sealed class MainDestinations(val screen_route:String){
    object PhotoListScreen: MainDestinations("photo_list_screen")
    object PhotoDetailScreen: MainDestinations("photo_detail_screen")

}