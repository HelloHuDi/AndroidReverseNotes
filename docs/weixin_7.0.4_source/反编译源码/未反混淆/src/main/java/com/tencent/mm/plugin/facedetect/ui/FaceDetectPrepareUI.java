package com.tencent.mm.plugin.facedetect.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiResumeDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiWriteCommData;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTaskStraight;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiGetInstallState;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiInstallDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiQueryDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.b.h;
import com.tencent.mm.plugin.appbrand.jsapi.z;
import com.tencent.mm.plugin.facedetect.b.d;
import com.tencent.mm.plugin.facedetect.c.f;
import com.tencent.mm.plugin.facedetect.model.FaceContextData;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.e;
import com.tencent.mm.plugin.facedetect.model.l;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.wcdb.FileUtils;
import com.tencent.wxmm.v2helper;
import java.lang.ref.WeakReference;

@com.tencent.mm.ui.base.a(3)
public class FaceDetectPrepareUI extends MMFragmentActivity implements android.support.v4.app.a.a, f {
    private boolean eTM = false;
    private boolean eVT = false;
    private String edV;
    private String lSK = null;
    private float lSM;
    private int lSf;
    private d lSg = null;
    private int lSq;
    private long lTH;
    private com.tencent.mm.plugin.facedetect.c.a lWT = null;
    private a lWU = null;
    private FaceTutorial lWV = null;
    private boolean lWW;
    private byte[] lWX;
    private boolean lWY = false;
    private boolean lWZ = false;
    private int lWs;
    private b lXa;
    private boolean lXb = false;
    private boolean lXc = false;
    private String lXd = null;
    private long lXe = -1;
    private Messenger lXf = null;
    private a lXg = null;
    private int lXh = -1;
    private boolean lXi = false;
    private com.tencent.mm.plugin.facedetectlight.Utils.a lXj;
    private RelativeLayout lXk;
    private boolean lXl = false;
    private int lXm = -1;
    private boolean lXn = false;
    private float lXo = 0.0f;
    private String mAppId;

    class b {
        String aIm;
        int errCode;
        int errType;
        Bundle extras;

        private b() {
        }

        /* synthetic */ b(FaceDetectPrepareUI faceDetectPrepareUI, byte b) {
            this();
        }

        /* Access modifiers changed, original: final */
        public final void e(int i, int i2, String str, Bundle bundle) {
            this.errType = i;
            this.errCode = i2;
            this.aIm = str;
            this.extras = bundle;
        }
    }

    static class a extends Handler {
        private WeakReference<FaceDetectPrepareUI> lWJ;

        /* synthetic */ a(FaceDetectPrepareUI faceDetectPrepareUI, byte b) {
            this(faceDetectPrepareUI);
        }

        private a(FaceDetectPrepareUI faceDetectPrepareUI) {
            AppMethodBeat.i(v2helper.EMethodSetSpkEnhance);
            this.lWJ = null;
            this.lWJ = new WeakReference(faceDetectPrepareUI);
            AppMethodBeat.o(v2helper.EMethodSetSpkEnhance);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(425);
            ab.i("MicroMsg.FaceDetectPrepareUI", "alvinluo client msg.what: %d", Integer.valueOf(message.what));
            if (!(this.lWJ == null || this.lWJ.get() == null)) {
                switch (message.what) {
                    case 0:
                        FaceDetectPrepareUI.a((FaceDetectPrepareUI) this.lWJ.get(), message);
                        AppMethodBeat.o(425);
                        return;
                    case 1:
                        FaceDetectPrepareUI.b((FaceDetectPrepareUI) this.lWJ.get(), message);
                        AppMethodBeat.o(425);
                        return;
                    case 6:
                        FaceDetectPrepareUI.c((FaceDetectPrepareUI) this.lWJ.get(), message);
                        break;
                }
            }
            AppMethodBeat.o(425);
        }
    }

    interface c {
        void p(int i, int i2, String str);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(FaceDetectPrepareUI faceDetectPrepareUI) {
        AppMethodBeat.i(455);
        faceDetectPrepareUI.btl();
        AppMethodBeat.o(455);
    }

    static /* synthetic */ void a(FaceDetectPrepareUI faceDetectPrepareUI, int i, int i2, String str, String str2) {
        AppMethodBeat.i(457);
        faceDetectPrepareUI.d(i, i2, str, str2);
        AppMethodBeat.o(457);
    }

