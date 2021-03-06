package com.coco.shows.framework.common

data class Resource<out T>(val status: Status, val data: T?, val message: String?) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun <T> success(data: T?): Resource<T> = Resource(Status.SUCCESS, data, null)
        fun <T> error(message: String?, data: T?): Resource<T> = Resource(Status.ERROR, data, message)
    }
}