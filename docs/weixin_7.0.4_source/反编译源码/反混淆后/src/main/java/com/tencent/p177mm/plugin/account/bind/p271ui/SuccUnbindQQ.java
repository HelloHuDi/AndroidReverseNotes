package com.tencent.p177mm.plugin.account.bind.p271ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMWizardActivity;

/* renamed from: com.tencent.mm.plugin.account.bind.ui.SuccUnbindQQ */
public class SuccUnbindQQ extends MMWizardActivity {

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.SuccUnbindQQ$1 */
    class C98681 implements OnMenuItemClickListener {
        C98681() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(13771);
            SuccUnbindQQ.m53876a(SuccUnbindQQ.this);
            AppMethodBeat.m2505o(13771);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(13772);
        super.onCreate(bundle);
        AppMethodBeat.m2505o(13772);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(13773);
        super.onDestroy();
        AppMethodBeat.m2505o(13773);
    }

    public void onResume() {
        AppMethodBeat.m2504i(13774);
        super.onResume();
        initView();
        AppMethodBeat.m2505o(13774);
    }

    public final int getLayoutId() {
        return 2130970907;
    }

    public final void initView() {
        AppMethodBeat.m2504i(13775);
        setMMTitle((int) C25738R.string.ey9);
        addTextOptionMenu(0, getString(C25738R.string.f9142qt), new C98681());
        AppMethodBeat.m2505o(13775);
    }

    /* renamed from: a */
    static /* synthetic */ void m53876a(SuccUnbindQQ succUnbindQQ) {
        AppMethodBeat.m2504i(13776);
        succUnbindQQ.mo27541Ni(1);
        AppMethodBeat.m2505o(13776);
    }
}