    static /* synthetic */ int vr(int i) {
        if (i == 1 || i == 2) {
            return 3;
        }
        if (i == 4) {
            return 2;
        }
        if (i != 0) {
            return 4;
        }
        return i;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(v2helper.EMethodSetAgcRxOn);
        super.onCreate(bundle);
        setContentView((int) R.layout.xf);
        this.lXk = (RelativeLayout) findViewById(R.id.bmp);
        this.lXk.setVisibility(4);
        getWindow().addFlags(2097280);
        this.mAppId = getIntent().getStringExtra("k_app_id");
        this.edV = getIntent().getStringExtra("k_user_name");
        this.lSf = getIntent().getIntExtra("k_server_scene", -1);
        this.lWW = getIntent().getBooleanExtra("k_need_signature", false);
        boolean z = e.bsu() || getIntent().getBooleanExtra("key_is_need_video", false);
        this.lXb = z;
        this.lSK = getIntent().getStringExtra("key_feedback_url");
        this.lXd = getIntent().getStringExtra("business_tips");
        this.lWs = getIntent().getIntExtra("check_alive_type_response", -1);
        if (this.lWs == -1) {
            this.lWs = getIntent().getIntExtra("check_alive_type", 0);
        }
        this.lSM = getIntent().getFloatExtra("mLight_threshold", -1.0f);
        this.lXj = com.tencent.mm.plugin.facedetectlight.Utils.a.b.mdr;
        this.lXj.dM(this);
        ab.i("MicroMsg.FaceDetectPrepareUI", "mIsNeedVideo： " + this.lXb);
        ab.i("MicroMsg.FaceDetectPrepareUI", "check_alive_type is " + this.lWs);
        ab.i("MicroMsg.FaceDetectPrepareUI", "mLight_threshold is " + this.lSM);
        ab.i("MicroMsg.FaceDetectPrepareUI", "mChechLiveFlag is " + this.lSq);
        this.lXg = new a(this, (byte) 0);
        this.lXf = new Messenger(this.lXg);
        Intent intent = new Intent(this, FaceDetectProcessService.class);
        intent.putExtra("k_messenger", this.lXf);
        com.tencent.mm.bp.d.j(intent, "tools");
        FaceContextData.a(new FaceContextData());
        p.N(this);
        Bundle extras = getIntent().getExtras();
        float btS = this.lXj.btS();
        this.lXo = btS;
        if (extras != null) {
            extras.putFloat("key_current_light", btS);
            extras.putBoolean("key_upload_video", this.lXb);
        }
        com.tencent.mm.plugin.facedetect.c.b bVar = com.tencent.mm.plugin.facedetect.c.b.lTj;
        this.lWT = com.tencent.mm.plugin.facedetect.c.b.a(this, this, this.lSf, this.lSq, extras);
        if (this.lWT == null) {
            aDo();
        } else {
            this.lWT.a(new com.tencent.mm.plugin.facedetect.b.c() {
                public final void e(long j, byte[] bArr) {
                    AppMethodBeat.i(405);
                    ab.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onGetConfigSuccess, bioId: %d, isCancel: %b", Long.valueOf(j), Boolean.valueOf(FaceDetectPrepareUI.this.eVT));
                    if (FaceDetectPrepareUI.this.eVT) {
                        AppMethodBeat.o(405);
                        return;
                    }
                    FaceDetectPrepareUI.this.lTH = j;
                    FaceDetectPrepareUI.this.lWX = bArr;
                    FaceDetectPrepareUI.a(FaceDetectPrepareUI.this, j, bArr);
                    AppMethodBeat.o(405);
                }

                public final void aw(int i, String str) {
                    AppMethodBeat.i(406);
                    ab.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onGetConfigFailed, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(90015), str);
                    FaceDetectPrepareUI.a(FaceDetectPrepareUI.this, FaceDetectPrepareUI.vr(i), 90015, str, FaceDetectPrepareUI.this.getString(R.string.bkk));
                    AppMethodBeat.o(406);
                }
            });
            this.lSg = new d() {
                private double lXt = 0.0d;

                public final void w(double d) {
                    AppMethodBeat.i(407);
                    ab.i("MicroMsg.FaceDetectPrepareUI", "hy: reg on process : %f", Double.valueOf(d));
                    this.lXt = 100.0d * d;
                    if (FaceDetectPrepareUI.this.lWT != null) {
                        FaceDetectPrepareUI.this.lWT;
                    }
                    AppMethodBeat.o(407);
                }

                public final void a(int i, int i2, int i3, String str) {
                    AppMethodBeat.i(408);
                    ab.i("MicroMsg.FaceDetectPrepareUI", "onError scene: %d, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
                    FaceDetectPrepareUI.a(FaceDetectPrepareUI.this, i2, i3, str, FaceDetectPrepareUI.this.getString(R.string.er5));
                    AppMethodBeat.o(408);
                }

                public final void n(String str, Bundle bundle) {
                    AppMethodBeat.i(409);
                    ab.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onUploadEnd");
                    int vr = FaceDetectPrepareUI.vr(0);
                    if (vr != 0) {
                        FaceDetectPrepareUI.this.d(vr, 0, str, bundle);
                    }
                    if (FaceDetectPrepareUI.this.lWT != null) {
                        FaceDetectPrepareUI.this.lWT.b(vr, str, bundle);
                    }
                    AppMethodBeat.o(409);
                }

                public final void g(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(410);
                    ab.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onVerifyEnd sceneType: %d, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(mVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str);
                    int vr = FaceDetectPrepareUI.vr(i);
                    if (!(vr == 0 && i2 == 0)) {
                        FaceDetectPrepareUI.this.d(vr, i2, str, null);
                    }
                    if (FaceDetectPrepareUI.this.lWT != null) {
                        FaceDetectPrepareUI.this.lWT.g(vr, i2, str, mVar);
                    }
                    AppMethodBeat.o(410);
                }
            };
            this.lWT.a(this.lSg);
        }
        if (this.lXa != null) {
            b bVar2 = this.lXa;
            bVar2.errType = -1;
            bVar2.errCode = -1;
            bVar2.aIm = "";
            if (bVar2.extras != null) {
                bVar2.extras.clear();
            }
        }
        this.lWY = false;
        this.lXh = 1;
        btm();
        if (p.M(this)) {
            ab.i("MicroMsg.FaceDetectPrepareUI", "alvinluo checkFacePermissionAnd Request true and do init ");
            btj();
        } else {
            ab.i("MicroMsg.FaceDetectPrepareUI", "hy: no camera permission. request permission");
        }
        if (this.lXb) {
            extras = new Bundle();
            extras.putBoolean("key_is_need_video", this.lXb);
            m(4, extras);
        }
        AppMethodBeat.o(v2helper.EMethodSetAgcRxOn);
    }

