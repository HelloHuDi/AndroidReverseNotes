package com.tencent.mm.plugin.game.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.ui.GameRegionPreference.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.q.b;
import java.util.Map;

public class GameRegionSelectUI extends MMPreference {
    private f ehK;
    private a nlP;
    private Map<String, a> nlT;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(112161);
        super.onCreate(bundle);
        this.ehK = this.yCw;
        initView();
        AppMethodBeat.o(112161);
    }

    public final int JC() {
        return -1;
    }

    public final void initView() {
        AppMethodBeat.i(112163);
        setMMTitle((int) R.string.c7t);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(112158);
                GameRegionSelectUI.this.setResult(0);
                GameRegionSelectUI.this.aqX();
                GameRegionSelectUI.this.finish();
                AppMethodBeat.o(112158);
                return true;
            }
        });
        a(0, getString(R.string.c7s), (OnMenuItemClickListener) new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(112160);
                if (e.eg(GameRegionSelectUI.this)) {
                    h.a(GameRegionSelectUI.this, true, GameRegionSelectUI.this.getString(R.string.c7q), "", GameRegionSelectUI.this.getString(R.string.c7r), GameRegionSelectUI.this.getString(R.string.c7p), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(112159);
                            e.eh(GameRegionSelectUI.this);
                            GameRegionSelectUI.a(GameRegionSelectUI.this);
                            Intent intent = new Intent();
                            a dX = e.dX(GameRegionSelectUI.this);
                            if (dX != null) {
                                intent.putExtra("gameRegionName", e.a(dX));
                                GameRegionSelectUI.this.setResult(-1, intent);
                            } else {
                                GameRegionSelectUI.this.setResult(1);
                            }
                            GameRegionSelectUI.this.finish();
                            AppMethodBeat.o(112159);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else {
                    GameRegionSelectUI.a(GameRegionSelectUI.this);
                    Intent intent = new Intent();
                    a dX = e.dX(GameRegionSelectUI.this);
                    if (dX != null) {
                        intent.putExtra("gameRegionName", e.a(dX));
                        GameRegionSelectUI.this.setResult(-1, intent);
                    } else {
                        GameRegionSelectUI.this.setResult(1);
                    }
                    GameRegionSelectUI.this.finish();
                }
                AppMethodBeat.o(112160);
                return true;
            }
        }, b.GREEN);
        bFy();
        AppMethodBeat.o(112163);
    }

    private void bFy() {
        AppMethodBeat.i(112164);
        this.ehK.removeAll();
        this.nlT = com.tencent.mm.plugin.game.f.a.a.nnu.bFD();
        a dX = e.dX(this);
        if (dX != null) {
            dX.gBF = true;
        }
        for (a dX2 : this.nlT.values()) {
            if (dX2 != null) {
                GameRegionPreference gameRegionPreference = new GameRegionPreference(this);
                gameRegionPreference.b(dX2);
                if (dX2.isDefault) {
                    this.ehK.a(gameRegionPreference, 0);
                } else {
                    this.ehK.b(gameRegionPreference);
                }
            }
        }
        this.ehK.b(new PreferenceCategory(this));
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.o(112164);
    }

    public final boolean a(f fVar, Preference preference) {
        AppMethodBeat.i(112165);
        if (preference instanceof GameRegionPreference) {
            a aVar = ((GameRegionPreference) preference).nlP;
            if (aVar == null) {
                AppMethodBeat.o(112165);
                return false;
            }
            this.nlP = aVar;
            for (a aVar2 : this.nlT.values()) {
                aVar2.gBF = false;
            }
            aVar.gBF = true;
            fVar.notifyDataSetChanged();
            AppMethodBeat.o(112165);
            return true;
        }
        AppMethodBeat.o(112165);
        return false;
    }

    public void onDestroy() {
        AppMethodBeat.i(112162);
        com.tencent.mm.plugin.game.f.a.a.nnu.bFB();
        super.onDestroy();
        AppMethodBeat.o(112162);
    }

    static /* synthetic */ void a(GameRegionSelectUI gameRegionSelectUI) {
        AppMethodBeat.i(112166);
        if (gameRegionSelectUI.nlP != null) {
            e.at(gameRegionSelectUI, gameRegionSelectUI.nlP.dui);
            com.tencent.mm.plugin.game.f.a.a.nnu.nns = true;
            com.tencent.mm.plugin.game.commlib.b.bDn().hI(true);
        }
        AppMethodBeat.o(112166);
    }
}
