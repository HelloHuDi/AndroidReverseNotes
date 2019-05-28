package com.tencent.p177mm.plugin.mmsight.segment;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.HandlerThread;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41530m;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.memory.C9631o;
import com.tencent.p177mm.memory.C9631o.C9633b;
import com.tencent.p177mm.modelcontrol.VideoTransPara;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p838bj.C17987e;
import com.tencent.p177mm.plugin.mmsight.segment.C12575c.C12576a;
import com.tencent.p177mm.plugin.mmsight.segment.C12575c.C12577b;
import com.tencent.p177mm.plugin.mmsight.segment.C3493d.C3494a;
import com.tencent.p177mm.plugin.mmsight.segment.C46084n.C12582a;
import com.tencent.p177mm.plugin.mmsight.segment.C46084n.C285191;
import com.tencent.p177mm.plugin.sight.base.C21846d;
import com.tencent.p177mm.plugin.sight.base.C43528a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.lang.ref.WeakReference;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;

/* renamed from: com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar */
public class RecyclerThumbSeekBar extends RelativeLayout implements C12575c {
    private int fPW = -1;
    private int fgI;
    private int fgJ;
    private RecyclerView iJP;
    private VideoTransPara ouc;
    private int oyo;
    private C12576a oyp;
    private C12577b oyq;
    private C28509c oyr;
    private C46084n oys;
    private int oyt;
    private C3494a oyu = new C3494a(4, new C345531());
    private Runnable oyv = new C345542();
    private C41530m oyw = new C345565();
    private C12582a oyx = new C34886();
    private String path;

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar$6 */
    class C34886 implements C12582a {
        C34886() {
        }

        public final void bQm() {
            AppMethodBeat.m2504i(54982);
            if (!(RecyclerThumbSeekBar.this.oyq == null || RecyclerThumbSeekBar.this.oyr == null)) {
                C12577b p = RecyclerThumbSeekBar.this.oyq;
                RecyclerThumbSeekBar.this.bQa();
                RecyclerThumbSeekBar.this.bQb();
                p.bQc();
            }
            AppMethodBeat.m2505o(54982);
        }

        public final void bQn() {
            AppMethodBeat.m2504i(54983);
            if (!(RecyclerThumbSeekBar.this.oyq == null || RecyclerThumbSeekBar.this.oyr == null)) {
                RecyclerThumbSeekBar.this.oyq.mo17634V(RecyclerThumbSeekBar.this.bQa(), RecyclerThumbSeekBar.this.bQb());
            }
            AppMethodBeat.m2505o(54983);
        }

