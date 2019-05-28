package com.tencent.p177mm.plugin.freewifi.p418ui;

import android.net.NetworkInfo.State;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.freewifi.C34189m;
import com.tencent.p177mm.plugin.freewifi.model.C11976j;
import com.tencent.p177mm.plugin.freewifi.model.C45957d;
import com.tencent.p177mm.plugin.freewifi.p416d.C28075a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

@Deprecated
/* renamed from: com.tencent.mm.plugin.freewifi.ui.FreewifiActivateWeChatNoAuthStateUI */
public class FreewifiActivateWeChatNoAuthStateUI extends FreeWifiActivateNoAuthStateUI {
    private int cyC;
    private String mAs;
    private String mAt;

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreewifiActivateWeChatNoAuthStateUI$1 */
    class C391231 implements C1202f {
        C391231() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(21111);
            C9638aw.m17182Rg().mo14546b(640, (C1202f) this);
            C4990ab.m7417i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "onSceneEnd, errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
            if (i == 0 && i2 == 0) {
                C4990ab.m7416i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "check ap ok");
                C45957d.m85352a(FreewifiActivateWeChatNoAuthStateUI.this.ssid, 2, FreewifiActivateWeChatNoAuthStateUI.this.getIntent());
                AppMethodBeat.m2505o(21111);
                return;
            }
            C4990ab.m7413e("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "check ap failed ： rssi is :  %d, mac : %s, ssid is : %s", Integer.valueOf(FreewifiActivateWeChatNoAuthStateUI.this.cyC), FreewifiActivateWeChatNoAuthStateUI.this.mAs, FreewifiActivateWeChatNoAuthStateUI.this.mAt);
            FreewifiActivateWeChatNoAuthStateUI.this.mo17578uQ(-2014);
            C45957d.m85350MF(FreewifiActivateWeChatNoAuthStateUI.this.mAt);
            AppMethodBeat.m2505o(21111);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* Access modifiers changed, original: protected|final */
    public final String bzA() {
        AppMethodBeat.m2504i(21112);
        String string = getString(C25738R.string.c0t);
        AppMethodBeat.m2505o(21112);
        return string;
    }

    /* renamed from: a */
    public final void mo17587a(State state) {
        AppMethodBeat.m2504i(21113);
        C4990ab.m7417i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "now network state : %s", state.toString());
        if (state == State.CONNECTED && C45957d.m85348MD(this.ssid) && this.mxY) {
            bzD();
            this.mxY = false;
            this.mAs = C45957d.byK();
            this.mAt = C45957d.byO();
            this.cyC = C45957d.byL();
            C4990ab.m7417i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "now has connect the ap, check from server rssi is :  %d, mac : %s, ssid is : %s", Integer.valueOf(this.cyC), this.mAs, this.mAt);
            new C28075a(this.jUg, this.mAs, this.mAt, this.cyC, this.cdf, C34189m.m56063V(getIntent())).mo68619c(new C391231());
        }
        AppMethodBeat.m2505o(21113);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(21114);
        super.onDestroy();
        AppMethodBeat.m2505o(21114);
    }

    /* Access modifiers changed, original: protected|final */
    public final int bzz() {
        AppMethodBeat.m2504i(21115);
        C11976j.byV();
        int MC = C45957d.m85347MC(this.ssid);
        C4990ab.m7417i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "get connect state = %d", Integer.valueOf(MC));
        if (MC == 0) {
            AppMethodBeat.m2505o(21115);
            return -2014;
        }
        AppMethodBeat.m2505o(21115);
        return MC;
    }
}
