package com.tencent.p177mm.plugin.record.p493ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C6550tn;
import com.tencent.p177mm.plugin.fav.p410ui.detail.BaseFavDetailReportUI;
import com.tencent.p177mm.plugin.record.p493ui.C3706h.C3713b;
import com.tencent.p177mm.pluginsdk.C30036f;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.record.ui.RecordMsgBaseUI */
public abstract class RecordMsgBaseUI extends BaseFavDetailReportUI {
    protected long cvx = -1;
    protected ListView gGW = null;
    protected C3706h pKw;

    /* renamed from: com.tencent.mm.plugin.record.ui.RecordMsgBaseUI$2 */
    class C216152 implements OnMenuItemClickListener {
        C216152() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(24232);
            RecordMsgBaseUI.this.finish();
            AppMethodBeat.m2505o(24232);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.record.ui.RecordMsgBaseUI$1 */
    class C216171 implements OnScrollListener {
        C216171() {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.m2504i(24230);
            if (i == 0) {
                C6550tn c6550tn = new C6550tn();
                c6550tn.cPI.type = 5;
                c6550tn.cPI.cPJ = RecordMsgBaseUI.this.gGW.getFirstVisiblePosition();
                c6550tn.cPI.cPK = RecordMsgBaseUI.this.gGW.getLastVisiblePosition();
                c6550tn.cPI.cPL = RecordMsgBaseUI.this.gGW.getHeaderViewsCount();
                C4879a.xxA.mo10055m(c6550tn);
            }
            AppMethodBeat.m2505o(24230);
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            int i4 = 0;
            AppMethodBeat.m2504i(24231);
            if (i == 0) {
                View childAt = RecordMsgBaseUI.this.gGW.getChildAt(0);
                if (childAt != null) {
                    i4 = childAt.getTop();
                }
                if (i4 == 0) {
                    RecordMsgBaseUI.this.dyb();
                    AppMethodBeat.m2505o(24231);
                    return;
                }
            }
            RecordMsgBaseUI.this.dyc();
            AppMethodBeat.m2505o(24231);
        }
    }

    public abstract C3706h ceJ();

    public abstract String ceK();

    public abstract String ceL();

    public abstract String ceM();

    public abstract void ceN();

    /* renamed from: d */
    public abstract void mo37104d(int i, int i2, Intent intent);

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getLayoutId() {
        return 2130970488;
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        C30036f.m47544m(this);
        super.onCreate(bundle);
        ceI();
        C30036f.m47545n(this);
    }

    /* Access modifiers changed, original: protected */
    public void ceI() {
        this.pKw = ceJ();
        this.cvx = getIntent().getLongExtra("message_id", -1);
        this.gGW = (ListView) findViewById(2131826913);
        ceQ();
        String ceL = ceL();
        String ceM = ceM();
        if (C5046bo.isNullOrNil(ceL) || C5046bo.isNullOrNil(ceM)) {
            C4990ab.m7416i("MicroMsg.RecordMsgBaseUI", "subtitle time error!");
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
        view.setLayoutParams(new LayoutParams(-1, getResources().getDimensionPixelSize(C25738R.dimen.f9992mk)));
        this.gGW.addHeaderView(view, null, false);
        view = View.inflate(this.mController.ylL, 2130970487, null);
        this.gGW.setAdapter(this.pKw);
        this.pKw.mListView = this.gGW;
        this.pKw.ceO();
        this.gGW.setOnScrollListener(new C216171());
        setBackBtn(new C216152());
        ceN();
        this.gGW.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(24233);
                View childAt = RecordMsgBaseUI.this.gGW.getChildAt(RecordMsgBaseUI.this.gGW.getLastVisiblePosition());
                if (childAt != null) {
                    int bottom = childAt.getBottom();
                    int bottom2 = RecordMsgBaseUI.this.gGW.getBottom();
                    int fromDPToPix = C1338a.fromDPToPix(RecordMsgBaseUI.this.mController.ylL, 64);
                    C4990ab.m7411d("MicroMsg.RecordMsgBaseUI", "lastBotm %s, listBotm %s, listEndmargin %s", Integer.valueOf(bottom), Integer.valueOf(bottom2), Integer.valueOf(fromDPToPix));
                    if (bottom < bottom2 - fromDPToPix) {
                        C4990ab.m7411d("MicroMsg.RecordMsgBaseUI", "offset %d", Integer.valueOf((bottom2 - bottom) - fromDPToPix));
                        view.setPadding(0, bottom, 0, 0);
                    }
                }
                RecordMsgBaseUI.this.gGW.addFooterView(view, null, false);
                AppMethodBeat.m2505o(24233);
            }
        }, 100);
    }

    public void onResume() {
        super.onResume();
        C6550tn c6550tn = new C6550tn();
        if (this.gGW != null) {
            c6550tn.cPI.type = 0;
            c6550tn.cPI.cPJ = this.gGW.getFirstVisiblePosition();
            c6550tn.cPI.cPK = this.gGW.getLastVisiblePosition();
            c6550tn.cPI.cPL = this.gGW.getHeaderViewsCount();
            C4879a.xxA.mo10055m(c6550tn);
        }
    }

    public void onPause() {
        super.onPause();
        if (this.pKw != null) {
            C3706h c3706h = this.pKw;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= c3706h.pKp.size()) {
                    break;
                }
                C3713b c3713b = (C3713b) c3706h.pKp.valueAt(i2);
                if (c3713b != null) {
                    c3713b.pause();
                }
                i = i2 + 1;
            }
        }
        C6550tn c6550tn = new C6550tn();
        c6550tn.cPI.type = 1;
        C4879a.xxA.mo10055m(c6550tn);
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.pKw != null) {
            this.pKw.destroy();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        mo37104d(i, i2, intent);
    }

    /* Access modifiers changed, original: protected|final */
    public final void ceQ() {
        CharSequence ceK = ceK();
        String string = this.mController.ylL.getString(C25738R.string.biv);
        if (ceK != null && ceK.endsWith(string) && ceK.lastIndexOf(string) > 0) {
            ceK = ceK.substring(0, ceK.lastIndexOf(string) - 1);
        }
        mo17368M(C44089j.m79294b(this.mController.ylL, ceK, getResources().getDimensionPixelSize(C25738R.dimen.f9728dt)));
    }
}
