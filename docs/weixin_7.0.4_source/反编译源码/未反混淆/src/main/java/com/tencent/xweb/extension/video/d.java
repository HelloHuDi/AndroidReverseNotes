package com.tencent.xweb.extension.video;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.util.Base64;
import android.view.Display;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.xweb.WebView;
import com.tencent.xweb.util.f;
import com.tencent.xweb.xwalk.a.c;
import com.tencent.xweb.xwalk.a.e;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Timer;
import java.util.TimerTask;
import org.xwalk.core.Log;
import org.xwalk.core.ReflectMethod;
import org.xwalk.core.XWalkEnvironment;

public final class d implements OnGestureListener, OnScaleGestureListener, b {
    private ViewGroup ANC;
    SurfaceView AND;
    private View ANE;
    ViewGroup ANF;
    VideoStatusLayout ANG;
    ProgressBar ANH;
    TextView ANI;
    TextView ANJ;
    ClickableFrameLayout ANK;
    LinearLayout ANL;
    ImageView ANM;
    ImageView ANN;
    ImageView ANO;
    c ANP;
    private CustomViewCallback ANQ;
    ScaleGestureDetector ANR;
    private boolean ANS;
    private long ANT;
    private double ANU;
    private double ANV;
    private final int ANW = 0;
    private final int ANX = 1;
    private final int ANY = 2;
    private final int ANZ = 3;
    private int AOa = -3;
    private int AOb = 0;
    private double AOc = 0.0d;
    private float AOd = 0.0f;
    private float AOe = 0.0f;
    private a AOf;
    String AOg;
    private Timer AOh;
    private boolean AOi;
    private int AOj = 0;
    private double AOk;
    private int AOl = 200;
    private Drawable AOm;
    private Drawable AOn;
    private boolean AOo;
    private boolean AOp;
    private boolean AOq = false;
    private int AOr;
    GestureDetector Mh;
    private Window Ti;
    private LayoutParams auN;
    private AudioManager euK;
    private int hiG;
    private double idN;
    Activity mActivity;
    private float mBrightness = 1.0f;
    private int mMode = 0;
    FrameLayout odV;
    WebView zxW;

    private Activity dUp() {
        AppMethodBeat.i(84596);
        Activity activity;
        if (this.mActivity != null) {
            activity = this.mActivity;
            AppMethodBeat.o(84596);
            return activity;
        }
        Context context = this.zxW.getContext();
        while (!(context instanceof Activity)) {
            if (!(context instanceof ContextWrapper)) {
                activity = null;
                break;
            }
            Context baseContext = ((ContextWrapper) context).getBaseContext();
            if (baseContext == context) {
                activity = null;
                break;
            }
            context = baseContext;
        }
        activity = (Activity) context;
        if (activity != null) {
            this.mActivity = activity;
        } else {
            Log.e("XWebNativeInterface", "royle:tryGetActivity but no Activity");
        }
        AppMethodBeat.o(84596);
        return activity;
    }

    public final void dh(Object obj) {
        AppMethodBeat.i(84597);
        new ReflectMethod(obj, "addJavascriptInterface", Object.class, String.class).invoke(this, "xwebToNative");
        AppMethodBeat.o(84597);
    }

