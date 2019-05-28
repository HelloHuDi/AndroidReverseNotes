package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;

/* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingDeleteAccountUI */
public class SettingDeleteAccountUI extends MMActivity {

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingDeleteAccountUI$1 */
    class C348641 implements OnMenuItemClickListener {
        C348641() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127070);
            SettingDeleteAccountUI.this.aqX();
            SettingDeleteAccountUI.this.finish();
            AppMethodBeat.m2505o(127070);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingDeleteAccountUI$2 */
    class C348652 implements OnClickListener {
        C348652() {
        }

        public final void onClick(View view) {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getLayoutId() {
        return 2130970623;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(127071);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.e45);
        initView();
        AppMethodBeat.m2505o(127071);
    }

    public final void initView() {
        AppMethodBeat.m2504i(127072);
        setBackBtn(new C348641());
        ((TextView) findViewById(2131827369)).setOnClickListener(new C348652());
        AppMethodBeat.m2505o(127072);
    }
}
