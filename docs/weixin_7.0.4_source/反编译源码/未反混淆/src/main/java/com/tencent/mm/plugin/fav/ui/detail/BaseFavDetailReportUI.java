package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.modelstat.f;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.ui.c;
import com.tencent.mm.plugin.fav.ui.widget.FavDetailScrollView;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMLoadScrollView;

public abstract class BaseFavDetailReportUI extends MMActivity {
    protected boolean mlA;
    private String mlB = null;
    public a mlz = new a();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
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
            bwd.setOnTopOrBottomListerner(new MMLoadScrollView.a() {
                public final void bmh() {
                    BaseFavDetailReportUI.this.mlz.mfe = true;
                }
            });
            if (bwd instanceof FavDetailScrollView) {
                ((FavDetailScrollView) bwd).setOnScrollChangeListener(new FavDetailScrollView.a() {
                    public final void bwe() {
                        AppMethodBeat.i(74317);
                        BaseFavDetailReportUI.this.dyc();
                        AppMethodBeat.o(74317);
                    }

                    public final void bwf() {
                        AppMethodBeat.i(74318);
                        BaseFavDetailReportUI.this.dyb();
                        AppMethodBeat.o(74318);
                    }
                });
            }
        }
        if (this.mlz.scene == 0) {
            ab.i("MicroMsg.Fav.BaseFavDetailReportUI", "report object scene is 0");
        }
        xE(this.mController.ylL.getResources().getColor(R.color.e5));
        dyb();
    }

    /* Access modifiers changed, original: protected */
    public MMLoadScrollView bwd() {
        return null;
    }

    public void onResume() {
        super.onResume();
        if (bo.isNullOrNil(this.mlB)) {
            this.mlB = f.akh().fSS;
        }
        ab.v("MicroMsg.Fav.BaseFavDetailReportUI", "onResume firstResumeClassname[%s]", this.mlB);
    }

    public void onPause() {
        this.mlz.meV = dyi();
        String str = f.akh().fSS;
        if (!(bo.isEqual(getClass().getName(), str) || bo.isEqual(str, this.mlB))) {
            long longValue;
            a aVar = this.mlz;
            long j = aVar.meW;
            f akh = f.akh();
            String str2 = f.akh().fSS;
            if (akh.fSR != null) {
                longValue = ((Long) akh.fSR.get(str2)).longValue();
            } else {
                longValue = 0;
            }
            aVar.meW = longValue + j;
        }
        ab.v("MicroMsg.Fav.BaseFavDetailReportUI", "onPause lastClassname[%s] detailPeriod[%d] subDetailPeriod[%d]", str, Long.valueOf(this.mlz.meV), Long.valueOf(this.mlz.meW));
        super.onPause();
    }

    /* Access modifiers changed, original: protected|final */
    public final void F(g gVar) {
        if (gVar != null && this.mlz.scene > 0) {
            this.mlz.meT = (long) gVar.field_id;
            this.mlz.type = gVar.field_type;
            this.mlz.cvd = gVar.field_sourceType;
            this.mlz.timestamp = gVar.field_sourceCreateTime / 1000;
            if (this.mlz.timestamp == 0) {
                this.mlz.timestamp = gVar.field_updateTime / 1000;
            }
            if (this.mlz.timestamp == 0) {
                this.mlz.timestamp = gVar.field_edittime;
            }
            this.mlz.meU = b.r(gVar);
            this.mlA = true;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void iL(long j) {
        g iE = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(j);
        if (iE != null) {
            F(iE);
        }
    }

    public void onDestroy() {
        if (this.mlA) {
            d.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(74319);
                    BaseFavDetailReportUI.this.mlz.mff = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().vz((int) BaseFavDetailReportUI.this.mlz.meT) + 1;
                    h.a(BaseFavDetailReportUI.this.mlz);
                    AppMethodBeat.o(74319);
                }
            }, "BaseFavReport");
        }
        setResult(-1, getIntent().putExtra("key_activity_browse_time", dyi()));
        c.bvC();
        super.onDestroy();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && intent != null) {
            long longExtra = intent.getLongExtra("key_activity_browse_time", 0);
            a aVar = this.mlz;
            aVar.meW += longExtra;
            ab.v("MicroMsg.Fav.BaseFavDetailReportUI", "onActivityResult subDetailPeriod[%d] subUIBrowserTime[%d]", Long.valueOf(this.mlz.meW), Long.valueOf(longExtra));
        }
        super.onActivityResult(i, i2, intent);
    }
}