        /* renamed from: iZ */
        public final void mo7947iZ(boolean z) {
            AppMethodBeat.m2504i(54984);
            if (!(RecyclerThumbSeekBar.this.oyq == null || RecyclerThumbSeekBar.this.oyr == null)) {
                RecyclerThumbSeekBar.this.oyq.mo17635W(RecyclerThumbSeekBar.this.bQa(), RecyclerThumbSeekBar.this.bQb());
            }
            if (z) {
                RecyclerThumbSeekBar.this.oyr.mo46475w(true, RecyclerThumbSeekBar.this.oys.getLeftSliderBound());
                AppMethodBeat.m2505o(54984);
                return;
            }
            RecyclerThumbSeekBar.this.oyr.mo46475w(false, RecyclerThumbSeekBar.this.oys.getWidth() - RecyclerThumbSeekBar.this.oys.getRightSliderBound());
            AppMethodBeat.m2505o(54984);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar$a */
    class C12569a implements Runnable {
        private Bitmap bitmap;
        private ImageView cAw;
        private C12570b oyA;

        C12569a(Bitmap bitmap, ImageView imageView, C12570b c12570b) {
            this.bitmap = bitmap;
            this.cAw = imageView;
            this.oyA = c12570b;
        }

        public final void run() {
            boolean z = true;
            AppMethodBeat.m2504i(54985);
            if (this.bitmap == null || this.bitmap.isRecycled()) {
                String str = "RecyclerThumbSeekBar";
                String str2 = "bitmap is null %b in DrawBitmapOnViewTask";
                Object[] objArr = new Object[1];
                if (this.bitmap != null) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                C4990ab.m7417i(str, str2, objArr);
                AppMethodBeat.m2505o(54985);
            } else if (this.oyA == null || this.oyA.fIa || this.cAw == null) {
                C4990ab.m7416i("RecyclerThumbSeekBar", "bitmap in DrawBitmapOnViewTask");
                AppMethodBeat.m2505o(54985);
            } else {
                ImageView imageView = this.cAw;
                imageView.setTag(null);
                ObjectAnimator.ofInt(imageView, "imageAlpha", new int[]{50, 255}).setDuration(200).start();
                imageView.setImageBitmap(this.bitmap);
                AppMethodBeat.m2505o(54985);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar$b */
    class C12570b implements Runnable {
        private WeakReference<ImageView> aIp;
        boolean fIa = false;
        private C7306ak handler;
        private int oyB;
        private Bitmap oyC;

        C12570b(int i, ImageView imageView, Bitmap bitmap, C7306ak c7306ak) {
            AppMethodBeat.m2504i(54986);
            this.oyB = i;
            this.aIp = new WeakReference(imageView);
            this.handler = c7306ak;
            this.oyC = bitmap;
            AppMethodBeat.m2505o(54986);
        }

        public final void run() {
            AppMethodBeat.m2504i(54987);
            if (this.fIa) {
                C9631o.fdT.mo20963f(this.oyC);
                AppMethodBeat.m2505o(54987);
            } else if (((ImageView) this.aIp.get()) == null) {
                C9631o.fdT.mo20963f(this.oyC);
                AppMethodBeat.m2505o(54987);
            } else {
                try {
                    C3493d bQd = RecyclerThumbSeekBar.this.oyu.bQd();
                    if (this.oyC == null) {
                        this.oyC = C9631o.fdT.mo20955a(new C9633b(bQd.getScaledWidth(), bQd.getScaledHeight()));
                    }
                    bQd.reuseBitmap(this.oyC);
                    if (!this.fIa) {
                        this.oyC = bQd.getFrameAtTime((long) this.oyB);
                    }
                    RecyclerThumbSeekBar.this.oyu.mo7966a(bQd);
                    if (this.oyC == null || this.fIa || this.aIp.get() == null) {
                        C9631o.fdT.mo20963f(this.oyC);
                        AppMethodBeat.m2505o(54987);
                        return;
                    }
                    this.handler.post(new C12569a(this.oyC, (ImageView) this.aIp.get(), this));
                    AppMethodBeat.m2505o(54987);
                } catch (Exception e) {
                    C4990ab.m7412e("RecyclerThumbSeekBar", "get bitmap error " + e.getMessage());
                    C9631o.fdT.mo20963f(this.oyC);
                    AppMethodBeat.m2505o(54987);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar$d */
    class C21306d {
        C7306ak handler = new C7306ak();
        int ovf = 4;
        HandlerThread[] oyI = new HandlerThread[this.ovf];
        int oyJ = 0;
        private BlockingDeque<C12570b> oyK = new LinkedBlockingDeque();

        public C21306d() {
            AppMethodBeat.m2504i(54994);
            for (int i = 0; i < this.oyI.length; i++) {
                this.oyI[i] = C7305d.m12297ek("RecyclerThumbSeekBar_SimpleImageLoader_".concat(String.valueOf(i)), -1);
                this.oyI[i].start();
            }
            this.oyJ = 0;
            AppMethodBeat.m2505o(54994);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar$c */
    class C28509c extends C41523a<C43310e> {
        C21306d oyD;
        int oyE;
        int oyF;
        private View oyG;
        private View oyH;

        private C28509c() {
            AppMethodBeat.m2504i(54988);
            this.oyD = new C21306d();
            this.oyE = RecyclerThumbSeekBar.this.oyt;
            this.oyF = RecyclerThumbSeekBar.this.oyt;
            AppMethodBeat.m2505o(54988);
        }

        /* synthetic */ C28509c(RecyclerThumbSeekBar recyclerThumbSeekBar, byte b) {
            this();
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.m2504i(54989);
            if (i == 0) {
                AppMethodBeat.m2505o(54989);
                return 1;
            } else if (i == getItemCount() - 1) {
                AppMethodBeat.m2505o(54989);
                return 2;
            } else {
                AppMethodBeat.m2505o(54989);
                return 0;
            }
        }

        /* renamed from: w */
        public final void mo46475w(boolean z, int i) {
            AppMethodBeat.m2504i(54990);
            if (z) {
                if (this.oyG != null) {
                    this.oyG.setMinimumWidth(i);
                }
                if (((LinearLayoutManager) RecyclerThumbSeekBar.this.iJP.getLayoutManager()).mo1780iQ() == 0) {
                    RecyclerThumbSeekBar.this.iJP.scrollBy(i - this.oyE, 0);
                }
                this.oyE = i;
                AppMethodBeat.m2505o(54990);
                return;
            }
            this.oyF = i;
            if (this.oyH != null) {
                this.oyH.setMinimumWidth(this.oyF);
            }
            AppMethodBeat.m2505o(54990);
        }

        public final int getItemCount() {
            AppMethodBeat.m2504i(54991);
            if (RecyclerThumbSeekBar.this.fPW <= 0) {
                AppMethodBeat.m2505o(54991);
                return 0;
            }
            int max = Math.max(0, (int) Math.floor((double) (((float) RecyclerThumbSeekBar.this.fPW) / ((float) RecyclerThumbSeekBar.this.oyo)))) + 2;
            AppMethodBeat.m2505o(54991);
            return max;
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar$1 */
    class C345531 implements Callable<C3493d> {
        C345531() {
        }

        public final /* synthetic */ Object call() {
            AppMethodBeat.m2504i(54976);
            if (C5046bo.isNullOrNil(RecyclerThumbSeekBar.this.path) || !C5730e.m8628ct(RecyclerThumbSeekBar.this.path)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("create thumb fetcher error, file not exist");
                AppMethodBeat.m2505o(54976);
                throw illegalArgumentException;
            }
            C4990ab.m7417i("RecyclerThumbSeekBar", "get thumb fetcher, ish265: %s", Boolean.valueOf(C17987e.m28307uD(RecyclerThumbSeekBar.this.path)));
            C3493d c12581k = new C12581k();
            if (!C17987e.m28307uD(RecyclerThumbSeekBar.this.path)) {
                C43528a WR = C21846d.m33388WR(RecyclerThumbSeekBar.this.path);
                if (WR != null && WR.width < 2000 && WR.height < 2000) {
                    c12581k = new FFmpegSightJNIThumbFetcher();
                }
            }
            c12581k.init(RecyclerThumbSeekBar.this.path, RecyclerThumbSeekBar.this.oyo, RecyclerThumbSeekBar.this.fgJ, RecyclerThumbSeekBar.this.fgI);
            AppMethodBeat.m2505o(54976);
            return c12581k;
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar$2 */
    class C345542 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar$2$1 */
        class C34871 implements Runnable {
            C34871() {
            }

            public final void run() {
                int i;
                AppMethodBeat.m2504i(54977);
                try {
                    C3493d bQd = RecyclerThumbSeekBar.this.oyu.bQd();
                    RecyclerThumbSeekBar.this.fPW = bQd.getDurationMs();
                    RecyclerThumbSeekBar.this.oyu.mo7966a(bQd);
                    i = 1;
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("RecyclerThumbSeekBar", e, "Try to init fetcher error : %s", e.getMessage());
                    i = 0;
                }
                if (i == 0) {
                    RecyclerThumbSeekBar.m77238h(RecyclerThumbSeekBar.this);
                    AppMethodBeat.m2505o(54977);
                    return;
                }
                if (RecyclerThumbSeekBar.this.fPW >= Downloads.MIN_WAIT_FOR_NETWORK) {
                    RecyclerThumbSeekBar.this.oyo = (RecyclerThumbSeekBar.this.ouc.duration * 1000) / 10;
                } else if (RecyclerThumbSeekBar.this.fPW > 0) {
                    RecyclerThumbSeekBar.this.oyo = RecyclerThumbSeekBar.this.fPW / 10;
                } else {
                    C4990ab.m7413e("RecyclerThumbSeekBar", "RecyclerThumbSeekBar duration invalid %d", Integer.valueOf(RecyclerThumbSeekBar.this.fPW));
                    RecyclerThumbSeekBar.m77238h(RecyclerThumbSeekBar.this);
                    AppMethodBeat.m2505o(54977);
                    return;
                }
                C4990ab.m7411d("RecyclerThumbSeekBar", "duration %d interval %d", Integer.valueOf(RecyclerThumbSeekBar.this.fPW), Integer.valueOf(RecyclerThumbSeekBar.this.oyo));
                RecyclerThumbSeekBar.m77241k(RecyclerThumbSeekBar.this);
                AppMethodBeat.m2505o(54977);
            }
        }

        C345542() {
        }

        public final void run() {
            AppMethodBeat.m2504i(54978);
            if (RecyclerThumbSeekBar.this.getHeight() == 0 || RecyclerThumbSeekBar.this.getWidth() == 0) {
                RecyclerThumbSeekBar.this.post(RecyclerThumbSeekBar.this.oyv);
                AppMethodBeat.m2505o(54978);
                return;
            }
            RecyclerThumbSeekBar.this.fgI = RecyclerThumbSeekBar.this.getHeight();
            RecyclerThumbSeekBar.this.fgJ = (RecyclerThumbSeekBar.this.getWidth() - (RecyclerThumbSeekBar.this.oyt * 2)) / 12;
            C7305d.post(new C34871(), "check duration of ");
            AppMethodBeat.m2505o(54978);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar$3 */
    class C345553 implements Runnable {
        C345553() {
        }

        public final void run() {
            int i = 1000;
            AppMethodBeat.m2504i(54979);
            try {
                RecyclerThumbSeekBar.this.oys.setCursorPos(-1.0f);
                RecyclerThumbSeekBar.this.oyr = new C28509c(RecyclerThumbSeekBar.this, (byte) 0);
                int e = RecyclerThumbSeekBar.m77233e(RecyclerThumbSeekBar.this, (RecyclerThumbSeekBar.this.ouc.duration * 1000) + 1000);
                RecyclerThumbSeekBar recyclerThumbSeekBar = RecyclerThumbSeekBar.this;
                if (RecyclerThumbSeekBar.this.oyo > 1000) {
                    i = RecyclerThumbSeekBar.this.oyo;
                }
                i = RecyclerThumbSeekBar.m77233e(recyclerThumbSeekBar, i);
                RecyclerThumbSeekBar.this.oyt = (RecyclerThumbSeekBar.this.getWidth() - e) / 2;
                C46084n l = RecyclerThumbSeekBar.this.oys;
                l.post(new C285191(e, RecyclerThumbSeekBar.this.oyt, i));
                C4990ab.m7417i("RecyclerThumbSeekBar", "RecyclerThumbSeekBar.run(212) width %d", Integer.valueOf(RecyclerThumbSeekBar.this.getWidth()));
                RecyclerThumbSeekBar.this.oyr.oyF = (RecyclerThumbSeekBar.this.getWidth() - RecyclerThumbSeekBar.this.oyt) - e;
                RecyclerThumbSeekBar.this.oyr.oyE = RecyclerThumbSeekBar.this.oyt;
                RecyclerThumbSeekBar.this.iJP.setAdapter(RecyclerThumbSeekBar.this.oyr);
                C4990ab.m7411d("RecyclerThumbSeekBar", "init segment thumb fetcher end, adapter.getItemCount() %d", Integer.valueOf(RecyclerThumbSeekBar.this.oyr.getItemCount()));
                if (RecyclerThumbSeekBar.this.oyp != null) {
                    RecyclerThumbSeekBar.this.oyp.mo17640iY(false);
                }
                AppMethodBeat.m2505o(54979);
            } catch (Exception e2) {
                C4990ab.printErrStackTrace("RecyclerThumbSeekBar", e2, "RecyclerThumbSeekBar notifySuccess error : %s", e2.getMessage());
                if (RecyclerThumbSeekBar.this.oyp != null) {
                    RecyclerThumbSeekBar.this.oyp.mo17640iY(true);
                }
                AppMethodBeat.m2505o(54979);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar$5 */
    class C345565 extends C41530m {
        C345565() {
        }

        /* renamed from: c */
        public final void mo6643c(RecyclerView recyclerView, int i) {
            AppMethodBeat.m2504i(54981);
            if (i == 0 && RecyclerThumbSeekBar.this.oyq != null) {
                RecyclerThumbSeekBar.this.oyq.mo17633U(RecyclerThumbSeekBar.this.bQa(), RecyclerThumbSeekBar.this.bQb());
            }
            AppMethodBeat.m2505o(54981);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar$4 */
    class C393964 implements Runnable {
        C393964() {
        }

        public final void run() {
            AppMethodBeat.m2504i(54980);
            if (RecyclerThumbSeekBar.this.oyp != null) {
                RecyclerThumbSeekBar.this.oyp.mo17640iY(true);
            }
            AppMethodBeat.m2505o(54980);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar$e */
    class C43310e extends C41531v {
        ImageView cAw;

        C43310e(View view, int i) {
            super(view);
            AppMethodBeat.m2504i(54995);
            if (i == 0) {
                this.cAw = (ImageView) ((LinearLayout) view).getChildAt(0);
            }
            AppMethodBeat.m2505o(54995);
        }
    }

    /* renamed from: h */
    static /* synthetic */ void m77238h(RecyclerThumbSeekBar recyclerThumbSeekBar) {
        AppMethodBeat.m2504i(55008);
        recyclerThumbSeekBar.bQl();
        AppMethodBeat.m2505o(55008);
    }

    public RecyclerThumbSeekBar(Context context) {
        super(context);
        AppMethodBeat.m2504i(54996);
        init();
        AppMethodBeat.m2505o(54996);
    }

    public RecyclerThumbSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(54997);
        init();
        AppMethodBeat.m2505o(54997);
    }

    public RecyclerThumbSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(54998);
        init();
        AppMethodBeat.m2505o(54998);
    }

    private void init() {
        AppMethodBeat.m2504i(54999);
        this.iJP = new RecyclerView(getContext());
        getContext();
        this.iJP.setLayoutManager(new LinearLayoutManager(0));
        this.iJP.setHasFixedSize(true);
        int al = C1338a.m2856al(getContext(), C25738R.dimen.aa1);
        this.oyt = C1338a.m2856al(getContext(), C25738R.dimen.aa0);
        addView(this.iJP, new LayoutParams(-1, al));
        this.oys = new C46084n(getContext());
        addView(this.oys, new LayoutParams(-1, -1));
        this.oys.setOnSliderTouchListener(this.oyx);
        this.iJP.mo66332a(this.oyw);
        AppMethodBeat.m2505o(54999);
    }

    public void setCurrentCursorPosition(float f) {
        float f2 = 0.0f;
        AppMethodBeat.m2504i(55000);
        C46084n c46084n = this.oys;
        if (!(this.oyr == null || this.iJP == null)) {
            float itemCount = ((float) this.oyr.getItemCount()) * f;
            int floor = (int) Math.floor((double) itemCount);
            itemCount -= (float) floor;
            C41531v cf = this.iJP.mo66357cf(floor + 1);
            if (cf != null) {
                View view = cf.apJ;
                f2 = ((((float) view.getWidth()) * itemCount) + ((float) view.getLeft())) / ((float) getWidth());
            }
        }
        c46084n.setCursorPos(f2);
        AppMethodBeat.m2505o(55000);
    }

    /* renamed from: RO */
    public final void mo24502RO(String str) {
        AppMethodBeat.m2504i(55001);
        if (C5046bo.isNullOrNil(str) || !C5730e.m8628ct(str)) {
            bQl();
            AppMethodBeat.m2505o(55001);
            return;
        }
        this.path = str;
        post(this.oyv);
        AppMethodBeat.m2505o(55001);
    }

    public int getDurationMs() {
        return this.fPW;
    }

    /* renamed from: iX */
    public final void mo24506iX(boolean z) {
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
        AppMethodBeat.m2504i(55002);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = i;
        setLayoutParams(layoutParams);
        AppMethodBeat.m2505o(55002);
    }

    private void bQl() {
        AppMethodBeat.m2504i(55003);
        C5004al.m7441d(new C393964());
        AppMethodBeat.m2505o(55003);
    }

    public final void release() {
        AppMethodBeat.m2504i(55004);
        this.fPW = -1;
        this.path = null;
        if (this.oyu != null) {
            this.oyu.destroy();
        }
        if (!(this.oyr == null || this.oyr.oyD == null)) {
            C21306d c21306d = this.oyr.oyD;
            if (!(c21306d.oyI == null || c21306d.oyI.length == 0)) {
                for (int i = 0; i < c21306d.oyI.length; i++) {
                    if (c21306d.oyI[i] != null) {
                        c21306d.oyI[i].quit();
                        c21306d.oyI[i] = null;
                    }
                }
            }
            this.oyr.oyD = null;
            this.oyr = null;
        }
        if (this.oys != null) {
            C46084n c46084n = this.oys;
            if (!(c46084n.ozg == null || c46084n.ozh == null)) {
                c46084n.oyQ.setBounds(c46084n.ozg);
                c46084n.oyR.setBounds(c46084n.ozh);
                c46084n.oyV = -1.0f;
                c46084n.postInvalidate();
            }
        }
        AppMethodBeat.m2505o(55004);
    }

    public void setOnPreparedListener(C12576a c12576a) {
        this.oyp = c12576a;
    }

    public void setThumbBarSeekListener(C12577b c12577b) {
        this.oyq = c12577b;
    }

    public final float bQa() {
        AppMethodBeat.m2504i(55005);
        if (this.oys == null) {
            AppMethodBeat.m2505o(55005);
            return 0.0f;
        }
        C4990ab.m7411d("RecyclerThumbSeekBar", "computeStartPercent x : [%d] ret[%f] seekLoopStartTime[%d] durationMs[%d]", Integer.valueOf(this.oys.getLeftSliderBound()), Float.valueOf(r0), Integer.valueOf(Math.round(((float) this.fPW) * m77223Z(this.oys.getLeftSliderBound(), false))), Integer.valueOf(this.fPW));
        AppMethodBeat.m2505o(55005);
        return m77223Z(this.oys.getLeftSliderBound(), false);
    }

    public final float bQb() {
        AppMethodBeat.m2504i(55006);
        if (this.oys == null) {
            AppMethodBeat.m2505o(55006);
            return 0.0f;
        }
        C4990ab.m7411d("RecyclerThumbSeekBar", "computeEndPercent x : [%d] ret[%f] seekLoopEndTime[%d]", Integer.valueOf(this.oys.getRightSliderBound()), Float.valueOf(r0), Integer.valueOf(Math.round(((float) this.fPW) * m77223Z(this.oys.getRightSliderBound(), true))));
        AppMethodBeat.m2505o(55006);
        return m77223Z(this.oys.getRightSliderBound(), true);
    }

    /* renamed from: Z */
    private float m77223Z(int i, boolean z) {
        AppMethodBeat.m2504i(55007);
        if (this.oyr == null || this.iJP == null) {
            AppMethodBeat.m2505o(55007);
            return 0.0f;
        }
        View x = this.iJP.mo66441x((float) i, 0.0f);
        if (x == null) {
            C4990ab.m7421w("RecyclerThumbSeekBar", "getPositionInTotalRange x[%d] isEnd[%b], view is null.", Integer.valueOf(i), Boolean.valueOf(z));
            AppMethodBeat.m2505o(55007);
            return 0.0f;
        }
        int bo = RecyclerView.m72547bo(x);
        int itemCount = this.oyr.getItemCount();
        if (bo <= 1) {
            AppMethodBeat.m2505o(55007);
            return 0.0f;
        } else if (bo >= itemCount - 1) {
            AppMethodBeat.m2505o(55007);
            return 1.0f;
        } else {
            float left = (((float) (bo - 1)) + (((float) (i - x.getLeft())) / ((float) x.getWidth()))) / ((float) (itemCount - 2));
            AppMethodBeat.m2505o(55007);
            return left;
        }
    }

    /* renamed from: k */
    static /* synthetic */ void m77241k(RecyclerThumbSeekBar recyclerThumbSeekBar) {
        AppMethodBeat.m2504i(55009);
        C5004al.m7441d(new C345553());
        AppMethodBeat.m2505o(55009);
    }

    /* renamed from: e */
    static /* synthetic */ int m77233e(RecyclerThumbSeekBar recyclerThumbSeekBar, int i) {
        AppMethodBeat.m2504i(55010);
        IllegalStateException illegalStateException;
        if (recyclerThumbSeekBar.oyr == null) {
            illegalStateException = new IllegalStateException("recyclerAdapter is null");
            AppMethodBeat.m2505o(55010);
            throw illegalStateException;
        } else if (recyclerThumbSeekBar.fPW <= 0) {
            illegalStateException = new IllegalStateException("durationMs <= 0");
            AppMethodBeat.m2505o(55010);
            throw illegalStateException;
        } else {
            recyclerThumbSeekBar.oyr.getItemCount();
            int min = (int) ((Math.min(Math.max(0.0f, ((float) i) / ((float) recyclerThumbSeekBar.fPW)), 1.0f) * ((float) recyclerThumbSeekBar.fgJ)) * ((float) (recyclerThumbSeekBar.oyr.getItemCount() - 2)));
            AppMethodBeat.m2505o(55010);
            return min;
        }
    }
}
