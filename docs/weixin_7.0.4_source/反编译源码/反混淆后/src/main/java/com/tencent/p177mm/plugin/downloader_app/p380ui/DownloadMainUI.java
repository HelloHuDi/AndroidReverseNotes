package com.tencent.p177mm.plugin.downloader_app.p380ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.ipcinvoker.C18514l;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMFragmentActivity.C5206a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.snackbar.C5670b;
import com.tencent.p177mm.plugin.downloader.p723c.p941a.p942a.C27701f;
import com.tencent.p177mm.plugin.downloader.p943h.C33913a;
import com.tencent.p177mm.plugin.downloader_app.p1646c.C45838a;
import com.tencent.p177mm.plugin.downloader_app.p377b.C27715f;
import com.tencent.p177mm.plugin.downloader_app.p377b.C27716g;
import com.tencent.p177mm.plugin.downloader_app.p377b.C27716g.C27717a;
import com.tencent.p177mm.plugin.downloader_app.p377b.C38861i;
import com.tencent.p177mm.plugin.downloader_app.p377b.C45836c;
import com.tencent.p177mm.plugin.downloader_app.p377b.C45837j;
import com.tencent.p177mm.plugin.downloader_app.search.DownloadSearchUI;
import com.tencent.p177mm.plugin.game.commlib.p977a.C34261a;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI */
public class DownloadMainUI extends MMActivity {
    private View emz;
    private C27701f kOV;
    TaskListView kQc;
    private DeleteTaskFooterView kQd;
    private TaskManagerHeaderView kQe;
    private View kQf;
    private boolean kQg;
    private boolean kQh;
    private C27715f kQi;
    private boolean kQj = false;
    private String mAppId;

    /* renamed from: com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI$5 */
    class C203475 implements Runnable {
        C203475() {
        }

        public final void run() {
            AppMethodBeat.m2504i(136230);
            C33913a.m55500a(DownloadMainUI.this, DownloadMainUI.this.mAppId, null);
            AppMethodBeat.m2505o(136230);
        }
    }

    /* renamed from: com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI$7 */
    class C203497 implements Runnable {
        C203497() {
        }

        public final void run() {
            AppMethodBeat.m2504i(136232);
            if (!DownloadMainUI.this.kQj) {
                C5670b.m8523i(DownloadMainUI.this, DownloadMainUI.this.getString(C25738R.string.ev8));
            }
            TaskListView g = DownloadMainUI.this.kQc;
            int indexOf = g.kQZ.kQR.indexOf(DownloadMainUI.this.kQi.mo45550IL(DownloadMainUI.this.mAppId));
            if (indexOf < 0 || indexOf >= DownloadMainUI.this.kQc.getSize()) {
                C4990ab.m7412e("MicroMsg.DownloadMainUI", "error position < 0");
                AppMethodBeat.m2505o(136232);
                return;
            }
            DownloadMainUI.this.kQc.smoothScrollToPosition(indexOf);
            AppMethodBeat.m2505o(136232);
        }
    }

    /* renamed from: com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI$a */
    public interface C27724a {
        /* renamed from: gl */
        void mo45557gl(boolean z);
    }

    /* renamed from: com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI$2 */
    class C388672 implements OnMenuItemClickListener {
        C388672() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(136225);
            DownloadMainUI.this.startActivity(new Intent(DownloadMainUI.this, DownloadSearchUI.class));
            C45838a.m84850a(10, 1001, 1, 2, "", "", "");
            AppMethodBeat.m2505o(136225);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI$1 */
    class C429251 implements OnMenuItemClickListener {
        C429251() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(136224);
            DownloadMainUI.this.finish();
            AppMethodBeat.m2505o(136224);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI$3 */
    class C429263 implements C27724a {
        C429263() {
        }

        /* renamed from: gl */
        public final void mo45557gl(boolean z) {
            AppMethodBeat.m2504i(136226);
            if (z) {
                DownloadMainUI.this.kQd.setVisibility(0);
                DownloadMainUI.this.kQd.startAnimation(AnimationUtils.loadAnimation(DownloadMainUI.this, C25738R.anim.f8305aa));
                DownloadMainUI.this.kQe.setVisibility(0);
                DownloadMainUI.this.kQe.startAnimation(AnimationUtils.loadAnimation(DownloadMainUI.this, C25738R.anim.f8418dz));
                AppMethodBeat.m2505o(136226);
                return;
            }
            DownloadMainUI.this.kQd.setVisibility(8);
            DownloadMainUI.this.kQd.startAnimation(AnimationUtils.loadAnimation(DownloadMainUI.this, C25738R.anim.f8306ab));
            DownloadMainUI.this.kQe.setVisibility(8);
            DownloadMainUI.this.kQe.startAnimation(AnimationUtils.loadAnimation(DownloadMainUI.this, C25738R.anim.f8419e0));
            AppMethodBeat.m2505o(136226);
        }
    }

