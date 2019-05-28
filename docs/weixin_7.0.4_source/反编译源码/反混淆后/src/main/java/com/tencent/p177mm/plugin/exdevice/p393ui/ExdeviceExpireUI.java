package com.tencent.p177mm.plugin.exdevice.p393ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;

/* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceExpireUI */
public class ExdeviceExpireUI extends MMActivity {

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceExpireUI$1 */
    class C117071 implements OnMenuItemClickListener {
        C117071() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(19966);
            ExdeviceExpireUI.this.finish();
            AppMethodBeat.m2505o(19966);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(19967);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.bhr);
        setBackBtn(new C117071());
        AppMethodBeat.m2505o(19967);
    }

    public final int getLayoutId() {
        return 2130969419;
    }
}
