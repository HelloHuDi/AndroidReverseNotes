package com.tencent.mm.plugin.brandservice.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ba.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoiceaddr.ui.b;
import com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(3)
public class BrandServiceLocalSearchUI extends MMActivity implements b.a, BrandServiceSortView.a {
    private b jLK;
    private BrandServiceSortView jLL;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(13926);
        super.onCreate(bundle);
        xE(android.support.v4.content.b.i(this.mController.ylL, R.color.vy));
        initView();
        g.Rg().a(new k(18), 0);
        AppMethodBeat.o(13926);
    }

    public final void apq() {
    }

    public final void apr() {
    }

    public final void initView() {
        AppMethodBeat.i(13927);
        this.jLL = (BrandServiceSortView) findViewById(R.id.a9i);
        this.jLL.setMode(1);
        this.jLL.setReturnResult(getIntent().getBooleanExtra("is_return_result", false));
        this.jLL.dAH();
        this.jLL.ql(false);
        this.jLL.setShowFooterView(false);
        this.jLL.setITransferToChildOnTouchListener(this);
        this.jLK = new b();
        this.jLK.qQ(true);
        this.jLK.a(this);
        this.jLK.gcl = false;
        AppMethodBeat.o(13927);
    }

    public final void app() {
    }

    public final void apo() {
        AppMethodBeat.i(13928);
        finish();
        AppMethodBeat.o(13928);
    }

    public final void vO(String str) {
        AppMethodBeat.i(13929);
        ab.i("MicroMsg.BrandServiceLocalSearchUI", "search biz, key word : %s", str);
        this.jLL.aqS(str);
        AppMethodBeat.o(13929);
    }

    public final boolean vN(String str) {
        AppMethodBeat.i(13930);
        aqX();
        AppMethodBeat.o(13930);
        return true;
    }

    public final void amJ() {
        AppMethodBeat.i(13931);
        aqX();
        AppMethodBeat.o(13931);
    }

    public void onPause() {
        AppMethodBeat.i(13932);
        super.onPause();
        this.jLK.cancel();
        this.jLK.clearFocus();
        AppMethodBeat.o(13932);
    }

    public void onDestroy() {
        AppMethodBeat.i(13933);
        super.onDestroy();
        this.jLL.release();
        AppMethodBeat.o(13933);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        AppMethodBeat.i(13934);
        this.jLK.a((FragmentActivity) this, menu);
        AppMethodBeat.o(13934);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        AppMethodBeat.i(13935);
        this.jLK.a(this, menu);
        AppMethodBeat.o(13935);
        return true;
    }

    public final void a(boolean z, String[] strArr, long j, int i) {
    }

    public final int getLayoutId() {
        return R.layout.hm;
    }

    public final boolean aWe() {
        AppMethodBeat.i(13936);
        aqX();
        AppMethodBeat.o(13936);
        return false;
    }
}
