package com.tencent.mm.plugin.facedetect.ui;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Process;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenAdCanvas;
import com.tencent.mm.plugin.appbrand.jsapi.aj;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiCancelDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.audio.m;
import com.tencent.mm.plugin.appbrand.jsapi.p.e;
import com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShowUpdatableMessageSubscribeButton;
import com.tencent.mm.plugin.appbrand.jsapi.share.k;
import com.tencent.mm.plugin.appbrand.jsapi.storage.j;
import com.tencent.mm.plugin.appbrand.jsapi.video.g;
import com.tencent.mm.plugin.facedetect.c.f;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.h;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.mm.plugin.facedetect.views.FaceDetectDecorView;
import com.tencent.mm.plugin.facedetect.views.FaceDetectView;
import com.tencent.mm.plugin.facedetect.views.FaceScanRect;
import com.tencent.mm.plugin.facedetect.views.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(3)
public class FaceDetectUI extends MMActivity implements f, com.tencent.mm.plugin.facedetect.views.a {
    private String edV = null;
    private int lSf = -1;
    private com.tencent.mm.plugin.facedetect.c.a lWT = null;
    private a lWU = null;
    private FaceTutorial lWV = null;
    private b lXA = null;
    private boolean lXB = false;
    private boolean lXC = false;
    private View lXD = null;
    private RelativeLayout lXE;
    FaceDetectView lXF = null;
    FaceScanRect lXG = null;
    private TextView lXH = null;
    private Button lXI = null;
    private FaceDetectProcessService lXJ = null;
    private ServiceConnection lXK = null;
    private boolean lXL = false;
    private boolean lXM = false;
    private c lXN = null;
    private String lXd;
    h lXz = null;
    boolean lsZ = false;
    private WakeLock wakeLock = null;

    class b {
        private boolean lXU;
        boolean lXV;
        private boolean lXW;
        private final boolean lXX;

        private b() {
            this.lXU = true;
            this.lXV = false;
            this.lXW = true;
            this.lXX = true;
        }

        /* synthetic */ b(FaceDetectUI faceDetectUI, byte b) {
            this();
        }

