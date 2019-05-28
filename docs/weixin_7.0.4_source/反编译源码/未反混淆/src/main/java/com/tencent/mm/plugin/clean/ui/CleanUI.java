package com.tencent.mm.plugin.clean.ui;

import android.content.Intent;
import android.content.pm.Signature;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import org.json.JSONException;
import org.json.JSONObject;

@a(19)
public class CleanUI extends MMActivity {
    private long kwP;
    private String kwQ = "com.tencent.qqpimsecure";
    private String kwR = "00B1208638DE0FCD3E920886D658DAF6";
    private String kwS = "11206657";
    private JSONObject kwT;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(18731);
        super.onCreate(bundle);
        if (getIntent().getBooleanExtra("had_detected_no_sdcard_space", false) && bgf()) {
            finish();
            AppMethodBeat.o(18731);
            return;
        }
        startActivity(new Intent(this, CleanNewUI.class));
        finish();
        AppMethodBeat.o(18731);
    }

    private boolean bgf() {
        AppMethodBeat.i(18732);
        bgg();
        if (p.u(this.mController.ylL, this.kwQ)) {
            Signature[] bx = p.bx(this, this.kwQ);
            if (!(bx == null || bx[0] == null)) {
                String x = g.x(bx[0].toByteArray());
                if (x != null && x.equalsIgnoreCase(this.kwR)) {
                    try {
                        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(this.kwQ);
                        if (launchIntentForPackage != null) {
                            Bundle bundle = new Bundle();
                            p.j(bundle, this.kwS);
                            launchIntentForPackage.putExtras(bundle);
                            launchIntentForPackage.addFlags(268435456);
                            startActivity(launchIntentForPackage);
                            h.pYm.a(282, 6, 1, false);
                            AppMethodBeat.o(18732);
                            return true;
                        }
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.CleanUI", e, "", new Object[0]);
                    }
                    AppMethodBeat.o(18732);
                    return true;
                }
            }
            AppMethodBeat.o(18732);
            return false;
        }
        AppMethodBeat.o(18732);
        return false;
    }

    private boolean bgg() {
        AppMethodBeat.i(18733);
        aw.ZK();
        String str = (String) c.Ry().get(ac.a.USERINFO_CLEANUI_QQMGRINFO_STRING, (Object) "");
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(18733);
            return false;
        }
        try {
            this.kwT = new JSONObject(str);
            this.kwQ = this.kwT.getString(DownloadInfoColumns.PACKAGENAME);
            this.kwT.get("md5");
            this.kwS = this.kwT.getString("launcherID");
            this.kwR = this.kwT.getString("signature");
            this.kwT.get("url");
            this.kwP = this.kwT.getLong("size");
            AppMethodBeat.o(18733);
            return true;
        } catch (JSONException e) {
            ab.printErrStackTrace("MicroMsg.CleanUI", e, "", new Object[0]);
            AppMethodBeat.o(18733);
            return false;
        }
    }

    public final int getLayoutId() {
        return R.layout.om;
    }
}
