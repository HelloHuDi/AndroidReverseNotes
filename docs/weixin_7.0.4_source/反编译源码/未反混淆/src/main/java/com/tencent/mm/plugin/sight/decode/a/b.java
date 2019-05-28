package com.tencent.mm.plugin.sight.decode.a;

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
import com.tencent.mm.g.a.tn;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class b {
    private static HashMap<String, WeakReference<Bitmap>> qxK = new HashMap();
    private static Map<String, Integer> qxO = new ConcurrentHashMap();
    private boolean fNO = false;
    public boolean fVc = true;
    public String ien = "";
    private ak lda;
    private Surface mSurface;
    public int position;
    private volatile h qxA;
    private volatile b qxB;
    public volatile i qxC;
    private volatile c qxD;
    private k qxE;
    private j qxF;
    private d qxG;
    public boolean qxH = true;
    public boolean qxI = true;
    public boolean qxJ = false;
    public boolean qxL = false;
    public double qxM = -1.0d;
    boolean qxN = false;
    public double qxP = -1.0d;
    private boolean qxQ = false;
    public boolean qxR = false;
    private a qxS;
    public volatile e qxT;
    public volatile f qxU;
    public volatile g qxV;
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

    public interface e {
        void c(b bVar, int i);
    }

    class j implements Runnable {
        private j() {
        }

        /* synthetic */ j(b bVar, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(70246);
            if (b.this.qxo < 0 || b.this.qxv == null || b.this.qxv.get() == null) {
                AppMethodBeat.o(70246);
                return;
            }
            ((TextView) b.this.qxv.get()).setText(SightVideoJNI.getVideoInfo(b.this.qxo));
            AppMethodBeat.o(70246);
        }
    }

    class k implements Runnable {
        WeakReference<Bitmap> qyh;

        private k() {
            AppMethodBeat.i(70250);
            this.qyh = new WeakReference(null);
            AppMethodBeat.o(70250);
        }

        /* synthetic */ k(b bVar, byte b) {
            this();
        }

        public final void run() {
            View view = null;
            boolean z = true;
            AppMethodBeat.i(70251);
            try {
                String str;
                String str2;
                Object[] objArr;
                View view2;
                if (b.this.mSurface == null || !b.this.mSurface.isValid()) {
                    boolean z2;
                    str = "MicroMsg.SightPlayController";
                    String str3 = "#0x%x-#0x%x want draw thumb, but surface status error, surface null ? %B, thumb bgView null ? %B, thumb null ? %B, mask null ? %B";
                    Object[] objArr2 = new Object[6];
                    objArr2[0] = Integer.valueOf(b.this.hashCode());
                    objArr2[1] = Integer.valueOf(hashCode());
                    objArr2[2] = Boolean.valueOf(b.this.mSurface == null);
                    if (b.this.qxu == null) {
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
                    if (b.this.qxs == null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objArr2[5] = Boolean.valueOf(z2);
                    ab.w(str, str3, objArr2);
                    if (b.this.qxs == null) {
                        final Bitmap bitmap = (Bitmap) this.qyh.get();
                        if (b.this.qxu != null) {
                            view = (View) b.this.qxu.get();
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
                            ab.e(str, str3, objArr2);
                            AppMethodBeat.o(70251);
                            return;
                        }
                        view.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(70247);
                                view.setBackgroundDrawable(new BitmapDrawable(bitmap));
                                AppMethodBeat.o(70247);
                            }
                        });
                        AppMethodBeat.o(70251);
                        return;
                    }
                    if (!(b.this.qxt != null && b.this.qxt.getWidth() == b.this.qxs.getWidth() && b.this.qxt.getHeight() == b.this.qxs.getHeight())) {
                        try {
                            b.this.qxt = Bitmap.createBitmap(b.this.qxs.getWidth(), b.this.qxs.getHeight(), Config.ARGB_8888);
                        } catch (Exception e) {
                            ab.printErrStackTrace("MicroMsg.SightPlayController", e, "try to create thumb bmp error:%s", e.getMessage());
                            b.this.qxt = null;
                        }
                    }
                    if (b.this.qxt == null || this.qyh.get() == null || ((Bitmap) this.qyh.get()).isRecycled()) {
                        str2 = "MicroMsg.SightPlayController";
                        str = "mThubmBgBmp:%B, thumbRef:%B";
                        objArr = new Object[2];
                        if (b.this.qxt == null) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        objArr[0] = Boolean.valueOf(z2);
                        if (this.qyh.get() != null) {
                            z = false;
                        }
                        objArr[1] = Boolean.valueOf(z);
                        ab.e(str2, str, objArr);
                        AppMethodBeat.o(70251);
                        return;
                    }
                    long nanoTime = System.nanoTime();
                    SightVideoJNI.handleThumb((Bitmap) this.qyh.get(), b.this.qxt, b.this.qxs);
                    ab.i("MicroMsg.SightPlayController", "handle thumb use %d us", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
                    final Bitmap q = b.this.qxt;
                    if (b.this.qxu != null) {
                        view2 = (View) b.this.qxu.get();
                    } else {
                        view2 = null;
                    }
                    if (view2 == null || q == null) {
                        AppMethodBeat.o(70251);
                        return;
                    }
                    view2.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(70248);
                            view2.setBackgroundDrawable(new BitmapDrawable(q));
                            AppMethodBeat.o(70248);
                        }
                    });
                    AppMethodBeat.o(70251);
                    return;
                }
                str2 = "MicroMsg.SightPlayController";
                str = "#0x%x-#0x%x draw thumb, thumb empty ? %B";
                objArr = new Object[3];
                objArr[0] = Integer.valueOf(b.this.hashCode());
                objArr[1] = Integer.valueOf(hashCode());
                objArr[2] = Boolean.valueOf(this.qyh.get() == null);
                ab.d(str2, str, objArr);
                if (b.this.qxu != null) {
                    view2 = (View) b.this.qxu.get();
                    if (view2 != null) {
                        view2.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(70249);
                                ab.v("MicroMsg.SightPlayController", "set background drawable null");
                                view2.setBackgroundDrawable(null);
                                AppMethodBeat.o(70249);
                            }
                        });
                    }
                }
                if (this.qyh.get() == null) {
                    SightVideoJNI.drawSurfaceColor(b.this.mSurface, 0);
                    AppMethodBeat.o(70251);
                    return;
                }
                SightVideoJNI.drawSurfaceThumb(b.this.mSurface, (Bitmap) this.qyh.get(), b.this.qxs);
                AppMethodBeat.o(70251);
            } catch (Exception e2) {
                ab.printErrStackTrace("MicroMsg.SightPlayController", e2, "", new Object[0]);
                AppMethodBeat.o(70251);
            }
        }
    }

    static class a extends com.tencent.mm.sdk.b.c<tn> {
        int mik = 0;
        int qxY = 0;
        int qxZ = 0;
        WeakReference<b> qya;

        public a(b bVar) {
            super(0);
            AppMethodBeat.i(70229);
            this.qya = new WeakReference(bVar);
            this.xxI = tn.class.getName().hashCode();
            AppMethodBeat.o(70229);
        }

        private void a(tn tnVar) {
            this.qxY = tnVar.cPI.cPL;
            this.qxZ = tnVar.cPI.cPJ;
            this.mik = tnVar.cPI.cPK;
        }

        private boolean clg() {
            AppMethodBeat.i(70230);
            if (this.qya.get() == null) {
                AppMethodBeat.o(70230);
                return false;
            }
            int E = ((b) this.qya.get()).position + this.qxY;
            if (E < this.qxZ || E > this.mik) {
                AppMethodBeat.o(70230);
                return false;
            }
            AppMethodBeat.o(70230);
            return true;
        }
    }

    class b implements Runnable {
        volatile boolean ovl;
        c qyb;

        private b() {
            this.ovl = false;
        }

        /* synthetic */ b(b bVar, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(70237);
            if (!(b.this.qxV == null || b.this.qxV.cli() == null || b.this.qxV.cli().getVisibility() != 0)) {
                b.this.lda.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(70232);
                        b.this.qxV.cli().setVisibility(8);
                        AppMethodBeat.o(70232);
                    }
                });
            }
            if (b.this.qxo < 0) {
                ab.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id, path %s", Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), b.this.ien);
                AppMethodBeat.o(70237);
            } else if (this.ovl) {
                ab.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at beg", Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()));
                AppMethodBeat.o(70237);
            } else {
                float f;
                double clk;
                if (b.this.qxw == 0) {
                    if (b.this.qxC != null) {
                        b.this.qxC.type = 1;
                        b.this.qxC.run();
                    }
                    b.this.qxw = System.currentTimeMillis();
                }
                Object obj = null;
                if (b.this.qxP != -1.0d) {
                    if (b.this.qxJ) {
                        if (b.this.qxC != null) {
                            b.this.qxC.type = 4;
                            b.this.qxC.qxP = b.this.qxP;
                            b.this.qxC.run();
                            b.this.lda.postDelayed(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(70233);
                                    b.this.qxQ = true;
                                    AppMethodBeat.o(70233);
                                }
                            }, 100);
                        } else if (SightVideoJNI.seekStream(b.this.qxP, b.this.qxo) > 0) {
                            if (b.this.qxC == null) {
                                b.this.qxC = new i(b.this, (byte) 0);
                            }
                            b.this.qxC.type = 4;
                            b.this.qxC.qxP = b.this.qxP;
                            b.this.qxC.run();
                            obj = 1;
                        }
                    } else if (SightVideoJNI.seekStream(b.this.qxP, b.this.qxo) > 0) {
                        if (b.this.qxC == null) {
                            b.this.qxC = new i(b.this, (byte) 0);
                        }
                        b.this.qxC.type = 4;
                        b.this.qxC.qxP = b.this.qxP;
                        b.this.qxC.run();
                        obj = 1;
                    }
                }
                float currentTimeMillis = (float) (System.currentTimeMillis() - b.this.qxw);
                if (obj != null) {
                    f = 0.0f;
                } else {
                    f = (currentTimeMillis / ((float) b.this.qxq)) + 0.5f;
                }
                if (b.this.qxJ && b.this.qxQ) {
                    b.this.qxQ = false;
                    if (b.this.qxC != null) {
                        clk = b.this.qxC.clk() / 1000.0d;
                        if (SightVideoJNI.seekStream(clk, b.this.qxo) > 0) {
                            f = 0.0f;
                            ab.i("MicroMsg.SightPlayController", "seek to " + clk + " modify time : 0.0");
                        }
                    }
                }
                float f2 = f;
                if (b.this.fNO) {
                    ab.i("MicroMsg.SightPlayController", "#0x%x video %d id passedTime:  %s  seek  %s", Integer.valueOf(b.this.hashCode()), Integer.valueOf(b.this.qxo), Float.valueOf(currentTimeMillis), Float.valueOf(f2));
                }
                b.this.qxw = System.currentTimeMillis();
                if (f2 >= 2.0f) {
                    b.this.qxl = b.this.qxl + 1;
                } else {
                    b.this.qxl = Math.max(0, b.this.qxl - 1);
                }
                if (b.this.clb()) {
                    ab.e("MicroMsg.SightPlayController", "match tolerate bad seek times %d", Integer.valueOf(b.this.qxl));
                    b.this.clear();
                    AppMethodBeat.o(70237);
                    return;
                }
                int i;
                Object obj2 = null;
                int i2 = 0;
                if (1 == b.this.qxm) {
                    Object obj3;
                    if (b.this.mSurface == null || b.this.mSurface.isValid()) {
                        i2 = SightVideoJNI.drawSurfaceFrame(b.this.qxo, b.this.mSurface, (int) f2, b.this.qxs, b.this.fVc);
                        if (b.this.qxU != null) {
                            clk = SightVideoJNI.getVideoPlayTime(b.this.qxo);
                            i = (int) clk;
                            if (i != ((int) b.this.qxM)) {
                                b.this.qxU.b(b.this, (long) i);
                            }
                            b.this.qxM = clk;
                        }
                        if (i2 == 0) {
                            b.this.qxP = -1.0d;
                            obj3 = null;
                        } else if (1 == i2) {
                            b.this.qxP = -1.0d;
                            obj3 = 1;
                            b.this.qxw = 0;
                            b.B(b.this);
                        } else if (-7 == i2) {
                            ab.w("MicroMsg.SightPlayController", "surface is null, continue");
                            obj3 = null;
                        } else {
                            ab.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error:%d", Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2));
                            this.ovl = true;
                            if (this.qyb != null) {
                                this.qyb.ovl = true;
                            }
                            b.this.T(null);
                            if (b.this.qxT != null) {
                                b.this.qxT.c(b.this, -1);
                            }
                            obj3 = null;
                        }
                    } else {
                        ab.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error, surface is not valid", Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()));
                        this.ovl = true;
                        if (this.qyb != null) {
                            this.qyb.ovl = true;
                            obj3 = null;
                        }
                        obj3 = null;
                    }
                    if (b.this.qxC != null) {
                        ab.d("MicroMsg.SightPlayController", "voice time is" + (b.this.qxC.clk() / 1000.0d));
                        obj2 = obj3;
                    } else {
                        obj2 = obj3;
                    }
                } else {
                    i2 = SightVideoJNI.drawFrame(b.this.qxo, b.this.qxr, (int) f2, null, false, b.this.fVc);
                    if (b.this.qxU != null) {
                        clk = SightVideoJNI.getVideoPlayTime(b.this.qxo);
                        i = (int) clk;
                        if (i != ((int) b.this.qxM)) {
                            b.this.qxU.b(b.this, (long) i);
                        }
                        b.this.qxM = clk;
                        if (b.this.fNO) {
                            ab.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2), Double.valueOf(clk));
                        }
                    } else if (b.this.fNO) {
                        clk = SightVideoJNI.getVideoPlayTime(b.this.qxo);
                        if (b.this.fNO) {
                            ab.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2), Double.valueOf(clk));
                        }
                    } else if (b.this.fNO) {
                        ab.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d", Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2));
                    }
                    if (i2 == 0) {
                        b.this.qxP = -1.0d;
                    } else if (1 == i2) {
                        b.this.qxP = -1.0d;
                        obj2 = 1;
                        b.this.qxw = 0;
                        b.B(b.this);
                    } else {
                        b.this.qxP = -1.0d;
                        ab.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw bitmap match error:%d", Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2));
                        this.ovl = true;
                        if (this.qyb != null) {
                            this.qyb.ovl = true;
                        }
                        b.this.lda.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(70234);
                                b.this.U(null);
                                AppMethodBeat.o(70234);
                            }
                        });
                        if (b.this.qxT != null) {
                            b.this.qxT.c(b.this, -1);
                        }
                    }
                }
                if (1 == i2) {
                    b.this.lda.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(70235);
                            if (b.this.qxT != null) {
                                b.this.qxT.c(b.this, 0);
                            }
                            AppMethodBeat.o(70235);
                        }
                    });
                }
                if (this.ovl) {
                    ab.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at end", Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()));
                    if (b.this.qxC != null) {
                        b.this.qxC.type = 0;
                        b.this.qxC.run();
                    }
                    AppMethodBeat.o(70237);
                    return;
                }
                if (1 == b.this.qxm) {
                    long currentTimeMillis2 = ((long) b.this.qxq) - (System.currentTimeMillis() - b.this.qxw);
                    if (b.this.qxw == 0) {
                        o.i(this, (long) (b.this.qxq * 5));
                    } else if (currentTimeMillis2 > 0) {
                        o.i(this, currentTimeMillis2);
                    } else {
                        o.i(this, 0);
                    }
                } else if (obj2 == null || b.this.qxV == null) {
                    this.qyb.qyd = i2;
                    b.this.lda.post(this.qyb);
                } else {
                    i = b.this.qxV.clh();
                    b.this.lda.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(70236);
                            if (b.this.qxV != null) {
                                View cli = b.this.qxV.cli();
                                if (cli != null) {
                                    if (!(b.this.qxz != null || b.this.qxV.clj() == -1 || b.this.qxx.get() == null)) {
                                        b.this.qxz = AnimationUtils.loadAnimation(((View) b.this.qxx.get()).getContext(), b.this.qxV.clj());
                                    }
                                    if (b.this.qxz != null) {
                                        cli.startAnimation(b.this.qxz);
                                    }
                                    cli.setVisibility(0);
                                }
                            }
                            AppMethodBeat.o(70236);
                        }
                    });
                    this.qyb.qyd = i2;
                    b.this.lda.postDelayed(this.qyb, (long) i);
                }
                if (b.this.qxC != null) {
                    ab.d("MicroMsg.SightPlayController", "voice time is" + (b.this.qxC.clk() / 1000.0d));
                }
                AppMethodBeat.o(70237);
            }
        }
    }

    class c implements Runnable {
        volatile boolean ovl = false;
        int qyd;
        b qye;

        public c() {
            AppMethodBeat.i(70238);
            ab.i("MicroMsg.SightPlayController", "make sure drawJob alive");
            AppMethodBeat.o(70238);
        }

        public final void run() {
            AppMethodBeat.i(70239);
            if (this.ovl) {
                ab.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop draw", Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()));
                AppMethodBeat.o(70239);
                return;
            }
            b.this.U(b.this.qxr);
            if (b.this.qxw == 0) {
                o.i(this.qye, 0);
                AppMethodBeat.o(70239);
                return;
            }
            long currentTimeMillis = ((long) b.this.qxq) - (System.currentTimeMillis() - b.this.qxw);
            if (currentTimeMillis > 0) {
                o.i(this.qye, currentTimeMillis);
                AppMethodBeat.o(70239);
                return;
            }
            o.i(this.qye, 0);
            AppMethodBeat.o(70239);
        }
    }

    class d implements Runnable {
        private d() {
        }

        /* synthetic */ d(b bVar, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(70240);
            if (b.this.qxx.get() == null) {
                AppMethodBeat.o(70240);
                return;
            }
            ((View) b.this.qxx.get()).startAnimation(b.this.qxy);
            AppMethodBeat.o(70240);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sight.decode.a.b$3 */
    public class AnonymousClass3 implements Runnable {
        final /* synthetic */ double qxX;

        public AnonymousClass3(double d) {
            this.qxX = d;
        }

        public final void run() {
            AppMethodBeat.i(70228);
            ab.i("MicroMsg.SightPlayController", "SeekToFrame   %f  %s", Double.valueOf(this.qxX), bo.dpG().toString());
            b.this.qxP = this.qxX;
            AppMethodBeat.o(70228);
        }
    }

    public interface g {
        int clh();

        View cli();

        int clj();
    }

    class h implements Runnable {
        volatile boolean ovl;

        private h() {
            this.ovl = false;
        }

        /* synthetic */ h(b bVar, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(70241);
            if (b.this.clb()) {
                ab.e("MicroMsg.SightPlayController", "is bad fps, do nothing when open file");
                AppMethodBeat.o(70241);
                return;
            }
            b.this.qxo = SightVideoJNI.openFile(b.this.ien, 1 == b.this.qxm ? 0 : 1, 1, false);
            ab.i("MicroMsg.SightPlayController", "SightVideoJNI.openFile mVideoPath:%s mVideoId:%s", b.this.ien, Integer.valueOf(b.this.qxo));
            b.this.qxp.offer(Integer.valueOf(b.this.qxo));
            if (b.this.qxo < 0) {
                ab.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id %d, path %s", Integer.valueOf(hashCode()), Integer.valueOf(b.this.hashCode()), Integer.valueOf(b.this.qxo), b.this.ien);
                b.this.T(null);
                if (b.this.qxT != null) {
                    b.this.qxT.c(b.this, -1);
                }
                AppMethodBeat.o(70241);
                return;
            }
            if (((Boolean) com.tencent.mm.kernel.g.RP().Ry().get(344065, Boolean.FALSE)).booleanValue()) {
                if (b.this.qxF == null) {
                    b.this.qxF = new j(b.this, (byte) 0);
                }
                b.this.lda.removeCallbacks(b.this.qxF);
                b.this.lda.post(b.this.qxF);
            }
            int max = Math.max(1, SightVideoJNI.getVideoWidth(b.this.qxo));
            int max2 = Math.max(1, SightVideoJNI.getVideoHeight(b.this.qxo));
            if (b.this.qxm == 0) {
                if (max * max2 >= 1048576 || max <= 0 || max2 <= 0) {
                    ab.e("MicroMsg.SightPlayController", "get error info videoWidth %d height  %d", Integer.valueOf(max), Integer.valueOf(max2));
                    AppMethodBeat.o(70241);
                    return;
                }
                b.a(b.this, max, max2);
            }
            b.this.clc();
            if (Float.compare(((float) max) / ((float) max2), 5.0f) > 0 || Float.compare(((float) max2) / ((float) max), 5.0f) > 0) {
                ab.w("MicroMsg.SightPlayController", "ERROR Video size %d, %d", Integer.valueOf(max), Integer.valueOf(max2));
                if (!bo.isNullOrNil(b.this.ien)) {
                    b.qxO.put(b.this.ien, Integer.valueOf(2));
                }
                b.this.qxw = 0;
                b.this.d(b.this.qxp);
                b.this.qxo = -1;
                b.this.ien = "";
                b.this.qxn = "ERROR#PATH";
                b.this.qxt = null;
                this.ovl = true;
                if (b.this.qxT != null) {
                    b.this.qxT.c(b.this, -1);
                }
                AppMethodBeat.o(70241);
                return;
            }
            b.this.dH(max, max2);
            if (1 == b.this.qxm) {
                b.this.qxB = new b(b.this, (byte) 0);
                b.this.qxD = null;
                if (!this.ovl) {
                    o.i(b.this.qxB, 0);
                }
            } else {
                b.this.qxB = new b(b.this, (byte) 0);
                b.this.qxD = new c();
                b.this.qxB.qyb = b.this.qxD;
                b.this.qxD.qye = b.this.qxB;
                if (!this.ovl) {
                    o.i(b.this.qxB, 0);
                }
            }
            if (this.ovl) {
                ab.e("MicroMsg.SightPlayController", "#0x%x-#0x%x open file end, match stop %B", Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Boolean.valueOf(this.ovl));
            }
            AppMethodBeat.o(70241);
        }
    }

    public class i implements Runnable {
        double qxP;
        MediaPlayer qyf;
        public int type;

        private i() {
            this.qxP = -1.0d;
        }

        public /* synthetic */ i(b bVar, byte b) {
            this();
        }

        private void bUd() {
            AppMethodBeat.i(70243);
            ab.i("MicroMsg.SightPlayController", "stopPlayer");
            try {
                if (this.qyf != null) {
                    this.qyf.stop();
                    this.qyf.release();
                    this.qyf = null;
                }
                AppMethodBeat.o(70243);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.SightPlayController", e, "stop play sound error: %s", e.getMessage());
                this.qyf = null;
                AppMethodBeat.o(70243);
            }
        }

        public final double clk() {
            AppMethodBeat.i(70244);
            if (this.qyf == null) {
                AppMethodBeat.o(70244);
                return 0.0d;
            }
            double currentPosition = (double) this.qyf.getCurrentPosition();
            AppMethodBeat.o(70244);
            return currentPosition;
        }

        public final void run() {
            String str;
            AppMethodBeat.i(70245);
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
            ab.i(str2, str3, objArr);
            switch (this.type) {
                case 0:
                    bUd();
                    AppMethodBeat.o(70245);
                    return;
                case 1:
                    bUd();
                    if (!bo.isNullOrNil(b.this.ien)) {
                        try {
                            this.qyf = new com.tencent.mm.compatible.b.k();
                            this.qyf.setDisplay(null);
                            this.qyf.reset();
                            this.qyf.setDataSource(b.this.ien);
                            this.qyf.setAudioStreamType(3);
                            this.qyf.setOnErrorListener(new OnErrorListener() {
                                public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                    AppMethodBeat.i(70242);
                                    ab.e("MicroMsg.SightPlayController", "on error: play %s ERROR!! %d %d", b.this.ien, Integer.valueOf(i), Integer.valueOf(i2));
                                    b.this.clear();
                                    if (b.this.qxT != null) {
                                        b.this.qxT.c(b.this, -1);
                                    }
                                    AppMethodBeat.o(70242);
                                    return true;
                                }
                            });
                            this.qyf.prepare();
                            this.qyf.start();
                            AppMethodBeat.o(70245);
                            return;
                        } catch (Exception e) {
                            ab.printErrStackTrace("MicroMsg.SightPlayController", e, "play sound error: %s", e.getMessage());
                            ab.e("MicroMsg.SightPlayController", "on Exception: play %s ERROR!!", b.this.ien);
                            b.this.clear();
                            if (b.this.qxT != null) {
                                b.this.qxT.c(b.this, -1);
                            }
                            AppMethodBeat.o(70245);
                            return;
                        }
                    }
                    break;
                case 2:
                    try {
                        if (this.qyf != null && this.qyf.isPlaying()) {
                            this.qyf.pause();
                        }
                        AppMethodBeat.o(70245);
                        return;
                    } catch (Exception e2) {
                        ab.printErrStackTrace("MicroMsg.SightPlayController", e2, "pause sound error: %s", e2.getMessage());
                        bUd();
                        AppMethodBeat.o(70245);
                        return;
                    }
                case 3:
                    try {
                        if (this.qyf != null) {
                            this.qyf.start();
                        }
                        AppMethodBeat.o(70245);
                        return;
                    } catch (Exception e22) {
                        ab.printErrStackTrace("MicroMsg.SightPlayController", e22, "pause sound error: %s", e22.getMessage());
                        bUd();
                        AppMethodBeat.o(70245);
                        return;
                    }
                case 4:
                    try {
                        ab.i("MicroMsg.SightPlayController", "soundplayer seek %f", Double.valueOf(this.qxP));
                        this.qyf.seekTo((int) (this.qxP * 1000.0d));
                        AppMethodBeat.o(70245);
                        return;
                    } catch (Exception e222) {
                        ab.printErrStackTrace("MicroMsg.SightPlayController", e222, "seek sound error: %s", e222.getMessage());
                        break;
                    }
            }
            AppMethodBeat.o(70245);
        }
    }

    public interface f {
        void b(b bVar, long j);
    }

    public abstract void U(Bitmap bitmap);

    public abstract void dH(int i, int i2);

    public static Bitmap b(Context context, int i, int i2, int i3, int i4) {
        String format = String.format("%s-%s-%s-%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        WeakReference weakReference = (WeakReference) qxK.get(format);
        if (weakReference != null && weakReference.get() != null) {
            return (Bitmap) weakReference.get();
        }
        if (context == null) {
            ab.w("MicroMsg.SightPlayController", "get mask bmp, but context is null");
            return null;
        } else if (i <= 0) {
            ab.w("MicroMsg.SightPlayController", "get mask bmp, but mask id error");
            return null;
        } else if (i2 <= 0 || i4 <= 0 || i3 <= 0) {
            ab.w("MicroMsg.SightPlayController", "get mask bmp, but size error");
            return null;
        } else {
            long yz = bo.yz();
            int i5 = (i2 * i4) / i3;
            NinePatchDrawable ninePatchDrawable = (NinePatchDrawable) context.getResources().getDrawable(i);
            ninePatchDrawable.setBounds(0, 0, i2, i5);
            Bitmap createBitmap = Bitmap.createBitmap(i2, i5, Config.ARGB_8888);
            ninePatchDrawable.draw(new Canvas(createBitmap));
            qxK.put(format, new WeakReference(createBitmap));
            ab.d("MicroMsg.SightPlayController", "create mask bmp use %dms", Long.valueOf(bo.az(yz)));
            return createBitmap;
        }
    }

    public static void WY() {
        o.i(new Runnable() {
            public final void run() {
                AppMethodBeat.i(70226);
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    SightVideoJNI.freeAll();
                } catch (Exception e) {
                    ab.e("MicroMsg.SightPlayController", "free all sight error");
                    ab.printErrStackTrace("MicroMsg.SightPlayController", e, "", new Object[0]);
                }
                ab.i("MicroMsg.SightPlayController", "free all, use %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.o(70226);
            }
        }, 0);
    }

    public b(int i, View view) {
        this.qxm = i;
        this.lda = new ak(Looper.getMainLooper());
        this.qxx = new WeakReference(view);
        ab.i("MicroMsg.SightPlayController", "new SightPlayController, drawType %d", Integer.valueOf(i));
    }

    /* Access modifiers changed, original: protected */
    public int ckZ() {
        return -1;
    }

    public final void kz(boolean z) {
        if (this.qxA != null) {
            o.y(this.qxA);
            this.qxA.ovl = true;
        }
        if (this.qxD != null) {
            this.lda.removeCallbacks(this.qxD);
            this.qxD.ovl = true;
        }
        if (this.qxB != null) {
            o.y(this.qxB);
            this.qxB.ovl = true;
        }
        if (this.qxC != null) {
            this.qxC.type = z ? 0 : 2;
            o.i(this.qxC, 0);
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
        ab.i("MicroMsg.SightPlayController", "#0x%x restart, canPlay %B, videoPath %s, videoId %d", Integer.valueOf(hashCode()), Boolean.valueOf(this.qxI), this.ien, Integer.valueOf(this.qxo));
        if (!this.qxI) {
            clear();
        } else if (cla()) {
            ab.w("MicroMsg.SightPlayController", "#0x%x is runing, do nothing when restart request asked, videoPath %s", Integer.valueOf(hashCode()), this.ien);
        } else {
            boolean z;
            if (this.qxo < 0) {
                z = true;
            } else {
                z = false;
            }
            kz(z);
            this.qxw = 0;
            if (clb()) {
                ab.e("MicroMsg.SightPlayController", "#0x%x is bad fps, do nothing when restart", Integer.valueOf(hashCode()));
            } else if (this.qxo < 0) {
                ab.w("MicroMsg.SightPlayController", "#0x%x restart match error video id, try reopen video, videoPath %s", Integer.valueOf(hashCode()), this.ien);
                if (!bo.isNullOrNil(this.ien)) {
                    if (WS(this.ien)) {
                        this.qxA = new h(this, (byte) 0);
                        o.i(this.qxA, 0);
                        return;
                    }
                    ab.w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
                    clear();
                }
            } else if (1 == this.qxm) {
                this.qxB = new b(this, (byte) 0);
                this.qxD = null;
                o.i(this.qxB, 0);
            } else {
                this.qxB = new b(this, (byte) 0);
                this.qxD = new c();
                this.qxB.qyb = this.qxD;
                this.qxD.qye = this.qxB;
                o.i(this.qxB, 0);
            }
        }
    }

    public final void clear() {
        ab.i("MicroMsg.SightPlayController", "#0x%x do clear, remove render job, video id %d, runing %B", Integer.valueOf(hashCode()), Integer.valueOf(this.qxo), Boolean.valueOf(cla()));
        kz(true);
        this.qxw = 0;
        d(this.qxp);
        this.qxo = -1;
        this.ien = "";
        this.qxn = "ERROR#PATH";
        this.qxt = null;
        this.qxM = 0.0d;
        this.qxN = false;
        com.tencent.mm.memory.o.fdT.f(this.qxr);
        this.qxr = null;
    }

    private void d(Queue<Integer> queue) {
        while (true) {
            Integer num = (Integer) queue.poll();
            if (num != null) {
                CE(num.intValue());
            } else {
                return;
            }
        }
    }

    private void CE(final int i) {
        o.i(new Runnable() {
            public final void run() {
                AppMethodBeat.i(70227);
                long currentTimeMillis = System.currentTimeMillis();
                SightVideoJNI.freeObj(i);
                ab.d("MicroMsg.SightPlayController", "#0x%x tick: do clear video %d, use %d ms", Integer.valueOf(b.this.hashCode()), Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.o(70227);
            }
        }, 0);
    }

    public final void bf(String str, boolean z) {
        ab.i("MicroMsg.SightPlayController", "#0x%x data: set video[%s], old path[%s], fling[%B], last video id %d, recording %B, canPlay %B", Integer.valueOf(hashCode()), str, this.ien, Boolean.valueOf(z), Integer.valueOf(this.qxo), Boolean.valueOf(this.qxR), Boolean.valueOf(this.qxI));
        if (this.qxR) {
            kz(false);
        } else if (clb()) {
            ab.e("MicroMsg.SightPlayController", "is bad fps, do nothing when set video path");
            clear();
        } else if (!this.qxI) {
            clear();
        } else if (z) {
            this.qxn = str;
            kz(false);
        } else if (this.ien.equals(str)) {
            this.qxn = "ERROR#PATH";
            kz(false);
            restart();
        } else {
            clear();
            if (str == null) {
                str = "";
            }
            this.ien = str;
            if (bo.isNullOrNil(this.ien)) {
                ab.w("MicroMsg.SightPlayController", "empty video path, do draw empty thumb and return");
                T(null);
            } else if (WS(this.ien)) {
                this.qxA = new h(this, (byte) 0);
                o.i(this.qxA, 0);
            } else {
                ab.w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
                clear();
            }
        }
    }

    public static boolean WS(String str) {
        if (bo.isNullOrNil(str)) {
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
            ab.v("MicroMsg.SightPlayController", "match not check bad fps, but now is bad fps");
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
        ab.d("MicroMsg.SightPlayController", "#0x%x update video rate to %d fps, delay %d ms", Integer.valueOf(hashCode()), Integer.valueOf(r0), Integer.valueOf(this.qxq));
    }

    public final void g(Surface surface) {
        ab.v("MicroMsg.SightPlayController", "set play surface %s", surface);
        this.mSurface = surface;
        o.i(this.qxE, 0);
    }

    public final void setThumbBgView(View view) {
        this.qxu = new WeakReference(view);
    }

    public final void setSightInfoView(TextView textView) {
        this.qxv = new WeakReference(textView);
    }

    public final void T(Bitmap bitmap) {
        boolean z = true;
        String str = "MicroMsg.SightPlayController";
        String str2 = "draw surface thumb, thumb is null ? %B";
        Object[] objArr = new Object[1];
        if (bitmap != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        ab.v(str, str2, objArr);
        o.y(this.qxE);
        if (this.qxE == null) {
            this.qxE = new k(this, (byte) 0);
        }
        this.qxE.qyh = new WeakReference(bitmap);
        o.i(this.qxE, 0);
    }

    public final com.tencent.mm.sdk.b.c cld() {
        if (this.qxS == null) {
            this.qxS = new a(this);
        }
        return this.qxS;
    }

    public final double cle() {
        if (this.qxo == -1) {
            return 0.0d;
        }
        return SightVideoJNI.getVideoDuration(this.qxo);
    }

    static /* synthetic */ void a(b bVar, int i, int i2) {
        ab.d("MicroMsg.SightPlayController", "#0x%x check bmp, video width %d, height %d", Integer.valueOf(bVar.hashCode()), Integer.valueOf(i), Integer.valueOf(i2));
        if (bVar.qxr == null) {
            bVar.qxr = com.tencent.mm.memory.o.fdT.a(new com.tencent.mm.memory.o.b(i, i2));
            ab.b("MicroMsg.SightPlayController", "checkBmp, create new one, videoPath: %s", bVar.ien);
        } else if (bVar.qxr.getWidth() != i || bVar.qxr.getHeight() != i2) {
            int i3;
            ab.w("MicroMsg.SightPlayController", "reset bmp, old value " + bVar.qxr.getWidth() + "*" + bVar.qxr.getHeight());
            if (!com.tencent.mm.compatible.util.d.iW(19) || bVar.qxr.getAllocationByteCount() < (i2 * i) * 4) {
                i3 = 0;
            } else {
                try {
                    ab.w("MicroMsg.SightPlayController", "reset bmp, try directly reconfigure");
                    bVar.qxr.reconfigure(i, i2, Config.ARGB_8888);
                    i3 = 1;
                } catch (Exception e) {
                    ab.e("MicroMsg.SightPlayController", "reconfigure failed: %s" + e.getMessage());
                    i3 = 0;
                }
            }
            if (i3 == 0) {
                com.tencent.mm.memory.o.fdT.f(bVar.qxr);
                bVar.qxr = com.tencent.mm.memory.o.fdT.a(new com.tencent.mm.memory.o.b(i, i2));
            }
            ab.b("MicroMsg.SightPlayController", "checkBmp, the origin bmp size not match, create new one, videoPath: %s", bVar.ien);
        }
    }

    static /* synthetic */ void B(b bVar) {
        if (bVar.qxx != null && -1 != bVar.ckZ() && bVar.qxH) {
            if (bVar.qxy == null && bVar.qxx.get() != null) {
                bVar.qxy = AnimationUtils.loadAnimation(((View) bVar.qxx.get()).getContext(), bVar.ckZ());
            }
            if (bVar.qxG == null) {
                bVar.qxG = new d(bVar, (byte) 0);
            }
            bVar.lda.post(bVar.qxG);
        }
    }
}
