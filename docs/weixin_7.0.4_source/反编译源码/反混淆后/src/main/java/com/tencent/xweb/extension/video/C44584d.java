package com.tencent.xweb.extension.video;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
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
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.xweb.WebView;
import com.tencent.xweb.extension.video.C44583c.C44582a;
import com.tencent.xweb.util.C24532f;
import com.tencent.xweb.xwalk.p686a.C24550c;
import com.tencent.xweb.xwalk.p686a.C36602e;
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

/* renamed from: com.tencent.xweb.extension.video.d */
public final class C44584d implements OnGestureListener, OnScaleGestureListener, C24528b {
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
    C44583c ANP;
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
    private C24527a AOf;
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
    /* renamed from: Mh */
    GestureDetector f17540Mh;
    /* renamed from: Ti */
    private Window f17541Ti;
    private LayoutParams auN;
    private AudioManager euK;
    private int hiG;
    private double idN;
    Activity mActivity;
    private float mBrightness = 1.0f;
    private int mMode = 0;
    FrameLayout odV;
    WebView zxW;

    /* renamed from: com.tencent.xweb.extension.video.d$12 */
    class C1638712 implements C44582a {

        /* renamed from: com.tencent.xweb.extension.video.d$12$1 */
        class C163881 implements ValueCallback<String> {
            C163881() {
            }

            public final /* bridge */ /* synthetic */ void onReceiveValue(Object obj) {
            }
        }

        C1638712() {
        }

        public final void aFw() {
            AppMethodBeat.m2504i(84586);
            C44584d.this.dUs();
            C44584d.this.dUt();
            AppMethodBeat.m2505o(84586);
        }

        /* renamed from: bw */
        public final void mo30108bw(float f) {
            AppMethodBeat.m2504i(84587);
            C44584d.this.mo71397f((C44584d.this.idN * ((double) f)) / 100.0d, false);
            C44584d.this.zxW.evaluateJavascript(String.format("xwebVideoBridge.xwebToJS_Video_Seek(%f);", new Object[]{Double.valueOf(r0)}), new C163881());
            C44584d.this.dUr();
            AppMethodBeat.m2505o(84587);
        }
    }

    /* renamed from: com.tencent.xweb.extension.video.d$13 */
    class C1638913 implements Runnable {
        C1638913() {
        }

        public final void run() {
            AppMethodBeat.m2504i(84588);
            if (C44584d.this.ANE != null) {
                C44584d.this.ANE.setVisibility(0);
            }
            AppMethodBeat.m2505o(84588);
        }
    }

    /* renamed from: com.tencent.xweb.extension.video.d$14 */
    class C1639014 implements OnTouchListener {

        /* renamed from: com.tencent.xweb.extension.video.d$14$1 */
        class C163911 implements ValueCallback<String> {
            C163911() {
            }

            public final /* bridge */ /* synthetic */ void onReceiveValue(Object obj) {
            }
        }

