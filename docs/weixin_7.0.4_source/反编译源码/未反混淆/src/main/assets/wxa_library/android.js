
var WeixinJSCoreAndroid = (function(global) {
    var WeixinJSCore = global.WeixinJSCore;

    var notifyEvent = function(eventId) {
        var res = WeixinJSCore.retrieveEvent(eventId);
        try {
            var obj = JSON.parse(res);
            var data = JSON.parse(obj.data);

            if (typeof WeixinJSBridge !== 'undefined') {
                WeixinJSBridge.subscribeHandler(obj.event, data, obj.src, obj.ext);
            }
        } catch (e) {}
    };

    var ret = {};
    ret.notifyEvent = notifyEvent;
    ret.invokeCallbackHandler = function(callbackId, data) {
        if (typeof WeixinJSBridge !== 'undefined') {
            WeixinJSBridge.invokeCallbackHandler(callbackId, data);
        }
    };
    ret.subscribeHandler = function(event, data, src, ext) {
        if (typeof WeixinJSBridge !== 'undefined') {
            WeixinJSBridge.subscribeHandler(event, data, src, ext);
        }
    };

    if (WeixinJSCore.isDebugPackage()) {
        ret.invokeHandler = function(api, data, callbackId) {
            return WeixinJSCore.invokeHandler(api, data, callbackId);
        };
        ret.invokeHandlerDirect = function(api, data) {
            return WeixinJSCore.invokeHandlerDirect(api, data)
        };
    }

    return ret;
})(this);
