package com.tencent.p177mm.plugin.facedetect.p401d;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.appbrand.jsapi.C19281ab;
import com.tencent.p177mm.plugin.appbrand.jsapi.wifi.C16681c;
import com.tencent.p177mm.plugin.appbrand.jsapi.wifi.C19523a;
import com.tencent.p177mm.plugin.appbrand.jsapi.wifi.C38405e;
import com.tencent.p177mm.plugin.facedetect.model.C11810f;
import com.tencent.p177mm.plugin.facedetect.model.C43032g;
import com.tencent.p177mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.p177mm.plugin.facedetect.p401d.C11798a.C11799b;
import com.tencent.p177mm.plugin.facedetect.p401d.C11802b.C11803b;
import com.tencent.p177mm.plugin.facedetect.p401d.C11802b.C11804a;
import com.tencent.p177mm.plugin.facedetect.p402e.C27922a;
import com.tencent.p177mm.plugin.facedetect.views.FaceNumberItemView;
import com.tencent.p177mm.plugin.facedetect.views.FaceNumberView;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.plugin.facedetect.d.d */
public final class C3023d implements C11802b {
    boolean eTf;
    private View kSh;
    private C11799b lUS;
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
    C11804a lVK;
    C7306ak lVL;
    private CountDownTimer lVM;
    Runnable lVN;
    boolean lVd;
    private View lVf;
    private String lVr;
    private int lVs;
    C11798a lVt;
    String[] lVu;
    int lVv;
    int lVw;
    private FaceNumberView lVx;
    private long lVy;
    private long lVz;

    /* renamed from: com.tencent.mm.plugin.facedetect.d.d$7 */
    class C30247 implements Runnable {
        C30247() {
        }

