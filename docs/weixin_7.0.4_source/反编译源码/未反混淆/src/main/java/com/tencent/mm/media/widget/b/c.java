package com.tencent.mm.media.widget.b;

import a.f.b.j;
import a.y;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.media.MediaCodec.BufferInfo;
import android.opengl.EGLContext;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.c.g;
import com.tencent.mm.media.d.b;
import com.tencent.mm.media.d.e;
import com.tencent.mm.media.g.a.d;
import com.tencent.mm.media.g.a.i;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.d.a;
import com.tencent.mm.plugin.mmsight.model.a.m;
import com.tencent.mm.plugin.mmsight.model.a.s;
import com.tencent.mm.plugin.mmsight.model.f;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.nio.ByteBuffer;

public final class c implements b {
    private static final Object fdj = new Object();
    private int bMU;
    private SurfaceTexture bsb;
    protected String cvZ;
    protected boolean eNa;
    protected int eTa;
    private EGLContext fag;
    private final Object fcD;
    protected String fcE;
    protected int fcF;
    protected float fcG;
    private int fcH;
    private float fcI;
    protected com.tencent.mm.plugin.mmsight.model.a.c fcJ;
    protected b fcK;
    protected int fcL;
    protected int fcM;
    protected int fcN;
    protected int fcO;
    protected int fcP;
    protected s fcQ;
    protected int fcR;
    protected String fcS;
    protected boolean fcT;
    protected String fcU;
    protected boolean fcV;
    protected com.tencent.mm.plugin.mmsight.model.b fcW;
    protected com.tencent.mm.plugin.mmsight.model.b fcX;
    protected VideoTransPara fcY;
    protected m fcZ;
    protected boolean fda;
    protected boolean fdb;
    protected int fdc;
    protected a fdd;
    protected Runnable fde;
    protected boolean fdf;
    protected boolean fdg;
    protected boolean fdh;
    private com.tencent.mm.media.g.a fdi;
    protected f fdk;
    private boolean isRecording;
    protected String mFileName;
    protected String thumbPath;

    static {
        AppMethodBeat.i(12776);
        AppMethodBeat.o(12776);
    }

    public c(VideoTransPara videoTransPara, com.tencent.mm.media.h.a aVar) {
        this(videoTransPara, aVar, null, -1);
    }

