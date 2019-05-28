package com.tencent.p177mm.plugin.wallet_core.p561ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.p177mm.wallet_core.p650ui.formview.C30890a;
import com.tencent.p177mm.wallet_core.p650ui.formview.EditHintPasswdView;
import com.tencent.p177mm.wallet_core.p650ui.formview.EditHintPasswdView.C30883a;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdNewUI */
public class WalletCheckPwdNewUI extends WalletBaseUI {
    private ImageView aqI;
    private C4408a tGS;
    TextView tGT;
    private TextView tGU;
    private LinearLayout tGV;
    private ImageView tGW;
    private TextView tGX;
    private LinearLayout tGY;
    private LinearLayout tGZ;
    private TextView tHa;
    private ScrollView tHb;
    private EditHintPasswdView tsd;

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdNewUI$a */
    public interface C4408a {
        void acQ(String str);

        void onCreate();
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdNewUI$3 */
    class C296543 implements C30883a {
        C296543() {
        }

        /* renamed from: hY */
        public final void mo9438hY(boolean z) {
            AppMethodBeat.m2504i(47323);
            C4990ab.m7417i("MicroMsg.WalletCheckPwdNewUI", "input isValid: %s", Boolean.valueOf(z));
            if (z) {
                WalletCheckPwdNewUI.this.tGS.acQ(WalletCheckPwdNewUI.this.tsd.getText());
            }
            AppMethodBeat.m2505o(47323);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdNewUI$1 */
    class C296551 implements OnMenuItemClickListener {
        C296551() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(47321);
            WalletCheckPwdNewUI.m47035a(WalletCheckPwdNewUI.this);
            AppMethodBeat.m2505o(47321);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdNewUI$2 */
    class C296562 implements OnClickListener {
        C296562() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47322);
            WalletCheckPwdNewUI.m47035a(WalletCheckPwdNewUI.this);
            AppMethodBeat.m2505o(47322);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(47324);
        super.onCreate(bundle);
        C4990ab.m7417i("MicroMsg.WalletCheckPwdNewUI", "scene: %s", Integer.valueOf(getIntent().getIntExtra("scene", -1)));
        if (getIntent().getIntExtra("scene", -1) == 3) {
            this.tGS = new C40126f(this);
        } else {
            this.tGS = new C43815a(this);
        }
        mo17446xE(getResources().getColor(C25738R.color.f11636x));
        this.mController.hideTitleView();
        dyb();
        initView();
        this.tGS.onCreate();
        setBackBtn(new C296551());
        AppMethodBeat.m2505o(47324);
    }

    public final void initView() {
        AppMethodBeat.m2504i(47326);
        this.aqI = (ImageView) findViewById(2131828753);
        this.tGT = (TextView) findViewById(2131824899);
        this.tGU = (TextView) findViewById(2131828754);
        this.tGV = (LinearLayout) findViewById(2131828752);
        this.tsd = (EditHintPasswdView) findViewById(2131824902);
        this.tGW = (ImageView) findViewById(2131828756);
        this.tGX = (TextView) findViewById(2131828757);
        this.tGY = (LinearLayout) findViewById(2131828755);
        this.tGZ = (LinearLayout) findViewById(2131828751);
        this.tHa = (TextView) findViewById(2131828758);
        this.tHb = (ScrollView) findViewById(2131828750);
        this.aqI.setOnClickListener(new C296562());
        C30890a.m49291a(this.tsd);
        this.tsd.setOnInputValidListener(new C296543());
        mo39989e(this.tsd, 0, false);
        dOC();
        AppMethodBeat.m2505o(47326);
    }

    public void onResume() {
        AppMethodBeat.m2504i(47327);
        super.onResume();
        AppMethodBeat.m2505o(47327);
    }

    public void onPause() {
        AppMethodBeat.m2504i(47328);
        super.onPause();
        AppMethodBeat.m2505o(47328);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(47329);
        super.onDestroy();
        AppMethodBeat.m2505o(47329);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(47330);
        C4990ab.m7417i("MicroMsg.WalletCheckPwdNewUI", "controller ret: %s", Boolean.FALSE);
        AppMethodBeat.m2505o(47330);
        return false;
    }

    public final int getLayoutId() {
        return 2130971083;
    }

    /* renamed from: AM */
    public final void mo9439AM(int i) {
        AppMethodBeat.m2504i(47325);
        this.mController.contentView.setVisibility(i);
        AppMethodBeat.m2505o(47325);
    }

    /* renamed from: a */
    static /* synthetic */ void m47035a(WalletCheckPwdNewUI walletCheckPwdNewUI) {
        AppMethodBeat.m2504i(47331);
        C4990ab.m7416i("MicroMsg.WalletCheckPwdNewUI", "close btn");
        walletCheckPwdNewUI.finish();
        AppMethodBeat.m2505o(47331);
    }
}
