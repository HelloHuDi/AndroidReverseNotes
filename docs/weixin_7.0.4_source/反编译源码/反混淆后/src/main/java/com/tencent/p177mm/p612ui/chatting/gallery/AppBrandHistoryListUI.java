package com.tencent.p177mm.p612ui.chatting.gallery;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.p069v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.chatting.p1092e.C15633b.C15634a;
import com.tencent.p177mm.p612ui.chatting.p1092e.C15633b.C15635b;
import com.tencent.p177mm.p612ui.chatting.p619i.C23783c;
import com.tencent.p177mm.p612ui.chatting.p619i.C46656a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.chatting.gallery.AppBrandHistoryListUI */
public class AppBrandHistoryListUI extends MMActivity implements C15635b {
    private RecyclerView aiB;
    private String emo;
    private TextView emq;
    private ProgressDialog kvA;
    private C15634a yTE;

    /* renamed from: com.tencent.mm.ui.chatting.gallery.AppBrandHistoryListUI$1 */
    class C156451 implements OnMenuItemClickListener {
        C156451() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(31951);
            AppBrandHistoryListUI.this.finish();
            AppMethodBeat.m2505o(31951);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo27875a(C23783c c23783c) {
        this.yTE = (C15634a) c23783c;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(31952);
        super.onCreate(bundle);
        this.emo = getIntent().getStringExtra("Chat_User");
        new C46656a(this).mo39610a(this);
        initView();
        this.yTE.dFH();
        if (C1855t.m3896kH(this.emo)) {
            C7060h.pYm.mo8381e(14562, this.emo, Integer.valueOf(0));
            AppMethodBeat.m2505o(31952);
            return;
        }
        C7060h.pYm.mo8381e(14562, this.emo, Integer.valueOf(1));
        AppMethodBeat.m2505o(31952);
    }

    public final void initView() {
        AppMethodBeat.m2504i(31953);
        setMMTitle(getString(C25738R.string.aip));
        this.emq = (TextView) findViewById(2131821477);
        this.aiB = (RecyclerView) findViewById(2131821478);
        this.aiB.setBackgroundColor(-1);
        this.aiB.setLayoutManager(this.yTE.bfC());
        this.aiB.setAdapter(this.yTE.aru(this.emo));
        this.aiB.setHasFixedSize(true);
        setBackBtn(new C156451());
        AppMethodBeat.m2505o(31953);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(31954);
        super.onDestroy();
        this.yTE.onDetach();
        AppMethodBeat.m2505o(31954);
    }

    public final int getLayoutId() {
        return 2130968763;
    }

    public final void dFL() {
        AppMethodBeat.m2504i(31955);
        m23937fE(true);
        AppMethodBeat.m2505o(31955);
    }

    /* renamed from: p */
    public final void mo27870p(boolean z, int i) {
        AppMethodBeat.m2504i(31956);
        m23937fE(false);
        C4990ab.m7417i("MicroMsg.AppBrandHistoryListUI", "[onDataLoaded] isFirst:%s addCount:%s", Boolean.valueOf(z), Integer.valueOf(i));
        if (i <= 0) {
            this.emq.setVisibility(0);
            this.aiB.setVisibility(8);
            this.emq.setText(getString(C25738R.string.ano));
            AppMethodBeat.m2505o(31956);
            return;
        }
        this.emq.setVisibility(8);
        this.aiB.setVisibility(0);
        this.aiB.getAdapter().mo66308ar(0, i);
        AppMethodBeat.m2505o(31956);
    }

    public final void onFinish() {
        AppMethodBeat.m2504i(31957);
        C4990ab.m7416i("MicroMsg.AppBrandHistoryListUI", "[onRefreshed]");
        finish();
        AppMethodBeat.m2505o(31957);
    }

    /* renamed from: ch */
    public final void mo27867ch(String str, boolean z) {
    }

    /* renamed from: fE */
    private void m23937fE(boolean z) {
        AppMethodBeat.m2504i(31958);
        C4990ab.m7417i("MicroMsg.AppBrandHistoryListUI", "[setProgress] isVisible:%s", Boolean.valueOf(z));
        if (z) {
            this.kvA = C44275p.m79966b(this, getString(C25738R.string.cn5), true, null);
            AppMethodBeat.m2505o(31958);
            return;
        }
        if (this.kvA != null && this.kvA.isShowing()) {
            this.kvA.dismiss();
            this.kvA = null;
        }
        AppMethodBeat.m2505o(31958);
    }
}
