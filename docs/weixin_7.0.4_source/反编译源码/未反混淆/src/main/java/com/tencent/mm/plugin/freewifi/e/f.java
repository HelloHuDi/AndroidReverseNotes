package com.tencent.mm.plugin.freewifi.e;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.freewifi.ConnectSsidPasswordHelper$2;
import com.tencent.mm.plugin.freewifi.c;
import com.tencent.mm.plugin.freewifi.c.a;
import com.tencent.mm.plugin.freewifi.e;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiCopyPwdUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.concurrent.TimeUnit;

public final class f extends e implements a {
    private String gDC = this.intent.getStringExtra("free_wifi_passowrd");

    public f(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        super(freeWifiFrontPageUI);
        AppMethodBeat.i(20810);
        ab.i("MicroMsg.FreeWifi.ProtocolFour", "sessionKey=%s, step=%d, desc=Data retrieved. password=%s", m.V(this.intent), Integer.valueOf(m.W(this.intent)), this.gDC);
        AppMethodBeat.o(20810);
    }

    public final void connect() {
        AppMethodBeat.i(20811);
        final c cVar = new c(this.ssid, this.mwF, this.gDC);
        j.byU();
        j.byZ().byI().post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(20809);
                c cVar = cVar;
                com.tencent.mm.plugin.freewifi.c.AnonymousClass1 anonymousClass1 = new com.tencent.mm.plugin.freewifi.c.AnonymousClass1(new a() {
                    public final void onSuccess() {
                        AppMethodBeat.i(20807);
                        ab.i("MicroMsg.FreeWifi.ProtocolFour", "sessionKey=%s, step=%d, desc=connect ssid succeeded. ", m.V(f.this.intent), Integer.valueOf(m.W(f.this.intent)));
                        k.a byo = k.byo();
                        byo.ssid = f.this.ssid;
                        byo.bssid = m.My("MicroMsg.FreeWifi.ProtocolFour");
                        byo.cuI = m.Mz("MicroMsg.FreeWifi.ProtocolFour");
                        byo.cuH = f.this.cuH;
                        byo.mud = f.this.appId;
                        byo.kBq = m.V(f.this.intent);
                        byo.mue = m.X(f.this.intent);
                        byo.muf = b.AddNetwork.muQ;
                        byo.mug = b.AddNetwork.name;
                        byo.result = 0;
                        byo.cIb = m.Y(f.this.intent);
                        byo.byq().byp();
                        m.a(f.this.intent, f.this.cuH, f.this.mwG, f.this.cdf, f.this.mwF, "MicroMsg.FreeWifi.ProtocolFour");
                        AppMethodBeat.o(20807);
                    }

                    public final void onFail(int i) {
                        AppMethodBeat.i(20808);
                        ab.i("MicroMsg.FreeWifi.ProtocolFour", "sessionKey=%s, step=%d, method=connect, desc=An attempt to connect to ssid failed. ssid=%s, errCode=%d", m.V(f.this.intent), Integer.valueOf(m.W(f.this.intent)), f.this.ssid, Integer.valueOf(i));
                        k.a byo = k.byo();
                        byo.ssid = f.this.ssid;
                        byo.bssid = m.My("MicroMsg.FreeWifi.ProtocolFour");
                        byo.cuI = m.Mz("MicroMsg.FreeWifi.ProtocolFour");
                        byo.cuH = f.this.cuH;
                        byo.mud = f.this.appId;
                        byo.kBq = m.V(f.this.intent);
                        byo.mue = m.X(f.this.intent);
                        byo.muf = b.AddNetwork.muQ;
                        byo.mug = b.AddNetwork.name;
                        byo.result = i;
                        byo.cIb = m.Y(f.this.intent);
                        byo.byq().byp();
                        FreeWifiFrontPageUI freeWifiFrontPageUI;
                        d dVar;
                        FreeWifiFrontPageUI.a aVar;
                        if (i == -16) {
                            f.this.intent.setClass(f.this.mwF.mController.ylL, FreeWifiCopyPwdUI.class);
                            f.this.mwF.finish();
                            f.this.mwF.startActivity(f.this.intent);
                            AppMethodBeat.o(20808);
                        } else if (i == -14 || i == -18) {
                            freeWifiFrontPageUI = f.this.mwF;
                            dVar = d.FAIL;
                            aVar = new FreeWifiFrontPageUI.a();
                            aVar.myH = R.string.bzr;
                            aVar.myI = m.a(f.this.mwG, b.AddNetwork, i);
                            freeWifiFrontPageUI.a(dVar, aVar);
                            AppMethodBeat.o(20808);
                        } else {
                            freeWifiFrontPageUI = f.this.mwF;
                            dVar = d.FAIL;
                            aVar = new FreeWifiFrontPageUI.a();
                            aVar.myH = R.string.bzq;
                            aVar.myI = m.a(f.this.mwG, b.AddNetwork, i);
                            freeWifiFrontPageUI.a(dVar, aVar);
                            AppMethodBeat.o(20808);
                        }
                    }
                });
                if (((ConnectivityManager) ah.getContext().getSystemService("connectivity")).getNetworkInfo(1).isConnected() && cVar.ssid.equals(com.tencent.mm.plugin.freewifi.model.d.byO())) {
                    anonymousClass1.onSuccess();
                    AppMethodBeat.o(20809);
                } else if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    RuntimeException runtimeException = new RuntimeException("ConnectNetworkHelper组件不能在主线程中运行。");
                    AppMethodBeat.o(20809);
                    throw runtimeException;
                } else {
                    cVar.broadcastReceiver = new ConnectSsidPasswordHelper$2(cVar);
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.net.wifi.STATE_CHANGE");
                    intentFilter.addAction("android.net.wifi.supplicant.STATE_CHANGE");
                    try {
                        int bye;
                        cVar.aCZ.lock();
                        cVar.activity.registerReceiver(cVar.broadcastReceiver, intentFilter);
                        if (!cVar.bJj.isWifiEnabled()) {
                            bye = new e(cVar.activity).bye();
                            ab.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "enable ret = ".concat(String.valueOf(bye)));
                            if (bye != 0) {
                                anonymousClass1.onFail(bye);
                                cVar.byc();
                                cVar.aCZ.unlock();
                                AppMethodBeat.o(20809);
                                return;
                            }
                        }
                        bye = com.tencent.mm.plugin.freewifi.model.d.c(cVar.ssid, cVar.gDC, 3, false);
                        if (bye != 0) {
                            cVar.byc();
                            anonymousClass1.onFail(bye);
                            cVar.byc();
                            cVar.aCZ.unlock();
                            AppMethodBeat.o(20809);
                            return;
                        }
                        boolean z;
                        if (cVar.connected || cVar.mtH) {
                            z = false;
                        } else {
                            z = cVar.cbS.await(cVar.ftP, TimeUnit.MILLISECONDS);
                        }
                        if (!z) {
                            anonymousClass1.onFail(-16);
                        } else if (cVar.connected) {
                            anonymousClass1.onSuccess();
                        } else if (cVar.mtH) {
                            anonymousClass1.onFail(-18);
                        }
                        cVar.byc();
                        cVar.aCZ.unlock();
                        AppMethodBeat.o(20809);
                    } catch (InterruptedException e) {
                        ab.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "sessionKey=%s, step=%d, desc=ConnectNetworkHelper encounter interrupted exception. msg=%s", m.V(cVar.activity.getIntent()), Integer.valueOf(m.W(cVar.activity.getIntent())), e.getMessage());
                        anonymousClass1.onFail(-17);
                        cVar.byc();
                        cVar.aCZ.unlock();
                        AppMethodBeat.o(20809);
                    } catch (Throwable th) {
                        cVar.byc();
                        cVar.aCZ.unlock();
                        AppMethodBeat.o(20809);
                        throw th;
                    }
                }
            }
        });
        AppMethodBeat.o(20811);
    }
}
