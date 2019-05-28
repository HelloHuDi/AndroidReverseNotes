package com.tencent.p177mm.plugin.game.p433ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.game.model.C12160ar;
import com.tencent.p177mm.plugin.game.model.C20993e;
import com.tencent.p177mm.plugin.game.model.C46013y;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.plugin.game.p433ui.C43205m.C21032a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.game.ui.GameCategoryUI */
public class GameCategoryUI extends MMActivity implements C1202f {
    private View emz;
    private Dialog iMU;
    private int mType;
    private int mXC = 0;
    private int mXJ = 0;
    private C21031k neZ = new C21031k();
    private ListView nfg;
    private C44745l nfh;
    private boolean nfi = false;
    private boolean nfj = false;
    private int nfk;
    private String nfl;
    private C21032a nfm = new C247763();
    private OnScrollListener nfn = new C431944();

    /* renamed from: com.tencent.mm.plugin.game.ui.GameCategoryUI$1 */
    class C210101 implements OnMenuItemClickListener {
        C210101() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(111745);
            GameCategoryUI.this.finish();
            AppMethodBeat.m2505o(111745);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameCategoryUI$3 */
    class C247763 implements C21032a {
        C247763() {
        }

        /* renamed from: wF */
        public final void mo36366wF(int i) {
            AppMethodBeat.m2504i(111747);
            int firstVisiblePosition = GameCategoryUI.this.nfg.getFirstVisiblePosition();
            int lastVisiblePosition = GameCategoryUI.this.nfg.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                GameCategoryUI.this.nfh.mo62134U(GameCategoryUI.this.nfg.getChildAt(i - firstVisiblePosition), i);
            }
            AppMethodBeat.m2505o(111747);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameCategoryUI$2 */
    class C282372 implements OnMenuItemClickListener {
        C282372() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(111746);
            Intent intent = new Intent(GameCategoryUI.this, GameSearchUI.class);
            switch (GameCategoryUI.this.mType) {
                case 1:
                    intent.putExtra("game_report_from_scene", 1602);
                    break;
                case 2:
                    intent.putExtra("game_report_from_scene", 1502);
                    break;
            }
            GameCategoryUI.this.startActivity(intent);
            AppMethodBeat.m2505o(111746);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameCategoryUI$4 */
    class C431944 implements OnScrollListener {
        C431944() {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.m2504i(111748);
            if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                if (!GameCategoryUI.this.nfj || GameCategoryUI.this.nfi) {
                    AppMethodBeat.m2505o(111748);
                    return;
                } else {
                    GameCategoryUI.this.emz.setVisibility(0);
                    GameCategoryUI.m85516g(GameCategoryUI.this);
                }
            }
            AppMethodBeat.m2505o(111748);
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public GameCategoryUI() {
        AppMethodBeat.m2504i(111751);
        AppMethodBeat.m2505o(111751);
    }

    /* renamed from: g */
    static /* synthetic */ void m85516g(GameCategoryUI gameCategoryUI) {
        AppMethodBeat.m2504i(111757);
        gameCategoryUI.bFi();
        AppMethodBeat.m2505o(111757);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(111752);
        super.onCreate(bundle);
        this.mType = getIntent().getIntExtra("extra_type", 0);
        this.nfk = getIntent().getIntExtra("extra_category_id", 0);
        this.nfl = getIntent().getStringExtra("extra_category_name");
        this.mXC = getIntent().getIntExtra("game_report_from_scene", 0);
        C1720g.m3540Rg().mo14539a(1220, (C1202f) this);
        setMMTitle(this.nfl);
        setBackBtn(new C210101());
        if (!C5046bo.isNullOrNil(C20993e.bEe())) {
            addIconOptionMenu(0, C25738R.string.ewn, C1318a.actionbar_icon_dark_search, new C282372());
        }
        this.nfg = (ListView) findViewById(2131824303);
        this.nfg.setOnItemClickListener(this.neZ);
        this.neZ.setSourceScene(this.mXC);
        this.nfg.setOnScrollListener(this.nfn);
        this.nfh = new C44745l(this);
        this.nfh.setSourceScene(this.mXC);
        this.nfh.mo62137a(this.nfm);
        this.emz = ((LayoutInflater) this.mController.ylL.getSystemService("layout_inflater")).inflate(2130969741, this.nfg, false);
        this.emz.setVisibility(8);
        this.nfg.addFooterView(this.emz);
        this.nfg.setAdapter(this.nfh);
        this.iMU = C46001c.m85459ej(this);
        this.iMU.show();
        bFi();
        AppMethodBeat.m2505o(111752);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(111753);
        super.onDestroy();
        C1720g.m3540Rg().mo14546b(1220, (C1202f) this);
        this.nfh.clear();
        AppMethodBeat.m2505o(111753);
    }

