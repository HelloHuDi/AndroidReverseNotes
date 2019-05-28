package com.tencent.p177mm.plugin.clean.p364ui;

import android.content.Intent;
import android.content.pm.Signature;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.clean.p364ui.fileindexui.CleanNewUI;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import org.json.JSONException;
import org.json.JSONObject;

@C5271a(19)
/* renamed from: com.tencent.mm.plugin.clean.ui.CleanUI */
public class CleanUI extends MMActivity {
    private long kwP;
    private String kwQ = "com.tencent.qqpimsecure";
    private String kwR = "00B1208638DE0FCD3E920886D658DAF6";
    private String kwS = "11206657";
    private JSONObject kwT;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(18731);
        super.onCreate(bundle);
        if (getIntent().getBooleanExtra("had_detected_no_sdcard_space", false) && bgf()) {
            finish();
            AppMethodBeat.m2505o(18731);
            return;
        }
        startActivity(new Intent(this, CleanNewUI.class));
        finish();
        AppMethodBeat.m2505o(18731);
    }

    private boolean bgf() {
        AppMethodBeat.m2504i(18732);
        bgg();
        if (C35799p.m58695u(this.mController.ylL, this.kwQ)) {
            Signature[] bx = C35799p.m58691bx(this, this.kwQ);
            if (!(bx == null || bx[0] == null)) {
                String x = C1178g.m2591x(bx[0].toByteArray());
                if (x != null && x.equalsIgnoreCase(this.kwR)) {
                    try {
                        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(this.kwQ);
                        if (launchIntentForPackage != null) {
                            Bundle bundle = new Bundle();
                            C35799p.m58694j(bundle, this.kwS);
                            launchIntentForPackage.putExtras(bundle);
                            launchIntentForPackage.addFlags(268435456);
                            startActivity(launchIntentForPackage);
                            C7060h.pYm.mo8378a(282, 6, 1, false);
                            AppMethodBeat.m2505o(18732);
                            return true;
                        }
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace("MicroMsg.CleanUI", e, "", new Object[0]);
                    }
                    AppMethodBeat.m2505o(18732);
                    return true;
                }
            }
            AppMethodBeat.m2505o(18732);
            return false;
        }
        AppMethodBeat.m2505o(18732);
        return false;
    }

    private boolean bgg() {
        AppMethodBeat.m2504i(18733);
        C9638aw.m17190ZK();
        String str = (String) C18628c.m29072Ry().get(C5127a.USERINFO_CLEANUI_QQMGRINFO_STRING, (Object) "");
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(18733);
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
            AppMethodBeat.m2505o(18733);
            return true;
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("MicroMsg.CleanUI", e, "", new Object[0]);
            AppMethodBeat.m2505o(18733);
            return false;
        }
    }

    public final int getLayoutId() {
        return 2130969145;
    }
}
