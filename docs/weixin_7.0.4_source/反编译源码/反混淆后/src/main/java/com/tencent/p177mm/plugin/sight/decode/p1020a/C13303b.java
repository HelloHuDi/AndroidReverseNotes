package com.tencent.p177mm.plugin.sight.decode.p1020a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.NinePatchDrawable;
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
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.memory.C9631o;
import com.tencent.p177mm.memory.C9631o.C9633b;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.p230g.p231a.C6550tn;
import com.tencent.p177mm.plugin.sight.base.SightVideoJNI;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* renamed from: com.tencent.mm.plugin.sight.decode.a.b */
public abstract class C13303b {
    private static HashMap<String, WeakReference<Bitmap>> qxK = new HashMap();
    private static Map<String, Integer> qxO = new ConcurrentHashMap();
    private boolean fNO = false;
    public boolean fVc = true;
    public String ien = "";
    private C7306ak lda;
    private Surface mSurface;
    public int position;
    private volatile C13322h qxA;
    private volatile C13311b qxB;
    public volatile C13323i qxC;
    private volatile C13317c qxD;
    private C13306k qxE;
    private C13305j qxF;
    private C13318d qxG;
    public boolean qxH = true;
    public boolean qxI = true;
    public boolean qxJ = false;
    public boolean qxL = false;
    public double qxM = -1.0d;
    boolean qxN = false;
    public double qxP = -1.0d;
    private boolean qxQ = false;
    public boolean qxR = false;
    private C13310a qxS;
    public volatile C13304e qxT;
    public volatile C13325f qxU;
    public volatile C13321g qxV;
    private int qxl = 0;
    private int qxm = 0;
    private String qxn = "";
    private int qxo = -1;
    private Queue<Integer> qxp = new ConcurrentLinkedQueue();
    protected int qxq = 41;
    private Bitmap qxr;
    public Bitmap qxs;
    private Bitmap qxt;
    private WeakReference<View> qxu;
    private WeakReference<TextView> qxv;
    private long qxw;
    public WeakReference<View> qxx;
    private Animation qxy;
    private Animation qxz;

    /* renamed from: com.tencent.mm.plugin.sight.decode.a.b$1 */
    static class C133021 implements Runnable {
        C133021() {
        }

