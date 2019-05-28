//     _WXJS.js
//     (c) 2010-2012 Thomas Fuchs
//     _WXJS.js may be freely distributed under the MIT license.
(function () {
  var __initLogArr = ["start"];
  try {
  var __DL = 0, __IL = 1, __EL = 2, __initLogLvl = __IL;
  function __initLog(lvl) {
    __initLogArr.push(arguments);
    if (lvl >= __initLogLvl) {
        console && console.log.apply(console, Array.prototype.slice.call(arguments, 1));
    }
  }

  if (window.WeixinJSBridge) {
    // Android加上了这个if判断，如果当前window已经定义了WeixinJSBridge对象，不再重新加载
    // 避免重新初始化_callback_map等变量，导致之前的消息回调失败，返回cb404
    __initLog(__IL, "window.WeixinJSBridge already exists");
    return;
  };

  var execStartTime = Date.now();

  function _isTmpl(t) { return t.indexOf('${') == 0 && t.indexOf('}') == t.length - 1 }
  //用于客户端替换
  var __dgtRdm = '${dgtVerifyRandomStr}',
      __dgtOn = '${dgtVerifyEnabled}';
  //否则使用注入
  if (_isTmpl(__dgtRdm)) __dgtRdm = null;
  if (_isTmpl(__dgtOn)) { __dgtOn = null; } else { __dgtOn = __dgtOn === 'true'; }
  __initLog(__DL, "replace dgt");

  (function (undefined) {
    if (String.prototype.trim === undefined) // fix for iOS 3.2
      String.prototype.trim = function () {
        return this.replace(/^\s+/, '').replace(/\s+$/, '')
      }

    // For iOS 3.x
    // from https://developer.mozilla.org/en/JavaScript/Reference/Global_Objects/Array/reduce
    if (Array.prototype.reduce === undefined)
      Array.prototype.reduce = function (fun) {
        if (this === void 0 || this === null) throw new TypeError()
        var t = Object(this),
          len = t.length >>> 0,
          k = 0,
          accumulator
        if (typeof fun != 'function') throw new TypeError()
        if (len == 0 && arguments.length == 1) throw new TypeError()

        if (arguments.length >= 2)
          accumulator = arguments[1]
        else
          do {
            if (k in t) {
              accumulator = t[k++]
              break
            }
            if (++k >= len) throw new TypeError()
          } while (true)

        while (k < len) {
          if (k in t) accumulator = fun.call(undefined, accumulator, t[k], k, t)
          k++
        }
        return accumulator
      }

  })()

  __initLog(__DL, "prototype compat");

  var _WXJS = (function () {
    var undefined, key, $, classList, emptyArray = [],
      slice = emptyArray.slice,
      document = window.document,
      elementDisplay = {},
      classCache = {},
      getComputedStyle = document.defaultView.getComputedStyle,
      cssNumber = {
        'column-count': 1,
        'columns': 1,
        'font-weight': 1,
        'line-height': 1,
        'opacity': 1,
        'z-index': 1,
        'zoom': 1
      },
      fragmentRE = /^\s*<(\w+|!)[^>]*>/,

      // Used by `$._WXJS.init` to wrap elements, text/comment nodes, document,
      // and document fragment node types.
      elementTypes = [1, 3, 8, 9, 11],

      adjacencyOperators = ['after', 'prepend', 'before', 'append'],
      table = document.createElement('table'),
      tableRow = document.createElement('tr'),
      containers = {
        'tr': document.createElement('tbody'),
        'tbody': table,
        'thead': table,
        'tfoot': table,
        'td': tableRow,
        'th': tableRow,
        '*': document.createElement('div')
      },
      readyRE = /complete|loaded|interactive/,
      classSelectorRE = /^\.([\w-]+)$/,
      idSelectorRE = /^#([\w-]+)$/,
      tagSelectorRE = /^[\w-]+$/,
      toString = ({}).toString,
      _WXJS = {},
      camelize, uniq,
      tempParent = document.createElement('div')

    __initLog(__DL, "_WXJS define");
    _WXJS.matches = function (element, selector) {
      if (!element || element.nodeType !== 1) return false
      var matchesSelector = element.webkitMatchesSelector || element.mozMatchesSelector ||
        element.oMatchesSelector || element.matchesSelector
      if (matchesSelector) return matchesSelector.call(element, selector)
      // fall back to performing a selector:
      var match, parent = element.parentNode,
        temp = !parent
      if (temp)(parent = tempParent).appendChild(element)
      match = ~_WXJS.qsa(parent, selector).indexOf(element)
      temp && tempParent.removeChild(element)
      return match
    }

    function isFunction(value) {
      return toString.call(value) == "[object Function]"
    }

    function isObject(value) {
      return value instanceof Object
    }

    function isPlainObject(value) {
      var key, ctor
      if (toString.call(value) !== "[object Object]") return false
      ctor = (isFunction(value.constructor) && value.constructor.prototype)
      if (!ctor || !hasOwnProperty.call(ctor, 'isPrototypeOf')) return false
      for (key in value) {}
      return key === undefined || hasOwnProperty.call(value, key)
    }

    function isArray(value) {
      return value instanceof Array
    }

    function likeArray(obj) {
      return typeof obj.length == 'number'
    }

    function compact(array) {
      return array.filter(function (item) {
        return item !== undefined && item !== null
      })
    }

    function flatten(array) {
      return array.length > 0 ? [].concat.apply([], array) : array
    }
    camelize = function (str) {
      return str.replace(/-+(.)?/g, function (match, chr) {
        return chr ? chr.toUpperCase() : ''
      })
    }

    function dasherize(str) {
      return str.replace(/::/g, '/')
        .replace(/([A-Z]+)([A-Z][a-z])/g, '$1_$2')
        .replace(/([a-z\d])([A-Z])/g, '$1_$2')
        .replace(/_/g, '-')
        .toLowerCase()
    }
    uniq = function (array) {
      return array.filter(function (item, idx) {
        return array.indexOf(item) == idx
      })
    }

    function classRE(name) {
      return name in classCache ?
        classCache[name] : (classCache[name] = new RegExp('(^|\\s)' + name + '(\\s|$)'))
    }

    function maybeAddPx(name, value) {
      return (typeof value == "number" && !cssNumber[dasherize(name)]) ? value + "px" : value
    }

    function defaultDisplay(nodeName) {
      var element, display
      if (!elementDisplay[nodeName]) {
        element = document.createElement(nodeName)
        document.body.appendChild(element)
        display = getComputedStyle(element, '').getPropertyValue("display")
        element.parentNode.removeChild(element)
        display == "none" && (display = "block")
        elementDisplay[nodeName] = display
      }
      return elementDisplay[nodeName]
    }

    // `$._WXJS.fragment` takes a html string and an optional tag name
    // to generate DOM nodes nodes from the given html string.
    // The generated DOM nodes are returned as an array.
    // This function can be overriden in plugins for example to make
    // it compatible with browsers that don't support the DOM fully.
    _WXJS.fragment = function (html, name) {
      if (name === undefined) name = fragmentRE.test(html) && RegExp.$1
      if (!(name in containers)) name = '*'
      var container = containers[name]
      container.innerHTML = '' + html
      return $.each(slice.call(container.childNodes), function () {
        container.removeChild(this)
      })
    }

    // `$._WXJS.Z` swaps out the prototype of the given `dom` array
    // of nodes with `$.fn` and thus supplying all the _WXJS functions
    // to the array. Note that `__proto__` is not supported on Internet
    // Explorer. This method can be overriden in plugins.
    _WXJS.Z = function (dom, selector) {
      dom = dom || []
      dom.__proto__ = arguments.callee.prototype
      dom.selector = selector || ''
      return dom
    }

    // `$._WXJS.isZ` should return `true` if the given object is a _WXJS
    // collection. This method can be overriden in plugins.
    _WXJS.isZ = function (object) {
      return object instanceof _WXJS.Z
    }

    // `$._WXJS.init` is _WXJS's counterpart to jQuery's `$.fn.init` and
    // takes a CSS selector and an optional context (and handles various
    // special cases).
    // This method can be overriden in plugins.
    _WXJS.init = function (selector, context) {
      // If nothing given, return an empty _WXJS collection
      if (!selector) return _WXJS.Z()
      // If a function is given, call it when the DOM is ready
      else if (isFunction(selector)) return $(document).ready(selector)
      // If a _WXJS collection is given, juts return it
      else if (_WXJS.isZ(selector)) return selector
      else {
        var dom
        // normalize array if an array of nodes is given
        if (isArray(selector)) dom = compact(selector)
        // if a JavaScript object is given, return a copy of it
        // this is a somewhat peculiar option, but supported by
        // jQuery so we'll do it, too
        else if (isPlainObject(selector))
          dom = [$.extend({}, selector)], selector = null
        // wrap stuff like `document` or `window`
        else if (elementTypes.indexOf(selector.nodeType) >= 0 || selector === window)
          dom = [selector], selector = null
        // If it's a html fragment, create nodes from it
        else if (fragmentRE.test(selector))
          dom = _WXJS.fragment(selector.trim(), RegExp.$1), selector = null
        // If there's a context, create a collection on that context first, and select
        // nodes from there
        else if (context !== undefined) return $(context).find(selector)
        // And last but no least, if it's a CSS selector, use it to select nodes.
        else dom = _WXJS.qsa(document, selector)
        // create a new _WXJS collection from the nodes found
        return _WXJS.Z(dom, selector)
      }
    }

    // `$` will be the base `_WXJS` object. When calling this
    // function just call `$._WXJS.init, whichs makes the implementation
    // details of selecting nodes and creating _WXJS collections
    // patchable in plugins.
    $ = function (selector, context) {
      return _WXJS.init(selector, context)
    }

    // Copy all but undefined properties from one or more
    // objects to the `target` object.
    $.extend = function (target) {
      slice.call(arguments, 1).forEach(function (source) {
        for (key in source)
          if (source[key] !== undefined)
            target[key] = source[key]
      })
      return target
    }

    // `$._WXJS.qsa` is _WXJS's CSS selector implementation which
    // uses `document.querySelectorAll` and optimizes for some special cases, like `#id`.
    // This method can be overriden in plugins.
    _WXJS.qsa = function (element, selector) {
      var found
      return (element === document && idSelectorRE.test(selector)) ?
        ((found = element.getElementById(RegExp.$1)) ? [found] : emptyArray) :
        (element.nodeType !== 1 && element.nodeType !== 9) ? emptyArray :
        slice.call(
          classSelectorRE.test(selector) ? element.getElementsByClassName(RegExp.$1) :
          tagSelectorRE.test(selector) ? element.getElementsByTagName(selector) :
          element.querySelectorAll(selector)
        )
    }

    function filtered(nodes, selector) {
      return selector === undefined ? $(nodes) : $(nodes).filter(selector)
    }

    function funcArg(context, arg, idx, payload) {
      return isFunction(arg) ? arg.call(context, idx, payload) : arg
    }

    $.isFunction = isFunction
    $.isObject = isObject
    $.isArray = isArray
    $.isPlainObject = isPlainObject

    $.inArray = function (elem, array, i) {
      return emptyArray.indexOf.call(array, elem, i)
    }

    $.trim = function (str) {
      return str.trim()
    }

    // plugin compatibility
    $.uuid = 0

    $.map = function (elements, callback) {
      var value, values = [],
        i, key
      if (likeArray(elements))
        for (i = 0; i < elements.length; i++) {
          value = callback(elements[i], i)
          if (value != null) values.push(value)
        }
      else
        for (key in elements) {
          value = callback(elements[key], key)
          if (value != null) values.push(value)
        }
      return flatten(values)
    }

    $.each = function (elements, callback) {
      var i, key
      if (likeArray(elements)) {
        for (i = 0; i < elements.length; i++)
          if (callback.call(elements[i], i, elements[i]) === false) return elements
      } else {
        for (key in elements)
          if (callback.call(elements[key], key, elements[key]) === false) return elements
      }

      return elements
    }
    __initLog(__DL, "_WXJS define functions");

    // Define methods that will be available on all
    // _WXJS collections
    $.fn = {
      // Because a collection acts like an array
      // copy over these useful array functions.
      forEach: emptyArray.forEach,
      reduce: emptyArray.reduce,
      push: emptyArray.push,
      indexOf: emptyArray.indexOf,
      concat: emptyArray.concat,

      // `map` and `slice` in the jQuery API work differently
      // from their array counterparts
      map: function (fn) {
        return $.map(this, function (el, i) {
          return fn.call(el, i, el)
        })
      },
      slice: function () {
        return $(slice.apply(this, arguments))
      },

      ready: function (callback) {
        if (readyRE.test(document.readyState)) callback($)
        else document.addEventListener('DOMContentLoaded', function () {
          callback($)
        }, false)
        return this
      },
      get: function (idx) {
        return idx === undefined ? slice.call(this) : this[idx]
      },
      toArray: function () {
        return this.get()
      },
      size: function () {
        return this.length
      },
      remove: function () {
        return this.each(function () {
          if (this.parentNode != null)
            this.parentNode.removeChild(this)
        })
      },
      each: function (callback) {
        this.forEach(function (el, idx) {
          callback.call(el, idx, el)
        })
        return this
      },
      filter: function (selector) {
        return $([].filter.call(this, function (element) {
          return _WXJS.matches(element, selector)
        }))
      },
      add: function (selector, context) {
        return $(uniq(this.concat($(selector, context))))
      },
      is: function (selector) {
        return this.length > 0 && _WXJS.matches(this[0], selector)
      },
      not: function (selector) {
        var nodes = []
        if (isFunction(selector) && selector.call !== undefined)
          this.each(function (idx) {
            if (!selector.call(this, idx)) nodes.push(this)
          })
        else {
          var excludes = typeof selector == 'string' ? this.filter(selector) :
            (likeArray(selector) && isFunction(selector.item)) ? slice.call(selector) : $(selector)
          this.forEach(function (el) {
            if (excludes.indexOf(el) < 0) nodes.push(el)
          })
        }
        return $(nodes)
      },
      eq: function (idx) {
        return idx === -1 ? this.slice(idx) : this.slice(idx, +idx + 1)
      },
      first: function () {
        var el = this[0]
        return el && !isObject(el) ? el : $(el)
      },
      last: function () {
        var el = this[this.length - 1]
        return el && !isObject(el) ? el : $(el)
      },
      find: function (selector) {
        var result
        if (this.length == 1) result = _WXJS.qsa(this[0], selector)
        else result = this.map(function () {
          return _WXJS.qsa(this, selector)
        })
        return $(result)
      },
      closest: function (selector, context) {
        var node = this[0]
        while (node && !_WXJS.matches(node, selector))
          node = node !== context && node !== document && node.parentNode
        return $(node)
      },
      parents: function (selector) {
        var ancestors = [],
          nodes = this
        while (nodes.length > 0)
          nodes = $.map(nodes, function (node) {
            if ((node = node.parentNode) && node !== document && ancestors.indexOf(node) < 0) {
              ancestors.push(node)
              return node
            }
          })
        return filtered(ancestors, selector)
      },
      parent: function (selector) {
        return filtered(uniq(this.pluck('parentNode')), selector)
      },
      children: function (selector) {
        return filtered(this.map(function () {
          return slice.call(this.children)
        }), selector)
      },
      siblings: function (selector) {
        return filtered(this.map(function (i, el) {
          return slice.call(el.parentNode.children).filter(function (child) {
            return child !== el
          })
        }), selector)
      },
      empty: function () {
        return this.each(function () {
          this.innerHTML = ''
        })
      },
      // `pluck` is borrowed from Prototype.js
      pluck: function (property) {
        return this.map(function () {
          return this[property]
        })
      },
      show: function () {
        return this.each(function () {
          this.style.display == "none" && (this.style.display = null)
          if (getComputedStyle(this, '').getPropertyValue("display") == "none")
            this.style.display = defaultDisplay(this.nodeName)
        })
      },
      replaceWith: function (newContent) {
        return this.before(newContent).remove()
      },
      wrap: function (newContent) {
        return this.each(function () {
          $(this).wrapAll($(newContent)[0].cloneNode(false))
        })
      },
      wrapAll: function (newContent) {
        if (this[0]) {
          $(this[0]).before(newContent = $(newContent))
          newContent.append(this)
        }
        return this
      },
      unwrap: function () {
        this.parent().each(function () {
          $(this).replaceWith($(this).children())
        })
        return this
      },
      clone: function () {
        return $(this.map(function () {
          return this.cloneNode(true)
        }))
      },
      hide: function () {
        return this.css("display", "none")
      },
      toggle: function (setting) {
        return (setting === undefined ? this.css("display") == "none" : setting) ? this.show() : this.hide()
      },
      prev: function () {
        return $(this.pluck('previousElementSibling'))
      },
      next: function () {
        return $(this.pluck('nextElementSibling'))
      },
      html: function (html) {
        return html === undefined ?
          (this.length > 0 ? this[0].innerHTML : null) :
          this.each(function (idx) {
            var originHtml = this.innerHTML
            $(this).empty().append(funcArg(this, html, idx, originHtml))
          })
      },
      text: function (text) {
        return text === undefined ?
          (this.length > 0 ? this[0].textContent : null) :
          this.each(function () {
            this.textContent = text
          })
      },
      attr: function (name, value) {
        var result
        return (typeof name == 'string' && value === undefined) ?
          (this.length == 0 || this[0].nodeType !== 1 ? undefined :
            (name == 'value' && this[0].nodeName == 'INPUT') ? this.val() :
            (!(result = this[0].getAttribute(name)) && name in this[0]) ? this[0][name] : result
          ) :
          this.each(function (idx) {
            if (this.nodeType !== 1) return
            if (isObject(name))
              for (key in name) this.setAttribute(key, name[key])
            else this.setAttribute(name, funcArg(this, value, idx, this.getAttribute(name)))
          })
      },
      removeAttr: function (name) {
        return this.each(function () {
          if (this.nodeType === 1) this.removeAttribute(name)
        })
      },
      prop: function (name, value) {
        return (value === undefined) ?
          (this[0] ? this[0][name] : undefined) :
          this.each(function (idx) {
            this[name] = funcArg(this, value, idx, this[name])
          })
      },
      data: function (name, value) {
        var data = this.attr('data-' + dasherize(name), value)
        return data !== null ? data : undefined
      },
      val: function (value) {
        return (value === undefined) ?
          (this.length > 0 ? this[0].value : undefined) :
          this.each(function (idx) {
            this.value = funcArg(this, value, idx, this.value)
          })
      },
      offset: function () {
        if (this.length == 0) return null
        var obj = this[0].getBoundingClientRect()
        return {
          left: obj.left + window.pageXOffset,
          top: obj.top + window.pageYOffset,
          width: obj.width,
          height: obj.height
        }
      },
      css: function (property, value) {
        if (value === undefined && typeof property == 'string')
          return (
            this.length == 0 ?
            undefined :
            this[0].style[camelize(property)] || getComputedStyle(this[0], '').getPropertyValue(property))

        var css = ''
        for (key in property)
          if (typeof property[key] == 'string' && property[key] == '')
            this.each(function () {
              this.style.removeProperty(dasherize(key))
            })
        else
          css += dasherize(key) + ':' + maybeAddPx(key, property[key]) + ';'

        if (typeof property == 'string')
          if (value == '')
            this.each(function () {
              this.style.removeProperty(dasherize(property))
            })
        else
          css = dasherize(property) + ":" + maybeAddPx(property, value)

        return this.each(function () {
          this.style.cssText += ';' + css
        })
      },
      index: function (element) {
        return element ? this.indexOf($(element)[0]) : this.parent().children().indexOf(this[0])
      },
      hasClass: function (name) {
        if (this.length < 1) return false
        else return classRE(name).test(this[0].className)
      },
      addClass: function (name) {
        return this.each(function (idx) {
          classList = []
          var cls = this.className,
            newName = funcArg(this, name, idx, cls)
          newName.split(/\s+/g).forEach(function (klass) {
            if (!$(this).hasClass(klass)) classList.push(klass)
          }, this)
          classList.length && (this.className += (cls ? " " : "") + classList.join(" "))
        })
      },
      removeClass: function (name) {
        return this.each(function (idx) {
          if (name === undefined)
            return this.className = ''
          classList = this.className
          funcArg(this, name, idx, classList).split(/\s+/g).forEach(function (klass) {
            classList = classList.replace(classRE(klass), " ")
          })
          this.className = classList.trim()
        })
      },
      toggleClass: function (name, when) {
        return this.each(function (idx) {
          var newName = funcArg(this, name, idx, this.className);
          (when === undefined ? !$(this).hasClass(newName) : when) ?
          $(this).addClass(newName): $(this).removeClass(newName)
        })
      }
    }
    __initLog(__DL, "_WXJS define $.fn");

    // Generate the `width` and `height` functions
    ;
    ['width', 'height'].forEach(function (dimension) {
      $.fn[dimension] = function (value) {
        var offset, Dimension = dimension.replace(/./, function (m) {
          return m[0].toUpperCase()
        })
        if (value === undefined) return this[0] == window ? window['inner' + Dimension] :
          this[0] == document ? document.documentElement['offset' + Dimension] :
          (offset = this.offset()) && offset[dimension]
        else return this.each(function (idx) {
          var el = $(this)
          el.css(dimension, funcArg(this, value, idx, el[dimension]()))
        })
      }
    })

    function insert(operator, target, node) {
      var parent = (operator % 2) ? target : target.parentNode
      parent ? parent.insertBefore(node, !operator ? target.nextSibling : // after
          operator == 1 ? parent.firstChild : // prepend
          operator == 2 ? target : // before
          null) : // append
        $(node).remove()
    }

    function traverseNode(node, fun) {
      fun(node)
      for (var key in node.childNodes) traverseNode(node.childNodes[key], fun)
    }

    // Generate the `after`, `prepend`, `before`, `append`,
    // `insertAfter`, `insertBefore`, `appendTo`, and `prependTo` methods.
    adjacencyOperators.forEach(function (key, operator) {
      $.fn[key] = function () {
        // arguments can be nodes, arrays of nodes, _WXJS objects and HTML strings
        var nodes = $.map(arguments, function (n) {
          return isObject(n) ? n : _WXJS.fragment(n)
        })
        if (nodes.length < 1) return this
        var size = this.length,
          copyByClone = size > 1,
          inReverse = operator < 2

        return this.each(function (index, target) {
          for (var i = 0; i < nodes.length; i++) {
            var node = nodes[inReverse ? nodes.length - i - 1 : i]
            traverseNode(node, function (node) {
              if (node.nodeName != null && node.nodeName.toUpperCase() === 'SCRIPT' && (!node.type || node.type === 'text/javascript'))
                window['eval'].call(window, node.innerHTML)
            })
            if (copyByClone && index < size - 1) node = node.cloneNode(true)
            insert(operator, target, node)
          }
        })
      }

      $.fn[(operator % 2) ? key + 'To' : 'insert' + (operator ? 'Before' : 'After')] = function (html) {
        $(html)[key](this)
        return this
      }
    })

    _WXJS.Z.prototype = $.fn

    // Export internal API functions in the `$._WXJS` namespace
    _WXJS.camelize = camelize
    _WXJS.uniq = uniq
    $._WXJS = _WXJS
    __initLog(__DL, "_WXJS init finished");
    return $
  })()

  // If `$` is not yet defined, point it to `_WXJS`
  window._WXJS = _WXJS;

  (function ($) {
    var $$ = $._WXJS.qsa,
      handlers = {},
      _zid = 1,
      specialEvents = {}

    specialEvents.click = specialEvents.mousedown = specialEvents.mouseup = specialEvents.mousemove = 'MouseEvents'

    function zid(element) {
      return element._zid || (element._zid = _zid++)
    }

    function findHandlers(element, event, fn, selector) {
      event = parse(event)
      if (event.ns) var matcher = matcherFor(event.ns)
      return (handlers[zid(element)] || []).filter(function (handler) {
        return handler &&
          (!event.e || handler.e == event.e) &&
          (!event.ns || matcher.test(handler.ns)) &&
          (!fn || zid(handler.fn) === zid(fn)) &&
          (!selector || handler.sel == selector)
      })
    }

    function parse(event) {
      var parts = ('' + event).split('.')
      return {
        e: parts[0],
        ns: parts.slice(1).sort().join(' ')
      }
    }

    function matcherFor(ns) {
      return new RegExp('(?:^| )' + ns.replace(' ', ' .* ?') + '(?: |$)')
    }

    function eachEvent(events, fn, iterator) {
      if ($.isObject(events)) $.each(events, iterator)
      else events.split(/\s/).forEach(function (type) {
        iterator(type, fn)
      })
    }

    function add(element, events, fn, selector, getDelegate, capture) {
      capture = !!capture
      var id = zid(element),
        set = (handlers[id] || (handlers[id] = []))
      eachEvent(events, fn, function (event, fn) {
        var delegate = getDelegate && getDelegate(fn, event),
          callback = delegate || fn
        var proxyfn = function (event) {
          var result = callback.apply(element, [event].concat(event.data))
          if (result === false) event.preventDefault()
          return result
        }
        var handler = $.extend(parse(event), {
          fn: fn,
          proxy: proxyfn,
          sel: selector,
          del: delegate,
          i: set.length
        })
        set.push(handler)
        element.addEventListener(handler.e, proxyfn, capture)
      })
    }

    function remove(element, events, fn, selector) {
      var id = zid(element)
      eachEvent(events || '', fn, function (event, fn) {
        findHandlers(element, event, fn, selector).forEach(function (handler) {
          delete handlers[id][handler.i]
          element.removeEventListener(handler.e, handler.proxy, false)
        })
      })
    }

    $.event = {
      add: add,
      remove: remove
    }

    $.proxy = function (fn, context) {
      if ($.isFunction(fn)) {
        var proxyFn = function () {
          return fn.apply(context, arguments)
        }
        proxyFn._zid = zid(fn)
        return proxyFn
      } else if (typeof context == 'string') {
        return $.proxy(fn[context], fn)
      } else {
        throw new TypeError("expected function")
      }
    }

    $.fn.bind = function (event, callback) {
      return this.each(function () {
        add(this, event, callback)
      })
    }
    $.fn.unbind = function (event, callback) {
      return this.each(function () {
        remove(this, event, callback)
      })
    }
    $.fn.one = function (event, callback) {
      return this.each(function (i, element) {
        add(this, event, callback, null, function (fn, type) {
          return function () {
            var result = fn.apply(element, arguments)
            remove(element, type, fn)
            return result
          }
        })
      })
    }

    var returnTrue = function () {
        return true
      },
      returnFalse = function () {
        return false
      },
      eventMethods = {
        preventDefault: 'isDefaultPrevented',
        stopImmediatePropagation: 'isImmediatePropagationStopped',
        stopPropagation: 'isPropagationStopped'
      }

    function createProxy(event) {
      var proxy = $.extend({
        originalEvent: event
      }, event)
      $.each(eventMethods, function (name, predicate) {
        proxy[name] = function () {
          this[predicate] = returnTrue
          return event[name].apply(event, arguments)
        }
        proxy[predicate] = returnFalse
      })
      return proxy
    }

    // emulates the 'defaultPrevented' property for browsers that have none
    function fix(event) {
      if (!('defaultPrevented' in event)) {
        event.defaultPrevented = false
        var prevent = event.preventDefault
        event.preventDefault = function () {
          this.defaultPrevented = true
          prevent.call(this)
        }
      }
    }

    $.fn.delegate = function (selector, event, callback) {
      var capture = false
      if (event == 'blur' || event == 'focus') {
        if ($.iswebkit)
          event = event == 'blur' ? 'focusout' : event == 'focus' ? 'focusin' : event
        else
          capture = true
      }

      return this.each(function (i, element) {
        add(element, event, callback, selector, function (fn) {
          return function (e) {
            var evt, match = $(e.target).closest(selector, element).get(0)
            if (match) {
              evt = $.extend(createProxy(e), {
                currentTarget: match,
                liveFired: element
              })
              return fn.apply(match, [evt].concat([].slice.call(arguments, 1)))
            }
          }
        }, capture)
      })
    }
    $.fn.undelegate = function (selector, event, callback) {
      return this.each(function () {
        remove(this, event, callback, selector)
      })
    }

    $.fn.live = function (event, callback) {
      $(document.body).delegate(this.selector, event, callback)
      return this
    }
    $.fn.die = function (event, callback) {
      $(document.body).undelegate(this.selector, event, callback)
      return this
    }

    $.fn.on = function (event, selector, callback) {
      return selector == undefined || $.isFunction(selector) ?
        this.bind(event, selector) : this.delegate(selector, event, callback)
    }
    $.fn.off = function (event, selector, callback) {
      return selector == undefined || $.isFunction(selector) ?
        this.unbind(event, selector) : this.undelegate(selector, event, callback)
    }

    $.fn.trigger = function (event, data) {
      if (typeof event == 'string') event = $.Event(event)
      fix(event)
      event.data = data
      return this.each(function () {
        // items in the collection might not be DOM elements
        // (todo: possibly support events on plain old objects)
        if ('dispatchEvent' in this) this.dispatchEvent(event)
      })
    }

    // triggers event handlers on current element just as if an event occurred,
    // doesn't trigger an actual event, doesn't bubble
    $.fn.triggerHandler = function (event, data) {
      var e, result
      this.each(function (i, element) {
        e = createProxy(typeof event == 'string' ? $.Event(event) : event)
        e.data = data
        e.target = element
        $.each(findHandlers(element, event.type || event), function (i, handler) {
          result = handler.proxy(e)
          if (e.isImmediatePropagationStopped()) return false
        })
      })
      return result
    }

    // shortcut methods for `.bind(event, fn)` for each event type
    ;
    ('focusin focusout load resize scroll unload click dblclick ' +
      'mousedown mouseup mousemove mouseover mouseout ' +
      'change select keydown keypress keyup error').split(' ').forEach(function (event) {
      $.fn[event] = function (callback) {
        return this.bind(event, callback)
      }
    })

    ;
    ['focus', 'blur'].forEach(function (name) {
      $.fn[name] = function (callback) {
        if (callback) this.bind(name, callback)
        else if (this.length) try {
          this.get(0)[name]()
        } catch (e) {}
        return this
      }
    })

    $.Event = function (type, props) {
      var event = document.createEvent(specialEvents[type] || 'Events'),
        bubbles = true
      if (props)
        for (var name in props)(name == 'bubbles') ? (bubbles = !!props[name]) : (event[name] = props[name])
      event.initEvent(type, bubbles, true, null, null, null, null, null, null, null, null, null, null, null, null)
      return event
    }

  })(_WXJS);
  __initLog(__DL, "$ init 1");

  (function ($) {
    function detect(ua) {
      var os = this.os = {},
        browser = this.browser = {},
        webkit = ua.match(/WebKit\/([\d.]+)/),
        android = ua.match(/(Android)\s+([\d.]+)/),
        ipad = ua.match(/(iPad).*OS\s([\d_]+)/),
        iphone = !ipad && ua.match(/(iPhone\sOS)\s([\d_]+)/),
        webos = ua.match(/(webOS|hpwOS)[\s\/]([\d.]+)/),
        touchpad = webos && ua.match(/TouchPad/),
        kindle = ua.match(/Kindle\/([\d.]+)/),
        silk = ua.match(/Silk\/([\d._]+)/),
        blackberry = ua.match(/(BlackBerry).*Version\/([\d.]+)/)

      // todo clean this up with a better OS/browser
      // separation. we need to discern between multiple
      // browsers on android, and decide if kindle fire in
      // silk mode is android or not

      if (browser.webkit = !!webkit) browser.version = webkit[1]

      if (android) os.android = true, os.version = android[2]
      if (iphone) os.ios = os.iphone = true, os.version = iphone[2].replace(/_/g, '.')
      if (ipad) os.ios = os.ipad = true, os.version = ipad[2].replace(/_/g, '.')
      if (webos) os.webos = true, os.version = webos[2]
      if (touchpad) os.touchpad = true
      if (blackberry) os.blackberry = true, os.version = blackberry[2]
      if (kindle) os.kindle = true, os.version = kindle[1]
      if (silk) browser.silk = true, browser.version = silk[1]
      if (!silk && os.android && ua.match(/Kindle Fire/)) browser.silk = true
    }

    detect.call($, navigator.userAgent)
    // make available to unit tests
    $.__detect = detect

  })(_WXJS);
  __initLog(__DL, "$ init 2");

  (function ($, undefined) {
    var prefix = '',
      eventPrefix, endEventName, endAnimationName,
      vendors = {
        Webkit: 'webkit',
        Moz: '',
        O: 'o',
        ms: 'MS'
      },
      document = window.document,
      testEl = document.createElement('div'),
      supportedTransforms = /^((translate|rotate|scale)(X|Y|Z|3d)?|matrix(3d)?|perspective|skew(X|Y)?)$/i,
      clearProperties = {}

    function downcase(str) {
      return str.toLowerCase()
    }

    function normalizeEvent(name) {
      return eventPrefix ? eventPrefix + name : downcase(name)
    }

    $.each(vendors, function (vendor, event) {
      if (testEl.style[vendor + 'TransitionProperty'] !== undefined) {
        prefix = '-' + downcase(vendor) + '-'
        eventPrefix = event
        return false
      }
    })

    clearProperties[prefix + 'transition-property'] =
      clearProperties[prefix + 'transition-duration'] =
      clearProperties[prefix + 'transition-timing-function'] =
      clearProperties[prefix + 'animation-name'] =
      clearProperties[prefix + 'animation-duration'] = ''

    $.fx = {
      off: (eventPrefix === undefined && testEl.style.transitionProperty === undefined),
      cssPrefix: prefix,
      transitionEnd: normalizeEvent('TransitionEnd'),
      animationEnd: normalizeEvent('AnimationEnd')
    }

    $.fn.animate = function (properties, duration, ease, callback) {
      if ($.isObject(duration))
        ease = duration.easing, callback = duration.complete, duration = duration.duration
      if (duration) duration = duration / 1000
      return this.anim(properties, duration, ease, callback)
    }

    $.fn.anim = function (properties, duration, ease, callback) {
      var transforms, cssProperties = {},
        key, that = this,
        wrappedCallback, endEvent = $.fx.transitionEnd
      if (duration === undefined) duration = 0.4
      if ($.fx.off) duration = 0

      if (typeof properties == 'string') {
        // keyframe animation
        cssProperties[prefix + 'animation-name'] = properties
        cssProperties[prefix + 'animation-duration'] = duration + 's'
        endEvent = $.fx.animationEnd
      } else {
        // CSS transitions
        for (key in properties)
          if (supportedTransforms.test(key)) {
            transforms || (transforms = [])
            transforms.push(key + '(' + properties[key] + ')')
          }
        else cssProperties[key] = properties[key]

        if (transforms) cssProperties[prefix + 'transform'] = transforms.join(' ')
        if (!$.fx.off && typeof properties === 'object') {
          cssProperties[prefix + 'transition-property'] = Object.keys(properties).join(', ')
          cssProperties[prefix + 'transition-duration'] = duration + 's'
          cssProperties[prefix + 'transition-timing-function'] = (ease || 'linear')
        }
      }

      wrappedCallback = function (event) {
        if (typeof event !== 'undefined') {
          if (event.target !== event.currentTarget) return // makes sure the event didn't bubble from "below"
          $(event.target).unbind(endEvent, arguments.callee)
        }
        $(this).css(clearProperties)
        callback && callback.call(this)
      }
      if (duration > 0) this.bind(endEvent, wrappedCallback)

      setTimeout(function () {
        that.css(cssProperties)
        if (duration <= 0) setTimeout(function () {
          that.each(function () {
            wrappedCallback.call(this)
          })
        }, 0)
      }, 0)

      return this
    }

    testEl = null
  })(_WXJS);
  __initLog(__DL, "$ init 3");

  (function ($) {
    var jsonpID = 0,
      isObject = $.isObject,
      document = window.document,
      key,
      name,
      rscript = /<script\b[^<]*(?:(?!<\/script>)<[^<]*)*<\/script>/gi,
      scriptTypeRE = /^(?:text|application)\/javascript/i,
      xmlTypeRE = /^(?:text|application)\/xml/i,
      jsonType = 'application/json',
      htmlType = 'text/html',
      blankRE = /^\s*$/

    // trigger a custom event and return false if it was cancelled
    function triggerAndReturn(context, eventName, data) {
      var event = $.Event(eventName)
      $(context).trigger(event, data)
      return !event.defaultPrevented
    }

    // trigger an Ajax "global" event
    function triggerGlobal(settings, context, eventName, data) {
      if (settings.global) return triggerAndReturn(context || document, eventName, data)
    }

    // Number of active Ajax requests
    $.active = 0

    function ajaxStart(settings) {
      if (settings.global && $.active++ === 0) triggerGlobal(settings, null, 'ajaxStart')
    }

    function ajaxStop(settings) {
      if (settings.global && !(--$.active)) triggerGlobal(settings, null, 'ajaxStop')
    }

    // triggers an extra global event "ajaxBeforeSend" that's like "ajaxSend" but cancelable
    function ajaxBeforeSend(xhr, settings) {
      var context = settings.context
      if (settings.beforeSend.call(context, xhr, settings) === false ||
        triggerGlobal(settings, context, 'ajaxBeforeSend', [xhr, settings]) === false)
        return false

      triggerGlobal(settings, context, 'ajaxSend', [xhr, settings])
    }

    function ajaxSuccess(data, xhr, settings) {
      var context = settings.context,
        status = 'success'
      settings.success.call(context, data, status, xhr)
      triggerGlobal(settings, context, 'ajaxSuccess', [xhr, settings, data])
      ajaxComplete(status, xhr, settings)
    }
    // type: "timeout", "error", "abort", "parsererror"
    function ajaxError(error, type, xhr, settings) {
      var context = settings.context
      settings.error.call(context, xhr, type, error)
      triggerGlobal(settings, context, 'ajaxError', [xhr, settings, error])
      ajaxComplete(type, xhr, settings)
    }
    // status: "success", "notmodified", "error", "timeout", "abort", "parsererror"
    function ajaxComplete(status, xhr, settings) {
      var context = settings.context
      settings.complete.call(context, xhr, status)
      triggerGlobal(settings, context, 'ajaxComplete', [xhr, settings])
      ajaxStop(settings)
    }

    // Empty function, used as default callback
    function empty() {}

    $.ajaxJSONP = function (options) {
      var callbackName = 'jsonp' + (++jsonpID),
        script = document.createElement('script'),
        abort = function () {
          $(script).remove()
          if (callbackName in window) window[callbackName] = empty
          ajaxComplete('abort', xhr, options)
        },
        xhr = {
          abort: abort
        },
        abortTimeout

      if (options.error) script.onerror = function () {
        xhr.abort()
        options.error()
      }

      window[callbackName] = function (data) {
        clearTimeout(abortTimeout)
        $(script).remove()
        delete window[callbackName]
        ajaxSuccess(data, xhr, options)
      }

      serializeData(options)
      script.src = options.url.replace(/=\?/, '=' + callbackName)
      $('head').append(script)

      if (options.timeout > 0) abortTimeout = setTimeout(function () {
        xhr.abort()
        ajaxComplete('timeout', xhr, options)
      }, options.timeout)

      return xhr
    }

    $.ajaxSettings = {
      // Default type of request
      type: 'GET',
      // Callback that is executed before request
      beforeSend: empty,
      // Callback that is executed if the request succeeds
      success: empty,
      // Callback that is executed the the server drops error
      error: empty,
      // Callback that is executed on request complete (both: error and success)
      complete: empty,
      // The context for the callbacks
      context: null,
      // Whether to trigger "global" Ajax events
      global: true,
      // Transport
      xhr: function () {
        return new window.XMLHttpRequest()
      },
      // MIME types mapping
      accepts: {
        script: 'text/javascript, application/javascript',
        json: jsonType,
        xml: 'application/xml, text/xml',
        html: htmlType,
        text: 'text/plain'
      },
      // Whether the request is to another domain
      crossDomain: false,
      // Default timeout
      timeout: 0
    }

    function mimeToDataType(mime) {
      return mime && (mime == htmlType ? 'html' :
        mime == jsonType ? 'json' :
        scriptTypeRE.test(mime) ? 'script' :
        xmlTypeRE.test(mime) && 'xml') || 'text'
    }

    function appendQuery(url, query) {
      return (url + '&' + query).replace(/[&?]{1,2}/, '?')
    }

    // serialize payload and append it to the URL for GET requests
    function serializeData(options) {
      if (isObject(options.data)) options.data = $.param(options.data)
      if (options.data && (!options.type || options.type.toUpperCase() == 'GET'))
        options.url = appendQuery(options.url, options.data)
    }

    $.ajax = function (options) {
      var settings = $.extend({}, options || {})
      for (key in $.ajaxSettings)
        if (settings[key] === undefined) settings[key] = $.ajaxSettings[key]

      ajaxStart(settings)

      if (!settings.crossDomain) settings.crossDomain = /^([\w-]+:)?\/\/([^\/]+)/.test(settings.url) &&
        RegExp.$2 != window.location.host

      var dataType = settings.dataType,
        hasPlaceholder = /=\?/.test(settings.url)
      if (dataType == 'jsonp' || hasPlaceholder) {
        if (!hasPlaceholder) settings.url = appendQuery(settings.url, 'callback=?')
        return $.ajaxJSONP(settings)
      }

      if (!settings.url) settings.url = window.location.toString()
      serializeData(settings)

      var mime = settings.accepts[dataType],
        baseHeaders = {},
        protocol = /^([\w-]+:)\/\//.test(settings.url) ? RegExp.$1 : window.location.protocol,
        xhr = $.ajaxSettings.xhr(),
        abortTimeout

      if (!settings.crossDomain) baseHeaders['X-Requested-With'] = 'XMLHttpRequest'
      if (mime) {
        baseHeaders['Accept'] = mime
        if (mime.indexOf(',') > -1) mime = mime.split(',', 2)[0]
        xhr.overrideMimeType && xhr.overrideMimeType(mime)
      }
      if (settings.contentType || (settings.data && settings.type.toUpperCase() != 'GET'))
        baseHeaders['Content-Type'] = (settings.contentType || 'application/x-www-form-urlencoded')
      settings.headers = $.extend(baseHeaders, settings.headers || {})

      xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
          clearTimeout(abortTimeout)
          var result, error = false
          if ((xhr.status >= 200 && xhr.status < 300) || xhr.status == 304 || (xhr.status == 0 && protocol == 'file:')) {
            dataType = dataType || mimeToDataType(xhr.getResponseHeader('content-type'))
            result = xhr.responseText

            try {
              if (dataType == 'script')(1, eval)(result)
              else if (dataType == 'xml') result = xhr.responseXML
              else if (dataType == 'json') result = blankRE.test(result) ? null : JSON.parse(result)
            } catch (e) {
              error = e
            }

            if (error) ajaxError(error, 'parsererror', xhr, settings)
            else ajaxSuccess(result, xhr, settings)
          } else {
            ajaxError(null, 'error', xhr, settings)
          }
        }
      }

      var async = 'async' in settings ? settings.async : true
      xhr.open(settings.type, settings.url, async)

      for (name in settings.headers) xhr.setRequestHeader(name, settings.headers[name])

      if (ajaxBeforeSend(xhr, settings) === false) {
        xhr.abort()
        return false
      }

      if (settings.timeout > 0) abortTimeout = setTimeout(function () {
        xhr.onreadystatechange = empty
        xhr.abort()
        ajaxError(null, 'timeout', xhr, settings)
      }, settings.timeout)

      // avoid sending empty string (#319)
      xhr.send(settings.data ? settings.data : null)
      return xhr
    }

    $.get = function (url, success) {
      return $.ajax({
        url: url,
        success: success
      })
    }

    $.post = function (url, data, success, dataType) {
      if ($.isFunction(data)) dataType = dataType || success, success = data, data = null
      return $.ajax({
        type: 'POST',
        url: url,
        data: data,
        success: success,
        dataType: dataType
      })
    }

    $.getJSON = function (url, success) {
      return $.ajax({
        url: url,
        success: success,
        dataType: 'json'
      })
    }

    $.fn.load = function (url, success) {
      if (!this.length) return this
      var self = this,
        parts = url.split(/\s/),
        selector
      if (parts.length > 1) url = parts[0], selector = parts[1]
      $.get(url, function (response) {
        self.html(selector ?
          $(document.createElement('div')).html(response.replace(rscript, "")).find(selector).html() :
          response)
        success && success.call(self)
      })
      return this
    }

    var escape = encodeURIComponent

    function serialize(params, obj, traditional, scope) {
      var array = $.isArray(obj)
      $.each(obj, function (key, value) {
        if (scope) key = traditional ? scope : scope + '[' + (array ? '' : key) + ']'
        // handle data in serializeArray() format
        if (!scope && array) params.add(value.name, value.value)
        // recurse into nested objects
        else if (traditional ? $.isArray(value) : isObject(value))
          serialize(params, value, traditional, key)
        else params.add(key, value)
      })
    }

    $.param = function (obj, traditional) {
      var params = []
      params.add = function (k, v) {
        this.push(escape(k) + '=' + escape(v))
      }
      serialize(params, obj, traditional)
      return params.join('&').replace('%20', '+')
    }
  })(_WXJS);
  __initLog(__DL, "$ init 4");

  (function ($) {
    $.fn.serializeArray = function () {
      var result = [],
        el
      $(Array.prototype.slice.call(this.get(0).elements)).each(function () {
        el = $(this)
        var type = el.attr('type')
        if (this.nodeName.toLowerCase() != 'fieldset' &&
          !this.disabled && type != 'submit' && type != 'reset' && type != 'button' &&
          ((type != 'radio' && type != 'checkbox') || this.checked))
          result.push({
            name: el.attr('name'),
            value: el.val()
          })
      })
      return result
    }

    $.fn.serialize = function () {
      var result = []
      this.serializeArray().forEach(function (elm) {
        result.push(encodeURIComponent(elm.name) + '=' + encodeURIComponent(elm.value))
      })
      return result.join('&')
    }

    $.fn.submit = function (callback) {
      if (callback) this.bind('submit', callback)
      else if (this.length) {
        var event = $.Event('submit')
        this.eq(0).trigger(event)
        if (!event.defaultPrevented) this.get(0).submit()
      }
      return this
    }

  })(_WXJS);
  __initLog(__DL, "$ init 5");

  (function ($) {
    var touch = {},
      touchTimeout

    function parentIfText(node) {
      return 'tagName' in node ? node : node.parentNode
    }

    function swipeDirection(x1, x2, y1, y2) {
      var xDelta = Math.abs(x1 - x2),
        yDelta = Math.abs(y1 - y2)
      return xDelta >= yDelta ? (x1 - x2 > 0 ? 'Left' : 'Right') : (y1 - y2 > 0 ? 'Up' : 'Down')
    }

    var longTapDelay = 750,
      longTapTimeout

    function longTap() {
      longTapTimeout = null
      if (touch.last) {
        if (touch.el) {
          touch.el.trigger('wx-longTap')
        }
        touch = {}
      }
    }

    function cancelLongTap() {
      if (longTapTimeout) clearTimeout(longTapTimeout)
      longTapTimeout = null
    }

    $(document).ready(function () {
      var now, delta

      $(document.body).bind('touchstart', function (e) {
        now = Date.now()
        delta = now - (touch.last || now)
        touch.el = $(parentIfText(e.touches[0].target))
        touchTimeout && clearTimeout(touchTimeout)
        touch.x1 = e.touches[0].pageX
        touch.y1 = e.touches[0].pageY
        if (delta > 0 && delta <= 250) touch.isDoubleTap = true
        touch.last = now
        longTapTimeout = setTimeout(longTap, longTapDelay)
      }).bind('touchmove', function (e) {
        cancelLongTap()
        touch.x2 = e.touches[0].pageX
        touch.y2 = e.touches[0].pageY
      }).bind('touchend', function (e) {
        cancelLongTap()

        // double tap (tapped twice within 250ms)
        if (touch.isDoubleTap) {
          if (touch.el) {
            touch.el.trigger('wx-doubleTap')
          }
          touch = {}

          // swipe
        } else if ((touch.x2 && Math.abs(touch.x1 - touch.x2) > 30) ||
          (touch.y2 && Math.abs(touch.y1 - touch.y2) > 30)) {
          if (touch.el) {
            touch.el.trigger('wx-swipe') &&
              touch.el.trigger('wx-swipe' + (swipeDirection(touch.x1, touch.x2, touch.y1, touch.y2)))
          }
          touch = {}

          // normal tap
        } else if ('last' in touch) {
          if (touch.el) {
            touch.el.trigger('wx-tap')
          }
          touchTimeout = setTimeout(function () {
            touchTimeout = null
            if (touch.el) {
              touch.el.trigger('wx-singleTap')
              touch = {}
            }
          }, 250)
        }
      }).bind('touchcancel', function () {
        if (touchTimeout) clearTimeout(touchTimeout)
        if (longTapTimeout) clearTimeout(longTapTimeout)
        longTapTimeout = touchTimeout = null
        touch = {}
      })
    })

    ;
    ['wx-swipe', 'wx-swipeLeft', 'wx-swipeRight', 'wx-swipeUp', 'wx-swipeDown', 'wx-doubleTap', 'wx-tap', 'wx-singleTap', 'wx-longTap'].forEach(function (m) {
      $.fn[m] = function (callback) {
        return this.bind(m, callback)
      }
    })
  })(_WXJS)
  __initLog(__DL, "$ init 6");

  // sprintf
  var sprintf = (function () {
    function get_type(variable) {
      return Object.prototype.toString.call(variable).slice(8, -1).toLowerCase();
    }

    function str_repeat(input, multiplier) {
      for (var output = []; multiplier > 0; output[--multiplier] = input) { /* do nothing */ }
      return output.join('');
    }

    var str_format = function () {
      if (!str_format.cache.hasOwnProperty(arguments[0])) {
        str_format.cache[arguments[0]] = str_format.parse(arguments[0]);
      }
      return str_format.format.call(null, str_format.cache[arguments[0]], arguments);
    };

    str_format.format = function (parse_tree, argv) {
      var cursor = 1,
        tree_length = parse_tree.length,
        node_type = '',
        arg, output = [],
        i, k, match, pad, pad_character, pad_length;
      for (i = 0; i < tree_length; i++) {
        node_type = get_type(parse_tree[i]);
        if (node_type === 'string') {
          output.push(parse_tree[i]);
        } else if (node_type === 'array') {
          match = parse_tree[i]; // convenience purposes only
          if (match[2]) { // keyword argument
            arg = argv[cursor];
            for (k = 0; k < match[2].length; k++) {
              if (!arg.hasOwnProperty(match[2][k])) {
                throw (sprintf('[sprintf] property "%s" does not exist', match[2][k]));
              }
              arg = arg[match[2][k]];
            }
          } else if (match[1]) { // positional argument (explicit)
            arg = argv[match[1]];
          } else { // positional argument (implicit)
            arg = argv[cursor++];
          }

          if (/[^s]/.test(match[8]) && (get_type(arg) != 'number')) {
            throw (sprintf('[sprintf] expecting number but found %s', get_type(arg)));
          }
          switch (match[8]) {
            case 'b':
              arg = arg.toString(2);
              break;
            case 'c':
              arg = String.fromCharCode(arg);
              break;
            case 'd':
              arg = parseInt(arg, 10);
              break;
            case 'e':
              arg = match[7] ? arg.toExponential(match[7]) : arg.toExponential();
              break;
            case 'f':
              arg = match[7] ? parseFloat(arg).toFixed(match[7]) : parseFloat(arg);
              break;
            case 'o':
              arg = arg.toString(8);
              break;
            case 's':
              arg = ((arg = String(arg)) && match[7] ? arg.substring(0, match[7]) : arg);
              break;
            case 'u':
              arg = Math.abs(arg);
              break;
            case 'x':
              arg = arg.toString(16);
              break;
            case 'X':
              arg = arg.toString(16).toUpperCase();
              break;
          }
          arg = (/[def]/.test(match[8]) && match[3] && arg >= 0 ? '+' + arg : arg);
          pad_character = match[4] ? match[4] == '0' ? '0' : match[4].charAt(1) : ' ';
          pad_length = match[6] - String(arg).length;
          pad = match[6] ? str_repeat(pad_character, pad_length) : '';
          output.push(match[5] ? arg + pad : pad + arg);
        }
      }
      return output.join('');
    };

    str_format.cache = {};

    str_format.parse = function (fmt) {
      var _fmt = fmt,
        match = [],
        parse_tree = [],
        arg_names = 0;
      while (_fmt) {
        if ((match = /^[^\x25]+/.exec(_fmt)) !== null) {
          parse_tree.push(match[0]);
        } else if ((match = /^\x25{2}/.exec(_fmt)) !== null) {
          parse_tree.push('%');
        } else if ((match = /^\x25(?:([1-9]\d*)\$|\(([^\)]+)\))?(\+)?(0|'[^$])?(-)?(\d+)?(?:\.(\d+))?([b-fosuxX])/.exec(_fmt)) !== null) {
          if (match[2]) {
            arg_names |= 1;
            var field_list = [],
              replacement_field = match[2],
              field_match = [];
            if ((field_match = /^([a-z_][a-z_\d]*)/i.exec(replacement_field)) !== null) {
              field_list.push(field_match[1]);
              while ((replacement_field = replacement_field.substring(field_match[0].length)) !== '') {
                if ((field_match = /^\.([a-z_][a-z_\d]*)/i.exec(replacement_field)) !== null) {
                  field_list.push(field_match[1]);
                } else if ((field_match = /^\[(\d+)\]/.exec(replacement_field)) !== null) {
                  field_list.push(field_match[1]);
                } else {
                  throw ('[sprintf] huh?');
                }
              }
            } else {
              throw ('[sprintf] huh?');
            }
            match[2] = field_list;
          } else {
            arg_names |= 2;
          }
          if (arg_names === 3) {
            throw ('[sprintf] mixing positional and named placeholders is not (yet) supported');
          }
          parse_tree.push(match);
        } else {
          throw ('[sprintf] huh?');
        }
        _fmt = _fmt.substring(match[0].length);
      }
      return parse_tree;
    };

    return str_format;
  })();

  var vsprintf = function (fmt, argv) {
    argv.unshift(fmt);
    return sprintf.apply(null, argv);
  };
  __initLog(__DL, "sprintf vsprintf init");

  // UTF8
  var UTF8 = {

    // public method for url encoding
    encode: function (string) {
      string = string.replace(/\r\n/g, "\n");
      var utftext = "";

      for (var n = 0; n < string.length; n++) {

        var c = string.charCodeAt(n);

        if (c < 128) {
          utftext += String.fromCharCode(c);
        } else if ((c > 127) && (c < 2048)) {
          utftext += String.fromCharCode((c >> 6) | 192);
          utftext += String.fromCharCode((c & 63) | 128);
        } else {
          utftext += String.fromCharCode((c >> 12) | 224);
          utftext += String.fromCharCode(((c >> 6) & 63) | 128);
          utftext += String.fromCharCode((c & 63) | 128);
        }

      }

      return utftext;
    },

    // public method for url decoding
    decode: function (utftext) {
      var string = "";
      var i = 0;
      var c = c1 = c2 = 0;

      while (i < utftext.length) {

        c = utftext.charCodeAt(i);

        if (c < 128) {
          string += String.fromCharCode(c);
          i++;
        } else if ((c > 191) && (c < 224)) {
          c2 = utftext.charCodeAt(i + 1);
          string += String.fromCharCode(((c & 31) << 6) | (c2 & 63));
          i += 2;
        } else {
          c2 = utftext.charCodeAt(i + 1);
          c3 = utftext.charCodeAt(i + 2);
          string += String.fromCharCode(((c & 15) << 12) | ((c2 & 63) << 6) | (c3 & 63));
          i += 3;
        }

      }

      return string;
    }

  };

  var HEX = {
    encode: function (str) {
      var r = "";
      var e = str.length;
      var c = 0;
      var h;
      while (c < e) {
        h = str.charCodeAt(c++).toString(16);
        while (h.length < 2) h = "0" + h;
        r += h;
      }
      return r.toUpperCase();
    },

    decode: function (str) {
      var r = "";
      var e = str.length;
      var s;
      while (e >= 0) {
        s = e - 2;
        r = String.fromCharCode("0x" + str.substring(s, e)) + r;
        e = s;
      }
      return r;
    }
  };

  var base64encodechars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

  function base64encode(str) {
    if (str === undefined) {
      return str;
    }

    var out, i, len;
    var c1, c2, c3;
    len = str.length;
    i = 0;
    out = "";
    while (i < len) {
      c1 = str.charCodeAt(i++) & 0xff;
      if (i == len) {
        out += base64encodechars.charAt(c1 >> 2);
        out += base64encodechars.charAt((c1 & 0x3) << 4);
        out += "==";
        break;
      }
      c2 = str.charCodeAt(i++);
      if (i == len) {
        out += base64encodechars.charAt(c1 >> 2);
        out += base64encodechars.charAt(((c1 & 0x3) << 4) | ((c2 & 0xf0) >> 4));
        out += base64encodechars.charAt((c2 & 0xf) << 2);
        out += "=";
        break;
      }
      c3 = str.charCodeAt(i++);
      out += base64encodechars.charAt(c1 >> 2);
      out += base64encodechars.charAt(((c1 & 0x3) << 4) | ((c2 & 0xf0) >> 4));
      out += base64encodechars.charAt(((c2 & 0xf) << 2) | ((c3 & 0xc0) >> 6));
      out += base64encodechars.charAt(c3 & 0x3f);
    }
    return out;
  }

  var CryptoJS = CryptoJS || function (e, m) {
    var p = {},
      j = p.lib = {},
      l = function () {},
      f = j.Base = {
        extend: function (a) {
          l.prototype = this;
          var c = new l;
          a && c.mixIn(a);
          c.hasOwnProperty("init") || (c.init = function () {
            c.$super.init.apply(this, arguments)
          });
          c.init.prototype = c;
          c.$super = this;
          return c
        },
        create: function () {
          var a = this.extend();
          a.init.apply(a, arguments);
          return a
        },
        init: function () {},
        mixIn: function (a) {
          for (var c in a) a.hasOwnProperty(c) && (this[c] = a[c]);
          a.hasOwnProperty("toString") && (this.toString = a.toString)
        },
        clone: function () {
          return this.init.prototype.extend(this)
        }
      },
      n = j.WordArray = f.extend({
        init: function (a, c) {
          a = this.words = a || [];
          this.sigBytes = c != m ? c : 4 * a.length
        },
        toString: function (a) {
          return (a || h).stringify(this)
        },
        concat: function (a) {
          var c = this.words,
            q = a.words,
            d = this.sigBytes;
          a = a.sigBytes;
          this.clamp();
          if (d % 4)
            for (var b = 0; b < a; b++) c[d + b >>> 2] |= (q[b >>> 2] >>> 24 - 8 * (b % 4) & 255) << 24 - 8 * ((d + b) % 4);
          else if (65535 < q.length)
            for (b = 0; b < a; b += 4) c[d + b >>> 2] = q[b >>> 2];
          else c.push.apply(c, q);
          this.sigBytes += a;
          return this
        },
        clamp: function () {
          var a = this.words,
            c = this.sigBytes;
          a[c >>> 2] &= 4294967295 << 32 - 8 * (c % 4);
          a.length = e.ceil(c / 4)
        },
        clone: function () {
          var a = f.clone.call(this);
          a.words = this.words.slice(0);
          return a
        },
        random: function (a) {
          for (var c = [], b = 0; b < a; b += 4) c.push(4294967296 * e.random() | 0);
          return new n.init(c, a)
        }
      }),
      b = p.enc = {},
      h = b.Hex = {
        stringify: function (a) {
          var c = a.words;
          a = a.sigBytes;
          for (var b = [], d = 0; d < a; d++) {
            var f = c[d >>> 2] >>> 24 - 8 * (d % 4) & 255;
            b.push((f >>> 4).toString(16));
            b.push((f & 15).toString(16))
          }
          return b.join("")
        },
        parse: function (a) {
          for (var c = a.length,
              b = [], d = 0; d < c; d += 2) b[d >>> 3] |= parseInt(a.substr(d, 2), 16) << 24 - 4 * (d % 8);
          return new n.init(b, c / 2)
        }
      },
      g = b.Latin1 = {
        stringify: function (a) {
          var c = a.words;
          a = a.sigBytes;
          for (var b = [], d = 0; d < a; d++) b.push(String.fromCharCode(c[d >>> 2] >>> 24 - 8 * (d % 4) & 255));
          return b.join("")
        },
        parse: function (a) {
          for (var c = a.length,
              b = [], d = 0; d < c; d++) b[d >>> 2] |= (a.charCodeAt(d) & 255) << 24 - 8 * (d % 4);
          return new n.init(b, c)
        }
      },
      r = b.Utf8 = {
        stringify: function (a) {
          try {
            return decodeURIComponent(escape(g.stringify(a)))
          } catch (c) {
            throw Error("Malformed UTF-8 data");
          }
        },
        parse: function (a) {
          return g.parse(unescape(encodeURIComponent(a)))
        }
      },
      k = j.BufferedBlockAlgorithm = f.extend({
        reset: function () {
          this._data = new n.init;
          this._nDataBytes = 0
        },
        _append: function (a) {
          "string" == typeof a && (a = r.parse(a));
          this._data.concat(a);
          this._nDataBytes += a.sigBytes
        },
        _process: function (a) {
          var c = this._data,
            b = c.words,
            d = c.sigBytes,
            f = this.blockSize,
            h = d / (4 * f),
            h = a ? e.ceil(h) : e.max((h | 0) - this._minBufferSize, 0);
          a = h * f;
          d = e.min(4 * a, d);
          if (a) {
            for (var g = 0; g < a; g += f) this._doProcessBlock(b, g);
            g = b.splice(0, a);
            c.sigBytes -= d
          }
          return new n.init(g, d)
        },
        clone: function () {
          var a = f.clone.call(this);
          a._data = this._data.clone();
          return a
        },
        _minBufferSize: 0
      });
    j.Hasher = k.extend({
      cfg: f.extend(),
      init: function (a) {
        this.cfg = this.cfg.extend(a);
        this.reset()
      },
      reset: function () {
        k.reset.call(this);
        this._doReset()
      },
      update: function (a) {
        this._append(a);
        this._process();
        return this
      },
      finalize: function (a) {
        a && this._append(a);
        return this._doFinalize()
      },
      blockSize: 16,
      _createHelper: function (a) {
        return function (c, b) {
          return (new a.init(b)).finalize(c)
        }
      },
      _createHmacHelper: function (a) {
        return function (b, f) {
          return (new s.HMAC.init(a, f)).finalize(b)
        }
      }
    });
    var s = p.algo = {};
    return p
  }(Math);

  (function () {
    var e = CryptoJS,
      m = e.lib,
      p = m.WordArray,
      j = m.Hasher,
      l = [],
      m = e.algo.SHA1 = j.extend({
        _doReset: function () {
          this._hash = new p.init([1732584193, 4023233417, 2562383102, 271733878, 3285377520])
        },
        _doProcessBlock: function (f, n) {
          for (var b = this._hash.words,
              h = b[0], g = b[1], e = b[2], k = b[3], j = b[4], a = 0; 80 > a; a++) {
            if (16 > a) l[a] = f[n + a] | 0;
            else {
              var c = l[a - 3] ^ l[a - 8] ^ l[a - 14] ^ l[a - 16];
              l[a] = c << 1 | c >>> 31
            }
            c = (h << 5 | h >>> 27) + j + l[a];
            c = 20 > a ? c + ((g & e | ~g & k) + 1518500249) : 40 > a ? c + ((g ^ e ^ k) + 1859775393) : 60 > a ? c + ((g & e | g & k | e & k) - 1894007588) : c + ((g ^ e ^ k) - 899497514);
            j = k;
            k = e;
            e = g << 30 | g >>> 2;
            g = h;
            h = c
          }
          b[0] = b[0] + h | 0;
          b[1] = b[1] + g | 0;
          b[2] = b[2] + e | 0;
          b[3] = b[3] + k | 0;
          b[4] = b[4] + j | 0
        },
        _doFinalize: function () {
          var f = this._data,
            e = f.words,
            b = 8 * this._nDataBytes,
            h = 8 * f.sigBytes;
          e[h >>> 5] |= 128 << 24 - h % 32;
          e[(h + 64 >>> 9 << 4) + 14] = Math.floor(b / 4294967296);
          e[(h + 64 >>> 9 << 4) + 15] = b;
          f.sigBytes = 4 * e.length;
          this._process();
          return this._hash
        },
        clone: function () {
          var e = j.clone.call(this);
          e._hash = this._hash.clone();
          return e
        }
      });
    e.SHA1 = j._createHelper(m);
    e.HmacSHA1 = j._createHmacHelper(m)
  })();
  __initLog(__DL, "UTF8 HEX base64 CryptoJS init");

  /* ========== REAL WXJS START ========== */

  var __wx = window.__wx;
  if (!__wx) return "WeixinJSBridge init err: __wx not found"
  delete window.__wx;

  var _readyMessageIframe, _sendMessageQueue = [],
    _receiveMessageQueue = [],
    _callback_count = 1000,
    _callback_map = {},
    _event_hook_map = {},
    _session_data = {},
    _MESSAGE_SEPERATOR = '__wxmsg_sep__',
    _CUSTOM_PROTOCOL_SCHEME = 'weixin',
    _MESSAGE_TYPE = '__msg_type',
    _CALLBACK_ID = '__callback_id',
    _EVENT_ID = '__event_id',
    _QUEUE_HAS_MESSAGE = 'dispatch_message/',
    _setResultIframe; // 用于替代addJavascriptInterface的替代方案，返回值通过修改该iframe src实现
  //创建ifram的准备队列

  var _runOn3rdApiList = [], //可以在第三方网页上运行的api列表
    _event_hook_map_for3rd = {}, //第三方网页hook的事件表 'event' => callback
    _RUN_ON_3RD_APIS = '__runOn3rd_apis';

  var _JSON_MESSAGE = '__json_message',
    _MSG_QUEUE = '__msg_queue',
    _CONTEXT_KEY = '__context_key',
    _context_val = '',
    _SHA_KEY = '__sha_key',
    _xxyy = __dgtRdm || __wx._getDgtVerifyRandomStr && __wx._getDgtVerifyRandomStr(),
    isDgtVerifyEnabled = __dgtOn || __wx._isDgtVerifyEnabled && __wx._isDgtVerifyEnabled();

  var _handleMessageIdentifier = _handleMessageFromWeixin;
  var _logIdentifier = _log;
  var _envIdentifier = _env;
  var _onfor3rdIdentifier = _onfor3rd;
  var _callIdentifier = _call;
  __initLog(__DL, "__wx define:" + _xxyy + "," + isDgtVerifyEnabled);

  function _sendMessage(msg) {
    var msgArray = []; msgArray.push(msg);
    var msgArrayString = JSON.stringify(msgArray);

    if (isDgtVerifyEnabled) {
      var arr = new Array;
      arr[0] = msgArrayString;
      arr[1] = _xxyy;
      var str = arr.join("");
      var msgSha = '';

      var shaObj = CryptoJS.SHA1(str);
      msgSha = shaObj.toString();

      var retMap = {};
      retMap[_JSON_MESSAGE] = msgArray;
      retMap[_SHA_KEY] = msgSha;
      msgArrayString = JSON.stringify(retMap);
    }
    __wx._sendMessage(msgArrayString);
  };

  function _handleMessageFromWeixin(message) {
    var curFuncIdentifier = __WeixinJSBridge._handleMessageFromWeixin;
    if (curFuncIdentifier !== _handleMessageIdentifier) {
      return '{}';
    }

    var ret;
    var msgWrap
    if (isDgtVerifyEnabled) {
      var realMessage = message[_JSON_MESSAGE];
      var shaStr = message[_SHA_KEY];
      var arr = new Array;
      arr[0] = JSON.stringify(realMessage);
      arr[1] = _xxyy;
      var str = arr.join("");
      var msgSha = '';
      var shaObj = CryptoJS.SHA1(str);
      msgSha = shaObj.toString();
      if (msgSha !== shaStr) {
        _log('_handleMessageFromWeixin , shaStr : ' + shaStr + ' , str : ' + str + ' , msgSha : ' + msgSha);
        return '{}';

      }
      msgWrap = realMessage;
    } else {
      msgWrap = message;
    }

    switch (msgWrap[_MESSAGE_TYPE]) {
      case 'callback':
        {
          if (typeof msgWrap[_CALLBACK_ID] === 'string' && typeof _callback_map[msgWrap[_CALLBACK_ID]] === 'function') {
            var ret = _callback_map[msgWrap[_CALLBACK_ID]](msgWrap['__params']);
            delete _callback_map[msgWrap[_CALLBACK_ID]]; // can only call once
            return JSON.stringify(ret);
          }
          return JSON.stringify({
            '__err_code': 'cb404'
          });
        }
        break;
      case 'event':
        {
          if (typeof msgWrap[_EVENT_ID] === 'string') {
            if (typeof _event_hook_map_for3rd[msgWrap[_EVENT_ID]] === 'function' && _isIn3rdApiList(msgWrap[_EVENT_ID])) {
              var shareEvents = ['menu:share:timeline', 'menu:share:qq', 'menu:share:weiboApp', 'menu:share:QZone', 'menu:share:appmessage', 'menu:share:email']
              if (shareEvents.indexOf(msgWrap[_EVENT_ID]) > -1) { // 判断是否分享事件，这里漏了要加上
                // 自定义分享内容，申请分享权限
                _sendMessage(JSON.stringify({
                  '__handleFromWeixin': _xxyy,
                  '__fullApiName': msgWrap['__params']['fullApiName']
                }));
              }

              var ret = _event_hook_map_for3rd[msgWrap[_EVENT_ID]](msgWrap['__params']);
              return JSON.stringify(ret);
            } else if (typeof _event_hook_map[msgWrap[_EVENT_ID]] === 'function') {
              var ret = _event_hook_map[msgWrap[_EVENT_ID]](msgWrap['__params']);
              return JSON.stringify(ret);
            }

          }
          return JSON.stringify({
            '__err_code': 'ev404'
          });
        }
        break;
    }
  };

  function _isIn3rdApiList(event) {
    var r = _runOn3rdApiList.some(function (x) {
      return x === event;
    });
    _log('_isIn3rdApiList , event : ' + event + " , result : " + r);
    return r;
  }

  function _env(key) {
    var curFuncIdentifier = __WeixinJSBridge.env;
    if (curFuncIdentifier !== _envIdentifier) {
      return '';
    }
    return _session_data[key];
  }

  function _log(fmt) {
    var curFuncIdentifier = __WeixinJSBridge.log;
    if (curFuncIdentifier !== _logIdentifier) {
      return;
    }
    var argv = [];
    for (var i = 0; i < arguments.length; i++) {
      argv.push(arguments[i]);
    };
    var fm = argv.shift();
    var msg;
    try {
      msg = vsprintf(fm, argv);
    } catch (e) {
      msg = fmt;
    }
    _call('log', {
      'msg': msg
    });
  }

  function _call(func, params, callback) {
    var curFuncIdentifier = __WeixinJSBridge.call;
    if (curFuncIdentifier !== _callIdentifier) {
      return;
    }
    if (!func || typeof func !== 'string') {
      return;
    };
    if (typeof params !== 'object') {
      params = {};
    };

    var callbackID = (_callback_count++).toString();

    if (typeof callback === 'function') {
      _callback_map[callbackID] = callback;
    };

    var msgObj = {
      'func': func,
      'params': params
    };
    msgObj[_MESSAGE_TYPE] = 'call';
    msgObj[_CALLBACK_ID] = callbackID;

    try {
      _sendMessage(JSON.stringify(msgObj));
    } catch (e) {
      __initLog(__EL, "_call error", e);
    }
  }

  function _on(event, callback) {
    if (!event || typeof event !== 'string') {
      return;
    };

    if (typeof callback !== 'function') {
      return;
    };

    _event_hook_map[event] = callback;
  }

  function _onfor3rd(event, callback) {
    var curFuncIdentifier = __WeixinJSBridge.on;
    if (curFuncIdentifier !== _onfor3rdIdentifier) {
      return;
    }
    if (!event || typeof event !== 'string') {
      return;
    }
    if (typeof callback !== 'function') {
      return;
    }
    _event_hook_map_for3rd[event] = callback;
  }

  function _emit(event, argv) {
    if (typeof _event_hook_map[event] !== 'function') {
      return;
    };

    if (_isIn3rdApiList(event)) {
      _event_hook_map_for3rd[event](argv);
    } else {
      _event_hook_map[event](argv);
    }
  }

  function _enable_old_UrlStyleImagePreviews() {
    var old_prefix = "weixin://viewimage/";
    _WXJS('a[href^="weixin://viewimage/"]').on('click', function (e) {
      var cur = '';
      var link;
      if (typeof e.target.href === 'string' && e.target.href.search(old_prefix) === 0) {
        link = e.target;
      } else {
        link = _WXJS(e.target).parents('a[href^="weixin://viewimage/"]')[0];
      }
      cur = link.href.substr(old_prefix.length);
      var allLinks = _WXJS('a[href^="weixin://viewimage/"]');
      var allUrls = [];
      for (var i = 0; i < allLinks.length; i++) {
        allUrls.push(allLinks[i].href.substr(old_prefix.length));
      };
      _call('imagePreview', {
        'urls': allUrls,
        'current': cur
      });

      e.preventDefault();
    });
  }

  function _enable_old_ReaderShareUrls() {
    var old_prefix = "weixin://readershare/";
    _WXJS('a[href^="weixin://readershare/"]').on('click', function (e) {
      e.preventDefault();

      _emit('menu:share:weibo', _session_data.shareWeiboData || {});
    });
    _WXJS('a[href^="weixin://readertimeline/"]').on('click', function (e) {
      e.preventDefault();

      _emit('menu:share:timeline', _session_data.shareTimelineData || {});
    });
  }

  function _enable_hashChangeNotify() {
    _WXJS(window).bind('hashchange', function () {
      _call('hashChange', {
        'hash': window.location.hash
      });
    });
  }

  function _setDefaultEventHandlers() {
    // set font
    _on('menu:setfont', function (argv) {
      if (typeof changefont === 'function') {
        var num = parseInt(argv.fontSize);
        _log('set font size with changefont: %s', argv.fontSize);
        changefont(num);
        return;
      }

      // fallback
      var s;
      switch (argv.fontSize) {
        case '1':
          s = '80%';
          break;
        case '2':
          s = '100%';
          break;
        case '3':
          s = '120%';
          break;
        case '4':
          s = '140%';
          break;
        default:
          return;
      }
      _log('set font size with webkitTextSizeAdjust: %s', argv.fontSize);

      // document.getElementsByTagName('body')[0].style.webkitTextSizeAdjust = s;
      // android机器上调用该方法不生效，改为回调到java层，用webview的api实现setFontSize
      _call('setFontSizeCallback', {
        "fontSize": argv.fontSize
      });
    });

    // 获取页面图片算法：
    // 在页面中找到第一个最小边大于290的图片，如果1秒内找不到，则返回空（不带图分享）。
    var getSharePreviewImage = function (cb) {

      var isCalled = false;

      var callCB = function (_img) {
        if (isCalled) {
          return;
        };
        isCalled = true;

        cb(_img);
      }

      var _allImgs = _WXJS('img');
      if (_allImgs.length == 0) {
        return callCB();
      }

      // 过滤掉重复的图片
      var _srcs = {};
      var allImgs = [];
      for (var i = 0; i < _allImgs.length; i++) {
        var _img = _allImgs[i];

        // 过滤掉不可以见的图片
        if (_WXJS(_img).css('display') == 'none' || _WXJS(_img).css('visibility') == 'hidden') {
          // _log('ivisable image !! ' + _img.src);
          continue;
        }

        if (_srcs[_img.src]) {
          // added
        } else {
          _srcs[_img.src] = 1; // mark added
          allImgs.push(_img);
        }
      };

      var results = [];

      var img;
      for (var i = 0; i < allImgs.length && i < 100; i++) {
        img = allImgs[i];

        var newImg = new Image();
        newImg.onload = function () {
          this.isLoaded = true;
          var loadedCount = 0;
          for (var j = 0; j < results.length; j++) {
            var res = results[j];
            if (!res.isLoaded) {
              break;
            }
            loadedCount++;
            if (res.width > 290 && res.height > 290) {
              callCB(res);
              break;
            }
          }
          if (loadedCount == results.length) {
            // 全部都已经加载完了，但还是没有找到。
            callCB();
          };
        }
        newImg.src = img.src;
        results.push(newImg);
      }

      setTimeout(function () {
        for (var j = 0; j < results.length; j++) {
          var res = results[j];
          if (!res.isLoaded) {
            continue;
          }
          if (res.width > 290 && res.height > 290) {
            callCB(res);
            return;
          }
        }
        callCB();
      }, 1000);
    }

    var getSharePreviewImageForRecordHistory = function (cb) {

      var isCalled = false;

      var callCB = function (_img) {
        if (isCalled) {
          return;
        };
        isCalled = true;

        cb(_img);
      }

      var _allImgs = _WXJS('img');
      if (_allImgs.length == 0) {
        return callCB();
      }

      // 过滤掉重复的图片
      var _srcs = {};
      var allImgs = [];
      for (var i = 0; i < _allImgs.length; i++) {
        var _img = _allImgs[i];

        // 过滤掉不可以见的图片
        if (_WXJS(_img).css('display') == 'none' || _WXJS(_img).css('visibility') == 'hidden') {
          // _log('ivisable image !! ' + _img.src);
          continue;
        }

        if (!_img.src.startsWith('http') && !_img.src.startsWith('https')) {
          continue;
        }

        if (_srcs[_img.src]) {
          // added
        } else {
          _srcs[_img.src] = 1; // mark added
          allImgs.push(_img);
        }
      };

      var results = [];

      var img;
      for (var i = 0; i < allImgs.length && i < 100; i++) {
        img = allImgs[i];

        var newImg = new Image();
        newImg.onload = function () {
          this.isLoaded = true;
          var loadedCount = 0;
          for (var j = 0; j < results.length; j++) {
            var res = results[j];
            if (!res.isLoaded) {
              break;
            }
            loadedCount++;
            if (res.width > 50 && res.height > 50) {
              callCB(res);
              break;
            }
          }
          if (loadedCount == results.length) {
            // 全部都已经加载完了，但还是没有找到。
            callCB();
          };
        }
        newImg.src = img.src;
        results.push(newImg);
      }

      setTimeout(function () {
        for (var j = 0; j < results.length; j++) {
          var res = results[j];
          if (!res.isLoaded) {
            continue;
          }
          if (res.width > 50 && res.height > 50) {
            callCB(res);
            return;
          }
        }
        callCB();
      }, 1000);
    }

    // share timeline
    _on('menu:share:timeline', function (argv) {
      _log('share timeline');

      var data;
      if (typeof argv.title === 'string') {
        data = argv;
        // 申请临时分享权限
        _sendMessage(JSON.stringify({
          '__handleFromWeixin': _xxyy,
          '__fullApiName': 'shareTimeline'
        }));
        _call('shareTimeline', data);
      } else {
        data = {
          // "img_url": "",
          // "img_width": "",
          // "img_height": "",
          "link": document.documentURI || _session_data.init_url,
          "desc": document.documentURI || _session_data.init_url,
          "title": document.title
        };

        var shareFunc = function (_img) {
          if (_img) {
            data['img_url'] = _img.src;
            data['img_width'] = _img.width;
            data['img_height'] = _img.height;
          }

          // 申请临时分享权限
          _sendMessage(JSON.stringify({
            '__handleFromWeixin': _xxyy,
            '__fullApiName': 'shareTimeline'
          }));
          _call('shareTimeline', data);
        };

        getSharePreviewImage(shareFunc);
      }
    });

    // share qq
    _on('menu:share:qq', function (argv) {
      _log('share QQ');

      var data;
      if (typeof argv.title === 'string') {
        data = argv;
        // 申请临时分享权限
        _sendMessage(JSON.stringify({
          '__handleFromWeixin': _xxyy,
          '__fullApiName': 'shareQQ'
        }));
        _call('shareQQ', data);
      } else {
        data = {
          "link": document.documentURI || _session_data.init_url,
          "desc": document.documentURI || _session_data.init_url,
          "title": document.title
        };

        var shareFunc = function (_img) {
          if (_img) {
            data['img_url'] = _img.src;
            data['img_width'] = _img.width;
            data['img_height'] = _img.height;
          }

          // 申请临时分享权限
          _sendMessage(JSON.stringify({
            '__handleFromWeixin': _xxyy,
            '__fullApiName': 'shareQQ'
          }));
          _call('shareQQ', data);
        };

        getSharePreviewImage(shareFunc);
      };
    });

    // share weiboApp
    _on('menu:share:weiboApp', function (argv) {
      _log('share weibo');

      var data;
      if (typeof argv.content === 'string') {
        data = argv;
      } else {
        data = {
          "link": document.documentURI || _session_data.short_url || _session_data.init_url,
          "title": document.title,
          "desc": document.title + ' ' + (document.documentURI || _session_data.short_url || _session_data.init_url)
        };

        var shareFunc = function (_img) {
          if (_img) {
            data['img_url'] = _img.src;
            data['img_width'] = _img.width;
            data['img_height'] = _img.height;
          }

          // 申请临时分享权限
          _sendMessage(JSON.stringify({
            '__handleFromWeixin': _xxyy,
            '__fullApiName': 'shareWeiboApp'
          }));
          _call('shareWeiboApp', data);
        };

        getSharePreviewImage(shareFunc);
      }
    });

    // share qzone
    _on('menu:share:QZone', function (argv) {
      _log('share QZone');

      var data;
      if (typeof argv.title === 'string') {
        data = argv;
        // 申请临时分享权限
        _sendMessage(JSON.stringify({
          '__handleFromWeixin': _xxyy,
          '__fullApiName': 'shareQZone'
        }));
        _call('shareQZone', data);
      } else {
        data = {
          "link": document.documentURI || _session_data.init_url,
          "desc": document.documentURI || _session_data.init_url,
          "title": document.title
        };

        var shareFunc = function (_img) {
          if (_img) {
            data['img_url'] = _img.src;
            data['img_width'] = _img.width;
            data['img_height'] = _img.height;
          }

          // 申请临时分享权限
          _sendMessage(JSON.stringify({
            '__handleFromWeixin': _xxyy,
            '__fullApiName': 'shareQZone'
          }));
          _call('shareQZone', data);
        };

        getSharePreviewImage(shareFunc);
      };
    });

    // share with app message
    _on('menu:share:appmessage', function (argv) {
      _log('share appmessage');

      var data;
      if (typeof argv.title === 'string') {
        data = argv;
        // 申请临时分享权限
        _sendMessage(JSON.stringify({
          '__handleFromWeixin': _xxyy,
          '__fullApiName': 'sendAppMessage'
        }));
        _call('sendAppMessage', data);
      } else {
        data = {
          // "appid" : ""
          // "img_url": "",
          // "img_width": "",
          // "img_height": "",
          "link": document.documentURI || _session_data.init_url,
          "desc": document.documentURI || _session_data.init_url,
          "title": document.title
        };

        var shareFunc = function (_img) {
          if (_img) {
            data['img_url'] = _img.src;
            data['img_width'] = _img.width;
            data['img_height'] = _img.height;
          }

          // 申请临时分享权限
          _sendMessage(JSON.stringify({
            '__handleFromWeixin': _xxyy,
            '__fullApiName': 'sendAppMessage'
          }));
          _call('sendAppMessage', data);
        };

        getSharePreviewImage(shareFunc);
      }
    });

    // send mail
    _on('menu:share:email', function (argv) {
      _log('send email');

      var data;
      if (typeof argv.title === 'string') {
        data = argv;
        // 申请临时权限
        _sendMessage(JSON.stringify({
          '__handleFromWeixin': _xxyy,
          '__fullApiName': 'sendEmail'
        }));
        _call('sendEmail', data);
      } else {
        data = {
          "content": document.documentURI || _session_data.init_url,
          "title": document.title
        };
        // 申请临时权限
        _sendMessage(JSON.stringify({
          '__handleFromWeixin': _xxyy,
          '__fullApiName': 'sendEmail'
        }));
        _call('sendEmail', data);
      }
    });

    // the first event
    _on('sys:init', function (ses) {
      // 避免由于Java层多次发起init请求，造成网页端多次收到WeixinJSBridgeReady事件
      if (window.WeixinJSBridge._hasInit) {
        _log('hasInit, no need to init again');
        return;
      }

      window.WeixinJSBridge._hasInit = true;

      // bridge ready
      var readyEvent;
      try {
        readyEvent = new Event('WeixinJSBridgeReady');
      } catch (e) {
        readyEvent = document.createEvent('Event');
        readyEvent.initEvent('WeixinJSBridgeReady');
      }
      document.dispatchEvent(readyEvent);
    });

    _on('sys:bridged', function (ses) {
      // 避免由于Java层多次发起init请求，造成网页端多次收到WeixinJSBridgeReady事件
      if (window.WeixinJSBridge._hasInit) {
        return;
      }

      // _log(_env('version'));
      // _log(_env('language'));
      // _log(_env('timezone'));
      // _log(_env('cpu'));
      // _log(_env('model'));
      if (_env('webview_type') === '1') {
        _emit('menu:setfont', {
          'fontSize': _env('init_font_size')
        });
      }

      try {
        _enable_old_UrlStyleImagePreviews();
        _enable_old_ReaderShareUrls();
        _enable_hashChangeNotify();
      } catch (e) {
        _log('error %s', e);
      }

    });

    _on('sys:attach_runOn3rd_apis', function (ses) {
      if (typeof ses[_RUN_ON_3RD_APIS] === 'object') {
        _runOn3rdApiList = ses[_RUN_ON_3RD_APIS];
        _log('_runOn3rdApiList : ' + _runOn3rdApiList);
        //alert('ses : ' + ses);
        ///alert('apis : ' + _runOn3rdApiList);
      }
    });

    _on('sys:get_all_hosts', function (ses) {
      var allHosts = getDomainList();
      //alert('jingle == ' + allHosts);
      //_setResultIframe.src = 'weixin://private/setresult/' + result;
      _log('sys:get_all_hosts : ' + allHosts);
      __wx._getAllHosts(allHosts);
    });

    _on('sys:get_html_content', function (ses) {
      var htmlContent = getHtmlContent();
      //alert('jingle == ' + allHosts);
      //_setResultIframe.src = 'weixin://private/setresult/' + result;
      _log('sys:get_html_content : ' + htmlContent);
      __wx._getHtmlContent(htmlContent);
    });

    _on('sys:record', function (ses) {
      __initLog(__IL, 'wx sys:record');
      _log('sys:record');
      data = {
        'title': document.title,
        'source': window.location.hostname
      }
      var shareFunc = function (_img) {
        if (_img) {
          data['img_url'] = _img.src;
          data['img_width'] = _img.width;
          data['img_height'] = _img.height;
        }
        _call('recordHistory', data);
      };
      getSharePreviewImageForRecordHistory(shareFunc);

    });
  }

  var domain_list = [];

  function getDomain(els, attr) {
    if (!els || els.length <= 0)
      return;

    var el, attrv, matchs;
    var reg = /http(s)?\:\/\/([^\/\?]*)(\?|\/)?/;
    for (var i = 0, len = els.length; i < len; ++i) {
      el = els[i];
      if (!el) {
        continue;
      }
      attrv = el.getAttribute(attr);
      if (!!attrv) {
        matchs = attrv.match(reg);
        if (!!matchs && !!matchs[2]) {
          //domain_list[matchs[2]] = true;
          domain_list.push(matchs[2]);
        }
      }
    }
  }

  function getDomainList() {
    domain_list = [];
    //link href
    //a href
    getDomain(document.getElementsByTagName("a"), 'href');
    getDomain(document.getElementsByTagName("link"), 'href');

    //iframe src
    //script src
    //img src
    getDomain(document.getElementsByTagName("iframe"), 'src');
    getDomain(document.getElementsByTagName("script"), 'src');
    getDomain(document.getElementsByTagName("img"), 'src');

    // var ret = [];

    // for (var k in domain_list){
    //      if (domain_list.hasOwnProperty(k)){
    //           ret.push(k);
    //      }
    // }
    // domain_list = [];
    return domain_list.join(",");
  }

  function getHtmlContent() {
    return document.documentElement.innerHTML;
  }

  function _test_start() {
    _emit('sys:init', {});
    _emit('sys:bridged', {});
  }
  __initLog(__DL, "__wx define functions");

  var __WeixinJSBridge = {
    // public
    invoke: _call,
    call: _call,
    on: _onfor3rd,
    env: _env,
    log: _log,
    // private
    _hasInit: false,
    _createdByScriptTag: (document.currentScript !== 'undefined')
  };

  try {
    Object.defineProperty(__WeixinJSBridge, '_handleMessageFromWeixin', {
      value: _handleMessageFromWeixin,
      writable: false,
      configurable: false
    });
  } catch (e) {
    __initLog(__EL, "define _handleMessageFromWeixin", e)
    return "WeixinJSBridge init err:" + e.message
  }




  try {
    Object.defineProperty(window, 'WeixinJSBridge', {
      value: __WeixinJSBridge,
      writable: false,
      configurable: false
    });
  } catch (e) {
    __initLog(__EL, "define WeixinJSBridge", e)
    return "WeixinJSBridge init err:" + e.message; // 如果页面已经存在 WeixinJSBridge，是恶意页面，就直接 return
  }
  __initLog(__DL, "__wx bind");

  _setDefaultEventHandlers();

  __wx._ready(true);

  __initLog(__IL, 'WeixinJSBridge exec time', (Date.now()-execStartTime));
  return "WeixinJSBridge init succ"
  } catch (e) {
    var logs = ""
    __initLogArr.forEach(function(args) {
        logs += Array.prototype.join.call(args, ",") + ","
    })
    return "WeixinJSBridge init err:" + e.message + "\n" + e.stack + logs
  }
})();