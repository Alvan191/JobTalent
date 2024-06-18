package com.example.jobtalent.utils

import com.example.jobtalent.navigation.Screen

fun String?.shouldShowBottomBar(): Boolean {
    return this in setOf(
        Screen.Home.route,
        Screen.Chat.route,
        Screen.Community.route,
        Screen.Profile.route
    )
}