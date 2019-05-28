package com.tencent.mm.plugin.game.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.ar;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.y;
import com.tencent.mm.plugin.game.ui.m.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

public class GameCategoryUI extends MMActivity implements f {
    private View emz;
    private Dialog iMU;
    private int mType;
    private int mXC = 0;
    private int mXJ = 0;
    private k neZ = new k();
    private ListView nfg;
    private l nfh;
    private boolean nfi = false;
    private boolean nfj = false;
    private int nfk;
    private String nfl;
    private a nfm = new a() {
        public final void wF(int i) {
            AppMethodBeat.i(111747);
            int firstVisiblePosition = GameCategoryUI.this.nfg.getFirstVisiblePosition();
            int lastVisiblePosition = GameCategoryUI.this.nfg.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                GameCategoryUI.this.nfh.U(GameCategoryUI.this.nfg.getChildAt(i - firstVisiblePosition), i);
            }
            AppMethodBeat.o(111747);
        }
    };
    private OnScrollListener nfn = new OnScrollListener() {
        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.i(111748);
            if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                if (!GameCategoryUI.this.nfj || GameCategoryUI.this.nfi) {
                    AppMethodBeat.o(111748);
                    return;
                } else {
                    GameCategoryUI.this.emz.setVisibility(0);
                    GameCategoryUI.g(GameCategoryUI.this);
                }
            }
            AppMethodBeat.o(111748);
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public GameCategoryUI() {
        AppMethodBeat.i(111751);
        AppMethodBeat.o(111751);
    }

    static /* synthetic */ void g(GameCategoryUI gameCategoryUI) {
        AppMethodBeat.i(111757);
        gameCategoryUI.bFi();
        AppMethodBeat.o(111757);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(111752);
        super.onCreate(bundle);
        this.mType = getIntent().getIntExtra("extra_type", 0);
        this.nfk = getIntent().getIntExtra("extra_category_id", 0);
        this.nfl = getIntent().getStringExtra("extra_category_name");
        this.mXC = getIntent().getIntExtra("game_report_from_scene", 0);
        g.Rg().a(1220, (f) this);
        setMMTitle(this.nfl);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(111745);
                GameCategoryUI.this.finish();
                AppMethodBeat.o(111745);
                return true;
            }
        });
        if (!bo.isNullOrNil(e.bEe())) {
            addIconOptionMenu(0, R.string.ewn, R.raw.actionbar_icon_dark_search, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(111746);
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
                    AppMethodBeat.o(111746);
                    return true;
                }
            });
        }
        this.nfg = (ListView) findViewById(R.id.c0l);
        this.nfg.setOnItemClickListener(this.neZ);
        this.neZ.setSourceScene(this.mXC);
        this.nfg.setOnScrollListener(this.nfn);
        this.nfh = new l(this);
        this.nfh.setSourceScene(this.mXC);
        this.nfh.a(this.nfm);
        this.emz = ((LayoutInflater) this.mController.ylL.getSystemService("layout_inflater")).inflate(R.layout.a4o, this.nfg, false);
        this.emz.setVisibility(8);
        this.nfg.addFooterView(this.emz);
        this.nfg.setAdapter(this.nfh);
        this.iMU = c.ej(this);
        this.iMU.show();
        bFi();
        AppMethodBeat.o(111752);
    }

    public void onDestroy() {
        AppMethodBeat.i(111753);
        super.onDestroy();
        g.Rg().b(1220, (f) this);
        this.nfh.clear();
        AppMethodBeat.o(111753);
    }

    public final int getLayoutId() {
        return R.layout.a2e;
    }

    private void bFi() {
        AppMethodBeat.i(111754);
        g.Rg().a(new ar(this.mXJ, this.mType, this.nfk), 0);
        this.nfi = true;
        AppMethodBeat.o(111754);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(111755);
        if (i == 0 && i2 == 0) {
            final com.tencent.mm.bt.a aVar = ((ar) mVar).lty.fsH.fsP;
            g.RS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(111750);
                    final y yVar = new y(aVar, GameCategoryUI.this.mType, GameCategoryUI.this.mXJ);
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(111749);
                            GameCategoryUI.a(GameCategoryUI.this, yVar, GameCategoryUI.this.mXJ != 0);
                            GameCategoryUI.this.nfi = false;
                            GameCategoryUI.this.emz.setVisibility(8);
                            GameCategoryUI.this.mXJ = GameCategoryUI.this.mXJ + 15;
                            if (GameCategoryUI.this.iMU != null) {
                                GameCategoryUI.this.iMU.dismiss();
                            }
                            AppMethodBeat.o(111749);
                        }
                    });
                    AppMethodBeat.o(111750);
                }
            });
            AppMethodBeat.o(111755);
            return;
        }
        ab.e("MicroMsg.GameCategoryUI", "errType: %d, errCode: %d", Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.o(111755);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(111756);
        super.onActivityResult(i, i2, intent);
        ab.i("MicroMsg.GameCategoryUI", "requestCode = %d, resultCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i != 1) {
            ab.e("MicroMsg.GameCategoryUI", "error request code");
            AppMethodBeat.o(111756);
            return;
        }
        String str = null;
        if (intent != null) {
            str = intent.getStringExtra("game_app_id");
        }
        switch (i2) {
            case 2:
                if (!bo.isNullOrNil(str)) {
                    this.nfh.Oj(str);
                    this.nfh.Ol(str);
                    break;
                }
                AppMethodBeat.o(111756);
                return;
            case 3:
                if (bo.isNullOrNil(str)) {
                    AppMethodBeat.o(111756);
                    return;
                }
                this.nfh.Ok(str);
                AppMethodBeat.o(111756);
                return;
        }
        AppMethodBeat.o(111756);
    }

    static /* synthetic */ void a(GameCategoryUI gameCategoryUI, y yVar, boolean z) {
        AppMethodBeat.i(111758);
        gameCategoryUI.nfj = yVar.mXH.nct;
        if (z) {
            gameCategoryUI.nfh.Y(yVar.mXI);
            AppMethodBeat.o(111758);
            return;
        }
        gameCategoryUI.nfh.Z(yVar.mXI);
        AppMethodBeat.o(111758);
    }
}
