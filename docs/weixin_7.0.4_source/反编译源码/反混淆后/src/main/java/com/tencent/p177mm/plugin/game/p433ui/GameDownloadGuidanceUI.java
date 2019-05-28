package com.tencent.p177mm.plugin.game.p433ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.plugin.game.model.C12156ab;
import com.tencent.p177mm.plugin.game.model.C20993e;
import com.tencent.p177mm.plugin.game.model.C34295ao;
import com.tencent.p177mm.plugin.game.p1268a.C43156b;
import com.tencent.p177mm.plugin.game.p1268a.C45983c;
import com.tencent.p177mm.plugin.game.p1485e.C34277b;
import com.tencent.p177mm.plugin.game.p1649b.C45984a;
import com.tencent.p177mm.plugin.game.p428f.C46000a.C3220a;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.plugin.game.p731d.C20948bi;
import com.tencent.p177mm.plugin.game.p731d.C28199p;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.game.ui.GameDownloadGuidanceUI */
public class GameDownloadGuidanceUI extends GameCenterBaseUI implements C1202f {
    private Dialog lud;
    private C20948bi mXT;
    private LinearLayout mpt;
    private TextView nhO;
    private TextView nhP;
    private TextView nhQ;
    private boolean nhR;
    private String nhS = "";

    /* renamed from: com.tencent.mm.plugin.game.ui.GameDownloadGuidanceUI$4 */
    class C32514 implements OnMenuItemClickListener {
        C32514() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(111884);
            C34277b.m56209a(GameDownloadGuidanceUI.this.mController.ylL, 10, 1008, 1, C46001c.m85455ax(GameDownloadGuidanceUI.this.mController.ylL, GameDownloadGuidanceUI.this.nhS), GameDownloadGuidanceUI.this.mXC, null);
            AppMethodBeat.m2505o(111884);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameDownloadGuidanceUI$2 */
    class C343072 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.game.ui.GameDownloadGuidanceUI$2$1 */
        class C343091 implements Runnable {
            C343091() {
            }

            public final void run() {
                AppMethodBeat.m2504i(111880);
                if (GameDownloadGuidanceUI.this.isFinishing()) {
                    AppMethodBeat.m2505o(111880);
                    return;
                }
                GameDownloadGuidanceUI.this.lud = C46001c.m85459ej(GameDownloadGuidanceUI.this);
                GameDownloadGuidanceUI.this.lud.show();
                AppMethodBeat.m2505o(111880);
            }
        }

        C343072() {
        }

