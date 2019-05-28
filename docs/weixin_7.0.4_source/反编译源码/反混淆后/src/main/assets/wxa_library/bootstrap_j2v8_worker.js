(function (global) {
    global.WeixinWorker = {
        appServiceMsgHandler : function(msg) {

        },
        postMsgToAppService : function(msg) {
            postMessage(msg);
        },
        errorHandler : function() {}
    };

    global.onmessage = function(msg) {
        try {
          msg = JSON.parse(msg)
        } catch (e) {
          console.error('global.onmessage error ', e.message)
          return
        }
        var w_ = global.WeixinWorker;
        typeof w_.appServiceMsgHandler !== 'undefined' && w_.appServiceMsgHandler(msg);
    }
})(this);