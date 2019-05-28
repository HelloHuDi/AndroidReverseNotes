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
import com.tencent.mm.sdk.platformtools.ab;

@Deprecated
public class FreewifiActivateWeChatNoAuthStateUI extends FreeWifiActivateNoAuthStateUI {
    private int cyC;
    private String mAs;
    private String mAt;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* Access modifiers changed, original: protected|final */
    public final String bzA() {
        AppMethodBeat.i(21112);
        String string = getString(R.string.c0t);
        AppMethodBeat.o(21112);
        return string;
    }

    public final void a(State state) {
        AppMethodBeat.i(21113);
        ab.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "now network state : %s", state.toString());
        if (state == State.CONNECTED && d.MD(this.ssid) && this.mxY) {
            bzD();
            this.mxY = false;
            this.mAs = d.byK();
            this.mAt = d.byO();
            this.cyC = d.byL();
            ab.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "now has connect the ap, check from server rssi is :  %d, mac : %s, ssid is : %s", Integer.valueOf(this.cyC), this.mAs, this.mAt);
            new a(this.jUg, this.mAs, this.mAt, this.cyC, this.cdf, m.V(getIntent())).c(new f() {
                public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
                    AppMethodBeat.i(21111);
                    aw.Rg().b(640, (f) this);
                    ab.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "onSceneEnd, errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
                    if (i == 0 && i2 == 0) {
                        ab.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "check ap ok");
                        d.a(FreewifiActivateWeChatNoAuthStateUI.this.ssid, 2, FreewifiActivateWeChatNoAuthStateUI.this.getIntent());
                        AppMethodBeat.o(21111);
                        return;
                    }
                    ab.e("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "check ap failed ： rssi is :  %d, mac : %s, ssid is : %s", Integer.valueOf(FreewifiActivateWeChatNoAuthStateUI.this.cyC), FreewifiActivateWeChatNoAuthStateUI.this.mAs, FreewifiActivateWeChatNoAuthStateUI.this.mAt);
                    FreewifiActivateWeChatNoAuthStateUI.this.uQ(-2014);
                    d.MF(FreewifiActivateWeChatNoAuthStateUI.this.mAt);
                    AppMethodBeat.o(21111);
                }
            });
        }
        AppMethodBeat.o(21113);
    }

    public void onDestroy() {
        AppMethodBeat.i(21114);
        super.onDestroy();
        AppMethodBeat.o(21114);
    }

    /* Access modifiers changed, original: protected|final */
    public final int bzz() {
        AppMethodBeat.i(21115);
        j.byV();
        int MC = d.MC(this.ssid);
        ab.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "get connect state = %d", Integer.valueOf(MC));
        if (MC == 0) {
            AppMethodBeat.o(21115);
            return -2014;
        }
        AppMethodBeat.o(21115);
        return MC;
    }
}