        C1639014() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(84589);
            if (C44584d.this.ANS) {
                switch (motionEvent.getAction() & 255) {
                    case 1:
                        C44584d.this.mMode = 0;
                        break;
                    case 5:
                        if (motionEvent.getPointerCount() == 2) {
                            C44584d.this.mMode = 1;
                            break;
                        }
                        break;
                    case 6:
                        C44584d.this.mMode = 0;
                        break;
                }
                if (motionEvent.getAction() == 1 && C44584d.this.AOj == 3) {
                    C44584d.this.mo71397f((C44584d.this.idN * ((double) C44584d.this.AOd)) / 100.0d, true);
                    C44584d.this.zxW.evaluateJavascript(String.format("xwebVideoBridge.xwebToJS_Video_Seek(%f);", new Object[]{Double.valueOf(r2)}), new C163911());
                    C44584d.this.AOj = 0;
                }
                boolean onTouchEvent;
                if (C44584d.this.mMode == 1) {
                    onTouchEvent = C44584d.this.ANR.onTouchEvent(motionEvent);
                    AppMethodBeat.m2505o(84589);
                    return onTouchEvent;
                }
                onTouchEvent = C44584d.this.f17540Mh.onTouchEvent(motionEvent);
                AppMethodBeat.m2505o(84589);
                return onTouchEvent;
            }
            AppMethodBeat.m2505o(84589);
            return false;
        }
    }

    /* renamed from: com.tencent.xweb.extension.video.d$8 */
    class C163928 implements Runnable {
        C163928() {
        }

        public final void run() {
            AppMethodBeat.m2504i(84582);
            C44584d.this.ANH.setVisibility(8);
            AppMethodBeat.m2505o(84582);
        }
    }

    /* renamed from: com.tencent.xweb.extension.video.d$1 */
    class C245291 implements Callback {
        C245291() {
        }

        public final void surfaceCreated(SurfaceHolder surfaceHolder) {
            AppMethodBeat.m2504i(84574);
            Canvas lockCanvas = surfaceHolder.lockCanvas();
            lockCanvas.drawColor(com.tencent.smtt.sdk.WebView.NIGHT_MODE_COLOR);
            surfaceHolder.unlockCanvasAndPost(lockCanvas);
            AppMethodBeat.m2505o(84574);
        }

        public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            AppMethodBeat.m2504i(84575);
            Canvas lockCanvas = surfaceHolder.lockCanvas();
            lockCanvas.drawColor(com.tencent.smtt.sdk.WebView.NIGHT_MODE_COLOR);
            surfaceHolder.unlockCanvasAndPost(lockCanvas);
            AppMethodBeat.m2505o(84575);
        }

        public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        }
    }

    /* renamed from: com.tencent.xweb.extension.video.d$10 */
    class C3114110 implements Runnable {
        C3114110() {
        }

        public final void run() {
            AppMethodBeat.m2504i(84584);
            C44584d.this.ANF.setVisibility(8);
            AppMethodBeat.m2505o(84584);
        }
    }

    /* renamed from: com.tencent.xweb.extension.video.d$19 */
    class C3114219 implements Runnable {
        C3114219() {
        }

        public final void run() {
            AppMethodBeat.m2504i(84594);
            C44584d.this.AOi = true;
            C44584d.this.ANL.setVisibility(0);
            C44584d.this.dUr();
            AppMethodBeat.m2505o(84594);
        }
    }

    /* renamed from: com.tencent.xweb.extension.video.d$6 */
    class C311436 implements Runnable {
        C311436() {
        }

        public final void run() {
            AppMethodBeat.m2504i(84580);
            C44584d.this.ANH.setVisibility(0);
            AppMethodBeat.m2505o(84580);
        }
    }

    /* renamed from: com.tencent.xweb.extension.video.d$7 */
    class C311447 implements Runnable {
        C311447() {
        }

        public final void run() {
            AppMethodBeat.m2504i(84581);
            C44584d.this.ANH.setVisibility(0);
            AppMethodBeat.m2505o(84581);
        }
    }

    /* renamed from: com.tencent.xweb.extension.video.d$16 */
    class C4112216 implements OnClickListener {

        /* renamed from: com.tencent.xweb.extension.video.d$16$1 */
        class C411211 implements ValueCallback<String> {
            C411211() {
            }

            public final /* bridge */ /* synthetic */ void onReceiveValue(Object obj) {
            }
        }

        C4112216() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(84591);
            C44584d.this.zxW.evaluateJavascript("xwebVideoBridge.xwebToJS_Video_Play();", new C411211());
            C44584d.this.dUr();
            AppMethodBeat.m2505o(84591);
        }
    }

    /* renamed from: com.tencent.xweb.extension.video.d$18 */
    class C4112318 extends TimerTask {
        C4112318() {
        }

        public final void run() {
            AppMethodBeat.m2504i(84593);
            C44584d.this.dUu();
            AppMethodBeat.m2505o(84593);
        }
    }

    /* renamed from: com.tencent.xweb.extension.video.d$20 */
    class C4112420 implements Runnable {
        C4112420() {
        }

        public final void run() {
            AppMethodBeat.m2504i(84595);
            C44584d.this.AOi = false;
            C44584d.this.ANL.setVisibility(4);
            AppMethodBeat.m2505o(84595);
        }
    }

    /* renamed from: com.tencent.xweb.extension.video.d$5 */
    class C411265 implements Runnable {
        C411265() {
        }

        public final void run() {
            AppMethodBeat.m2504i(84579);
            C44584d.this.ANH.setVisibility(8);
            AppMethodBeat.m2505o(84579);
        }
    }

    /* renamed from: com.tencent.xweb.extension.video.d$15 */
    class C4458515 implements OnClickListener {

        /* renamed from: com.tencent.xweb.extension.video.d$15$1 */
        class C411201 implements ValueCallback<String> {
            C411201() {
            }

            public final /* bridge */ /* synthetic */ void onReceiveValue(Object obj) {
            }
        }

        C4458515() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(84590);
            C44584d.this.zxW.evaluateJavascript("xwebVideoBridge.xwebToJS_Video_ExitFullscreen();", new C411201());
            AppMethodBeat.m2505o(84590);
        }
    }

    /* renamed from: com.tencent.xweb.extension.video.d$17 */
    class C4458617 implements ValueCallback<String> {
        C4458617() {
        }

        public final /* synthetic */ void onReceiveValue(Object obj) {
            AppMethodBeat.m2504i(84592);
            ((String) obj).equals("1");
            AppMethodBeat.m2505o(84592);
        }
    }

    private Activity dUp() {
        AppMethodBeat.m2504i(84596);
        Activity activity;
        if (this.mActivity != null) {
            activity = this.mActivity;
            AppMethodBeat.m2505o(84596);
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
            Log.m81046e("XWebNativeInterface", "royle:tryGetActivity but no Activity");
        }
        AppMethodBeat.m2505o(84596);
        return activity;
    }

    /* renamed from: dh */
    public final void mo30115dh(Object obj) {
        AppMethodBeat.m2504i(84597);
        new ReflectMethod(obj, "addJavascriptInterface", Object.class, String.class).invoke(this, "xwebToNative");
        AppMethodBeat.m2505o(84597);
    }

    /* renamed from: am */
    public final void mo30114am(boolean z, boolean z2) {
        AppMethodBeat.m2504i(84598);
        if (!(this.zxW == null || !z2 || this.AOg == null)) {
            Log.m81049i("XWebNativeInterface", "evaluteJavascript:".concat(String.valueOf(z)));
            String str = this.AOg;
            if (z) {
                str = "window.addEventListener('DOMContentLoaded', function() {" + this.AOg + "});this.xwebReturn = function (){return \"1\";};this.xwebReturn()";
            }
            this.zxW.evaluateJavascript(str, new C4458617());
        }
        AppMethodBeat.m2505o(84598);
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
        AppMethodBeat.m2504i(84599);
        C24550c avu = C36602e.avu(XWalkEnvironment.XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO);
        Object inputStream2;
        if (avu == null || avu.ASG == -1) {
            i = -1;
            inputStream2 = str2;
        } else {
            int i2 = avu.ASG;
            File file = new File(avu.mo13331aM(avu.ASG, false));
            if (file.isFile() && file.exists()) {
                try {
                    InputStream fileInputStream = new FileInputStream(file);
                    i = i2;
                    inputStream2 = fileInputStream;
                } catch (FileNotFoundException e2) {
                    Log.m81046e("XWebNativeInterface", "initJs open jsFile error:" + e2.getMessage());
                    i = i2;
                    inputStream2 = str2;
                }
            } else {
                avu.mo41307SD(-1);
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
                        Log.m81046e("XWebNativeInterface", "initJs open jsFile error" + e.getMessage());
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
                        Log.m81049i("XWebNativeInterface", "use video js default ");
                        str = "this.xwebVideoBridge||(this.xwebVideoBridge=function(b,c){function d(a){a=a.target;var c=v(a);try{b.xwebToNative.onVideoTimeUpdate(a.currentTime,a.duration,c)}catch(t){}try{b.xwebToNative.onVideoSizeUpdate(a.videoWidth,a.videoHeight)}catch(t){}}function k(a){try{b.xwebToNative.onVideoPlay()}catch(e){}}function g(a){try{b.xwebToNative.onVideoPause()}catch(e){}}function f(a){try{b.xwebToNative.onVideoPlaying()}catch(e){}}function l(a){try{b.xwebToNative.onVideoWaiting()}catch(e){}}function n(a){try{b.xwebToNative.onVideoSeeking()}catch(e){}}\nfunction m(a){try{b.xwebToNative.onVideoSeeked()}catch(e){}}function v(a){for(var b=[],c=0;c<a.buffered.length;c++)b.push(a.buffered.start(c)),b.push(a.buffered.end(c));return b}var q,u,a=null,p=!0,r=!1;xwebVideoBridge.xwebToJS_Video_ExitFullscreen=function(){c&&c.webkitExitFullscreen();return\"1\"};xwebVideoBridge.xwebToJS_Video_Play=function(){a&&(a.paused?a.play():a.pause());return\"1\"};xwebVideoBridge.xwebToJS_Video_Seek=function(b){a&&(a.currentTime=b);return\"1\"};xwebVideoBridge.xwebToNative_Special_Video_EnterFullscreen=\nfunction(a){try{if(b.xwebToNative.onSpecialVideoEnterFullscreen)b.xwebToNative.onSpecialVideoEnterFullscreen(a)}catch(e){}};xwebVideoBridge.xwebToNative_Special_Video_Hook=function(a){try{b.xwebToNative.onSpecialVideoHook&&!r&&(b.xwebToNative.onSpecialVideoHook(a),r=!0)}catch(e){}};xwebVideoBridge.hookFullscreen=function(){xwebVideoBridge.xweb_webkitfullscreenchange||(xwebVideoBridge.xweb_webkitfullscreenchange=function(h){h=c;if(c.webkitFullscreenElement){(a=c.webkitFullscreenElement)&&\"IFRAME\"==\na.tagName&&(h=a.contentDocument,a=a.contentDocument.webkitFullscreenElement);p=!0;if(a&&\"VIDEO\"!=a.tagName){p=!1;var e=a.querySelectorAll(\"video\");e&&0<e.length&&(a=e[0])}if(a&&\"VIDEO\"==a.tagName){a.addEventListener(\"timeupdate\",d);a.addEventListener(\"play\",k);a.addEventListener(\"pause\",g);a.addEventListener(\"playing\",f);a.addEventListener(\"waiting\",l);a.addEventListener(\"seeking\",n);a.addEventListener(\"seeked\",m);e=a.videoWidth;var t=a.videoHeight;u=(new Date).valueOf();var r=v(a);try{b.xwebToNative.onVideoEnterFullscreen(p,\nu,e,t,a.paused,a.seeking,a.currentTime,a.duration,r)}catch(w){}p&&(e=h.getElementById(\"styles_js\"),e||(e=h.createElement(\"style\"),e.type=\"text/css\",e.id=\"styles_js\",h.getElementsByTagName(\"head\")[0].appendChild(e)),q=h.createTextNode(\"video::-webkit-media-controls {display: none!important;}\"),e.appendChild(q))}}else if(a){a.removeEventListener(\"timeupdate\",d);a.removeEventListener(\"play\",k);a.removeEventListener(\"pause\",g);a.removeEventListener(\"playing\",f);a.removeEventListener(\"waiting\",l);a.removeEventListener(\"seeking\",\nn);a.removeEventListener(\"seeked\",m);a=null;u=0;try{b.xwebToNative.onVideoExitFullscreen()}catch(w){}p&&(h=h.getElementById(\"styles_js\"))&&h.hasChildNodes(q)&&h.removeChild(q)}},c.addEventListener(\"webkitfullscreenchange\",xwebVideoBridge.xweb_webkitfullscreenchange))};return 1},this.xwebVideoBridge(this,document));this.xwebVideoBridge.hookFullscreen();function xweb_log_print(b){}\nthis.xweb_video_utils={ClickItemInfo:function(b,c,d,k,g,f,l,n,m){this.index=b;this.pattern=c;this.videoNode=d;this.fullsceenNode=k;this.parentLevel=g;this.cloneNode=f;this.event=l;this.iframe=n;this[\"continue\"]=void 0==m?!0:m},getClickMapInfo:function(b){var c=[new this.ClickItemInfo(0,/^https?:\\/\\/.*\\.qq\\.com/,\"video\",'button[class=\"txp_btn txp_btn_fullscreen\"]',7,!0,\"click\",\"\"),new this.ClickItemInfo(1,/^https?:\\/\\/.*\\.le\\.com/,\"video\",'div[class=\"hv_botbar_btn\"]',7,!0,\"click\",\"\"),new this.ClickItemInfo(2,\n/^https?:\\/\\/.*\\.bilibili\\.com/,'div[class=\"index__player__src-videoPage-player-\"]','i[class=\"player-icon icon-widescreen\"]',10,!1,\"click\",\"\"),new this.ClickItemInfo(3,/^https?:\\/\\/.*\\.acfun\\.cn/,'div[class=\"player\"]','div[class=\"controller-btn-fullscreen\"]',5,!0,\"click\",\"player\")],d=[];for(cinfo in c)if(c[cinfo].pattern.test(b)&&(d.push(c[cinfo]),!c[cinfo][\"continue\"]))break;return d},getNode:function(b,c){return c.constructor==String?b.querySelectorAll(c)[0]:c},getNodes:function(b,c){return b.constructor==\nString?void 0!=c&&\"\"!=c?(iDoc=document.getElementById(c),null==iDoc?b:iDoc.contentWindow.document.querySelectorAll(b)):document.querySelectorAll(b):b},registerForFullscreen:function(b,c){var d;function k(b,c){xweb_log_print(\"enterFullscreen\");for(var d=b,a=0;a<c.parentLevel&&null!=d.parentElement;++a)d=d.parentElement;d=xweb_video_utils.getNode(d,c.videoNode);void 0!=d&&d.webkitRequestFullscreen&&(xweb_log_print(\"requestFullscreen\"),d.webkitRequestFullscreen(),this.xwebVideoBridge.xwebToNative_Special_Video_EnterFullscreen(c.index))}\nfunction g(b,c){null==document.webkitFullscreenElement?k(b,c):(xweb_log_print(\"webkitExitFullscreen\"),document.webkitExitFullscreen())}function f(d){xweb_log_print(\"handleClick\");g(b,c)}function l(b){xweb_log_print(\"touchstart\");d=b.changedTouches[0].clientX;m=b.changedTouches[0].clientY}function n(f){xweb_log_print(\"touchend\");5>Math.abs(d-f.changedTouches[0].clientX)&&5>Math.abs(m-f.changedTouches[0].clientY)&&g(b,c)}var m=d=void 0;if(void 0==b.clickishook||1!=b.clickishook)\"click\"==c.event&&(b.addEventListener(\"click\",\nf),b.clickishook=!0),\"touch\"==c.event&&(b.addEventListener(\"touchstart\",l),b.addEventListener(\"touchend\",n),b.clickishook=!0),window.xwebVideoBridge.xwebToNative_Special_Video_Hook(c.index)}};kMaxTry=10;\nwindow.xweb_register_fullscreen_detect_function=function(){xweb_log_print(\"xweb_register_fullscreen_detect_function\");var b=xweb_video_utils.getClickMapInfo(location.href);if(void 0==b||0==b.length)xweb_log_print(\"we not support the url:\"+location.href);else{xweb_log_print(\"we support the url:\"+location.href+\", clickInfos.length= \"+b.length);for(cinfo in b){var c=b[cinfo],d=xweb_video_utils.getNodes(c.fullsceenNode,c.iframe);xweb_log_print(\"try to find  all video node for fullscreenNodes \"+d+\", length = \"+\nd.length);for(var k=0;k<d.length;++k){try{var g=d.item(k)}catch(n){break}if(c.cloneNode){var f=g.cloneNode(!0);g.parentNode.replaceChild(f,g);g=f}f=g;xweb_log_print(\"try to find video node for fullscreenNode \"+g);for(var l=0;l<c.parentLevel&&null!=f.parentElement;++l)f=f.parentElement;f=xweb_video_utils.getNode(f,c.videoNode);void 0!=f&&void 0!=g&&(xweb_log_print(\"find videoNode = \"+f+\", fullscreenNode =\"+g),xweb_video_utils.registerForFullscreen(g,c),kMaxTry=0)}}0<--kMaxTry&&(xweb_log_print(\"not found the target node, sleep 300ms for next find this = \"+\nthis),window.setTimeout(window.xweb_register_fullscreen_detect_function,600))}};this.detect||(window.setTimeout(window.xweb_register_fullscreen_detect_function,600),this.detect=!0);\nvar MutationObserver=window.MutationObserver||window.WebKitMutationObserver||window.MozMutationObserver,observer=new MutationObserver(function(b){b.forEach(function(b){b.addedNodes.forEach(function(b){b.querySelector&&void 0!=b.querySelector(\"video\")&&window.xweb_register_fullscreen_detect_function()})})}),config={subtree:!0,childList:!0};observer.observe(document.body,config);";
                        C24532f.dVv();
                        AppMethodBeat.m2505o(84599);
                        return str;
                    } catch (Throwable th2) {
                        th = th2;
                        if (inputStreamReader != null) {
                            try {
                                inputStreamReader.close();
                            } catch (Exception e7) {
                                AppMethodBeat.m2505o(84599);
                                throw th;
                            }
                        }
                        if (obj2 != null) {
                            obj2.close();
                        }
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        AppMethodBeat.m2505o(84599);
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
                    AppMethodBeat.m2505o(84599);
                    throw th;
                }
            } catch (IOException e8) {
                e = e8;
                Object obj3 = str2;
                obj2 = str2;
                Log.m81046e("XWebNativeInterface", "initJs open jsFile error" + e.getMessage());
                if (inputStreamReader != null) {
                }
                if (obj2 != null) {
                }
                if (inputStream2 != null) {
                }
                str = str2;
                if (str != null) {
                }
                Log.m81049i("XWebNativeInterface", "use video js default ");
                str = "this.xwebVideoBridge||(this.xwebVideoBridge=function(b,c){function d(a){a=a.target;var c=v(a);try{b.xwebToNative.onVideoTimeUpdate(a.currentTime,a.duration,c)}catch(t){}try{b.xwebToNative.onVideoSizeUpdate(a.videoWidth,a.videoHeight)}catch(t){}}function k(a){try{b.xwebToNative.onVideoPlay()}catch(e){}}function g(a){try{b.xwebToNative.onVideoPause()}catch(e){}}function f(a){try{b.xwebToNative.onVideoPlaying()}catch(e){}}function l(a){try{b.xwebToNative.onVideoWaiting()}catch(e){}}function n(a){try{b.xwebToNative.onVideoSeeking()}catch(e){}}\nfunction m(a){try{b.xwebToNative.onVideoSeeked()}catch(e){}}function v(a){for(var b=[],c=0;c<a.buffered.length;c++)b.push(a.buffered.start(c)),b.push(a.buffered.end(c));return b}var q,u,a=null,p=!0,r=!1;xwebVideoBridge.xwebToJS_Video_ExitFullscreen=function(){c&&c.webkitExitFullscreen();return\"1\"};xwebVideoBridge.xwebToJS_Video_Play=function(){a&&(a.paused?a.play():a.pause());return\"1\"};xwebVideoBridge.xwebToJS_Video_Seek=function(b){a&&(a.currentTime=b);return\"1\"};xwebVideoBridge.xwebToNative_Special_Video_EnterFullscreen=\nfunction(a){try{if(b.xwebToNative.onSpecialVideoEnterFullscreen)b.xwebToNative.onSpecialVideoEnterFullscreen(a)}catch(e){}};xwebVideoBridge.xwebToNative_Special_Video_Hook=function(a){try{b.xwebToNative.onSpecialVideoHook&&!r&&(b.xwebToNative.onSpecialVideoHook(a),r=!0)}catch(e){}};xwebVideoBridge.hookFullscreen=function(){xwebVideoBridge.xweb_webkitfullscreenchange||(xwebVideoBridge.xweb_webkitfullscreenchange=function(h){h=c;if(c.webkitFullscreenElement){(a=c.webkitFullscreenElement)&&\"IFRAME\"==\na.tagName&&(h=a.contentDocument,a=a.contentDocument.webkitFullscreenElement);p=!0;if(a&&\"VIDEO\"!=a.tagName){p=!1;var e=a.querySelectorAll(\"video\");e&&0<e.length&&(a=e[0])}if(a&&\"VIDEO\"==a.tagName){a.addEventListener(\"timeupdate\",d);a.addEventListener(\"play\",k);a.addEventListener(\"pause\",g);a.addEventListener(\"playing\",f);a.addEventListener(\"waiting\",l);a.addEventListener(\"seeking\",n);a.addEventListener(\"seeked\",m);e=a.videoWidth;var t=a.videoHeight;u=(new Date).valueOf();var r=v(a);try{b.xwebToNative.onVideoEnterFullscreen(p,\nu,e,t,a.paused,a.seeking,a.currentTime,a.duration,r)}catch(w){}p&&(e=h.getElementById(\"styles_js\"),e||(e=h.createElement(\"style\"),e.type=\"text/css\",e.id=\"styles_js\",h.getElementsByTagName(\"head\")[0].appendChild(e)),q=h.createTextNode(\"video::-webkit-media-controls {display: none!important;}\"),e.appendChild(q))}}else if(a){a.removeEventListener(\"timeupdate\",d);a.removeEventListener(\"play\",k);a.removeEventListener(\"pause\",g);a.removeEventListener(\"playing\",f);a.removeEventListener(\"waiting\",l);a.removeEventListener(\"seeking\",\nn);a.removeEventListener(\"seeked\",m);a=null;u=0;try{b.xwebToNative.onVideoExitFullscreen()}catch(w){}p&&(h=h.getElementById(\"styles_js\"))&&h.hasChildNodes(q)&&h.removeChild(q)}},c.addEventListener(\"webkitfullscreenchange\",xwebVideoBridge.xweb_webkitfullscreenchange))};return 1},this.xwebVideoBridge(this,document));this.xwebVideoBridge.hookFullscreen();function xweb_log_print(b){}\nthis.xweb_video_utils={ClickItemInfo:function(b,c,d,k,g,f,l,n,m){this.index=b;this.pattern=c;this.videoNode=d;this.fullsceenNode=k;this.parentLevel=g;this.cloneNode=f;this.event=l;this.iframe=n;this[\"continue\"]=void 0==m?!0:m},getClickMapInfo:function(b){var c=[new this.ClickItemInfo(0,/^https?:\\/\\/.*\\.qq\\.com/,\"video\",'button[class=\"txp_btn txp_btn_fullscreen\"]',7,!0,\"click\",\"\"),new this.ClickItemInfo(1,/^https?:\\/\\/.*\\.le\\.com/,\"video\",'div[class=\"hv_botbar_btn\"]',7,!0,\"click\",\"\"),new this.ClickItemInfo(2,\n/^https?:\\/\\/.*\\.bilibili\\.com/,'div[class=\"index__player__src-videoPage-player-\"]','i[class=\"player-icon icon-widescreen\"]',10,!1,\"click\",\"\"),new this.ClickItemInfo(3,/^https?:\\/\\/.*\\.acfun\\.cn/,'div[class=\"player\"]','div[class=\"controller-btn-fullscreen\"]',5,!0,\"click\",\"player\")],d=[];for(cinfo in c)if(c[cinfo].pattern.test(b)&&(d.push(c[cinfo]),!c[cinfo][\"continue\"]))break;return d},getNode:function(b,c){return c.constructor==String?b.querySelectorAll(c)[0]:c},getNodes:function(b,c){return b.constructor==\nString?void 0!=c&&\"\"!=c?(iDoc=document.getElementById(c),null==iDoc?b:iDoc.contentWindow.document.querySelectorAll(b)):document.querySelectorAll(b):b},registerForFullscreen:function(b,c){var d;function k(b,c){xweb_log_print(\"enterFullscreen\");for(var d=b,a=0;a<c.parentLevel&&null!=d.parentElement;++a)d=d.parentElement;d=xweb_video_utils.getNode(d,c.videoNode);void 0!=d&&d.webkitRequestFullscreen&&(xweb_log_print(\"requestFullscreen\"),d.webkitRequestFullscreen(),this.xwebVideoBridge.xwebToNative_Special_Video_EnterFullscreen(c.index))}\nfunction g(b,c){null==document.webkitFullscreenElement?k(b,c):(xweb_log_print(\"webkitExitFullscreen\"),document.webkitExitFullscreen())}function f(d){xweb_log_print(\"handleClick\");g(b,c)}function l(b){xweb_log_print(\"touchstart\");d=b.changedTouches[0].clientX;m=b.changedTouches[0].clientY}function n(f){xweb_log_print(\"touchend\");5>Math.abs(d-f.changedTouches[0].clientX)&&5>Math.abs(m-f.changedTouches[0].clientY)&&g(b,c)}var m=d=void 0;if(void 0==b.clickishook||1!=b.clickishook)\"click\"==c.event&&(b.addEventListener(\"click\",\nf),b.clickishook=!0),\"touch\"==c.event&&(b.addEventListener(\"touchstart\",l),b.addEventListener(\"touchend\",n),b.clickishook=!0),window.xwebVideoBridge.xwebToNative_Special_Video_Hook(c.index)}};kMaxTry=10;\nwindow.xweb_register_fullscreen_detect_function=function(){xweb_log_print(\"xweb_register_fullscreen_detect_function\");var b=xweb_video_utils.getClickMapInfo(location.href);if(void 0==b||0==b.length)xweb_log_print(\"we not support the url:\"+location.href);else{xweb_log_print(\"we support the url:\"+location.href+\", clickInfos.length= \"+b.length);for(cinfo in b){var c=b[cinfo],d=xweb_video_utils.getNodes(c.fullsceenNode,c.iframe);xweb_log_print(\"try to find  all video node for fullscreenNodes \"+d+\", length = \"+\nd.length);for(var k=0;k<d.length;++k){try{var g=d.item(k)}catch(n){break}if(c.cloneNode){var f=g.cloneNode(!0);g.parentNode.replaceChild(f,g);g=f}f=g;xweb_log_print(\"try to find video node for fullscreenNode \"+g);for(var l=0;l<c.parentLevel&&null!=f.parentElement;++l)f=f.parentElement;f=xweb_video_utils.getNode(f,c.videoNode);void 0!=f&&void 0!=g&&(xweb_log_print(\"find videoNode = \"+f+\", fullscreenNode =\"+g),xweb_video_utils.registerForFullscreen(g,c),kMaxTry=0)}}0<--kMaxTry&&(xweb_log_print(\"not found the target node, sleep 300ms for next find this = \"+\nthis),window.setTimeout(window.xweb_register_fullscreen_detect_function,600))}};this.detect||(window.setTimeout(window.xweb_register_fullscreen_detect_function,600),this.detect=!0);\nvar MutationObserver=window.MutationObserver||window.WebKitMutationObserver||window.MozMutationObserver,observer=new MutationObserver(function(b){b.forEach(function(b){b.addedNodes.forEach(function(b){b.querySelector&&void 0!=b.querySelector(\"video\")&&window.xweb_register_fullscreen_detect_function()})})}),config={subtree:!0,childList:!0};observer.observe(document.body,config);";
                C24532f.dVv();
                AppMethodBeat.m2505o(84599);
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
                AppMethodBeat.m2505o(84599);
                throw th;
            }
        }
        str = str2;
        if (str != null || str.isEmpty()) {
            Log.m81049i("XWebNativeInterface", "use video js default ");
            str = "this.xwebVideoBridge||(this.xwebVideoBridge=function(b,c){function d(a){a=a.target;var c=v(a);try{b.xwebToNative.onVideoTimeUpdate(a.currentTime,a.duration,c)}catch(t){}try{b.xwebToNative.onVideoSizeUpdate(a.videoWidth,a.videoHeight)}catch(t){}}function k(a){try{b.xwebToNative.onVideoPlay()}catch(e){}}function g(a){try{b.xwebToNative.onVideoPause()}catch(e){}}function f(a){try{b.xwebToNative.onVideoPlaying()}catch(e){}}function l(a){try{b.xwebToNative.onVideoWaiting()}catch(e){}}function n(a){try{b.xwebToNative.onVideoSeeking()}catch(e){}}\nfunction m(a){try{b.xwebToNative.onVideoSeeked()}catch(e){}}function v(a){for(var b=[],c=0;c<a.buffered.length;c++)b.push(a.buffered.start(c)),b.push(a.buffered.end(c));return b}var q,u,a=null,p=!0,r=!1;xwebVideoBridge.xwebToJS_Video_ExitFullscreen=function(){c&&c.webkitExitFullscreen();return\"1\"};xwebVideoBridge.xwebToJS_Video_Play=function(){a&&(a.paused?a.play():a.pause());return\"1\"};xwebVideoBridge.xwebToJS_Video_Seek=function(b){a&&(a.currentTime=b);return\"1\"};xwebVideoBridge.xwebToNative_Special_Video_EnterFullscreen=\nfunction(a){try{if(b.xwebToNative.onSpecialVideoEnterFullscreen)b.xwebToNative.onSpecialVideoEnterFullscreen(a)}catch(e){}};xwebVideoBridge.xwebToNative_Special_Video_Hook=function(a){try{b.xwebToNative.onSpecialVideoHook&&!r&&(b.xwebToNative.onSpecialVideoHook(a),r=!0)}catch(e){}};xwebVideoBridge.hookFullscreen=function(){xwebVideoBridge.xweb_webkitfullscreenchange||(xwebVideoBridge.xweb_webkitfullscreenchange=function(h){h=c;if(c.webkitFullscreenElement){(a=c.webkitFullscreenElement)&&\"IFRAME\"==\na.tagName&&(h=a.contentDocument,a=a.contentDocument.webkitFullscreenElement);p=!0;if(a&&\"VIDEO\"!=a.tagName){p=!1;var e=a.querySelectorAll(\"video\");e&&0<e.length&&(a=e[0])}if(a&&\"VIDEO\"==a.tagName){a.addEventListener(\"timeupdate\",d);a.addEventListener(\"play\",k);a.addEventListener(\"pause\",g);a.addEventListener(\"playing\",f);a.addEventListener(\"waiting\",l);a.addEventListener(\"seeking\",n);a.addEventListener(\"seeked\",m);e=a.videoWidth;var t=a.videoHeight;u=(new Date).valueOf();var r=v(a);try{b.xwebToNative.onVideoEnterFullscreen(p,\nu,e,t,a.paused,a.seeking,a.currentTime,a.duration,r)}catch(w){}p&&(e=h.getElementById(\"styles_js\"),e||(e=h.createElement(\"style\"),e.type=\"text/css\",e.id=\"styles_js\",h.getElementsByTagName(\"head\")[0].appendChild(e)),q=h.createTextNode(\"video::-webkit-media-controls {display: none!important;}\"),e.appendChild(q))}}else if(a){a.removeEventListener(\"timeupdate\",d);a.removeEventListener(\"play\",k);a.removeEventListener(\"pause\",g);a.removeEventListener(\"playing\",f);a.removeEventListener(\"waiting\",l);a.removeEventListener(\"seeking\",\nn);a.removeEventListener(\"seeked\",m);a=null;u=0;try{b.xwebToNative.onVideoExitFullscreen()}catch(w){}p&&(h=h.getElementById(\"styles_js\"))&&h.hasChildNodes(q)&&h.removeChild(q)}},c.addEventListener(\"webkitfullscreenchange\",xwebVideoBridge.xweb_webkitfullscreenchange))};return 1},this.xwebVideoBridge(this,document));this.xwebVideoBridge.hookFullscreen();function xweb_log_print(b){}\nthis.xweb_video_utils={ClickItemInfo:function(b,c,d,k,g,f,l,n,m){this.index=b;this.pattern=c;this.videoNode=d;this.fullsceenNode=k;this.parentLevel=g;this.cloneNode=f;this.event=l;this.iframe=n;this[\"continue\"]=void 0==m?!0:m},getClickMapInfo:function(b){var c=[new this.ClickItemInfo(0,/^https?:\\/\\/.*\\.qq\\.com/,\"video\",'button[class=\"txp_btn txp_btn_fullscreen\"]',7,!0,\"click\",\"\"),new this.ClickItemInfo(1,/^https?:\\/\\/.*\\.le\\.com/,\"video\",'div[class=\"hv_botbar_btn\"]',7,!0,\"click\",\"\"),new this.ClickItemInfo(2,\n/^https?:\\/\\/.*\\.bilibili\\.com/,'div[class=\"index__player__src-videoPage-player-\"]','i[class=\"player-icon icon-widescreen\"]',10,!1,\"click\",\"\"),new this.ClickItemInfo(3,/^https?:\\/\\/.*\\.acfun\\.cn/,'div[class=\"player\"]','div[class=\"controller-btn-fullscreen\"]',5,!0,\"click\",\"player\")],d=[];for(cinfo in c)if(c[cinfo].pattern.test(b)&&(d.push(c[cinfo]),!c[cinfo][\"continue\"]))break;return d},getNode:function(b,c){return c.constructor==String?b.querySelectorAll(c)[0]:c},getNodes:function(b,c){return b.constructor==\nString?void 0!=c&&\"\"!=c?(iDoc=document.getElementById(c),null==iDoc?b:iDoc.contentWindow.document.querySelectorAll(b)):document.querySelectorAll(b):b},registerForFullscreen:function(b,c){var d;function k(b,c){xweb_log_print(\"enterFullscreen\");for(var d=b,a=0;a<c.parentLevel&&null!=d.parentElement;++a)d=d.parentElement;d=xweb_video_utils.getNode(d,c.videoNode);void 0!=d&&d.webkitRequestFullscreen&&(xweb_log_print(\"requestFullscreen\"),d.webkitRequestFullscreen(),this.xwebVideoBridge.xwebToNative_Special_Video_EnterFullscreen(c.index))}\nfunction g(b,c){null==document.webkitFullscreenElement?k(b,c):(xweb_log_print(\"webkitExitFullscreen\"),document.webkitExitFullscreen())}function f(d){xweb_log_print(\"handleClick\");g(b,c)}function l(b){xweb_log_print(\"touchstart\");d=b.changedTouches[0].clientX;m=b.changedTouches[0].clientY}function n(f){xweb_log_print(\"touchend\");5>Math.abs(d-f.changedTouches[0].clientX)&&5>Math.abs(m-f.changedTouches[0].clientY)&&g(b,c)}var m=d=void 0;if(void 0==b.clickishook||1!=b.clickishook)\"click\"==c.event&&(b.addEventListener(\"click\",\nf),b.clickishook=!0),\"touch\"==c.event&&(b.addEventListener(\"touchstart\",l),b.addEventListener(\"touchend\",n),b.clickishook=!0),window.xwebVideoBridge.xwebToNative_Special_Video_Hook(c.index)}};kMaxTry=10;\nwindow.xweb_register_fullscreen_detect_function=function(){xweb_log_print(\"xweb_register_fullscreen_detect_function\");var b=xweb_video_utils.getClickMapInfo(location.href);if(void 0==b||0==b.length)xweb_log_print(\"we not support the url:\"+location.href);else{xweb_log_print(\"we support the url:\"+location.href+\", clickInfos.length= \"+b.length);for(cinfo in b){var c=b[cinfo],d=xweb_video_utils.getNodes(c.fullsceenNode,c.iframe);xweb_log_print(\"try to find  all video node for fullscreenNodes \"+d+\", length = \"+\nd.length);for(var k=0;k<d.length;++k){try{var g=d.item(k)}catch(n){break}if(c.cloneNode){var f=g.cloneNode(!0);g.parentNode.replaceChild(f,g);g=f}f=g;xweb_log_print(\"try to find video node for fullscreenNode \"+g);for(var l=0;l<c.parentLevel&&null!=f.parentElement;++l)f=f.parentElement;f=xweb_video_utils.getNode(f,c.videoNode);void 0!=f&&void 0!=g&&(xweb_log_print(\"find videoNode = \"+f+\", fullscreenNode =\"+g),xweb_video_utils.registerForFullscreen(g,c),kMaxTry=0)}}0<--kMaxTry&&(xweb_log_print(\"not found the target node, sleep 300ms for next find this = \"+\nthis),window.setTimeout(window.xweb_register_fullscreen_detect_function,600))}};this.detect||(window.setTimeout(window.xweb_register_fullscreen_detect_function,600),this.detect=!0);\nvar MutationObserver=window.MutationObserver||window.WebKitMutationObserver||window.MozMutationObserver,observer=new MutationObserver(function(b){b.forEach(function(b){b.addedNodes.forEach(function(b){b.querySelector&&void 0!=b.querySelector(\"video\")&&window.xweb_register_fullscreen_detect_function()})})}),config={subtree:!0,childList:!0};observer.observe(document.body,config);";
            C24532f.dVv();
        } else {
            Log.m81049i("XWebNativeInterface", "use video js ver ".concat(String.valueOf(i)));
            C24532f.dVu();
        }
        AppMethodBeat.m2505o(84599);
        return str;
    }

    private void reset() {
        AppMethodBeat.m2504i(84600);
        if (this.euK == null) {
            this.euK = (AudioManager) this.zxW.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        }
        this.AOb = this.euK.getStreamMaxVolume(3);
        this.AOc = (double) this.euK.getStreamVolume(3);
        if (this.AOf == null) {
            this.AOf = new C24527a(this.zxW.getContext());
        }
        if (this.f17541Ti == null) {
            Activity dUp = dUp();
            if (dUp != null) {
                this.f17541Ti = dUp.getWindow();
            }
        }
        if (this.f17541Ti != null && this.auN == null) {
            this.auN = this.f17541Ti.getAttributes();
        }
        if (this.auN != null) {
            this.mBrightness = this.auN.screenBrightness;
            if (this.mBrightness == -1.0f) {
                try {
                    this.mBrightness = (float) (((double) System.getInt(this.zxW.getContext().getContentResolver(), "screen_brightness")) / 256.0d);
                    AppMethodBeat.m2505o(84600);
                    return;
                } catch (SettingNotFoundException e) {
                    Log.m81046e("XWebNativeInterface", "brightness get error:" + e.getMessage());
                }
            }
        }
        AppMethodBeat.m2505o(84600);
    }

    public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        AppMethodBeat.m2504i(84601);
        Log.m81049i("XWebNativeInterface", "onShowCustomView");
        this.ANE = view;
        this.ANQ = customViewCallback;
        if (this.ANE != null || this.zxW.isXWalkKernel()) {
            if (this.zxW.isXWalkKernel()) {
                C24532f.dUT();
            } else if (this.zxW.isSysKernel()) {
                C24532f.dUX();
            }
            Log.m81049i("XWebNativeInterface", "attach");
            if (this.AOq) {
                Log.m81049i("XWebNativeInterface", "attach has entered fullscreen");
            } else {
                Activity dUp = dUp();
                if (dUp != null) {
                    reset();
                    m80995rA(true);
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
                            SurfaceView fB = m80981fB(this.ANE);
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
                            this.odV.postDelayed(new C1638913(), (long) this.AOl);
                        }
                    }
                }
            }
        }
        this.zxW.requestFocus();
        AppMethodBeat.m2505o(84601);
    }

    public final void onHideCustomView() {
        AppMethodBeat.m2504i(84602);
        if (this.ANQ != null) {
            this.ANQ.onCustomViewHidden();
        }
        Log.m81049i("XWebNativeInterface", "detach");
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
                    AppMethodBeat.m2505o(84602);
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
                m80995rA(false);
                if (this.odV.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.odV.getParent()).removeView(this.odV);
                }
            }
            AppMethodBeat.m2505o(84602);
            return;
        }
        Log.m81049i("XWebNativeInterface", "detach has exited fullscreen");
        AppMethodBeat.m2505o(84602);
    }

    /* renamed from: aC */
    private void m80975aC(Runnable runnable) {
        AppMethodBeat.m2504i(84603);
        Activity dUp = dUp();
        if (dUp != null) {
            dUp.runOnUiThread(runnable);
            AppMethodBeat.m2505o(84603);
            return;
        }
        this.zxW.getView().post(runnable);
        AppMethodBeat.m2505o(84603);
    }

    public final void dUr() {
        AppMethodBeat.m2504i(84604);
        if (this.AOh != null) {
            this.AOh.cancel();
            this.AOh.purge();
            this.AOh = null;
        }
        this.AOh = new Timer();
        this.AOh.schedule(new C4112318(), 4000);
        AppMethodBeat.m2505o(84604);
    }

    public final void dUs() {
        AppMethodBeat.m2504i(84605);
        if (this.AOh != null) {
            this.AOh.cancel();
            this.AOh.purge();
            this.AOh = null;
        }
        AppMethodBeat.m2505o(84605);
    }

    public final boolean onDown(MotionEvent motionEvent) {
        this.AOj = 0;
        return true;
    }

    public final void onShowPress(MotionEvent motionEvent) {
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(84606);
        dUs();
        if (this.AOi) {
            dUu();
        } else {
            dUt();
        }
        AppMethodBeat.m2505o(84606);
        return true;
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        AppMethodBeat.m2504i(84607);
        if (motionEvent == null || motionEvent2 == null) {
            AppMethodBeat.m2505o(84607);
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
                    this.f17541Ti.setAttributes(this.auN);
                    this.ANG.setBrightProgress((int) (height * 100.0f));
                    this.ANG.show();
                    break;
                case 3:
                    width = motionEvent2.getX() - motionEvent.getX();
                    this.AOe = this.ANP.f17539Yn;
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
                    this.ANG.setVideoTimeProgress(C44584d.m80993q(ceil, this.idN) + "/" + C44584d.m80993q(this.idN, this.idN));
                    this.ANG.show();
                    this.AOk = ceil;
                    break;
            }
            AppMethodBeat.m2505o(84607);
        }
        return true;
    }

    public final void onLongPress(MotionEvent motionEvent) {
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        AppMethodBeat.m2504i(84608);
        if (this.mMode != 1 || this.ANE == null) {
            AppMethodBeat.m2505o(84608);
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
        AppMethodBeat.m2505o(84608);
        return true;
    }

    public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        return true;
    }

    public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
    }

    public final void dUt() {
        AppMethodBeat.m2504i(84609);
        m80975aC(new C3114219());
        AppMethodBeat.m2505o(84609);
    }

    public final void dUu() {
        AppMethodBeat.m2504i(84610);
        m80975aC(new C4112420());
        AppMethodBeat.m2505o(84610);
    }

    /* renamed from: rz */
    private void m80996rz(final boolean z) {
        AppMethodBeat.m2504i(84611);
        m80975aC(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(84576);
                if (z) {
                    C44584d.this.ANO.setImageResource(C25738R.drawable.a83);
                    AppMethodBeat.m2505o(84576);
                    return;
                }
                C44584d.this.ANO.setImageResource(C25738R.drawable.a85);
                AppMethodBeat.m2505o(84576);
            }
        });
        AppMethodBeat.m2505o(84611);
    }

    /* renamed from: f */
    public final void mo71397f(final double d, final boolean z) {
        AppMethodBeat.m2504i(84612);
        m80975aC(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(84577);
                if (z && C44584d.this.idN != 0.0d) {
                    C44584d.this.ANP.mo71392c((float) ((int) (100.0d * (d / C44584d.this.idN))), false);
                }
                C44584d.this.ANI.setText(C44584d.m80973a(C44584d.this, d));
                C44584d.this.ANJ.setText(C44584d.m80989n(C44584d.this));
                AppMethodBeat.m2505o(84577);
            }
        });
        AppMethodBeat.m2505o(84612);
    }

    /* renamed from: q */
    private static String m80993q(double d, double d2) {
        AppMethodBeat.m2504i(84613);
        String format = String.format("%02d", new Object[]{Integer.valueOf((int) (d / 3600.0d))});
        String format2 = String.format("%02d", new Object[]{Integer.valueOf(((int) (d % 3600.0d)) / 60)});
        String format3 = String.format("%02d", new Object[]{Integer.valueOf(((int) (d % 3600.0d)) % 60)});
        if (d2 > 3600.0d) {
            format = String.format("%s:%s:%s", new Object[]{format, format2, format3});
        } else {
            format = String.format("%s:%s", new Object[]{format2, format3});
        }
        AppMethodBeat.m2505o(84613);
        return format;
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void onVideoGetFrame(long j, double d, String str) {
        AppMethodBeat.m2504i(84614);
        if (j == this.ANT && this.AOk == d && str != null && str.startsWith("data:image/png;base64,")) {
            byte[] decode = Base64.decode(str.substring(22), 0);
            this.ANM.setImageBitmap(BitmapFactory.decodeByteArray(decode, 0, decode.length));
            this.ANM.setVisibility(0);
        }
        AppMethodBeat.m2505o(84614);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void onVideoPlaying() {
        AppMethodBeat.m2504i(84615);
        Log.m81049i("XWebNativeInterface", "onVideoPlaying");
        m80975aC(new C411265());
        AppMethodBeat.m2505o(84615);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void onVideoWaiting() {
        AppMethodBeat.m2504i(84616);
        Log.m81049i("XWebNativeInterface", "onVideoWaiting");
        m80975aC(new C311436());
        AppMethodBeat.m2505o(84616);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void onVideoSeeking() {
        AppMethodBeat.m2504i(84617);
        Log.m81049i("XWebNativeInterface", "onVideoSeeking");
        m80975aC(new C311447());
        AppMethodBeat.m2505o(84617);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void onVideoSeeked() {
        AppMethodBeat.m2504i(84618);
        Log.m81049i("XWebNativeInterface", "onVideoSeeked");
        m80975aC(new C163928());
        AppMethodBeat.m2505o(84618);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void onVideoPlay() {
        AppMethodBeat.m2504i(84619);
        Log.m81049i("XWebNativeInterface", "onVideoPlay");
        m80996rz(false);
        AppMethodBeat.m2505o(84619);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void onVideoPause() {
        AppMethodBeat.m2504i(84620);
        Log.m81049i("XWebNativeInterface", "onVideoPause");
        m80996rz(true);
        AppMethodBeat.m2505o(84620);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void onVideoEnterFullscreen(boolean z, long j, double d, double d2, boolean z2, boolean z3, double d3, double d4, double[] dArr) {
        AppMethodBeat.m2504i(84621);
        Log.m81049i("XWebNativeInterface", "onVideoEnterFullscreen:isVideoTag:" + z + ",width:" + d + ",height:" + d2 + ",pause:" + z2 + ",seeking:" + z3 + ",currentTime:" + d3 + ",duration:" + d4);
        if (this.zxW.isXWalkKernel()) {
            C24532f.dUU();
        } else if (this.zxW.isSysKernel()) {
            C24532f.dUY();
        }
        if (z) {
            if (this.zxW.isXWalkKernel()) {
                C24532f.dUV();
            } else if (this.zxW.isSysKernel()) {
                C24532f.dUZ();
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
        m80975aC(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(84583);
                if (z4) {
                    C44584d.this.ANF.setVisibility(0);
                }
                C44584d.this.mo71398ii((int) d5, (int) d6);
                AppMethodBeat.m2505o(84583);
            }
        });
        onVideoTimeUpdate(d3, d4, dArr);
        m80996rz(z2);
        AppMethodBeat.m2505o(84621);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void onVideoExitFullscreen() {
        AppMethodBeat.m2504i(84622);
        Log.m81049i("XWebNativeInterface", "onVideoExitFullscreen");
        this.ANS = false;
        m80975aC(new C3114110());
        AppMethodBeat.m2505o(84622);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void onVideoTimeUpdate(double d, final double d2, final double[] dArr) {
        AppMethodBeat.m2504i(84623);
        this.idN = d2;
        mo71397f(d, true);
        m80975aC(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(84578);
                C44583c l = C44584d.this.ANP;
                double d = d2;
                double[] dArr = dArr;
                double d2 = 0.0d;
                int i = 0;
                while (i < dArr.length) {
                    if (dArr.length > i + 1 && (dArr[i] / d) * 100.0d <= ((double) l.f17539Yn) && (dArr[i + 1] / d) * 100.0d > ((double) l.f17539Yn)) {
                        d2 = (dArr[i + 1] / d) * 100.0d;
                    }
                    i += 2;
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) l.hZC.getLayoutParams();
                layoutParams.width = (int) ((d2 / 100.0d) * ((double) l.qym.getWidth()));
                l.hZC.setLayoutParams(layoutParams);
                l.hZC.requestLayout();
                AppMethodBeat.m2505o(84578);
            }
        });
        AppMethodBeat.m2505o(84623);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void onVideoSizeUpdate(double d, double d2) {
        AppMethodBeat.m2504i(84624);
        if (!(this.ANV == d2 && this.ANU == d)) {
            this.ANU = d;
            this.ANV = d2;
            Log.m81049i("XWebNativeInterface", "onVideoSizeUpdate width:" + d + ", height:" + d2);
            final double d3 = d;
            final double d4 = d2;
            m80975aC(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(84585);
                    C44584d.this.mo71398ii((int) d3, (int) d4);
                    AppMethodBeat.m2505o(84585);
                }
            });
        }
        AppMethodBeat.m2505o(84624);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void onSpecialVideoEnterFullscreen(int i) {
        AppMethodBeat.m2504i(84625);
        Log.m81049i("XWebNativeInterface", "onSpecialVideoEnterFullscreen:".concat(String.valueOf(i)));
        C24532f.m38169aK(i, this.zxW.isXWalkKernel());
        AppMethodBeat.m2505o(84625);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void onSpecialVideoHook(int i) {
        AppMethodBeat.m2504i(84626);
        Log.m81049i("XWebNativeInterface", "onSpecialVideoHook:".concat(String.valueOf(i)));
        C24532f.m38170aL(i, this.zxW.isXWalkKernel());
        AppMethodBeat.m2505o(84626);
    }

    /* renamed from: fB */
    private SurfaceView m80981fB(View view) {
        AppMethodBeat.m2504i(84627);
        if (view instanceof SurfaceView) {
            SurfaceView surfaceView = (SurfaceView) view;
            AppMethodBeat.m2505o(84627);
            return surfaceView;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                SurfaceView fB = m80981fB(viewGroup.getChildAt(i));
                if (fB != null) {
                    AppMethodBeat.m2505o(84627);
                    return fB;
                }
            }
        }
        AppMethodBeat.m2505o(84627);
        return null;
    }

    public final boolean hasEnteredFullscreen() {
        return this.AOq;
    }

    /* renamed from: rA */
    private void m80995rA(boolean z) {
        AppMethodBeat.m2504i(84628);
        Activity dUp = dUp();
        if (dUp == null) {
            AppMethodBeat.m2505o(84628);
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
                AppMethodBeat.m2505o(84628);
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
        AppMethodBeat.m2505o(84628);
    }

    /* renamed from: ii */
    public final void mo71398ii(int i, int i2) {
        AppMethodBeat.m2504i(84629);
        Activity dUp = dUp();
        if (dUp == null) {
            AppMethodBeat.m2505o(84629);
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
        AppMethodBeat.m2505o(84629);
    }

    /* renamed from: n */
    static /* synthetic */ String m80989n(C44584d c44584d) {
        AppMethodBeat.m2504i(84631);
        String q = C44584d.m80993q(c44584d.idN, c44584d.idN);
        AppMethodBeat.m2505o(84631);
        return q;
    }
}
