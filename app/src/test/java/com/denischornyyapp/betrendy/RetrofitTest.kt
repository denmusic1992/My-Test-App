package com.denischornyyapp.betrendy

import com.denischornyyapp.betrendy.framework.network.NetworkRepositoryImpl
import com.denischornyyapp.betrendy.framework.usecases.PostUseCases
import com.denischornyyapp.domain_layer.repository.PostRepositoryImpl
import com.denischornyyapp.domain_layer.use_cases.post.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

/**
Created by Denis Chornyy on 13,Май,2020
All rights received.
 */
class RetrofitTest {
    @Test
    fun testApiCalls() {
        val postRepositoryImpl = PostRepositoryImpl(NetworkRepositoryImpl())
        val postUseCases = PostUseCases(
            AddPost(postRepositoryImpl),
            UpdatePost(postRepositoryImpl),
            DeletePost(postRepositoryImpl),
            GetAllPosts(postRepositoryImpl),
            GetPostByID(postRepositoryImpl),
            GetPostByUserID(postRepositoryImpl)
        )

        runBlocking {
            launch {
                val posts = postUseCases.getAllPosts()
                if (posts != null) {
                    for(post in posts.subList(0, 30)) {
                        val newPost = postUseCases.getPostByID(post.id)
                        assertThat(newPost, equalTo(post))
                    }
                }

            }
        }
    }
}