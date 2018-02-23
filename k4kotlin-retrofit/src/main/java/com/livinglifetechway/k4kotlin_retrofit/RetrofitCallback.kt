package com.livinglifetechway.k4kotlin_retrofit

import android.view.View
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitCallback<T>(function: RetrofitCallback<T>.() -> Unit) : Callback<T> {

    /**
     * A progress view will be shown when the view is set
     * And will hide itself when onResponse/onFailure is received
     * Note:    If you do not want to show the view when callback function is initialized
     *          you should use lazyProgressView
     */
    var progressView: View? = null
        set(view) {
            field = view
            field?.visibility = View.VISIBLE
        }

    /**
     * A lazy progress view will hide itself when onResponse/onFailure is received
     * Showing view's visibility should be handled by the user
     * Note:    If you want to show the view when callback function is initialized
     *          you should use progressView
     */
    var lazyProgressView: View? = null

    private var onResponseCallback: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var onFailureCallback: (call: Call<T>?, throwable: Throwable?) -> Unit = { _, _ -> }
    private var onCompleted: (call: Call<T>?, response: Response<T>?, throwable: Throwable?) -> Unit = { _, _, _ -> }
    private var onCancelled: (call: Call<T>?, throwable: Throwable?) -> Unit = { _, _ -> }
    private var onFailureNotCancelled: (call: Call<T>?, throwable: Throwable?) -> Unit = { _, _ -> }
    private var on2xxSuccess: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on3xxRedirection: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on4xxClientError: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on5xxServerError: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var onUnsuccessfulResponse: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var onUnsuccessfulResponseOrFailure: (call: Call<T>?, response: Response<T>?, throwable: Throwable?) -> Unit = { _, _, _ -> }
    private var onUnsuccessfulResponseOrFailureNotCancelled: (call: Call<T>?, response: Response<T>?, throwable: Throwable?) -> Unit = { _, _, _ -> }
    private var on200Ok: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on201Created: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on202Accepted: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on203NonAuthoritativeInformation: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on204NoContent: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on205ResetContent: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on206PartialContent: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on207MultiStatus: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on208AlreadyReported: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on226ImUsed: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on300MultipleChoices: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on301MovedPermanently: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on302Found: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on303SeeOther: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on304NotModified: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on305UseProxy: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on306SwitchProxy: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on307TemporaryRedirect: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on308PermanentRedirect: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on400BadRequest: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on401Unauthorized: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on402PaymentFailed: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on403Forbidden: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on404NotFound: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on405MethodNotAllowed: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on406NotAcceptable: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on407ProxyAuthenticationRequired: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on408RequestTimeout: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on409Conflict: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on410Gone: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on411LengthRequired: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on412PreconditionFailed: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on413PayloadTooLarge: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on414UriTooLong: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on415UnsupportedMediaType: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on416RangeNotSatisfiable: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on417ExpectationFailed: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on418ImaTeapot: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on421MisdirectedRequest: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on422UnprocessableEntity: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on423Locked: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on424FailedDependency: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on426UpgradeRequired: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on428PreconditionRequired: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on429TooManyRequests: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on431RequestHeaderFieldsTooLarge: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on451UnavailableForLegalReasons: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on500InternalServerError: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on501NotImplemented: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on502BadGateway: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on503ServiceUnavailable: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on504GatewayTimeout: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on505HttpVersionNotSupported: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on506VariantAlsoNegotiates: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on507InsufficientStorage: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on508LoopDetected: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on510NotExtended: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }
    private var on511NetworkAuthenticationRequired: (call: Call<T>?, response: Response<T>?) -> Unit = { _, _ -> }

    private fun hideProgressView() {
        progressView?.visibility = View.GONE
        lazyProgressView?.visibility = View.GONE
    }

    override fun onFailure(call: Call<T>?, t: Throwable?) {
        // hide progress view after call is finished
        hideProgressView()

        // call is completed
        onCompleted(call, null, t)

        // call failed
        onFailureCallback(call, t)

        // check if call is cancelled
        if (call?.isCanceled == true) {
            onCancelled(call, t)
        } else {
            onFailureNotCancelled(call, t)
        }

        // unsuccessful or failure? -> Failure
        onUnsuccessfulResponseOrFailure(call, null, t)

        // unsuccessful or failure(not cancelled)? -> Failure(not cancelled)
        if (call?.isCanceled == false) {
            onUnsuccessfulResponseOrFailureNotCancelled(call, null, t)
        }
    }

    override fun onResponse(call: Call<T>?, response: Response<T>?) {
        // hide progress view after call is finished
        hideProgressView()

        // call is completed
        onCompleted(call, response, null)

        // call failed
        onResponseCallback(call, response)

        // check for response code range callbacks
        when (response?.code()) {
            in 200..299 -> on2xxSuccess(call, response)
            in 300..399 -> on3xxRedirection(call, response)
            in 400..499 -> on4xxClientError(call, response)
            in 500..599 -> on5xxServerError(call, response)
        }

        // check for unsuccessful callback (any response code other than 2xx)
        if (response?.isSuccessful != true) {
            onUnsuccessfulResponse(call, response)

            // unsuccessful or failure? -> Unsuccessful
            onUnsuccessfulResponseOrFailure(call, response, null)

            // unsuccessful or failure (not cancelled)? -> Unsuccessful
            onUnsuccessfulResponseOrFailureNotCancelled(call, response, null)
        }

        // check for individual response code
        when (response?.code()) {
            200 -> on200Ok(call, response)
            201 -> on201Created(call, response)
            202 -> on202Accepted(call, response)
            203 -> on203NonAuthoritativeInformation(call, response)
            204 -> on204NoContent(call, response)
            205 -> on205ResetContent(call, response)
            206 -> on206PartialContent(call, response)
            207 -> on207MultiStatus(call, response)
            208 -> on208AlreadyReported(call, response)
            226 -> on226ImUsed(call, response)
            300 -> on300MultipleChoices(call, response)
            301 -> on301MovedPermanently(call, response)
            302 -> on302Found(call, response)
            303 -> on303SeeOther(call, response)
            304 -> on304NotModified(call, response)
            305 -> on305UseProxy(call, response)
            306 -> on306SwitchProxy(call, response)
            307 -> on307TemporaryRedirect(call, response)
            308 -> on308PermanentRedirect(call, response)
            400 -> on400BadRequest(call, response)
            401 -> on401Unauthorized(call, response)
            402 -> on402PaymentFailed(call, response)
            403 -> on403Forbidden(call, response)
            404 -> on404NotFound(call, response)
            405 -> on405MethodNotAllowed(call, response)
            406 -> on406NotAcceptable(call, response)
            407 -> on407ProxyAuthenticationRequired(call, response)
            408 -> on408RequestTimeout(call, response)
            409 -> on409Conflict(call, response)
            410 -> on410Gone(call, response)
            411 -> on411LengthRequired(call, response)
            412 -> on412PreconditionFailed(call, response)
            413 -> on413PayloadTooLarge(call, response)
            414 -> on414UriTooLong(call, response)
            415 -> on415UnsupportedMediaType(call, response)
            416 -> on416RangeNotSatisfiable(call, response)
            417 -> on417ExpectationFailed(call, response)
            418 -> on418ImaTeapot(call, response)
            421 -> on421MisdirectedRequest(call, response)
            422 -> on422UnprocessableEntity(call, response)
            423 -> on423Locked(call, response)
            424 -> on424FailedDependency(call, response)
            426 -> on426UpgradeRequired(call, response)
            428 -> on428PreconditionRequired(call, response)
            429 -> on429TooManyRequests(call, response)
            431 -> on431RequestHeaderFieldsTooLarge(call, response)
            451 -> on451UnavailableForLegalReasons(call, response)
            500 -> on500InternalServerError(call, response)
            501 -> on501NotImplemented(call, response)
            502 -> on502BadGateway(call, response)
            503 -> on503ServiceUnavailable(call, response)
            504 -> on504GatewayTimeout(call, response)
            505 -> on505HttpVersionNotSupported(call, response)
            506 -> on506VariantAlsoNegotiates(call, response)
            507 -> on507InsufficientStorage(call, response)
            508 -> on508LoopDetected(call, response)
            510 -> on510NotExtended(call, response)
            511 -> on511NetworkAuthenticationRequired(call, response)
        }
    }

    // DSL
    fun onResponseCallback(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.onResponseCallback = function
    }

    fun onFailureCallback(function: (call: Call<T>?, throwable: Throwable?) -> Unit) {
        this.onFailureCallback = function
    }

    fun onCompleted(function: (call: Call<T>?, response: Response<T>?, throwable: Throwable?) -> Unit) {
        this.onCompleted = function
    }

    fun onCancelled(function: (call: Call<T>?, throwable: Throwable?) -> Unit) {
        this.onCancelled = function
    }

    fun onFailureNotCancelled(function: (call: Call<T>?, throwable: Throwable?) -> Unit) {
        this.onFailureNotCancelled = function
    }

    fun on2xxSuccess(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on2xxSuccess = function
    }

    fun on3xxRedirection(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on3xxRedirection = function
    }

    fun on4xxClientError(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on4xxClientError = function
    }

    fun on5xxServerError(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on5xxServerError = function
    }

    fun onUnsuccessfulResponse(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.onUnsuccessfulResponse = function
    }

    fun onUnsuccessfulResponseOrFailure(function: (call: Call<T>?, response: Response<T>?, throwable: Throwable?) -> Unit) {
        this.onUnsuccessfulResponseOrFailure = function
    }

    fun onUnsuccessfulResponseOrFailureNotCancelled(function: (call: Call<T>?, response: Response<T>?, throwable: Throwable?) -> Unit) {
        this.onUnsuccessfulResponseOrFailureNotCancelled = function
    }

    fun on200Ok(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on200Ok = function
    }

    fun on201Created(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on201Created = function
    }

    fun on202Accepted(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on202Accepted = function
    }

    fun on203NonAuthoritativeInformation(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on203NonAuthoritativeInformation = function
    }

    fun on204NoContent(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on204NoContent = function
    }

    fun on205ResetContent(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on205ResetContent = function
    }

    fun on206PartialContent(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on206PartialContent = function
    }

    fun on207MultiStatus(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on207MultiStatus = function
    }

    fun on208AlreadyReported(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on208AlreadyReported = function
    }

    fun on226ImUsed(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on226ImUsed = function
    }

    fun on300MultipleChoices(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on300MultipleChoices = function
    }

    fun on301MovedPermanently(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on301MovedPermanently = function
    }

    fun on302Found(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on302Found = function
    }

    fun on303SeeOther(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on303SeeOther = function
    }

    fun on304NotModified(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on304NotModified = function
    }

    fun on305UseProxy(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on305UseProxy = function
    }

    fun on306SwitchProxy(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on306SwitchProxy = function
    }

    fun on307TemporaryRedirect(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on307TemporaryRedirect = function
    }

    fun on308PermanentRedirect(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on308PermanentRedirect = function
    }

    fun on400BadRequest(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on400BadRequest = function
    }

    fun on401Unauthorized(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on401Unauthorized = function
    }

    fun on402PaymentFailed(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on402PaymentFailed = function
    }

    fun on403Forbidden(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on403Forbidden = function
    }

    fun on404NotFound(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on404NotFound = function
    }

    fun on405MethodNotAllowed(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on405MethodNotAllowed = function
    }

    fun on406NotAcceptable(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on406NotAcceptable = function
    }

    fun on407ProxyAuthenticationRequired(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on407ProxyAuthenticationRequired = function
    }

    fun on408RequestTimeout(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on408RequestTimeout = function
    }

    fun on409Conflict(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on409Conflict = function
    }

    fun on410Gone(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on410Gone = function
    }

    fun on411LengthRequired(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on411LengthRequired = function
    }

    fun on412PreconditionFailed(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on412PreconditionFailed = function
    }

    fun on413PayloadTooLarge(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on413PayloadTooLarge = function
    }

    fun on414UriTooLong(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on414UriTooLong = function
    }

    fun on415UnsupportedMediaType(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on415UnsupportedMediaType = function
    }

    fun on416RangeNotSatisfiable(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on416RangeNotSatisfiable = function
    }

    fun on417ExpectationFailed(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on417ExpectationFailed = function
    }

    fun on418ImaTeapot(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on418ImaTeapot = function
    }

    fun on421MisdirectedRequest(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on421MisdirectedRequest = function
    }

    fun on422UnprocessableEntity(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on422UnprocessableEntity = function
    }

    fun on423Locked(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on423Locked = function
    }

    fun on424FailedDependency(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on424FailedDependency = function
    }

    fun on426UpgradeRequired(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on426UpgradeRequired = function
    }

    fun on428PreconditionRequired(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on428PreconditionRequired = function
    }

    fun on429TooManyRequests(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on429TooManyRequests = function
    }

    fun on431RequestHeaderFieldsTooLarge(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on431RequestHeaderFieldsTooLarge = function
    }

    fun on451UnavailableForLegalReasons(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on451UnavailableForLegalReasons = function
    }

    fun on500InternalServerError(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on500InternalServerError = function
    }

    fun on501NotImplemented(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on501NotImplemented = function
    }

    fun on502BadGateway(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on502BadGateway = function
    }

    fun on503ServiceUnavailable(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on503ServiceUnavailable = function
    }

    fun on504GatewayTimeout(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on504GatewayTimeout = function
    }

    fun on505HttpVersionNotSupported(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on505HttpVersionNotSupported = function
    }

    fun on506VariantAlsoNegotiates(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on506VariantAlsoNegotiates = function
    }

    fun on507InsufficientStorage(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on507InsufficientStorage = function
    }

    fun on508LoopDetected(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on508LoopDetected = function
    }

    fun on510NotExtended(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on510NotExtended = function
    }

    fun on511NetworkAuthenticationRequired(function: (call: Call<T>?, response: Response<T>?) -> Unit) {
        this.on511NetworkAuthenticationRequired = function
    }

    // IMPORTANT: If init call is defined at the start of the file,
    //            It's value will be override by the property's default values
    //            As property initialization will be called after init
    //            It init is in the last, property initialization will be done first
    //            and then init will replace the actual functions
    init {
        // dsl method calls
        function()
    }

}