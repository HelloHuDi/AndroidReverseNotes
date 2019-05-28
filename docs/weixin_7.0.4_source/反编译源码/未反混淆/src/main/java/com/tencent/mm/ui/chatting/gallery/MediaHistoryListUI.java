package com.tencent.mm.ui.chatting.gallery;

import android.app.ProgressDialog;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.KeyEvent;
import android.view.Menu;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.e.b.b;
import com.tencent.mm.ui.chatting.i.d;
import com.tencent.mm.ui.chatting.i.f;
import com.tencent.mm.ui.chatting.i.g;
import com.tencent.mm.ui.chatting.i.h;

@a(3)
public class MediaHistoryListUI extends MMActivity implements b {
    private RecyclerView aiB;
    private String emo;
    private TextView emq;
    private ProgressDialog kvA;
    private com.tencent.mm.ui.chatting.e.b.a yTE;
    private com.tencent.mm.modelvoiceaddr.ui.b yXV;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(32439);
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 21) {
            Transition inflateTransition = TransitionInflater.from(this).inflateTransition(17760258);
            inflateTransition.excludeTarget(getWindow().getDecorView().findViewById(R.id.k0), true);
            inflateTransition.excludeTarget(16908335, true);
            getWindow().setEnterTransition(inflateTransition);
        }
        this.emo = getIntent().getStringExtra("kintent_talker");
        com.tencent.mm.ui.chatting.e.b.a aVar = null;
        switch (getIntent().getIntExtra("key_media_type", -1)) {
            case 2:
                aVar = new d(this);
                break;
            case 3:
                aVar = new h(this);
                break;
            case 4:
                aVar = new f(this);
                break;
            case 5:
                aVar = new g(this);
                break;
            case 6:
                aVar = new com.tencent.mm.ui.chatting.i.a(this);
                break;
        }
        if (aVar == null) {
            ab.e("MicroMsg.MediaHistoryListUI", "[onCreate] presenter is null!");
            AppMethodBeat.o(32439);
            return;
        }
        aVar.a(this);
        xE(android.support.v4.content.b.i(this.mController.ylL, R.color.vy));
        dyb();
        initView();
        this.yTE.dFH();
        boolean kH = t.kH(this.emo);
        aw.ZK();
        u ob = c.XV().ob(this.emo);
        if (kH) {
            if (this.yTE.getType() == 6) {
                com.tencent.mm.plugin.report.service.h.pYm.e(14569, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(ob.afg().size()), Integer.valueOf(1));
                AppMethodBeat.o(32439);
                return;
            } else if (this.yTE.getType() == -1) {
                com.tencent.mm.plugin.report.service.h.pYm.e(14569, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(ob.afg().size()), Integer.valueOf(1));
                AppMethodBeat.o(32439);
                return;
            } else if (this.yTE.getType() == 3) {
                com.tencent.mm.plugin.report.service.h.pYm.e(14569, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(ob.afg().size()), Integer.valueOf(1));
                AppMethodBeat.o(32439);
                return;
            } else if (this.yTE.getType() == 5) {
                com.tencent.mm.plugin.report.service.h.pYm.e(14569, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(ob.afg().size()), Integer.valueOf(1), Integer.valueOf(1));
                AppMethodBeat.o(32439);
                return;
            } else if (this.yTE.getType() == 33) {
                com.tencent.mm.plugin.report.service.h.pYm.e(14569, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(ob.afg().size()), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(8));
                AppMethodBeat.o(32439);
                return;
            }
        } else if (this.yTE.getType() == 6) {
            com.tencent.mm.plugin.report.service.h.pYm.e(14569, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
            AppMethodBeat.o(32439);
            return;
        } else if (this.yTE.getType() == -1) {
            com.tencent.mm.plugin.report.service.h.pYm.e(14569, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
            AppMethodBeat.o(32439);
            return;
        } else if (this.yTE.getType() == 3) {
            com.tencent.mm.plugin.report.service.h.pYm.e(14569, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0));
            AppMethodBeat.o(32439);
            return;
        } else if (this.yTE.getType() == 5) {
            com.tencent.mm.plugin.report.service.h.pYm.e(14569, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
            AppMethodBeat.o(32439);
            return;
        } else if (this.yTE.getType() == 33) {
            com.tencent.mm.plugin.report.service.h.pYm.e(14569, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(8));
        }
        AppMethodBeat.o(32439);
    }

    public final void initView() {
        AppMethodBeat.i(32440);
        this.yXV = new com.tencent.mm.modelvoiceaddr.ui.b();
        this.yXV.qQ(false);
        this.yXV.a(this.yTE.dFJ());
        this.yXV.gcl = false;
        this.emq = (TextView) findViewById(R.id.yi);
        this.aiB = (RecyclerView) findViewById(R.id.yj);
        findViewById(R.id.yh).setBackgroundColor(-1);
        this.aiB.setBackgroundColor(-1);
        this.aiB.setLayoutManager(this.yTE.bfC());
        this.aiB.a(this.yTE.dFG());
        this.aiB.setAdapter(this.yTE.aru(this.emo));
        this.aiB.setHasFixedSize(true);
        setMMTitle(this.yTE.aoy());
        AppMethodBeat.o(32440);
    }

    public void onDestroy() {
        AppMethodBeat.i(32441);
        super.onDestroy();
        this.yTE.onDetach();
        AppMethodBeat.o(32441);
    }

    public final void onKeyboardStateChanged() {
        AppMethodBeat.i(32442);
        super.onKeyboardStateChanged();
        if (this.mController.ymc == 2) {
            this.yXV.clearFocus();
        }
        AppMethodBeat.o(32442);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        AppMethodBeat.i(32443);
        this.yXV.a((FragmentActivity) this, menu);
        com.tencent.mm.modelvoiceaddr.ui.b bVar = this.yXV;
        String dFK = this.yTE.dFK();
        if (!(bVar.zGZ == null || bo.isNullOrNil(dFK))) {
            bVar.zGZ.setSelectedTag(dFK);
        }
        this.mController.contentView.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(32438);
                MediaHistoryListUI.this.yXV.clearFocus();
                AppMethodBeat.o(32438);
            }
        }, 200);
        AppMethodBeat.o(32443);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        AppMethodBeat.i(32444);
        this.yXV.a(this, menu);
        AppMethodBeat.o(32444);
        return true;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(32445);
        if (keyEvent.getAction() == 4) {
            finish();
            overridePendingTransition(0, 0);
            AppMethodBeat.o(32445);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(32445);
        return onKeyDown;
    }

    public void onBackPressed() {
        AppMethodBeat.i(32446);
        super.onBackPressed();
        finish();
        overridePendingTransition(0, 0);
        AppMethodBeat.o(32446);
    }

    public final int getLayoutId() {
        return R.layout.acu;
    }

    public final void dFL() {
        AppMethodBeat.i(32447);
        fE(true);
        AppMethodBeat.o(32447);
    }

    public final void p(boolean z, int i) {
        AppMethodBeat.i(32448);
        fE(false);
        ab.i("MicroMsg.MediaHistoryListUI", "[onDataLoaded] isFirst:%s addCount:%s", Boolean.valueOf(z), Integer.valueOf(i));
        if (i <= 0) {
            this.emq.setVisibility(0);
            this.aiB.setVisibility(8);
            this.emq.setText(getString(R.string.ano));
            AppMethodBeat.o(32448);
            return;
        }
        this.emq.setVisibility(8);
        this.aiB.setVisibility(0);
        this.aiB.getAdapter().aop.notifyChanged();
        AppMethodBeat.o(32448);
    }

    public final void onFinish() {
        AppMethodBeat.i(32449);
        ab.i("MicroMsg.MediaHistoryListUI", "[onRefreshed]");
        finish();
        overridePendingTransition(0, 0);
        AppMethodBeat.o(32449);
    }

    public final void ch(String str, boolean z) {
        AppMethodBeat.i(32450);
        if (z) {
            CharSequence string = getString(R.string.ans, new Object[]{str});
            this.emq.setVisibility(0);
            this.aiB.setVisibility(8);
            TextView textView = this.emq;
            this.emq.getContext();
            textView.setText(com.tencent.mm.plugin.fts.a.f.a(string, str));
            AppMethodBeat.o(32450);
            return;
        }
        this.emq.setVisibility(8);
        this.aiB.setVisibility(0);
        AppMethodBeat.o(32450);
    }

    private void fE(boolean z) {
        AppMethodBeat.i(32451);
        ab.i("MicroMsg.MediaHistoryListUI", "[setProgress] isVisible:%s", Boolean.valueOf(z));
        if (z) {
            this.kvA = p.b(this, getString(R.string.cn5), true, null);
            AppMethodBeat.o(32451);
            return;
        }
        if (this.kvA != null && this.kvA.isShowing()) {
            this.kvA.dismiss();
            this.kvA = null;
        }
        AppMethodBeat.o(32451);
    }
}