    public final void am(boolean z, boolean z2) {
        AppMethodBeat.i(84598);
        if (!(this.zxW == null || !z2 || this.AOg == null)) {
            Log.i("XWebNativeInterface", "evaluteJavascript:".concat(String.valueOf(z)));
            String str = this.AOg;
            if (z) {
                str = "window.addEventListener('DOMContentLoaded', function() {" + this.AOg + "});this.xwebReturn = function (){return \"1\";};this.xwebReturn()";
            }
            this.zxW.evaluateJavascript(str, new ValueCallback<String>() {
                public final /* synthetic */ void onReceiveValue(Object obj) {
                    AppMethodBeat.i(84592);
                    ((String) obj).equals("1");
                    AppMethodBeat.o(84592);
                }
            });
        }
        AppMethodBeat.o(84598);
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x00e5 A:{SYNTHETIC, Splitter:B:56:0x00e5} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ea A:{Catch:{ Exception -> 0x010b }} */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00ef A:{Catch:{ Exception -> 0x010b }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007a A:{SYNTHETIC, Splitter:B:26:0x007a} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007f A:{Catch:{ Exception -> 0x00dd }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0084 A:{Catch:{ Exception -> 0x00dd }} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00e5 A:{SYNTHETIC, Splitter:B:56:0x00e5} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ea A:{Catch:{ Exception -> 0x010b }} */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00ef A:{Catch:{ Exception -> 0x010b }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String dUq() {
        int i;
        InputStream inputStream;
        String str;
        IOException e;
        Object obj;
        Throwable th;
        String str2 = null;
        AppMethodBeat.i(84599);
        c avu = e.avu(XWalkEnvironment.XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO);
        Object inputStream2;
        if (avu == null || avu.ASG == -1) {
            i = -1;
            inputStream2 = str2;
        } else {
            int i2 = avu.ASG;
            File file = new File(avu.aM(avu.ASG, false));
            if (file.isFile() && file.exists()) {
                try {
                    InputStream fileInputStream = new FileInputStream(file);
                    i = i2;
                    inputStream2 = fileInputStream;
                } catch (FileNotFoundException e2) {
                    Log.e("XWebNativeInterface", "initJs open jsFile error:" + e2.getMessage());
                    i = i2;
                    inputStream2 = str2;
                }
            } else {
                avu.SD(-1);
                i = i2;
                inputStream2 = str2;
            }
        }
        if (inputStream2 != null) {
            InputStreamReader inputStreamReader;
            BufferedReader obj2;
            try {
                inputStreamReader = new InputStreamReader(inputStream2, "UTF-8");
                try {
                    obj2 = new BufferedReader(inputStreamReader);
                    try {
                        StringBuffer stringBuffer = new StringBuffer("");
                        while (true) {
                            String readLine = obj2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(readLine);
                            stringBuffer.append(IOUtils.LINE_SEPARATOR_UNIX);
                        }
                        str2 = stringBuffer.toString();
                        try {
                            inputStreamReader.close();
                            obj2.close();
                            if (inputStream2 != null) {
                                inputStream2.close();
                            }
                            str = str2;
                        } catch (Exception e3) {
                            str = str2;
                        }
                    } catch (IOException e4) {
                        e = e4;
                    }
                } catch (IOException e5) {
                    e = e5;
                    obj2 = str2;
                    try {
                        Log.e("XWebNativeInterface", "initJs open jsFile error" + e.getMessage());
                        if (inputStreamReader != null) {
                            try {
                                inputStreamReader.close();
                            } catch (Exception e6) {
                                str = str2;
                            }
                        }
                        if (obj2 != null) {
                            obj2.close();
                        }
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        str = str2;
                        if (str != null) {
                        }
                        Log.i("XWebNativeInterface", "use video js default ");
                        str = "this.xwebVideoBridge||(this.xwebVideoBridge=function(b,c){function d(a){a=a.target;var c=v(a);try{b.xwebToNative.onVideoTimeUpdate(a.currentTime,a.duration,c)}catch(t){}try{b.xwebToNative.onVideoSizeUpdate(a.videoWidth,a.videoHeight)}catch(t){}}function k(a){try{b.xwebToNative.onVideoPlay()}catch(e){}}function g(a){try{b.xwebToNative.onVideoPause()}catch(e){}}function f(a){try{b.xwebToNative.onVideoPlaying()}catch(e){}}function l(a){try{b.xwebToNative.onVideoWaiting()}catch(e){}}function n(a){try{b.xwebToNative.onVideoSeeking()}catch(e){}}\nfunction m(a){try{b.xwebToNative.onVideoSeeked()}catch(e){}}function v(a){for(var b=[],c=0;c<a.buffered.length;c++)b.push(a.buffered.start(c)),b.push(a.buffered.end(c));return b}var q,u,a=null,p=!0,r=!1;xwebVideoBridge.xwebToJS_Video_ExitFullscreen=function(){c&&c.webkitExitFullscreen();return\"1\"};xwebVideoBridge.xwebToJS_Video_Play=function(){a&&(a.paused?a.play():a.pause());return\"1\"};xwebVideoBridge.xwebToJS_Video_Seek=function(b){a&&(a.currentTime=b);return\"1\"};xwebVideoBridge.xwebToNative_Special_Video_EnterFullscreen=\nfunction(a){try{if(b.xwebToNative.onSpecialVideoEnterFullscreen)b.xwebToNative.onSpecialVideoEnterFullscreen(a)}catch(e){}};xwebVideoBridge.xwebToNative_Special_Video_Hook=function(a){try{b.xwebToNative.onSpecialVideoHook&&!r&&(b.xwebToNative.onSpecialVideoHook(a),r=!0)}catch(e){}};xwebVideoBridge.hookFullscreen=function(){xwebVideoBridge.xweb_webkitfullscreenchange||(xwebVideoBridge.xweb_webkitfullscreenchange=function(h){h=c;if(c.webkitFullscreenElement){(a=c.webkitFullscreenElement)&&\"IFRAME\"==\na.tagName&&(h=a.contentDocument,a=a.contentDocument.webkitFullscreenElement);p=!0;if(a&&\"VIDEO\"!=a.tagName){p=!1;var e=a.querySelectorAll(\"video\");e&&0<e.length&&(a=e[0])}if(a&&\"VIDEO\"==a.tagName){a.addEventListener(\"timeupdate\",d);a.addEventListener(\"play\",k);a.addEventListener(\"pause\",g);a.addEventListener(\"playing\",f);a.addEventListener(\"waiting\",l);a.addEventListener(\"seeking\",n);a.addEventListener(\"seeked\",m);e=a.videoWidth;var t=a.videoHeight;u=(new Date).valueOf();var r=v(a);try{b.xwebToNative.onVideoEnterFullscreen(p,\nu,e,t,a.paused,a.seeking,a.currentTime,a.duration,r)}catch(w){}p&&(e=h.getElementById(\"styles_js\"),e||(e=h.createElement(\"style\"),e.type=\"text/css\",e.id=\"styles_js\",h.getElementsByTagName(\"head\")[0].appendChild(e)),q=h.createTextNode(\"video::-webkit-media-controls {display: none!important;}\"),e.appendChild(q))}}else if(a){a.removeEventListener(\"timeupdate\",d);a.removeEventListener(\"play\",k);a.removeEventListener(\"pause\",g);a.removeEventListener(\"playing\",f);a.removeEventListener(\"waiting\",l);a.removeEventListener(\"seeking\",\nn);a.removeEventListener(\"seeked\",m);a=null;u=0;try{b.xwebToNative.onVideoExitFullscreen()}catch(w){}p&&(h=h.getElementById(\"styles_js\"))&&h.hasChildNodes(q)&&h.removeChild(q)}},c.addEventListener(\"webkitfullscreenchange\",xwebVideoBridge.xweb_webkitfullscreenchange))};return 1},this.xwebVideoBridge(this,document));this.xwebVideoBridge.hookFullscreen();function xweb_log_print(b){}\nthis.xweb_video_utils={ClickItemInfo:function(b,c,d,k,g,f,l,n,m){this.index=b;this.pattern=c;this.videoNode=d;this.fullsceenNode=k;this.parentLevel=g;this.cloneNode=f;this.event=l;this.iframe=n;this[\"continue\"]=void 0==m?!0:m},getClickMapInfo:function(b){var c=[new this.ClickItemInfo(0,/^https?:\\/\\/.*\\.qq\\.com/,\"video\",'button[class=\"txp_btn txp_btn_fullscreen\"]',7,!0,\"click\",\"\"),new this.ClickItemInfo(1,/^https?:\\/\\/.*\\.le\\.com/,\"video\",'div[class=\"hv_botbar_btn\"]',7,!0,\"click\",\"\"),new this.ClickItemInfo(2,\n/^https?:\\/\\/.*\\.bilibili\\.com/,'div[class=\"index__player__src-videoPage-player-\"]','i[class=\"player-icon icon-widescreen\"]',10,!1,\"click\",\"\"),new this.ClickItemInfo(3,/^https?:\\/\\/.*\\.acfun\\.cn/,'div[class=\"player\"]','div[class=\"controller-btn-fullscreen\"]',5,!0,\"click\",\"player\")],d=[];for(cinfo in c)if(c[cinfo].pattern.test(b)&&(d.push(c[cinfo]),!c[cinfo][\"continue\"]))break;return d},getNode:function(b,c){return c.constructor==String?b.querySelectorAll(c)[0]:c},getNodes:function(b,c){return b.constructor==\nString?void 0!=c&&\"\"!=c?(iDoc=document.getElementById(c),null==iDoc?b:iDoc.contentWindow.document.querySelectorAll(b)):document.querySelectorAll(b):b},registerForFullscreen:function(b,c){var d;function k(b,c){xweb_log_print(\"enterFullscreen\");for(var d=b,a=0;a<c.parentLevel&&null!=d.parentElement;++a)d=d.parentElement;d=xweb_video_utils.getNode(d,c.videoNode);void 0!=d&&d.webkitRequestFullscreen&&(xweb_log_print(\"requestFullscreen\"),d.webkitRequestFullscreen(),this.xwebVideoBridge.xwebToNative_Special_Video_EnterFullscreen(c.index))}\nfunction g(b,c){null==document.webkitFullscreenElement?k(b,c):(xweb_log_print(\"webkitExitFullscreen\"),document.webkitExitFullscreen())}function f(d){xweb_log_print(\"handleClick\");g(b,c)}function l(b){xweb_log_print(\"touchstart\");d=b.changedTouches[0].clientX;m=b.changedTouches[0].clientY}function n(f){xweb_log_print(\"touchend\");5>Math.abs(d-f.changedTouches[0].clientX)&&5>Math.abs(m-f.changedTouches[0].clientY)&&g(b,c)}var m=d=void 0;if(void 0==b.clickishook||1!=b.clickishook)\"click\"==c.event&&(b.addEventListener(\"click\",\nf),b.clickishook=!0),\"touch\"==c.event&&(b.addEventListener(\"touchstart\",l),b.addEventListener(\"touchend\",n),b.clickishook=!0),window.xwebVideoBridge.xwebToNative_Special_Video_Hook(c.index)}};kMaxTry=10;\nwindow.xweb_register_fullscreen_detect_function=function(){xweb_log_print(\"xweb_register_fullscreen_detect_function\");var b=xweb_video_utils.getClickMapInfo(location.href);if(void 0==b||0==b.length)xweb_log_print(\"we not support the url:\"+location.href);else{xweb_log_print(\"we support the url:\"+location.href+\", clickInfos.length= \"+b.length);for(cinfo in b){var c=b[cinfo],d=xweb_video_utils.getNodes(c.fullsceenNode,c.iframe);xweb_log_print(\"try to find  all video node for fullscreenNodes \"+d+\", length = \"+\nd.length);for(var k=0;k<d.length;++k){try{var g=d.item(k)}catch(n){break}if(c.cloneNode){var f=g.cloneNode(!0);g.parentNode.replaceChild(f,g);g=f}f=g;xweb_log_print(\"try to find video node for fullscreenNode \"+g);for(var l=0;l<c.parentLevel&&null!=f.parentElement;++l)f=f.parentElement;f=xweb_video_utils.getNode(f,c.videoNode);void 0!=f&&void 0!=g&&(xweb_log_print(\"find videoNode = \"+f+\", fullscreenNode =\"+g),xweb_video_utils.registerForFullscreen(g,c),kMaxTry=0)}}0<--kMaxTry&&(xweb_log_print(\"not found the target node, sleep 300ms for next find this = \"+\nthis),window.setTimeout(window.xweb_register_fullscreen_detect_function,600))}};this.detect||(window.setTimeout(window.xweb_register_fullscreen_detect_function,600),this.detect=!0);\nvar MutationObserver=window.MutationObserver||window.WebKitMutationObserver||window.MozMutationObserver,observer=new MutationObserver(function(b){b.forEach(function(b){b.addedNodes.forEach(function(b){b.querySelector&&void 0!=b.querySelector(\"video\")&&window.xweb_register_fullscreen_detect_function()})})}),config={subtree:!0,childList:!0};observer.observe(document.body,config);";
                        f.dVv();
                        AppMethodBeat.o(84599);
                        return str;
                    } catch (Throwable th2) {
                        th = th2;
                        if (inputStreamReader != null) {
                            try {
                                inputStreamReader.close();
                            } catch (Exception e7) {
                                AppMethodBeat.o(84599);
                                throw th;
                            }
                        }
                        if (obj2 != null) {
                            obj2.close();
                        }
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        AppMethodBeat.o(84599);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    obj2 = str2;
                    if (inputStreamReader != null) {
                    }
                    if (obj2 != null) {
                    }
                    if (inputStream2 != null) {
                    }
                    AppMethodBeat.o(84599);
                    throw th;
                }
            } catch (IOException e8) {
                e = e8;
                Object obj3 = str2;
                obj2 = str2;
                Log.e("XWebNativeInterface", "initJs open jsFile error" + e.getMessage());
                if (inputStreamReader != null) {
                }
                if (obj2 != null) {
                }
                if (inputStream2 != null) {
                }
                str = str2;
                if (str != null) {
                }
                Log.i("XWebNativeInterface", "use video js default ");
                str = "this.xwebVideoBridge||(this.xwebVideoBridge=function(b,c){function d(a){a=a.target;var c=v(a);try{b.xwebToNative.onVideoTimeUpdate(a.currentTime,a.duration,c)}catch(t){}try{b.xwebToNative.onVideoSizeUpdate(a.videoWidth,a.videoHeight)}catch(t){}}function k(a){try{b.xwebToNative.onVideoPlay()}catch(e){}}function g(a){try{b.xwebToNative.onVideoPause()}catch(e){}}function f(a){try{b.xwebToNative.onVideoPlaying()}catch(e){}}function l(a){try{b.xwebToNative.onVideoWaiting()}catch(e){}}function n(a){try{b.xwebToNative.onVideoSeeking()}catch(e){}}\nfunction m(a){try{b.xwebToNative.onVideoSeeked()}catch(e){}}function v(a){for(var b=[],c=0;c<a.buffered.length;c++)b.push(a.buffered.start(c)),b.push(a.buffered.end(c));return b}var q,u,a=null,p=!0,r=!1;xwebVideoBridge.xwebToJS_Video_ExitFullscreen=function(){c&&c.webkitExitFullscreen();return\"1\"};xwebVideoBridge.xwebToJS_Video_Play=function(){a&&(a.paused?a.play():a.pause());return\"1\"};xwebVideoBridge.xwebToJS_Video_Seek=function(b){a&&(a.currentTime=b);return\"1\"};xwebVideoBridge.xwebToNative_Special_Video_EnterFullscreen=\nfunction(a){try{if(b.xwebToNative.onSpecialVideoEnterFullscreen)b.xwebToNative.onSpecialVideoEnterFullscreen(a)}catch(e){}};xwebVideoBridge.xwebToNative_Special_Video_Hook=function(a){try{b.xwebToNative.onSpecialVideoHook&&!r&&(b.xwebToNative.onSpecialVideoHook(a),r=!0)}catch(e){}};xwebVideoBridge.hookFullscreen=function(){xwebVideoBridge.xweb_webkitfullscreenchange||(xwebVideoBridge.xweb_webkitfullscreenchange=function(h){h=c;if(c.webkitFullscreenElement){(a=c.webkitFullscreenElement)&&\"IFRAME\"==\na.tagName&&(h=a.contentDocument,a=a.contentDocument.webkitFullscreenElement);p=!0;if(a&&\"VIDEO\"!=a.tagName){p=!1;var e=a.querySelectorAll(\"video\");e&&0<e.length&&(a=e[0])}if(a&&\"VIDEO\"==a.tagName){a.addEventListener(\"timeupdate\",d);a.addEventListener(\"play\",k);a.addEventListener(\"pause\",g);a.addEventListener(\"playing\",f);a.addEventListener(\"waiting\",l);a.addEventListener(\"seeking\",n);a.addEventListener(\"seeked\",m);e=a.videoWidth;var t=a.videoHeight;u=(new Date).valueOf();var r=v(a);try{b.xwebToNative.onVideoEnterFullscreen(p,\nu,e,t,a.paused,a.seeking,a.currentTime,a.duration,r)}catch(w){}p&&(e=h.getElementById(\"styles_js\"),e||(e=h.createElement(\"style\"),e.type=\"text/css\",e.id=\"styles_js\",h.getElementsByTagName(\"head\")[0].appendChild(e)),q=h.createTextNode(\"video::-webkit-media-controls {display: none!important;}\"),e.appendChild(q))}}else if(a){a.removeEventListener(\"timeupdate\",d);a.removeEventListener(\"play\",k);a.removeEventListener(\"pause\",g);a.removeEventListener(\"playing\",f);a.removeEventListener(\"waiting\",l);a.removeEventListener(\"seeking\",\nn);a.removeEventListener(\"seeked\",m);a=null;u=0;try{b.xwebToNative.onVideoExitFullscreen()}catch(w){}p&&(h=h.getElementById(\"styles_js\"))&&h.hasChildNodes(q)&&h.removeChild(q)}},c.addEventListener(\"webkitfullscreenchange\",xwebVideoBridge.xweb_webkitfullscreenchange))};return 1},this.xwebVideoBridge(this,document));this.xwebVideoBridge.hookFullscreen();function xweb_log_print(b){}\nthis.xweb_video_utils={ClickItemInfo:function(b,c,d,k,g,f,l,n,m){this.index=b;this.pattern=c;this.videoNode=d;this.fullsceenNode=k;this.parentLevel=g;this.cloneNode=f;this.event=l;this.iframe=n;this[\"continue\"]=void 0==m?!0:m},getClickMapInfo:function(b){var c=[new this.ClickItemInfo(0,/^https?:\\/\\/.*\\.qq\\.com/,\"video\",'button[class=\"txp_btn txp_btn_fullscreen\"]',7,!0,\"click\",\"\"),new this.ClickItemInfo(1,/^https?:\\/\\/.*\\.le\\.com/,\"video\",'div[class=\"hv_botbar_btn\"]',7,!0,\"click\",\"\"),new this.ClickItemInfo(2,\n/^https?:\\/\\/.*\\.bilibili\\.com/,'div[class=\"index__player__src-videoPage-player-\"]','i[class=\"player-icon icon-widescreen\"]',10,!1,\"click\",\"\"),new this.ClickItemInfo(3,/^https?:\\/\\/.*\\.acfun\\.cn/,'div[class=\"player\"]','div[class=\"controller-btn-fullscreen\"]',5,!0,\"click\",\"player\")],d=[];for(cinfo in c)if(c[cinfo].pattern.test(b)&&(d.push(c[cinfo]),!c[cinfo][\"continue\"]))break;return d},getNode:function(b,c){return c.constructor==String?b.querySelectorAll(c)[0]:c},getNodes:function(b,c){return b.constructor==\nString?void 0!=c&&\"\"!=c?(iDoc=document.getElementById(c),null==iDoc?b:iDoc.contentWindow.document.querySelectorAll(b)):document.querySelectorAll(b):b},registerForFullscreen:function(b,c){var d;function k(b,c){xweb_log_print(\"enterFullscreen\");for(var d=b,a=0;a<c.parentLevel&&null!=d.parentElement;++a)d=d.parentElement;d=xweb_video_utils.getNode(d,c.videoNode);void 0!=d&&d.webkitRequestFullscreen&&(xweb_log_print(\"requestFullscreen\"),d.webkitRequestFullscreen(),this.xwebVideoBridge.xwebToNative_Special_Video_EnterFullscreen(c.index))}\nfunction g(b,c){null==document.webkitFullscreenElement?k(b,c):(xweb_log_print(\"webkitExitFullscreen\"),document.webkitExitFullscreen())}function f(d){xweb_log_print(\"handleClick\");g(b,c)}function l(b){xweb_log_print(\"touchstart\");d=b.changedTouches[0].clientX;m=b.changedTouches[0].clientY}function n(f){xweb_log_print(\"touchend\");5>Math.abs(d-f.changedTouches[0].clientX)&&5>Math.abs(m-f.changedTouches[0].clientY)&&g(b,c)}var m=d=void 0;if(void 0==b.clickishook||1!=b.clickishook)\"click\"==c.event&&(b.addEventListener(\"click\",\nf),b.clickishook=!0),\"touch\"==c.event&&(b.addEventListener(\"touchstart\",l),b.addEventListener(\"touchend\",n),b.clickishook=!0),window.xwebVideoBridge.xwebToNative_Special_Video_Hook(c.index)}};kMaxTry=10;\nwindow.xweb_register_fullscreen_detect_function=function(){xweb_log_print(\"xweb_register_fullscreen_detect_function\");var b=xweb_video_utils.getClickMapInfo(location.href);if(void 0==b||0==b.length)xweb_log_print(\"we not support the url:\"+location.href);else{xweb_log_print(\"we support the url:\"+location.href+\", clickInfos.length= \"+b.length);for(cinfo in b){var c=b[cinfo],d=xweb_video_utils.getNodes(c.fullsceenNode,c.iframe);xweb_log_print(\"try to find  all video node for fullscreenNodes \"+d+\", length = \"+\nd.length);for(var k=0;k<d.length;++k){try{var g=d.item(k)}catch(n){break}if(c.cloneNode){var f=g.cloneNode(!0);g.parentNode.replaceChild(f,g);g=f}f=g;xweb_log_print(\"try to find video node for fullscreenNode \"+g);for(var l=0;l<c.parentLevel&&null!=f.parentElement;++l)f=f.parentElement;f=xweb_video_utils.getNode(f,c.videoNode);void 0!=f&&void 0!=g&&(xweb_log_print(\"find videoNode = \"+f+\", fullscreenNode =\"+g),xweb_video_utils.registerForFullscreen(g,c),kMaxTry=0)}}0<--kMaxTry&&(xweb_log_print(\"not found the target node, sleep 300ms for next find this = \"+\nthis),window.setTimeout(window.xweb_register_fullscreen_detect_function,600))}};this.detect||(window.setTimeout(window.xweb_register_fullscreen_detect_function,600),this.detect=!0);\nvar MutationObserver=window.MutationObserver||window.WebKitMutationObserver||window.MozMutationObserver,observer=new MutationObserver(function(b){b.forEach(function(b){b.addedNodes.forEach(function(b){b.querySelector&&void 0!=b.querySelector(\"video\")&&window.xweb_register_fullscreen_detect_function()})})}),config={subtree:!0,childList:!0};observer.observe(document.body,config);";
                f.dVv();
                AppMethodBeat.o(84599);
                return str;
            } catch (Throwable th4) {
                th = th4;
                inputStreamReader = str2;
                obj2 = str2;
                if (inputStreamReader != null) {
                }
                if (obj2 != null) {
                }
                if (inputStream2 != null) {
                }
                AppMethodBeat.o(84599);
                throw th;
            }
        }
        str = str2;
        if (str != null || str.isEmpty()) {
            Log.i("XWebNativeInterface", "use video js default ");
            str = "this.xwebVideoBridge||(this.xwebVideoBridge=function(b,c){function d(a){a=a.target;var c=v(a);try{b.xwebToNative.onVideoTimeUpdate(a.currentTime,a.duration,c)}catch(t){}try{b.xwebToNative.onVideoSizeUpdate(a.videoWidth,a.videoHeight)}catch(t){}}function k(a){try{b.xwebToNative.onVideoPlay()}catch(e){}}function g(a){try{b.xwebToNative.onVideoPause()}catch(e){}}function f(a){try{b.xwebToNative.onVideoPlaying()}catch(e){}}function l(a){try{b.xwebToNative.onVideoWaiting()}catch(e){}}function n(a){try{b.xwebToNative.onVideoSeeking()}catch(e){}}\nfunction m(a){try{b.xwebToNative.onVideoSeeked()}catch(e){}}function v(a){for(var b=[],c=0;c<a.buffered.length;c++)b.push(a.buffered.start(c)),b.push(a.buffered.end(c));return b}var q,u,a=null,p=!0,r=!1;xwebVideoBridge.xwebToJS_Video_ExitFullscreen=function(){c&&c.webkitExitFullscreen();return\"1\"};xwebVideoBridge.xwebToJS_Video_Play=function(){a&&(a.paused?a.play():a.pause());return\"1\"};xwebVideoBridge.xwebToJS_Video_Seek=function(b){a&&(a.currentTime=b);return\"1\"};xwebVideoBridge.xwebToNative_Special_Video_EnterFullscreen=\nfunction(a){try{if(b.xwebToNative.onSpecialVideoEnterFullscreen)b.xwebToNative.onSpecialVideoEnterFullscreen(a)}catch(e){}};xwebVideoBridge.xwebToNative_Special_Video_Hook=function(a){try{b.xwebToNative.onSpecialVideoHook&&!r&&(b.xwebToNative.onSpecialVideoHook(a),r=!0)}catch(e){}};xwebVideoBridge.hookFullscreen=function(){xwebVideoBridge.xweb_webkitfullscreenchange||(xwebVideoBridge.xweb_webkitfullscreenchange=function(h){h=c;if(c.webkitFullscreenElement){(a=c.webkitFullscreenElement)&&\"IFRAME\"==\na.tagName&&(h=a.contentDocument,a=a.contentDocument.webkitFullscreenElement);p=!0;if(a&&\"VIDEO\"!=a.tagName){p=!1;var e=a.querySelectorAll(\"video\");e&&0<e.length&&(a=e[0])}if(a&&\"VIDEO\"==a.tagName){a.addEventListener(\"timeupdate\",d);a.addEventListener(\"play\",k);a.addEventListener(\"pause\",g);a.addEventListener(\"playing\",f);a.addEventListener(\"waiting\",l);a.addEventListener(\"seeking\",n);a.addEventListener(\"seeked\",m);e=a.videoWidth;var t=a.videoHeight;u=(new Date).valueOf();var r=v(a);try{b.xwebToNative.onVideoEnterFullscreen(p,\nu,e,t,a.paused,a.seeking,a.currentTime,a.duration,r)}catch(w){}p&&(e=h.getElementById(\"styles_js\"),e||(e=h.createElement(\"style\"),e.type=\"text/css\",e.id=\"styles_js\",h.getElementsByTagName(\"head\")[0].appendChild(e)),q=h.createTextNode(\"video::-webkit-media-controls {display: none!important;}\"),e.appendChild(q))}}else if(a){a.removeEventListener(\"timeupdate\",d);a.removeEventListener(\"play\",k);a.removeEventListener(\"pause\",g);a.removeEventListener(\"playing\",f);a.removeEventListener(\"waiting\",l);a.removeEventListener(\"seeking\",\nn);a.removeEventListener(\"seeked\",m);a=null;u=0;try{b.xwebToNative.onVideoExitFullscreen()}catch(w){}p&&(h=h.getElementById(\"styles_js\"))&&h.hasChildNodes(q)&&h.removeChild(q)}},c.addEventListener(\"webkitfullscreenchange\",xwebVideoBridge.xweb_webkitfullscreenchange))};return 1},this.xwebVideoBridge(this,document));this.xwebVideoBridge.hookFullscreen();function xweb_log_print(b){}\nthis.xweb_video_utils={ClickItemInfo:function(b,c,d,k,g,f,l,n,m){this.index=b;this.pattern=c;this.videoNode=d;this.fullsceenNode=k;this.parentLevel=g;this.cloneNode=f;this.event=l;this.iframe=n;this[\"continue\"]=void 0==m?!0:m},getClickMapInfo:function(b){var c=[new this.ClickItemInfo(0,/^https?:\\/\\/.*\\.qq\\.com/,\"video\",'button[class=\"txp_btn txp_btn_fullscreen\"]',7,!0,\"click\",\"\"),new this.ClickItemInfo(1,/^https?:\\/\\/.*\\.le\\.com/,\"video\",'div[class=\"hv_botbar_btn\"]',7,!0,\"click\",\"\"),new this.ClickItemInfo(2,\n/^https?:\\/\\/.*\\.bilibili\\.com/,'div[class=\"index__player__src-videoPage-player-\"]','i[class=\"player-icon icon-widescreen\"]',10,!1,\"click\",\"\"),new this.ClickItemInfo(3,/^https?:\\/\\/.*\\.acfun\\.cn/,'div[class=\"player\"]','div[class=\"controller-btn-fullscreen\"]',5,!0,\"click\",\"player\")],d=[];for(cinfo in c)if(c[cinfo].pattern.test(b)&&(d.push(c[cinfo]),!c[cinfo][\"continue\"]))break;return d},getNode:function(b,c){return c.constructor==String?b.querySelectorAll(c)[0]:c},getNodes:function(b,c){return b.constructor==\nString?void 0!=c&&\"\"!=c?(iDoc=document.getElementById(c),null==iDoc?b:iDoc.contentWindow.document.querySelectorAll(b)):document.querySelectorAll(b):b},registerForFullscreen:function(b,c){var d;function k(b,c){xweb_log_print(\"enterFullscreen\");for(var d=b,a=0;a<c.parentLevel&&null!=d.parentElement;++a)d=d.parentElement;d=xweb_video_utils.getNode(d,c.videoNode);void 0!=d&&d.webkitRequestFullscreen&&(xweb_log_print(\"requestFullscreen\"),d.webkitRequestFullscreen(),this.xwebVideoBridge.xwebToNative_Special_Video_EnterFullscreen(c.index))}\nfunction g(b,c){null==document.webkitFullscreenElement?k(b,c):(xweb_log_print(\"webkitExitFullscreen\"),document.webkitExitFullscreen())}function f(d){xweb_log_print(\"handleClick\");g(b,c)}function l(b){xweb_log_print(\"touchstart\");d=b.changedTouches[0].clientX;m=b.changedTouches[0].clientY}function n(f){xweb_log_print(\"touchend\");5>Math.abs(d-f.changedTouches[0].clientX)&&5>Math.abs(m-f.changedTouches[0].clientY)&&g(b,c)}var m=d=void 0;if(void 0==b.clickishook||1!=b.clickishook)\"click\"==c.event&&(b.addEventListener(\"click\",\nf),b.clickishook=!0),\"touch\"==c.event&&(b.addEventListener(\"touchstart\",l),b.addEventListener(\"touchend\",n),b.clickishook=!0),window.xwebVideoBridge.xwebToNative_Special_Video_Hook(c.index)}};kMaxTry=10;\nwindow.xweb_register_fullscreen_detect_function=function(){xweb_log_print(\"xweb_register_fullscreen_detect_function\");var b=xweb_video_utils.getClickMapInfo(location.href);if(void 0==b||0==b.length)xweb_log_print(\"we not support the url:\"+location.href);else{xweb_log_print(\"we support the url:\"+location.href+\", clickInfos.length= \"+b.length);for(cinfo in b){var c=b[cinfo],d=xweb_video_utils.getNodes(c.fullsceenNode,c.iframe);xweb_log_print(\"try to find  all video node for fullscreenNodes \"+d+\", length = \"+\nd.length);for(var k=0;k<d.length;++k){try{var g=d.item(k)}catch(n){break}if(c.cloneNode){var f=g.cloneNode(!0);g.parentNode.replaceChild(f,g);g=f}f=g;xweb_log_print(\"try to find video node for fullscreenNode \"+g);for(var l=0;l<c.parentLevel&&null!=f.parentElement;++l)f=f.parentElement;f=xweb_video_utils.getNode(f,c.videoNode);void 0!=f&&void 0!=g&&(xweb_log_print(\"find videoNode = \"+f+\", fullscreenNode =\"+g),xweb_video_utils.registerForFullscreen(g,c),kMaxTry=0)}}0<--kMaxTry&&(xweb_log_print(\"not found the target node, sleep 300ms for next find this = \"+\nthis),window.setTimeout(window.xweb_register_fullscreen_detect_function,600))}};this.detect||(window.setTimeout(window.xweb_register_fullscreen_detect_function,600),this.detect=!0);\nvar MutationObserver=window.MutationObserver||window.WebKitMutationObserver||window.MozMutationObserver,observer=new MutationObserver(function(b){b.forEach(function(b){b.addedNodes.forEach(function(b){b.querySelector&&void 0!=b.querySelector(\"video\")&&window.xweb_register_fullscreen_detect_function()})})}),config={subtree:!0,childList:!0};observer.observe(document.body,config);";
            f.dVv();
        } else {
            Log.i("XWebNativeInterface", "use video js ver ".concat(String.valueOf(i)));
            f.dVu();
        }
        AppMethodBeat.o(84599);
        return str;
    }

    private void reset() {
        AppMethodBeat.i(84600);
        if (this.euK == null) {
            this.euK = (AudioManager) this.zxW.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        }
        this.AOb = this.euK.getStreamMaxVolume(3);
        this.AOc = (double) this.euK.getStreamVolume(3);
        if (this.AOf == null) {
            this.AOf = new a(this.zxW.getContext());
        }
        if (this.Ti == null) {
            Activity dUp = dUp();
            if (dUp != null) {
                this.Ti = dUp.getWindow();
            }
        }
        if (this.Ti != null && this.auN == null) {
            this.auN = this.Ti.getAttributes();
        }
        if (this.auN != null) {
            this.mBrightness = this.auN.screenBrightness;
            if (this.mBrightness == -1.0f) {
                try {
                    this.mBrightness = (float) (((double) System.getInt(this.zxW.getContext().getContentResolver(), "screen_brightness")) / 256.0d);
                    AppMethodBeat.o(84600);
                    return;
                } catch (SettingNotFoundException e) {
                    Log.e("XWebNativeInterface", "brightness get error:" + e.getMessage());
                }
            }
        }
        AppMethodBeat.o(84600);
    }

    public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        AppMethodBeat.i(84601);
        Log.i("XWebNativeInterface", "onShowCustomView");
        this.ANE = view;
        this.ANQ = customViewCallback;
        if (this.ANE != null || this.zxW.isXWalkKernel()) {
            if (this.zxW.isXWalkKernel()) {
                f.dUT();
            } else if (this.zxW.isSysKernel()) {
                f.dUX();
            }
            Log.i("XWebNativeInterface", "attach");
            if (this.AOq) {
                Log.i("XWebNativeInterface", "attach has entered fullscreen");
            } else {
                Activity dUp = dUp();
                if (dUp != null) {
                    reset();
                    rA(true);
                    ViewParent viewParent = (FrameLayout) dUp.getWindow().getDecorView();
                    if (this.zxW.isXWalkKernel() && this.odV.getParent() == viewParent && this.ANE != null) {
                        this.odV.addView(this.ANE, 0, new FrameLayout.LayoutParams(-1, -1, 17));
                    } else if (this.odV.getParent() != viewParent) {
                        viewParent.addView(this.odV, new FrameLayout.LayoutParams(-1, -1, 17));
                        if (this.ANE != null) {
                            this.odV.addView(this.ANE, this.odV.getChildCount(), new FrameLayout.LayoutParams(-1, -1, 17));
                            if (this.zxW.isSysKernel()) {
                                this.ANE.setVisibility(4);
                            }
                        }
                        if (this.zxW.isSysKernel()) {
                            SurfaceView fB = fB(this.ANE);
                            if (fB != null) {
                                fB.setZOrderMediaOverlay(true);
                            }
                        }
                        if (this.zxW.isXWalkKernel()) {
                            this.ANC = (ViewGroup) this.zxW.getParent();
                            this.ANC.removeView(this.zxW);
                            this.odV.addView(this.zxW, this.odV.getChildCount());
                        }
                        this.odV.addView(this.ANF, this.odV.getChildCount(), new FrameLayout.LayoutParams(-1, -1, 17));
                        this.AOm = this.zxW.getWebViewUI().getBackground();
                        this.zxW.getWebViewUI().setBackgroundColor(com.tencent.smtt.sdk.WebView.NIGHT_MODE_COLOR);
                        this.AOn = this.zxW.getBackground();
                        this.zxW.setBackgroundColor(com.tencent.smtt.sdk.WebView.NIGHT_MODE_COLOR);
                        if (this.zxW.isSysKernel()) {
                            this.odV.postDelayed(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(84588);
                                    if (d.this.ANE != null) {
                                        d.this.ANE.setVisibility(0);
                                    }
                                    AppMethodBeat.o(84588);
                                }
                            }, (long) this.AOl);
                        }
                    }
                }
            }
        }
        this.zxW.requestFocus();
        AppMethodBeat.o(84601);
    }

    public final void onHideCustomView() {
        AppMethodBeat.i(84602);
        if (this.ANQ != null) {
            this.ANQ.onCustomViewHidden();
        }
        Log.i("XWebNativeInterface", "detach");
        if (this.AOq) {
            Activity dUp = dUp();
            if (dUp != null) {
                if (this.AOm != null) {
                    if (this.AOm instanceof ColorDrawable) {
                        this.zxW.getWebViewUI().setBackgroundColor(((ColorDrawable) this.AOm).getColor());
                    }
                    this.AOm = null;
                } else {
                    this.zxW.getWebViewUI().setBackgroundColor(0);
                }
                if (this.AOn != null) {
                    this.zxW.setBackground(this.AOn);
                } else {
                    this.zxW.setBackgroundColor(0);
                }
                if (this.odV.getParent() != ((ViewGroup) dUp.getWindow().getDecorView())) {
                    AppMethodBeat.o(84602);
                    return;
                }
                if (this.zxW.isXWalkKernel()) {
                    this.odV.removeView(this.zxW);
                    this.ANC.addView(this.zxW, 0);
                }
                if (this.ANE != null) {
                    this.odV.removeView(this.ANE);
                }
                this.odV.removeView(this.ANF);
                this.ANF.setVisibility(8);
                if (this.AOa != -3) {
                    dUp.setRequestedOrientation(this.AOa);
                    this.AOa = -3;
                }
                rA(false);
                if (this.odV.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.odV.getParent()).removeView(this.odV);
                }
            }
            AppMethodBeat.o(84602);
            return;
        }
        Log.i("XWebNativeInterface", "detach has exited fullscreen");
        AppMethodBeat.o(84602);
    }

    private void aC(Runnable runnable) {
        AppMethodBeat.i(84603);
        Activity dUp = dUp();
        if (dUp != null) {
            dUp.runOnUiThread(runnable);
            AppMethodBeat.o(84603);
            return;
        }
        this.zxW.getView().post(runnable);
        AppMethodBeat.o(84603);
    }

    public final void dUr() {
        AppMethodBeat.i(84604);
        if (this.AOh != null) {
            this.AOh.cancel();
            this.AOh.purge();
            this.AOh = null;
        }
        this.AOh = new Timer();
        this.AOh.schedule(new TimerTask() {
            public final void run() {
                AppMethodBeat.i(84593);
                d.this.dUu();
                AppMethodBeat.o(84593);
            }
        }, 4000);
        AppMethodBeat.o(84604);
    }

    public final void dUs() {
        AppMethodBeat.i(84605);
        if (this.AOh != null) {
            this.AOh.cancel();
            this.AOh.purge();
            this.AOh = null;
        }
        AppMethodBeat.o(84605);
    }

    public final boolean onDown(MotionEvent motionEvent) {
        this.AOj = 0;
        return true;
    }

    public final void onShowPress(MotionEvent motionEvent) {
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        AppMethodBeat.i(84606);
        dUs();
        if (this.AOi) {
            dUu();
        } else {
            dUt();
        }
        AppMethodBeat.o(84606);
        return true;
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        AppMethodBeat.i(84607);
        if (motionEvent == null || motionEvent2 == null) {
            AppMethodBeat.o(84607);
        } else {
            float width;
            float height;
            float x = motionEvent2.getX() - motionEvent.getX();
            float y = motionEvent2.getY() - motionEvent.getY();
            if (this.ANF.getHeight() > this.ANF.getWidth()) {
                width = (float) this.ANF.getWidth();
                height = (float) this.ANF.getHeight();
            } else {
                width = (float) this.ANF.getHeight();
                height = (float) this.ANF.getWidth();
            }
            double ceil;
            switch (this.AOj) {
                case 0:
                    if (Math.abs(x) - Math.abs(y) <= 1.0f) {
                        reset();
                        ceil = Math.ceil((double) (25.0f * this.zxW.getContext().getResources().getDisplayMetrics().density));
                        if (((double) motionEvent.getY()) >= 2.0d * ceil && ((double) motionEvent.getY()) <= ((double) this.ANF.getHeight()) - (ceil * 2.0d)) {
                            if (motionEvent.getX() >= ((float) this.ANF.getWidth()) / 2.0f) {
                                this.AOj = 1;
                                break;
                            }
                            this.AOj = 2;
                            break;
                        }
                        this.AOj = 0;
                        break;
                    }
                    this.AOj = 3;
                    break;
                    break;
                case 1:
                    float f3 = y * -1.0f;
                    double d = (double) (((((float) this.AOb) * f3) / width) * 1.2f);
                    int i = (int) d;
                    if (i == 0 && Math.abs(d) > 0.20000000298023224d) {
                        if (f3 > 0.0f) {
                            i = 1;
                        } else if (f3 < 0.0f) {
                            i = -1;
                        }
                    }
                    ceil = ((double) i) + this.AOc;
                    if (ceil > ((double) this.AOb)) {
                        ceil = (double) this.AOb;
                    } else if (ceil < 0.0d) {
                        ceil = 0.0d;
                    }
                    this.euK.setStreamVolume(3, (int) ceil, 4);
                    this.ANG.setVolumnProgress((int) ((ceil / ((double) ((float) this.AOb))) * 100.0d));
                    this.ANG.show();
                    break;
                case 2:
                    height = (((-1.0f * y) / width) * 1.2f) + this.mBrightness;
                    if (height < 0.0f) {
                        height = 0.0f;
                    } else if (height > 1.0f) {
                        height = 1.0f;
                    }
                    this.auN.screenBrightness = height;
                    this.Ti.setAttributes(this.auN);
                    this.ANG.setBrightProgress((int) (height * 100.0f));
                    this.ANG.show();
                    break;
                case 3:
                    width = motionEvent2.getX() - motionEvent.getX();
                    this.AOe = this.ANP.Yn;
                    if (width > 0.0f) {
                        this.AOd = (float) ((int) (((width / height) * 100.0f) + this.AOe));
                        if (this.AOd > 100.0f) {
                            this.AOd = 100.0f;
                        }
                    } else {
                        this.AOd = (float) ((int) (((width / height) * 100.0f) + this.AOe));
                        if (this.AOd < 0.0f) {
                            this.AOd = 0.0f;
                        }
                    }
                    ceil = (this.idN * ((double) this.AOd)) / 100.0d;
                    this.ANG.setVideoTimeProgress(q(ceil, this.idN) + "/" + q(this.idN, this.idN));
                    this.ANG.show();
                    this.AOk = ceil;
                    break;
            }
            AppMethodBeat.o(84607);
        }
        return true;
    }

    public final void onLongPress(MotionEvent motionEvent) {
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        AppMethodBeat.i(84608);
        if (this.mMode != 1 || this.ANE == null) {
            AppMethodBeat.o(84608);
            return false;
        }
        float scaleFactor = scaleGestureDetector.getScaleFactor();
        this.ANE.getLeft();
        this.ANE.getTop();
        this.ANE.getBottom();
        this.ANE.getRight();
        int width = (int) (((float) this.ANE.getWidth()) * scaleFactor);
        int height = (int) (scaleFactor * ((float) this.ANE.getHeight()));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        layoutParams.width = width;
        layoutParams.height = height;
        if (this.ANE != null) {
            this.ANE.setLayoutParams(layoutParams);
        }
        AppMethodBeat.o(84608);
        return true;
    }

    public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        return true;
    }

