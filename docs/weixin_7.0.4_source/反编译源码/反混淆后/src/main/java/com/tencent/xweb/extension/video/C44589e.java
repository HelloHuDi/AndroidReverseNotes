package com.tencent.xweb.extension.video;

import android.app.Activity;
import android.content.Context;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.ScaleGestureDetector;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.extension.video.C44584d.C1638712;
import com.tencent.xweb.extension.video.C44584d.C1639014;
import com.tencent.xweb.extension.video.C44584d.C245291;
import com.tencent.xweb.extension.video.C44584d.C4112216;
import com.tencent.xweb.extension.video.C44584d.C4458515;
import dalvik.system.DexClassLoader;
import java.io.File;
import org.xwalk.core.Log;
import org.xwalk.core.ReflectMethod;
import org.xwalk.core.XWalkCoreWrapper;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.resource.XWalkContextWrapper;

/* renamed from: com.tencent.xweb.extension.video.e */
public final class C44589e {
    private static ClassLoader mClassLoader;

    /* renamed from: com.tencent.xweb.extension.video.e$a */
    public static class C16393a implements C24528b {
        ReflectMethod AOF;
        private ReflectMethod AOG;
        private ReflectMethod AOH;
        private ReflectMethod AOI;
        private Object AOJ;
        private ReflectMethod hasEnteredFullscreenMethod;
        private ReflectMethod onHideCustomViewMethod;

        public C16393a(Object obj) {
            AppMethodBeat.m2504i(84632);
            this.AOJ = obj;
            this.AOF = new ReflectMethod(obj, "init", Activity.class, View.class, View.class, Context.class, String.class);
            this.AOG = new ReflectMethod(obj, "evaluteJavascript", Boolean.TYPE, Boolean.TYPE);
            this.AOH = new ReflectMethod(obj, "onShowCustomView", View.class, CustomViewCallback.class);
            this.onHideCustomViewMethod = new ReflectMethod(obj, "onHideCustomView", new Class[0]);
            this.hasEnteredFullscreenMethod = new ReflectMethod(obj, "hasEnteredFullscreen", new Class[0]);
            this.AOI = new ReflectMethod(obj, "registerJavascriptInterface", Object.class);
            AppMethodBeat.m2505o(84632);
        }

        /* renamed from: am */
        public final void mo30114am(boolean z, boolean z2) {
            AppMethodBeat.m2504i(84633);
            this.AOG.invoke(Boolean.valueOf(z), Boolean.valueOf(z2));
            AppMethodBeat.m2505o(84633);
        }

        /* renamed from: dh */
        public final void mo30115dh(Object obj) {
            AppMethodBeat.m2504i(84634);
            this.AOI.invoke(obj);
            AppMethodBeat.m2505o(84634);
        }

        public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
            AppMethodBeat.m2504i(84635);
            this.AOH.invoke(view, customViewCallback);
            AppMethodBeat.m2505o(84635);
        }

        public final void onHideCustomView() {
            AppMethodBeat.m2504i(84636);
            this.onHideCustomViewMethod.invoke(new Object[0]);
            AppMethodBeat.m2505o(84636);
        }

        public final boolean hasEnteredFullscreen() {
            AppMethodBeat.m2504i(84637);
            boolean booleanValue = ((Boolean) this.hasEnteredFullscreenMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.m2505o(84637);
            return booleanValue;
        }
    }

