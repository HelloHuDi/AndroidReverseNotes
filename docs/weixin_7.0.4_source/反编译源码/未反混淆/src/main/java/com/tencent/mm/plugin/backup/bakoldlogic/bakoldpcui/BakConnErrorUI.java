package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMWizardActivity;

public class BakConnErrorUI extends MMWizardActivity {
    private int jAt;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getLayoutId() {
        return R.layout.fj;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(17916);
        super.onCreate(bundle);
        if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            AppMethodBeat.o(17916);
            return;
        }
        this.jAt = getIntent().getIntExtra("cmd", -1);
        ab.i("MicroMsg.BakFinishUI", "BakConnErrorUI onCreate nowCmd:%d", Integer.valueOf(this.jAt));
        initView();
        a.aUB().aUC().jzK = -1;
        AppMethodBeat.o(17916);
    }

    public final void initView() {
        AppMethodBeat.i(17917);
        setMMTitle((int) R.string.a2v);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(17915);
                BakConnErrorUI.a(BakConnErrorUI.this);
                AppMethodBeat.o(17915);
                return true;
            }
        });
        AppMethodBeat.o(17917);
    }

    public void onDestroy() {
        AppMethodBeat.i(17918);
        super.onDestroy();
        a.aUB().aUC().jzC = null;
        ab.i("MicroMsg.BakFinishUI", "BakConnErrorUI onDestroy nowCmd:%d", Integer.valueOf(this.jAt));
        AppMethodBeat.o(17918);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(17919);
        if (i == 4) {
            Ni(1);
            AppMethodBeat.o(17919);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(17919);
        return onKeyDown;
    }

    static /* synthetic */ void a(BakConnErrorUI bakConnErrorUI) {
        AppMethodBeat.i(17920);
        bakConnErrorUI.Ni(1);
        AppMethodBeat.o(17920);
    }
}
