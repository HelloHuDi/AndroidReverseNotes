package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;

/* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingDeleteAccountInputPassUI */
public class SettingDeleteAccountInputPassUI extends MMActivity {

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingDeleteAccountInputPassUI$1 */
    class C289391 implements OnMenuItemClickListener {
        C289391() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127066);
            SettingDeleteAccountInputPassUI.this.aqX();
            SettingDeleteAccountInputPassUI.this.finish();
            AppMethodBeat.m2505o(127066);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingDeleteAccountInputPassUI$2 */
    class C289402 implements OnMenuItemClickListener {
        C289402() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127067);
            SettingDeleteAccountInputPassUI.this.aqX();
            SettingDeleteAccountInputPassUI.this.startActivity(new Intent(SettingDeleteAccountInputPassUI.this, SettingDeleteAccountUI.class));
            AppMethodBeat.m2505o(127067);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getLayoutId() {
        return 2130970625;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(127068);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.e45);
        initView();
        AppMethodBeat.m2505o(127068);
    }

    public final void initView() {
        AppMethodBeat.m2504i(127069);
        setBackBtn(new C289391());
        addTextOptionMenu(0, getString(C25738R.string.f9142qt), new C289402());
        AppMethodBeat.m2505o(127069);
    }
}
