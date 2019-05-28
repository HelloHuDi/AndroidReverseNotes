package com.tencent.p177mm.plugin.appbrand.jsapi.p317u.p320b;

import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.opengl.GLES20;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C33183g;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33184d;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33303e;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10379b;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10380c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10381d;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45608m;
import com.tencent.p177mm.plugin.appbrand.jsapi.p317u.p320b.C38394f.C27123a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p317u.p320b.p902a.C42585c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p317u.p320b.p902a.C42586d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p317u.p320b.p902a.C42587e;
import com.tencent.p177mm.plugin.appbrand.jsapi.p317u.p320b.p902a.C45625b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p317u.p320b.p903b.C38390a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p317u.p320b.p903b.C38393c;
import com.tencent.p177mm.plugin.appbrand.p893e.C19213f;
import com.tencent.p177mm.plugin.appbrand.p893e.C42433e;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.b.c */
public final class C27116c extends C42433e {
    boolean hLW;
    boolean hLX;
    C38393c idR;
    C42588g idS;
    C38394f idT;
    C42589h idU;
    private C45627e idV;
    private C33303e idW;
    private C10381d idX;
    private C10379b idY;
    private C10380c idZ;
    boolean iea;
    boolean ieb;
    boolean iec;
    boolean ied;
    boolean iee;
    boolean ief;
    private boolean ieg;
    boolean ieh = false;
    private boolean iei = false;
    private int iej;
    private int iek;
    int iel;
    int iem = 0;
    private String ien;
    private String ieo;
    private String iep;
    boolean ieq;
    boolean ier;
    private final ConcurrentLinkedQueue<Runnable> ies = new ConcurrentLinkedQueue();
    private Surface mSurface;
    private SurfaceTexture mSurfaceTexture;
    int mVideoHeight;
    int mVideoWidth;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.b.c$10 */
    class C1054410 implements OnVideoSizeChangedListener {
        C1054410() {
        }

        public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            AppMethodBeat.m2504i(117396);
            C4990ab.m7417i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler onVideoSizeChanged, width:%d, height:%d", Integer.valueOf(i), Integer.valueOf(i2));
            C27116c.this.aGH();
            if (C27116c.this.aGN() && C27116c.this.iea && C27116c.this.idR != null) {
                int duration = C27116c.this.idR.getDuration();
                if (!((C27116c.this.idS == null || i == C27116c.this.mVideoWidth) && i2 == C27116c.this.mVideoHeight && duration == C27116c.this.iel)) {
                    C27116c.this.idS.mo22024L(i, i2, duration);
                }
            }
            C27116c.this.mVideoWidth = i;
            C27116c.this.mVideoHeight = i2;
            if (C27116c.this.idR != null) {
                C27116c.this.iel = C27116c.this.idR.getDuration();
            }
            AppMethodBeat.m2505o(117396);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.b.c$13 */
    class C1054513 implements Runnable {
        C1054513() {
        }

