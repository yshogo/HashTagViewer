package Task

interface Callback {
    fun onSuccess(result: String)

    fun onError()
}