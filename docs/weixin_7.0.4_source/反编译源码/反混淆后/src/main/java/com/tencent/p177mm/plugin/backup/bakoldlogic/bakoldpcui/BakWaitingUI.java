package com.tencent.p177mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.backup.bakoldlogic.bakoldpcmodel.C27460e.C11115c;
import com.tencent.p177mm.plugin.backup.bakoldlogic.bakoldpcmodel.C41257a;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakWaitingUI */
public class BakWaitingUI extends MMWizardActivity implements C11115c {
    /* renamed from: Cn */
    private int f17190Cn;
    private C7306ak handler = new C7306ak(Looper.getMainLooper());
    private boolean jAL;

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakWaitingUI$1 */
    class C274721 implements OnMenuItemClickListener {
        C274721() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(17984);
            BakWaitingUI.m75826a(BakWaitingUI.this);
            AppMethodBeat.m2505o(17984);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakWaitingUI$2 */
    class C386512 implements Runnable {
        C386512() {
        }

        public final void run() {
            AppMethodBeat.m2504i(17985);
            BakWaitingUI.this.aUX();
            AppMethodBeat.m2505o(17985);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public BakWaitingUI() {
        AppMethodBeat.m2504i(17988);
        AppMethodBeat.m2505o(17988);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(17989);
        super.onCreate(bundle);
        if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            AppMethodBeat.m2505o(17989);
            return;
        }
        C41257a.aUB().aUC().jzA = this;
        this.f17190Cn = C41257a.aUB().aUC().jzH;
        this.jAL = getIntent().getBooleanExtra("from_back_finish", false);
        C4990ab.m7417i("MicroMsg.BakWaitingUI", "BakWaitingUI onCreate nowCmd:%d isFromFinish:%b", Integer.valueOf(this.f17190Cn), Boolean.valueOf(this.jAL));
        initView();
        aUX();
        AppMethodBeat.m2505o(17989);
    }

    public final void initView() {
        AppMethodBeat.m2504i(17990);
        setMMTitle((int) C25738R.string.a2v);
        if (this.jAL) {
            findViewById(2131821622).setVisibility(8);
        } else {
            findViewById(2131821622).setVisibility(0);
        }
        setBackBtn(new C274721());
        AppMethodBeat.m2505o(17990);
    }

    public final int getLayoutId() {
        return 2130968810;
    }

    public final void onEvent(int i) {
        AppMethodBeat.m2504i(17991);
        this.f17190Cn = i;
        this.handler.post(new C386512());
        AppMethodBeat.m2505o(17991);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(17992);
        super.onDestroy();
        C41257a.aUB().aUC().jzA = null;
        C4990ab.m7417i("MicroMsg.BakWaitingUI", "BakWaitingUI onDestroy nowCmd:%d isFromFinish:%b", Integer.valueOf(this.f17190Cn), Boolean.valueOf(this.jAL));
        AppMethodBeat.m2505o(17992);
    }

    /* renamed from: rH */
    public final void mo22815rH(final int i) {
        AppMethodBeat.m2504i(17993);
        this.handler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(17986);
                C4990ab.m7411d("MicroMsg.BakWaitingUI", "BakWaitingUI onCloseSocket errType: %d", Integer.valueOf(i));
                if (i == -1) {
                    C4990ab.m7410d("MicroMsg.BakWaitingUI", "BakToPcUI jump tips");
                    Intent intent = new Intent();
                    intent.putExtra("title", BakWaitingUI.this.getString(C25738R.string.a0m));
                    intent.putExtra("rawUrl", BakWaitingUI.this.getString(C25738R.string.g5j, new Object[]{C4988aa.dor()}));
                    intent.putExtra("showShare", false);
                    intent.putExtra("neverGetA8Key", true);
                    C25985d.m41467b(BakWaitingUI.this, "webview", ".ui.tools.WebViewUI", intent);
                }
                AppMethodBeat.m2505o(17986);
            }
        });
        AppMethodBeat.m2505o(17993);
    }

    /* Access modifiers changed, original: final */
    public final void aUX() {
        AppMethodBeat.m2504i(17994);
        if (6 == this.f17190Cn || 1 == this.f17190Cn) {
            Intent intent = new Intent(this, BakOperatingUI.class);
            intent.putExtra("cmd", this.f17190Cn);
            MMWizardActivity.m23791J(this, intent);
        }
        AppMethodBeat.m2505o(17994);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(17995);
        if (i == 4) {
            mo27541Ni(1);
            AppMethodBeat.m2505o(17995);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(17995);
        return onKeyDown;
    }

    public final void onError(final int i) {
        AppMethodBeat.m2504i(17996);
        this.handler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(17987);
                C4990ab.m7411d("MicroMsg.BakWaitingUI", "BakWaitingUI onCloseSocket errType: %d", Integer.valueOf(i));
                if (i == -1) {
                    C4990ab.m7410d("MicroMsg.BakWaitingUI", "BakToPcUI jump tips");
                    Intent intent = new Intent();
                    intent.putExtra("title", BakWaitingUI.this.getString(C25738R.string.a0m));
                    intent.putExtra("rawUrl", BakWaitingUI.this.getString(C25738R.string.g5j, new Object[]{C4988aa.dor()}));
                    intent.putExtra("showShare", false);
                    intent.putExtra("neverGetA8Key", true);
                    C25985d.m41467b(BakWaitingUI.this, "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.m2505o(17987);
                    return;
                }
                MMWizardActivity.m23791J(BakWaitingUI.this, new Intent(BakWaitingUI.this, BakConnErrorUI.class));
                AppMethodBeat.m2505o(17987);
            }
        });
        AppMethodBeat.m2505o(17996);
    }

    /* renamed from: a */
    static /* synthetic */ void m75826a(BakWaitingUI bakWaitingUI) {
        AppMethodBeat.m2504i(17997);
        bakWaitingUI.mo27541Ni(1);
        AppMethodBeat.m2505o(17997);
    }
}
