package com.tencent.xweb.extension.video;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.xweb.WebView;
import dalvik.system.DexClassLoader;
import java.io.File;
import org.xwalk.core.Log;
import org.xwalk.core.ReflectMethod;
import org.xwalk.core.XWalkCoreWrapper;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.resource.XWalkContextWrapper;

public final class e {
    private static ClassLoader mClassLoader;

    public static class a implements b {
        ReflectMethod AOF;
        private ReflectMethod AOG;
        private ReflectMethod AOH;
        private ReflectMethod AOI;
        private Object AOJ;
        private ReflectMethod hasEnteredFullscreenMethod;
        private ReflectMethod onHideCustomViewMethod;

        public a(Object obj) {
            AppMethodBeat.i(84632);
            this.AOJ = obj;
            this.AOF = new ReflectMethod(obj, "init", Activity.class, View.class, View.class, Context.class, String.class);
            this.AOG = new ReflectMethod(obj, "evaluteJavascript", Boolean.TYPE, Boolean.TYPE);
            this.AOH = new ReflectMethod(obj, "onShowCustomView", View.class, CustomViewCallback.class);
            this.onHideCustomViewMethod = new ReflectMethod(obj, "onHideCustomView", new Class[0]);
            this.hasEnteredFullscreenMethod = new ReflectMethod(obj, "hasEnteredFullscreen", new Class[0]);
            this.AOI = new ReflectMethod(obj, "registerJavascriptInterface", Object.class);
            AppMethodBeat.o(84632);
        }

        public final void am(boolean z, boolean z2) {
            AppMethodBeat.i(84633);
            this.AOG.invoke(Boolean.valueOf(z), Boolean.valueOf(z2));
            AppMethodBeat.o(84633);
        }

        public final void dh(Object obj) {
            AppMethodBeat.i(84634);
            this.AOI.invoke(obj);
            AppMethodBeat.o(84634);
        }

        public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
            AppMethodBeat.i(84635);
            this.AOH.invoke(view, customViewCallback);
            AppMethodBeat.o(84635);
        }

        public final void onHideCustomView() {
            AppMethodBeat.i(84636);
            this.onHideCustomViewMethod.invoke(new Object[0]);
            AppMethodBeat.o(84636);
        }

        public final boolean hasEnteredFullscreen() {
            AppMethodBeat.i(84637);
            boolean booleanValue = ((Boolean) this.hasEnteredFullscreenMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.o(84637);
            return booleanValue;
        }
    }