    private void m(int i, Bundle bundle) {
        AppMethodBeat.i(v2helper.EMethodPcMicLevel);
        String str = "MicroMsg.FaceDetectPrepareUI";
        String str2 = "hy: sending msg: cmd: %d, data: %s";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = bundle != null ? bundle.toString() : BuildConfig.COMMAND;
        ab.i(str, str2, objArr);
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("k_cmd", i);
        Intent intent = new Intent(this, FaceDetectProcessService.class);
        intent.putExtras(bundle);
        com.tencent.mm.bp.d.j(intent, "tools");
        AppMethodBeat.o(v2helper.EMethodPcMicLevel);
    }

    private void btj() {
        AppMethodBeat.i(v2helper.EMethodSetIosMicAbCheckOn);
        if (this.lWT != null) {
            this.lWT.bsk();
        }
        AppMethodBeat.o(v2helper.EMethodSetIosMicAbCheckOn);
    }

    public final void bsk() {
        int i;
        AppMethodBeat.i(v2helper.EMethodSetIosMicAbCheckOff);
        ab.i("MicroMsg.FaceDetectPrepareUI", "alvinluo startFaceDetect");
        ab.i("MicroMsg.FaceDetectPrepareUI", "alvinluo preparing");
        if (this.lWT != null) {
            String string = getIntent().getExtras().getString("k_ticket");
            if (!bo.isNullOrNil(string)) {
                ab.i("MicroMsg.FaceDetectBaseController", "hy: has prepared ticket. force set");
                com.tencent.mm.plugin.facedetect.b.p.Lp(string);
            }
        }
        ab.i("MicroMsg.FaceDetectPrepareUI", "carson init jumper: %b", Boolean.valueOf(this.lXl));
        if (!this.lXl) {
            ab.i("MicroMsg.FaceDetectPrepareUI", "hy: start show jumper: %b", Boolean.TRUE);
            this.lXe = bo.yz();
            com.tencent.mm.sdk.g.d.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(v2helper.EMethodSetPlayerPreCorrectCofOn);
                    final Bitmap Lr = p.Lr(FaceDetectPrepareUI.this.edV);
                    final AnonymousClass1 anonymousClass1 = new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(418);
                            FaceDetectPrepareUI.a(FaceDetectPrepareUI.this, 90003, "user cancel in init");
                            AppMethodBeat.o(418);
                        }
                    };
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(419);
                            c a = a.a(FaceDetectPrepareUI.this, anonymousClass1);
                            a.lYE = Lr;
                            FaceDetectPrepareUI.this.a(false, false, a);
                            AppMethodBeat.o(419);
                        }
                    });
                    AppMethodBeat.o(v2helper.EMethodSetPlayerPreCorrectCofOn);
                }
            }, "face_prepareInit");
        }
        btk();
        switch (this.lXm) {
            case 0:
                i = 1;
                break;
            case 1:
                i = 2;
                break;
            default:
                i = 1;
                break;
        }
        if (this.lSf == 0 || this.lSf == 1 || this.lSf == 3 || this.lSf == 4) {
            i = 1;
        }
        this.lSq = i;
        if (this.lWT != null) {
            this.lWT.lTf = this.lSq;
            this.lWT.bsj();
        }
        this.lXi = true;
        AppMethodBeat.o(v2helper.EMethodSetIosMicAbCheckOff);
    }

    private void btk() {
        AppMethodBeat.i(430);
        switch (this.lWs) {
            case 0:
                this.lXm = 0;
                FaceDetectReporter.bsJ().lUv = 4;
                AppMethodBeat.o(430);
                return;
            case 1:
                this.lXm = 1;
                FaceDetectReporter.bsJ().lUv = 6;
                AppMethodBeat.o(430);
                return;
            case 2:
                float btS = this.lXj.btS();
                FaceDetectReporter.bsJ().lUw = Math.round(btS);
                ab.i("MicroMsg.FaceDetectPrepareUI", "curLux is : ".concat(String.valueOf(btS)));
                ab.i("MicroMsg.FaceDetectPrepareUI", "Light threshold is : " + this.lSM);
                if (btS < this.lSM) {
                    this.lXj.stop();
                    this.lXm = 1;
                    FaceDetectReporter.bsJ().lUv = 6;
                    AppMethodBeat.o(430);
                    return;
                }
                this.lXm = 0;
                FaceDetectReporter.bsJ().lUv = 4;
                AppMethodBeat.o(430);
                return;
            default:
                this.lXm = 0;
                AppMethodBeat.o(430);
                return;
        }
    }

    private void btl() {
        AppMethodBeat.i(431);
        this.lXh = 2;
        if (this.lWT != null) {
            this.lWT.vg(0);
        }
        Intent intent = new Intent(this, FaceDetectUI.class);
        intent.putExtra("k_user_name", this.edV);
        intent.putExtra("k_server_scene", this.lSf);
        intent.putExtra("k_need_signature", this.lWW);
        intent.putExtra("k_bio_id", String.valueOf(this.lTH));
        intent.putExtra("k_bio_config", this.lWX);
        intent.putExtra("business_tips", this.lXd);
        ab.i("MicroMsg.FaceDetectPrepareUI", "carson logic ");
        ab.i("MicroMsg.FaceDetectPrepareUI", "Config is " + this.lWX);
        ab.i("MicroMsg.FaceDetectPrepareUI", "Carson bioID is " + this.lTH + "  string：" + String.valueOf(this.lTH));
        ab.v("MicroMsg.FaceDetectPrepareUI", "alvinluo FaceDetectReporter info: %s", Long.valueOf(FaceDetectReporter.bsJ().hbj));
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_parcelable_reporter", FaceDetectReporter.bsJ());
        intent.putExtra("key_reporter_bundle", bundle);
        if (this.lWU != null) {
            this.lWU.resetAll();
        }
        startActivityForResult(intent, 1);
        AppMethodBeat.o(431);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        boolean z = false;
        AppMethodBeat.i(v2helper.EMethodSetSendToNetworkOn);
        ab.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onActivityResult requestCode: %d, resultCode: %d", Integer.valueOf(i), Integer.valueOf(i2));
        FaceDetectReporter faceDetectReporter;
        int intExtra;
        int intExtra2;
        String stringExtra;
        com.tencent.mm.plugin.facedetect.c.a aVar;
        String stringExtra2;
        if (i == 2) {
            this.lXh = 1;
            this.lXk.setVisibility(0);
            if (intent == null) {
                ab.e("MicroMsg.FaceDetectPrepareUI", "carson onActivityResult data is null");
                a(4, 90018, "system error", getString(R.string.bkz), false, new c() {
                    public final void p(int i, int i2, String str) {
                        AppMethodBeat.i(414);
                        if (FaceDetectPrepareUI.this.lWT != null) {
                            FaceDetectPrepareUI.this.lWT.c(i, i2, str, null);
                        }
                        AppMethodBeat.o(414);
                    }
                });
                AppMethodBeat.o(v2helper.EMethodSetSendToNetworkOn);
                return;
            }
            int i3;
            faceDetectReporter = (FaceDetectReporter) intent.getParcelableExtra("key_parcelable_reporter");
            if (faceDetectReporter != null) {
                FaceDetectReporter.bsJ().a(faceDetectReporter);
            }
            FaceDetectReporter bsJ = FaceDetectReporter.bsJ();
            if (this.lXb) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            bsJ.lUx = i3;
            FaceDetectReporter.bsJ().lUw = Math.round(this.lXo);
            intExtra = intent.getIntExtra("err_type", -1);
            intExtra2 = intent.getIntExtra("err_code", -1);
            stringExtra = intent.getStringExtra("err_msg");
            if (this.lWT != null) {
                aVar = this.lWT;
                intent.getExtras();
                aVar.n(intExtra, intExtra2, stringExtra);
            }
            ab.i("MicroMsg.FaceDetectPrepareUI", "carson onActivityResult errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(intExtra), Integer.valueOf(intExtra2), stringExtra);
            if (intExtra == 0 && intExtra2 == 0) {
                btn();
                m(6, intent.getExtras());
                AppMethodBeat.o(v2helper.EMethodSetSendToNetworkOn);
                return;
            }
            if (intExtra != 1) {
                stringExtra2 = intent.getStringExtra("show_err_msg");
                if (intExtra2 == 90013) {
                    stringExtra2 = getString(R.string.bkk);
                } else if (intExtra2 == 90008 || intExtra2 == 90010) {
                    stringExtra2 = getString(R.string.dbs);
                } else if (intExtra2 == 90009) {
                    stringExtra2 = getString(R.string.dc0);
                } else if (bo.isNullOrNil(stringExtra2)) {
                    stringExtra2 = getString(R.string.er5);
                }
                d(intExtra, intExtra2, stringExtra, null);
                if (intExtra2 == 90023) {
                    z = true;
                }
                a(intExtra, intExtra2, stringExtra, stringExtra2, z, new c() {
                    public final void p(int i, int i2, String str) {
                        AppMethodBeat.i(415);
                        if (FaceDetectPrepareUI.this.lWT != null) {
                            FaceDetectPrepareUI.this.lWT.c(i, i2, str, null);
                        }
                        AppMethodBeat.o(415);
                    }
                });
            } else if (intExtra2 == 90004 || intExtra2 == 90025) {
                az(intExtra2, stringExtra);
                AppMethodBeat.o(v2helper.EMethodSetSendToNetworkOn);
                return;
            }
            AppMethodBeat.o(v2helper.EMethodSetSendToNetworkOn);
            return;
        }
        this.lXh = 1;
        if (intent == null) {
            ab.e("MicroMsg.FaceDetectPrepareUI", "alvinluo onActivityResult data is null");
            a(4, 90018, "system error", getString(R.string.bkz), false, new c() {
                public final void p(int i, int i2, String str) {
                    AppMethodBeat.i(416);
                    if (FaceDetectPrepareUI.this.lWT != null) {
                        FaceDetectPrepareUI.this.lWT.c(i, i2, str, null);
                    }
                    AppMethodBeat.o(416);
                }
            });
            AppMethodBeat.o(v2helper.EMethodSetSendToNetworkOn);
            return;
        }
        faceDetectReporter = (FaceDetectReporter) intent.getParcelableExtra("key_parcelable_reporter");
        if (faceDetectReporter != null) {
            FaceDetectReporter.bsJ().a(faceDetectReporter);
        }
        intExtra = intent.getIntExtra("err_type", -1);
        intExtra2 = intent.getIntExtra("err_code", -1);
        stringExtra = intent.getStringExtra("err_msg");
        if (this.lWT != null) {
            aVar = this.lWT;
            intent.getExtras();
            aVar.n(intExtra, intExtra2, stringExtra);
        }
        ab.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onActivityResult errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(intExtra), Integer.valueOf(intExtra2), stringExtra);
        if (intExtra == 0 && intExtra2 == 0) {
            btn();
            m(1, null);
            AppMethodBeat.o(v2helper.EMethodSetSendToNetworkOn);
            return;
        }
        if (intExtra != 1) {
            stringExtra2 = intent.getStringExtra("show_err_msg");
            if (intExtra2 == 90013) {
                stringExtra2 = getString(R.string.bkk);
            } else if (intExtra2 == 90008 || intExtra2 == 90010) {
                stringExtra2 = getString(R.string.dbs);
            } else if (intExtra2 == 90009) {
                stringExtra2 = getString(R.string.dc0);
            } else if (bo.isNullOrNil(stringExtra2)) {
                stringExtra2 = getString(R.string.er5);
            }
            d(intExtra, intExtra2, stringExtra, null);
            if (intExtra2 == 90023) {
                z = true;
            }
            a(intExtra, intExtra2, stringExtra, stringExtra2, z, new c() {
                public final void p(int i, int i2, String str) {
                    AppMethodBeat.i(417);
                    if (FaceDetectPrepareUI.this.lWT != null) {
                        FaceDetectPrepareUI.this.lWT.c(i, i2, str, null);
                    }
                    AppMethodBeat.o(417);
                }
            });
        } else if (intExtra2 == 90004 || intExtra2 == 90025) {
            az(intExtra2, stringExtra);
            AppMethodBeat.o(v2helper.EMethodSetSendToNetworkOn);
            return;
        }
        AppMethodBeat.o(v2helper.EMethodSetSendToNetworkOn);
    }

    private void btm() {
        AppMethodBeat.i(v2helper.EMethodSetSendToNetworkOff);
        if (this.lWU != null) {
            this.lWU.dismiss();
        }
        ab.i("MicroMsg.FaceDetectPrepareUI", "carson init jumper: %b", Boolean.valueOf(this.lXl));
        if (this.lXl) {
            this.lWU = new b(this);
            this.lWU.create();
            AppMethodBeat.o(v2helper.EMethodSetSendToNetworkOff);
            return;
        }
        this.lWU = new a(this);
        this.lWU.create();
        AppMethodBeat.o(v2helper.EMethodSetSendToNetworkOff);
    }

    public final void a(boolean z, boolean z2, c cVar) {
        AppMethodBeat.i(434);
        if (z2) {
            ab.i("MicroMsg.FaceDetectPrepareUI", "hy: need blur");
            com.tencent.mm.sdk.g.d.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(v2helper.EMethodOutputVolumeGainEnable);
                    final Bitmap Lr = p.Lr(FaceDetectPrepareUI.this.edV);
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(v2helper.EMethodSetPlayerPreCorrectCofOff);
                            FaceDetectPrepareUI.this.lWU.M(Lr);
                            AppMethodBeat.o(v2helper.EMethodSetPlayerPreCorrectCofOff);
                        }
                    });
                    AppMethodBeat.o(v2helper.EMethodOutputVolumeGainEnable);
                }
            }, "face_refresh_background");
        }
        this.lWU.a(cVar);
        AppMethodBeat.o(434);
    }

    private void btn() {
        AppMethodBeat.i(z.CTRL_INDEX);
        String string = getString(R.string.bko);
        c b = a.b(R.drawable.b31, string, null, getString(R.string.or), null, new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(v2helper.EMethodSetNgStrength);
                FaceDetectPrepareUI.a(FaceDetectPrepareUI.this, 90005, "user cancel in uploading");
                AppMethodBeat.o(v2helper.EMethodSetNgStrength);
            }
        });
        b.lYB = true;
        b.lYD = string.length() - 3;
        b.status = 1;
        a(false, true, b);
        AppMethodBeat.o(z.CTRL_INDEX);
    }

    private void a(final int i, final int i2, final String str, String str2, boolean z, c cVar) {
        AppMethodBeat.i(h.CTRL_INDEX);
        ab.i("MicroMsg.FaceDetectPrepareUI", "alvinluo showFailJumper showErrMsg: %s", str2);
        if (this.lXn) {
            View findViewById = findViewById(R.id.bnr);
            if (findViewById != null) {
                ab.i("MicroMsg.FaceDetectPrepareUI", "carson: hide tutorialRoot");
                findViewById.setVisibility(8);
            }
            this.lXk.setVisibility(0);
        }
        final boolean z2 = z;
        final c cVar2 = cVar;
        final int i3 = i;
        final int i4 = i2;
        final String str3 = str;
        final c a = a.a(R.drawable.b33, str2, z ? getResources().getString(R.string.blm) : getString(R.string.blk), z ? getResources().getString(R.string.or) : null, new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(401);
                if (!z2) {
                    if (cVar2 != null) {
                        cVar2.p(i3, i4, str3);
                    }
                    FaceDetectPrepareUI.this.a(i3, i4, str3, null);
                } else if (FaceDetectPrepareUI.this.lWT != null) {
                    FaceDetectPrepareUI.this.lWT.bsk();
                    AppMethodBeat.o(401);
                    return;
                }
                AppMethodBeat.o(401);
            }
        }, new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(402);
                FaceDetectPrepareUI.this.a(i, i2, str, null);
                AppMethodBeat.o(402);
            }
        });
        a.status = 3;
        String string = getString(R.string.bke);
        if (this.lSK == null) {
            string = null;
        }
        a.a(a, string, new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(403);
                if (bo.isNullOrNil(FaceDetectPrepareUI.this.lSK)) {
                    ab.e("MicroMsg.FaceDetectPrepareUI", "alvinluo feedback url is null");
                    AppMethodBeat.o(403);
                    return;
                }
                FaceDetectPrepareUI.this.lXi = false;
                try {
                    String str = "appid=%s;errcode=%d;identifyid=%s";
                    Object[] objArr = new Object[3];
                    objArr[0] = FaceDetectPrepareUI.this.mAppId != null ? FaceDetectPrepareUI.this.mAppId : "";
                    objArr[1] = Integer.valueOf(i2);
                    objArr[2] = "";
                    ab.i("MicroMsg.FaceDetectPrepareUI", "alvinluo feedback url: %s", FaceDetectPrepareUI.this.lSK + "?customInfo=" + q.encode(String.format(str, objArr), "UTF-8"));
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", r0);
                    com.tencent.mm.bp.d.b(FaceDetectPrepareUI.this, "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.o(403);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.FaceDetectPrepareUI", e, "alvinluo start feedback webview exception", new Object[0]);
                    AppMethodBeat.o(403);
                }
            }
        });
        al.d(new Runnable() {
            final /* synthetic */ boolean lXs = true;

            public final void run() {
                AppMethodBeat.i(404);
                FaceDetectPrepareUI.this.a(true, this.lXs, a);
                AppMethodBeat.o(404);
            }
        });
        AppMethodBeat.o(h.CTRL_INDEX);
    }

    public final void bsm() {
    }

    public final void a(int i, int i2, String str, Bundle bundle) {
        int i3 = 1;
        AppMethodBeat.i(437);
        ab.i("MicroMsg.FaceDetectPrepareUI", "finishWithResult errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (bundle != null) {
            bundle.putString("k_bio_id", String.valueOf(this.lTH));
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt("err_code", l.vm(i2));
        bundle2.putString("err_msg", str);
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        Intent intent = new Intent();
        intent.putExtras(bundle2);
        setResult(-1, intent);
        if (this.lXb) {
            this.lXc = true;
            m(5, this.lWT.bso());
            FaceDetectReporter bsJ = FaceDetectReporter.bsJ();
            if (!this.lXb) {
                i3 = 0;
            }
            bsJ.lUx = i3;
        }
        finish();
        AppMethodBeat.o(437);
    }

    public void onDestroy() {
        AppMethodBeat.i(438);
        ab.i("MicroMsg.FaceDetectPrepareUI", "onDestroy");
        super.onDestroy();
        if (!this.lXc) {
            com.tencent.mm.bp.d.l(new Intent(this, FaceDetectProcessService.class), "tools");
        }
        if (this.lXj != null) {
            this.lXj.stop();
        }
        AppMethodBeat.o(438);
    }

    public void onStart() {
        AppMethodBeat.i(JsApiGetInstallState.CTRL_INDEX);
        super.onStart();
        AppMethodBeat.o(JsApiGetInstallState.CTRL_INDEX);
    }

    public void onResume() {
        AppMethodBeat.i(JsApiAddDownloadTaskStraight.CTRL_INDEX);
        ab.i("MicroMsg.FaceDetectPrepareUI", "onResume");
        super.onResume();
        this.lXi = true;
        AppMethodBeat.o(JsApiAddDownloadTaskStraight.CTRL_INDEX);
    }

    public void onStop() {
        AppMethodBeat.i(JsApiQueryDownloadTask.CTRL_INDEX);
        super.onStop();
        if (this.lXi) {
            if (this.eTM || !hasError()) {
                finish();
            } else {
                a(this.lXa.errType, this.lXa.errCode, this.lXa.aIm, this.lXa.extras);
                AppMethodBeat.o(JsApiQueryDownloadTask.CTRL_INDEX);
                return;
            }
        }
        AppMethodBeat.o(JsApiQueryDownloadTask.CTRL_INDEX);
    }

    private void bto() {
        AppMethodBeat.i(JsApiPauseDownloadTask.CTRL_INDEX);
        d(4, 90011, "get image failed", getString(R.string.bkf));
        AppMethodBeat.o(JsApiPauseDownloadTask.CTRL_INDEX);
    }

    private void aDo() {
        AppMethodBeat.i(JsApiResumeDownloadTask.CTRL_INDEX);
        d(4, 90013, "init lib failed", getString(R.string.bkk));
        AppMethodBeat.o(JsApiResumeDownloadTask.CTRL_INDEX);
    }

    private void d(int i, int i2, String str, String str2) {
        AppMethodBeat.i(JsApiWriteCommData.CTRL_INDEX);
        ab.i("MicroMsg.FaceDetectPrepareUI", "onProcessingError errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        d(i, i2, str, null);
        this.lWZ = true;
        a(i, i2, str, str2, false, new c() {
            public final void p(int i, int i2, String str) {
                AppMethodBeat.i(413);
                if (FaceDetectPrepareUI.this.lWT != null) {
                    FaceDetectPrepareUI.this.lWT.c(i, i2, str, FaceDetectPrepareUI.this.lXa.extras);
                }
                AppMethodBeat.o(413);
            }
        });
        AppMethodBeat.o(JsApiWriteCommData.CTRL_INDEX);
    }

    private boolean hasError() {
        boolean z;
        AppMethodBeat.i(446);
        String str = "MicroMsg.FaceDetectPrepareUI";
        String str2 = "alvinluo hasLastError: %b, lastError == null: %b, hashCode: %d";
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(this.lWY);
        if (this.lXa == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Integer.valueOf(hashCode());
        ab.i(str, str2, objArr);
        if (!this.lWY || this.lXa == null) {
            AppMethodBeat.o(446);
            return false;
        }
        AppMethodBeat.o(446);
        return true;
    }

    public final void d(int i, int i2, String str, Bundle bundle) {
        AppMethodBeat.i(447);
        ab.i("MicroMsg.FaceDetectPrepareUI", "alvinluo saveError errType: %d, errCode: %d, errMsg: %s, hashCode: %d", Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(hashCode()));
        if (this.lXa == null) {
            this.lXa = new b(this, (byte) 0);
        }
        this.lWY = true;
        this.lXa.e(i, i2, str, bundle);
        AppMethodBeat.o(447);
    }

    public void onBackPressed() {
        AppMethodBeat.i(FileUtils.S_IRWXU);
        if (hasError()) {
            if (this.lWT != null) {
                this.lWT.c(this.lXa.errType, this.lXa.errCode, this.lXa.aIm, this.lXa.extras);
                AppMethodBeat.o(FileUtils.S_IRWXU);
                return;
            }
        } else if (this.lXh == 1) {
            az(90003, "user cancel in init");
            AppMethodBeat.o(FileUtils.S_IRWXU);
            return;
        } else if (this.lXh == 3) {
            az(90005, "user cancel in uploading");
            AppMethodBeat.o(FileUtils.S_IRWXU);
            return;
        } else if (this.lXh == 0) {
            az(90002, "user cancel in tutorial");
            AppMethodBeat.o(FileUtils.S_IRWXU);
            return;
        } else {
            az(90050, "user cancel unknown");
        }
        AppMethodBeat.o(FileUtils.S_IRWXU);
    }

    private void az(int i, String str) {
        AppMethodBeat.i(449);
        if (hasError()) {
            if (this.lWT != null) {
                this.lWT.c(this.lXa.errType, this.lXa.errCode, this.lXa.aIm, this.lXa.extras);
            }
        } else if (this.lWT != null) {
            this.lWT.ax(i, str);
        }
        this.eVT = true;
        finish();
        AppMethodBeat.o(449);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        int i2 = 90008;
        AppMethodBeat.i(450);
        ab.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onRequestPermissionsResult");
        if (iArr == null || iArr.length <= 0) {
            AppMethodBeat.o(450);
            return;
        }
        switch (i) {
            case 23:
                int i3;
                String str = "";
                String str2 = "";
                View findViewById;
                if (iArr.length != 1) {
                    if (iArr.length == 2) {
                        if (iArr[0] == 0 && iArr[1] == 0) {
                            i3 = 1;
                        } else {
                            if (iArr[0] != 0) {
                                str = "camera permission not granted";
                                str2 = getString(R.string.dbs);
                            } else {
                                i2 = -1;
                            }
                            if (iArr[1] != 0) {
                                i2 = 90009;
                                str = "audio permission not granted";
                                str2 = getString(R.string.dc0);
                            }
                            if (!(iArr[0] == 0 || iArr[1] == 0)) {
                                i2 = 90010;
                                str = "both camera and audio permission not granted";
                                str2 = getString(R.string.dbs);
                            }
                            this.lXk.setVisibility(0);
                            ab.i("MicroMsg.FaceDetectPrepareUI", " mFacePrepareLayout, visible: %s", Integer.valueOf(this.lXk.getVisibility()));
                            findViewById = findViewById(R.id.bnr);
                            if (findViewById != null) {
                            }
                            d(1, i2, str, str2);
                            i3 = 0;
                        }
                    }
                    i2 = -1;
                    this.lXk.setVisibility(0);
                    ab.i("MicroMsg.FaceDetectPrepareUI", " mFacePrepareLayout, visible: %s", Integer.valueOf(this.lXk.getVisibility()));
                    findViewById = findViewById(R.id.bnr);
                    if (findViewById != null) {
                    }
                    d(1, i2, str, str2);
                    i3 = 0;
                } else if (iArr[0] == 0) {
                    i3 = 1;
                } else {
                    if (strArr[0].equals("android.permission.CAMERA")) {
                        str = "camera permission not granted";
                        str2 = getString(R.string.dbs);
                    } else {
                        if (strArr[0].equals("android.permission.RECORD_AUDIO")) {
                            i2 = 90009;
                            str = "audio permission not granted";
                            str2 = getString(R.string.dc0);
                        }
                        i2 = -1;
                    }
                    this.lXk.setVisibility(0);
                    ab.i("MicroMsg.FaceDetectPrepareUI", " mFacePrepareLayout, visible: %s", Integer.valueOf(this.lXk.getVisibility()));
                    findViewById = findViewById(R.id.bnr);
                    if (findViewById != null) {
                        findViewById.setVisibility(8);
                    }
                    d(1, i2, str, str2);
                    i3 = 0;
                }
                if (i3 != 0) {
                    btj();
                    AppMethodBeat.o(450);
                    return;
                }
                break;
            default:
                ab.i("MicroMsg.FaceDetectPrepareUI", "carson：finish()");
                break;
        }
        AppMethodBeat.o(450);
    }

    public final void bsp() {
        this.lXi = false;
    }

    public void finish() {
        AppMethodBeat.i(JsApiInstallDownloadTask.CTRL_INDEX);
        ab.i("MicroMsg.FaceDetectPrepareUI", "dismissJumper");
        if (this.lWU != null && this.lWU.aFF()) {
            this.lWU.dismiss();
        }
        if (this.lWV != null) {
            this.lWV.dismiss();
        }
        ab.v("MicroMsg.FaceDetectPrepareUI", "alvinluo: releaseFaceDetect");
        if (this.lWT != null) {
            this.lWT.bsm();
        }
        super.finish();
        this.eTM = true;
        AppMethodBeat.o(JsApiInstallDownloadTask.CTRL_INDEX);
    }

    static /* synthetic */ void b(FaceDetectPrepareUI faceDetectPrepareUI, Message message) {
        AppMethodBeat.i(452);
        Bundle data = message.getData();
        if (data == null) {
            faceDetectPrepareUI.bto();
            AppMethodBeat.o(452);
        } else if (data.getInt("key_face_result_code", -1) != 0) {
            faceDetectPrepareUI.bto();
            AppMethodBeat.o(452);
        } else {
            faceDetectPrepareUI.lXh = 3;
            final String string = data.getString("key_face_result_file_path");
            if (string != null) {
                com.tencent.mm.sdk.g.d.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(412);
                        try {
                            FaceDetectPrepareUI.this.lWT.Lq(string);
                            AppMethodBeat.o(412);
                        } catch (Exception e) {
                            ab.printErrStackTrace("MicroMsg.FaceDetectPrepareUI", e, "", new Object[0]);
                            AppMethodBeat.o(412);
                        }
                    }
                }, "face_upload");
            }
            AppMethodBeat.o(452);
        }
    }

    static /* synthetic */ void c(FaceDetectPrepareUI faceDetectPrepareUI, Message message) {
        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.k.l.CTRL_INDEX);
        Bundle data = message.getData();
        if (data == null) {
            ab.i("MicroMsg.FaceDetectPrepareUI", "onUploadBioBuffer, data is null");
            faceDetectPrepareUI.bto();
            AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.k.l.CTRL_INDEX);
            return;
        }
        final String string = data.getString("key_bio_buffer_path");
        if (bo.isNullOrNil(string)) {
            ab.i("MicroMsg.FaceDetectPrepareUI", "onUploadBioBuffer, filepath is null");
            faceDetectPrepareUI.bto();
            AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.k.l.CTRL_INDEX);
            return;
        }
        com.tencent.mm.sdk.g.d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(411);
                try {
                    ab.i("MicroMsg.FaceDetectPrepareUI", "call controller start upload biobuffer: %s", string);
                    FaceDetectPrepareUI.this.lWT.Lq(string);
                    AppMethodBeat.o(411);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.FaceDetectPrepareUI", e, "", new Object[0]);
                    AppMethodBeat.o(411);
                }
            }
        }, "face_upload");
        AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.k.l.CTRL_INDEX);
    }
}
