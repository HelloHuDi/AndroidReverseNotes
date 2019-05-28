(function(global) {

  if (global.WeixinJSBridge) return 'success';

  var isWebView = global.hasOwnProperty('document');
  var isIosWebView = false;

  var invokeCallbacks = {};
  var invokeCallbackId = 0;

  var onCallbacks = {};

  var customEventPrefix = 'custom_event_';
  var subscribeCallbacks = {};

  if (isWebView) {
    var userAgent = global.navigator.userAgent;
    var isAndroidWebView = userAgent.indexOf('Android') != -1;
    isIosWebView = !isAndroidWebView;
  }

  var _invokeHandler = function(event, paramsString, callbackId) {
    if (isIosWebView) {
      global.webkit.messageHandlers.invokeHandler.postMessage({
        event: event,
        paramsString: paramsString,
        callbackId: callbackId,
      });
    } else {
      var currentTime = new Date().getTime();
      var result = WXGameJsCore.invokeHandler(event, paramsString, callbackId, currentTime);
      if (typeof result !== 'undefined' && typeof invokeCallbacks[callbackId] === 'function' && result !== '') {
        try {
          result = JSON.parse(result)
        } catch (e) {
          result = {}
        }
        invokeCallbacks[callbackId](result)
        delete invokeCallbacks[callbackId]
      }
    }
  }

  var invoke = function(event, params, callback) {
    var paramsString = JSON.stringify(params || {});
    var callbackId = ++invokeCallbackId
    invokeCallbacks[callbackId] = callback;
    _invokeHandler(event, paramsString, callbackId);
  }

  var invokeCallbackHandler = function(callbackId, result) {
    var callback = invokeCallbacks[callbackId];
    if (typeof callback == 'function') {
      callback(result);
    }
    delete invokeCallbacks[callbackId];
  }

  var on = function(event, callback) {
    if (!event || typeof event !== 'string') {
      return;
    }
   if (typeof callback !== 'function') {
       return;
   }
   onCallbacks[event] = callback;
  }

//  var publish = function(event, params, webviewIds) {
//    webviewIds = webviewIds || [];
//    webviewIds = JSON.stringify(webviewIds);
//
//    var customEvent = customEventPrefix + event;
//    var paramsString = JSON.stringify(params);
//    _publishHandler(customEvent, paramsString, webviewIds);
//  }
//
//  var subscribe = function(event, callback) {
//    subscribeCallbacks[customEventPrefix + event] = callback;
//  }

  var subscribeHandler = function(event, result, webviewId, ext) {
    var callback;
    if (event.indexOf(customEventPrefix) != -1) {
      callback = subscribeCallbacks[event];
    } else {
      callback = onCallbacks[event];
    }
    if (typeof callback == 'function') {
      callback(result, webviewId,ext);
    } else {
        if (event == "menu:share:appmessage") {
            var data;
            data = {
                    "link": document.documentURI,
                    "desc": document.documentURI,
                    "title": document.title
            };
            invoke("sendAppMessage", data, null);
        } else if (event == "menu:share:timeline") {
            var data;
             data = {
                "link": document.documentURI,
                "desc": document.documentURI,
                "title": document.title
             };
             invoke("shareTimeline", data, null);
        }
    }
  }

  global.WeixinJSBridge = {
    invoke: invoke,
    invokeCallbackHandler: invokeCallbackHandler,

    call: invoke,

    on: on,

    //publish: publish,

    //subscribe: subscribe,
    subscribeHandler: subscribeHandler,
  }

   on('sys:init',function(ses){
  		// 避免由于Java层多次发起init请求，造成网页端多次收到WeixinJSBridgeReady事件
  		if (window.WeixinJSBridge._hasInit) {
  			console.log('hasInit, no need to init again');
  			return;
  		}

  		window.WeixinJSBridge._hasInit = true;
        var readyEvent = document.createEvent('Events');
        readyEvent.initEvent('WeixinJSBridgeReady');
        document.dispatchEvent(readyEvent);
   });



   return 'success';

}) (this);
