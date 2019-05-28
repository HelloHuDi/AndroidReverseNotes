package com.tencent.mm.plugin.freewifi.ui;

import android.net.NetworkInfo.State;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.protobuf.gj;
import com.tencent.mm.sdk.platformtools.ab;

@Deprecated
public class FreewifiWeChatNoAuthStateUI extends FreeWifiNoAuthStateUI {
    private int cyC;
    private String mAs;
    private String mAt;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* Access modifiers changed, original: protected|final */
    public final String bzA() {
        AppMethodBeat.i(21117);
        String string = getString(R.string.c0t);
        AppMethodBeat.o(21117);
        return string;
    }

    public final void a(State state) {
        AppMethodBeat.i(21118);
        ab.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "now network state : %s", state.toString());
        if (state == State.CONNECTED && d.MD(this.ssid) && this.mxY) {
            bzD();
            this.mxY = false;
            this.mAs = d.byK();
            this.mAt = d.byO();
            this.cyC = d.byL();
            ab.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "now has connect the ap, check from server rssi is :  %d, mac : %s, ssid is : %s", Integer.valueOf(this.cyC), this.mAs, this.mAt);
            new a(this.jUg, this.mAs, this.mAt, this.cyC, this.cdf, m.V(getIntent())).c(new f() {
                public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
                    AppMethodBeat.i(21116);
                    aw.Rg().b(640, (f) this);
                    ab.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "onSceneEnd, errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
                    if (i == 0 && i2 == 0) {
                        ab.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "check ap ok");
                        gj bzj = ((a) mVar).bzj();
                        if (bzj != null) {
                            ab.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", bzj.vEn, bzj.jCH, bzj.jBB, Integer.valueOf(bzj.vID), bzj.vIE, bzj.guQ);
                            FreewifiWeChatNoAuthStateUI.this.csB = bzj.vEn;
                            FreewifiWeChatNoAuthStateUI.this.mwH = bzj.jCH;
                            FreewifiWeChatNoAuthStateUI.this.cBb = bzj.jBB;
                            FreewifiWeChatNoAuthStateUI.this.mzZ = bzj.vID;
                            FreewifiWeChatNoAuthStateUI.this.mAa = bzj.vIE;
                            FreewifiWeChatNoAuthStateUI.this.signature = bzj.guQ;
                            FreewifiWeChatNoAuthStateUI.this.mAb = bzj.vIF;
                        }
                        d.a(FreewifiWeChatNoAuthStateUI.this.ssid, 2, FreewifiWeChatNoAuthStateUI.this.getIntent());
                        AppMethodBeat.o(21116);
                        return;
                    }
                    ab.e("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "check ap failed ： rssi is :  %d, mac : %s, ssid is : %s", Integer.valueOf(FreewifiWeChatNoAuthStateUI.this.cyC), FreewifiWeChatNoAuthStateUI.this.mAs, FreewifiWeChatNoAuthStateUI.this.mAt);
                    d.a(FreewifiWeChatNoAuthStateUI.this.ssid, -2014, FreewifiWeChatNoAuthStateUI.this.getIntent());
                    d.MF(FreewifiWeChatNoAuthStateUI.this.mAt);
                    AppMethodBeat.o(21116);
                }
            });
        }
        AppMethodBeat.o(21118);
    }

    public void onDestroy() {
        AppMethodBeat.i(21119);
        super.onDestroy();
        AppMethodBeat.o(21119);
    }

    /* Access modifiers changed, original: protected|final */
    public final int bzz() {
        AppMethodBeat.i(21120);
        j.byV();
        int MC = d.MC(this.ssid);
        ab.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "get connect state = %d", Integer.valueOf(MC));
        if (MC == 0) {
            AppMethodBeat.o(21120);
            return -2014;
        }
        AppMethodBeat.o(21120);
        return MC;
    }
}