        public final synchronized void btu() {
            this.lXV = true;
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        public final synchronized void reset() {
            this.lXV = false;
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        public final synchronized void btv() {
            AppMethodBeat.i(471);
            ab.i("MicroMsg.FaceDetectUI", "toString: %s", toString());
            if (this.lXU && this.lXV && this.lXW) {
                FaceDetectUI.this.lXE.setVisibility(0);
            }
            AppMethodBeat.o(471);
        }

        public final String toString() {
            AppMethodBeat.i(e.CTRL_INDEX);
            String str = "InitHandler{isCgiInitDone=" + this.lXU + ", isCameraInitDone=" + this.lXV + ", isLightInitDone=true, isLibraryInitDone=" + this.lXW + '}';
            AppMethodBeat.o(e.CTRL_INDEX);
            return str;
        }
    }

    interface a {
        void onFinish();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(FaceDetectUI faceDetectUI) {
        AppMethodBeat.i(494);
        faceDetectUI.bth();
        AppMethodBeat.o(494);
    }

    static /* synthetic */ void l(FaceDetectUI faceDetectUI) {
        AppMethodBeat.i(j.CTRL_INDEX);
        faceDetectUI.btq();
        AppMethodBeat.o(j.CTRL_INDEX);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(473);
        super.onCreate(bundle);
        getWindow().addFlags(2097280);
        this.edV = getIntent().getStringExtra("k_user_name");
        this.lSf = getIntent().getIntExtra("k_server_scene", -1);
        this.lXd = getIntent().getStringExtra("business_tips");
        FaceDetectReporter faceDetectReporter = (FaceDetectReporter) getIntent().getBundleExtra("key_reporter_bundle").getParcelable("key_parcelable_reporter");
        if (faceDetectReporter != null) {
            FaceDetectReporter.bsJ().a(faceDetectReporter);
        }
        com.tencent.mm.plugin.facedetect.c.b bVar = com.tencent.mm.plugin.facedetect.c.b.lTj;
        this.lWT = com.tencent.mm.plugin.facedetect.c.b.a(this, this, this.lSf, 0, getIntent().getExtras());
        p.N(this);
        this.lXI = (Button) findViewById(R.id.bn8);
        this.lXI.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(FacebookRequestErrorClassification.ESC_APP_NOT_INSTALLED);
                ab.i("MicroMsg.FaceDetectUI", "hy: user cancelled with left button");
                FaceDetectUI.a(FaceDetectUI.this);
                AppMethodBeat.o(FacebookRequestErrorClassification.ESC_APP_NOT_INSTALLED);
            }
        });
        this.lXD = findViewById(R.id.bn5);
        this.lXD.setVisibility(8);
        this.lXE = (RelativeLayout) findViewById(R.id.bn7);
        this.lXG = (FaceScanRect) findViewById(R.id.bn9);
        this.lXF = (FaceDetectView) findViewById(R.id.bn6);
        this.lXH = (TextView) findViewById(R.id.bn_);
        this.lXF.setCallback(this);
        this.lXF.setBusinessTip(this.lXd);
        FaceDetectView faceDetectView = this.lXF;
        RelativeLayout relativeLayout = this.lXE;
        ViewGroup centerHintHolder = this.lXG.getCenterHintHolder();
        faceDetectView.maC = relativeLayout;
        faceDetectView.maD = centerHintHolder;
        this.lXF.setErrTextView(this.lXH);
        this.lXF.m(true, this.edV);
        this.lXG.setOnRefreshRectListener(new com.tencent.mm.plugin.facedetect.views.FaceScanRect.b() {
            public final void btt() {
                AppMethodBeat.i(460);
                FaceDetectView c = FaceDetectUI.this.lXF;
                RectF rectF = new RectF((float) FaceDetectUI.this.lXG.getLeft(), (float) FaceDetectUI.this.lXG.getTop(), (float) FaceDetectUI.this.lXG.getRight(), (float) FaceDetectUI.this.lXG.getBottom());
                FaceDetectDecorView faceDetectDecorView = c.maB;
                faceDetectDecorView.mav = true;
                faceDetectDecorView.maw = true;
                faceDetectDecorView.may = rectF;
                faceDetectDecorView.invalidate();
                AppMethodBeat.o(460);
            }
        });
        this.lXG.setVisibility(4);
        this.lXA = new b(this, (byte) 0);
        AppMethodBeat.o(473);
    }

    private void boF() {
        AppMethodBeat.i(JsApiAddDownloadTask.CTRL_INDEX);
        ab.i("MicroMsg.FaceDetectUI", "alvinluo unbindService, mBound: %b", Boolean.valueOf(this.lXL));
        if (this.lXL) {
            ab.i("MicroMsg.FaceDetectUI", "alvinluo unbindService");
            d.a(this.lXK, "tools");
            this.lXL = false;
        }
        AppMethodBeat.o(JsApiAddDownloadTask.CTRL_INDEX);
    }

    public final void bsp() {
    }

