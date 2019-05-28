package com.tencent.p177mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.plugin.backup.bakoldlogic.bakoldpcmodel.C41257a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakConnErrorUI */
public class BakConnErrorUI extends MMWizardActivity {
    private int jAt;

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakConnErrorUI$1 */
    class C427641 implements OnMenuItemClickListener {
        C427641() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(17915);
            BakConnErrorUI.m75825a(BakConnErrorUI.this);
            AppMethodBeat.m2505o(17915);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getLayoutId() {
        return 2130968807;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(17916);
        super.onCreate(bundle);
        if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            AppMethodBeat.m2505o(17916);
            return;
        }
        this.jAt = getIntent().getIntExtra("cmd", -1);
        C4990ab.m7417i("MicroMsg.BakFinishUI", "BakConnErrorUI onCreate nowCmd:%d", Integer.valueOf(this.jAt));
        initView();
        C41257a.aUB().aUC().jzK = -1;
        AppMethodBeat.m2505o(17916);
    }

    public final void initView() {
        AppMethodBeat.m2504i(17917);
        setMMTitle((int) C25738R.string.a2v);
        setBackBtn(new C427641());
        AppMethodBeat.m2505o(17917);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(17918);
        super.onDestroy();
        C41257a.aUB().aUC().jzC = null;
        C4990ab.m7417i("MicroMsg.BakFinishUI", "BakConnErrorUI onDestroy nowCmd:%d", Integer.valueOf(this.jAt));
        AppMethodBeat.m2505o(17918);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(17919);
        if (i == 4) {
            mo27541Ni(1);
            AppMethodBeat.m2505o(17919);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(17919);
        return onKeyDown;
    }

    /* renamed from: a */
    static /* synthetic */ void m75825a(BakConnErrorUI bakConnErrorUI) {
        AppMethodBeat.m2504i(17920);
        bakConnErrorUI.mo27541Ni(1);
        AppMethodBeat.m2505o(17920);
    }
}