        public final void run() {
            AppMethodBeat.m2504i(70226);
            long currentTimeMillis = System.currentTimeMillis();
            try {
                SightVideoJNI.freeAll();
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.SightPlayController", "free all sight error");
                C4990ab.printErrStackTrace("MicroMsg.SightPlayController", e, "", new Object[0]);
            }
            C4990ab.m7417i("MicroMsg.SightPlayController", "free all, use %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.m2505o(70226);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sight.decode.a.b$e */
    public interface C13304e {
        /* renamed from: c */
        void mo8940c(C13303b c13303b, int i);
    }

    /* renamed from: com.tencent.mm.plugin.sight.decode.a.b$j */
    class C13305j implements Runnable {
        private C13305j() {
        }

        /* synthetic */ C13305j(C13303b c13303b, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(70246);
            if (C13303b.this.qxo < 0 || C13303b.this.qxv == null || C13303b.this.qxv.get() == null) {
                AppMethodBeat.m2505o(70246);
                return;
            }
            ((TextView) C13303b.this.qxv.get()).setText(SightVideoJNI.getVideoInfo(C13303b.this.qxo));
            AppMethodBeat.m2505o(70246);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sight.decode.a.b$k */
    class C13306k implements Runnable {
        WeakReference<Bitmap> qyh;

        private C13306k() {
            AppMethodBeat.m2504i(70250);
            this.qyh = new WeakReference(null);
            AppMethodBeat.m2505o(70250);
        }

        /* synthetic */ C13306k(C13303b c13303b, byte b) {
            this();
        }

        public final void run() {
            View view = null;
            boolean z = true;
            AppMethodBeat.m2504i(70251);
            try {
                String str;
                String str2;
                Object[] objArr;
                View view2;
                if (C13303b.this.mSurface == null || !C13303b.this.mSurface.isValid()) {
                    boolean z2;
                    str = "MicroMsg.SightPlayController";
                    String str3 = "#0x%x-#0x%x want draw thumb, but surface status error, surface null ? %B, thumb bgView null ? %B, thumb null ? %B, mask null ? %B";
                    Object[] objArr2 = new Object[6];
                    objArr2[0] = Integer.valueOf(C13303b.this.hashCode());
                    objArr2[1] = Integer.valueOf(hashCode());
                    objArr2[2] = Boolean.valueOf(C13303b.this.mSurface == null);
                    if (C13303b.this.qxu == null) {
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
                    if (C13303b.this.qxs == null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objArr2[5] = Boolean.valueOf(z2);
                    C4990ab.m7421w(str, str3, objArr2);
                    if (C13303b.this.qxs == null) {
                        final Bitmap bitmap = (Bitmap) this.qyh.get();
                        if (C13303b.this.qxu != null) {
                            view = (View) C13303b.this.qxu.get();
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
                            AppMethodBeat.m2505o(70251);
                            return;
                        }
                        view.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(70247);
                                view.setBackgroundDrawable(new BitmapDrawable(bitmap));
                                AppMethodBeat.m2505o(70247);
                            }
                        });
                        AppMethodBeat.m2505o(70251);
                        return;
                    }
                    if (!(C13303b.this.qxt != null && C13303b.this.qxt.getWidth() == C13303b.this.qxs.getWidth() && C13303b.this.qxt.getHeight() == C13303b.this.qxs.getHeight())) {
                        try {
                            C13303b.this.qxt = Bitmap.createBitmap(C13303b.this.qxs.getWidth(), C13303b.this.qxs.getHeight(), Config.ARGB_8888);
                        } catch (Exception e) {
                            C4990ab.printErrStackTrace("MicroMsg.SightPlayController", e, "try to create thumb bmp error:%s", e.getMessage());
                            C13303b.this.qxt = null;
                        }
                    }
                    if (C13303b.this.qxt == null || this.qyh.get() == null || ((Bitmap) this.qyh.get()).isRecycled()) {
                        str2 = "MicroMsg.SightPlayController";
                        str = "mThubmBgBmp:%B, thumbRef:%B";
                        objArr = new Object[2];
                        if (C13303b.this.qxt == null) {
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
                        AppMethodBeat.m2505o(70251);
                        return;
                    }
                    long nanoTime = System.nanoTime();
                    SightVideoJNI.handleThumb((Bitmap) this.qyh.get(), C13303b.this.qxt, C13303b.this.qxs);
                    C4990ab.m7417i("MicroMsg.SightPlayController", "handle thumb use %d us", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
                    final Bitmap q = C13303b.this.qxt;
                    if (C13303b.this.qxu != null) {
                        view2 = (View) C13303b.this.qxu.get();
                    } else {
                        view2 = null;
                    }
                    if (view2 == null || q == null) {
                        AppMethodBeat.m2505o(70251);
                        return;
                    }
                    view2.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(70248);
                            view2.setBackgroundDrawable(new BitmapDrawable(q));
                            AppMethodBeat.m2505o(70248);
                        }
                    });
                    AppMethodBeat.m2505o(70251);
                    return;
                }
                str2 = "MicroMsg.SightPlayController";
                str = "#0x%x-#0x%x draw thumb, thumb empty ? %B";
                objArr = new Object[3];
                objArr[0] = Integer.valueOf(C13303b.this.hashCode());
                objArr[1] = Integer.valueOf(hashCode());
                objArr[2] = Boolean.valueOf(this.qyh.get() == null);
                C4990ab.m7411d(str2, str, objArr);
                if (C13303b.this.qxu != null) {
                    view2 = (View) C13303b.this.qxu.get();
                    if (view2 != null) {
                        view2.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(70249);
                                C4990ab.m7418v("MicroMsg.SightPlayController", "set background drawable null");
                                view2.setBackgroundDrawable(null);
                                AppMethodBeat.m2505o(70249);
                            }
                        });
                    }
                }
                if (this.qyh.get() == null) {
                    SightVideoJNI.drawSurfaceColor(C13303b.this.mSurface, 0);
                    AppMethodBeat.m2505o(70251);
                    return;
                }
                SightVideoJNI.drawSurfaceThumb(C13303b.this.mSurface, (Bitmap) this.qyh.get(), C13303b.this.qxs);
                AppMethodBeat.m2505o(70251);
            } catch (Exception e2) {
                C4990ab.printErrStackTrace("MicroMsg.SightPlayController", e2, "", new Object[0]);
                AppMethodBeat.m2505o(70251);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.sight.decode.a.b$a */
    static class C13310a extends C4884c<C6550tn> {
        int mik = 0;
        int qxY = 0;
        int qxZ = 0;
        WeakReference<C13303b> qya;

        public C13310a(C13303b c13303b) {
            super(0);
            AppMethodBeat.m2504i(70229);
            this.qya = new WeakReference(c13303b);
            this.xxI = C6550tn.class.getName().hashCode();
            AppMethodBeat.m2505o(70229);
        }

        /* renamed from: a */
        private void m21429a(C6550tn c6550tn) {
            this.qxY = c6550tn.cPI.cPL;
            this.qxZ = c6550tn.cPI.cPJ;
            this.mik = c6550tn.cPI.cPK;
        }

        private boolean clg() {
            AppMethodBeat.m2504i(70230);
            if (this.qya.get() == null) {
                AppMethodBeat.m2505o(70230);
                return false;
            }
            int E = ((C13303b) this.qya.get()).position + this.qxY;
            if (E < this.qxZ || E > this.mik) {
                AppMethodBeat.m2505o(70230);
                return false;
            }
            AppMethodBeat.m2505o(70230);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sight.decode.a.b$b */
    class C13311b implements Runnable {
        volatile boolean ovl;
        C13317c qyb;

        /* renamed from: com.tencent.mm.plugin.sight.decode.a.b$b$2 */
        class C133122 implements Runnable {
            C133122() {
            }

            public final void run() {
                AppMethodBeat.m2504i(70233);
                C13303b.this.qxQ = true;
                AppMethodBeat.m2505o(70233);
            }
        }

        /* renamed from: com.tencent.mm.plugin.sight.decode.a.b$b$3 */
        class C133133 implements Runnable {
            C133133() {
            }

            public final void run() {
                AppMethodBeat.m2504i(70234);
                C13303b.this.mo8532U(null);
                AppMethodBeat.m2505o(70234);
            }
        }

        /* renamed from: com.tencent.mm.plugin.sight.decode.a.b$b$1 */
        class C133141 implements Runnable {
            C133141() {
            }

            public final void run() {
                AppMethodBeat.m2504i(70232);
                C13303b.this.qxV.cli().setVisibility(8);
                AppMethodBeat.m2505o(70232);
            }
        }

        /* renamed from: com.tencent.mm.plugin.sight.decode.a.b$b$5 */
        class C133155 implements Runnable {
            C133155() {
            }

            public final void run() {
                AppMethodBeat.m2504i(70236);
                if (C13303b.this.qxV != null) {
                    View cli = C13303b.this.qxV.cli();
                    if (cli != null) {
                        if (!(C13303b.this.qxz != null || C13303b.this.qxV.clj() == -1 || C13303b.this.qxx.get() == null)) {
                            C13303b.this.qxz = AnimationUtils.loadAnimation(((View) C13303b.this.qxx.get()).getContext(), C13303b.this.qxV.clj());
                        }
                        if (C13303b.this.qxz != null) {
                            cli.startAnimation(C13303b.this.qxz);
                        }
                        cli.setVisibility(0);
                    }
                }
                AppMethodBeat.m2505o(70236);
            }
        }

        /* renamed from: com.tencent.mm.plugin.sight.decode.a.b$b$4 */
        class C133164 implements Runnable {
            C133164() {
            }

            public final void run() {
                AppMethodBeat.m2504i(70235);
                if (C13303b.this.qxT != null) {
                    C13303b.this.qxT.mo8940c(C13303b.this, 0);
                }
                AppMethodBeat.m2505o(70235);
            }
        }

        private C13311b() {
            this.ovl = false;
        }

        /* synthetic */ C13311b(C13303b c13303b, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(70237);
            if (!(C13303b.this.qxV == null || C13303b.this.qxV.cli() == null || C13303b.this.qxV.cli().getVisibility() != 0)) {
                C13303b.this.lda.post(new C133141());
            }
            if (C13303b.this.qxo < 0) {
                C4990ab.m7421w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id, path %s", Integer.valueOf(C13303b.this.hashCode()), Integer.valueOf(hashCode()), C13303b.this.ien);
                AppMethodBeat.m2505o(70237);
            } else if (this.ovl) {
                C4990ab.m7413e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at beg", Integer.valueOf(C13303b.this.hashCode()), Integer.valueOf(hashCode()));
                AppMethodBeat.m2505o(70237);
            } else {
                float f;
                double clk;
                if (C13303b.this.qxw == 0) {
                    if (C13303b.this.qxC != null) {
                        C13303b.this.qxC.type = 1;
                        C13303b.this.qxC.run();
                    }
                    C13303b.this.qxw = System.currentTimeMillis();
                }
                Object obj = null;
                if (C13303b.this.qxP != -1.0d) {
                    if (C13303b.this.qxJ) {
                        if (C13303b.this.qxC != null) {
                            C13303b.this.qxC.type = 4;
                            C13303b.this.qxC.qxP = C13303b.this.qxP;
                            C13303b.this.qxC.run();
                            C13303b.this.lda.postDelayed(new C133122(), 100);
                        } else if (SightVideoJNI.seekStream(C13303b.this.qxP, C13303b.this.qxo) > 0) {
                            if (C13303b.this.qxC == null) {
                                C13303b.this.qxC = new C13323i(C13303b.this, (byte) 0);
                            }
                            C13303b.this.qxC.type = 4;
                            C13303b.this.qxC.qxP = C13303b.this.qxP;
                            C13303b.this.qxC.run();
                            obj = 1;
                        }
                    } else if (SightVideoJNI.seekStream(C13303b.this.qxP, C13303b.this.qxo) > 0) {
                        if (C13303b.this.qxC == null) {
                            C13303b.this.qxC = new C13323i(C13303b.this, (byte) 0);
                        }
                        C13303b.this.qxC.type = 4;
                        C13303b.this.qxC.qxP = C13303b.this.qxP;
                        C13303b.this.qxC.run();
                        obj = 1;
                    }
                }
                float currentTimeMillis = (float) (System.currentTimeMillis() - C13303b.this.qxw);
                if (obj != null) {
                    f = 0.0f;
                } else {
                    f = (currentTimeMillis / ((float) C13303b.this.qxq)) + 0.5f;
                }
                if (C13303b.this.qxJ && C13303b.this.qxQ) {
                    C13303b.this.qxQ = false;
                    if (C13303b.this.qxC != null) {
                        clk = C13303b.this.qxC.clk() / 1000.0d;
                        if (SightVideoJNI.seekStream(clk, C13303b.this.qxo) > 0) {
                            f = 0.0f;
                            C4990ab.m7416i("MicroMsg.SightPlayController", "seek to " + clk + " modify time : 0.0");
                        }
                    }
                }
                float f2 = f;
                if (C13303b.this.fNO) {
                    C4990ab.m7417i("MicroMsg.SightPlayController", "#0x%x video %d id passedTime:  %s  seek  %s", Integer.valueOf(C13303b.this.hashCode()), Integer.valueOf(C13303b.this.qxo), Float.valueOf(currentTimeMillis), Float.valueOf(f2));
                }
                C13303b.this.qxw = System.currentTimeMillis();
                if (f2 >= 2.0f) {
                    C13303b.this.qxl = C13303b.this.qxl + 1;
                } else {
                    C13303b.this.qxl = Math.max(0, C13303b.this.qxl - 1);
                }
                if (C13303b.this.clb()) {
                    C4990ab.m7413e("MicroMsg.SightPlayController", "match tolerate bad seek times %d", Integer.valueOf(C13303b.this.qxl));
                    C13303b.this.clear();
                    AppMethodBeat.m2505o(70237);
                    return;
                }
                int i;
                Object obj2 = null;
                int i2 = 0;
                if (1 == C13303b.this.qxm) {
                    Object obj3;
                    if (C13303b.this.mSurface == null || C13303b.this.mSurface.isValid()) {
                        i2 = SightVideoJNI.drawSurfaceFrame(C13303b.this.qxo, C13303b.this.mSurface, (int) f2, C13303b.this.qxs, C13303b.this.fVc);
                        if (C13303b.this.qxU != null) {
                            clk = SightVideoJNI.getVideoPlayTime(C13303b.this.qxo);
                            i = (int) clk;
                            if (i != ((int) C13303b.this.qxM)) {
                                C13303b.this.qxU.mo8946b(C13303b.this, (long) i);
                            }
                            C13303b.this.qxM = clk;
                        }
                        if (i2 == 0) {
                            C13303b.this.qxP = -1.0d;
                            obj3 = null;
                        } else if (1 == i2) {
                            C13303b.this.qxP = -1.0d;
                            obj3 = 1;
                            C13303b.this.qxw = 0;
                            C13303b.m21369B(C13303b.this);
                        } else if (-7 == i2) {
                            C4990ab.m7420w("MicroMsg.SightPlayController", "surface is null, continue");
                            obj3 = null;
                        } else {
                            C4990ab.m7413e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error:%d", Integer.valueOf(C13303b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2));
                            this.ovl = true;
                            if (this.qyb != null) {
                                this.qyb.ovl = true;
                            }
                            C13303b.this.mo25371T(null);
                            if (C13303b.this.qxT != null) {
                                C13303b.this.qxT.mo8940c(C13303b.this, -1);
                            }
                            obj3 = null;
                        }
                    } else {
                        C4990ab.m7413e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error, surface is not valid", Integer.valueOf(C13303b.this.hashCode()), Integer.valueOf(hashCode()));
                        this.ovl = true;
                        if (this.qyb != null) {
                            this.qyb.ovl = true;
                            obj3 = null;
                        }
                        obj3 = null;
                    }
                    if (C13303b.this.qxC != null) {
                        C4990ab.m7410d("MicroMsg.SightPlayController", "voice time is" + (C13303b.this.qxC.clk() / 1000.0d));
                        obj2 = obj3;
                    } else {
                        obj2 = obj3;
                    }
                } else {
                    i2 = SightVideoJNI.drawFrame(C13303b.this.qxo, C13303b.this.qxr, (int) f2, null, false, C13303b.this.fVc);
                    if (C13303b.this.qxU != null) {
                        clk = SightVideoJNI.getVideoPlayTime(C13303b.this.qxo);
                        i = (int) clk;
                        if (i != ((int) C13303b.this.qxM)) {
                            C13303b.this.qxU.mo8946b(C13303b.this, (long) i);
                        }
                        C13303b.this.qxM = clk;
                        if (C13303b.this.fNO) {
                            C4990ab.m7417i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", Integer.valueOf(C13303b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2), Double.valueOf(clk));
                        }
                    } else if (C13303b.this.fNO) {
                        clk = SightVideoJNI.getVideoPlayTime(C13303b.this.qxo);
                        if (C13303b.this.fNO) {
                            C4990ab.m7417i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", Integer.valueOf(C13303b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2), Double.valueOf(clk));
                        }
                    } else if (C13303b.this.fNO) {
                        C4990ab.m7417i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d", Integer.valueOf(C13303b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2));
                    }
                    if (i2 == 0) {
                        C13303b.this.qxP = -1.0d;
                    } else if (1 == i2) {
                        C13303b.this.qxP = -1.0d;
                        obj2 = 1;
                        C13303b.this.qxw = 0;
                        C13303b.m21369B(C13303b.this);
                    } else {
                        C13303b.this.qxP = -1.0d;
                        C4990ab.m7413e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw bitmap match error:%d", Integer.valueOf(C13303b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2));
                        this.ovl = true;
                        if (this.qyb != null) {
                            this.qyb.ovl = true;
                        }
                        C13303b.this.lda.post(new C133133());
                        if (C13303b.this.qxT != null) {
                            C13303b.this.qxT.mo8940c(C13303b.this, -1);
                        }
                    }
                }
                if (1 == i2) {
                    C13303b.this.lda.post(new C133164());
                }
                if (this.ovl) {
                    C4990ab.m7413e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at end", Integer.valueOf(C13303b.this.hashCode()), Integer.valueOf(hashCode()));
                    if (C13303b.this.qxC != null) {
                        C13303b.this.qxC.type = 0;
                        C13303b.this.qxC.run();
                    }
                    AppMethodBeat.m2505o(70237);
                    return;
                }
                if (1 == C13303b.this.qxm) {
                    long currentTimeMillis2 = ((long) C13303b.this.qxq) - (System.currentTimeMillis() - C13303b.this.qxw);
                    if (C13303b.this.qxw == 0) {
                        C37961o.m64222i(this, (long) (C13303b.this.qxq * 5));
                    } else if (currentTimeMillis2 > 0) {
                        C37961o.m64222i(this, currentTimeMillis2);
                    } else {
                        C37961o.m64222i(this, 0);
                    }
                } else if (obj2 == null || C13303b.this.qxV == null) {
                    this.qyb.qyd = i2;
                    C13303b.this.lda.post(this.qyb);
                } else {
                    i = C13303b.this.qxV.clh();
                    C13303b.this.lda.post(new C133155());
                    this.qyb.qyd = i2;
                    C13303b.this.lda.postDelayed(this.qyb, (long) i);
                }
                if (C13303b.this.qxC != null) {
                    C4990ab.m7410d("MicroMsg.SightPlayController", "voice time is" + (C13303b.this.qxC.clk() / 1000.0d));
                }
                AppMethodBeat.m2505o(70237);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.sight.decode.a.b$c */
    class C13317c implements Runnable {
        volatile boolean ovl = false;
        int qyd;
        C13311b qye;

        public C13317c() {
            AppMethodBeat.m2504i(70238);
            C4990ab.m7416i("MicroMsg.SightPlayController", "make sure drawJob alive");
            AppMethodBeat.m2505o(70238);
        }

        public final void run() {
            AppMethodBeat.m2504i(70239);
            if (this.ovl) {
                C4990ab.m7413e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop draw", Integer.valueOf(C13303b.this.hashCode()), Integer.valueOf(hashCode()));
                AppMethodBeat.m2505o(70239);
                return;
            }
            C13303b.this.mo8532U(C13303b.this.qxr);
            if (C13303b.this.qxw == 0) {
                C37961o.m64222i(this.qye, 0);
                AppMethodBeat.m2505o(70239);
                return;
            }
            long currentTimeMillis = ((long) C13303b.this.qxq) - (System.currentTimeMillis() - C13303b.this.qxw);
            if (currentTimeMillis > 0) {
                C37961o.m64222i(this.qye, currentTimeMillis);
                AppMethodBeat.m2505o(70239);
                return;
            }
            C37961o.m64222i(this.qye, 0);
            AppMethodBeat.m2505o(70239);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sight.decode.a.b$d */
    class C13318d implements Runnable {
        private C13318d() {
        }

        /* synthetic */ C13318d(C13303b c13303b, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(70240);
            if (C13303b.this.qxx.get() == null) {
                AppMethodBeat.m2505o(70240);
                return;
            }
            ((View) C13303b.this.qxx.get()).startAnimation(C13303b.this.qxy);
            AppMethodBeat.m2505o(70240);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sight.decode.a.b$3 */
    public class C133193 implements Runnable {
        final /* synthetic */ double qxX;

        public C133193(double d) {
            this.qxX = d;
        }

        public final void run() {
            AppMethodBeat.m2504i(70228);
            C4990ab.m7417i("MicroMsg.SightPlayController", "SeekToFrame   %f  %s", Double.valueOf(this.qxX), C5046bo.dpG().toString());
            C13303b.this.qxP = this.qxX;
            AppMethodBeat.m2505o(70228);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sight.decode.a.b$g */
    public interface C13321g {
        int clh();

        View cli();

        int clj();
    }

    /* renamed from: com.tencent.mm.plugin.sight.decode.a.b$h */
    class C13322h implements Runnable {
        volatile boolean ovl;

        private C13322h() {
            this.ovl = false;
        }

        /* synthetic */ C13322h(C13303b c13303b, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(70241);
            if (C13303b.this.clb()) {
                C4990ab.m7412e("MicroMsg.SightPlayController", "is bad fps, do nothing when open file");
                AppMethodBeat.m2505o(70241);
                return;
            }
            C13303b.this.qxo = SightVideoJNI.openFile(C13303b.this.ien, 1 == C13303b.this.qxm ? 0 : 1, 1, false);
            C4990ab.m7417i("MicroMsg.SightPlayController", "SightVideoJNI.openFile mVideoPath:%s mVideoId:%s", C13303b.this.ien, Integer.valueOf(C13303b.this.qxo));
            C13303b.this.qxp.offer(Integer.valueOf(C13303b.this.qxo));
            if (C13303b.this.qxo < 0) {
                C4990ab.m7421w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id %d, path %s", Integer.valueOf(hashCode()), Integer.valueOf(C13303b.this.hashCode()), Integer.valueOf(C13303b.this.qxo), C13303b.this.ien);
                C13303b.this.mo25371T(null);
                if (C13303b.this.qxT != null) {
                    C13303b.this.qxT.mo8940c(C13303b.this, -1);
                }
                AppMethodBeat.m2505o(70241);
                return;
            }
            if (((Boolean) C1720g.m3536RP().mo5239Ry().get(344065, Boolean.FALSE)).booleanValue()) {
                if (C13303b.this.qxF == null) {
                    C13303b.this.qxF = new C13305j(C13303b.this, (byte) 0);
                }
                C13303b.this.lda.removeCallbacks(C13303b.this.qxF);
                C13303b.this.lda.post(C13303b.this.qxF);
            }
            int max = Math.max(1, SightVideoJNI.getVideoWidth(C13303b.this.qxo));
            int max2 = Math.max(1, SightVideoJNI.getVideoHeight(C13303b.this.qxo));
            if (C13303b.this.qxm == 0) {
                if (max * max2 >= 1048576 || max <= 0 || max2 <= 0) {
                    C4990ab.m7413e("MicroMsg.SightPlayController", "get error info videoWidth %d height  %d", Integer.valueOf(max), Integer.valueOf(max2));
                    AppMethodBeat.m2505o(70241);
                    return;
                }
                C13303b.m21389a(C13303b.this, max, max2);
            }
            C13303b.this.clc();
            if (Float.compare(((float) max) / ((float) max2), 5.0f) > 0 || Float.compare(((float) max2) / ((float) max), 5.0f) > 0) {
                C4990ab.m7421w("MicroMsg.SightPlayController", "ERROR Video size %d, %d", Integer.valueOf(max), Integer.valueOf(max2));
                if (!C5046bo.isNullOrNil(C13303b.this.ien)) {
                    C13303b.qxO.put(C13303b.this.ien, Integer.valueOf(2));
                }
                C13303b.this.qxw = 0;
                C13303b.this.m21399d(C13303b.this.qxp);
                C13303b.this.qxo = -1;
                C13303b.this.ien = "";
                C13303b.this.qxn = "ERROR#PATH";
                C13303b.this.qxt = null;
                this.ovl = true;
                if (C13303b.this.qxT != null) {
                    C13303b.this.qxT.mo8940c(C13303b.this, -1);
                }
                AppMethodBeat.m2505o(70241);
                return;
            }
            C13303b.this.mo8534dH(max, max2);
            if (1 == C13303b.this.qxm) {
                C13303b.this.qxB = new C13311b(C13303b.this, (byte) 0);
                C13303b.this.qxD = null;
                if (!this.ovl) {
                    C37961o.m64222i(C13303b.this.qxB, 0);
                }
            } else {
                C13303b.this.qxB = new C13311b(C13303b.this, (byte) 0);
                C13303b.this.qxD = new C13317c();
                C13303b.this.qxB.qyb = C13303b.this.qxD;
                C13303b.this.qxD.qye = C13303b.this.qxB;
                if (!this.ovl) {
                    C37961o.m64222i(C13303b.this.qxB, 0);
                }
            }
            if (this.ovl) {
                C4990ab.m7413e("MicroMsg.SightPlayController", "#0x%x-#0x%x open file end, match stop %B", Integer.valueOf(C13303b.this.hashCode()), Integer.valueOf(hashCode()), Boolean.valueOf(this.ovl));
            }
            AppMethodBeat.m2505o(70241);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sight.decode.a.b$i */
    public class C13323i implements Runnable {
        double qxP;
        MediaPlayer qyf;
        public int type;

        /* renamed from: com.tencent.mm.plugin.sight.decode.a.b$i$1 */
        class C133241 implements OnErrorListener {
            C133241() {
            }

            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                AppMethodBeat.m2504i(70242);
                C4990ab.m7413e("MicroMsg.SightPlayController", "on error: play %s ERROR!! %d %d", C13303b.this.ien, Integer.valueOf(i), Integer.valueOf(i2));
                C13303b.this.clear();
                if (C13303b.this.qxT != null) {
                    C13303b.this.qxT.mo8940c(C13303b.this, -1);
                }
                AppMethodBeat.m2505o(70242);
                return true;
            }
        }

        private C13323i() {
            this.qxP = -1.0d;
        }

        public /* synthetic */ C13323i(C13303b c13303b, byte b) {
            this();
        }

        private void bUd() {
            AppMethodBeat.m2504i(70243);
            C4990ab.m7416i("MicroMsg.SightPlayController", "stopPlayer");
            try {
                if (this.qyf != null) {
                    this.qyf.stop();
                    this.qyf.release();
                    this.qyf = null;
                }
                AppMethodBeat.m2505o(70243);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.SightPlayController", e, "stop play sound error: %s", e.getMessage());
                this.qyf = null;
                AppMethodBeat.m2505o(70243);
            }
        }

        public final double clk() {
            AppMethodBeat.m2504i(70244);
            if (this.qyf == null) {
                AppMethodBeat.m2505o(70244);
                return 0.0d;
            }
            double currentPosition = (double) this.qyf.getCurrentPosition();
            AppMethodBeat.m2505o(70244);
            return currentPosition;
        }

        public final void run() {
            String str;
            AppMethodBeat.m2504i(70245);
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
                    AppMethodBeat.m2505o(70245);
                    return;
                case 1:
                    bUd();
                    if (!C5046bo.isNullOrNil(C13303b.this.ien)) {
                        try {
                            this.qyf = new C45289k();
                            this.qyf.setDisplay(null);
                            this.qyf.reset();
                            this.qyf.setDataSource(C13303b.this.ien);
                            this.qyf.setAudioStreamType(3);
                            this.qyf.setOnErrorListener(new C133241());
                            this.qyf.prepare();
                            this.qyf.start();
                            AppMethodBeat.m2505o(70245);
                            return;
                        } catch (Exception e) {
                            C4990ab.printErrStackTrace("MicroMsg.SightPlayController", e, "play sound error: %s", e.getMessage());
                            C4990ab.m7413e("MicroMsg.SightPlayController", "on Exception: play %s ERROR!!", C13303b.this.ien);
                            C13303b.this.clear();
                            if (C13303b.this.qxT != null) {
                                C13303b.this.qxT.mo8940c(C13303b.this, -1);
                            }
                            AppMethodBeat.m2505o(70245);
                            return;
                        }
                    }
                    break;
                case 2:
                    try {
                        if (this.qyf != null && this.qyf.isPlaying()) {
                            this.qyf.pause();
                        }
                        AppMethodBeat.m2505o(70245);
                        return;
                    } catch (Exception e2) {
                        C4990ab.printErrStackTrace("MicroMsg.SightPlayController", e2, "pause sound error: %s", e2.getMessage());
                        bUd();
                        AppMethodBeat.m2505o(70245);
                        return;
                    }
                case 3:
                    try {
                        if (this.qyf != null) {
                            this.qyf.start();
                        }
                        AppMethodBeat.m2505o(70245);
                        return;
                    } catch (Exception e22) {
                        C4990ab.printErrStackTrace("MicroMsg.SightPlayController", e22, "pause sound error: %s", e22.getMessage());
                        bUd();
                        AppMethodBeat.m2505o(70245);
                        return;
                    }
                case 4:
                    try {
                        C4990ab.m7417i("MicroMsg.SightPlayController", "soundplayer seek %f", Double.valueOf(this.qxP));
                        this.qyf.seekTo((int) (this.qxP * 1000.0d));
                        AppMethodBeat.m2505o(70245);
                        return;
                    } catch (Exception e222) {
                        C4990ab.printErrStackTrace("MicroMsg.SightPlayController", e222, "seek sound error: %s", e222.getMessage());
                        break;
                    }
            }
            AppMethodBeat.m2505o(70245);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sight.decode.a.b$f */
    public interface C13325f {
        /* renamed from: b */
        void mo8946b(C13303b c13303b, long j);
    }

    /* renamed from: U */
    public abstract void mo8532U(Bitmap bitmap);

    /* renamed from: dH */
    public abstract void mo8534dH(int i, int i2);

    /* renamed from: b */
    public static Bitmap m21393b(Context context, int i, int i2, int i3, int i4) {
        String format = String.format("%s-%s-%s-%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        WeakReference weakReference = (WeakReference) qxK.get(format);
        if (weakReference != null && weakReference.get() != null) {
            return (Bitmap) weakReference.get();
        }
        if (context == null) {
            C4990ab.m7420w("MicroMsg.SightPlayController", "get mask bmp, but context is null");
            return null;
        } else if (i <= 0) {
            C4990ab.m7420w("MicroMsg.SightPlayController", "get mask bmp, but mask id error");
            return null;
        } else if (i2 <= 0 || i4 <= 0 || i3 <= 0) {
            C4990ab.m7420w("MicroMsg.SightPlayController", "get mask bmp, but size error");
            return null;
        } else {
            long yz = C5046bo.m7588yz();
            int i5 = (i2 * i4) / i3;
            NinePatchDrawable ninePatchDrawable = (NinePatchDrawable) context.getResources().getDrawable(i);
            ninePatchDrawable.setBounds(0, 0, i2, i5);
            Bitmap createBitmap = Bitmap.createBitmap(i2, i5, Config.ARGB_8888);
            ninePatchDrawable.draw(new Canvas(createBitmap));
            qxK.put(format, new WeakReference(createBitmap));
            C4990ab.m7411d("MicroMsg.SightPlayController", "create mask bmp use %dms", Long.valueOf(C5046bo.m7525az(yz)));
            return createBitmap;
        }
    }

    /* renamed from: WY */
    public static void m21377WY() {
        C37961o.m64222i(new C133021(), 0);
    }

    public C13303b(int i, View view) {
        this.qxm = i;
        this.lda = new C7306ak(Looper.getMainLooper());
        this.qxx = new WeakReference(view);
        C4990ab.m7417i("MicroMsg.SightPlayController", "new SightPlayController, drawType %d", Integer.valueOf(i));
    }

    /* Access modifiers changed, original: protected */
    public int ckZ() {
        return -1;
    }

    /* renamed from: kz */
    public final void mo25380kz(boolean z) {
        if (this.qxA != null) {
            C37961o.m64223y(this.qxA);
            this.qxA.ovl = true;
        }
        if (this.qxD != null) {
            this.lda.removeCallbacks(this.qxD);
            this.qxD.ovl = true;
        }
        if (this.qxB != null) {
            C37961o.m64223y(this.qxB);
            this.qxB.ovl = true;
        }
        if (this.qxC != null) {
            this.qxC.type = z ? 0 : 2;
            C37961o.m64222i(this.qxC, 0);
        }
    }

    public final boolean cla() {
        if (1 == this.qxm) {
            if (this.qxB == null || this.qxB.ovl) {
                return false;
            }
            return true;
        } else if (this.qxD == null || this.qxD.ovl || this.qxB == null || this.qxB.ovl) {
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
            mo25380kz(z);
            this.qxw = 0;
            if (clb()) {
                C4990ab.m7413e("MicroMsg.SightPlayController", "#0x%x is bad fps, do nothing when restart", Integer.valueOf(hashCode()));
            } else if (this.qxo < 0) {
                C4990ab.m7421w("MicroMsg.SightPlayController", "#0x%x restart match error video id, try reopen video, videoPath %s", Integer.valueOf(hashCode()), this.ien);
                if (!C5046bo.isNullOrNil(this.ien)) {
                    if (C13303b.m21376WS(this.ien)) {
                        this.qxA = new C13322h(this, (byte) 0);
                        C37961o.m64222i(this.qxA, 0);
                        return;
                    }
                    C4990ab.m7420w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
                    clear();
                }
            } else if (1 == this.qxm) {
                this.qxB = new C13311b(this, (byte) 0);
                this.qxD = null;
                C37961o.m64222i(this.qxB, 0);
            } else {
                this.qxB = new C13311b(this, (byte) 0);
                this.qxD = new C13317c();
                this.qxB.qyb = this.qxD;
                this.qxD.qye = this.qxB;
                C37961o.m64222i(this.qxB, 0);
            }
        }
    }

    public final void clear() {
        C4990ab.m7417i("MicroMsg.SightPlayController", "#0x%x do clear, remove render job, video id %d, runing %B", Integer.valueOf(hashCode()), Integer.valueOf(this.qxo), Boolean.valueOf(cla()));
        mo25380kz(true);
        this.qxw = 0;
        m21399d(this.qxp);
        this.qxo = -1;
        this.ien = "";
        this.qxn = "ERROR#PATH";
        this.qxt = null;
        this.qxM = 0.0d;
        this.qxN = false;
        C9631o.fdT.mo20963f(this.qxr);
        this.qxr = null;
    }

    /* renamed from: d */
    private void m21399d(Queue<Integer> queue) {
        while (true) {
            Integer num = (Integer) queue.poll();
            if (num != null) {
                m21371CE(num.intValue());
            } else {
                return;
            }
        }
    }

    /* renamed from: CE */
    private void m21371CE(final int i) {
        C37961o.m64222i(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(70227);
                long currentTimeMillis = System.currentTimeMillis();
                SightVideoJNI.freeObj(i);
                C4990ab.m7411d("MicroMsg.SightPlayController", "#0x%x tick: do clear video %d, use %d ms", Integer.valueOf(C13303b.this.hashCode()), Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.m2505o(70227);
            }
        }, 0);
    }

    /* renamed from: bf */
    public final void mo25372bf(String str, boolean z) {
        C4990ab.m7417i("MicroMsg.SightPlayController", "#0x%x data: set video[%s], old path[%s], fling[%B], last video id %d, recording %B, canPlay %B", Integer.valueOf(hashCode()), str, this.ien, Boolean.valueOf(z), Integer.valueOf(this.qxo), Boolean.valueOf(this.qxR), Boolean.valueOf(this.qxI));
        if (this.qxR) {
            mo25380kz(false);
        } else if (clb()) {
            C4990ab.m7412e("MicroMsg.SightPlayController", "is bad fps, do nothing when set video path");
            clear();
        } else if (!this.qxI) {
            clear();
        } else if (z) {
            this.qxn = str;
            mo25380kz(false);
        } else if (this.ien.equals(str)) {
            this.qxn = "ERROR#PATH";
            mo25380kz(false);
            restart();
        } else {
            clear();
            if (str == null) {
                str = "";
            }
            this.ien = str;
            if (C5046bo.isNullOrNil(this.ien)) {
                C4990ab.m7420w("MicroMsg.SightPlayController", "empty video path, do draw empty thumb and return");
                mo25371T(null);
            } else if (C13303b.m21376WS(this.ien)) {
                this.qxA = new C13322h(this, (byte) 0);
                C37961o.m64222i(this.qxA, 0);
            } else {
                C4990ab.m7420w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
                clear();
            }
        }
    }

    /* renamed from: WS */
    public static boolean m21376WS(String str) {
        if (C5046bo.isNullOrNil(str)) {
            return false;
        }
        Integer num = (Integer) qxO.get(str);
        if (num == null || 2 != num.intValue()) {
            return true;
        }
        return false;
    }

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

    /* renamed from: g */
    public final void mo25379g(Surface surface) {
        C4990ab.m7419v("MicroMsg.SightPlayController", "set play surface %s", surface);
        this.mSurface = surface;
        C37961o.m64222i(this.qxE, 0);
    }

    public final void setThumbBgView(View view) {
        this.qxu = new WeakReference(view);
    }

    public final void setSightInfoView(TextView textView) {
        this.qxv = new WeakReference(textView);
    }

    /* renamed from: T */
    public final void mo25371T(Bitmap bitmap) {
        boolean z = true;
        String str = "MicroMsg.SightPlayController";
        String str2 = "draw surface thumb, thumb is null ? %B";
        Object[] objArr = new Object[1];
        if (bitmap != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        C4990ab.m7419v(str, str2, objArr);
        C37961o.m64223y(this.qxE);
        if (this.qxE == null) {
            this.qxE = new C13306k(this, (byte) 0);
        }
        this.qxE.qyh = new WeakReference(bitmap);
        C37961o.m64222i(this.qxE, 0);
    }

    public final C4884c cld() {
        if (this.qxS == null) {
            this.qxS = new C13310a(this);
        }
        return this.qxS;
    }

    public final double cle() {
        if (this.qxo == -1) {
            return 0.0d;
        }
        return SightVideoJNI.getVideoDuration(this.qxo);
    }

    /* renamed from: a */
    static /* synthetic */ void m21389a(C13303b c13303b, int i, int i2) {
        C4990ab.m7411d("MicroMsg.SightPlayController", "#0x%x check bmp, video width %d, height %d", Integer.valueOf(c13303b.hashCode()), Integer.valueOf(i), Integer.valueOf(i2));
        if (c13303b.qxr == null) {
            c13303b.qxr = C9631o.fdT.mo20955a(new C9633b(i, i2));
            C4990ab.m7408b("MicroMsg.SightPlayController", "checkBmp, create new one, videoPath: %s", c13303b.ien);
        } else if (c13303b.qxr.getWidth() != i || c13303b.qxr.getHeight() != i2) {
            int i3;
            C4990ab.m7420w("MicroMsg.SightPlayController", "reset bmp, old value " + c13303b.qxr.getWidth() + "*" + c13303b.qxr.getHeight());
            if (!C1443d.m3068iW(19) || c13303b.qxr.getAllocationByteCount() < (i2 * i) * 4) {
                i3 = 0;
            } else {
                try {
                    C4990ab.m7420w("MicroMsg.SightPlayController", "reset bmp, try directly reconfigure");
                    c13303b.qxr.reconfigure(i, i2, Config.ARGB_8888);
                    i3 = 1;
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.SightPlayController", "reconfigure failed: %s" + e.getMessage());
                    i3 = 0;
                }
            }
            if (i3 == 0) {
                C9631o.fdT.mo20963f(c13303b.qxr);
                c13303b.qxr = C9631o.fdT.mo20955a(new C9633b(i, i2));
            }
            C4990ab.m7408b("MicroMsg.SightPlayController", "checkBmp, the origin bmp size not match, create new one, videoPath: %s", c13303b.ien);
        }
    }

    /* renamed from: B */
    static /* synthetic */ void m21369B(C13303b c13303b) {
        if (c13303b.qxx != null && -1 != c13303b.ckZ() && c13303b.qxH) {
            if (c13303b.qxy == null && c13303b.qxx.get() != null) {
                c13303b.qxy = AnimationUtils.loadAnimation(((View) c13303b.qxx.get()).getContext(), c13303b.ckZ());
            }
            if (c13303b.qxG == null) {
                c13303b.qxG = new C13318d(c13303b, (byte) 0);
            }
            c13303b.lda.post(c13303b.qxG);
        }
    }
}