        public final void run() {
            AppMethodBeat.m2504i(117399);
            if (C27116c.this.idR != null && C27116c.this.iea && C27116c.this.iee) {
                C4990ab.m7416i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handleWebViewForeground runnable, video playing when enter background");
                C27116c.this.iee = false;
                C27116c.this.play();
            }
            AppMethodBeat.m2505o(117399);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.b.c$3 */
    class C194933 implements C10381d {
        C194933() {
        }

        /* renamed from: wU */
        public final void mo6095wU() {
            AppMethodBeat.m2504i(117389);
            C27116c.this.aGJ();
            AppMethodBeat.m2505o(117389);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.b.c$5 */
    class C194955 implements C10380c {
        C194955() {
        }

        public final void onDestroy() {
            AppMethodBeat.m2504i(117391);
            C27116c.this.aGK();
            AppMethodBeat.m2505o(117391);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.b.c$11 */
    class C2711411 implements OnBufferingUpdateListener {
        C2711411() {
        }

        public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            AppMethodBeat.m2504i(117397);
            if (i != C27116c.this.iem) {
                C27116c.this.iem = i;
                C4990ab.m7417i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler onBufferingUpdate, percent:%s", Integer.valueOf(i));
            }
            if (C27116c.this.aGN() && C27116c.this.iea) {
                C27116c.this.idS.mo22029oJ(i);
            }
            AppMethodBeat.m2505o(117397);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.b.c$6 */
    class C271156 implements OnErrorListener {
        C271156() {
        }

        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            AppMethodBeat.m2504i(117392);
            C4990ab.m7417i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler onError, what:%d, extra:%d", Integer.valueOf(i), Integer.valueOf(i2));
            if (C27116c.this.idT != null) {
                C27116c.this.idT.mo44768dh(i, i2);
                if (C27116c.this.idU != null) {
                    if (i == -1024) {
                        C27116c.this.idU.mo22037gq((long) (-i2));
                    } else {
                        C27116c.this.idU.mo22037gq(41);
                    }
                }
            }
            AppMethodBeat.m2505o(117392);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.b.c$12 */
    class C2711712 implements C27123a {
        C2711712() {
        }

        /* renamed from: I */
        public final void mo44783I(String str, int i, int i2) {
            AppMethodBeat.m2504i(117398);
            C4990ab.m7421w("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler send video error event, what:%d, extra:%d", Integer.valueOf(i), Integer.valueOf(i2));
            if (C27116c.this.aGN()) {
                C27116c.this.idS.mo22023I(str, i, i2);
            }
            if (C27116c.this.idU != null) {
                C27116c.this.idU.mo22037gq(0);
            }
            AppMethodBeat.m2505o(117398);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.b.c$9 */
    class C271199 implements OnSeekCompleteListener {
        C271199() {
        }

        public final void onSeekComplete(MediaPlayer mediaPlayer) {
            AppMethodBeat.m2504i(117395);
            C4990ab.m7416i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler onSeekComplete");
            if (C27116c.this.ieb) {
                C4990ab.m7416i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "onSeekComplete, start when seek complete");
                C27116c.this.ieb = false;
                C27116c.this.play();
                AppMethodBeat.m2505o(117395);
                return;
            }
            boolean isPlaying = C27116c.this.idR.isPlaying();
            if (C27116c.this.iec) {
                C4990ab.m7417i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "onSeekComplete, video playing before seeking, isCurrentPlaying:%b, position:%s, duration:%s", Boolean.valueOf(isPlaying), Integer.valueOf(C27116c.this.idR.getCurrentPosition()), Integer.valueOf(C27116c.this.idR.getDuration()));
                C27116c.this.iec = false;
                if (C27116c.this.idR.getCurrentPosition() / 1000 < C27116c.this.idR.getDuration() / 1000) {
                    C4990ab.m7416i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "onSeekComplete, video not end");
                    if (isPlaying && C27116c.this.aGN()) {
                        C4990ab.m7416i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "onSeekComplete, dispatch play again");
                        C27116c.this.idS.onVideoPlay();
                        AppMethodBeat.m2505o(117395);
                        return;
                    }
                }
                C4990ab.m7416i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "onSeekComplete, video ends");
                C27116c.this.idR.pause();
                C27116c.this.idR.start();
                AppMethodBeat.m2505o(117395);
                return;
            }
            C4990ab.m7417i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "onSeekComplete, video not playing before seeking, isCurrentPlaying:%b", Boolean.valueOf(isPlaying));
            if (!isPlaying && C27116c.this.aGN()) {
                C4990ab.m7416i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "onSeekComplete, dispatch pause again");
                C27116c.this.idS.onVideoPause();
            }
            AppMethodBeat.m2505o(117395);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.b.c$1 */
    class C271201 implements OnInfoListener {
        C271201() {
        }

        public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            AppMethodBeat.m2504i(117387);
            C4990ab.m7417i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler onInfo, what:%d, extra:%d", Integer.valueOf(i), Integer.valueOf(i2));
            if (i == 701) {
                C27116c.this.ied = C27116c.this.idR.isPlaying();
                C4990ab.m7417i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "onInfo, buffering start, isPlayingBeforeBuffering:%b", Boolean.valueOf(C27116c.this.ied));
                if (C27116c.this.aGN()) {
                    C27116c.this.idS.onVideoWaiting();
                }
            } else if (i == 702) {
                boolean isPlaying = C27116c.this.idR.isPlaying();
                C4990ab.m7417i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "onInfo, buffering end, isPlayingBeforeBuffering:%b, isCurrentPlaying", Boolean.valueOf(C27116c.this.ied), Boolean.valueOf(isPlaying));
                if (C27116c.this.ied) {
                    C27116c.this.ied = false;
                    if (isPlaying && C27116c.this.aGN()) {
                        C4990ab.m7416i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "onInfo, buffering end, notify video play");
                        C27116c.this.idS.onVideoPlay();
                    }
                } else if (!isPlaying && C27116c.this.aGN()) {
                    C4990ab.m7416i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "onInfo, buffering end, notify video pause");
                    C27116c.this.idS.onVideoPause();
                }
            } else if (i2 == -1004) {
                C4990ab.m7417i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "onInfo, special error, what:%d, extra:%d", Integer.valueOf(i), Integer.valueOf(i2));
                if (C27116c.this.idT != null) {
                    C27116c.this.idT.mo44768dh(i, i2);
                }
                if (C27116c.this.idU != null) {
                    C27116c.this.idU.mo22037gq(40);
                }
            }
            AppMethodBeat.m2505o(117387);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.b.c$7 */
    class C271217 implements OnPreparedListener {
        C271217() {
        }

        public final void onPrepared(MediaPlayer mediaPlayer) {
            AppMethodBeat.m2504i(117393);
            C4990ab.m7416i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler onPrepared");
            C27116c.this.iea = true;
            C27116c.this.aGH();
            if (C27116c.this.idT != null) {
                C27116c.this.idT.init();
            }
            if (C27116c.this.aGN() && C27116c.this.idR != null) {
                C27116c.this.idS.mo22024L(C27116c.this.idR.getVideoWidth(), C27116c.this.idR.getVideoHeight(), C27116c.this.idR.getDuration());
            }
            if (C27116c.this.ier) {
                C4990ab.m7416i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "onPrepared, stop video auto play when webview in background");
                if (C27116c.this.idR != null) {
                    C27116c.this.idR.mo61045eu(false);
                }
                C27116c.this.iee = C27116c.this.ief;
            } else if (C27116c.this.ief) {
                C4990ab.m7416i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "onPrepared, start when prepared");
                if (C27116c.this.aGN()) {
                    C27116c.this.idS.onVideoPlay();
                    AppMethodBeat.m2505o(117393);
                    return;
                }
            }
            AppMethodBeat.m2505o(117393);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.b.c$8 */
    class C271228 implements OnCompletionListener {
        C271228() {
        }

        public final void onCompletion(MediaPlayer mediaPlayer) {
            AppMethodBeat.m2504i(117394);
            C4990ab.m7416i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler onCompletion");
            if (C27116c.this.aGN()) {
                C27116c.this.idS.aGE();
            }
            if (C27116c.this.ieh) {
                C4990ab.m7416i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "onCompletion, video loop playing");
                C27116c.this.ieb = true;
                C27116c.this.seek(0);
                AppMethodBeat.m2505o(117394);
                return;
            }
            C4990ab.m7416i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "onCompletion, video end playing");
            C27116c.this.ieq = true;
            AppMethodBeat.m2505o(117394);
        }
    }

