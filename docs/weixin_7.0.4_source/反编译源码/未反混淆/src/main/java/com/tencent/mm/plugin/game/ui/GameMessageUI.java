package com.tencent.mm.plugin.game.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.b;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.plugin.game.model.n.e;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.p.a;

public class GameMessageUI extends GameCenterActivity implements OnItemClickListener, f {
    private int edX = 0;
    private int emC;
    private TextView gqv;
    private OnScrollListener nfn = new OnScrollListener() {
        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.i(112103);
            if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && !GameMessageUI.this.nlm.bdn()) {
                GameMessageUI.this.nlm.bFr();
                GameMessageUI.this.nlm.a(null, null);
            }
            AppMethodBeat.o(112103);
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private ListView nll;
    private n nlm;
    private View nln;
    private int nlo = 1;
    private boolean nlp = false;
    private boolean nlq = false;
    private String nlr = "";
    private OnClickListener nls;
    private OnClickListener nlt;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public GameMessageUI() {
        AppMethodBeat.i(112105);
        AppMethodBeat.o(112105);
    }

    static /* synthetic */ void a(GameMessageUI gameMessageUI) {
        AppMethodBeat.i(112116);
        gameMessageUI.goBack();
        AppMethodBeat.o(112116);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(112106);
        super.onCreate(bundle);
        g.Rg().a(573, (f) this);
        this.edX = getIntent().getIntExtra("game_unread_msg_count", 0);
        this.nlr = getIntent().getStringExtra("game_manage_url");
        initView();
        ((b) g.K(b.class)).bCX();
        q.bEr();
        AppMethodBeat.o(112106);
    }

    public void onResume() {
        AppMethodBeat.i(112107);
        super.onResume();
        this.nlm.notifyDataSetChanged();
        if (this.nlq && this.nln != null) {
            this.nll.removeHeaderView(this.nln);
        }
        AppMethodBeat.o(112107);
    }

