package com.tencent.mm.plugin.mmsight.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.YuvImage;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.g.a.in;
import com.tencent.mm.g.a.mj;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.d;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.model.c;
import com.tencent.mm.plugin.mmsight.model.e;
import com.tencent.mm.plugin.mmsight.model.i;
import com.tencent.mm.plugin.mmsight.model.j;
import com.tencent.mm.plugin.mmsight.ui.cameraglview.MMSightCameraGLSurfaceView;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.plugin.webview.ui.tools.widget.o;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.protocal.protobuf.baa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMNewPhotoEditUI;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.base.a;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.wxmm.v2helper;
import java.io.ByteArrayOutputStream;
import org.json.JSONObject;

@a(3)
public class SightCaptureUI extends MMActivity implements d.a, c.a {
    private String cMW = "";
    private com.tencent.mm.remoteservice.d ext = new com.tencent.mm.remoteservice.d(ah.getContext());
    private VideoTransPara fcY;
    private ObservableTextureView gLR;
    private d gLs;
    private b gar;
    private int hGH = -1;
    private boolean hGI = false;
    private long hGJ = -1;
    private MMSightCaptureTouchView lmm;
    private View nPr;
    private TextView oCA;
    private View oCB;
    private b oCC;
    private boolean oCD = true;
    private baa oCE = new baa();
    private byte[] oCF;
    private int oCG;
    private int oCH;
    private int oCI;
    private int oCJ;
    private byte[] oCK;
    private int oCL;
    private c oCM;
    private boolean oCN = false;
    private boolean oCO = false;
    private boolean oCP = false;
    private int oCQ = 0;
    private int oCR = 0;
    private Thread oCS = null;
    private long oCT = -1;
    private boolean oCU = false;
    private boolean oCV = false;
    private Boolean oCW = Boolean.FALSE;
    private Point oCX;
    private com.tencent.mm.sdk.b.c oCY = new com.tencent.mm.sdk.b.c<in>() {
        {
            AppMethodBeat.i(55198);
            this.xxI = in.class.getName().hashCode();
            AppMethodBeat.o(55198);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(55199);
            in inVar = (in) bVar;
            if (!(inVar == null || inVar.cDG == null)) {
                ab.i("MicroMsg.SightCaptureUI", "summerhardcoder system event [%s] backCamera[%s]", Integer.valueOf(inVar.cDG.keycode), Boolean.valueOf(SightCaptureUI.this.oCD));
                if (inVar.cDG.keycode == 1 && SightCaptureUI.this.oCD) {
                    SightCaptureUI.d(SightCaptureUI.this);
                }
            }
            AppMethodBeat.o(55199);
            return false;
        }
    };
    private Runnable oCZ = new Runnable() {
        public final void run() {
            AppMethodBeat.i(55211);
            if (SightCaptureUI.this.hGH == 7 && SightCaptureUI.this.oCn != null) {
                ab.i("MicroMsg.SightCaptureUI", "showRecoderProgressBar");
                SightCaptureUI.this.oCn.bQs();
            }
            AppMethodBeat.o(55211);
        }
    };
    private int oCj = 1;
    private boolean oCk = true;
    private e oCl;
    private ViewGroup oCm;
    private MMSightRecordButton oCn;
    private View oCo;
    private View oCp;
    private ViewGroup oCq;
    private ViewGroup oCr;
    private ImageView oCs;
    private ImageView oCt;
    private SurfaceTexture oCu;
    CameraFrontSightView oCv;
    private ViewGroup oCw;
    private ImageView oCx;
    private MMSightCameraGLSurfaceView oCy;
    private com.tencent.mm.plugin.mmsight.ui.cameraglview.a oCz;
    private String oDa;
    private String oDb;
    private boolean oDc;
    private Bundle oDd;
    private Runnable oDe = new Runnable() {
        public final void run() {
            AppMethodBeat.i(55212);
            if (SightCaptureUI.this.hGH != 4) {
                ab.e("MicroMsg.SightCaptureUI", "checkPreviewStatusRunnable, not previewing now!!!");
                SightCaptureUI.g(SightCaptureUI.this, 9);
            }
            AppMethodBeat.o(55212);
        }
    };
    private int osJ = 2;
    private SightParams owm;
    private VideoPlayerTextureView oxL;
    private VideoSeekBarEditorView oxM;
    private com.tencent.mm.pluginsdk.ui.tools.e.a oxS = new com.tencent.mm.pluginsdk.ui.tools.e.a() {
        public final void onError(int i, int i2) {
            AppMethodBeat.i(55215);
            ab.e("MicroMsg.SightCaptureUI", "%d on error what %d extra %d", Integer.valueOf(SightCaptureUI.this.hashCode()), Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.o(55215);
        }

        public final void pL() {
            AppMethodBeat.i(55216);
            if (SightCaptureUI.this.oxL != null) {
                SightCaptureUI.this.oxL.start();
                SightCaptureUI.this.oxL.setLoop(true);
            }
            al.af(SightCaptureUI.this.oDe);
            SightCaptureUI.this.oxL.setOneTimeVideoTextureUpdateCallback(new com.tencent.mm.pluginsdk.ui.tools.e.e() {
                public final void bQL() {
                    AppMethodBeat.i(55214);
                    al.n(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(55213);
                            ab.i("MicroMsg.SightCaptureUI", "onTextureUpdate");
                            if (SightCaptureUI.this.oxL == null) {
                                AppMethodBeat.o(55213);
                                return;
                            }
                            SightCaptureUI.this.oxL.setAlpha(1.0f);
                            SightCaptureUI.g(SightCaptureUI.this, 4);
                            SightCaptureUI.G(SightCaptureUI.this);
                            AppMethodBeat.o(55213);
                        }
                    }, 50);
                    SightCaptureUI.this.oCt.setVisibility(0);
                    AppMethodBeat.o(55214);
                }
            });
            AppMethodBeat.o(55216);
        }

        public final void EA() {
            AppMethodBeat.i(55217);
            SightCaptureUI.this.oxL.d(0.0d, true);
            AppMethodBeat.o(55217);
        }

        public final int dG(int i, int i2) {
            return 0;
        }

