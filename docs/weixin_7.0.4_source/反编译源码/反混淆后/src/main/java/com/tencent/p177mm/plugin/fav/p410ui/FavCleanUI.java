package com.tencent.p177mm.plugin.fav.p410ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C34126ak;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p407a.C43054d;
import com.tencent.p177mm.plugin.fav.p407a.C43054d.C27965a;
import com.tencent.p177mm.plugin.fav.p407a.C7604ae;
import com.tencent.p177mm.plugin.fav.p410ui.p1260a.C39056b;
import com.tencent.p177mm.plugin.fav.p410ui.p412d.C20714a.C20717c;
import com.tencent.p177mm.plugin.fav.p410ui.widget.C43087a;
import com.tencent.p177mm.plugin.fav.p410ui.widget.C43087a.C3110a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.fav.ui.FavCleanUI */
public class FavCleanUI extends MMActivity implements C20717c {
    protected C7306ak fbD = new C7306ak(Looper.getMainLooper());
    private HandlerThread mcx;
    protected C7306ak mcy;
    private Runnable mhC = new C279887();
    protected Runnable mhD = new C390428();
    private C45939l mhN;
    private C39056b mhO;
    private ListView mhP;
    private TextView mhQ;
    private C43087a mhR;
    private boolean mhS = false;
    private int mhT = 0;
    private C27965a mhU = new C390453();
    private C1202f mhV = new C118636();
    private boolean mho = false;
    protected boolean mhp = false;
    private long mhr = 0;
    protected View mhu;
    private View mhv;

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavCleanUI$4 */
    class C118624 implements OnItemClickListener {
        C118624() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(73952);
            if (FavCleanUI.this.mhO != null) {
                FavCleanUI.this.mhO.onItemClick(adapterView, view, i, j);
            }
            AppMethodBeat.m2505o(73952);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavCleanUI$6 */
    class C118636 implements C1202f {
        C118636() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(73958);
            C4990ab.m7416i("MicroMsg.FavCleanUI", "on getfavinfo scene end");
            if (FavCleanUI.this.mhR != null) {
                FavCleanUI.this.mhR.mpx = C39037b.buh();
            }
            AppMethodBeat.m2505o(73958);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavCleanUI$5 */
    class C279845 implements C3110a {

