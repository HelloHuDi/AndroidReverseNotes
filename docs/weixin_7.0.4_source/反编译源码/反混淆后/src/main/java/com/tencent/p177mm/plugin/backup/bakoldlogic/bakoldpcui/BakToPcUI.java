package com.tencent.p177mm.plugin.backup.bakoldlogic.bakoldpcui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.backup.bakoldlogic.bakoldpcmodel.C27460e.C27461a;
import com.tencent.p177mm.plugin.backup.bakoldlogic.bakoldpcmodel.C41257a;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakToPcUI */
public class BakToPcUI extends MMWizardActivity implements C27461a {
    /* renamed from: Cn */
    private int f17889Cn = -1;
    private Button grC;
    private C7306ak handler = new C7306ak(Looper.getMainLooper());
    private Button jAH;
    private TextView jAI;
    private TextView jAJ;

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakToPcUI$3 */
    class C111203 implements OnClickListener {
        C111203() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(17969);
            if (BakToPcUI.this.f17889Cn == 0) {
                C41257a.aUB().aUD().flQ = 2;
                C41257a.aUB().aUD().aar();
                C41257a.aUB().aUC().mo45248rE(1);
                BakToPcUI.m84529c(BakToPcUI.this);
            }
            AppMethodBeat.m2505o(17969);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakToPcUI$4 */
    class C199674 implements Runnable {
        C199674() {
        }

        public final void run() {
            AppMethodBeat.m2504i(17970);
            BakToPcUI.m84530d(BakToPcUI.this);
            AppMethodBeat.m2505o(17970);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakToPcUI$2 */
    class C274712 implements OnClickListener {
        C274712() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(17968);
            if (BakToPcUI.this.f17889Cn == 0) {
                C41257a.aUB().aUD().flQ = 1;
                C41257a.aUB().aUC().mo45248rE(0);
                MMWizardActivity.m23791J(BakToPcUI.this, new Intent(BakToPcUI.this, BakWaitingUI.class));
            }
            AppMethodBeat.m2505o(17968);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakToPcUI$1 */
    class C386501 implements OnMenuItemClickListener {
        C386501() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(17967);
            C41257a.aUB().aUC().mo45248rE(1);
            BakToPcUI.m84527a(BakToPcUI.this);
            AppMethodBeat.m2505o(17967);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public BakToPcUI() {
        AppMethodBeat.m2504i(17972);
        AppMethodBeat.m2505o(17972);
    }

    /* renamed from: d */
    static /* synthetic */ void m84530d(BakToPcUI bakToPcUI) {
        AppMethodBeat.m2504i(17982);
        bakToPcUI.aUW();
        AppMethodBeat.m2505o(17982);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(17973);
        super.onCreate(bundle);
        if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            AppMethodBeat.m2505o(17973);
            return;
        }
        initView();
        this.f17889Cn = C41257a.aUB().aUC().jzH;
        C4990ab.m7417i("MicroMsg.BakToPcUI", "BakToPcUI auth onCreate nowCmd:%d", Integer.valueOf(this.f17889Cn));
        C41257a.aUB().aUC().jzB = this;
        aUW();
        AppMethodBeat.m2505o(17973);
    }

    public final void initView() {
        AppMethodBeat.m2504i(17974);
        setMMTitle((int) C25738R.string.a2v);
        setBackBtn(new C386501());
        this.grC = (Button) findViewById(2131821620);
        this.grC.setOnClickListener(new C274712());
        this.jAH = (Button) findViewById(2131821621);
        this.jAH.setOnClickListener(new C111203());
        this.jAI = (TextView) findViewById(2131821618);
        this.jAI.setText(C41257a.aUB().aUC().jzI);
        this.jAJ = (TextView) findViewById(2131821619);
        this.jAJ.setText(C41257a.aUB().aUC().jzJ);
        AppMethodBeat.m2505o(17974);
    }

    public final int getLayoutId() {
        return 2130968806;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(17975);
        super.onDestroy();
        C4990ab.m7417i("MicroMsg.BakToPcUI", "BakToPcUI auth onDestroy nowCmd:%d", Integer.valueOf(this.f17889Cn));
        C41257a.aUB().aUC().jzB = null;
        AppMethodBeat.m2505o(17975);
    }

    public final void aUO() {
        AppMethodBeat.m2504i(17976);
        this.f17889Cn = 0;
        this.grC.setVisibility(0);
        this.jAH.setVisibility(0);
        new C7306ak(Looper.getMainLooper()).post(new C199674());
        AppMethodBeat.m2505o(17976);
    }

    private void aUW() {
        AppMethodBeat.m2504i(17977);
        if (this.f17889Cn == 0) {
            this.grC.setEnabled(true);
            this.jAH.setEnabled(true);
            AppMethodBeat.m2505o(17977);
            return;
        }
        this.grC.setEnabled(false);
        this.jAH.setEnabled(false);
        AppMethodBeat.m2505o(17977);
    }

    public final void onError(final int i) {
        AppMethodBeat.m2504i(17978);
        this.handler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(17971);
                C4990ab.m7411d("MicroMsg.BakToPcUI", "BakToPcUI onCloseSocket errType: %d", Integer.valueOf(i));
                if (i == -1) {
                    C4990ab.m7410d("MicroMsg.BakToPcUI", "BakToPcUI jump tips");
                    Intent intent = new Intent();
                    intent.putExtra("title", BakToPcUI.this.getString(C25738R.string.a0m));
                    intent.putExtra("rawUrl", BakToPcUI.this.getString(C25738R.string.g5j, new Object[]{C4988aa.dor()}));
                    intent.putExtra("showShare", false);
                    intent.putExtra("neverGetA8Key", true);
                    C25985d.m41467b(BakToPcUI.this, "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.m2505o(17971);
                    return;
                }
                BakToPcUI.m84531e(BakToPcUI.this);
                AppMethodBeat.m2505o(17971);
            }
        });
        AppMethodBeat.m2505o(17978);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(17979);
        if (i == 4) {
            C41257a.aUB().aUD().flQ = 3;
            C41257a.aUB().aUD().aar();
            C41257a.aUB().aUC().mo45248rE(1);
            mo27541Ni(1);
            AppMethodBeat.m2505o(17979);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(17979);
        return onKeyDown;
    }

    /* renamed from: a */
    static /* synthetic */ void m84527a(BakToPcUI bakToPcUI) {
        AppMethodBeat.m2504i(17980);
        bakToPcUI.mo27541Ni(1);
        AppMethodBeat.m2505o(17980);
    }

    /* renamed from: c */
    static /* synthetic */ void m84529c(BakToPcUI bakToPcUI) {
        AppMethodBeat.m2504i(17981);
        bakToPcUI.mo27541Ni(1);
        AppMethodBeat.m2505o(17981);
    }

    /* renamed from: e */
    static /* synthetic */ void m84531e(BakToPcUI bakToPcUI) {
        AppMethodBeat.m2504i(17983);
        bakToPcUI.mo27541Ni(1);
        AppMethodBeat.m2505o(17983);
    }
}
