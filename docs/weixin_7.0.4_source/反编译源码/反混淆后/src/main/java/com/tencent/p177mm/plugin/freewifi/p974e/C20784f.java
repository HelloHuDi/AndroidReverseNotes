package com.tencent.p177mm.plugin.freewifi.p974e;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.freewifi.C11966k;
import com.tencent.p177mm.plugin.freewifi.C11966k.C11967a;
import com.tencent.p177mm.plugin.freewifi.C11966k.C11968b;
import com.tencent.p177mm.plugin.freewifi.C28073c;
import com.tencent.p177mm.plugin.freewifi.C28073c.C119551;
import com.tencent.p177mm.plugin.freewifi.C28073c.C28074a;
import com.tencent.p177mm.plugin.freewifi.C34189m;
import com.tencent.p177mm.plugin.freewifi.C39108e;
import com.tencent.p177mm.plugin.freewifi.ConnectSsidPasswordHelper$2;
import com.tencent.p177mm.plugin.freewifi.model.C11976j;
import com.tencent.p177mm.plugin.freewifi.model.C45957d;
import com.tencent.p177mm.plugin.freewifi.p418ui.FreeWifiCopyPwdUI;
import com.tencent.p177mm.plugin.freewifi.p418ui.FreeWifiFrontPageUI;
import com.tencent.p177mm.plugin.freewifi.p418ui.FreeWifiFrontPageUI.C28088a;
import com.tencent.p177mm.plugin.freewifi.p418ui.FreeWifiFrontPageUI.C28089d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.concurrent.TimeUnit;

/* renamed from: com.tencent.mm.plugin.freewifi.e.f */
public final class C20784f extends C28079e implements C39102a {
    private String gDC = this.intent.getStringExtra("free_wifi_passowrd");

    public C20784f(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        super(freeWifiFrontPageUI);
        AppMethodBeat.m2504i(20810);
        C4990ab.m7417i("MicroMsg.FreeWifi.ProtocolFour", "sessionKey=%s, step=%d, desc=Data retrieved. password=%s", C34189m.m56063V(this.intent), Integer.valueOf(C34189m.m56064W(this.intent)), this.gDC);
        AppMethodBeat.m2505o(20810);
    }

