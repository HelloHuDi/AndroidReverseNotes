package com.tencent.p177mm.plugin.fav.p410ui.detail;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelstat.C18691f;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.widget.MMLoadScrollView;
import com.tencent.p177mm.p612ui.widget.MMLoadScrollView.C36354a;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C27968h;
import com.tencent.p177mm.plugin.fav.p407a.C27968h.C27969a;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p407a.C7604ae;
import com.tencent.p177mm.plugin.fav.p410ui.C45932c;
import com.tencent.p177mm.plugin.fav.p410ui.widget.FavDetailScrollView;
import com.tencent.p177mm.plugin.fav.p410ui.widget.FavDetailScrollView.C36774a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI */
public abstract class BaseFavDetailReportUI extends MMActivity {
    protected boolean mlA;
    private String mlB = null;
    public C27969a mlz = new C27969a();

    /* renamed from: com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI$2 */
    class C30872 implements C36774a {
        C30872() {
        }

        public final void bwe() {
            AppMethodBeat.m2504i(74317);
            BaseFavDetailReportUI.this.dyc();
            AppMethodBeat.m2505o(74317);
        }

        public final void bwf() {
            AppMethodBeat.m2504i(74318);
            BaseFavDetailReportUI.this.dyb();
            AppMethodBeat.m2505o(74318);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI$3 */
    class C30883 implements Runnable {
        C30883() {
        }

        public final void run() {
            AppMethodBeat.m2504i(74319);
            BaseFavDetailReportUI.this.mlz.mff = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23698vz((int) BaseFavDetailReportUI.this.mlz.meT) + 1;
            C27968h.m44526a(BaseFavDetailReportUI.this.mlz);
            AppMethodBeat.m2505o(74319);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI$1 */
    class C341651 implements C36354a {
        C341651() {
        }

        public final void bmh() {
            BaseFavDetailReportUI.this.mlz.mfe = true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mlz.scene = getIntent().getIntExtra("key_detail_fav_scene", 0);
        this.mlz.jSW = getIntent().getIntExtra("key_detail_fav_sub_scene", 0);
        this.mlz.index = getIntent().getIntExtra("key_detail_fav_index", 0);
        this.mlz.query = getIntent().getStringExtra("key_detail_fav_query");
        this.mlz.sid = getIntent().getStringExtra("key_detail_fav_sessionid");
        this.mlz.mfg = getIntent().getStringExtra("key_detail_fav_tags");
        this.mlz.query = this.mlz.query == null ? "" : this.mlz.query;
        this.mlz.sid = this.mlz.sid == null ? "" : this.mlz.sid;
        this.mlz.mfg = this.mlz.mfg == null ? "" : this.mlz.mfg;
        MMLoadScrollView bwd = bwd();
        if (bwd != null) {
            bwd.setOnTopOrBottomListerner(new C341651());
            if (bwd instanceof FavDetailScrollView) {
                ((FavDetailScrollView) bwd).setOnScrollChangeListener(new C30872());
            }
        }
        if (this.mlz.scene == 0) {
            C4990ab.m7416i("MicroMsg.Fav.BaseFavDetailReportUI", "report object scene is 0");
        }
        mo17446xE(this.mController.ylL.getResources().getColor(C25738R.color.f11705e5));
        dyb();
    }

    /* Access modifiers changed, original: protected */
    public MMLoadScrollView bwd() {
        return null;
    }

    public void onResume() {
        super.onResume();
        if (C5046bo.isNullOrNil(this.mlB)) {
            this.mlB = C18691f.akh().fSS;
        }
        C4990ab.m7419v("MicroMsg.Fav.BaseFavDetailReportUI", "onResume firstResumeClassname[%s]", this.mlB);
    }

    public void onPause() {
        this.mlz.meV = dyi();
        String str = C18691f.akh().fSS;
        if (!(C5046bo.isEqual(getClass().getName(), str) || C5046bo.isEqual(str, this.mlB))) {
            long longValue;
            C27969a c27969a = this.mlz;
            long j = c27969a.meW;
            C18691f akh = C18691f.akh();
            String str2 = C18691f.akh().fSS;
            if (akh.fSR != null) {
                longValue = ((Long) akh.fSR.get(str2)).longValue();
            } else {
                longValue = 0;
            }
            c27969a.meW = longValue + j;
        }
        C4990ab.m7419v("MicroMsg.Fav.BaseFavDetailReportUI", "onPause lastClassname[%s] detailPeriod[%d] subDetailPeriod[%d]", str, Long.valueOf(this.mlz.meV), Long.valueOf(this.mlz.meW));
        super.onPause();
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: F */
    public final void mo54744F(C27966g c27966g) {
        if (c27966g != null && this.mlz.scene > 0) {
            this.mlz.meT = (long) c27966g.field_id;
            this.mlz.type = c27966g.field_type;
            this.mlz.cvd = c27966g.field_sourceType;
            this.mlz.timestamp = c27966g.field_sourceCreateTime / 1000;
            if (this.mlz.timestamp == 0) {
                this.mlz.timestamp = c27966g.field_updateTime / 1000;
            }
            if (this.mlz.timestamp == 0) {
                this.mlz.timestamp = c27966g.field_edittime;
            }
            this.mlz.meU = C39037b.m66418r(c27966g);
            this.mlA = true;
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: iL */
    public final void mo54745iL(long j) {
        C27966g iE = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(j);
        if (iE != null) {
            mo54744F(iE);
        }
    }

    public void onDestroy() {
        if (this.mlA) {
            C7305d.post(new C30883(), "BaseFavReport");
        }
        setResult(-1, getIntent().putExtra("key_activity_browse_time", dyi()));
        C45932c.bvC();
        super.onDestroy();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && intent != null) {
            long longExtra = intent.getLongExtra("key_activity_browse_time", 0);
            C27969a c27969a = this.mlz;
            c27969a.meW += longExtra;
            C4990ab.m7419v("MicroMsg.Fav.BaseFavDetailReportUI", "onActivityResult subDetailPeriod[%d] subUIBrowserTime[%d]", Long.valueOf(this.mlz.meW), Long.valueOf(longExtra));
        }
        super.onActivityResult(i, i2, intent);
    }
}
