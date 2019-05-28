package com.tencent.mm.plugin.mmsight.segment;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.HandlerThread;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.v;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.memory.o;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.lang.ref.WeakReference;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;

public class RecyclerThumbSeekBar extends RelativeLayout implements c {
    private int fPW = -1;
    private int fgI;
    private int fgJ;
    private RecyclerView iJP;
    private VideoTransPara ouc;
    private int oyo;
    private com.tencent.mm.plugin.mmsight.segment.c.a oyp;
    private com.tencent.mm.plugin.mmsight.segment.c.b oyq;
    private c oyr;
    private n oys;
    private int oyt;
    private com.tencent.mm.plugin.mmsight.segment.d.a oyu = new com.tencent.mm.plugin.mmsight.segment.d.a(4, new Callable<d>() {
        public final /* synthetic */ Object call() {
            AppMethodBeat.i(54976);
            if (bo.isNullOrNil(RecyclerThumbSeekBar.this.path) || !com.tencent.mm.vfs.e.ct(RecyclerThumbSeekBar.this.path)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("create thumb fetcher error, file not exist");
                AppMethodBeat.o(54976);
                throw illegalArgumentException;
            }
            ab.i("RecyclerThumbSeekBar", "get thumb fetcher, ish265: %s", Boolean.valueOf(com.tencent.mm.bj.e.uD(RecyclerThumbSeekBar.this.path)));
            d kVar = new k();
            if (!com.tencent.mm.bj.e.uD(RecyclerThumbSeekBar.this.path)) {
                com.tencent.mm.plugin.sight.base.a WR = com.tencent.mm.plugin.sight.base.d.WR(RecyclerThumbSeekBar.this.path);
                if (WR != null && WR.width < 2000 && WR.height < 2000) {
                    kVar = new FFmpegSightJNIThumbFetcher();
                }
            }
            kVar.init(RecyclerThumbSeekBar.this.path, RecyclerThumbSeekBar.this.oyo, RecyclerThumbSeekBar.this.fgJ, RecyclerThumbSeekBar.this.fgI);
            AppMethodBeat.o(54976);
            return kVar;
        }
    });
    private Runnable oyv = new Runnable() {
        public final void run() {
            AppMethodBeat.i(54978);
            if (RecyclerThumbSeekBar.this.getHeight() == 0 || RecyclerThumbSeekBar.this.getWidth() == 0) {
                RecyclerThumbSeekBar.this.post(RecyclerThumbSeekBar.this.oyv);
                AppMethodBeat.o(54978);
                return;
            }
            RecyclerThumbSeekBar.this.fgI = RecyclerThumbSeekBar.this.getHeight();
            RecyclerThumbSeekBar.this.fgJ = (RecyclerThumbSeekBar.this.getWidth() - (RecyclerThumbSeekBar.this.oyt * 2)) / 12;
            com.tencent.mm.sdk.g.d.post(new Runnable() {
                public final void run() {
                    int i;
                    AppMethodBeat.i(54977);
                    try {
                        d bQd = RecyclerThumbSeekBar.this.oyu.bQd();
                        RecyclerThumbSeekBar.this.fPW = bQd.getDurationMs();
                        RecyclerThumbSeekBar.this.oyu.a(bQd);
                        i = 1;
                    } catch (Exception e) {
                        ab.printErrStackTrace("RecyclerThumbSeekBar", e, "Try to init fetcher error : %s", e.getMessage());
                        i = 0;
                    }
                    if (i == 0) {
                        RecyclerThumbSeekBar.h(RecyclerThumbSeekBar.this);
                        AppMethodBeat.o(54977);
                        return;
                    }
                    if (RecyclerThumbSeekBar.this.fPW >= Downloads.MIN_WAIT_FOR_NETWORK) {
                        RecyclerThumbSeekBar.this.oyo = (RecyclerThumbSeekBar.this.ouc.duration * 1000) / 10;
                    } else if (RecyclerThumbSeekBar.this.fPW > 0) {
                        RecyclerThumbSeekBar.this.oyo = RecyclerThumbSeekBar.this.fPW / 10;
                    } else {
                        ab.e("RecyclerThumbSeekBar", "RecyclerThumbSeekBar duration invalid %d", Integer.valueOf(RecyclerThumbSeekBar.this.fPW));
                        RecyclerThumbSeekBar.h(RecyclerThumbSeekBar.this);
                        AppMethodBeat.o(54977);
                        return;
                    }
                    ab.d("RecyclerThumbSeekBar", "duration %d interval %d", Integer.valueOf(RecyclerThumbSeekBar.this.fPW), Integer.valueOf(RecyclerThumbSeekBar.this.oyo));
                    RecyclerThumbSeekBar.k(RecyclerThumbSeekBar.this);
                    AppMethodBeat.o(54977);
                }
            }, "check duration of ");
            AppMethodBeat.o(54978);
        }
    };
    private m oyw = new m() {
        public final void c(RecyclerView recyclerView, int i) {
            AppMethodBeat.i(54981);
            if (i == 0 && RecyclerThumbSeekBar.this.oyq != null) {
                RecyclerThumbSeekBar.this.oyq.U(RecyclerThumbSeekBar.this.bQa(), RecyclerThumbSeekBar.this.bQb());
            }
            AppMethodBeat.o(54981);
        }
    };
    private com.tencent.mm.plugin.mmsight.segment.n.a oyx = new com.tencent.mm.plugin.mmsight.segment.n.a() {
        public final void bQm() {
            AppMethodBeat.i(54982);
            if (!(RecyclerThumbSeekBar.this.oyq == null || RecyclerThumbSeekBar.this.oyr == null)) {
                com.tencent.mm.plugin.mmsight.segment.c.b p = RecyclerThumbSeekBar.this.oyq;
                RecyclerThumbSeekBar.this.bQa();
                RecyclerThumbSeekBar.this.bQb();
                p.bQc();
            }
            AppMethodBeat.o(54982);
        }

        public final void bQn() {
            AppMethodBeat.i(54983);
            if (!(RecyclerThumbSeekBar.this.oyq == null || RecyclerThumbSeekBar.this.oyr == null)) {
                RecyclerThumbSeekBar.this.oyq.V(RecyclerThumbSeekBar.this.bQa(), RecyclerThumbSeekBar.this.bQb());
            }
            AppMethodBeat.o(54983);
        }

        public final void iZ(boolean z) {
            AppMethodBeat.i(54984);
            if (!(RecyclerThumbSeekBar.this.oyq == null || RecyclerThumbSeekBar.this.oyr == null)) {
                RecyclerThumbSeekBar.this.oyq.W(RecyclerThumbSeekBar.this.bQa(), RecyclerThumbSeekBar.this.bQb());
            }
            if (z) {
                RecyclerThumbSeekBar.this.oyr.w(true, RecyclerThumbSeekBar.this.oys.getLeftSliderBound());
                AppMethodBeat.o(54984);
                return;
            }
            RecyclerThumbSeekBar.this.oyr.w(false, RecyclerThumbSeekBar.this.oys.getWidth() - RecyclerThumbSeekBar.this.oys.getRightSliderBound());
            AppMethodBeat.o(54984);
        }
    };
    private String path;

