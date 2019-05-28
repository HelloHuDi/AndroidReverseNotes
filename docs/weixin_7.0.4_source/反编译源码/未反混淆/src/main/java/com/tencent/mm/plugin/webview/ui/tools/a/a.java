package com.tencent.mm.plugin.webview.ui.tools.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.du;
import com.tencent.mm.g.a.dv;
import com.tencent.mm.g.a.dw;
import com.tencent.mm.g.a.dx;
import com.tencent.mm.g.a.ea;
import com.tencent.mm.g.a.ee;
import com.tencent.mm.g.a.ev;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class a implements com.tencent.mm.pluginsdk.ui.tools.t.a {
    private static String eSg = "lan";
    private static a uzZ;
    public String cwz;
    public boolean hasInit = false;
    public byte[] uAa = null;
    private int uAb = -1;
    public boolean uAc = false;
    public a uzY;

    public static class a {
        private String cwz = "";
        public c uAd = new c<ea>() {
            {
                AppMethodBeat.i(8303);
                this.xxI = ea.class.getName().hashCode();
                AppMethodBeat.o(8303);
            }

            public final /* synthetic */ boolean a(b bVar) {
                AppMethodBeat.i(8304);
                boolean h = a.this.h((ea) bVar);
                AppMethodBeat.o(8304);
                return h;
            }
        };
        public c uAe = new c<du>() {
            {
                AppMethodBeat.i(8305);
                this.xxI = du.class.getName().hashCode();
                AppMethodBeat.o(8305);
            }

            public final /* synthetic */ boolean a(b bVar) {
                AppMethodBeat.i(8306);
                boolean h = a.this.h((du) bVar);
                AppMethodBeat.o(8306);
                return h;
            }
        };
        public c uAf = new c<dv>() {
            {
                AppMethodBeat.i(8307);
                this.xxI = dv.class.getName().hashCode();
                AppMethodBeat.o(8307);
            }

            public final /* synthetic */ boolean a(b bVar) {
                AppMethodBeat.i(8308);
                boolean h = a.this.h((dv) bVar);
                AppMethodBeat.o(8308);
                return h;
            }
        };
        public c uAg = new c<dw>() {
            {
                AppMethodBeat.i(8309);
                this.xxI = dw.class.getName().hashCode();
                AppMethodBeat.o(8309);
            }

            public final /* synthetic */ boolean a(b bVar) {
                AppMethodBeat.i(8310);
                boolean h = a.this.h((dw) bVar);
                AppMethodBeat.o(8310);
                return h;
            }
        };
        public c uAh = new c<dx>() {
            {
                AppMethodBeat.i(8311);
                this.xxI = dx.class.getName().hashCode();
                AppMethodBeat.o(8311);
            }

            public final /* synthetic */ boolean a(b bVar) {
                AppMethodBeat.i(8312);
                boolean h = a.this.h((dx) bVar);
                AppMethodBeat.o(8312);
                return h;
            }
        };
        private e umI = null;

        public a(e eVar, String str) {
            AppMethodBeat.i(8313);
            this.umI = eVar;
            this.cwz = str;
            AppMethodBeat.o(8313);
        }

        /* Access modifiers changed, original: final */
        public final boolean h(b bVar) {
            AppMethodBeat.i(8314);
            if (bVar == null) {
                AppMethodBeat.o(8314);
                return false;
            } else if (this.umI == null) {
                ab.e("MicroMsg.webview.WebViewExDeviceLanMgr", "callbacker is null");
                AppMethodBeat.o(8314);
                return false;
            } else {
                try {
                    Bundle bundle;
                    if (bVar instanceof ea) {
                        ab.d("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceOnDeviceBindStateChangeEvent");
                        ea eaVar = (ea) bVar;
                        if (bo.isNullOrNil(eaVar.cxB.ceI)) {
                            AppMethodBeat.o(8314);
                            return true;
                        }
                        bundle = new Bundle();
                        bundle.putString("exdevice_device_id", eaVar.cxB.ceI);
                        bundle.putBoolean("exdevice_is_bound", eaVar.cxB.cww);
                        this.umI.c(17, bundle);
                        AppMethodBeat.o(8314);
                        return true;
                    } else if (bVar instanceof du) {
                        ab.d("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceConnectStateEvent");
                        du duVar = (du) bVar;
                        if (bo.isNullOrNil(duVar.cxr.ceI) || !this.cwz.equals(duVar.cxr.cwz)) {
                            AppMethodBeat.o(8314);
                            return true;
                        }
                        bundle = new Bundle();
                        bundle.putString("exdevice_device_id", duVar.cxr.ceI);
                        bundle.putInt("exdevice_on_state_change_state", duVar.cxr.cxs);
                        bundle.putString("exdevice_device_type", a.eSg);
                        this.umI.c(1004, bundle);
                        AppMethodBeat.o(8314);
                        return true;
                    } else {
                        if (bVar instanceof dv) {
                            ab.d("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceRecvDataEvent");
                            dv dvVar = (dv) bVar;
                            if (bo.isNullOrNil(dvVar.cxt.ceI) || bo.isNullOrNil(dvVar.cxt.cwz) || dvVar.cxt.data == null) {
                                AppMethodBeat.o(8314);
                                return true;
                            }
                            bundle = new Bundle();
                            bundle.putString("exdevice_device_id", dvVar.cxt.ceI);
                            bundle.putByteArray("exdevice_data", dvVar.cxt.data);
                            bundle.putString("exdevice_brand_name", dvVar.cxt.cwz);
                            bundle.putString("exdevice_device_type", a.eSg);
                            this.umI.c(16, bundle);
                        } else if (bVar instanceof dw) {
                            ab.i("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceScanResultEvent");
                            dw dwVar = (dw) bVar;
                            bundle = new Bundle();
                            bundle.putString("exdevice_device_id", dwVar.cxu.ceI);
                            bundle.putByteArray("exdevice_broadcast_data", dwVar.cxu.cxv);
                            bundle.putBoolean("exdevice_is_complete", dwVar.cxu.bcU);
                            bundle.putBoolean("exdevice_is_lan_device", true);
                            bundle.putString("exdevice_device_type", a.eSg);
                            this.umI.c(15, bundle);
                        } else if (bVar instanceof dx) {
                            ab.i("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceStateChangeEvent");
                            dx dxVar = (dx) bVar;
                            bundle = new Bundle();
                            if (dxVar.cxw.cxx) {
                                bundle.putBoolean("exdevice_lan_state", true);
                            } else {
                                bundle.putBoolean("exdevice_lan_state", false);
                            }
                            this.umI.c(47, bundle);
                        }
                        AppMethodBeat.o(8314);
                        return true;
                    }
                } catch (Exception e) {
                    ab.w("MicroMsg.webview.WebViewExDeviceLanMgr", "exception in WVExDeviceEventListener callback, %s", e.getMessage());
                }
            }
        }
    }

    private a() {
    }

    public static a dbo() {
        AppMethodBeat.i(8315);
        if (uzZ == null) {
            uzZ = new a();
        }
        a aVar = uzZ;
        AppMethodBeat.o(8315);
        return aVar;
    }

    public final String getName() {
        return "WebViewExDeviceLanMgr";
    }

    public final void dbp() {
        AppMethodBeat.i(8316);
        ab.i("MicroMsg.webview.WebViewExDeviceLanMgr", "stopPlugin, isScaning = %s", Boolean.valueOf(this.uAc));
        if (this.uAc) {
            ev evVar = new ev();
            evVar.cyp.cwA = false;
            com.tencent.mm.sdk.b.a.xxA.m(evVar);
            this.uAc = false;
        }
        this.hasInit = false;
        if (this.uzY != null) {
            com.tencent.mm.sdk.b.a.xxA.d(this.uzY.uAd);
            com.tencent.mm.sdk.b.a.xxA.d(this.uzY.uAe);
            com.tencent.mm.sdk.b.a.xxA.d(this.uzY.uAg);
            com.tencent.mm.sdk.b.a.xxA.d(this.uzY.uAf);
            com.tencent.mm.sdk.b.a.xxA.d(this.uzY.uAh);
            this.uzY = null;
        }
        this.uAa = null;
        ee eeVar = new ee();
        eeVar.cxF.cwA = false;
        com.tencent.mm.sdk.b.a.xxA.m(eeVar);
        AppMethodBeat.o(8316);
    }

    public final void ft(Context context) {
    }

    public final void dbq() {
    }
}
