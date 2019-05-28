package com.tencent.mm.plugin.api.recordView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.YuvImage;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.api.recordView.g.a;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.c;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.g;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.h;
import com.tencent.mm.plugin.mmsight.model.a.d;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.model.j;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.plugin.video.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ugc.TXRecordCommon;
import com.tencent.wxmm.v2helper;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class f extends e implements a, d.a, com.tencent.mm.plugin.mmsight.model.f {
    private int audioSampleRate;
    private Context context;
    private int fps;
    private int fzS;
    private d gLK;
    com.tencent.mm.plugin.mmsight.model.e gLL;
    int gLM;
    private int gLN;
    float gLO;
    private int gLP;
    private boolean gLQ = true;
    private ObservableTextureView gLR;
    MMSightCameraGLSurfaceView gLS;
    boolean gLT = false;
    private MMSightRecordView.a gLU;
    boolean gLV = false;
    boolean gLW = false;
    int gLX = -1;
    Point gLY;
    private Point gLZ;
    private boolean gMa = true;
    private boolean gMb = true;
    private g gMc;
    MMSightRecordView.d gMd;
    c gMe;
    private boolean gMf = false;
    private float gMg = 1.0f;
    private WindowManager gMh = null;
    h gMi = null;
    private Point gMj = new Point(0, 0);
    private byte[] gMk = null;
    private int videoBitrate;
    private String videoPath;

    public f() {
        AppMethodBeat.i(76344);
        AppMethodBeat.o(76344);
    }

    public final void b(Context context, ViewGroup viewGroup) {
        AppMethodBeat.i(76345);
        this.context = context;
        this.gLR = new ObservableTextureView(context);
        this.gLS = new MMSightCameraGLSurfaceView(context);
        int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(context, 1);
        viewGroup.addView(this.gLR, new LayoutParams(fromDPToPix, fromDPToPix));
        viewGroup.addView(this.gLS, new MarginLayoutParams(-1, -1));
        this.gMc = new g();
        this.gMc.gMu = this;
        this.gLS.setOnTouchListener(this.gMc);
        j.bPw();
        ab.i("MicroMsg.MMSightRecordViewImpl", "init view, context: %s", context);
        AppMethodBeat.o(76345);
    }

    public final void setInitErrorCallback(MMSightRecordView.d dVar) {
        this.gMd = dVar;
    }

    public final void setInitDoneCallback(c cVar) {
        this.gMe = cVar;
    }

    public final void setDisplayRatio(float f) {
        AppMethodBeat.i(76346);
        int asz = asz();
        ab.i("MicroMsg.MMSightRecordViewImpl", "setDisplayRatio: %s, screenRotation: %s", Float.valueOf(f), Integer.valueOf(asz));
        this.gLO = f;
        if (asz == 90 || asz == 270) {
            this.gLO = 1.0f / this.gLO;
        }
        AppMethodBeat.o(76346);
    }

    public final void setPreviewSizeLimit(int i) {
        AppMethodBeat.i(76347);
        ab.i("MicroMsg.MMSightRecordViewImpl", "setPreviewSizeLimit: %s", Integer.valueOf(i));
        this.gLM = i;
        AppMethodBeat.o(76347);
    }

    public final void setRGBSizeLimit(int i) {
        AppMethodBeat.i(76348);
        ab.i("MicroMsg.MMSightRecordViewImpl", "setRGBSizeLimit: %s", Integer.valueOf(i));
        this.gLN = i;
        AppMethodBeat.o(76348);
    }

    public final void startPreview() {
        AppMethodBeat.i(76349);
        ab.i("MicroMsg.MMSightRecordViewImpl", "startPreview, displayRatio: %s, previewSizeLimit: %s", Float.valueOf(this.gLO), Integer.valueOf(this.gLM));
        if (this.gLO > 0.0f && this.gLM > 0) {
            VideoTransPara videoTransPara = new VideoTransPara();
            videoTransPara.width = this.gLM;
            videoTransPara.height = (int) (((float) this.gLM) / this.gLO);
            ab.i("MicroMsg.MMSightRecordViewImpl", "para width: %s, height: %s", Integer.valueOf(videoTransPara.width), Integer.valueOf(videoTransPara.height));
            this.gLL = new com.tencent.mm.plugin.mmsight.model.e(videoTransPara, -1);
            this.gLL.a((com.tencent.mm.plugin.mmsight.model.f) this);
            if (this.gLL.v(this.context, this.gLQ)) {
                ab.i("MicroMsg.MMSightRecordViewImpl", "open camera finish");
                if (this.gLR.isAvailable()) {
                    if (this.gLL.a(this.gLR.getSurfaceTexture(), this.gLM, this.gLO, this.gLV) < 0) {
                        ab.e("MicroMsg.MMSightRecordViewImpl", "start preview failed!");
                        if (this.gMd != null) {
                            this.gMd.aDo();
                        }
                    }
                    if (this.gLX != -1) {
                        ass();
                    }
                    this.gLL.bPn();
                    ab.i("MicroMsg.MMSightRecordViewImpl", "do start preview directly");
                    asp();
                    asA();
                    if (this.gMi != null) {
                        this.gMi.a(this.gLS.fag);
                    }
                    AppMethodBeat.o(76349);
                    return;
                }
                this.gLR.setTextureChangeCallback(new b() {
                    public final void e(SurfaceTexture surfaceTexture) {
                        AppMethodBeat.i(76338);
                        if (f.this.gLL.a(surfaceTexture, f.this.gLM, f.this.gLO, f.this.gLV) < 0) {
                            ab.e("MicroMsg.MMSightRecordViewImpl", "start preview failed!");
                            if (f.this.gMd != null) {
                                f.this.gMd.aDo();
                            }
                        }
                        if (f.this.gLX != -1) {
                            f.this.ass();
                        }
                        f.this.gLL.bPn();
                        f.this.asp();
                        f.this.asA();
                        if (f.this.gMi != null) {
                            f.this.gMi.a(f.this.gLS.fag);
                        }
                        ab.i("MicroMsg.MMSightRecordViewImpl", "do start preview after texture available");
                        AppMethodBeat.o(76338);
                    }
                });
            } else {
                ab.i("MicroMsg.MMSightRecordViewImpl", "open camera failed!");
                if (this.gMd != null) {
                    this.gMd.aDo();
                }
                AppMethodBeat.o(76349);
                return;
            }
        }
        AppMethodBeat.o(76349);
    }

    public final void setVideoPara$2e715812(int i) {
        AppMethodBeat.i(76350);
        this.gLP = i;
        this.videoBitrate = 4800000;
        this.fps = 30;
        this.fzS = 64000;
        this.audioSampleRate = TXRecordCommon.AUDIO_SAMPLERATE_44100;
        ab.i("MicroMsg.MMSightRecordViewImpl", "setVideoPara, maxDuration: %s, videoBitrate: %s, fps: %s, audioBitrate: %s, audioSampleRate: %s", Integer.valueOf(i), Integer.valueOf(4800000), Integer.valueOf(30), Integer.valueOf(64000), Integer.valueOf(TXRecordCommon.AUDIO_SAMPLERATE_44100));
        AppMethodBeat.o(76350);
    }

    public final void setVideoFilePath(String str) {
        AppMethodBeat.i(76351);
        ab.i("MicroMsg.MMSightRecordViewImpl", "setVideoFilePath: %s", str);
        this.videoPath = str;
        AppMethodBeat.o(76351);
    }

    public final String getVideoFilePath() {
        AppMethodBeat.i(76352);
        String str;
        if (this.gLK == null || !this.gLT) {
            str = this.videoPath;
            AppMethodBeat.o(76352);
            return str;
        }
        str = this.gLK.getFilePath();
        AppMethodBeat.o(76352);
        return str;
    }

    public final void aso() {
        AppMethodBeat.i(76353);
        asp();
        AppMethodBeat.o(76353);
    }

    /* Access modifiers changed, original: final */
    public final void asp() {
        AppMethodBeat.i(76354);
        if (this.gLT) {
            ab.i("MicroMsg.MMSightRecordViewImpl", "initRecorder, already init");
            AppMethodBeat.o(76354);
            return;
        }
        if (this.gLK != null) {
            ab.i("MicroMsg.MMSightRecordViewImpl", "startRecord, recorder not null, stop first");
            this.gLK.cancel();
            if (this.gLL != null) {
                this.gLL.b(this.gLK.getFrameDataCallback());
            }
            this.gLK = null;
        }
        if (this.gLM > 0 && this.gLP > 0 && this.videoBitrate > 0 && this.fps > 0 && this.fzS > 0 && this.audioSampleRate > 0 && this.gLL != null && this.gLL.getEncodeVideoBestSize() != null) {
            VideoTransPara videoTransPara = new VideoTransPara();
            videoTransPara.width = this.gLM;
            videoTransPara.height = (int) (((float) this.gLM) / this.gLO);
            videoTransPara.duration = this.gLP;
            videoTransPara.videoBitrate = this.videoBitrate;
            videoTransPara.fps = this.fps;
            videoTransPara.fzS = this.fzS;
            videoTransPara.audioSampleRate = this.audioSampleRate;
            videoTransPara.fzU = 2;
            videoTransPara.fzV = 1;
            videoTransPara.fzT = 1;
            j.ouz.fcY = videoTransPara;
            j.ouz.videoBitrate = this.videoBitrate;
            j.ouz.fay = this.gLM;
            k.bPR();
            this.gLK = k.p(videoTransPara);
            if (this.gLK == null) {
                ab.e("MicroMsg.MMSightRecordViewImpl", "can not get media recorder!");
                if (this.gMd != null) {
                    this.gMd.aDo();
                }
                AppMethodBeat.o(76354);
                return;
            }
            this.gLK.setFilePath(this.videoPath);
            if (this.gLV && this.gLL != null && this.gLL.bPu()) {
                asq();
            }
            int i = this.gLL.getEncodeVideoBestSize().x;
            int i2 = this.gLL.getEncodeVideoBestSize().y;
            if (this.gLZ != null && this.gLV) {
                i = this.gLZ.x;
                i2 = this.gLZ.y;
            }
            i2 = (int) (((float) i2) * this.gMg);
            i = com.tencent.mm.plugin.mmsight.d.yP((int) (((float) i) * this.gMg));
            i2 = com.tencent.mm.plugin.mmsight.d.yP(i2);
            ab.i("MicroMsg.MMSightRecordViewImpl", "initRecorder, videoWidth: %s, videoHeight: %s, videoSizeRatio: %s", Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(this.gMg));
            if (this.gLZ == null || !this.gLV) {
                this.gLK.s(this.gLL.getPreviewWidth(), this.gLL.getPreviewHeight(), i, i2);
            } else {
                this.gLK.s(this.gLZ.y, this.gLZ.x, i, i2);
            }
            this.gLK.WR();
            this.gLK.a(this);
            if (this.gLK.ko(this.gLL.getOrientation())) {
                al.n(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(138312);
                        if (f.this.gMe != null) {
                            f.this.gMe.aDp();
                        }
                        AppMethodBeat.o(138312);
                    }
                }, 100);
                this.gLT = true;
            } else {
                ab.e("MicroMsg.MMSightRecordViewImpl", "init recorder error");
                if (this.gMd != null) {
                    this.gMd.aDo();
                }
                AppMethodBeat.o(76354);
                return;
            }
        }
        AppMethodBeat.o(76354);
    }

    public final boolean EL() {
        AppMethodBeat.i(76355);
        ab.i("MicroMsg.MMSightRecordViewImpl", "startRecord, recorder: %s", this.gLK);
        asp();
        if (this.gLK == null) {
            ab.e("MicroMsg.MMSightRecordViewImpl", "startRecord error, recorder is null!");
            AppMethodBeat.o(76355);
            return false;
        }
        int asz = asz();
        ab.i("MicroMsg.MMSightRecordViewImpl", "screen rotate: %s", Integer.valueOf(asz));
        if (asz == 90 || asz == 270) {
            asz = this.gLK.b(this.gLL.getOrientation(), true, 360 - asz);
        } else {
            asz = this.gLK.b(this.gLL.getOrientation(), false, asz);
        }
        ab.i("MicroMsg.MMSightRecordViewImpl", "startRecord now, ret: %s", Integer.valueOf(asz));
        if (asz >= 0) {
            AppMethodBeat.o(76355);
            return true;
        }
        AppMethodBeat.o(76355);
        return false;
    }

    public final void a(final h hVar) {
        AppMethodBeat.i(76356);
        if (this.gLK != null) {
            ab.i("MicroMsg.MMSightRecordViewImpl", "stopRecord, stopCallback: %s", hVar);
            this.gLK.a(new d.a() {
                public final void asv() {
                    AppMethodBeat.i(138313);
                    if (hVar != null) {
                        hVar.dX(true);
                    }
                    AppMethodBeat.o(138313);
                }
            });
            this.gLK.v(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(76341);
                    f.this.gLT = false;
                    if (hVar != null) {
                        hVar.dX(false);
                    }
                    AppMethodBeat.o(76341);
                }
            });
            this.gLK = null;
        }
        AppMethodBeat.o(76356);
    }

    public final void a(final g gVar, final boolean z) {
        AppMethodBeat.i(76357);
        if (!(gVar == null || this.gLL == null || !this.gLL.bPu())) {
            if (z) {
                this.gLL.bPr();
            }
            if (z) {
                al.n(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(138314);
                        f.this.b(gVar, z);
                        AppMethodBeat.o(138314);
                    }
                }, 100);
                AppMethodBeat.o(76357);
                return;
            }
            b(gVar, z);
        }
        AppMethodBeat.o(76357);
    }

    /* Access modifiers changed, original: final */
    public final void b(final g gVar, final boolean z) {
        AppMethodBeat.i(76358);
        this.gLL.a(new com.tencent.mm.plugin.mmsight.model.e.b() {
            /* JADX WARNING: Removed duplicated region for block: B:22:0x00a5 A:{Catch:{ Exception -> 0x010a }} */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void a(byte[] bArr, int i, int i2, int i3, int i4) {
                AppMethodBeat.i(138315);
                if (z) {
                    f.this.gLL.bPs();
                }
                if (bArr == null || i < 0 || i2 < 0 || i3 < 0) {
                    ab.e("MicroMsg.MMSightRecordViewImpl", "onPictureYuvTaken, data is null!!");
                    gVar.aDq();
                    AppMethodBeat.o(138315);
                    return;
                }
                try {
                    byte[] bArr2;
                    int i5;
                    int i6;
                    YuvImage yuvImage;
                    ByteArrayOutputStream byteArrayOutputStream;
                    byte[] toByteArray;
                    Bitmap decodeByteArray;
                    Bitmap copy;
                    if (f.this.gLW) {
                        f.this.asr();
                        if (f.this.gLL.oud) {
                            if (f.this.gLY.y < i) {
                                bArr2 = new byte[(((f.this.gLY.x * f.this.gLY.y) * 3) >> 1)];
                                SightVideoJNI.cropCameraDataLongEdge(bArr, bArr2, i, f.this.gLY.y, i2);
                                i = f.this.gLY.y;
                                i5 = f.this.gLY.x;
                                i6 = i;
                                yuvImage = new YuvImage(bArr2, 17, i6, i5, null);
                                byteArrayOutputStream = new ByteArrayOutputStream();
                                yuvImage.compressToJpeg(new Rect(0, 0, i6, i5), 100, byteArrayOutputStream);
                                toByteArray = byteArrayOutputStream.toByteArray();
                                decodeByteArray = MMBitmapFactory.decodeByteArray(toByteArray, 0, toByteArray.length);
                                if (i4 == 90 || i4 == 270) {
                                    i3 = ((i3 - i4) + v2helper.VOIP_ENC_HEIGHT_LV1) % v2helper.VOIP_ENC_HEIGHT_LV1;
                                }
                                if (i3 != 0 || i3 == v2helper.VOIP_ENC_HEIGHT_LV1) {
                                    copy = decodeByteArray.copy(Config.ARGB_8888, false);
                                } else {
                                    copy = com.tencent.mm.sdk.platformtools.d.b(decodeByteArray, (float) i3);
                                }
                                ab.i("MicroMsg.MMSightRecordViewImpl", "bitmap recycle %s", decodeByteArray.toString());
                                decodeByteArray.recycle();
                                gVar.F(copy);
                                AppMethodBeat.o(138315);
                            }
                        } else if (f.this.gLY.x < i2) {
                            bArr2 = new byte[(((f.this.gLY.x * f.this.gLY.y) * 3) >> 1)];
                            SightVideoJNI.cropCameraData(bArr, bArr2, i, i2, f.this.gLY.x);
                            i = f.this.gLY.y;
                            i5 = f.this.gLY.x;
                            i6 = i;
                            yuvImage = new YuvImage(bArr2, 17, i6, i5, null);
                            byteArrayOutputStream = new ByteArrayOutputStream();
                            yuvImage.compressToJpeg(new Rect(0, 0, i6, i5), 100, byteArrayOutputStream);
                            toByteArray = byteArrayOutputStream.toByteArray();
                            decodeByteArray = MMBitmapFactory.decodeByteArray(toByteArray, 0, toByteArray.length);
                            i3 = ((i3 - i4) + v2helper.VOIP_ENC_HEIGHT_LV1) % v2helper.VOIP_ENC_HEIGHT_LV1;
                            if (i3 != 0) {
                            }
                            copy = decodeByteArray.copy(Config.ARGB_8888, false);
                            ab.i("MicroMsg.MMSightRecordViewImpl", "bitmap recycle %s", decodeByteArray.toString());
                            decodeByteArray.recycle();
                            gVar.F(copy);
                            AppMethodBeat.o(138315);
                        }
                    }
                    i5 = i2;
                    i6 = i;
                    bArr2 = bArr;
                    yuvImage = new YuvImage(bArr2, 17, i6, i5, null);
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    yuvImage.compressToJpeg(new Rect(0, 0, i6, i5), 100, byteArrayOutputStream);
                    toByteArray = byteArrayOutputStream.toByteArray();
                    decodeByteArray = MMBitmapFactory.decodeByteArray(toByteArray, 0, toByteArray.length);
                    i3 = ((i3 - i4) + v2helper.VOIP_ENC_HEIGHT_LV1) % v2helper.VOIP_ENC_HEIGHT_LV1;
                    if (i3 != 0) {
                    }
                    copy = decodeByteArray.copy(Config.ARGB_8888, false);
                    ab.i("MicroMsg.MMSightRecordViewImpl", "bitmap recycle %s", decodeByteArray.toString());
                    decodeByteArray.recycle();
                    gVar.F(copy);
                    AppMethodBeat.o(138315);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.MMSightRecordViewImpl", e, "saveCaptureYuvDataToBitmap error: %s", e.getMessage());
                    gVar.aDq();
                    AppMethodBeat.o(138315);
                }
            }
        }, false, asz());
        AppMethodBeat.o(76358);
    }

    public final void setUseBackCamera(boolean z) {
        AppMethodBeat.i(76359);
        ab.i("MicroMsg.MMSightRecordViewImpl", "setUseBackCamera: %s", Boolean.valueOf(z));
        this.gLQ = z;
        AppMethodBeat.o(76359);
    }

    public final Point getPictureSize() {
        AppMethodBeat.i(76360);
        Point point;
        if (this.gLL == null || !this.gLL.bPu()) {
            AppMethodBeat.o(76360);
            return null;
        } else if (this.gLW) {
            asr();
            point = this.gLY;
            AppMethodBeat.o(76360);
            return point;
        } else {
            point = new Point(this.gLL.getPreviewWidth(), this.gLL.getPreviewHeight());
            AppMethodBeat.o(76360);
            return point;
        }
    }

    public final Point getVideoSize() {
        AppMethodBeat.i(76361);
        if (this.gLL == null || !this.gLL.bPu()) {
            AppMethodBeat.o(76361);
            return null;
        }
        int i = this.gLL.getEncodeVideoBestSize().x;
        int i2 = this.gLL.getEncodeVideoBestSize().y;
        if (this.gLZ != null && this.gLV) {
            i = this.gLZ.x;
            i2 = this.gLZ.y;
        }
        Point point = new Point(com.tencent.mm.plugin.mmsight.d.yP((int) (((float) i) * this.gMg)), com.tencent.mm.plugin.mmsight.d.yP((int) (((float) i2) * this.gMg)));
        AppMethodBeat.o(76361);
        return point;
    }

    public final Point getPreviewSize() {
        AppMethodBeat.i(76362);
        int i = (this.gLL.getOrientation() == 0 || this.gLL.getOrientation() == 180) ? 1 : 0;
        ab.i("MicroMsg.MMSightRecordViewImpl", "getPreviewSize : %d %d", Integer.valueOf(i != 0 ? this.gLL.getPreviewWidth() : this.gLL.getPreviewHeight()), Integer.valueOf(i != 0 ? this.gLL.getPreviewHeight() : this.gLL.getPreviewWidth()));
        Point point = new Point(r1, r0);
        AppMethodBeat.o(76362);
        return point;
    }

    public final Point getDrawSizePoint() {
        AppMethodBeat.i(76363);
        ab.i("MicroMsg.MMSightRecordViewImpl", "getDrawSizePoint : %s", this.gMj.toString());
        Point point = this.gMj;
        AppMethodBeat.o(76363);
        return point;
    }

    public final void setFrameDataCallback(MMSightRecordView.a aVar) {
        this.gLU = aVar;
    }

    public final int getCameraRotation() {
        AppMethodBeat.i(76364);
        if (this.gLL != null) {
            int orientation = this.gLL.getOrientation();
            AppMethodBeat.o(76364);
            return orientation;
        }
        AppMethodBeat.o(76364);
        return 0;
    }

    public final void switchCamera() {
        AppMethodBeat.i(76365);
        if (this.gLL != null && this.gLL.bPu() && (this.gLK == null || this.gLK.WL() != d.c.Start)) {
            this.gLL.a(this.context, this.gLR.getSurfaceTexture(), this.gLM, this.gLO, this.gLV);
            if (this.gMi != null) {
                Point previewSize = getPreviewSize();
                this.gMi.h(previewSize.x, previewSize.y, this.gLL.getOrientation(), this.gMj.x, this.gMj.y);
            }
        }
        AppMethodBeat.o(76365);
    }

    public final void setClipVideoSize(boolean z) {
        AppMethodBeat.i(76366);
        this.gLV = z;
        if (this.gLV && this.gLL != null && this.gLL.bPu()) {
            asq();
        }
        AppMethodBeat.o(76366);
    }

    private void asq() {
        AppMethodBeat.i(76367);
        if (this.gLL != null && this.gLL.bPu()) {
            if (this.gLL.oud) {
                this.gLZ = new Point(com.tencent.mm.plugin.mmsight.d.ev((int) (((float) this.gLL.getPreviewWidth()) / this.gLO), this.gLL.getPreviewHeight()), this.gLL.getPreviewWidth());
            } else {
                this.gLZ = new Point(this.gLL.getPreviewHeight(), com.tencent.mm.plugin.mmsight.d.ev((int) (((float) this.gLL.getPreviewHeight()) * this.gLO), this.gLL.getPreviewWidth()));
            }
            ab.i("MicroMsg.MMSightRecordViewImpl", "initVideoSize: %s", this.gLZ);
        }
        AppMethodBeat.o(76367);
    }

    public final void setClipPictureSize(boolean z) {
        AppMethodBeat.i(76368);
        this.gLW = z;
        if (this.gLW && this.gLL != null && this.gLL.bPu()) {
            asr();
        }
        AppMethodBeat.o(76368);
    }

    /* Access modifiers changed, original: final */
    public final void asr() {
        AppMethodBeat.i(76369);
        if (this.gLL != null && this.gLL.bPu()) {
            if (this.gLL.oud) {
                this.gLY = new Point(this.gLL.getPreviewWidth(), (int) (((float) this.gLL.getPreviewWidth()) / this.gLO));
                AppMethodBeat.o(76369);
                return;
            }
            this.gLY = new Point((int) (((float) this.gLL.getPreviewHeight()) * this.gLO), this.gLL.getPreviewHeight());
        }
        AppMethodBeat.o(76369);
    }

    public final void setFlashMode(int i) {
        boolean z = true;
        AppMethodBeat.i(76370);
        this.gLX = i;
        String str = "MicroMsg.MMSightRecordViewImpl";
        String str2 = "setFlashMode: %s, camera: %s, previewing: %s";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = this.gLL;
        if (this.gLL == null || !this.gLL.bPu()) {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        ab.i(str, str2, objArr);
        if (this.gLL != null && this.gLL.bPu()) {
            ass();
        }
        AppMethodBeat.o(76370);
    }

    /* Access modifiers changed, original: final */
    public final void ass() {
        AppMethodBeat.i(76371);
        ab.i("MicroMsg.MMSightRecordViewImpl", "setFlashModeImpl, mode: %s", Integer.valueOf(this.gLX));
        switch (this.gLX) {
            case 1:
                this.gLL.bPr();
                AppMethodBeat.o(76371);
                return;
            case 2:
                this.gLL.bPs();
                AppMethodBeat.o(76371);
                return;
            case 3:
                this.gLL.bPt();
                break;
        }
        AppMethodBeat.o(76371);
    }

    public final int getFlashMode() {
        return this.gLX;
    }

    public final void setEnableDragZoom(boolean z) {
        this.gMa = z;
    }

    public final void setEnableTouchFocus(boolean z) {
        this.gMb = z;
    }

    public final void ast() {
        AppMethodBeat.i(76372);
        ab.i("MicroMsg.MMSightRecordViewImpl", "setHalfPreviewVideoSize");
        this.gMg = 0.5f;
        AppMethodBeat.o(76372);
    }

    public final void asu() {
        AppMethodBeat.i(76373);
        ab.i("MicroMsg.MMSightRecordViewImpl", "set34PreviewVideoSize");
        this.gMg = 0.75f;
        AppMethodBeat.o(76373);
    }

    public final Bitmap getCurrentFramePicture() {
        AppMethodBeat.i(76374);
        if (this.gLL != null && this.gLL.bPu()) {
            byte[] bArr;
            com.tencent.mm.plugin.mmsight.model.e eVar = this.gLL;
            if (eVar.fbl != null) {
                eVar.fbk = true;
                bArr = new byte[eVar.fbl.length];
                System.arraycopy(eVar.fbl, 0, bArr, 0, eVar.fbl.length);
                eVar.fbk = false;
            } else {
                bArr = null;
            }
            if (bArr != null) {
                byte[] g;
                byte[] bArr2;
                int previewWidth = this.gLL.getPreviewWidth();
                int previewHeight = this.gLL.getPreviewHeight();
                if (this.gLL.oud) {
                    int previewWidth2 = (int) (((float) this.gLL.getPreviewWidth()) / this.gLO);
                    if (previewWidth2 < previewHeight) {
                        if (this.gLV || this.gMk != null) {
                            g = com.tencent.mm.plugin.mmsight.model.a.j.owk.g(Integer.valueOf(((this.gLZ.x * this.gLZ.y) * 3) >> 1));
                        } else {
                            this.gMk = new byte[(((previewWidth * previewWidth2) * 3) >> 1)];
                            g = this.gMk;
                        }
                        SightVideoJNI.cropCameraDataLongEdge(bArr, g, previewHeight, this.gLZ.x, previewWidth);
                        if (this.gLV) {
                            previewWidth2 = this.gLZ.x;
                        }
                        this.gMf = true;
                        previewHeight = previewWidth2;
                    } else {
                        g = bArr;
                    }
                    bArr2 = g;
                } else {
                    int i = (int) (((float) previewHeight) * this.gLO);
                    if (i < previewWidth) {
                        if (this.gLV || this.gMk != null) {
                            g = com.tencent.mm.plugin.mmsight.model.a.j.owk.g(Integer.valueOf(((this.gLZ.x * this.gLZ.y) * 3) >> 1));
                        } else {
                            this.gMk = new byte[(((i * previewHeight) * 3) >> 1)];
                            g = this.gMk;
                        }
                        SightVideoJNI.cropCameraData(bArr, g, previewHeight, previewWidth, this.gLZ.y);
                        previewWidth = this.gLZ.y;
                        this.gMf = true;
                        bArr2 = g;
                    } else {
                        bArr2 = bArr;
                    }
                }
                YuvImage yuvImage = new YuvImage(bArr2, 17, previewHeight, previewWidth, null);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                yuvImage.compressToJpeg(new Rect(0, 0, previewHeight, previewWidth), 100, byteArrayOutputStream);
                g = byteArrayOutputStream.toByteArray();
                Bitmap decodeByteArray = MMBitmapFactory.decodeByteArray(g, 0, g.length);
                Bitmap b = com.tencent.mm.sdk.platformtools.d.b(decodeByteArray, (float) this.gLL.getOrientation());
                ab.i("MicroMsg.MMSightRecordViewImpl", "bitmap recycle %s", decodeByteArray);
                decodeByteArray.recycle();
                AppMethodBeat.o(76374);
                return b;
            }
        }
        AppMethodBeat.o(76374);
        return null;
    }

    public final void release() {
        AppMethodBeat.i(76375);
        ab.i("MicroMsg.MMSightRecordViewImpl", "release, camera: %s, recorder: %s", this.gLL, this.gLK);
        if (this.gLL != null) {
            this.gLL.bPq();
        }
        if (this.gLK != null) {
            this.gLK.a(null);
            this.gLK.v(null);
            this.gLK = null;
        }
        if (this.gMi != null) {
            this.gMi.release();
        }
        this.gLT = false;
        this.gLV = false;
        this.gLW = false;
        this.gLY = null;
        this.gLZ = null;
        this.gLX = -1;
        this.gMa = true;
        this.gMb = true;
        com.tencent.mm.plugin.mmsight.model.a.j.owk.WY();
        AppMethodBeat.o(76375);
    }

    public final boolean O(byte[] bArr) {
        AppMethodBeat.i(76376);
        if (bArr == null) {
            AppMethodBeat.o(76376);
            return false;
        }
        int asz;
        byte[] bArr2;
        if (this.gMi != null) {
            asz = asz();
            h hVar = this.gMi;
            if (hVar.eCM || hVar.gMv != null) {
                hVar.queue(new com.tencent.mm.plugin.api.recordView.h.AnonymousClass2(bArr, asz));
            }
        }
        if (this.gLO <= 0.0f || this.gLM <= 0 || this.gLL == null) {
            bArr2 = bArr;
        } else {
            int previewWidth = this.gLL.getPreviewWidth();
            int previewHeight = this.gLL.getPreviewHeight();
            int previewWidth2;
            if (this.gLL.oud) {
                previewWidth2 = (int) (((float) this.gLL.getPreviewWidth()) / this.gLO);
                if (previewWidth2 < previewHeight) {
                    if (this.gLV || this.gMk != null) {
                        bArr2 = com.tencent.mm.plugin.mmsight.model.a.j.owk.g(Integer.valueOf(((this.gLZ.x * this.gLZ.y) * 3) >> 1));
                    } else {
                        this.gMk = new byte[(((previewWidth * previewWidth2) * 3) >> 1)];
                        bArr2 = this.gMk;
                    }
                    bo.yz();
                    SightVideoJNI.cropCameraDataLongEdge(bArr, bArr2, previewHeight, this.gLZ.x, previewWidth);
                    if (this.gLV) {
                        previewWidth2 = this.gLZ.x;
                    }
                    this.gMf = true;
                } else {
                    previewWidth2 = previewHeight;
                    bArr2 = bArr;
                }
                previewHeight = previewWidth2;
            } else {
                asz = (int) (((float) previewHeight) * this.gLO);
                if (asz < previewWidth) {
                    if (this.gLV || this.gMk != null) {
                        bArr2 = com.tencent.mm.plugin.mmsight.model.a.j.owk.g(Integer.valueOf(((this.gLZ.x * this.gLZ.y) * 3) >> 1));
                    } else {
                        this.gMk = new byte[(((asz * previewHeight) * 3) >> 1)];
                        bArr2 = this.gMk;
                    }
                    bo.yz();
                    SightVideoJNI.cropCameraData(bArr, bArr2, previewHeight, previewWidth, this.gLZ.y);
                    previewWidth2 = this.gLZ.y;
                    this.gMf = true;
                    previewWidth = previewWidth2;
                } else {
                    bArr2 = bArr;
                }
            }
            if (this.gLS != null) {
                MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView = this.gLS;
                int orientation = this.gLL.getOrientation();
                if (!(previewHeight == mMSightCameraGLSurfaceView.gLw && previewWidth == mMSightCameraGLSurfaceView.gLx && orientation == mMSightCameraGLSurfaceView.fcf)) {
                    ab.i("MicroMsg.MMSightCameraGLSurfaceView", "setFrameInfo, width: %s, height: %s, rotate: %s this: %s", Integer.valueOf(previewHeight), Integer.valueOf(previewWidth), Integer.valueOf(orientation), mMSightCameraGLSurfaceView);
                    mMSightCameraGLSurfaceView.gLw = previewHeight;
                    mMSightCameraGLSurfaceView.gLx = previewWidth;
                    mMSightCameraGLSurfaceView.fcf = orientation;
                }
                previewHeight = asz();
                MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView2 = this.gLS;
                if (bArr2 == null || mMSightCameraGLSurfaceView2.gLE == null || mMSightCameraGLSurfaceView2.gLE.gLv) {
                    ab.v("MicroMsg.MMSightCameraGLSurfaceView", "passing draw");
                } else {
                    a aVar = mMSightCameraGLSurfaceView2.gLE;
                    int i = mMSightCameraGLSurfaceView2.gLw;
                    int i2 = mMSightCameraGLSurfaceView2.gLx;
                    int i3 = mMSightCameraGLSurfaceView2.fcf;
                    Object obj = null;
                    try {
                        if (!(aVar.gLx == i2 && aVar.gLw == i && aVar.rotate == i3 && aVar.gLD == previewHeight)) {
                            obj = 1;
                        }
                        if (obj != null) {
                            ab.d("MicroMsg.MMSightCameraGLRenderer", "setDrawFrame, frameData: %s, frameWidth: %s, frameHeight: %s, rotate: %s, isLandScape, frameSizeChange: %s, this %s", bArr2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(aVar.fdb), Boolean.TRUE, aVar);
                        }
                        aVar.frameData = bArr2;
                        aVar.gLw = i;
                        aVar.gLx = i2;
                        aVar.rotate = i3;
                        aVar.gLD = previewHeight;
                        if (obj != null) {
                            aVar.eZU = ByteBuffer.allocateDirect(i2 * i);
                            aVar.eZV = ByteBuffer.allocateDirect((i * i2) / 2);
                            aVar.eZU.order(ByteOrder.nativeOrder());
                            aVar.eZV.order(ByteOrder.nativeOrder());
                            if (aVar.gLB != null) {
                                aVar.eZi.put(aVar.gLB);
                                aVar.eZi.position(0);
                            }
                        }
                        if (!(aVar.eZU == null || aVar.eZV == null)) {
                            aVar.eZU.put(bArr2, 0, i * i2);
                            aVar.eZU.position(0);
                            aVar.eZV.put(bArr2, i * i2, (i * i2) / 2);
                            aVar.eZV.position(0);
                        }
                    } catch (Exception e) {
                        ab.e("MicroMsg.MMSightCameraGLRenderer", "setDrawFrame error: %s", e.getMessage());
                    }
                    mMSightCameraGLSurfaceView2.requestRender();
                }
            }
        }
        if (this.gLU != null) {
            Point previewSize = getPreviewSize();
            this.gLU.q(bArr, previewSize.x, previewSize.y);
        }
        boolean z = true;
        Object obj2 = null;
        if (!(this.gLK == null || this.gLK.getFrameDataCallback() == null)) {
            if (this.gLV && this.gMf) {
                z = this.gLK.getFrameDataCallback().O(bArr2);
                obj2 = 1;
            } else {
                z = this.gLK.getFrameDataCallback().O(bArr);
            }
        }
        if (obj2 != null && (this.gLK == null || this.gLK.WL() != d.c.Start)) {
            com.tencent.mm.plugin.mmsight.model.a.j.owk.g(bArr2);
        }
        AppMethodBeat.o(76376);
        return z;
    }

    public final void asv() {
        AppMethodBeat.i(76377);
        ab.i("MicroMsg.MMSightRecordViewImpl", "onError: %s", Integer.valueOf(1));
        this.gLK.reset();
        AppMethodBeat.o(76377);
    }

    public final void asw() {
        AppMethodBeat.i(76378);
        if (this.gLL != null && this.gLL.bPu() && this.gMb) {
            this.gLL.bPp();
        }
        AppMethodBeat.o(76378);
    }

    public final void asx() {
        AppMethodBeat.i(76379);
        if (this.gLL != null && this.gLL.bPu() && this.gMa) {
            this.gLL.d(true, false, 1);
        }
        AppMethodBeat.o(76379);
    }

    public final void asy() {
        AppMethodBeat.i(76380);
        if (this.gLL != null && this.gLL.bPu() && this.gMa) {
            this.gLL.d(false, false, 1);
        }
        AppMethodBeat.o(76380);
    }

    private int asz() {
        AppMethodBeat.i(76381);
        if (this.gMh == null) {
            this.gMh = (WindowManager) ah.getContext().getSystemService("window");
        }
        if (this.gMh == null) {
            AppMethodBeat.o(76381);
            return 0;
        }
        switch (this.gMh.getDefaultDisplay().getRotation()) {
            case 0:
                AppMethodBeat.o(76381);
                return 0;
            case 1:
                AppMethodBeat.o(76381);
                return 90;
            case 2:
                AppMethodBeat.o(76381);
                return 180;
            case 3:
                AppMethodBeat.o(76381);
                return 270;
            default:
                AppMethodBeat.o(76381);
                return 0;
        }
    }

    public final void a(final ByteBuffer byteBuffer, final com.tencent.mm.plugin.mmsight.api.MMSightRecordView.f fVar) {
        AppMethodBeat.i(76382);
        if (fVar == null && byteBuffer == null) {
            if (this.gMi != null) {
                this.gMi.release();
                this.gMi = null;
            }
            AppMethodBeat.o(76382);
            return;
        }
        if (this.gMi == null) {
            this.gMi = new h();
            Point previewSize = getPreviewSize();
            this.gMi.h(previewSize.x, previewSize.y, this.gLL.getOrientation(), this.gMj.x, this.gMj.y);
            this.gMi.gMw = new i.a() {
                public final void asB() {
                    AppMethodBeat.i(138316);
                    if (fVar != null) {
                        fVar.aDr();
                    }
                    AppMethodBeat.o(138316);
                }

                public final ByteBuffer getBuffer() {
                    return byteBuffer;
                }
            };
            this.gMi.a(this.gLS.fag);
        }
        AppMethodBeat.o(76382);
    }

    /* Access modifiers changed, original: final */
    public final void asA() {
        AppMethodBeat.i(76383);
        Point previewSize = getPreviewSize();
        this.gMj.y = this.gLN;
        this.gMj.x = (previewSize.x * this.gLN) / previewSize.y;
        if (getCameraRotation() == 0 || getCameraRotation() == 180) {
            int i = this.gMj.y;
            this.gMj.y = this.gMj.x;
            this.gMj.x = i;
        }
        if (this.gMi != null) {
            Point previewSize2 = getPreviewSize();
            this.gMi.h(previewSize2.x, previewSize2.y, this.gLL.getOrientation(), this.gMj.x, this.gMj.y);
        }
        AppMethodBeat.o(76383);
    }
}