        /* renamed from: com.tencent.mm.plugin.fav.ui.FavCleanUI$5$1 */
        class C279851 implements OnClickListener {
            C279851() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(73956);
                long bwc = FavCleanUI.this.mhO.bwc();
                final List hk = FavCleanUI.this.mhO.mo61970hk(true);
                C43087a f = FavCleanUI.this.mhR;
                f.mpx += bwc;
                C39037b.m66399in(C39037b.buj() - bwc);
                if (hk.isEmpty()) {
                    AppMethodBeat.m2505o(73956);
                    return;
                }
                C7060h.pYm.mo8381e(14110, Integer.valueOf(FavCleanUI.this.mhT), Integer.valueOf(hk.size()), Integer.valueOf((int) ((((double) bwc) * 1.0d) / 1024.0d)));
                final C44275p b = C30379h.m48458b(FavCleanUI.this.mController.ylL, FavCleanUI.this.getString(C25738R.string.bnr), false, null);
                C1720g.m3539RS().mo10302aa(new Runnable() {

                    /* renamed from: com.tencent.mm.plugin.fav.ui.FavCleanUI$5$1$1$1 */
                    class C279871 implements Runnable {
                        C279871() {
                        }

                        public final void run() {
                            AppMethodBeat.m2504i(73953);
                            C39056b e = FavCleanUI.this.mhO;
                            List<C27966g> list = hk;
                            if (e.mld != null) {
                                ArrayList arrayList = new ArrayList();
                                for (C27966g c27966g : e.mld) {
                                    if (c27966g != null) {
                                        Object obj;
                                        for (C27966g c27966g2 : list) {
                                            if (c27966g2 != null && c27966g.field_localId == c27966g2.field_localId) {
                                                obj = 1;
                                                break;
                                            }
                                        }
                                        obj = null;
                                        if (obj == null) {
                                            arrayList.add(c27966g);
                                        }
                                    }
                                }
                                e.mld = arrayList;
                                arrayList = new ArrayList();
                                for (Long l : e.mlg) {
                                    Object obj2;
                                    for (C27966g c27966g3 : list) {
                                        if (c27966g3 != null && l.equals(Long.valueOf(c27966g3.field_localId))) {
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
                            AppMethodBeat.m2505o(73953);
                        }

                        public final String toString() {
                            AppMethodBeat.m2504i(73954);
                            String str = super.toString() + "|batchDelFavItems";
                            AppMethodBeat.m2505o(73954);
                            return str;
                        }
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(73955);
                        C39037b.m66377bJ(hk);
                        C5004al.m7441d(new C279871());
                        AppMethodBeat.m2505o(73955);
                    }
                });
                C7060h.pYm.mo8381e(11125, Integer.valueOf(hk.size()), Integer.valueOf(3));
                AppMethodBeat.m2505o(73956);
            }
        }

        C279845() {
        }

        public final void bvB() {
            AppMethodBeat.m2504i(73957);
            C30379h.m48440a(FavCleanUI.this.mController.ylL, FavCleanUI.this.getString(C25738R.string.bn6), "", new C279851(), null);
            AppMethodBeat.m2505o(73957);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavCleanUI$7 */
    class C279887 implements Runnable {
        C279887() {
        }

        public final void run() {
            AppMethodBeat.m2504i(73959);
            if (FavCleanUI.this.mhO != null) {
                FavCleanUI.this.mhO.bvX();
            }
            FavCleanUI.this.bvz();
            AppMethodBeat.m2505o(73959);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavCleanUI$8 */
    class C390428 implements Runnable {
        C390428() {
        }

        public final void run() {
            AppMethodBeat.m2504i(73960);
            if (FavCleanUI.this.mhO == null) {
                AppMethodBeat.m2505o(73960);
            } else if (FavCleanUI.this.mhO.isEmpty() || SystemClock.elapsedRealtime() - FavCleanUI.this.mhr >= 1000) {
                FavCleanUI.this.mho = false;
                FavCleanUI.this.mhr = SystemClock.elapsedRealtime();
                C4990ab.m7418v("MicroMsg.FavCleanUI", "do refresh job");
                FavCleanUI.m66443d(FavCleanUI.this);
                if (FavCleanUI.this.mhp) {
                    C4990ab.m7418v("MicroMsg.FavCleanUI", "do scroll to first");
                    FavCleanUI.this.mhP.setSelection(0);
                    FavCleanUI.this.mhp = false;
                }
                AppMethodBeat.m2505o(73960);
            } else {
                C4990ab.m7411d("MicroMsg.FavCleanUI", "try refresh, time limit, now %d last %d delay %d", Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(FavCleanUI.this.mhr), Integer.valueOf(1000));
                FavCleanUI.this.fbD.postDelayed(this, 500);
                AppMethodBeat.m2505o(73960);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavCleanUI$1 */
    class C390431 implements OnMenuItemClickListener {
        C390431() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(73949);
            FavCleanUI.this.finish();
            AppMethodBeat.m2505o(73949);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavCleanUI$2 */
    class C390442 implements OnScrollListener {
        C390442() {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.m2504i(73950);
            if (i == 0 && FavCleanUI.m66440a(FavCleanUI.this)) {
                C4990ab.m7416i("MicroMsg.FavCleanUI", "force bottom load data");
                FavCleanUI.m66441b(FavCleanUI.this);
            }
            AppMethodBeat.m2505o(73950);
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavCleanUI$3 */
    class C390453 implements C27965a {
        C390453() {
        }

        public final void onFinish() {
            AppMethodBeat.m2504i(73951);
            C4990ab.m7416i("MicroMsg.FavCleanUI", "FavCleanFirstLoader onRefreshed()");
            FavCleanUI.m66442c(FavCleanUI.this);
            FavCleanUI.m66443d(FavCleanUI.this);
            AppMethodBeat.m2505o(73951);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public FavCleanUI() {
        AppMethodBeat.m2504i(73961);
        AppMethodBeat.m2505o(73961);
    }

    public final int getLayoutId() {
        return 2130969493;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(73962);
        super.onCreate(bundle);
        this.mhT = getIntent().getIntExtra("key_enter_fav_cleanui_from", 0);
        this.mcx = C7305d.anM(getClass().getName() + "_handlerThread_" + System.currentTimeMillis());
        this.mcx.start();
        this.mcy = new C7306ak(this.mcx.getLooper());
        this.mhP = (ListView) findViewById(2131823882);
        setMMTitle((int) C25738R.string.bn_);
        this.mhS = true;
        C1720g.m3540Rg().mo14541a(new C34126ak(), 0);
        C1720g.m3540Rg().mo14539a(438, this.mhV);
        setBackBtn(new C390431());
        ViewStub viewStub = (ViewStub) findViewById(2131823883);
        if (viewStub != null) {
            this.mhv = viewStub.inflate();
        } else {
            this.mhv = findViewById(2131823610);
        }
        this.mhQ = (TextView) findViewById(2131823609);
        this.mhv.setVisibility(0);
        this.mhQ.setVisibility(8);
        this.mhP.removeFooterView(this.mhu);
        if (this.mhR != null) {
            this.mhR.hide();
        }
        this.mhu = C5616v.m8409hu(this).inflate(2130969518, null);
        this.mhP.setOnScrollListener(new C390442());
        if (this.mhS) {
            this.mhR = new C43087a();
            C43087a c43087a = this.mhR;
            View findViewById = findViewById(2131823879);
            c43087a.mpz = false;
            c43087a.mpA = findViewById;
            this.mhR.mpB = new C279845();
            this.mhS = false;
        }
        C43054d.bur().mo68585a(this.mhU);
        AppMethodBeat.m2505o(73962);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(73963);
        super.onDestroy();
        C43054d bur = C43054d.bur();
        C27965a c27965a = this.mhU;
        if (bur.meK.contains(c27965a)) {
            bur.meK.remove(c27965a);
        }
        if (this.mhN != null) {
            this.mhN.destory();
            this.mhN = null;
        }
        if (this.mhO != null) {
            this.mhO.finish();
        }
        this.mcx.quit();
        C1720g.m3540Rg().mo14546b(438, this.mhV);
        AppMethodBeat.m2505o(73963);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        AppMethodBeat.m2504i(73964);
        C4990ab.m7410d("MicroMsg.FavCleanUI", "on create options menu");
        boolean onCreateOptionsMenu = super.onCreateOptionsMenu(menu);
        AppMethodBeat.m2505o(73964);
        return onCreateOptionsMenu;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        AppMethodBeat.m2504i(73965);
        boolean onOptionsItemSelected = super.onOptionsItemSelected(menuItem);
        AppMethodBeat.m2505o(73965);
        return onOptionsItemSelected;
    }

    public void onResume() {
        AppMethodBeat.m2504i(73966);
        super.onResume();
        AppMethodBeat.m2505o(73966);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(73967);
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(73967);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bvz() {
        AppMethodBeat.m2504i(73968);
        C4990ab.m7416i("MicroMsg.FavCleanUI", "on storage change, try refresh job");
        this.fbD.removeCallbacks(this.mhD);
        this.fbD.post(this.mhD);
        AppMethodBeat.m2505o(73968);
    }

    /* renamed from: eY */
    private void m66445eY(boolean z) {
        AppMethodBeat.m2504i(73969);
        if (z) {
            this.mhv.setVisibility(8);
            this.mhQ.setVisibility(0);
            this.mhP.removeFooterView(this.mhu);
            if (this.mhR != null) {
                this.mhR.hide();
                AppMethodBeat.m2505o(73969);
                return;
            }
        }
        this.mhv.setVisibility(8);
        this.mhQ.setVisibility(8);
        this.mhP.removeFooterView(this.mhu);
        if (this.mhR != null) {
            this.mhR.show();
        }
        AppMethodBeat.m2505o(73969);
    }

    /* renamed from: hj */
    private void m66449hj(boolean z) {
        AppMethodBeat.m2504i(73970);
        if (!z) {
            this.mhP.removeFooterView(this.mhu);
        } else if (this.mhP.getFooterViewsCount() == 0) {
            this.mhP.addFooterView(this.mhu);
            AppMethodBeat.m2505o(73970);
            return;
        }
        AppMethodBeat.m2505o(73970);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(73971);
        finish();
        super.onBackPressed();
        AppMethodBeat.m2505o(73971);
    }

    /* renamed from: iI */
    public final void mo36019iI(long j) {
        AppMethodBeat.m2504i(73972);
        C27966g iE = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(j);
        if (!(iE == null || iE.field_favProto == null || iE.field_favProto.wiv.size() == 0)) {
            Iterator it = iE.field_favProto.wiv.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        if (this.mhO.mlp) {
            boolean z;
            C43087a c43087a = this.mhR;
            if (this.mhO.bwb() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (c43087a.mpz) {
                c43087a.gzI.setEnabled(z);
            }
            C43087a c43087a2 = this.mhR;
            List hk = this.mhO.mo61970hk(false);
            long bwc = this.mhO.bwc();
            if (hk.size() == 0 || bwc <= 0) {
                c43087a2.bwz();
            } else {
                c43087a2.kxJ.setText(c43087a2.kxJ.getContext().getString(C25738R.string.bn5, new Object[]{C39037b.m66407iv(bwc)}));
                c43087a2.gzI.setEnabled(true);
                AppMethodBeat.m2505o(73972);
                return;
            }
        }
        AppMethodBeat.m2505o(73972);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m66440a(FavCleanUI favCleanUI) {
        AppMethodBeat.m2504i(73973);
        if (favCleanUI.mhP.getChildAt(favCleanUI.mhP.getChildCount() - 1) == null || favCleanUI.mhP.getLastVisiblePosition() != favCleanUI.mhP.getAdapter().getCount() - 1) {
            AppMethodBeat.m2505o(73973);
            return false;
        }
        C4990ab.m7416i("MicroMsg.FavCleanUI", "at bottom call back");
        AppMethodBeat.m2505o(73973);
        return true;
    }

    /* renamed from: b */
    static /* synthetic */ void m66441b(FavCleanUI favCleanUI) {
        AppMethodBeat.m2504i(73974);
        C4990ab.m7418v("MicroMsg.FavCleanUI", "on pull down callback");
        if (favCleanUI.mhO.mlq) {
            C4990ab.m7416i("MicroMsg.FavCleanUI", "has shown all, do not load data");
            AppMethodBeat.m2505o(73974);
        } else if (favCleanUI.mho) {
            C4990ab.m7420w("MicroMsg.FavCleanUI", "onBottomLoadData loading, return");
            AppMethodBeat.m2505o(73974);
        } else {
            favCleanUI.mho = true;
            favCleanUI.m66449hj(true);
            C4990ab.m7416i("MicroMsg.FavCleanUI", "on bottom load data listener");
            favCleanUI.mcy.removeCallbacks(favCleanUI.mhC);
            favCleanUI.mcy.post(favCleanUI.mhC);
            AppMethodBeat.m2505o(73974);
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m66442c(FavCleanUI favCleanUI) {
        AppMethodBeat.m2504i(73975);
        favCleanUI.mhN = new C45939l(C4996ah.getContext(), 16);
        C4996ah.getContext();
        favCleanUI.mhO = new C39056b(favCleanUI.mhN, true);
        favCleanUI.mhO.mlo = favCleanUI;
        favCleanUI.mhP.setAdapter(favCleanUI.mhO);
        favCleanUI.mhP.setOnItemClickListener(new C118624());
        favCleanUI.mhP.setOnTouchListener(null);
        favCleanUI.mhP.setOnItemLongClickListener(null);
        AppMethodBeat.m2505o(73975);
    }

    /* renamed from: d */
    static /* synthetic */ void m66443d(FavCleanUI favCleanUI) {
        AppMethodBeat.m2504i(73976);
        favCleanUI.mhO.notifyDataSetChanged();
        if (favCleanUI.mhO.isEmpty()) {
            favCleanUI.m66445eY(true);
            if (8 != favCleanUI.mhP.getVisibility()) {
                favCleanUI.mhP.setVisibility(8);
            }
        } else {
            favCleanUI.m66445eY(false);
            if (favCleanUI.mhR != null) {
                favCleanUI.mhR.show();
            }
            if (favCleanUI.mhP.getVisibility() != 0) {
                favCleanUI.mhP.setVisibility(0);
            }
        }
        favCleanUI.m66449hj(false);
        AppMethodBeat.m2505o(73976);
    }
}
