package com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Point;
import android.opengl.EGL14;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.C2545b;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView.C33606n;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.Buffer;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 !2\u00020\u0001:\u0002!\"B\u001b\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0014J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J\u0006\u0010\u0017\u001a\u00020\u000fJ\u000e\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\fJ\u0012\u0010\u001d\u001a\u00020\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010 \u001a\u00020\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/DynamicBackgroundGLSurfaceView;", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mDelayPauseRunnable", "Ljava/lang/Runnable;", "mRenderer", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/DynamicBackgroundGLSurfaceView$GLRenderer;", "needPause", "", "showGradientView", "onAttachedToWindow", "", "onDetachedFromWindow", "onResume", "onVisibilityChanged", "changedView", "Landroid/view/View;", "visibility", "", "release", "setGradientBackgroundView", "gradientColorBackgroundView", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GradientColorBackgroundView;", "setShowGradientView", "show", "surfaceCreated", "holder", "Landroid/view/SurfaceHolder;", "surfaceDestroyed", "Companion", "GLRenderer", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.DynamicBackgroundGLSurfaceView */
public final class DynamicBackgroundGLSurfaceView extends GameGLSurfaceView {
    public static final C10970a iZk = new C10970a();
    private C27360b iZh;
    private boolean iZi;
    private boolean iZj;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/DynamicBackgroundGLSurfaceView$Companion;", "", "()V", "DRAW_LOG", "", "TAG", "", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.DynamicBackgroundGLSurfaceView$a */
    public static final class C10970a {
        private C10970a() {
        }

        public /* synthetic */ C10970a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u000e\u0018\u0000 42\u00020\u0001:\u00014B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\u001a\u0010\u001d\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\bH\u0016J\u001c\u0010!\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010$\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010%\u001a\u00020\u001b2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010(\u001a\u00020\u001bH\u0016J\b\u0010)\u001a\u00020\u001bH\u0016J\"\u0010*\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u0006H\u0016J\u0006\u0010-\u001a\u00020\u001bJ\b\u0010.\u001a\u00020\u001bH\u0002J\u000e\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u00020\u000eJ\u000e\u00101\u001a\u00020\u001b2\u0006\u00102\u001a\u00020\bJ\u000e\u00103\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u00065"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/DynamicBackgroundGLSurfaceView$GLRenderer;", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$Renderer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "drawCount", "", "hasPostAlphaAnimation", "", "isAlphaAnimating", "()Z", "setAlphaAnimating", "(Z)V", "mGradientBgView", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GradientColorBackgroundView;", "mLastDraw", "", "mNativeRenderer", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/DynamicBackgroundNative;", "needCheckBlack", "needCheckCrash", "showGradientView", "surfaceView", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView;", "viewHeight", "viewWidth", "init", "", "onDestroy", "onDrawFrame", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "isPaused", "onEGLCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "onEGLSurfaceChanged", "onError", "e", "", "onPause", "onResume", "onSurfaceSizeChanged", "width", "height", "release", "reset", "setGradientBackgroundView", "gradientColorBackgroundView", "setShowGradientView", "show", "setSurfaceView", "Companion", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.DynamicBackgroundGLSurfaceView$b */
    public static final class C27360b implements C33606n {
        private static long iZu = 500;
        public static final C27362a iZv = new C27362a();
        private Context context;
        private int eNs;
        GradientColorBackgroundView iWx;
        boolean iZj;
        private DynamicBackgroundNative iZl;
        private long iZm = -1;
        private int iZn;
        private int iZo;
        boolean iZp;
        boolean iZq;
        GameGLSurfaceView iZr;
        private boolean iZs = true;
        private boolean iZt = true;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.DynamicBackgroundGLSurfaceView$b$c */
        static final class C27361c implements Runnable {
            final /* synthetic */ C27360b iZw;

