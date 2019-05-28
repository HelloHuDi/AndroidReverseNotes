package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Build.VERSION;
import android.os.Looper;
import android.view.Surface;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p219b.C45289k;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.memory.C9631o;
import com.tencent.p177mm.memory.C9631o.C9633b;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.p230g.p231a.C6550tn;
import com.tencent.p177mm.plugin.sight.base.SightVideoJNI;
import com.tencent.p177mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b */
public abstract class C3919b {
    private static HashMap<String, WeakReference<Bitmap>> qxK = new HashMap();
    private static Map<String, Integer> qxO = new ConcurrentHashMap();
    private boolean fNO;
    boolean fVc;
    String ien;
    private C7306ak lda;
    private Surface mSurface;
    int position;
    boolean qxI;
    public boolean qxJ;
    public boolean qxL;
    double qxM;
    boolean qxN;
    double qxP;
    private boolean qxQ;
    boolean qxR;
    private int qxl;
    private int qxm;
    String qxn;
    int qxo;
    protected int qxq;
    private Bitmap qxr;
    private Bitmap qxs;
    private Bitmap qxt;
    WeakReference<View> qxu;
    WeakReference<TextView> qxv;
    private long qxw;
    private WeakReference<View> qxx;
    private Animation qxy;
    private Animation qxz;
    volatile C3932h rci;
    private volatile C3911b rcj;
    volatile C3929i rck;
    private volatile C3917c rcl;
    private C3922k rcm;
    private C3921j rcn;
    private C3918d rco;
    private C3920a rcp;
    C3926e rcq;
    C3927f rcr;
    C3928g rcs;

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b$b */
    class C3911b implements Runnable {
        volatile boolean ovl;
        C3917c rcu;

        /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b$b$5 */
        class C39125 implements Runnable {
            C39125() {
            }

            public final void run() {
                AppMethodBeat.m2504i(37419);
                if (C3919b.this.rcs != null) {
                    View cli = C3919b.this.rcs.cli();
                    if (cli != null) {
                        if (!(C3919b.this.qxz != null || C3919b.this.rcs.clj() == -1 || C3919b.this.qxx.get() == null)) {
                            C3919b.this.qxz = AnimationUtils.loadAnimation(((View) C3919b.this.qxx.get()).getContext(), C3919b.this.rcs.clj());
                        }
                        if (C3919b.this.qxz != null) {
                            cli.startAnimation(C3919b.this.qxz);
                        }
                        cli.setVisibility(0);
                    }
                }
                AppMethodBeat.m2505o(37419);
            }
        }

        /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b$b$3 */
        class C39133 implements Runnable {
            C39133() {
            }

            public final void run() {
                AppMethodBeat.m2504i(37417);
                C3919b.this.mo8665U(null);
                AppMethodBeat.m2505o(37417);
            }
        }

        /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b$b$4 */
        class C39144 implements Runnable {
            C39144() {
            }

            public final void run() {
                AppMethodBeat.m2504i(37418);
                if (C3919b.this.rcq != null) {
                    C3919b.this.rcq.mo8653Ds(0);
                }
                AppMethodBeat.m2505o(37418);
            }
        }

        /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b$b$1 */
        class C39151 implements Runnable {
            C39151() {
            }

            public final void run() {
                AppMethodBeat.m2504i(37415);
                C3919b.this.rcs.cli().setVisibility(8);
                AppMethodBeat.m2505o(37415);
            }
        }

        /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b$b$2 */
        class C39162 implements Runnable {
            C39162() {
            }

            public final void run() {
                AppMethodBeat.m2504i(37416);
                C3919b.this.qxQ = true;
                AppMethodBeat.m2505o(37416);
            }
        }

        private C3911b() {
            this.ovl = false;
        }

