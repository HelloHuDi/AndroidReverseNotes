package com.tencent.p177mm.plugin.freewifi.p418ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;

/* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiNoWifiUI */
public class FreeWifiNoWifiUI extends MMActivity {

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiNoWifiUI$1 */
    class C431151 implements OnMenuItemClickListener {
        C431151() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(21057);
            FreeWifiNoWifiUI.this.finish();
            AppMethodBeat.m2505o(21057);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(21058);
        super.onCreate(bundle);
        setBackBtn(new C431151());
        AppMethodBeat.m2505o(21058);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public final int getLayoutId() {
        return 2130969595;
    }
}
