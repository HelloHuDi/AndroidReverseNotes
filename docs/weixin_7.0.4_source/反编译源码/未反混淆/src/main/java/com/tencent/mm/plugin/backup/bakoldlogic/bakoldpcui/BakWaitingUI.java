package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.MMWizardActivity;

public class BakWaitingUI extends MMWizardActivity implements c {
    private int Cn;
    private ak handler = new ak(Looper.getMainLooper());
    private boolean jAL;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public BakWaitingUI() {
        AppMethodBeat.i(17988);
        AppMethodBeat.o(17988);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(17989);
        super.onCreate(bundle);
        if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            AppMethodBeat.o(17989);
            return;
        }
        a.aUB().aUC().jzA = this;
        this.Cn = a.aUB().aUC().jzH;
        this.jAL = getIntent().getBooleanExtra("from_back_finish", false);
        ab.i("MicroMsg.BakWaitingUI", "BakWaitingUI onCreate nowCmd:%d isFromFinish:%b", Integer.valueOf(this.Cn), Boolean.valueOf(this.jAL));
        initView();
        aUX();
        AppMethodBeat.o(17989);
    }

    public final void initView() {
        AppMethodBeat.i(17990);
        setMMTitle((int) R.string.a2v);
        if (this.jAL) {
            findViewById(R.id.a24).setVisibility(8);
        } else {
            findViewById(R.id.a24).setVisibility(0);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(17984);
                BakWaitingUI.a(BakWaitingUI.this);
                AppMethodBeat.o(17984);
                return true;
            }
        });
        AppMethodBeat.o(17990);
    }

    public final int getLayoutId() {
        return R.layout.fm;
    }

    public final void onEvent(int i) {
        AppMethodBeat.i(17991);
        this.Cn = i;
        this.handler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(17985);
                BakWaitingUI.this.aUX();
                AppMethodBeat.o(17985);
            }
        });
        AppMethodBeat.o(17991);
    }

    public void onDestroy() {
        AppMethodBeat.i(17992);
        super.onDestroy();
        a.aUB().aUC().jzA = null;
        ab.i("MicroMsg.BakWaitingUI", "BakWaitingUI onDestroy nowCmd:%d isFromFinish:%b", Integer.valueOf(this.Cn), Boolean.valueOf(this.jAL));
        AppMethodBeat.o(17992);
    }

    public final void rH(final int i) {
        AppMethodBeat.i(17993);
        this.handler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(17986);
                ab.d("MicroMsg.BakWaitingUI", "BakWaitingUI onCloseSocket errType: %d", Integer.valueOf(i));
                if (i == -1) {
                    ab.d("MicroMsg.BakWaitingUI", "BakToPcUI jump tips");
                    Intent intent = new Intent();
                    intent.putExtra("title", BakWaitingUI.this.getString(R.string.a0m));
                    intent.putExtra("rawUrl", BakWaitingUI.this.getString(R.string.g5j, new Object[]{aa.dor()}));
                    intent.putExtra("showShare", false);
                    intent.putExtra("neverGetA8Key", true);
                    d.b(BakWaitingUI.this, "webview", ".ui.tools.WebViewUI", intent);
                }
                AppMethodBeat.o(17986);
            }
        });
        AppMethodBeat.o(17993);
    }

    /* Access modifiers changed, original: final */
    public final void aUX() {
        AppMethodBeat.i(17994);
        if (6 == this.Cn || 1 == this.Cn) {
            Intent intent = new Intent(this, BakOperatingUI.class);
            intent.putExtra("cmd", this.Cn);
            MMWizardActivity.J(this, intent);
        }
        AppMethodBeat.o(17994);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(17995);
        if (i == 4) {
            Ni(1);
            AppMethodBeat.o(17995);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(17995);
        return onKeyDown;
    }

    public final void onError(final int i) {
        AppMethodBeat.i(17996);
        this.handler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(17987);
                ab.d("MicroMsg.BakWaitingUI", "BakWaitingUI onCloseSocket errType: %d", Integer.valueOf(i));
                if (i == -1) {
                    ab.d("MicroMsg.BakWaitingUI", "BakToPcUI jump tips");
                    Intent intent = new Intent();
                    intent.putExtra("title", BakWaitingUI.this.getString(R.string.a0m));
                    intent.putExtra("rawUrl", BakWaitingUI.this.getString(R.string.g5j, new Object[]{aa.dor()}));
                    intent.putExtra("showShare", false);
                    intent.putExtra("neverGetA8Key", true);
                    d.b(BakWaitingUI.this, "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.o(17987);
                    return;
                }
                MMWizardActivity.J(BakWaitingUI.this, new Intent(BakWaitingUI.this, BakConnErrorUI.class));
                AppMethodBeat.o(17987);
            }
        });
        AppMethodBeat.o(17996);
    }

    static /* synthetic */ void a(BakWaitingUI bakWaitingUI) {
        AppMethodBeat.i(17997);
        bakWaitingUI.Ni(1);
        AppMethodBeat.o(17997);
    }
}