            @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
            /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.DynamicBackgroundGLSurfaceView$b$c$1 */
            static final class C25461 implements Runnable {
                final /* synthetic */ C27361c iZy;

                C25461(C27361c c27361c) {
                    this.iZy = c27361c;
                }

                public final void run() {
                    AppMethodBeat.m2504i(135227);
                    GameGLSurfaceView b = this.iZy.iZw.iZr;
                    if (b != null) {
                        b.onPause();
                    }
                    b = this.iZy.iZw.iZr;
                    if (b != null) {
                        b.setVisibility(4);
                        AppMethodBeat.m2505o(135227);
                        return;
                    }
                    AppMethodBeat.m2505o(135227);
                }
            }

            C27361c(C27360b c27360b) {
                this.iZw = c27360b;
            }

            public final void run() {
                AppMethodBeat.m2504i(135228);
                GradientColorBackgroundView a = this.iZw.iWx;
                if (a != null) {
                    a.setVisibility(0);
                }
                a = this.iZw.iWx;
                if (a != null) {
                    a.setAlpha(1.0f);
                }
                C4990ab.m7410d("MicroMsg.DynamicBgSurfaceView", "alvinluo showGradientView");
                GameGLSurfaceView b = this.iZw.iZr;
                if (b != null) {
                    b.postDelayed(new C25461(this), 50);
                    AppMethodBeat.m2505o(135228);
                    return;
                }
                AppMethodBeat.m2505o(135228);
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\u0004J\u0016\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010J(\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0007\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/DynamicBackgroundGLSurfaceView$GLRenderer$Companion;", "", "()V", "ALPHA_ANIMATION_DURATION", "", "checkBlackScreen", "", "buf", "Ljava/nio/ByteBuffer;", "width", "", "height", "getAlphaAnimation", "loadShader", "type", "shaderCode", "", "saveRgb2Bitmap", "Landroid/graphics/Bitmap;", "Ljava/nio/Buffer;", "filename", "updateAlphaAnimation", "", "duration", "plugin-appbrand-integration_release"})
        /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.DynamicBackgroundGLSurfaceView$b$a */
        public static final class C27362a {
            private C27362a() {
            }

            public /* synthetic */ C27362a(byte b) {
                this();
            }

            /* JADX WARNING: Removed duplicated region for block: B:12:0x0054 A:{SYNTHETIC, Splitter:B:12:0x0054} */
            /* JADX WARNING: Removed duplicated region for block: B:18:0x0060 A:{SYNTHETIC, Splitter:B:18:0x0060} */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            /* renamed from: a */
            public static Bitmap m43434a(Buffer buffer, String str) {
                Throwable th;
                AppMethodBeat.m2504i(135224);
                C25052j.m39376p(buffer, "buf");
                C25052j.m39376p(str, "filename");
                C4990ab.m7410d("TryOpenGL", "Creating ".concat(String.valueOf(str)));
                BufferedOutputStream bufferedOutputStream;
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
                    try {
                        Bitmap createBitmap = Bitmap.createBitmap(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2000, Config.ARGB_8888);
                        createBitmap.copyPixelsFromBuffer(buffer);
                        createBitmap.compress(CompressFormat.PNG, 90, bufferedOutputStream);
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e) {
                        }
                        AppMethodBeat.m2505o(135224);
                        return createBitmap;
                    } catch (IOException e2) {
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException e3) {
                            }
                        }
                        AppMethodBeat.m2505o(135224);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException e4) {
                            }
                        }
                        AppMethodBeat.m2505o(135224);
                        throw th;
                    }
                } catch (IOException e5) {
                    bufferedOutputStream = null;
                    if (bufferedOutputStream != null) {
                    }
                    AppMethodBeat.m2505o(135224);
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedOutputStream = null;
                    if (bufferedOutputStream != null) {
                    }
                    AppMethodBeat.m2505o(135224);
                    throw th;
                }
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.DynamicBackgroundGLSurfaceView$b$b */
        static final class C27363b implements Runnable {
            final /* synthetic */ C27360b iZw;

