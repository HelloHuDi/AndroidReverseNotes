package com.tencent.p177mm.plugin.api.recordView;

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
import com.tencent.p177mm.graphics.MMBitmapFactory;
import com.tencent.p177mm.modelcontrol.VideoTransPara;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.api.recordView.C10045i.C10046a;
import com.tencent.p177mm.plugin.api.recordView.C33059g.C33060a;
import com.tencent.p177mm.plugin.api.recordView.C33064h.C330622;
import com.tencent.p177mm.plugin.mmsight.C3475d;
import com.tencent.p177mm.plugin.mmsight.api.MMSightRecordView.C12536a;
import com.tencent.p177mm.plugin.mmsight.api.MMSightRecordView.C21285c;
import com.tencent.p177mm.plugin.mmsight.api.MMSightRecordView.C21286d;
import com.tencent.p177mm.plugin.mmsight.api.MMSightRecordView.C21287f;
import com.tencent.p177mm.plugin.mmsight.api.MMSightRecordView.C21288e;
import com.tencent.p177mm.plugin.mmsight.api.MMSightRecordView.C21289g;
import com.tencent.p177mm.plugin.mmsight.api.MMSightRecordView.C3474h;
import com.tencent.p177mm.plugin.mmsight.model.C12563j;
import com.tencent.p177mm.plugin.mmsight.model.C39385e;
import com.tencent.p177mm.plugin.mmsight.model.C39385e.C34548b;
import com.tencent.p177mm.plugin.mmsight.model.C39387f;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43304d;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43304d.C12543a;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43304d.C34543c;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43305j;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43306k;
import com.tencent.p177mm.plugin.sight.base.SightVideoJNI;
import com.tencent.p177mm.plugin.video.C35339b;
import com.tencent.p177mm.plugin.video.ObservableTextureView;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.ugc.TXRecordCommon;
import com.tencent.wxmm.v2helper;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.tencent.mm.plugin.api.recordView.f */
public final class C46888f extends C21288e implements C33060a, C12543a, C39387f {
    private int audioSampleRate;
    private Context context;
    private int fps;
    private int fzS;
    private C43304d gLK;
    C39385e gLL;
    int gLM;
    private int gLN;
    float gLO;
    private int gLP;
    private boolean gLQ = true;
    private ObservableTextureView gLR;
    MMSightCameraGLSurfaceView gLS;
    boolean gLT = false;
    private C12536a gLU;
    boolean gLV = false;
    boolean gLW = false;
    int gLX = -1;
    Point gLY;
    private Point gLZ;
    private boolean gMa = true;
    private boolean gMb = true;
    private C33059g gMc;
    C21286d gMd;
    C21285c gMe;
    private boolean gMf = false;
    private float gMg = 1.0f;
    private WindowManager gMh = null;
    C33064h gMi = null;
    private Point gMj = new Point(0, 0);
    private byte[] gMk = null;
    private int videoBitrate;
    private String videoPath;

    /* renamed from: com.tencent.mm.plugin.api.recordView.f$2 */
    class C100442 implements Runnable {
        C100442() {
        }

        public final void run() {
            AppMethodBeat.m2504i(138312);
            if (C46888f.this.gMe != null) {
                C46888f.this.gMe.aDp();
            }
            AppMethodBeat.m2505o(138312);
        }
    }

    /* renamed from: com.tencent.mm.plugin.api.recordView.f$1 */
    class C267161 implements C35339b {
        C267161() {
        }

        /* renamed from: e */
        public final void mo30809e(SurfaceTexture surfaceTexture) {
            AppMethodBeat.m2504i(76338);
            if (C46888f.this.gLL.mo62277a(surfaceTexture, C46888f.this.gLM, C46888f.this.gLO, C46888f.this.gLV) < 0) {
                C4990ab.m7412e("MicroMsg.MMSightRecordViewImpl", "start preview failed!");
                if (C46888f.this.gMd != null) {
                    C46888f.this.gMd.aDo();
                }
            }
            if (C46888f.this.gLX != -1) {
                C46888f.this.ass();
            }
            C46888f.this.gLL.bPn();
            C46888f.this.asp();
            C46888f.this.asA();
            if (C46888f.this.gMi != null) {
                C46888f.this.gMi.mo53630a(C46888f.this.gLS.fag);
            }
            C4990ab.m7416i("MicroMsg.MMSightRecordViewImpl", "do start preview after texture available");
            AppMethodBeat.m2505o(76338);
        }
    }

