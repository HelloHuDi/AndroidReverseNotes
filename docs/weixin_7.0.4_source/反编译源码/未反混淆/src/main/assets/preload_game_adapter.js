(function(global) {
  if (global.luggageBridge === undefined || global.WeixinJSBridge) {
    return;
  }

  var luggage = global.luggageBridge;


  var jsApiQueue = [];

  var invoke = function(func, params, callback) {
    if (!func || typeof func !== 'string') {
      return;
    };
    if (typeof params !== 'object') {
      params = {};
    };

    if (!jsApiReady) {
        var jsApi = {
            "func" : func,
            "params" : params,
            "callback" : callback
        };
        jsApiQueue.push(jsApi);
        return;
    }

    if (!callback || (typeof callback) !== 'function') {
      luggage.invoke(func, params, false);
    } else {
      luggage.invoke(func, params, function(error, data) {
        var err_msg = '';

        switch (func) {
        case 'getInstallState':
        case 'getNetworkType':
          err_msg = error.toString();
          break;

        default:
          if (error) {
            err_msg = func + ":fail_" + error;
          } else {
            err_msg = func + ":ok";
          }
        }

        data['err_msg'] = err_msg;
        callback(data);
      });
    }
  };

  var event_cb_map = {};

  var subscribe = function(event, callback) {
    if (event_cb_map[event]) {
      luggage.unsubscribe(event, event_cb_map[event]);
    }
    event_cb_map[event] = callback;
    luggage.subscribe(event, callback);
  };

  subscribe("menu:share:appmessage", function(res) {
    var data = {
      "link": document.documentURI,
      "desc": document.documentURI,
      "title": document.title
    };
    invoke("sendAppMessage", data);
  });

  subscribe("menu:share:timeline", function(res) {
    var data = {
      "link": document.documentURI,
      "desc": document.documentURI,
      "title": document.title
    };
    invoke("shareTimeline", data);
  });

  var jsApiReady = false;

  subscribe("onJsApiReady", function(res) {
      jsApiReady = true;
      flush();
  })

  var flush = function() {
      for (var i = 0; i < jsApiQueue.length; ++i) {
          var jsApi = jsApiQueue[i];
          if (jsApi.func) {
              invoke(jsApi.func, jsApi.params, jsApi.callback);
          }
      }
  }


  global.WeixinJSBridge = {
    invoke : invoke,
    call : invoke,
    on : subscribe,
    log : function(msg) {}
  }

  if (global.document) {
    var readyEvent = document.createEvent('Events');
    readyEvent.initEvent('WeixinJSBridgeReady');
    document.dispatchEvent(readyEvent);
  }
})(this);