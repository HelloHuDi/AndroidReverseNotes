package com.tencent.p177mm.plugin.fav.p410ui;

import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewStub;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.fav.p407a.C34126ak;
import com.tencent.p177mm.plugin.fav.p407a.C39036aj;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p407a.C7604ae;
import com.tencent.p177mm.plugin.fav.p410ui.p1260a.C34148a;
import com.tencent.p177mm.plugin.fav.p410ui.widget.C11919c;
import com.tencent.p177mm.plugin.fav.p410ui.widget.C11919c.C11922a;
import com.tencent.p177mm.pluginsdk.wallet.C14991i;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4978c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.fav.ui.FavBaseUI */
public abstract class FavBaseUI extends MMActivity implements OnItemClickListener {
    protected C7306ak fbD = new C7306ak(Looper.getMainLooper());
    private final Object lockObj = new Object();
    private HandlerThread mcx;
    protected C7306ak mcy;
    private C1202f mhA = new C341368();
    private C1202f mhB = new C341409();
    private Runnable mhC = new C3413310();
    protected Runnable mhD = new C3413411();
    private Runnable mhE = new C341382();
    private C4931a mhF = new C341393();
    private boolean mho = false;
    protected boolean mhp = false;
    private boolean mhq = false;
    private long mhr = 0;
    protected ListView mhs;
    protected TextView mht;
    protected View mhu;
    private View mhv;
    protected C11919c mhw;
    protected View mhx;
    protected C45939l mhy;
    protected C11922a mhz = null;

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavBaseUI$4 */
    class C206874 implements OnClickListener {
        C206874() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(73929);
            C4978c.m7375a(FavBaseUI.this.mhs);
            AppMethodBeat.m2505o(73929);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavBaseUI$5 */
    class C206885 implements OnScrollListener {
        C206885() {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.m2504i(73930);
            if (i == 0) {
                if (((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23695t(FavBaseUI.this.bvu().bvV(), FavBaseUI.this.bvu().getType())) {
                    C4990ab.m7418v("MicroMsg.FavoriteBaseUI", "has shown all, do not load data");
                    AppMethodBeat.m2505o(73930);
                    return;
                } else if (FavBaseUI.m55961a(FavBaseUI.this)) {
                    C4990ab.m7416i("MicroMsg.FavoriteBaseUI", "force bottom load data");
                    FavBaseUI.m55962b(FavBaseUI.this);
                }
            }
            AppMethodBeat.m2505o(73930);
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavBaseUI$6 */
    class C206896 implements OnTouchListener {
        C206896() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(73931);
            FavBaseUI.this.aqX();
            AppMethodBeat.m2505o(73931);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavBaseUI$10 */
    class C3413310 implements Runnable {
        C3413310() {
        }

        public final void run() {
            AppMethodBeat.m2504i(73935);
            C34148a bvu = FavBaseUI.this.bvu();
            bvu.bvX();
            bvu.bvY();
            FavBaseUI.this.bvz();
            AppMethodBeat.m2505o(73935);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavBaseUI$11 */
    class C3413411 implements Runnable {
        C3413411() {
        }

        public final void run() {
            AppMethodBeat.m2504i(73936);
            C34148a bvu = FavBaseUI.this.bvu();
            if (bvu.isEmpty() || SystemClock.elapsedRealtime() - FavBaseUI.this.mhr >= 400) {
                FavBaseUI.this.mho = false;
                FavBaseUI.this.mhr = SystemClock.elapsedRealtime();
                C4990ab.m7418v("MicroMsg.FavoriteBaseUI", "do refresh job");
                bvu.notifyDataSetChanged();
                FavBaseUI.this.mo54702a(bvu);
                if (FavBaseUI.this.mhp) {
                    C4990ab.m7418v("MicroMsg.FavoriteBaseUI", "do scroll to first");
                    FavBaseUI.this.mhs.setSelection(0);
                    FavBaseUI.this.mhp = false;
                }
                AppMethodBeat.m2505o(73936);
                return;
            }
            C4990ab.m7411d("MicroMsg.FavoriteBaseUI", "try refresh, time limit, now %d last %d delay %d", Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(FavBaseUI.this.mhr), Integer.valueOf(400));
            FavBaseUI.this.fbD.postDelayed(this, 200);
            AppMethodBeat.m2505o(73936);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavBaseUI$8 */
    class C341368 implements C1202f {
        C341368() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(73933);
            C4990ab.m7416i("MicroMsg.FavoriteBaseUI", "on fav sync end");
            if (((C39036aj) c1207m).mgl) {
                C4990ab.m7416i("MicroMsg.FavoriteBaseUI", "need batch get return");
                AppMethodBeat.m2505o(73933);
                return;
            }
            C4990ab.m7416i("MicroMsg.FavoriteBaseUI", "dismiss loading dialog");
            if (FavBaseUI.this.mhq) {
                FavBaseUI.this.mhq = false;
            }
            FavBaseUI.this.mo54704hh(false);
            FavBaseUI.this.bvz();
            AppMethodBeat.m2505o(73933);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavBaseUI$1 */
    class C341371 implements Runnable {
        C341371() {
        }

        public final void run() {
            AppMethodBeat.m2504i(73926);
            C39037b.buf();
            AppMethodBeat.m2505o(73926);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavBaseUI$2 */
    class C341382 implements Runnable {
        C341382() {
        }

        public final void run() {
            AppMethodBeat.m2504i(73927);
            synchronized (FavBaseUI.this.lockObj) {
                try {
                    FavBaseUI.this.bvv();
                    FavBaseUI.this.bvu().bvY();
                    FavBaseUI.this.bvz();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(73927);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavBaseUI$3 */
    class C341393 implements C4931a {
        long mhH = 0;

        C341393() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(73928);
            FavBaseUI.this.mcy.removeCallbacks(FavBaseUI.this.mhE);
            if (C5046bo.m7525az(this.mhH) > 200) {
                this.mhH = C5046bo.m7588yz();
                FavBaseUI.this.mcy.post(FavBaseUI.this.mhE);
                AppMethodBeat.m2505o(73928);
                return;
            }
            FavBaseUI.this.mcy.postDelayed(FavBaseUI.this.mhE, 200);
            AppMethodBeat.m2505o(73928);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavBaseUI$9 */
    class C341409 implements C1202f {
        C341409() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(73934);
            C4990ab.m7416i("MicroMsg.FavoriteBaseUI", "on batch get end");
            if (FavBaseUI.this.mhq) {
                C4990ab.m7416i("MicroMsg.FavoriteBaseUI", "init currently, dismiss dialog");
                FavBaseUI.this.mhq = false;
                FavBaseUI.this.mo54704hh(false);
            }
            AppMethodBeat.m2505o(73934);
        }
    }

    public abstract C34148a bvu();

    public abstract void bvv();

    public abstract boolean bvw();

    public abstract void bvx();

    public abstract OnClickListener bvy();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getLayoutId() {
        return 2130969535;
    }

    public void onCreate(Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        super.onCreate(bundle);
        C4990ab.m7417i("MicroMsg.FavoriteBaseUI", "onCreate MMCore.accHasReady[%b]", Boolean.valueOf(C1720g.m3531RK()));
        C1720g.m3540Rg().mo14541a(new C34126ak(), 0);
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo10116c(this.mhF);
        C1720g.m3540Rg().mo14539a(400, this.mhA);
        C1720g.m3540Rg().mo14539a(402, this.mhB);
        this.mcx = C7305d.anM(getClass().getName() + "_handlerThread_" + System.currentTimeMillis());
        this.mcx.start();
        this.mcy = new C7306ak(this.mcx.getLooper());
        this.mhy = new C45939l(this.mController.ylL, 64);
        initView();
        mo17446xE(this.mController.ylL.getResources().getColor(C25738R.color.f12206vy));
        if (C5046bo.m7567h((Integer) C1720g.m3536RP().mo5239Ry().get(8217, null)) == 0) {
            C4990ab.m7416i("MicroMsg.FavoriteBaseUI", "do init data for first time");
            this.mhq = true;
            C1720g.m3540Rg().mo14541a(new C39036aj(), 0);
            if (this.mhq) {
                C4990ab.m7416i("MicroMsg.FavoriteBaseUI", "show loading dialog");
                if (bvu() == null || bvu().isEmpty()) {
                    mo54704hh(true);
                }
                m55969hi(false);
            }
        } else {
            C39037b.startSync();
            if (bvu().isEmpty()) {
                mo54704hh(true);
                m55969hi(false);
                this.mhu.setVisibility(8);
            } else {
                mo54704hh(false);
                m55969hi(false);
            }
        }
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnService().run();
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getCheckCdnService().run();
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getSendService().run();
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getModService().run();
        C1720g.m3539RS().mo10302aa(new C341371());
        C4990ab.m7411d("MicroMsg.FavoriteBaseUI", "on create use %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    public void onResume() {
        super.onResume();
        C14991i.m23324Lt(5);
    }

    public void onPause() {
        super.onPause();
        bvu();
    }

    public void onDestroy() {
        super.onDestroy();
        if (((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().buR() != null) {
            this.mhy.destory();
            this.mhy = null;
            this.mcx.quit();
            ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo10117d(this.mhF);
            C1720g.m3540Rg().mo14546b(400, this.mhA);
            C1720g.m3540Rg().mo14546b(402, this.mhB);
        }
    }

    public final void initView() {
        long currentTimeMillis = System.currentTimeMillis();
        this.mhs = (ListView) findViewById(2131823990);
        this.mhs.setDrawingCacheEnabled(false);
        C206874 c206874 = new C206874();
        initHeaderView();
        this.mhu = C5616v.m8409hu(this).inflate(2130969518, null);
        this.mhs.setOnScrollListener(new C206885());
        this.mhs.setOnItemClickListener(this);
        this.mhs.setOnTouchListener(new C206896());
        this.mhs.setAdapter(bvu());
        mo54702a(bvu());
        C4990ab.m7411d("MicroMsg.FavoriteBaseUI", "init view use %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: hh */
    public final void mo54704hh(boolean z) {
        if (z) {
            if (this.mhv == null) {
                this.mhv = ((ViewStub) findViewById(2131823883)).inflate();
            }
            this.mhv.setVisibility(0);
        } else if (this.mhv != null) {
            this.mhv.setVisibility(8);
        }
    }

    /* renamed from: hi */
    private void m55969hi(boolean z) {
        if (z) {
            if (this.mht == null) {
                this.mht = (TextView) ((ViewStub) findViewById(2131823991)).inflate().findViewById(2131823609);
            }
            this.mht.setVisibility(0);
        } else if (this.mht != null) {
            this.mht.setVisibility(8);
        }
    }

    /* Access modifiers changed, original: protected */
    public void initHeaderView() {
        this.mhw = new C11919c(this.mController.ylL);
        this.mhw.setCleanFavSpace(this.mhz);
        this.mhw.mo23770hn(false);
        this.mhw.mpK.setVisibility(8);
        this.mhw.mpL.setVisibility(8);
        C4990ab.m7411d("MicroMsg.FavoriteBaseUI", "padding %s, %s", Integer.valueOf(this.mhw.getPaddingTop()), Integer.valueOf(this.mhw.getPaddingBottom()));
        this.mhs.addHeaderView(this.mhw);
        this.mhx = View.inflate(this.mController.ylL, 2130969532, null);
        TextView textView = (TextView) this.mhx.findViewById(2131823983);
        final TextView textView2 = (TextView) this.mhx.findViewById(2131823982);
        TextView textView3 = (TextView) this.mhx.findViewById(2131823987);
        TextView textView4 = (TextView) this.mhx.findViewById(2131823985);
        TextView textView5 = (TextView) this.mhx.findViewById(2131823989);
        TextView textView6 = (TextView) this.mhx.findViewById(2131823984);
        final TextView textView7 = (TextView) this.mhx.findViewById(2131823986);
        TextView textView8 = (TextView) this.mhx.findViewById(2131823988);
        OnClickListener bvy = bvy();
        textView.setOnClickListener(bvy);
        textView.setTag(Integer.valueOf(5));
        textView2.setOnClickListener(bvy);
        textView2.setTag(Integer.valueOf(21));
        textView3.setOnClickListener(bvy);
        textView3.setTag(Integer.valueOf(3));
        textView4.setOnClickListener(bvy);
        textView4.setTag(Integer.valueOf(7));
        textView5.setOnClickListener(bvy);
        textView5.setTag(Integer.valueOf(6));
        textView6.setOnClickListener(bvy);
        textView6.setTag(Integer.valueOf(8));
        textView7.setOnClickListener(bvy);
        textView7.setTag(Integer.valueOf(17));
        textView8.setOnClickListener(bvy);
        textView8.setTag(Integer.valueOf(18));
        this.mhx.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                AppMethodBeat.m2504i(73932);
                FavBaseUI.this.mhx.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                int width = FavBaseUI.this.mhx.findViewById(2131823981).getWidth() / 4;
                if (width > 0 && textView2.getWidth() < width) {
                    textView2.setWidth(width);
                    textView7.setWidth(width);
                }
                AppMethodBeat.m2505o(73932);
            }
        });
        this.mhs.addHeaderView(this.mhx);
    }

    /* Access modifiers changed, original: protected */
    public void bvz() {
        C4990ab.m7416i("MicroMsg.FavoriteBaseUI", "on storage change, try refresh job");
        this.fbD.removeCallbacks(this.mhD);
        this.fbD.post(this.mhD);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo54702a(C34148a c34148a) {
        if (c34148a == null) {
            C4990ab.m7420w("MicroMsg.FavoriteBaseUI", "handle empty view fail, adapter is null");
            return;
        }
        if (!c34148a.isEmpty()) {
            mo54704hh(false);
            m55969hi(false);
        } else if (bvw()) {
            mo54704hh(true);
            m55969hi(false);
        } else {
            mo54704hh(false);
            m55969hi(true);
            bvx();
        }
        if (c34148a.isEmpty() || ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23695t(c34148a.bvV(), c34148a.getType())) {
            this.mhs.removeFooterView(this.mhu);
        } else if (this.mhs.getFooterViewsCount() == 0) {
            this.mhs.addFooterView(this.mhu);
        }
    }

    /* renamed from: b */
    static /* synthetic */ boolean m55962b(FavBaseUI favBaseUI) {
        C4990ab.m7418v("MicroMsg.FavoriteBaseUI", "on pull down callback");
        if (!((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23695t(favBaseUI.bvu().bvV(), favBaseUI.bvu().getType())) {
            if (C39037b.buo()) {
                C4990ab.m7420w("MicroMsg.FavoriteBaseUI", "doing batchget, do not load data");
            } else if (favBaseUI.mho) {
                C4990ab.m7420w("MicroMsg.FavoriteBaseUI", "onBottomLoadData loading, return");
            } else {
                favBaseUI.mho = true;
                C4990ab.m7416i("MicroMsg.FavoriteBaseUI", "on bottom load data listener");
                favBaseUI.mcy.removeCallbacks(favBaseUI.mhC);
                favBaseUI.mcy.post(favBaseUI.mhC);
            }
        }
        return true;
    }
}
