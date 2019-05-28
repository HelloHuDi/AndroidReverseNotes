(function (global) {
	if (global.luggageBridge) return;

	var MAGIC_PREFIX = '<<//+//>>';

	var MessageType = {
		NONE: 'NONE',
		READY: 'READY',
		INVOKE: 'INVOKE',
		CALLBACK: 'CALLBACK',
		EVENT: 'EVENT',
		SUBSCRIBE: 'SUBSCRIBE',
		UNSUBSCRIBE: 'UNSUBSCRIBE'
	}

	var invokeCallbackId = 0;
	var invokeCallbacks = {};
	var eventListeners = {};
	var invokeListeners = {};

	var luggageBridgeNative = _luggageBridgeNative || {
		send: function (msg, sync) {
			if (!global || !global.prompt) {
				console.error('Neither java object or window.prompt is available, LuggageBridge WILL NOT WORK');
				return;
			}

			var prefix;
			if (sync) {
				prefix = MAGIC_PREFIX.replace('+', 'sync');
			} else {
				prefix = MAGIC_PREFIX.replace('+', 'async');
			}

			if (sync) {
				return global.prompt(prefix + msg, '');
			} else {
				global.prompt(prefix + msg, '');
				return;
			}
		}
	}

	var invoke = function (method, data, callback) {
		if (!method) {
			return;
		}

		var sync = false;
		var callbackId = 0;
		var callbackFunc = 'undefined';

		switch (typeof callback) {
			case 'undefined':
				break;
			case 'function':
				sync = false;
				callbackId = ++invokeCallbackId;
				callbackFunc = callback;
				break;
			case 'boolean':
				sync = callback;
				break;

			default:
			    return;
		}

		if (callbackId !== 0) {
			invokeCallbacks[callbackId] = callback;
		}

		var msg = {
			method: method,
			data: data || {},
			callbackId: callbackId
		};

		var ret = luggageBridgeNative.send(wrapMessage(MessageType.INVOKE, msg), sync);
		if (ret) {
			return processMessageFromJava(JSON.parse(ret));
		}
	};

	var dispatch = function (event, data) {
		if (!event) {
			return;
		}

		var msg = {
			event: event,
			data: data || {}
		}
		luggageBridgeNative.send(wrapMessage(MessageType.EVENT, msg), false);
	}

	var subscribe = function (event, listener) {
		if (!event || (typeof listener !== 'function')) {
			return;
		}

		if (!(event in eventListeners)) {
			eventListeners[event] = [];
		}

		eventListeners[event].push(listener);
	}

	var unsubscribe = function (event, listener) {
		if (!event || (typeof listener !== 'function')) {
			return;
		}

		if (!(event in eventListeners)) {
			eventListeners[event] = [];
		}

		var index = eventListeners[event].indexOf(listener);
		if (index > -1) {
			eventListeners[event].splice(index, 1);
		}
	}

	var handle = function (method, func) {
		if (!method || (typeof func !== 'function')) {
			return;
		}

		invokeListeners[method] = func;
	}

	var unhandle = function (method) {
		if (!method) {
			return;
		}

		delete invokeListeners[method];
	}

	var ready = function () {
	    luggageBridgeNative.send(wrapMessage(MessageType.READY), true);
	}

	var wrapMessage = function (type, msg) {
		return JSON.stringify({
			type: type,
			data: msg
		});
	};

	// return result object or undefined
	var processMessageFromJava = function (msg) {
		switch (msg.type) {

			case MessageType.CALLBACK:
				return processCallbackFromJava(msg.data);

			case MessageType.EVENT:
				processEventFromJava(msg.data);
				return;

			case MessageType.INVOKE:
				processInvokeFromJava(msg.data);
				return;

		}
	};

	var processCallbackFromJava = function (data) {
		if (data.callbackId === 0) {
			if (data.error) {
				throw data.error;
			} else {
				return data.data;
			}
		} else {
			invokeCallbacks[data.callbackId](data.error, data.data);
			if (!data.keepCallback) {
				delete invokeCallbacks[data.callbackId];
			}
			return;
		}
	};

	var processEventFromJava = function (data) {
		if (!(data.event in eventListeners)) {
			return;
		}

//		var context = {
//			getEventName: function () {
//				return data.event;
//			},
//			getEventData: function () {
//				return data.data;
//			}
//		}

        for (var i = 0; i < eventListeners[data.event].length; ++i) {
            eventListeners[data.event][i](data.data);
        }

	};

	var processInvokeFromJava = function (data) {
		if (!(data.method in invokeListeners)) {
			return;
		}

		var msg = {
			method: data.method, 
			data: {},
			callbackId: data.callbackId,
			keepCallback: false
		}

		var callback = function () {
			if (data.callbackId === 0) {
				return;
			}
			luggageBridgeNative.send(wrapMessage(MessageType.CALLBACK, msg), false);
		}

		var context = {
			getMethod: function () {
				return data.method;
			},
			getData: function () {
				return data.data;
			},
			setReturn: function (ret) {
				if (typeof ret !== 'object') {
					return;
				}
				msg.data = ret;
				callback();
			},
			keepCallback: function (keep) {
				msg.keepCallback = keep;
			}
		}

		invokeListeners[data.method](context);
	};

	global.luggageBridge = {
		invoke: invoke,
		dispatch: dispatch,
		subscribe: subscribe,
		unsubscribe: unsubscribe,
		handle: handle,
		unhandle: unhandle,
		_processMessageFromJava: processMessageFromJava
	};

    ready();
	if (global.document && global.Event) {
		global.document.dispatchEvent(new Event('LuggageBridgeReady'));
	}
})(this);
