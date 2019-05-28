package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.appcache.j;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

public class WxaWidgetSettingsUI extends MMActivity {
    String appId;
    int cBc;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        boolean z = false;
        AppMethodBeat.i(11033);
        super.onCreate(bundle);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(11030);
                WxaWidgetSettingsUI.this.finish();
                AppMethodBeat.o(11030);
                return false;
            }
        });
        setMMTitle((int) R.string.g3n);
        this.appId = getIntent().getStringExtra("app_id");
        this.cBc = getIntent().getIntExtra("pkg_type", 0);
        MMSwitchBtn mMSwitchBtn = (MMSwitchBtn) findViewById(R.id.fm5);
        DebuggerInfo Ad = b.Ad(this.appId);
        boolean z2 = Ad != null && Ad.hmF;
        mMSwitchBtn.setCheck(z2);
        mMSwitchBtn.setSwitchListener(new a() {
            public final void di(boolean z) {
                AppMethodBeat.i(11031);
                DebuggerInfo Ad = b.Ad(WxaWidgetSettingsUI.this.appId);
                if (Ad == null) {
                    Ad = new DebuggerInfo();
                    b.a(WxaWidgetSettingsUI.this.appId, Ad);
                }
                Ad.hmF = z;
                AppMethodBeat.o(11031);
            }
        });
        mMSwitchBtn = (MMSwitchBtn) findViewById(R.id.fm6);
        if ((Ad != null && Ad.hmD) || j.a.kR(this.cBc)) {
            z = true;
        }
        mMSwitchBtn.setCheck(z);
        mMSwitchBtn.setEnabled(j.a.np(this.cBc));
        mMSwitchBtn.setSwitchListener(new a() {
            public final void di(boolean z) {
                AppMethodBeat.i(11032);
                DebuggerInfo Ad = b.Ad(WxaWidgetSettingsUI.this.appId);
                if (Ad == null) {
                    Ad = new DebuggerInfo();
                    b.a(WxaWidgetSettingsUI.this.appId, Ad);
                }
                Ad.hmD = z;
                AppMethodBeat.o(11032);
            }
        });
        AppMethodBeat.o(11033);
    }

    public final int getLayoutId() {
        return R.layout.b8d;
    }
}
