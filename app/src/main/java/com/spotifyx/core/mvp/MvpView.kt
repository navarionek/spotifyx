package com.spotifyx.core.mvp

interface MvpView<T: MvpPresenter> {
    fun getPresenter(): T
}