    private static ClassLoader dUv() {
        AppMethodBeat.m2504i(84638);
        ClassLoader classLoader;
        if (mClassLoader != null) {
            classLoader = mClassLoader;
            AppMethodBeat.m2505o(84638);
            return classLoader;
        }
        try {
            int availableVersion = XWalkEnvironment.getAvailableVersion();
            if (availableVersion == -1) {
                Log.m81049i("VideoNativeInterface", "getXWalkClassLoader version = -1");
                AppMethodBeat.m2505o(84638);
                return null;
            }
            String extractedCoreDir = XWalkEnvironment.getExtractedCoreDir(availableVersion);
            String classDexFilePath = XWalkEnvironment.getClassDexFilePath(availableVersion);
            if (new File(classDexFilePath).exists()) {
                mClassLoader = new DexClassLoader(classDexFilePath, XWalkEnvironment.getOptimizedDexDir(availableVersion), extractedCoreDir, ClassLoader.getSystemClassLoader());
                classLoader = mClassLoader;
                AppMethodBeat.m2505o(84638);
                return classLoader;
            }
            AppMethodBeat.m2505o(84638);
            return null;
        } catch (Exception e) {
            Log.m81046e("VideoNativeInterface", "getXWalkClassLoader error:" + e.getMessage());
            AppMethodBeat.m2505o(84638);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b6 A:{SYNTHETIC, Splitter:B:27:0x00b6} */
    /* JADX WARNING: Removed duplicated region for block: B:4:0x0027 A:{SYNTHETIC, Splitter:B:4:0x0027} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static C24528b m81001a(Activity activity, WebView webView, View view, String str) {
        ClassLoader classLoader;
        Class cls;
        ViewGroup viewGroup;
        C44584d c44584d;
        AppMethodBeat.m2504i(84639);
        if (XWalkCoreWrapper.getInstance() != null) {
            Log.m81049i("VideoNativeInterface", "createXWebNativeInterface get class by xwalk");
            classLoader = null;
            cls = XWalkCoreWrapper.getInstance().getClass("org.xwalk.core.internal.videofullscreen.XWebNativeInterfaceInternal");
        } else {
            Log.m81049i("VideoNativeInterface", "createXWebNativeInterface get class by sys");
            Boolean valueOf = Boolean.valueOf(XWalkEnvironment.getXWebInitArgs(XWalkEnvironment.XWALK_ENV_MAP_KEY_ISGPVERSION, false));
            if (valueOf == null || !(valueOf instanceof Boolean)) {
                Log.m81046e("VideoNativeInterface", "createXWebNativeInterface no gpversion value");
                classLoader = null;
                cls = null;
            } else if (valueOf.booleanValue()) {
                Log.m81046e("VideoNativeInterface", "createXWebNativeInterface current is gpversion not load dex");
                classLoader = null;
                cls = null;
            } else {
                try {
                    Class loadClass;
                    classLoader = C44589e.dUv();
                    if (classLoader != null) {
                        try {
                            loadClass = classLoader.loadClass("org.xwalk.core.internal.videofullscreen.XWebNativeInterfaceInternal");
                        } catch (ClassNotFoundException e) {
                            Object viewGroup2 = classLoader;
                        }
                    } else {
                        loadClass = null;
                    }
                    cls = loadClass;
                } catch (ClassNotFoundException e2) {
                    viewGroup2 = null;
                }
            }
        }
        if (cls == null) {
            try {
                Log.m81049i("VideoNativeInterface", "createXWebNativeInterface try using runtime class:XWebNativeInterfaceInternal");
                C16393a c16393a = new C16393a(cls.newInstance());
                XWalkContextWrapper xWalkContextWrapper = new XWalkContextWrapper(webView.getContext(), XWalkEnvironment.getAvailableVersion());
                if (classLoader != null) {
                    xWalkContextWrapper.setClassLoader(classLoader);
                }
                c16393a.AOF.invoke(activity, webView, view, xWalkContextWrapper, str);
                AppMethodBeat.m2505o(84639);
                return c16393a;
            } catch (Exception e3) {
                Log.m81046e("VideoNativeInterface", "XWebNativeInterfaceInternal found but error:" + e3.getMessage());
            }
        } else {
            Log.m81049i("VideoNativeInterface", "createXWebNativeInterface try using runtime class:XWebNativeInterfaceInternal but bot found");
            Log.m81049i("VideoNativeInterface", "createXWebNativeInterface using local class:XWebNativeInterface");
            c44584d = new C44584d();
            view.getContext();
            c44584d.mActivity = activity;
            c44584d.zxW = webView;
            c44584d.AOg = str;
            c44584d.odV = new FrameLayout(c44584d.zxW.getContext());
            c44584d.odV.setBackgroundColor(com.tencent.smtt.sdk.WebView.NIGHT_MODE_COLOR);
            if (c44584d.zxW.isXWalkKernel()) {
                c44584d.AND = new SurfaceView(c44584d.zxW.getContext());
                c44584d.AND.getHolder().setFormat(-3);
                c44584d.AND.getHolder().addCallback(new C245291());
                c44584d.AND.setZOrderOnTop(false);
                c44584d.AND.setZOrderMediaOverlay(false);
                c44584d.odV.addView(c44584d.AND);
            }
            c44584d.f17540Mh = new GestureDetector(c44584d.zxW.getContext(), c44584d);
            c44584d.ANR = new ScaleGestureDetector(c44584d.zxW.getContext(), c44584d);
            c44584d.f17540Mh.setIsLongpressEnabled(false);
            c44584d.ANF = (ViewGroup) LayoutInflater.from(c44584d.zxW.getContext()).inflate(2130970987, null);
            c44584d.ANF.setVisibility(8);
            c44584d.ANP = new C44583c((FrameLayout) c44584d.ANF.findViewById(2131821422), new C1638712());
            c44584d.ANH = (ProgressBar) c44584d.ANF.findViewById(2131828403);
            c44584d.ANI = (TextView) c44584d.ANF.findViewById(2131828407);
            c44584d.ANJ = (TextView) c44584d.ANF.findViewById(2131828408);
            c44584d.ANM = (ImageView) c44584d.ANF.findViewById(2131828404);
            c44584d.ANG = (VideoStatusLayout) c44584d.ANF.findViewById(2131828402);
            c44584d.ANK = (ClickableFrameLayout) c44584d.ANF.findViewById(2131828401);
            c44584d.ANK.setGestureDetector(c44584d.f17540Mh);
            c44584d.ANK.setOnTouchListener(new C1639014());
            c44584d.ANN = (ImageView) c44584d.ANF.findViewById(2131828409);
            c44584d.ANN.setOnClickListener(new C4458515());
            c44584d.ANL = (LinearLayout) c44584d.ANF.findViewById(2131828405);
            c44584d.ANL.setVisibility(4);
            c44584d.ANO = (ImageView) c44584d.ANF.findViewById(2131828406);
            c44584d.ANO.setOnClickListener(new C4112216());
            AppMethodBeat.m2505o(84639);
            return c44584d;
        }
        Object classLoader2 = viewGroup2;
        cls = null;
        if (cls == null) {
        }
        Log.m81049i("VideoNativeInterface", "createXWebNativeInterface using local class:XWebNativeInterface");
        c44584d = new C44584d();
        view.getContext();
        c44584d.mActivity = activity;
        c44584d.zxW = webView;
        c44584d.AOg = str;
        c44584d.odV = new FrameLayout(c44584d.zxW.getContext());
        c44584d.odV.setBackgroundColor(com.tencent.smtt.sdk.WebView.NIGHT_MODE_COLOR);
        if (c44584d.zxW.isXWalkKernel()) {
        }
        c44584d.f17540Mh = new GestureDetector(c44584d.zxW.getContext(), c44584d);
        c44584d.ANR = new ScaleGestureDetector(c44584d.zxW.getContext(), c44584d);
        c44584d.f17540Mh.setIsLongpressEnabled(false);
        c44584d.ANF = (ViewGroup) LayoutInflater.from(c44584d.zxW.getContext()).inflate(2130970987, null);
        c44584d.ANF.setVisibility(8);
        c44584d.ANP = new C44583c((FrameLayout) c44584d.ANF.findViewById(2131821422), new C1638712());
        c44584d.ANH = (ProgressBar) c44584d.ANF.findViewById(2131828403);
        c44584d.ANI = (TextView) c44584d.ANF.findViewById(2131828407);
        c44584d.ANJ = (TextView) c44584d.ANF.findViewById(2131828408);
        c44584d.ANM = (ImageView) c44584d.ANF.findViewById(2131828404);
        c44584d.ANG = (VideoStatusLayout) c44584d.ANF.findViewById(2131828402);
        c44584d.ANK = (ClickableFrameLayout) c44584d.ANF.findViewById(2131828401);
        c44584d.ANK.setGestureDetector(c44584d.f17540Mh);
        c44584d.ANK.setOnTouchListener(new C1639014());
        c44584d.ANN = (ImageView) c44584d.ANF.findViewById(2131828409);
        c44584d.ANN.setOnClickListener(new C4458515());
        c44584d.ANL = (LinearLayout) c44584d.ANF.findViewById(2131828405);
        c44584d.ANL.setVisibility(4);
        c44584d.ANO = (ImageView) c44584d.ANF.findViewById(2131828406);
        c44584d.ANO.setOnClickListener(new C4112216());
        AppMethodBeat.m2505o(84639);
        return c44584d;
    }
}