        public final void dH(int i, int i2) {
        }
    };

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SightCaptureUI() {
        AppMethodBeat.i(55228);
        AppMethodBeat.o(55228);
    }

    static /* synthetic */ void B(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.i(55269);
        sightCaptureUI.bQI();
        AppMethodBeat.o(55269);
    }

    static /* synthetic */ boolean J(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.i(55273);
        boolean jb = sightCaptureUI.jb(false);
        AppMethodBeat.o(55273);
        return jb;
    }

    static /* synthetic */ void d(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.i(55255);
        sightCaptureUI.bQA();
        AppMethodBeat.o(55255);
    }

    static /* synthetic */ void g(SightCaptureUI sightCaptureUI, int i) {
        AppMethodBeat.i(55271);
        sightCaptureUI.updateState(i);
        AppMethodBeat.o(55271);
    }

    static /* synthetic */ int m(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.i(55258);
        int bQD = sightCaptureUI.bQD();
        AppMethodBeat.o(55258);
        return bQD;
    }

    static /* synthetic */ void r(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.i(55262);
        sightCaptureUI.stopRecord();
        AppMethodBeat.o(55262);
    }

    static /* synthetic */ void s(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.i(55263);
        sightCaptureUI.bQC();
        AppMethodBeat.o(55263);
    }

    static /* synthetic */ boolean w(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.i(55267);
        boolean bQK = sightCaptureUI.bQK();
        AppMethodBeat.o(55267);
        return bQK;
    }

    static /* synthetic */ String zb(int i) {
        AppMethodBeat.i(55274);
        String za = za(i);
        AppMethodBeat.o(55274);
        return za;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(55229);
        supportRequestWindowFeature(1);
        super.onCreate(bundle);
        this.owm = (SightParams) getIntent().getParcelableExtra("KEY_SIGHT_PARAMS");
        if (this.owm == null) {
            ab.e("MicroMsg.SightCaptureUI", "error!!!! sightParams is null!!");
            AppMethodBeat.o(55229);
            return;
        }
        CaptureMMProxy.createProxy(new CaptureMMProxy(this.ext));
        final long yz = bo.yz();
        this.ext.connect(new Runnable() {
            public final void run() {
                AppMethodBeat.i(55180);
                ab.i("MicroMsg.SightCaptureUI", "connect cost %sms", Long.valueOf(bo.az(yz)));
                j.c(SightCaptureUI.this.owm.fcY);
                SightCaptureUI.b(SightCaptureUI.this);
                AppMethodBeat.o(55180);
            }
        });
        com.tencent.mm.sdk.b.a.xxA.c(this.oCY);
        AppMethodBeat.o(55229);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(55230);
        if (q.etc.eqV == 1 && i == 700 && this.oCD) {
            bQA();
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(55230);
        return onKeyDown;
    }

    public void onPause() {
        AppMethodBeat.i(55231);
        super.onPause();
        ab.i("MicroMsg.SightCaptureUI", "onPause, currentState: %s", za(this.hGH));
        if (this.hGH == 2) {
            stopRecord();
        } else if (this.hGH == 1) {
            bQI();
        } else if (this.hGH == 4 && this.oxL != null) {
            this.oxL.pause();
        }
        o.JV(2);
        AppMethodBeat.o(55231);
    }

    public void onResume() {
        boolean z = false;
        AppMethodBeat.i(55232);
        super.onResume();
        Ne(8);
        String str = "MicroMsg.SightCaptureUI";
        String str2 = "onResume, currentState: %s, textureview available: %s";
        Object[] objArr = new Object[2];
        objArr[0] = za(this.hGH);
        if (this.gLR != null && this.gLR.isAvailable()) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        ab.i(str, str2, objArr);
        if (this.hGH == 2 || this.hGH == 1) {
            bQC();
        } else if (this.hGH == 4) {
            if (this.gLR != null) {
                if (this.gLR.isAvailable()) {
                    this.oCz.WB();
                } else {
                    this.gLR.setTextureChangeCallback(new com.tencent.mm.plugin.video.b() {
                        public final void e(SurfaceTexture surfaceTexture) {
                            AppMethodBeat.i(55218);
                            SightCaptureUI.this.oCz.WB();
                            SightCaptureUI.this.gLR.setTextureChangeCallback(null);
                            AppMethodBeat.o(55218);
                        }
                    });
                }
            }
            if (this.oxL != null) {
                this.oxL.start();
            }
        } else if (this.hGH == 3) {
            if (this.gLR != null) {
                this.gLR.setTextureChangeCallback(null);
            }
            this.oCz.a(this.oCK, this.oCP, this.oCL);
        }
        o.JV(1);
        AppMethodBeat.o(55232);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(55233);
        super.onConfigurationChanged(configuration);
        if (this.oCW.booleanValue() && com.tencent.mm.compatible.util.d.iW(13)) {
            Point point = new Point(configuration.screenWidthDp, configuration.screenHeightDp);
            if (this.oCX == null || !this.oCX.equals(point)) {
                this.oCX = point;
                bQC();
            }
        }
        AppMethodBeat.o(55233);
    }

    private void bQA() {
        AppMethodBeat.i(55234);
        if (this.oCT <= 0 || bo.az(this.oCT) > 500) {
            ab.v("MicroMsg.TestCaptureUiEvent", "switchCameraClick %s, currentState: %s", bo.dpG().toString(), Integer.valueOf(this.hGH));
            bQG();
            this.oCN = true;
            if (this.hGH == 2) {
                if (this.gLs == null || !this.gLs.WP()) {
                    ab.i("MicroMsg.SightCaptureUI", "switchCameraClick, not write camera data!");
                } else {
                    bQJ();
                    this.oCO = true;
                }
            } else if (this.hGH == 1) {
                updateState(6);
                if (jb(true)) {
                    updateState(1);
                }
            }
            bQH();
            this.oCT = bo.yz();
            AppMethodBeat.o(55234);
            return;
        }
        ab.i("MicroMsg.SightCaptureUI", "switchCameraClick, switch camera too frequently!!! ignore");
        AppMethodBeat.o(55234);
    }

    private void stopRecord() {
        AppMethodBeat.i(55235);
        ab.c("MicroMsg.SightCaptureUI", "stopRecord, currentStatus: %s", Integer.valueOf(this.hGH));
        if (this.hGH == 2) {
            bQF();
        }
        AppMethodBeat.o(55235);
    }

    private void bQB() {
        AppMethodBeat.i(55236);
        try {
            LayoutParams layoutParams = this.oxL.getLayoutParams();
            this.oCq.removeView(this.oxL);
            this.oCq.addView(this.oxL, 0, layoutParams);
            AppMethodBeat.o(55236);
        } catch (Exception e) {
            ab.e("MicroMsg.SightCaptureUI", "clearVideoPlayViewContent, error: %s", e.getMessage());
            AppMethodBeat.o(55236);
        }
    }

    private void bQC() {
        AppMethodBeat.i(55237);
        updateState(0);
        this.oCR = 0;
        this.hGI = false;
        this.oCV = false;
        if (this.oxL != null) {
            this.oxL.stop();
            this.oxL.setVideoCallback(null);
            bQB();
        }
        if (this.oCC != null) {
            this.oCC.release();
            this.oCC = null;
        }
        if (this.oCy != null) {
            this.oCy.setVisibility(0);
        }
        this.oCx.setImageBitmap(null);
        bQI();
        this.oCl = new e(this.fcY, this.owm.scene);
        this.oCl.a(this.oCz.fcA);
        if (this.oCl.v(this, this.oCD)) {
            if (this.gLR.isAvailable()) {
                this.oCu = this.gLR.getSurfaceTexture();
                ab.i("MicroMsg.SightCaptureUI", "surface already available, directly set local surface: %s", this.oCu);
                if (jb(false)) {
                    updateState(1);
                } else {
                    updateState(8);
                }
            } else {
                this.gLR.setTextureChangeCallback(new com.tencent.mm.plugin.video.b() {
                    public final void e(SurfaceTexture surfaceTexture) {
                        AppMethodBeat.i(55192);
                        ab.i("MicroMsg.SightCaptureUI", "callback onSurfaceTextureAvailable set local surface: %s", surfaceTexture);
                        SightCaptureUI.this.oCu = surfaceTexture;
                        if (SightCaptureUI.J(SightCaptureUI.this)) {
                            SightCaptureUI.g(SightCaptureUI.this, 1);
                            AppMethodBeat.o(55192);
                            return;
                        }
                        SightCaptureUI.g(SightCaptureUI.this, 8);
                        AppMethodBeat.o(55192);
                    }
                });
            }
            if (this.oCA != null && this.oCk) {
                this.oCA.setAlpha(1.0f);
                this.oCA.setVisibility(0);
            }
            this.oCM.reset();
            this.oCN = false;
            this.oCO = false;
            AppMethodBeat.o(55237);
            return;
        }
        updateState(8);
        AppMethodBeat.o(55237);
    }

    private boolean jb(boolean z) {
        AppMethodBeat.i(55238);
        ab.b("MicroMsg.SightCaptureUI", "createRecorder, surface: %s", this.oCu);
        this.oCV = false;
        if (this.gLs != null) {
            if (this.oCl != null) {
                this.oCl.b(this.gLs.getFrameDataCallback());
            }
            this.gLs.cancel();
        }
        if (this.oCl == null) {
            AppMethodBeat.o(55238);
            return false;
        }
        boolean a;
        this.oCE = new baa();
        this.oCE.wDP = true;
        this.oCE.wDO = j.ouz.ouO;
        if (this.owm != null) {
            this.oCE.wDR = this.owm.scene;
        }
        if (z) {
            a = this.oCl.a((Context) this, this.oCu, true);
            this.oCD = this.oCl.bPv();
            if (!a) {
                AppMethodBeat.o(55238);
                return false;
            }
        } else if (this.oCl.a(this.oCu, true) < 0) {
            AppMethodBeat.o(55238);
            return false;
        }
        if (this.oCl.getEncodeVideoBestSize() == null) {
            AppMethodBeat.o(55238);
            return false;
        }
        k.bPR();
        this.gLs = k.p(this.fcY);
        if (this.gLs == null) {
            ab.e("MicroMsg.SightCaptureUI", "create mediaRecorder error");
            this.oCV = true;
            AppMethodBeat.o(55238);
            return false;
        }
        com.tencent.mm.plugin.mmsight.d.a(this.gLs, this.owm);
        this.gLs.a(this);
        this.oCl.a(this.gLs.getFrameDataCallback());
        if (this.oCz != null) {
            this.oCz.ab(this.oCl.getPreviewWidth(), this.oCl.getPreviewHeight(), this.oCl.getOrientation());
        }
        this.gLs.s(this.oCl.getPreviewWidth(), this.oCl.getPreviewHeight(), this.oCl.getEncodeVideoBestSize().x, this.oCl.getEncodeVideoBestSize().y);
        a = this.gLs.ko(this.oCl.getOrientation());
        ab.i("MicroMsg.SightCaptureUI", "preInit result: %s", Boolean.valueOf(a));
        if (!a) {
            this.oCV = true;
        }
        AppMethodBeat.o(55238);
        return a;
    }

    private int bQD() {
        AppMethodBeat.i(55239);
        ab.i("MicroMsg.SightCaptureUI", "startRecordImpl");
        int b = this.gLs.b(this.oCl.getOrientation(), this.oCM.isLandscape(), this.oCM.getOrientation());
        ab.i("MicroMsg.SightCaptureUI", "startRecordImpl ret: %d", Integer.valueOf(b));
        if (b >= 0) {
            this.oCl.a(e.a.Recording);
        }
        AppMethodBeat.o(55239);
        return b;
    }

    private void bQE() {
        AppMethodBeat.i(55240);
        this.oCV = true;
        updateState(8);
        if (this.gLs != null) {
            try {
                this.gLs.cancel();
                this.gLs = null;
                AppMethodBeat.o(55240);
                return;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.SightCaptureUI", e, "", new Object[0]);
            }
        }
        AppMethodBeat.o(55240);
    }

    private void bQF() {
        AppMethodBeat.i(55241);
        updateState(7);
        this.oCn.setTouchEnable(false);
        final int previewWidth = this.oCl.getPreviewWidth();
        final int previewHeight = this.oCl.getPreviewHeight();
        this.gLs.v(new Runnable() {
            public final void run() {
                AppMethodBeat.i(55195);
                ab.c("MicroMsg.SightCaptureUI", "call stop callback now, currentStatus: %s", SightCaptureUI.zb(SightCaptureUI.this.hGH));
                SightCaptureUI.this.oCl.a(e.a.Stoping);
                SightCaptureUI.B(SightCaptureUI.this);
                final long RN = com.tencent.mm.plugin.mmsight.d.RN("TIME_RECODER_2_PLAY");
                com.tencent.mm.sdk.g.d.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(55194);
                        String filePath = SightCaptureUI.this.gLs.getFilePath();
                        baa K = SightCaptureUI.this.oCE;
                        try {
                            if (!bo.isNullOrNil(filePath) && com.tencent.mm.vfs.e.ct(filePath)) {
                                int i;
                                int i2;
                                int i3;
                                int i4;
                                int i5;
                                h.pYm.a(440, 87, 1, false);
                                JSONObject jSONObject = new JSONObject(SightVideoJNI.getSimpleMp4Info(filePath));
                                int i6 = (int) jSONObject.getDouble("videoFPS");
                                int optInt = jSONObject.optInt("videoBitrate");
                                ab.i("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish, videoFPS: %s, videoBitrate: %s", Integer.valueOf(i6), Integer.valueOf(optInt));
                                com.tencent.mm.plugin.mmsight.model.a bPi = com.tencent.mm.plugin.mmsight.model.a.bPi();
                                bPi.otv = j.ouz.etz;
                                bPi.videoBitrate = j.ouz.videoBitrate;
                                bPi.etA = j.ouz.ouL ? 1 : 0;
                                bPi.otw = j.ouz.ouM ? 1 : 0;
                                bPi.fay = j.ouz.fay;
                                bPi.otx = i6;
                                bPi.fileSize = com.tencent.mm.vfs.e.asZ(filePath);
                                com.tencent.mm.plugin.sight.base.a WR = com.tencent.mm.plugin.sight.base.d.WR(filePath);
                                if (WR != null) {
                                    bPi.otA = WR.width;
                                    bPi.otB = WR.height;
                                    bPi.otC = WR.videoBitrate;
                                    bPi.oty = WR.eWK;
                                }
                                if (j.ouz.etz == 1) {
                                    h.pYm.a(440, 89, 1, false);
                                    h.pYm.a(440, 49, (long) i6, false);
                                    i = 93;
                                    i2 = 73;
                                    i3 = 69;
                                } else {
                                    h.pYm.a(440, 88, 1, false);
                                    h.pYm.a(440, 48, (long) i6, false);
                                    i = 90;
                                    i2 = 54;
                                    i3 = 50;
                                }
                                if (j.ouz.fay == 720) {
                                    i++;
                                    i4 = i2 + 6;
                                    i5 = i3 + 6;
                                } else if (j.ouz.bPI()) {
                                    i += 2;
                                    i4 = i2 + 12;
                                    i5 = i3 + 12;
                                } else {
                                    i4 = i2;
                                    i5 = i3;
                                }
                                h.pYm.a(440, (long) i4, (long) i6, false);
                                h.pYm.a(440, (long) i, 1, false);
                                h.pYm.a(440, 47, (long) i6, false);
                                ab.i("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish, filePath: %s base %d", filePath, Integer.valueOf(i5));
                                if (i6 >= 0 && i6 <= 10) {
                                    h.pYm.a(440, (long) i5, 1, false);
                                } else if (i6 > 10 && i6 <= 15) {
                                    h.pYm.a(440, (long) (i5 + 1), 1, false);
                                } else if (i6 > 15 && i6 <= 20) {
                                    h.pYm.a(440, (long) (i5 + 2), 1, false);
                                } else if (i6 > 20 && i6 <= 30) {
                                    h.pYm.a(440, (long) (i5 + 3), 1, false);
                                }
                                if (optInt > 0) {
                                    if (j.ouz.etz == 2) {
                                        h.pYm.a(440, 175, (long) optInt, false);
                                        h.pYm.a(440, 176, 1, false);
                                        if (K != null) {
                                            if (K.wDR == 1) {
                                                h.pYm.a(440, 184, (long) optInt, false);
                                                h.pYm.a(440, 185, 1, false);
                                            } else if (K.wDR == 2) {
                                                h.pYm.a(440, 194, (long) optInt, false);
                                                h.pYm.a(440, 195, 1, false);
                                            }
                                        }
                                    } else {
                                        h.pYm.a(440, 179, (long) optInt, false);
                                        h.pYm.a(440, 180, 1, false);
                                        if (K != null) {
                                            if (K.wDR == 1) {
                                                h.pYm.a(440, 189, (long) optInt, false);
                                                h.pYm.a(440, 190, 1, false);
                                            } else if (K.wDR == 2) {
                                                h.pYm.a(440, 199, (long) optInt, false);
                                                h.pYm.a(440, 200, 1, false);
                                            }
                                        }
                                    }
                                }
                            }
                        } catch (Exception e) {
                            ab.e("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish error: %s", e.getMessage());
                        }
                        com.tencent.mm.plugin.mmsight.model.k.d(false, RN);
                        AppMethodBeat.o(55194);
                    }
                }, "BigSightFFMpegRecorder_markAfterCaptureFinish_idkeystat");
                ab.v("MicroMsg.TestCaptureUiEvent", "doStopRecorderAndStartPreviewDone %s", bo.dpG().toString());
                ab.i("MicroMsg.SightCaptureUI", "stop finish, filepath: %s %s time_takevideo %s", SightCaptureUI.this.gLs.getFilePath(), Long.valueOf(com.tencent.mm.vfs.e.asZ(SightCaptureUI.this.gLs.getFilePath())), Long.valueOf(RN));
                SightCaptureUI.this.cMW = SightCaptureUI.this.gLs.Aq();
                SightCaptureUI.A(SightCaptureUI.this);
                SightCaptureUI.L(SightCaptureUI.this);
                SightCaptureUI.M(SightCaptureUI.this);
                al.n(SightCaptureUI.this.oDe, 1000);
                if (SightCaptureUI.this.owm.scene == 1 || SightCaptureUI.this.owm.scene == 2 || SightCaptureUI.this.owm.scene == 7) {
                    h.pYm.e(13819, Integer.valueOf(2), Integer.valueOf(SightCaptureUI.this.owm.scene), SightCaptureUI.this.owm.osR, Long.valueOf(bo.anT()));
                }
                AppMethodBeat.o(55195);
            }
        });
        AppMethodBeat.o(55241);
    }

    private void bQG() {
        AppMethodBeat.i(55242);
        k.bPR();
        if (k.isDebug()) {
            TextView textView = (TextView) findViewById(R.id.a4k);
            textView.setVisibility(8);
            textView.setText("");
            AppMethodBeat.o(55242);
            return;
        }
        AppMethodBeat.o(55242);
    }

    private void bQH() {
        AppMethodBeat.i(55243);
        k.bPR();
        if (k.isDebug()) {
            ab.i("MicroMsg.SightCaptureUI", "test for debug " + bo.dpG().toString());
            i.S(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(55201);
                    SightCaptureUI.O(SightCaptureUI.this);
                    AppMethodBeat.o(55201);
                }
            });
            AppMethodBeat.o(55243);
            return;
        }
        AppMethodBeat.o(55243);
    }

    private String aU(String str, boolean z) {
        String RL;
        AppMethodBeat.i(55244);
        boolean z2 = CaptureMMProxy.getInstance().getBoolean(ac.a.USERINFO_WEIXIN_CAMERASAVEIMAGE_STATE_BOOLEAN, true);
        boolean z3 = CaptureMMProxy.getInstance().getBoolean(ac.a.USERINFO_WEIXIN_CAMERASAVEVIDEO_STATE_BOOLEAN, true);
        if (z) {
            RL = com.tencent.mm.plugin.mmsight.d.RL("jpg");
        } else {
            RL = com.tencent.mm.plugin.mmsight.d.RL("mp4");
        }
        if ((z2 && z) || (z3 && !z)) {
            ab.i("MicroMsg.SightCaptureUI", "auto save src %s dest %s state %s %s", str, RL, Boolean.valueOf(z2), Boolean.valueOf(z3));
            com.tencent.mm.vfs.e.y(str, RL);
            com.tencent.mm.sdk.f.a.a(RL, this);
        }
        AppMethodBeat.o(55244);
        return RL;
    }

    private void bQI() {
        AppMethodBeat.i(55245);
        if (this.gLR != null) {
            this.gLR.setTextureChangeCallback(null);
        }
        if (this.oCl != null) {
            this.oCD = this.oCl.bPv();
            this.oCl.bPq();
            this.oCT = -1;
            this.hGJ = -1;
        }
        AppMethodBeat.o(55245);
    }

    private void bQJ() {
        AppMethodBeat.i(55246);
        String str = "MicroMsg.SightCaptureUI";
        String str2 = "switchCameraOnRecord, currentStatus: %s, mediaRecorder.status: %s";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(this.hGH);
        objArr[1] = this.gLs != null ? this.gLs.WL() : "";
        ab.i(str, str2, objArr);
        if (this.hGH == 2 && this.gLs != null && this.gLs.WL() == d.c.Start) {
            this.gLs.pause();
            this.oCl.a((Context) this, this.oCu, false);
            this.oCD = this.oCl.bPv();
            if (this.oCz != null) {
                this.oCz.ab(this.oCl.getPreviewWidth(), this.oCl.getPreviewHeight(), this.oCl.getOrientation());
            }
            if (this.gLs.WL() != d.c.Pause) {
                ab.e("MicroMsg.SightCaptureUI", "switchCameraOnRecord, recorder status error: %s", this.gLs.WL());
                AppMethodBeat.o(55246);
                return;
            }
            int previewWidth = this.oCl.getPreviewWidth();
            int previewHeight = this.oCl.getPreviewHeight();
            int orientation = this.oCl.getOrientation();
            Point WN = this.gLs.WN();
            ab.i("MicroMsg.SightCaptureUI", "switchCameraOnRecord, newPreviewSize: [%s, %s], oldPreviewSize: [%s], newOrientation: %s, oldOrientation: %s", Integer.valueOf(previewWidth), Integer.valueOf(previewHeight), WN, Integer.valueOf(orientation), Integer.valueOf(this.gLs.WO()));
            if (!(this.gLs.WO() == orientation && WN.x == previewWidth && WN.y == previewHeight)) {
                ab.e("MicroMsg.SightCaptureUI", "error oldOrientation! after switch, size or orientation not match");
            }
            this.gLs.s(this.oCl.getPreviewWidth(), this.oCl.getPreviewHeight(), this.oCl.getEncodeVideoBestSize().x, this.oCl.getEncodeVideoBestSize().y);
            this.gLs.G(orientation, this.oCl.getEncodeVideoBestSize().x, this.oCl.getEncodeVideoBestSize().y);
        }
        AppMethodBeat.o(55246);
    }

    public void onDestroy() {
        Object obj;
        AppMethodBeat.i(55247);
        super.onDestroy();
        ab.i("MicroMsg.SightCaptureUI", "onDestroy");
        this.ext.release();
        if (this.gLs != null) {
            this.gLs.a(null);
            this.gLs.v(null);
            this.gLs.clear();
        }
        if (this.hGH == -1) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            bQI();
            if (this.oxL != null) {
                this.oxL.stop();
                this.oxL.setVideoCallback(null);
            }
            if (this.gar != null) {
                this.gar.Mm();
            }
            if (this.oCC != null) {
                this.oCC.release();
                this.oCC = null;
            }
        }
        if (this.oCM != null) {
            this.oCM.disable();
            this.oCM.otK = null;
            this.oCM = null;
        }
        com.tencent.mm.plugin.mmsight.model.a.j.owk.WY();
        com.tencent.mm.sdk.b.a.xxA.d(this.oCY);
        AppMethodBeat.o(55247);
    }

    public final int getLayoutId() {
        return R.layout.g9;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(55248);
        super.onActivityResult(i, i2, intent);
        String str = "MicroMsg.SightCaptureUI";
        String str2 = "[onActivityResult] requestCode:%s  resultCode:%s data is null?:";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        ab.i(str, str2, objArr);
        switch (i) {
            case 4369:
                ab.i("MicroMsg.SightCaptureUI", "[handlePhotoEditResult] resultCode:%s", Integer.valueOf(i2));
                if (!(i2 != -1 || intent == null || this.gLs == null)) {
                    this.oDc = true;
                    this.oDd = intent.getBundleExtra("report_info");
                    this.oDa = intent.getStringExtra("raw_photo_path");
                    this.oDb = intent.getStringExtra("after_photo_edit");
                    ab.i("MicroMsg.SightCaptureUI", "rawEditPhotoPath:%s lastEditPhotoPath:%s imageState:%s", this.oDa, this.oDb, Boolean.valueOf(CaptureMMProxy.getInstance().getBoolean(ac.a.USERINFO_WEIXIN_CAMERASAVEIMAGE_STATE_BOOLEAN, true)));
                    if (CaptureMMProxy.getInstance().getBoolean(ac.a.USERINFO_WEIXIN_CAMERASAVEIMAGE_STATE_BOOLEAN, true)) {
                        this.gLs.mc(this.oDb);
                    } else {
                        String subCoreImageFullPath = CaptureMMProxy.getInstance().getSubCoreImageFullPath("photoEdited_" + System.currentTimeMillis());
                        ab.i("MicroMsg.SightCaptureUI", "saveFullPath:%s", subCoreImageFullPath);
                        com.tencent.mm.vfs.e.y(this.oDb, subCoreImageFullPath);
                        com.tencent.mm.vfs.e.deleteFile(this.oDb);
                        com.tencent.mm.sdk.f.a.a(this.oDb, this);
                        this.gLs.mc(subCoreImageFullPath);
                        this.oDb = subCoreImageFullPath;
                    }
                    Options options = new Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(this.oDb, options);
                    ab.i("MicroMsg.SightCaptureUI", "rawW:%s rawH:%s", Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight));
                    Bitmap ao = com.tencent.mm.sdk.platformtools.d.ao(this.oDb, options.outHeight, options.outWidth);
                    this.oCx.setVisibility(0);
                    this.oCx.setImageBitmap(ao);
                    this.oCy.setVisibility(8);
                    break;
                }
        }
        AppMethodBeat.o(55248);
    }

    private static String za(int i) {
        if (i == -1) {
            return "CAPTURE_STATE_BINGDING";
        }
        if (i == 0) {
            return "CAPTURE_STATE_INIT";
        }
        if (i == 1) {
            return "CAPTURE_STATE_CAPTURING";
        }
        if (i == 2) {
            return "CAPTURE_STATE_RECORDING";
        }
        if (i == 3) {
            return "CAPTURE_STATE_PREVIEW_PICTURE";
        }
        if (i == 4) {
            return "CAPTURE_STATE_PREVIEW_VIDEO";
        }
        if (i == 6) {
            return "CAPTURE_STATE_SUPERMAN";
        }
        if (i == 7) {
            return "CAPTURE_STATE_WAIT_TO_PREVIEW";
        }
        if (i == 8) {
            return "CAPTURE_STATE_INIT_ERROR";
        }
        if (i == 9) {
            return "CAPTURE_STATE_STOP_ERROR";
        }
        return "UNKNOW";
    }

    private void updateState(int i) {
        AppMethodBeat.i(55249);
        ab.i("MicroMsg.SightCaptureUI", "pre state %s %s update state %s %s", Integer.valueOf(this.hGH), za(this.hGH), Integer.valueOf(i), za(i));
        ab.i("MicroMsg.TestCaptureUiEvent", "pre state %s %s update state %s %s %s", Integer.valueOf(this.hGH), za(this.hGH), Integer.valueOf(i), za(i), bo.dpG().toString());
        if (i == this.hGH) {
            AppMethodBeat.o(55249);
        } else if (this.oCq == null) {
            AppMethodBeat.o(55249);
        } else {
            com.tencent.mm.plugin.mmsight.d.RM("TIME_RECODER_2_PLAY");
            this.hGH = i;
            if (this.hGH != 7) {
                al.af(this.oCZ);
            }
            if (this.hGH == 0) {
                this.oCq.setVisibility(8);
                this.oCt.setVisibility(8);
                this.oCr.setVisibility(8);
                this.oCx.setVisibility(8);
                this.oCw.setVisibility(0);
                if (this.oCQ > 1) {
                    this.oCs.setVisibility(0);
                }
                if (this.oCl != null) {
                    this.oCl.a(e.a.Preview);
                }
                com.tencent.mm.plugin.mmsight.model.a.reset();
                if (this.oCS != null) {
                    try {
                        this.oCS.interrupt();
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.SightCaptureUI", e, "update to state init, interrupt failed: %s", e.getMessage());
                    }
                    this.oCS = null;
                    AppMethodBeat.o(55249);
                    return;
                }
            } else if (this.hGH == 1 || this.hGH == 2) {
                this.oCq.setVisibility(0);
                this.oCt.setVisibility(8);
                this.oCr.setVisibility(0);
                this.oCr.setClipChildren(false);
                this.oCo.setVisibility(8);
                this.nPr.setVisibility(8);
                this.oCp.setVisibility(0);
                this.oCn.setVisibility(0);
                this.oxL.setVisibility(8);
                if (this.hGH == 1) {
                    this.oCn.reset();
                } else {
                    this.oCn.setTouchEnable(true);
                    this.oCn.bQt();
                }
                this.oCB.setVisibility(8);
                this.oCx.setVisibility(8);
                this.lmm.setVisibility(0);
                if (this.oCQ > 1) {
                    this.oCs.setVisibility(0);
                }
                this.lmm.bringToFront();
                this.oCs.bringToFront();
                bQG();
                bQH();
                AppMethodBeat.o(55249);
                return;
            } else if (this.hGH == 4 || this.hGH == 3) {
                this.oCq.setVisibility(0);
                this.oCr.setVisibility(8);
                this.oCr.setClipChildren(false);
                this.oCo.setVisibility(0);
                this.nPr.setVisibility(0);
                this.oCp.setVisibility(8);
                this.oCn.setVisibility(8);
                if (this.hGH == 3) {
                    this.oCt.setVisibility(0);
                    this.oCx.setVisibility(0);
                    this.oxL.setVisibility(8);
                } else {
                    this.oCx.setVisibility(8);
                    this.oxL.setVisibility(0);
                    this.oxL.setForceScaleFullScreen(true);
                    LayoutParams layoutParams = this.oxL.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.oxL.setLayoutParams(layoutParams);
                    if (this.gLs.isLandscape()) {
                        this.oCz.WB();
                    }
                    this.oCw.setVisibility(8);
                }
                this.lmm.setVisibility(8);
                AppMethodBeat.o(55249);
                return;
            } else if (this.hGH == 6) {
                this.oCo.setVisibility(8);
                this.nPr.setVisibility(8);
                this.oCt.setVisibility(8);
                this.oCp.setVisibility(8);
                this.oCn.setVisibility(8);
                AppMethodBeat.o(55249);
                return;
            } else if (this.hGH == 7) {
                this.oCo.setVisibility(8);
                this.nPr.setVisibility(8);
                this.oCp.setVisibility(8);
                this.oCs.setVisibility(8);
                this.oCt.setVisibility(8);
                this.oCn.setTouchEnable(false);
                al.n(this.oCZ, 1500);
                this.oCn.bgk();
                AppMethodBeat.o(55249);
                return;
            } else if (this.hGH == 8) {
                this.oCq.setVisibility(0);
                this.oCr.setVisibility(0);
                this.oCr.setClipChildren(false);
                this.oCo.setVisibility(8);
                this.nPr.setVisibility(8);
                this.oCt.setVisibility(8);
                this.oCp.setVisibility(0);
                if (this.oCQ > 1) {
                    this.oCs.setVisibility(0);
                }
                this.oCn.setVisibility(0);
                this.lmm.setVisibility(0);
                this.oxL.setVisibility(8);
                this.oCB.setVisibility(8);
                this.oCx.setVisibility(8);
                if (this.oCV) {
                    Toast.makeText(this, R.string.czu, 1).show();
                } else {
                    Toast.makeText(this, R.string.czz, 1).show();
                }
                this.oCn.setTouchEnable(false);
                this.oCn.setEnabled(false);
                AppMethodBeat.o(55249);
                return;
            } else if (this.hGH == 9) {
                this.oCo.setVisibility(8);
                this.nPr.setVisibility(8);
                this.oCt.setVisibility(8);
                this.oCp.setVisibility(0);
                this.oCs.setVisibility(8);
                this.oCn.reset();
                this.oCn.setTouchEnable(false);
                this.oCn.setEnabled(false);
                Toast.makeText(this, R.string.czv, 1).show();
            }
            AppMethodBeat.o(55249);
        }
    }

    private void jc(boolean z) {
        AppMethodBeat.i(55250);
        ab.i("MicroMsg.SightCaptureUI", "[clearPhotoEditCache] isDelete:%s mLastEditPhotoPath:%s mRawEditPhotoPath:%s", Boolean.valueOf(z), this.oDb, this.oDa);
        if (!bo.isNullOrNil(this.oDb) && z) {
            com.tencent.mm.vfs.e.deleteFile(this.oDb);
        }
        if (!bo.isNullOrNil(this.oDa)) {
            com.tencent.mm.vfs.e.deleteFile(this.oDa);
        }
        this.oDb = null;
        this.oDa = null;
        mj mjVar = new mj();
        mjVar.cIo.cuy = 0;
        com.tencent.mm.sdk.b.a.xxA.m(mjVar);
        AppMethodBeat.o(55250);
    }

    public void onBackPressed() {
        AppMethodBeat.i(55251);
        ab.i("MicroMsg.SightCaptureUI", "onBackPressed %d", Integer.valueOf(this.hGH));
        if (this.oCC != null && this.oCC.wY()) {
            AppMethodBeat.o(55251);
        } else if (this.oCC != null) {
            this.oCC.release();
            this.oCC = null;
            Ne(8);
            this.oCo.setVisibility(0);
            this.nPr.setVisibility(0);
            this.oCt.setVisibility(0);
            AppMethodBeat.o(55251);
        } else {
            if (bQK()) {
                super.onBackPressed();
                overridePendingTransition(-1, R.anim.d_);
                jc(true);
            }
            AppMethodBeat.o(55251);
        }
    }

    private boolean bQK() {
        return this.hGH == 4 || this.hGH == 3 || this.hGH == 1 || this.hGH == 8 || this.hGH == 9;
    }

    public final void yR(int i) {
        AppMethodBeat.i(55252);
        if (this.oCQ <= 1) {
            AppMethodBeat.o(55252);
        } else if (this.hGH == 2) {
            AppMethodBeat.o(55252);
        } else {
            ab.i("MicroMsg.SightCaptureUI", "onOrientationChange: %s", Integer.valueOf(i));
            if (i < 0) {
                AppMethodBeat.o(55252);
                return;
            }
            float f;
            if (i != 90 && i != 270) {
                f = (float) i;
            } else if (i == 270) {
                f = 90.0f;
            } else {
                f = -90.0f;
            }
            if (this.oCs.getRotation() == f) {
                AppMethodBeat.o(55252);
                return;
            }
            this.oCs.animate().rotation(f).setDuration(100).start();
            AppMethodBeat.o(55252);
        }
    }

    public final void asv() {
        AppMethodBeat.i(55253);
        ab.i("MicroMsg.SightCaptureUI", "onError: %s", Integer.valueOf(1));
        try {
            if (this.gLs != null) {
                this.gLs.reset();
            }
        } catch (Exception e) {
            ab.e("MicroMsg.SightCaptureUI", "onError, reset mediaRecorder error: %s", e.getMessage());
        }
        updateState(9);
        AppMethodBeat.o(55253);
    }

    static /* synthetic */ void b(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.i(55254);
        sightCaptureUI.dyg();
        sightCaptureUI.Ne(8);
        if (sightCaptureUI.owm == null) {
            ab.e("MicroMsg.SightCaptureUI", "sightParams error!");
            AppMethodBeat.o(55254);
            return;
        }
        sightCaptureUI.oCQ = com.tencent.mm.compatible.e.d.getNumberOfCameras();
        ab.i("MicroMsg.SightCaptureUI", "initOnCreate, numCamera: %s", Integer.valueOf(sightCaptureUI.oCQ));
        sightCaptureUI.gar = new b(sightCaptureUI);
        sightCaptureUI.oCk = sightCaptureUI.owm.osP;
        sightCaptureUI.osJ = sightCaptureUI.owm.osJ;
        sightCaptureUI.oCD = sightCaptureUI.osJ == 2;
        k.bPR().owm = sightCaptureUI.owm;
        sightCaptureUI.oCj = sightCaptureUI.owm.mode;
        ab.i("MicroMsg.SightCaptureUI", "SightCaptureUI onCreate, captureMode: %s, showHint: %s, defaultCamera: %s, scene: %s", Integer.valueOf(sightCaptureUI.oCj), Boolean.valueOf(sightCaptureUI.oCk), Integer.valueOf(sightCaptureUI.osJ), Integer.valueOf(sightCaptureUI.owm.scene));
        sightCaptureUI.fcY = sightCaptureUI.owm.fcY;
        if (sightCaptureUI.fcY == null) {
            ab.e("MicroMsg.SightCaptureUI", "SightCaptureUI onCreate, cannot get videoParams");
            AppMethodBeat.o(55254);
            return;
        }
        ab.i("MicroMsg.SightCaptureUI", "SightCaptureUI onCreate, videoParams: %s", sightCaptureUI.fcY);
        sightCaptureUI.getWindow().addFlags(2097280);
        if (com.tencent.mm.compatible.util.d.iW(19)) {
            sightCaptureUI.getWindow().setFlags(201327616, 201327616);
            com.tencent.mm.plugin.mmsight.d.iV(true);
        } else {
            sightCaptureUI.getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            com.tencent.mm.plugin.mmsight.d.iV(false);
        }
        if (VERSION.SDK_INT >= 21) {
            sightCaptureUI.getWindow().addFlags(67108864);
        }
        sightCaptureUI.oCM = new c(sightCaptureUI);
        sightCaptureUI.oCM.otK = sightCaptureUI;
        sightCaptureUI.oCM.enable();
        sightCaptureUI.oCm = (ViewGroup) sightCaptureUI.findViewById(R.id.l_);
        sightCaptureUI.oCq = (ViewGroup) sightCaptureUI.findViewById(R.id.a4f);
        sightCaptureUI.oCr = (ViewGroup) sightCaptureUI.findViewById(R.id.a4r);
        sightCaptureUI.oCv = (CameraFrontSightView) sightCaptureUI.findViewById(R.id.a4e);
        sightCaptureUI.gLR = (ObservableTextureView) sightCaptureUI.findViewById(R.id.a4u);
        sightCaptureUI.oCn = (MMSightRecordButton) sightCaptureUI.findViewById(R.id.a4s);
        sightCaptureUI.oCo = sightCaptureUI.findViewById(R.id.a4m);
        sightCaptureUI.nPr = sightCaptureUI.findViewById(R.id.a4n);
        sightCaptureUI.oCp = sightCaptureUI.findViewById(R.id.a4l);
        sightCaptureUI.oCw = (ViewGroup) sightCaptureUI.findViewById(R.id.a4c);
        sightCaptureUI.oCA = (TextView) sightCaptureUI.findViewById(R.id.a4t);
        if (sightCaptureUI.oCj == 2) {
            sightCaptureUI.oCA.setText(R.string.czx);
        } else if (sightCaptureUI.oCj == 1) {
            sightCaptureUI.oCA.setText(R.string.czy);
        } else if (sightCaptureUI.oCj == 0) {
            sightCaptureUI.oCA.setText(R.string.czw);
        }
        sightCaptureUI.oxL = (VideoPlayerTextureView) sightCaptureUI.findViewById(R.id.a4h);
        sightCaptureUI.oCs = (ImageView) sightCaptureUI.findViewById(R.id.a4q);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) sightCaptureUI.oCs.getLayoutParams();
        int i = layoutParams.topMargin;
        if (ae.hD(sightCaptureUI.mController.ylL)) {
            i += ae.hC(sightCaptureUI.mController.ylL);
        }
        layoutParams.setMargins(layoutParams.leftMargin, i, layoutParams.rightMargin, layoutParams.bottomMargin);
        sightCaptureUI.oCs.setLayoutParams(layoutParams);
        sightCaptureUI.oCt = (ImageView) sightCaptureUI.findViewById(R.id.a4j);
        sightCaptureUI.oCt.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(55219);
                if (SightCaptureUI.this.hGH == 3) {
                    SightCaptureUI.h(SightCaptureUI.this);
                    AppMethodBeat.o(55219);
                    return;
                }
                if (SightCaptureUI.this.hGH == 4) {
                    SightCaptureUI.i(SightCaptureUI.this);
                }
                AppMethodBeat.o(55219);
            }
        });
        sightCaptureUI.oCx = (ImageView) sightCaptureUI.findViewById(R.id.a4i);
        sightCaptureUI.oCy = (MMSightCameraGLSurfaceView) sightCaptureUI.findViewById(R.id.a4d);
        sightCaptureUI.lmm = (MMSightCaptureTouchView) sightCaptureUI.findViewById(R.id.a4p);
        sightCaptureUI.oCB = sightCaptureUI.findViewById(R.id.a4g);
        sightCaptureUI.oCz = new com.tencent.mm.plugin.mmsight.ui.cameraglview.a(sightCaptureUI.oCy);
        if (sightCaptureUI.oCk) {
            sightCaptureUI.oCA.setVisibility(0);
        } else {
            sightCaptureUI.oCA.setVisibility(8);
        }
        int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(sightCaptureUI.mController.ylL, 120);
        sightCaptureUI.oCv.ez(fromDPToPix, fromDPToPix);
        if (com.tencent.mm.compatible.util.d.iW(19)) {
            i = Math.max(ak.fr(sightCaptureUI), ak.hx(sightCaptureUI));
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) sightCaptureUI.oCn.getLayoutParams();
            marginLayoutParams.bottomMargin += i;
            sightCaptureUI.oCn.setLayoutParams(marginLayoutParams);
            marginLayoutParams = (MarginLayoutParams) sightCaptureUI.oCp.getLayoutParams();
            marginLayoutParams.bottomMargin += i;
            sightCaptureUI.oCp.setLayoutParams(marginLayoutParams);
            marginLayoutParams = (MarginLayoutParams) sightCaptureUI.oCo.getLayoutParams();
            marginLayoutParams.bottomMargin += i;
            sightCaptureUI.oCo.setLayoutParams(marginLayoutParams);
            marginLayoutParams = (MarginLayoutParams) sightCaptureUI.oCt.getLayoutParams();
            marginLayoutParams.bottomMargin += i;
            sightCaptureUI.oCt.setLayoutParams(marginLayoutParams);
            marginLayoutParams = (MarginLayoutParams) sightCaptureUI.nPr.getLayoutParams();
            marginLayoutParams.bottomMargin = i + marginLayoutParams.bottomMargin;
            sightCaptureUI.nPr.setLayoutParams(marginLayoutParams);
        }
        if (sightCaptureUI.oCj == 1 || sightCaptureUI.oCj == 0) {
            sightCaptureUI.oCn.setLongPressCallback(new MMSightRecordButton.b() {
                public final void bnV() {
                    AppMethodBeat.i(55220);
                    ab.i("MicroMsg.SightCaptureUI", "onPressDown, currentStatus: %s", Integer.valueOf(SightCaptureUI.this.hGH));
                    if (SightCaptureUI.this.hGH == 0 || SightCaptureUI.this.oCl == null || !SightCaptureUI.this.oCl.bPu()) {
                        AppMethodBeat.o(55220);
                        return;
                    }
                    int[] iArr = new int[2];
                    SightCaptureUI.this.oCn.getLocationOnScreen(iArr);
                    SightCaptureUI.this.oCl.kj(iArr[1]);
                    if (SightCaptureUI.this.oCj == 0) {
                        SightCaptureUI.this.oCR = SightCaptureUI.m(SightCaptureUI.this);
                    }
                    AppMethodBeat.o(55220);
                }

                /* renamed from: if */
                public final void m11if() {
                    AppMethodBeat.i(55221);
                    if (SightCaptureUI.this.hGH == 0 || SightCaptureUI.this.oCl == null || !SightCaptureUI.this.oCl.bPu()) {
                        AppMethodBeat.o(55221);
                        return;
                    }
                    SightCaptureUI.n(SightCaptureUI.this);
                    ab.i("MicroMsg.TestCaptureUiEvent", "onLongPress %s", bo.dpG().toString());
                    SightCaptureUI.o(SightCaptureUI.this);
                    AppMethodBeat.o(55221);
                }

                public final void bnU() {
                    AppMethodBeat.i(55222);
                    String str = "MicroMsg.TestCaptureUiEvent";
                    String str2 = "onLongPressFinish %s, recorder: %s, recordTime: %s";
                    Object[] objArr = new Object[3];
                    objArr[0] = bo.dpG().toString();
                    objArr[1] = SightCaptureUI.this.gLs;
                    objArr[2] = Long.valueOf(SightCaptureUI.this.gLs != null ? SightCaptureUI.this.gLs.WK() : 0);
                    ab.i(str, str2, objArr);
                    if (SightCaptureUI.this.oCj == 0) {
                        if (SightCaptureUI.this.gLs == null || SightCaptureUI.this.gLs.WK() > 1000 || SightCaptureUI.this.gLs.WL() != d.c.Start) {
                            SightCaptureUI.r(SightCaptureUI.this);
                            AppMethodBeat.o(55222);
                            return;
                        }
                        ab.i("MicroMsg.SightCaptureUI", "video record too short, cancel and convert to takepicture");
                        SightCaptureUI.this.gLs.cancel();
                        if (SightCaptureUI.this.oCj == 0) {
                            SightCaptureUI.q(SightCaptureUI.this);
                            AppMethodBeat.o(55222);
                            return;
                        }
                    } else if (SightCaptureUI.this.oCj == 1) {
                        if ((SightCaptureUI.this.gLs == null || SightCaptureUI.this.gLs.WK() > 1000) && SightCaptureUI.this.gLs != null) {
                            SightCaptureUI.r(SightCaptureUI.this);
                        } else {
                            ab.i("MicroMsg.SightCaptureUI", "video record too short");
                            Toast.makeText(SightCaptureUI.this, R.string.d00, 1).show();
                            SightCaptureUI.s(SightCaptureUI.this);
                            AppMethodBeat.o(55222);
                            return;
                        }
                    }
                    AppMethodBeat.o(55222);
                }
            });
            sightCaptureUI.oCn.setErrorPressCallback(new MMSightRecordButton.a() {
                public final void bQu() {
                    AppMethodBeat.i(55223);
                    ab.i("MicroMsg.TestCaptureUiEvent", "onErrorUp: %s", bo.dpG().toString());
                    if (SightCaptureUI.this.gLs != null) {
                        SightCaptureUI.this.gLs.cancel();
                        if (SightCaptureUI.this.oCj == 0) {
                            SightCaptureUI.q(SightCaptureUI.this);
                        }
                    }
                    AppMethodBeat.o(55223);
                }
            });
            sightCaptureUI.oCn.setLongPressScrollCallback(new MMSightRecordButton.c() {
                public final void uF(int i) {
                    AppMethodBeat.i(55224);
                    if (SightCaptureUI.this.oCl != null) {
                        SightCaptureUI.this.oCl.d(true, true, i);
                    }
                    AppMethodBeat.o(55224);
                }

                public final void uG(int i) {
                    AppMethodBeat.i(55225);
                    if (SightCaptureUI.this.oCl != null) {
                        SightCaptureUI.this.oCl.d(false, true, i);
                    }
                    AppMethodBeat.o(55225);
                }
            });
        }
        if (sightCaptureUI.oCj == 0 || sightCaptureUI.oCj == 2) {
            sightCaptureUI.oCn.setSimpleTapCallback(new MMSightRecordButton.d() {
                public final void bnX() {
                    AppMethodBeat.i(55226);
                    ab.v("MicroMsg.TestCaptureUiEvent", "onSimpleTap %s", bo.dpG().toString());
                    if (SightCaptureUI.this.gLs != null) {
                        ab.i("MicroMsg.SightCaptureUI", "onSimpleTap, mediaRecorder.status: %s", SightCaptureUI.this.gLs.WL());
                        SightCaptureUI.this.gLs.cancel();
                    }
                    com.tencent.mm.plugin.mmsight.d.RM("TIME_RECODER_2_PLAY");
                    SightCaptureUI.q(SightCaptureUI.this);
                    AppMethodBeat.o(55226);
                }
            });
        }
        if (sightCaptureUI.oCQ > 1) {
            sightCaptureUI.oCs.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(55227);
                    if (SightCaptureUI.this.oCl != null) {
                        SightCaptureUI.d(SightCaptureUI.this);
                    }
                    AppMethodBeat.o(55227);
                }
            });
        } else {
            sightCaptureUI.oCs.setVisibility(8);
        }
        sightCaptureUI.nPr.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(55181);
                if (SightCaptureUI.this.hGH == 4) {
                    SightCaptureUI.t(SightCaptureUI.this);
                    AppMethodBeat.o(55181);
                    return;
                }
                if (SightCaptureUI.this.hGH == 3) {
                    SightCaptureUI.u(SightCaptureUI.this);
                    SightCaptureUI.a(SightCaptureUI.this, false);
                }
                AppMethodBeat.o(55181);
            }
        });
        sightCaptureUI.oCo.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(55182);
                if (SightCaptureUI.this.gar != null) {
                    SightCaptureUI.this.gar.Mm();
                }
                SightCaptureUI.s(SightCaptureUI.this);
                SightCaptureUI.a(SightCaptureUI.this, true);
                AppMethodBeat.o(55182);
            }
        });
        sightCaptureUI.oCp.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(55183);
                if (SightCaptureUI.w(SightCaptureUI.this)) {
                    SightCaptureUI.this.finish();
                    SightCaptureUI.this.overridePendingTransition(-1, R.anim.d_);
                    AppMethodBeat.o(55183);
                    return;
                }
                AppMethodBeat.o(55183);
            }
        });
        sightCaptureUI.lmm.setTouchCallback(new MMSightCaptureTouchView.a() {
            public final void P(float f, float f2) {
                AppMethodBeat.i(55184);
                if (!(SightCaptureUI.this.hGH == 0 || SightCaptureUI.this.hGH == 3 || SightCaptureUI.this.hGH == 4 || SightCaptureUI.this.oCy == null)) {
                    SightCaptureUI.this.oCl.b(f, f2, SightCaptureUI.this.oCy.getWidth(), SightCaptureUI.this.oCy.getHeight());
                    SightCaptureUI sightCaptureUI = SightCaptureUI.this;
                    if (sightCaptureUI.oCv != null) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) sightCaptureUI.oCv.getLayoutParams();
                        layoutParams.leftMargin = ((int) f) - (sightCaptureUI.oCv.mWidth / 2);
                        layoutParams.topMargin = ((int) f2) - (sightCaptureUI.oCv.mHeight / 2);
                        sightCaptureUI.oCv.setLayoutParams(layoutParams);
                        sightCaptureUI.oCv.bQr();
                    }
                }
                AppMethodBeat.o(55184);
            }

            public final void bnY() {
                AppMethodBeat.i(55185);
                if (SightCaptureUI.this.hGH != 0 && SightCaptureUI.this.oCQ > 1) {
                    SightCaptureUI.this.oCl.oug.removeMessages(4354);
                    SightCaptureUI.d(SightCaptureUI.this);
                }
                AppMethodBeat.o(55185);
            }

            public final void asx() {
                AppMethodBeat.i(55186);
                if (!(SightCaptureUI.this.hGH == 0 || SightCaptureUI.this.oCl == null)) {
                    SightCaptureUI.this.oCl.d(true, false, 1);
                }
                AppMethodBeat.o(55186);
            }

            public final void asy() {
                AppMethodBeat.i(55187);
                if (!(SightCaptureUI.this.hGH == 0 || SightCaptureUI.this.oCl == null)) {
                    SightCaptureUI.this.oCl.d(false, false, 1);
                }
                AppMethodBeat.o(55187);
            }
        });
        sightCaptureUI.updateState(0);
        sightCaptureUI.bQC();
        sightCaptureUI.oCW = Boolean.TRUE;
        AppMethodBeat.o(55254);
    }

    static /* synthetic */ void h(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.i(55256);
        ab.i("MicroMsg.SightCaptureUI", "[gotoPhotoEditUI]");
        if (sightCaptureUI.gLs == null) {
            ab.e("MicroMsg.SightCaptureUI", "mediaRecorder == NULL");
            AppMethodBeat.o(55256);
            return;
        }
        String stringExtra = sightCaptureUI.getIntent().getStringExtra("GalleryUI_FromUser");
        String stringExtra2 = sightCaptureUI.getIntent().getStringExtra("GalleryUI_ToUser");
        Intent intent = new Intent();
        intent.putExtra("GalleryUI_FromUser", stringExtra);
        intent.putExtra("GalleryUI_ToUser", stringExtra2);
        if (sightCaptureUI.owm.scene == 1) {
            intent.putExtra("from_scene", 290);
        } else if (sightCaptureUI.owm.scene == 2) {
            intent.putExtra("from_scene", com.tencent.view.d.MIC_PTU_ZIRAN);
        }
        intent.putExtra("raw_photo_path", bo.isNullOrNil(sightCaptureUI.oDa) ? sightCaptureUI.gLs.WI() : sightCaptureUI.oDa);
        intent.putExtra("after_photo_edit", sightCaptureUI.oDb);
        intent.setClass(sightCaptureUI, MMNewPhotoEditUI.class);
        sightCaptureUI.startActivityForResult(intent, 4369);
        AppMethodBeat.o(55256);
    }

    static /* synthetic */ void i(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.i(55257);
        if (ak.hw(sightCaptureUI)) {
            sightCaptureUI.Ne(0);
        }
        sightCaptureUI.oxM = (VideoSeekBarEditorView) sightCaptureUI.findViewById(R.id.a4o);
        if (ak.hw(sightCaptureUI)) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) sightCaptureUI.oxM.getLayoutParams();
            marginLayoutParams.bottomMargin = Math.max(ak.fr(sightCaptureUI), ak.hx(sightCaptureUI));
            sightCaptureUI.oxM.setLayoutParams(marginLayoutParams);
        }
        sightCaptureUI.oCC = new b();
        sightCaptureUI.oCC.oBR = 2;
        sightCaptureUI.oCC.oBN = true;
        sightCaptureUI.oCC.a(sightCaptureUI, sightCaptureUI.owm.scene, sightCaptureUI.gLs.getFilePath(), sightCaptureUI.oxM, sightCaptureUI.oxL, sightCaptureUI.oCq, sightCaptureUI.fcY, false);
        sightCaptureUI.oCC.oBL = new b.a() {
            public final void bQf() {
                AppMethodBeat.i(55204);
                ab.i("MicroMsg.SightCaptureUI", "on video edit finish");
                if (SightCaptureUI.this.oCC != null) {
                    SightCaptureUI.this.cMW = bo.bc(SightCaptureUI.this.oCC.cvZ, "");
                    SightCaptureUI.this.oCC.n(false, SightCaptureUI.this.owm.osR);
                    SightCaptureUI.this.oCC.release();
                    SightCaptureUI.this.oCC = null;
                }
                SightCaptureUI.this.oCo.setVisibility(0);
                SightCaptureUI.this.nPr.setVisibility(0);
                SightCaptureUI.this.oCt.setVisibility(0);
                SightCaptureUI.this.oxL.stop();
                SightCaptureUI.this.oxL.setVideoPath(SightCaptureUI.this.gLs.getFilePath());
                SightCaptureUI.this.oxL.setLoop(true);
                SightCaptureUI.this.oxL.setForceScaleFullScreen(true);
                SightCaptureUI.this.oxL.setVideoCallback(SightCaptureUI.this.oxS);
                SightCaptureUI.this.Ne(8);
                com.tencent.mm.sdk.g.d.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(55202);
                        SightCaptureUI.V(SightCaptureUI.this);
                        AppMethodBeat.o(55202);
                    }
                }, "SightCaptureUI_edit_finish_save_new_thumb");
                SightCaptureUI.this.oCU = true;
                AppMethodBeat.o(55204);
            }

            public final void bQg() {
                AppMethodBeat.i(55205);
                ab.i("MicroMsg.SightCaptureUI", "on video edit exit");
                if (SightCaptureUI.this.oCC != null) {
                    SightCaptureUI.this.oCC.n(true, SightCaptureUI.this.owm.osR);
                    SightCaptureUI.this.oCC.release();
                    SightCaptureUI.this.oCC = null;
                }
                SightCaptureUI.this.Ne(8);
                SightCaptureUI.this.oCo.setVisibility(0);
                SightCaptureUI.this.nPr.setVisibility(0);
                SightCaptureUI.this.oCt.setVisibility(0);
                AppMethodBeat.o(55205);
            }

            public final void onError() {
                AppMethodBeat.i(55206);
                ab.i("MicroMsg.SightCaptureUI", "on video edit error");
                if (SightCaptureUI.this.oCC != null) {
                    SightCaptureUI.this.oCC.release();
                    SightCaptureUI.this.oCC = null;
                }
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(55203);
                        Toast.makeText(SightCaptureUI.this, R.string.d01, 1).show();
                        SightCaptureUI.this.Ne(8);
                        SightCaptureUI.this.oCo.setVisibility(0);
                        SightCaptureUI.this.nPr.setVisibility(0);
                        SightCaptureUI.this.oCt.setVisibility(0);
                        AppMethodBeat.o(55203);
                    }
                });
                AppMethodBeat.o(55206);
            }
        };
        sightCaptureUI.oCo.setVisibility(8);
        sightCaptureUI.nPr.setVisibility(8);
        sightCaptureUI.oCt.setVisibility(8);
        AppMethodBeat.o(55257);
    }

    static /* synthetic */ void n(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.i(55259);
        if (sightCaptureUI.oCA != null && sightCaptureUI.oCk) {
            sightCaptureUI.oCA.animate().alpha(0.0f).setDuration(100).setListener(new AnimatorListenerAdapter() {
                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(55191);
                    SightCaptureUI.this.oCA.setVisibility(8);
                    AppMethodBeat.o(55191);
                }
            }).start();
        }
        AppMethodBeat.o(55259);
    }

    static /* synthetic */ void o(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.i(55260);
        if (sightCaptureUI.gLs != null) {
            ab.v("MicroMsg.TestCaptureUiEvent", "startRecord, mediaRecorder.status: %s, %s", sightCaptureUI.gLs.WL(), bo.dpG().toString());
            sightCaptureUI.updateState(6);
            if (sightCaptureUI.gLs.WL() == d.c.Stop) {
                sightCaptureUI.oCR = sightCaptureUI.bQD();
                if (sightCaptureUI.oCR < 0) {
                    sightCaptureUI.bQE();
                    AppMethodBeat.o(55260);
                    return;
                }
            } else if (sightCaptureUI.oCR < 0) {
                sightCaptureUI.bQE();
                AppMethodBeat.o(55260);
                return;
            }
            sightCaptureUI.updateState(2);
            if (sightCaptureUI.oCl != null) {
                sightCaptureUI.oCl.bPm();
            }
            sightCaptureUI.oCn.a((sightCaptureUI.fcY.duration * 1000) - 500, 0, new MMSightCircularProgressBar.a() {
                public final void bnW() {
                    AppMethodBeat.i(55193);
                    SightCaptureUI.r(SightCaptureUI.this);
                    AppMethodBeat.o(55193);
                }
            });
        }
        AppMethodBeat.o(55260);
    }

    static /* synthetic */ void q(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.i(55261);
        if (!(sightCaptureUI.oCl == null || !sightCaptureUI.oCl.bPu() || sightCaptureUI.oCM == null || sightCaptureUI.hGI || (sightCaptureUI.hGJ >= 0 && bo.az(sightCaptureUI.hGJ) > 300))) {
            sightCaptureUI.hGI = true;
            if (sightCaptureUI.oCA != null && sightCaptureUI.oCk) {
                sightCaptureUI.oCA.setVisibility(8);
            }
            sightCaptureUI.updateState(7);
            sightCaptureUI.oCn.setTouchEnable(false);
            sightCaptureUI.oCP = sightCaptureUI.oCM.isLandscape();
            sightCaptureUI.oCK = null;
            sightCaptureUI.oCL = -1;
            sightCaptureUI.oCl.a(new e.b() {
                public final void a(byte[] bArr, int i, int i2, int i3, int i4) {
                    AppMethodBeat.i(55190);
                    if (bArr == null || i < 0 || i2 < 0 || i3 < 0) {
                        ab.e("MicroMsg.SightCaptureUI", "onPictureYuvTaken, data is null!!");
                        SightCaptureUI.this.hGI = false;
                        AppMethodBeat.o(55190);
                        return;
                    }
                    int i5;
                    ab.i("MicroMsg.SightCaptureUI", "data frameWidth %s frameHeight %s rotate %s deviceDegree %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
                    SightCaptureUI.A(SightCaptureUI.this);
                    SightCaptureUI.B(SightCaptureUI.this);
                    SightCaptureUI.this.oCG = i;
                    SightCaptureUI.this.oCH = i2;
                    SightCaptureUI.this.oCI = i3;
                    SightCaptureUI.this.oCJ = i4;
                    if (SightCaptureUI.this.oCF != null) {
                        com.tencent.mm.plugin.mmsight.model.a.j.owk.g(SightCaptureUI.this.oCF);
                        SightCaptureUI.this.oCF = null;
                    }
                    SightCaptureUI.this.oCF = com.tencent.mm.plugin.mmsight.model.a.j.owk.g(Integer.valueOf(bArr.length));
                    System.arraycopy(bArr, 0, SightCaptureUI.this.oCF, 0, bArr.length);
                    SightCaptureUI.this.oCS = com.tencent.mm.sdk.g.d.h(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(55188);
                            SightCaptureUI.D(SightCaptureUI.this);
                            AppMethodBeat.o(55188);
                        }
                    }, "SightCaptureUI_saveCaptureBitmap");
                    SightCaptureUI.this.oCS.start();
                    com.tencent.mm.plugin.mmsight.model.k.d(true, com.tencent.mm.plugin.mmsight.d.RN("TIME_RECODER_2_PLAY"));
                    if (SightCaptureUI.this.oCP) {
                        if (Math.abs(i3 - i4) == 0) {
                            i5 = 180;
                        } else {
                            i5 = 0;
                        }
                        bArr = com.tencent.mm.plugin.mmsight.d.c(bArr, i, i2, i5 % v2helper.VOIP_ENC_HEIGHT_LV1);
                        SightCaptureUI.this.oCz.a(bArr, true, 0);
                    } else {
                        if (i4 == 180) {
                            i5 = i3 + i4;
                        } else {
                            i5 = i3;
                        }
                        if (i5 > v2helper.VOIP_ENC_HEIGHT_LV1) {
                            i5 -= 360;
                        }
                        SightCaptureUI.this.oCz.a(bArr, false, i5);
                    }
                    SightCaptureUI.this.oCK = bArr;
                    SightCaptureUI.this.oCL = i5;
                    SightCaptureUI.g(SightCaptureUI.this, 3);
                    SightCaptureUI.this.oCo.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(55189);
                            SightCaptureUI.G(SightCaptureUI.this);
                            AppMethodBeat.o(55189);
                        }
                    });
                    if (SightCaptureUI.this.owm.scene == 1 || SightCaptureUI.this.owm.scene == 2 || SightCaptureUI.this.owm.scene == 7) {
                        h.pYm.e(13819, Integer.valueOf(1), Integer.valueOf(SightCaptureUI.this.owm.scene), SightCaptureUI.this.owm.osR, Long.valueOf(bo.anT()));
                    }
                    AppMethodBeat.o(55190);
                }
            }, sightCaptureUI.oCP, sightCaptureUI.oCM.getOrientation());
            sightCaptureUI.hGJ = bo.yz();
        }
        AppMethodBeat.o(55261);
    }

    static /* synthetic */ void t(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.i(55264);
        if (sightCaptureUI.owm.scene == 1 || sightCaptureUI.owm.scene == 2 || sightCaptureUI.owm.scene == 7) {
            int i = sightCaptureUI.oCN ? sightCaptureUI.oCO ? 2 : 1 : 0;
            h.pYm.e(13820, Integer.valueOf(i), Integer.valueOf(sightCaptureUI.owm.scene), sightCaptureUI.owm.osR, Long.valueOf(bo.anT()));
        }
        if (sightCaptureUI.owm != null && sightCaptureUI.oCU) {
            com.tencent.mm.plugin.mmsight.a.a.a(new com.tencent.mm.plugin.mmsight.a.a.a(sightCaptureUI.owm.scene));
        }
        Intent intent = new Intent();
        String filePath = sightCaptureUI.gLs.getFilePath();
        String WO = com.tencent.mm.plugin.sight.base.d.WO(filePath);
        if (sightCaptureUI.owm.osQ) {
            sightCaptureUI.aU(filePath, false);
        }
        if (com.tencent.mm.plugin.mmsight.model.a.bPi() != null) {
            sightCaptureUI.oCE.wDS = com.tencent.mm.plugin.mmsight.model.a.bPi().bPj();
        }
        int WM = sightCaptureUI.gLs.WM();
        if (sightCaptureUI.oCU) {
            com.tencent.mm.plugin.sight.base.a WR = com.tencent.mm.plugin.sight.base.d.WR(sightCaptureUI.gLs.getFilePath());
            if (WR != null) {
                WM = Math.round(((float) WR.eWK) / 1000.0f);
            }
        }
        intent.putExtra("key_req_result", new SightCaptureResult(sightCaptureUI.oCl.bPv(), filePath, WO, sightCaptureUI.gLs.getFileName(), sightCaptureUI.cMW, WM, sightCaptureUI.oCE));
        intent.putExtra("KSessionID", sightCaptureUI.owm.osR);
        intent.putExtra("latitude", sightCaptureUI.getIntent().getDoubleExtra("album_business_bubble_media_by_coordinate_latitude", 181.0d));
        intent.putExtra("longitude", sightCaptureUI.getIntent().getDoubleExtra("album_business_bubble_media_by_coordinate_longitude", 91.0d));
        sightCaptureUI.setResult(-1, intent);
        sightCaptureUI.finish();
        AppMethodBeat.o(55264);
    }

    static /* synthetic */ void u(SightCaptureUI sightCaptureUI) {
        Object obj;
        AppMethodBeat.i(55265);
        if (sightCaptureUI.oCS != null && sightCaptureUI.oCS.isAlive()) {
            try {
                sightCaptureUI.oCS.join();
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.SightCaptureUI", e, "wait saveCaptureImageThread error: %s", e.getMessage());
            }
        }
        if (sightCaptureUI.owm.scene == 1 || sightCaptureUI.owm.scene == 2 || sightCaptureUI.owm.scene == 7) {
            int i = 0;
            if (sightCaptureUI.oCN) {
                i = 1;
            }
            h.pYm.e(13820, Integer.valueOf(i), Integer.valueOf(sightCaptureUI.owm.scene), sightCaptureUI.owm.osR, Long.valueOf(bo.anT()));
        }
        if (sightCaptureUI.owm.scene == 1) {
            h.pYm.e(13858, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0));
        } else if (sightCaptureUI.owm.scene == 2) {
            h.pYm.e(13858, Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0));
        }
        Intent intent = new Intent();
        if (bo.isNullOrNil(sightCaptureUI.oDb) || sightCaptureUI.gLs == null || !sightCaptureUI.oDb.equals(sightCaptureUI.gLs.WI())) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null && sightCaptureUI.owm.osQ) {
            ab.i("MicroMsg.SightCaptureUI", "is not Photo editted!");
            sightCaptureUI.aU(sightCaptureUI.gLs.WI(), true);
        }
        intent.putExtra("key_req_result", new SightCaptureResult(sightCaptureUI.oCl.bPv(), sightCaptureUI.gLs.WI()));
        intent.putExtra("KSessionID", sightCaptureUI.owm.osR);
        intent.putExtra("latitude", sightCaptureUI.getIntent().getDoubleExtra("album_business_bubble_media_by_coordinate_latitude", 181.0d));
        intent.putExtra("longitude", sightCaptureUI.getIntent().getDoubleExtra("album_business_bubble_media_by_coordinate_longitude", 91.0d));
        sightCaptureUI.setResult(-1, intent);
        Bundle bundle = sightCaptureUI.oDd;
        if (bundle == null) {
            ab.e("MicroMsg.SightCaptureUI", "[reportPhotoEdit] date == null");
        } else if (sightCaptureUI.oDc) {
            int i2 = bundle.getInt("report_info_emotion_count");
            int i3 = bundle.getInt("report_info_text_count");
            int i4 = bundle.getInt("report_info_mosaic_count");
            int i5 = bundle.getInt("report_info_doodle_count");
            boolean z = bundle.getBoolean("report_info_iscrop");
            int i6 = bundle.getInt("report_info_undo_count");
            boolean z2 = bundle.getBoolean("report_info_is_rotation");
            String str = "MicroMsg.SightCaptureUI";
            String str2 = "[reportPhotoEdit] emojiCount:%s,textCount:%s,mosaicCount:%s,penCount:%s,isCrop:%s,undoCount:%s,isRotation:%s";
            Object[] objArr = new Object[7];
            objArr[0] = Integer.valueOf(i2);
            objArr[1] = Integer.valueOf(i3);
            objArr[2] = Integer.valueOf(i4);
            objArr[3] = Integer.valueOf(i5);
            objArr[4] = Integer.valueOf(z ? 1 : 0);
            objArr[5] = Integer.valueOf(i6);
            objArr[6] = Boolean.valueOf(z2);
            ab.i(str, str2, objArr);
            h hVar = h.pYm;
            objArr = new Object[12];
            objArr[0] = Integer.valueOf(1);
            objArr[1] = Integer.valueOf(1);
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = Integer.valueOf(i3);
            objArr[4] = Integer.valueOf(i4);
            objArr[5] = Integer.valueOf(i5);
            objArr[6] = Integer.valueOf(z ? 1 : 0);
            objArr[7] = Integer.valueOf(i6);
            objArr[8] = Integer.valueOf(3);
            objArr[9] = Integer.valueOf(z2 ? 1 : 0);
            objArr[10] = sightCaptureUI.owm.osR;
            objArr[11] = Long.valueOf(bo.anT());
            hVar.e(13857, objArr);
        } else {
            ab.i("MicroMsg.SightCaptureUI", "[reportPhotoEdit] reportPhotoEdit == false");
        }
        sightCaptureUI.finish();
        AppMethodBeat.o(55265);
    }

    static /* synthetic */ void A(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.i(55268);
        ab.i("MicroMsg.SightCaptureUI", "setRevertAndSendBtnPos");
        if (sightCaptureUI.oCt.getVisibility() == 8) {
            sightCaptureUI.lmm.setVisibility(8);
        } else {
            sightCaptureUI.lmm.setVisibility(0);
        }
        Point eu = com.tencent.mm.plugin.mmsight.d.eu(sightCaptureUI);
        int dimensionPixelSize = sightCaptureUI.getResources().getDimensionPixelSize(R.dimen.a65);
        int dimensionPixelSize2 = sightCaptureUI.getResources().getDimensionPixelSize(R.dimen.a67);
        sightCaptureUI.oCn.getX();
        sightCaptureUI.oCo.setTranslationX(((((float) eu.x) / 2.0f) - ((float) dimensionPixelSize2)) - (((float) dimensionPixelSize) / 2.0f));
        sightCaptureUI.nPr.setTranslationX(((((float) (-eu.x)) / 2.0f) + ((float) dimensionPixelSize2)) + (((float) dimensionPixelSize) / 2.0f));
        sightCaptureUI.oCo.setEnabled(false);
        sightCaptureUI.nPr.setEnabled(false);
        AppMethodBeat.o(55268);
    }

    static /* synthetic */ void D(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.i(55270);
        if (bo.cb(sightCaptureUI.oCF) || sightCaptureUI.oCH <= 0 || sightCaptureUI.oCG <= 0) {
            ab.e("MicroMsg.SightCaptureUI", "saveCaptureYuvDataToBitmap error");
        } else {
            try {
                Bitmap b;
                YuvImage yuvImage = new YuvImage(sightCaptureUI.oCF, 17, sightCaptureUI.oCG, sightCaptureUI.oCH, null);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                yuvImage.compressToJpeg(new Rect(0, 0, sightCaptureUI.oCG, sightCaptureUI.oCH), 100, byteArrayOutputStream);
                byte[] toByteArray = byteArrayOutputStream.toByteArray();
                Bitmap decodeByteArray = MMBitmapFactory.decodeByteArray(toByteArray, 0, toByteArray.length);
                if (!sightCaptureUI.oCP || sightCaptureUI.oCJ == 180) {
                    int i = sightCaptureUI.oCI;
                    if (sightCaptureUI.oCJ == 180) {
                        i += 180;
                        if (i > v2helper.VOIP_ENC_HEIGHT_LV1) {
                            i -= 360;
                        }
                    }
                    b = com.tencent.mm.sdk.platformtools.d.b(decodeByteArray, (float) i);
                    decodeByteArray.recycle();
                } else if (Math.abs(sightCaptureUI.oCI - sightCaptureUI.oCJ) == 0) {
                    b = com.tencent.mm.sdk.platformtools.d.b(decodeByteArray, 180.0f);
                    decodeByteArray.recycle();
                } else {
                    b = decodeByteArray;
                }
                try {
                    com.tencent.mm.sdk.platformtools.d.a(b, 90, CompressFormat.JPEG, sightCaptureUI.gLs.WI(), false);
                    ab.i("MicroMsg.SightCaptureUI", "bitmap filelen %s", Long.valueOf(com.tencent.mm.vfs.e.asZ(r1)));
                } catch (Exception e) {
                    ab.e("MicroMsg.SightCaptureUI", "error for saveBitmapToImage %s", e.getMessage());
                }
                com.tencent.mm.plugin.mmsight.model.a.j.owk.g(sightCaptureUI.oCF);
                sightCaptureUI.oCH = 0;
                sightCaptureUI.oCG = 0;
                sightCaptureUI.oCJ = 0;
                sightCaptureUI.oCI = 0;
                sightCaptureUI.oCF = null;
            } catch (Exception e2) {
                ab.printErrStackTrace("MicroMsg.SightCaptureUI", e2, "saveCaptureYuvDataToBitmap error: %s", e2.getMessage());
            }
        }
        sightCaptureUI.hGI = false;
        AppMethodBeat.o(55270);
    }

    static /* synthetic */ void G(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.i(55272);
        sightCaptureUI.oCo.animate().translationX(0.0f).setDuration(200).setListener(new AnimatorListenerAdapter() {
            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(55207);
                SightCaptureUI.this.oCo.setEnabled(true);
                AppMethodBeat.o(55207);
            }

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(55208);
                SightCaptureUI.this.oCo.setEnabled(false);
                AppMethodBeat.o(55208);
            }
        }).start();
        sightCaptureUI.nPr.animate().translationX(0.0f).setDuration(200).setListener(new AnimatorListenerAdapter() {
            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(55209);
                SightCaptureUI.this.nPr.setEnabled(true);
                AppMethodBeat.o(55209);
            }

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(55210);
                SightCaptureUI.this.nPr.setEnabled(false);
                AppMethodBeat.o(55210);
            }
        }).start();
        AppMethodBeat.o(55272);
    }

    static /* synthetic */ void L(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.i(55275);
        i.R(new Runnable() {
            public final void run() {
                AppMethodBeat.i(55197);
                String RK = com.tencent.mm.plugin.mmsight.d.RK(SightCaptureUI.this.gLs.getFilePath());
                if (bo.isNullOrNil(RK)) {
                    AppMethodBeat.o(55197);
                    return;
                }
                RK = ((RK + IOUtils.LINE_SEPARATOR_UNIX + String.format("FPS: %s", new Object[]{Float.valueOf(SightCaptureUI.this.gLs.WJ())})) + IOUtils.LINE_SEPARATOR_UNIX + String.format("TIME_RECODER_2_PLAY: %s", new Object[]{Long.valueOf(com.tencent.mm.plugin.mmsight.d.RN("TIME_RECODER_2_PLAY"))})) + IOUtils.LINE_SEPARATOR_UNIX + String.format("CPU: cur %s max:%s", new Object[]{m.Lz(), m.Lx()});
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(55196);
                        ab.i("MicroMsg.SightCaptureUI", "DEBUG showDebugInfo %s", RK);
                        k.bPR();
                        if (k.isDebug()) {
                            TextView textView = (TextView) SightCaptureUI.this.findViewById(R.id.a4k);
                            textView.setVisibility(0);
                            textView.setText(RK);
                            AppMethodBeat.o(55196);
                            return;
                        }
                        AppMethodBeat.o(55196);
                    }
                });
                AppMethodBeat.o(55197);
            }
        });
        AppMethodBeat.o(55275);
    }

    static /* synthetic */ void M(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.i(55276);
        ab.i("MicroMsg.SightCaptureUI", "start preview");
        if (sightCaptureUI.gar != null) {
            sightCaptureUI.gar.requestFocus();
        }
        sightCaptureUI.oxL.setVisibility(0);
        sightCaptureUI.oxL.setAlpha(0.0f);
        sightCaptureUI.oxL.setVideoPath(sightCaptureUI.gLs.getFilePath());
        sightCaptureUI.oxL.setLoop(true);
        sightCaptureUI.oxL.setForceScaleFullScreen(true);
        sightCaptureUI.oxL.setVideoCallback(sightCaptureUI.oxS);
        AppMethodBeat.o(55276);
    }

    static /* synthetic */ void O(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.i(55277);
        if (sightCaptureUI.hGH == 1 || sightCaptureUI.hGH == 2) {
            String bPo = sightCaptureUI.oCl.bPo();
            if (!bo.isNullOrNil(bPo)) {
                StringBuilder append = new StringBuilder().append(bPo + IOUtils.LINE_SEPARATOR_UNIX + String.format("CPU: cur %s max:%s", new Object[]{m.Lz(), m.Lx()})).append(IOUtils.LINE_SEPARATOR_UNIX);
                Object[] objArr = new Object[1];
                k.bPR();
                objArr[0] = k.bPV();
                bPo = append.append(String.format("RecorderType %s", objArr)).toString() + IOUtils.LINE_SEPARATOR_UNIX + String.format("MemoryClass: %sMB, TotalMem: %sMB", new Object[]{Integer.valueOf(((ActivityManager) ah.getContext().getSystemService("activity")).getLargeMemoryClass()), Integer.valueOf(com.tencent.mm.plugin.mmsight.d.ev(sightCaptureUI))});
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(55200);
                        ab.i("MicroMsg.SightCaptureUI", "DEBUG showCameraInfoImpl: %s", bPo);
                        k.bPR();
                        if (k.isDebug()) {
                            TextView textView = (TextView) SightCaptureUI.this.findViewById(R.id.a4k);
                            textView.setVisibility(0);
                            textView.setText(bPo);
                            AppMethodBeat.o(55200);
                            return;
                        }
                        AppMethodBeat.o(55200);
                    }
                });
            }
        }
        AppMethodBeat.o(55277);
    }

    static /* synthetic */ void V(SightCaptureUI sightCaptureUI) {
        AppMethodBeat.i(55278);
        try {
            Bitmap tv = com.tencent.mm.plugin.mmsight.d.tv(sightCaptureUI.gLs.getFilePath());
            if (!(tv == null || sightCaptureUI.fcY == null || Math.min(tv.getWidth(), tv.getHeight()) <= sightCaptureUI.fcY.fAf)) {
                int width = tv.getWidth();
                int height = tv.getHeight();
                int i = sightCaptureUI.fcY.fAf > 0 ? sightCaptureUI.fcY.fAf : sightCaptureUI.fcY.width;
                if (width < height) {
                    width = (int) (((float) height) / ((((float) width) * 1.0f) / ((float) i)));
                    height = i;
                } else {
                    height = (int) (((float) width) / ((((float) height) * 1.0f) / ((float) i)));
                    width = i;
                }
                com.tencent.mm.sdk.platformtools.d.a(Bitmap.createScaledBitmap(tv, height, width, true), 60, CompressFormat.JPEG, sightCaptureUI.gLs.Wy(), true);
            }
            AppMethodBeat.o(55278);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.SightCaptureUI", e, "saveNewThumbAfterEdit error: %s", e.getMessage());
            AppMethodBeat.o(55278);
        }
    }
}
