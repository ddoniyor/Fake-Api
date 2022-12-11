package com.example.fakeapiproject.domain.model

import com.example.photo_domain.Photo


data class PostsAndPhotos(
    var posts :List<Post>,
    var photos : List<Photo>
)
