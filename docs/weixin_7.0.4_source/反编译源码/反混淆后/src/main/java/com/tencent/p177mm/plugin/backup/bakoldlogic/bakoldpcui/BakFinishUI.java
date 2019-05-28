package com.tencent.p177mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.plugin.backup.bakoldlogic.bakoldpcmodel.C27460e.C2643e;
import com.tencent.p177mm.plugin.backup.bakoldlogic.bakoldpcmodel.C41257a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakFinishUI */
public class BakFinishUI extends MMWizardActivity implements C2643e {
    private C7306ak handler = new C7306ak(Looper.getMainLooper());
    private int jAt;
    private TextView jAv;

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakFinishUI$3 */
    class C111173 implements Runnable {
        C111173() {
        }

        public final void run() {
            AppMethodBeat.m2504i(17923);
            C4990ab.m7410d("MicroMsg.BakFinishUI", "BakFinishUI onCloseSocket");
            MMWizardActivity.m23791J(BakFinishUI.this, new Intent(BakFinishUI.this, BakConnErrorUI.class));
            AppMethodBeat.m2505o(17923);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakFinishUI$1 */
    class C167131 implements OnMenuItemClickListener {
        C167131() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(17921);
            C41257a.aUB().aUC().jzK = -1;
            BakFinishUI.m25734a(BakFinishUI.this);
            AppMethodBeat.m2505o(17921);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakFinishUI$2 */
    class C167142 implements Runnable {
        C167142() {
        }

        public final void run() {
            AppMethodBeat.m2504i(17922);
            C41257a.aUB().aUC().jzK = -1;
            BakFinishUI.m25735b(BakFinishUI.this);
            AppMethodBeat.m2505o(17922);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public BakFinishUI() {
        AppMethodBeat.m2504i(17924);
        AppMethodBeat.m2505o(17924);
    }

    public final int getLayoutId() {
        return 2130968808;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(17925);
        super.onCreate(bundle);
        if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            AppMethodBeat.m2505o(17925);
            return;
        }
        this.jAt = getIntent().getIntExtra("cmd", -1);
        C4990ab.m7417i("MicroMsg.BakFinishUI", "BakFinishUI onCreate nowCmd:%d", Integer.valueOf(this.jAt));
        initView();
        C41257a.aUB().aUC().jzC = this;
        AppMethodBeat.m2505o(17925);
    }

    public final void initView() {
        AppMethodBeat.m2504i(17926);
        setMMTitle((int) C25738R.string.a2v);
        this.jAv = (TextView) findViewById(2131821623);
        if (6 == this.jAt) {
            this.jAv.setText(getString(C25738R.string.a2r));
        } else if (1 == this.jAt) {
            this.jAv.setText(getString(C25738R.string.a2i));
        }
        setBackBtn(new C167131());
        AppMethodBeat.m2505o(17926);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(17927);
        super.onDestroy();
        C41257a.aUB().aUC().jzC = null;
        C4990ab.m7417i("MicroMsg.BakFinishUI", "BakFinishUI onDestroy nowCmd:%d", Integer.valueOf(this.jAt));
        AppMethodBeat.m2505o(17927);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(17928);
        if (i == 4) {
            C41257a.aUB().aUC().jzK = -1;
            mo27541Ni(1);
            AppMethodBeat.m2505o(17928);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(17928);
        return onKeyDown;
    }

    public final void aUR() {
        AppMethodBeat.m2504i(17929);
        this.handler.post(new C167142());
        AppMethodBeat.m2505o(17929);
    }

    public final void onError(int i) {
        AppMethodBeat.m2504i(17930);
        this.handler.post(new C111173());
        AppMethodBeat.m2505o(17930);
    }

    /* renamed from: a */
    static /* synthetic */ void m25734a(BakFinishUI bakFinishUI) {
        AppMethodBeat.m2504i(17931);
        bakFinishUI.mo27541Ni(1);
        AppMethodBeat.m2505o(17931);
    }

    /* renamed from: b */
    static /* synthetic */ void m25735b(BakFinishUI bakFinishUI) {
        AppMethodBeat.m2504i(17932);
        bakFinishUI.mo27541Ni(1);
        AppMethodBeat.m2505o(17932);
    }
}
