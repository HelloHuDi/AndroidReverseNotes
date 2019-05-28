package com.tencent.mm.plugin.freewifi.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;

public class FreeWifiNoWifiUI extends MMActivity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(21058);
        super.onCreate(bundle);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(21057);
                FreeWifiNoWifiUI.this.finish();
                AppMethodBeat.o(21057);
                return true;
            }
        });
        AppMethodBeat.o(21058);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public final int getLayoutId() {
        return R.layout.a0q;
    }
}