    public final void connect() {
        AppMethodBeat.m2504i(20811);
        final C28073c c28073c = new C28073c(this.ssid, this.mwF, this.gDC);
        C11976j.byU();
        C11976j.byZ().byI().post(new Runnable() {

            /* renamed from: com.tencent.mm.plugin.freewifi.e.f$1$1 */
            class C207831 implements C28074a {
                C207831() {
                }

                public final void onSuccess() {
                    AppMethodBeat.m2504i(20807);
                    C4990ab.m7417i("MicroMsg.FreeWifi.ProtocolFour", "sessionKey=%s, step=%d, desc=connect ssid succeeded. ", C34189m.m56063V(C20784f.this.intent), Integer.valueOf(C34189m.m56064W(C20784f.this.intent)));
                    C11967a byo = C11966k.byo();
                    byo.ssid = C20784f.this.ssid;
                    byo.bssid = C34189m.m56060My("MicroMsg.FreeWifi.ProtocolFour");
                    byo.cuI = C34189m.m56061Mz("MicroMsg.FreeWifi.ProtocolFour");
                    byo.cuH = C20784f.this.cuH;
                    byo.mud = C20784f.this.appId;
                    byo.kBq = C34189m.m56063V(C20784f.this.intent);
                    byo.mue = C34189m.m56065X(C20784f.this.intent);
                    byo.muf = C11968b.AddNetwork.muQ;
                    byo.mug = C11968b.AddNetwork.name;
                    byo.result = 0;
                    byo.cIb = C34189m.m56066Y(C20784f.this.intent);
                    byo.byq().byp();
                    C34189m.m56071a(C20784f.this.intent, C20784f.this.cuH, C20784f.this.mwG, C20784f.this.cdf, C20784f.this.mwF, "MicroMsg.FreeWifi.ProtocolFour");
                    AppMethodBeat.m2505o(20807);
                }

                public final void onFail(int i) {
                    AppMethodBeat.m2504i(20808);
                    C4990ab.m7417i("MicroMsg.FreeWifi.ProtocolFour", "sessionKey=%s, step=%d, method=connect, desc=An attempt to connect to ssid failed. ssid=%s, errCode=%d", C34189m.m56063V(C20784f.this.intent), Integer.valueOf(C34189m.m56064W(C20784f.this.intent)), C20784f.this.ssid, Integer.valueOf(i));
                    C11967a byo = C11966k.byo();
                    byo.ssid = C20784f.this.ssid;
                    byo.bssid = C34189m.m56060My("MicroMsg.FreeWifi.ProtocolFour");
                    byo.cuI = C34189m.m56061Mz("MicroMsg.FreeWifi.ProtocolFour");
                    byo.cuH = C20784f.this.cuH;
                    byo.mud = C20784f.this.appId;
                    byo.kBq = C34189m.m56063V(C20784f.this.intent);
                    byo.mue = C34189m.m56065X(C20784f.this.intent);
                    byo.muf = C11968b.AddNetwork.muQ;
                    byo.mug = C11968b.AddNetwork.name;
                    byo.result = i;
                    byo.cIb = C34189m.m56066Y(C20784f.this.intent);
                    byo.byq().byp();
                    FreeWifiFrontPageUI freeWifiFrontPageUI;
                    C28089d c28089d;
                    C28088a c28088a;
                    if (i == -16) {
                        C20784f.this.intent.setClass(C20784f.this.mwF.mController.ylL, FreeWifiCopyPwdUI.class);
                        C20784f.this.mwF.finish();
                        C20784f.this.mwF.startActivity(C20784f.this.intent);
                        AppMethodBeat.m2505o(20808);
                    } else if (i == -14 || i == -18) {
                        freeWifiFrontPageUI = C20784f.this.mwF;
                        c28089d = C28089d.FAIL;
                        c28088a = new C28088a();
                        c28088a.myH = C25738R.string.bzr;
                        c28088a.myI = C34189m.m56068a(C20784f.this.mwG, C11968b.AddNetwork, i);
                        freeWifiFrontPageUI.mo62019a(c28089d, c28088a);
                        AppMethodBeat.m2505o(20808);
                    } else {
                        freeWifiFrontPageUI = C20784f.this.mwF;
                        c28089d = C28089d.FAIL;
                        c28088a = new C28088a();
                        c28088a.myH = C25738R.string.bzq;
                        c28088a.myI = C34189m.m56068a(C20784f.this.mwG, C11968b.AddNetwork, i);
                        freeWifiFrontPageUI.mo62019a(c28089d, c28088a);
                        AppMethodBeat.m2505o(20808);
                    }
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(20809);
                C28073c c28073c = c28073c;
                C119551 c119551 = new C119551(new C207831());
                if (((ConnectivityManager) C4996ah.getContext().getSystemService("connectivity")).getNetworkInfo(1).isConnected() && c28073c.ssid.equals(C45957d.byO())) {
                    c119551.onSuccess();
                    AppMethodBeat.m2505o(20809);
                } else if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    RuntimeException runtimeException = new RuntimeException("ConnectNetworkHelper组件不能在主线程中运行。");
                    AppMethodBeat.m2505o(20809);
                    throw runtimeException;
                } else {
                    c28073c.broadcastReceiver = new ConnectSsidPasswordHelper$2(c28073c);
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.net.wifi.STATE_CHANGE");
                    intentFilter.addAction("android.net.wifi.supplicant.STATE_CHANGE");
                    try {
                        int bye;
                        c28073c.aCZ.lock();
                        c28073c.activity.registerReceiver(c28073c.broadcastReceiver, intentFilter);
                        if (!c28073c.bJj.isWifiEnabled()) {
                            bye = new C39108e(c28073c.activity).bye();
                            C4990ab.m7416i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "enable ret = ".concat(String.valueOf(bye)));
                            if (bye != 0) {
                                c119551.onFail(bye);
                                c28073c.byc();
                                c28073c.aCZ.unlock();
                                AppMethodBeat.m2505o(20809);
                                return;
                            }
                        }
                        bye = C45957d.m85353c(c28073c.ssid, c28073c.gDC, 3, false);
                        if (bye != 0) {
                            c28073c.byc();
                            c119551.onFail(bye);
                            c28073c.byc();
                            c28073c.aCZ.unlock();
                            AppMethodBeat.m2505o(20809);
                            return;
                        }
                        boolean z;
                        if (c28073c.connected || c28073c.mtH) {
                            z = false;
                        } else {
                            z = c28073c.cbS.await(c28073c.ftP, TimeUnit.MILLISECONDS);
                        }
                        if (!z) {
                            c119551.onFail(-16);
                        } else if (c28073c.connected) {
                            c119551.onSuccess();
                        } else if (c28073c.mtH) {
                            c119551.onFail(-18);
                        }
                        c28073c.byc();
                        c28073c.aCZ.unlock();
                        AppMethodBeat.m2505o(20809);
                    } catch (InterruptedException e) {
                        C4990ab.m7417i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "sessionKey=%s, step=%d, desc=ConnectNetworkHelper encounter interrupted exception. msg=%s", C34189m.m56063V(c28073c.activity.getIntent()), Integer.valueOf(C34189m.m56064W(c28073c.activity.getIntent())), e.getMessage());
                        c119551.onFail(-17);
                        c28073c.byc();
                        c28073c.aCZ.unlock();
                        AppMethodBeat.m2505o(20809);
                    } catch (Throwable th) {
                        c28073c.byc();
                        c28073c.aCZ.unlock();
                        AppMethodBeat.m2505o(20809);
                        throw th;
                    }
                }
            }
        });
        AppMethodBeat.m2505o(20811);
    }
}