    public C46888f() {
        AppMethodBeat.m2504i(76344);
        AppMethodBeat.m2505o(76344);
    }

    /* renamed from: b */
    public final void mo36681b(Context context, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(76345);
        this.context = context;
        this.gLR = new ObservableTextureView(context);
        this.gLS = new MMSightCameraGLSurfaceView(context);
        int fromDPToPix = C1338a.fromDPToPix(context, 1);
        viewGroup.addView(this.gLR, new LayoutParams(fromDPToPix, fromDPToPix));
        viewGroup.addView(this.gLS, new MarginLayoutParams(-1, -1));
        this.gMc = new C33059g();
        this.gMc.gMu = this;
        this.gLS.setOnTouchListener(this.gMc);
        C12563j.bPw();
        C4990ab.m7417i("MicroMsg.MMSightRecordViewImpl", "init view, context: %s", context);
        AppMethodBeat.m2505o(76345);
    }

    public final void setInitErrorCallback(C21286d c21286d) {
        this.gMd = c21286d;
    }

    public final void setInitDoneCallback(C21285c c21285c) {
        this.gMe = c21285c;
    }

    public final void setDisplayRatio(float f) {
        AppMethodBeat.m2504i(76346);
        int asz = asz();
        C4990ab.m7417i("MicroMsg.MMSightRecordViewImpl", "setDisplayRatio: %s, screenRotation: %s", Float.valueOf(f), Integer.valueOf(asz));
        this.gLO = f;
        if (asz == 90 || asz == 270) {
            this.gLO = 1.0f / this.gLO;
        }
        AppMethodBeat.m2505o(76346);
    }

    public final void setPreviewSizeLimit(int i) {
        AppMethodBeat.m2504i(76347);
        C4990ab.m7417i("MicroMsg.MMSightRecordViewImpl", "setPreviewSizeLimit: %s", Integer.valueOf(i));
        this.gLM = i;
        AppMethodBeat.m2505o(76347);
    }

    public final void setRGBSizeLimit(int i) {
        AppMethodBeat.m2504i(76348);
        C4990ab.m7417i("MicroMsg.MMSightRecordViewImpl", "setRGBSizeLimit: %s", Integer.valueOf(i));
        this.gLN = i;
        AppMethodBeat.m2505o(76348);
    }

    public final void startPreview() {
        AppMethodBeat.m2504i(76349);
        C4990ab.m7417i("MicroMsg.MMSightRecordViewImpl", "startPreview, displayRatio: %s, previewSizeLimit: %s", Float.valueOf(this.gLO), Integer.valueOf(this.gLM));
        if (this.gLO > 0.0f && this.gLM > 0) {
            VideoTransPara videoTransPara = new VideoTransPara();
            videoTransPara.width = this.gLM;
            videoTransPara.height = (int) (((float) this.gLM) / this.gLO);
            C4990ab.m7417i("MicroMsg.MMSightRecordViewImpl", "para width: %s, height: %s", Integer.valueOf(videoTransPara.width), Integer.valueOf(videoTransPara.height));
            this.gLL = new C39385e(videoTransPara, -1);
            this.gLL.mo62281a((C39387f) this);
            if (this.gLL.mo62304v(this.context, this.gLQ)) {
                C4990ab.m7416i("MicroMsg.MMSightRecordViewImpl", "open camera finish");
                if (this.gLR.isAvailable()) {
                    if (this.gLL.mo62277a(this.gLR.getSurfaceTexture(), this.gLM, this.gLO, this.gLV) < 0) {
                        C4990ab.m7412e("MicroMsg.MMSightRecordViewImpl", "start preview failed!");
                        if (this.gMd != null) {
                            this.gMd.aDo();
                        }
                    }
                    if (this.gLX != -1) {
                        ass();
                    }
                    this.gLL.bPn();
                    C4990ab.m7416i("MicroMsg.MMSightRecordViewImpl", "do start preview directly");
                    asp();
                    asA();
                    if (this.gMi != null) {
                        this.gMi.mo53630a(this.gLS.fag);
                    }
                    AppMethodBeat.m2505o(76349);
                    return;
                }
                this.gLR.setTextureChangeCallback(new C267161());
            } else {
                C4990ab.m7416i("MicroMsg.MMSightRecordViewImpl", "open camera failed!");
                if (this.gMd != null) {
                    this.gMd.aDo();
                }
                AppMethodBeat.m2505o(76349);
                return;
            }
        }
        AppMethodBeat.m2505o(76349);
    }

