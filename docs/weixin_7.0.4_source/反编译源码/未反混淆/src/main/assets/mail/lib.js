
(function(_aoNS) {

	var rroot = /^(?:body|html)$/i,
		rmsPrefix = /^-ms-/,
		rdashAlpha = /-([\da-z])/gi,
		core_pnum = /[\-+]?(?:\d*\.|)\d+(?:[eE][\-+]?\d+|)/.source,
		rnumnonpx = new RegExp("^(" + core_pnum + ")(?!px)[a-z%]+$", "i"),
		rmargin = /^margin/,
		cssProps = {
			"myfloat": "cssFloat"
		},
		cssHooks = {
		},
		cssNormalTransform = {
			letterSpacing: 0,
			fontWeight: 400
		},
		fcamelCase = function (all, letter) {
			return (letter + "").toUpperCase();
		};

	var camelCase = function (string) {
		return string.replace(rmsPrefix, "ms-").replace(rdashAlpha, fcamelCase);
	};
	
	var vendorPropName = function (style, name) {
		if (name in style) {
			return name;
		}
	
		var capName = name.charAt(0).toUpperCase() + name.slice(1),
		origName = name,
		i = cssPrefixes.length;
	
		while (i--) {
			name = cssPrefixes[i] + capName;
			if (name in style) {

				return name;
			}
		}
	
		return origName;
	};

	
	var style = function (dom, name) {
		if (!dom || dom.nodeType === 3 || dom.nodeType === 8 || !dom.style) {
			return;
		}

		var ret, type, hooks,
		origName = camelCase(name),
		style = dom.style;
	
		if(origName == "float") {
			origName = "myfloat";
		}
	
		name = cssProps[origName] || (cssProps[origName] = vendorPropName(style, origName));
		hooks = cssHooks[name] || cssHooks[origName];

		if (hooks && "get" in hooks && (ret = hooks.get(elem, false, null)) !== undefined) {
			return ret;
		}

		return style[name];
	};

	var curCSS = function (elem, name) {
		var ret, width, minWidth, maxWidth,
		computed = window.getComputedStyle(elem, null),
		style = elem.style;
		if (computed) {
			ret = computed.getPropertyValue(name) || computed[name];
			if (ret === "") {
				ret = style(elem, name);
			}

			if (rnumnonpx.test(ret) && rmargin.test(name)) {
				width = style.width;
				minWidth = style.minWidth;
				maxWidth = style.maxWidth;
			
				style.minWidth = style.maxWidth = style.width = ret;
				ret = computed.width;
			
				style.width = width;
				style.minWidth = minWidth;
				style.maxWidth = maxWidth;
			}
		}
	
		return ret;
	};

	
	var css = function (dom, name) {
		var val, num, hooks,
		origName = camelCase(name);
	
		if(origName == "float"){
			origName = "myfloat";
		}
	
		name = cssProps[origName] || (cssProps[origName] = vendorPropName(dom.style, origName));
		hooks = cssHooks[name] || cssHooks[origName];

		if (hooks && "get" in hooks) {
			val = hooks.get(dom, true, extra);
		}

		if (val === undefined) {
			val = curCSS(dom, name);
		}
	
		if (val === "normal" && name in cssNormalTransform) {
			val = cssNormalTransform[name];
		}
	
		return val;
	};
	
	var offset = function (dom) {
		var docElem, body, win, clientTop, clientLeft, scrollTop, scrollLeft,
		box = {
			top: 0,
			left: 0
		},
		elem = dom,
		doc = elem && elem.ownerDocument;

		if (!doc) {
			return;
		}
		body = doc.body;
		docElem = doc.documentElement;

		if (typeof elem.getBoundingClientRect !== "undefined") {
			box = elem.getBoundingClientRect();
		}
		win = window;
		clientTop = docElem.clientTop || body.clientTop || 0;
		clientLeft = docElem.clientLeft || body.clientLeft || 0;
		scrollTop = win.pageYOffset || docElem.scrollTop;
		scrollLeft = win.pageXOffset || docElem.scrollLeft;
		return {
			top: box.top + scrollTop - clientTop,
			left: box.left + scrollLeft - clientLeft
		};
	};


	var offsetParentFunc = function (dom) {
		var offsetParent = dom.offsetParent || document.body;
		while (offsetParent && (!rroot.test(offsetParent.nodeName) && css(offsetParent, "position") === "static")) {
			offsetParent = offsetParent.offsetParent;
		}
		return offsetParent || document.body;
	};
	
	var replaceClassName = function(dom, oldClassName, newClassName) {
		dom && (dom.className = dom.className.replace(oldClassName, newClassName));
	};




	_aoNS.insertHTML = function(_aoDomObj, _asWhere, _asHtml) {
		if(!_aoDomObj){
			return false;
		}
		try
		{
			var _oRange = _aoDomObj.ownerDocument.createRange(),
				_abIsBefore = _asWhere.indexOf("before") == 0,
				_abIsBegin = _asWhere.indexOf("Begin") != -1;
			if (_abIsBefore == _abIsBegin)
			{
				_oRange[_abIsBefore ? "setStartBefore" : "setStartAfter"](_aoDomObj);
				_aoDomObj.parentNode.insertBefore(_oRange.createContextualFragment(_asHtml), _abIsBegin ? _aoDomObj : _aoDomObj.nextSibling);
			}
			else
			{
				var _oDomObj = _aoDomObj[_abIsBefore ? "lastChild" : "firstChild"];
				if (_oDomObj)
				{
					_oRange[_abIsBefore ? "setStartAfter" : "setStartBefore"](_oDomObj);
					_aoDomObj[_abIsBefore ? "appendChild" : "insertBefore"](_oRange.createContextualFragment(_asHtml), _oDomObj);
				}
				else
				{
					_aoDomObj.innerHTML = _asHtml;
				}
			}
			return true;
		}
		catch (_oError)
		{
			return false;
		}
	};


	_aoNS.dom = function(_asQueryStr, _aoDom) {
		return (_aoDom || document).querySelector(_asQueryStr);
	};

	_aoNS.doms = function(_asQueryStr, _aoDom) {
		return (_aoDom || document).querySelectorAll(_asQueryStr);
	};
	
	_aoNS.docElem = function() {
		return document.documentElement;
	};

	_aoNS.attr = function(dom, attr) {
		return dom.getAttribute(attr);
	};

	_aoNS.addClass = function(dom, className) {
		dom.className += "" + className;
	};
	
	_aoNS.removeClass = function(dom, className) {
		replaceClassName(dom, className, "");
	};
	
	_aoNS.replaceClass = replaceClassName;

	_aoNS.css = css;

	_aoNS.position = function (dom) {
		var offsetParent = offsetParentFunc(dom);
		var offsetobj = offset(dom);
		var parentOffset = rroot.test(offsetParent.nodeName) ? {
			top: 0,
			left: 0
		} : offsetParent.offset();
		
		offsetobj.top -= parseFloat(css(dom, "marginTop")) || 0;
		offsetobj.left -= parseFloat(css(dom, "marginLeft")) || 0;

		parentOffset.top += parseFloat(css(offsetParent, "borderTopWidth")) || 0;

		return {
			top: offsetobj.top - parentOffset.top,
			left: offsetobj.left - parentOffset.left
		};
	};

})(window);