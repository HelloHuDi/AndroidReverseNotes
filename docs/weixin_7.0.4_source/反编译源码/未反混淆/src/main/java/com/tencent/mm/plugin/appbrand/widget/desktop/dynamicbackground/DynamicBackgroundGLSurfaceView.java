package com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground;

import a.f.b.j;
import a.l;
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
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.ae;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.Buffer;

@l(dWo = {1, 1, 13}, dWp = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 !2\u00020\u0001:\u0002!\"B\u001b\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0014J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J\u0006\u0010\u0017\u001a\u00020\u000fJ\u000e\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\fJ\u0012\u0010\u001d\u001a\u00020\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010 \u001a\u00020\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/DynamicBackgroundGLSurfaceView;", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mDelayPauseRunnable", "Ljava/lang/Runnable;", "mRenderer", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/DynamicBackgroundGLSurfaceView$GLRenderer;", "needPause", "", "showGradientView", "onAttachedToWindow", "", "onDetachedFromWindow", "onResume", "onVisibilityChanged", "changedView", "Landroid/view/View;", "visibility", "", "release", "setGradientBackgroundView", "gradientColorBackgroundView", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GradientColorBackgroundView;", "setShowGradientView", "show", "surfaceCreated", "holder", "Landroid/view/SurfaceHolder;", "surfaceDestroyed", "Companion", "GLRenderer", "plugin-appbrand-integration_release"})
public final class DynamicBackgroundGLSurfaceView extends GameGLSurfaceView {
    public static final a iZk = new a();
    private b iZh;
    private boolean iZi;
    private boolean iZj;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/DynamicBackgroundGLSurfaceView$Companion;", "", "()V", "DRAW_LOG", "", "TAG", "", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u000e\u0018\u0000 42\u00020\u0001:\u00014B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\u001a\u0010\u001d\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\bH\u0016J\u001c\u0010!\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010$\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010%\u001a\u00020\u001b2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010(\u001a\u00020\u001bH\u0016J\b\u0010)\u001a\u00020\u001bH\u0016J\"\u0010*\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u0006H\u0016J\u0006\u0010-\u001a\u00020\u001bJ\b\u0010.\u001a\u00020\u001bH\u0002J\u000e\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u00020\u000eJ\u000e\u00101\u001a\u00020\u001b2\u0006\u00102\u001a\u00020\bJ\u000e\u00103\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u00065"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/DynamicBackgroundGLSurfaceView$GLRenderer;", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$Renderer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "drawCount", "", "hasPostAlphaAnimation", "", "isAlphaAnimating", "()Z", "setAlphaAnimating", "(Z)V", "mGradientBgView", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GradientColorBackgroundView;", "mLastDraw", "", "mNativeRenderer", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/DynamicBackgroundNative;", "needCheckBlack", "needCheckCrash", "showGradientView", "surfaceView", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView;", "viewHeight", "viewWidth", "init", "", "onDestroy", "onDrawFrame", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "isPaused", "onEGLCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "onEGLSurfaceChanged", "onError", "e", "", "onPause", "onResume", "onSurfaceSizeChanged", "width", "height", "release", "reset", "setGradientBackgroundView", "gradientColorBackgroundView", "setShowGradientView", "show", "setSurfaceView", "Companion", "plugin-appbrand-integration_release"})
    public static final class b implements n {
        private static long iZu = 500;
        public static final a iZv = new a();
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

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        static final class c implements Runnable {
            final /* synthetic */ b iZw;

            @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
            /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.DynamicBackgroundGLSurfaceView$b$c$1 */
            static final class AnonymousClass1 implements Runnable {
                final /* synthetic */ c iZy;

                AnonymousClass1(c cVar) {
                    this.iZy = cVar;
                }

                public final void run() {
                    AppMethodBeat.i(135227);
                    GameGLSurfaceView b = this.iZy.iZw.iZr;
                    if (b != null) {
                        b.onPause();
                    }
                    b = this.iZy.iZw.iZr;
                    if (b != null) {
                        b.setVisibility(4);
                        AppMethodBeat.o(135227);
                        return;
                    }
                    AppMethodBeat.o(135227);
                }
            }

            c(b bVar) {
                this.iZw = bVar;
            }

            public final void run() {
                AppMethodBeat.i(135228);
                GradientColorBackgroundView a = this.iZw.iWx;
                if (a != null) {
                    a.setVisibility(0);
                }
                a = this.iZw.iWx;
                if (a != null) {
                    a.setAlpha(1.0f);
                }
                ab.d("MicroMsg.DynamicBgSurfaceView", "alvinluo showGradientView");
                GameGLSurfaceView b = this.iZw.iZr;
                if (b != null) {
                    b.postDelayed(new AnonymousClass1(this), 50);
                    AppMethodBeat.o(135228);
                    return;
                }
                AppMethodBeat.o(135228);
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\u0004J\u0016\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010J(\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0007\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/DynamicBackgroundGLSurfaceView$GLRenderer$Companion;", "", "()V", "ALPHA_ANIMATION_DURATION", "", "checkBlackScreen", "", "buf", "Ljava/nio/ByteBuffer;", "width", "", "height", "getAlphaAnimation", "loadShader", "type", "shaderCode", "", "saveRgb2Bitmap", "Landroid/graphics/Bitmap;", "Ljava/nio/Buffer;", "filename", "updateAlphaAnimation", "", "duration", "plugin-appbrand-integration_release"})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b) {
                this();
            }

            /* JADX WARNING: Removed duplicated region for block: B:12:0x0054 A:{SYNTHETIC, Splitter:B:12:0x0054} */
            /* JADX WARNING: Removed duplicated region for block: B:18:0x0060 A:{SYNTHETIC, Splitter:B:18:0x0060} */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public static Bitmap a(Buffer buffer, String str) {
                Throwable th;
                AppMethodBeat.i(135224);
                j.p(buffer, "buf");
                j.p(str, "filename");
                ab.d("TryOpenGL", "Creating ".concat(String.valueOf(str)));
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
                        AppMethodBeat.o(135224);
                        return createBitmap;
                    } catch (IOException e2) {
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException e3) {
                            }
                        }
                        AppMethodBeat.o(135224);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException e4) {
                            }
                        }
                        AppMethodBeat.o(135224);
                        throw th;
                    }
                } catch (IOException e5) {
                    bufferedOutputStream = null;
                    if (bufferedOutputStream != null) {
                    }
                    AppMethodBeat.o(135224);
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedOutputStream = null;
                    if (bufferedOutputStream != null) {
                    }
                    AppMethodBeat.o(135224);
                    throw th;
                }
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        static final class b implements Runnable {
            final /* synthetic */ b iZw;

            @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, dWq = {"com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/DynamicBackgroundGLSurfaceView$GLRenderer$onDrawFrame$1$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-appbrand-integration_release"})
            /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.DynamicBackgroundGLSurfaceView$b$b$1 */
            public static final class AnonymousClass1 implements AnimatorListener {
                final /* synthetic */ b iZx;

                AnonymousClass1(b bVar) {
                    this.iZx = bVar;
                }

                public final void onAnimationRepeat(Animator animator) {
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(135225);
                    GradientColorBackgroundView a = this.iZx.iZw.iWx;
                    if (a != null) {
                        a.setVisibility(4);
                    }
                    this.iZx.iZw.iZp = false;
                    AppMethodBeat.o(135225);
                }

                public final void onAnimationCancel(Animator animator) {
                    this.iZx.iZw.iZp = false;
                }

                public final void onAnimationStart(Animator animator) {
                }
            }

            b(b bVar) {
                this.iZw = bVar;
            }

            public final void run() {
                AppMethodBeat.i(135226);
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
                        ab.d("MicroMsg.DynamicBgSurfaceView", "alvinluo GradientColorBackgroundView do alpha animation");
                        a = this.iZw.iWx;
                        if (a != null) {
                            ViewPropertyAnimator animate = a.animate();
                            if (animate != null) {
                                animate = animate.alpha(0.0f);
                                if (animate != null) {
                                    ViewPropertyAnimator duration = animate.setDuration(b.iZu);
                                    if (duration != null) {
                                        animate = duration.setListener(new AnonymousClass1(this));
                                        if (animate != null) {
                                            animate.start();
                                            AppMethodBeat.o(135226);
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    AppMethodBeat.o(135226);
                    return;
                }
                AppMethodBeat.o(135226);
            }
        }

        public b(Context context) {
            j.p(context, "context");
            AppMethodBeat.i(135238);
            if (!com.tencent.mm.plugin.appbrand.widget.desktop.b.aPe() || d.aPS()) {
                ab.e("MicroMsg.DynamicBgSurfaceView", "alvinluo AppBrandDesktopConfig not enableNativeDynamicBackground");
            } else {
                this.iZl = new DynamicBackgroundNative();
            }
            this.context = context;
            AppMethodBeat.o(135238);
        }

        private final void init() {
            AppMethodBeat.i(135229);
            ab.i("MicroMsg.DynamicBgSurfaceView", "alvinluo NativeRender init");
            DynamicBackgroundNative dynamicBackgroundNative;
            try {
                dynamicBackgroundNative = this.iZl;
                if (dynamicBackgroundNative != null) {
                    dynamicBackgroundNative.nativeInit();
                    AppMethodBeat.o(135229);
                    return;
                }
                AppMethodBeat.o(135229);
            } catch (Throwable th) {
                d.aPL();
                AppMethodBeat.o(135229);
            }
        }

        public final void aPC() {
            AppMethodBeat.i(135230);
            try {
                init();
                Point hy = ae.hy(this.context);
                this.iZn = hy.x;
                this.iZo = hy.y;
                ab.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onEGLCreated width: %d, height: %d", Integer.valueOf(this.iZn), Integer.valueOf(this.iZo));
                ab.i("MicroMsg.DynamicBgSurfaceView", "alvinluo handle: %s, %s, %s", EGL14.eglGetCurrentContext(), EGL14.eglGetCurrentDisplay(), EGL14.eglGetCurrentSurface(12377));
                DynamicBackgroundNative dynamicBackgroundNative = this.iZl;
                if (dynamicBackgroundNative != null) {
                    dynamicBackgroundNative.surfaceCreated(this.iZn, this.iZo);
                }
                dynamicBackgroundNative = this.iZl;
                if (dynamicBackgroundNative != null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    e eVar = e.iZE;
                    String stringBuilder2 = stringBuilder.append(e.dn(this.context)).append("scene_shaderv.glsl").toString();
                    StringBuilder stringBuilder3 = new StringBuilder();
                    e eVar2 = e.iZE;
                    String stringBuilder4 = stringBuilder3.append(e.dn(this.context)).append("scene_shaderf.glsl").toString();
                    StringBuilder stringBuilder5 = new StringBuilder();
                    e eVar3 = e.iZE;
                    String stringBuilder6 = stringBuilder5.append(e.dn(this.context)).append("vertex_framebuffer_plane.glsl").toString();
                    StringBuilder stringBuilder7 = new StringBuilder();
                    e eVar4 = e.iZE;
                    String stringBuilder8 = stringBuilder7.append(e.dn(this.context)).append("frag_framebuffer_plane.glsl").toString();
                    StringBuilder stringBuilder9 = new StringBuilder();
                    e eVar5 = e.iZE;
                    String stringBuilder10 = stringBuilder9.append(e.dn(this.context)).append("texture_vertex_shader.glsl").toString();
                    StringBuilder stringBuilder11 = new StringBuilder();
                    e eVar6 = e.iZE;
                    String stringBuilder12 = stringBuilder11.append(e.dn(this.context)).append("texture_fragment_shader.glsl").toString();
                    StringBuilder stringBuilder13 = new StringBuilder();
                    e eVar7 = e.iZE;
                    String stringBuilder14 = stringBuilder13.append(e.dn(this.context)).append("bg_gradient_vertex_shader.glsl").toString();
                    StringBuilder stringBuilder15 = new StringBuilder();
                    e eVar8 = e.iZE;
                    dynamicBackgroundNative.setupGlslFiles(stringBuilder2, stringBuilder4, stringBuilder6, stringBuilder8, stringBuilder10, stringBuilder12, stringBuilder14, stringBuilder15.append(e.dn(this.context)).append("bg_gradient_fragment_shader.glsl").toString());
                }
                dynamicBackgroundNative = this.iZl;
                if (dynamicBackgroundNative != null) {
                    dynamicBackgroundNative.initView();
                }
                if (com.tencent.mm.plugin.appbrand.widget.desktop.b.aPe() && !d.aPN()) {
                    d.aPP();
                    AppMethodBeat.o(135230);
                    return;
                }
            } catch (Throwable th) {
                ab.printErrStackTrace("MicroMsg.DynamicBgSurfaceView", th, "alvinluo onEGLCreated exception", new Object[0]);
                d.aPL();
            }
            AppMethodBeat.o(135230);
        }

        public final void aPD() {
            AppMethodBeat.i(135231);
            ab.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onEGLSurfaceChanged and do nothing");
            this.eNs = 0;
            AppMethodBeat.o(135231);
        }

        /* renamed from: do */
        public final void m13do(int i, int i2) {
            AppMethodBeat.i(135232);
            try {
                ab.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onSurfaceSizeChanged width: %d, height: %d", Integer.valueOf(i), Integer.valueOf(i2));
                if (!(this.iZn == i || this.iZo == i2)) {
                    init();
                    this.iZn = i;
                    this.iZo = i2;
                    ab.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onSurfaceSizeChanged reCreated width: %d, height: %d", Integer.valueOf(this.iZn), Integer.valueOf(this.iZo));
                    DynamicBackgroundNative dynamicBackgroundNative = this.iZl;
                    if (dynamicBackgroundNative != null) {
                        dynamicBackgroundNative.surfaceCreated(this.iZn, this.iZo);
                    }
                    dynamicBackgroundNative = this.iZl;
                    if (dynamicBackgroundNative != null) {
                        StringBuilder stringBuilder = new StringBuilder();
                        e eVar = e.iZE;
                        String stringBuilder2 = stringBuilder.append(e.dn(this.context)).append("scene_shaderv.glsl").toString();
                        StringBuilder stringBuilder3 = new StringBuilder();
                        e eVar2 = e.iZE;
                        String stringBuilder4 = stringBuilder3.append(e.dn(this.context)).append("scene_shaderf.glsl").toString();
                        StringBuilder stringBuilder5 = new StringBuilder();
                        e eVar3 = e.iZE;
                        String stringBuilder6 = stringBuilder5.append(e.dn(this.context)).append("vertex_framebuffer_plane.glsl").toString();
                        StringBuilder stringBuilder7 = new StringBuilder();
                        e eVar4 = e.iZE;
                        String stringBuilder8 = stringBuilder7.append(e.dn(this.context)).append("frag_framebuffer_plane.glsl").toString();
                        StringBuilder stringBuilder9 = new StringBuilder();
                        e eVar5 = e.iZE;
                        String stringBuilder10 = stringBuilder9.append(e.dn(this.context)).append("texture_vertex_shader.glsl").toString();
                        StringBuilder stringBuilder11 = new StringBuilder();
                        e eVar6 = e.iZE;
                        String stringBuilder12 = stringBuilder11.append(e.dn(this.context)).append("texture_fragment_shader.glsl").toString();
                        StringBuilder stringBuilder13 = new StringBuilder();
                        e eVar7 = e.iZE;
                        String stringBuilder14 = stringBuilder13.append(e.dn(this.context)).append("bg_gradient_vertex_shader.glsl").toString();
                        StringBuilder stringBuilder15 = new StringBuilder();
                        e eVar8 = e.iZE;
                        dynamicBackgroundNative.setupGlslFiles(stringBuilder2, stringBuilder4, stringBuilder6, stringBuilder8, stringBuilder10, stringBuilder12, stringBuilder14, stringBuilder15.append(e.dn(this.context)).append("bg_gradient_fragment_shader.glsl").toString());
                    }
                    dynamicBackgroundNative = this.iZl;
                    if (dynamicBackgroundNative != null) {
                        dynamicBackgroundNative.initView();
                    }
                    this.eNs = 0;
                    AppMethodBeat.o(135232);
                    return;
                }
            } catch (Throwable th) {
                ab.printErrStackTrace("MicroMsg.DynamicBgSurfaceView", th, "alvinluo onSurfaceSizeChanged exception", new Object[0]);
                com.tencent.mm.plugin.appbrand.widget.desktop.b.eT(false);
            }
            AppMethodBeat.o(135232);
        }

        public final void aPE() {
            AppMethodBeat.i(135233);
            try {
                b bVar = b.iZg;
                Thread.sleep((long) b.aPz());
            } catch (Exception e) {
            }
            if (d.aPI()) {
                d.aPQ();
            }
            try {
                DynamicBackgroundNative dynamicBackgroundNative = this.iZl;
                if (dynamicBackgroundNative != null) {
                    dynamicBackgroundNative.draw();
                }
            } catch (Throwable th) {
                ab.printErrStackTrace("MicroMsg.DynamicBgSurfaceView", th, "alvinluo onDraw exception", new Object[0]);
                com.tencent.mm.plugin.appbrand.widget.desktop.b.eT(false);
            }
            if (d.aPI()) {
                this.eNs++;
                if (this.eNs >= 2) {
                    d.aPR();
                }
            }
            GradientColorBackgroundView gradientColorBackgroundView;
            if (this.iZj || this.iZq) {
                if (this.iZj) {
                    GradientColorBackgroundView gradientColorBackgroundView2 = this.iWx;
                    if (gradientColorBackgroundView2 == null || gradientColorBackgroundView2.getVisibility() != 0) {
                        gradientColorBackgroundView = this.iWx;
                        if (gradientColorBackgroundView != null) {
                            gradientColorBackgroundView.post(new c(this));
                            AppMethodBeat.o(135233);
                            return;
                        }
                    }
                }
                AppMethodBeat.o(135233);
                return;
            }
            this.iZq = true;
            gradientColorBackgroundView = this.iWx;
            if (gradientColorBackgroundView != null) {
                gradientColorBackgroundView.post(new b(this));
                AppMethodBeat.o(135233);
                return;
            }
            AppMethodBeat.o(135233);
        }

        public final void onResume() {
            AppMethodBeat.i(135234);
            ab.i("MicroMsg.DynamicBgSurfaceView", "alvinluo DynamicBackgroundSurfaceView.Renderer onResume");
            this.iZt = true;
            AppMethodBeat.o(135234);
        }

        public final void onDestroy() {
            AppMethodBeat.i(135235);
            ab.i("MicroMsg.DynamicBgSurfaceView", "alvinluo DynamicBackgroundSurfaceView.Renderer onDestroy");
            try {
                DynamicBackgroundNative dynamicBackgroundNative = this.iZl;
                if (dynamicBackgroundNative != null) {
                    dynamicBackgroundNative.nativeRelease();
                    AppMethodBeat.o(135235);
                    return;
                }
                AppMethodBeat.o(135235);
            } catch (Throwable th) {
                ab.printErrStackTrace("MicroMsg.DynamicBgSurfaceView", th, "alvinluo nativeRelease exception", new Object[0]);
                AppMethodBeat.o(135235);
            }
        }

        public final void onPause() {
            AppMethodBeat.i(135236);
            ab.i("MicroMsg.DynamicBgSurfaceView", "alvinluo DynamicBackgroundSurfaceView.Renderer onPause");
            AppMethodBeat.o(135236);
        }

        public final void aPF() {
            AppMethodBeat.i(135237);
            ab.e("MicroMsg.DynamicBgSurfaceView", "alvinluo GLSurfaceView onError");
            d.aPM();
            AppMethodBeat.o(135237);
        }

        static {
            AppMethodBeat.i(135239);
            AppMethodBeat.o(135239);
        }
    }

    static {
        AppMethodBeat.i(135248);
        AppMethodBeat.o(135248);
    }

    public DynamicBackgroundGLSurfaceView(Context context, byte b) {
        this(context);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDetachedFromWindow() {
        AppMethodBeat.i(135240);
        super.onDetachedFromWindow();
        ab.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onDetachedFromWindow");
        AppMethodBeat.o(135240);
    }

    private /* synthetic */ DynamicBackgroundGLSurfaceView(Context context) {
        this(context, null);
    }

    public DynamicBackgroundGLSurfaceView(Context context, AttributeSet attributeSet) {
        j.p(context, "context");
        super(context, attributeSet);
        AppMethodBeat.i(135247);
        setEGLContextClientVersion(2);
        aPV();
        setPreserveEGLContextOnPause(true);
        this.iZh = new b(context);
        setRenderer(this.iZh);
        getHolder().setFormat(-3);
        b bVar = this.iZh;
        if (bVar != null) {
            GameGLSurfaceView gameGLSurfaceView = this;
            j.p(gameGLSurfaceView, "surfaceView");
            bVar.iZr = gameGLSurfaceView;
            AppMethodBeat.o(135247);
            return;
        }
        AppMethodBeat.o(135247);
    }

    public final void setShowGradientView(boolean z) {
        this.iZj = z;
        b bVar = this.iZh;
        if (bVar != null) {
            bVar.iZj = z;
            if (!bVar.iZj) {
                bVar.iZq = false;
            }
        }
    }

    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(135241);
        super.surfaceDestroyed(surfaceHolder);
        ab.i("MicroMsg.DynamicBgSurfaceView", "alvinluo surfaceDestroyed");
        b bVar = this.iZh;
        if (bVar != null) {
            bVar.iZp = false;
            AppMethodBeat.o(135241);
            return;
        }
        AppMethodBeat.o(135241);
    }

    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(135242);
        super.surfaceCreated(surfaceHolder);
        ab.i("MicroMsg.DynamicBgSurfaceView", "alvinluo surfaceCreated");
        AppMethodBeat.o(135242);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onAttachedToWindow() {
        AppMethodBeat.i(135243);
        super.onAttachedToWindow();
        ab.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onAttachedToWindow");
        AppMethodBeat.o(135243);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onVisibilityChanged(View view, int i) {
        AppMethodBeat.i(135244);
        j.p(view, "changedView");
        super.onVisibilityChanged(view, i);
        ab.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onVisibilityChanged: %d", Integer.valueOf(i));
        if (i != 0 && this.iZi) {
            ab.i("MicroMsg.DynamicBgSurfaceView", "alvinluo needPause");
            this.iZi = false;
        }
        AppMethodBeat.o(135244);
    }

    public final void onResume() {
        AppMethodBeat.i(135245);
        super.onResume();
        this.iZi = false;
        AppMethodBeat.o(135245);
    }

    public final void setGradientBackgroundView(GradientColorBackgroundView gradientColorBackgroundView) {
        AppMethodBeat.i(135246);
        j.p(gradientColorBackgroundView, "gradientColorBackgroundView");
        b bVar = this.iZh;
        if (bVar != null) {
            j.p(gradientColorBackgroundView, "gradientColorBackgroundView");
            bVar.iWx = gradientColorBackgroundView;
            AppMethodBeat.o(135246);
            return;
        }
        AppMethodBeat.o(135246);
    }
}