    class a implements Runnable {
        private Bitmap bitmap;
        private ImageView cAw;
        private b oyA;

        a(Bitmap bitmap, ImageView imageView, b bVar) {
            this.bitmap = bitmap;
            this.cAw = imageView;
            this.oyA = bVar;
        }

        public final void run() {
            boolean z = true;
            AppMethodBeat.i(54985);
            if (this.bitmap == null || this.bitmap.isRecycled()) {
                String str = "RecyclerThumbSeekBar";
                String str2 = "bitmap is null %b in DrawBitmapOnViewTask";
                Object[] objArr = new Object[1];
                if (this.bitmap != null) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                ab.i(str, str2, objArr);
                AppMethodBeat.o(54985);
            } else if (this.oyA == null || this.oyA.fIa || this.cAw == null) {
                ab.i("RecyclerThumbSeekBar", "bitmap in DrawBitmapOnViewTask");
                AppMethodBeat.o(54985);
            } else {
                ImageView imageView = this.cAw;
                imageView.setTag(null);
                ObjectAnimator.ofInt(imageView, "imageAlpha", new int[]{50, 255}).setDuration(200).start();
                imageView.setImageBitmap(this.bitmap);
                AppMethodBeat.o(54985);
            }
        }
    }

    class b implements Runnable {
        private WeakReference<ImageView> aIp;
        boolean fIa = false;
        private ak handler;
        private int oyB;
        private Bitmap oyC;

