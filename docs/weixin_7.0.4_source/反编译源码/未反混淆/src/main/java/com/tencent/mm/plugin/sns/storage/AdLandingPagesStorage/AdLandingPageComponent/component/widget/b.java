package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

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
import com.tencent.mm.g.a.tn;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class b {
    private static HashMap<String, WeakReference<Bitmap>> qxK = new HashMap();
    private static Map<String, Integer> qxO = new ConcurrentHashMap();
    private boolean fNO;
    boolean fVc;
    String ien;
    private ak lda;
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
    volatile h rci;
    private volatile b rcj;
    volatile i rck;
    private volatile c rcl;
    private k rcm;
    private j rcn;
    private d rco;
    private a rcp;
    e rcq;
    f rcr;
    g rcs;

    class b implements Runnable {
        volatile boolean ovl;
        c rcu;

        private b() {
            this.ovl = false;
        }

        /* synthetic */ b(b bVar, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(37420);
            if (!(b.this.rcs == null || b.this.rcs.cli() == null || b.this.rcs.cli().getVisibility() != 0)) {
                b.this.lda.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(37415);
                        b.this.rcs.cli().setVisibility(8);
                        AppMethodBeat.o(37415);
                    }
                });
            }
            if (b.this.qxo < 0) {
                ab.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id, path %s", Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), b.this.ien);
                AppMethodBeat.o(37420);
            } else if (this.ovl) {
                ab.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at beg", Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()));
                AppMethodBeat.o(37420);
            } else {
                float f;
                double clk;
                if (b.this.qxw == 0) {
                    if (b.this.rck != null) {
                        b.this.rck.type = 1;
                        b.this.rck.run();
                    }
                    b.this.qxw = System.currentTimeMillis();
                }
                Object obj = null;
                if (b.this.qxP != -1.0d) {
                    if (b.this.qxJ) {
                        if (b.this.rck != null) {
                            b.this.rck.type = 4;
                            b.this.rck.qxP = b.this.qxP;
                            b.this.rck.run();
                            b.this.lda.postDelayed(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(37416);
                                    b.this.qxQ = true;
                                    AppMethodBeat.o(37416);
                                }
                            }, 100);
                        } else if (SightVideoJNI.seekStream(b.this.qxP, b.this.qxo) > 0) {
                            if (b.this.rck == null) {
                                b.this.rck = new i(b.this, (byte) 0);
                            }
                            b.this.rck.type = 4;
                            b.this.rck.qxP = b.this.qxP;
                            b.this.rck.run();
                            obj = 1;
                        }
                    } else if (SightVideoJNI.seekStream(b.this.qxP, b.this.qxo) > 0) {
                        if (b.this.rck == null) {
                            b.this.rck = new i(b.this, (byte) 0);
                        }
                        b.this.rck.type = 4;
                        b.this.rck.qxP = b.this.qxP;
                        b.this.rck.run();
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
                    if (b.this.rck != null) {
                        clk = b.this.rck.clk() / 1000.0d;
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
                    AppMethodBeat.o(37420);
                    return;
                }
                int i;
                Object obj2 = null;
                int i2 = 0;
                if (1 == b.this.qxm) {
                    Object obj3;
                    if (b.this.mSurface == null || b.this.mSurface.isValid()) {
                        i2 = SightVideoJNI.drawSurfaceFrame(b.this.qxo, b.this.mSurface, (int) f2, b.this.qxs, b.this.fVc);
                        if (b.this.rcr != null) {
                            clk = SightVideoJNI.getVideoPlayTime(b.this.qxo);
                            i = (int) clk;
                            if (i != ((int) b.this.qxM)) {
                                b.this.rcr.ks((long) i);
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
                            b.A(b.this);
                        } else if (-7 == i2) {
                            ab.w("MicroMsg.SightPlayController", "surface is null, continue");
                            obj3 = null;
                        } else {
                            ab.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error:%d", Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2));
                            this.ovl = true;
                            if (this.rcu != null) {
                                this.rcu.ovl = true;
                            }
                            b.this.cpV();
                            if (b.this.rcq != null) {
                                b.this.rcq.Ds(-1);
                            }
                            obj3 = null;
                        }
                    } else {
                        ab.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error, surface is not valid", Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()));
                        this.ovl = true;
                        if (this.rcu != null) {
                            this.rcu.ovl = true;
                            obj3 = null;
                        }
                        obj3 = null;
                    }
                    if (b.this.rck != null) {
                        ab.d("MicroMsg.SightPlayController", "voice time is" + (b.this.rck.clk() / 1000.0d));
                        obj2 = obj3;
                    } else {
                        obj2 = obj3;
                    }
                } else {
                    i2 = SightVideoJNI.drawFrame(b.this.qxo, b.this.qxr, (int) f2, null, false, b.this.fVc);
                    if (b.this.rcr != null) {
                        clk = SightVideoJNI.getVideoPlayTime(b.this.qxo);
                        i = (int) clk;
                        if (i != ((int) b.this.qxM)) {
                            b.this.rcr.ks((long) i);
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
                        b.A(b.this);
                    } else {
                        b.this.qxP = -1.0d;
                        ab.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw bitmap match error:%d", Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2));
                        this.ovl = true;
                        if (this.rcu != null) {
                            this.rcu.ovl = true;
                        }
                        b.this.lda.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(37417);
                                b.this.U(null);
                                AppMethodBeat.o(37417);
                            }
                        });
                        if (b.this.rcq != null) {
                            b.this.rcq.Ds(-1);
                        }
                    }
                }
                if (1 == i2) {
                    b.this.lda.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(37418);
                            if (b.this.rcq != null) {
                                b.this.rcq.Ds(0);
                            }
                            AppMethodBeat.o(37418);
                        }
                    });
                }
                if (this.ovl) {
                    ab.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at end", Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()));
                    if (b.this.rck != null) {
                        b.this.rck.type = 0;
                        b.this.rck.run();
                    }
                    AppMethodBeat.o(37420);
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
                } else if (obj2 == null || b.this.rcs == null) {
                    this.rcu.qyd = i2;
                    b.this.lda.post(this.rcu);
                } else {
                    i = b.this.rcs.clh();
                    b.this.lda.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(37419);
                            if (b.this.rcs != null) {
                                View cli = b.this.rcs.cli();
                                if (cli != null) {
                                    if (!(b.this.qxz != null || b.this.rcs.clj() == -1 || b.this.qxx.get() == null)) {
                                        b.this.qxz = AnimationUtils.loadAnimation(((View) b.this.qxx.get()).getContext(), b.this.rcs.clj());
                                    }
                                    if (b.this.qxz != null) {
                                        cli.startAnimation(b.this.qxz);
                                    }
                                    cli.setVisibility(0);
                                }
                            }
                            AppMethodBeat.o(37419);
                        }
                    });
                    this.rcu.qyd = i2;
                    b.this.lda.postDelayed(this.rcu, (long) i);
                }
                if (b.this.rck != null) {
                    ab.d("MicroMsg.SightPlayController", "voice time is" + (b.this.rck.clk() / 1000.0d));
                }
                AppMethodBeat.o(37420);
            }
        }
    }

    class c implements Runnable {
        volatile boolean ovl = false;
        int qyd;
        b rcw;

        public c() {
            AppMethodBeat.i(37421);
            ab.i("MicroMsg.SightPlayController", "make sure drawJob alive");
            AppMethodBeat.o(37421);
        }

        public final void run() {
            AppMethodBeat.i(37422);
            if (this.ovl) {
                ab.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop draw", Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()));
                AppMethodBeat.o(37422);
                return;
            }
            b.this.U(b.this.qxr);
            if (b.this.qxw == 0) {
                o.i(this.rcw, 0);
                AppMethodBeat.o(37422);
                return;
            }
            long currentTimeMillis = ((long) b.this.qxq) - (System.currentTimeMillis() - b.this.qxw);
            if (currentTimeMillis > 0) {
                o.i(this.rcw, currentTimeMillis);
                AppMethodBeat.o(37422);
                return;
            }
            o.i(this.rcw, 0);
            AppMethodBeat.o(37422);
        }
    }

    class d implements Runnable {
        private d() {
        }

        /* synthetic */ d(b bVar, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(37423);
            if (b.this.qxx.get() == null) {
                AppMethodBeat.o(37423);
                return;
            }
            ((View) b.this.qxx.get()).startAnimation(b.this.qxy);
            AppMethodBeat.o(37423);
        }
    }

    static class a extends com.tencent.mm.sdk.b.c<tn> {
        int mik = 0;
        int qxY = 0;
        int qxZ = 0;
        WeakReference<b> qya;

        public a(b bVar) {
            super(0);
            AppMethodBeat.i(37412);
            this.qya = new WeakReference(bVar);
            this.xxI = tn.class.getName().hashCode();
            AppMethodBeat.o(37412);
        }

        private void a(tn tnVar) {
            this.qxY = tnVar.cPI.cPL;
            this.qxZ = tnVar.cPI.cPJ;
            this.mik = tnVar.cPI.cPK;
        }

        private boolean clg() {
            AppMethodBeat.i(37413);
            if (this.qya.get() == null) {
                AppMethodBeat.o(37413);
                return false;
            }
            int D = ((b) this.qya.get()).position + this.qxY;
            if (D < this.qxZ || D > this.mik) {
                AppMethodBeat.o(37413);
                return false;
            }
            AppMethodBeat.o(37413);
            return true;
        }
    }

    class j implements Runnable {
        private j() {
        }

        /* synthetic */ j(b bVar, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(37429);
            if (b.this.qxo < 0 || b.this.qxv == null || b.this.qxv.get() == null) {
                AppMethodBeat.o(37429);
                return;
            }
            ((TextView) b.this.qxv.get()).setText(SightVideoJNI.getVideoInfo(b.this.qxo));
            AppMethodBeat.o(37429);
        }
    }

    class k implements Runnable {
        WeakReference<Bitmap> qyh;

        private k() {
            AppMethodBeat.i(37433);
            this.qyh = new WeakReference(null);
            AppMethodBeat.o(37433);
        }

        /* synthetic */ k(b bVar, byte b) {
            this();
        }

        public final void run() {
            View view = null;
            boolean z = true;
            AppMethodBeat.i(37434);
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
                            AppMethodBeat.o(37434);
                            return;
                        }
                        view.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(37430);
                                view.setBackgroundDrawable(new BitmapDrawable(bitmap));
                                AppMethodBeat.o(37430);
                            }
                        });
                        AppMethodBeat.o(37434);
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
                        AppMethodBeat.o(37434);
                        return;
                    }
                    long nanoTime = System.nanoTime();
                    SightVideoJNI.handleThumb((Bitmap) this.qyh.get(), b.this.qxt, b.this.qxs);
                    ab.i("MicroMsg.SightPlayController", "handle thumb use %d us", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
                    final Bitmap p = b.this.qxt;
                    if (b.this.qxu != null) {
                        view2 = (View) b.this.qxu.get();
                    } else {
                        view2 = null;
                    }
                    if (view2 == null || p == null) {
                        AppMethodBeat.o(37434);
                        return;
                    }
                    view2.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(37431);
                            view2.setBackgroundDrawable(new BitmapDrawable(p));
                            AppMethodBeat.o(37431);
                        }
                    });
                    AppMethodBeat.o(37434);
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
                                AppMethodBeat.i(37432);
                                ab.v("MicroMsg.SightPlayController", "set background drawable null");
                                view2.setBackgroundDrawable(null);
                                AppMethodBeat.o(37432);
                            }
                        });
                    }
                }
                if (this.qyh.get() == null) {
                    SightVideoJNI.drawSurfaceColor(b.this.mSurface, 0);
                    AppMethodBeat.o(37434);
                    return;
                }
                SightVideoJNI.drawSurfaceThumb(b.this.mSurface, (Bitmap) this.qyh.get(), b.this.qxs);
                AppMethodBeat.o(37434);
            } catch (Exception e2) {
                ab.printErrStackTrace("MicroMsg.SightPlayController", e2, "", new Object[0]);
                AppMethodBeat.o(37434);
            }
        }
    }

    public interface e {
        void Ds(int i);
    }

    public interface f {
        void ks(long j);
    }

    public interface g {
        int clh();

        View cli();

        int clj();
    }

    class i implements Runnable {
        double qxP;
        MediaPlayer qyf;
        int type;

        private i() {
            this.qxP = -1.0d;
        }

        /* synthetic */ i(b bVar, byte b) {
            this();
        }

        private void bUd() {
            AppMethodBeat.i(37426);
            ab.i("MicroMsg.SightPlayController", "stopPlayer");
            try {
                if (this.qyf != null) {
                    this.qyf.stop();
                    this.qyf.release();
                    this.qyf = null;
                }
                AppMethodBeat.o(37426);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.SightPlayController", e, "stop play sound error: %s", e.getMessage());
                this.qyf = null;
                AppMethodBeat.o(37426);
            }
        }

        public final double clk() {
            AppMethodBeat.i(37427);
            if (this.qyf == null) {
                AppMethodBeat.o(37427);
                return 0.0d;
            }
            double currentPosition = (double) this.qyf.getCurrentPosition();
            AppMethodBeat.o(37427);
            return currentPosition;
        }

        public final void run() {
            String str;
            AppMethodBeat.i(37428);
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
                    AppMethodBeat.o(37428);
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
                                    AppMethodBeat.i(37425);
                                    ab.e("MicroMsg.SightPlayController", "on error: play %s ERROR!! %d %d", b.this.ien, Integer.valueOf(i), Integer.valueOf(i2));
                                    b.this.clear();
                                    if (b.this.rcq != null) {
                                        b.this.rcq.Ds(-1);
                                    }
                                    AppMethodBeat.o(37425);
                                    return true;
                                }
                            });
                            this.qyf.prepare();
                            this.qyf.start();
                            AppMethodBeat.o(37428);
                            return;
                        } catch (Exception e) {
                            ab.printErrStackTrace("MicroMsg.SightPlayController", e, "play sound error: %s", e.getMessage());
                            ab.e("MicroMsg.SightPlayController", "on Exception: play %s ERROR!!", b.this.ien);
                            b.this.clear();
                            if (b.this.rcq != null) {
                                b.this.rcq.Ds(-1);
                            }
                            AppMethodBeat.o(37428);
                            return;
                        }
                    }
                    break;
                case 2:
                    try {
                        if (this.qyf != null && this.qyf.isPlaying()) {
                            this.qyf.pause();
                        }
                        AppMethodBeat.o(37428);
                        return;
                    } catch (Exception e2) {
                        ab.printErrStackTrace("MicroMsg.SightPlayController", e2, "pause sound error: %s", e2.getMessage());
                        bUd();
                        AppMethodBeat.o(37428);
                        return;
                    }
                case 3:
                    try {
                        if (this.qyf != null) {
                            this.qyf.start();
                        }
                        AppMethodBeat.o(37428);
                        return;
                    } catch (Exception e22) {
                        ab.printErrStackTrace("MicroMsg.SightPlayController", e22, "pause sound error: %s", e22.getMessage());
                        bUd();
                        AppMethodBeat.o(37428);
                        return;
                    }
                case 4:
                    try {
                        ab.i("MicroMsg.SightPlayController", "soundplayer seek %f", Double.valueOf(this.qxP));
                        this.qyf.seekTo((int) (this.qxP * 1000.0d));
                        AppMethodBeat.o(37428);
                        return;
                    } catch (Exception e222) {
                        ab.printErrStackTrace("MicroMsg.SightPlayController", e222, "seek sound error: %s", e222.getMessage());
                        break;
                    }
            }
            AppMethodBeat.o(37428);
        }
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
            AppMethodBeat.i(37424);
            if (b.this.clb()) {
                ab.e("MicroMsg.SightPlayController", "is bad fps, do nothing when open file");
                AppMethodBeat.o(37424);
                return;
            }
            b.this.qxo = SightVideoJNI.openFile(b.this.ien, 1 == b.this.qxm ? 0 : 1, 1, false);
            if (b.this.qxo < 0) {
                ab.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id %d, path %s", Integer.valueOf(hashCode()), Integer.valueOf(b.this.hashCode()), Integer.valueOf(b.this.qxo), b.this.ien);
                b.this.cpV();
                if (b.this.rcq != null) {
                    b.this.rcq.Ds(-1);
                }
                AppMethodBeat.o(37424);
                return;
            }
            if (((Boolean) AdLandingPagesProxy.getInstance().getCfg(344065, Boolean.FALSE)).booleanValue()) {
                if (b.this.rcn == null) {
                    b.this.rcn = new j(b.this, (byte) 0);
                }
                b.this.lda.removeCallbacks(b.this.rcn);
                b.this.lda.post(b.this.rcn);
            }
            int max = Math.max(1, SightVideoJNI.getVideoWidth(b.this.qxo));
            int max2 = Math.max(1, SightVideoJNI.getVideoHeight(b.this.qxo));
            if (b.this.qxm == 0) {
                if (max * max2 >= 1048576 || max <= 0 || max2 <= 0) {
                    ab.e("MicroMsg.SightPlayController", "get error info videoWidth %d height  %d", Integer.valueOf(max), Integer.valueOf(max2));
                    AppMethodBeat.o(37424);
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
                b.this.CE(b.this.qxo);
                b.this.qxo = -1;
                b.this.ien = "";
                b.this.qxn = "ERROR#PATH";
                b.this.qxt = null;
                this.ovl = true;
                if (b.this.rcq != null) {
                    b.this.rcq.Ds(-1);
                }
                AppMethodBeat.o(37424);
                return;
            }
            b.this.dH(max, max2);
            if (1 == b.this.qxm) {
                b.this.rcj = new b(b.this, (byte) 0);
                b.this.rcl = null;
                if (!this.ovl) {
                    o.i(b.this.rcj, 0);
                }
            } else {
                b.this.rcj = new b(b.this, (byte) 0);
                b.this.rcl = new c();
                b.this.rcj.rcu = b.this.rcl;
                b.this.rcl.rcw = b.this.rcj;
                if (!this.ovl) {
                    o.i(b.this.rcj, 0);
                }
            }
            if (this.ovl) {
                ab.e("MicroMsg.SightPlayController", "#0x%x-#0x%x open file end, match stop %B", Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Boolean.valueOf(this.ovl));
            }
            AppMethodBeat.o(37424);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ double qxX;

        AnonymousClass2(double d) {
            this.qxX = d;
        }

        public final void run() {
            AppMethodBeat.i(37411);
            ab.i("MicroMsg.SightPlayController", "SeekToFrame   %f  %s", Double.valueOf(this.qxX), bo.dpG().toString());
            b.this.qxP = this.qxX;
            AppMethodBeat.o(37411);
        }
    }

    public abstract void U(Bitmap bitmap);

    public abstract void dH(int i, int i2);

    public b(View view) {
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
        this.lda = new ak(Looper.getMainLooper());
        this.qxx = new WeakReference(view);
        ab.i("MicroMsg.SightPlayController", "new SightPlayController, drawType %d", Integer.valueOf(0));
    }

    /* Access modifiers changed, original: protected */
    public int ckZ() {
        return -1;
    }

    public final void kz(boolean z) {
        if (this.rci != null) {
            o.y(this.rci);
            this.rci.ovl = true;
        }
        if (this.rcl != null) {
            this.lda.removeCallbacks(this.rcl);
            this.rcl.ovl = true;
        }
        if (this.rcj != null) {
            o.y(this.rcj);
            this.rcj.ovl = true;
        }
        if (this.rck != null) {
            this.rck.type = z ? 0 : 2;
            o.i(this.rck, 0);
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
                        this.rci = new h(this, (byte) 0);
                        o.i(this.rci, 0);
                        return;
                    }
                    ab.w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
                    clear();
                }
            } else if (1 == this.qxm) {
                this.rcj = new b(this, (byte) 0);
                this.rcl = null;
                o.i(this.rcj, 0);
            } else {
                this.rcj = new b(this, (byte) 0);
                this.rcl = new c();
                this.rcj.rcu = this.rcl;
                this.rcl.rcw = this.rcj;
                o.i(this.rcj, 0);
            }
        }
    }

    public final void clear() {
        ab.i("MicroMsg.SightPlayController", "#0x%x do clear, remove render job, video id %d, runing %B", Integer.valueOf(hashCode()), Integer.valueOf(this.qxo), Boolean.valueOf(cla()));
        kz(true);
        this.qxw = 0;
        CE(this.qxo);
        this.qxo = -1;
        this.ien = "";
        this.qxn = "ERROR#PATH";
        this.qxt = null;
        this.qxM = 0.0d;
        this.qxN = false;
        com.tencent.mm.memory.o.fdT.f(this.qxr);
        this.qxr = null;
    }

    private void CE(final int i) {
        o.i(new Runnable() {
            public final void run() {
                AppMethodBeat.i(37410);
                long currentTimeMillis = System.currentTimeMillis();
                SightVideoJNI.freeObj(i);
                ab.d("MicroMsg.SightPlayController", "#0x%x tick: do clear video %d, use %d ms", Integer.valueOf(b.this.hashCode()), Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.o(37410);
            }
        }, 0);
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

    /* Access modifiers changed, original: final */
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

    public final void cpV() {
        ab.v("MicroMsg.SightPlayController", "draw surface thumb, thumb is null ? %B", Boolean.TRUE);
        o.y(this.rcm);
        if (this.rcm == null) {
            this.rcm = new k(this, (byte) 0);
        }
        this.rcm.qyh = new WeakReference(null);
        o.i(this.rcm, 0);
    }

    public final com.tencent.mm.sdk.b.c cld() {
        if (this.rcp == null) {
            this.rcp = new a(this);
        }
        return this.rcp;
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

    static /* synthetic */ void A(b bVar) {
        if (bVar.qxx != null && -1 != bVar.ckZ()) {
            if (bVar.qxy == null && bVar.qxx.get() != null) {
                bVar.qxy = AnimationUtils.loadAnimation(((View) bVar.qxx.get()).getContext(), bVar.ckZ());
            }
            if (bVar.rco == null) {
                bVar.rco = new d(bVar, (byte) 0);
            }
            bVar.lda.post(bVar.rco);
        }
    }
}
