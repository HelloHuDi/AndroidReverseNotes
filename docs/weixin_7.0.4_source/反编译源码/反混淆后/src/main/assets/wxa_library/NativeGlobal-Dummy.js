;NativeGlobal = typeof NativeGlobal === 'object' ? NativeGlobal : {};
NativeGlobal.OffscreenCanvas = function(){
let dummy = {};
dummy.destroy = function(){};
dummy.getContext = function(){};
return dummy;
};
NativeGlobal.Image = function() {
let dummy = {};
dummy.destroy = function(){};
dummy.addEventListener() = function(){};
dummy.removeEventListener() = function(){};
return dummy;
}