package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;

public class SettingDeleteAccountUI extends MMActivity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getLayoutId() {
        return R.layout.arh;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(127071);
        super.onCreate(bundle);
        setMMTitle((int) R.string.e45);
        initView();
        AppMethodBeat.o(127071);
    }

    public final void initView() {
        AppMethodBeat.i(127072);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127070);
                SettingDeleteAccountUI.this.aqX();
                SettingDeleteAccountUI.this.finish();
                AppMethodBeat.o(127070);
                return true;
            }
        });
        ((TextView) findViewById(R.id.e9h)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
            }
        });
        AppMethodBeat.o(127072);
    }
}
