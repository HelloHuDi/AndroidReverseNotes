package com.tencent.xweb;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebView.FindListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.xweb.c.h;
import com.tencent.xweb.c.i;
import com.tencent.xweb.c.j;
import com.tencent.xweb.c.k;
import com.tencent.xweb.util.e;
import com.tencent.xweb.util.f;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public class WebView extends FrameLayout implements h {
    static d AMM = d.WV_KIND_NONE;
    static String AMN = "";
    static com.tencent.xweb.x5.sdk.c AMT;
    h AMO;
    d AMQ;
    com.tencent.xweb.c.d AMS;
    private int AMU;
    public boolean isX5Kernel;
    OnLongClickListener zMt;

    public static class b {
        public String mExtra;
        public int mType = 0;
    }

    public enum d {
        WV_KIND_NONE,
        WV_KIND_CW,
        WV_KIND_X5,
        WV_KIND_SYS;

        static {
            AppMethodBeat.o(3846);
        }
    }

    public enum a {
        NOT_HOOK,
        HOOK_NOT_EVALUTE_JS,
        HOOK_EVALUTE_JS;

        static {
            AppMethodBeat.o(3843);
        }
    }

    public interface c {
        void BH();

        void onCoreInitFinished();
    }

    static {
        AppMethodBeat.i(3941);
        x.initInterface();
        AppMethodBeat.o(3941);
    }

    public static d getPreferedWebviewType(Context context, String str) {
        AppMethodBeat.i(3847);
        d preferedWebviewType = getPreferedWebviewType(context, d.WV_KIND_X5, str);
        AppMethodBeat.o(3847);
        return preferedWebviewType;
    }

    public static d getPreferedWebviewType(Context context, d dVar, String str) {
        AppMethodBeat.i(3848);
        if (AMM != d.WV_KIND_NONE) {
            dVar = AMM;
            AppMethodBeat.o(3848);
            return dVar;
        }
        XWalkEnvironment.init(context);
        if (XWalkEnvironment.isIaDevice()) {
            XWalkEnvironment.addXWalkInitializeLog("XWeb.getPreferedWebviewType", "x86 device use WV_KIND_SYS");
            f.nI(69);
            dVar = d.WV_KIND_SYS;
            AppMethodBeat.o(3848);
            return dVar;
        }
        boolean z;
        if (m.dTZ().avg(str) != d.WV_KIND_NONE) {
            z = true;
            dVar = m.dTZ().avg(str);
            XWalkEnvironment.addXWalkInitializeLog("XWeb.getPreferedWebviewType", "use hard code web type = ".concat(String.valueOf(dVar)));
        } else {
            if (a.auU(str) != d.WV_KIND_NONE) {
                dVar = a.auU(str);
                XWalkEnvironment.addXWalkInitializeLog("XWeb.getPreferedWebviewType", "module " + str + "use cmd web type = " + dVar);
            }
            z = false;
        }
        f.g(dVar);
        if (!z && dVar == d.WV_KIND_CW && XWalkEnvironment.getXWebInitArgs(XWalkEnvironment.XWALK_ENV_MAP_KEY_ISGPVERSION, false)) {
            dVar = d.WV_KIND_SYS;
            XWalkEnvironment.addXWalkInitializeLog("gp version  , use sys");
        }
        if (dVar == d.WV_KIND_CW && !XWalkEnvironment.hasAvailableVersion()) {
            dVar = d.WV_KIND_X5;
            XWalkEnvironment.addXWalkInitializeLog("xwalk is not available , use x5");
        }
        j.d(dVar);
        if (j.dUB().dUG()) {
            XWalkEnvironment.addXWalkInitializeLog("kind is match loadurlwatchdog switch to syskernal");
            dVar = d.WV_KIND_SYS;
        }
        AppMethodBeat.o(3848);
        return dVar;
    }

    public static void initWebviewCore(Context context, d dVar, String str, c cVar) {
        AppMethodBeat.i(3849);
        if (AMM != d.WV_KIND_NONE) {
            if (AMM != dVar) {
                Log.e("xweb.WebView", "invalid set webview kind to diffrent type");
            }
            AppMethodBeat.o(3849);
            return;
        }
        AMN = str;
        f.avn(str);
        if (str == null) {
            str = "";
        }
        XWalkEnvironment.init(context);
        m.jy(context);
        b(context, getPreferedWebviewType(context, dVar, str), cVar);
        AppMethodBeat.o(3849);
    }

    private static synchronized boolean b(Context context, d dVar, c cVar) {
        boolean a;
        synchronized (WebView.class) {
            AppMethodBeat.i(3850);
            a = a(context, dVar, cVar, true, false);
            AppMethodBeat.o(3850);
        }
        return a;
    }

    private static synchronized boolean a(Context context, d dVar, c cVar, boolean z, boolean z2) {
        boolean z3 = false;
        synchronized (WebView.class) {
            AppMethodBeat.i(3851);
            if (!a(dVar, context, cVar, z2) && z) {
                dVar = d.WV_KIND_NONE;
                d[] dVarArr = new d[]{d.WV_KIND_CW, d.WV_KIND_SYS, d.WV_KIND_X5};
                int i = 0;
                while (i < 3) {
                    if (dVarArr[i] != dVar && a(dVarArr[i], context, cVar, z2)) {
                        dVar = dVarArr[i];
                        break;
                    }
                    i++;
                }
            }
            AMM = dVar;
            if (d.WV_KIND_NONE == dVar) {
                f.dVj();
                Log.e("xweb.WebView", "_initWebviewCore finally failed type = ".concat(String.valueOf(dVar)));
                AppMethodBeat.o(3851);
            } else {
                XWalkEnvironment.addXWalkInitializeLog("init webview core type = " + dVar + ", sdk:190301,xweb apk ver:" + XWalkEnvironment.getAvailableVersion());
                AppMethodBeat.o(3851);
                z3 = true;
            }
        }
        return z3;
    }

    private static boolean a(d dVar, Context context, c cVar, boolean z) {
        boolean z2 = false;
        AppMethodBeat.i(3852);
        Log.i("xweb.WebView", "try to init webview core = ".concat(String.valueOf(dVar)));
        if (z || !com.tencent.xweb.c.c.c(dVar)) {
            com.tencent.xweb.c.c b = com.tencent.xweb.c.c.b("LOAD_CORE", dVar);
            b.dUx();
            try {
                com.tencent.xweb.c.k.a f = k.f(dVar);
                z2 = f.initWebviewCore(context, cVar);
                if (z2) {
                    b.dTR().ALS = f.getCookieManager();
                    c.ALU = f.getCookieSyncManager();
                    f.h(dVar);
                    b.dUy();
                } else {
                    XWalkEnvironment.addXWalkInitializeLog("xweb.WebView", "init webview failed type = ".concat(String.valueOf(dVar)));
                }
            } catch (Exception e) {
                XWalkEnvironment.addXWalkInitializeLog("xweb.WebView", "init webview got exception  type = " + dVar + ", err = " + e.getMessage());
                try {
                    XWalkEnvironment.addXWalkInitializeLog("xweb.WebView", "crash stack : " + android.util.Log.getStackTraceString(e));
                } catch (Exception e2) {
                }
                f.j(dVar);
            }
            AppMethodBeat.o(3852);
        } else {
            f.i(dVar);
            AppMethodBeat.o(3852);
        }
        return z2;
    }

    public static boolean hasInited() {
        AppMethodBeat.i(3853);
        if (getCurWebType() == d.WV_KIND_NONE) {
            AppMethodBeat.o(3853);
            return false;
        } else if (k.f(getCurWebType()) == null) {
            AppMethodBeat.o(3853);
            return false;
        } else {
            boolean hasInited = k.f(getCurWebType()).hasInited();
            AppMethodBeat.o(3853);
            return hasInited;
        }
    }

    public static d getCurWebType() {
        return AMM;
    }

    public d getWebCoreType() {
        return this.AMQ;
    }

    public static String getCurStrModule() {
        return AMN;
    }

    public WebView(Context context) {
        this(context, null);
    }

    public WebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WebView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, 0, d.WV_KIND_NONE);
    }

    public WebView(Context context, AttributeSet attributeSet, int i, d dVar) {
        if (context instanceof MutableContextWrapper) {
            context = new MutableContextWrapper(((MutableContextWrapper) context).getBaseContext()) {
                public final void setBaseContext(Context context) {
                    AppMethodBeat.i(3839);
                    super.setBaseContext(context);
                    m.dTZ();
                    AppMethodBeat.o(3839);
                }
            };
        }
        super(context, attributeSet, i);
        AppMethodBeat.i(3854);
        this.AMQ = d.WV_KIND_NONE;
        this.isX5Kernel = false;
        this.AMU = -1;
        b(dVar);
        AppMethodBeat.o(3854);
    }

    /* Access modifiers changed, original: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        AppMethodBeat.i(3855);
        boolean drawChild = super.drawChild(canvas, view, j);
        AppMethodBeat.o(3855);
        return drawChild;
    }

    /* Access modifiers changed, original: protected */
    public void dispatchDraw(Canvas canvas) {
        AppMethodBeat.i(3856);
        super.dispatchDraw(canvas);
        AppMethodBeat.o(3856);
    }

    private void b(d dVar) {
        AppMethodBeat.i(3857);
        Log.i("xweb.WebView", "start to init, prefer type = " + getCurWebType() + " , forcetype = " + dVar);
        if (XWalkEnvironment.getApplicationContext() == null) {
            XWalkEnvironment.init(getContext());
        }
        if (this.AMQ != d.WV_KIND_NONE) {
            AppMethodBeat.o(3857);
            return;
        }
        if (getCurWebType() == d.WV_KIND_NONE) {
            b(getContext(), d.WV_KIND_SYS, null);
            Log.e("xweb.Webview", "use xweb without init, force to use sys web");
        }
        if (j.dUB().dUE()) {
            this.AMQ = d.WV_KIND_SYS;
            XWalkEnvironment.addXWalkInitializeLog("xweb.WebView", "isTestingSys, force to use sys web");
        } else if (dVar == d.WV_KIND_SYS) {
            this.AMQ = dVar;
        } else {
            this.AMQ = getCurWebType();
        }
        this.AMO = k.a(this.AMQ, this);
        if (this.AMO == null) {
            d[] dVarArr = new d[]{d.WV_KIND_CW, d.WV_KIND_SYS, d.WV_KIND_X5};
            int i = 0;
            while (i < 3) {
                if (dVarArr[i] != this.AMQ && b(getContext(), dVarArr[i], null)) {
                    this.AMO = k.a(dVarArr[i], this);
                    if (this.AMO != null) {
                        this.AMQ = getCurWebType();
                        break;
                    }
                }
                i++;
            }
        }
        if (this.AMO == null) {
            a(getContext(), d.WV_KIND_SYS, null, false, true);
            this.AMO = k.a(d.WV_KIND_SYS, this);
            this.AMQ = getCurWebType();
        }
        if (this.AMO == null) {
            Log.e("xweb.WebView", "init finally failed type = " + this.AMQ);
            f.dVk();
            AppMethodBeat.o(3857);
            return;
        }
        addView(this.AMO.getWebViewUI());
        if (this.AMQ != d.WV_KIND_X5) {
            Log.i("xweb.WebView", "this webview instance is using :" + this.AMQ);
        } else if (this.AMO.getX5WebViewExtension() != null) {
            this.isX5Kernel = true;
            Log.i("xweb.WebView", "this webview instance is using x5-x5kernal");
        } else {
            Log.i("xweb.WebView", "this webview instance is using x5-syskernal ");
        }
        if (this.AMO.getCurWebviewClient() != null) {
            this.AMO.getCurWebviewClient().AMp = this.AMO.getDefalutOpProvider();
        }
        if (this.AMO.getCurWebChromeClient() != null) {
            this.AMO.getCurWebChromeClient().AMp = this.AMO.getDefalutOpProvider();
        }
        this.AMO.getView().setOnLongClickListener(new OnLongClickListener() {
            public final boolean onLongClick(View view) {
                AppMethodBeat.i(3840);
                if (WebView.this.zMt != null) {
                    boolean onLongClick = WebView.this.zMt.onLongClick(WebView.this);
                    AppMethodBeat.o(3840);
                    return onLongClick;
                }
                AppMethodBeat.o(3840);
                return false;
            }
        });
        try {
            this.AMS = (com.tencent.xweb.c.d) k.f(d.WV_KIND_CW).excute("STR_CMD_GET_DEBUG_VIEW", new Object[]{this});
            this.AMS.dUl();
        } catch (Exception e) {
            Log.e("xweb.WebView", "create IDebugView failed, use dummy one ");
            this.AMS = new com.tencent.xweb.c.d() {
                public final boolean avh(String str) {
                    return false;
                }

                public final void dUl() {
                }
            };
        }
        if (getWebCoreType() == d.WV_KIND_CW) {
            String auZ = a.auZ(getCurStrModule());
            int auY = a.auY(getCurStrModule());
            if (this.AMO instanceof i) {
                ((i) this.AMO).eU(auZ, auY);
            }
        }
        getSettings().setUserAgentString(getSettings().getUserAgentString() + " MMWEBID/" + XWalkEnvironment.getGrayValue());
        AppMethodBeat.o(3857);
    }

    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        this.zMt = onLongClickListener;
    }

    public Object getX5WebViewExtension() {
        AppMethodBeat.i(3858);
        Object x5WebViewExtension = this.AMO.getX5WebViewExtension();
        AppMethodBeat.o(3858);
        return x5WebViewExtension;
    }

    public void setWebViewClientExtension(com.tencent.xweb.x5.a.a.a.a.b bVar) {
        AppMethodBeat.i(3859);
        this.AMO.setWebViewClientExtension(bVar);
        AppMethodBeat.o(3859);
    }

    public boolean super_onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(3860);
        boolean super_onTouchEvent = this.AMO.super_onTouchEvent(motionEvent);
        AppMethodBeat.o(3860);
        return super_onTouchEvent;
    }

    public boolean super_onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(3861);
        boolean super_onInterceptTouchEvent = this.AMO.super_onInterceptTouchEvent(motionEvent);
        AppMethodBeat.o(3861);
        return super_onInterceptTouchEvent;
    }

    public void super_onOverScrolled(int i, int i2, boolean z, boolean z2) {
        AppMethodBeat.i(3862);
        this.AMO.super_onOverScrolled(i, i2, z, z2);
        AppMethodBeat.o(3862);
    }

    public boolean super_dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(3863);
        boolean super_dispatchTouchEvent = this.AMO.super_dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(3863);
        return super_dispatchTouchEvent;
    }

    public void super_computeScroll() {
        AppMethodBeat.i(3864);
        this.AMO.super_computeScroll();
        AppMethodBeat.o(3864);
    }

    public void super_onScrollChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(3865);
        this.AMO.super_onScrollChanged(i, i2, i3, i4);
        AppMethodBeat.o(3865);
    }

    public boolean super_overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        AppMethodBeat.i(3866);
        boolean super_overScrollBy = this.AMO.super_overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
        AppMethodBeat.o(3866);
        return super_overScrollBy;
    }

    public void onResume() {
        AppMethodBeat.i(3867);
        this.AMO.onResume();
        AppMethodBeat.o(3867);
    }

    public void onPause() {
        AppMethodBeat.i(3868);
        this.AMO.onPause();
        AppMethodBeat.o(3868);
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        AppMethodBeat.i(3869);
        this.AMO.getWebViewUI().setOnTouchListener(onTouchListener);
        AppMethodBeat.o(3869);
    }

    public boolean isXWalkKernel() {
        return this.AMQ == d.WV_KIND_CW;
    }

    public boolean isSysKernel() {
        return this.AMQ == d.WV_KIND_SYS;
    }

    /* Access modifiers changed, original: protected */
    public void onVisibilityChanged(View view, int i) {
        AppMethodBeat.i(3870);
        super.onVisibilityChanged(view, i);
        if (this.AMO != null) {
            this.AMO.getView().setVisibility(i);
        }
        AppMethodBeat.o(3870);
    }

    public void drawCanvas(Canvas canvas) {
        AppMethodBeat.i(3871);
        if (isXWalkKernel()) {
            canvas.drawBitmap(getBitmap(), 0.0f, 0.0f, null);
            AppMethodBeat.o(3871);
            return;
        }
        draw(canvas);
        AppMethodBeat.o(3871);
    }

    public Bitmap getBitmap() {
        AppMethodBeat.i(3872);
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Config.ARGB_8888);
        if (createBitmap != null) {
            createBitmap.eraseColor(-1);
            Canvas canvas = new Canvas(createBitmap);
            if (isXWalkKernel()) {
                try {
                    Bitmap bitmap;
                    Paint paint = new Paint();
                    paint.setXfermode(new PorterDuffXfermode(Mode.SRC_OVER));
                    for (TextureView bitmap2 : fA(this)) {
                        bitmap = bitmap2.getBitmap();
                        if (bitmap != null) {
                            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
                        } else {
                            Log.e("xweb.WebView", "getBitmap textureViewBitmap = null");
                        }
                    }
                    bitmap = Bitmap.createBitmap(getWidth(), getHeight(), Config.ARGB_8888);
                    getTopView().draw(new Canvas(bitmap));
                    canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
                } catch (Exception e) {
                }
            } else {
                draw(canvas);
            }
        }
        AppMethodBeat.o(3872);
        return createBitmap;
    }

    private List<TextureView> fA(View view) {
        AppMethodBeat.i(3873);
        ArrayList arrayList = new ArrayList();
        if (view instanceof TextureView) {
            arrayList.add((TextureView) view);
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                arrayList.addAll(fA(viewGroup.getChildAt(i)));
            }
        }
        AppMethodBeat.o(3873);
        return arrayList;
    }

    public void setFocusable(boolean z) {
        AppMethodBeat.i(3874);
        if (z) {
            setDescendantFocusability(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
            super.setFocusable(false);
            AppMethodBeat.o(3874);
            return;
        }
        setDescendantFocusability(393216);
        super.setFocusable(false);
        AppMethodBeat.o(3874);
    }

    public void setFocusableInTouchMode(boolean z) {
        AppMethodBeat.i(3875);
        if (z) {
            setDescendantFocusability(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
            super.setFocusableInTouchMode(false);
            AppMethodBeat.o(3875);
            return;
        }
        setDescendantFocusability(393216);
        super.setFocusableInTouchMode(false);
        AppMethodBeat.o(3875);
    }

    public void onWebViewScrollChanged(int i, int i2, int i3, int i4) {
    }

    public View getView() {
        AppMethodBeat.i(3876);
        View view = this.AMO.getView();
        AppMethodBeat.o(3876);
        return view;
    }

    public ViewGroup getTopView() {
        AppMethodBeat.i(3877);
        ViewGroup topView = this.AMO.getTopView();
        AppMethodBeat.o(3877);
        return topView;
    }

    public String getUrl() {
        AppMethodBeat.i(3878);
        String url = this.AMO.getUrl();
        AppMethodBeat.o(3878);
        return url;
    }

    public void removeJavascriptInterface(String str) {
        AppMethodBeat.i(3879);
        this.AMO.removeJavascriptInterface(str);
        AppMethodBeat.o(3879);
    }

    public void stopLoading() {
        AppMethodBeat.i(3880);
        this.AMO.stopLoading();
        AppMethodBeat.o(3880);
    }

    public void setWebViewCallbackClient(r rVar) {
        AppMethodBeat.i(3881);
        this.AMO.setWebViewCallbackClient(rVar);
        AppMethodBeat.o(3881);
    }

    public b getHitTestResult() {
        AppMethodBeat.i(3882);
        b hitTestResult = this.AMO.getHitTestResult();
        AppMethodBeat.o(3882);
        return hitTestResult;
    }

    public String getTitle() {
        AppMethodBeat.i(3883);
        String title = this.AMO.getTitle();
        AppMethodBeat.o(3883);
        return title;
    }

    public void clearMatches() {
        AppMethodBeat.i(3884);
        this.AMO.clearMatches();
        AppMethodBeat.o(3884);
    }

    public void findNext(boolean z) {
        AppMethodBeat.i(3885);
        this.AMO.findNext(z);
        AppMethodBeat.o(3885);
    }

    public void findAllAsync(String str) {
        AppMethodBeat.i(3886);
        this.AMO.findAllAsync(str);
        AppMethodBeat.o(3886);
    }

    public String getVersionInfo() {
        AppMethodBeat.i(3887);
        String versionInfo = this.AMO.getVersionInfo();
        AppMethodBeat.o(3887);
        return versionInfo;
    }

    public String getAbstractInfo() {
        AppMethodBeat.i(3888);
        String abstractInfo = this.AMO.getAbstractInfo();
        AppMethodBeat.o(3888);
        return abstractInfo;
    }

    public s getCurWebviewClient() {
        AppMethodBeat.i(3889);
        s curWebviewClient = this.AMO.getCurWebviewClient();
        AppMethodBeat.o(3889);
        return curWebviewClient;
    }

    public l getCurWebChromeClient() {
        AppMethodBeat.i(3890);
        l curWebChromeClient = this.AMO.getCurWebChromeClient();
        AppMethodBeat.o(3890);
        return curWebChromeClient;
    }

    public boolean isSupportExtendPluginForAppbrand() {
        AppMethodBeat.i(3891);
        if (isXWalkKernel()) {
            boolean isSupportExtendPluginForAppbrand = this.AMO.isSupportExtendPluginForAppbrand();
            AppMethodBeat.o(3891);
            return isSupportExtendPluginForAppbrand;
        }
        AppMethodBeat.o(3891);
        return false;
    }

    public static void setX5Interface(com.tencent.xweb.x5.sdk.c cVar) {
        AMT = cVar;
    }

    public static int getUsingTbsCoreVersion(Context context) {
        AppMethodBeat.i(3892);
        if (AMM == d.WV_KIND_X5) {
            if (AMT != null) {
                int tbsCoreVersion = AMT.getTbsCoreVersion(context);
                AppMethodBeat.o(3892);
                return tbsCoreVersion;
            }
            Log.e("xweb.WebView", "getTbsCoreVersion: sImp is null");
        }
        AppMethodBeat.o(3892);
        return 0;
    }

    public static int getInstalledTbsCoreVersion(Context context) {
        AppMethodBeat.i(3893);
        if (AMT != null) {
            int tbsCoreVersion = AMT.getTbsCoreVersion(context);
            AppMethodBeat.o(3893);
            return tbsCoreVersion;
        }
        Log.e("xweb.WebView", "getTbsCoreVersion: sImp is null");
        AppMethodBeat.o(3893);
        return 0;
    }

    @Deprecated
    public static int getTbsCoreVersion(Context context) {
        AppMethodBeat.i(3894);
        if (AMT != null) {
            int tbsCoreVersion = AMT.getTbsCoreVersion(context);
            AppMethodBeat.o(3894);
            return tbsCoreVersion;
        }
        Log.e("xweb.WebView", "getTbsCoreVersion: sImp is null");
        AppMethodBeat.o(3894);
        return 0;
    }

    public static int getTbsSDKVersion(Context context) {
        AppMethodBeat.i(3895);
        if (AMT != null) {
            int tbsSDKVersion = AMT.getTbsSDKVersion(context);
            AppMethodBeat.o(3895);
            return tbsSDKVersion;
        }
        Log.e("xweb.WebView", "getTbsSDKVersion: sImp is null");
        AppMethodBeat.o(3895);
        return 0;
    }

    public static String getCrashExtraMessage(Context context) {
        AppMethodBeat.i(3896);
        String crashExtraMessage;
        if (AMT != null) {
            crashExtraMessage = AMT.getCrashExtraMessage(context);
            AppMethodBeat.o(3896);
            return crashExtraMessage;
        }
        Log.e("xweb.WebView", "getCrashExtraMessage: sImp is null");
        crashExtraMessage = "";
        AppMethodBeat.o(3896);
        return crashExtraMessage;
    }

    public static boolean getCanReboot() {
        AppMethodBeat.i(3897);
        if (getCurWebType() == d.WV_KIND_X5) {
            if (AMT != null) {
                boolean canReboot = AMT.getCanReboot();
                AppMethodBeat.o(3897);
                return canReboot;
            }
            Log.e("xweb.WebView", "getCanReboot: sImp is null");
        }
        if (j.dUB().dUF()) {
            AppMethodBeat.o(3897);
            return true;
        }
        AppMethodBeat.o(3897);
        return false;
    }

    public void reload() {
        AppMethodBeat.i(3898);
        this.AMO.reload();
        AppMethodBeat.o(3898);
    }

    public void clearSslPreferences() {
        AppMethodBeat.i(3899);
        this.AMO.clearSslPreferences();
        AppMethodBeat.o(3899);
    }

    public void loadData(String str, String str2, String str3) {
        AppMethodBeat.i(3900);
        this.AMO.loadData(str, str2, str3);
        f.avp(str);
        reportLoadByReason();
        AppMethodBeat.o(3900);
    }

    public int getContentHeight() {
        AppMethodBeat.i(3901);
        int contentHeight = this.AMO.getContentHeight();
        AppMethodBeat.o(3901);
        return contentHeight;
    }

    public float getScale() {
        AppMethodBeat.i(3902);
        float scale = this.AMO.getScale();
        AppMethodBeat.o(3902);
        return scale;
    }

    public int getWebScrollY() {
        AppMethodBeat.i(3903);
        int webScrollY = this.AMO.getWebScrollY();
        AppMethodBeat.o(3903);
        return webScrollY;
    }

    public int getWebScrollX() {
        AppMethodBeat.i(3904);
        int webScrollX = this.AMO.getWebScrollX();
        AppMethodBeat.o(3904);
        return webScrollX;
    }

    public boolean isOverScrollStart() {
        AppMethodBeat.i(3905);
        boolean isOverScrollStart = this.AMO.isOverScrollStart();
        AppMethodBeat.o(3905);
        return isOverScrollStart;
    }

    public int getVisibleTitleHeight() {
        AppMethodBeat.i(3906);
        int visibleTitleHeight = this.AMO.getVisibleTitleHeight();
        AppMethodBeat.o(3906);
        return visibleTitleHeight;
    }

    public boolean overlayHorizontalScrollbar() {
        AppMethodBeat.i(3907);
        boolean overlayHorizontalScrollbar = this.AMO.overlayHorizontalScrollbar();
        AppMethodBeat.o(3907);
        return overlayHorizontalScrollbar;
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(3908);
        this.AMO.loadDataWithBaseURL(str, str2, str3, str4, str5);
        f.avp(str);
        AppMethodBeat.o(3908);
    }

    public boolean zoomOut() {
        AppMethodBeat.i(3909);
        boolean zoomOut = this.AMO.zoomOut();
        AppMethodBeat.o(3909);
        return zoomOut;
    }

    public boolean zoomIn() {
        AppMethodBeat.i(3910);
        boolean zoomIn = this.AMO.zoomIn();
        AppMethodBeat.o(3910);
        return zoomIn;
    }

    @TargetApi(8)
    public void loadUrl(String str, Map<String, String> map) {
        AppMethodBeat.i(3911);
        if (this.AMS.avh(str)) {
            this.AMO.loadUrl("http://weixin.qq.com/");
            AppMethodBeat.o(3911);
            return;
        }
        this.AMO.loadUrl(str, map);
        f.avp(str);
        reportLoadByReason();
        AppMethodBeat.o(3911);
    }

    public void addJavascriptInterface(Object obj, String str) {
        AppMethodBeat.i(3912);
        this.AMO.addJavascriptInterface(obj, str);
        AppMethodBeat.o(3912);
    }

    public void _enablePlatformNotifications() {
    }

    public void _disablePlatformNotifications() {
    }

    @Deprecated
    public static void enablePlatformNotifications() {
        AppMethodBeat.i(3913);
        if (getCurWebType() == d.WV_KIND_SYS) {
            e.iJ("android.webkit.WebView", "enablePlatformNotifications");
        }
        AppMethodBeat.o(3913);
    }

    @Deprecated
    public static void disablePlatformNotifications() {
        AppMethodBeat.i(3914);
        if (getCurWebType() == d.WV_KIND_SYS) {
            e.iJ("android.webkit.WebView", "disablePlatformNotifications");
        }
        AppMethodBeat.o(3914);
    }

    public p getSettings() {
        AppMethodBeat.i(3915);
        p settings = this.AMO.getSettings();
        AppMethodBeat.o(3915);
        return settings;
    }

    public View getWebViewUI() {
        AppMethodBeat.i(3916);
        View webViewUI = this.AMO.getWebViewUI();
        AppMethodBeat.o(3916);
        return webViewUI;
    }

    public void setWebViewClient(s sVar) {
        AppMethodBeat.i(3917);
        if (sVar != null) {
            sVar.AMp = this.AMO.getDefalutOpProvider();
        }
        this.AMO.setWebViewClient(sVar);
        AppMethodBeat.o(3917);
    }

    public void setWebChromeClient(l lVar) {
        AppMethodBeat.i(3918);
        if (lVar != null) {
            lVar.AMp = this.AMO.getDefalutOpProvider();
        }
        this.AMO.setWebChromeClient(lVar);
        AppMethodBeat.o(3918);
    }

    public void setDownloadListener(DownloadListener downloadListener) {
        AppMethodBeat.i(3919);
        this.AMO.setDownloadListener(downloadListener);
        AppMethodBeat.o(3919);
    }

    public void setFindListener(FindListener findListener) {
        AppMethodBeat.i(3920);
        this.AMO.setFindListener(findListener);
        AppMethodBeat.o(3920);
    }

    public void loadUrl(String str) {
        AppMethodBeat.i(3921);
        if (this.AMS.avh(str)) {
            this.AMO.loadUrl("http://weixin.qq.com/");
            AppMethodBeat.o(3921);
            return;
        }
        this.AMO.loadUrl(str);
        f.avp(str);
        reportLoadByReason();
        AppMethodBeat.o(3921);
    }

    public boolean canGoBack() {
        AppMethodBeat.i(3922);
        boolean canGoBack = this.AMO.canGoBack();
        AppMethodBeat.o(3922);
        return canGoBack;
    }

    public void goBack() {
        AppMethodBeat.i(3923);
        this.AMO.goBack();
        AppMethodBeat.o(3923);
    }

    public void clearView() {
        AppMethodBeat.i(3924);
        this.AMO.clearView();
        AppMethodBeat.o(3924);
    }

    public void destroy() {
        AppMethodBeat.i(3925);
        this.AMO.destroy();
        AppMethodBeat.o(3925);
    }

    public boolean hasEnteredFullscreen() {
        AppMethodBeat.i(3926);
        boolean hasEnteredFullscreen = this.AMO.hasEnteredFullscreen();
        AppMethodBeat.o(3926);
        return hasEnteredFullscreen;
    }

    public void leaveFullscreen() {
        AppMethodBeat.i(3927);
        this.AMO.leaveFullscreen();
        AppMethodBeat.o(3927);
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(3928);
        this.AMO.evaluateJavascript(str, valueCallback);
        AppMethodBeat.o(3928);
    }

    public a getFullscreenVideoKind() {
        AppMethodBeat.i(3929);
        a fullscreenVideoKind = this.AMO.getFullscreenVideoKind();
        AppMethodBeat.o(3929);
        return fullscreenVideoKind;
    }

    public void setJSExceptionListener(t tVar) {
        AppMethodBeat.i(3930);
        this.AMO.setJSExceptionListener(tVar);
        AppMethodBeat.o(3930);
    }

    public boolean savePage(String str, String str2, int i) {
        AppMethodBeat.i(3931);
        boolean savePage = this.AMO.savePage(str, str2, i);
        AppMethodBeat.o(3931);
        return savePage;
    }

    public void clearHistory() {
        AppMethodBeat.i(3932);
        this.AMO.clearHistory();
        AppMethodBeat.o(3932);
    }

    public boolean canGoForward() {
        AppMethodBeat.i(3933);
        boolean canGoForward = this.AMO.canGoForward();
        AppMethodBeat.o(3933);
        return canGoForward;
    }

    public boolean supportFeature(int i) {
        AppMethodBeat.i(3934);
        boolean supportFeature = this.AMO.supportFeature(i);
        AppMethodBeat.o(3934);
        return supportFeature;
    }

    public com.tencent.xweb.c.b.a getCookieManager() {
        return null;
    }

    public com.tencent.xweb.c.b.b getCookieSyncManager() {
        return null;
    }

    public com.tencent.xweb.c.e getDefalutOpProvider() {
        return null;
    }

    public void setVerticalScrollBarEnabled(boolean z) {
        AppMethodBeat.i(3935);
        this.AMO.setVerticalScrollBarEnabled(z);
        AppMethodBeat.o(3935);
    }

    public void setHorizontalScrollBarEnabled(boolean z) {
        AppMethodBeat.i(3936);
        this.AMO.setHorizontalScrollBarEnabled(z);
        AppMethodBeat.o(3936);
    }

    public static boolean isXWalk() {
        AppMethodBeat.i(3937);
        if (getCurWebType() == d.WV_KIND_CW) {
            AppMethodBeat.o(3937);
            return true;
        }
        AppMethodBeat.o(3937);
        return false;
    }

    public static boolean isX5() {
        AppMethodBeat.i(3938);
        if (getCurWebType() == d.WV_KIND_X5) {
            AppMethodBeat.o(3938);
            return true;
        }
        AppMethodBeat.o(3938);
        return false;
    }

    public static boolean isSys() {
        AppMethodBeat.i(3939);
        if (getCurWebType() == d.WV_KIND_SYS) {
            AppMethodBeat.o(3939);
            return true;
        }
        AppMethodBeat.o(3939);
        return false;
    }

    public void setA8keyReason(int i) {
        this.AMU = i;
    }

    public void reportLoadByReason() {
        AppMethodBeat.i(3940);
        f.Sx(this.AMU);
        this.AMU = -1;
        AppMethodBeat.o(3940);
    }
}
