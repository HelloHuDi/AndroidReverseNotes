package com.tencent.mm.plugin.appbrand.jsapi.u.b;

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
import com.tencent.mm.plugin.appbrand.e.e;
import com.tencent.mm.plugin.appbrand.e.f;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.u.b.b.a;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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

public final class c extends e {
    boolean hLW;
    boolean hLX;
    com.tencent.mm.plugin.appbrand.jsapi.u.b.b.c idR;
    g idS;
    f idT;
    h idU;
    private e idV;
    private com.tencent.mm.plugin.appbrand.jsapi.e idW;
    private d idX;
    private b idY;
    private com.tencent.mm.plugin.appbrand.jsapi.f.c idZ;
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

    public c() {
        AppMethodBeat.i(117400);
        aGG();
        AppMethodBeat.o(117400);
    }

    private void aGG() {
        AppMethodBeat.i(117401);
        this.idR = new a();
        this.idR.setOnInfoListener(new OnInfoListener() {
            public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                AppMethodBeat.i(117387);
                ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler onInfo, what:%d, extra:%d", Integer.valueOf(i), Integer.valueOf(i2));
                if (i == 701) {
                    c.this.ied = c.this.idR.isPlaying();
                    ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "onInfo, buffering start, isPlayingBeforeBuffering:%b", Boolean.valueOf(c.this.ied));
                    if (c.this.aGN()) {
                        c.this.idS.onVideoWaiting();
                    }
                } else if (i == 702) {
                    boolean isPlaying = c.this.idR.isPlaying();
                    ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "onInfo, buffering end, isPlayingBeforeBuffering:%b, isCurrentPlaying", Boolean.valueOf(c.this.ied), Boolean.valueOf(isPlaying));
                    if (c.this.ied) {
                        c.this.ied = false;
                        if (isPlaying && c.this.aGN()) {
                            ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "onInfo, buffering end, notify video play");
                            c.this.idS.onVideoPlay();
                        }
                    } else if (!isPlaying && c.this.aGN()) {
                        ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "onInfo, buffering end, notify video pause");
                        c.this.idS.onVideoPause();
                    }
                } else if (i2 == -1004) {
                    ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "onInfo, special error, what:%d, extra:%d", Integer.valueOf(i), Integer.valueOf(i2));
                    if (c.this.idT != null) {
                        c.this.idT.dh(i, i2);
                    }
                    if (c.this.idU != null) {
                        c.this.idU.gq(40);
                    }
                }
                AppMethodBeat.o(117387);
                return false;
            }
        });
        this.idR.setOnErrorListener(new OnErrorListener() {
            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                AppMethodBeat.i(117392);
                ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler onError, what:%d, extra:%d", Integer.valueOf(i), Integer.valueOf(i2));
                if (c.this.idT != null) {
                    c.this.idT.dh(i, i2);
                    if (c.this.idU != null) {
                        if (i == -1024) {
                            c.this.idU.gq((long) (-i2));
                        } else {
                            c.this.idU.gq(41);
                        }
                    }
                }
                AppMethodBeat.o(117392);
                return false;
            }
        });
        this.idR.setOnPreparedListener(new OnPreparedListener() {
            public final void onPrepared(MediaPlayer mediaPlayer) {
                AppMethodBeat.i(117393);
                ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler onPrepared");
                c.this.iea = true;
                c.this.aGH();
                if (c.this.idT != null) {
                    c.this.idT.init();
                }
                if (c.this.aGN() && c.this.idR != null) {
                    c.this.idS.L(c.this.idR.getVideoWidth(), c.this.idR.getVideoHeight(), c.this.idR.getDuration());
                }
                if (c.this.ier) {
                    ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "onPrepared, stop video auto play when webview in background");
                    if (c.this.idR != null) {
                        c.this.idR.eu(false);
                    }
                    c.this.iee = c.this.ief;
                } else if (c.this.ief) {
                    ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "onPrepared, start when prepared");
                    if (c.this.aGN()) {
                        c.this.idS.onVideoPlay();
                        AppMethodBeat.o(117393);
                        return;
                    }
                }
                AppMethodBeat.o(117393);
            }
        });
        this.idR.setOnCompletionListener(new OnCompletionListener() {
            public final void onCompletion(MediaPlayer mediaPlayer) {
                AppMethodBeat.i(117394);
                ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler onCompletion");
                if (c.this.aGN()) {
                    c.this.idS.aGE();
                }
                if (c.this.ieh) {
                    ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "onCompletion, video loop playing");
                    c.this.ieb = true;
                    c.this.seek(0);
                    AppMethodBeat.o(117394);
                    return;
                }
                ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "onCompletion, video end playing");
                c.this.ieq = true;
                AppMethodBeat.o(117394);
            }
        });
        this.idR.setOnSeekCompleteListener(new OnSeekCompleteListener() {
            public final void onSeekComplete(MediaPlayer mediaPlayer) {
                AppMethodBeat.i(117395);
                ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler onSeekComplete");
                if (c.this.ieb) {
                    ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "onSeekComplete, start when seek complete");
                    c.this.ieb = false;
                    c.this.play();
                    AppMethodBeat.o(117395);
                    return;
                }
                boolean isPlaying = c.this.idR.isPlaying();
                if (c.this.iec) {
                    ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "onSeekComplete, video playing before seeking, isCurrentPlaying:%b, position:%s, duration:%s", Boolean.valueOf(isPlaying), Integer.valueOf(c.this.idR.getCurrentPosition()), Integer.valueOf(c.this.idR.getDuration()));
                    c.this.iec = false;
                    if (c.this.idR.getCurrentPosition() / 1000 < c.this.idR.getDuration() / 1000) {
                        ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "onSeekComplete, video not end");
                        if (isPlaying && c.this.aGN()) {
                            ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "onSeekComplete, dispatch play again");
                            c.this.idS.onVideoPlay();
                            AppMethodBeat.o(117395);
                            return;
                        }
                    }
                    ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "onSeekComplete, video ends");
                    c.this.idR.pause();
                    c.this.idR.start();
                    AppMethodBeat.o(117395);
                    return;
                }
                ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "onSeekComplete, video not playing before seeking, isCurrentPlaying:%b", Boolean.valueOf(isPlaying));
                if (!isPlaying && c.this.aGN()) {
                    ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "onSeekComplete, dispatch pause again");
                    c.this.idS.onVideoPause();
                }
                AppMethodBeat.o(117395);
            }
        });
        this.idR.setOnVideoSizeChangedListener(new OnVideoSizeChangedListener() {
            public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                AppMethodBeat.i(117396);
                ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler onVideoSizeChanged, width:%d, height:%d", Integer.valueOf(i), Integer.valueOf(i2));
                c.this.aGH();
                if (c.this.aGN() && c.this.iea && c.this.idR != null) {
                    int duration = c.this.idR.getDuration();
                    if (!((c.this.idS == null || i == c.this.mVideoWidth) && i2 == c.this.mVideoHeight && duration == c.this.iel)) {
                        c.this.idS.L(i, i2, duration);
                    }
                }
                c.this.mVideoWidth = i;
                c.this.mVideoHeight = i2;
                if (c.this.idR != null) {
                    c.this.iel = c.this.idR.getDuration();
                }
                AppMethodBeat.o(117396);
            }
        });
        this.idR.setOnBufferingUpdateListener(new OnBufferingUpdateListener() {
            public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                AppMethodBeat.i(117397);
                if (i != c.this.iem) {
                    c.this.iem = i;
                    ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler onBufferingUpdate, percent:%s", Integer.valueOf(i));
                }
                if (c.this.aGN() && c.this.iea) {
                    c.this.idS.oJ(i);
                }
                AppMethodBeat.o(117397);
            }
        });
        this.idV = new e();
        this.idU = new d();
        this.idT = new a(this, new f.a() {
            public final void I(String str, int i, int i2) {
                AppMethodBeat.i(117398);
                ab.w("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler send video error event, what:%d, extra:%d", Integer.valueOf(i), Integer.valueOf(i2));
                if (c.this.aGN()) {
                    c.this.idS.I(str, i, i2);
                }
                if (c.this.idU != null) {
                    c.this.idU.gq(0);
                }
                AppMethodBeat.o(117398);
            }
        });
        AppMethodBeat.o(117401);
    }

    /* Access modifiers changed, original: final */
    public final void aGH() {
        AppMethodBeat.i(117402);
        if (bo.isNullOrNil(this.ieo)) {
            ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler adjust objectFit, no video objectFit");
        } else if (!this.iea || aAn() == null || this.idV == null) {
            ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler adjust objectFit, video not prepared");
            AppMethodBeat.o(117402);
            return;
        } else {
            int i;
            e eVar = this.idV;
            String str = this.ieo;
            int i2 = this.iej;
            int i3 = this.iek;
            int i4 = this.mVideoWidth;
            int i5 = this.mVideoHeight;
            if (bo.isNullOrNil(str)) {
                ab.w("MicroMsg.AppBrand.SameLayer.AppBrandVideoScaleHandler", "calculateScale, scale type is null");
                i = 0;
            } else if (i2 == 0 || i3 == 0 || i4 == 0 || i5 == 0) {
                ab.w("MicroMsg.AppBrand.SameLayer.AppBrandVideoScaleHandler", "calculateScale, width or height is 0");
                i = 0;
            } else if (str.equalsIgnoreCase(eVar.iey) && eVar.ieu == i2 && eVar.iev == i3 && eVar.videoWidth == i4 && eVar.videoHeight == i5) {
                ab.w("MicroMsg.AppBrand.SameLayer.AppBrandVideoScaleHandler", "calculateScale, same as last calculated");
                i = 1;
            } else {
                e eVar2;
                eVar.iey = str;
                eVar.ieu = i2;
                eVar.iev = i3;
                eVar.videoWidth = i4;
                eVar.videoHeight = i5;
                float f = (((float) eVar.videoWidth) * 1.0f) / ((float) eVar.videoHeight);
                float f2 = (((float) eVar.ieu) * 1.0f) / ((float) eVar.iev);
                if (eVar.iey.equalsIgnoreCase("contain")) {
                    if (eVar.ieu < eVar.iev) {
                        eVar.iex = (int) (((float) eVar.ieu) / f);
                        eVar.iew = eVar.ieu;
                        if (eVar.iex > eVar.iev) {
                            eVar2 = eVar;
                        }
                    } else {
                        eVar.iew = (int) (((float) eVar.iev) * f);
                        eVar.iex = eVar.iev;
                        if (eVar.iew > eVar.ieu) {
                            eVar.iex = (int) (((float) eVar.ieu) / f);
                            eVar.iew = eVar.ieu;
                        }
                    }
                    eVar.iez = (((float) eVar.iew) * 1.0f) / ((float) eVar.ieu);
                    eVar.ieA = (((float) eVar.iex) * 1.0f) / ((float) eVar.iev);
                    ab.d("MicroMsg.AppBrand.SameLayer.AppBrandVideoScaleHandler", "calculateScale, screen[%d, %d], video[%d, %d], measure[%d, %d], scale[%f, %f]", Integer.valueOf(eVar.ieu), Integer.valueOf(eVar.iev), Integer.valueOf(eVar.videoWidth), Integer.valueOf(eVar.videoHeight), Integer.valueOf(eVar.iew), Integer.valueOf(eVar.iex), Float.valueOf(eVar.iez), Float.valueOf(eVar.ieA));
                    i = 1;
                } else {
                    if (eVar.iey.equalsIgnoreCase("fill")) {
                        eVar.iex = eVar.iev;
                        eVar.iew = eVar.ieu;
                    } else if (eVar.iey.equalsIgnoreCase("cover")) {
                        if (eVar.ieu > eVar.iev) {
                            eVar.iex = (int) (((float) eVar.ieu) / f);
                            eVar.iew = eVar.ieu;
                            if (eVar.iex < eVar.iev) {
                                eVar2 = eVar;
                            }
                        } else {
                            eVar.iew = (int) (((float) eVar.iev) * f);
                            eVar.iex = eVar.iev;
                            if (eVar.iew < eVar.ieu) {
                                eVar.iex = (int) (((float) eVar.ieu) / f);
                                eVar.iew = eVar.ieu;
                            }
                        }
                    } else if (((double) Math.abs(f - f2)) > 0.05d) {
                        if (eVar.ieu < eVar.iev) {
                            eVar.iex = (int) (((float) eVar.ieu) / f);
                            eVar.iew = eVar.ieu;
                        } else {
                            eVar.iew = (int) (((float) eVar.iev) * f);
                            eVar.iex = eVar.iev;
                        }
                    } else if (eVar.ieu > eVar.iev) {
                        eVar.iex = (int) (((float) eVar.ieu) / f);
                        eVar.iew = eVar.ieu;
                    } else {
                        eVar2 = eVar;
                    }
                    eVar.iez = (((float) eVar.iew) * 1.0f) / ((float) eVar.ieu);
                    eVar.ieA = (((float) eVar.iex) * 1.0f) / ((float) eVar.iev);
                    ab.d("MicroMsg.AppBrand.SameLayer.AppBrandVideoScaleHandler", "calculateScale, screen[%d, %d], video[%d, %d], measure[%d, %d], scale[%f, %f]", Integer.valueOf(eVar.ieu), Integer.valueOf(eVar.iev), Integer.valueOf(eVar.videoWidth), Integer.valueOf(eVar.videoHeight), Integer.valueOf(eVar.iew), Integer.valueOf(eVar.iex), Float.valueOf(eVar.iez), Float.valueOf(eVar.ieA));
                    i = 1;
                }
                eVar2.iew = (int) (f * ((float) eVar2.iev));
                eVar2.iex = eVar2.iev;
                eVar.iez = (((float) eVar.iew) * 1.0f) / ((float) eVar.ieu);
                eVar.ieA = (((float) eVar.iex) * 1.0f) / ((float) eVar.iev);
                ab.d("MicroMsg.AppBrand.SameLayer.AppBrandVideoScaleHandler", "calculateScale, screen[%d, %d], video[%d, %d], measure[%d, %d], scale[%f, %f]", Integer.valueOf(eVar.ieu), Integer.valueOf(eVar.iev), Integer.valueOf(eVar.videoWidth), Integer.valueOf(eVar.videoHeight), Integer.valueOf(eVar.iew), Integer.valueOf(eVar.iex), Float.valueOf(eVar.iez), Float.valueOf(eVar.ieA));
                i = 1;
            }
            if (i != 0) {
                ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler adjust objectFit:%s, scale:[%s, %s]", this.ieo, Float.valueOf(this.idV.iez), Float.valueOf(this.idV.ieA));
                f aAn = aAn();
                String type = getType();
                i2 = getId();
                float f3 = this.idV.iez;
                float f4 = this.idV.ieA;
                if (!(aAn == null || aAn.yp() == null)) {
                    ab.i("MicroMsg.AppBrand.SameLayer.WebViewExtendPluginUtil", "applyPluginTextureScale, %s#%d, scale:[%s,%s]", type, Integer.valueOf(i2), Float.valueOf(f3), Float.valueOf(f4));
                    aAn.yp().setPluginTextureScale(type, i2, f3, f4);
                }
                AppMethodBeat.o(117402);
                return;
            }
        }
        AppMethodBeat.o(117402);
    }

    public final boolean a(m mVar) {
        AppMethodBeat.i(117403);
        if (this.hpN || (mVar != null && mVar.getName().equals(com.tencent.mm.plugin.appbrand.jsapi.u.b.a.d.NAME))) {
            AppMethodBeat.o(117403);
            return true;
        }
        AppMethodBeat.o(117403);
        return false;
    }

    public final void d(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(117404);
        super.d(surfaceTexture);
        ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "*** handler(%s) handlePluginReady", wP());
        this.ieb = false;
        this.iec = false;
        this.ied = false;
        this.mSurfaceTexture = surfaceTexture;
        this.mSurface = new Surface(surfaceTexture);
        if (this.idR != null) {
            this.idR.setSurface(this.mSurface);
        }
        aGI();
        AppMethodBeat.o(117404);
    }

    private void aGI() {
        AppMethodBeat.i(117405);
        synchronized (this.ies) {
            try {
                if (!this.ies.isEmpty()) {
                    ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler flushPendingTasks, size:%d", Integer.valueOf(this.ies.size()));
                    Iterator it = this.ies.iterator();
                    while (it.hasNext()) {
                        ((Runnable) it.next()).run();
                    }
                    this.ies.clear();
                }
            } finally {
                AppMethodBeat.o(117405);
            }
        }
    }

    public final void yr() {
        AppMethodBeat.i(117406);
        super.yr();
        ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "*** handler(%s) handlePluginDestroy", wP());
        pause();
        AppMethodBeat.o(117406);
    }

    public final void aGJ() {
        AppMethodBeat.i(117407);
        ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "*** handler(%s) handleWebViewForeground", wP());
        this.ier = false;
        AnonymousClass13 anonymousClass13 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(117399);
                if (c.this.idR != null && c.this.iea && c.this.iee) {
                    ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handleWebViewForeground runnable, video playing when enter background");
                    c.this.iee = false;
                    c.this.play();
                }
                AppMethodBeat.o(117399);
            }
        };
        if (a(null)) {
            anonymousClass13.run();
            AppMethodBeat.o(117407);
            return;
        }
        ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler webview foreground, plugin is not ready, add to pending tasks");
        this.ies.add(anonymousClass13);
        AppMethodBeat.o(117407);
    }

    public final void oK(final int i) {
        AppMethodBeat.i(117408);
        ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "*** handler(%s) handleWebViewBackground, type:%d", wP(), Integer.valueOf(i));
        this.ier = true;
        AnonymousClass2 anonymousClass2 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(117388);
                if ((i != 2 || c.this.hLX) && (i != 1 || c.this.hLW)) {
                    if (c.this.idR != null && c.this.iea) {
                        c.this.iee = c.this.idR.isPlaying();
                        ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handleWebViewBackground runnable, video playing state when enter background:%s", Boolean.valueOf(c.this.iee));
                        c.this.pause();
                    }
                    AppMethodBeat.o(117388);
                    return;
                }
                ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handleWebViewBackground runnable, video not auto pause");
                AppMethodBeat.o(117388);
            }
        };
        if (a(null)) {
            anonymousClass2.run();
            AppMethodBeat.o(117408);
            return;
        }
        ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler webview background, plugin is not ready, add to pending tasks");
        this.ies.add(anonymousClass2);
        AppMethodBeat.o(117408);
    }

    public final void aGK() {
        AppMethodBeat.i(117409);
        ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "*** handler(%s) handleWebViewDestroy", wP());
        release();
        AppMethodBeat.o(117409);
    }

    public final String a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject, m mVar, int i) {
        AppMethodBeat.i(117410);
        ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "*** handler(%s) handleJsApi(%s), data:%s", wP(), mVar.getName(), jSONObject.toString());
        if (mVar instanceof com.tencent.mm.plugin.appbrand.jsapi.u.b.a.b) {
            oL(21);
            c(cVar, jSONObject, mVar, i);
        } else if (mVar instanceof com.tencent.mm.plugin.appbrand.jsapi.u.b.a.e) {
            oL(22);
            b(cVar, jSONObject, mVar, i);
        } else if (mVar instanceof com.tencent.mm.plugin.appbrand.jsapi.u.b.a.c) {
            oL(23);
            d(cVar, jSONObject, mVar, i);
        } else if (mVar instanceof com.tencent.mm.plugin.appbrand.jsapi.u.b.a.d) {
            oL(24);
            a(cVar, mVar, i);
        }
        AppMethodBeat.o(117410);
        return null;
    }

    private synchronized void c(final com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject, m mVar, int i) {
        AppMethodBeat.i(117411);
        if (this.idR == null) {
            ab.w("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler insert, media player is null");
            cVar.M(i, mVar.j("fail", null));
            AppMethodBeat.o(117411);
        } else {
            if (cVar instanceof com.tencent.mm.plugin.appbrand.jsapi.e) {
                this.idW = (com.tencent.mm.plugin.appbrand.jsapi.e) cVar;
                this.idX = new d() {
                    public final void wU() {
                        AppMethodBeat.i(117389);
                        c.this.aGJ();
                        AppMethodBeat.o(117389);
                    }
                };
                this.idY = new b() {
                    public final void wW() {
                        AppMethodBeat.i(117390);
                        g.d wV = g.wV(cVar.getAppId());
                        if (wV == g.d.LAUNCH_NATIVE_PAGE) {
                            c.this.oK(2);
                            AppMethodBeat.o(117390);
                        } else if (wV == g.d.HIDE) {
                            c.this.oK(1);
                            AppMethodBeat.o(117390);
                        } else {
                            c.this.oK(3);
                            AppMethodBeat.o(117390);
                        }
                    }
                };
                this.idZ = new com.tencent.mm.plugin.appbrand.jsapi.f.c() {
                    public final void onDestroy() {
                        AppMethodBeat.i(117391);
                        c.this.aGK();
                        AppMethodBeat.o(117391);
                    }
                };
                this.idW.a(this.idX);
                this.idW.a(this.idY);
                this.idW.a(this.idZ);
            }
            this.ief = jSONObject.optBoolean("autoplay", false);
            this.idR.eu(this.ief);
            double optDouble = jSONObject.optDouble("initialTime", 0.0d);
            if (optDouble > 0.0d) {
                this.idR.oM((int) (optDouble * 1000.0d));
            }
            this.ieh = jSONObject.optBoolean("loop", false);
            this.idR.setLooping(this.ieh);
            this.iei = jSONObject.optBoolean("muted", false);
            this.idR.setMute(this.iei);
            this.hLW = jSONObject.optBoolean("autoPauseIfNavigate", true);
            this.hLX = jSONObject.optBoolean("autoPauseIfOpenNative", true);
            this.ieg = jSONObject.optBoolean("needEvent", false);
            if (this.ieg) {
                this.idS = new b(this, cVar);
                this.idS.Cd(jSONObject.optString("data", ""));
            } else {
                this.idS = null;
            }
            if (jSONObject.has("position")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("position");
                if (optJSONObject != null) {
                    this.iej = optJSONObject.optInt("width", 0);
                    this.iek = optJSONObject.optInt("height", 0);
                    ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler insert, position:[%d, %d]", Integer.valueOf(this.iej), Integer.valueOf(this.iek));
                }
            }
            this.ieo = jSONObject.optString("objectFit", "contain");
            if (bo.isNullOrNil(this.ieo)) {
                this.ieo = "contain";
            }
            aGH();
            this.ien = jSONObject.optString("filePath");
            this.ien = l(cVar, this.ien);
            if (!(bo.isNullOrNil(this.ien) || this.idR == null)) {
                ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler insert, path:%s", this.ien);
                this.idR.setDataSource(this.ien);
                prepareAsync();
            }
            cVar.M(i, mVar.j("ok", null));
            AppMethodBeat.o(117411);
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
    private synchronized void b(com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject, m mVar, int i) {
        Object obj = 1;
        synchronized (this) {
            AppMethodBeat.i(117412);
            if (this.idR == null) {
                ab.w("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler update, media player is null");
                cVar.M(i, mVar.j("fail", null));
                AppMethodBeat.o(117412);
            } else {
                if (jSONObject.has("filePath")) {
                    String l = l(cVar, jSONObject.optString("filePath"));
                    if (!(bo.isNullOrNil(l) || l.equalsIgnoreCase(this.ien) || this.idR == null)) {
                        ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler update, path:%s", l);
                        if (!bo.isNullOrNil(this.ien)) {
                            aGM();
                        }
                        this.ien = l;
                        this.idR.setDataSource(this.ien);
                        if (jSONObject.has("autoplay") && this.idR != null) {
                            this.ief = jSONObject.optBoolean("autoplay", false);
                            this.idR.eu(this.ief);
                        }
                        if (jSONObject.has("initialTime")) {
                            double optDouble = jSONObject.optDouble("initialTime", 0.0d);
                            if (optDouble > 0.0d) {
                                this.idR.oM((int) (optDouble * 1000.0d));
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
                                this.idS = new b(this, cVar);
                                if (jSONObject.has("data")) {
                                    this.idS.Cd(jSONObject.optString("data", ""));
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
                                ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler update, position:[%d, %d]", Integer.valueOf(this.iej), Integer.valueOf(this.iek));
                            }
                            aGH();
                        }
                        if (jSONObject.has("objectFit")) {
                            this.ieo = jSONObject.optString("objectFit", "contain");
                            if (bo.isNullOrNil(this.ieo)) {
                                this.ieo = "contain";
                            }
                            aGH();
                        }
                        if (obj != null) {
                            prepareAsync();
                        }
                        cVar.M(i, mVar.j("ok", null));
                        AppMethodBeat.o(117412);
                    }
                }
                obj = null;
                this.ief = jSONObject.optBoolean("autoplay", false);
                this.idR.eu(this.ief);
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
                cVar.M(i, mVar.j("ok", null));
                AppMethodBeat.o(117412);
            }
        }
    }

    private static String l(com.tencent.mm.plugin.appbrand.jsapi.c cVar, String str) {
        AppMethodBeat.i(117413);
        if (bo.isNullOrNil(str) || cVar == null || cVar.asE() == null || !cVar.asE().ca(str)) {
            AppMethodBeat.o(117413);
            return str;
        }
        File yg = cVar.asE().yg(str);
        if (yg == null) {
            AppMethodBeat.o(117413);
            return str;
        }
        str = "file://" + yg.getAbsolutePath();
        AppMethodBeat.o(117413);
        return str;
    }

    private synchronized void a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, m mVar, int i) {
        AppMethodBeat.i(117414);
        release();
        cVar.M(i, mVar.j("ok", null));
        AppMethodBeat.o(117414);
    }

    private synchronized void d(com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject, m mVar, int i) {
        u uVar = null;
        boolean z = true;
        boolean z2 = false;
        synchronized (this) {
            AppMethodBeat.i(117415);
            if (this.idR == null) {
                ab.w("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler operate, media player is null");
                cVar.M(i, mVar.j("fail", null));
                AppMethodBeat.o(117415);
            } else {
                String str;
                String optString = jSONObject.optString("type");
                if (!bo.isNullOrNil(optString)) {
                    ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler operate, type:%s", optString);
                    JSONArray optJSONArray;
                    if (optString.equalsIgnoreCase("play")) {
                        oL(25);
                        z2 = play();
                    } else if (optString.equalsIgnoreCase("pause")) {
                        oL(26);
                        z2 = pause();
                    } else if (optString.equalsIgnoreCase("stop")) {
                        boolean z3;
                        oL(27);
                        if (this.idR != null) {
                            ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "video stop");
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
                        oL(28);
                        if (!(this.idR == null || jSONObject == null || !jSONObject.has("data"))) {
                            optJSONArray = jSONObject.optJSONArray("data");
                            if (optJSONArray == null || optJSONArray.length() == 0) {
                                ab.w("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler seek, data array is null");
                            } else {
                                double optDouble = optJSONArray.optDouble(0, -1.0d);
                                if (optDouble < 0.0d) {
                                    ab.w("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler seek, invalid position:%s", Double.valueOf(optDouble));
                                } else {
                                    ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler seek, position:%s", Double.valueOf(optDouble));
                                    seek((int) (1000.0d * optDouble));
                                    z2 = z;
                                }
                            }
                        }
                        z = false;
                        z2 = z;
                    } else if (optString.equalsIgnoreCase("playbackRate")) {
                        oL(29);
                        if (!(this.idR == null || jSONObject == null || !jSONObject.has("data"))) {
                            optJSONArray = jSONObject.optJSONArray("data");
                            if (optJSONArray == null || optJSONArray.length() == 0) {
                                ab.w("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler speed, data array is null");
                            } else {
                                double optDouble2 = optJSONArray.optDouble(0, -1.0d);
                                if (optDouble2 < 0.0d) {
                                    ab.w("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler speed, invalid rate:%s", Double.valueOf(optDouble2));
                                } else {
                                    ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler speed, speed:%s", Double.valueOf(optDouble2));
                                    z2 = this.idR.at((float) optDouble2);
                                }
                            }
                        }
                    } else if (optString.equalsIgnoreCase("requestFullScreen")) {
                        u uVar2;
                        oL(30);
                        if (cVar instanceof u) {
                            uVar2 = (u) cVar;
                        } else if (cVar instanceof q) {
                            uVar2 = ((q) cVar).getCurrentPageView();
                        } else {
                            uVar2 = null;
                        }
                        if (uVar2 == null) {
                            ab.w("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler requestFullscreen, page view is null");
                        } else if (jSONObject != null && jSONObject.has("data")) {
                            optJSONArray = jSONObject.optJSONArray("data");
                            if (optJSONArray == null || optJSONArray.length() == 0) {
                                ab.w("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler requestFullscreen, data array is null");
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
                                this.iep = uVar2.isQ;
                                if (this.iep == null) {
                                    this.iep = uVar2.getPageConfig().hfD;
                                    if (this.iep == null) {
                                        this.iep = "portrait";
                                    }
                                }
                                ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler requestFullscreen, current orientation:%s, target orientation:%s", this.iep, str);
                                uVar2.Dg(str);
                                z2 = z;
                            }
                        }
                        z = false;
                        z2 = z;
                    } else if (optString.equalsIgnoreCase("exitFullScreen")) {
                        oL(31);
                        if (cVar instanceof u) {
                            uVar = (u) cVar;
                        } else if (cVar instanceof q) {
                            uVar = ((q) cVar).getCurrentPageView();
                        }
                        if (uVar == null) {
                            ab.w("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler exitFullscreen, page view is null");
                        } else if (this.iep == null) {
                            ab.w("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler exitFullscreen, orientation before fullscreen is null");
                        } else {
                            ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler exitFullscreen, orientation:%s", this.iep);
                            uVar.Dg(this.iep);
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
                cVar.M(i, mVar.j(str, null));
                AppMethodBeat.o(117415);
            }
        }
    }

    private void aGL() {
        AppMethodBeat.i(117416);
        if (this.idW != null) {
            if (this.idX != null) {
                this.idW.b(this.idX);
                this.idX = null;
            }
            if (this.idY != null) {
                this.idW.b(this.idY);
                this.idY = null;
            }
            if (this.idZ != null) {
                this.idW.b(this.idZ);
                this.idZ = null;
            }
        }
        AppMethodBeat.o(117416);
    }

    /* Access modifiers changed, original: final */
    public final void prepareAsync() {
        AppMethodBeat.i(117417);
        if (this.idR != null) {
            ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "video prepare async");
            this.iea = false;
            this.idR.prepareAsync();
            if (aGN()) {
                this.idS.onVideoWaiting();
            }
        }
        AppMethodBeat.o(117417);
    }

    /* Access modifiers changed, original: final */
    public final boolean play() {
        AppMethodBeat.i(117418);
        if (this.idR == null) {
            AppMethodBeat.o(117418);
            return false;
        } else if (this.idR.isPlaying()) {
            ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "video play, video is playing");
            AppMethodBeat.o(117418);
            return true;
        } else if (this.ieq) {
            ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "video play, video has ended playing, clear surface and start again");
            this.ieq = false;
            aGM();
            if (this.idR != null) {
                this.ief = true;
                this.idR.eu(true);
                this.idR.setDataSource(this.ien);
                prepareAsync();
            }
            AppMethodBeat.o(117418);
            return true;
        } else if (this.idR != null && this.idR.getState() == 5) {
            ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "video play, video has stopped now, try prepare and start when prepared");
            this.ief = true;
            this.idR.eu(true);
            prepareAsync();
            AppMethodBeat.o(117418);
            return true;
        } else if (this.idR == null || this.iea) {
            this.idR.start();
            if (aGN()) {
                this.idS.onVideoPlay();
            }
            AppMethodBeat.o(117418);
            return true;
        } else {
            ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "video play, video not prepared yet, start until prepared");
            this.ief = true;
            this.idR.eu(true);
            AppMethodBeat.o(117418);
            return true;
        }
    }

    /* Access modifiers changed, original: final */
    public final boolean pause() {
        AppMethodBeat.i(117419);
        if (this.idR == null) {
            AppMethodBeat.o(117419);
            return false;
        } else if (this.idR.isPlaying()) {
            ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "video pause");
            this.idR.pause();
            if (aGN()) {
                this.idS.onVideoPause();
            }
            AppMethodBeat.o(117419);
            return true;
        } else {
            ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "video pause, video is not playing");
            AppMethodBeat.o(117419);
            return true;
        }
    }

    private void release() {
        AppMethodBeat.i(117420);
        ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler release");
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
        pB();
        aGL();
        AppMethodBeat.o(117420);
    }

    public final void seek(int i) {
        AppMethodBeat.i(117421);
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
        AppMethodBeat.o(117421);
    }

    private void pB() {
        AppMethodBeat.i(117423);
        if (this.mSurface != null) {
            this.mSurface.release();
            this.mSurface = null;
        }
        AppMethodBeat.o(117423);
    }

    private void oL(int i) {
        AppMethodBeat.i(117424);
        if (this.idU != null) {
            this.idU.gq((long) i);
        }
        AppMethodBeat.o(117424);
    }

    /* Access modifiers changed, original: final */
    public final boolean aGN() {
        return this.ieg && this.idS != null;
    }

    private synchronized void aGM() {
        AppMethodBeat.i(117422);
        if (this.idR != null) {
            ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler resetMediaPlayer, clear media player");
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
                ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler clearSurfaceTexture");
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
            ab.e("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler clearSurfaceTexture error", e);
        }
        aGG();
        if (this.idR != null) {
            this.idR.setMute(this.iei);
            this.idR.setLooping(this.ieh);
            this.idR.eu(this.ief);
            if (this.mSurface != null) {
                this.idR.setSurface(this.mSurface);
            }
        }
        AppMethodBeat.o(117422);
        return;
    }
}
