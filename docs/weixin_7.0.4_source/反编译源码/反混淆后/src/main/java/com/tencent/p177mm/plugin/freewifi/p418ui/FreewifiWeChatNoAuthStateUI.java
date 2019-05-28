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
import com.tencent.p177mm.protocal.protobuf.C23391gj;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

@Deprecated
/* renamed from: com.tencent.mm.plugin.freewifi.ui.FreewifiWeChatNoAuthStateUI */
public class FreewifiWeChatNoAuthStateUI extends FreeWifiNoAuthStateUI {
    private int cyC;
    private String mAs;
    private String mAt;

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreewifiWeChatNoAuthStateUI$1 */
    class C208101 implements C1202f {
        C208101() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(21116);
            C9638aw.m17182Rg().mo14546b(640, (C1202f) this);
            C4990ab.m7417i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "onSceneEnd, errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
            if (i == 0 && i2 == 0) {
                C4990ab.m7416i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "check ap ok");
                C23391gj bzj = ((C28075a) c1207m).bzj();
                if (bzj != null) {
                    C4990ab.m7417i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", bzj.vEn, bzj.jCH, bzj.jBB, Integer.valueOf(bzj.vID), bzj.vIE, bzj.guQ);
                    FreewifiWeChatNoAuthStateUI.this.csB = bzj.vEn;
                    FreewifiWeChatNoAuthStateUI.this.mwH = bzj.jCH;
                    FreewifiWeChatNoAuthStateUI.this.cBb = bzj.jBB;
                    FreewifiWeChatNoAuthStateUI.this.mzZ = bzj.vID;
                    FreewifiWeChatNoAuthStateUI.this.mAa = bzj.vIE;
                    FreewifiWeChatNoAuthStateUI.this.signature = bzj.guQ;
                    FreewifiWeChatNoAuthStateUI.this.mAb = bzj.vIF;
                }
                C45957d.m85352a(FreewifiWeChatNoAuthStateUI.this.ssid, 2, FreewifiWeChatNoAuthStateUI.this.getIntent());
                AppMethodBeat.m2505o(21116);
                return;
            }
            C4990ab.m7413e("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "check ap failed ： rssi is :  %d, mac : %s, ssid is : %s", Integer.valueOf(FreewifiWeChatNoAuthStateUI.this.cyC), FreewifiWeChatNoAuthStateUI.this.mAs, FreewifiWeChatNoAuthStateUI.this.mAt);
            C45957d.m85352a(FreewifiWeChatNoAuthStateUI.this.ssid, -2014, FreewifiWeChatNoAuthStateUI.this.getIntent());
            C45957d.m85350MF(FreewifiWeChatNoAuthStateUI.this.mAt);
            AppMethodBeat.m2505o(21116);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* Access modifiers changed, original: protected|final */
    public final String bzA() {
        AppMethodBeat.m2504i(21117);
        String string = getString(C25738R.string.c0t);
        AppMethodBeat.m2505o(21117);
        return string;
    }

    /* renamed from: a */
    public final void mo17587a(State state) {
        AppMethodBeat.m2504i(21118);
        C4990ab.m7417i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "now network state : %s", state.toString());
        if (state == State.CONNECTED && C45957d.m85348MD(this.ssid) && this.mxY) {
            bzD();
            this.mxY = false;
            this.mAs = C45957d.byK();
            this.mAt = C45957d.byO();
            this.cyC = C45957d.byL();
            C4990ab.m7417i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "now has connect the ap, check from server rssi is :  %d, mac : %s, ssid is : %s", Integer.valueOf(this.cyC), this.mAs, this.mAt);
            new C28075a(this.jUg, this.mAs, this.mAt, this.cyC, this.cdf, C34189m.m56063V(getIntent())).mo68619c(new C208101());
        }
        AppMethodBeat.m2505o(21118);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(21119);
        super.onDestroy();
        AppMethodBeat.m2505o(21119);
    }

    /* Access modifiers changed, original: protected|final */
    public final int bzz() {
        AppMethodBeat.m2504i(21120);
        C11976j.byV();
        int MC = C45957d.m85347MC(this.ssid);
        C4990ab.m7417i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "get connect state = %d", Integer.valueOf(MC));
        if (MC == 0) {
            AppMethodBeat.m2505o(21120);
            return -2014;
        }
        AppMethodBeat.m2505o(21120);
        return MC;
    }
}
