package com.tencent.p177mm.plugin.freewifi.p418ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.modelgeo.C26443d;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.freewifi.C34189m;
import com.tencent.p177mm.plugin.freewifi.model.C11976j;
import com.tencent.p177mm.plugin.freewifi.model.C39113g.C20800b;
import com.tencent.p177mm.plugin.freewifi.model.C45957d;
import com.tencent.p177mm.plugin.freewifi.p416d.C28075a;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.protocal.protobuf.C23391gj;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

@Deprecated
/* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiAuthStateUI */
public class FreeWifiAuthStateUI extends FreeWifiStateUI {
    private boolean myf = true;

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiAuthStateUI$2 */
    class C119832 implements OnClickListener {
        C119832() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(20910);
            C26443d.m42103bX(FreeWifiAuthStateUI.this);
            AppMethodBeat.m2505o(20910);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiAuthStateUI$1 */
    class C208021 implements C20800b {

        /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiAuthStateUI$1$1 */
        class C208031 implements C1202f {
            C208031() {
            }

            public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                AppMethodBeat.m2504i(20908);
                C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "errType : %d, errCode : %d, errMsg : %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                FreeWifiAuthStateUI.this.mxY = false;
                if (i == 0 && i2 == 0) {
                    C28075a c28075a = (C28075a) c1207m;
                    C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "authUrl : %s", c28075a.bze());
                    C23391gj bzj = c28075a.bzj();
                    if (bzj != null) {
                        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", bzj.vEn, bzj.jCH, bzj.jBB, Integer.valueOf(bzj.vID), bzj.vIE, bzj.guQ);
                        FreeWifiAuthStateUI.this.csB = bzj.vEn;
                        FreeWifiAuthStateUI.this.mwH = bzj.jCH;
                        FreeWifiAuthStateUI.this.cBb = bzj.jBB;
                        FreeWifiAuthStateUI.this.mzZ = bzj.vID;
                        FreeWifiAuthStateUI.this.mAa = bzj.vIE;
                        FreeWifiAuthStateUI.this.signature = bzj.guQ;
                        FreeWifiAuthStateUI.this.mAb = bzj.vIF;
                    }
                    C11976j.bzb().mo7394a(FreeWifiAuthStateUI.this.ssid, r0, FreeWifiAuthStateUI.this.getIntent());
                    AppMethodBeat.m2505o(20908);
                } else if (i2 == -2014) {
                    C45957d.m85352a(FreeWifiAuthStateUI.this.ssid, -2014, FreeWifiAuthStateUI.this.getIntent());
                    AppMethodBeat.m2505o(20908);
                } else {
                    C45957d.m85352a(FreeWifiAuthStateUI.this.ssid, 3, FreeWifiAuthStateUI.this.getIntent());
                    AppMethodBeat.m2505o(20908);
                }
            }
        }

        C208021() {
        }

        /* renamed from: ci */
        public final void mo36090ci(String str, int i) {
            AppMethodBeat.m2504i(20909);
            C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "get ap auth data : %s, url : %s, mac : %s", str, FreeWifiAuthStateUI.this.jUg, C45957d.byK());
            if (!C5046bo.isNullOrNil(str)) {
                String str2 = str;
                new C28075a(FreeWifiAuthStateUI.this.jUg, FreeWifiAuthStateUI.this.ssid, r3, FreeWifiAuthStateUI.this.mxW, str2, "", i, C34189m.m56063V(FreeWifiAuthStateUI.this.getIntent())).mo68619c(new C208031());
            }
            AppMethodBeat.m2505o(20909);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(20911);
        super.onCreate(bundle);
        AppMethodBeat.m2505o(20911);
    }

    public final void initView() {
        AppMethodBeat.m2504i(20912);
        super.initView();
        setMMTitle((int) C25738R.string.c0t);
        C45957d.m85352a(this.ssid, 4, getIntent());
        AppMethodBeat.m2505o(20912);
    }

    /* JADX WARNING: Missing block: B:3:0x0029, code skipped:
            if (com.tencent.p177mm.pluginsdk.permission.C35805b.m58707a(r9, "android.permission.ACCESS_COARSE_LOCATION", 77, null, null) == false) goto L_0x002b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResume() {
        int i = false;
        AppMethodBeat.m2504i(20913);
        super.onResume();
        if (this.myf) {
            C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "summerper checkPermission checkLocation [%b]", Boolean.valueOf(C35805b.m58707a(this, "android.permission.ACCESS_COARSE_LOCATION", 77, null, null)));
        }
        if (C35805b.m58714o(this, "android.permission.ACCESS_COARSE_LOCATION")) {
            if (C26443d.agA()) {
                i = 1;
            } else {
                C30379h.m48445a((Context) this, getString(C25738R.string.c9z), getString(C25738R.string.f9238tz), getString(C25738R.string.ckr), getString(C25738R.string.f9076or), false, new C119832(), null);
            }
        }
        if (i == 0) {
            C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "check permission not passed!");
        }
        C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "now it is from qrcode, try to auth");
        AppMethodBeat.m2505o(20913);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(20914);
        super.onDestroy();
        AppMethodBeat.m2505o(20914);
    }

    /* renamed from: a */
    public final void mo17587a(State state) {
        AppMethodBeat.m2504i(20915);
        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "now network state : %s", state.toString());
        if (state == State.CONNECTED && C45957d.m85348MD(this.ssid)) {
            bzD();
            bzF();
        }
        AppMethodBeat.m2505o(20915);
    }

    /* Access modifiers changed, original: protected|final */
    public final void aqU() {
        AppMethodBeat.m2504i(20916);
        C11976j.bzb().mo7393a(this.ssid, new C208021(), this.cdf, getIntent());
        AppMethodBeat.m2505o(20916);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(20917);
        if (iArr == null || iArr.length <= 0) {
            C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.m2505o(20917);
            return;
        }
        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        if (iArr.length == 0) {
            AppMethodBeat.m2505o(20917);
            return;
        }
        switch (i) {
            case 64:
                if (iArr[0] != 0) {
                    this.myf = false;
                    break;
                }
                break;
        }
        AppMethodBeat.m2505o(20917);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bzy() {
        AppMethodBeat.m2504i(20918);
        bzC();
        C45957d.m85349ME(this.ssid);
        AppMethodBeat.m2505o(20918);
    }

    /* Access modifiers changed, original: protected|final */
    public final int bzz() {
        AppMethodBeat.m2504i(20919);
        C11976j.byV();
        int MC = C45957d.m85347MC(this.ssid);
        AppMethodBeat.m2505o(20919);
        return MC;
    }
}
