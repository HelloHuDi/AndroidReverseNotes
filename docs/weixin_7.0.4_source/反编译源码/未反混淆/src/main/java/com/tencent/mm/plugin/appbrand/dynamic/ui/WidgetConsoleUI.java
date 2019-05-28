package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.modelappbrand.l.a;
import com.tencent.mm.plugin.appbrand.wxawidget.console.ConsolePanel;
import com.tencent.mm.plugin.appbrand.wxawidget.console.d;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

public class WidgetConsoleUI extends MMActivity implements a {
    String appId;
    int cBc;
    int gVu;
    ConsolePanel hoZ;
    String id;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(11004);
        super.onCreate(bundle);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN);
                WidgetConsoleUI.this.finish();
                AppMethodBeat.o(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN);
                return false;
            }
        });
        setMMTitle((int) R.string.gb5);
        this.hoZ = (ConsolePanel) findViewById(R.id.flm);
        if (aAk()) {
            AppMethodBeat.o(11004);
            return;
        }
        finish();
        AppMethodBeat.o(11004);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(TXCStreamUploader.TXE_UPLOAD_INFO_HANDSHAKE_FAIL);
        super.onNewIntent(intent);
        if (aAk()) {
            AppMethodBeat.o(TXCStreamUploader.TXE_UPLOAD_INFO_HANDSHAKE_FAIL);
            return;
        }
        finish();
        AppMethodBeat.o(TXCStreamUploader.TXE_UPLOAD_INFO_HANDSHAKE_FAIL);
    }

    private boolean aAk() {
        AppMethodBeat.i(TXCStreamUploader.TXE_UPLOAD_INFO_CONNECT_FAILED);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("id");
        this.appId = intent.getStringExtra("app_id");
        this.cBc = intent.getIntExtra("pkg_type", 0);
        this.gVu = intent.getIntExtra("pkg_version", 0);
        setMMSubTitle(String.format("(%s)", new Object[]{stringExtra}));
        if (bo.isNullOrNil(stringExtra)) {
            AppMethodBeat.o(TXCStreamUploader.TXE_UPLOAD_INFO_CONNECT_FAILED);
            return false;
        } else if (stringExtra.equals(this.id)) {
            AppMethodBeat.o(TXCStreamUploader.TXE_UPLOAD_INFO_CONNECT_FAILED);
            return true;
        } else {
            ((e) g.K(e.class)).abz().b(this.id, this);
            ((e) g.K(e.class)).abz().a(stringExtra, this);
            this.id = stringExtra;
            d.a(this.hoZ);
            AppMethodBeat.o(TXCStreamUploader.TXE_UPLOAD_INFO_CONNECT_FAILED);
            return true;
        }
    }

    public final void kS(int i) {
        String str;
        AppMethodBeat.i(TXCStreamUploader.TXE_UPLOAD_INFO_SERVER_REFUSE);
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
        com.tencent.mm.ce.a.q(new Runnable() {
            public final void run() {
                AppMethodBeat.i(TXCStreamUploader.TXE_UPLOAD_INFO_NET_BUSY);
                WidgetConsoleUI.this.setMMTitle(String.format("%s%s", new Object[]{WidgetConsoleUI.this.getString(R.string.gb5), str}));
                Toast.makeText(WidgetConsoleUI.this.mController.ylL, String.format("%s%s", new Object[]{WidgetConsoleUI.this.id, str}), 1).show();
                AppMethodBeat.o(TXCStreamUploader.TXE_UPLOAD_INFO_NET_BUSY);
            }
        });
        AppMethodBeat.o(TXCStreamUploader.TXE_UPLOAD_INFO_SERVER_REFUSE);
    }

    public void onDestroy() {
        AppMethodBeat.i(TXCStreamUploader.TXE_UPLOAD_INFO_PUBLISH_START);
        super.onDestroy();
        ((e) g.K(e.class)).abz().b(this.id, this);
        d.b(this.hoZ);
        AppMethodBeat.o(TXCStreamUploader.TXE_UPLOAD_INFO_PUBLISH_START);
    }

    public void finish() {
        AppMethodBeat.i(11009);
        if (isFinishing() || this.uiu) {
            AppMethodBeat.o(11009);
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
        AppMethodBeat.o(11009);
    }

    public final int getLayoutId() {
        return R.layout.b7y;
    }
}