    public c(VideoTransPara videoTransPara, com.tencent.mm.media.h.a aVar, EGLContext eGLContext, int i) {
        AppMethodBeat.i(12751);
        this.fcD = new Object();
        this.fcE = "";
        this.fcF = 0;
        this.fcG = 0.0f;
        this.fcH = -1;
        this.fcI = -1.0f;
        this.fcL = 480;
        this.fcM = 640;
        this.fcN = 1600000;
        this.fcO = 480;
        this.fcP = 640;
        this.eTa = -1;
        this.fcS = null;
        this.fcT = false;
        this.thumbPath = null;
        this.fcU = null;
        this.fcV = false;
        this.fcW = new com.tencent.mm.plugin.mmsight.model.b("yuvRecorderWriteData");
        this.fcX = new com.tencent.mm.plugin.mmsight.model.b("frameCountCallback");
        this.eNa = false;
        this.fda = false;
        this.cvZ = "";
        this.fdb = false;
        this.fdc = 0;
        this.fde = null;
        this.fdf = false;
        this.fdg = true;
        this.fdh = false;
        this.isRecording = false;
        this.fdi = null;
        this.fag = null;
        this.bMU = -1;
        this.fdk = new f() {
            public final boolean O(byte[] bArr) {
                AppMethodBeat.i(12738);
                c.a(c.this, bArr);
                AppMethodBeat.o(12738);
                return false;
            }
        };
        this.fcY = videoTransPara;
        this.fcL = videoTransPara.width;
        this.fcM = videoTransPara.height;
        this.fcQ = new s();
        com.tencent.mm.media.i.c cVar = com.tencent.mm.media.i.c.faj;
        com.tencent.mm.media.i.c.Vv();
        ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "create MediaCodecMP4MuxRecorder, targetWidth: %s, targetHeight: %s", Integer.valueOf(this.fcL), Integer.valueOf(this.fcM));
        this.fag = eGLContext;
        this.fdi = new com.tencent.mm.media.g.a(aVar);
        this.bMU = i;
        ab.c("MicroMsg.Media.MediaCodecMP4MuxRecorder", "textureId : ".concat(String.valueOf(i)), new Object[0]);
        AppMethodBeat.o(12751);
    }

    private boolean kn(int i) {
        AppMethodBeat.i(12752);
        long yz = bo.yz();
        this.fcN = this.fcY.videoBitrate;
        this.eTa = SightVideoJNI.initDataBufferForMMSightLock(this.fcO, this.fcP, i, this.fcL, this.fcM, (float) this.fcY.fps, this.fcN, this.fcY.fzV, 8, this.fcY.fzU, 23.0f, false, false, this.fcY.duration, false);
        ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "init, bufId: %s", Integer.valueOf(this.eTa));
        if (this.eTa < 0) {
            ab.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "init failed!");
            AppMethodBeat.o(12752);
            return false;
        }
        this.fcR = i;
        com.tencent.mm.media.b.c cVar = new com.tencent.mm.media.b.c();
        if (cVar.eTn) {
            ab.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "encodeConfig  InitError");
            AppMethodBeat.o(12752);
            return false;
        }
        ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "mTargetRate " + this.fcN + "  videoParams.fps: " + this.fcY.fps + " mTargetHeight:" + this.fcM + " mTargetWidth:" + this.fcL);
        cVar.bitrate = this.fcN;
        cVar.eTk = this.fcY.fps;
        cVar.eTj = this.fcM;
        cVar.eTi = this.fcL;
        com.tencent.mm.media.i.c cVar2;
        try {
            this.fcK = new e(cVar, true, new a.f.a.b<b, y>() {
                public final /* synthetic */ Object am(Object obj) {
                    AppMethodBeat.i(12741);
                    b bVar = (b) obj;
                    bVar.eVy = new a.f.a.m<ByteBuffer, BufferInfo, y>() {
                        public final /* synthetic */ Object m(Object obj, Object obj2) {
                            AppMethodBeat.i(12739);
                            ByteBuffer byteBuffer = (ByteBuffer) obj;
                            BufferInfo bufferInfo = (BufferInfo) obj2;
                            ab.d("MicroMsg.Media.MediaCodecMP4MuxRecorder", "writeH264Data  ,bufferInfo.size : " + bufferInfo.size);
                            SightVideoJNI.writeH264DataLock(c.this.eTa, byteBuffer, bufferInfo.size);
                            AppMethodBeat.o(12739);
                            return null;
                        }
                    };
                    bVar.eVz = new a.f.a.a<y>() {
                        public final /* synthetic */ Object invoke() {
                            AppMethodBeat.i(12740);
                            c.a(c.this);
                            AppMethodBeat.o(12740);
                            return null;
                        }
                    };
                    AppMethodBeat.o(12741);
                    return null;
                }
            });
            com.tencent.mm.media.g.a aVar = this.fdi;
            Surface inputSurface = this.fcK.getInputSurface();
            EGLContext eGLContext = this.fag;
            AnonymousClass3 anonymousClass3 = new a.f.a.b<Boolean, y>() {
                public final /* synthetic */ Object am(Object obj) {
                    AppMethodBeat.i(12743);
                    y c = AnonymousClass3.c((Boolean) obj);
                    AppMethodBeat.o(12743);
                    return c;
                }

                private static y c(Boolean bool) {
                    AppMethodBeat.i(12742);
                    if (!bool.booleanValue()) {
                        com.tencent.mm.media.i.c cVar = com.tencent.mm.media.i.c.faj;
                        com.tencent.mm.media.i.c.Vx();
                    }
                    synchronized (c.fdj) {
                        try {
                            c.fdj.notifyAll();
                        } catch (Exception e) {
                            ab.printErrStackTrace("MicroMsg.Media.MediaCodecMP4MuxRecorder", e, "initSurfaceLock notify error", new Object[0]);
                        } catch (Throwable th) {
                            AppMethodBeat.o(12742);
                        }
                    }
                    AppMethodBeat.o(12742);
                    return null;
                }
            };
            j.p(inputSurface, "surface");
            aVar.aOO = inputSurface;
            ab.i(aVar.TAG, aVar.hashCode() + " initWithSurface, eglContext:" + eGLContext + ", surface:" + inputSurface + ", waitNewFrame:false, callback:false");
            aVar.b((a.f.a.a) new d(aVar, eGLContext, inputSurface, anonymousClass3));
            synchronized (fdj) {
                try {
                    fdj.wait(500);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.Media.MediaCodecMP4MuxRecorder", e, "initSurfaceLock wait error", new Object[0]);
                } catch (Throwable th) {
                    AppMethodBeat.o(12752);
                    throw th;
                }
            }
            this.fdi.eXd = new a.f.a.b<Boolean, y>() {
                public final /* synthetic */ Object am(Object obj) {
                    AppMethodBeat.i(12745);
                    if (c.this.fcK != null) {
                        c.this.fcK.UP();
                    }
                    if (c.this.fcK != null && c.this.fcQ.oxa == com.tencent.mm.plugin.mmsight.model.a.d.c.WaitStop) {
                        ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "final frame draw");
                        c.this.fcK.UO();
                        if (c.this.fcJ != null) {
                            c.this.fcJ.a(new com.tencent.mm.plugin.mmsight.model.a.c.b() {
                                public final void WT() {
                                    AppMethodBeat.i(12744);
                                    ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "aac stop finish");
                                    AppMethodBeat.o(12744);
                                }
                            });
                        }
                        c.this.fdi.release();
                    }
                    AppMethodBeat.o(12745);
                    return null;
                }
            };
            WH();
            this.fcJ = new a(this.fcY.audioSampleRate, this.fcY.fzS);
            this.fcJ.iW(this.fdf);
            int q = this.fcJ.q(this.eTa, com.tencent.mm.plugin.sight.base.d.WP(this.fcE));
            ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "initImpl used %sms", Long.valueOf(bo.az(yz)));
            if (q != 0) {
                cVar2 = com.tencent.mm.media.i.c.faj;
                com.tencent.mm.media.i.c.Vy();
                AppMethodBeat.o(12752);
                return false;
            }
            AppMethodBeat.o(12752);
            return true;
        } catch (Exception e2) {
            ab.printErrStackTrace("MicroMsg.Media.MediaCodecMP4MuxRecorder", e2, "init encoder error", new Object[0]);
            cVar2 = com.tencent.mm.media.i.c.faj;
            com.tencent.mm.media.i.c.Vw();
            AppMethodBeat.o(12752);
            return false;
        }
    }

    private void WH() {
        AppMethodBeat.i(12753);
        this.fdi.cg(this.fcL, this.fcM);
        this.fdi.ka(this.fcR);
        this.fdi.ch(this.fcO, this.fcP);
        ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "outputWidth: %s, outputHeight: %s, cameraPreviewWidth: %s, cameraPreviewHeight: %s, getDataRotate: %s", Integer.valueOf(r0), Integer.valueOf(r1), Integer.valueOf(this.fcO), Integer.valueOf(this.fcP), Integer.valueOf(this.fcR));
        AppMethodBeat.o(12753);
    }

    public final boolean ko(int i) {
        AppMethodBeat.i(12754);
        if (this.eNa) {
            AppMethodBeat.o(12754);
            return true;
        }
        ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "preInit, cameraOrientation %d", Integer.valueOf(i));
        boolean kn = kn(i);
        this.eNa = true;
        ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "initImpl result: %s", Boolean.valueOf(kn));
        AppMethodBeat.o(12754);
        return kn;
    }

    public final int b(int i, boolean z, int i2) {
        AppMethodBeat.i(12755);
        ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "start, cameraOrientation: %s, isLandscape: %s, degree: %s", Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2));
        this.fcW.reset();
        this.fcF = 0;
        this.fcX.reset();
        this.fcT = false;
        this.fdb = z;
        this.fdc = i2;
        this.fcQ.a(com.tencent.mm.plugin.mmsight.model.a.d.c.WaitStart);
        if (bo.isNullOrNil(this.fcE)) {
            ab.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "start error, mCurRecordPath is null!!");
            AppMethodBeat.o(12755);
            return -1;
        }
        int i3;
        try {
            this.mFileName = com.tencent.mm.vfs.e.atd(this.fcE);
            String atb = com.tencent.mm.vfs.e.atb(this.fcE);
            if (!atb.endsWith("/")) {
                atb = atb + "/";
            }
            this.fcS = atb + "tempRotate.mp4";
        } catch (Exception e) {
            ab.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "retrieve file name error: %s", e.getMessage());
        }
        ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "mCurRecordPath: %s, tempRotateFilePath: %s", this.fcE, this.fcS);
        this.fcR = i;
        if (!this.eNa) {
            kn(i);
            this.eNa = true;
        }
        if (this.fdh || this.fdf || this.fcJ == null) {
            ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "start yuvRecorder with mute");
            this.fcQ.a(com.tencent.mm.plugin.mmsight.model.a.d.c.Start);
            this.fda = false;
            i3 = 0;
        } else {
            i3 = this.fcJ.a(new com.tencent.mm.plugin.mmsight.model.a.c.a() {
                public final void WU() {
                    AppMethodBeat.i(12746);
                    ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "onPcmReady");
                    if (c.this.WL() != com.tencent.mm.plugin.mmsight.model.a.d.c.Initialized) {
                        ab.w("MicroMsg.Media.MediaCodecMP4MuxRecorder", "not MediaStatus.Initialized, maybe canceled by user");
                        AppMethodBeat.o(12746);
                        return;
                    }
                    c.this.fcQ.a(com.tencent.mm.plugin.mmsight.model.a.d.c.Start);
                    AppMethodBeat.o(12746);
                }
            });
            ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "start aacRecorder ret: %s", Integer.valueOf(i3));
            this.fda = false;
            if (i3 != 0) {
                this.fcQ.a(com.tencent.mm.plugin.mmsight.model.a.d.c.Error);
            } else {
                this.fcQ.a(com.tencent.mm.plugin.mmsight.model.a.d.c.Initialized);
            }
        }
        AppMethodBeat.o(12755);
        return i3;
    }

    public final void v(Runnable runnable) {
        AppMethodBeat.i(12756);
        this.fde = runnable;
        ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "!!!!!stop, stopCallback: %s !!!", runnable);
        if (this.fcK == null || (this.fcJ == null && !this.fdh)) {
            ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
            if (runnable != null) {
                al.d(runnable);
            }
            AppMethodBeat.o(12756);
        } else if (this.fcQ == null || this.fcQ.oxa != com.tencent.mm.plugin.mmsight.model.a.d.c.Stop) {
            this.fcF = (int) this.fcK.UQ();
            com.tencent.mm.media.i.c cVar = com.tencent.mm.media.i.c.faj;
            com.tencent.mm.media.i.c.Vz();
            if (this.fcQ != null) {
                this.fcQ.a(com.tencent.mm.plugin.mmsight.model.a.d.c.PrepareStop);
            }
            AppMethodBeat.o(12756);
        } else {
            ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "stop, already in stop videoRecordStatus");
            if (this.fcJ != null) {
                this.fcJ.clear();
            }
            if (runnable != null) {
                al.d(runnable);
            }
            AppMethodBeat.o(12756);
        }
    }

    public final String Aq() {
        AppMethodBeat.i(12757);
        String bc = bo.bc(this.cvZ, "");
        AppMethodBeat.o(12757);
        return bc;
    }

    public final void cancel() {
        AppMethodBeat.i(12758);
        ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "cancel record");
        if (this.fcK == null || (this.fcJ == null && !this.fdh)) {
            ab.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
            AppMethodBeat.o(12758);
            return;
        }
        this.fcQ.a(com.tencent.mm.plugin.mmsight.model.a.d.c.WaitStop);
        this.fcK.UO();
        if (this.fcJ != null) {
            this.fcJ.a(new com.tencent.mm.plugin.mmsight.model.a.c.b() {
                public final void WT() {
                    AppMethodBeat.i(12749);
                    ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "aac stop finish");
                    AppMethodBeat.o(12749);
                }
            });
        }
        if (this.eTa >= 0) {
            SightVideoJNI.releaseBigSightDataBufferLock(this.eTa);
        } else {
            ab.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "why buf id < 0 ? %d", Integer.valueOf(this.eTa));
        }
        this.fcQ.a(com.tencent.mm.plugin.mmsight.model.a.d.c.Stop);
        reset();
        AppMethodBeat.o(12758);
    }

    public final void clear() {
        AppMethodBeat.i(12759);
        try {
            ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "clear");
            if (this.fcJ != null) {
                this.fcJ.clear();
            }
            if (this.fdi != null) {
                this.fdi.release();
            }
            if (this.fcK != null) {
                this.fcK.release();
            }
            AppMethodBeat.o(12759);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Media.MediaCodecMP4MuxRecorder", e, "clear error: %s", e.getMessage());
            AppMethodBeat.o(12759);
        }
    }

    public final void setFilePath(String str) {
        this.fcE = str;
    }

    public final void mb(String str) {
        this.thumbPath = str;
    }

    public final void mc(String str) {
        this.fcU = str;
    }

    public final String WI() {
        return this.fcU;
    }

    public final String getFilePath() {
        return this.fcE;
    }

    public final String getFileName() {
        return this.mFileName;
    }

    public final float WJ() {
        return this.fcG;
    }

    public final void reset() {
        AppMethodBeat.i(12760);
        ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "reset, yuvRecorder: %s, aacRecorder: %s, muxer: %s", this.fcK, this.fcJ, this.fcZ);
        ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "reset, yuvRecorder: %s, aacRecorder: %s", this.fcK, this.fcJ);
        synchronized (this.fcD) {
            try {
                this.fcK = null;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(12760);
            }
        }
        this.fcJ = null;
        this.fcZ = null;
        this.eNa = false;
        this.fda = false;
    }

    public final long WK() {
        AppMethodBeat.i(12761);
        if (this.fcK != null) {
            long UQ = this.fcK.UQ();
            AppMethodBeat.o(12761);
            return UQ;
        }
        AppMethodBeat.o(12761);
        return 0;
    }

    public final f getFrameDataCallback() {
        return this.fdk;
    }

    public final void s(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(12762);
        ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "setSize, width: %s, height: %s, targetWidth: %s, targetHeight: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        if (i3 % 16 != 0) {
            i3 = com.tencent.mm.plugin.mmsight.d.yN(i3);
        }
        if (i4 % 16 != 0) {
            i4 = com.tencent.mm.plugin.mmsight.d.yN(i4);
        }
        ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "setSize, after align, targetWidth: %d, targetHeight: %d", Integer.valueOf(i3), Integer.valueOf(i4));
        this.fcO = i;
        this.fcP = i2;
        if (com.tencent.mm.plugin.mmsight.model.a.j.owk.g(Integer.valueOf(((i * i2) * 3) / 2)) == null) {
            ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "preloadCameraData, width: %s, height: %s, count: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(3));
            long yz = bo.yz();
            for (int i5 = 0; i5 < 3; i5++) {
                com.tencent.mm.plugin.mmsight.model.a.j.owk.g(new byte[(((i * i2) * 3) / 2)]);
            }
            ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "preloadCameraData used %sms", Long.valueOf(bo.az(yz)));
        }
        AppMethodBeat.o(12762);
    }

    public final String Wy() {
        return this.thumbPath;
    }

    public final com.tencent.mm.plugin.mmsight.model.a.d.c WL() {
        return this.fcQ.oxa;
    }

    public final int WM() {
        AppMethodBeat.i(12763);
        int round = Math.round(((float) this.fcF) / 1000.0f);
        AppMethodBeat.o(12763);
        return round;
    }

    public final Point WN() {
        AppMethodBeat.i(12764);
        Point point = new Point(this.fcO, this.fcP);
        AppMethodBeat.o(12764);
        return point;
    }

    public final int WO() {
        return this.fcR;
    }

    public final void pause() {
        AppMethodBeat.i(12765);
        ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "pause");
        if (this.fcQ != null && this.fcQ.oxa == com.tencent.mm.plugin.mmsight.model.a.d.c.Start) {
            this.fcQ.a(com.tencent.mm.plugin.mmsight.model.a.d.c.Pause);
        }
        AppMethodBeat.o(12765);
    }

    public final void G(int i, int i2, int i3) {
        AppMethodBeat.i(12766);
        ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "resume, cameraOrientation: %s, cameraPreviewWidth:%s, cameraPreviewHeight:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        this.fcR = i;
        this.fcO = i2;
        this.fcP = i3;
        this.fdi.ka(this.fcR);
        WH();
        if (this.fcQ != null && this.fcQ.oxa == com.tencent.mm.plugin.mmsight.model.a.d.c.Pause) {
            this.fcQ.a(com.tencent.mm.plugin.mmsight.model.a.d.c.Start);
        }
        AppMethodBeat.o(12766);
    }

    public final boolean WP() {
        return this.fda;
    }

    public final void a(a aVar) {
        this.fdd = aVar;
    }

    public final boolean isLandscape() {
        return this.fdb;
    }

    public final void cv(boolean z) {
        this.fdf = z;
    }

    public final com.tencent.mm.audio.b.c.a WQ() {
        AppMethodBeat.i(12767);
        if (this.fcJ != null) {
            com.tencent.mm.audio.b.c.a bPN = this.fcJ.bPN();
            AppMethodBeat.o(12767);
            return bPN;
        }
        AppMethodBeat.o(12767);
        return null;
    }

    public final void WR() {
        this.fdg = false;
    }

    public final void setMute(boolean z) {
        this.fdh = z;
    }

    public final void kp(int i) {
        AppMethodBeat.i(12768);
        ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "overrideDurationMs: %s", Integer.valueOf(i));
        this.fcH = i;
        AppMethodBeat.o(12768);
    }

    public final void af(float f) {
        AppMethodBeat.i(12769);
        ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "overrideFps: %s", Float.valueOf(f));
        this.fcI = f;
        AppMethodBeat.o(12769);
    }

    private boolean WS() {
        AppMethodBeat.i(12771);
        if (this.fcQ.oxa == com.tencent.mm.plugin.mmsight.model.a.d.c.Start || this.fcQ.oxa == com.tencent.mm.plugin.mmsight.model.a.d.c.PrepareStop) {
            if (this.fcQ.oxa == com.tencent.mm.plugin.mmsight.model.a.d.c.PrepareStop) {
                this.fcQ.oxa = com.tencent.mm.plugin.mmsight.model.a.d.c.WaitStop;
                ab.c("MicroMsg.Media.MediaCodecMP4MuxRecorder", "forward one more frame", new Object[0]);
            }
            if (this.fcJ != null) {
                this.fcJ.bPM();
            }
            this.fcX.jl(1);
            this.fcW.jl(1);
            AppMethodBeat.o(12771);
            return true;
        }
        AppMethodBeat.o(12771);
        return false;
    }

    public final void WG() {
        AppMethodBeat.i(12770);
        if (this.bMU >= 0 && WS()) {
            this.fdi.s(this.bMU, System.nanoTime());
        }
        if (this.bsb == null || !WS()) {
            AppMethodBeat.o(12770);
            return;
        }
        com.tencent.mm.media.g.a aVar = this.fdi;
        SurfaceTexture surfaceTexture = this.bsb;
        j.p(surfaceTexture, "surfaceTexture");
        aVar.b((a.f.a.a) new i(aVar, surfaceTexture));
        AppMethodBeat.o(12770);
    }

    static /* synthetic */ boolean c(c cVar) {
        AppMethodBeat.i(12774);
        long yz = bo.yz();
        if (cVar.fcK == null) {
            AppMethodBeat.o(12774);
            return false;
        }
        cVar.fcG = (((float) cVar.fcK.frameNum) * 1000.0f) / ((float) cVar.fcF);
        ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "stop, frameCount: %s, fps: %s, duration: %s, file: %s handlerrunning %s, overrideDurationMs: %s, overrideFps: %s", Integer.valueOf(r2), Float.valueOf(cVar.fcG), Integer.valueOf(cVar.fcF), cVar.fcE, Long.valueOf(bo.az(yz)), Integer.valueOf(cVar.fcH), Float.valueOf(cVar.fcI));
        ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "frameCountCallback %s", cVar.fcX.getValue());
        ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "yuvRecorderWriteDataCallback %s", cVar.fcW.getValue());
        String str = null;
        if (CaptureMMProxy.getInstance() != null) {
            str = CaptureMMProxy.getInstance().getAccVideoPath();
        } else if (!bo.isNullOrNil(cVar.fcE)) {
            str = new File(cVar.fcE).getParentFile().getAbsolutePath();
        }
        Object RJ = !bo.isNullOrNil(str) ? com.tencent.mm.plugin.mmsight.d.RJ(str) : cVar.fcE;
        int i = cVar.fcF;
        if (cVar.fcH > 0) {
            i = cVar.fcH;
        }
        float f = cVar.fcG;
        if (cVar.fcI > 0.0f) {
            f = cVar.fcI;
        }
        ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "muxResultPath : ".concat(String.valueOf(RJ)));
        m mVar = new m(cVar.eTa, RJ, f, cVar.fcN, i, cVar.fcY.audioSampleRate, cVar.fdh);
        long yz2 = bo.yz();
        ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "mux used %sms, success: %s", Long.valueOf(bo.az(yz2)), Boolean.valueOf(mVar.bPO()));
        if (mVar.bPO()) {
            SightVideoJNI.releaseBigSightDataBufferLock(cVar.eTa);
            cVar.fcQ.a(com.tencent.mm.plugin.mmsight.model.a.d.c.Stop);
            cVar.cvZ = g.cz(RJ);
            if (!(bo.isNullOrNil(RJ) || RJ.equals(cVar.fcE))) {
                com.tencent.mm.vfs.e.aQ(RJ, cVar.fcE);
                com.tencent.mm.vfs.e.deleteFile(RJ);
            }
            AppMethodBeat.o(12774);
            return true;
        }
        ab.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "mux failed!");
        k.bPC();
        AppMethodBeat.o(12774);
        return false;
    }
}
