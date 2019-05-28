package com.tencent.p177mm.plugin.appbrand.dynamic.p770ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.widget.MMSwitchBtn;
import com.tencent.p177mm.p612ui.widget.MMSwitchBtn.C30795a;
import com.tencent.p177mm.plugin.appbrand.appcache.C45515j.C33097a;
import com.tencent.p177mm.plugin.appbrand.dynamic.debugger.C42423b;
import com.tencent.p177mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetSettingsUI */
public class WxaWidgetSettingsUI extends MMActivity {
    String appId;
    int cBc;

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetSettingsUI$3 */
    class C192073 implements C30795a {
        C192073() {
        }

        /* renamed from: di */
        public final void mo6646di(boolean z) {
            AppMethodBeat.m2504i(11032);
            DebuggerInfo Ad = C42423b.m75141Ad(WxaWidgetSettingsUI.this.appId);
            if (Ad == null) {
                Ad = new DebuggerInfo();
                C42423b.m75143a(WxaWidgetSettingsUI.this.appId, Ad);
            }
            Ad.hmD = z;
            AppMethodBeat.m2505o(11032);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetSettingsUI$2 */
    class C268732 implements C30795a {
        C268732() {
        }

        /* renamed from: di */
        public final void mo6646di(boolean z) {
            AppMethodBeat.m2504i(11031);
            DebuggerInfo Ad = C42423b.m75141Ad(WxaWidgetSettingsUI.this.appId);
            if (Ad == null) {
                Ad = new DebuggerInfo();
                C42423b.m75143a(WxaWidgetSettingsUI.this.appId, Ad);
            }
            Ad.hmF = z;
            AppMethodBeat.m2505o(11031);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetSettingsUI$1 */
    class C268741 implements OnMenuItemClickListener {
        C268741() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(11030);
            WxaWidgetSettingsUI.this.finish();
            AppMethodBeat.m2505o(11030);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        boolean z = false;
        AppMethodBeat.m2504i(11033);
        super.onCreate(bundle);
        setBackBtn(new C268741());
        setMMTitle((int) C25738R.string.g3n);
        this.appId = getIntent().getStringExtra("app_id");
        this.cBc = getIntent().getIntExtra("pkg_type", 0);
        MMSwitchBtn mMSwitchBtn = (MMSwitchBtn) findViewById(2131829243);
        DebuggerInfo Ad = C42423b.m75141Ad(this.appId);
        boolean z2 = Ad != null && Ad.hmF;
        mMSwitchBtn.setCheck(z2);
        mMSwitchBtn.setSwitchListener(new C268732());
        mMSwitchBtn = (MMSwitchBtn) findViewById(2131829244);
        if ((Ad != null && Ad.hmD) || C33097a.m54089kR(this.cBc)) {
            z = true;
        }
        mMSwitchBtn.setCheck(z);
        mMSwitchBtn.setEnabled(C33097a.m54090np(this.cBc));
        mMSwitchBtn.setSwitchListener(new C192073());
        AppMethodBeat.m2505o(11033);
    }

    public final int getLayoutId() {
        return 2130971251;
    }
}
