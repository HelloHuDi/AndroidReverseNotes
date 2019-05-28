package com.tencent.p177mm.plugin.mmsight.p458ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.api.C1241c;
import com.tencent.p177mm.api.C25784s;
import com.tencent.p177mm.api.C25784s.C25785a.C17916a;
import com.tencent.p177mm.api.C25784s.C8957c;
import com.tencent.p177mm.api.C32247e;
import com.tencent.p177mm.api.C32249g;
import com.tencent.p177mm.api.C37464n;
import com.tencent.p177mm.api.C37465p;
import com.tencent.p177mm.api.C8956r;
import com.tencent.p177mm.media.p254g.C37894c;
import com.tencent.p177mm.modelcontrol.VideoTransPara;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p209c.C25998g;
import com.tencent.p177mm.p612ui.C5230ak;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.plugin.mmsight.C3475d;
import com.tencent.p177mm.plugin.mmsight.api.C46074a;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43305j;
import com.tencent.p177mm.plugin.mmsight.p1490a.C34537a;
import com.tencent.p177mm.plugin.mmsight.p1490a.C34537a.C34539b;
import com.tencent.p177mm.plugin.mmsight.segment.C12575c.C12576a;
import com.tencent.p177mm.plugin.mmsight.segment.C12575c.C12577b;
import com.tencent.p177mm.plugin.mmsight.segment.RecyclerThumbSeekBar;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14981a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.VideoPlayerTextureView;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

/* renamed from: com.tencent.mm.plugin.mmsight.ui.b */
public final class C12597b {
    private static int ehv;
    private static final Object oBK = new Object();
    private MMActivity crP;
    String cvZ;
    private C44275p eir;
    private boolean oBA = false;
    private int oBB = -1;
    public int oBC = -1;
    public int oBD = -1;
    private C7564ap oBE;
    private ViewGroup oBF;
    private C25784s oBG;
    private C1241c oBH;
    private C46074a oBI;
    private C37894c oBJ;
    public C12615a oBL;
    private boolean oBM = false;
    public boolean oBN = false;
    private boolean oBO = false;
    private boolean oBP = false;
    public String oBQ = null;
    public int oBR = -1;
    private C34539b oBS;
    public boolean oBT = false;
    public boolean oBU = true;
    private RecyclerThumbSeekBar oBz;
    private VideoTransPara ouc;
    private VideoPlayerTextureView oxL;
    private VideoSeekBarEditorView oxM;
    public int scene;
    private String videoPath;

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.b$1 */
    class C35011 implements C32249g {

        /* renamed from: com.tencent.mm.plugin.mmsight.ui.b$1$2 */
        class C35022 implements Runnable {
            C35022() {
            }

            public final void run() {
                AppMethodBeat.m2504i(55133);
                C12597b.this.oBL.bQg();
                AppMethodBeat.m2505o(55133);
            }
        }

        /* renamed from: com.tencent.mm.plugin.mmsight.ui.b$1$1 */
        class C35031 implements C37464n {

            /* renamed from: com.tencent.mm.plugin.mmsight.ui.b$1$1$1 */
            class C35051 implements Runnable {
                C35051() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(55127);
                    C12597b.this.eir = C30379h.m48458b(C12597b.this.crP, C12597b.this.crP.getString(C25738R.string.d02), false, null);
                    C12597b.this.oxL.pause();
                    C12597b.m20539a(C12597b.this, null);
                    AppMethodBeat.m2505o(55127);
                }
            }

            /* renamed from: com.tencent.mm.plugin.mmsight.ui.b$1$1$2 */
            class C35062 implements Runnable {
                C35062() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(55128);
                    C12597b.this.oBL.bQf();
                    AppMethodBeat.m2505o(55128);
                }
            }

