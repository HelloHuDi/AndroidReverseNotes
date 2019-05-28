;NativeGlobal.setTimeout = this.setTimeout;
NativeGlobal.clearTimeout = this.clearTimeout;
NativeGlobal.setInterval = this.setInterval;
NativeGlobal.clearInterval = this.clearInterval;
(function(){
let OffscreenCanvas = NativeGlobal.OffscreenCanvas;
NativeGlobal.OffscreenCanvas = function(width, height) {
return new OffscreenCanvas(width, height, {forbiddenContextTypes:['2d']});
}
})();
