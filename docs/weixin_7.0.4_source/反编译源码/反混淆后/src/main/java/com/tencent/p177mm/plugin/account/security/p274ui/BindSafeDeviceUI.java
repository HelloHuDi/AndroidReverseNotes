package com.tencent.p177mm.plugin.account.security.p274ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.plugin.account.bind.p271ui.BindMContactUI;

/* renamed from: com.tencent.mm.plugin.account.security.ui.BindSafeDeviceUI */
public class BindSafeDeviceUI extends MMWizardActivity {

    /* renamed from: com.tencent.mm.plugin.account.security.ui.BindSafeDeviceUI$1 */
    class C165721 implements OnMenuItemClickListener {
        C165721() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(69858);
            BindSafeDeviceUI.this.finish();
            AppMethodBeat.m2505o(69858);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.security.ui.BindSafeDeviceUI$2 */
    class C165732 implements OnClickListener {
        C165732() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(69859);
            Intent intent = new Intent();
            intent.putExtra("bind_scene", 1);
            intent.setClass(BindSafeDeviceUI.this, BindMContactUI.class);
            MMWizardActivity.m23791J(BindSafeDeviceUI.this, intent);
            AppMethodBeat.m2505o(69859);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getLayoutId() {
        return 2130970577;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(69860);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(69860);
    }

    public final void initView() {
        AppMethodBeat.m2504i(69861);
        setMMTitle((int) C25738R.string.dvx);
        setBackBtn(new C165721());
        ((ImageView) findViewById(2131827287)).setImageResource(C1318a.accounts_saftphone_icon);
        ((TextView) findViewById(2131827288)).setText(C25738R.string.dw3);
        ((TextView) findViewById(2131827291)).setText(C25738R.string.dw4);
        findViewById(2131827291).setOnClickListener(new C165732());
        AppMethodBeat.m2505o(69861);
    }
}