        b(int i, ImageView imageView, Bitmap bitmap, ak akVar) {
            AppMethodBeat.i(54986);
            this.oyB = i;
            this.aIp = new WeakReference(imageView);
            this.handler = akVar;
            this.oyC = bitmap;
            AppMethodBeat.o(54986);
        }

        public final void run() {
            AppMethodBeat.i(54987);
            if (this.fIa) {
                o.fdT.f(this.oyC);
                AppMethodBeat.o(54987);
            } else if (((ImageView) this.aIp.get()) == null) {
                o.fdT.f(this.oyC);
                AppMethodBeat.o(54987);
            } else {
                try {
                    d bQd = RecyclerThumbSeekBar.this.oyu.bQd();
                    if (this.oyC == null) {
                        this.oyC = o.fdT.a(new com.tencent.mm.memory.o.b(bQd.getScaledWidth(), bQd.getScaledHeight()));
                    }
                    bQd.reuseBitmap(this.oyC);
                    if (!this.fIa) {
                        this.oyC = bQd.getFrameAtTime((long) this.oyB);
                    }
                    RecyclerThumbSeekBar.this.oyu.a(bQd);
                    if (this.oyC == null || this.fIa || this.aIp.get() == null) {
                        o.fdT.f(this.oyC);
                        AppMethodBeat.o(54987);
                        return;
                    }
                    this.handler.post(new a(this.oyC, (ImageView) this.aIp.get(), this));
                    AppMethodBeat.o(54987);
                } catch (Exception e) {
                    ab.e("RecyclerThumbSeekBar", "get bitmap error " + e.getMessage());
                    o.fdT.f(this.oyC);
                    AppMethodBeat.o(54987);
                }
            }
        }
    }

    class d {
        ak handler = new ak();
        int ovf = 4;
        HandlerThread[] oyI = new HandlerThread[this.ovf];
        int oyJ = 0;
        private BlockingDeque<b> oyK = new LinkedBlockingDeque();

        public d() {
            AppMethodBeat.i(54994);
            for (int i = 0; i < this.oyI.length; i++) {
                this.oyI[i] = com.tencent.mm.sdk.g.d.ek("RecyclerThumbSeekBar_SimpleImageLoader_".concat(String.valueOf(i)), -1);
                this.oyI[i].start();
            }
            this.oyJ = 0;
            AppMethodBeat.o(54994);
        }
    }

    class c extends android.support.v7.widget.RecyclerView.a<e> {
        d oyD;
        int oyE;
        int oyF;
        private View oyG;
        private View oyH;

        private c() {
            AppMethodBeat.i(54988);
            this.oyD = new d();
            this.oyE = RecyclerThumbSeekBar.this.oyt;
            this.oyF = RecyclerThumbSeekBar.this.oyt;
            AppMethodBeat.o(54988);
        }

        /* synthetic */ c(RecyclerThumbSeekBar recyclerThumbSeekBar, byte b) {
            this();
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.i(54989);
            if (i == 0) {
                AppMethodBeat.o(54989);
                return 1;
            } else if (i == getItemCount() - 1) {
                AppMethodBeat.o(54989);
                return 2;
            } else {
                AppMethodBeat.o(54989);
                return 0;
            }
        }