    public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
    }

    public final void dUt() {
        AppMethodBeat.i(84609);
        aC(new Runnable() {
            public final void run() {
                AppMethodBeat.i(84594);
                d.this.AOi = true;
                d.this.ANL.setVisibility(0);
                d.this.dUr();
                AppMethodBeat.o(84594);
            }
        });
        AppMethodBeat.o(84609);
    }

    public final void dUu() {
        AppMethodBeat.i(84610);
        aC(new Runnable() {
            public final void run() {
                AppMethodBeat.i(84595);
                d.this.AOi = false;
                d.this.ANL.setVisibility(4);
                AppMethodBeat.o(84595);
            }
        });
        AppMethodBeat.o(84610);
    }

    private void rz(final boolean z) {
        AppMethodBeat.i(84611);
        aC(new Runnable() {
            public final void run() {
                AppMethodBeat.i(84576);
                if (z) {
                    d.this.ANO.setImageResource(R.drawable.a83);
                    AppMethodBeat.o(84576);
                    return;
                }
                d.this.ANO.setImageResource(R.drawable.a85);
                AppMethodBeat.o(84576);
            }
        });
        AppMethodBeat.o(84611);
    }

    public final void f(final double d, final boolean z) {
        AppMethodBeat.i(84612);
        aC(new Runnable() {
            public final void run() {
                AppMethodBeat.i(84577);
                if (z && d.this.idN != 0.0d) {
                    d.this.ANP.c((float) ((int) (100.0d * (d / d.this.idN))), false);
                }
                d.this.ANI.setText(d.a(d.this, d));
                d.this.ANJ.setText(d.n(d.this));
                AppMethodBeat.o(84577);
            }
        });
        AppMethodBeat.o(84612);
    }

    private static String q(double d, double d2) {
        AppMethodBeat.i(84613);
        String format = String.format("%02d", new Object[]{Integer.valueOf((int) (d / 3600.0d))});
        String format2 = String.format("%02d", new Object[]{Integer.valueOf(((int) (d % 3600.0d)) / 60)});
        String format3 = String.format("%02d", new Object[]{Integer.valueOf(((int) (d % 3600.0d)) % 60)});
        if (d2 > 3600.0d) {
            format = String.format("%s:%s:%s", new Object[]{format, format2, format3});
        } else {
            format = String.format("%s:%s", new Object[]{format2, format3});
        }
        AppMethodBeat.o(84613);
        return format;
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void onVideoGetFrame(long j, double d, String str) {
        AppMethodBeat.i(84614);
        if (j == this.ANT && this.AOk == d && str != null && str.startsWith("data:image/png;base64,")) {
            byte[] decode = Base64.decode(str.substring(22), 0);
            this.ANM.setImageBitmap(BitmapFactory.decodeByteArray(decode, 0, decode.length));
            this.ANM.setVisibility(0);
        }
        AppMethodBeat.o(84614);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void onVideoPlaying() {
        AppMethodBeat.i(84615);
        Log.i("XWebNativeInterface", "onVideoPlaying");
        aC(new Runnable() {
            public final void run() {
                AppMethodBeat.i(84579);
                d.this.ANH.setVisibility(8);
                AppMethodBeat.o(84579);
            }
        });
        AppMethodBeat.o(84615);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void onVideoWaiting() {
        AppMethodBeat.i(84616);
        Log.i("XWebNativeInterface", "onVideoWaiting");
        aC(new Runnable() {
            public final void run() {
                AppMethodBeat.i(84580);
                d.this.ANH.setVisibility(0);
                AppMethodBeat.o(84580);
            }
        });
        AppMethodBeat.o(84616);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void onVideoSeeking() {
        AppMethodBeat.i(84617);
        Log.i("XWebNativeInterface", "onVideoSeeking");
        aC(new Runnable() {
            public final void run() {
                AppMethodBeat.i(84581);
                d.this.ANH.setVisibility(0);
                AppMethodBeat.o(84581);
            }
        });
        AppMethodBeat.o(84617);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void onVideoSeeked() {
        AppMethodBeat.i(84618);
        Log.i("XWebNativeInterface", "onVideoSeeked");
        aC(new Runnable() {
            public final void run() {
                AppMethodBeat.i(84582);
                d.this.ANH.setVisibility(8);
                AppMethodBeat.o(84582);
            }
        });
        AppMethodBeat.o(84618);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void onVideoPlay() {
        AppMethodBeat.i(84619);
        Log.i("XWebNativeInterface", "onVideoPlay");
        rz(false);
        AppMethodBeat.o(84619);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void onVideoPause() {
        AppMethodBeat.i(84620);
        Log.i("XWebNativeInterface", "onVideoPause");
        rz(true);
        AppMethodBeat.o(84620);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void onVideoEnterFullscreen(boolean z, long j, double d, double d2, boolean z2, boolean z3, double d3, double d4, double[] dArr) {
        AppMethodBeat.i(84621);
        Log.i("XWebNativeInterface", "onVideoEnterFullscreen:isVideoTag:" + z + ",width:" + d + ",height:" + d2 + ",pause:" + z2 + ",seeking:" + z3 + ",currentTime:" + d3 + ",duration:" + d4);
        if (this.zxW.isXWalkKernel()) {
            f.dUU();
        } else if (this.zxW.isSysKernel()) {
            f.dUY();
        }
        if (z) {
            if (this.zxW.isXWalkKernel()) {
                f.dUV();
            } else if (this.zxW.isSysKernel()) {
                f.dUZ();
            }
            this.ANS = true;
        }
        this.ANT = j;
        this.idN = d4;
        this.ANU = d;
        this.ANV = d2;
        if (z3) {
            onVideoSeeking();
        } else {
            onVideoSeeked();
        }
        final boolean z4 = z;
        final double d5 = d;
        final double d6 = d2;
        aC(new Runnable() {
            public final void run() {
                AppMethodBeat.i(84583);
                if (z4) {
                    d.this.ANF.setVisibility(0);
                }
                d.this.ii((int) d5, (int) d6);
                AppMethodBeat.o(84583);
            }
        });
        onVideoTimeUpdate(d3, d4, dArr);
        rz(z2);
        AppMethodBeat.o(84621);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void onVideoExitFullscreen() {
        AppMethodBeat.i(84622);
        Log.i("XWebNativeInterface", "onVideoExitFullscreen");
        this.ANS = false;
        aC(new Runnable() {
            public final void run() {
                AppMethodBeat.i(84584);
                d.this.ANF.setVisibility(8);
                AppMethodBeat.o(84584);
            }
        });
        AppMethodBeat.o(84622);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void onVideoTimeUpdate(double d, final double d2, final double[] dArr) {
        AppMethodBeat.i(84623);
        this.idN = d2;
        f(d, true);
        aC(new Runnable() {
            public final void run() {
                AppMethodBeat.i(84578);
                c l = d.this.ANP;
                double d = d2;
                double[] dArr = dArr;
                double d2 = 0.0d;
                int i = 0;
                while (i < dArr.length) {
                    if (dArr.length > i + 1 && (dArr[i] / d) * 100.0d <= ((double) l.Yn) && (dArr[i + 1] / d) * 100.0d > ((double) l.Yn)) {
                        d2 = (dArr[i + 1] / d) * 100.0d;
                    }
                    i += 2;
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) l.hZC.getLayoutParams();
                layoutParams.width = (int) ((d2 / 100.0d) * ((double) l.qym.getWidth()));
                l.hZC.setLayoutParams(layoutParams);
                l.hZC.requestLayout();
                AppMethodBeat.o(84578);
            }
        });
        AppMethodBeat.o(84623);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void onVideoSizeUpdate(double d, double d2) {
        AppMethodBeat.i(84624);
        if (!(this.ANV == d2 && this.ANU == d)) {
            this.ANU = d;
            this.ANV = d2;
            Log.i("XWebNativeInterface", "onVideoSizeUpdate width:" + d + ", height:" + d2);
            final double d3 = d;
            final double d4 = d2;
            aC(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(84585);
                    d.this.ii((int) d3, (int) d4);
                    AppMethodBeat.o(84585);
                }
            });
        }
        AppMethodBeat.o(84624);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void onSpecialVideoEnterFullscreen(int i) {
        AppMethodBeat.i(84625);
        Log.i("XWebNativeInterface", "onSpecialVideoEnterFullscreen:".concat(String.valueOf(i)));
        f.aK(i, this.zxW.isXWalkKernel());
        AppMethodBeat.o(84625);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void onSpecialVideoHook(int i) {
        AppMethodBeat.i(84626);
        Log.i("XWebNativeInterface", "onSpecialVideoHook:".concat(String.valueOf(i)));
        f.aL(i, this.zxW.isXWalkKernel());
        AppMethodBeat.o(84626);
    }

    private SurfaceView fB(View view) {
        AppMethodBeat.i(84627);
        if (view instanceof SurfaceView) {
            SurfaceView surfaceView = (SurfaceView) view;
            AppMethodBeat.o(84627);
            return surfaceView;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                SurfaceView fB = fB(viewGroup.getChildAt(i));
                if (fB != null) {
                    AppMethodBeat.o(84627);
                    return fB;
                }
            }
        }
        AppMethodBeat.o(84627);
        return null;
    }

    public final boolean hasEnteredFullscreen() {
        return this.AOq;
    }

    private void rA(boolean z) {
        AppMethodBeat.i(84628);
        Activity dUp = dUp();
        if (dUp == null) {
            AppMethodBeat.o(84628);
            return;
        }
        if (z) {
            if ((dUp.getWindow().getAttributes().flags & 2048) != 0) {
                this.AOp = true;
                dUp.getWindow().clearFlags(2048);
            } else {
                this.AOp = false;
            }
            if (!this.AOq) {
                if ((dUp.getWindow().getAttributes().flags & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
                    this.AOo = true;
                } else {
                    this.AOo = false;
                    dUp.getWindow().addFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                }
                this.AOq = true;
                AppMethodBeat.o(84628);
                return;
            }
        }
        if (this.AOp) {
            dUp.getWindow().addFlags(2048);
        }
        if (!this.AOo) {
            dUp.getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
        this.AOr = 0;
        this.AOq = false;
        this.ANS = false;
        AppMethodBeat.o(84628);
    }

    public final void ii(int i, int i2) {
        AppMethodBeat.i(84629);
        Activity dUp = dUp();
        if (dUp == null) {
            AppMethodBeat.o(84629);
            return;
        }
        int i3;
        if (this.AOa == -3 && dUp != null) {
            this.AOa = dUp.getRequestedOrientation();
        }
        if (i <= i2) {
            dUp.setRequestedOrientation(1);
            i3 = 1;
        } else {
            dUp.setRequestedOrientation(0);
            i3 = 0;
        }
        this.hiG = i3;
        if (this.ANE != null) {
            int min;
            View view = this.ANE;
            Display defaultDisplay = ((WindowManager) this.zxW.getContext().getSystemService("window")).getDefaultDisplay();
            Point point = new Point(0, 0);
            defaultDisplay.getSize(point);
            if (i3 == 0) {
                i3 = Math.max(point.x, point.y);
                min = Math.min(point.x, point.y);
            } else {
                min = Math.max(point.x, point.y);
                i3 = Math.min(point.x, point.y);
            }
            double d = (((double) i) * 1.0d) / ((double) i2);
            if (d >= (((double) i3) * 1.0d) / ((double) min)) {
                min = (int) ((1.0d / d) * ((double) i3));
            } else {
                i3 = (int) (d * ((double) min));
            }
            view.setLayoutParams(new FrameLayout.LayoutParams(i3, min, 17));
        }
        AppMethodBeat.o(84629);
    }

    static /* synthetic */ String n(d dVar) {
        AppMethodBeat.i(84631);
        String q = q(dVar.idN, dVar.idN);
        AppMethodBeat.o(84631);
        return q;
    }
}