    /* renamed from: com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI$4 */
    class C429274 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI$4$1 */
        class C388681 implements Runnable {
            C388681() {
            }

            public final void run() {
                AppMethodBeat.m2504i(136227);
                DownloadMainUI.m76235a(DownloadMainUI.this, DownloadMainUI.this.kQi, false);
                AppMethodBeat.m2505o(136227);
            }
        }

        /* renamed from: com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI$4$2 */
        class C429282 implements Runnable {
            C429282() {
            }

            public final void run() {
                AppMethodBeat.m2504i(136228);
                DownloadMainUI.m76241f(DownloadMainUI.this);
                AppMethodBeat.m2505o(136228);
            }
        }

        C429274() {
        }

        public final void run() {
            AppMethodBeat.m2504i(136229);
            DownloadMainUI.this.kQi = C27716g.biM();
            C5004al.m7441d(new C388681());
            boolean a = DownloadMainUI.m76236a(DownloadMainUI.this, DownloadMainUI.this.mAppId);
            if (DownloadMainUI.this.kQj || a) {
                DownloadMainUI.this.mo68456c(C45837j.biP(), null);
                AppMethodBeat.m2505o(136229);
                return;
            }
            LinkedList biP = C45837j.biP();
            if (!biP.contains(DownloadMainUI.this.mAppId)) {
                biP.add(DownloadMainUI.this.mAppId);
            }
            DownloadMainUI.this.mo68456c(biP, DownloadMainUI.this.mAppId);
            C18514l.m28819q(new C429282());
            AppMethodBeat.m2505o(136229);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m76235a(DownloadMainUI downloadMainUI, C27715f c27715f, boolean z) {
        AppMethodBeat.m2504i(136248);
        downloadMainUI.m76234a(c27715f, z);
        AppMethodBeat.m2505o(136248);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(136237);
        super.onCreate(bundle);
        overridePendingTransition(C5206a.yng, C5206a.ynh);
        C4990ab.m7416i("MicroMsg.DownloadMainUI", "onCreate: " + System.currentTimeMillis());
        this.kQh = true;
        mo17446xE(getResources().getColor(C25738R.color.f11947ms));
        dyc();
        setMMTitle((int) C25738R.string.g0e);
        setBackBtn(new C429251());
        addIconOptionMenu(0, C1318a.actionbar_icon_dark_search, new C388672());
        this.kQc = (TaskListView) findViewById(2131820986);
        this.kQd = (DeleteTaskFooterView) findViewById(2131823319);
        this.kQc.kRa = new C429263();
        this.kQe = (TaskManagerHeaderView) findViewById(2131822020);
        this.kQf = findViewById(2131823320);
        this.mAppId = getIntent().getStringExtra("appId");
        this.kQj = getIntent().getBooleanExtra("view_task", false);
        C46494g.m87739bT(this.mAppId, true);
        m76231Kh();
        C45838a.m84850a(10, 0, 0, 1, "", "", "");
        AppMethodBeat.m2505o(136237);
    }

    public void onResume() {
        AppMethodBeat.m2504i(136238);
        super.onResume();
        this.kQg = true;
        if (!this.kQh) {
            this.kQi = C27716g.biM();
            m76234a(this.kQi, true);
        }
        this.kQh = false;
        AppMethodBeat.m2505o(136238);
    }

    public void onPause() {
        AppMethodBeat.m2504i(136239);
        super.onPause();
        if (this.kQi != null) {
            ((C34261a) C1720g.m3528K(C34261a.class)).mo23946a("pb_appinfo", this.kQi.kOS);
        }
        this.kQg = false;
        AppMethodBeat.m2505o(136239);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(136240);
        setIntent(intent);
        this.kQc.biU();
        this.mAppId = intent.getStringExtra("appId");
        this.kQj = intent.getBooleanExtra("view_task", false);
        C46494g.m87739bT(this.mAppId, true);
        m76231Kh();
        AppMethodBeat.m2505o(136240);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(136241);
        super.onDestroy();
        C27716g.kOX = null;
        AppMethodBeat.m2505o(136241);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(136242);
        if (this.kQc != null) {
            Object obj;
            TaskListView taskListView = this.kQc;
            if (taskListView.kRb) {
                taskListView.biU();
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                AppMethodBeat.m2505o(136242);
                return;
            }
        }
        super.onBackPressed();
        AppMethodBeat.m2505o(136242);
    }

    /* renamed from: Kh */
    private void m76231Kh() {
        AppMethodBeat.m2504i(136243);
        C7305d.xDG.execute(new C429274());
        AppMethodBeat.m2505o(136243);
    }

    /* renamed from: c */
    public final void mo68456c(LinkedList<String> linkedList, final String str) {
        AppMethodBeat.m2504i(136244);
        C27716g.m44026a(linkedList, new C27717a() {

            /* renamed from: com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI$8$1 */
            class C277221 implements Runnable {
                C277221() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(136233);
                    DownloadMainUI.m76243h(DownloadMainUI.this);
                    AppMethodBeat.m2505o(136233);
                }
            }

            /* renamed from: com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI$8$2 */
            class C277232 implements Runnable {
                C277232() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(136235);
                    if (!C5046bo.isNullOrNil(str)) {
                        final C38861i IL = DownloadMainUI.this.kQi.mo45550IL(str);
                        if (IL != null) {
                            C45837j.m84846Iz(str);
                            C18514l.postDelayed(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.m2504i(136234);
                                    C45836c.m84837a(DownloadMainUI.this, IL, true);
                                    AppMethodBeat.m2505o(136234);
                                }
                            }, 200);
                        } else {
                            C30379h.m48461b(DownloadMainUI.this, "", DownloadMainUI.this.getResources().getString(C25738R.string.d7h), true);
                        }
                    }
                    DownloadMainUI.m76235a(DownloadMainUI.this, DownloadMainUI.this.kQi, true);
                    AppMethodBeat.m2505o(136235);
                }
            }

