package com.tencent.mm.plugin.webview.ui.tools.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.dz;
import com.tencent.mm.g.a.ea;
import com.tencent.mm.g.a.eb;
import com.tencent.mm.g.a.ec;
import com.tencent.mm.g.a.ef;
import com.tencent.mm.g.a.el;
import com.tencent.mm.g.a.lq;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class b implements com.tencent.mm.pluginsdk.ui.tools.t.a {
    private static final byte[] ltL = new byte[]{(byte) -2, (byte) 1, (byte) 1};
    private static b uAk;
    public String cwz;
    public boolean hasInit = false;
    public byte[] uAa = null;
    public boolean uAc = false;
    public a uAj;
    public int uAl = -1;
    public boolean uAm = false;

    public static class a {
        private String cwz = "";
        public c qwh = new c<dz>() {
            {
                AppMethodBeat.i(8325);
                this.xxI = dz.class.getName().hashCode();
                AppMethodBeat.o(8325);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(8326);
                boolean h = a.this.h((dz) bVar);
                AppMethodBeat.o(8326);
                return h;
            }
        };
        public c uAd = new c<ea>() {
            {
                AppMethodBeat.i(8321);
                this.xxI = ea.class.getName().hashCode();
                AppMethodBeat.o(8321);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(8322);
                boolean h = a.this.h((ea) bVar);
                AppMethodBeat.o(8322);
                return h;
            }
        };
        public c uAn = new c<ec>() {
            {
                AppMethodBeat.i(8317);
                this.xxI = ec.class.getName().hashCode();
                AppMethodBeat.o(8317);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(8318);
                boolean h = a.this.h((ec) bVar);
                AppMethodBeat.o(8318);
                return h;
            }
        };
        public c uAo = new c<eb>() {
            {
                AppMethodBeat.i(8319);
                this.xxI = eb.class.getName().hashCode();
                AppMethodBeat.o(8319);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(8320);
                boolean h = a.this.h((eb) bVar);
                AppMethodBeat.o(8320);
                return h;
            }
        };
        public c uAp = new c<lq>() {
            {
                AppMethodBeat.i(8323);
                this.xxI = lq.class.getName().hashCode();
                AppMethodBeat.o(8323);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(8324);
                boolean h = a.this.h((lq) bVar);
                AppMethodBeat.o(8324);
                return h;
            }
        };
        private e umI = null;

        public a(e eVar, String str) {
            AppMethodBeat.i(8327);
            this.umI = eVar;
            this.cwz = str;
            AppMethodBeat.o(8327);
        }

        /* Access modifiers changed, original: final */
        public final boolean h(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(8328);
            if (bVar == null) {
                AppMethodBeat.o(8328);
                return false;
            } else if (this.umI == null) {
                ab.e("MicroMsg.webview.WebViewExDeviceMgr", "callbacker is null");
                AppMethodBeat.o(8328);
                return false;
            } else {
                try {
                    Bundle bundle;
                    if (bVar instanceof ec) {
                        ab.i("MicroMsg.webview.WebViewExDeviceMgr", "ExDeviceOnScanDeviceResultEvent");
                        ec ecVar = (ec) bVar;
                        bundle = new Bundle();
                        bundle.putString("exdevice_device_id", ecVar.cxD.ceI);
                        bundle.putByteArray("exdevice_broadcast_data", ecVar.cxD.cxv);
                        bundle.putBoolean("exdevice_is_complete", ecVar.cxD.bcU);
                        this.umI.c(15, bundle);
                    } else if (bVar instanceof eb) {
                        ab.i("MicroMsg.webview.WebViewExDeviceMgr", "ExDeviceOnRecvDataFromDeviceEvent");
                        eb ebVar = (eb) bVar;
                        if (bo.isNullOrNil(ebVar.cxC.ceI) || bo.isNullOrNil(ebVar.cxC.cwz) || ebVar.cxC.data == null) {
                            AppMethodBeat.o(8328);
                            return true;
                        }
                        bundle = new Bundle();
                        bundle.putString("exdevice_device_id", ebVar.cxC.ceI);
                        bundle.putByteArray("exdevice_data", ebVar.cxC.data);
                        bundle.putString("exdevice_brand_name", ebVar.cxC.cwz);
                        this.umI.c(16, bundle);
                    } else if (bVar instanceof ea) {
                        ab.d("MicroMsg.webview.WebViewExDeviceMgr", "ExDeviceOnDeviceBindStateChangeEvent");
                        ea eaVar = (ea) bVar;
                        if (bo.isNullOrNil(eaVar.cxB.ceI)) {
                            AppMethodBeat.o(8328);
                            return true;
                        }
                        bundle = new Bundle();
                        bundle.putString("exdevice_device_id", eaVar.cxB.ceI);
                        bundle.putBoolean("exdevice_is_bound", eaVar.cxB.cww);
                        this.umI.c(17, bundle);
                    } else if (bVar instanceof lq) {
                        lq lqVar = (lq) bVar;
                        if (lqVar.cHu.op != 2) {
                            AppMethodBeat.o(8328);
                            return true;
                        } else if (bo.isNullOrNil(lqVar.cHu.cEN) || !this.cwz.equals(lqVar.cHu.cEN)) {
                            AppMethodBeat.o(8328);
                            return true;
                        } else {
                            bundle = new Bundle();
                            bundle.putString("exdevice_device_id", lqVar.cHu.ceI);
                            bundle.putInt("exdevice_on_state_change_state", lqVar.cHu.cxs);
                            this.umI.c(1004, bundle);
                        }
                    } else if (bVar instanceof dz) {
                        dz dzVar = (dz) bVar;
                        bundle = new Bundle();
                        if (dzVar.cxz.cxA == 12) {
                            bundle.putBoolean("exdevice_bt_state", true);
                        } else {
                            bundle.putBoolean("exdevice_bt_state", false);
                        }
                        this.umI.c(18, bundle);
                    }
                } catch (Exception e) {
                    ab.w("MicroMsg.webview.WebViewExDeviceMgr", "exception in WVExDeviceEventListener callback, %s", e.getMessage());
                }
                AppMethodBeat.o(8328);
                return true;
            }
        }
    }

    private b() {
    }

    public static b dbr() {
        AppMethodBeat.i(8329);
        if (uAk == null) {
            uAk = new b();
        }
        b bVar = uAk;
        AppMethodBeat.o(8329);
        return bVar;
    }

    public final String getName() {
        return "WebViewExDeviceMgr";
    }

    public final void dbp() {
        AppMethodBeat.i(8330);
        ab.i("MicroMsg.webview.WebViewExDeviceMgr", "stopPlugin, isScaning = %s", Boolean.valueOf(this.uAc));
        if (this.uAc) {
            ef efVar = new ef();
            efVar.cxG.cwA = false;
            efVar.cxG.cwz = this.cwz;
            com.tencent.mm.sdk.b.a.xxA.m(efVar);
            if (!efVar.cxH.cwB) {
                ab.e("MicroMsg.webview.WebViewExDeviceMgr", "stopScanWXDevice fail");
            }
            this.uAc = false;
        }
        this.hasInit = false;
        if (this.uAj != null) {
            com.tencent.mm.sdk.b.a.xxA.d(this.uAj.uAn);
            com.tencent.mm.sdk.b.a.xxA.d(this.uAj.uAo);
            com.tencent.mm.sdk.b.a.xxA.d(this.uAj.uAp);
            com.tencent.mm.sdk.b.a.xxA.d(this.uAj.uAd);
            com.tencent.mm.sdk.b.a.xxA.d(this.uAj.qwh);
            this.uAj = null;
        }
        this.uAa = null;
        el elVar = new el();
        elVar.cxX.ceI = "";
        elVar.cxX.direction = 0;
        elVar.cxX.clear = true;
        com.tencent.mm.sdk.b.a.xxA.m(elVar);
        ab.i("MicroMsg.webview.WebViewExDeviceMgr", "stop EcDeviceMgr for webview %s", Boolean.valueOf(elVar.cxY.cwB));
        AppMethodBeat.o(8330);
    }

    public static boolean bE(byte[] bArr) {
        if (bArr != null && bArr.length >= 9 && bArr[bArr.length - 7] == (byte) 1 && bArr[bArr.length - 8] == (byte) 1 && bArr[bArr.length - 9] == (byte) -2) {
            return true;
        }
        return false;
    }

    public final void ft(Context context) {
    }

    public final void dbq() {
    }
}