    private static ClassLoader dUv() {
        AppMethodBeat.i(84638);
        ClassLoader classLoader;
        if (mClassLoader != null) {
            classLoader = mClassLoader;
            AppMethodBeat.o(84638);
            return classLoader;
        }
        try {
            int availableVersion = XWalkEnvironment.getAvailableVersion();
            if (availableVersion == -1) {
                Log.i("VideoNativeInterface", "getXWalkClassLoader version = -1");
                AppMethodBeat.o(84638);
                return null;
            }
            String extractedCoreDir = XWalkEnvironment.getExtractedCoreDir(availableVersion);
            String classDexFilePath = XWalkEnvironment.getClassDexFilePath(availableVersion);
            if (new File(classDexFilePath).exists()) {
                mClassLoader = new DexClassLoader(classDexFilePath, XWalkEnvironment.getOptimizedDexDir(availableVersion), extractedCoreDir, ClassLoader.getSystemClassLoader());
                classLoader = mClassLoader;
                AppMethodBeat.o(84638);
                return classLoader;
            }
            AppMethodBeat.o(84638);
            return null;
        } catch (Exception e) {
            Log.e("VideoNativeInterface", "getXWalkClassLoader error:" + e.getMessage());
            AppMethodBeat.o(84638);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b6 A:{SYNTHETIC, Splitter:B:27:0x00b6} */
    /* JADX WARNING: Removed duplicated region for block: B:4:0x0027 A:{SYNTHETIC, Splitter:B:4:0x0027} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static b a(Activity activity, WebView webView, View view, String str) {
        ClassLoader classLoader;
        Class cls;
        ViewGroup viewGroup;
        d dVar;
        AppMethodBeat.i(84639);
        if (XWalkCoreWrapper.getInstance() != null) {
            Log.i("VideoNativeInterface", "createXWebNativeInterface get class by xwalk");
            classLoader = null;
            cls = XWalkCoreWrapper.getInstance().getClass("org.xwalk.core.internal.videofullscreen.XWebNativeInterfaceInternal");
        } else {
            Log.i("VideoNativeInterface", "createXWebNativeInterface get class by sys");
            Boolean valueOf = Boolean.valueOf(XWalkEnvironment.getXWebInitArgs(XWalkEnvironment.XWALK_ENV_MAP_KEY_ISGPVERSION, false));
            if (valueOf == null || !(valueOf instanceof Boolean)) {
                Log.e("VideoNativeInterface", "createXWebNativeInterface no gpversion value");
                classLoader = null;
                cls = null;
            } else if (valueOf.booleanValue()) {
                Log.e("VideoNativeInterface", "createXWebNativeInterface current is gpversion not load dex");
                classLoader = null;
                cls = null;
            } else {
                try {
                    Class loadClass;
                    classLoader = dUv();
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
                Log.i("VideoNativeInterface", "createXWebNativeInterface try using runtime class:XWebNativeInterfaceInternal");
                a aVar = new a(cls.newInstance());
                XWalkContextWrapper xWalkContextWrapper = new XWalkContextWrapper(webView.getContext(), XWalkEnvironment.getAvailableVersion());
                if (classLoader != null) {
                    xWalkContextWrapper.setClassLoader(classLoader);
                }
                aVar.AOF.invoke(activity, webView, view, xWalkContextWrapper, str);
                AppMethodBeat.o(84639);
                return aVar;
            } catch (Exception e3) {
                Log.e("VideoNativeInterface", "XWebNativeInterfaceInternal found but error:" + e3.getMessage());
            }
        } else {
            Log.i("VideoNativeInterface", "createXWebNativeInterface try using runtime class:XWebNativeInterfaceInternal but bot found");
            Log.i("VideoNativeInterface", "createXWebNativeInterface using local class:XWebNativeInterface");
            dVar = new d();
            view.getContext();
            dVar.mActivity = activity;
            dVar.zxW = webView;
            dVar.AOg = str;
            dVar.odV = new FrameLayout(dVar.zxW.getContext());
            dVar.odV.setBackgroundColor(com.tencent.smtt.sdk.WebView.NIGHT_MODE_COLOR);
            if (dVar.zxW.isXWalkKernel()) {
                dVar.AND = new SurfaceView(dVar.zxW.getContext());
                dVar.AND.getHolder().setFormat(-3);
                dVar.AND.getHolder().addCallback(new Callback() {
                    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
                        AppMethodBeat.i(84574);
                        Canvas lockCanvas = surfaceHolder.lockCanvas();
                        lockCanvas.drawColor(com.tencent.smtt.sdk.WebView.NIGHT_MODE_COLOR);
                        surfaceHolder.unlockCanvasAndPost(lockCanvas);
                        AppMethodBeat.o(84574);
                    }

                    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                        AppMethodBeat.i(84575);
                        Canvas lockCanvas = surfaceHolder.lockCanvas();
                        lockCanvas.drawColor(com.tencent.smtt.sdk.WebView.NIGHT_MODE_COLOR);
                        surfaceHolder.unlockCanvasAndPost(lockCanvas);
                        AppMethodBeat.o(84575);
                    }

                    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                    }
                });
                dVar.AND.setZOrderOnTop(false);
                dVar.AND.setZOrderMediaOverlay(false);
                dVar.odV.addView(dVar.AND);
            }
            dVar.Mh = new GestureDetector(dVar.zxW.getContext(), dVar);
            dVar.ANR = new ScaleGestureDetector(dVar.zxW.getContext(), dVar);
            dVar.Mh.setIsLongpressEnabled(false);
            dVar.ANF = (ViewGroup) LayoutInflater.from(dVar.zxW.getContext()).inflate(R.layout.b1a, null);
            dVar.ANF.setVisibility(8);
            dVar.ANP = new c((FrameLayout) dVar.ANF.findViewById(R.id.x1), new com.tencent.xweb.extension.video.c.a() {
                public final void aFw() {
                    AppMethodBeat.i(84586);
                    d.this.dUs();
                    d.this.dUt();
                    AppMethodBeat.o(84586);
                }

                public final void bw(float f) {
                    AppMethodBeat.i(84587);
                    d.this.f((d.this.idN * ((double) f)) / 100.0d, false);
                    d.this.zxW.evaluateJavascript(String.format("xwebVideoBridge.xwebToJS_Video_Seek(%f);", new Object[]{Double.valueOf(r0)}), new ValueCallback<String>() {
                        public final /* bridge */ /* synthetic */ void onReceiveValue(Object obj) {
                        }
                    });
                    d.this.dUr();
                    AppMethodBeat.o(84587);
                }
            });
            dVar.ANH = (ProgressBar) dVar.ANF.findViewById(R.id.f0f);
            dVar.ANI = (TextView) dVar.ANF.findViewById(R.id.f0j);
            dVar.ANJ = (TextView) dVar.ANF.findViewById(R.id.f0k);
            dVar.ANM = (ImageView) dVar.ANF.findViewById(R.id.f0g);
            dVar.ANG = (VideoStatusLayout) dVar.ANF.findViewById(R.id.f0e);
            dVar.ANK = (ClickableFrameLayout) dVar.ANF.findViewById(R.id.f0d);
            dVar.ANK.setGestureDetector(dVar.Mh);
            dVar.ANK.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(84589);
                    if (d.this.ANS) {
                        switch (motionEvent.getAction() & 255) {
                            case 1:
                                d.this.mMode = 0;
                                break;
                            case 5:
                                if (motionEvent.getPointerCount() == 2) {
                                    d.this.mMode = 1;
                                    break;
                                }
                                break;
                            case 6:
                                d.this.mMode = 0;
                                break;
                        }
                        if (motionEvent.getAction() == 1 && d.this.AOj == 3) {
                            d.this.f((d.this.idN * ((double) d.this.AOd)) / 100.0d, true);
                            d.this.zxW.evaluateJavascript(String.format("xwebVideoBridge.xwebToJS_Video_Seek(%f);", new Object[]{Double.valueOf(r2)}), new ValueCallback<String>() {
                                public final /* bridge */ /* synthetic */ void onReceiveValue(Object obj) {
                                }
                            });
                            d.this.AOj = 0;
                        }
                        boolean onTouchEvent;
                        if (d.this.mMode == 1) {
                            onTouchEvent = d.this.ANR.onTouchEvent(motionEvent);
                            AppMethodBeat.o(84589);
                            return onTouchEvent;
                        }
                        onTouchEvent = d.this.Mh.onTouchEvent(motionEvent);
                        AppMethodBeat.o(84589);
                        return onTouchEvent;
                    }
                    AppMethodBeat.o(84589);
                    return false;
                }
            });
            dVar.ANN = (ImageView) dVar.ANF.findViewById(R.id.f0l);
            dVar.ANN.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(84590);
                    d.this.zxW.evaluateJavascript("xwebVideoBridge.xwebToJS_Video_ExitFullscreen();", new ValueCallback<String>() {
                        public final /* bridge */ /* synthetic */ void onReceiveValue(Object obj) {
                        }
                    });
                    AppMethodBeat.o(84590);
                }
            });
            dVar.ANL = (LinearLayout) dVar.ANF.findViewById(R.id.f0h);
            dVar.ANL.setVisibility(4);
            dVar.ANO = (ImageView) dVar.ANF.findViewById(R.id.f0i);
            dVar.ANO.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(84591);
                    d.this.zxW.evaluateJavascript("xwebVideoBridge.xwebToJS_Video_Play();", new ValueCallback<String>() {
                        public final /* bridge */ /* synthetic */ void onReceiveValue(Object obj) {
                        }
                    });
                    d.this.dUr();
                    AppMethodBeat.o(84591);
                }
            });
            AppMethodBeat.o(84639);
            return dVar;
        }
        Object classLoader2 = viewGroup2;
        cls = null;
        if (cls == null) {
        }
        Log.i("VideoNativeInterface", "createXWebNativeInterface using local class:XWebNativeInterface");
        dVar = new d();
        view.getContext();
        dVar.mActivity = activity;
        dVar.zxW = webView;
        dVar.AOg = str;
        dVar.odV = new FrameLayout(dVar.zxW.getContext());
        dVar.odV.setBackgroundColor(com.tencent.smtt.sdk.WebView.NIGHT_MODE_COLOR);
        if (dVar.zxW.isXWalkKernel()) {
        }
        dVar.Mh = new GestureDetector(dVar.zxW.getContext(), dVar);
        dVar.ANR = new ScaleGestureDetector(dVar.zxW.getContext(), dVar);
        dVar.Mh.setIsLongpressEnabled(false);
        dVar.ANF = (ViewGroup) LayoutInflater.from(dVar.zxW.getContext()).inflate(R.layout.b1a, null);
        dVar.ANF.setVisibility(8);
        dVar.ANP = new c((FrameLayout) dVar.ANF.findViewById(R.id.x1), /* anonymous class already generated */);
        dVar.ANH = (ProgressBar) dVar.ANF.findViewById(R.id.f0f);
        dVar.ANI = (TextView) dVar.ANF.findViewById(R.id.f0j);
        dVar.ANJ = (TextView) dVar.ANF.findViewById(R.id.f0k);
        dVar.ANM = (ImageView) dVar.ANF.findViewById(R.id.f0g);
        dVar.ANG = (VideoStatusLayout) dVar.ANF.findViewById(R.id.f0e);
        dVar.ANK = (ClickableFrameLayout) dVar.ANF.findViewById(R.id.f0d);
        dVar.ANK.setGestureDetector(dVar.Mh);
        dVar.ANK.setOnTouchListener(/* anonymous class already generated */);
        dVar.ANN = (ImageView) dVar.ANF.findViewById(R.id.f0l);
        dVar.ANN.setOnClickListener(/* anonymous class already generated */);
        dVar.ANL = (LinearLayout) dVar.ANF.findViewById(R.id.f0h);
        dVar.ANL.setVisibility(4);
        dVar.ANO = (ImageView) dVar.ANF.findViewById(R.id.f0i);
        dVar.ANO.setOnClickListener(/* anonymous class already generated */);
        AppMethodBeat.o(84639);
        return dVar;
    }
}
