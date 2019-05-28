package com.tencent.mm.ui.chatting.gallery;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.e.b.a;
import com.tencent.mm.ui.chatting.e.b.b;
import com.tencent.mm.ui.chatting.i.c;

public class AppBrandHistoryListUI extends MMActivity implements b {
    private RecyclerView aiB;
    private String emo;
    private TextView emq;
    private ProgressDialog kvA;
    private a yTE;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final /* bridge */ /* synthetic */ void a(c cVar) {
        this.yTE = (a) cVar;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(31952);
        super.onCreate(bundle);
        this.emo = getIntent().getStringExtra("Chat_User");
        new com.tencent.mm.ui.chatting.i.a(this).a(this);
        initView();
        this.yTE.dFH();
        if (t.kH(this.emo)) {
            h.pYm.e(14562, this.emo, Integer.valueOf(0));
            AppMethodBeat.o(31952);
            return;
        }
        h.pYm.e(14562, this.emo, Integer.valueOf(1));
        AppMethodBeat.o(31952);
    }

    public final void initView() {
        AppMethodBeat.i(31953);
        setMMTitle(getString(R.string.aip));
        this.emq = (TextView) findViewById(R.id.yi);
        this.aiB = (RecyclerView) findViewById(R.id.yj);
        this.aiB.setBackgroundColor(-1);
        this.aiB.setLayoutManager(this.yTE.bfC());
        this.aiB.setAdapter(this.yTE.aru(this.emo));
        this.aiB.setHasFixedSize(true);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(31951);
                AppBrandHistoryListUI.this.finish();
                AppMethodBeat.o(31951);
                return true;
            }
        });
        AppMethodBeat.o(31953);
    }

    public void onDestroy() {
        AppMethodBeat.i(31954);
        super.onDestroy();
        this.yTE.onDetach();
        AppMethodBeat.o(31954);
    }

    public final int getLayoutId() {
        return R.layout.ec;
    }

    public final void dFL() {
        AppMethodBeat.i(31955);
        fE(true);
        AppMethodBeat.o(31955);
    }

    public final void p(boolean z, int i) {
        AppMethodBeat.i(31956);
        fE(false);
        ab.i("MicroMsg.AppBrandHistoryListUI", "[onDataLoaded] isFirst:%s addCount:%s", Boolean.valueOf(z), Integer.valueOf(i));
        if (i <= 0) {
            this.emq.setVisibility(0);
            this.aiB.setVisibility(8);
            this.emq.setText(getString(R.string.ano));
            AppMethodBeat.o(31956);
            return;
        }
        this.emq.setVisibility(8);
        this.aiB.setVisibility(0);
        this.aiB.getAdapter().ar(0, i);
        AppMethodBeat.o(31956);
    }

    public final void onFinish() {
        AppMethodBeat.i(31957);
        ab.i("MicroMsg.AppBrandHistoryListUI", "[onRefreshed]");
        finish();
        AppMethodBeat.o(31957);
    }

    public final void ch(String str, boolean z) {
    }

    private void fE(boolean z) {
        AppMethodBeat.i(31958);
        ab.i("MicroMsg.AppBrandHistoryListUI", "[setProgress] isVisible:%s", Boolean.valueOf(z));
        if (z) {
            this.kvA = p.b(this, getString(R.string.cn5), true, null);
            AppMethodBeat.o(31958);
            return;
        }
        if (this.kvA != null && this.kvA.isShowing()) {
            this.kvA.dismiss();
            this.kvA = null;
        }
        AppMethodBeat.o(31958);
    }
}
