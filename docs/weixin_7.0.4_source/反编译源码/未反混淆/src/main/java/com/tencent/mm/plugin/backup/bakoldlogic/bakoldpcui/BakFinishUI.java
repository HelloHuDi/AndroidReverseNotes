package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.MMWizardActivity;

public class BakFinishUI extends MMWizardActivity implements e {
    private ak handler = new ak(Looper.getMainLooper());
    private int jAt;
    private TextView jAv;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public BakFinishUI() {
        AppMethodBeat.i(17924);
        AppMethodBeat.o(17924);
    }

    public final int getLayoutId() {
        return R.layout.fk;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(17925);
        super.onCreate(bundle);
        if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            AppMethodBeat.o(17925);
            return;
        }
        this.jAt = getIntent().getIntExtra("cmd", -1);
        ab.i("MicroMsg.BakFinishUI", "BakFinishUI onCreate nowCmd:%d", Integer.valueOf(this.jAt));
        initView();
        a.aUB().aUC().jzC = this;
        AppMethodBeat.o(17925);
    }

    public final void initView() {
        AppMethodBeat.i(17926);
        setMMTitle((int) R.string.a2v);
        this.jAv = (TextView) findViewById(R.id.a25);
        if (6 == this.jAt) {
            this.jAv.setText(getString(R.string.a2r));
        } else if (1 == this.jAt) {
            this.jAv.setText(getString(R.string.a2i));
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(17921);
                a.aUB().aUC().jzK = -1;
                BakFinishUI.a(BakFinishUI.this);
                AppMethodBeat.o(17921);
                return true;
            }
        });
        AppMethodBeat.o(17926);
    }

    public void onDestroy() {
        AppMethodBeat.i(17927);
        super.onDestroy();
        a.aUB().aUC().jzC = null;
        ab.i("MicroMsg.BakFinishUI", "BakFinishUI onDestroy nowCmd:%d", Integer.valueOf(this.jAt));
        AppMethodBeat.o(17927);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(17928);
        if (i == 4) {
            a.aUB().aUC().jzK = -1;
            Ni(1);
            AppMethodBeat.o(17928);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(17928);
        return onKeyDown;
    }

    public final void aUR() {
        AppMethodBeat.i(17929);
        this.handler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(17922);
                a.aUB().aUC().jzK = -1;
                BakFinishUI.b(BakFinishUI.this);
                AppMethodBeat.o(17922);
            }
        });
        AppMethodBeat.o(17929);
    }

    public final void onError(int i) {
        AppMethodBeat.i(17930);
        this.handler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(17923);
                ab.d("MicroMsg.BakFinishUI", "BakFinishUI onCloseSocket");
                MMWizardActivity.J(BakFinishUI.this, new Intent(BakFinishUI.this, BakConnErrorUI.class));
                AppMethodBeat.o(17923);
            }
        });
        AppMethodBeat.o(17930);
    }

    static /* synthetic */ void a(BakFinishUI bakFinishUI) {
        AppMethodBeat.i(17931);
        bakFinishUI.Ni(1);
        AppMethodBeat.o(17931);
    }

    static /* synthetic */ void b(BakFinishUI bakFinishUI) {
        AppMethodBeat.i(17932);
        bakFinishUI.Ni(1);
        AppMethodBeat.o(17932);
    }
}