        public final void w(boolean z, int i) {
            AppMethodBeat.i(54990);
            if (z) {
                if (this.oyG != null) {
                    this.oyG.setMinimumWidth(i);
                }
                if (((LinearLayoutManager) RecyclerThumbSeekBar.this.iJP.getLayoutManager()).iQ() == 0) {
                    RecyclerThumbSeekBar.this.iJP.scrollBy(i - this.oyE, 0);
                }
                this.oyE = i;
                AppMethodBeat.o(54990);
                return;
            }
            this.oyF = i;
            if (this.oyH != null) {
                this.oyH.setMinimumWidth(this.oyF);
            }
            AppMethodBeat.o(54990);
        }

        public final int getItemCount() {
            AppMethodBeat.i(54991);
            if (RecyclerThumbSeekBar.this.fPW <= 0) {
                AppMethodBeat.o(54991);
                return 0;
            }
            int max = Math.max(0, (int) Math.floor((double) (((float) RecyclerThumbSeekBar.this.fPW) / ((float) RecyclerThumbSeekBar.this.oyo)))) + 2;
            AppMethodBeat.o(54991);
            return max;
        }
    }

    class e extends v {
        ImageView cAw;

        e(View view, int i) {
            super(view);
            AppMethodBeat.i(54995);
            if (i == 0) {
                this.cAw = (ImageView) ((LinearLayout) view).getChildAt(0);
            }
            AppMethodBeat.o(54995);
        }
    }

    static /* synthetic */ void h(RecyclerThumbSeekBar recyclerThumbSeekBar) {
        AppMethodBeat.i(55008);
        recyclerThumbSeekBar.bQl();
        AppMethodBeat.o(55008);
    }

    public RecyclerThumbSeekBar(Context context) {
        super(context);
        AppMethodBeat.i(54996);
        init();
        AppMethodBeat.o(54996);
    }

