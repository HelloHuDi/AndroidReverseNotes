package com.tencent.mm.plugin.wallet_core.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;

@com.tencent.mm.ui.base.a(3)
public class WalletCheckPwdNewUI extends WalletBaseUI {
    private ImageView aqI;
    private a tGS;
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

    public interface a {
        void acQ(String str);

        void onCreate();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(47324);
        super.onCreate(bundle);
        ab.i("MicroMsg.WalletCheckPwdNewUI", "scene: %s", Integer.valueOf(getIntent().getIntExtra("scene", -1)));
        if (getIntent().getIntExtra("scene", -1) == 3) {
            this.tGS = new f(this);
        } else {
            this.tGS = new a(this);
        }
        xE(getResources().getColor(R.color.x));
        this.mController.hideTitleView();
        dyb();
        initView();
        this.tGS.onCreate();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(47321);
                WalletCheckPwdNewUI.a(WalletCheckPwdNewUI.this);
                AppMethodBeat.o(47321);
                return false;
            }
        });
        AppMethodBeat.o(47324);
    }

    public final void initView() {
        AppMethodBeat.i(47326);
        this.aqI = (ImageView) findViewById(R.id.f9w);
        this.tGT = (TextView) findViewById(R.id.cfp);
        this.tGU = (TextView) findViewById(R.id.f9x);
        this.tGV = (LinearLayout) findViewById(R.id.f9v);
        this.tsd = (EditHintPasswdView) findViewById(R.id.cfs);
        this.tGW = (ImageView) findViewById(R.id.f9z);
        this.tGX = (TextView) findViewById(R.id.f_0);
        this.tGY = (LinearLayout) findViewById(R.id.f9y);
        this.tGZ = (LinearLayout) findViewById(R.id.f9u);
        this.tHa = (TextView) findViewById(R.id.f_1);
        this.tHb = (ScrollView) findViewById(R.id.f9t);
        this.aqI.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47322);
                WalletCheckPwdNewUI.a(WalletCheckPwdNewUI.this);
                AppMethodBeat.o(47322);
            }
        });
        com.tencent.mm.wallet_core.ui.formview.a.a(this.tsd);
        this.tsd.setOnInputValidListener(new com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a() {
            public final void hY(boolean z) {
                AppMethodBeat.i(47323);
                ab.i("MicroMsg.WalletCheckPwdNewUI", "input isValid: %s", Boolean.valueOf(z));
                if (z) {
                    WalletCheckPwdNewUI.this.tGS.acQ(WalletCheckPwdNewUI.this.tsd.getText());
                }
                AppMethodBeat.o(47323);
            }
        });
        e(this.tsd, 0, false);
        dOC();
        AppMethodBeat.o(47326);
    }

    public void onResume() {
        AppMethodBeat.i(47327);
        super.onResume();
        AppMethodBeat.o(47327);
    }

    public void onPause() {
        AppMethodBeat.i(47328);
        super.onPause();
        AppMethodBeat.o(47328);
    }

    public void onDestroy() {
        AppMethodBeat.i(47329);
        super.onDestroy();
        AppMethodBeat.o(47329);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(47330);
        ab.i("MicroMsg.WalletCheckPwdNewUI", "controller ret: %s", Boolean.FALSE);
        AppMethodBeat.o(47330);
        return false;
    }

    public final int getLayoutId() {
        return R.layout.b3u;
    }

    public final void AM(int i) {
        AppMethodBeat.i(47325);
        this.mController.contentView.setVisibility(i);
        AppMethodBeat.o(47325);
    }

    static /* synthetic */ void a(WalletCheckPwdNewUI walletCheckPwdNewUI) {
        AppMethodBeat.i(47331);
        ab.i("MicroMsg.WalletCheckPwdNewUI", "close btn");
        walletCheckPwdNewUI.finish();
        AppMethodBeat.o(47331);
    }
}