    public void onStart() {
        AppMethodBeat.i(JsApiCancelDownloadTask.CTRL_INDEX);
        super.onStart();
        ab.i("MicroMsg.FaceDetectUI", "alvinluo onStart");
        if (this.wakeLock == null) {
            this.wakeLock = ((PowerManager) getSystemService("power")).newWakeLock(10, "Scan Lock");
        }
        if (!this.wakeLock.isHeld()) {
            ab.i("MicroMsg.FaceDetectUI", "alvinluo acquire wakeLock");
            this.wakeLock.acquire();
        }
        Intent intent = new Intent(this, FaceDetectProcessService.class);
        intent.putExtra("key_face_service_connection_from", 2);
        this.lXK = new ServiceConnection() {
            public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                AppMethodBeat.i(461);
                ab.i("MicroMsg.FaceDetectUI", "alvinluo service connected %s", componentName);
                FaceDetectUI.this.lXL = true;
                FaceDetectUI.this.lXJ = FaceDetectProcessService.this;
                com.tencent.mm.plugin.facedetect.model.f fVar = com.tencent.mm.plugin.facedetect.model.f.lTL;
                FaceDetectProcessService d = FaceDetectUI.this.lXJ;
                ab.i("MicroMsg.FaceDetectManager", "alvinluo bindService process name: %s, hashCode: %d", bo.aw(ah.getContext(), Process.myPid()), Integer.valueOf(fVar.hashCode()));
                fVar.lTM = d;
                ab.i("MicroMsg.FaceDetectUI", "alvinluo FaceDetectUI service hashCode: %d", Integer.valueOf(FaceDetectUI.this.lXJ.hashCode()));
                FaceDetectUI.e(FaceDetectUI.this);
                AppMethodBeat.o(461);
            }

            public final void onServiceDisconnected(ComponentName componentName) {
                AppMethodBeat.i(462);
                ab.i("MicroMsg.FaceDetectUI", "alvinluo service disconnected %s", componentName.toString());
                FaceDetectUI.this.lXL = false;
                AppMethodBeat.o(462);
            }
        };
        ab.i("MicroMsg.FaceDetectUI", "alvinluo bindService");
        d.a(intent, this.lXK, "tools");
        AppMethodBeat.o(JsApiCancelDownloadTask.CTRL_INDEX);
    }

    public void onStop() {
        AppMethodBeat.i(JsApiOpenAdCanvas.CTRL_INDEX);
        super.onStop();
        ab.i("MicroMsg.FaceDetectUI", "hy: onStop, finish");
        boF();
        if (this.lXM) {
            finish();
            AppMethodBeat.o(JsApiOpenAdCanvas.CTRL_INDEX);
            return;
        }
        a(1, 90006, "cancel with on stop", null);
        AppMethodBeat.o(JsApiOpenAdCanvas.CTRL_INDEX);
    }

    public final int getLayoutId() {
        return R.layout.xj;
    }

    public final void bsk() {
        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX);
        ab.i("MicroMsg.FaceDetectUI", "alvinluo startFaceDetect ");
        LayoutParams attributes = getWindow().getAttributes();
        if (attributes.screenBrightness < 0.9f) {
            attributes.screenBrightness = 0.9f;
            getWindow().setAttributes(attributes);
        }
        this.lXG.mbN = com.tencent.mm.plugin.facedetect.views.FaceScanRect.a.INIT;
        FaceScanRect faceScanRect = this.lXG;
        if (faceScanRect.mbN == com.tencent.mm.plugin.facedetect.views.FaceScanRect.a.OPENED) {
            ab.w("MicroMsg.FaceScanRect", "hy: already opened");
        } else {
            faceScanRect.mbM.setVisibility(0);
            faceScanRect.mbv.setBackgroundResource(R.drawable.b3u);
            faceScanRect.mbM.startAnimation(faceScanRect.mbJ);
            for (View view : faceScanRect.mbE) {
                view.clearAnimation();
                view.setBackgroundColor(faceScanRect.getResources().getColor(R.color.a69));
            }
            faceScanRect.mbN = com.tencent.mm.plugin.facedetect.views.FaceScanRect.a.OPENED;
        }
        this.lXF.maB.mau = false;
        this.lXG.setVisibility(0);
        ab.d("MicroMsg.FaceDetectUI", "alvinluo %d, %d, %d, %d", Integer.valueOf(this.lXG.getTop()), Integer.valueOf(this.lXG.getRight()), Integer.valueOf(this.lXG.getLeft()), Integer.valueOf(this.lXG.getBottom()));
        this.lXB = true;
        this.lsZ = false;
        this.lXA.reset();
        if (this.lXB) {
            this.lXN = new c() {
                public final void vt(int i) {
                    AppMethodBeat.i(463);
                    ab.i("MicroMsg.FaceDetectUI", "alvinluo onPreviewInitDone: %d", Integer.valueOf(i));
                    if (i == 0) {
                        FaceDetectUI.f(FaceDetectUI.this);
                        AppMethodBeat.o(463);
                    } else if (i == 1) {
                        FaceDetectUI.g(FaceDetectUI.this);
                        AppMethodBeat.o(463);
                    } else {
                        if (i == 2) {
                            FaceDetectUI.a(FaceDetectUI.this, "camera permission not granted", FaceDetectUI.this.getString(R.string.dbs));
                        }
                        AppMethodBeat.o(463);
                    }
                }
            };
            ab.i("MicroMsg.FaceDetectUI", "hy: start preview");
            c cVar = this.lXN;
            FaceDetectView faceDetectView = this.lXF;
            faceDetectView.maA.a(new com.tencent.mm.plugin.facedetect.views.FaceDetectView.AnonymousClass4(cVar));
        }
        AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX);
    }

    public final void bsm() {
        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.bio.face.c.CTRL_INDEX);
        ab.i("MicroMsg.FaceDetectUI", "alvinluo releaseFaceDetect");
        if (!this.lXC) {
            this.lXN = null;
            this.lXC = true;
            if (this.lXA.lXV) {
                bts();
                this.lXF.maA.mae.btG();
            }
            if (this.wakeLock != null && this.wakeLock.isHeld()) {
                this.wakeLock.release();
                this.wakeLock = null;
            }
            com.tencent.mm.sdk.g.d.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(459);
                    long yz = bo.yz();
                    Runtime.getRuntime().gc();
                    ab.i("MicroMsg.FaceDetectUI", "hy: gc uses: %d ms", Long.valueOf(bo.az(yz)));
                    AppMethodBeat.o(459);
                }
            }, "Face_active_gc");
        }
        boF();
        AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.bio.face.c.CTRL_INDEX);
    }

    public final void a(int i, int i2, String str, Bundle bundle) {
        AppMethodBeat.i(479);
        ab.i("MicroMsg.FaceDetectUI", "finishWithResult errType: %d, errCode: %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i != 0 && i2 != 0 && com.tencent.mm.plugin.facedetect.e.a.btw().isStarted() && com.tencent.mm.plugin.facedetect.e.a.btw().lZc) {
            com.tencent.mm.plugin.facedetect.e.a.btw().bty();
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("key_parcelable_reporter", FaceDetectReporter.bsJ());
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        f(i, i2, str, bundle2);
        finish();
        AppMethodBeat.o(479);
    }

    /* Access modifiers changed, original: final */
    public final void btq() {
        AppMethodBeat.i(480);
        if (this.lsZ) {
            ab.i("MicroMsg.FaceDetectUI", "hy: start capture face");
            FaceDetectView faceDetectView = this.lXF;
            Rect rect = new Rect(this.lXG.getLeft(), this.lXG.getTop(), this.lXG.getRight(), this.lXG.getBottom());
            com.tencent.mm.plugin.facedetect.model.h.a bsI = h.bsI();
            if (bsI.type == 100) {
                AppMethodBeat.o(480);
                return;
            }
            if (faceDetectView.maF != null) {
                faceDetectView.maF.bsX();
            }
            faceDetectView.eTf = false;
            faceDetectView.isPaused = false;
            faceDetectView.maL = bo.yz();
            faceDetectView.maJ = bsI.lTV;
            faceDetectView.maI = bsI.gJH;
            ab.i("MicroMsg.FaceDetectView", "carson logic");
            ab.i("MicroMsg.FaceDetectView", "item.hintStr" + bsI.gJH);
            faceDetectView.lTW = bsI.lTW;
            faceDetectView.maG = true;
            faceDetectView.maK = bsI.lTZ;
            faceDetectView.maF = com.tencent.mm.plugin.facedetect.d.b.c.a(bsI);
            if (faceDetectView.maF != null) {
                if (faceDetectView.maC != null) {
                    faceDetectView.maC.removeAllViews();
                }
                if (faceDetectView.maD != null) {
                    faceDetectView.maD.removeAllViews();
                }
                faceDetectView.maF.a(faceDetectView.getContext(), faceDetectView.maC, faceDetectView.maD);
                ab.d("MicroMsg.FaceDetectView", "mBusinessTip : " + faceDetectView.lXd);
                faceDetectView.maF.setBusinessTip(faceDetectView.lXd);
            }
            if (faceDetectView.maA != null) {
                faceDetectView.maA.a(rect, bsI.lTT);
            }
            faceDetectView.maH = false;
        }
        AppMethodBeat.o(480);
    }

    private void stopPreview() {
        AppMethodBeat.i(m.CTRL_INDEX);
        this.lXB = false;
        this.lXF.maA.mae.stopPreview();
        ab.i("MicroMsg.FaceDetectUI", "hy: stopped preview");
        AppMethodBeat.o(m.CTRL_INDEX);
    }

    private void btr() {
        AppMethodBeat.i(482);
        this.lsZ = false;
        this.lXF.hc(false);
        ab.i("MicroMsg.FaceDetectUI", "hy: stopped scan");
        AppMethodBeat.o(482);
    }

    private void bts() {
        AppMethodBeat.i(g.CTRL_INDEX);
        btr();
        stopPreview();
        AppMethodBeat.o(g.CTRL_INDEX);
    }

    public final void a(boolean z, boolean z2, c cVar) {
        AppMethodBeat.i(484);
        if (z) {
            bts();
        }
        if (z2) {
            ab.i("MicroMsg.FaceDetectUI", "hy: need blur");
            final Bitmap previewBm = this.lXF.getPreviewBm();
            com.tencent.mm.sdk.g.d.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(aj.CTRL_INDEX);
                    ah.getContext();
                    final Bitmap n = p.n(FaceDetectUI.this.edV, previewBm);
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(JsApiShowUpdatableMessageSubscribeButton.CTRL_INDEX);
                            FaceDetectUI.this.lWU.M(n);
                            AppMethodBeat.o(JsApiShowUpdatableMessageSubscribeButton.CTRL_INDEX);
                        }
                    });
                    AppMethodBeat.o(aj.CTRL_INDEX);
                }
            }, "FaceDetectUI_BlurBgMap");
        }
        this.lWU.a(cVar);
        AppMethodBeat.o(484);
    }

    private void t(int i, String str, String str2) {
        AppMethodBeat.i(485);
        ab.i("MicroMsg.FaceDetectUI", "onProcessingError errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(4), Integer.valueOf(i), str);
        Bundle bundle = new Bundle();
        bundle.putString("show_err_msg", str2);
        bts();
        a(4, i, str, bundle);
        AppMethodBeat.o(485);
    }

    public final void d(int i, int i2, String str, Bundle bundle) {
    }

    public final void T(int i, String str) {
        boolean z = true;
        AppMethodBeat.i(486);
        ab.i("MicroMsg.FaceDetectUI", "hy: face detect result: %d", Integer.valueOf(i));
        if (!FaceCharacteristicsResult.vi(i)) {
            boolean z2;
            h hVar = this.lXz;
            if (hVar.lfO >= hVar.lTR - 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                ab.i("MicroMsg.FaceDetectUI", "hy: collect data ok");
                this.lXF.hc(true);
                final Bitmap previewBm = this.lXF.getPreviewBm();
                String str2 = "MicroMsg.FaceDetectUI";
                String str3 = "alvinluo bitmap == null: %b";
                Object[] objArr = new Object[1];
                if (previewBm != null) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                ab.i(str2, str3, objArr);
                final AnonymousClass9 anonymousClass9 = new a() {
                    public final void onFinish() {
                        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.audio.g.CTRL_INDEX);
                        ab.i("MicroMsg.FaceDetectUI", "alvinluo set result and return to FaceDetectPrepareUI");
                        FaceDetectUI.this.lXM = true;
                        FaceDetectUI.this.a(0, 0, "collect data ok", null);
                        AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.audio.g.CTRL_INDEX);
                    }
                };
                com.tencent.mm.sdk.g.d.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.h.a.a.CTRL_INDEX);
                        ah.getContext();
                        p.n(FaceDetectUI.this.edV, previewBm);
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.h.a.CTRL_INDEX);
                                if (anonymousClass9 != null) {
                                    anonymousClass9.onFinish();
                                }
                                AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.h.a.CTRL_INDEX);
                            }
                        });
                        AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.h.a.a.CTRL_INDEX);
                    }
                }, "save_face_bitmap");
                AppMethodBeat.o(486);
                return;
            }
            hVar = this.lXz;
            com.tencent.mm.plugin.facedetect.model.g gVar = com.tencent.mm.plugin.facedetect.model.f.lTL.lTM.lVR;
            if (gVar.lTP == null) {
                ab.e("MicroMsg.FaceDetectNativeManager", "hy: move to next motion no instance");
            } else {
                ab.i("MicroMsg.FaceDetectNativeManager", "hy: start move next motion");
                gVar.lTP.engineNextMotion();
            }
            hVar.lfO++;
            int i2 = h.bsI().type;
            ab.i("MicroMsg.FaceDetectUI", "hy: detect ok. start next: %d", Integer.valueOf(i2));
            if (h.bsI().lTY) {
                this.lXG.b(new AnimationListener() {
                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        AppMethodBeat.i(470);
                        FaceDetectUI.l(FaceDetectUI.this);
                        AppMethodBeat.o(470);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }
                });
                AppMethodBeat.o(486);
                return;
            }
            ab.i("MicroMsg.FaceDetectUI", "hy: detect ok. start next: %d", Integer.valueOf(i2));
            btq();
            AppMethodBeat.o(486);
        } else if (i == 3) {
            t(90017, "face detect time out", str);
            AppMethodBeat.o(486);
        } else if (i == 6 || i == 5) {
            t(90023, "face track failed or not stable", str);
            AppMethodBeat.o(486);
        } else if (i == 7) {
            t(90009, "audio permission not granted", ah.getContext().getString(R.string.dc0));
            AppMethodBeat.o(486);
        } else {
            t(90018, "system error", str);
            AppMethodBeat.o(486);
        }
    }

    public final void vs(int i) {
        AppMethodBeat.i(487);
        if (i == 1) {
            this.lXG.b(null);
        }
        AppMethodBeat.o(487);
    }

    private void bth() {
        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.p.f.CTRL_INDEX);
        ab.i("MicroMsg.FaceDetectUI", "alvinluo onUserCancel");
        com.tencent.mm.plugin.facedetect.d.b.b currentMotionCancelInfo = this.lXF.getCurrentMotionCancelInfo();
        a(1, currentMotionCancelInfo.errCode, currentMotionCancelInfo.aIm, null);
        AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.p.f.CTRL_INDEX);
    }

    private void f(int i, int i2, String str, Bundle bundle) {
        AppMethodBeat.i(489);
        setResult(-1, g(i, i2, str, bundle));
        AppMethodBeat.o(489);
    }

    private static Intent g(int i, int i2, String str, Bundle bundle) {
        AppMethodBeat.i(490);
        Bundle bundle2 = new Bundle();
        bundle2.putInt("err_type", i);
        bundle2.putInt("err_code", i2);
        bundle2.putString("err_msg", str);
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        Intent intent = new Intent();
        intent.putExtras(bundle2);
        AppMethodBeat.o(490);
        return intent;
    }

    public void onDestroy() {
        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.p.d.CTRL_INDEX);
        ab.i("MicroMsg.FaceDetectUI", "hy: current %d instance not destroyed", Integer.valueOf(hashCode()));
        super.onDestroy();
        AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.p.d.CTRL_INDEX);
    }

    public void finish() {
        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.g.f.CTRL_INDEX);
        ab.i("MicroMsg.FaceDetectUI", "alvinluo finish");
        if (this.lWU != null && this.lWU.aFF()) {
            this.lWU.dismiss();
        }
        if (this.lWV != null) {
            this.lWV.dismiss();
        }
        ab.i("MicroMsg.FaceDetectUI", "alvinluo FaceDetectUI release");
        bsm();
        super.finish();
        AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.g.f.CTRL_INDEX);
    }

    public void onBackPressed() {
        AppMethodBeat.i(FacebookRequestErrorClassification.ESC_APP_INACTIVE);
        ab.i("MicroMsg.FaceDetectUI", "alvinluo onBackPressed and cancel");
        bth();
        AppMethodBeat.o(FacebookRequestErrorClassification.ESC_APP_INACTIVE);
    }

    static /* synthetic */ void e(FaceDetectUI faceDetectUI) {
        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.bio.face.d.CTRL_INDEX);
        ab.i("MicroMsg.FaceDetectUI", "alvinluo start");
        faceDetectUI.bsk();
        AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.bio.face.d.CTRL_INDEX);
    }

    static /* synthetic */ void f(FaceDetectUI faceDetectUI) {
        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.storage.m.CTRL_INDEX);
        ab.v("MicroMsg.FaceDetectUI", "alvinluo onPreviewDone");
        if (com.tencent.mm.plugin.facedetect.e.a.btw().lZc) {
            com.tencent.mm.plugin.facedetect.e.a.btw().a(faceDetectUI.lXF.getCameraRotation(), faceDetectUI.lXF.getCameraPreivewWidth(), faceDetectUI.lXF.getCameraPreviewHeight(), faceDetectUI.lXF.getCameraBestWidth(), faceDetectUI.lXF.getCameraPreviewHeight(), true);
        }
        faceDetectUI.lXF.m(false, faceDetectUI.edV);
        al.n(new Runnable() {
            public final void run() {
                int i;
                int[] iArr = null;
                AppMethodBeat.i(k.CTRL_INDEX);
                ab.i("MicroMsg.FaceDetectUI", "alvinluo dismiss cover and start capture");
                FaceDetectUI.this.lXA.btu();
                FaceDetectUI.this.lXA.btv();
                FaceDetectUI faceDetectUI = FaceDetectUI.this;
                if (h.lTS == null) {
                    h.lTS = new h();
                }
                faceDetectUI.lXz = h.lTS;
                h hVar = faceDetectUI.lXz;
                hVar.lfO = 0;
                hVar.lTQ = null;
                hVar.lTR = -1;
                hVar = faceDetectUI.lXz;
                com.tencent.mm.plugin.facedetect.model.g gVar = com.tencent.mm.plugin.facedetect.model.f.lTL.lTM.lVR;
                if (gVar.lTP == null) {
                    ab.e("MicroMsg.FaceDetectNativeManager", "hy: get all motion not init");
                } else {
                    iArr = gVar.lTP.engineGetAllMotions();
                }
                hVar.lTQ = iArr;
                if (hVar.lTQ == null) {
                    i = 0;
                } else {
                    i = hVar.lTQ.length;
                }
                hVar.lTR = i;
                faceDetectUI.lsZ = true;
                FaceDetectView faceDetectView = faceDetectUI.lXF;
                RectF rectF = new RectF((float) faceDetectUI.lXG.getLeft(), (float) faceDetectUI.lXG.getTop(), (float) faceDetectUI.lXG.getRight(), (float) faceDetectUI.lXG.getBottom());
                FaceDetectDecorView faceDetectDecorView = faceDetectView.maB;
                String str = "MicroMsg.FaceDetectDecorView";
                String str2 = "hy: trigger showCover cover: %s, old: %s";
                Object[] objArr = new Object[2];
                objArr[0] = rectF.toString();
                objArr[1] = faceDetectDecorView.may == null ? BuildConfig.COMMAND : faceDetectDecorView.may.toString();
                ab.i(str, str2, objArr);
                faceDetectDecorView.mav = true;
                if (faceDetectDecorView.may == null || !faceDetectDecorView.may.equals(rectF)) {
                    faceDetectDecorView.may = rectF;
                    ab.i("MicroMsg.FaceDetectDecorView", "alvinluo invalidate %s", faceDetectDecorView.may.toString());
                    faceDetectDecorView.invalidate();
                }
                faceDetectUI.btq();
                AppMethodBeat.o(k.CTRL_INDEX);
            }
        }, 500);
        AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.storage.m.CTRL_INDEX);
    }

    static /* synthetic */ void g(FaceDetectUI faceDetectUI) {
        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.storage.d.CTRL_INDEX);
        faceDetectUI.t(90016, "preview error", faceDetectUI.getString(R.string.er5));
        AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.storage.d.CTRL_INDEX);
    }
}
