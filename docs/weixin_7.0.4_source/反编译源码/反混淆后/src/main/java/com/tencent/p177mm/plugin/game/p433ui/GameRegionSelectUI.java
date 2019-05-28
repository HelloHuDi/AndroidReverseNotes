package com.tencent.p177mm.plugin.game.p433ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.base.preference.PreferenceCategory;
import com.tencent.p177mm.plugin.game.commlib.C20945b;
import com.tencent.p177mm.plugin.game.model.C20993e;
import com.tencent.p177mm.plugin.game.p428f.C46000a.C3220a;
import com.tencent.p177mm.plugin.game.p433ui.GameRegionPreference.C3265a;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.game.ui.GameRegionSelectUI */
public class GameRegionSelectUI extends MMPreference {
    private C15541f ehK;
    private C3265a nlP;
    private Map<String, C3265a> nlT;

    /* renamed from: com.tencent.mm.plugin.game.ui.GameRegionSelectUI$2 */
    class C282592 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.game.ui.GameRegionSelectUI$2$2 */
        class C121872 implements OnClickListener {
            C121872() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        /* renamed from: com.tencent.mm.plugin.game.ui.GameRegionSelectUI$2$1 */
        class C282581 implements OnClickListener {
            C282581() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(112159);
                C20993e.m32281eh(GameRegionSelectUI.this);
                GameRegionSelectUI.m85545a(GameRegionSelectUI.this);
                Intent intent = new Intent();
                C3265a dX = C20993e.m32271dX(GameRegionSelectUI.this);
                if (dX != null) {
                    intent.putExtra("gameRegionName", C20993e.m32261a(dX));
                    GameRegionSelectUI.this.setResult(-1, intent);
                } else {
                    GameRegionSelectUI.this.setResult(1);
                }
                GameRegionSelectUI.this.finish();
                AppMethodBeat.m2505o(112159);
            }
        }

        C282592() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(112160);
            if (C20993e.m32280eg(GameRegionSelectUI.this)) {
                C30379h.m48453a(GameRegionSelectUI.this, true, GameRegionSelectUI.this.getString(C25738R.string.c7q), "", GameRegionSelectUI.this.getString(C25738R.string.c7r), GameRegionSelectUI.this.getString(C25738R.string.c7p), new C282581(), new C121872());
            } else {
                GameRegionSelectUI.m85545a(GameRegionSelectUI.this);
                Intent intent = new Intent();
                C3265a dX = C20993e.m32271dX(GameRegionSelectUI.this);
                if (dX != null) {
                    intent.putExtra("gameRegionName", C20993e.m32261a(dX));
                    GameRegionSelectUI.this.setResult(-1, intent);
                } else {
                    GameRegionSelectUI.this.setResult(1);
                }
                GameRegionSelectUI.this.finish();
            }
            AppMethodBeat.m2505o(112160);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameRegionSelectUI$1 */
    class C392321 implements OnMenuItemClickListener {
        C392321() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(112158);
            GameRegionSelectUI.this.setResult(0);
            GameRegionSelectUI.this.aqX();
            GameRegionSelectUI.this.finish();
            AppMethodBeat.m2505o(112158);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(112161);
        super.onCreate(bundle);
        this.ehK = this.yCw;
        initView();
        AppMethodBeat.m2505o(112161);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return -1;
    }

    public final void initView() {
        AppMethodBeat.m2504i(112163);
        setMMTitle((int) C25738R.string.c7t);
        setBackBtn(new C392321());
        mo17379a(0, getString(C25738R.string.c7s), (OnMenuItemClickListener) new C282592(), C5535b.GREEN);
        bFy();
        AppMethodBeat.m2505o(112163);
    }

    private void bFy() {
        AppMethodBeat.m2504i(112164);
        this.ehK.removeAll();
        this.nlT = C3220a.nnu.bFD();
        C3265a dX = C20993e.m32271dX(this);
        if (dX != null) {
            dX.gBF = true;
        }
        for (C3265a dX2 : this.nlT.values()) {
            if (dX2 != null) {
                GameRegionPreference gameRegionPreference = new GameRegionPreference(this);
                gameRegionPreference.mo7606b(dX2);
                if (dX2.isDefault) {
                    this.ehK.mo27708a(gameRegionPreference, 0);
                } else {
                    this.ehK.mo27713b(gameRegionPreference);
                }
            }
        }
        this.ehK.mo27713b(new PreferenceCategory(this));
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.m2505o(112164);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(112165);
        if (preference instanceof GameRegionPreference) {
            C3265a c3265a = ((GameRegionPreference) preference).nlP;
            if (c3265a == null) {
                AppMethodBeat.m2505o(112165);
                return false;
            }
            this.nlP = c3265a;
            for (C3265a c3265a2 : this.nlT.values()) {
                c3265a2.gBF = false;
            }
            c3265a.gBF = true;
            c15541f.notifyDataSetChanged();
            AppMethodBeat.m2505o(112165);
            return true;
        }
        AppMethodBeat.m2505o(112165);
        return false;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(112162);
        C3220a.nnu.bFB();
        super.onDestroy();
        AppMethodBeat.m2505o(112162);
    }

    /* renamed from: a */
    static /* synthetic */ void m85545a(GameRegionSelectUI gameRegionSelectUI) {
        AppMethodBeat.m2504i(112166);
        if (gameRegionSelectUI.nlP != null) {
            C20993e.m32268at(gameRegionSelectUI, gameRegionSelectUI.nlP.dui);
            C3220a.nnu.nns = true;
            C20945b.bDn().mo36287hI(true);
        }
        AppMethodBeat.m2505o(112166);
    }
}
