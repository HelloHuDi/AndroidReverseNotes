var window = {'__wcc_version__':'', '__wcc_version_info__':{}, 'screen': {'width':%f}}

var navigator = {'userAgent': 'Android'}

var Element = {
    createNew: function(){
        var element = {}
        element.appendChild = function(child) {

        }
        element.type = ''
        element.createElement = function(ele) {

            return element
        }

        element.setAttribute = function(wxssPath, infoPath) {


        }

        element.styleSheet = {cssText: ''}
        element.childNodes = {}

        return element
    }

}


var document = {}
document.getElementsByTagName = function(tag) {
    var eles = new Array()

    eles[0] = Element.createNew()
    return eles
}

document.createElement = function(ele) {

    return Element.createNew()
}


document.createTextNode = function(n) {

    return Element.createNew()
}

document.dispatchEvent = function() {

}


function CustomEvent(name, obj) {

}

//var console = {}
//
//console.warn = function(text) {
//
//}


// exports.document = document
// exports.window = window
// exports.navigator = navigator

