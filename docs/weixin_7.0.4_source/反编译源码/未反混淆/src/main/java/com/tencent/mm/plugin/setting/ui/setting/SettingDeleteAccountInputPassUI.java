package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;

public class SettingDeleteAccountInputPassUI extends MMActivity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getLayoutId() {
        return R.layout.arj;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(127068);
        super.onCreate(bundle);
        setMMTitle((int) R.string.e45);
        initView();
        AppMethodBeat.o(127068);
    }

    public final void initView() {
        AppMethodBeat.i(127069);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127066);
                SettingDeleteAccountInputPassUI.this.aqX();
                SettingDeleteAccountInputPassUI.this.finish();
                AppMethodBeat.o(127066);
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.qt), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127067);
                SettingDeleteAccountInputPassUI.this.aqX();
                SettingDeleteAccountInputPassUI.this.startActivity(new Intent(SettingDeleteAccountInputPassUI.this, SettingDeleteAccountUI.class));
                AppMethodBeat.o(127067);
                return true;
            }
        });
        AppMethodBeat.o(127069);
    }
}
