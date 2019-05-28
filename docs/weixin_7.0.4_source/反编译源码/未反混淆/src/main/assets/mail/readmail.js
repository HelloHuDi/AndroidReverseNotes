
(function() {

var _pageScale = 1;
var _titlePaddingHeight = 0;

var _oUrlSearchs = location.search.substr(1).split("&"),
  _oUrlParams = {};
for (var i = 0, l = _oUrlSearchs.length, _oUrlParam; i < l; i++) {
  _oUrlParam = _oUrlSearchs[i].split("=");
  _oUrlParams[_oUrlParam[0]] = _oUrlParam[1];
}



var _nRestoreBodyScrollWidth = parseFloat(_oUrlParams["contentWidth"]) || 0,
_nPageWidth = parseInt(_oUrlParams["pageWidth"]) || 360,
               _nPageMargin = 0,
               _bIsFixTable = false,
               _bIsOnLoad = false;



function _setImgMaxHeightBaseMaxWidth(_aoImg) {

  var _nW, _nH;
  if ((_nW = _aoImg.naturalWidth) && (_nH = _aoImg.naturalHeight)) {

    _aoImg.style.maxHeight = (parseInt(_aoImg.width) * _nH / _nW)  + "px";
    _aoImg.getAttribute("layoutResized", true);
  }
}



function _setViewport(_anScale, _anWidth) {
  console.log("_setViewport:" + _anScale + "," + _anWidth);
  dom("#viewport").content = "initial-scale=" + _anScale + ",width=" + (_anWidth + 12) + 
    " , user-scalable=yes, maximum-scale=2.0" + ", minimum-scale=" + _anScale;
}


function _fixImgScale() {
  replaceClass(document.body, "body_beforescale", "body_scale");
}

function _fixPageScale() {

  var _nBodyScrollWidth = document.body.scrollWidth;
  console.log("_fixPageScale bw=" + _nBodyScrollWidth + " pw=" + _nPageWidth + " rbsw=" + _nRestoreBodyScrollWidth);
  if (_nBodyScrollWidth > (Math.max(_nPageWidth, _nRestoreBodyScrollWidth) + 24)) {

    _pageScale = _nPageWidth / ((_nRestoreBodyScrollWidth = _nBodyScrollWidth) + 24);
    _setViewport(_pageScale, _nRestoreBodyScrollWidth);
    return true;
  }
  return false;
}

function _resetTableAreaHeight(_aoDomArea) {
  var _nScale = parseFloat(attr(_aoDomArea, "nScale"));
  if (!isNaN(_nScale)) {
    _aoDomArea.style.cssText = "height:" +
      parseInt(_getTableFromTableArea(_aoDomArea).scrollHeight * _nScale + 
          (parseInt(_aoDomArea, "nOriHeightDelta") || 0)) + 
      "px!important;overflow:visible;"; 
    return true;
  }
  return false;
}

function _fixTableScale(_aoDomArea, _aoDomTable, _anTableWidth) {

  var _nScale = _aoDomArea.clientWidth / _anTableWidth;

  console.log("fixTableScale,table client width:" + _aoDomArea.clientWidth + ",table width:" + _anTableWidth);

  if (_nScale < 1 && parseFloat(attr(_aoDomArea, "nScale")) != _nScale) {

    var _nTranslate = (1 - _nScale) * 100 / (2 * _nScale);
    _aoDomTable.style.webkitTransform =
      "scale(" + _nScale + ") translate(-" + _nTranslate + "%,-" + _nTranslate + "%)";
    _aoDomArea.setAttribute("nScale", _nScale);
    _resetTableAreaHeight(_aoDomArea);
    return true;
  }

  return false;
}


//添加缩放事件
function _addScaleEvent() {
  //使用轮询方案加速触发时机
  var _nOrientationChangeTimer = 0,
      _nTimerStartTime = 2000000000000,
      _nBodyWidth = document.body.clientWidth;

  function _timerFunc() {
    //运行时间过长，就不再探测，避免死循环
    if (now() - _nTimerStartTime > 1000) {
      console.log("resetContentHeight _addScaleEvent timeout");
      _clearInterval();
      return true;
    }

    var _nClientWidth = document.body.clientWidth;
    console.log("resetContentHeight _addScaleEvent:" + _nClientWidth + " " + _nBodyWidth);

    if (_nClientWidth != _nBodyWidth) {
      _nBodyWidth = _nClientWidth;
      _clearInterval();
      _refixTablesScale();
      _resetContentHeight();
      return true;
    }

    return false;
  }

  function _clearInterval() {
    if (_nOrientationChangeTimer) {
      clearInterval(_nOrientationChangeTimer);
      _nOrientationChangeTimer = 0;
    }
  }

  function _detectOrientationChange() {
    if (!_timerFunc()) {
      _clearInterval();
      _nTimerStartTime = now();
      _nOrientationChangeTimer = setInterval(_timerFunc, 10);
    }
  }

  window.addEventListener("orientationchange", _detectOrientationChange);
}



function _canRemoveTablesWidth(_aoDomContainer) {
  var _nTrsLen = _aoDomContainer.getElementsByTagName("tr").length, 
      _nTdsLen = _aoDomContainer.getElementsByTagName("td").length, 
      _nThsLen = _aoDomContainer.getElementsByTagName("th").length,
      _bIsOk = _nTrsLen > 0 && (_nTdsLen > 0 || _nThsLen > 0) &&
        (_nThsLen + _nTdsLen) / _nTrsLen == 1 &&
        _aoDomContainer.getElementsByTagName("table").length == 0;
  return _bIsOk;
}

function _getTableFromTableArea(_aoTableAreaDom) {
  var _oTable = dom("table", _aoTableAreaDom);
  !_oTable && console.err("table not found in qmTableArea!");
  return _oTable || _aoTableAreaDom;
}

function _fixTableScaleReady(_aoDomArea) {

  var _oDomTable = _getTableFromTableArea(_aoDomArea),
      _nScrollWidth;

  addClass(_aoDomArea, "qmFixedTableArea" + 
      (_canRemoveTablesWidth(_aoDomArea) ? " qmFixedTableWidthForAll" : ""));
  _aoDomArea.setAttribute("nOriHeightDelta", _aoDomArea.scrollHeight - _oDomTable.scrollHeight);
  _aoDomArea.setAttribute("nOriWidth", _nScrollWidth = _oDomTable.scrollWidth);
  _fixTableScale(_aoDomArea, _oDomTable, _nScrollWidth);

}


function _fixTablesScale(_aoDomAreas) {

  console.log("fixTableScale");
  for (var i = 0, l = _aoDomAreas.length; i < l; i++) {
    _fixTableScaleReady(_aoDomAreas[i]);
  }

}

function _refixTablesScale() {

  console.log("refixTableScale");
  var _oDomAreas = doms(".qmTableArea");
  for (var i = 0, l = _oDomAreas.length, _nTableWidth, _oDomArea, _oDomTable; i < l; i++) {
    if (!isNaN(_nTableWidth = parseInt(attr(_oDomArea = _oDomAreas[i], "nOriWidth")))) {
      if (!_fixTableScale(_oDomArea, _oDomTable = _getTableFromTableArea(_oDomArea), _nTableWidth) && 
          (parseFloat(attr(_aoDomArea, "nScale")) || 10) < 1) {
            _oDomTable.style.webkitTransform = "";
            _oDomArea.setAttribute("nScale", 1);
            _resetTableAreaHeight(_oDomArea);
          }
    }
  }
}

function _resetContentHeight(){
  console.log("height:" + (document.body.clientHeight + position(document.body).top));
  _updateTitleBarHeight(_titlePaddingHeight,_pageScale);
}



function _setLoadsImagesAutomatically() {
  console.log("start load img");
}

function _getImgSelectedWidth(_aoImg) {
  var _nWidth;
  if (_nWidth = _aoImg.oriWidth) {
    return _nWidth;
  }
  var _sWidth = _aoImg.style.width || attr(_aoImg, "width");
  if (_sWidth && _sWidth.indexOf("%") == -1) {
    return parseInt(_sWidth);
  }
  return null;
}


function _getImgSelectedHeight(_aoImg) {
  var _nHeight;
  if (_nHeight = _aoImg.oriWidth) {
    return _nHeight;
  }
  var _sHeight = _aoImg.style.height || attr(_aoImg, "height");
  if (_sHeight && _sHeight.indexOf("%") == -1) {
    return parseInt(_sHeight);
  }
  return null;
}

function _reCalcImgHeight(_aoImg, _abIsAbsoluteValue) {

  var _nWidth, _nHeight, _nImgWidth;
  if ((_nWidth = _getImgSelectedWidth(_aoImg)) &&
      (_nHeight = _getImgSelectedHeight(_aoImg)) &&
      _nHeight > 30 && 
      _nWidth > (_nImgWidth = _aoImg.width)) {
        if (_abIsAbsoluteValue) {
          _aoImg.oriWidth = _nWidth;
          _aoImg.oriHeight = _nHeight;
          _aoImg.style.height = (_nHeight * _nImgWidth / _nWidth) + "px";
        }
        else {
          _aoImg.style.cssText = "height:auto!important;";
        }
      }
      console.log("re calculate img height," + _nWidth + "," + _nHeight + "," + _nImgWidth);
}


function _startLoadImages(_aoImgs) {

  for (var i = 0, _nLen = _aoImgs.length; i < _nLen; i++) {
      removeClass(_aoImgs[i], "qqmail_img_spacer");
      _aoImgs[i].onload = _imgOnLoad;
      _reCalcImgHeight(_aoImgs[i],true);
  }
}

function _initImages(_aoImgs) {
  var _nLen = _aoImgs.length;
  var _nWidth,_nHeight;

  for (var i = 0;i < _nLen; i++) {
    _nWidth = _aoImgs[i].width;
    _nHeight = _aoImgs[i].height;
    if ((_nWidth > 50 && _nHeight > 50) || (_nWidth == 0 && _nHeight == 0)) {
      addClass(_aoImgs[i], "qqmail_img_spacer");
    }

    _reCalcImgHeight(_aoImgs[i], true);
  }
}



function _imgOnLoad() {

  if (!_imgOnLoad._nTimer) {
    _imgOnLoad._nTimer = setTimeout(function() {
      console.log("img onload process");
      _imgOnLoad._nTimer = 0;

      if (_bIsFixTable) {

        for (var _oNode = this.parentNode, _nOriWidth; _oNode && _oNode.tagName != "BODY"; _oNode = _oNode.parentNode) {

          if (!isNaN(_nOriWidth = parseInt(attr(_oNode, "nOriWidth")))) {
            var _oDomTable = _getTableFromTableArea(_oNode),
      _nScrollWidth = _oDomTable.scrollWidth;

    if (_nOriWidth != _nScrollWidth) {
      _oNode.setAttribute("nOriWidth", _nScrollWidth);
      _fixTableScale(_oNode, _oDomTable, _nScrollWidth);
    }

    else {
      _resetTableAreaHeight(_oNode);
    }
    break;
          }
        }
      }
      else{
         _fixPageScale();
      }

      console.log("_imgOnLoad resetContentHeight");
      setTimeout(_resetContentHeight,400);
    }, 1000);
  }
}


function _showImages() {
    _setLoadsImagesAutomatically();
}




function _fixScale() {

    var _oDomContent = document.body,
      _oDomImgs = doms("img", _oDomContent),
      _sSaveModifyContent;

      var _oDomAreas = doms(".qmTableArea", _oDomContent),
          _nDomAreasLen = _oDomAreas.length,
          _oDomFixAreas = [],
          _nTableImgs = 0;

      for (var i = 0, _oDomArea; i < _nDomAreasLen; i++) {
        if (getComputedStyle(_oDomArea = _oDomAreas[i])["overflow"] != "visible") {
          _oDomFixAreas.push(_oDomArea);
          _nTableImgs += doms("img", _oDomArea).length;
        }
      }

      if ( _nTableImgs * 2 > _oDomImgs.length || _nDomAreasLen == 0) {
        addClass(_oDomContent, "qmNoTableScale");
        console.log("no table to scale");
      }
      else {
        _bIsFixTable = true;
        _fixTablesScale(_oDomFixAreas);
      }

      _fixPageScale();
      _fixImgScale();
      _initImages(_oDomImgs);
      _showImages();
      _startLoadImages(_oDomImgs);
      _addScaleEvent();
  }


function _reFormatHtml(){

   var _oDomContent = document.body,
       _oDomTables = doms("table", _oDomContent),
       _nDomTablesLen = _oDomTables.length;

   console.log("reFormat html," + _nDomTablesLen);
   var _nNewTable,_tableParent;

   for(var i = 0,_oDomTable; i < _nDomTablesLen; i++){
      _oDomTable = _oDomTables[i];
      _tableParent = _oDomTable.parentNode;
      _nNewTable = document.createElement("div");
       _nNewTable.className="qmTableArea";
      _tableParent.removeChild(_oDomTable);
      _tableParent.appendChild(_nNewTable);
      _nNewTable.appendChild(_oDomTable);
   }

}

function _startFixScale(){
    console.log("start fix scale");
    _reFormatHtml();
    _fixScale();
}

window.reflowAndRepaint = function() {
  document.body.style.overflow = "hidden";
  document.body.offsetHeight;
  document.body.style.overflow = "auto";
};

window._updateTitleBarHeight = function(_aHeight){
  console.log("set title bar height:" + _aHeight);
  var _titlePadding = document.createElement("p");
  _titlePaddingHeight = _aHeight;
  _titlePadding.style.height = _aHeight + "px";
  _titlePadding.style.margin = "15px";
  _titlePadding.className = ".qmTitlePadding";
  if(document.body.firstChild.className == ".qmTitlePadding"){
    document.body.removeChild(document.body.firstChild);
  }
  document.getElementsByTagName('html')[0].style = "margin-top:0px";
  document.body.insertBefore(_titlePadding,document.body.firstChild);
};

window._updateBottomBarHeight=function(_aHeight){
  console.log("set bottom bar height:" + _aHeight);
  var _bottomPadding = document.createElement("p");
  _bottomPadding.style.height = _aHeight + "px";
  _bottomPadding.className = ".qmBottomPadding";
  if(document.body.lastChild.className == ".qmBottomPadding"){
      document.body.removeChild(document.body.lastChild);
  }
  document.body.appendChild(_bottomPadding);
};

_startFixScale();

window.addEventListener("load", function() {
  _bIsOnLoad = true;
}, false);


})();