            @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, dWq = {"com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/DynamicBackgroundGLSurfaceView$GLRenderer$onDrawFrame$1$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-appbrand-integration_release"})
            /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.DynamicBackgroundGLSurfaceView$b$b$1 */
            public static final class C273641 implements AnimatorListener {
                final /* synthetic */ C27363b iZx;

                C273641(C27363b c27363b) {
                    this.iZx = c27363b;
                }

                public final void onAnimationRepeat(Animator animator) {
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.m2504i(135225);
                    GradientColorBackgroundView a = this.iZx.iZw.iWx;
                    if (a != null) {
                        a.setVisibility(4);
                    }
                    this.iZx.iZw.iZp = false;
                    AppMethodBeat.m2505o(135225);
                }

                public final void onAnimationCancel(Animator animator) {
                    this.iZx.iZw.iZp = false;
                }

                public final void onAnimationStart(Animator animator) {
                }
            }

            C27363b(C27360b c27360b) {
                this.iZw = c27360b;
            }

            public final void run() {
                AppMethodBeat.m2504i(135226);
                GradientColorBackgroundView a = this.iZw.iWx;
                if (a != null) {
                    if (a.getVisibility() == 0 && !this.iZw.iZp) {
                        GameGLSurfaceView b = this.iZw.iZr;
                        if (b != null) {
                            b.setVisibility(0);
                        }
                        this.iZw.iZp = true;
                        a = this.iZw.iWx;
                        if (a != null) {
                            a.setAlpha(1.0f);
                        }
                        C4990ab.m7410d("MicroMsg.DynamicBgSurfaceView", "alvinluo GradientColorBackgroundView do alpha animation");
                        a = this.iZw.iWx;
                        if (a != null) {
                            ViewPropertyAnimator animate = a.animate();
                            if (animate != null) {
                                animate = animate.alpha(0.0f);
                                if (animate != null) {
                                    ViewPropertyAnimator duration = animate.setDuration(C27360b.iZu);
                                    if (duration != null) {
                                        animate = duration.setListener(new C273641(this));
                                        if (animate != null) {
                                            animate.start();
                                            AppMethodBeat.m2505o(135226);
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    AppMethodBeat.m2505o(135226);
                    return;
                }
                AppMethodBeat.m2505o(135226);
            }
        }

        public C27360b(Context context) {
            C25052j.m39376p(context, "context");
            AppMethodBeat.m2504i(135238);
            if (!C2545b.aPe() || C33608d.aPS()) {
                C4990ab.m7412e("MicroMsg.DynamicBgSurfaceView", "alvinluo AppBrandDesktopConfig not enableNativeDynamicBackground");
            } else {
                this.iZl = new DynamicBackgroundNative();
            }
            this.context = context;
            AppMethodBeat.m2505o(135238);
        }

        private final void init() {
            AppMethodBeat.m2504i(135229);
            C4990ab.m7416i("MicroMsg.DynamicBgSurfaceView", "alvinluo NativeRender init");
            DynamicBackgroundNative dynamicBackgroundNative;
            try {
                dynamicBackgroundNative = this.iZl;
                if (dynamicBackgroundNative != null) {
                    dynamicBackgroundNative.nativeInit();
                    AppMethodBeat.m2505o(135229);
                    return;
                }
                AppMethodBeat.m2505o(135229);
            } catch (Throwable th) {
                C33608d.aPL();
                AppMethodBeat.m2505o(135229);
            }
        }

        public final void aPC() {
            AppMethodBeat.m2504i(135230);
            try {
                init();
                Point hy = C5222ae.m7953hy(this.context);
                this.iZn = hy.x;
                this.iZo = hy.y;
                C4990ab.m7417i("MicroMsg.DynamicBgSurfaceView", "alvinluo onEGLCreated width: %d, height: %d", Integer.valueOf(this.iZn), Integer.valueOf(this.iZo));
                C4990ab.m7417i("MicroMsg.DynamicBgSurfaceView", "alvinluo handle: %s, %s, %s", EGL14.eglGetCurrentContext(), EGL14.eglGetCurrentDisplay(), EGL14.eglGetCurrentSurface(12377));
                DynamicBackgroundNative dynamicBackgroundNative = this.iZl;
                if (dynamicBackgroundNative != null) {
                    dynamicBackgroundNative.surfaceCreated(this.iZn, this.iZo);
                }
                dynamicBackgroundNative = this.iZl;
                if (dynamicBackgroundNative != null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    C38585e c38585e = C38585e.iZE;
                    String stringBuilder2 = stringBuilder.append(C38585e.m65394dn(this.context)).append("scene_shaderv.glsl").toString();
                    StringBuilder stringBuilder3 = new StringBuilder();
                    C38585e c38585e2 = C38585e.iZE;
                    String stringBuilder4 = stringBuilder3.append(C38585e.m65394dn(this.context)).append("scene_shaderf.glsl").toString();
                    StringBuilder stringBuilder5 = new StringBuilder();
                    C38585e c38585e3 = C38585e.iZE;
                    String stringBuilder6 = stringBuilder5.append(C38585e.m65394dn(this.context)).append("vertex_framebuffer_plane.glsl").toString();
                    StringBuilder stringBuilder7 = new StringBuilder();
                    C38585e c38585e4 = C38585e.iZE;
                    String stringBuilder8 = stringBuilder7.append(C38585e.m65394dn(this.context)).append("frag_framebuffer_plane.glsl").toString();
                    StringBuilder stringBuilder9 = new StringBuilder();
                    C38585e c38585e5 = C38585e.iZE;
                    String stringBuilder10 = stringBuilder9.append(C38585e.m65394dn(this.context)).append("texture_vertex_shader.glsl").toString();
                    StringBuilder stringBuilder11 = new StringBuilder();
                    C38585e c38585e6 = C38585e.iZE;
                    String stringBuilder12 = stringBuilder11.append(C38585e.m65394dn(this.context)).append("texture_fragment_shader.glsl").toString();
                    StringBuilder stringBuilder13 = new StringBuilder();
                    C38585e c38585e7 = C38585e.iZE;
                    String stringBuilder14 = stringBuilder13.append(C38585e.m65394dn(this.context)).append("bg_gradient_vertex_shader.glsl").toString();
                    StringBuilder stringBuilder15 = new StringBuilder();
                    C38585e c38585e8 = C38585e.iZE;
                    dynamicBackgroundNative.setupGlslFiles(stringBuilder2, stringBuilder4, stringBuilder6, stringBuilder8, stringBuilder10, stringBuilder12, stringBuilder14, stringBuilder15.append(C38585e.m65394dn(this.context)).append("bg_gradient_fragment_shader.glsl").toString());
                }
                dynamicBackgroundNative = this.iZl;
                if (dynamicBackgroundNative != null) {
                    dynamicBackgroundNative.initView();
                }
                if (C2545b.aPe() && !C33608d.aPN()) {
                    C33608d.aPP();
                    AppMethodBeat.m2505o(135230);
                    return;
                }
            } catch (Throwable th) {
                C4990ab.printErrStackTrace("MicroMsg.DynamicBgSurfaceView", th, "alvinluo onEGLCreated exception", new Object[0]);
                C33608d.aPL();
            }
            AppMethodBeat.m2505o(135230);
        }

        public final void aPD() {
            AppMethodBeat.m2504i(135231);
            C4990ab.m7416i("MicroMsg.DynamicBgSurfaceView", "alvinluo onEGLSurfaceChanged and do nothing");
            this.eNs = 0;
            AppMethodBeat.m2505o(135231);
        }

        /* renamed from: do */
        public final void mo45044do(int i, int i2) {
            AppMethodBeat.m2504i(135232);
            try {
                C4990ab.m7417i("MicroMsg.DynamicBgSurfaceView", "alvinluo onSurfaceSizeChanged width: %d, height: %d", Integer.valueOf(i), Integer.valueOf(i2));
                if (!(this.iZn == i || this.iZo == i2)) {
                    init();
                    this.iZn = i;
                    this.iZo = i2;
                    C4990ab.m7417i("MicroMsg.DynamicBgSurfaceView", "alvinluo onSurfaceSizeChanged reCreated width: %d, height: %d", Integer.valueOf(this.iZn), Integer.valueOf(this.iZo));
                    DynamicBackgroundNative dynamicBackgroundNative = this.iZl;
                    if (dynamicBackgroundNative != null) {
                        dynamicBackgroundNative.surfaceCreated(this.iZn, this.iZo);
                    }
                    dynamicBackgroundNative = this.iZl;
                    if (dynamicBackgroundNative != null) {
                        StringBuilder stringBuilder = new StringBuilder();
                        C38585e c38585e = C38585e.iZE;
                        String stringBuilder2 = stringBuilder.append(C38585e.m65394dn(this.context)).append("scene_shaderv.glsl").toString();
                        StringBuilder stringBuilder3 = new StringBuilder();
                        C38585e c38585e2 = C38585e.iZE;
                        String stringBuilder4 = stringBuilder3.append(C38585e.m65394dn(this.context)).append("scene_shaderf.glsl").toString();
                        StringBuilder stringBuilder5 = new StringBuilder();
                        C38585e c38585e3 = C38585e.iZE;
                        String stringBuilder6 = stringBuilder5.append(C38585e.m65394dn(this.context)).append("vertex_framebuffer_plane.glsl").toString();
                        StringBuilder stringBuilder7 = new StringBuilder();
                        C38585e c38585e4 = C38585e.iZE;
                        String stringBuilder8 = stringBuilder7.append(C38585e.m65394dn(this.context)).append("frag_framebuffer_plane.glsl").toString();
                        StringBuilder stringBuilder9 = new StringBuilder();
                        C38585e c38585e5 = C38585e.iZE;
                        String stringBuilder10 = stringBuilder9.append(C38585e.m65394dn(this.context)).append("texture_vertex_shader.glsl").toString();
                        StringBuilder stringBuilder11 = new StringBuilder();
                        C38585e c38585e6 = C38585e.iZE;
                        String stringBuilder12 = stringBuilder11.append(C38585e.m65394dn(this.context)).append("texture_fragment_shader.glsl").toString();
                        StringBuilder stringBuilder13 = new StringBuilder();
                        C38585e c38585e7 = C38585e.iZE;
                        String stringBuilder14 = stringBuilder13.append(C38585e.m65394dn(this.context)).append("bg_gradient_vertex_shader.glsl").toString();
                        StringBuilder stringBuilder15 = new StringBuilder();
                        C38585e c38585e8 = C38585e.iZE;
                        dynamicBackgroundNative.setupGlslFiles(stringBuilder2, stringBuilder4, stringBuilder6, stringBuilder8, stringBuilder10, stringBuilder12, stringBuilder14, stringBuilder15.append(C38585e.m65394dn(this.context)).append("bg_gradient_fragment_shader.glsl").toString());
                    }
                    dynamicBackgroundNative = this.iZl;
                    if (dynamicBackgroundNative != null) {
                        dynamicBackgroundNative.initView();
                    }
                    this.eNs = 0;
                    AppMethodBeat.m2505o(135232);
                    return;
                }
            } catch (Throwable th) {
                C4990ab.printErrStackTrace("MicroMsg.DynamicBgSurfaceView", th, "alvinluo onSurfaceSizeChanged exception", new Object[0]);
                C2545b.m4793eT(false);
            }
            AppMethodBeat.m2505o(135232);
        }

        public final void aPE() {
            AppMethodBeat.m2504i(135233);
            try {
                C38583b c38583b = C38583b.iZg;
                Thread.sleep((long) C38583b.aPz());
            } catch (Exception e) {
            }
            if (C33608d.aPI()) {
                C33608d.aPQ();
            }
            try {
                DynamicBackgroundNative dynamicBackgroundNative = this.iZl;
                if (dynamicBackgroundNative != null) {
                    dynamicBackgroundNative.draw();
                }
            } catch (Throwable th) {
                C4990ab.printErrStackTrace("MicroMsg.DynamicBgSurfaceView", th, "alvinluo onDraw exception", new Object[0]);
                C2545b.m4793eT(false);
            }
            if (C33608d.aPI()) {
                this.eNs++;
                if (this.eNs >= 2) {
                    C33608d.aPR();
                }
            }
            GradientColorBackgroundView gradientColorBackgroundView;
            if (this.iZj || this.iZq) {
                if (this.iZj) {
                    GradientColorBackgroundView gradientColorBackgroundView2 = this.iWx;
                    if (gradientColorBackgroundView2 == null || gradientColorBackgroundView2.getVisibility() != 0) {
                        gradientColorBackgroundView = this.iWx;
                        if (gradientColorBackgroundView != null) {
                            gradientColorBackgroundView.post(new C27361c(this));
                            AppMethodBeat.m2505o(135233);
                            return;
                        }
                    }
                }
                AppMethodBeat.m2505o(135233);
                return;
            }
            this.iZq = true;
            gradientColorBackgroundView = this.iWx;
            if (gradientColorBackgroundView != null) {
                gradientColorBackgroundView.post(new C27363b(this));
                AppMethodBeat.m2505o(135233);
                return;
            }
            AppMethodBeat.m2505o(135233);
        }

        public final void onResume() {
            AppMethodBeat.m2504i(135234);
            C4990ab.m7416i("MicroMsg.DynamicBgSurfaceView", "alvinluo DynamicBackgroundSurfaceView.Renderer onResume");
            this.iZt = true;
            AppMethodBeat.m2505o(135234);
        }

        public final void onDestroy() {
            AppMethodBeat.m2504i(135235);
            C4990ab.m7416i("MicroMsg.DynamicBgSurfaceView", "alvinluo DynamicBackgroundSurfaceView.Renderer onDestroy");
            try {
                DynamicBackgroundNative dynamicBackgroundNative = this.iZl;
                if (dynamicBackgroundNative != null) {
                    dynamicBackgroundNative.nativeRelease();
                    AppMethodBeat.m2505o(135235);
                    return;
                }
                AppMethodBeat.m2505o(135235);
            } catch (Throwable th) {
                C4990ab.printErrStackTrace("MicroMsg.DynamicBgSurfaceView", th, "alvinluo nativeRelease exception", new Object[0]);
                AppMethodBeat.m2505o(135235);
            }
        }

        public final void onPause() {
            AppMethodBeat.m2504i(135236);
            C4990ab.m7416i("MicroMsg.DynamicBgSurfaceView", "alvinluo DynamicBackgroundSurfaceView.Renderer onPause");
            AppMethodBeat.m2505o(135236);
        }

        public final void aPF() {
            AppMethodBeat.m2504i(135237);
            C4990ab.m7412e("MicroMsg.DynamicBgSurfaceView", "alvinluo GLSurfaceView onError");
            C33608d.aPM();
            AppMethodBeat.m2505o(135237);
        }

        static {
            AppMethodBeat.m2504i(135239);
            AppMethodBeat.m2505o(135239);
        }
    }

    static {
        AppMethodBeat.m2504i(135248);
        AppMethodBeat.m2505o(135248);
    }

    public DynamicBackgroundGLSurfaceView(Context context, byte b) {
        this(context);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDetachedFromWindow() {
        AppMethodBeat.m2504i(135240);
        super.onDetachedFromWindow();
        C4990ab.m7416i("MicroMsg.DynamicBgSurfaceView", "alvinluo onDetachedFromWindow");
        AppMethodBeat.m2505o(135240);
    }

    private /* synthetic */ DynamicBackgroundGLSurfaceView(Context context) {
        this(context, null);
    }

    public DynamicBackgroundGLSurfaceView(Context context, AttributeSet attributeSet) {
        C25052j.m39376p(context, "context");
        super(context, attributeSet);
        AppMethodBeat.m2504i(135247);
        setEGLContextClientVersion(2);
        aPV();
        setPreserveEGLContextOnPause(true);
        this.iZh = new C27360b(context);
        setRenderer(this.iZh);
        getHolder().setFormat(-3);
        C27360b c27360b = this.iZh;
        if (c27360b != null) {
            GameGLSurfaceView gameGLSurfaceView = this;
            C25052j.m39376p(gameGLSurfaceView, "surfaceView");
            c27360b.iZr = gameGLSurfaceView;
            AppMethodBeat.m2505o(135247);
            return;
        }
        AppMethodBeat.m2505o(135247);
    }

    public final void setShowGradientView(boolean z) {
        this.iZj = z;
        C27360b c27360b = this.iZh;
        if (c27360b != null) {
            c27360b.iZj = z;
            if (!c27360b.iZj) {
                c27360b.iZq = false;
            }
        }
    }

    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        AppMethodBeat.m2504i(135241);
        super.surfaceDestroyed(surfaceHolder);
        C4990ab.m7416i("MicroMsg.DynamicBgSurfaceView", "alvinluo surfaceDestroyed");
        C27360b c27360b = this.iZh;
        if (c27360b != null) {
            c27360b.iZp = false;
            AppMethodBeat.m2505o(135241);
            return;
        }
        AppMethodBeat.m2505o(135241);
    }

    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        AppMethodBeat.m2504i(135242);
        super.surfaceCreated(surfaceHolder);
        C4990ab.m7416i("MicroMsg.DynamicBgSurfaceView", "alvinluo surfaceCreated");
        AppMethodBeat.m2505o(135242);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onAttachedToWindow() {
        AppMethodBeat.m2504i(135243);
        super.onAttachedToWindow();
        C4990ab.m7416i("MicroMsg.DynamicBgSurfaceView", "alvinluo onAttachedToWindow");
        AppMethodBeat.m2505o(135243);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onVisibilityChanged(View view, int i) {
        AppMethodBeat.m2504i(135244);
        C25052j.m39376p(view, "changedView");
        super.onVisibilityChanged(view, i);
        C4990ab.m7417i("MicroMsg.DynamicBgSurfaceView", "alvinluo onVisibilityChanged: %d", Integer.valueOf(i));
        if (i != 0 && this.iZi) {
            C4990ab.m7416i("MicroMsg.DynamicBgSurfaceView", "alvinluo needPause");
            this.iZi = false;
        }
        AppMethodBeat.m2505o(135244);
    }

    public final void onResume() {
        AppMethodBeat.m2504i(135245);
        super.onResume();
        this.iZi = false;
        AppMethodBeat.m2505o(135245);
    }

    public final void setGradientBackgroundView(GradientColorBackgroundView gradientColorBackgroundView) {
        AppMethodBeat.m2504i(135246);
        C25052j.m39376p(gradientColorBackgroundView, "gradientColorBackgroundView");
        C27360b c27360b = this.iZh;
        if (c27360b != null) {
            C25052j.m39376p(gradientColorBackgroundView, "gradientColorBackgroundView");
            c27360b.iWx = gradientColorBackgroundView;
            AppMethodBeat.m2505o(135246);
            return;
        }
        AppMethodBeat.m2505o(135246);
    }
}
