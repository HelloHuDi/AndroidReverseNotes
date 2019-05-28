package com.tencent.mm.plugin.facedetectaction.ui;

import android.content.Intent;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.facedetectaction.b.d;
import com.tencent.mm.plugin.facedetectlight.ui.PreviewFrameLayout;
import com.tencent.mm.plugin.facedetectlight.ui.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.mm.ui.base.a;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.youtu.ytfacetrace.jni.YTFaceTraceJNIInterface.FaceStatus;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface;

@a(3)
public class FaceActionUI extends MMActivity {
    int cvG;
    private long endTime;
    RelativeLayout lYg;
    RelativeLayout lYh;
    RelativeLayout lYi;
    ImageView lYj;
    ImageView lYk;
    ImageView lYl;
    private int mbW;
    private String mbX;
    RelativeLayout mcN;
    private PreviewFrameLayout mcO;
    private FaceActionMask mcP;
    private MMTextureView mcQ;
    ImageView mcR;
    private TextView mcS;
    private TextView mcT;
    private ImageView mcU;
    private Button mcV;
    private Button mcW;
    private TextView mcX;
    public boolean mcY = false;
    b mcZ;
    private com.tencent.mm.plugin.facedetectaction.b.a.a mca;
    private int mda;
    private int mdb;
    private String mdc;
    private int mdd;
    private int scene;
    private long startTime;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void d(FaceActionUI faceActionUI) {
        AppMethodBeat.i(744);
        faceActionUI.btR();
        AppMethodBeat.o(744);
    }