    public C27116c() {
        AppMethodBeat.m2504i(117400);
        aGG();
        AppMethodBeat.m2505o(117400);
    }

    private void aGG() {
        AppMethodBeat.m2504i(117401);
        this.idR = new C38390a();
        this.idR.setOnInfoListener(new C271201());
        this.idR.setOnErrorListener(new C271156());
        this.idR.setOnPreparedListener(new C271217());
        this.idR.setOnCompletionListener(new C271228());
        this.idR.setOnSeekCompleteListener(new C271199());
        this.idR.setOnVideoSizeChangedListener(new C1054410());
        this.idR.setOnBufferingUpdateListener(new C2711411());
        this.idV = new C45627e();
        this.idU = new C10546d();
        this.idT = new C27110a(this, new C2711712());
        AppMethodBeat.m2505o(117401);
    }

    /* Access modifiers changed, original: final */
    public final void aGH() {
        AppMethodBeat.m2504i(117402);
        if (C5046bo.isNullOrNil(this.ieo)) {
            C4990ab.m7416i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler adjust objectFit, no video objectFit");
        } else if (!this.iea || aAn() == null || this.idV == null) {
            C4990ab.m7416i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler adjust objectFit, video not prepared");
            AppMethodBeat.m2505o(117402);
            return;
        } else {
            int i;
            C45627e c45627e = this.idV;
            String str = this.ieo;
            int i2 = this.iej;
            int i3 = this.iek;
            int i4 = this.mVideoWidth;
            int i5 = this.mVideoHeight;
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7420w("MicroMsg.AppBrand.SameLayer.AppBrandVideoScaleHandler", "calculateScale, scale type is null");
                i = 0;
            } else if (i2 == 0 || i3 == 0 || i4 == 0 || i5 == 0) {
                C4990ab.m7420w("MicroMsg.AppBrand.SameLayer.AppBrandVideoScaleHandler", "calculateScale, width or height is 0");
                i = 0;
            } else if (str.equalsIgnoreCase(c45627e.iey) && c45627e.ieu == i2 && c45627e.iev == i3 && c45627e.videoWidth == i4 && c45627e.videoHeight == i5) {
                C4990ab.m7420w("MicroMsg.AppBrand.SameLayer.AppBrandVideoScaleHandler", "calculateScale, same as last calculated");
                i = 1;
            } else {
                C45627e c45627e2;
                c45627e.iey = str;
                c45627e.ieu = i2;
                c45627e.iev = i3;
                c45627e.videoWidth = i4;
                c45627e.videoHeight = i5;
                float f = (((float) c45627e.videoWidth) * 1.0f) / ((float) c45627e.videoHeight);
                float f2 = (((float) c45627e.ieu) * 1.0f) / ((float) c45627e.iev);
                if (c45627e.iey.equalsIgnoreCase("contain")) {
                    if (c45627e.ieu < c45627e.iev) {
                        c45627e.iex = (int) (((float) c45627e.ieu) / f);
                        c45627e.iew = c45627e.ieu;
                        if (c45627e.iex > c45627e.iev) {
                            c45627e2 = c45627e;
                        }
                    } else {
                        c45627e.iew = (int) (((float) c45627e.iev) * f);
                        c45627e.iex = c45627e.iev;
                        if (c45627e.iew > c45627e.ieu) {
                            c45627e.iex = (int) (((float) c45627e.ieu) / f);
                            c45627e.iew = c45627e.ieu;
                        }
                    }
                    c45627e.iez = (((float) c45627e.iew) * 1.0f) / ((float) c45627e.ieu);
                    c45627e.ieA = (((float) c45627e.iex) * 1.0f) / ((float) c45627e.iev);
                    C4990ab.m7411d("MicroMsg.AppBrand.SameLayer.AppBrandVideoScaleHandler", "calculateScale, screen[%d, %d], video[%d, %d], measure[%d, %d], scale[%f, %f]", Integer.valueOf(c45627e.ieu), Integer.valueOf(c45627e.iev), Integer.valueOf(c45627e.videoWidth), Integer.valueOf(c45627e.videoHeight), Integer.valueOf(c45627e.iew), Integer.valueOf(c45627e.iex), Float.valueOf(c45627e.iez), Float.valueOf(c45627e.ieA));
                    i = 1;
                } else {
                    if (c45627e.iey.equalsIgnoreCase("fill")) {
                        c45627e.iex = c45627e.iev;
                        c45627e.iew = c45627e.ieu;
                    } else if (c45627e.iey.equalsIgnoreCase("cover")) {
                        if (c45627e.ieu > c45627e.iev) {
                            c45627e.iex = (int) (((float) c45627e.ieu) / f);
                            c45627e.iew = c45627e.ieu;
                            if (c45627e.iex < c45627e.iev) {
                                c45627e2 = c45627e;
                            }
                        } else {
                            c45627e.iew = (int) (((float) c45627e.iev) * f);
                            c45627e.iex = c45627e.iev;
                            if (c45627e.iew < c45627e.ieu) {
                                c45627e.iex = (int) (((float) c45627e.ieu) / f);
                                c45627e.iew = c45627e.ieu;
                            }
                        }
                    } else if (((double) Math.abs(f - f2)) > 0.05d) {
                        if (c45627e.ieu < c45627e.iev) {
                            c45627e.iex = (int) (((float) c45627e.ieu) / f);
                            c45627e.iew = c45627e.ieu;
                        } else {
                            c45627e.iew = (int) (((float) c45627e.iev) * f);
                            c45627e.iex = c45627e.iev;
                        }
                    } else if (c45627e.ieu > c45627e.iev) {
                        c45627e.iex = (int) (((float) c45627e.ieu) / f);
                        c45627e.iew = c45627e.ieu;
                    } else {
                        c45627e2 = c45627e;
                    }
                    c45627e.iez = (((float) c45627e.iew) * 1.0f) / ((float) c45627e.ieu);
                    c45627e.ieA = (((float) c45627e.iex) * 1.0f) / ((float) c45627e.iev);
                    C4990ab.m7411d("MicroMsg.AppBrand.SameLayer.AppBrandVideoScaleHandler", "calculateScale, screen[%d, %d], video[%d, %d], measure[%d, %d], scale[%f, %f]", Integer.valueOf(c45627e.ieu), Integer.valueOf(c45627e.iev), Integer.valueOf(c45627e.videoWidth), Integer.valueOf(c45627e.videoHeight), Integer.valueOf(c45627e.iew), Integer.valueOf(c45627e.iex), Float.valueOf(c45627e.iez), Float.valueOf(c45627e.ieA));
                    i = 1;
                }
                c45627e2.iew = (int) (f * ((float) c45627e2.iev));
                c45627e2.iex = c45627e2.iev;
                c45627e.iez = (((float) c45627e.iew) * 1.0f) / ((float) c45627e.ieu);
                c45627e.ieA = (((float) c45627e.iex) * 1.0f) / ((float) c45627e.iev);
                C4990ab.m7411d("MicroMsg.AppBrand.SameLayer.AppBrandVideoScaleHandler", "calculateScale, screen[%d, %d], video[%d, %d], measure[%d, %d], scale[%f, %f]", Integer.valueOf(c45627e.ieu), Integer.valueOf(c45627e.iev), Integer.valueOf(c45627e.videoWidth), Integer.valueOf(c45627e.videoHeight), Integer.valueOf(c45627e.iew), Integer.valueOf(c45627e.iex), Float.valueOf(c45627e.iez), Float.valueOf(c45627e.ieA));
                i = 1;
            }
            if (i != 0) {
                C4990ab.m7417i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler adjust objectFit:%s, scale:[%s, %s]", this.ieo, Float.valueOf(this.idV.iez), Float.valueOf(this.idV.ieA));
                C19213f aAn = aAn();
                String type = getType();
                i2 = getId();
                float f3 = this.idV.iez;
                float f4 = this.idV.ieA;
                if (!(aAn == null || aAn.mo20076yp() == null)) {
                    C4990ab.m7417i("MicroMsg.AppBrand.SameLayer.WebViewExtendPluginUtil", "applyPluginTextureScale, %s#%d, scale:[%s,%s]", type, Integer.valueOf(i2), Float.valueOf(f3), Float.valueOf(f4));
                    aAn.mo20076yp().setPluginTextureScale(type, i2, f3, f4);
                }
                AppMethodBeat.m2505o(117402);
                return;
            }
        }
        AppMethodBeat.m2505o(117402);
    }

    /* renamed from: a */
    public final boolean mo41593a(C45608m c45608m) {
        AppMethodBeat.m2504i(117403);
        if (this.hpN || (c45608m != null && c45608m.getName().equals(C42586d.NAME))) {
            AppMethodBeat.m2505o(117403);
            return true;
        }
        AppMethodBeat.m2505o(117403);
        return false;
    }

    /* renamed from: d */
    public final void mo32980d(SurfaceTexture surfaceTexture) {
        AppMethodBeat.m2504i(117404);
        super.mo32980d(surfaceTexture);
        C4990ab.m7417i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "*** handler(%s) handlePluginReady", mo67958wP());
        this.ieb = false;
        this.iec = false;
        this.ied = false;
        this.mSurfaceTexture = surfaceTexture;
        this.mSurface = new Surface(surfaceTexture);
        if (this.idR != null) {
            this.idR.setSurface(this.mSurface);
        }
        aGI();
        AppMethodBeat.m2505o(117404);
    }

    private void aGI() {
        AppMethodBeat.m2504i(117405);
        synchronized (this.ies) {
            try {
                if (!this.ies.isEmpty()) {
                    C4990ab.m7417i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler flushPendingTasks, size:%d", Integer.valueOf(this.ies.size()));
                    Iterator it = this.ies.iterator();
                    while (it.hasNext()) {
                        ((Runnable) it.next()).run();
                    }
                    this.ies.clear();
                }
            } finally {
                AppMethodBeat.m2505o(117405);
            }
        }
    }

    /* renamed from: yr */
    public final void mo32982yr() {
        AppMethodBeat.m2504i(117406);
        super.mo32982yr();
        C4990ab.m7417i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "*** handler(%s) handlePluginDestroy", mo67958wP());
        pause();
        AppMethodBeat.m2505o(117406);
    }

    public final void aGJ() {
        AppMethodBeat.m2504i(117407);
        C4990ab.m7417i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "*** handler(%s) handleWebViewForeground", mo67958wP());
        this.ier = false;
        C1054513 c1054513 = new C1054513();
        if (mo41593a(null)) {
            c1054513.run();
            AppMethodBeat.m2505o(117407);
            return;
        }
        C4990ab.m7416i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler webview foreground, plugin is not ready, add to pending tasks");
        this.ies.add(c1054513);
        AppMethodBeat.m2505o(117407);
    }

    /* renamed from: oK */
    public final void mo44778oK(final int i) {
        AppMethodBeat.m2504i(117408);
        C4990ab.m7417i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "*** handler(%s) handleWebViewBackground, type:%d", mo67958wP(), Integer.valueOf(i));
        this.ier = true;
        C271182 c271182 = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(117388);
                if ((i != 2 || C27116c.this.hLX) && (i != 1 || C27116c.this.hLW)) {
                    if (C27116c.this.idR != null && C27116c.this.iea) {
                        C27116c.this.iee = C27116c.this.idR.isPlaying();
                        C4990ab.m7417i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handleWebViewBackground runnable, video playing state when enter background:%s", Boolean.valueOf(C27116c.this.iee));
                        C27116c.this.pause();
                    }
                    AppMethodBeat.m2505o(117388);
                    return;
                }
                C4990ab.m7416i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handleWebViewBackground runnable, video not auto pause");
                AppMethodBeat.m2505o(117388);
            }
        };
        if (mo41593a(null)) {
            c271182.run();
            AppMethodBeat.m2505o(117408);
            return;
        }
        C4990ab.m7416i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler webview background, plugin is not ready, add to pending tasks");
        this.ies.add(c271182);
        AppMethodBeat.m2505o(117408);
    }

    public final void aGK() {
        AppMethodBeat.m2504i(117409);
        C4990ab.m7417i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "*** handler(%s) handleWebViewDestroy", mo67958wP());
        release();
        AppMethodBeat.m2505o(117409);
    }

    /* renamed from: a */
    public final String mo41591a(C2241c c2241c, JSONObject jSONObject, C45608m c45608m, int i) {
        AppMethodBeat.m2504i(117410);
        C4990ab.m7417i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "*** handler(%s) handleJsApi(%s), data:%s", mo67958wP(), c45608m.getName(), jSONObject.toString());
        if (c45608m instanceof C45625b) {
            m43101oL(21);
            m43098c(c2241c, jSONObject, c45608m, i);
        } else if (c45608m instanceof C42587e) {
            m43101oL(22);
            m43097b(c2241c, jSONObject, c45608m, i);
        } else if (c45608m instanceof C42585c) {
            m43101oL(23);
            m43099d(c2241c, jSONObject, c45608m, i);
        } else if (c45608m instanceof C42586d) {
            m43101oL(24);
            m43096a(c2241c, c45608m, i);
        }
        AppMethodBeat.m2505o(117410);
        return null;
    }

    /* renamed from: c */
    private synchronized void m43098c(final C2241c c2241c, JSONObject jSONObject, C45608m c45608m, int i) {
        AppMethodBeat.m2504i(117411);
        if (this.idR == null) {
            C4990ab.m7420w("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler insert, media player is null");
            c2241c.mo6107M(i, c45608m.mo73394j("fail", null));
            AppMethodBeat.m2505o(117411);
        } else {
            if (c2241c instanceof C33303e) {
                this.idW = (C33303e) c2241c;
                this.idX = new C194933();
                this.idY = new C10379b() {
                    /* renamed from: wW */
                    public final void mo21857wW() {
                        AppMethodBeat.m2504i(117390);
                        C33184d wV = C33183g.m54286wV(c2241c.getAppId());
                        if (wV == C33184d.LAUNCH_NATIVE_PAGE) {
                            C27116c.this.mo44778oK(2);
                            AppMethodBeat.m2505o(117390);
                        } else if (wV == C33184d.HIDE) {
                            C27116c.this.mo44778oK(1);
                            AppMethodBeat.m2505o(117390);
                        } else {
                            C27116c.this.mo44778oK(3);
                            AppMethodBeat.m2505o(117390);
                        }
                    }
                };
                this.idZ = new C194955();
                this.idW.mo53829a(this.idX);
                this.idW.mo53827a(this.idY);
                this.idW.mo53828a(this.idZ);
            }
            this.ief = jSONObject.optBoolean("autoplay", false);
            this.idR.mo61045eu(this.ief);
            double optDouble = jSONObject.optDouble("initialTime", 0.0d);
            if (optDouble > 0.0d) {
                this.idR.mo61051oM((int) (optDouble * 1000.0d));
            }
            this.ieh = jSONObject.optBoolean("loop", false);
            this.idR.setLooping(this.ieh);
            this.iei = jSONObject.optBoolean("muted", false);
            this.idR.setMute(this.iei);
            this.hLW = jSONObject.optBoolean("autoPauseIfNavigate", true);
            this.hLX = jSONObject.optBoolean("autoPauseIfOpenNative", true);
            this.ieg = jSONObject.optBoolean("needEvent", false);
            if (this.ieg) {
                this.idS = new C10533b(this, c2241c);
                this.idS.mo22022Cd(jSONObject.optString("data", ""));
            } else {
                this.idS = null;
            }
            if (jSONObject.has("position")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("position");
                if (optJSONObject != null) {
                    this.iej = optJSONObject.optInt("width", 0);
                    this.iek = optJSONObject.optInt("height", 0);
                    C4990ab.m7417i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler insert, position:[%d, %d]", Integer.valueOf(this.iej), Integer.valueOf(this.iek));
                }
            }
            this.ieo = jSONObject.optString("objectFit", "contain");
            if (C5046bo.isNullOrNil(this.ieo)) {
                this.ieo = "contain";
            }
            aGH();
            this.ien = jSONObject.optString("filePath");
            this.ien = C27116c.m43100l(c2241c, this.ien);
            if (!(C5046bo.isNullOrNil(this.ien) || this.idR == null)) {
                C4990ab.m7417i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler insert, path:%s", this.ien);
                this.idR.setDataSource(this.ien);
                prepareAsync();
            }
            c2241c.mo6107M(i, c45608m.mo73394j("ok", null));
            AppMethodBeat.m2505o(117411);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0194  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01b2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private synchronized void m43097b(C2241c c2241c, JSONObject jSONObject, C45608m c45608m, int i) {
        Object obj = 1;
        synchronized (this) {
            AppMethodBeat.m2504i(117412);
            if (this.idR == null) {
                C4990ab.m7420w("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler update, media player is null");
                c2241c.mo6107M(i, c45608m.mo73394j("fail", null));
                AppMethodBeat.m2505o(117412);
            } else {
                if (jSONObject.has("filePath")) {
                    String l = C27116c.m43100l(c2241c, jSONObject.optString("filePath"));
                    if (!(C5046bo.isNullOrNil(l) || l.equalsIgnoreCase(this.ien) || this.idR == null)) {
                        C4990ab.m7417i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler update, path:%s", l);
                        if (!C5046bo.isNullOrNil(this.ien)) {
                            aGM();
                        }
                        this.ien = l;
                        this.idR.setDataSource(this.ien);
                        if (jSONObject.has("autoplay") && this.idR != null) {
                            this.ief = jSONObject.optBoolean("autoplay", false);
                            this.idR.mo61045eu(this.ief);
                        }
                        if (jSONObject.has("initialTime")) {
                            double optDouble = jSONObject.optDouble("initialTime", 0.0d);
                            if (optDouble > 0.0d) {
                                this.idR.mo61051oM((int) (optDouble * 1000.0d));
                            }
                        }
                        if (jSONObject.has("loop")) {
                            this.ieh = jSONObject.optBoolean("loop", false);
                            this.idR.setLooping(this.ieh);
                        }
                        if (jSONObject.has("muted")) {
                            this.iei = jSONObject.optBoolean("muted", false);
                            this.idR.setMute(this.iei);
                        }
                        if (jSONObject.has("autoPauseIfNavigate")) {
                            this.hLW = jSONObject.optBoolean("autoPauseIfNavigate", true);
                        }
                        if (jSONObject.has("autoPauseIfOpenNative")) {
                            this.hLX = jSONObject.optBoolean("autoPauseIfOpenNative", true);
                        }
                        if (jSONObject.has("needEvent")) {
                            this.ieg = jSONObject.optBoolean("needEvent", false);
                            if (this.ieg) {
                                this.idS = new C10533b(this, c2241c);
                                if (jSONObject.has("data")) {
                                    this.idS.mo22022Cd(jSONObject.optString("data", ""));
                                }
                            } else {
                                this.idS = null;
                            }
                        }
                        if (jSONObject.has("position")) {
                            JSONObject optJSONObject = jSONObject.optJSONObject("position");
                            if (optJSONObject != null) {
                                this.iej = optJSONObject.optInt("width", 0);
                                this.iek = optJSONObject.optInt("height", 0);
                                C4990ab.m7417i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler update, position:[%d, %d]", Integer.valueOf(this.iej), Integer.valueOf(this.iek));
                            }
                            aGH();
                        }
                        if (jSONObject.has("objectFit")) {
                            this.ieo = jSONObject.optString("objectFit", "contain");
                            if (C5046bo.isNullOrNil(this.ieo)) {
                                this.ieo = "contain";
                            }
                            aGH();
                        }
                        if (obj != null) {
                            prepareAsync();
                        }
                        c2241c.mo6107M(i, c45608m.mo73394j("ok", null));
                        AppMethodBeat.m2505o(117412);
                    }
                }
                obj = null;
                this.ief = jSONObject.optBoolean("autoplay", false);
                this.idR.mo61045eu(this.ief);
                if (jSONObject.has("initialTime")) {
                }
                if (jSONObject.has("loop")) {
                }
                if (jSONObject.has("muted")) {
                }
                if (jSONObject.has("autoPauseIfNavigate")) {
                }
                if (jSONObject.has("autoPauseIfOpenNative")) {
                }
                if (jSONObject.has("needEvent")) {
                }
                if (jSONObject.has("position")) {
                }
                if (jSONObject.has("objectFit")) {
                }
                if (obj != null) {
                }
                c2241c.mo6107M(i, c45608m.mo73394j("ok", null));
                AppMethodBeat.m2505o(117412);
            }
        }
    }

    /* renamed from: l */
    private static String m43100l(C2241c c2241c, String str) {
        AppMethodBeat.m2504i(117413);
        if (C5046bo.isNullOrNil(str) || c2241c == null || c2241c.asE() == null || !c2241c.asE().mo5845ca(str)) {
            AppMethodBeat.m2505o(117413);
            return str;
        }
        File yg = c2241c.asE().mo34314yg(str);
        if (yg == null) {
            AppMethodBeat.m2505o(117413);
            return str;
        }
        str = "file://" + yg.getAbsolutePath();
        AppMethodBeat.m2505o(117413);
        return str;
    }

    /* renamed from: a */
    private synchronized void m43096a(C2241c c2241c, C45608m c45608m, int i) {
        AppMethodBeat.m2504i(117414);
        release();
        c2241c.mo6107M(i, c45608m.mo73394j("ok", null));
        AppMethodBeat.m2505o(117414);
    }

    /* renamed from: d */
    private synchronized void m43099d(C2241c c2241c, JSONObject jSONObject, C45608m c45608m, int i) {
        C44709u c44709u = null;
        boolean z = true;
        boolean z2 = false;
        synchronized (this) {
            AppMethodBeat.m2504i(117415);
            if (this.idR == null) {
                C4990ab.m7420w("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler operate, media player is null");
                c2241c.mo6107M(i, c45608m.mo73394j("fail", null));
                AppMethodBeat.m2505o(117415);
            } else {
                String str;
                String optString = jSONObject.optString("type");
                if (!C5046bo.isNullOrNil(optString)) {
                    C4990ab.m7417i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler operate, type:%s", optString);
                    JSONArray optJSONArray;
                    if (optString.equalsIgnoreCase("play")) {
                        m43101oL(25);
                        z2 = play();
                    } else if (optString.equalsIgnoreCase("pause")) {
                        m43101oL(26);
                        z2 = pause();
                    } else if (optString.equalsIgnoreCase("stop")) {
                        boolean z3;
                        m43101oL(27);
                        if (this.idR != null) {
                            C4990ab.m7416i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "video stop");
                            this.idR.stop();
                            if (aGN()) {
                                this.idS.onVideoPause();
                            }
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        z2 = z3;
                    } else if (optString.equalsIgnoreCase("seek")) {
                        m43101oL(28);
                        if (!(this.idR == null || jSONObject == null || !jSONObject.has("data"))) {
                            optJSONArray = jSONObject.optJSONArray("data");
                            if (optJSONArray == null || optJSONArray.length() == 0) {
                                C4990ab.m7420w("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler seek, data array is null");
                            } else {
                                double optDouble = optJSONArray.optDouble(0, -1.0d);
                                if (optDouble < 0.0d) {
                                    C4990ab.m7421w("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler seek, invalid position:%s", Double.valueOf(optDouble));
                                } else {
                                    C4990ab.m7417i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler seek, position:%s", Double.valueOf(optDouble));
                                    seek((int) (1000.0d * optDouble));
                                    z2 = z;
                                }
                            }
                        }
                        z = false;
                        z2 = z;
                    } else if (optString.equalsIgnoreCase("playbackRate")) {
                        m43101oL(29);
                        if (!(this.idR == null || jSONObject == null || !jSONObject.has("data"))) {
                            optJSONArray = jSONObject.optJSONArray("data");
                            if (optJSONArray == null || optJSONArray.length() == 0) {
                                C4990ab.m7420w("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler speed, data array is null");
                            } else {
                                double optDouble2 = optJSONArray.optDouble(0, -1.0d);
                                if (optDouble2 < 0.0d) {
                                    C4990ab.m7421w("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler speed, invalid rate:%s", Double.valueOf(optDouble2));
                                } else {
                                    C4990ab.m7417i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler speed, speed:%s", Double.valueOf(optDouble2));
                                    z2 = this.idR.mo61044at((float) optDouble2);
                                }
                            }
                        }
                    } else if (optString.equalsIgnoreCase("requestFullScreen")) {
                        C44709u c44709u2;
                        m43101oL(30);
                        if (c2241c instanceof C44709u) {
                            c44709u2 = (C44709u) c2241c;
                        } else if (c2241c instanceof C38492q) {
                            c44709u2 = ((C38492q) c2241c).getCurrentPageView();
                        } else {
                            c44709u2 = null;
                        }
                        if (c44709u2 == null) {
                            C4990ab.m7420w("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler requestFullscreen, page view is null");
                        } else if (jSONObject != null && jSONObject.has("data")) {
                            optJSONArray = jSONObject.optJSONArray("data");
                            if (optJSONArray == null || optJSONArray.length() == 0) {
                                C4990ab.m7420w("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler requestFullscreen, data array is null");
                            } else {
                                switch (optJSONArray.optInt(0, 90)) {
                                    case -90:
                                        str = "landscapeLeft";
                                        break;
                                    case 0:
                                        str = "portrait";
                                        break;
                                    case 90:
                                        str = "landscape";
                                        break;
                                    default:
                                        str = "landscape";
                                        break;
                                }
                                this.iep = c44709u2.isQ;
                                if (this.iep == null) {
                                    this.iep = c44709u2.getPageConfig().hfD;
                                    if (this.iep == null) {
                                        this.iep = "portrait";
                                    }
                                }
                                C4990ab.m7417i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler requestFullscreen, current orientation:%s, target orientation:%s", this.iep, str);
                                c44709u2.mo71744Dg(str);
                                z2 = z;
                            }
                        }
                        z = false;
                        z2 = z;
                    } else if (optString.equalsIgnoreCase("exitFullScreen")) {
                        m43101oL(31);
                        if (c2241c instanceof C44709u) {
                            c44709u = (C44709u) c2241c;
                        } else if (c2241c instanceof C38492q) {
                            c44709u = ((C38492q) c2241c).getCurrentPageView();
                        }
                        if (c44709u == null) {
                            C4990ab.m7420w("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler exitFullscreen, page view is null");
                        } else if (this.iep == null) {
                            C4990ab.m7420w("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler exitFullscreen, orientation before fullscreen is null");
                        } else {
                            C4990ab.m7417i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler exitFullscreen, orientation:%s", this.iep);
                            c44709u.mo71744Dg(this.iep);
                            this.iep = null;
                            z2 = true;
                        }
                    }
                }
                if (z2) {
                    str = "ok";
                } else {
                    str = "fail";
                }
                c2241c.mo6107M(i, c45608m.mo73394j(str, null));
                AppMethodBeat.m2505o(117415);
            }
        }
    }

    private void aGL() {
        AppMethodBeat.m2504i(117416);
        if (this.idW != null) {
            if (this.idX != null) {
                this.idW.mo53834b(this.idX);
                this.idX = null;
            }
            if (this.idY != null) {
                this.idW.mo53832b(this.idY);
                this.idY = null;
            }
            if (this.idZ != null) {
                this.idW.mo53833b(this.idZ);
                this.idZ = null;
            }
        }
        AppMethodBeat.m2505o(117416);
    }

    /* Access modifiers changed, original: final */
    public final void prepareAsync() {
        AppMethodBeat.m2504i(117417);
        if (this.idR != null) {
            C4990ab.m7416i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "video prepare async");
            this.iea = false;
            this.idR.prepareAsync();
            if (aGN()) {
                this.idS.onVideoWaiting();
            }
        }
        AppMethodBeat.m2505o(117417);
    }

    /* Access modifiers changed, original: final */
    public final boolean play() {
        AppMethodBeat.m2504i(117418);
        if (this.idR == null) {
            AppMethodBeat.m2505o(117418);
            return false;
        } else if (this.idR.isPlaying()) {
            C4990ab.m7416i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "video play, video is playing");
            AppMethodBeat.m2505o(117418);
            return true;
        } else if (this.ieq) {
            C4990ab.m7416i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "video play, video has ended playing, clear surface and start again");
            this.ieq = false;
            aGM();
            if (this.idR != null) {
                this.ief = true;
                this.idR.mo61045eu(true);
                this.idR.setDataSource(this.ien);
                prepareAsync();
            }
            AppMethodBeat.m2505o(117418);
            return true;
        } else if (this.idR != null && this.idR.getState() == 5) {
            C4990ab.m7416i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "video play, video has stopped now, try prepare and start when prepared");
            this.ief = true;
            this.idR.mo61045eu(true);
            prepareAsync();
            AppMethodBeat.m2505o(117418);
            return true;
        } else if (this.idR == null || this.iea) {
            this.idR.start();
            if (aGN()) {
                this.idS.onVideoPlay();
            }
            AppMethodBeat.m2505o(117418);
            return true;
        } else {
            C4990ab.m7416i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "video play, video not prepared yet, start until prepared");
            this.ief = true;
            this.idR.mo61045eu(true);
            AppMethodBeat.m2505o(117418);
            return true;
        }
    }

    /* Access modifiers changed, original: final */
    public final boolean pause() {
        AppMethodBeat.m2504i(117419);
        if (this.idR == null) {
            AppMethodBeat.m2505o(117419);
            return false;
        } else if (this.idR.isPlaying()) {
            C4990ab.m7416i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "video pause");
            this.idR.pause();
            if (aGN()) {
                this.idS.onVideoPause();
            }
            AppMethodBeat.m2505o(117419);
            return true;
        } else {
            C4990ab.m7416i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "video pause, video is not playing");
            AppMethodBeat.m2505o(117419);
            return true;
        }
    }

    private void release() {
        AppMethodBeat.m2504i(117420);
        C4990ab.m7416i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler release");
        if (this.idR != null) {
            this.idR.reset();
            this.idR.release();
            this.idR = null;
        }
        if (this.idS != null) {
            this.idS.destroy();
            this.idS = null;
        }
        if (this.idT != null) {
            this.idT.destroy();
            this.idT = null;
        }
        m43102pB();
        aGL();
        AppMethodBeat.m2505o(117420);
    }

    public final void seek(int i) {
        AppMethodBeat.m2504i(117421);
        if (this.idR != null) {
            if (this.idS != null) {
                this.idS.onVideoWaiting();
            }
            if (this.idR != null) {
                this.iec = this.idR.isPlaying();
            }
            if (this.idR != null) {
                this.idR.seekTo(i);
            }
        }
        AppMethodBeat.m2505o(117421);
    }

    /* renamed from: pB */
    private void m43102pB() {
        AppMethodBeat.m2504i(117423);
        if (this.mSurface != null) {
            this.mSurface.release();
            this.mSurface = null;
        }
        AppMethodBeat.m2505o(117423);
    }

    /* renamed from: oL */
    private void m43101oL(int i) {
        AppMethodBeat.m2504i(117424);
        if (this.idU != null) {
            this.idU.mo22037gq((long) i);
        }
        AppMethodBeat.m2505o(117424);
    }

    /* Access modifiers changed, original: final */
    public final boolean aGN() {
        return this.ieg && this.idS != null;
    }

    private synchronized void aGM() {
        AppMethodBeat.m2504i(117422);
        if (this.idR != null) {
            C4990ab.m7416i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler resetMediaPlayer, clear media player");
            this.idR.setOnInfoListener(null);
            this.idR.setOnErrorListener(null);
            this.idR.setOnPreparedListener(null);
            this.idR.setOnCompletionListener(null);
            this.idR.setOnSeekCompleteListener(null);
            this.idR.setOnVideoSizeChangedListener(null);
            this.idR.stop();
            this.idR.reset();
            this.idR.release();
        }
        this.idR = null;
        try {
            if (this.mSurfaceTexture != null && this.iea) {
                C4990ab.m7416i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler clearSurfaceTexture");
                SurfaceTexture surfaceTexture = this.mSurfaceTexture;
                EGL10 egl10 = (EGL10) EGLContext.getEGL();
                EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
                egl10.eglInitialize(eglGetDisplay, null);
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                egl10.eglChooseConfig(eglGetDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344, 0, 12344}, eGLConfigArr, 1, new int[1]);
                EGLConfig eGLConfig = eGLConfigArr[0];
                EGLContext eglCreateContext = egl10.eglCreateContext(eglGetDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
                EGLSurface eglCreateWindowSurface = egl10.eglCreateWindowSurface(eglGetDisplay, eGLConfig, surfaceTexture, new int[]{12344});
                egl10.eglMakeCurrent(eglGetDisplay, eglCreateWindowSurface, eglCreateWindowSurface, eglCreateContext);
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                GLES20.glClear(16384);
                egl10.eglSwapBuffers(eglGetDisplay, eglCreateWindowSurface);
                egl10.eglDestroySurface(eglGetDisplay, eglCreateWindowSurface);
                eglCreateWindowSurface = EGL10.EGL_NO_SURFACE;
                egl10.eglMakeCurrent(eglGetDisplay, eglCreateWindowSurface, eglCreateWindowSurface, EGL10.EGL_NO_CONTEXT);
                egl10.eglDestroyContext(eglGetDisplay, eglCreateContext);
                egl10.eglTerminate(eglGetDisplay);
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler clearSurfaceTexture error", e);
        }
        aGG();
        if (this.idR != null) {
            this.idR.setMute(this.iei);
            this.idR.setLooping(this.ieh);
            this.idR.mo61045eu(this.ief);
            if (this.mSurface != null) {
                this.idR.setSurface(this.mSurface);
            }
        }
        AppMethodBeat.m2505o(117422);
        return;
    }
}