    public final int getLayoutId() {
        return 2130969657;
    }

    private void bFi() {
        AppMethodBeat.m2504i(111754);
        C1720g.m3540Rg().mo14541a(new C12160ar(this.mXJ, this.mType, this.nfk), 0);
        this.nfi = true;
        AppMethodBeat.m2505o(111754);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(111755);
        if (i == 0 && i2 == 0) {
            final C1331a c1331a = ((C12160ar) c1207m).lty.fsH.fsP;
            C1720g.m3539RS().mo10302aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(111750);
                    final C46013y c46013y = new C46013y(c1331a, GameCategoryUI.this.mType, GameCategoryUI.this.mXJ);
                    C5004al.m7441d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(111749);
                            GameCategoryUI.m85510a(GameCategoryUI.this, c46013y, GameCategoryUI.this.mXJ != 0);
                            GameCategoryUI.this.nfi = false;
                            GameCategoryUI.this.emz.setVisibility(8);
                            GameCategoryUI.this.mXJ = GameCategoryUI.this.mXJ + 15;
                            if (GameCategoryUI.this.iMU != null) {
                                GameCategoryUI.this.iMU.dismiss();
                            }
                            AppMethodBeat.m2505o(111749);
                        }
                    });
                    AppMethodBeat.m2505o(111750);
                }
            });
            AppMethodBeat.m2505o(111755);
            return;
        }
        C4990ab.m7413e("MicroMsg.GameCategoryUI", "errType: %d, errCode: %d", Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.m2505o(111755);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(111756);
        super.onActivityResult(i, i2, intent);
        C4990ab.m7417i("MicroMsg.GameCategoryUI", "requestCode = %d, resultCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i != 1) {
            C4990ab.m7412e("MicroMsg.GameCategoryUI", "error request code");
            AppMethodBeat.m2505o(111756);
            return;
        }
        String str = null;
        if (intent != null) {
            str = intent.getStringExtra("game_app_id");
        }
        switch (i2) {
            case 2:
                if (!C5046bo.isNullOrNil(str)) {
                    this.nfh.mo62131Oj(str);
                    this.nfh.mo62133Ol(str);
                    break;
                }
                AppMethodBeat.m2505o(111756);
                return;
            case 3:
                if (C5046bo.isNullOrNil(str)) {
                    AppMethodBeat.m2505o(111756);
                    return;
                }
                this.nfh.mo62132Ok(str);
                AppMethodBeat.m2505o(111756);
                return;
        }
        AppMethodBeat.m2505o(111756);
    }

    /* renamed from: a */
    static /* synthetic */ void m85510a(GameCategoryUI gameCategoryUI, C46013y c46013y, boolean z) {
        AppMethodBeat.m2504i(111758);
        gameCategoryUI.nfj = c46013y.mXH.nct;
        if (z) {
            gameCategoryUI.nfh.mo24020Y(c46013y.mXI);
            AppMethodBeat.m2505o(111758);
            return;
        }
        gameCategoryUI.nfh.mo24021Z(c46013y.mXI);
        AppMethodBeat.m2505o(111758);
    }
}
