package com.example.fakeapiproject.presentattion

import com.example.fakeapiproject.R

sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String){

    object CommonList : BottomNavItem("List", R.drawable.ic_list,"list")
    object NestedList: BottomNavItem("Nested List",R.drawable.ic_list,"nested_list")
    object Grid: BottomNavItem("Grid",R.drawable.ic_list,"grid")
    object ListDb: BottomNavItem("List Db",R.drawable.ic_list,"list_db")
    object Jobs: BottomNavItem("Jobs",R.drawable.ic_job,"jobs")
}

