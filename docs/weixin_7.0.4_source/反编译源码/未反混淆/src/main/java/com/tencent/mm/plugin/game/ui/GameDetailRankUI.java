package com.tencent.mm.plugin.game.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.game.model.aa;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.plugin.game.model.j;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

public class GameDetailRankUI extends MMActivity {
    public static String EXTRA_SESSION_ID = "extra_session_id";
    public static String ngH = "gameDetailRankDataKey";
    private String appId;
    private ListView ngE;
    private GameRankHeadView ngF;
    private i ngG;

    public static class a {
        public String ngJ;
        public String ngK;
        c ngL;
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(111835);
        super.onCreate(bundle);
        b nV = v.Zp().nV(getIntent().getStringExtra(EXTRA_SESSION_ID));
        if (nV == null) {
            finish();
            AppMethodBeat.o(111835);
            return;
        }
        a aVar = (a) nV.get(ngH);
        this.ngE = (ListView) findViewById(R.id.c4m);
        if (!(bo.isNullOrNil(aVar.ngJ) || bo.isNullOrNil(aVar.ngK))) {
            View inflate = ((LayoutInflater) this.mController.ylL.getSystemService("layout_inflater")).inflate(R.layout.a3k, this.ngE, false);
            this.ngF = (GameRankHeadView) inflate.findViewById(R.id.c52);
            this.ngE.addHeaderView(inflate);
            this.ngF.setData(aVar);
        }
        this.ngG = new i(this);
        this.ngG.Rt = R.layout.a3e;
        this.ngE.setAdapter(this.ngG);
        this.appId = aVar.ngL.field_appId;
        if (bo.isNullOrNil(this.appId)) {
            finish();
            AppMethodBeat.o(111835);
            return;
        }
        initView();
        g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(111833);
                GameDetailRankUI.this.ngG.a(new aa(GameDetailRankUI.this.appId));
                AppMethodBeat.o(111833);
            }
        });
        AppMethodBeat.o(111835);
    }

    public void onResume() {
        AppMethodBeat.i(111836);
        super.onResume();
        AppMethodBeat.o(111836);
    }

    public void onDestroy() {
        AppMethodBeat.i(111837);
        super.onDestroy();
        j.b(this.ngF.ngQ);
        AppMethodBeat.o(111837);
    }

    public final int getLayoutId() {
        return R.layout.a3d;
    }

    public final void initView() {
        AppMethodBeat.i(111838);
        setMMTitle(com.tencent.mm.pluginsdk.model.app.g.t(this.mController.ylL, this.appId));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(111834);
                GameDetailRankUI.this.finish();
                AppMethodBeat.o(111834);
                return true;
            }
        });
        AppMethodBeat.o(111838);
    }
}