    public RecyclerThumbSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(54997);
        init();
        AppMethodBeat.o(54997);
    }

    public RecyclerThumbSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(54998);
        init();
        AppMethodBeat.o(54998);
    }

    private void init() {
        AppMethodBeat.i(54999);
        this.iJP = new RecyclerView(getContext());
        getContext();
        this.iJP.setLayoutManager(new LinearLayoutManager(0));
        this.iJP.setHasFixedSize(true);
        int al = com.tencent.mm.bz.a.al(getContext(), R.dimen.aa1);
        this.oyt = com.tencent.mm.bz.a.al(getContext(), R.dimen.aa0);
        addView(this.iJP, new LayoutParams(-1, al));
        this.oys = new n(getContext());
        addView(this.oys, new LayoutParams(-1, -1));
        this.oys.setOnSliderTouchListener(this.oyx);
        this.iJP.a(this.oyw);
        AppMethodBeat.o(54999);
    }

    public void setCurrentCursorPosition(float f) {
        float f2 = 0.0f;
        AppMethodBeat.i(55000);
        n nVar = this.oys;
        if (!(this.oyr == null || this.iJP == null)) {
            float itemCount = ((float) this.oyr.getItemCount()) * f;
            int floor = (int) Math.floor((double) itemCount);
            itemCount -= (float) floor;
            v cf = this.iJP.cf(floor + 1);
            if (cf != null) {
                View view = cf.apJ;
                f2 = ((((float) view.getWidth()) * itemCount) + ((float) view.getLeft())) / ((float) getWidth());
            }
        }
        nVar.setCursorPos(f2);
        AppMethodBeat.o(55000);
    }

    public final void RO(String str) {
        AppMethodBeat.i(55001);
        if (bo.isNullOrNil(str) || !com.tencent.mm.vfs.e.ct(str)) {
            bQl();
            AppMethodBeat.o(55001);
            return;
        }
        this.path = str;
        post(this.oyv);
        AppMethodBeat.o(55001);
    }

    public int getDurationMs() {
        return this.fPW;
    }

    public final void iX(boolean z) {
        if (z) {
            this.oys.oyN = true;
        } else {
            this.oys.oyN = false;
        }
    }

    public void setVideoTransPara(VideoTransPara videoTransPara) {
        this.ouc = videoTransPara;
    }

    private void setViewWidth(int i) {
        AppMethodBeat.i(55002);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = i;
        setLayoutParams(layoutParams);
        AppMethodBeat.o(55002);
    }

    private void bQl() {
        AppMethodBeat.i(55003);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(54980);
                if (RecyclerThumbSeekBar.this.oyp != null) {
                    RecyclerThumbSeekBar.this.oyp.iY(true);
                }
                AppMethodBeat.o(54980);
            }
        });
        AppMethodBeat.o(55003);
    }

    public final void release() {
        AppMethodBeat.i(55004);
        this.fPW = -1;
        this.path = null;
        if (this.oyu != null) {
            this.oyu.destroy();
        }
        if (!(this.oyr == null || this.oyr.oyD == null)) {
            d dVar = this.oyr.oyD;
            if (!(dVar.oyI == null || dVar.oyI.length == 0)) {
                for (int i = 0; i < dVar.oyI.length; i++) {
                    if (dVar.oyI[i] != null) {
                        dVar.oyI[i].quit();
                        dVar.oyI[i] = null;
                    }
                }
            }
            this.oyr.oyD = null;
            this.oyr = null;
        }
        if (this.oys != null) {
            n nVar = this.oys;
            if (!(nVar.ozg == null || nVar.ozh == null)) {
                nVar.oyQ.setBounds(nVar.ozg);
                nVar.oyR.setBounds(nVar.ozh);
                nVar.oyV = -1.0f;
                nVar.postInvalidate();
            }
        }
        AppMethodBeat.o(55004);
    }

    public void setOnPreparedListener(com.tencent.mm.plugin.mmsight.segment.c.a aVar) {
        this.oyp = aVar;
    }

    public void setThumbBarSeekListener(com.tencent.mm.plugin.mmsight.segment.c.b bVar) {
        this.oyq = bVar;
    }

    public final float bQa() {
        AppMethodBeat.i(55005);
        if (this.oys == null) {
            AppMethodBeat.o(55005);
            return 0.0f;
        }
        ab.d("RecyclerThumbSeekBar", "computeStartPercent x : [%d] ret[%f] seekLoopStartTime[%d] durationMs[%d]", Integer.valueOf(this.oys.getLeftSliderBound()), Float.valueOf(r0), Integer.valueOf(Math.round(((float) this.fPW) * Z(this.oys.getLeftSliderBound(), false))), Integer.valueOf(this.fPW));
        AppMethodBeat.o(55005);
        return Z(this.oys.getLeftSliderBound(), false);
    }

    public final float bQb() {
        AppMethodBeat.i(55006);
        if (this.oys == null) {
            AppMethodBeat.o(55006);
            return 0.0f;
        }
        ab.d("RecyclerThumbSeekBar", "computeEndPercent x : [%d] ret[%f] seekLoopEndTime[%d]", Integer.valueOf(this.oys.getRightSliderBound()), Float.valueOf(r0), Integer.valueOf(Math.round(((float) this.fPW) * Z(this.oys.getRightSliderBound(), true))));
        AppMethodBeat.o(55006);
        return Z(this.oys.getRightSliderBound(), true);
    }

    private float Z(int i, boolean z) {
        AppMethodBeat.i(55007);
        if (this.oyr == null || this.iJP == null) {
            AppMethodBeat.o(55007);
            return 0.0f;
        }
        View x = this.iJP.x((float) i, 0.0f);
        if (x == null) {
            ab.w("RecyclerThumbSeekBar", "getPositionInTotalRange x[%d] isEnd[%b], view is null.", Integer.valueOf(i), Boolean.valueOf(z));
            AppMethodBeat.o(55007);
            return 0.0f;
        }
        int bo = RecyclerView.bo(x);
        int itemCount = this.oyr.getItemCount();
        if (bo <= 1) {
            AppMethodBeat.o(55007);
            return 0.0f;
        } else if (bo >= itemCount - 1) {
            AppMethodBeat.o(55007);
            return 1.0f;
        } else {
            float left = (((float) (bo - 1)) + (((float) (i - x.getLeft())) / ((float) x.getWidth()))) / ((float) (itemCount - 2));
            AppMethodBeat.o(55007);
            return left;
        }
    }

    static /* synthetic */ void k(RecyclerThumbSeekBar recyclerThumbSeekBar) {
        AppMethodBeat.i(55009);
        al.d(new Runnable() {
            public final void run() {
                int i = 1000;
                AppMethodBeat.i(54979);
                try {
                    RecyclerThumbSeekBar.this.oys.setCursorPos(-1.0f);
                    RecyclerThumbSeekBar.this.oyr = new c(RecyclerThumbSeekBar.this, (byte) 0);
                    int e = RecyclerThumbSeekBar.e(RecyclerThumbSeekBar.this, (RecyclerThumbSeekBar.this.ouc.duration * 1000) + 1000);
                    RecyclerThumbSeekBar recyclerThumbSeekBar = RecyclerThumbSeekBar.this;
                    if (RecyclerThumbSeekBar.this.oyo > 1000) {
                        i = RecyclerThumbSeekBar.this.oyo;
                    }
                    i = RecyclerThumbSeekBar.e(recyclerThumbSeekBar, i);
                    RecyclerThumbSeekBar.this.oyt = (RecyclerThumbSeekBar.this.getWidth() - e) / 2;
                    n l = RecyclerThumbSeekBar.this.oys;
                    l.post(new com.tencent.mm.plugin.mmsight.segment.n.AnonymousClass1(e, RecyclerThumbSeekBar.this.oyt, i));
                    ab.i("RecyclerThumbSeekBar", "RecyclerThumbSeekBar.run(212) width %d", Integer.valueOf(RecyclerThumbSeekBar.this.getWidth()));
                    RecyclerThumbSeekBar.this.oyr.oyF = (RecyclerThumbSeekBar.this.getWidth() - RecyclerThumbSeekBar.this.oyt) - e;
                    RecyclerThumbSeekBar.this.oyr.oyE = RecyclerThumbSeekBar.this.oyt;
                    RecyclerThumbSeekBar.this.iJP.setAdapter(RecyclerThumbSeekBar.this.oyr);
                    ab.d("RecyclerThumbSeekBar", "init segment thumb fetcher end, adapter.getItemCount() %d", Integer.valueOf(RecyclerThumbSeekBar.this.oyr.getItemCount()));
                    if (RecyclerThumbSeekBar.this.oyp != null) {
                        RecyclerThumbSeekBar.this.oyp.iY(false);
                    }
                    AppMethodBeat.o(54979);
                } catch (Exception e2) {
                    ab.printErrStackTrace("RecyclerThumbSeekBar", e2, "RecyclerThumbSeekBar notifySuccess error : %s", e2.getMessage());
                    if (RecyclerThumbSeekBar.this.oyp != null) {
                        RecyclerThumbSeekBar.this.oyp.iY(true);
                    }
                    AppMethodBeat.o(54979);
                }
            }
        });
        AppMethodBeat.o(55009);
    }

    static /* synthetic */ int e(RecyclerThumbSeekBar recyclerThumbSeekBar, int i) {
        AppMethodBeat.i(55010);
        IllegalStateException illegalStateException;
        if (recyclerThumbSeekBar.oyr == null) {
            illegalStateException = new IllegalStateException("recyclerAdapter is null");
            AppMethodBeat.o(55010);
            throw illegalStateException;
        } else if (recyclerThumbSeekBar.fPW <= 0) {
            illegalStateException = new IllegalStateException("durationMs <= 0");
            AppMethodBeat.o(55010);
            throw illegalStateException;
        } else {
            recyclerThumbSeekBar.oyr.getItemCount();
            int min = (int) ((Math.min(Math.max(0.0f, ((float) i) / ((float) recyclerThumbSeekBar.fPW)), 1.0f) * ((float) recyclerThumbSeekBar.fgJ)) * ((float) (recyclerThumbSeekBar.oyr.getItemCount() - 2)));
            AppMethodBeat.o(55010);
            return min;
        }
    }
}
