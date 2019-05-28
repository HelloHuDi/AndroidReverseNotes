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
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.xweb.p1115c.C24523c;
import com.tencent.xweb.p1115c.C24524e;
import com.tencent.xweb.p1115c.C31138d;
import com.tencent.xweb.p1115c.C41119i;
import com.tencent.xweb.p1115c.C44577b.C36584a;
import com.tencent.xweb.p1115c.C44577b.C36585b;
import com.tencent.xweb.p1115c.C44579j;
import com.tencent.xweb.p1115c.C44581k;
import com.tencent.xweb.p1115c.C44581k.C44580a;
import com.tencent.xweb.p1115c.C46832h;
import com.tencent.xweb.p685x5.p1116a.p1117a.p1118a.p1119a.C16404b;
import com.tencent.xweb.p685x5.sdk.C36599c;
import com.tencent.xweb.util.C24532f;
import com.tencent.xweb.util.C6038e;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public class WebView extends FrameLayout implements C46832h {
    static C44570d AMM = C44570d.WV_KIND_NONE;
    static String AMN = "";
    static C36599c AMT;
    C46832h AMO;
    C44570d AMQ;
    C31138d AMS;
    private int AMU;
    public boolean isX5Kernel;
    OnLongClickListener zMt;

    /* renamed from: com.tencent.xweb.WebView$2 */
    class C245212 implements OnLongClickListener {
        C245212() {
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.m2504i(3840);
            if (WebView.this.zMt != null) {
                boolean onLongClick = WebView.this.zMt.onLongClick(WebView.this);
                AppMethodBeat.m2505o(3840);
                return onLongClick;
            }
            AppMethodBeat.m2505o(3840);
            return false;
        }
    }

    /* renamed from: com.tencent.xweb.WebView$3 */
    class C245223 implements C31138d {
        C245223() {
        }

        public final boolean avh(String str) {
            return false;
        }

        public final void dUl() {
        }
    }

    /* renamed from: com.tencent.xweb.WebView$b */
    public static class C41116b {
        public String mExtra;
        public int mType = 0;
    }

    /* renamed from: com.tencent.xweb.WebView$d */
    public enum C44570d {
        WV_KIND_NONE,
        WV_KIND_CW,
        WV_KIND_X5,
        WV_KIND_SYS;

        static {
            AppMethodBeat.m2505o(3846);
        }
    }

    /* renamed from: com.tencent.xweb.WebView$a */
    public enum C46827a {
        NOT_HOOK,
        HOOK_NOT_EVALUTE_JS,
        HOOK_EVALUTE_JS;

        static {
            AppMethodBeat.m2505o(3843);
        }
    }

    /* renamed from: com.tencent.xweb.WebView$c */
    public interface C46828c {
        /* renamed from: BH */
        void mo4528BH();

        void onCoreInitFinished();
    }

    static {
        AppMethodBeat.m2504i(3941);
        C46838x.initInterface();
        AppMethodBeat.m2505o(3941);
    }

    public static C44570d getPreferedWebviewType(Context context, String str) {
        AppMethodBeat.m2504i(3847);
        C44570d preferedWebviewType = getPreferedWebviewType(context, C44570d.WV_KIND_X5, str);
        AppMethodBeat.m2505o(3847);
        return preferedWebviewType;
    }

    public static C44570d getPreferedWebviewType(Context context, C44570d c44570d, String str) {
        AppMethodBeat.m2504i(3848);
        if (AMM != C44570d.WV_KIND_NONE) {
            c44570d = AMM;
            AppMethodBeat.m2505o(3848);
            return c44570d;
        }
        XWalkEnvironment.init(context);
        if (XWalkEnvironment.isIaDevice()) {
            XWalkEnvironment.addXWalkInitializeLog("XWeb.getPreferedWebviewType", "x86 device use WV_KIND_SYS");
            C24532f.m38181nI(69);
            c44570d = C44570d.WV_KIND_SYS;
            AppMethodBeat.m2505o(3848);
            return c44570d;
        }
        boolean z;
        if (C31146m.dTZ().avg(str) != C44570d.WV_KIND_NONE) {
            z = true;
            c44570d = C31146m.dTZ().avg(str);
            XWalkEnvironment.addXWalkInitializeLog("XWeb.getPreferedWebviewType", "use hard code web type = ".concat(String.valueOf(c44570d)));
        } else {
            if (C44572a.auU(str) != C44570d.WV_KIND_NONE) {
                c44570d = C44572a.auU(str);
                XWalkEnvironment.addXWalkInitializeLog("XWeb.getPreferedWebviewType", "module " + str + "use cmd web type = " + c44570d);
            }
            z = false;
        }
        C24532f.m38174g(c44570d);
        if (!z && c44570d == C44570d.WV_KIND_CW && XWalkEnvironment.getXWebInitArgs(XWalkEnvironment.XWALK_ENV_MAP_KEY_ISGPVERSION, false)) {
            c44570d = C44570d.WV_KIND_SYS;
            XWalkEnvironment.addXWalkInitializeLog("gp version  , use sys");
        }
        if (c44570d == C44570d.WV_KIND_CW && !XWalkEnvironment.hasAvailableVersion()) {
            c44570d = C44570d.WV_KIND_X5;
            XWalkEnvironment.addXWalkInitializeLog("xwalk is not available , use x5");
        }
        C44579j.m80965d(c44570d);
        if (C44579j.dUB().dUG()) {
            XWalkEnvironment.addXWalkInitializeLog("kind is match loadurlwatchdog switch to syskernal");
            c44570d = C44570d.WV_KIND_SYS;
        }
        AppMethodBeat.m2505o(3848);
        return c44570d;
    }

    public static void initWebviewCore(Context context, C44570d c44570d, String str, C46828c c46828c) {
        AppMethodBeat.m2504i(3849);
        if (AMM != C44570d.WV_KIND_NONE) {
            if (AMM != c44570d) {
                Log.m81046e("xweb.WebView", "invalid set webview kind to diffrent type");
            }
            AppMethodBeat.m2505o(3849);
            return;
        }
        AMN = str;
        C24532f.avn(str);
        if (str == null) {
            str = "";
        }
        XWalkEnvironment.init(context);
        C31146m.m50231jy(context);
        m89789b(context, getPreferedWebviewType(context, c44570d, str), c46828c);
        AppMethodBeat.m2505o(3849);
    }

    /* renamed from: b */
    private static synchronized boolean m89789b(Context context, C44570d c44570d, C46828c c46828c) {
        boolean a;
        synchronized (WebView.class) {
            AppMethodBeat.m2504i(3850);
            a = m89786a(context, c44570d, c46828c, true, false);
            AppMethodBeat.m2505o(3850);
        }
        return a;
    }

    /* renamed from: a */
    private static synchronized boolean m89786a(Context context, C44570d c44570d, C46828c c46828c, boolean z, boolean z2) {
        boolean z3 = false;
        synchronized (WebView.class) {
            AppMethodBeat.m2504i(3851);
            if (!m89787a(c44570d, context, c46828c, z2) && z) {
                c44570d = C44570d.WV_KIND_NONE;
                C44570d[] c44570dArr = new C44570d[]{C44570d.WV_KIND_CW, C44570d.WV_KIND_SYS, C44570d.WV_KIND_X5};
                int i = 0;
                while (i < 3) {
                    if (c44570dArr[i] != c44570d && m89787a(c44570dArr[i], context, c46828c, z2)) {
                        c44570d = c44570dArr[i];
                        break;
                    }
                    i++;
                }
            }
            AMM = c44570d;
            if (C44570d.WV_KIND_NONE == c44570d) {
                C24532f.dVj();
                Log.m81046e("xweb.WebView", "_initWebviewCore finally failed type = ".concat(String.valueOf(c44570d)));
                AppMethodBeat.m2505o(3851);
            } else {
                XWalkEnvironment.addXWalkInitializeLog("init webview core type = " + c44570d + ", sdk:190301,xweb apk ver:" + XWalkEnvironment.getAvailableVersion());
                AppMethodBeat.m2505o(3851);
                z3 = true;
            }
        }
        return z3;
    }

    /* renamed from: a */
    private static boolean m89787a(C44570d c44570d, Context context, C46828c c46828c, boolean z) {
        boolean z2 = false;
        AppMethodBeat.m2504i(3852);
        Log.m81049i("xweb.WebView", "try to init webview core = ".concat(String.valueOf(c44570d)));
        if (z || !C24523c.m38151c(c44570d)) {
            C24523c b = C24523c.m38149b("LOAD_CORE", c44570d);
            b.dUx();
            try {
                C44580a f = C44581k.m80968f(c44570d);
                z2 = f.initWebviewCore(context, c46828c);
                if (z2) {
                    C44576b.dTR().ALS = f.getCookieManager();
                    C24526c.ALU = f.getCookieSyncManager();
                    C24532f.m38175h(c44570d);
                    b.dUy();
                } else {
                    XWalkEnvironment.addXWalkInitializeLog("xweb.WebView", "init webview failed type = ".concat(String.valueOf(c44570d)));
                }
            } catch (Exception e) {
                XWalkEnvironment.addXWalkInitializeLog("xweb.WebView", "init webview got exception  type = " + c44570d + ", err = " + e.getMessage());
                try {
                    XWalkEnvironment.addXWalkInitializeLog("xweb.WebView", "crash stack : " + android.util.Log.getStackTraceString(e));
                } catch (Exception e2) {
                }
                C24532f.m38178j(c44570d);
            }
            AppMethodBeat.m2505o(3852);
        } else {
            C24532f.m38176i(c44570d);
            AppMethodBeat.m2505o(3852);
        }
        return z2;
    }

    public static boolean hasInited() {
        AppMethodBeat.m2504i(3853);
        if (getCurWebType() == C44570d.WV_KIND_NONE) {
            AppMethodBeat.m2505o(3853);
            return false;
        } else if (C44581k.m80968f(getCurWebType()) == null) {
            AppMethodBeat.m2505o(3853);
            return false;
        } else {
            boolean hasInited = C44581k.m80968f(getCurWebType()).hasInited();
            AppMethodBeat.m2505o(3853);
            return hasInited;
        }
    }

    public static C44570d getCurWebType() {
        return AMM;
    }

    public C44570d getWebCoreType() {
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
        this(context, attributeSet, 0, C44570d.WV_KIND_NONE);
    }

    public WebView(Context context, AttributeSet attributeSet, int i, C44570d c44570d) {
        if (context instanceof MutableContextWrapper) {
            context = new MutableContextWrapper(((MutableContextWrapper) context).getBaseContext()) {
                public final void setBaseContext(Context context) {
                    AppMethodBeat.m2504i(3839);
                    super.setBaseContext(context);
                    C31146m.dTZ();
                    AppMethodBeat.m2505o(3839);
                }
            };
        }
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(3854);
        this.AMQ = C44570d.WV_KIND_NONE;
        this.isX5Kernel = false;
        this.AMU = -1;
        m89788b(c44570d);
        AppMethodBeat.m2505o(3854);
    }

    /* Access modifiers changed, original: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        AppMethodBeat.m2504i(3855);
        boolean drawChild = super.drawChild(canvas, view, j);
        AppMethodBeat.m2505o(3855);
        return drawChild;
    }

    /* Access modifiers changed, original: protected */
    public void dispatchDraw(Canvas canvas) {
        AppMethodBeat.m2504i(3856);
        super.dispatchDraw(canvas);
        AppMethodBeat.m2505o(3856);
    }

    /* renamed from: b */
    private void m89788b(C44570d c44570d) {
        AppMethodBeat.m2504i(3857);
        Log.m81049i("xweb.WebView", "start to init, prefer type = " + getCurWebType() + " , forcetype = " + c44570d);
        if (XWalkEnvironment.getApplicationContext() == null) {
            XWalkEnvironment.init(getContext());
        }
        if (this.AMQ != C44570d.WV_KIND_NONE) {
            AppMethodBeat.m2505o(3857);
            return;
        }
        if (getCurWebType() == C44570d.WV_KIND_NONE) {
            m89789b(getContext(), C44570d.WV_KIND_SYS, null);
            Log.m81046e("xweb.Webview", "use xweb without init, force to use sys web");
        }
        if (C44579j.dUB().dUE()) {
            this.AMQ = C44570d.WV_KIND_SYS;
            XWalkEnvironment.addXWalkInitializeLog("xweb.WebView", "isTestingSys, force to use sys web");
        } else if (c44570d == C44570d.WV_KIND_SYS) {
            this.AMQ = c44570d;
        } else {
            this.AMQ = getCurWebType();
        }
        this.AMO = C44581k.m80967a(this.AMQ, this);
        if (this.AMO == null) {
            C44570d[] c44570dArr = new C44570d[]{C44570d.WV_KIND_CW, C44570d.WV_KIND_SYS, C44570d.WV_KIND_X5};
            int i = 0;
            while (i < 3) {
                if (c44570dArr[i] != this.AMQ && m89789b(getContext(), c44570dArr[i], null)) {
                    this.AMO = C44581k.m80967a(c44570dArr[i], this);
                    if (this.AMO != null) {
                        this.AMQ = getCurWebType();
                        break;
                    }
                }
                i++;
            }
        }
        if (this.AMO == null) {
            m89786a(getContext(), C44570d.WV_KIND_SYS, null, false, true);
            this.AMO = C44581k.m80967a(C44570d.WV_KIND_SYS, this);
            this.AMQ = getCurWebType();
        }
        if (this.AMO == null) {
            Log.m81046e("xweb.WebView", "init finally failed type = " + this.AMQ);
            C24532f.dVk();
            AppMethodBeat.m2505o(3857);
            return;
        }
        addView(this.AMO.getWebViewUI());
        if (this.AMQ != C44570d.WV_KIND_X5) {
            Log.m81049i("xweb.WebView", "this webview instance is using :" + this.AMQ);
        } else if (this.AMO.getX5WebViewExtension() != null) {
            this.isX5Kernel = true;
            Log.m81049i("xweb.WebView", "this webview instance is using x5-x5kernal");
        } else {
            Log.m81049i("xweb.WebView", "this webview instance is using x5-syskernal ");
        }
        if (this.AMO.getCurWebviewClient() != null) {
            this.AMO.getCurWebviewClient().AMp = this.AMO.getDefalutOpProvider();
        }
        if (this.AMO.getCurWebChromeClient() != null) {
            this.AMO.getCurWebChromeClient().AMp = this.AMO.getDefalutOpProvider();
        }
        this.AMO.getView().setOnLongClickListener(new C245212());
        try {
            this.AMS = (C31138d) C44581k.m80968f(C44570d.WV_KIND_CW).excute("STR_CMD_GET_DEBUG_VIEW", new Object[]{this});
            this.AMS.dUl();
        } catch (Exception e) {
            Log.m81046e("xweb.WebView", "create IDebugView failed, use dummy one ");
            this.AMS = new C245223();
        }
        if (getWebCoreType() == C44570d.WV_KIND_CW) {
            String auZ = C44572a.auZ(getCurStrModule());
            int auY = C44572a.auY(getCurStrModule());
            if (this.AMO instanceof C41119i) {
                ((C41119i) this.AMO).mo13359eU(auZ, auY);
            }
        }
        getSettings().setUserAgentString(getSettings().getUserAgentString() + " MMWEBID/" + XWalkEnvironment.getGrayValue());
        AppMethodBeat.m2505o(3857);
    }

    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        this.zMt = onLongClickListener;
    }

    public Object getX5WebViewExtension() {
        AppMethodBeat.m2504i(3858);
        Object x5WebViewExtension = this.AMO.getX5WebViewExtension();
        AppMethodBeat.m2505o(3858);
        return x5WebViewExtension;
    }

    public void setWebViewClientExtension(C16404b c16404b) {
        AppMethodBeat.m2504i(3859);
        this.AMO.setWebViewClientExtension(c16404b);
        AppMethodBeat.m2505o(3859);
    }

    public boolean super_onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(3860);
        boolean super_onTouchEvent = this.AMO.super_onTouchEvent(motionEvent);
        AppMethodBeat.m2505o(3860);
        return super_onTouchEvent;
    }

    public boolean super_onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(3861);
        boolean super_onInterceptTouchEvent = this.AMO.super_onInterceptTouchEvent(motionEvent);
        AppMethodBeat.m2505o(3861);
        return super_onInterceptTouchEvent;
    }

    public void super_onOverScrolled(int i, int i2, boolean z, boolean z2) {
        AppMethodBeat.m2504i(3862);
        this.AMO.super_onOverScrolled(i, i2, z, z2);
        AppMethodBeat.m2505o(3862);
    }

    public boolean super_dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(3863);
        boolean super_dispatchTouchEvent = this.AMO.super_dispatchTouchEvent(motionEvent);
        AppMethodBeat.m2505o(3863);
        return super_dispatchTouchEvent;
    }

    public void super_computeScroll() {
        AppMethodBeat.m2504i(3864);
        this.AMO.super_computeScroll();
        AppMethodBeat.m2505o(3864);
    }

    public void super_onScrollChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(3865);
        this.AMO.super_onScrollChanged(i, i2, i3, i4);
        AppMethodBeat.m2505o(3865);
    }

    public boolean super_overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        AppMethodBeat.m2504i(3866);
        boolean super_overScrollBy = this.AMO.super_overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
        AppMethodBeat.m2505o(3866);
        return super_overScrollBy;
    }

    public void onResume() {
        AppMethodBeat.m2504i(3867);
        this.AMO.onResume();
        AppMethodBeat.m2505o(3867);
    }

    public void onPause() {
        AppMethodBeat.m2504i(3868);
        this.AMO.onPause();
        AppMethodBeat.m2505o(3868);
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        AppMethodBeat.m2504i(3869);
        this.AMO.getWebViewUI().setOnTouchListener(onTouchListener);
        AppMethodBeat.m2505o(3869);
    }

    public boolean isXWalkKernel() {
        return this.AMQ == C44570d.WV_KIND_CW;
    }

    public boolean isSysKernel() {
        return this.AMQ == C44570d.WV_KIND_SYS;
    }

    /* Access modifiers changed, original: protected */
    public void onVisibilityChanged(View view, int i) {
        AppMethodBeat.m2504i(3870);
        super.onVisibilityChanged(view, i);
        if (this.AMO != null) {
            this.AMO.getView().setVisibility(i);
        }
        AppMethodBeat.m2505o(3870);
    }

    public void drawCanvas(Canvas canvas) {
        AppMethodBeat.m2504i(3871);
        if (isXWalkKernel()) {
            canvas.drawBitmap(getBitmap(), 0.0f, 0.0f, null);
            AppMethodBeat.m2505o(3871);
            return;
        }
        draw(canvas);
        AppMethodBeat.m2505o(3871);
    }

    public Bitmap getBitmap() {
        AppMethodBeat.m2504i(3872);
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Config.ARGB_8888);
        if (createBitmap != null) {
            createBitmap.eraseColor(-1);
            Canvas canvas = new Canvas(createBitmap);
            if (isXWalkKernel()) {
                try {
                    Bitmap bitmap;
                    Paint paint = new Paint();
                    paint.setXfermode(new PorterDuffXfermode(Mode.SRC_OVER));
                    for (TextureView bitmap2 : m89790fA(this)) {
                        bitmap = bitmap2.getBitmap();
                        if (bitmap != null) {
                            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
                        } else {
                            Log.m81046e("xweb.WebView", "getBitmap textureViewBitmap = null");
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
        AppMethodBeat.m2505o(3872);
        return createBitmap;
    }

    /* renamed from: fA */
    private List<TextureView> m89790fA(View view) {
        AppMethodBeat.m2504i(3873);
        ArrayList arrayList = new ArrayList();
        if (view instanceof TextureView) {
            arrayList.add((TextureView) view);
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                arrayList.addAll(m89790fA(viewGroup.getChildAt(i)));
            }
        }
        AppMethodBeat.m2505o(3873);
        return arrayList;
    }

    public void setFocusable(boolean z) {
        AppMethodBeat.m2504i(3874);
        if (z) {
            setDescendantFocusability(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
            super.setFocusable(false);
            AppMethodBeat.m2505o(3874);
            return;
        }
        setDescendantFocusability(393216);
        super.setFocusable(false);
        AppMethodBeat.m2505o(3874);
    }

    public void setFocusableInTouchMode(boolean z) {
        AppMethodBeat.m2504i(3875);
        if (z) {
            setDescendantFocusability(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
            super.setFocusableInTouchMode(false);
            AppMethodBeat.m2505o(3875);
            return;
        }
        setDescendantFocusability(393216);
        super.setFocusableInTouchMode(false);
        AppMethodBeat.m2505o(3875);
    }

    public void onWebViewScrollChanged(int i, int i2, int i3, int i4) {
    }

    public View getView() {
        AppMethodBeat.m2504i(3876);
        View view = this.AMO.getView();
        AppMethodBeat.m2505o(3876);
        return view;
    }

    public ViewGroup getTopView() {
        AppMethodBeat.m2504i(3877);
        ViewGroup topView = this.AMO.getTopView();
        AppMethodBeat.m2505o(3877);
        return topView;
    }

    public String getUrl() {
        AppMethodBeat.m2504i(3878);
        String url = this.AMO.getUrl();
        AppMethodBeat.m2505o(3878);
        return url;
    }

    public void removeJavascriptInterface(String str) {
        AppMethodBeat.m2504i(3879);
        this.AMO.removeJavascriptInterface(str);
        AppMethodBeat.m2505o(3879);
    }

    public void stopLoading() {
        AppMethodBeat.m2504i(3880);
        this.AMO.stopLoading();
        AppMethodBeat.m2505o(3880);
    }

    public void setWebViewCallbackClient(C36591r c36591r) {
        AppMethodBeat.m2504i(3881);
        this.AMO.setWebViewCallbackClient(c36591r);
        AppMethodBeat.m2505o(3881);
    }

    public C41116b getHitTestResult() {
        AppMethodBeat.m2504i(3882);
        C41116b hitTestResult = this.AMO.getHitTestResult();
        AppMethodBeat.m2505o(3882);
        return hitTestResult;
    }

    public String getTitle() {
        AppMethodBeat.m2504i(3883);
        String title = this.AMO.getTitle();
        AppMethodBeat.m2505o(3883);
        return title;
    }

    public void clearMatches() {
        AppMethodBeat.m2504i(3884);
        this.AMO.clearMatches();
        AppMethodBeat.m2505o(3884);
    }

    public void findNext(boolean z) {
        AppMethodBeat.m2504i(3885);
        this.AMO.findNext(z);
        AppMethodBeat.m2505o(3885);
    }

    public void findAllAsync(String str) {
        AppMethodBeat.m2504i(3886);
        this.AMO.findAllAsync(str);
        AppMethodBeat.m2505o(3886);
    }

    public String getVersionInfo() {
        AppMethodBeat.m2504i(3887);
        String versionInfo = this.AMO.getVersionInfo();
        AppMethodBeat.m2505o(3887);
        return versionInfo;
    }

    public String getAbstractInfo() {
        AppMethodBeat.m2504i(3888);
        String abstractInfo = this.AMO.getAbstractInfo();
        AppMethodBeat.m2505o(3888);
        return abstractInfo;
    }

    public C36592s getCurWebviewClient() {
        AppMethodBeat.m2504i(3889);
        C36592s curWebviewClient = this.AMO.getCurWebviewClient();
        AppMethodBeat.m2505o(3889);
        return curWebviewClient;
    }

    public C6031l getCurWebChromeClient() {
        AppMethodBeat.m2504i(3890);
        C6031l curWebChromeClient = this.AMO.getCurWebChromeClient();
        AppMethodBeat.m2505o(3890);
        return curWebChromeClient;
    }

    public boolean isSupportExtendPluginForAppbrand() {
        AppMethodBeat.m2504i(3891);
        if (isXWalkKernel()) {
            boolean isSupportExtendPluginForAppbrand = this.AMO.isSupportExtendPluginForAppbrand();
            AppMethodBeat.m2505o(3891);
            return isSupportExtendPluginForAppbrand;
        }
        AppMethodBeat.m2505o(3891);
        return false;
    }

    public static void setX5Interface(C36599c c36599c) {
        AMT = c36599c;
    }

    public static int getUsingTbsCoreVersion(Context context) {
        AppMethodBeat.m2504i(3892);
        if (AMM == C44570d.WV_KIND_X5) {
            if (AMT != null) {
                int tbsCoreVersion = AMT.getTbsCoreVersion(context);
                AppMethodBeat.m2505o(3892);
                return tbsCoreVersion;
            }
            Log.m81046e("xweb.WebView", "getTbsCoreVersion: sImp is null");
        }
        AppMethodBeat.m2505o(3892);
        return 0;
    }

    public static int getInstalledTbsCoreVersion(Context context) {
        AppMethodBeat.m2504i(3893);
        if (AMT != null) {
            int tbsCoreVersion = AMT.getTbsCoreVersion(context);
            AppMethodBeat.m2505o(3893);
            return tbsCoreVersion;
        }
        Log.m81046e("xweb.WebView", "getTbsCoreVersion: sImp is null");
        AppMethodBeat.m2505o(3893);
        return 0;
    }

    @Deprecated
    public static int getTbsCoreVersion(Context context) {
        AppMethodBeat.m2504i(3894);
        if (AMT != null) {
            int tbsCoreVersion = AMT.getTbsCoreVersion(context);
            AppMethodBeat.m2505o(3894);
            return tbsCoreVersion;
        }
        Log.m81046e("xweb.WebView", "getTbsCoreVersion: sImp is null");
        AppMethodBeat.m2505o(3894);
        return 0;
    }

    public static int getTbsSDKVersion(Context context) {
        AppMethodBeat.m2504i(3895);
        if (AMT != null) {
            int tbsSDKVersion = AMT.getTbsSDKVersion(context);
            AppMethodBeat.m2505o(3895);
            return tbsSDKVersion;
        }
        Log.m81046e("xweb.WebView", "getTbsSDKVersion: sImp is null");
        AppMethodBeat.m2505o(3895);
        return 0;
    }

    public static String getCrashExtraMessage(Context context) {
        AppMethodBeat.m2504i(3896);
        String crashExtraMessage;
        if (AMT != null) {
            crashExtraMessage = AMT.getCrashExtraMessage(context);
            AppMethodBeat.m2505o(3896);
            return crashExtraMessage;
        }
        Log.m81046e("xweb.WebView", "getCrashExtraMessage: sImp is null");
        crashExtraMessage = "";
        AppMethodBeat.m2505o(3896);
        return crashExtraMessage;
    }

    public static boolean getCanReboot() {
        AppMethodBeat.m2504i(3897);
        if (getCurWebType() == C44570d.WV_KIND_X5) {
            if (AMT != null) {
                boolean canReboot = AMT.getCanReboot();
                AppMethodBeat.m2505o(3897);
                return canReboot;
            }
            Log.m81046e("xweb.WebView", "getCanReboot: sImp is null");
        }
        if (C44579j.dUB().dUF()) {
            AppMethodBeat.m2505o(3897);
            return true;
        }
        AppMethodBeat.m2505o(3897);
        return false;
    }

    public void reload() {
        AppMethodBeat.m2504i(3898);
        this.AMO.reload();
        AppMethodBeat.m2505o(3898);
    }

    public void clearSslPreferences() {
        AppMethodBeat.m2504i(3899);
        this.AMO.clearSslPreferences();
        AppMethodBeat.m2505o(3899);
    }

    public void loadData(String str, String str2, String str3) {
        AppMethodBeat.m2504i(3900);
        this.AMO.loadData(str, str2, str3);
        C24532f.avp(str);
        reportLoadByReason();
        AppMethodBeat.m2505o(3900);
    }

    public int getContentHeight() {
        AppMethodBeat.m2504i(3901);
        int contentHeight = this.AMO.getContentHeight();
        AppMethodBeat.m2505o(3901);
        return contentHeight;
    }

    public float getScale() {
        AppMethodBeat.m2504i(3902);
        float scale = this.AMO.getScale();
        AppMethodBeat.m2505o(3902);
        return scale;
    }

    public int getWebScrollY() {
        AppMethodBeat.m2504i(3903);
        int webScrollY = this.AMO.getWebScrollY();
        AppMethodBeat.m2505o(3903);
        return webScrollY;
    }

    public int getWebScrollX() {
        AppMethodBeat.m2504i(3904);
        int webScrollX = this.AMO.getWebScrollX();
        AppMethodBeat.m2505o(3904);
        return webScrollX;
    }

    public boolean isOverScrollStart() {
        AppMethodBeat.m2504i(3905);
        boolean isOverScrollStart = this.AMO.isOverScrollStart();
        AppMethodBeat.m2505o(3905);
        return isOverScrollStart;
    }

    public int getVisibleTitleHeight() {
        AppMethodBeat.m2504i(3906);
        int visibleTitleHeight = this.AMO.getVisibleTitleHeight();
        AppMethodBeat.m2505o(3906);
        return visibleTitleHeight;
    }

    public boolean overlayHorizontalScrollbar() {
        AppMethodBeat.m2504i(3907);
        boolean overlayHorizontalScrollbar = this.AMO.overlayHorizontalScrollbar();
        AppMethodBeat.m2505o(3907);
        return overlayHorizontalScrollbar;
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.m2504i(3908);
        this.AMO.loadDataWithBaseURL(str, str2, str3, str4, str5);
        C24532f.avp(str);
        AppMethodBeat.m2505o(3908);
    }

    public boolean zoomOut() {
        AppMethodBeat.m2504i(3909);
        boolean zoomOut = this.AMO.zoomOut();
        AppMethodBeat.m2505o(3909);
        return zoomOut;
    }

    public boolean zoomIn() {
        AppMethodBeat.m2504i(3910);
        boolean zoomIn = this.AMO.zoomIn();
        AppMethodBeat.m2505o(3910);
        return zoomIn;
    }

    @TargetApi(8)
    public void loadUrl(String str, Map<String, String> map) {
        AppMethodBeat.m2504i(3911);
        if (this.AMS.avh(str)) {
            this.AMO.loadUrl("http://weixin.qq.com/");
            AppMethodBeat.m2505o(3911);
            return;
        }
        this.AMO.loadUrl(str, map);
        C24532f.avp(str);
        reportLoadByReason();
        AppMethodBeat.m2505o(3911);
    }

    public void addJavascriptInterface(Object obj, String str) {
        AppMethodBeat.m2504i(3912);
        this.AMO.addJavascriptInterface(obj, str);
        AppMethodBeat.m2505o(3912);
    }

    public void _enablePlatformNotifications() {
    }

    public void _disablePlatformNotifications() {
    }

    @Deprecated
    public static void enablePlatformNotifications() {
        AppMethodBeat.m2504i(3913);
        if (getCurWebType() == C44570d.WV_KIND_SYS) {
            C6038e.m9509iJ("android.webkit.WebView", "enablePlatformNotifications");
        }
        AppMethodBeat.m2505o(3913);
    }

    @Deprecated
    public static void disablePlatformNotifications() {
        AppMethodBeat.m2504i(3914);
        if (getCurWebType() == C44570d.WV_KIND_SYS) {
            C6038e.m9509iJ("android.webkit.WebView", "disablePlatformNotifications");
        }
        AppMethodBeat.m2505o(3914);
    }

    public C36589p getSettings() {
        AppMethodBeat.m2504i(3915);
        C36589p settings = this.AMO.getSettings();
        AppMethodBeat.m2505o(3915);
        return settings;
    }

    public View getWebViewUI() {
        AppMethodBeat.m2504i(3916);
        View webViewUI = this.AMO.getWebViewUI();
        AppMethodBeat.m2505o(3916);
        return webViewUI;
    }

    public void setWebViewClient(C36592s c36592s) {
        AppMethodBeat.m2504i(3917);
        if (c36592s != null) {
            c36592s.AMp = this.AMO.getDefalutOpProvider();
        }
        this.AMO.setWebViewClient(c36592s);
        AppMethodBeat.m2505o(3917);
    }

    public void setWebChromeClient(C6031l c6031l) {
        AppMethodBeat.m2504i(3918);
        if (c6031l != null) {
            c6031l.AMp = this.AMO.getDefalutOpProvider();
        }
        this.AMO.setWebChromeClient(c6031l);
        AppMethodBeat.m2505o(3918);
    }

    public void setDownloadListener(DownloadListener downloadListener) {
        AppMethodBeat.m2504i(3919);
        this.AMO.setDownloadListener(downloadListener);
        AppMethodBeat.m2505o(3919);
    }

    public void setFindListener(FindListener findListener) {
        AppMethodBeat.m2504i(3920);
        this.AMO.setFindListener(findListener);
        AppMethodBeat.m2505o(3920);
    }

    public void loadUrl(String str) {
        AppMethodBeat.m2504i(3921);
        if (this.AMS.avh(str)) {
            this.AMO.loadUrl("http://weixin.qq.com/");
            AppMethodBeat.m2505o(3921);
            return;
        }
        this.AMO.loadUrl(str);
        C24532f.avp(str);
        reportLoadByReason();
        AppMethodBeat.m2505o(3921);
    }

    public boolean canGoBack() {
        AppMethodBeat.m2504i(3922);
        boolean canGoBack = this.AMO.canGoBack();
        AppMethodBeat.m2505o(3922);
        return canGoBack;
    }

    public void goBack() {
        AppMethodBeat.m2504i(3923);
        this.AMO.goBack();
        AppMethodBeat.m2505o(3923);
    }

    public void clearView() {
        AppMethodBeat.m2504i(3924);
        this.AMO.clearView();
        AppMethodBeat.m2505o(3924);
    }

    public void destroy() {
        AppMethodBeat.m2504i(3925);
        this.AMO.destroy();
        AppMethodBeat.m2505o(3925);
    }

    public boolean hasEnteredFullscreen() {
        AppMethodBeat.m2504i(3926);
        boolean hasEnteredFullscreen = this.AMO.hasEnteredFullscreen();
        AppMethodBeat.m2505o(3926);
        return hasEnteredFullscreen;
    }

    public void leaveFullscreen() {
        AppMethodBeat.m2504i(3927);
        this.AMO.leaveFullscreen();
        AppMethodBeat.m2505o(3927);
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.m2504i(3928);
        this.AMO.evaluateJavascript(str, valueCallback);
        AppMethodBeat.m2505o(3928);
    }

    public C46827a getFullscreenVideoKind() {
        AppMethodBeat.m2504i(3929);
        C46827a fullscreenVideoKind = this.AMO.getFullscreenVideoKind();
        AppMethodBeat.m2505o(3929);
        return fullscreenVideoKind;
    }

    public void setJSExceptionListener(C6035t c6035t) {
        AppMethodBeat.m2504i(3930);
        this.AMO.setJSExceptionListener(c6035t);
        AppMethodBeat.m2505o(3930);
    }

    public boolean savePage(String str, String str2, int i) {
        AppMethodBeat.m2504i(3931);
        boolean savePage = this.AMO.savePage(str, str2, i);
        AppMethodBeat.m2505o(3931);
        return savePage;
    }

    public void clearHistory() {
        AppMethodBeat.m2504i(3932);
        this.AMO.clearHistory();
        AppMethodBeat.m2505o(3932);
    }

    public boolean canGoForward() {
        AppMethodBeat.m2504i(3933);
        boolean canGoForward = this.AMO.canGoForward();
        AppMethodBeat.m2505o(3933);
        return canGoForward;
    }

    public boolean supportFeature(int i) {
        AppMethodBeat.m2504i(3934);
        boolean supportFeature = this.AMO.supportFeature(i);
        AppMethodBeat.m2505o(3934);
        return supportFeature;
    }

    public C36584a getCookieManager() {
        return null;
    }

    public C36585b getCookieSyncManager() {
        return null;
    }

    public C24524e getDefalutOpProvider() {
        return null;
    }

    public void setVerticalScrollBarEnabled(boolean z) {
        AppMethodBeat.m2504i(3935);
        this.AMO.setVerticalScrollBarEnabled(z);
        AppMethodBeat.m2505o(3935);
    }

    public void setHorizontalScrollBarEnabled(boolean z) {
        AppMethodBeat.m2504i(3936);
        this.AMO.setHorizontalScrollBarEnabled(z);
        AppMethodBeat.m2505o(3936);
    }

    public static boolean isXWalk() {
        AppMethodBeat.m2504i(3937);
        if (getCurWebType() == C44570d.WV_KIND_CW) {
            AppMethodBeat.m2505o(3937);
            return true;
        }
        AppMethodBeat.m2505o(3937);
        return false;
    }

    public static boolean isX5() {
        AppMethodBeat.m2504i(3938);
        if (getCurWebType() == C44570d.WV_KIND_X5) {
            AppMethodBeat.m2505o(3938);
            return true;
        }
        AppMethodBeat.m2505o(3938);
        return false;
    }

    public static boolean isSys() {
        AppMethodBeat.m2504i(3939);
        if (getCurWebType() == C44570d.WV_KIND_SYS) {
            AppMethodBeat.m2505o(3939);
            return true;
        }
        AppMethodBeat.m2505o(3939);
        return false;
    }

    public void setA8keyReason(int i) {
        this.AMU = i;
    }

    public void reportLoadByReason() {
        AppMethodBeat.m2504i(3940);
        C24532f.m38167Sx(this.AMU);
        this.AMU = -1;
        AppMethodBeat.m2505o(3940);
    }
}
