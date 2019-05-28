package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.MMWizardActivity;

public class BakToPcUI extends MMWizardActivity implements a {
    private int Cn = -1;
    private Button grC;
    private ak handler = new ak(Looper.getMainLooper());
    private Button jAH;
    private TextView jAI;
    private TextView jAJ;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public BakToPcUI() {
        AppMethodBeat.i(17972);
        AppMethodBeat.o(17972);
    }

    static /* synthetic */ void d(BakToPcUI bakToPcUI) {
        AppMethodBeat.i(17982);
        bakToPcUI.aUW();
        AppMethodBeat.o(17982);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(17973);
        super.onCreate(bundle);
        if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            AppMethodBeat.o(17973);
            return;
        }
        initView();
        this.Cn = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aUB().aUC().jzH;
        ab.i("MicroMsg.BakToPcUI", "BakToPcUI auth onCreate nowCmd:%d", Integer.valueOf(this.Cn));
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aUB().aUC().jzB = this;
        aUW();
        AppMethodBeat.o(17973);
    }

    public final void initView() {
        AppMethodBeat.i(17974);
        setMMTitle((int) R.string.a2v);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(17967);
                com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aUB().aUC().rE(1);
                BakToPcUI.a(BakToPcUI.this);
                AppMethodBeat.o(17967);
                return true;
            }
        });
        this.grC = (Button) findViewById(R.id.a22);
        this.grC.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(17968);
                if (BakToPcUI.this.Cn == 0) {
                    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aUB().aUD().flQ = 1;
                    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aUB().aUC().rE(0);
                    MMWizardActivity.J(BakToPcUI.this, new Intent(BakToPcUI.this, BakWaitingUI.class));
                }
                AppMethodBeat.o(17968);
            }
        });
        this.jAH = (Button) findViewById(R.id.a23);
        this.jAH.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(17969);
                if (BakToPcUI.this.Cn == 0) {
                    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aUB().aUD().flQ = 2;
                    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aUB().aUD().aar();
                    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aUB().aUC().rE(1);
                    BakToPcUI.c(BakToPcUI.this);
                }
                AppMethodBeat.o(17969);
            }
        });
        this.jAI = (TextView) findViewById(R.id.a20);
        this.jAI.setText(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aUB().aUC().jzI);
        this.jAJ = (TextView) findViewById(R.id.a21);
        this.jAJ.setText(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aUB().aUC().jzJ);
        AppMethodBeat.o(17974);
    }

    public final int getLayoutId() {
        return R.layout.fi;
    }

    public void onDestroy() {
        AppMethodBeat.i(17975);
        super.onDestroy();
        ab.i("MicroMsg.BakToPcUI", "BakToPcUI auth onDestroy nowCmd:%d", Integer.valueOf(this.Cn));
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aUB().aUC().jzB = null;
        AppMethodBeat.o(17975);
    }

    public final void aUO() {
        AppMethodBeat.i(17976);
        this.Cn = 0;
        this.grC.setVisibility(0);
        this.jAH.setVisibility(0);
        new ak(Looper.getMainLooper()).post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(17970);
                BakToPcUI.d(BakToPcUI.this);
                AppMethodBeat.o(17970);
            }
        });
        AppMethodBeat.o(17976);
    }

    private void aUW() {
        AppMethodBeat.i(17977);
        if (this.Cn == 0) {
            this.grC.setEnabled(true);
            this.jAH.setEnabled(true);
            AppMethodBeat.o(17977);
            return;
        }
        this.grC.setEnabled(false);
        this.jAH.setEnabled(false);
        AppMethodBeat.o(17977);
    }

    public final void onError(final int i) {
        AppMethodBeat.i(17978);
        this.handler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(17971);
                ab.d("MicroMsg.BakToPcUI", "BakToPcUI onCloseSocket errType: %d", Integer.valueOf(i));
                if (i == -1) {
                    ab.d("MicroMsg.BakToPcUI", "BakToPcUI jump tips");
                    Intent intent = new Intent();
                    intent.putExtra("title", BakToPcUI.this.getString(R.string.a0m));
                    intent.putExtra("rawUrl", BakToPcUI.this.getString(R.string.g5j, new Object[]{aa.dor()}));
                    intent.putExtra("showShare", false);
                    intent.putExtra("neverGetA8Key", true);
                    d.b(BakToPcUI.this, "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.o(17971);
                    return;
                }
                BakToPcUI.e(BakToPcUI.this);
                AppMethodBeat.o(17971);
            }
        });
        AppMethodBeat.o(17978);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(17979);
        if (i == 4) {
            com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aUB().aUD().flQ = 3;
            com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aUB().aUD().aar();
            com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aUB().aUC().rE(1);
            Ni(1);
            AppMethodBeat.o(17979);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(17979);
        return onKeyDown;
    }

    static /* synthetic */ void a(BakToPcUI bakToPcUI) {
        AppMethodBeat.i(17980);
        bakToPcUI.Ni(1);
        AppMethodBeat.o(17980);
    }

    static /* synthetic */ void c(BakToPcUI bakToPcUI) {
        AppMethodBeat.i(17981);
        bakToPcUI.Ni(1);
        AppMethodBeat.o(17981);
    }

    static /* synthetic */ void e(BakToPcUI bakToPcUI) {
        AppMethodBeat.i(17983);
        bakToPcUI.Ni(1);
        AppMethodBeat.o(17983);
    }
}