        /* synthetic */ C3911b(C3919b c3919b, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(37420);
            if (!(C3919b.this.rcs == null || C3919b.this.rcs.cli() == null || C3919b.this.rcs.cli().getVisibility() != 0)) {
                C3919b.this.lda.post(new C39151());
            }
            if (C3919b.this.qxo < 0) {
                C4990ab.m7421w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id, path %s", Integer.valueOf(C3919b.this.hashCode()), Integer.valueOf(hashCode()), C3919b.this.ien);
                AppMethodBeat.m2505o(37420);
            } else if (this.ovl) {
                C4990ab.m7413e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at beg", Integer.valueOf(C3919b.this.hashCode()), Integer.valueOf(hashCode()));
                AppMethodBeat.m2505o(37420);
            } else {
                float f;
                double clk;
                if (C3919b.this.qxw == 0) {
                    if (C3919b.this.rck != null) {
                        C3919b.this.rck.type = 1;
                        C3919b.this.rck.run();
                    }
                    C3919b.this.qxw = System.currentTimeMillis();
                }
                Object obj = null;
                if (C3919b.this.qxP != -1.0d) {
                    if (C3919b.this.qxJ) {
                        if (C3919b.this.rck != null) {
                            C3919b.this.rck.type = 4;
                            C3919b.this.rck.qxP = C3919b.this.qxP;
                            C3919b.this.rck.run();
                            C3919b.this.lda.postDelayed(new C39162(), 100);
                        } else if (SightVideoJNI.seekStream(C3919b.this.qxP, C3919b.this.qxo) > 0) {
                            if (C3919b.this.rck == null) {
                                C3919b.this.rck = new C3929i(C3919b.this, (byte) 0);
                            }
                            C3919b.this.rck.type = 4;
                            C3919b.this.rck.qxP = C3919b.this.qxP;
                            C3919b.this.rck.run();
                            obj = 1;
                        }
                    } else if (SightVideoJNI.seekStream(C3919b.this.qxP, C3919b.this.qxo) > 0) {
                        if (C3919b.this.rck == null) {
                            C3919b.this.rck = new C3929i(C3919b.this, (byte) 0);
                        }
                        C3919b.this.rck.type = 4;
                        C3919b.this.rck.qxP = C3919b.this.qxP;
                        C3919b.this.rck.run();
                        obj = 1;
                    }
                }
                float currentTimeMillis = (float) (System.currentTimeMillis() - C3919b.this.qxw);
                if (obj != null) {
                    f = 0.0f;
                } else {
                    f = (currentTimeMillis / ((float) C3919b.this.qxq)) + 0.5f;
                }
                if (C3919b.this.qxJ && C3919b.this.qxQ) {
                    C3919b.this.qxQ = false;
                    if (C3919b.this.rck != null) {
                        clk = C3919b.this.rck.clk() / 1000.0d;
                        if (SightVideoJNI.seekStream(clk, C3919b.this.qxo) > 0) {
                            f = 0.0f;
                            C4990ab.m7416i("MicroMsg.SightPlayController", "seek to " + clk + " modify time : 0.0");
                        }
                    }
                }
                float f2 = f;
                if (C3919b.this.fNO) {
                    C4990ab.m7417i("MicroMsg.SightPlayController", "#0x%x video %d id passedTime:  %s  seek  %s", Integer.valueOf(C3919b.this.hashCode()), Integer.valueOf(C3919b.this.qxo), Float.valueOf(currentTimeMillis), Float.valueOf(f2));
                }
                C3919b.this.qxw = System.currentTimeMillis();
                if (f2 >= 2.0f) {
                    C3919b.this.qxl = C3919b.this.qxl + 1;
                } else {
                    C3919b.this.qxl = Math.max(0, C3919b.this.qxl - 1);
                }
                if (C3919b.this.clb()) {
                    C4990ab.m7413e("MicroMsg.SightPlayController", "match tolerate bad seek times %d", Integer.valueOf(C3919b.this.qxl));
                    C3919b.this.clear();
                    AppMethodBeat.m2505o(37420);
                    return;
                }
                int i;
                Object obj2 = null;
                int i2 = 0;
                if (1 == C3919b.this.qxm) {
                    Object obj3;
                    if (C3919b.this.mSurface == null || C3919b.this.mSurface.isValid()) {
                        i2 = SightVideoJNI.drawSurfaceFrame(C3919b.this.qxo, C3919b.this.mSurface, (int) f2, C3919b.this.qxs, C3919b.this.fVc);
                        if (C3919b.this.rcr != null) {
                            clk = SightVideoJNI.getVideoPlayTime(C3919b.this.qxo);
                            i = (int) clk;
                            if (i != ((int) C3919b.this.qxM)) {
                                C3919b.this.rcr.mo8681ks((long) i);
                            }
                            C3919b.this.qxM = clk;
                        }
                        if (i2 == 0) {
                            C3919b.this.qxP = -1.0d;
                            obj3 = null;
                        } else if (1 == i2) {
                            C3919b.this.qxP = -1.0d;
                            obj3 = 1;
                            C3919b.this.qxw = 0;
                            C3919b.m6205A(C3919b.this);
                        } else if (-7 == i2) {
                            C4990ab.m7420w("MicroMsg.SightPlayController", "surface is null, continue");
                            obj3 = null;
                        } else {
                            C4990ab.m7413e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error:%d", Integer.valueOf(C3919b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2));
                            this.ovl = true;
                            if (this.rcu != null) {
                                this.rcu.ovl = true;
                            }
                            C3919b.this.cpV();
                            if (C3919b.this.rcq != null) {
                                C3919b.this.rcq.mo8653Ds(-1);
                            }
                            obj3 = null;
                        }
                    } else {
                        C4990ab.m7413e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error, surface is not valid", Integer.valueOf(C3919b.this.hashCode()), Integer.valueOf(hashCode()));
                        this.ovl = true;
                        if (this.rcu != null) {
                            this.rcu.ovl = true;
                            obj3 = null;
                        }
                        obj3 = null;
                    }
                    if (C3919b.this.rck != null) {
                        C4990ab.m7410d("MicroMsg.SightPlayController", "voice time is" + (C3919b.this.rck.clk() / 1000.0d));
                        obj2 = obj3;
                    } else {
                        obj2 = obj3;
                    }
                } else {
                    i2 = SightVideoJNI.drawFrame(C3919b.this.qxo, C3919b.this.qxr, (int) f2, null, false, C3919b.this.fVc);
                    if (C3919b.this.rcr != null) {
                        clk = SightVideoJNI.getVideoPlayTime(C3919b.this.qxo);
                        i = (int) clk;
                        if (i != ((int) C3919b.this.qxM)) {
                            C3919b.this.rcr.mo8681ks((long) i);
                        }
                        C3919b.this.qxM = clk;
                        if (C3919b.this.fNO) {
                            C4990ab.m7417i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", Integer.valueOf(C3919b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2), Double.valueOf(clk));
                        }
                    } else if (C3919b.this.fNO) {
                        clk = SightVideoJNI.getVideoPlayTime(C3919b.this.qxo);
                        if (C3919b.this.fNO) {
                            C4990ab.m7417i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", Integer.valueOf(C3919b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2), Double.valueOf(clk));
                        }
                    } else if (C3919b.this.fNO) {
                        C4990ab.m7417i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d", Integer.valueOf(C3919b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2));
                    }
                    if (i2 == 0) {
                        C3919b.this.qxP = -1.0d;
                    } else if (1 == i2) {
                        C3919b.this.qxP = -1.0d;
                        obj2 = 1;
                        C3919b.this.qxw = 0;
                        C3919b.m6205A(C3919b.this);
                    } else {
                        C3919b.this.qxP = -1.0d;
                        C4990ab.m7413e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw bitmap match error:%d", Integer.valueOf(C3919b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2));
                        this.ovl = true;
                        if (this.rcu != null) {
                            this.rcu.ovl = true;
                        }
                        C3919b.this.lda.post(new C39133());
                        if (C3919b.this.rcq != null) {
                            C3919b.this.rcq.mo8653Ds(-1);
                        }
                    }
                }
                if (1 == i2) {
                    C3919b.this.lda.post(new C39144());
                }
                if (this.ovl) {
                    C4990ab.m7413e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at end", Integer.valueOf(C3919b.this.hashCode()), Integer.valueOf(hashCode()));
                    if (C3919b.this.rck != null) {
                        C3919b.this.rck.type = 0;
                        C3919b.this.rck.run();
                    }
                    AppMethodBeat.m2505o(37420);
                    return;
                }
                if (1 == C3919b.this.qxm) {
                    long currentTimeMillis2 = ((long) C3919b.this.qxq) - (System.currentTimeMillis() - C3919b.this.qxw);
                    if (C3919b.this.qxw == 0) {
                        C37961o.m64222i(this, (long) (C3919b.this.qxq * 5));
                    } else if (currentTimeMillis2 > 0) {
                        C37961o.m64222i(this, currentTimeMillis2);
                    } else {
                        C37961o.m64222i(this, 0);
                    }
                } else if (obj2 == null || C3919b.this.rcs == null) {
                    this.rcu.qyd = i2;
                    C3919b.this.lda.post(this.rcu);
                } else {
                    i = C3919b.this.rcs.clh();
                    C3919b.this.lda.post(new C39125());
                    this.rcu.qyd = i2;
                    C3919b.this.lda.postDelayed(this.rcu, (long) i);
                }
                if (C3919b.this.rck != null) {
                    C4990ab.m7410d("MicroMsg.SightPlayController", "voice time is" + (C3919b.this.rck.clk() / 1000.0d));
                }
                AppMethodBeat.m2505o(37420);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b$c */
    class C3917c implements Runnable {
        volatile boolean ovl = false;
        int qyd;
        C3911b rcw;

        public C3917c() {
            AppMethodBeat.m2504i(37421);
            C4990ab.m7416i("MicroMsg.SightPlayController", "make sure drawJob alive");
            AppMethodBeat.m2505o(37421);
        }

        public final void run() {
            AppMethodBeat.m2504i(37422);
            if (this.ovl) {
                C4990ab.m7413e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop draw", Integer.valueOf(C3919b.this.hashCode()), Integer.valueOf(hashCode()));
                AppMethodBeat.m2505o(37422);
                return;
            }
            C3919b.this.mo8665U(C3919b.this.qxr);
            if (C3919b.this.qxw == 0) {
                C37961o.m64222i(this.rcw, 0);
                AppMethodBeat.m2505o(37422);
                return;
            }
            long currentTimeMillis = ((long) C3919b.this.qxq) - (System.currentTimeMillis() - C3919b.this.qxw);
            if (currentTimeMillis > 0) {
                C37961o.m64222i(this.rcw, currentTimeMillis);
                AppMethodBeat.m2505o(37422);
                return;
            }
            C37961o.m64222i(this.rcw, 0);
            AppMethodBeat.m2505o(37422);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b$d */
    class C3918d implements Runnable {
        private C3918d() {
        }

        /* synthetic */ C3918d(C3919b c3919b, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(37423);
            if (C3919b.this.qxx.get() == null) {
                AppMethodBeat.m2505o(37423);
                return;
            }
            ((View) C3919b.this.qxx.get()).startAnimation(C3919b.this.qxy);
            AppMethodBeat.m2505o(37423);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b$a */
    static class C3920a extends C4884c<C6550tn> {
        int mik = 0;
        int qxY = 0;
        int qxZ = 0;
        WeakReference<C3919b> qya;

        public C3920a(C3919b c3919b) {
            super(0);
            AppMethodBeat.m2504i(37412);
            this.qya = new WeakReference(c3919b);
            this.xxI = C6550tn.class.getName().hashCode();
            AppMethodBeat.m2505o(37412);
        }

        /* renamed from: a */
        private void m6258a(C6550tn c6550tn) {
            this.qxY = c6550tn.cPI.cPL;
            this.qxZ = c6550tn.cPI.cPJ;
            this.mik = c6550tn.cPI.cPK;
        }

        private boolean clg() {
            AppMethodBeat.m2504i(37413);
            if (this.qya.get() == null) {
                AppMethodBeat.m2505o(37413);
                return false;
            }
            int D = ((C3919b) this.qya.get()).position + this.qxY;
            if (D < this.qxZ || D > this.mik) {
                AppMethodBeat.m2505o(37413);
                return false;
            }
            AppMethodBeat.m2505o(37413);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b$j */
    class C3921j implements Runnable {
        private C3921j() {
        }

        /* synthetic */ C3921j(C3919b c3919b, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(37429);
            if (C3919b.this.qxo < 0 || C3919b.this.qxv == null || C3919b.this.qxv.get() == null) {
                AppMethodBeat.m2505o(37429);
                return;
            }
            ((TextView) C3919b.this.qxv.get()).setText(SightVideoJNI.getVideoInfo(C3919b.this.qxo));
            AppMethodBeat.m2505o(37429);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b$k */
    class C3922k implements Runnable {
        WeakReference<Bitmap> qyh;

        private C3922k() {
            AppMethodBeat.m2504i(37433);
            this.qyh = new WeakReference(null);
            AppMethodBeat.m2505o(37433);
        }

        /* synthetic */ C3922k(C3919b c3919b, byte b) {
            this();
        }

        public final void run() {
            View view = null;
            boolean z = true;
            AppMethodBeat.m2504i(37434);
            try {
                String str;
                String str2;
                Object[] objArr;
                View view2;
                if (C3919b.this.mSurface == null || !C3919b.this.mSurface.isValid()) {
                    boolean z2;
                    str = "MicroMsg.SightPlayController";
                    String str3 = "#0x%x-#0x%x want draw thumb, but surface status error, surface null ? %B, thumb bgView null ? %B, thumb null ? %B, mask null ? %B";
                    Object[] objArr2 = new Object[6];
                    objArr2[0] = Integer.valueOf(C3919b.this.hashCode());
                    objArr2[1] = Integer.valueOf(hashCode());
                    objArr2[2] = Boolean.valueOf(C3919b.this.mSurface == null);
                    if (C3919b.this.qxu == null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objArr2[3] = Boolean.valueOf(z2);
                    if (this.qyh.get() == null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objArr2[4] = Boolean.valueOf(z2);
                    if (C3919b.this.qxs == null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objArr2[5] = Boolean.valueOf(z2);
                    C4990ab.m7421w(str, str3, objArr2);
                    if (C3919b.this.qxs == null) {
                        final Bitmap bitmap = (Bitmap) this.qyh.get();
                        if (C3919b.this.qxu != null) {
                            view = (View) C3919b.this.qxu.get();
                        }
                        if (view == null || bitmap == null || bitmap.isRecycled()) {
                            str = "MicroMsg.SightPlayController";
                            str3 = "bgView:%B, thumb:%B";
                            objArr2 = new Object[2];
                            objArr2[0] = Boolean.valueOf(view == null);
                            if (bitmap != null) {
                                z = false;
                            }
                            objArr2[1] = Boolean.valueOf(z);
                            C4990ab.m7413e(str, str3, objArr2);
                            AppMethodBeat.m2505o(37434);
                            return;
                        }
                        view.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(37430);
                                view.setBackgroundDrawable(new BitmapDrawable(bitmap));
                                AppMethodBeat.m2505o(37430);
                            }
                        });
                        AppMethodBeat.m2505o(37434);
                        return;
                    }
                    if (!(C3919b.this.qxt != null && C3919b.this.qxt.getWidth() == C3919b.this.qxs.getWidth() && C3919b.this.qxt.getHeight() == C3919b.this.qxs.getHeight())) {
                        try {
                            C3919b.this.qxt = Bitmap.createBitmap(C3919b.this.qxs.getWidth(), C3919b.this.qxs.getHeight(), Config.ARGB_8888);
                        } catch (Exception e) {
                            C4990ab.printErrStackTrace("MicroMsg.SightPlayController", e, "try to create thumb bmp error:%s", e.getMessage());
                            C3919b.this.qxt = null;
                        }
                    }
                    if (C3919b.this.qxt == null || this.qyh.get() == null || ((Bitmap) this.qyh.get()).isRecycled()) {
                        str2 = "MicroMsg.SightPlayController";
                        str = "mThubmBgBmp:%B, thumbRef:%B";
                        objArr = new Object[2];
                        if (C3919b.this.qxt == null) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        objArr[0] = Boolean.valueOf(z2);
                        if (this.qyh.get() != null) {
                            z = false;
                        }
                        objArr[1] = Boolean.valueOf(z);
                        C4990ab.m7413e(str2, str, objArr);
                        AppMethodBeat.m2505o(37434);
                        return;
                    }
                    long nanoTime = System.nanoTime();
                    SightVideoJNI.handleThumb((Bitmap) this.qyh.get(), C3919b.this.qxt, C3919b.this.qxs);
                    C4990ab.m7417i("MicroMsg.SightPlayController", "handle thumb use %d us", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
                    final Bitmap p = C3919b.this.qxt;
                    if (C3919b.this.qxu != null) {
                        view2 = (View) C3919b.this.qxu.get();
                    } else {
                        view2 = null;
                    }
                    if (view2 == null || p == null) {
                        AppMethodBeat.m2505o(37434);
                        return;
                    }
                    view2.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(37431);
                            view2.setBackgroundDrawable(new BitmapDrawable(p));
                            AppMethodBeat.m2505o(37431);
                        }
                    });
                    AppMethodBeat.m2505o(37434);
                    return;
                }
                str2 = "MicroMsg.SightPlayController";
                str = "#0x%x-#0x%x draw thumb, thumb empty ? %B";
                objArr = new Object[3];
                objArr[0] = Integer.valueOf(C3919b.this.hashCode());
                objArr[1] = Integer.valueOf(hashCode());
                objArr[2] = Boolean.valueOf(this.qyh.get() == null);
                C4990ab.m7411d(str2, str, objArr);
                if (C3919b.this.qxu != null) {
                    view2 = (View) C3919b.this.qxu.get();
                    if (view2 != null) {
                        view2.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(37432);
                                C4990ab.m7418v("MicroMsg.SightPlayController", "set background drawable null");
                                view2.setBackgroundDrawable(null);
                                AppMethodBeat.m2505o(37432);
                            }
                        });
                    }
                }
                if (this.qyh.get() == null) {
                    SightVideoJNI.drawSurfaceColor(C3919b.this.mSurface, 0);
                    AppMethodBeat.m2505o(37434);
                    return;
                }
                SightVideoJNI.drawSurfaceThumb(C3919b.this.mSurface, (Bitmap) this.qyh.get(), C3919b.this.qxs);
                AppMethodBeat.m2505o(37434);
            } catch (Exception e2) {
                C4990ab.printErrStackTrace("MicroMsg.SightPlayController", e2, "", new Object[0]);
                AppMethodBeat.m2505o(37434);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b$e */
    public interface C3926e {
        /* renamed from: Ds */
        void mo8653Ds(int i);
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b$f */
    public interface C3927f {
        /* renamed from: ks */
        void mo8681ks(long j);
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b$g */
    public interface C3928g {
        int clh();

        View cli();

        int clj();
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b$i */
    class C3929i implements Runnable {
        double qxP;
        MediaPlayer qyf;
        int type;

        /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b$i$1 */
        class C39301 implements OnErrorListener {
            C39301() {
            }

            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                AppMethodBeat.m2504i(37425);
                C4990ab.m7413e("MicroMsg.SightPlayController", "on error: play %s ERROR!! %d %d", C3919b.this.ien, Integer.valueOf(i), Integer.valueOf(i2));
                C3919b.this.clear();
                if (C3919b.this.rcq != null) {
                    C3919b.this.rcq.mo8653Ds(-1);
                }
                AppMethodBeat.m2505o(37425);
                return true;
            }
        }

        private C3929i() {
            this.qxP = -1.0d;
        }

        /* synthetic */ C3929i(C3919b c3919b, byte b) {
            this();
        }

        private void bUd() {
            AppMethodBeat.m2504i(37426);
            C4990ab.m7416i("MicroMsg.SightPlayController", "stopPlayer");
            try {
                if (this.qyf != null) {
                    this.qyf.stop();
                    this.qyf.release();
                    this.qyf = null;
                }
                AppMethodBeat.m2505o(37426);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.SightPlayController", e, "stop play sound error: %s", e.getMessage());
                this.qyf = null;
                AppMethodBeat.m2505o(37426);
            }
        }

        public final double clk() {
            AppMethodBeat.m2504i(37427);
            if (this.qyf == null) {
                AppMethodBeat.m2505o(37427);
                return 0.0d;
            }
            double currentPosition = (double) this.qyf.getCurrentPosition();
            AppMethodBeat.m2505o(37427);
            return currentPosition;
        }

        public final void run() {
            String str;
            AppMethodBeat.m2504i(37428);
            String str2 = "MicroMsg.SightPlayController";
            String str3 = "do play sound, operation %s";
            Object[] objArr = new Object[1];
            switch (this.type) {
                case 0:
                    str = "stop";
                    break;
                case 1:
                    str = "start";
                    break;
                case 2:
                    str = "pause";
                    break;
                case 3:
                    str = "resume";
                    break;
                case 4:
                    str = "seek";
                    break;
                default:
                    str = "unknown";
                    break;
            }
            objArr[0] = str;
            C4990ab.m7417i(str2, str3, objArr);
            switch (this.type) {
                case 0:
                    bUd();
                    AppMethodBeat.m2505o(37428);
                    return;
                case 1:
                    bUd();
                    if (!C5046bo.isNullOrNil(C3919b.this.ien)) {
                        try {
                            this.qyf = new C45289k();
                            this.qyf.setDisplay(null);
                            this.qyf.reset();
                            this.qyf.setDataSource(C3919b.this.ien);
                            this.qyf.setAudioStreamType(3);
                            this.qyf.setOnErrorListener(new C39301());
                            this.qyf.prepare();
                            this.qyf.start();
                            AppMethodBeat.m2505o(37428);
                            return;
                        } catch (Exception e) {
                            C4990ab.printErrStackTrace("MicroMsg.SightPlayController", e, "play sound error: %s", e.getMessage());
                            C4990ab.m7413e("MicroMsg.SightPlayController", "on Exception: play %s ERROR!!", C3919b.this.ien);
                            C3919b.this.clear();
                            if (C3919b.this.rcq != null) {
                                C3919b.this.rcq.mo8653Ds(-1);
                            }
                            AppMethodBeat.m2505o(37428);
                            return;
                        }
                    }
                    break;
                case 2:
                    try {
                        if (this.qyf != null && this.qyf.isPlaying()) {
                            this.qyf.pause();
                        }
                        AppMethodBeat.m2505o(37428);
                        return;
                    } catch (Exception e2) {
                        C4990ab.printErrStackTrace("MicroMsg.SightPlayController", e2, "pause sound error: %s", e2.getMessage());
                        bUd();
                        AppMethodBeat.m2505o(37428);
                        return;
                    }
                case 3:
                    try {
                        if (this.qyf != null) {
                            this.qyf.start();
                        }
                        AppMethodBeat.m2505o(37428);
                        return;
                    } catch (Exception e22) {
                        C4990ab.printErrStackTrace("MicroMsg.SightPlayController", e22, "pause sound error: %s", e22.getMessage());
                        bUd();
                        AppMethodBeat.m2505o(37428);
                        return;
                    }
                case 4:
                    try {
                        C4990ab.m7417i("MicroMsg.SightPlayController", "soundplayer seek %f", Double.valueOf(this.qxP));
                        this.qyf.seekTo((int) (this.qxP * 1000.0d));
                        AppMethodBeat.m2505o(37428);
                        return;
                    } catch (Exception e222) {
                        C4990ab.printErrStackTrace("MicroMsg.SightPlayController", e222, "seek sound error: %s", e222.getMessage());
                        break;
                    }
            }
            AppMethodBeat.m2505o(37428);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b$h */
    class C3932h implements Runnable {
        volatile boolean ovl;

        private C3932h() {
            this.ovl = false;
        }

        /* synthetic */ C3932h(C3919b c3919b, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(37424);
            if (C3919b.this.clb()) {
                C4990ab.m7412e("MicroMsg.SightPlayController", "is bad fps, do nothing when open file");
                AppMethodBeat.m2505o(37424);
                return;
            }
            C3919b.this.qxo = SightVideoJNI.openFile(C3919b.this.ien, 1 == C3919b.this.qxm ? 0 : 1, 1, false);
            if (C3919b.this.qxo < 0) {
                C4990ab.m7421w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id %d, path %s", Integer.valueOf(hashCode()), Integer.valueOf(C3919b.this.hashCode()), Integer.valueOf(C3919b.this.qxo), C3919b.this.ien);
                C3919b.this.cpV();
                if (C3919b.this.rcq != null) {
                    C3919b.this.rcq.mo8653Ds(-1);
                }
                AppMethodBeat.m2505o(37424);
                return;
            }
            if (((Boolean) AdLandingPagesProxy.getInstance().getCfg(344065, Boolean.FALSE)).booleanValue()) {
                if (C3919b.this.rcn == null) {
                    C3919b.this.rcn = new C3921j(C3919b.this, (byte) 0);
                }
                C3919b.this.lda.removeCallbacks(C3919b.this.rcn);
                C3919b.this.lda.post(C3919b.this.rcn);
            }
            int max = Math.max(1, SightVideoJNI.getVideoWidth(C3919b.this.qxo));
            int max2 = Math.max(1, SightVideoJNI.getVideoHeight(C3919b.this.qxo));
            if (C3919b.this.qxm == 0) {
                if (max * max2 >= 1048576 || max <= 0 || max2 <= 0) {
                    C4990ab.m7413e("MicroMsg.SightPlayController", "get error info videoWidth %d height  %d", Integer.valueOf(max), Integer.valueOf(max2));
                    AppMethodBeat.m2505o(37424);
                    return;
                }
                C3919b.m6224a(C3919b.this, max, max2);
            }
            C3919b.this.clc();
            if (Float.compare(((float) max) / ((float) max2), 5.0f) > 0 || Float.compare(((float) max2) / ((float) max), 5.0f) > 0) {
                C4990ab.m7421w("MicroMsg.SightPlayController", "ERROR Video size %d, %d", Integer.valueOf(max), Integer.valueOf(max2));
                if (!C5046bo.isNullOrNil(C3919b.this.ien)) {
                    C3919b.qxO.put(C3919b.this.ien, Integer.valueOf(2));
                }
                C3919b.this.qxw = 0;
                C3919b.this.m6208CE(C3919b.this.qxo);
                C3919b.this.qxo = -1;
                C3919b.this.ien = "";
                C3919b.this.qxn = "ERROR#PATH";
                C3919b.this.qxt = null;
                this.ovl = true;
                if (C3919b.this.rcq != null) {
                    C3919b.this.rcq.mo8653Ds(-1);
                }
                AppMethodBeat.m2505o(37424);
                return;
            }
            C3919b.this.mo8673dH(max, max2);
            if (1 == C3919b.this.qxm) {
                C3919b.this.rcj = new C3911b(C3919b.this, (byte) 0);
                C3919b.this.rcl = null;
                if (!this.ovl) {
                    C37961o.m64222i(C3919b.this.rcj, 0);
                }
            } else {
                C3919b.this.rcj = new C3911b(C3919b.this, (byte) 0);
                C3919b.this.rcl = new C3917c();
                C3919b.this.rcj.rcu = C3919b.this.rcl;
                C3919b.this.rcl.rcw = C3919b.this.rcj;
                if (!this.ovl) {
                    C37961o.m64222i(C3919b.this.rcj, 0);
                }
            }
            if (this.ovl) {
                C4990ab.m7413e("MicroMsg.SightPlayController", "#0x%x-#0x%x open file end, match stop %B", Integer.valueOf(C3919b.this.hashCode()), Integer.valueOf(hashCode()), Boolean.valueOf(this.ovl));
            }
            AppMethodBeat.m2505o(37424);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b$2 */
    class C39332 implements Runnable {
        final /* synthetic */ double qxX;

        C39332(double d) {
            this.qxX = d;
        }

        public final void run() {
            AppMethodBeat.m2504i(37411);
            C4990ab.m7417i("MicroMsg.SightPlayController", "SeekToFrame   %f  %s", Double.valueOf(this.qxX), C5046bo.dpG().toString());
            C3919b.this.qxP = this.qxX;
            AppMethodBeat.m2505o(37411);
        }
    }

    /* renamed from: U */
    public abstract void mo8665U(Bitmap bitmap);

    /* renamed from: dH */
    public abstract void mo8673dH(int i, int i2);

    public C3919b(View view) {
        this.fNO = false;
        this.qxl = 0;
        this.qxm = 0;
        this.ien = "";
        this.qxn = "";
        this.qxo = -1;
        this.qxq = 41;
        this.qxI = true;
        this.qxJ = false;
        this.qxL = false;
        this.fVc = true;
        this.qxM = -1.0d;
        this.qxN = false;
        this.qxP = -1.0d;
        this.qxQ = false;
        this.qxR = false;
        this.qxm = 0;
        this.lda = new C7306ak(Looper.getMainLooper());
        this.qxx = new WeakReference(view);
        C4990ab.m7417i("MicroMsg.SightPlayController", "new SightPlayController, drawType %d", Integer.valueOf(0));
    }

    /* Access modifiers changed, original: protected */
    public int ckZ() {
        return -1;
    }

    /* renamed from: kz */
    public final void mo8674kz(boolean z) {
        if (this.rci != null) {
            C37961o.m64223y(this.rci);
            this.rci.ovl = true;
        }
        if (this.rcl != null) {
            this.lda.removeCallbacks(this.rcl);
            this.rcl.ovl = true;
        }
        if (this.rcj != null) {
            C37961o.m64223y(this.rcj);
            this.rcj.ovl = true;
        }
        if (this.rck != null) {
            this.rck.type = z ? 0 : 2;
            C37961o.m64222i(this.rck, 0);
        }
    }

    public final boolean cla() {
        if (1 == this.qxm) {
            if (this.rcj == null || this.rcj.ovl) {
                return false;
            }
            return true;
        } else if (this.rcl == null || this.rcl.ovl || this.rcj == null || this.rcj.ovl) {
            return false;
        } else {
            return true;
        }
    }

    public final void restart() {
        C4990ab.m7417i("MicroMsg.SightPlayController", "#0x%x restart, canPlay %B, videoPath %s, videoId %d", Integer.valueOf(hashCode()), Boolean.valueOf(this.qxI), this.ien, Integer.valueOf(this.qxo));
        if (!this.qxI) {
            clear();
        } else if (cla()) {
            C4990ab.m7421w("MicroMsg.SightPlayController", "#0x%x is runing, do nothing when restart request asked, videoPath %s", Integer.valueOf(hashCode()), this.ien);
        } else {
            boolean z;
            if (this.qxo < 0) {
                z = true;
            } else {
                z = false;
            }
            mo8674kz(z);
            this.qxw = 0;
            if (clb()) {
                C4990ab.m7413e("MicroMsg.SightPlayController", "#0x%x is bad fps, do nothing when restart", Integer.valueOf(hashCode()));
            } else if (this.qxo < 0) {
                C4990ab.m7421w("MicroMsg.SightPlayController", "#0x%x restart match error video id, try reopen video, videoPath %s", Integer.valueOf(hashCode()), this.ien);
                if (!C5046bo.isNullOrNil(this.ien)) {
                    if (C3919b.m6212WS(this.ien)) {
                        this.rci = new C3932h(this, (byte) 0);
                        C37961o.m64222i(this.rci, 0);
                        return;
                    }
                    C4990ab.m7420w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
                    clear();
                }
            } else if (1 == this.qxm) {
                this.rcj = new C3911b(this, (byte) 0);
                this.rcl = null;
                C37961o.m64222i(this.rcj, 0);
            } else {
                this.rcj = new C3911b(this, (byte) 0);
                this.rcl = new C3917c();
                this.rcj.rcu = this.rcl;
                this.rcl.rcw = this.rcj;
                C37961o.m64222i(this.rcj, 0);
            }
        }
    }

    public final void clear() {
        C4990ab.m7417i("MicroMsg.SightPlayController", "#0x%x do clear, remove render job, video id %d, runing %B", Integer.valueOf(hashCode()), Integer.valueOf(this.qxo), Boolean.valueOf(cla()));
        mo8674kz(true);
        this.qxw = 0;
        m6208CE(this.qxo);
        this.qxo = -1;
        this.ien = "";
        this.qxn = "ERROR#PATH";
        this.qxt = null;
        this.qxM = 0.0d;
        this.qxN = false;
        C9631o.fdT.mo20963f(this.qxr);
        this.qxr = null;
    }

    /* renamed from: CE */
    private void m6208CE(final int i) {
        C37961o.m64222i(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(37410);
                long currentTimeMillis = System.currentTimeMillis();
                SightVideoJNI.freeObj(i);
                C4990ab.m7411d("MicroMsg.SightPlayController", "#0x%x tick: do clear video %d, use %d ms", Integer.valueOf(C3919b.this.hashCode()), Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.m2505o(37410);
            }
        }, 0);
    }

    /* renamed from: WS */
    public static boolean m6212WS(String str) {
        if (C5046bo.isNullOrNil(str)) {
            return false;
        }
        Integer num = (Integer) qxO.get(str);
        if (num == null || 2 != num.intValue()) {
            return true;
        }
        return false;
    }

    /* Access modifiers changed, original: final */
    public final boolean clb() {
        if (this.qxL) {
            return false;
        }
        if (VERSION.SDK_INT >= 11) {
            if (this.qxl < 3) {
                return false;
            }
            C4990ab.m7418v("MicroMsg.SightPlayController", "match not check bad fps, but now is bad fps");
            this.qxl = 0;
            return false;
        } else if (this.qxl >= 3) {
            return true;
        } else {
            return false;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void clc() {
        this.qxq = 1000 / Math.max(1, (int) SightVideoJNI.getVideoRate(this.qxo));
        C4990ab.m7411d("MicroMsg.SightPlayController", "#0x%x update video rate to %d fps, delay %d ms", Integer.valueOf(hashCode()), Integer.valueOf(r0), Integer.valueOf(this.qxq));
    }

    public final void cpV() {
        C4990ab.m7419v("MicroMsg.SightPlayController", "draw surface thumb, thumb is null ? %B", Boolean.TRUE);
        C37961o.m64223y(this.rcm);
        if (this.rcm == null) {
            this.rcm = new C3922k(this, (byte) 0);
        }
        this.rcm.qyh = new WeakReference(null);
        C37961o.m64222i(this.rcm, 0);
    }

    public final C4884c cld() {
        if (this.rcp == null) {
            this.rcp = new C3920a(this);
        }
        return this.rcp;
    }

    /* renamed from: a */
    static /* synthetic */ void m6224a(C3919b c3919b, int i, int i2) {
        C4990ab.m7411d("MicroMsg.SightPlayController", "#0x%x check bmp, video width %d, height %d", Integer.valueOf(c3919b.hashCode()), Integer.valueOf(i), Integer.valueOf(i2));
        if (c3919b.qxr == null) {
            c3919b.qxr = C9631o.fdT.mo20955a(new C9633b(i, i2));
            C4990ab.m7408b("MicroMsg.SightPlayController", "checkBmp, create new one, videoPath: %s", c3919b.ien);
        } else if (c3919b.qxr.getWidth() != i || c3919b.qxr.getHeight() != i2) {
            int i3;
            C4990ab.m7420w("MicroMsg.SightPlayController", "reset bmp, old value " + c3919b.qxr.getWidth() + "*" + c3919b.qxr.getHeight());
            if (!C1443d.m3068iW(19) || c3919b.qxr.getAllocationByteCount() < (i2 * i) * 4) {
                i3 = 0;
            } else {
                try {
                    C4990ab.m7420w("MicroMsg.SightPlayController", "reset bmp, try directly reconfigure");
                    c3919b.qxr.reconfigure(i, i2, Config.ARGB_8888);
                    i3 = 1;
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.SightPlayController", "reconfigure failed: %s" + e.getMessage());
                    i3 = 0;
                }
            }
            if (i3 == 0) {
                C9631o.fdT.mo20963f(c3919b.qxr);
                c3919b.qxr = C9631o.fdT.mo20955a(new C9633b(i, i2));
            }
            C4990ab.m7408b("MicroMsg.SightPlayController", "checkBmp, the origin bmp size not match, create new one, videoPath: %s", c3919b.ien);
        }
    }

    /* renamed from: A */
    static /* synthetic */ void m6205A(C3919b c3919b) {
        if (c3919b.qxx != null && -1 != c3919b.ckZ()) {
            if (c3919b.qxy == null && c3919b.qxx.get() != null) {
                c3919b.qxy = AnimationUtils.loadAnimation(((View) c3919b.qxx.get()).getContext(), c3919b.ckZ());
            }
            if (c3919b.rco == null) {
                c3919b.rco = new C3918d(c3919b, (byte) 0);
            }
            c3919b.lda.post(c3919b.rco);
        }
    }
}
