package com.tencent.mm.plugin.facedetect.d;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.facedetect.d.a.b;
import com.tencent.mm.plugin.facedetect.d.b.a;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.plugin.facedetect.model.g;
import com.tencent.mm.plugin.facedetect.views.FaceNumberItemView;
import com.tencent.mm.plugin.facedetect.views.FaceNumberView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

public final class d implements b {
    boolean eTf;
    private View kSh;
    private b lUS;
    boolean lVA;
    boolean lVB;
    boolean lVC;
    boolean lVD;
    private Animation lVE;
    private Animation lVF;
    private AnimationSet lVG;
    private Animation lVH;
    final Object lVI;
    boolean lVJ;
    a lVK;
    ak lVL;
    private CountDownTimer lVM;
    Runnable lVN;
    boolean lVd;
    private View lVf;
    private String lVr;
    private int lVs;
    a lVt;
    String[] lVu;
    int lVv;
    int lVw;
    private FaceNumberView lVx;
    private long lVy;
    private long lVz;

    public d(String str) {
        AppMethodBeat.i(ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_01);
        this.lVr = null;
        this.lVs = 0;
        this.lVt = null;
        this.lVu = null;
        this.lVv = 0;
        this.lVw = 0;
        this.kSh = null;
        this.lVx = null;
        this.lVd = false;
        this.lVy = -1;
        this.lVz = -1;
        this.lVA = false;
        this.lVB = false;
        this.lVC = false;
        this.lVD = false;
        this.lVI = new Object();
        this.eTf = false;
        this.lVJ = false;
        this.lVK = null;
        this.lVL = new ak(Looper.getMainLooper()) {
            public final void handleMessage(Message message) {
                AppMethodBeat.i(com.tencent.view.d.MIC_PTU_MUSE);
                super.handleMessage(message);
                switch (message.what) {
                    case 0:
                        ab.i("MicroMsg.NumberFaceMotion", "hy: refresh number");
                        d.this.btd();
                        break;
                }
                AppMethodBeat.o(com.tencent.view.d.MIC_PTU_MUSE);
            }
        };
        this.lVM = new CountDownTimer() {
            public final void onTick(long j) {
                AppMethodBeat.i(com.tencent.view.d.MIC_PTU_DANNAI);
                ab.i("MicroMsg.NumberFaceMotion", "hy: on ticked");
                if (d.this.eTf) {
                    ab.w("MicroMsg.NumberFaceMotion", "hy: isEnd. trigger cancel");
                    cancel();
                    AppMethodBeat.o(com.tencent.view.d.MIC_PTU_DANNAI);
                } else if (d.this.lVB) {
                    ab.i("MicroMsg.NumberFaceMotion", "hy: suspend.");
                    AppMethodBeat.o(com.tencent.view.d.MIC_PTU_DANNAI);
                } else {
                    ab.i("MicroMsg.NumberFaceMotion", "hy: mCurrentShowedIndexInItem: %d, mItemDatas[mCurrentGroupDataIndex].length() - 1: %d, mCurrentGroupDataIndex: %d, mItemDatas.length - 1 : %d", Integer.valueOf(d.this.lVw), Integer.valueOf(d.this.lVu[d.this.lVv].length() - 1), Integer.valueOf(d.this.lVv), Integer.valueOf(d.this.lVu.length - 1));
                    if (d.this.lVw < d.this.lVu[d.this.lVv].length() - 1) {
                        d dVar = d.this;
                        dVar.lVw++;
                        d.this.lVL.sendEmptyMessage(0);
                        AppMethodBeat.o(com.tencent.view.d.MIC_PTU_DANNAI);
                        return;
                    }
                    ab.i("MicroMsg.NumberFaceMotion", "hy: last number in group");
                    al.n(d.this.lVN, 1500);
                    d.this.eTf = true;
                    cancel();
                    d.this.eTf = true;
                    AppMethodBeat.o(com.tencent.view.d.MIC_PTU_DANNAI);
                }
            }

            public final void onFinish() {
                AppMethodBeat.i(com.tencent.view.d.MIC_PTU_HONGKONG);
                ab.i("MicroMsg.NumberFaceMotion", "hy: on count number finished");
                AppMethodBeat.o(com.tencent.view.d.MIC_PTU_HONGKONG);
            }
        };
        this.lVN = new Runnable() {
            public final void run() {
                AppMethodBeat.i(312);
                synchronized (d.this.lVI) {
                    try {
                        if (d.this.lVv >= d.this.lVu.length - 1) {
                            ab.i("MicroMsg.NumberFaceMotion", "hy: already last. handle upper judge.");
                            d.this.lVd = true;
                            f fVar = f.lTL;
                            byte[] e = e.e(d.this.lVt.lUU, -1, -1);
                            g gVar = fVar.lTM.lVR;
                            if (gVar.lTP == null) {
                                ab.e("MicroMsg.FaceDetectNativeManager", "hy: set face data instance null!");
                            } else {
                                gVar.lTP.engineSetVoiceData(e);
                            }
                        } else {
                            ab.i("MicroMsg.NumberFaceMotion", "hy: startShowNext");
                            d dVar = d.this;
                            dVar.lVv++;
                            d.this.lVw = -1;
                            d.this.hb(true);
                            d.this.btd();
                        }
                    } finally {
                        AppMethodBeat.o(312);
                    }
                }
            }
        };
        this.lUS = new b() {
            public final void bsU() {
                AppMethodBeat.i(ErrorCode.ERROR_QBSDK_INIT_CANLOADX5);
                synchronized (d.this.lVI) {
                    try {
                        ab.i("MicroMsg.NumberFaceMotion", "hy: triggered read symbol");
                        if (!d.this.lVC && d.this.lVD) {
                            d.this.lVC = true;
                            d.b(d.this);
                        }
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(ErrorCode.ERROR_QBSDK_INIT_CANLOADX5);
                    }
                }
            }

            public final void onError(int i) {
                AppMethodBeat.i(320);
                synchronized (d.this.lVI) {
                    try {
                        ab.w("MicroMsg.NumberFaceMotion", "hy: on voice prepare error: %d", Integer.valueOf(i));
                        switch (i) {
                            case 11:
                                d.this.lVA = true;
                                break;
                            default:
                                d.this.lVJ = true;
                                d.this.lVK = new a(ah.getResources().getString(R.string.dc0));
                                break;
                        }
                    } finally {
                        AppMethodBeat.o(320);
                    }
                    AppMethodBeat.o(320);
                }
            }
        };
        this.lVt = new a();
        this.lVt.lUS = this.lUS;
        this.lVE = AnimationUtils.loadAnimation(ah.getContext(), R.anim.df);
        this.lVF = AnimationUtils.loadAnimation(ah.getContext(), R.anim.as);
        this.lVH = AnimationUtils.loadAnimation(ah.getContext(), R.anim.b5);
        this.lVH.setDuration(250);
        this.lVH.setFillAfter(true);
        this.lVr = str;
        this.lVs = this.lVr == null ? 0 : this.lVr.length();
        btc();
        if (btb()) {
            this.lVG = (AnimationSet) AnimationUtils.loadAnimation(ah.getContext(), R.anim.at);
        } else {
            this.lVG = (AnimationSet) AnimationUtils.loadAnimation(ah.getContext(), R.anim.au);
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) ah.getResources().getDimensionPixelSize(R.dimen.a1q));
        translateAnimation.setDuration((long) ah.getContext().getResources().getInteger(R.integer.j));
        this.lVG.addAnimation(translateAnimation);
        ab.i("MicroMsg.NumberFaceMotion", "hy: starting read number: %s", this.lVr);
        AppMethodBeat.o(ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_01);
    }

    private boolean btb() {
        return this.lVs >= 6;
    }

    private void btc() {
        int i = 0;
        AppMethodBeat.i(ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_02);
        if (bo.isNullOrNil(this.lVr) || !btb()) {
            this.lVu = new String[1];
            this.lVu[0] = this.lVr;
            AppMethodBeat.o(ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_02);
            return;
        }
        ab.i("MicroMsg.NumberFaceMotion", "hy: data too long. need to split into %d rounds", Integer.valueOf(2));
        this.lVu = new String[2];
        int i2 = this.lVs / 2;
        while (i < 2) {
            this.lVu[i] = this.lVr.substring(i2 * i, (i + 1) * i2);
            i++;
        }
        AppMethodBeat.o(ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_02);
    }

    public final boolean bsV() {
        return this.lVd;
    }

    private TextView bta() {
        AppMethodBeat.i(323);
        if (this.kSh != null) {
            TextView textView = (TextView) this.kSh.findViewById(R.id.bmb);
            AppMethodBeat.o(323);
            return textView;
        }
        AppMethodBeat.o(323);
        return null;
    }

    public final void setBusinessTip(String str) {
        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.ab.CTRL_INDEX);
        ((TextView) this.lVf.findViewById(R.id.bmb)).setText(str);
        AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.ab.CTRL_INDEX);
    }

    public final void a(Context context, ViewGroup viewGroup, ViewGroup viewGroup2) {
        AppMethodBeat.i(ErrorCode.THROWABLE_INITX5CORE);
        ab.d("MicroMsg.NumberFaceMotion", "hy: on number init motion");
        this.kSh = LayoutInflater.from(context).inflate(R.layout.x8, viewGroup2);
        this.lVx = (FaceNumberView) this.kSh.findViewById(R.id.bmd);
        this.lVf = LayoutInflater.from(context).inflate(R.layout.x6, viewGroup);
        eb(this.lVu.length, -1);
        bta().startAnimation(this.lVE);
        if (this.lVx != null) {
            this.lVx.setVisibility(0);
            this.lVx.startAnimation(this.lVE);
            this.lVv = 0;
            hb(false);
            this.lVw = -1;
            btd();
            this.lVy = bo.yz();
            this.lVz = bo.yz();
            this.eTf = false;
        }
        AppMethodBeat.o(ErrorCode.THROWABLE_INITX5CORE);
    }

    private static String vp(int i) {
        AppMethodBeat.i(ErrorCode.TEST_THROWABLE_IS_NULL);
        String string;
        switch (i) {
            case 1:
                string = ah.getContext().getString(R.string.bl2);
                AppMethodBeat.o(ErrorCode.TEST_THROWABLE_IS_NULL);
                return string;
            case 2:
                string = ah.getContext().getString(R.string.bl3);
                AppMethodBeat.o(ErrorCode.TEST_THROWABLE_IS_NULL);
                return string;
            case 3:
                string = ah.getContext().getString(R.string.bl5);
                AppMethodBeat.o(ErrorCode.TEST_THROWABLE_IS_NULL);
                return string;
            case 4:
                string = ah.getContext().getString(R.string.bl6);
                AppMethodBeat.o(ErrorCode.TEST_THROWABLE_IS_NULL);
                return string;
            default:
                ab.e("MicroMsg.NumberFaceMotion", "hy: unknown length!!");
                string = "";
                AppMethodBeat.o(ErrorCode.TEST_THROWABLE_IS_NULL);
                return string;
        }
    }

    private void eb(int i, int i2) {
        AppMethodBeat.i(ErrorCode.TEST_THROWABLE_ISNOT_NULL);
        ab.i("MicroMsg.NumberFaceMotion", "alvinluo groupIndex: %d, itemDataLength: %d", Integer.valueOf(i2), Integer.valueOf(i));
        if (bta() != null) {
            if (i == 1) {
                bta().setText(ah.getContext().getString(R.string.bl9));
                AppMethodBeat.o(ErrorCode.TEST_THROWABLE_ISNOT_NULL);
                return;
            }
            CharSequence string;
            TextView bta = bta();
            if (i2 == -1) {
                string = ah.getContext().getString(R.string.bl8, new Object[]{vq(i)});
            } else {
                string = ah.getContext().getString(R.string.bl7, new Object[]{vp(this.lVv + 1)});
            }
            bta.setText(string);
            if (i2 > 0) {
                ab.i("MicroMsg.NumberFaceMotion", "alvinluo start %d group number", Integer.valueOf(i2 + 1));
                f.lTL.bsF();
            }
        }
        AppMethodBeat.o(ErrorCode.TEST_THROWABLE_ISNOT_NULL);
    }

    /* Access modifiers changed, original: final */
    public final void hb(boolean z) {
        AppMethodBeat.i(ErrorCode.THROWABLE_INITTESRUNTIMEENVIRONMENT);
        if (this.lVx != null) {
            eb(this.lVu.length, this.lVv);
            this.lVx.setNumberLengthAndInflate(this.lVu[this.lVv].length());
            this.lVD = false;
            if (z) {
                this.lVE.setAnimationListener(new AnimationListener() {
                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        AppMethodBeat.i(314);
                        al.n(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(313);
                                d.a(d.this);
                                AppMethodBeat.o(313);
                            }
                        }, 500);
                        AppMethodBeat.o(314);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }
                });
                if (this.kSh != null) {
                    this.kSh.startAnimation(this.lVE);
                    AppMethodBeat.o(ErrorCode.THROWABLE_INITTESRUNTIMEENVIRONMENT);
                    return;
                }
            }
            al.n(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.wifi.e.CTRL_INDEX);
                    d.a(d.this);
                    AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.wifi.e.CTRL_INDEX);
                }
            }, 500);
        }
        AppMethodBeat.o(ErrorCode.THROWABLE_INITTESRUNTIMEENVIRONMENT);
    }

    /* Access modifiers changed, original: final */
    public final void btd() {
        AppMethodBeat.i(ErrorCode.ERROR_GETSTRINGARRAY_JARFILE);
        if (this.lVx != null) {
            if (this.lVv >= 0) {
                this.lVx.Lw(this.lVu[this.lVv].substring(0, this.lVw + 1));
                AppMethodBeat.o(ErrorCode.ERROR_GETSTRINGARRAY_JARFILE);
                return;
            }
            this.lVx.Lw(null);
        }
        AppMethodBeat.o(ErrorCode.ERROR_GETSTRINGARRAY_JARFILE);
    }

    private static String vq(int i) {
        AppMethodBeat.i(ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE);
        String string;
        switch (i) {
            case 2:
                string = ah.getContext().getString(R.string.bl4);
                AppMethodBeat.o(ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE);
                return string;
            default:
                string = vp(i);
                AppMethodBeat.o(ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE);
                return string;
        }
    }

    public final boolean bsW() {
        this.lVB = true;
        return this.lVJ;
    }

    public final boolean a(FaceCharacteristicsResult faceCharacteristicsResult) {
        this.lVB = true;
        return this.lVJ;
    }

    public final boolean b(FaceCharacteristicsResult faceCharacteristicsResult) {
        this.lVB = false;
        return this.lVJ;
    }

    public final void bsX() {
        AppMethodBeat.i(ErrorCode.ERROR_QBSDK_INIT_ERROR_EMPTY_BUNDLE);
        this.eTf = true;
        this.lVJ = false;
        a aVar = this.lVt;
        aVar.lUT = true;
        ab.i("MicroMsg.FaceVoiceRecordLogic", "hy: face start reset");
        synchronized (aVar) {
            try {
                if (aVar.coZ != null) {
                    aVar.coZ.EB();
                    aVar.coZ = null;
                }
                if (aVar.gaY != null) {
                    aVar.gaY.Fe();
                    aVar.gaY = null;
                }
                if (aVar.gbh != null) {
                    aVar.gbh.release();
                    aVar.gbh = null;
                    aVar.gbH = true;
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.FaceVoiceRecordLogic", e, "mVoiceSilentDetectAPI.release error", new Object[0]);
            } catch (Throwable th) {
                AppMethodBeat.o(ErrorCode.ERROR_QBSDK_INIT_ERROR_EMPTY_BUNDLE);
            }
            aVar.gaT = 0;
        }
        a aVar2 = this.lVt;
        ab.i("MicroMsg.FaceVoiceRecordLogic", "hy: recycling voice.");
        aVar2.lUS = null;
        this.lVt.bsT();
        if (com.tencent.mm.plugin.facedetect.e.a.btw().lZc && com.tencent.mm.plugin.facedetect.e.a.btw().isStarted()) {
            this.lVt.lUV.remove(com.tencent.mm.plugin.facedetect.e.a.btw().btx());
            if (this.lVd) {
                com.tencent.mm.plugin.facedetect.e.a.btw().a(null);
            } else {
                com.tencent.mm.plugin.facedetect.e.a.btw().bty();
            }
        }
        this.lVM.cancel();
        this.lVL.removeCallbacksAndMessages(null);
        if (this.lVx != null) {
            FaceNumberView faceNumberView = this.lVx;
            if (faceNumberView.mbk != null && faceNumberView.mbk.length > 0) {
                for (FaceNumberItemView btK : faceNumberView.mbk) {
                    btK.btK();
                }
            }
        }
        if (this.kSh != null) {
            this.lVd = false;
            this.lVy = -1;
            this.kSh = null;
            this.lVx = null;
        }
        AppMethodBeat.o(ErrorCode.ERROR_QBSDK_INIT_ERROR_EMPTY_BUNDLE);
    }

    public final b.b bsY() {
        AppMethodBeat.i(332);
        b.b bVar = new b.b(90004, "user cancelled in processing");
        AppMethodBeat.o(332);
        return bVar;
    }

    public final a bsZ() {
        return this.lVK;
    }

    /* Access modifiers changed, original: final */
    public final void bte() {
        AppMethodBeat.i(333);
        this.lVM.start();
        AppMethodBeat.o(333);
    }
}