        public final void run() {
            AppMethodBeat.m2504i(C16681c.CTRL_INDEX);
            synchronized (C3023d.this.lVI) {
                try {
                    if (C3023d.this.lVC) {
                        C4990ab.m7416i("MicroMsg.NumberFaceMotion", "hy: user already start. do nothing");
                    } else {
                        C4990ab.m7420w("MicroMsg.NumberFaceMotion", "hy: not triggered symbol. auto start");
                        C3023d.this.lVC = true;
                        C3023d.m5313b(C3023d.this);
                    }
                } finally {
                    AppMethodBeat.m2505o(C16681c.CTRL_INDEX);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.d.d$8 */
    class C30258 implements Runnable {
        C30258() {
        }

        public final void run() {
            AppMethodBeat.m2504i(318);
            C3023d.this.bte();
            AppMethodBeat.m2505o(318);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.d.d$9 */
    class C30269 implements C11799b {
        C30269() {
        }

        public final void bsU() {
            AppMethodBeat.m2504i(ErrorCode.ERROR_QBSDK_INIT_CANLOADX5);
            synchronized (C3023d.this.lVI) {
                try {
                    C4990ab.m7416i("MicroMsg.NumberFaceMotion", "hy: triggered read symbol");
                    if (!C3023d.this.lVC && C3023d.this.lVD) {
                        C3023d.this.lVC = true;
                        C3023d.m5313b(C3023d.this);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(ErrorCode.ERROR_QBSDK_INIT_CANLOADX5);
                }
            }
        }

        public final void onError(int i) {
            AppMethodBeat.m2504i(320);
            synchronized (C3023d.this.lVI) {
                try {
                    C4990ab.m7421w("MicroMsg.NumberFaceMotion", "hy: on voice prepare error: %d", Integer.valueOf(i));
                    switch (i) {
                        case 11:
                            C3023d.this.lVA = true;
                            break;
                        default:
                            C3023d.this.lVJ = true;
                            C3023d.this.lVK = new C11804a(C4996ah.getResources().getString(C25738R.string.dc0));
                            break;
                    }
                } finally {
                    AppMethodBeat.m2505o(320);
                }
                AppMethodBeat.m2505o(320);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.d.d$6 */
    class C30276 implements Runnable {
        C30276() {
        }

        public final void run() {
            AppMethodBeat.m2504i(C19523a.CTRL_INDEX);
            if (C27922a.btw().lZc) {
                C3023d.this.lVt.mo23596a(C27922a.btw().btx());
                C27922a.btw().mo45816EL();
            }
            AppMethodBeat.m2505o(C19523a.CTRL_INDEX);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.d.d$5 */
    class C30285 implements Runnable {
        C30285() {
        }

        public final void run() {
            AppMethodBeat.m2504i(C38405e.CTRL_INDEX);
            C3023d.m5312a(C3023d.this);
            AppMethodBeat.m2505o(C38405e.CTRL_INDEX);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.d.d$2 */
    class C30302 extends CountDownTimer {
        C30302() {
            super(Long.MAX_VALUE, 1000);
        }

        public final void onTick(long j) {
            AppMethodBeat.m2504i(C31128d.MIC_PTU_DANNAI);
            C4990ab.m7416i("MicroMsg.NumberFaceMotion", "hy: on ticked");
            if (C3023d.this.eTf) {
                C4990ab.m7420w("MicroMsg.NumberFaceMotion", "hy: isEnd. trigger cancel");
                cancel();
                AppMethodBeat.m2505o(C31128d.MIC_PTU_DANNAI);
            } else if (C3023d.this.lVB) {
                C4990ab.m7416i("MicroMsg.NumberFaceMotion", "hy: suspend.");
                AppMethodBeat.m2505o(C31128d.MIC_PTU_DANNAI);
            } else {
                C4990ab.m7417i("MicroMsg.NumberFaceMotion", "hy: mCurrentShowedIndexInItem: %d, mItemDatas[mCurrentGroupDataIndex].length() - 1: %d, mCurrentGroupDataIndex: %d, mItemDatas.length - 1 : %d", Integer.valueOf(C3023d.this.lVw), Integer.valueOf(C3023d.this.lVu[C3023d.this.lVv].length() - 1), Integer.valueOf(C3023d.this.lVv), Integer.valueOf(C3023d.this.lVu.length - 1));
                if (C3023d.this.lVw < C3023d.this.lVu[C3023d.this.lVv].length() - 1) {
                    C3023d c3023d = C3023d.this;
                    c3023d.lVw++;
                    C3023d.this.lVL.sendEmptyMessage(0);
                    AppMethodBeat.m2505o(C31128d.MIC_PTU_DANNAI);
                    return;
                }
                C4990ab.m7416i("MicroMsg.NumberFaceMotion", "hy: last number in group");
                C5004al.m7442n(C3023d.this.lVN, 1500);
                C3023d.this.eTf = true;
                cancel();
                C3023d.this.eTf = true;
                AppMethodBeat.m2505o(C31128d.MIC_PTU_DANNAI);
            }
        }

        public final void onFinish() {
            AppMethodBeat.m2504i(C31128d.MIC_PTU_HONGKONG);
            C4990ab.m7416i("MicroMsg.NumberFaceMotion", "hy: on count number finished");
            AppMethodBeat.m2505o(C31128d.MIC_PTU_HONGKONG);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.d.d$3 */
    class C30313 implements Runnable {
        C30313() {
        }

        public final void run() {
            AppMethodBeat.m2504i(312);
            synchronized (C3023d.this.lVI) {
                try {
                    if (C3023d.this.lVv >= C3023d.this.lVu.length - 1) {
                        C4990ab.m7416i("MicroMsg.NumberFaceMotion", "hy: already last. handle upper judge.");
                        C3023d.this.lVd = true;
                        C11810f c11810f = C11810f.lTL;
                        byte[] e = C5730e.m8632e(C3023d.this.lVt.lUU, -1, -1);
                        C43032g c43032g = c11810f.lTM.lVR;
                        if (c43032g.lTP == null) {
                            C4990ab.m7412e("MicroMsg.FaceDetectNativeManager", "hy: set face data instance null!");
                        } else {
                            c43032g.lTP.engineSetVoiceData(e);
                        }
                    } else {
                        C4990ab.m7416i("MicroMsg.NumberFaceMotion", "hy: startShowNext");
                        C3023d c3023d = C3023d.this;
                        c3023d.lVv++;
                        C3023d.this.lVw = -1;
                        C3023d.this.mo7253hb(true);
                        C3023d.this.btd();
                    }
                } finally {
                    AppMethodBeat.m2505o(312);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.d.d$4 */
    class C30324 implements AnimationListener {

        /* renamed from: com.tencent.mm.plugin.facedetect.d.d$4$1 */
        class C30331 implements Runnable {
            C30331() {
            }

            public final void run() {
                AppMethodBeat.m2504i(313);
                C3023d.m5312a(C3023d.this);
                AppMethodBeat.m2505o(313);
            }
        }

        C30324() {
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(314);
            C5004al.m7442n(new C30331(), 500);
            AppMethodBeat.m2505o(314);
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    public C3023d(String str) {
        AppMethodBeat.m2504i(ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_01);
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
        this.lVL = new C7306ak(Looper.getMainLooper()) {
            public final void handleMessage(Message message) {
                AppMethodBeat.m2504i(C31128d.MIC_PTU_MUSE);
                super.handleMessage(message);
                switch (message.what) {
                    case 0:
                        C4990ab.m7416i("MicroMsg.NumberFaceMotion", "hy: refresh number");
                        C3023d.this.btd();
                        break;
                }
                AppMethodBeat.m2505o(C31128d.MIC_PTU_MUSE);
            }
        };
        this.lVM = new C30302();
        this.lVN = new C30313();
        this.lUS = new C30269();
        this.lVt = new C11798a();
        this.lVt.lUS = this.lUS;
        this.lVE = AnimationUtils.loadAnimation(C4996ah.getContext(), C25738R.anim.f8403df);
        this.lVF = AnimationUtils.loadAnimation(C4996ah.getContext(), C25738R.anim.f8321as);
        this.lVH = AnimationUtils.loadAnimation(C4996ah.getContext(), C25738R.anim.f8332b5);
        this.lVH.setDuration(250);
        this.lVH.setFillAfter(true);
        this.lVr = str;
        this.lVs = this.lVr == null ? 0 : this.lVr.length();
        btc();
        if (btb()) {
            this.lVG = (AnimationSet) AnimationUtils.loadAnimation(C4996ah.getContext(), C25738R.anim.f8322at);
        } else {
            this.lVG = (AnimationSet) AnimationUtils.loadAnimation(C4996ah.getContext(), C25738R.anim.f8323au);
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) C4996ah.getResources().getDimensionPixelSize(C25738R.dimen.a1q));
        translateAnimation.setDuration((long) C4996ah.getContext().getResources().getInteger(C25738R.integer.f11612j));
        this.lVG.addAnimation(translateAnimation);
        C4990ab.m7417i("MicroMsg.NumberFaceMotion", "hy: starting read number: %s", this.lVr);
        AppMethodBeat.m2505o(ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_01);
    }

    private boolean btb() {
        return this.lVs >= 6;
    }

    private void btc() {
        int i = 0;
        AppMethodBeat.m2504i(ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_02);
        if (C5046bo.isNullOrNil(this.lVr) || !btb()) {
            this.lVu = new String[1];
            this.lVu[0] = this.lVr;
            AppMethodBeat.m2505o(ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_02);
            return;
        }
        C4990ab.m7417i("MicroMsg.NumberFaceMotion", "hy: data too long. need to split into %d rounds", Integer.valueOf(2));
        this.lVu = new String[2];
        int i2 = this.lVs / 2;
        while (i < 2) {
            this.lVu[i] = this.lVr.substring(i2 * i, (i + 1) * i2);
            i++;
        }
        AppMethodBeat.m2505o(ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_02);
    }

    public final boolean bsV() {
        return this.lVd;
    }

    private TextView bta() {
        AppMethodBeat.m2504i(323);
        if (this.kSh != null) {
            TextView textView = (TextView) this.kSh.findViewById(2131823775);
            AppMethodBeat.m2505o(323);
            return textView;
        }
        AppMethodBeat.m2505o(323);
        return null;
    }

    public final void setBusinessTip(String str) {
        AppMethodBeat.m2504i(C19281ab.CTRL_INDEX);
        ((TextView) this.lVf.findViewById(2131823775)).setText(str);
        AppMethodBeat.m2505o(C19281ab.CTRL_INDEX);
    }

    /* renamed from: a */
    public final void mo7238a(Context context, ViewGroup viewGroup, ViewGroup viewGroup2) {
        AppMethodBeat.m2504i(ErrorCode.THROWABLE_INITX5CORE);
        C4990ab.m7410d("MicroMsg.NumberFaceMotion", "hy: on number init motion");
        this.kSh = LayoutInflater.from(context).inflate(2130969463, viewGroup2);
        this.lVx = (FaceNumberView) this.kSh.findViewById(2131823777);
        this.lVf = LayoutInflater.from(context).inflate(2130969461, viewGroup);
        m5314eb(this.lVu.length, -1);
        bta().startAnimation(this.lVE);
        if (this.lVx != null) {
            this.lVx.setVisibility(0);
            this.lVx.startAnimation(this.lVE);
            this.lVv = 0;
            mo7253hb(false);
            this.lVw = -1;
            btd();
            this.lVy = C5046bo.m7588yz();
            this.lVz = C5046bo.m7588yz();
            this.eTf = false;
        }
        AppMethodBeat.m2505o(ErrorCode.THROWABLE_INITX5CORE);
    }

    /* renamed from: vp */
    private static String m5315vp(int i) {
        AppMethodBeat.m2504i(ErrorCode.TEST_THROWABLE_IS_NULL);
        String string;
        switch (i) {
            case 1:
                string = C4996ah.getContext().getString(C25738R.string.bl2);
                AppMethodBeat.m2505o(ErrorCode.TEST_THROWABLE_IS_NULL);
                return string;
            case 2:
                string = C4996ah.getContext().getString(C25738R.string.bl3);
                AppMethodBeat.m2505o(ErrorCode.TEST_THROWABLE_IS_NULL);
                return string;
            case 3:
                string = C4996ah.getContext().getString(C25738R.string.bl5);
                AppMethodBeat.m2505o(ErrorCode.TEST_THROWABLE_IS_NULL);
                return string;
            case 4:
                string = C4996ah.getContext().getString(C25738R.string.bl6);
                AppMethodBeat.m2505o(ErrorCode.TEST_THROWABLE_IS_NULL);
                return string;
            default:
                C4990ab.m7412e("MicroMsg.NumberFaceMotion", "hy: unknown length!!");
                string = "";
                AppMethodBeat.m2505o(ErrorCode.TEST_THROWABLE_IS_NULL);
                return string;
        }
    }

    /* renamed from: eb */
    private void m5314eb(int i, int i2) {
        AppMethodBeat.m2504i(ErrorCode.TEST_THROWABLE_ISNOT_NULL);
        C4990ab.m7417i("MicroMsg.NumberFaceMotion", "alvinluo groupIndex: %d, itemDataLength: %d", Integer.valueOf(i2), Integer.valueOf(i));
        if (bta() != null) {
            if (i == 1) {
                bta().setText(C4996ah.getContext().getString(C25738R.string.bl9));
                AppMethodBeat.m2505o(ErrorCode.TEST_THROWABLE_ISNOT_NULL);
                return;
            }
            CharSequence string;
            TextView bta = bta();
            if (i2 == -1) {
                string = C4996ah.getContext().getString(C25738R.string.bl8, new Object[]{C3023d.m5316vq(i)});
            } else {
                string = C4996ah.getContext().getString(C25738R.string.bl7, new Object[]{C3023d.m5315vp(this.lVv + 1)});
            }
            bta.setText(string);
            if (i2 > 0) {
                C4990ab.m7417i("MicroMsg.NumberFaceMotion", "alvinluo start %d group number", Integer.valueOf(i2 + 1));
                C11810f.lTL.bsF();
            }
        }
        AppMethodBeat.m2505o(ErrorCode.TEST_THROWABLE_ISNOT_NULL);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: hb */
    public final void mo7253hb(boolean z) {
        AppMethodBeat.m2504i(ErrorCode.THROWABLE_INITTESRUNTIMEENVIRONMENT);
        if (this.lVx != null) {
            m5314eb(this.lVu.length, this.lVv);
            this.lVx.setNumberLengthAndInflate(this.lVu[this.lVv].length());
            this.lVD = false;
            if (z) {
                this.lVE.setAnimationListener(new C30324());
                if (this.kSh != null) {
                    this.kSh.startAnimation(this.lVE);
                    AppMethodBeat.m2505o(ErrorCode.THROWABLE_INITTESRUNTIMEENVIRONMENT);
                    return;
                }
            }
            C5004al.m7442n(new C30285(), 500);
        }
        AppMethodBeat.m2505o(ErrorCode.THROWABLE_INITTESRUNTIMEENVIRONMENT);
    }

    /* Access modifiers changed, original: final */
    public final void btd() {
        AppMethodBeat.m2504i(ErrorCode.ERROR_GETSTRINGARRAY_JARFILE);
        if (this.lVx != null) {
            if (this.lVv >= 0) {
                this.lVx.mo35956Lw(this.lVu[this.lVv].substring(0, this.lVw + 1));
                AppMethodBeat.m2505o(ErrorCode.ERROR_GETSTRINGARRAY_JARFILE);
                return;
            }
            this.lVx.mo35956Lw(null);
        }
        AppMethodBeat.m2505o(ErrorCode.ERROR_GETSTRINGARRAY_JARFILE);
    }

    /* renamed from: vq */
    private static String m5316vq(int i) {
        AppMethodBeat.m2504i(ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE);
        String string;
        switch (i) {
            case 2:
                string = C4996ah.getContext().getString(C25738R.string.bl4);
                AppMethodBeat.m2505o(ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE);
                return string;
            default:
                string = C3023d.m5315vp(i);
                AppMethodBeat.m2505o(ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE);
                return string;
        }
    }

    public final boolean bsW() {
        this.lVB = true;
        return this.lVJ;
    }

    /* renamed from: a */
    public final boolean mo7239a(FaceCharacteristicsResult faceCharacteristicsResult) {
        this.lVB = true;
        return this.lVJ;
    }

    /* renamed from: b */
    public final boolean mo7240b(FaceCharacteristicsResult faceCharacteristicsResult) {
        this.lVB = false;
        return this.lVJ;
    }

    public final void bsX() {
        AppMethodBeat.m2504i(ErrorCode.ERROR_QBSDK_INIT_ERROR_EMPTY_BUNDLE);
        this.eTf = true;
        this.lVJ = false;
        C11798a c11798a = this.lVt;
        c11798a.lUT = true;
        C4990ab.m7416i("MicroMsg.FaceVoiceRecordLogic", "hy: face start reset");
        synchronized (c11798a) {
            try {
                if (c11798a.coZ != null) {
                    c11798a.coZ.mo4590EB();
                    c11798a.coZ = null;
                }
                if (c11798a.gaY != null) {
                    c11798a.gaY.mo43820Fe();
                    c11798a.gaY = null;
                }
                if (c11798a.gbh != null) {
                    c11798a.gbh.release();
                    c11798a.gbh = null;
                    c11798a.gbH = true;
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.FaceVoiceRecordLogic", e, "mVoiceSilentDetectAPI.release error", new Object[0]);
            } catch (Throwable th) {
                AppMethodBeat.m2505o(ErrorCode.ERROR_QBSDK_INIT_ERROR_EMPTY_BUNDLE);
            }
            c11798a.gaT = 0;
        }
        C11798a c11798a2 = this.lVt;
        C4990ab.m7416i("MicroMsg.FaceVoiceRecordLogic", "hy: recycling voice.");
        c11798a2.lUS = null;
        this.lVt.bsT();
        if (C27922a.btw().lZc && C27922a.btw().isStarted()) {
            this.lVt.lUV.remove(C27922a.btw().btx());
            if (this.lVd) {
                C27922a.btw().mo45817a(null);
            } else {
                C27922a.btw().bty();
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
        AppMethodBeat.m2505o(ErrorCode.ERROR_QBSDK_INIT_ERROR_EMPTY_BUNDLE);
    }

    public final C11803b bsY() {
        AppMethodBeat.m2504i(332);
        C11803b c11803b = new C11803b(90004, "user cancelled in processing");
        AppMethodBeat.m2505o(332);
        return c11803b;
    }

    public final C11804a bsZ() {
        return this.lVK;
    }

    /* Access modifiers changed, original: final */
    public final void bte() {
        AppMethodBeat.m2504i(333);
        this.lVM.start();
        AppMethodBeat.m2505o(333);
    }
}
