package com.jhavidit.moviedb.login

data class LoginState(
    val onLogin: () -> Unit
)