            /* renamed from: gd */
            public final void mo23230gd(boolean z) {
                AppMethodBeat.m2504i(136236);
                C18514l.m28819q(new C277221());
                if (z) {
                    DownloadMainUI.this.kQi = C27716g.biM();
                    C5004al.m7441d(new C277232());
                    AppMethodBeat.m2505o(136236);
                    return;
                }
                if (!C5046bo.isNullOrNil(str)) {
                    C30379h.m48461b(DownloadMainUI.this, "", DownloadMainUI.this.getResources().getString(C25738R.string.ail), true);
                }
                AppMethodBeat.m2505o(136236);
            }
        });
        AppMethodBeat.m2505o(136244);
    }

    /* renamed from: a */
    private void m76234a(C27715f c27715f, boolean z) {
        C27701f c27701f;
        AppMethodBeat.m2504i(136245);
        if (c27715f != null) {
            c27701f = c27715f.kOV;
        } else {
            c27701f = null;
        }
        this.kOV = c27701f;
        if (c27715f == null || c27715f.biL()) {
            if (z) {
                mo68458gk(true);
            }
            AppMethodBeat.m2505o(136245);
            return;
        }
        LinkedList O = c27715f.mo45551O(C45837j.biP());
        if (C5046bo.m7548ek(O)) {
            mo68458gk(true);
            AppMethodBeat.m2505o(136245);
            return;
        }
        mo68458gk(false);
        this.kQc.setData(O);
        AppMethodBeat.m2505o(136245);
    }

    /* renamed from: gj */
    public final void mo68457gj(boolean z) {
        AppMethodBeat.m2504i(136246);
        DeleteTaskFooterView deleteTaskFooterView = this.kQd;
        deleteTaskFooterView.kPZ = z;
        if (deleteTaskFooterView.kPZ) {
            deleteTaskFooterView.kPV.setImageResource(C25738R.drawable.at5);
            AppMethodBeat.m2505o(136246);
            return;
        }
        deleteTaskFooterView.kPV.setImageResource(C25738R.drawable.at6);
        AppMethodBeat.m2505o(136246);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: gk */
    public final void mo68458gk(boolean z) {
        AppMethodBeat.m2504i(136247);
        if (z) {
            if (this.kQf instanceof ViewStub) {
                this.kQf = ((ViewStub) this.kQf).inflate();
                this.kQf.setVisibility(0);
            }
        } else if (!(this.kQf instanceof ViewStub)) {
            this.kQf.setVisibility(8);
        }
        if (z) {
            this.kQf.setVisibility(0);
            ((NoTaskLayout) this.kQf).setData(this.kOV);
        }
        AppMethodBeat.m2505o(136247);
    }

    public final int getLayoutId() {
        return 2130969300;
    }

    /* renamed from: f */
    static /* synthetic */ void m76241f(DownloadMainUI downloadMainUI) {
        AppMethodBeat.m2504i(136250);
        if (downloadMainUI.emz == null) {
            downloadMainUI.emz = downloadMainUI.findViewById(2131821325);
            downloadMainUI.emz = ((ViewStub) downloadMainUI.emz).inflate();
        }
        downloadMainUI.emz.setVisibility(0);
        AppMethodBeat.m2505o(136250);
    }

    /* renamed from: h */
    static /* synthetic */ void m76243h(DownloadMainUI downloadMainUI) {
        AppMethodBeat.m2504i(136251);
        if (downloadMainUI.emz != null) {
            downloadMainUI.emz.setVisibility(8);
        }
        AppMethodBeat.m2505o(136251);
    }
}
