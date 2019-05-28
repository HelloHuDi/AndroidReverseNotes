package com.tencent.p177mm.p612ui.chatting.gallery;

import android.app.ProgressDialog;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p057v4.app.FragmentActivity;
import android.support.p057v4.content.C0380b;
import android.support.p069v7.widget.RecyclerView;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.KeyEvent;
import android.view.Menu;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvoiceaddr.p875ui.C42239b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.chatting.p1092e.C15633b.C15634a;
import com.tencent.p177mm.p612ui.chatting.p1092e.C15633b.C15635b;
import com.tencent.p177mm.p612ui.chatting.p619i.C30519d;
import com.tencent.p177mm.p612ui.chatting.p619i.C30540f;
import com.tencent.p177mm.p612ui.chatting.p619i.C40786g;
import com.tencent.p177mm.p612ui.chatting.p619i.C46656a;
import com.tencent.p177mm.p612ui.chatting.p619i.C46658h;
import com.tencent.p177mm.plugin.fts.p419a.C34204f;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7577u;

@C5271a(3)
/* renamed from: com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI */
public class MediaHistoryListUI extends MMActivity implements C15635b {
    private RecyclerView aiB;
    private String emo;
    private TextView emq;
    private ProgressDialog kvA;
    private C15634a yTE;
    private C42239b yXV;

    /* renamed from: com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI$1 */
    class C407731 implements Runnable {
        C407731() {
        }

