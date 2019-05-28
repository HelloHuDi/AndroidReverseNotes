package com.tencent.mm.plugin.record.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.tn;
import com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public abstract class RecordMsgBaseUI extends BaseFavDetailReportUI {
    protected long cvx = -1;
    protected ListView gGW = null;
    protected h pKw;

    public abstract h ceJ();

    public abstract String ceK();

    public abstract String ceL();

    public abstract String ceM();

    public abstract void ceN();

    public abstract void d(int i, int i2, Intent intent);

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getLayoutId() {
        return R.layout.anu;
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        f.m(this);
        super.onCreate(bundle);
        ceI();
        f.n(this);
    }

    /* Access modifiers changed, original: protected */
    public void ceI() {
        this.pKw = ceJ();
        this.cvx = getIntent().getLongExtra("message_id", -1);
        this.gGW = (ListView) findViewById(R.id.dx6);
        ceQ();
        String ceL = ceL();
        String ceM = ceM();
        if (bo.isNullOrNil(ceL) || bo.isNullOrNil(ceM)) {
            ab.i("MicroMsg.RecordMsgBaseUI", "subtitle time error!");
        } else {
            ceL = ceL.split(" ")[0];
            Object obj = ceM.split(" ")[0];
            if (ceL.equals(obj)) {
                this.pKw.pKq = false;
            } else {
                ceL = ceL + "~" + obj;
                this.pKw.pKq = true;
            }
            setMMSubTitle(ceL);
        }
        View view = new View(this.mController.ylL);
        view.setLayoutParams(new LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.mk)));
        this.gGW.addHeaderView(view, null, false);
        view = View.inflate(this.mController.ylL, R.layout.ant, null);
        this.gGW.setAdapter(this.pKw);
        this.pKw.mListView = this.gGW;
        this.pKw.ceO();
        this.gGW.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
                AppMethodBeat.i(24230);
                if (i == 0) {
                    tn tnVar = new tn();
                    tnVar.cPI.type = 5;
                    tnVar.cPI.cPJ = RecordMsgBaseUI.this.gGW.getFirstVisiblePosition();
                    tnVar.cPI.cPK = RecordMsgBaseUI.this.gGW.getLastVisiblePosition();
                    tnVar.cPI.cPL = RecordMsgBaseUI.this.gGW.getHeaderViewsCount();
                    a.xxA.m(tnVar);
                }
                AppMethodBeat.o(24230);
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int i4 = 0;
                AppMethodBeat.i(24231);
                if (i == 0) {
                    View childAt = RecordMsgBaseUI.this.gGW.getChildAt(0);
                    if (childAt != null) {
                        i4 = childAt.getTop();
                    }
                    if (i4 == 0) {
                        RecordMsgBaseUI.this.dyb();
                        AppMethodBeat.o(24231);
                        return;
                    }
                }
                RecordMsgBaseUI.this.dyc();
                AppMethodBeat.o(24231);
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(24232);
                RecordMsgBaseUI.this.finish();
                AppMethodBeat.o(24232);
                return true;
            }
        });
        ceN();
        this.gGW.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(24233);
                View childAt = RecordMsgBaseUI.this.gGW.getChildAt(RecordMsgBaseUI.this.gGW.getLastVisiblePosition());
                if (childAt != null) {
                    int bottom = childAt.getBottom();
                    int bottom2 = RecordMsgBaseUI.this.gGW.getBottom();
                    int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(RecordMsgBaseUI.this.mController.ylL, 64);
                    ab.d("MicroMsg.RecordMsgBaseUI", "lastBotm %s, listBotm %s, listEndmargin %s", Integer.valueOf(bottom), Integer.valueOf(bottom2), Integer.valueOf(fromDPToPix));
                    if (bottom < bottom2 - fromDPToPix) {
                        ab.d("MicroMsg.RecordMsgBaseUI", "offset %d", Integer.valueOf((bottom2 - bottom) - fromDPToPix));
                        view.setPadding(0, bottom, 0, 0);
                    }
                }
                RecordMsgBaseUI.this.gGW.addFooterView(view, null, false);
                AppMethodBeat.o(24233);
            }
        }, 100);
    }

    public void onResume() {
        super.onResume();
        tn tnVar = new tn();
        if (this.gGW != null) {
            tnVar.cPI.type = 0;
            tnVar.cPI.cPJ = this.gGW.getFirstVisiblePosition();
            tnVar.cPI.cPK = this.gGW.getLastVisiblePosition();
            tnVar.cPI.cPL = this.gGW.getHeaderViewsCount();
            a.xxA.m(tnVar);
        }
    }

    public void onPause() {
        super.onPause();
        if (this.pKw != null) {
            h hVar = this.pKw;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= hVar.pKp.size()) {
                    break;
                }
                b bVar = (b) hVar.pKp.valueAt(i2);
                if (bVar != null) {
                    bVar.pause();
                }
                i = i2 + 1;
            }
        }
        tn tnVar = new tn();
        tnVar.cPI.type = 1;
        a.xxA.m(tnVar);
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.pKw != null) {
            this.pKw.destroy();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        d(i, i2, intent);
    }

    /* Access modifiers changed, original: protected|final */
    public final void ceQ() {
        CharSequence ceK = ceK();
        String string = this.mController.ylL.getString(R.string.biv);
        if (ceK != null && ceK.endsWith(string) && ceK.lastIndexOf(string) > 0) {
            ceK = ceK.substring(0, ceK.lastIndexOf(string) - 1);
        }
        M(j.b(this.mController.ylL, ceK, getResources().getDimensionPixelSize(R.dimen.dt)));
    }
}
