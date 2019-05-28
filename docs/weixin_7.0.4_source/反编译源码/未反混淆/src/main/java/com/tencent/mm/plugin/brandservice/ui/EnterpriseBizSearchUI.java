package com.tencent.mm.plugin.brandservice.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.modelvoiceaddr.ui.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(3)
public class EnterpriseBizSearchUI extends MMActivity implements b.a, EnterpriseBizContactListView.b {
    private b jLK;
    private EnterpriseBizContactListView jLP;
    private String jMp;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(14003);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(14003);
    }

    public void onDestroy() {
        AppMethodBeat.i(14004);
        super.onDestroy();
        if (this.jLP != null) {
            EnterpriseBizContactListView.release();
        }
        AppMethodBeat.o(14004);
    }

    private void aWh() {
        AppMethodBeat.i(14005);
        if (bo.isNullOrNil(this.jMp)) {
            this.jMp = getIntent().getStringExtra("enterprise_biz_name");
            if (bo.isNullOrNil(this.jMp)) {
                finish();
            }
        }
        AppMethodBeat.o(14005);
    }

    public final void apq() {
    }

    public final void apr() {
    }

    public final void initView() {
        AppMethodBeat.i(14006);
        aWh();
        this.jLP = (EnterpriseBizContactListView) findViewById(R.id.a9i);
        this.jLP.setFatherBizName(this.jMp);
        this.jLP.setExcludeBizChat(true);
        this.jLP.refresh();
        this.jLP.setMode(1);
        this.jLP.aWg();
        this.jLP.dAH();
        this.jLP.ql(false);
        this.jLP.setOnTouchListener(this);
        ((TextView) this.jLP.getNoResultView()).setText(R.string.bdz);
        this.jLK = new b();
        this.jLK.qQ(true);
        this.jLK.a(this);
        this.jLK.gcl = false;
        AppMethodBeat.o(14006);
    }

    public final void app() {
    }

    public final void apo() {
        AppMethodBeat.i(14007);
        finish();
        AppMethodBeat.o(14007);
    }

    public final void vO(String str) {
        AppMethodBeat.i(14008);
        ab.i("MicroMsg.EnterpriseBizSearchUI", "search biz, key word : %s", str);
        this.jLP.aqS(str);
        AppMethodBeat.o(14008);
    }

    public final boolean vN(String str) {
        AppMethodBeat.i(14009);
        aqX();
        AppMethodBeat.o(14009);
        return true;
    }

    public final void amJ() {
        AppMethodBeat.i(14010);
        aqX();
        AppMethodBeat.o(14010);
    }

    public void onPause() {
        AppMethodBeat.i(14011);
        super.onPause();
        this.jLK.cancel();
        this.jLK.clearFocus();
        AppMethodBeat.o(14011);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        AppMethodBeat.i(14012);
        this.jLK.a((FragmentActivity) this, menu);
        AppMethodBeat.o(14012);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        AppMethodBeat.i(14013);
        this.jLK.a(this, menu);
        AppMethodBeat.o(14013);
        return true;
    }

    public final void a(boolean z, String[] strArr, long j, int i) {
    }

    public final int getLayoutId() {
        return R.layout.vh;
    }

    public final boolean aWe() {
        AppMethodBeat.i(14014);
        aqX();
        AppMethodBeat.o(14014);
        return false;
    }
}