        public final void run() {
            AppMethodBeat.m2504i(32438);
            MediaHistoryListUI.this.yXV.clearFocus();
            AppMethodBeat.m2505o(32438);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(32439);
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 21) {
            Transition inflateTransition = TransitionInflater.from(this).inflateTransition(17760258);
            inflateTransition.excludeTarget(getWindow().getDecorView().findViewById(2131820940), true);
            inflateTransition.excludeTarget(16908335, true);
            getWindow().setEnterTransition(inflateTransition);
        }
        this.emo = getIntent().getStringExtra("kintent_talker");
        C15634a c15634a = null;
        switch (getIntent().getIntExtra("key_media_type", -1)) {
            case 2:
                c15634a = new C30519d(this);
                break;
            case 3:
                c15634a = new C46658h(this);
                break;
            case 4:
                c15634a = new C30540f(this);
                break;
            case 5:
                c15634a = new C40786g(this);
                break;
            case 6:
                c15634a = new C46656a(this);
                break;
        }
        if (c15634a == null) {
            C4990ab.m7412e("MicroMsg.MediaHistoryListUI", "[onCreate] presenter is null!");
            AppMethodBeat.m2505o(32439);
            return;
        }
        c15634a.mo39610a(this);
        mo17446xE(C0380b.m652i(this.mController.ylL, C25738R.color.f12206vy));
        dyb();
        initView();
        this.yTE.dFH();
        boolean kH = C1855t.m3896kH(this.emo);
        C9638aw.m17190ZK();
        C7577u ob = C18628c.m29087XV().mo14886ob(this.emo);
        if (kH) {
            if (this.yTE.getType() == 6) {
                C7060h.pYm.mo8381e(14569, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(ob.afg().size()), Integer.valueOf(1));
                AppMethodBeat.m2505o(32439);
                return;
            } else if (this.yTE.getType() == -1) {
                C7060h.pYm.mo8381e(14569, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(ob.afg().size()), Integer.valueOf(1));
                AppMethodBeat.m2505o(32439);
                return;
            } else if (this.yTE.getType() == 3) {
                C7060h.pYm.mo8381e(14569, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(ob.afg().size()), Integer.valueOf(1));
                AppMethodBeat.m2505o(32439);
                return;
            } else if (this.yTE.getType() == 5) {
                C7060h.pYm.mo8381e(14569, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(ob.afg().size()), Integer.valueOf(1), Integer.valueOf(1));
                AppMethodBeat.m2505o(32439);
                return;
            } else if (this.yTE.getType() == 33) {
                C7060h.pYm.mo8381e(14569, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(ob.afg().size()), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(8));
                AppMethodBeat.m2505o(32439);
                return;
            }
        } else if (this.yTE.getType() == 6) {
            C7060h.pYm.mo8381e(14569, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
            AppMethodBeat.m2505o(32439);
            return;
        } else if (this.yTE.getType() == -1) {
            C7060h.pYm.mo8381e(14569, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
            AppMethodBeat.m2505o(32439);
            return;
        } else if (this.yTE.getType() == 3) {
            C7060h.pYm.mo8381e(14569, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0));
            AppMethodBeat.m2505o(32439);
            return;
        } else if (this.yTE.getType() == 5) {
            C7060h.pYm.mo8381e(14569, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
            AppMethodBeat.m2505o(32439);
            return;
        } else if (this.yTE.getType() == 33) {
            C7060h.pYm.mo8381e(14569, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(8));
        }
        AppMethodBeat.m2505o(32439);
    }

    public final void initView() {
        AppMethodBeat.m2504i(32440);
        this.yXV = new C42239b();
        this.yXV.mo11371qQ(false);
        this.yXV.mo67775a(this.yTE.dFJ());
        this.yXV.gcl = false;
        this.emq = (TextView) findViewById(2131821477);
        this.aiB = (RecyclerView) findViewById(2131821478);
        findViewById(2131821476).setBackgroundColor(-1);
        this.aiB.setBackgroundColor(-1);
        this.aiB.setLayoutManager(this.yTE.bfC());
        this.aiB.mo66330a(this.yTE.dFG());
        this.aiB.setAdapter(this.yTE.aru(this.emo));
        this.aiB.setHasFixedSize(true);
        setMMTitle(this.yTE.aoy());
        AppMethodBeat.m2505o(32440);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(32441);
        super.onDestroy();
        this.yTE.onDetach();
        AppMethodBeat.m2505o(32441);
    }

    public final void onKeyboardStateChanged() {
        AppMethodBeat.m2504i(32442);
        super.onKeyboardStateChanged();
        if (this.mController.ymc == 2) {
            this.yXV.clearFocus();
        }
        AppMethodBeat.m2505o(32442);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        AppMethodBeat.m2504i(32443);
        this.yXV.mo11359a((FragmentActivity) this, menu);
        C42239b c42239b = this.yXV;
        String dFK = this.yTE.dFK();
        if (!(c42239b.zGZ == null || C5046bo.isNullOrNil(dFK))) {
            c42239b.zGZ.setSelectedTag(dFK);
        }
        this.mController.contentView.postDelayed(new C407731(), 200);
        AppMethodBeat.m2505o(32443);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        AppMethodBeat.m2504i(32444);
        this.yXV.mo11358a(this, menu);
        AppMethodBeat.m2505o(32444);
        return true;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(32445);
        if (keyEvent.getAction() == 4) {
            finish();
            overridePendingTransition(0, 0);
            AppMethodBeat.m2505o(32445);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(32445);
        return onKeyDown;
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(32446);
        super.onBackPressed();
        finish();
        overridePendingTransition(0, 0);
        AppMethodBeat.m2505o(32446);
    }

    public final int getLayoutId() {
        return 2130970080;
    }

    public final void dFL() {
        AppMethodBeat.m2504i(32447);
        m70558fE(true);
        AppMethodBeat.m2505o(32447);
    }

    /* renamed from: p */
    public final void mo27870p(boolean z, int i) {
        AppMethodBeat.m2504i(32448);
        m70558fE(false);
        C4990ab.m7417i("MicroMsg.MediaHistoryListUI", "[onDataLoaded] isFirst:%s addCount:%s", Boolean.valueOf(z), Integer.valueOf(i));
        if (i <= 0) {
            this.emq.setVisibility(0);
            this.aiB.setVisibility(8);
            this.emq.setText(getString(C25738R.string.ano));
            AppMethodBeat.m2505o(32448);
            return;
        }
        this.emq.setVisibility(8);
        this.aiB.setVisibility(0);
        this.aiB.getAdapter().aop.notifyChanged();
        AppMethodBeat.m2505o(32448);
    }

    public final void onFinish() {
        AppMethodBeat.m2504i(32449);
        C4990ab.m7416i("MicroMsg.MediaHistoryListUI", "[onRefreshed]");
        finish();
        overridePendingTransition(0, 0);
        AppMethodBeat.m2505o(32449);
    }

    /* renamed from: ch */
    public final void mo27867ch(String str, boolean z) {
        AppMethodBeat.m2504i(32450);
        if (z) {
            CharSequence string = getString(C25738R.string.ans, new Object[]{str});
            this.emq.setVisibility(0);
            this.aiB.setVisibility(8);
            TextView textView = this.emq;
            this.emq.getContext();
            textView.setText(C34204f.m56084a(string, str));
            AppMethodBeat.m2505o(32450);
            return;
        }
        this.emq.setVisibility(8);
        this.aiB.setVisibility(0);
        AppMethodBeat.m2505o(32450);
    }

    /* renamed from: fE */
    private void m70558fE(boolean z) {
        AppMethodBeat.m2504i(32451);
        C4990ab.m7417i("MicroMsg.MediaHistoryListUI", "[setProgress] isVisible:%s", Boolean.valueOf(z));
        if (z) {
            this.kvA = C44275p.m79966b(this, getString(C25738R.string.cn5), true, null);
            AppMethodBeat.m2505o(32451);
            return;
        }
        if (this.kvA != null && this.kvA.isShowing()) {
            this.kvA.dismiss();
            this.kvA = null;
        }
        AppMethodBeat.m2505o(32451);
    }
}
