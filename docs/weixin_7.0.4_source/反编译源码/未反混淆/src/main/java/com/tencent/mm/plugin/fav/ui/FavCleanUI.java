package com.tencent.mm.plugin.fav.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewStub;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.d;
import com.tencent.mm.plugin.fav.ui.a.b;
import com.tencent.mm.plugin.fav.ui.d.a.c;
import com.tencent.mm.plugin.fav.ui.widget.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FavCleanUI extends MMActivity implements c {
    protected ak fbD = new ak(Looper.getMainLooper());
    private HandlerThread mcx;
    protected ak mcy;
    private Runnable mhC = new Runnable() {
        public final void run() {
            AppMethodBeat.i(73959);
            if (FavCleanUI.this.mhO != null) {
                FavCleanUI.this.mhO.bvX();
            }
            FavCleanUI.this.bvz();
            AppMethodBeat.o(73959);
        }
    };
    protected Runnable mhD = new Runnable() {
        public final void run() {
            AppMethodBeat.i(73960);
            if (FavCleanUI.this.mhO == null) {
                AppMethodBeat.o(73960);
            } else if (FavCleanUI.this.mhO.isEmpty() || SystemClock.elapsedRealtime() - FavCleanUI.this.mhr >= 1000) {
                FavCleanUI.this.mho = false;
                FavCleanUI.this.mhr = SystemClock.elapsedRealtime();
                ab.v("MicroMsg.FavCleanUI", "do refresh job");
                FavCleanUI.d(FavCleanUI.this);
                if (FavCleanUI.this.mhp) {
                    ab.v("MicroMsg.FavCleanUI", "do scroll to first");
                    FavCleanUI.this.mhP.setSelection(0);
                    FavCleanUI.this.mhp = false;
                }
                AppMethodBeat.o(73960);
            } else {
                ab.d("MicroMsg.FavCleanUI", "try refresh, time limit, now %d last %d delay %d", Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(FavCleanUI.this.mhr), Integer.valueOf(1000));
                FavCleanUI.this.fbD.postDelayed(this, 500);
                AppMethodBeat.o(73960);
            }
        }
    };
    private l mhN;
    private b mhO;
    private ListView mhP;
    private TextView mhQ;
    private a mhR;
    private boolean mhS = false;
    private int mhT = 0;
    private d.a mhU = new d.a() {
        public final void onFinish() {
            AppMethodBeat.i(73951);
            ab.i("MicroMsg.FavCleanUI", "FavCleanFirstLoader onRefreshed()");
            FavCleanUI.c(FavCleanUI.this);
            FavCleanUI.d(FavCleanUI.this);
            AppMethodBeat.o(73951);
        }
    };
    private f mhV = new f() {
        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(73958);
            ab.i("MicroMsg.FavCleanUI", "on getfavinfo scene end");
            if (FavCleanUI.this.mhR != null) {
                FavCleanUI.this.mhR.mpx = com.tencent.mm.plugin.fav.a.b.buh();
            }
            AppMethodBeat.o(73958);
        }
    };
    private boolean mho = false;
    protected boolean mhp = false;
    private long mhr = 0;
    protected View mhu;
    private View mhv;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FavCleanUI() {
        AppMethodBeat.i(73961);
        AppMethodBeat.o(73961);
    }

    public final int getLayoutId() {
        return R.layout.y1;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(73962);
        super.onCreate(bundle);
        this.mhT = getIntent().getIntExtra("key_enter_fav_cleanui_from", 0);
        this.mcx = com.tencent.mm.sdk.g.d.anM(getClass().getName() + "_handlerThread_" + System.currentTimeMillis());
        this.mcx.start();
        this.mcy = new ak(this.mcx.getLooper());
        this.mhP = (ListView) findViewById(R.id.bp8);
        setMMTitle((int) R.string.bn_);
        this.mhS = true;
        g.Rg().a(new com.tencent.mm.plugin.fav.a.ak(), 0);
        g.Rg().a(438, this.mhV);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(73949);
                FavCleanUI.this.finish();
                AppMethodBeat.o(73949);
                return true;
            }
        });
        ViewStub viewStub = (ViewStub) findViewById(R.id.bp9);
        if (viewStub != null) {
            this.mhv = viewStub.inflate();
        } else {
            this.mhv = findViewById(R.id.bhv);
        }
        this.mhQ = (TextView) findViewById(R.id.bhu);
        this.mhv.setVisibility(0);
        this.mhQ.setVisibility(8);
        this.mhP.removeFooterView(this.mhu);
        if (this.mhR != null) {
            this.mhR.hide();
        }
        this.mhu = v.hu(this).inflate(R.layout.yp, null);
        this.mhP.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
                AppMethodBeat.i(73950);
                if (i == 0 && FavCleanUI.a(FavCleanUI.this)) {
                    ab.i("MicroMsg.FavCleanUI", "force bottom load data");
                    FavCleanUI.b(FavCleanUI.this);
                }
                AppMethodBeat.o(73950);
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        if (this.mhS) {
            this.mhR = new a();
            a aVar = this.mhR;
            View findViewById = findViewById(R.id.bp5);
            aVar.mpz = false;
            aVar.mpA = findViewById;
            this.mhR.mpB = new a.a() {
                public final void bvB() {
                    AppMethodBeat.i(73957);
                    h.a(FavCleanUI.this.mController.ylL, FavCleanUI.this.getString(R.string.bn6), "", new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(73956);
                            long bwc = FavCleanUI.this.mhO.bwc();
                            final List hk = FavCleanUI.this.mhO.hk(true);
                            a f = FavCleanUI.this.mhR;
                            f.mpx += bwc;
                            com.tencent.mm.plugin.fav.a.b.in(com.tencent.mm.plugin.fav.a.b.buj() - bwc);
                            if (hk.isEmpty()) {
                                AppMethodBeat.o(73956);
                                return;
                            }
                            com.tencent.mm.plugin.report.service.h.pYm.e(14110, Integer.valueOf(FavCleanUI.this.mhT), Integer.valueOf(hk.size()), Integer.valueOf((int) ((((double) bwc) * 1.0d) / 1024.0d)));
                            final p b = h.b(FavCleanUI.this.mController.ylL, FavCleanUI.this.getString(R.string.bnr), false, null);
                            g.RS().aa(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(73955);
                                    com.tencent.mm.plugin.fav.a.b.bJ(hk);
                                    al.d(new Runnable() {
                                        public final void run() {
                                            AppMethodBeat.i(73953);
                                            b e = FavCleanUI.this.mhO;
                                            List<com.tencent.mm.plugin.fav.a.g> list = hk;
                                            if (e.mld != null) {
                                                ArrayList arrayList = new ArrayList();
                                                for (com.tencent.mm.plugin.fav.a.g gVar : e.mld) {
                                                    if (gVar != null) {
                                                        Object obj;
                                                        for (com.tencent.mm.plugin.fav.a.g gVar2 : list) {
                                                            if (gVar2 != null && gVar.field_localId == gVar2.field_localId) {
                                                                obj = 1;
                                                                break;
                                                            }
                                                        }
                                                        obj = null;
                                                        if (obj == null) {
                                                            arrayList.add(gVar);
                                                        }
                                                    }
                                                }
                                                e.mld = arrayList;
                                                arrayList = new ArrayList();
                                                for (Long l : e.mlg) {
                                                    Object obj2;
                                                    for (com.tencent.mm.plugin.fav.a.g gVar3 : list) {
                                                        if (gVar3 != null && l.equals(Long.valueOf(gVar3.field_localId))) {
                                                            obj2 = 1;
                                                            break;
                                                        }
                                                    }
                                                    obj2 = null;
                                                    if (obj2 == null) {
                                                        arrayList.add(l);
                                                    }
                                                }
                                                e.mlg = arrayList;
                                            }
                                            FavCleanUI.this.mhO.notifyDataSetChanged();
                                            FavCleanUI.this.mhR.bwz();
                                            b.dismiss();
                                            AppMethodBeat.o(73953);
                                        }

                                        public final String toString() {
                                            AppMethodBeat.i(73954);
                                            String str = super.toString() + "|batchDelFavItems";
                                            AppMethodBeat.o(73954);
                                            return str;
                                        }
                                    });
                                    AppMethodBeat.o(73955);
                                }
                            });
                            com.tencent.mm.plugin.report.service.h.pYm.e(11125, Integer.valueOf(hk.size()), Integer.valueOf(3));
                            AppMethodBeat.o(73956);
                        }
                    }, null);
                    AppMethodBeat.o(73957);
                }
            };
            this.mhS = false;
        }
        d.bur().a(this.mhU);
        AppMethodBeat.o(73962);
    }

    public void onDestroy() {
        AppMethodBeat.i(73963);
        super.onDestroy();
        d bur = d.bur();
        d.a aVar = this.mhU;
        if (bur.meK.contains(aVar)) {
            bur.meK.remove(aVar);
        }
        if (this.mhN != null) {
            this.mhN.destory();
            this.mhN = null;
        }
        if (this.mhO != null) {
            this.mhO.finish();
        }
        this.mcx.quit();
        g.Rg().b(438, this.mhV);
        AppMethodBeat.o(73963);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        AppMethodBeat.i(73964);
        ab.d("MicroMsg.FavCleanUI", "on create options menu");
        boolean onCreateOptionsMenu = super.onCreateOptionsMenu(menu);
        AppMethodBeat.o(73964);
        return onCreateOptionsMenu;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        AppMethodBeat.i(73965);
        boolean onOptionsItemSelected = super.onOptionsItemSelected(menuItem);
        AppMethodBeat.o(73965);
        return onOptionsItemSelected;
    }

    public void onResume() {
        AppMethodBeat.i(73966);
        super.onResume();
        AppMethodBeat.o(73966);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(73967);
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(73967);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bvz() {
        AppMethodBeat.i(73968);
        ab.i("MicroMsg.FavCleanUI", "on storage change, try refresh job");
        this.fbD.removeCallbacks(this.mhD);
        this.fbD.post(this.mhD);
        AppMethodBeat.o(73968);
    }

    private void eY(boolean z) {
        AppMethodBeat.i(73969);
        if (z) {
            this.mhv.setVisibility(8);
            this.mhQ.setVisibility(0);
            this.mhP.removeFooterView(this.mhu);
            if (this.mhR != null) {
                this.mhR.hide();
                AppMethodBeat.o(73969);
                return;
            }
        }
        this.mhv.setVisibility(8);
        this.mhQ.setVisibility(8);
        this.mhP.removeFooterView(this.mhu);
        if (this.mhR != null) {
            this.mhR.show();
        }
        AppMethodBeat.o(73969);
    }

    private void hj(boolean z) {
        AppMethodBeat.i(73970);
        if (!z) {
            this.mhP.removeFooterView(this.mhu);
        } else if (this.mhP.getFooterViewsCount() == 0) {
            this.mhP.addFooterView(this.mhu);
            AppMethodBeat.o(73970);
            return;
        }
        AppMethodBeat.o(73970);
    }

    public void onBackPressed() {
        AppMethodBeat.i(73971);
        finish();
        super.onBackPressed();
        AppMethodBeat.o(73971);
    }

    public final void iI(long j) {
        AppMethodBeat.i(73972);
        com.tencent.mm.plugin.fav.a.g iE = ((ae) g.M(ae.class)).getFavItemInfoStorage().iE(j);
        if (!(iE == null || iE.field_favProto == null || iE.field_favProto.wiv.size() == 0)) {
            Iterator it = iE.field_favProto.wiv.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        if (this.mhO.mlp) {
            boolean z;
            a aVar = this.mhR;
            if (this.mhO.bwb() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (aVar.mpz) {
                aVar.gzI.setEnabled(z);
            }
            a aVar2 = this.mhR;
            List hk = this.mhO.hk(false);
            long bwc = this.mhO.bwc();
            if (hk.size() == 0 || bwc <= 0) {
                aVar2.bwz();
            } else {
                aVar2.kxJ.setText(aVar2.kxJ.getContext().getString(R.string.bn5, new Object[]{com.tencent.mm.plugin.fav.a.b.iv(bwc)}));
                aVar2.gzI.setEnabled(true);
                AppMethodBeat.o(73972);
                return;
            }
        }
        AppMethodBeat.o(73972);
    }

    static /* synthetic */ boolean a(FavCleanUI favCleanUI) {
        AppMethodBeat.i(73973);
        if (favCleanUI.mhP.getChildAt(favCleanUI.mhP.getChildCount() - 1) == null || favCleanUI.mhP.getLastVisiblePosition() != favCleanUI.mhP.getAdapter().getCount() - 1) {
            AppMethodBeat.o(73973);
            return false;
        }
        ab.i("MicroMsg.FavCleanUI", "at bottom call back");
        AppMethodBeat.o(73973);
        return true;
    }

    static /* synthetic */ void b(FavCleanUI favCleanUI) {
        AppMethodBeat.i(73974);
        ab.v("MicroMsg.FavCleanUI", "on pull down callback");
        if (favCleanUI.mhO.mlq) {
            ab.i("MicroMsg.FavCleanUI", "has shown all, do not load data");
            AppMethodBeat.o(73974);
        } else if (favCleanUI.mho) {
            ab.w("MicroMsg.FavCleanUI", "onBottomLoadData loading, return");
            AppMethodBeat.o(73974);
        } else {
            favCleanUI.mho = true;
            favCleanUI.hj(true);
            ab.i("MicroMsg.FavCleanUI", "on bottom load data listener");
            favCleanUI.mcy.removeCallbacks(favCleanUI.mhC);
            favCleanUI.mcy.post(favCleanUI.mhC);
            AppMethodBeat.o(73974);
        }
    }

    static /* synthetic */ void c(FavCleanUI favCleanUI) {
        AppMethodBeat.i(73975);
        favCleanUI.mhN = new l(ah.getContext(), 16);
        ah.getContext();
        favCleanUI.mhO = new b(favCleanUI.mhN, true);
        favCleanUI.mhO.mlo = favCleanUI;
        favCleanUI.mhP.setAdapter(favCleanUI.mhO);
        favCleanUI.mhP.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(73952);
                if (FavCleanUI.this.mhO != null) {
                    FavCleanUI.this.mhO.onItemClick(adapterView, view, i, j);
                }
                AppMethodBeat.o(73952);
            }
        });
        favCleanUI.mhP.setOnTouchListener(null);
        favCleanUI.mhP.setOnItemLongClickListener(null);
        AppMethodBeat.o(73975);
    }

    static /* synthetic */ void d(FavCleanUI favCleanUI) {
        AppMethodBeat.i(73976);
        favCleanUI.mhO.notifyDataSetChanged();
        if (favCleanUI.mhO.isEmpty()) {
            favCleanUI.eY(true);
            if (8 != favCleanUI.mhP.getVisibility()) {
                favCleanUI.mhP.setVisibility(8);
            }
        } else {
            favCleanUI.eY(false);
            if (favCleanUI.mhR != null) {
                favCleanUI.mhR.show();
            }
            if (favCleanUI.mhP.getVisibility() != 0) {
                favCleanUI.mhP.setVisibility(0);
            }
        }
        favCleanUI.hj(false);
        AppMethodBeat.o(73976);
    }
}