        public final void run() {
            AppMethodBeat.m2504i(111882);
            byte[] NK = ((C45983c) C1720g.m3528K(C45983c.class)).bCZ().mo54825NK("pb_download_guidance");
            if (NK == null) {
                C5004al.m7441d(new C343091());
            } else {
                final C12156ab c12156ab = new C12156ab(NK);
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(111881);
                        try {
                            GameDownloadGuidanceUI.this.mo54834a(c12156ab, 1);
                            AppMethodBeat.m2505o(111881);
                        } catch (Exception e) {
                            C4990ab.m7413e("MicroMsg.GameDownloadGuidanceUI", "GameDownloadGuidanceUI crash, %s", e.getMessage());
                            GameDownloadGuidanceUI.this.finish();
                            AppMethodBeat.m2505o(111881);
                        }
                    }
                });
            }
            C1720g.m3540Rg().mo14541a(new C34295ao(C4988aa.dor(), C20993e.bDR(), GameDownloadGuidanceUI.this.nfw, GameDownloadGuidanceUI.this.nfx, GameDownloadGuidanceUI.this.nfy, GameDownloadGuidanceUI.this.nfv), 0);
            C20993e.bDW();
            C3220a.nnu.bFC();
            AppMethodBeat.m2505o(111882);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameDownloadGuidanceUI$3 */
    class C343103 implements Runnable {
        C343103() {
        }

        public final void run() {
            AppMethodBeat.m2504i(111883);
            ((C45983c) C1720g.m3528K(C45983c.class)).bCZ().mo54826b("pb_over_sea", GameDownloadGuidanceUI.this.mXT);
            AppMethodBeat.m2505o(111883);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameDownloadGuidanceUI$1 */
    class C343111 implements OnMenuItemClickListener {
        C343111() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(111879);
            GameDownloadGuidanceUI.this.finish();
            AppMethodBeat.m2505o(111879);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(111887);
        super.onCreate(bundle);
        C1720g.m3540Rg().mo14539a(2586, (C1202f) this);
        initView();
        C46001c.aNS().mo10302aa(new C343072());
        AppMethodBeat.m2505o(111887);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(111888);
        C4990ab.m7416i("MicroMsg.GameDownloadGuidanceUI", "onDestroy");
        super.onDestroy();
        C3220a.nnu.clearCache();
        C1720g.m3540Rg().mo14546b(2586, (C1202f) this);
        ((C43156b) C1720g.m3528K(C43156b.class)).bCV().clearCache();
        AppMethodBeat.m2505o(111888);
    }

    public final void initView() {
        AppMethodBeat.m2504i(111889);
        setBackBtn(new C343111());
        setMMTitle((int) C25738R.string.c8c);
        this.mpt = (LinearLayout) findViewById(2131821064);
        this.nhO = (TextView) findViewById(2131824519);
        this.nhP = (TextView) findViewById(2131824520);
        this.nhQ = (TextView) findViewById(2131824521);
        AppMethodBeat.m2505o(111889);
    }

    /* renamed from: a */
    public final void mo54834a(C12156ab c12156ab, int i) {
        AppMethodBeat.m2504i(111890);
        if (isFinishing()) {
            C4990ab.m7420w("MicroMsg.GameDownloadGuidanceUI", "GameDownloadGuidanceUI hasFinished");
            AppMethodBeat.m2505o(111890);
        } else if (c12156ab == null || c12156ab.bEJ() == null) {
            C4990ab.m7412e("MicroMsg.GameDownloadGuidanceUI", "Null data");
            AppMethodBeat.m2505o(111890);
        } else {
            if (c12156ab == null || c12156ab.bEK() == null) {
                this.nhS = "";
            } else {
                this.nhS = c12156ab.bEK().mZj;
            }
            if (C5046bo.isNullOrNil(this.nhS)) {
                if (this.nhR) {
                    removeOptionMenu(0);
                    this.nhR = false;
                }
            } else if (!this.nhR) {
                addIconOptionMenu(0, C1318a.actionbar_setting_icon, new C32514());
                this.nhR = true;
            }
            this.mpt.setVisibility(0);
            C28199p bEJ = c12156ab.bEJ();
            if (C5046bo.isNullOrNil(bEJ.mZZ)) {
                this.nhO.setVisibility(8);
            } else {
                this.nhO.setText(bEJ.mZZ);
                this.nhO.setVisibility(0);
            }
            if (C5046bo.isNullOrNil(bEJ.naa)) {
                this.nhP.setVisibility(8);
            } else {
                this.nhP.setText(bEJ.naa);
                this.nhP.setVisibility(0);
            }
            if (C5046bo.isNullOrNil(bEJ.nab)) {
                this.nhQ.setVisibility(8);
            } else {
                this.nhQ.setText(bEJ.nab);
                this.nhQ.setVisibility(0);
            }
            if (i == 2) {
                C46001c.aNS().mo10302aa(new C343103());
            }
            AppMethodBeat.m2505o(111890);
        }
    }

    public final int getLayoutId() {
        return 2130969722;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(111891);
        C4990ab.m7417i("MicroMsg.GameDownloadGuidanceUI", "errType: %d errCode: %d, scene: %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(c1207m.hashCode()));
        if (i == 0 && i2 == 0) {
            switch (c1207m.getType()) {
                case 2586:
                    final long currentTimeMillis = System.currentTimeMillis();
                    final C1331a c1331a = ((C34295ao) c1207m).lty.fsH.fsP;
                    C46001c.aNS().mo10302aa(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(111886);
                            if (c1331a == null) {
                                GameDownloadGuidanceUI.this.mXT = new C20948bi();
                            } else {
                                GameDownloadGuidanceUI.this.mXT = (C20948bi) c1331a;
                            }
                            final C12156ab c12156ab = new C12156ab(c1331a);
                            C5004al.m7441d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.m2504i(111885);
                                    try {
                                        GameDownloadGuidanceUI.this.mo54834a(c12156ab, 2);
                                    } catch (Exception e) {
                                        C4990ab.m7413e("MicroMsg.GameDownloadGuidanceUI", "GameDownloadGuidanceUI crash, %s", e.getMessage());
                                        GameDownloadGuidanceUI.this.finish();
                                    }
                                    if (GameDownloadGuidanceUI.this.lud != null) {
                                        GameDownloadGuidanceUI.this.lud.dismiss();
                                    }
                                    C4990ab.m7417i("MicroMsg.GameDownloadGuidanceUI", "Server data parsing time: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                    AppMethodBeat.m2505o(111885);
                                }
                            });
                            AppMethodBeat.m2505o(111886);
                        }
                    });
                    break;
            }
            AppMethodBeat.m2505o(111891);
            return;
        }
        if (!C45984a.gkF.mo38859a((Context) this, i, i2, str)) {
            Toast.makeText(this, getString(C25738R.string.c6n, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
        if (this.lud != null) {
            this.lud.cancel();
        }
        AppMethodBeat.m2505o(111891);
    }
}