    public final int getLayoutId() {
        return R.layout.x2;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(728);
        ab.d("MicroMsg.FaceActionUI", "start VerifyActivity");
        super.onCreate(bundle);
        getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        getWindow().addFlags(2097280);
        this.scene = getIntent().getIntExtra("scene", 0);
        this.mdd = 0;
        this.startTime = bo.yz();
        this.cvG = 4;
        ab.d("MicroMsg.FaceActionUI", "initLayout");
        this.mcR = (ImageView) findViewById(R.id.blv);
        btQ();
        this.lYg = (RelativeLayout) findViewById(R.id.blo);
        this.lYh = (RelativeLayout) findViewById(R.id.blk);
        this.lYi = (RelativeLayout) findViewById(R.id.blf);
        this.lYg.setVisibility(4);
        this.lYh.setVisibility(4);
        this.lYi.setVisibility(4);
        this.lYj = (ImageView) findViewById(R.id.blq);
        this.lYk = (ImageView) findViewById(R.id.blp);
        this.lYl = (ImageView) findViewById(R.id.blm);
        this.mcX = (TextView) findViewById(R.id.blh);
        this.mcV = (Button) findViewById(R.id.bli);
        this.mcW = (Button) findViewById(R.id.blj);
        if (bo.isNullOrNil(d.mcq.cKU)) {
            this.mcW.setVisibility(8);
        } else {
            this.mcW.setText(d.mcq.cKU);
            this.mcW.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(723);
                    ab.i("MicroMsg.FaceActionUI", "click mUploadFailedConfig");
                    FaceActionUI.this.mcY = true;
                    FaceActionUI.this.s("fail", FaceActionUI.this.mdb, "");
                    AppMethodBeat.o(723);
                }
            });
        }
        if (p.M(this)) {
            ab.i("MicroMsg.FaceActionUI", "carson: checkFacePermissionAnd Request true and do init ");
            btj();
            AppMethodBeat.o(728);
            return;
        }
        ab.i("MicroMsg.FaceActionUI", "carson: no camera permission. request permission");
        AppMethodBeat.o(728);
    }

    private void btj() {
        AppMethodBeat.i(729);
        this.mca = new com.tencent.mm.plugin.facedetectaction.b.a.a() {
            public final void a(FaceStatus faceStatus, byte[] bArr) {
                AppMethodBeat.i(709);
                d dVar = d.mcq;
                Camera camera = FaceActionUI.this.mcZ.mdw.etv;
                if (dVar.mcr != null) {
                    dVar.mStatus = 1;
                    com.tencent.mm.plugin.facedetectaction.b.b bVar = dVar.mcr;
                    if (faceStatus != null) {
                        bVar.status = 2;
                        YTPoseDetectInterface.poseDetect(faceStatus.xys, bVar.mcm, bArr, camera, faceStatus.pitch, faceStatus.yaw, faceStatus.roll, bVar.mcn);
                    }
                }
                AppMethodBeat.o(709);
            }
        };
        d.mcq.mcw = new d.a() {
            public final void aA(final int i, final String str) {
                AppMethodBeat.i(716);
                ab.i("MicroMsg.FaceActionUI", "onInitFaceCheckFinish: %s", Integer.valueOf(i));
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(710);
                        FaceActionUI.this.mbW = i;
                        FaceActionUI.this.mbX = str;
                        FaceActionUI.c(FaceActionUI.this);
                        FaceActionUI.d(FaceActionUI.this);
                        FaceActionUI.this.mdd = FaceActionUI.this.mdd + 1;
                        AppMethodBeat.o(710);
                    }
                });
                AppMethodBeat.o(716);
            }

            public final void btP() {
                AppMethodBeat.i(717);
                ab.i("MicroMsg.FaceActionUI", "onStartUpload");
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(711);
                        FaceActionUI faceActionUI = FaceActionUI.this;
                        if (faceActionUI.mcZ != null) {
                            faceActionUI.mcZ.stopPreview();
                        }
                        faceActionUI.mcN.setVisibility(8);
                        faceActionUI.lYg.setVisibility(0);
                        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) faceActionUI.lYj.getHeight());
                        translateAnimation.setDuration(FaceGestureDetGLThread.BRIGHTNESS_DURATION);
                        translateAnimation.setRepeatMode(2);
                        translateAnimation.setRepeatCount(-1);
                        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 1.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                        scaleAnimation.setDuration(1000);
                        scaleAnimation.setRepeatMode(2);
                        scaleAnimation.setRepeatCount(-1);
                        AnimationSet animationSet = new AnimationSet(true);
                        animationSet.addAnimation(translateAnimation);
                        animationSet.addAnimation(scaleAnimation);
                        animationSet.setAnimationListener(new AnimationListener() {
                            public final void onAnimationEnd(Animation animation) {
                                AppMethodBeat.i(724);
                                ab.d("MicroMsg.FaceActionUI", "checkingAnimation, AnimationEnd");
                                ab.d("MicroMsg.FaceActionUI", "checkingAnimation, AnimationEnd");
                                AppMethodBeat.o(724);
                            }

                            public final void onAnimationRepeat(Animation animation) {
                            }

                            public final void onAnimationStart(Animation animation) {
                                AppMethodBeat.i(725);
                                ab.d("MicroMsg.FaceActionUI", "checkingAnimation, AnimationStart");
                                AppMethodBeat.o(725);
                            }
                        });
                        animationSet.setRepeatCount(-1);
                        faceActionUI.lYk.startAnimation(animationSet);
                        AppMethodBeat.o(711);
                    }
                });
                AppMethodBeat.o(717);
            }

            public final void Lx(final String str) {
                AppMethodBeat.i(718);
                ab.i("MicroMsg.FaceActionUI", "onVerifyFinish:   authToken ：%s", str);
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(712);
                        FaceActionUI.this.lYk.clearAnimation();
                        FaceActionUI faceActionUI = FaceActionUI.this;
                        faceActionUI.mcN.setVisibility(8);
                        faceActionUI.lYk.clearAnimation();
                        faceActionUI.lYg.setVisibility(8);
                        faceActionUI.mcR.setVisibility(0);
                        faceActionUI.lYh.setVisibility(0);
                        faceActionUI.lYl.setScaleX(0.0f);
                        faceActionUI.lYl.setScaleY(0.0f);
                        faceActionUI.lYl.animate().scaleX(1.0f).scaleY(1.0f).setDuration(800);
                        faceActionUI = FaceActionUI.this;
                        String str = str;
                        ab.i("MicroMsg.FaceActionUI", "callbackDetectSuccess（）");
                        Bundle bundle = new Bundle();
                        bundle.putString("token", str);
                        faceActionUI.cvG = 0;
                        faceActionUI.a("ok", 0, bundle, Boolean.valueOf(faceActionUI.mcY));
                        AppMethodBeat.o(712);
                    }
                });
                AppMethodBeat.o(718);
            }

            public final void a(int i, final int i2, final String str, final int i3) {
                AppMethodBeat.i(719);
                ab.i("MicroMsg.FaceActionUI", "onError, err: %s, cgiErrCode: %s, cgiErrMsg: %s,retry: %s", Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3));
                FaceActionUI.this.mda = i;
                FaceActionUI.this.mdb = i2;
                FaceActionUI.this.mdc = str;
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(715);
                        if (bo.isNullOrNil(str)) {
                            FaceActionUI.this.mcX.setText(R.string.bje);
                        } else {
                            FaceActionUI.this.mcX.setText(str);
                            FaceActionUI.this.cvG = 2;
                        }
                        if (i3 == 1) {
                            FaceActionUI.this.mcV.setText(R.string.bll);
                            FaceActionUI.this.mcV.setOnClickListener(new OnClickListener() {
                                public final void onClick(View view) {
                                    AppMethodBeat.i(713);
                                    ab.i("MicroMsg.FaceActionUI", "click retry");
                                    FaceActionUI.j(FaceActionUI.this);
                                    AppMethodBeat.o(713);
                                }
                            });
                        } else {
                            FaceActionUI.this.mcV.setText(R.string.blk);
                            FaceActionUI.this.mcV.setOnClickListener(new OnClickListener() {
                                public final void onClick(View view) {
                                    AppMethodBeat.i(714);
                                    ab.i("MicroMsg.FaceActionUI", "click finish");
                                    FaceActionUI.this.s("fail", i2, "");
                                    AppMethodBeat.o(714);
                                }
                            });
                        }
                        FaceActionUI.this.lYk.clearAnimation();
                        FaceActionUI faceActionUI = FaceActionUI.this;
                        faceActionUI.mcN.setVisibility(8);
                        faceActionUI.lYi.setVisibility(0);
                        faceActionUI.lYk.clearAnimation();
                        faceActionUI.mcR.setVisibility(0);
                        faceActionUI.lYg.setVisibility(8);
                        d.mcq.mStatus = 3;
                        if (bo.isNullOrNil(d.mcq.cKU)) {
                            FaceActionUI.this.s("fail", i2, "");
                        }
                        AppMethodBeat.o(715);
                    }
                });
                AppMethodBeat.o(719);
            }
        };
        d.mcq.crP = this;
        d.mcq.a(this);
        AppMethodBeat.o(729);
    }

    public void onStart() {
        AppMethodBeat.i(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_SPACE_NOT_ENOUGH);
        ab.d("MicroMsg.FaceActionUI", "onStart");
        super.onStart();
        if (this.mcZ != null) {
            this.mcZ.a(this.mcQ);
            this.mcZ.btX();
        }
        AppMethodBeat.o(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_SPACE_NOT_ENOUGH);
    }

    public void onResume() {
        AppMethodBeat.i(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_URL_EMPTY);
        super.onResume();
        ab.d("MicroMsg.FaceActionUI", "onResume");
        btR();
        AppMethodBeat.o(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_URL_EMPTY);
    }

    public void onPause() {
        AppMethodBeat.i(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION);
        ab.d("MicroMsg.FaceActionUI", "onPause");
        super.onPause();
        AppMethodBeat.o(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION);
    }

    public void onStop() {
        AppMethodBeat.i(733);
        ab.i("MicroMsg.FaceActionUI", "onStop");
        super.onStop();
        if (this.mcZ != null) {
            this.mcZ.lXB = false;
        }
        AppMethodBeat.o(733);
    }

    public void onDestroy() {
        AppMethodBeat.i(734);
        super.onDestroy();
        ab.i("MicroMsg.FaceActionUI", "onDestroy");
        d.mcq.release(true);
        AppMethodBeat.o(734);
    }

    private void btQ() {
        AppMethodBeat.i(735);
        this.mcN = (RelativeLayout) findViewById(R.id.bls);
        this.mcO = (PreviewFrameLayout) findViewById(R.id.blt);
        this.mcQ = (MMTextureView) findViewById(R.id.blu);
        this.mcQ.setVisibility(4);
        this.mcP = (FaceActionMask) findViewById(R.id.blx);
        this.mcU = (ImageView) findViewById(R.id.blw);
        this.mcU.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(720);
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) FaceActionUI.this.mcU.getLayoutParams();
                marginLayoutParams.topMargin = (int) (((double) FaceActionUI.this.mcP.getHeight()) * 0.4d);
                FaceActionUI.this.mcU.setLayoutParams(marginLayoutParams);
                FaceActionUI.this.mcU.setVisibility(0);
                AppMethodBeat.o(720);
            }
        });
        this.mcS = (TextView) findViewById(R.id.bly);
        this.mcS.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(721);
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) FaceActionUI.this.mcS.getLayoutParams();
                marginLayoutParams.topMargin = (((int) (((double) FaceActionUI.this.mcP.getHeight()) * 0.4d)) + ((int) (((double) FaceActionUI.this.mcP.getWidth()) * 0.35d))) + aj.fromDPToPix(FaceActionUI.this, 30);
                ab.i("MicroMsg.FaceActionUI", "topMargin：%d", Integer.valueOf(r1));
                FaceActionUI.this.mcS.setLayoutParams(marginLayoutParams);
                FaceActionUI.this.mcS.setVisibility(0);
                AppMethodBeat.o(721);
            }
        });
        this.mcT = (TextView) findViewById(R.id.blz);
        this.mcT.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(722);
                d.mcq.onBackPressed();
                FaceActionUI.this.finish();
                AppMethodBeat.o(722);
            }
        });
        AppMethodBeat.o(735);
    }

    public final void s(String str, int i, String str2) {
        AppMethodBeat.i(736);
        ab.i("MicroMsg.FaceActionUI", "callbackDetectFailed（）");
        Bundle bundle = new Bundle();
        bundle.putString("token", str2);
        a(str, i, bundle, Boolean.valueOf(this.mcY));
        AppMethodBeat.o(736);
    }

    public final void a(String str, int i, Bundle bundle, Boolean bool) {
        String str2;
        AppMethodBeat.i(737);
        ab.i("MicroMsg.FaceActionUI", "finishWithResult errMsg: %s, errCode: %d", str, Integer.valueOf(i));
        if (bool.booleanValue()) {
            str2 = "yes";
        } else {
            str2 = "no";
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("click_other_verify_btn", str2);
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        c(str, i, bundle2);
        new ak().postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(727);
                FaceActionUI.this.finish();
                AppMethodBeat.o(727);
            }
        }, 1500);
        AppMethodBeat.o(737);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c(String str, int i, Bundle bundle) {
        int i2;
        AppMethodBeat.i(738);
        Intent d = d(str, i, bundle);
        switch (str.hashCode()) {
            case -1367724422:
                if (str.equals("cancel")) {
                    i2 = 2;
                    break;
                }
            case 3548:
                if (str.equals("ok")) {
                    i2 = 0;
                    break;
                }
            case 3135262:
                if (str.equals("fail")) {
                    i2 = 1;
                    break;
                }
            default:
                i2 = -1;
                break;
        }
        switch (i2) {
            case 0:
                setResult(-1, d);
                AppMethodBeat.o(738);
                return;
            case 1:
                setResult(1, d);
                AppMethodBeat.o(738);
                return;
            case 2:
                setResult(0, d);
                AppMethodBeat.o(738);
                return;
            default:
                setResult(-1, d);
                AppMethodBeat.o(738);
                return;
        }
    }

    private Intent d(String str, int i, Bundle bundle) {
        AppMethodBeat.i(739);
        Bundle bundle2 = new Bundle();
        bundle2.putInt("err_code", i);
        bundle2.putString("err_msg", str);
        bundle2.putInt("scene", this.scene);
        bundle2.putInt("countFace", this.mdd);
        bundle2.putInt("err_type", this.cvG);
        this.endTime = bo.yz();
        ab.i("MicroMsg.FaceActionUI", "endTime：" + this.endTime);
        ab.i("MicroMsg.FaceActionUI", "startTime：" + this.startTime);
        bundle2.putLong("totalTime", this.endTime - this.startTime);
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        Intent intent = new Intent();
        intent.putExtras(bundle2);
        AppMethodBeat.o(739);
        return intent;
    }

    public void onBackPressed() {
        AppMethodBeat.i(740);
        d.mcq.onBackPressed();
        AppMethodBeat.o(740);
    }

    private void btR() {
        AppMethodBeat.i(741);
        ab.i("MicroMsg.FaceActionUI", "preview");
        if (this.mcZ != null) {
            this.mcZ.mdx = true;
            ab.i("MicroMsg.FaceActionUI", "mCamera ！= null");
        }
        this.mcS.setText(R.string.bld);
        AppMethodBeat.o(741);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(742);
        ab.i("MicroMsg.FaceActionUI", "carson onRequestPermissionsResult");
        if (iArr == null || iArr.length <= 0) {
            AppMethodBeat.o(742);
            return;
        }
        switch (i) {
            case 23:
                int i2;
                Object obj = "";
                Object obj2 = "";
                if (iArr.length != 1) {
                    if (iArr.length == 2) {
                        if (iArr[0] == 0 && iArr[1] == 0) {
                            i2 = 1;
                        } else {
                            if (iArr[0] != 0) {
                                obj = "camera permission not granted";
                                obj2 = getString(R.string.dbs);
                            }
                            if (iArr[1] != 0) {
                                obj = "audio permission not granted";
                                obj2 = getString(R.string.dc0);
                            }
                            if (!(iArr[0] == 0 || iArr[1] == 0)) {
                                obj = "both camera and audio permission not granted";
                                obj2 = getString(R.string.dbs);
                            }
                        }
                    }
                    ab.i("MicroMsg.FaceActionUI", "carson PermissionsResult:errMsg".concat(String.valueOf(obj)));
                    ab.i("MicroMsg.FaceActionUI", "carson PermissionsResult:showErrMsg".concat(String.valueOf(obj2)));
                    ab.i("MicroMsg.FaceActionUI", "checkPermissionFailedAnimation");
                    this.mcX.setText(obj2);
                    this.mcV.setText(R.string.blk);
                    this.mcV.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(726);
                            ab.i("MicroMsg.FaceActionUI", "click finish");
                            FaceActionUI.this.s("fail", 90010, "");
                            AppMethodBeat.o(726);
                        }
                    });
                    this.mcN.setVisibility(8);
                    this.lYi.setVisibility(0);
                    this.lYk.clearAnimation();
                    this.mcR.setVisibility(0);
                    this.lYg.setVisibility(8);
                    i2 = 0;
                } else if (iArr[0] == 0) {
                    i2 = 1;
                } else {
                    if (strArr[0].equals("android.permission.CAMERA")) {
                        obj = "camera permission not granted";
                        obj2 = getString(R.string.dbs);
                    } else if (strArr[0].equals("android.permission.RECORD_AUDIO")) {
                        obj = "audio permission not granted";
                        obj2 = getString(R.string.dc0);
                    }
                    ab.i("MicroMsg.FaceActionUI", "carson PermissionsResult:errMsg".concat(String.valueOf(obj)));
                    ab.i("MicroMsg.FaceActionUI", "carson PermissionsResult:showErrMsg".concat(String.valueOf(obj2)));
                    ab.i("MicroMsg.FaceActionUI", "checkPermissionFailedAnimation");
                    this.mcX.setText(obj2);
                    this.mcV.setText(R.string.blk);
                    this.mcV.setOnClickListener(/* anonymous class already generated */);
                    this.mcN.setVisibility(8);
                    this.lYi.setVisibility(0);
                    this.lYk.clearAnimation();
                    this.mcR.setVisibility(0);
                    this.lYg.setVisibility(8);
                    i2 = 0;
                }
                if (i2 != 0) {
                    btj();
                    break;
                }
                break;
        }
        AppMethodBeat.o(742);
    }

    static /* synthetic */ void c(FaceActionUI faceActionUI) {
        AppMethodBeat.i(743);
        ab.d("MicroMsg.FaceActionUI", "initCamera");
        faceActionUI.mcZ = new b(faceActionUI, faceActionUI.mca);
        faceActionUI.mcZ.mdy = faceActionUI.mcS;
        faceActionUI.mcZ.mcP = faceActionUI.mcP;
        faceActionUI.mcZ.mdA = faceActionUI.mcO;
        faceActionUI.mcZ.mbW = faceActionUI.mbW;
        faceActionUI.mcZ.mbX = faceActionUI.mbX;
        faceActionUI.mcZ.mdE = faceActionUI.mcU;
        faceActionUI.mcZ.mdD = faceActionUI.mcR;
        faceActionUI.mcZ.a(faceActionUI.mcQ);
        faceActionUI.mcZ.btX();
        AppMethodBeat.o(743);
    }

    static /* synthetic */ void j(FaceActionUI faceActionUI) {
        AppMethodBeat.i(745);
        d.mcq.release(false);
        faceActionUI.mcZ.btW();
        faceActionUI.lYg.setVisibility(8);
        faceActionUI.lYi.setVisibility(8);
        faceActionUI.mcN.setVisibility(0);
        faceActionUI.btQ();
        d.mcq.a(faceActionUI);
        AppMethodBeat.o(745);
    }
}