            /* renamed from: com.tencent.mm.plugin.mmsight.ui.b$1$1$3 */
            class C35073 implements Runnable {
                C35073() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(55129);
                    C12597b.this.eir = C30379h.m48458b(C12597b.this.crP, C12597b.this.crP.getString(C25738R.string.d02), false, null);
                    C12597b.this.oxL.pause();
                    C12597b.m20539a(C12597b.this, null);
                    AppMethodBeat.m2505o(55129);
                }
            }

            C35031() {
            }

            public final void onError(Exception exception) {
                AppMethodBeat.m2504i(55131);
                C4990ab.m7413e("MicroMsg.MMSightVideoEditor", "photoEditor onError: %s", exception);
                AppMethodBeat.m2505o(55131);
            }

            /* renamed from: b */
            public final void mo7985b(final Bitmap bitmap, boolean z) {
                AppMethodBeat.m2504i(55132);
                C4990ab.m7417i("MicroMsg.MMSightVideoEditor", "photoEditor onSuccess: %s isNever：%s", bitmap, Boolean.valueOf(z));
                if (z) {
                    if (!(bitmap == null || bitmap.isRecycled())) {
                        bitmap.recycle();
                    }
                    if (C12597b.this.oBL == null || C12597b.this.oBN) {
                        if (C12597b.this.oBN) {
                            C5004al.m7441d(new C35073());
                            AppMethodBeat.m2505o(55132);
                            return;
                        }
                    } else if (C12597b.this.oBD <= 0 || C12597b.this.oBB <= 0 || C12597b.this.oBD > C12597b.this.oBB) {
                        C12597b.this.cvZ = C25998g.m41489cz(C12597b.this.videoPath);
                        C5004al.m7441d(new C35062());
                        AppMethodBeat.m2505o(55132);
                        return;
                    } else {
                        C5004al.m7441d(new C35051());
                        AppMethodBeat.m2505o(55132);
                        return;
                    }
                } else if (bitmap != null) {
                    C5004al.m7441d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(55130);
                            C12597b.this.eir = C30379h.m48458b(C12597b.this.crP, C12597b.this.crP.getString(C25738R.string.d02), false, null);
                            C12597b.this.oxL.pause();
                            C12597b.m20539a(C12597b.this, bitmap);
                            AppMethodBeat.m2505o(55130);
                        }
                    });
                }
                AppMethodBeat.m2505o(55132);
            }
        }

        C35011() {
        }

        public final void onFinish() {
            AppMethodBeat.m2504i(55134);
            C4990ab.m7416i("MicroMsg.MMSightVideoEditor", "photoEditor onFinish");
            C12597b.this.oBG.mo33292a(new C35031());
            AppMethodBeat.m2505o(55134);
        }

        public final void onExit() {
            AppMethodBeat.m2504i(55135);
            C4990ab.m7416i("MicroMsg.MMSightVideoEditor", "photoEditor onExit");
            C12597b.this.release();
            if (C12597b.this.oBL != null) {
                C5004al.m7441d(new C35022());
            }
            AppMethodBeat.m2505o(55135);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.b$8 */
    class C35088 implements OnClickListener {
        C35088() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(55153);
            if (C12597b.this.oBU) {
                C12597b.m20556p(C12597b.this);
                if (C12597b.this.oBC >= 0 && C12597b.this.oBD > 0) {
                    C12597b.this.oBM = true;
                }
                AppMethodBeat.m2505o(55153);
                return;
            }
            C12597b.m20558r(C12597b.this);
            AppMethodBeat.m2505o(55153);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.b$2 */
    class C125952 implements AnimatorListener {
        C125952() {
        }

        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(55136);
            if (C12597b.this.oxL != null) {
                C12597b.this.oxL.requestLayout();
            }
            AppMethodBeat.m2505o(55136);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationRepeat(Animator animator) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.b$9 */
    class C125969 implements Runnable {
        C125969() {
        }

        public final void run() {
            AppMethodBeat.m2504i(55154);
            C12597b.this.oBH.setFooterVisible(false);
            C12597b.this.oBH.setActionBarVisible(false);
            C12597b.this.oBH.setActivated(false);
            C12597b.m20549i(C12597b.this);
            AppMethodBeat.m2505o(55154);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.b$10 */
    class C1259810 implements C12576a {

        /* renamed from: com.tencent.mm.plugin.mmsight.ui.b$10$1 */
        class C125991 implements Runnable {
            C125991() {
            }

            public final void run() {
                AppMethodBeat.m2504i(55155);
                if (C12597b.this.eir != null) {
                    C12597b.this.eir.dismiss();
                }
                if (C12597b.this.oBL != null) {
                    C12597b.this.oBL.onError();
                }
                AppMethodBeat.m2505o(55155);
            }
        }

        C1259810() {
        }

        /* renamed from: iY */
        public final void mo17640iY(boolean z) {
            AppMethodBeat.m2504i(55156);
            if (z) {
                C4990ab.m7412e("MicroMsg.MMSightVideoEditor", "Not Supported init SegmentSeekBar failed.");
                C5004al.m7441d(new C125991());
                AppMethodBeat.m2505o(55156);
                return;
            }
            if (C12597b.this.oBz != null) {
                C12597b.this.oBB = C12597b.this.oBz.getDurationMs();
                C4990ab.m7417i("MicroMsg.MMSightVideoEditor", "thumbSeekBar onPrepared success %d", Integer.valueOf(C12597b.this.oBB));
                try {
                    if (C12597b.this.oxL != null) {
                        C12597b.this.oBC = Math.round(((float) C12597b.this.oBB) * C12597b.this.oBz.bQa());
                        C12597b.this.oBD = Math.round(((float) C12597b.this.oBB) * C12597b.this.oBz.bQb());
                        if (C12597b.this.oBD <= 0) {
                            if (C12597b.this.oBB <= (C12597b.this.ouc.duration * 1000) + 500) {
                                C12597b.this.oBD = C12597b.this.oBB;
                            } else {
                                C12597b.this.oBD = C12597b.this.ouc.duration * 1000;
                            }
                        }
                        C4990ab.m7417i("MicroMsg.MMSightVideoEditor", "thumbSeekBar onPrepared, start: %s, end: %s, duration: %s", Integer.valueOf(C12597b.this.oBC), Integer.valueOf(C12597b.this.oBD), Integer.valueOf(C12597b.this.oBB));
                    }
                    C12597b.m20564x(C12597b.this);
                    AppMethodBeat.m2505o(55156);
                    return;
                } catch (Exception e) {
                }
            }
            AppMethodBeat.m2505o(55156);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.b$7 */
    class C126007 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.mmsight.ui.b$7$1 */
        class C126011 implements Runnable {
            C126011() {
            }

            public final void run() {
                AppMethodBeat.m2504i(55150);
                C12597b.this.oBL.bQg();
                AppMethodBeat.m2505o(55150);
            }
        }

        /* renamed from: com.tencent.mm.plugin.mmsight.ui.b$7$2 */
        class C126022 implements Runnable {
            C126022() {
            }

            public final void run() {
                AppMethodBeat.m2504i(55151);
                C12597b.this.oBL.bQg();
                AppMethodBeat.m2505o(55151);
            }
        }

        C126007() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(55152);
            if (!C12597b.this.oBM && C12597b.this.oBB <= C12597b.this.ouc.duration) {
                C12597b.this.oBC = C12597b.this.oBD = -1;
                C12597b.this.oxM.bQM();
                C12597b.this.oBz = C12597b.this.oxM.oDA;
                C12597b.this.oBA = false;
            }
            if (C12597b.this.oBU) {
                C12597b.m20556p(C12597b.this);
                if (!(C12597b.this.oBM || !C12597b.this.oBT || C12597b.this.oBL == null)) {
                    C5004al.m7441d(new C126022());
                }
            } else if (C12597b.this.oBL != null) {
                C5004al.m7441d(new C126011());
                AppMethodBeat.m2505o(55152);
                return;
            }
            AppMethodBeat.m2505o(55152);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.b$11 */
    class C1260311 implements C12577b {
        C1260311() {
        }

        /* renamed from: U */
        public final void mo17633U(float f, float f2) {
            AppMethodBeat.m2504i(55157);
            if (C12597b.this.oxL == null) {
                AppMethodBeat.m2505o(55157);
                return;
            }
            int d = C12597b.this.oBB;
            C12597b.this.oBC = Math.round(((float) d) * f);
            C12597b.this.oBD = Math.round(((float) d) * f2);
            C4990ab.m7417i("MicroMsg.MMSightVideoEditor", "onRecyclerChanged, start: %s, end: %s %s %s", Integer.valueOf(C12597b.this.oBC), Integer.valueOf(C12597b.this.oBD), Float.valueOf(f), Float.valueOf(f2));
            C12597b.this.oxL.mo27356d((double) C12597b.this.oBC, true);
            AppMethodBeat.m2505o(55157);
        }

        public final void bQc() {
            AppMethodBeat.m2504i(55158);
            if (C12597b.this.oxL == null) {
                AppMethodBeat.m2505o(55158);
                return;
            }
            C12597b.this.oxL.pause();
            AppMethodBeat.m2505o(55158);
        }

        /* renamed from: V */
        public final void mo17634V(float f, float f2) {
            AppMethodBeat.m2504i(55159);
            if (C12597b.this.oxL == null) {
                AppMethodBeat.m2505o(55159);
                return;
            }
            int d = C12597b.this.oBB;
            C12597b.this.oBC = Math.round(((float) d) * f);
            C12597b.this.oBD = Math.round(((float) d) * f2);
            if (C12597b.this.oBD <= 0) {
                C12597b.this.oBD = 1000;
            }
            C12597b.this.oxL.mo27356d((double) C12597b.this.oBC, true);
            C4990ab.m7417i("MicroMsg.MMSightVideoEditor", "onUp, start: %s, end: %s %s %s", Integer.valueOf(C12597b.this.oBC), Integer.valueOf(C12597b.this.oBD), Float.valueOf(f), Float.valueOf(f2));
            AppMethodBeat.m2505o(55159);
        }

        /* renamed from: W */
        public final void mo17635W(float f, float f2) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.b$12 */
    class C1260412 implements C14981a {
        C1260412() {
        }

        /* renamed from: pL */
        public final void mo8557pL() {
        }

        /* renamed from: EA */
        public final void mo8553EA() {
            AppMethodBeat.m2504i(55160);
            if (C12597b.this.oBC > 0) {
                C12597b.this.oxL.mo27356d((double) C12597b.this.oBC, true);
                AppMethodBeat.m2505o(55160);
                return;
            }
            C12597b.this.oxL.mo27356d(0.0d, true);
            AppMethodBeat.m2505o(55160);
        }

        /* renamed from: dG */
        public final int mo8554dG(int i, int i2) {
            return 0;
        }

        /* renamed from: dH */
        public final void mo8555dH(int i, int i2) {
        }

        public final void onError(int i, int i2) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.b$3 */
    class C126053 extends AnimatorListenerAdapter {
        C126053() {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(55137);
            C12597b.this.oxM.setVisibility(8);
            C12597b.this.oxM.setAlpha(1.0f);
            AppMethodBeat.m2505o(55137);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.b$5 */
    class C126145 implements Runnable {
        C126145() {
        }

        public final void run() {
            AppMethodBeat.m2504i(55146);
            if (C12597b.this.eir != null) {
                C12597b.this.eir.dismiss();
            }
            if (C12597b.this.oBL != null) {
                C12597b.this.oBL.bQf();
            }
            AppMethodBeat.m2505o(55146);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.b$a */
    public interface C12615a {
        void bQf();

        void bQg();

        void onError();
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.b$13 */
    class C1261613 implements C5015a {
        C1261613() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(55161);
            if (C12597b.this.oxL != null && C12597b.this.oxL.isPlaying()) {
                if (C12597b.this.oBD <= 0 || C12597b.this.oxL.getCurrentPosition() < C12597b.this.oBD) {
                    C12597b.this.oBz.setCurrentCursorPosition(((float) C12597b.this.oxL.getCurrentPosition()) / ((float) C12597b.this.oBB));
                } else {
                    C12597b.this.oxL.mo27356d((double) C12597b.this.oBC, true);
                    C12597b.this.oBz.setCurrentCursorPosition(((float) C12597b.this.oBC) / ((float) C12597b.this.oBB));
                }
            }
            AppMethodBeat.m2505o(55161);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.b$6 */
    class C126176 implements C8956r {
        C126176() {
        }

        /* renamed from: a */
        public final void mo4525a(C32247e c32247e) {
            AppMethodBeat.m2504i(55147);
            C4990ab.m7417i("MicroMsg.MMSightVideoEditor", "photoEditor [onSelectedFeature] features:%s", c32247e.name());
            if (c32247e == C32247e.CROP_VIDEO) {
                C12597b.m20549i(C12597b.this);
            }
            AppMethodBeat.m2505o(55147);
        }

        /* renamed from: a */
        public final void mo4526a(C32247e c32247e, int i) {
            AppMethodBeat.m2504i(55148);
            C4990ab.m7417i("MicroMsg.MMSightVideoEditor", "photoEditor [onSelectedDetailFeature] features:%s index:%s", c32247e.name(), Integer.valueOf(i));
            AppMethodBeat.m2505o(55148);
        }

        /* renamed from: bd */
        public final void mo4527bd(boolean z) {
            AppMethodBeat.m2504i(55149);
            if (z) {
                C12597b.this.crP.showVKB();
                AppMethodBeat.m2505o(55149);
                return;
            }
            C12597b.this.crP.hideVKB(C12597b.this.oBF);
            AppMethodBeat.m2505o(55149);
        }
    }

    /* renamed from: p */
    static /* synthetic */ void m20556p(C12597b c12597b) {
        AppMethodBeat.m2504i(55171);
        c12597b.bQw();
        AppMethodBeat.m2505o(55171);
    }

    /* renamed from: r */
    static /* synthetic */ void m20558r(C12597b c12597b) {
        AppMethodBeat.m2504i(55172);
        c12597b.bQx();
        AppMethodBeat.m2505o(55172);
    }

    static {
        AppMethodBeat.m2504i(55175);
        AppMethodBeat.m2505o(55175);
    }

    /* renamed from: a */
    public final void mo24539a(MMActivity mMActivity, int i, String str, VideoSeekBarEditorView videoSeekBarEditorView, VideoPlayerTextureView videoPlayerTextureView, ViewGroup viewGroup, VideoTransPara videoTransPara, boolean z) {
        AppMethodBeat.m2504i(55162);
        this.ouc = videoTransPara;
        if (this.ouc == null) {
            C4990ab.m7412e("MicroMsg.MMSightVideoEditor", "video trans para is null!!!");
            this.ouc = new VideoTransPara();
            this.ouc.duration = Downloads.MIN_WAIT_FOR_NETWORK;
        } else if (this.ouc.duration <= 0) {
            this.ouc.duration = Downloads.MIN_WAIT_FOR_NETWORK;
        }
        this.scene = i;
        this.videoPath = str;
        this.oxM = videoSeekBarEditorView;
        this.oxL = videoPlayerTextureView;
        this.oBF = viewGroup;
        this.crP = mMActivity;
        this.oBO = z;
        this.oBS = new C34539b(i);
        this.oBz = videoSeekBarEditorView.oDA;
        this.oBz.setVideoTransPara(this.ouc);
        bQv();
        AppMethodBeat.m2505o(55162);
    }

    private void bQv() {
        AppMethodBeat.m2504i(55163);
        this.oBG = C25784s.ccQ.mo33296Ae();
        C25784s c25784s = this.oBG;
        C17916a c17916a = new C17916a();
        c17916a.ccS = false;
        c17916a.ccU = true;
        c17916a.ccR = C8957c.VIDEO;
        c17916a.ccV = new Rect(this.oxL.getLeft(), this.oxL.getTop(), this.oxL.getRight(), this.oxL.getBottom());
        c25784s.mo33293a(c17916a.mo33430AB());
        this.oBH = this.oBG.mo33294aQ(this.oBF.getContext());
        this.oBH.setActionBarCallback(new C35011());
        MarginLayoutParams marginLayoutParams = new MarginLayoutParams(-1, -1);
        if (C5230ak.m7991hw(this.crP)) {
            marginLayoutParams.height = C3475d.bPg().y - Math.max(C5230ak.m7988fr(this.crP), C5230ak.m7992hx(this.crP));
        }
        this.oBF.addView(this.oBH, marginLayoutParams);
        this.oBH.setSelectedFeatureListener(new C126176());
        this.oxM.setCancelButtonClickListener(new C126007());
        this.oxM.setFinishButtonClickListener(new C35088());
        if (this.oBO) {
            this.oxM.setVisibility(0);
            this.oxM.bringToFront();
            this.oxM.post(new C125969());
        }
        AppMethodBeat.m2505o(55163);
    }

    private void bQw() {
        AppMethodBeat.m2504i(55164);
        this.oxL.animate().scaleX(1.0f).scaleY(1.0f).translationY(0.0f).setDuration(300);
        this.oxM.animate().alpha(0.0f).setDuration(100).setListener(new C126053());
        this.oBH.setFooterVisible(true);
        this.oBH.setAutoShowFooterAndBar(true);
        this.oBH.setActionBarVisible(true);
        this.oBH.animate().scaleX(1.0f).scaleY(1.0f).translationY(0.0f).setDuration(300);
        this.oBP = false;
        AppMethodBeat.m2505o(55164);
    }

    private void bQx() {
        AppMethodBeat.m2504i(55165);
        C5004al.m7441d(new C126145());
        AppMethodBeat.m2505o(55165);
    }

    public final void release() {
        AppMethodBeat.m2504i(55166);
        try {
            if (this.oBE != null) {
                this.oBE.stopTimer();
                this.oBE = null;
            }
            if (this.oBz != null) {
                this.oBz.release();
            }
            if (this.oBG != null) {
                this.oBG.onDestroy();
            }
            if (this.oBF != null) {
                this.oBF.removeView(this.oBH);
            }
            if (this.oxM != null) {
                this.oxM.bQM();
            }
            this.oBA = false;
            C43305j.owk.mo45830WY();
            AppMethodBeat.m2505o(55166);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.MMSightVideoEditor", e, "release error: %s", e.getMessage());
            AppMethodBeat.m2505o(55166);
        }
    }

    /* renamed from: n */
    public final void mo24540n(boolean z, String str) {
        AppMethodBeat.m2504i(55167);
        try {
            this.oBS.eVT = z;
            if (this.oBG == null) {
                C4990ab.m7412e("MicroMsg.MMSightVideoEditor", "[report] null == photoEditor");
                AppMethodBeat.m2505o(55167);
                return;
            }
            C37465p Ac = this.oBG.mo33290Ac();
            this.oBS.oxz = Ac.mo60376As();
            this.oBS.oxA = Ac.mo60375Ar();
            this.oBS.oxC = Ac.mo60378Au();
            this.oBS.efs = Ac.mo60379Av();
            this.oBS.oxD = Ac.mo60381Ax();
            this.oBS.textColor = Ac.getTextColor();
            C34537a.m56630a(this.oBS, str);
            AppMethodBeat.m2505o(55167);
        } catch (Exception e) {
            AppMethodBeat.m2505o(55167);
        }
    }

    /* renamed from: wY */
    public final boolean mo24542wY() {
        AppMethodBeat.m2504i(55168);
        if (!this.oBU) {
            AppMethodBeat.m2505o(55168);
            return false;
        } else if (this.oBP) {
            bQw();
            AppMethodBeat.m2505o(55168);
            return true;
        } else if (this.oBG != null) {
            boolean Ab = this.oBG.mo33289Ab();
            AppMethodBeat.m2505o(55168);
            return Ab;
        } else {
            AppMethodBeat.m2505o(55168);
            return false;
        }
    }

    /* renamed from: i */
    static /* synthetic */ void m20549i(C12597b c12597b) {
        AppMethodBeat.m2504i(55170);
        int width = c12597b.oxL.getWidth();
        int height = c12597b.oxL.getHeight();
        int fromDPToPix = ((c12597b.oxM.getHeight() <= 0 ? C1338a.fromDPToPix(c12597b.crP, 95) : c12597b.oxM.getHeight()) + C1338a.fromDPToPix(c12597b.crP, 20)) + C1338a.fromDPToPix(c12597b.crP, 12);
        if (C5230ak.m7991hw(c12597b.crP)) {
            fromDPToPix += C5230ak.m7988fr(c12597b.crP);
        }
        int i = height - fromDPToPix;
        if (c12597b.oxL.getBottom() + fromDPToPix < C3475d.m5780eu(c12597b.crP).y) {
            i = (int) (((float) (width - (C1338a.fromDPToPix(c12597b.crP, 32) * 2))) / (((float) width) / ((float) height)));
        }
        float f = ((float) ((int) ((((float) width) / ((float) height)) * ((float) i)))) / ((float) width);
        float f2 = ((float) i) / ((float) height);
        c12597b.oxL.animate().scaleX(f).scaleY(f2).translationY(-(((float) fromDPToPix) / 2.0f)).setDuration(300).setListener(new C125952());
        c12597b.oBH.animate().scaleX(f).scaleY(f2).translationY(-(((float) fromDPToPix) / 2.0f)).setDuration(300);
        c12597b.oBH.setAutoShowFooterAndBar(false);
        c12597b.oBH.setFooterVisible(false);
        c12597b.oBH.setActionBarVisible(false);
        if (!c12597b.oBA) {
            c12597b.oBz.setOnPreparedListener(new C1259810());
            c12597b.oBz.setThumbBarSeekListener(new C1260311());
            c12597b.oBz.mo24502RO(c12597b.videoPath);
            c12597b.oxL.setLoop(true);
            c12597b.oxL.setVideoCallback(new C1260412());
            c12597b.oBA = true;
        }
        c12597b.oxM.setVisibility(0);
        c12597b.oxM.bringToFront();
        c12597b.oBP = true;
        AppMethodBeat.m2505o(55170);
    }

    /* renamed from: x */
    static /* synthetic */ void m20564x(C12597b c12597b) {
        AppMethodBeat.m2504i(55173);
        c12597b.oBE = new C7564ap(Looper.getMainLooper(), new C1261613(), true);
        c12597b.oBE.mo16770ae(20, 20);
        AppMethodBeat.m2505o(55173);
    }

    /* renamed from: C */
    static /* synthetic */ Point m20529C(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(55174);
        C4990ab.m7410d("MicroMsg.MMSightVideoEditor", "scale() called with: decoderOutputWidth = [" + i + "], decoderOutputHeight = [" + i2 + "], specWidth = [" + i3 + "], specHeight = [" + i4 + "]");
        if (i > i3 || i2 > i4) {
            int max = Math.max(i, i2);
            int min = Math.min(i, i2);
            int max2 = Math.max(i3, i4);
            int min2 = Math.min(i3, i4);
            int i5;
            Point point;
            if (max % 16 == 0 && Math.abs(max - max2) < 16 && min % 16 == 0 && Math.abs(min - min2) < 16) {
                C4990ab.m7416i("MicroMsg.MMSightVideoEditor", "calc scale, same len divide by 16, no need scale");
                AppMethodBeat.m2505o(55174);
                return null;
            } else if (max / 2 == max2 && min / 2 == min2) {
                C4990ab.m7416i("MicroMsg.MMSightVideoEditor", "calc scale, double ratio");
                i5 = i / 2;
                max = i2 / 2;
                if (i5 % 2 != 0) {
                    i5++;
                }
                if (max % 2 != 0) {
                    max++;
                }
                point = new Point(i5, max);
                AppMethodBeat.m2505o(55174);
                return point;
            } else {
                i5 = max / 2;
                max = min / 2;
                if (i5 % 16 != 0 || Math.abs(i5 - max2) >= 16 || max % 16 != 0 || Math.abs(max - min2) >= 16) {
                    point = new Point();
                    if (i < i2) {
                        i5 = Math.min(i3, i4);
                        max = (int) (((double) i2) / ((((double) i) * 1.0d) / ((double) i5)));
                    } else {
                        max = Math.min(i3, i4);
                        i5 = (int) (((double) i) / ((((double) i2) * 1.0d) / ((double) max)));
                    }
                    if (max % 2 != 0) {
                        max++;
                    }
                    if (i5 % 2 != 0) {
                        i5++;
                    }
                    C4990ab.m7417i("MicroMsg.MMSightVideoEditor", "calc scale, outputsize: %s %s", Integer.valueOf(i5), Integer.valueOf(max));
                    point.x = i5;
                    point.y = max;
                    AppMethodBeat.m2505o(55174);
                    return point;
                }
                C4990ab.m7416i("MicroMsg.MMSightVideoEditor", "calc scale, double ratio divide by 16");
                i5 = i / 2;
                max = i2 / 2;
                if (i5 % 2 != 0) {
                    i5++;
                }
                if (max % 2 != 0) {
                    max++;
                }
                point = new Point(i5, max);
                AppMethodBeat.m2505o(55174);
                return point;
            }
        }
        C4990ab.m7416i("MicroMsg.MMSightVideoEditor", "calc scale, small or equal to spec size");
        AppMethodBeat.m2505o(55174);
        return null;
    }
}
