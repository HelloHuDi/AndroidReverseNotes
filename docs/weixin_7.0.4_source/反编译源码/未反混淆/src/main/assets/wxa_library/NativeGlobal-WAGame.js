;NativeGlobal.setTimeout = this.setTimeout;
NativeGlobal.clearTimeout = this.clearTimeout;
NativeGlobal.setInterval = this.setInterval;
NativeGlobal.clearInterval = this.clearInterval;
this.requestAnimationFrame = NativeGlobal.requestAnimationFrame;
this.cancelAnimationFrame = NativeGlobal.cancelAnimationFrame;
NativeGlobal.__wxConfig = __wxConfig;
NativeGlobal.BindingObject = NativeGlobal.Watcher;
(function(){

let firstTime = true;
let getSystemInfo = NativeGlobal.getSystemInfo;
let ScreenCanvas = NativeGlobal.ScreenCanvas;
let OffscreenCanvas = NativeGlobal.OffscreenCanvas;
let SharedCanvas = NativeGlobal.SharedCanvas;
//NativeGlobal.Canvas=function(){
//let info = getSystemInfo();
//if(firstTime){firstTime = false;
//return new ScreenCanvas(info.screenWidth, info.screenHeight);
//}else{
//return new OffscreenCanvas(info.screenWidth, info.screenHeight);
//}}
//NativeGlobal.SharedCanvas=function(){
//let info = getSystemInfo();
//return new SharedCanvas(info.screenWidth, info.screenHeight);
//}
NativeGlobal.Canvas = NativeGlobal.AutoScreenCanvas;

let onbindingobjectdestruct;
let EventHandler = NativeGlobal.EventHandler;
Object.defineProperty(NativeGlobal.EventHandler,'onbindingobjectdestruct', {
get:()=>{ return onbindingobjectdestruct },
set:(l)=>{
if (!!onbindingobjectdestruct) {
EventHandler.removeEventListener('watcherdestruct', onbindingobjectdestruct);
}
if (!!l) {
EventHandler.addEventListener('watcherdestruct', l);
onbindingobjectdestruct = l;
}
}});

let performanceNow = NativeGlobal.performanceNow;
NativeGlobal.performanceNow = function() {
return performanceNow() * 1000;
}
})();
