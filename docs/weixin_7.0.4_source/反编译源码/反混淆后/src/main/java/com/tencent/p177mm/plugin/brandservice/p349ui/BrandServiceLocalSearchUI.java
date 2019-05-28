package com.tencent.p177mm.plugin.brandservice.p349ui;

import android.os.Bundle;
import android.support.p057v4.app.FragmentActivity;
import android.support.p057v4.content.C0380b;
import android.view.Menu;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelvoiceaddr.p875ui.C42239b;
import com.tencent.p177mm.modelvoiceaddr.p875ui.C42239b.C9756a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p707ba.C45181k;
import com.tencent.p177mm.plugin.brandservice.p349ui.base.BrandServiceSortView;
import com.tencent.p177mm.plugin.brandservice.p349ui.base.BrandServiceSortView.C11206a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.brandservice.ui.BrandServiceLocalSearchUI */
public class BrandServiceLocalSearchUI extends MMActivity implements C9756a, C11206a {
    private C42239b jLK;
    private BrandServiceSortView jLL;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(13926);
        super.onCreate(bundle);
        mo17446xE(C0380b.m652i(this.mController.ylL, C25738R.color.f12206vy));
        initView();
        C1720g.m3540Rg().mo14541a(new C45181k(18), 0);
        AppMethodBeat.m2505o(13926);
    }

    public final void apq() {
    }

    public final void apr() {
    }

    public final void initView() {
        AppMethodBeat.m2504i(13927);
        this.jLL = (BrandServiceSortView) findViewById(2131821896);
        this.jLL.setMode(1);
        this.jLL.setReturnResult(getIntent().getBooleanExtra("is_return_result", false));
        this.jLL.dAH();
        this.jLL.mo70149ql(false);
        this.jLL.setShowFooterView(false);
        this.jLL.setITransferToChildOnTouchListener(this);
        this.jLK = new C42239b();
        this.jLK.mo11371qQ(true);
        this.jLK.mo67775a(this);
        this.jLK.gcl = false;
        AppMethodBeat.m2505o(13927);
    }

    public final void app() {
    }

    public final void apo() {
        AppMethodBeat.m2504i(13928);
        finish();
        AppMethodBeat.m2505o(13928);
    }

    /* renamed from: vO */
    public final void mo7460vO(String str) {
        AppMethodBeat.m2504i(13929);
        C4990ab.m7417i("MicroMsg.BrandServiceLocalSearchUI", "search biz, key word : %s", str);
        this.jLL.aqS(str);
        AppMethodBeat.m2505o(13929);
    }

    /* renamed from: vN */
    public final boolean mo7459vN(String str) {
        AppMethodBeat.m2504i(13930);
        aqX();
        AppMethodBeat.m2505o(13930);
        return true;
    }

    public final void amJ() {
        AppMethodBeat.m2504i(13931);
        aqX();
        AppMethodBeat.m2505o(13931);
    }

    public void onPause() {
        AppMethodBeat.m2504i(13932);
        super.onPause();
        this.jLK.cancel();
        this.jLK.clearFocus();
        AppMethodBeat.m2505o(13932);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(13933);
        super.onDestroy();
        this.jLL.release();
        AppMethodBeat.m2505o(13933);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        AppMethodBeat.m2504i(13934);
        this.jLK.mo11359a((FragmentActivity) this, menu);
        AppMethodBeat.m2505o(13934);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        AppMethodBeat.m2504i(13935);
        this.jLK.mo11358a(this, menu);
        AppMethodBeat.m2505o(13935);
        return true;
    }

    /* renamed from: a */
    public final void mo21125a(boolean z, String[] strArr, long j, int i) {
    }

    public final int getLayoutId() {
        return 2130968884;
    }

    public final boolean aWe() {
        AppMethodBeat.m2504i(13936);
        aqX();
        AppMethodBeat.m2505o(13936);
        return false;
    }
}
