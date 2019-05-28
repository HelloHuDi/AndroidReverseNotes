package com.tencent.mm.plugin.account.security.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.account.bind.ui.BindMContactUI;
import com.tencent.mm.ui.MMWizardActivity;

public class BindSafeDeviceUI extends MMWizardActivity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getLayoutId() {
        return R.layout.aq9;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(69860);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(69860);
    }

    public final void initView() {
        AppMethodBeat.i(69861);
        setMMTitle((int) R.string.dvx);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(69858);
                BindSafeDeviceUI.this.finish();
                AppMethodBeat.o(69858);
                return true;
            }
        });
        ((ImageView) findViewById(R.id.e7_)).setImageResource(R.raw.accounts_saftphone_icon);
        ((TextView) findViewById(R.id.e7a)).setText(R.string.dw3);
        ((TextView) findViewById(R.id.e7d)).setText(R.string.dw4);
        findViewById(R.id.e7d).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(69859);
                Intent intent = new Intent();
                intent.putExtra("bind_scene", 1);
                intent.setClass(BindSafeDeviceUI.this, BindMContactUI.class);
                MMWizardActivity.J(BindSafeDeviceUI.this, intent);
                AppMethodBeat.o(69859);
            }
        });
        AppMethodBeat.o(69861);
    }
}
