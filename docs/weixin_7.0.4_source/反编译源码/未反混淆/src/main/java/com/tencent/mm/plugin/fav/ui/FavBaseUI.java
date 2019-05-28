package com.tencent.mm.plugin.fav.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.aj;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.ui.a.a;
import com.tencent.mm.plugin.fav.ui.widget.c;
import com.tencent.mm.pluginsdk.wallet.i;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.v;

public abstract class FavBaseUI extends MMActivity implements OnItemClickListener {
    protected ak fbD = new ak(Looper.getMainLooper());
    private final Object lockObj = new Object();
    private HandlerThread mcx;
    protected ak mcy;
    private f mhA = new f() {
        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(73933);
            ab.i("MicroMsg.FavoriteBaseUI", "on fav sync end");
            if (((aj) mVar).mgl) {
                ab.i("MicroMsg.FavoriteBaseUI", "need batch get return");
                AppMethodBeat.o(73933);
                return;
            }
            ab.i("MicroMsg.FavoriteBaseUI", "dismiss loading dialog");
            if (FavBaseUI.this.mhq) {
                FavBaseUI.this.mhq = false;
            }
            FavBaseUI.this.hh(false);
            FavBaseUI.this.bvz();
            AppMethodBeat.o(73933);
        }
    };
    private f mhB = new f() {
        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(73934);
            ab.i("MicroMsg.FavoriteBaseUI", "on batch get end");
            if (FavBaseUI.this.mhq) {
                ab.i("MicroMsg.FavoriteBaseUI", "init currently, dismiss dialog");
                FavBaseUI.this.mhq = false;
                FavBaseUI.this.hh(false);
            }
            AppMethodBeat.o(73934);
        }
    };
    private Runnable mhC = new Runnable() {
        public final void run() {
            AppMethodBeat.i(73935);
            a bvu = FavBaseUI.this.bvu();
            bvu.bvX();
            bvu.bvY();
            FavBaseUI.this.bvz();
            AppMethodBeat.o(73935);
        }
    };
    protected Runnable mhD = new Runnable() {
        public final void run() {
            AppMethodBeat.i(73936);
            a bvu = FavBaseUI.this.bvu();
            if (bvu.isEmpty() || SystemClock.elapsedRealtime() - FavBaseUI.this.mhr >= 400) {
                FavBaseUI.this.mho = false;
                FavBaseUI.this.mhr = SystemClock.elapsedRealtime();
                ab.v("MicroMsg.FavoriteBaseUI", "do refresh job");
                bvu.notifyDataSetChanged();
                FavBaseUI.this.a(bvu);
                if (FavBaseUI.this.mhp) {
                    ab.v("MicroMsg.FavoriteBaseUI", "do scroll to first");
                    FavBaseUI.this.mhs.setSelection(0);
                    FavBaseUI.this.mhp = false;
                }
                AppMethodBeat.o(73936);
                return;
            }
            ab.d("MicroMsg.FavoriteBaseUI", "try refresh, time limit, now %d last %d delay %d", Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(FavBaseUI.this.mhr), Integer.valueOf(400));
            FavBaseUI.this.fbD.postDelayed(this, 200);
            AppMethodBeat.o(73936);
        }
    };
    private Runnable mhE = new Runnable() {
        public final void run() {
            AppMethodBeat.i(73927);
            synchronized (FavBaseUI.this.lockObj) {
                try {
                    FavBaseUI.this.bvv();
                    FavBaseUI.this.bvu().bvY();
                    FavBaseUI.this.bvz();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(73927);
                }
            }
        }
    };
    private k.a mhF = new k.a() {
        long mhH = 0;

        public final void a(String str, com.tencent.mm.sdk.e.m mVar) {
            AppMethodBeat.i(73928);
            FavBaseUI.this.mcy.removeCallbacks(FavBaseUI.this.mhE);
            if (bo.az(this.mhH) > 200) {
                this.mhH = bo.yz();
                FavBaseUI.this.mcy.post(FavBaseUI.this.mhE);
                AppMethodBeat.o(73928);
                return;
            }
            FavBaseUI.this.mcy.postDelayed(FavBaseUI.this.mhE, 200);
            AppMethodBeat.o(73928);
        }
    };
    private boolean mho = false;
    protected boolean mhp = false;
    private boolean mhq = false;
    private long mhr = 0;
    protected ListView mhs;
    protected TextView mht;
    protected View mhu;
    private View mhv;
    protected c mhw;
    protected View mhx;
    protected l mhy;
    protected c.a mhz = null;

    public abstract a bvu();

    public abstract void bvv();

    public abstract boolean bvw();

    public abstract void bvx();

    public abstract OnClickListener bvy();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getLayoutId() {
        return R.layout.z6;
    }

    public void onCreate(Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        super.onCreate(bundle);
        ab.i("MicroMsg.FavoriteBaseUI", "onCreate MMCore.accHasReady[%b]", Boolean.valueOf(g.RK()));
        g.Rg().a(new com.tencent.mm.plugin.fav.a.ak(), 0);
        ((ae) g.M(ae.class)).getFavItemInfoStorage().c(this.mhF);
        g.Rg().a(400, this.mhA);
        g.Rg().a(402, this.mhB);
        this.mcx = d.anM(getClass().getName() + "_handlerThread_" + System.currentTimeMillis());
        this.mcx.start();
        this.mcy = new ak(this.mcx.getLooper());
        this.mhy = new l(this.mController.ylL, 64);
        initView();
        xE(this.mController.ylL.getResources().getColor(R.color.vy));
        if (bo.h((Integer) g.RP().Ry().get(8217, null)) == 0) {
            ab.i("MicroMsg.FavoriteBaseUI", "do init data for first time");
            this.mhq = true;
            g.Rg().a(new aj(), 0);
            if (this.mhq) {
                ab.i("MicroMsg.FavoriteBaseUI", "show loading dialog");
                if (bvu() == null || bvu().isEmpty()) {
                    hh(true);
                }
                hi(false);
            }
        } else {
            b.startSync();
            if (bvu().isEmpty()) {
                hh(true);
                hi(false);
                this.mhu.setVisibility(8);
            } else {
                hh(false);
                hi(false);
            }
        }
        ((ae) g.M(ae.class)).getFavCdnService().run();
        ((ae) g.M(ae.class)).getCheckCdnService().run();
        ((ae) g.M(ae.class)).getSendService().run();
        ((ae) g.M(ae.class)).getModService().run();
        g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(73926);
                b.buf();
                AppMethodBeat.o(73926);
            }
        });
        ab.d("MicroMsg.FavoriteBaseUI", "on create use %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    public void onResume() {
        super.onResume();
        i.Lt(5);
    }

    public void onPause() {
        super.onPause();
        bvu();
    }

    public void onDestroy() {
        super.onDestroy();
        if (((ae) g.M(ae.class)).getFavItemInfoStorage().buR() != null) {
            this.mhy.destory();
            this.mhy = null;
            this.mcx.quit();
            ((ae) g.M(ae.class)).getFavItemInfoStorage().d(this.mhF);
            g.Rg().b(400, this.mhA);
            g.Rg().b(402, this.mhB);
        }
    }

    public final void initView() {
        long currentTimeMillis = System.currentTimeMillis();
        this.mhs = (ListView) findViewById(R.id.bs5);
        this.mhs.setDrawingCacheEnabled(false);
        AnonymousClass4 anonymousClass4 = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(73929);
                BackwardSupportUtil.c.a(FavBaseUI.this.mhs);
                AppMethodBeat.o(73929);
            }
        };
        initHeaderView();
        this.mhu = v.hu(this).inflate(R.layout.yp, null);
        this.mhs.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
                AppMethodBeat.i(73930);
                if (i == 0) {
                    if (((ae) g.M(ae.class)).getFavItemInfoStorage().t(FavBaseUI.this.bvu().bvV(), FavBaseUI.this.bvu().getType())) {
                        ab.v("MicroMsg.FavoriteBaseUI", "has shown all, do not load data");
                        AppMethodBeat.o(73930);
                        return;
                    } else if (FavBaseUI.a(FavBaseUI.this)) {
                        ab.i("MicroMsg.FavoriteBaseUI", "force bottom load data");
                        FavBaseUI.b(FavBaseUI.this);
                    }
                }
                AppMethodBeat.o(73930);
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.mhs.setOnItemClickListener(this);
        this.mhs.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(73931);
                FavBaseUI.this.aqX();
                AppMethodBeat.o(73931);
                return false;
            }
        });
        this.mhs.setAdapter(bvu());
        a(bvu());
        ab.d("MicroMsg.FavoriteBaseUI", "init view use %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    /* Access modifiers changed, original: protected|final */
    public final void hh(boolean z) {
        if (z) {
            if (this.mhv == null) {
                this.mhv = ((ViewStub) findViewById(R.id.bp9)).inflate();
            }
            this.mhv.setVisibility(0);
        } else if (this.mhv != null) {
            this.mhv.setVisibility(8);
        }
    }

    private void hi(boolean z) {
        if (z) {
            if (this.mht == null) {
                this.mht = (TextView) ((ViewStub) findViewById(R.id.bs6)).inflate().findViewById(R.id.bhu);
            }
            this.mht.setVisibility(0);
        } else if (this.mht != null) {
            this.mht.setVisibility(8);
        }
    }

    /* Access modifiers changed, original: protected */
    public void initHeaderView() {
        this.mhw = new c(this.mController.ylL);
        this.mhw.setCleanFavSpace(this.mhz);
        this.mhw.hn(false);
        this.mhw.mpK.setVisibility(8);
        this.mhw.mpL.setVisibility(8);
        ab.d("MicroMsg.FavoriteBaseUI", "padding %s, %s", Integer.valueOf(this.mhw.getPaddingTop()), Integer.valueOf(this.mhw.getPaddingBottom()));
        this.mhs.addHeaderView(this.mhw);
        this.mhx = View.inflate(this.mController.ylL, R.layout.z3, null);
        TextView textView = (TextView) this.mhx.findViewById(R.id.bry);
        final TextView textView2 = (TextView) this.mhx.findViewById(R.id.brx);
        TextView textView3 = (TextView) this.mhx.findViewById(R.id.bs2);
        TextView textView4 = (TextView) this.mhx.findViewById(R.id.bs0);
        TextView textView5 = (TextView) this.mhx.findViewById(R.id.bs4);
        TextView textView6 = (TextView) this.mhx.findViewById(R.id.brz);
        final TextView textView7 = (TextView) this.mhx.findViewById(R.id.bs1);
        TextView textView8 = (TextView) this.mhx.findViewById(R.id.bs3);
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
                AppMethodBeat.i(73932);
                FavBaseUI.this.mhx.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                int width = FavBaseUI.this.mhx.findViewById(R.id.brw).getWidth() / 4;
                if (width > 0 && textView2.getWidth() < width) {
                    textView2.setWidth(width);
                    textView7.setWidth(width);
                }
                AppMethodBeat.o(73932);
            }
        });
        this.mhs.addHeaderView(this.mhx);
    }

    /* Access modifiers changed, original: protected */
    public void bvz() {
        ab.i("MicroMsg.FavoriteBaseUI", "on storage change, try refresh job");
        this.fbD.removeCallbacks(this.mhD);
        this.fbD.post(this.mhD);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(a aVar) {
        if (aVar == null) {
            ab.w("MicroMsg.FavoriteBaseUI", "handle empty view fail, adapter is null");
            return;
        }
        if (!aVar.isEmpty()) {
            hh(false);
            hi(false);
        } else if (bvw()) {
            hh(true);
            hi(false);
        } else {
            hh(false);
            hi(true);
            bvx();
        }
        if (aVar.isEmpty() || ((ae) g.M(ae.class)).getFavItemInfoStorage().t(aVar.bvV(), aVar.getType())) {
            this.mhs.removeFooterView(this.mhu);
        } else if (this.mhs.getFooterViewsCount() == 0) {
            this.mhs.addFooterView(this.mhu);
        }
    }

    static /* synthetic */ boolean b(FavBaseUI favBaseUI) {
        ab.v("MicroMsg.FavoriteBaseUI", "on pull down callback");
        if (!((ae) g.M(ae.class)).getFavItemInfoStorage().t(favBaseUI.bvu().bvV(), favBaseUI.bvu().getType())) {
            if (b.buo()) {
                ab.w("MicroMsg.FavoriteBaseUI", "doing batchget, do not load data");
            } else if (favBaseUI.mho) {
                ab.w("MicroMsg.FavoriteBaseUI", "onBottomLoadData loading, return");
            } else {
                favBaseUI.mho = true;
                ab.i("MicroMsg.FavoriteBaseUI", "on bottom load data listener");
                favBaseUI.mcy.removeCallbacks(favBaseUI.mhC);
                favBaseUI.mcy.post(favBaseUI.mhC);
            }
        }
        return true;
    }
}
