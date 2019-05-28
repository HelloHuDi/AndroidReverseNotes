package com.tencent.p177mm.plugin.game.p433ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.C46692p.C30723a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.game.model.C20993e;
import com.tencent.p177mm.plugin.game.model.C28229n;
import com.tencent.p177mm.plugin.game.model.C28229n.C28231e;
import com.tencent.p177mm.plugin.game.model.C39215q;
import com.tencent.p177mm.plugin.game.model.C43192o;
import com.tencent.p177mm.plugin.game.p1268a.C43156b;
import com.tencent.p177mm.plugin.game.p1268a.C45983c;
import com.tencent.p177mm.plugin.game.p1485e.C34277b;
import com.tencent.p177mm.plugin.game.p1649b.C45984a;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.game.ui.GameMessageUI */
public class GameMessageUI extends GameCenterActivity implements OnItemClickListener, C1202f {
    private int edX = 0;
    private int emC;
    private TextView gqv;
    private OnScrollListener nfn = new C32624();
    private ListView nll;
    private C43207n nlm;
    private View nln;
    private int nlo = 1;
    private boolean nlp = false;
    private boolean nlq = false;
    private String nlr = "";
    private OnClickListener nls;
    private OnClickListener nlt;

    /* renamed from: com.tencent.mm.plugin.game.ui.GameMessageUI$2 */
    class C32582 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.game.ui.GameMessageUI$2$1 */
        class C32591 implements OnClickListener {
            C32591() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(112100);
                ((C45983c) C1720g.m3528K(C45983c.class)).bCY().mo16768hY("GameRawMessage", "delete from GameRawMessage");
                GameMessageUI.this.nlm.mo6870KD();
                GameMessageUI.this.nlm.notifyDataSetChanged();
                AppMethodBeat.m2505o(112100);
            }
        }

        /* renamed from: com.tencent.mm.plugin.game.ui.GameMessageUI$2$2 */
        class C32602 implements OnClickListener {
            C32602() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        C32582() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(112101);
            GameMessageUI.this.nls = new C32591();
            GameMessageUI.this.nlt = new C32602();
            C30379h.m48432a(GameMessageUI.this.mController.ylL, (int) C25738R.string.c4t, 0, GameMessageUI.this.nls, GameMessageUI.this.nlt);
            AppMethodBeat.m2505o(112101);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameMessageUI$3 */
    class C32613 implements C30723a {
        C32613() {
        }

        public final void apt() {
            AppMethodBeat.m2504i(112102);
            if (GameMessageUI.this.nlm.getCount() == 0) {
                GameMessageUI.this.nll.setVisibility(8);
                GameMessageUI.m32322a(GameMessageUI.this, 0);
                GameMessageUI.this.enableOptionMenu(false);
                AppMethodBeat.m2505o(112102);
                return;
            }
            GameMessageUI.this.nll.setVisibility(0);
            GameMessageUI.m32322a(GameMessageUI.this, 8);
            GameMessageUI.this.enableOptionMenu(true);
            AppMethodBeat.m2505o(112102);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameMessageUI$4 */
    class C32624 implements OnScrollListener {
        C32624() {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.m2504i(112103);
            if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && !GameMessageUI.this.nlm.bdn()) {
                GameMessageUI.this.nlm.bFr();
                GameMessageUI.this.nlm.mo5248a(null, null);
            }
            AppMethodBeat.m2505o(112103);
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameMessageUI$5 */
    class C32635 implements View.OnClickListener {
        C32635() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(112104);
            if (!C5046bo.isNullOrNil(GameMessageUI.this.nlr)) {
                C34277b.m56209a(GameMessageUI.this.mController.ylL, 13, 1302, 1, C46001c.m85455ax(GameMessageUI.this.mController.ylL, GameMessageUI.this.nlr), GameMessageUI.this.emC, null);
            }
            GameMessageUI.this.nlq = true;
            AppMethodBeat.m2505o(112104);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameMessageUI$1 */
    class C210251 implements OnMenuItemClickListener {
        C210251() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(112099);
            GameMessageUI.m32321a(GameMessageUI.this);
            AppMethodBeat.m2505o(112099);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public GameMessageUI() {
        AppMethodBeat.m2504i(112105);
        AppMethodBeat.m2505o(112105);
    }

    /* renamed from: a */
    static /* synthetic */ void m32321a(GameMessageUI gameMessageUI) {
        AppMethodBeat.m2504i(112116);
        gameMessageUI.goBack();
        AppMethodBeat.m2505o(112116);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(112106);
        super.onCreate(bundle);
        C1720g.m3540Rg().mo14539a(573, (C1202f) this);
        this.edX = getIntent().getIntExtra("game_unread_msg_count", 0);
        this.nlr = getIntent().getStringExtra("game_manage_url");
        initView();
        ((C43156b) C1720g.m3528K(C43156b.class)).bCX();
        C39215q.bEr();
        AppMethodBeat.m2505o(112106);
    }

    public void onResume() {
        AppMethodBeat.m2504i(112107);
        super.onResume();
        this.nlm.notifyDataSetChanged();
        if (this.nlq && this.nln != null) {
            this.nll.removeHeaderView(this.nln);
        }
        AppMethodBeat.m2505o(112107);
    }

    public final void initView() {
        AppMethodBeat.m2504i(112108);
        setMMTitle((int) C25738R.string.c70);
        setBackBtn(new C210251());
        addTextOptionMenu(0, getString(C25738R.string.f9078ou), new C32582());
        this.emC = getIntent().getIntExtra("game_report_from_scene", 0);
        this.nll = (ListView) findViewById(2131824570);
        this.nll.setOnItemClickListener(this);
        if (this.edX > 20) {
            bFv();
        }
        C28229n c28229n = new C28229n();
        c28229n.mXf = true;
        this.nlm = new C43207n(this, c28229n, this.emC);
        this.nlm.mo74996pN(true);
        m32331wN(8);
        this.nlm.mo74992a((C30723a) new C32613());
        this.nll.setOnScrollListener(this.nfn);
        this.nll.setAdapter(this.nlm);
        C34277b.m56210a(this.mController.ylL, 13, 1300, 0, 1, 0, null, this.emC, 0, null, null, null);
        AppMethodBeat.m2505o(112108);
    }

    /* renamed from: wN */
    private void m32331wN(int i) {
        AppMethodBeat.m2504i(112109);
        if (this.gqv == null) {
            this.gqv = (TextView) findViewById(2131824571);
        }
        this.gqv.setVisibility(i);
        AppMethodBeat.m2505o(112109);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(112110);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getRepeatCount() == 0) {
            goBack();
            AppMethodBeat.m2505o(112110);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(112110);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.m2504i(112111);
        ((C45983c) C1720g.m3528K(C45983c.class)).bCY().bEv();
        finish();
        AppMethodBeat.m2505o(112111);
    }

    public final int getLayoutId() {
        return 2130969754;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(112112);
        super.onDestroy();
        if (this.nlm != null) {
            this.nlm.bIf();
        }
        C1720g.m3540Rg().mo14546b(573, (C1202f) this);
        boolean hY = ((C45983c) C1720g.m3528K(C45983c.class)).bCY().mo16768hY("GameRawMessage", "delete from GameRawMessage where createTime < (" + "select createTime from GameRawMessage order by createTime desc limit 9999,1" + ")");
        C4990ab.m7417i("MicroMsg.GameMessageStorage", "clearMessageStorage: [%b], [%s]", Boolean.valueOf(hY), r1);
        ((C45983c) C1720g.m3528K(C45983c.class)).bCY().bEv();
        AppMethodBeat.m2505o(112112);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.m2504i(112113);
        C28229n c28229n = (C28229n) adapterView.getAdapter().getItem(i);
        if (c28229n == null) {
            C4990ab.m7413e("MicroMsg.GameMessageUI", "get message null: position:[%d]", Integer.valueOf(i));
            AppMethodBeat.m2505o(112113);
            return;
        }
        c28229n.bEl();
        int a;
        Bundle bundle;
        if (c28229n.field_msgType == 100) {
            if (!C5046bo.isNullOrNil(c28229n.mWO)) {
                C28231e c28231e = (C28231e) c28229n.mWu.get(c28229n.mWO);
                if (c28231e == null) {
                    AppMethodBeat.m2505o(112113);
                    return;
                }
                a = C43192o.m76770a(this, c28229n, c28231e, c28229n.field_appId, 1301);
                if (a != 0) {
                    C34277b.m56210a(this.mController.ylL, 13, 1301, 4, a, 0, c28229n.field_appId, this.emC, c28229n.mXb, c28229n.field_gameMsgId, c28229n.mXc, null);
                }
            }
            AppMethodBeat.m2505o(112113);
        } else if (c28229n.mXd == 0) {
            switch (c28229n.field_msgType) {
                case 2:
                case 5:
                    if (C46494g.m87757u(this, c28229n.field_appId)) {
                        C20993e.m32265ak(this, c28229n.field_appId);
                        a = 3;
                    } else {
                        bundle = new Bundle();
                        bundle.putCharSequence("game_app_id", c28229n.field_appId);
                        bundle.putInt("game_report_from_scene", 1301);
                        a = C46001c.m85457b(this, c28229n.field_appId, null, bundle);
                    }
                case 6:
                    if (!C5046bo.isNullOrNil(c28229n.mWJ)) {
                        a = C46001c.m85455ax(this, c28229n.mWJ);
                    }
                    break;
                case 10:
                case 11:
                    if (!C5046bo.isNullOrNil(c28229n.mWh)) {
                        a = C46001c.m85455ax(this, c28229n.mWh);
                    }
                    break;
            }
            C34277b.m56210a(this.mController.ylL, 13, 1301, 4, a, 0, c28229n.field_appId, this.emC, c28229n.field_msgType, c28229n.field_gameMsgId, c28229n.mXc, null);
            AppMethodBeat.m2505o(112113);
        } else {
            switch (c28229n.mXd) {
                case 1:
                    if (C5046bo.isNullOrNil(c28229n.field_appId)) {
                        C4990ab.m7412e("MicroMsg.GameMessageUI", "appid is null");
                        AppMethodBeat.m2505o(112113);
                        return;
                    }
                    bundle = new Bundle();
                    bundle.putCharSequence("game_app_id", c28229n.field_appId);
                    bundle.putInt("game_report_from_scene", 1301);
                    C34277b.m56210a(this.mController.ylL, 13, 1301, 4, C46001c.m85457b(this, c28229n.field_appId, null, bundle), 0, c28229n.field_appId, this.emC, c28229n.field_msgType, c28229n.field_gameMsgId, c28229n.mXc, null);
                    AppMethodBeat.m2505o(112113);
                    return;
                case 2:
                    if (C46494g.m87757u(this, c28229n.field_appId)) {
                        C20993e.m32265ak(this, c28229n.field_appId);
                        a = 3;
                    } else {
                        bundle = new Bundle();
                        bundle.putCharSequence("game_app_id", c28229n.field_appId);
                        bundle.putInt("game_report_from_scene", 1301);
                        a = C46001c.m85457b(this, c28229n.field_appId, null, bundle);
                    }
                    C34277b.m56210a(this.mController.ylL, 13, 1301, 4, a, 0, c28229n.field_appId, this.emC, c28229n.field_msgType, c28229n.field_gameMsgId, c28229n.mXc, null);
                    AppMethodBeat.m2505o(112113);
                    return;
                case 3:
                    if (C5046bo.isNullOrNil(c28229n.mXe)) {
                        C4990ab.m7412e("MicroMsg.GameMessageUI", "jumpurl is null");
                        AppMethodBeat.m2505o(112113);
                        return;
                    }
                    C34277b.m56210a(this.mController.ylL, 13, 1301, 4, C46001c.m85455ax(this, c28229n.mXe), 0, c28229n.field_appId, this.emC, c28229n.field_msgType, c28229n.field_gameMsgId, c28229n.mXc, null);
                    AppMethodBeat.m2505o(112113);
                    return;
                default:
                    C4990ab.m7412e("MicroMsg.GameMessageUI", "unknowed jumptype : " + c28229n.mXd);
                    AppMethodBeat.m2505o(112113);
                    return;
            }
        }
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(112114);
        C4990ab.m7417i("MicroMsg.GameMessageUI", "onSceneEnd: errType:[%d], errCode:[%d], type:[%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(c1207m.getType()));
        if (i == 0 && i2 == 0) {
            if (c1207m.getType() == 573) {
                m32331wN(8);
                this.nlm.mo5248a(null, null);
                AppMethodBeat.m2505o(112114);
                return;
            }
        } else if (this.nlm.getCount() > 0) {
            C4990ab.m7416i("MicroMsg.GameMessageUI", "has local message, do not show error tips");
            AppMethodBeat.m2505o(112114);
            return;
        } else if (C45984a.gkF.mo38859a((Context) this, i, i2, str)) {
            AppMethodBeat.m2505o(112114);
            return;
        } else {
            Toast.makeText(this, getString(C25738R.string.c5w, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
        AppMethodBeat.m2505o(112114);
    }

    private void bFv() {
        AppMethodBeat.m2504i(112115);
        if (C20993e.m32276ec(this)) {
            this.nln = View.inflate(this, 2130969758, null);
            this.nln.setOnClickListener(new C32635());
            this.nll.addHeaderView(this.nln);
            this.nln.setVisibility(0);
            C20993e.m32277ed(this);
            AppMethodBeat.m2505o(112115);
            return;
        }
        if (this.nln != null) {
            this.nln.setVisibility(8);
        }
        AppMethodBeat.m2505o(112115);
    }

    public final int bFf() {
        return 13;
    }

    public final int bFg() {
        return 1300;
    }

    public final int bFh() {
        return this.emC;
    }
}
