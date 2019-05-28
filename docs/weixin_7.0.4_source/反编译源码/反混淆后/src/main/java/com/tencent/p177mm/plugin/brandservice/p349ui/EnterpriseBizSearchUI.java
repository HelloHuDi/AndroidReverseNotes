package com.tencent.p177mm.plugin.brandservice.p349ui;

import android.os.Bundle;
import android.support.p057v4.app.FragmentActivity;
import android.view.Menu;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.modelvoiceaddr.p875ui.C42239b;
import com.tencent.p177mm.modelvoiceaddr.p875ui.C42239b.C9756a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.brandservice.p349ui.EnterpriseBizContactListView.C20033b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.brandservice.ui.EnterpriseBizSearchUI */
public class EnterpriseBizSearchUI extends MMActivity implements C9756a, C20033b {
    private C42239b jLK;
    private EnterpriseBizContactListView jLP;
    private String jMp;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(14003);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(14003);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(14004);
        super.onDestroy();
        if (this.jLP != null) {
            EnterpriseBizContactListView.release();
        }
        AppMethodBeat.m2505o(14004);
    }

    private void aWh() {
        AppMethodBeat.m2504i(14005);
        if (C5046bo.isNullOrNil(this.jMp)) {
            this.jMp = getIntent().getStringExtra("enterprise_biz_name");
            if (C5046bo.isNullOrNil(this.jMp)) {
                finish();
            }
        }
        AppMethodBeat.m2505o(14005);
    }

    public final void apq() {
    }

    public final void apr() {
    }

    public final void initView() {
        AppMethodBeat.m2504i(14006);
        aWh();
        this.jLP = (EnterpriseBizContactListView) findViewById(2131821896);
        this.jLP.setFatherBizName(this.jMp);
        this.jLP.setExcludeBizChat(true);
        this.jLP.refresh();
        this.jLP.setMode(1);
        this.jLP.aWg();
        this.jLP.dAH();
        this.jLP.mo70149ql(false);
        this.jLP.setOnTouchListener(this);
        ((TextView) this.jLP.getNoResultView()).setText(C25738R.string.bdz);
        this.jLK = new C42239b();
        this.jLK.mo11371qQ(true);
        this.jLK.mo67775a(this);
        this.jLK.gcl = false;
        AppMethodBeat.m2505o(14006);
    }

    public final void app() {
    }

    public final void apo() {
        AppMethodBeat.m2504i(14007);
        finish();
        AppMethodBeat.m2505o(14007);
    }

    /* renamed from: vO */
    public final void mo7460vO(String str) {
        AppMethodBeat.m2504i(14008);
        C4990ab.m7417i("MicroMsg.EnterpriseBizSearchUI", "search biz, key word : %s", str);
        this.jLP.aqS(str);
        AppMethodBeat.m2505o(14008);
    }

    /* renamed from: vN */
    public final boolean mo7459vN(String str) {
        AppMethodBeat.m2504i(14009);
        aqX();
        AppMethodBeat.m2505o(14009);
        return true;
    }

    public final void amJ() {
        AppMethodBeat.m2504i(14010);
        aqX();
        AppMethodBeat.m2505o(14010);
    }

    public void onPause() {
        AppMethodBeat.m2504i(14011);
        super.onPause();
        this.jLK.cancel();
        this.jLK.clearFocus();
        AppMethodBeat.m2505o(14011);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        AppMethodBeat.m2504i(14012);
        this.jLK.mo11359a((FragmentActivity) this, menu);
        AppMethodBeat.m2505o(14012);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        AppMethodBeat.m2504i(14013);
        this.jLK.mo11358a(this, menu);
        AppMethodBeat.m2505o(14013);
        return true;
    }

    /* renamed from: a */
    public final void mo21125a(boolean z, String[] strArr, long j, int i) {
    }

    public final int getLayoutId() {
        return 2130969399;
    }

    public final boolean aWe() {
        AppMethodBeat.m2504i(14014);
        aqX();
        AppMethodBeat.m2505o(14014);
        return false;
    }
}
