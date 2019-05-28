package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.ui.MMActivity;

public class SettingsAliasResultUI extends MMActivity {
    private String dFl;
    private TextView gnC;
    private TextView qmN;
    private Button qmO;
    private ImageView qmP;
    private boolean qmQ;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(127179);
        super.onCreate(bundle);
        this.dFl = (String) g.RP().Ry().get(42, null);
        this.qmQ = getIntent().getBooleanExtra("has_pwd", true);
        initView();
        AppMethodBeat.o(127179);
    }

    public final int getLayoutId() {
        return R.layout.arp;
    }

    public void onPause() {
        AppMethodBeat.i(127180);
        super.onPause();
        AppMethodBeat.o(127180);
    }

    public void onDestroy() {
        AppMethodBeat.i(127181);
        super.onDestroy();
        AppMethodBeat.o(127181);
    }

    public final void initView() {
        AppMethodBeat.i(127182);
        setMMTitle((int) R.string.d18);
        this.gnC = (TextView) findViewById(R.id.ld);
        this.qmN = (TextView) findViewById(R.id.o9);
        this.qmO = (Button) findViewById(R.id.e9v);
        this.qmP = (ImageView) findViewById(R.id.e9u);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127177);
                SettingsAliasResultUI.this.finish();
                AppMethodBeat.o(127177);
                return true;
            }
        });
        this.qmN.setText(this.dFl);
        if (this.qmQ) {
            this.qmO.setVisibility(8);
            this.gnC.setText(getString(R.string.d1d));
        } else {
            this.qmO.setVisibility(0);
            this.gnC.setText(getString(R.string.d1c));
        }
        this.qmO.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(127178);
                Intent intent = new Intent(SettingsAliasResultUI.this.mController.ylL, RegByMobileSetPwdUI.class);
                intent.putExtra("kintent_hint", SettingsAliasResultUI.this.getString(R.string.dlx));
                SettingsAliasResultUI.this.startActivityForResult(intent, 0);
                AppMethodBeat.o(127178);
            }
        });
        AppMethodBeat.o(127182);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(127183);
        if (i2 == -1) {
            finish();
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(127183);
    }
}
