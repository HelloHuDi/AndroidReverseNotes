package com.tencent.mm.plugin.exdevice.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;

public class ExdeviceExpireUI extends MMActivity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(19967);
        super.onCreate(bundle);
        setMMTitle((int) R.string.bhr);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(19966);
                ExdeviceExpireUI.this.finish();
                AppMethodBeat.o(19966);
                return false;
            }
        });
        AppMethodBeat.o(19967);
    }

    public final int getLayoutId() {
        return R.layout.w1;
    }
}