    public final void setVideoPara$2e715812(int i) {
        AppMethodBeat.m2504i(76350);
        this.gLP = i;
        this.videoBitrate = 4800000;
        this.fps = 30;
        this.fzS = 64000;
        this.audioSampleRate = TXRecordCommon.AUDIO_SAMPLERATE_44100;
        C4990ab.m7417i("MicroMsg.MMSightRecordViewImpl", "setVideoPara, maxDuration: %s, videoBitrate: %s, fps: %s, audioBitrate: %s, audioSampleRate: %s", Integer.valueOf(i), Integer.valueOf(4800000), Integer.valueOf(30), Integer.valueOf(64000), Integer.valueOf(TXRecordCommon.AUDIO_SAMPLERATE_44100));
        AppMethodBeat.m2505o(76350);
    }

    public final void setVideoFilePath(String str) {
        AppMethodBeat.m2504i(76351);
        C4990ab.m7417i("MicroMsg.MMSightRecordViewImpl", "setVideoFilePath: %s", str);
        this.videoPath = str;
        AppMethodBeat.m2505o(76351);
    }

    public final String getVideoFilePath() {
        AppMethodBeat.m2504i(76352);
        String str;
        if (this.gLK == null || !this.gLT) {
            str = this.videoPath;
            AppMethodBeat.m2505o(76352);
            return str;
        }
        str = this.gLK.getFilePath();
        AppMethodBeat.m2505o(76352);
        return str;
    }

    public final void aso() {
        AppMethodBeat.m2504i(76353);
        asp();
        AppMethodBeat.m2505o(76353);
    }

    /* Access modifiers changed, original: final */
    public final void asp() {
        AppMethodBeat.m2504i(76354);
        if (this.gLT) {
            C4990ab.m7416i("MicroMsg.MMSightRecordViewImpl", "initRecorder, already init");
            AppMethodBeat.m2505o(76354);
            return;
        }
        if (this.gLK != null) {
            C4990ab.m7416i("MicroMsg.MMSightRecordViewImpl", "startRecord, recorder not null, stop first");
            this.gLK.cancel();
            if (this.gLL != null) {
                this.gLL.mo62285b(this.gLK.getFrameDataCallback());
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
            C12563j.ouz.fcY = videoTransPara;
            C12563j.ouz.videoBitrate = this.videoBitrate;
            C12563j.ouz.fay = this.gLM;
            C43306k.bPR();
            this.gLK = C43306k.m77221p(videoTransPara);
            if (this.gLK == null) {
                C4990ab.m7412e("MicroMsg.MMSightRecordViewImpl", "can not get media recorder!");
                if (this.gMd != null) {
                    this.gMd.aDo();
                }
                AppMethodBeat.m2505o(76354);
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
            i = C3475d.m5787yP((int) (((float) i) * this.gMg));
            i2 = C3475d.m5787yP(i2);
            C4990ab.m7417i("MicroMsg.MMSightRecordViewImpl", "initRecorder, videoWidth: %s, videoHeight: %s, videoSizeRatio: %s", Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(this.gMg));
            if (this.gLZ == null || !this.gLV) {
                this.gLK.mo14862s(this.gLL.getPreviewWidth(), this.gLL.getPreviewHeight(), i, i2);
            } else {
                this.gLK.mo14862s(this.gLZ.y, this.gLZ.x, i, i2);
            }
            this.gLK.mo14844WR();
            this.gLK.mo14846a(this);
            if (this.gLK.mo14856ko(this.gLL.getOrientation())) {
                C5004al.m7442n(new C100442(), 100);
                this.gLT = true;
            } else {
                C4990ab.m7412e("MicroMsg.MMSightRecordViewImpl", "init recorder error");
                if (this.gMd != null) {
                    this.gMd.aDo();
                }
                AppMethodBeat.m2505o(76354);
                return;
            }
        }
        AppMethodBeat.m2505o(76354);
    }

    /* renamed from: EL */
    public final boolean mo36674EL() {
        AppMethodBeat.m2504i(76355);
        C4990ab.m7417i("MicroMsg.MMSightRecordViewImpl", "startRecord, recorder: %s", this.gLK);
        asp();
        if (this.gLK == null) {
            C4990ab.m7412e("MicroMsg.MMSightRecordViewImpl", "startRecord error, recorder is null!");
            AppMethodBeat.m2505o(76355);
            return false;
        }
        int asz = asz();
        C4990ab.m7417i("MicroMsg.MMSightRecordViewImpl", "screen rotate: %s", Integer.valueOf(asz));
        if (asz == 90 || asz == 270) {
            asz = this.gLK.mo14848b(this.gLL.getOrientation(), true, 360 - asz);
        } else {
            asz = this.gLK.mo14848b(this.gLL.getOrientation(), false, asz);
        }
        C4990ab.m7417i("MicroMsg.MMSightRecordViewImpl", "startRecord now, ret: %s", Integer.valueOf(asz));
        if (asz >= 0) {
            AppMethodBeat.m2505o(76355);
            return true;
        }
        AppMethodBeat.m2505o(76355);
        return false;
    }

    /* renamed from: a */
    public final void mo36676a(final C3474h c3474h) {
        AppMethodBeat.m2504i(76356);
        if (this.gLK != null) {
            C4990ab.m7417i("MicroMsg.MMSightRecordViewImpl", "stopRecord, stopCallback: %s", c3474h);
            this.gLK.mo14846a(new C12543a() {
                public final void asv() {
                    AppMethodBeat.m2504i(138313);
                    if (c3474h != null) {
                        c3474h.mo7934dX(true);
                    }
                    AppMethodBeat.m2505o(138313);
                }
            });
            this.gLK.mo14865v(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(76341);
                    C46888f.this.gLT = false;
                    if (c3474h != null) {
                        c3474h.mo7934dX(false);
                    }
                    AppMethodBeat.m2505o(76341);
                }
            });
            this.gLK = null;
        }
        AppMethodBeat.m2505o(76356);
    }