    public final void initView() {
        AppMethodBeat.i(112108);
        setMMTitle((int) R.string.c70);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(112099);
                GameMessageUI.a(GameMessageUI.this);
                AppMethodBeat.o(112099);
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.ou), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(112101);
                GameMessageUI.this.nls = new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(112100);
                        ((c) g.K(c.class)).bCY().hY("GameRawMessage", "delete from GameRawMessage");
                        GameMessageUI.this.nlm.KD();
                        GameMessageUI.this.nlm.notifyDataSetChanged();
                        AppMethodBeat.o(112100);
                    }
                };
                GameMessageUI.this.nlt = new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                };
                h.a(GameMessageUI.this.mController.ylL, (int) R.string.c4t, 0, GameMessageUI.this.nls, GameMessageUI.this.nlt);
                AppMethodBeat.o(112101);
                return false;
            }
        });
        this.emC = getIntent().getIntExtra("game_report_from_scene", 0);
        this.nll = (ListView) findViewById(R.id.c7t);
        this.nll.setOnItemClickListener(this);
        if (this.edX > 20) {
            bFv();
        }
        n nVar = new n();
        nVar.mXf = true;
        this.nlm = new n(this, nVar, this.emC);
        this.nlm.pN(true);
        wN(8);
        this.nlm.a((a) new a() {
            public final void apt() {
                AppMethodBeat.i(112102);
                if (GameMessageUI.this.nlm.getCount() == 0) {
                    GameMessageUI.this.nll.setVisibility(8);
                    GameMessageUI.a(GameMessageUI.this, 0);
                    GameMessageUI.this.enableOptionMenu(false);
                    AppMethodBeat.o(112102);
                    return;
                }
                GameMessageUI.this.nll.setVisibility(0);
                GameMessageUI.a(GameMessageUI.this, 8);
                GameMessageUI.this.enableOptionMenu(true);
                AppMethodBeat.o(112102);
            }
        });
        this.nll.setOnScrollListener(this.nfn);
        this.nll.setAdapter(this.nlm);
        com.tencent.mm.plugin.game.e.b.a(this.mController.ylL, 13, 1300, 0, 1, 0, null, this.emC, 0, null, null, null);
        AppMethodBeat.o(112108);
    }

    private void wN(int i) {
        AppMethodBeat.i(112109);
        if (this.gqv == null) {
            this.gqv = (TextView) findViewById(R.id.c7u);
        }
        this.gqv.setVisibility(i);
        AppMethodBeat.o(112109);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(112110);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getRepeatCount() == 0) {
            goBack();
            AppMethodBeat.o(112110);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(112110);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.i(112111);
        ((c) g.K(c.class)).bCY().bEv();
        finish();
        AppMethodBeat.o(112111);
    }

    public final int getLayoutId() {
        return R.layout.a51;
    }

    public void onDestroy() {
        AppMethodBeat.i(112112);
        super.onDestroy();
        if (this.nlm != null) {
            this.nlm.bIf();
        }
        g.Rg().b(573, (f) this);
        boolean hY = ((c) g.K(c.class)).bCY().hY("GameRawMessage", "delete from GameRawMessage where createTime < (" + "select createTime from GameRawMessage order by createTime desc limit 9999,1" + ")");
        ab.i("MicroMsg.GameMessageStorage", "clearMessageStorage: [%b], [%s]", Boolean.valueOf(hY), r1);
        ((c) g.K(c.class)).bCY().bEv();
        AppMethodBeat.o(112112);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.i(112113);
        n nVar = (n) adapterView.getAdapter().getItem(i);
        if (nVar == null) {
            ab.e("MicroMsg.GameMessageUI", "get message null: position:[%d]", Integer.valueOf(i));
            AppMethodBeat.o(112113);
            return;
        }
        nVar.bEl();
        int a;
        Bundle bundle;
        if (nVar.field_msgType == 100) {
            if (!bo.isNullOrNil(nVar.mWO)) {
                e eVar = (e) nVar.mWu.get(nVar.mWO);
                if (eVar == null) {
                    AppMethodBeat.o(112113);
                    return;
                }
                a = o.a(this, nVar, eVar, nVar.field_appId, 1301);
                if (a != 0) {
                    com.tencent.mm.plugin.game.e.b.a(this.mController.ylL, 13, 1301, 4, a, 0, nVar.field_appId, this.emC, nVar.mXb, nVar.field_gameMsgId, nVar.mXc, null);
                }
            }
            AppMethodBeat.o(112113);
        } else if (nVar.mXd == 0) {
            switch (nVar.field_msgType) {
                case 2:
                case 5:
                    if (com.tencent.mm.pluginsdk.model.app.g.u(this, nVar.field_appId)) {
                        com.tencent.mm.plugin.game.model.e.ak(this, nVar.field_appId);
                        a = 3;
                    } else {
                        bundle = new Bundle();
                        bundle.putCharSequence("game_app_id", nVar.field_appId);
                        bundle.putInt("game_report_from_scene", 1301);
                        a = com.tencent.mm.plugin.game.f.c.b(this, nVar.field_appId, null, bundle);
                    }
                case 6:
                    if (!bo.isNullOrNil(nVar.mWJ)) {
                        a = com.tencent.mm.plugin.game.f.c.ax(this, nVar.mWJ);
                    }
                    break;
                case 10:
                case 11:
                    if (!bo.isNullOrNil(nVar.mWh)) {
                        a = com.tencent.mm.plugin.game.f.c.ax(this, nVar.mWh);
                    }
                    break;
            }
            com.tencent.mm.plugin.game.e.b.a(this.mController.ylL, 13, 1301, 4, a, 0, nVar.field_appId, this.emC, nVar.field_msgType, nVar.field_gameMsgId, nVar.mXc, null);
            AppMethodBeat.o(112113);
        } else {
            switch (nVar.mXd) {
                case 1:
                    if (bo.isNullOrNil(nVar.field_appId)) {
                        ab.e("MicroMsg.GameMessageUI", "appid is null");
                        AppMethodBeat.o(112113);
                        return;
                    }
                    bundle = new Bundle();
                    bundle.putCharSequence("game_app_id", nVar.field_appId);
                    bundle.putInt("game_report_from_scene", 1301);
                    com.tencent.mm.plugin.game.e.b.a(this.mController.ylL, 13, 1301, 4, com.tencent.mm.plugin.game.f.c.b(this, nVar.field_appId, null, bundle), 0, nVar.field_appId, this.emC, nVar.field_msgType, nVar.field_gameMsgId, nVar.mXc, null);
                    AppMethodBeat.o(112113);
                    return;
                case 2:
                    if (com.tencent.mm.pluginsdk.model.app.g.u(this, nVar.field_appId)) {
                        com.tencent.mm.plugin.game.model.e.ak(this, nVar.field_appId);
                        a = 3;
                    } else {
                        bundle = new Bundle();
                        bundle.putCharSequence("game_app_id", nVar.field_appId);
                        bundle.putInt("game_report_from_scene", 1301);
                        a = com.tencent.mm.plugin.game.f.c.b(this, nVar.field_appId, null, bundle);
                    }
                    com.tencent.mm.plugin.game.e.b.a(this.mController.ylL, 13, 1301, 4, a, 0, nVar.field_appId, this.emC, nVar.field_msgType, nVar.field_gameMsgId, nVar.mXc, null);
                    AppMethodBeat.o(112113);
                    return;
                case 3:
                    if (bo.isNullOrNil(nVar.mXe)) {
                        ab.e("MicroMsg.GameMessageUI", "jumpurl is null");
                        AppMethodBeat.o(112113);
                        return;
                    }
                    com.tencent.mm.plugin.game.e.b.a(this.mController.ylL, 13, 1301, 4, com.tencent.mm.plugin.game.f.c.ax(this, nVar.mXe), 0, nVar.field_appId, this.emC, nVar.field_msgType, nVar.field_gameMsgId, nVar.mXc, null);
                    AppMethodBeat.o(112113);
                    return;
                default:
                    ab.e("MicroMsg.GameMessageUI", "unknowed jumptype : " + nVar.mXd);
                    AppMethodBeat.o(112113);
                    return;
            }
        }
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(112114);
        ab.i("MicroMsg.GameMessageUI", "onSceneEnd: errType:[%d], errCode:[%d], type:[%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(mVar.getType()));
        if (i == 0 && i2 == 0) {
            if (mVar.getType() == 573) {
                wN(8);
                this.nlm.a(null, null);
                AppMethodBeat.o(112114);
                return;
            }
        } else if (this.nlm.getCount() > 0) {
            ab.i("MicroMsg.GameMessageUI", "has local message, do not show error tips");
            AppMethodBeat.o(112114);
            return;
        } else if (com.tencent.mm.plugin.game.b.a.gkF.a((Context) this, i, i2, str)) {
            AppMethodBeat.o(112114);
            return;
        } else {
            Toast.makeText(this, getString(R.string.c5w, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
        AppMethodBeat.o(112114);
    }

    private void bFv() {
        AppMethodBeat.i(112115);
        if (com.tencent.mm.plugin.game.model.e.ec(this)) {
            this.nln = View.inflate(this, R.layout.a55, null);
            this.nln.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(112104);
                    if (!bo.isNullOrNil(GameMessageUI.this.nlr)) {
                        com.tencent.mm.plugin.game.e.b.a(GameMessageUI.this.mController.ylL, 13, 1302, 1, com.tencent.mm.plugin.game.f.c.ax(GameMessageUI.this.mController.ylL, GameMessageUI.this.nlr), GameMessageUI.this.emC, null);
                    }
                    GameMessageUI.this.nlq = true;
                    AppMethodBeat.o(112104);
                }
            });
            this.nll.addHeaderView(this.nln);
            this.nln.setVisibility(0);
            com.tencent.mm.plugin.game.model.e.ed(this);
            AppMethodBeat.o(112115);
            return;
        }
        if (this.nln != null) {
            this.nln.setVisibility(8);
        }
        AppMethodBeat.o(112115);
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
