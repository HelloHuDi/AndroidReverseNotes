package com.tencent.p177mm.plugin.appbrand.dynamic.p770ui;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelappbrand.C18651l.C18650a;
import com.tencent.p177mm.modelappbrand.C9687e;
import com.tencent.p177mm.p1378ce.C26006a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.appbrand.wxawidget.console.C33656d;
import com.tencent.p177mm.plugin.appbrand.wxawidget.console.ConsolePanel;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.ui.WidgetConsoleUI */
public class WidgetConsoleUI extends MMActivity implements C18650a {
    String appId;
    int cBc;
    int gVu;
    ConsolePanel hoZ;
    /* renamed from: id */
    String f2133id;

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.ui.WidgetConsoleUI$1 */
    class C77161 implements OnMenuItemClickListener {
        C77161() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN);
            WidgetConsoleUI.this.finish();
            AppMethodBeat.m2505o(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(11004);
        super.onCreate(bundle);
        setBackBtn(new C77161());
        setMMTitle((int) C25738R.string.gb5);
        this.hoZ = (ConsolePanel) findViewById(2131829224);
        if (aAk()) {
            AppMethodBeat.m2505o(11004);
            return;
        }
        finish();
        AppMethodBeat.m2505o(11004);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(TXCStreamUploader.TXE_UPLOAD_INFO_HANDSHAKE_FAIL);
        super.onNewIntent(intent);
        if (aAk()) {
            AppMethodBeat.m2505o(TXCStreamUploader.TXE_UPLOAD_INFO_HANDSHAKE_FAIL);
            return;
        }
        finish();
        AppMethodBeat.m2505o(TXCStreamUploader.TXE_UPLOAD_INFO_HANDSHAKE_FAIL);
    }

    private boolean aAk() {
        AppMethodBeat.m2504i(TXCStreamUploader.TXE_UPLOAD_INFO_CONNECT_FAILED);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("id");
        this.appId = intent.getStringExtra("app_id");
        this.cBc = intent.getIntExtra("pkg_type", 0);
        this.gVu = intent.getIntExtra("pkg_version", 0);
        setMMSubTitle(String.format("(%s)", new Object[]{stringExtra}));
        if (C5046bo.isNullOrNil(stringExtra)) {
            AppMethodBeat.m2505o(TXCStreamUploader.TXE_UPLOAD_INFO_CONNECT_FAILED);
            return false;
        } else if (stringExtra.equals(this.f2133id)) {
            AppMethodBeat.m2505o(TXCStreamUploader.TXE_UPLOAD_INFO_CONNECT_FAILED);
            return true;
        } else {
            ((C9687e) C1720g.m3528K(C9687e.class)).abz().mo33912b(this.f2133id, this);
            ((C9687e) C1720g.m3528K(C9687e.class)).abz().mo33909a(stringExtra, this);
            this.f2133id = stringExtra;
            C33656d.m54962a(this.hoZ);
            AppMethodBeat.m2505o(TXCStreamUploader.TXE_UPLOAD_INFO_CONNECT_FAILED);
            return true;
        }
    }

    /* renamed from: kS */
    public final void mo17534kS(int i) {
        String str;
        AppMethodBeat.m2504i(TXCStreamUploader.TXE_UPLOAD_INFO_SERVER_REFUSE);
        switch (i) {
            case 1:
                str = "(START)";
                break;
            case 2:
                str = "(RESUME)";
                break;
            case 3:
                str = "(PAUSE)";
                break;
            case 4:
                str = "(STOP)";
                break;
            default:
                str = "";
                break;
        }
        C26006a.m41506q(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(TXCStreamUploader.TXE_UPLOAD_INFO_NET_BUSY);
                WidgetConsoleUI.this.setMMTitle(String.format("%s%s", new Object[]{WidgetConsoleUI.this.getString(C25738R.string.gb5), str}));
                Toast.makeText(WidgetConsoleUI.this.mController.ylL, String.format("%s%s", new Object[]{WidgetConsoleUI.this.f2133id, str}), 1).show();
                AppMethodBeat.m2505o(TXCStreamUploader.TXE_UPLOAD_INFO_NET_BUSY);
            }
        });
        AppMethodBeat.m2505o(TXCStreamUploader.TXE_UPLOAD_INFO_SERVER_REFUSE);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(TXCStreamUploader.TXE_UPLOAD_INFO_PUBLISH_START);
        super.onDestroy();
        ((C9687e) C1720g.m3528K(C9687e.class)).abz().mo33912b(this.f2133id, this);
        C33656d.m54963b(this.hoZ);
        AppMethodBeat.m2505o(TXCStreamUploader.TXE_UPLOAD_INFO_PUBLISH_START);
    }

    public void finish() {
        AppMethodBeat.m2504i(11009);
        if (isFinishing() || this.uiu) {
            AppMethodBeat.m2505o(11009);
            return;
        }
        if (VERSION.SDK_INT >= 21) {
            finishAndRemoveTask();
        } else {
            super.finish();
        }
        TypedArray obtainStyledAttributes = obtainStyledAttributes(16973825, new int[]{16842938, 16842939});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
        obtainStyledAttributes.recycle();
        overridePendingTransition(resourceId, resourceId2);
        AppMethodBeat.m2505o(11009);
    }

    public final int getLayoutId() {
        return 2130971235;
    }
}