    /* renamed from: a */
    public final void mo36675a(final C21289g c21289g, final boolean z) {
        AppMethodBeat.m2504i(76357);
        if (!(c21289g == null || this.gLL == null || !this.gLL.bPu())) {
            if (z) {
                this.gLL.bPr();
            }
            if (z) {
                C5004al.m7442n(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(138314);
                        C46888f.this.mo76088b(c21289g, z);
                        AppMethodBeat.m2505o(138314);
                    }
                }, 100);
                AppMethodBeat.m2505o(76357);
                return;
            }
            mo76088b(c21289g, z);
        }
        AppMethodBeat.m2505o(76357);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final void mo76088b(final C21289g c21289g, final boolean z) {
        AppMethodBeat.m2504i(76358);
        this.gLL.mo62280a(new C34548b() {
            /* JADX WARNING: Removed duplicated region for block: B:22:0x00a5 A:{Catch:{ Exception -> 0x010a }} */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            /* renamed from: a */
            public final void mo30824a(byte[] bArr, int i, int i2, int i3, int i4) {
                AppMethodBeat.m2504i(138315);
                if (z) {
                    C46888f.this.gLL.bPs();
                }
                if (bArr == null || i < 0 || i2 < 0 || i3 < 0) {
                    C4990ab.m7412e("MicroMsg.MMSightRecordViewImpl", "onPictureYuvTaken, data is null!!");
                    c21289g.aDq();
                    AppMethodBeat.m2505o(138315);
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
                    if (C46888f.this.gLW) {
                        C46888f.this.asr();
                        if (C46888f.this.gLL.oud) {
                            if (C46888f.this.gLY.y < i) {
                                bArr2 = new byte[(((C46888f.this.gLY.x * C46888f.this.gLY.y) * 3) >> 1)];
                                SightVideoJNI.cropCameraDataLongEdge(bArr, bArr2, i, C46888f.this.gLY.y, i2);
                                i = C46888f.this.gLY.y;
                                i5 = C46888f.this.gLY.x;
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
                                    copy = C5056d.m7648b(decodeByteArray, (float) i3);
                                }
                                C4990ab.m7417i("MicroMsg.MMSightRecordViewImpl", "bitmap recycle %s", decodeByteArray.toString());
                                decodeByteArray.recycle();
                                c21289g.mo21838F(copy);
                                AppMethodBeat.m2505o(138315);
                            }
                        } else if (C46888f.this.gLY.x < i2) {
                            bArr2 = new byte[(((C46888f.this.gLY.x * C46888f.this.gLY.y) * 3) >> 1)];
                            SightVideoJNI.cropCameraData(bArr, bArr2, i, i2, C46888f.this.gLY.x);
                            i = C46888f.this.gLY.y;
                            i5 = C46888f.this.gLY.x;
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
                            C4990ab.m7417i("MicroMsg.MMSightRecordViewImpl", "bitmap recycle %s", decodeByteArray.toString());
                            decodeByteArray.recycle();
                            c21289g.mo21838F(copy);
                            AppMethodBeat.m2505o(138315);
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
                    C4990ab.m7417i("MicroMsg.MMSightRecordViewImpl", "bitmap recycle %s", decodeByteArray.toString());
                    decodeByteArray.recycle();
                    c21289g.mo21838F(copy);
                    AppMethodBeat.m2505o(138315);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.MMSightRecordViewImpl", e, "saveCaptureYuvDataToBitmap error: %s", e.getMessage());
                    c21289g.aDq();
                    AppMethodBeat.m2505o(138315);
                }
            }
        }, false, asz());
        AppMethodBeat.m2505o(76358);
    }

    public final void setUseBackCamera(boolean z) {
        AppMethodBeat.m2504i(76359);
        C4990ab.m7417i("MicroMsg.MMSightRecordViewImpl", "setUseBackCamera: %s", Boolean.valueOf(z));
        this.gLQ = z;
        AppMethodBeat.m2505o(76359);
    }

    public final Point getPictureSize() {
        AppMethodBeat.m2504i(76360);
        Point point;
        if (this.gLL == null || !this.gLL.bPu()) {
            AppMethodBeat.m2505o(76360);
            return null;
        } else if (this.gLW) {
            asr();
            point = this.gLY;
            AppMethodBeat.m2505o(76360);
            return point;
        } else {
            point = new Point(this.gLL.getPreviewWidth(), this.gLL.getPreviewHeight());
            AppMethodBeat.m2505o(76360);
            return point;
        }
    }

    public final Point getVideoSize() {
        AppMethodBeat.m2504i(76361);
        if (this.gLL == null || !this.gLL.bPu()) {
            AppMethodBeat.m2505o(76361);
            return null;
        }
        int i = this.gLL.getEncodeVideoBestSize().x;
        int i2 = this.gLL.getEncodeVideoBestSize().y;
        if (this.gLZ != null && this.gLV) {
            i = this.gLZ.x;
            i2 = this.gLZ.y;
        }
        Point point = new Point(C3475d.m5787yP((int) (((float) i) * this.gMg)), C3475d.m5787yP((int) (((float) i2) * this.gMg)));
        AppMethodBeat.m2505o(76361);
        return point;
    }

    public final Point getPreviewSize() {
        AppMethodBeat.m2504i(76362);
        int i = (this.gLL.getOrientation() == 0 || this.gLL.getOrientation() == 180) ? 1 : 0;
        C4990ab.m7417i("MicroMsg.MMSightRecordViewImpl", "getPreviewSize : %d %d", Integer.valueOf(i != 0 ? this.gLL.getPreviewWidth() : this.gLL.getPreviewHeight()), Integer.valueOf(i != 0 ? this.gLL.getPreviewHeight() : this.gLL.getPreviewWidth()));
        Point point = new Point(r1, r0);
        AppMethodBeat.m2505o(76362);
        return point;
    }

    public final Point getDrawSizePoint() {
        AppMethodBeat.m2504i(76363);
        C4990ab.m7417i("MicroMsg.MMSightRecordViewImpl", "getDrawSizePoint : %s", this.gMj.toString());
        Point point = this.gMj;
        AppMethodBeat.m2505o(76363);
        return point;
    }

    public final void setFrameDataCallback(C12536a c12536a) {
        this.gLU = c12536a;
    }

    public final int getCameraRotation() {
        AppMethodBeat.m2504i(76364);
        if (this.gLL != null) {
            int orientation = this.gLL.getOrientation();
            AppMethodBeat.m2505o(76364);
            return orientation;
        }
        AppMethodBeat.m2505o(76364);
        return 0;
    }

    public final void switchCamera() {
        AppMethodBeat.m2504i(76365);
        if (this.gLL != null && this.gLL.bPu() && (this.gLK == null || this.gLK.mo14838WL() != C34543c.Start)) {
            this.gLL.mo62282a(this.context, this.gLR.getSurfaceTexture(), this.gLM, this.gLO, this.gLV);
            if (this.gMi != null) {
                Point previewSize = getPreviewSize();
                this.gMi.mo53631h(previewSize.x, previewSize.y, this.gLL.getOrientation(), this.gMj.x, this.gMj.y);
            }
        }
        AppMethodBeat.m2505o(76365);
    }

    public final void setClipVideoSize(boolean z) {
        AppMethodBeat.m2504i(76366);
        this.gLV = z;
        if (this.gLV && this.gLL != null && this.gLL.bPu()) {
            asq();
        }
        AppMethodBeat.m2505o(76366);
    }

    private void asq() {
        AppMethodBeat.m2504i(76367);
        if (this.gLL != null && this.gLL.bPu()) {
            if (this.gLL.oud) {
                this.gLZ = new Point(C3475d.m5781ev((int) (((float) this.gLL.getPreviewWidth()) / this.gLO), this.gLL.getPreviewHeight()), this.gLL.getPreviewWidth());
            } else {
                this.gLZ = new Point(this.gLL.getPreviewHeight(), C3475d.m5781ev((int) (((float) this.gLL.getPreviewHeight()) * this.gLO), this.gLL.getPreviewWidth()));
            }
            C4990ab.m7417i("MicroMsg.MMSightRecordViewImpl", "initVideoSize: %s", this.gLZ);
        }
        AppMethodBeat.m2505o(76367);
    }

    public final void setClipPictureSize(boolean z) {
        AppMethodBeat.m2504i(76368);
        this.gLW = z;
        if (this.gLW && this.gLL != null && this.gLL.bPu()) {
            asr();
        }
        AppMethodBeat.m2505o(76368);
    }

    /* Access modifiers changed, original: final */
    public final void asr() {
        AppMethodBeat.m2504i(76369);
        if (this.gLL != null && this.gLL.bPu()) {
            if (this.gLL.oud) {
                this.gLY = new Point(this.gLL.getPreviewWidth(), (int) (((float) this.gLL.getPreviewWidth()) / this.gLO));
                AppMethodBeat.m2505o(76369);
                return;
            }
            this.gLY = new Point((int) (((float) this.gLL.getPreviewHeight()) * this.gLO), this.gLL.getPreviewHeight());
        }
        AppMethodBeat.m2505o(76369);
    }

    public final void setFlashMode(int i) {
        boolean z = true;
        AppMethodBeat.m2504i(76370);
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
        C4990ab.m7417i(str, str2, objArr);
        if (this.gLL != null && this.gLL.bPu()) {
            ass();
        }
        AppMethodBeat.m2505o(76370);
    }

    /* Access modifiers changed, original: final */
    public final void ass() {
        AppMethodBeat.m2504i(76371);
        C4990ab.m7417i("MicroMsg.MMSightRecordViewImpl", "setFlashModeImpl, mode: %s", Integer.valueOf(this.gLX));
        switch (this.gLX) {
            case 1:
                this.gLL.bPr();
                AppMethodBeat.m2505o(76371);
                return;
            case 2:
                this.gLL.bPs();
                AppMethodBeat.m2505o(76371);
                return;
            case 3:
                this.gLL.bPt();
                break;
        }
        AppMethodBeat.m2505o(76371);
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
        AppMethodBeat.m2504i(76372);
        C4990ab.m7416i("MicroMsg.MMSightRecordViewImpl", "setHalfPreviewVideoSize");
        this.gMg = 0.5f;
        AppMethodBeat.m2505o(76372);
    }

    public final void asu() {
        AppMethodBeat.m2504i(76373);
        C4990ab.m7416i("MicroMsg.MMSightRecordViewImpl", "set34PreviewVideoSize");
        this.gMg = 0.75f;
        AppMethodBeat.m2505o(76373);
    }

    public final Bitmap getCurrentFramePicture() {
        AppMethodBeat.m2504i(76374);
        if (this.gLL != null && this.gLL.bPu()) {
            byte[] bArr;
            C39385e c39385e = this.gLL;
            if (c39385e.fbl != null) {
                c39385e.fbk = true;
                bArr = new byte[c39385e.fbl.length];
                System.arraycopy(c39385e.fbl, 0, bArr, 0, c39385e.fbl.length);
                c39385e.fbk = false;
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
                            g = C43305j.owk.mo68846g(Integer.valueOf(((this.gLZ.x * this.gLZ.y) * 3) >> 1));
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
                            g = C43305j.owk.mo68846g(Integer.valueOf(((this.gLZ.x * this.gLZ.y) * 3) >> 1));
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
                Bitmap b = C5056d.m7648b(decodeByteArray, (float) this.gLL.getOrientation());
                C4990ab.m7417i("MicroMsg.MMSightRecordViewImpl", "bitmap recycle %s", decodeByteArray);
                decodeByteArray.recycle();
                AppMethodBeat.m2505o(76374);
                return b;
            }
        }
        AppMethodBeat.m2505o(76374);
        return null;
    }

    public final void release() {
        AppMethodBeat.m2504i(76375);
        C4990ab.m7417i("MicroMsg.MMSightRecordViewImpl", "release, camera: %s, recorder: %s", this.gLL, this.gLK);
        if (this.gLL != null) {
            this.gLL.bPq();
        }
        if (this.gLK != null) {
            this.gLK.mo14846a(null);
            this.gLK.mo14865v(null);
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
        C43305j.owk.mo45830WY();
        AppMethodBeat.m2505o(76375);
    }

    /* renamed from: O */
    public final boolean mo14870O(byte[] bArr) {
        AppMethodBeat.m2504i(76376);
        if (bArr == null) {
            AppMethodBeat.m2505o(76376);
            return false;
        }
        int asz;
        byte[] bArr2;
        if (this.gMi != null) {
            asz = asz();
            C33064h c33064h = this.gMi;
            if (c33064h.eCM || c33064h.gMv != null) {
                c33064h.queue(new C330622(bArr, asz));
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
                        bArr2 = C43305j.owk.mo68846g(Integer.valueOf(((this.gLZ.x * this.gLZ.y) * 3) >> 1));
                    } else {
                        this.gMk = new byte[(((previewWidth * previewWidth2) * 3) >> 1)];
                        bArr2 = this.gMk;
                    }
                    C5046bo.m7588yz();
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
                        bArr2 = C43305j.owk.mo68846g(Integer.valueOf(((this.gLZ.x * this.gLZ.y) * 3) >> 1));
                    } else {
                        this.gMk = new byte[(((asz * previewHeight) * 3) >> 1)];
                        bArr2 = this.gMk;
                    }
                    C5046bo.m7588yz();
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
                    C4990ab.m7417i("MicroMsg.MMSightCameraGLSurfaceView", "setFrameInfo, width: %s, height: %s, rotate: %s this: %s", Integer.valueOf(previewHeight), Integer.valueOf(previewWidth), Integer.valueOf(orientation), mMSightCameraGLSurfaceView);
                    mMSightCameraGLSurfaceView.gLw = previewHeight;
                    mMSightCameraGLSurfaceView.gLx = previewWidth;
                    mMSightCameraGLSurfaceView.fcf = orientation;
                }
                previewHeight = asz();
                MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView2 = this.gLS;
                if (bArr2 == null || mMSightCameraGLSurfaceView2.gLE == null || mMSightCameraGLSurfaceView2.gLE.gLv) {
                    C4990ab.m7418v("MicroMsg.MMSightCameraGLSurfaceView", "passing draw");
                } else {
                    C10042a c10042a = mMSightCameraGLSurfaceView2.gLE;
                    int i = mMSightCameraGLSurfaceView2.gLw;
                    int i2 = mMSightCameraGLSurfaceView2.gLx;
                    int i3 = mMSightCameraGLSurfaceView2.fcf;
                    Object obj = null;
                    try {
                        if (!(c10042a.gLx == i2 && c10042a.gLw == i && c10042a.rotate == i3 && c10042a.gLD == previewHeight)) {
                            obj = 1;
                        }
                        if (obj != null) {
                            C4990ab.m7411d("MicroMsg.MMSightCameraGLRenderer", "setDrawFrame, frameData: %s, frameWidth: %s, frameHeight: %s, rotate: %s, isLandScape, frameSizeChange: %s, this %s", bArr2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(c10042a.fdb), Boolean.TRUE, c10042a);
                        }
                        c10042a.frameData = bArr2;
                        c10042a.gLw = i;
                        c10042a.gLx = i2;
                        c10042a.rotate = i3;
                        c10042a.gLD = previewHeight;
                        if (obj != null) {
                            c10042a.eZU = ByteBuffer.allocateDirect(i2 * i);
                            c10042a.eZV = ByteBuffer.allocateDirect((i * i2) / 2);
                            c10042a.eZU.order(ByteOrder.nativeOrder());
                            c10042a.eZV.order(ByteOrder.nativeOrder());
                            if (c10042a.gLB != null) {
                                c10042a.eZi.put(c10042a.gLB);
                                c10042a.eZi.position(0);
                            }
                        }
                        if (!(c10042a.eZU == null || c10042a.eZV == null)) {
                            c10042a.eZU.put(bArr2, 0, i * i2);
                            c10042a.eZU.position(0);
                            c10042a.eZV.put(bArr2, i * i2, (i * i2) / 2);
                            c10042a.eZV.position(0);
                        }
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.MMSightCameraGLRenderer", "setDrawFrame error: %s", e.getMessage());
                    }
                    mMSightCameraGLSurfaceView2.requestRender();
                }
            }
        }
        if (this.gLU != null) {
            Point previewSize = getPreviewSize();
            this.gLU.mo24462q(bArr, previewSize.x, previewSize.y);
        }
        boolean z = true;
        Object obj2 = null;
        if (!(this.gLK == null || this.gLK.getFrameDataCallback() == null)) {
            if (this.gLV && this.gMf) {
                z = this.gLK.getFrameDataCallback().mo14870O(bArr2);
                obj2 = 1;
            } else {
                z = this.gLK.getFrameDataCallback().mo14870O(bArr);
            }
        }
        if (obj2 != null && (this.gLK == null || this.gLK.mo14838WL() != C34543c.Start)) {
            C43305j.owk.mo68845g(bArr2);
        }
        AppMethodBeat.m2505o(76376);
        return z;
    }

    public final void asv() {
        AppMethodBeat.m2504i(76377);
        C4990ab.m7417i("MicroMsg.MMSightRecordViewImpl", "onError: %s", Integer.valueOf(1));
        this.gLK.reset();
        AppMethodBeat.m2505o(76377);
    }

    public final void asw() {
        AppMethodBeat.m2504i(76378);
        if (this.gLL != null && this.gLL.bPu() && this.gMb) {
            this.gLL.bPp();
        }
        AppMethodBeat.m2505o(76378);
    }

    public final void asx() {
        AppMethodBeat.m2504i(76379);
        if (this.gLL != null && this.gLL.bPu() && this.gMa) {
            this.gLL.mo62296d(true, false, 1);
        }
        AppMethodBeat.m2505o(76379);
    }

    public final void asy() {
        AppMethodBeat.m2504i(76380);
        if (this.gLL != null && this.gLL.bPu() && this.gMa) {
            this.gLL.mo62296d(false, false, 1);
        }
        AppMethodBeat.m2505o(76380);
    }

    private int asz() {
        AppMethodBeat.m2504i(76381);
        if (this.gMh == null) {
            this.gMh = (WindowManager) C4996ah.getContext().getSystemService("window");
        }
        if (this.gMh == null) {
            AppMethodBeat.m2505o(76381);
            return 0;
        }
        switch (this.gMh.getDefaultDisplay().getRotation()) {
            case 0:
                AppMethodBeat.m2505o(76381);
                return 0;
            case 1:
                AppMethodBeat.m2505o(76381);
                return 90;
            case 2:
                AppMethodBeat.m2505o(76381);
                return 180;
            case 3:
                AppMethodBeat.m2505o(76381);
                return 270;
            default:
                AppMethodBeat.m2505o(76381);
                return 0;
        }
    }

    /* renamed from: a */
    public final void mo36677a(final ByteBuffer byteBuffer, final C21287f c21287f) {
        AppMethodBeat.m2504i(76382);
        if (c21287f == null && byteBuffer == null) {
            if (this.gMi != null) {
                this.gMi.release();
                this.gMi = null;
            }
            AppMethodBeat.m2505o(76382);
            return;
        }
        if (this.gMi == null) {
            this.gMi = new C33064h();
            Point previewSize = getPreviewSize();
            this.gMi.mo53631h(previewSize.x, previewSize.y, this.gLL.getOrientation(), this.gMj.x, this.gMj.y);
            this.gMi.gMw = new C10046a() {
                public final void asB() {
                    AppMethodBeat.m2504i(138316);
                    if (c21287f != null) {
                        c21287f.aDr();
                    }
                    AppMethodBeat.m2505o(138316);
                }

                public final ByteBuffer getBuffer() {
                    return byteBuffer;
                }
            };
            this.gMi.mo53630a(this.gLS.fag);
        }
        AppMethodBeat.m2505o(76382);
    }

    /* Access modifiers changed, original: final */
    public final void asA() {
        AppMethodBeat.m2504i(76383);
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
            this.gMi.mo53631h(previewSize2.x, previewSize2.y, this.gLL.getOrientation(), this.gMj.x, this.gMj.y);
        }
        AppMethodBeat.m2505o(76383);
    }
}
