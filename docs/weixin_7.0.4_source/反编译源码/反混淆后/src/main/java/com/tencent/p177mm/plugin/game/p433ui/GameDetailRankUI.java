package com.tencent.p177mm.plugin.game.p433ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.game.model.C20992c;
import com.tencent.p177mm.plugin.game.model.C20998j;
import com.tencent.p177mm.plugin.game.model.C28219aa;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.game.ui.GameDetailRankUI */
public class GameDetailRankUI extends MMActivity {
    public static String EXTRA_SESSION_ID = "extra_session_id";
    public static String ngH = "gameDetailRankDataKey";
    private String appId;
    private ListView ngE;
    private GameRankHeadView ngF;
    private C12202i ngG;

    /* renamed from: com.tencent.mm.plugin.game.ui.GameDetailRankUI$2 */
    class C210172 implements OnMenuItemClickListener {
        C210172() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(111834);
            GameDetailRankUI.this.finish();
            AppMethodBeat.m2505o(111834);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameDetailRankUI$1 */
    class C282411 implements Runnable {
        C282411() {
        }

        public final void run() {
            AppMethodBeat.m2504i(111833);
            GameDetailRankUI.this.ngG.mo24034a(new C28219aa(GameDetailRankUI.this.appId));
            AppMethodBeat.m2505o(111833);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameDetailRankUI$a */
    public static class C34304a {
        public String ngJ;
        public String ngK;
        C20992c ngL;
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(111835);
        super.onCreate(bundle);
        C32800b nV = C37922v.m64076Zp().mo60674nV(getIntent().getStringExtra(EXTRA_SESSION_ID));
        if (nV == null) {
            finish();
            AppMethodBeat.m2505o(111835);
            return;
        }
        C34304a c34304a = (C34304a) nV.get(ngH);
        this.ngE = (ListView) findViewById(2131824452);
        if (!(C5046bo.isNullOrNil(c34304a.ngJ) || C5046bo.isNullOrNil(c34304a.ngK))) {
            View inflate = ((LayoutInflater) this.mController.ylL.getSystemService("layout_inflater")).inflate(2130969700, this.ngE, false);
            this.ngF = (GameRankHeadView) inflate.findViewById(2131824468);
            this.ngE.addHeaderView(inflate);
            this.ngF.setData(c34304a);
        }
        this.ngG = new C12202i(this);
        this.ngG.f2909Rt = 2130969694;
        this.ngE.setAdapter(this.ngG);
        this.appId = c34304a.ngL.field_appId;
        if (C5046bo.isNullOrNil(this.appId)) {
            finish();
            AppMethodBeat.m2505o(111835);
            return;
        }
        initView();
        C1720g.m3539RS().mo10302aa(new C282411());
        AppMethodBeat.m2505o(111835);
    }

    public void onResume() {
        AppMethodBeat.m2504i(111836);
        super.onResume();
        AppMethodBeat.m2505o(111836);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(111837);
        super.onDestroy();
        C20998j.m32288b(this.ngF.ngQ);
        AppMethodBeat.m2505o(111837);
    }

    public final int getLayoutId() {
        return 2130969693;
    }

    public final void initView() {
        AppMethodBeat.m2504i(111838);
        setMMTitle(C46494g.m87756t(this.mController.ylL, this.appId));
        setBackBtn(new C210172());
        AppMethodBeat.m2505o(111838);
    }
}
