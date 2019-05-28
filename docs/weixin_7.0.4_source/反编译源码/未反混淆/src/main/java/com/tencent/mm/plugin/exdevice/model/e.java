package com.tencent.mm.plugin.exdevice.model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Base64;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.aj.f;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.dc;
import com.tencent.mm.g.a.dd;
import com.tencent.mm.g.a.df;
import com.tencent.mm.g.a.dg;
import com.tencent.mm.g.a.dh;
import com.tencent.mm.g.a.di;
import com.tencent.mm.g.a.dj;
import com.tencent.mm.g.a.dk;
import com.tencent.mm.g.a.dl;
import com.tencent.mm.g.a.dm;
import com.tencent.mm.g.a.dn;
import com.tencent.mm.g.a.do;
import com.tencent.mm.g.a.dp;
import com.tencent.mm.g.a.dq;
import com.tencent.mm.g.a.ds;
import com.tencent.mm.g.a.dy;
import com.tencent.mm.g.a.ea;
import com.tencent.mm.g.a.eb;
import com.tencent.mm.g.a.ec;
import com.tencent.mm.g.a.ed;
import com.tencent.mm.g.a.ee;
import com.tencent.mm.g.a.ef;
import com.tencent.mm.g.a.eh;
import com.tencent.mm.g.a.ei;
import com.tencent.mm.g.a.ej;
import com.tencent.mm.g.a.el;
import com.tencent.mm.g.a.em;
import com.tencent.mm.g.a.en;
import com.tencent.mm.g.a.eo;
import com.tencent.mm.g.a.ep;
import com.tencent.mm.g.a.er;
import com.tencent.mm.g.a.es;
import com.tencent.mm.g.a.et;
import com.tencent.mm.g.a.eu;
import com.tencent.mm.g.a.ev;
import com.tencent.mm.g.a.ew;
import com.tencent.mm.g.a.ex;
import com.tencent.mm.g.a.id;
import com.tencent.mm.g.a.jn;
import com.tencent.mm.g.a.jo;
import com.tencent.mm.g.a.lk;
import com.tencent.mm.g.a.ln;
import com.tencent.mm.g.a.lq;
import com.tencent.mm.g.a.sl;
import com.tencent.mm.g.a.sm;
import com.tencent.mm.g.a.st;
import com.tencent.mm.g.a.z;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.m.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.exdevice.b.k;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.i.i;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.service.ExDeviceService;
import com.tencent.mm.plugin.exdevice.service.j;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.ajp;
import com.tencent.mm.protocal.protobuf.ajq;
import com.tencent.mm.protocal.protobuf.asq;
import com.tencent.mm.protocal.protobuf.atr;
import com.tencent.mm.protocal.protobuf.ats;
import com.tencent.mm.protocal.protobuf.atu;
import com.tencent.mm.protocal.protobuf.atv;
import com.tencent.mm.protocal.protobuf.atw;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e {
    private final long bYn = 300000;
    public com.tencent.mm.sdk.b.c jDf = new com.tencent.mm.sdk.b.c<z>() {
        {
            AppMethodBeat.i(19165);
            this.xxI = z.class.getName().hashCode();
            AppMethodBeat.o(19165);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(19166);
            boolean boK = e.boK();
            AppMethodBeat.o(19166);
            return boK;
        }
    };
    public com.tencent.mm.sdk.b.c lrA = new com.tencent.mm.sdk.b.c<ed>() {
        {
            AppMethodBeat.i(19169);
            this.xxI = ed.class.getName().hashCode();
            AppMethodBeat.o(19169);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(19170);
            ed edVar = (ed) bVar;
            e eVar = e.this;
            ab.i("MicroMsg.exdevice.ExdeviceEventManager", "handleOpInChattingUIEvent");
            edVar = edVar;
            if (bo.isNullOrNil(edVar.cxE.userName)) {
                ab.e("MicroMsg.exdevice.ExdeviceEventManager", "ExDeviceOpInChattingUIEventListener, userName is null");
                AppMethodBeat.o(19170);
                return false;
            }
            ab.i("MicroMsg.exdevice.ExdeviceEventManager", "This biz is binded a device, notify chatting view to dimiss connect fail tips");
            e.cc(edVar.cxE.userName, -1);
            if ((edVar.cxE.op == 0 || edVar.cxE.op == 3) && i.lto.gN(false)) {
                i.lto.a(edVar.cxE.context, new AnonymousClass39(edVar));
                AppMethodBeat.o(19170);
                return true;
            }
            boolean at = eVar.at(edVar.cxE.op, edVar.cxE.userName);
            AppMethodBeat.o(19170);
            return at;
        }
    };
    public com.tencent.mm.sdk.b.c lrB = new com.tencent.mm.sdk.b.c<dc>() {
        {
            AppMethodBeat.i(19191);
            this.xxI = dc.class.getName().hashCode();
            AppMethodBeat.o(19191);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(19192);
            dc dcVar = (dc) bVar;
            ab.i("MicroMsg.exdevice.ExdeviceEventManager", "receive ExDeviceBindHardDeviceEvent");
            dcVar = dcVar;
            int i = dcVar.cwj.opType;
            ab.i("MicroMsg.exdevice.ExdeviceEventManager", "now optype is %d, subscribeFlag is %d", Integer.valueOf(i), Integer.valueOf(dcVar.cwj.cwm));
            if (i == 1) {
                m lVar = new l(dcVar.cwj.cwl, r1);
                aw.Rg().a(lVar, 0);
                dcVar.cwk.cwn = lVar;
            } else if (i == 2 && dcVar.cwj.cwn != null) {
                aw.Rg().c((l) dcVar.cwj.cwn);
            }
            AppMethodBeat.o(19192);
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lrC = new com.tencent.mm.sdk.b.c<ex>() {
        {
            AppMethodBeat.i(19201);
            this.xxI = ex.class.getName().hashCode();
            AppMethodBeat.o(19201);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(19202);
            ex exVar = (ex) bVar;
            ab.i("MicroMsg.exdevice.ExdeviceEventManager", "receive ExDeviceUnBindHardDeviceEvent");
            ad.bpd().uI(0);
            exVar = exVar;
            if (bo.isNullOrNil(exVar.cyr.cwz)) {
                ab.e("MicroMsg.exdevice.ExdeviceEventManager", "brandName is null, can not unbind device");
                AppMethodBeat.o(19202);
                return false;
            }
            asq asq = new asq();
            asq.jBE = "";
            asq.vIk = exVar.cyr.cwz;
            aw.Rg().a(new x(asq, 1), 0);
            AppMethodBeat.o(19202);
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lrD = new com.tencent.mm.sdk.b.c<sl>() {
        {
            AppMethodBeat.i(19203);
            this.xxI = sl.class.getName().hashCode();
            AppMethodBeat.o(19203);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(19204);
            boolean boH = e.boH();
            AppMethodBeat.o(19204);
            return boH;
        }
    };
    public com.tencent.mm.sdk.b.c lrE = new com.tencent.mm.sdk.b.c<sm>() {
        {
            AppMethodBeat.i(19205);
            this.xxI = sm.class.getName().hashCode();
            AppMethodBeat.o(19205);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(19206);
            sm smVar = (sm) bVar;
            ab.i("MicroMsg.exdevice.ExdeviceEventManager", "receive StopAllChannelWithParamsEvent");
            smVar = smVar;
            ad.bpd();
            d.gL(smVar.cOL.cOM);
            AppMethodBeat.o(19206);
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lrF = new com.tencent.mm.sdk.b.c<st>() {
        {
            AppMethodBeat.i(19207);
            this.xxI = st.class.getName().hashCode();
            AppMethodBeat.o(19207);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(19208);
            e eVar = e.this;
            ab.i("MicroMsg.exdevice.ExdeviceEventManager", "receive SyncExdeviceDataEvent");
            int acS = aw.Rg().acS();
            if (acS == 4 || acS == 6) {
                boolean z;
                String value = g.Nu().getValue("DeviceAutoSyncClose");
                ab.i("MicroMsg.exdevice.Util", "handleSyncExdeviceDataEvent, auto sync has close : %s", value);
                if (bo.isNullOrNil(value) || !value.equalsIgnoreCase("1")) {
                    z = true;
                } else {
                    ab.i("MicroMsg.exdevice.Util", "auto sync has closed, ignore this sync request");
                    z = false;
                }
                if (!z) {
                    ab.i("MicroMsg.exdevice.ExdeviceEventManager", "not allowed to sync exdevice data");
                    AppMethodBeat.o(19208);
                    return false;
                } else if (!com.tencent.mm.plugin.d.a.e.a.dv(ah.getContext())) {
                    ab.i("MicroMsg.exdevice.ExdeviceEventManager", "now sdk version not support ble device : %d", Integer.valueOf(VERSION.SDK_INT));
                    AppMethodBeat.o(19208);
                    return false;
                } else if (com.tencent.mm.plugin.d.a.e.a.aVH()) {
                    ad.bpd();
                    if (d.boE() == 1) {
                        ab.i("MicroMsg.exdevice.ExdeviceEventManager", "it is in brand");
                        AppMethodBeat.o(19208);
                        return false;
                    } else if (i.lto.gN(false)) {
                        ab.i("MicroMsg.exdevice.ExdeviceEventManager", "now need to get bound harddevices");
                        i.lto.a(null, new com.tencent.mm.plugin.exdevice.model.i.a() {
                            public final void gM(boolean z) {
                                AppMethodBeat.i(19197);
                                e.boG();
                                AppMethodBeat.o(19197);
                            }
                        });
                        AppMethodBeat.o(19208);
                        return true;
                    } else {
                        ab.i("MicroMsg.exdevice.ExdeviceEventManager", "now do not need to get bound device, do sync directly");
                        boolean boG = e.boG();
                        AppMethodBeat.o(19208);
                        return boG;
                    }
                } else {
                    ab.i("MicroMsg.exdevice.ExdeviceEventManager", "Bluetooth is not open, Just leave");
                    AppMethodBeat.o(19208);
                    return false;
                }
            }
            ab.i("MicroMsg.exdevice.ExdeviceEventManager", "net work state is not connected, now state is %d", Integer.valueOf(acS));
            AppMethodBeat.o(19208);
            return false;
        }
    };
    public com.tencent.mm.sdk.b.c lrG = new com.tencent.mm.sdk.b.c<dk>() {
        {
            AppMethodBeat.i(19209);
            this.xxI = dk.class.getName().hashCode();
            AppMethodBeat.o(19209);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(19210);
            boolean z = ((dk) bVar).cwH.cwI;
            ab.i("MicroMsg.exdevice.ExdeviceEventManager", "------handleGetBoundDeviceEvent------ check if need to get bound device after auth");
            if (i.lto.gN(z)) {
                ab.i("MicroMsg.exdevice.ExdeviceEventManager", "do get bound device after auth");
                i.lto.a(null, null);
            }
            AppMethodBeat.o(19210);
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lrH = new com.tencent.mm.sdk.b.c<ds>() {
        {
            AppMethodBeat.i(19127);
            this.xxI = ds.class.getName().hashCode();
            AppMethodBeat.o(19127);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(19128);
            ds dsVar = (ds) bVar;
            if (dsVar != null && (dsVar instanceof ds)) {
                dsVar = dsVar;
                String str = dsVar.cxg.cxi;
                boolean z = dsVar.cxg.cxf;
                d bpd = ad.bpd();
                ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "ranging, uuid = %s, op = %s", str, String.valueOf(z));
                d.xDH.a(new com.tencent.mm.plugin.exdevice.model.d.AnonymousClass5(str, z), "MicroMsg.exdevice.ExdeviceConnectManager|ranging");
            }
            AppMethodBeat.o(19128);
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lrI = new com.tencent.mm.sdk.b.c<ef>() {
        {
            AppMethodBeat.i(19129);
            this.xxI = ef.class.getName().hashCode();
            AppMethodBeat.o(19129);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(19130);
            boolean g = e.this.g((ef) bVar);
            AppMethodBeat.o(19130);
            return g;
        }
    };
    public com.tencent.mm.sdk.b.c lrJ = new com.tencent.mm.sdk.b.c<dp>() {
        {
            AppMethodBeat.i(19131);
            this.xxI = dp.class.getName().hashCode();
            AppMethodBeat.o(19131);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(19132);
            boolean f = e.this.f((dp) bVar);
            AppMethodBeat.o(19132);
            return f;
        }
    };
    public com.tencent.mm.sdk.b.c lrK = new com.tencent.mm.sdk.b.c<dh>() {
        {
            AppMethodBeat.i(19133);
            this.xxI = dh.class.getName().hashCode();
            AppMethodBeat.o(19133);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            boolean z = false;
            AppMethodBeat.i(19134);
            dh dhVar = (dh) bVar;
            ab.i("MicroMsg.exdevice.ExdeviceEventManager", "handleConnectDeviceEvent: brandName=%s, deviceId=%s, type=%b", dhVar.cwx.cwz, dhVar.cwx.ceI, Boolean.valueOf(dhVar.cwx.cwA));
            String str = dhVar.cwx.cwz;
            String str2 = dhVar.cwx.ceI;
            boolean z2 = dhVar.cwx.cwA;
            if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
                ab.e("MicroMsg.exdevice.ExdeviceEventManager", "connectBluetoothDevice %s, %s, %s", str, str2, Boolean.valueOf(z2));
            } else {
                com.tencent.mm.plugin.exdevice.h.b Kv = ad.boW().Kv(str2);
                if (Kv == null) {
                    ab.e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo null, %s", str2);
                } else if (!Kv.field_brandName.equals(str)) {
                    ab.e("MicroMsg.exdevice.ExdeviceEventManager", "brand name not match. %s != %s", Kv.field_brandName, str);
                } else if (bo.nullAsNil(Kv.field_connProto).contains("4")) {
                    e.b(str, Kv.field_url, -1, Kv.field_deviceType);
                    e.cc(str, -1);
                    ab.i("MicroMsg.exdevice.ExdeviceEventManager", "Wifi biz, Just leave");
                } else if (com.tencent.mm.plugin.d.a.e.a.aVH()) {
                    e.cc(str, -1);
                    int a = e.a(Kv);
                    if (a == 1) {
                        if (!com.tencent.mm.plugin.d.a.e.a.aVF()) {
                            ab.e("MicroMsg.exdevice.ExdeviceEventManager", "device is BC, but you phone not support BC.");
                        }
                    } else if (a == 0 && !com.tencent.mm.plugin.d.a.e.a.dv(ah.getContext())) {
                        e.cc(str, 1);
                        ab.e("MicroMsg.exdevice.ExdeviceEventManager", "device is BLE, but you phone not support BLE.");
                    }
                    if (z2) {
                        if (aa.boT().lsZ) {
                            aa.boT().uK(a);
                        }
                        d bpd = ad.bpd();
                        if (!(bpd.lrg == null || bpd.lrg.size() == 0)) {
                            bpd.lrg.clear();
                        }
                        ad.bpd().b(Kv.field_brandName, Kv.field_mac, a);
                    } else {
                        ad.bpd();
                        d.hH(Kv.field_mac);
                    }
                    z = true;
                } else {
                    ab.w("MicroMsg.exdevice.ExdeviceEventManager", "System bluetooth is close");
                    e.cc(str, 0);
                }
            }
            dhVar.cwy.cwB = z;
            AppMethodBeat.o(19134);
            return z;
        }
    };
    public com.tencent.mm.sdk.b.c lrL = new com.tencent.mm.sdk.b.c<dj>() {
        {
            AppMethodBeat.i(19135);
            this.xxI = dj.class.getName().hashCode();
            AppMethodBeat.o(19135);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(19136);
            dj djVar = (dj) bVar;
            com.tencent.mm.plugin.exdevice.h.b dT = ad.boW().dT(djVar.cwE.cwG, djVar.cwE.ceI);
            if (dT == null || (dT.field_connStrategy & 16) != 0) {
                djVar.cwF.cwB = false;
            } else {
                ab.i("MicroMsg.exdevice.ExdeviceEventManager", "CONNECT_STRATEGY_IGNORE_ON_CHAT disable, (%s) do not disconnect ble device(%s)", djVar.cwE.cwG, djVar.cwE.ceI);
                djVar.cwF.cwB = true;
            }
            AppMethodBeat.o(19136);
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lrM = new com.tencent.mm.sdk.b.c<eh>() {
        {
            AppMethodBeat.i(19137);
            this.xxI = eh.class.getName().hashCode();
            AppMethodBeat.o(19137);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(19138);
            boolean e = e.e((eh) bVar);
            AppMethodBeat.o(19138);
            return e;
        }
    };
    public com.tencent.mm.sdk.b.c lrN = new com.tencent.mm.sdk.b.c<dy>() {
        {
            AppMethodBeat.i(19139);
            this.xxI = dy.class.getName().hashCode();
            AppMethodBeat.o(19139);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(19140);
            ab.i("MicroMsg.exdevice.ExdeviceEventManager", "handleDeviceOPFromJSAPIEvent: %d", Integer.valueOf(((dy) bVar).cxy.op));
            if (((dy) bVar).cxy.op == 1) {
                d bpd = ad.bpd();
                if (bpd.lrc == null) {
                    bpd.lrc = new com.tencent.mm.plugin.exdevice.service.c();
                    bpd.lrc.lwE = new com.tencent.mm.plugin.exdevice.service.c.a() {
                        public final void onServiceConnected() {
                            AppMethodBeat.i(19109);
                            ab.d("MicroMsg.exdevice.ExdeviceConnectManager", "onServiceConnected");
                            AppMethodBeat.o(19109);
                        }
                    };
                    bpd.lrc.dH(ah.getContext());
                }
            }
            AppMethodBeat.o(19140);
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lrO = new com.tencent.mm.sdk.b.c<dm>() {
        {
            AppMethodBeat.i(19141);
            this.xxI = dm.class.getName().hashCode();
            AppMethodBeat.o(19141);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(19142);
            boolean d = e.d((dm) bVar);
            AppMethodBeat.o(19142);
            return d;
        }
    };
    public com.tencent.mm.sdk.b.c lrP = new com.tencent.mm.sdk.b.c<el>() {
        {
            AppMethodBeat.i(19143);
            this.xxI = el.class.getName().hashCode();
            AppMethodBeat.o(19143);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(19144);
            el elVar = (el) bVar;
            ab.i("MicroMsg.exdevice.ExdeviceEventManager", "handleSetSendDataDirectionEvent: %s, %s, %s", elVar.cxX.ceI, Integer.valueOf(elVar.cxX.direction), Boolean.valueOf(elVar.cxX.clear));
            if (elVar.cxX.clear) {
                k.bow().lqJ.clear();
                elVar.cxY.cwB = true;
            } else if (bo.isNullOrNil(elVar.cxX.ceI)) {
                elVar.cxY.cwB = false;
            } else {
                k bow = k.bow();
                String str = elVar.cxX.ceI;
                int i = elVar.cxX.direction;
                if (!bo.isNullOrNil(str)) {
                    bow.lqJ.put(str, Integer.valueOf(i));
                }
                elVar.cxY.cwB = true;
            }
            AppMethodBeat.o(19144);
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lrQ = new com.tencent.mm.sdk.b.c<es>() {
        {
            AppMethodBeat.i(19145);
            this.xxI = es.class.getName().hashCode();
            AppMethodBeat.o(19145);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(19146);
            es esVar = (es) bVar;
            if (esVar == null || !(esVar instanceof es)) {
                ab.e("MicroMsg.exdevice.ExdeviceEventManager", "event is not instanceof ExDeviceSimpleBTScanDeviceEvent");
                AppMethodBeat.o(19146);
                return false;
            }
            esVar = esVar;
            if (e.boJ()) {
                esVar.cyk.cwB = true;
            } else {
                esVar.cyk.cwB = false;
            }
            AppMethodBeat.o(19146);
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lrR = new com.tencent.mm.sdk.b.c<eo>() {
        {
            AppMethodBeat.i(19149);
            this.xxI = eo.class.getName().hashCode();
            AppMethodBeat.o(19149);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(19150);
            eo eoVar = (eo) bVar;
            e eVar = e.this;
            if (eoVar == null || !(eoVar instanceof eo)) {
                ab.e("MicroMsg.exdevice.ExdeviceEventManager", "event is not instanceof ExDeviceSimpleBTConnectDeviceEvent");
                AppMethodBeat.o(19150);
                return false;
            }
            boolean Kg;
            eoVar = eoVar;
            if (eoVar.cye.cwA) {
                Kg = eVar.Kg(eoVar.cye.mac);
            } else {
                Kg = e.Kf(eoVar.cye.mac);
            }
            if (Kg) {
                eoVar.cyf.cwB = true;
            } else {
                eoVar.cyf.cwB = false;
            }
            AppMethodBeat.o(19150);
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lrS = new com.tencent.mm.sdk.b.c<et>() {
        {
            AppMethodBeat.i(19151);
            this.xxI = et.class.getName().hashCode();
            AppMethodBeat.o(19151);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(19152);
            et etVar = (et) bVar;
            e eVar = e.this;
            if (etVar == null || !(etVar instanceof et)) {
                ab.e("MicroMsg.exdevice.ExdeviceEventManager", "event is not instanceof ExDeviceSimpleBTSendDataToDeviceEvent");
                AppMethodBeat.o(19152);
                return false;
            }
            etVar = etVar;
            if (eVar.u(etVar.cyl.mac, etVar.cyl.data)) {
                etVar.cym.cwB = true;
            } else {
                etVar.cym.cwB = false;
            }
            AppMethodBeat.o(19152);
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lrT = new com.tencent.mm.sdk.b.c<en>() {
        {
            AppMethodBeat.i(19153);
            this.xxI = en.class.getName().hashCode();
            AppMethodBeat.o(19153);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(19154);
            en enVar = (en) bVar;
            if (enVar == null || !(enVar instanceof en)) {
                ab.e("MicroMsg.exdevice.ExdeviceEventManager", "event is not instanceof ExDeviceSimpleBTBindDeviceEvent");
                AppMethodBeat.o(19154);
                return false;
            }
            enVar = enVar;
            if (ad.boW().id(com.tencent.mm.plugin.exdevice.j.b.KK(enVar.cya.mac)) != null) {
                ab.d("MicroMsg.exdevice.ExdeviceEventManager", "device(" + enVar.cya.mac + ") has been binded");
                enVar.cyb.cwB = true;
            } else {
                boolean z;
                String str = enVar.cya.mac;
                String str2 = enVar.cya.cyc;
                long j = enVar.cya.cyd;
                if (bo.isNullOrNil(str)) {
                    ab.e("MicroMsg.exdevice.ExdeviceEventManager", "mac is null or nil");
                    z = false;
                } else {
                    String str3;
                    String str4 = "MicroMsg.exdevice.ExdeviceEventManager";
                    String str5 = "handleExDeviceSimpleBTBindDevice. mac = %s, broadcastName = %s, profileType = %d";
                    Object[] objArr = new Object[3];
                    objArr[0] = str;
                    if (str2 == null) {
                        str3 = BuildConfig.COMMAND;
                    } else {
                        str3 = str2;
                    }
                    objArr[1] = str3;
                    objArr[2] = Long.valueOf(j);
                    ab.d(str4, str5, objArr);
                    int acS = aw.Rg().acS();
                    if (acS == 4 || acS == 6) {
                        if (aw.Rg().a(new m(com.tencent.mm.plugin.exdevice.j.b.KK(str), str2, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, j), 0)) {
                            z = true;
                        } else {
                            ab.e("MicroMsg.exdevice.ExdeviceEventManager", "do NetSceneBindUnauthDevice fail");
                            z = false;
                        }
                    } else {
                        ab.e("MicroMsg.exdevice.ExdeviceEventManager", "net work state is not connected, current state is %d", Integer.valueOf(acS));
                        z = false;
                    }
                }
                if (z) {
                    enVar.cyb.cwB = true;
                } else {
                    enVar.cyb.cwB = false;
                }
            }
            AppMethodBeat.o(19154);
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lrU = new com.tencent.mm.sdk.b.c<eu>() {
        {
            AppMethodBeat.i(19155);
            this.xxI = eu.class.getName().hashCode();
            AppMethodBeat.o(19155);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(19156);
            eu euVar = (eu) bVar;
            if (euVar == null || !(euVar instanceof eu)) {
                ab.e("MicroMsg.exdevice.ExdeviceEventManager", "event is not instanceof ExDeviceSimpleBTUploadDataToServerEvent");
                AppMethodBeat.o(19156);
                return false;
            }
            euVar = euVar;
            if (e.c(euVar.cyn.mac, euVar.cyn.cwz, euVar.cyn.data)) {
                euVar.cyo.cwB = true;
            } else {
                euVar.cyo.cwB = false;
            }
            AppMethodBeat.o(19156);
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lrV = new com.tencent.mm.sdk.b.c<dg>() {
        {
            AppMethodBeat.i(19157);
            this.xxI = dg.class.getName().hashCode();
            AppMethodBeat.o(19157);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            com.tencent.mm.g.a.dg.b bVar2;
            boolean z = false;
            AppMethodBeat.i(19158);
            dg dgVar = (dg) bVar;
            ab.i("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceCheckDeviceIsBoundEvent: deviceType(%s), deviceId(%s)", dgVar.cwu.cws, dgVar.cwu.ceI);
            if (dgVar.cwu.cws == null || dgVar.cwu.ceI == null) {
                bVar2 = dgVar.cwv;
            } else {
                com.tencent.mm.plugin.exdevice.h.b dS = ad.boW().dS(dgVar.cwu.ceI, dgVar.cwu.cws);
                bVar2 = dgVar.cwv;
                if (dS != null) {
                    z = true;
                }
            }
            bVar2.cww = z;
            AppMethodBeat.o(19158);
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lrW = new com.tencent.mm.sdk.b.c<df>() {
        {
            AppMethodBeat.i(19159);
            this.xxI = df.class.getName().hashCode();
            AppMethodBeat.o(19159);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(19160);
            df dfVar = (df) bVar;
            ab.i("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceCheckDeviceHasAbilityEvent: deviceType(%s), deviceId(%s)", dfVar.cwq.cws, dfVar.cwq.ceI);
            if (dfVar.cwq.cws == null || dfVar.cwq.ceI == null) {
                dfVar.cwr.cwt = false;
            } else {
                com.tencent.mm.plugin.exdevice.h.b dT = ad.boW().dT(dfVar.cwq.cws, dfVar.cwq.ceI);
                if (dT != null) {
                    String str = dT.dFr;
                    com.tencent.mm.g.a.df.b bVar2 = dfVar.cwr;
                    ad.boW();
                    bVar2.cwt = com.tencent.mm.plugin.exdevice.h.c.Kw(str);
                } else {
                    dfVar.cwr.cwt = false;
                }
            }
            AppMethodBeat.o(19160);
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lrX = new com.tencent.mm.sdk.b.c<dl>() {
        {
            AppMethodBeat.i(19161);
            this.xxI = dl.class.getName().hashCode();
            AppMethodBeat.o(19161);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(19162);
            dl dlVar = (dl) bVar;
            ab.i("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceGetCurrentSSIDEvent: opCode = %b", Boolean.valueOf(dlVar.cwJ.cwA));
            if (dlVar.cwJ.cwA) {
                String gE = at.gE(ah.getContext());
                if (!bo.isNullOrNil(gE)) {
                    dlVar.cwK.cwB = true;
                    dlVar.cwK.cwL = gE.replaceAll("\"", "");
                    AppMethodBeat.o(19162);
                    return true;
                }
            }
            dlVar.cwK.cwB = false;
            dlVar.cwK.cwL = null;
            AppMethodBeat.o(19162);
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lrY = new com.tencent.mm.sdk.b.c<lk>() {
        {
            AppMethodBeat.i(19163);
            this.xxI = lk.class.getName().hashCode();
            AppMethodBeat.o(19163);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(19164);
            if (((lk) bVar) == null) {
                ab.w("MicroMsg.exdevice.ExdeviceEventManager", "handleOnAuthSyncEvent, event is null.");
                AppMethodBeat.o(19164);
            } else {
                ab.i("MicroMsg.exdevice.ExdeviceEventManager", "handleOnAuthSyncEvent");
                AppMethodBeat.o(19164);
            }
            return false;
        }
    };
    public com.tencent.mm.sdk.b.c lrZ = new com.tencent.mm.sdk.b.c<ln>() {
        {
            AppMethodBeat.i(19167);
            this.xxI = ln.class.getName().hashCode();
            AppMethodBeat.o(19167);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(19168);
            ab.i("MicroMsg.exdevice.ExdeviceEventManager", "OnSubCoreInited, process : %s", ah.getProcessName());
            if (ah.doH()) {
                AppMethodBeat.o(19168);
                return false;
            }
            AppMethodBeat.o(19168);
            return true;
        }
    };
    List<b> lrw = new LinkedList();
    Map<String, b> lrx = new HashMap();
    public com.tencent.mm.sdk.b.c lry = new com.tencent.mm.sdk.b.c<jo>() {
        {
            AppMethodBeat.i(19125);
            this.xxI = jo.class.getName().hashCode();
            AppMethodBeat.o(19125);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            com.tencent.mm.plugin.exdevice.h.b bVar2;
            AppMethodBeat.i(19126);
            jo joVar = (jo) bVar;
            e eVar = e.this;
            int i = joVar.cEM.opType;
            int i2 = joVar.cEM.cEO;
            String str = joVar.cEM.cEN;
            if (i == 1) {
                ab.i("MicroMsg.exdevice.ExdeviceEventManager", "Just enter, so clear previous state.");
                lq lqVar = new lq();
                lqVar.cHu.op = 3;
                lqVar.cHu.cEN = joVar.cEM.cEN;
                com.tencent.mm.sdk.b.a.xxA.m(lqVar);
            }
            LinkedList Kx = ad.boW().Kx(str);
            com.tencent.mm.aj.d qX = f.qX(str);
            if (qX != null) {
                com.tencent.mm.aj.d.b cJ = qX.cJ(false);
                if (cJ != null) {
                    com.tencent.mm.aj.d.b.b aej = cJ.aej();
                    if (aej != null && aej.aes() && aej.fvJ == 1) {
                        LinkedList<com.tencent.mm.plugin.exdevice.h.b> bpC = ad.boW().bpC();
                        ab.i("MicroMsg.exdevice.ExdeviceEventManager", "Wechat sport biz...");
                        if (bpC.size() != 0) {
                            for (com.tencent.mm.plugin.exdevice.h.b bVar22 : bpC) {
                                if (0 != (bVar22.dFq & 1)) {
                                    ab.i("MicroMsg.exdevice.ExdeviceEventManager", "BLE connected device info, mac(%s), deviceId(%s), deviceType(%s), SimpleProtol(%d), connProto(%s)", Long.valueOf(bVar22.field_mac), bVar22.field_deviceID, bVar22.field_deviceType, Long.valueOf(bVar22.dFq), bVar22.field_connProto);
                                    Kx.add(bVar22);
                                }
                            }
                        }
                    }
                }
            }
            if (Kx == null) {
                ab.i("MicroMsg.exdevice.ExdeviceEventManager", "get hdinfo by brandName failed : %s", str);
                AppMethodBeat.o(19126);
                return false;
            } else if (Kx.size() == 0) {
                ab.i("MicroMsg.exdevice.ExdeviceEventManager", "get hdinfo by brandName(%s) result count is 0 ", str);
                AppMethodBeat.o(19126);
                return true;
            } else {
                if (i == 2) {
                    ab.d("MicroMsg.exdevice.ExdeviceEventManager", "exit chattingui, clear observers.");
                    eVar.lrx.clear();
                }
                LinkedList linkedList = new LinkedList();
                Iterator it = Kx.iterator();
                Object obj = null;
                while (it.hasNext()) {
                    bVar22 = (com.tencent.mm.plugin.exdevice.h.b) it.next();
                    if (bVar22 == null || bo.isNullOrNil(bVar22.field_brandName)) {
                        AppMethodBeat.o(19126);
                        return false;
                    }
                    String nullAsNil = bo.nullAsNil(bVar22.field_connProto);
                    if (nullAsNil.contains("4")) {
                        ab.i("MicroMsg.exdevice.ExdeviceEventManager", "Wifi biz.");
                        linkedList.add(bVar22);
                    } else {
                        if (nullAsNil.contains("1") || nullAsNil.contains(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL) || nullAsNil.contains("5") || nullAsNil.length() == 0) {
                            ab.i("MicroMsg.exdevice.ExdeviceEventManager", "BlueTooth biz.");
                            if (com.tencent.mm.plugin.d.a.e.a.aVH()) {
                                obj = null;
                                e.a(bVar22, i, i2);
                            } else {
                                ab.w("MicroMsg.exdevice.ExdeviceEventManager", "System bluetooth is close");
                                obj = 1;
                            }
                        }
                        obj = obj;
                    }
                }
                i2 = linkedList.size();
                if (i2 > 0) {
                    eVar.k(linkedList, i);
                    bVar22 = (com.tencent.mm.plugin.exdevice.h.b) linkedList.get(i2 - 1);
                    if (i2 == Kx.size()) {
                        e.b(bVar22.field_brandName, bVar22.field_url, 0, bVar22.field_deviceID);
                    }
                }
                e.cc(str, obj != null ? 0 : -1);
                AppMethodBeat.o(19126);
                return false;
            }
        }
    };
    public com.tencent.mm.sdk.b.c lrz = new com.tencent.mm.sdk.b.c<jn>() {
        {
            AppMethodBeat.i(19147);
            this.xxI = jn.class.getName().hashCode();
            AppMethodBeat.o(19147);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(19148);
            u.bpy().a(new i(((jn) bVar).cEL.opType));
            AppMethodBeat.o(19148);
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lsa = new com.tencent.mm.sdk.b.c<dq>() {
        {
            AppMethodBeat.i(19171);
            this.xxI = dq.class.getName().hashCode();
            AppMethodBeat.o(19171);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(19172);
            dq dqVar = (dq) bVar;
            long j = dqVar.cxc.cvx;
            String str = dqVar.cxc.cwT;
            List<com.tencent.mm.plugin.exdevice.h.b> bpA = ad.boW().bpA();
            if (bpA.size() > 0) {
                boolean z;
                if (j == -1 || j == Long.MIN_VALUE) {
                    z = false;
                } else {
                    aw.ZK();
                    bi jf = com.tencent.mm.model.c.XO().jf(j);
                    if (jf.field_msgId == 0) {
                        z = false;
                    } else {
                        int type = jf.getType();
                        String str2 = jf.field_content;
                        String str3;
                        if (jf.bAA()) {
                            com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(str2);
                            if (me == null) {
                                ab.e("MicroMsg.exdevice.ExdeviceEventManager", "get content is null");
                                z = false;
                            } else if (me.type == 3) {
                                for (com.tencent.mm.plugin.exdevice.h.b bVar2 : bpA) {
                                    str3 = bVar2.dFr;
                                    if (str3 != null && str3.contains("wxmsg_music")) {
                                        z = true;
                                        break;
                                    }
                                }
                                z = false;
                            } else if (me.type == 4) {
                                z = false;
                            } else if (me.type == 6) {
                                for (com.tencent.mm.plugin.exdevice.h.b bVar22 : bpA) {
                                    str3 = bVar22.dFr;
                                    if (str3 != null && str3.contains("wxmsg_file")) {
                                        z = true;
                                        break;
                                    }
                                }
                                z = false;
                            } else if (me.type == 5) {
                                z = e.i(me.url, bpA);
                            } else {
                                if (me.type == 2) {
                                    for (com.tencent.mm.plugin.exdevice.h.b bVar222 : bpA) {
                                        str3 = bVar222.dFr;
                                        if (str3 != null && str3.contains("wxmsg_image")) {
                                            z = true;
                                            break;
                                        }
                                    }
                                    z = false;
                                }
                                z = false;
                            }
                        } else if (type == 3) {
                            for (com.tencent.mm.plugin.exdevice.h.b bVar2222 : bpA) {
                                str3 = bVar2222.dFr;
                                if (str3 != null && str3.contains("wxmsg_image")) {
                                    z = true;
                                    break;
                                }
                            }
                            z = false;
                        } else if (type == 48) {
                            for (com.tencent.mm.plugin.exdevice.h.b bVar22222 : bpA) {
                                str3 = bVar22222.dFr;
                                if (str3 != null && str3.contains("wxmsg_poi")) {
                                    z = true;
                                    break;
                                }
                            }
                            z = false;
                        } else {
                            if (type == 62) {
                                for (com.tencent.mm.plugin.exdevice.h.b bVar222222 : bpA) {
                                    str3 = bVar222222.dFr;
                                    if (str3 != null && str3.contains("wxmsg_video")) {
                                        z = true;
                                        break;
                                    }
                                }
                            }
                            z = false;
                        }
                        ab.i("MicroMsg.exdevice.ExdeviceEventManager", "isSupportsMsgType = " + z + ", msgType = " + type);
                    }
                }
                if (z || e.j(str, bpA)) {
                    dqVar.cxd.cwB = true;
                    AppMethodBeat.o(19172);
                    return true;
                }
            }
            dqVar.cxd.cwB = false;
            AppMethodBeat.o(19172);
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lsb = new com.tencent.mm.sdk.b.c<do>() {
        {
            AppMethodBeat.i(19173);
            this.xxI = do.class.getName().hashCode();
            AppMethodBeat.o(19173);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(19174);
            do doVar = (do) bVar;
            e eVar = e.this;
            doVar = doVar;
            eVar.lsn = new g();
            g gVar = eVar.lsn;
            ab.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "startScanWCLanDevice...");
            Java2CExDevice.startScanWCLanDevice(new byte[0], 1000);
            gVar.lsv = false;
            new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
                public final boolean BI() {
                    AppMethodBeat.i(19257);
                    int size = g.this.lsJ.size();
                    int i = 0;
                    while (i < size) {
                        if (((b) g.this.lsJ.get(i)).dFr.contains("internet_to_device") && ((b) g.this.lsJ.get(i)).dFr.contains("wechat_to_device") && !g.this.lsK.contains(g.this.lsJ.get(i))) {
                            g.this.lsK.add(g.this.lsJ.get(i));
                            g.bx(g.this.lsK);
                        }
                        i++;
                    }
                    AppMethodBeat.o(19257);
                    return true;
                }
            }, false).ae(3000, 3000);
            g gVar2 = eVar.lsn;
            long j = doVar.cwR.cvx;
            String str = doVar.cwR.cwT;
            String str2 = doVar.cwR.cwU;
            int i = doVar.cwR.cwV;
            ArrayList arrayList = new ArrayList();
            gVar2.edW = j;
            gVar2.lsy = str;
            gVar2.lsz = str2;
            gVar2.lsA = i;
            int size = gVar2.lsK.size();
            for (int i2 = 0; i2 < size; i2++) {
                HashMap hashMap = new HashMap();
                hashMap.put("deviceType", ((com.tencent.mm.plugin.exdevice.h.b) gVar2.lsK.get(i2)).field_deviceType);
                hashMap.put("deviceID", ((com.tencent.mm.plugin.exdevice.h.b) gVar2.lsK.get(i2)).field_deviceID);
                hashMap.put("displayName", g.c((com.tencent.mm.plugin.exdevice.h.b) gVar2.lsK.get(i2)));
                hashMap.put("iconUrl", ((com.tencent.mm.plugin.exdevice.h.b) gVar2.lsK.get(i2)).iconUrl);
                hashMap.put("ability", ((com.tencent.mm.plugin.exdevice.h.b) gVar2.lsK.get(i2)).dFr);
                hashMap.put("abilityInf", ((com.tencent.mm.plugin.exdevice.h.b) gVar2.lsK.get(i2)).dFs);
                arrayList.add(hashMap);
            }
            if (arrayList.size() > 0) {
                doVar.cwS.cwW = arrayList;
                doVar.cwS.cwB = true;
            } else {
                doVar.cwS.cwB = false;
            }
            AppMethodBeat.o(19174);
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lsc = new com.tencent.mm.sdk.b.c<ej>() {
        {
            AppMethodBeat.i(19175);
            this.xxI = ej.class.getName().hashCode();
            AppMethodBeat.o(19175);
        }

        /* JADX WARNING: Removed duplicated region for block: B:108:0x04bb  */
        /* JADX WARNING: Removed duplicated region for block: B:90:0x03d8  */
        /* JADX WARNING: Removed duplicated region for block: B:111:0x04d2  */
        /* JADX WARNING: Removed duplicated region for block: B:93:0x03ea  */
        /* JADX WARNING: Removed duplicated region for block: B:90:0x03d8  */
        /* JADX WARNING: Removed duplicated region for block: B:108:0x04bb  */
        /* JADX WARNING: Removed duplicated region for block: B:93:0x03ea  */
        /* JADX WARNING: Removed duplicated region for block: B:111:0x04d2  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(19176);
            ej ejVar = (ej) bVar;
            e eVar = e.this;
            ejVar = ejVar;
            if (bo.isNullOrNil(ejVar.cxP.cws) || bo.isNullOrNil(ejVar.cxP.ceI)) {
                ejVar.cxQ.cxT = false;
            } else {
                String str;
                Boolean bool;
                int i;
                com.tencent.mm.g.a.ej.b bVar2 = ejVar.cxQ;
                g gVar = eVar.lsn;
                String str2 = ejVar.cxP.cws;
                String str3 = ejVar.cxP.ceI;
                String str4 = ejVar.cxP.cxR;
                long j = ejVar.cxP.cvx;
                String str5 = ejVar.cxP.cwT;
                boolean z = ejVar.cxP.cxS;
                gVar.edW = j;
                gVar.lsw = false;
                gVar.lsx = z;
                ab.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "deviceType: %s, deviceId: %s", str2, str3);
                int i2 = 0;
                if (str4 == null || !str4.contains("wechat_to_device") || gVar.lsL.get(str3) == null) {
                    if (str4 != null && str4.contains("internet_to_device")) {
                        i2 = 1;
                        if (!z && (g.hJ(j).booleanValue() || g.hI(j).booleanValue() || g.hL(j).booleanValue() || g.hK(j).booleanValue())) {
                            str4 = "MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice";
                            str5 = "mDeviceMsgForUseCdn %s deviceId %s deviceType %s";
                            Object[] objArr = new Object[3];
                            objArr[0] = Boolean.valueOf(gVar.lsH == null);
                            objArr[1] = str3;
                            objArr[2] = str2;
                            ab.d(str4, str5, objArr);
                            if (gVar.lsH != null) {
                                aw.Rg().a(new n(gVar.lsH, str2, str3, 1), 0);
                            } else {
                                gVar.lsG.put(str3, str2);
                                if (!gVar.lsF) {
                                    Object obj;
                                    str4 = "";
                                    str = "";
                                    gVar.lsE = true;
                                    aw.ZK();
                                    bi jf = com.tencent.mm.model.c.XO().jf(j);
                                    Object[] objArr2;
                                    com.tencent.mm.i.g gVar2;
                                    if (g.hJ(j).booleanValue()) {
                                        com.tencent.mm.at.e w = o.ahl().w(jf);
                                        str4 = o.ahl().q(w.fDz, "", "");
                                        str = o.ahl().q(w.fDB, "", "");
                                        gVar.eFm = w.fDy;
                                        if (bo.isNullOrNil(gVar.fFa)) {
                                            ab.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "createMediaId time:%d talker:%s msg:%d img:%d compressType:%d", Long.valueOf(jf.field_createTime), jf.field_talker, Long.valueOf(jf.field_msgId), Long.valueOf(gVar.eFm), Integer.valueOf(0));
                                            gVar.fFa = com.tencent.mm.al.c.a("upimg", jf.field_createTime, jf.field_talker, jf.field_msgId + "_" + gVar.eFm + "_0");
                                        }
                                        com.tencent.mm.al.f.afx();
                                        if (!com.tencent.mm.al.b.lg(1) && bo.isNullOrNil(w.fDK)) {
                                            objArr2 = new Object[2];
                                            com.tencent.mm.al.f.afx();
                                            objArr2[0] = Boolean.valueOf(com.tencent.mm.al.b.lg(1));
                                            objArr2[1] = w.fDK;
                                            ab.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra not use cdn flag:%b getCdnInfo:%s", objArr2);
                                            obj = null;
                                        }
                                        if (g.hJ(j).booleanValue() || g.hK(j).booleanValue()) {
                                            gVar.lsI = new Random().nextLong();
                                            str4 = g.B(str4, gVar.lsI);
                                            str = g.B(str, gVar.lsI);
                                        }
                                        gVar2 = new com.tencent.mm.i.g();
                                        gVar2.egl = gVar.fFk;
                                        gVar2.field_mediaId = gVar.fFa;
                                        gVar2.field_fullpath = str4;
                                        gVar2.field_thumbpath = str;
                                        gVar2.field_fileType = com.tencent.mm.i.a.efM;
                                        gVar2.field_talker = jf.field_talker;
                                        gVar2.field_priority = com.tencent.mm.i.a.efB;
                                        gVar2.field_needStorage = false;
                                        gVar2.field_isStreamMedia = false;
                                        gVar2.field_appType = 202;
                                        gVar2.field_bzScene = 2;
                                        if (g.hI(j).booleanValue()) {
                                            gVar2.field_fileType = com.tencent.mm.i.a.efM;
                                            gVar2.field_appType = 202;
                                        } else if (g.hL(j).booleanValue()) {
                                            gVar2.field_appType = 102;
                                            gVar2.field_fileType = com.tencent.mm.i.a.efI;
                                            gVar2.field_bzScene = 1;
                                        }
                                        if (com.tencent.mm.al.f.afx().e(gVar2)) {
                                            obj = 1;
                                        } else {
                                            h.pYm.a(111, 205, 1, false);
                                            ab.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra addSendTask failed. clientid:%s", gVar.fFa);
                                            gVar.fFa = "";
                                            obj = null;
                                        }
                                    } else if (g.hI(j).booleanValue() || g.hK(j).booleanValue()) {
                                        com.tencent.mm.pluginsdk.model.app.b aiE = am.aUq().aiE(com.tencent.mm.af.j.b.me(jf.field_content).csD);
                                        if (aiE != null) {
                                            str4 = aiE.field_fileFullPath;
                                            com.tencent.mm.al.f.afx();
                                            if (com.tencent.mm.al.b.lg(4) || aiE.field_isUseCdn == 1) {
                                                if (!bo.isNullOrNil(jf.field_imgPath)) {
                                                    str = o.ahl().sj(jf.field_imgPath);
                                                }
                                                long asZ = com.tencent.mm.vfs.e.asZ(str);
                                                long asZ2 = com.tencent.mm.vfs.e.asZ(aiE.field_fileFullPath);
                                                if (asZ >= ((long) com.tencent.mm.i.a.efW)) {
                                                    ab.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", str, Long.valueOf(asZ));
                                                    obj = null;
                                                } else {
                                                    gVar.fFa = com.tencent.mm.al.c.a("upattach", aiE.field_createTime, jf.field_talker, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                                                    if (bo.isNullOrNil(gVar.fFa)) {
                                                        ab.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra genClientId failed not use cdn compressType:%d", Integer.valueOf(0));
                                                        obj = null;
                                                    } else {
                                                        ab.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra checkUseCdn id:%d file[%s][%d] thumb[%s][%d]", Long.valueOf(aiE.field_msgInfoId), aiE.field_fileFullPath, Long.valueOf(asZ2), str, Long.valueOf(asZ));
                                                        gVar.lsI = new Random().nextLong();
                                                        str4 = g.B(str4, gVar.lsI);
                                                        str = g.B(str, gVar.lsI);
                                                        gVar2 = new com.tencent.mm.i.g();
                                                        gVar2.egl = gVar.fFk;
                                                        gVar2.field_mediaId = gVar.fFa;
                                                        gVar2.field_fullpath = str4;
                                                        gVar2.field_thumbpath = str;
                                                        gVar2.field_fileType = com.tencent.mm.i.a.efM;
                                                        gVar2.field_talker = jf.field_talker;
                                                        gVar2.field_priority = com.tencent.mm.i.a.efB;
                                                        gVar2.field_needStorage = false;
                                                        gVar2.field_isStreamMedia = false;
                                                        gVar2.field_appType = 202;
                                                        gVar2.field_bzScene = 2;
                                                        if (g.hI(j).booleanValue()) {
                                                        }
                                                        if (com.tencent.mm.al.f.afx().e(gVar2)) {
                                                        }
                                                    }
                                                }
                                            } else {
                                                objArr2 = new Object[2];
                                                com.tencent.mm.al.f.afx();
                                                objArr2[0] = Boolean.valueOf(com.tencent.mm.al.b.lg(4));
                                                objArr2[1] = Integer.valueOf(aiE.field_isUseCdn);
                                                ab.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra not use cdn flag:%b getCdnInfo:%d", objArr2);
                                                obj = null;
                                            }
                                        } else {
                                            ab.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "getFilePath attInfo is null");
                                            obj = null;
                                        }
                                    } else {
                                        if (g.hL(j).booleanValue()) {
                                            s uf = com.tencent.mm.modelvideo.o.all().uf(jf.field_imgPath);
                                            if (uf == null) {
                                                ab.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "Get info Failed file:" + jf.field_imgPath);
                                                obj = null;
                                            } else {
                                                com.tencent.mm.al.f.afx();
                                                if (com.tencent.mm.al.b.lg(2) || uf.fXi == 1) {
                                                    gVar.fFa = com.tencent.mm.al.c.a("upvideo", uf.createTime, uf.getUser(), uf.getFileName());
                                                    if (bo.isNullOrNil(gVar.fFa)) {
                                                        ab.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra genClientId failed not use cdn file:%s", uf.getFileName());
                                                        obj = null;
                                                    } else {
                                                        com.tencent.mm.modelvideo.o.all();
                                                        str = t.ui(jf.field_imgPath);
                                                        com.tencent.mm.modelvideo.o.all();
                                                        str4 = t.uh(jf.field_imgPath);
                                                    }
                                                } else {
                                                    r7 = new Object[2];
                                                    com.tencent.mm.al.f.afx();
                                                    r7[0] = Boolean.valueOf(com.tencent.mm.al.b.lg(2));
                                                    r7[1] = Integer.valueOf(uf.fXi);
                                                    ab.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra not use cdn flag:%b getCdnInfo:%d", r7);
                                                    obj = null;
                                                }
                                            }
                                        }
                                        gVar.lsI = new Random().nextLong();
                                        str4 = g.B(str4, gVar.lsI);
                                        str = g.B(str, gVar.lsI);
                                        gVar2 = new com.tencent.mm.i.g();
                                        gVar2.egl = gVar.fFk;
                                        gVar2.field_mediaId = gVar.fFa;
                                        gVar2.field_fullpath = str4;
                                        gVar2.field_thumbpath = str;
                                        gVar2.field_fileType = com.tencent.mm.i.a.efM;
                                        gVar2.field_talker = jf.field_talker;
                                        gVar2.field_priority = com.tencent.mm.i.a.efB;
                                        gVar2.field_needStorage = false;
                                        gVar2.field_isStreamMedia = false;
                                        gVar2.field_appType = 202;
                                        gVar2.field_bzScene = 2;
                                        if (g.hI(j).booleanValue()) {
                                        }
                                        if (com.tencent.mm.al.f.afx().e(gVar2)) {
                                        }
                                    }
                                    if (obj == null) {
                                        g.dQ(str3, gVar.lsC);
                                        gVar.lsF = false;
                                    } else {
                                        gVar.lsF = true;
                                    }
                                }
                            }
                            bool = Boolean.TRUE;
                            bVar2.cxT = bool.booleanValue();
                        }
                    }
                    i = i2;
                } else {
                    i = 0;
                }
                atr atr = new atr();
                bau bau;
                if (!z) {
                    gVar.a(atr, gVar.edW);
                } else if (gVar.boL().xfI.wbJ != 1 || i != 0 || gVar.lsz != null) {
                    if (str5 != null) {
                        TimeLineObject boL = gVar.boL();
                        switch (boL.xfI.wbJ) {
                            case 1:
                                ab.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "is sns photo!");
                                int i3 = -1;
                                String str6 = null;
                                String str7 = null;
                                str = null;
                                String str8 = gVar.lsz;
                                if (str8 != null && str8.length() > 0) {
                                    com.tencent.mm.vfs.b bVar3 = new com.tencent.mm.vfs.b(str8);
                                    str7 = bVar3.getName();
                                    i3 = (int) bVar3.length();
                                    str = str7.substring(str7.lastIndexOf(".") + 1, str7.length());
                                    str6 = com.tencent.mm.vfs.e.atg(str8);
                                    ab.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "dataSnsInit filePath %s, fileSize %s, fileMd5 %s", str8, Integer.valueOf(i3), str6);
                                }
                                ats ats = new ats();
                                ats.Type = str;
                                ats.Name = str7;
                                ats.jCo = i3;
                                ats.Md5 = str6;
                                if (i == 1) {
                                    bau = (bau) boL.xfI.wbK.get(gVar.lsA);
                                    if (bau == null) {
                                        ab.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mediaObjImage is null");
                                        break;
                                    }
                                    ats.Url = bau.Url;
                                    ats.wxO = bau.wEY;
                                    if (!bo.isNullOrNil(ats.wxO)) {
                                        ats.Url += "?idx=" + bau.wEX + "&token=" + bau.wEW;
                                    }
                                }
                                atr.wxK = ats;
                                atr.wxH = 3;
                                break;
                            case 3:
                                bau = (bau) boL.xfI.wbK.get(0);
                                if (bau != null) {
                                    gVar.lsw = true;
                                    atv atv = new atv();
                                    atv.Url = bau.Url;
                                    atv.Title = bau.Title;
                                    atv.wxR = bau.Desc;
                                    atr.wxM = atv;
                                    atr.wxH = 5;
                                    break;
                                }
                                ab.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mediaObUrl is null");
                                break;
                            case 4:
                                ab.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "is sns music!");
                                bau = (bau) boL.xfI.wbK.get(0);
                                if (bau != null) {
                                    gVar.lsw = true;
                                    atu atu = new atu();
                                    atu.Title = bau.Title;
                                    atu.wxR = bau.Desc;
                                    atu.Url = boL.xfI.Url;
                                    atu.vYK = bau.Url;
                                    atu.wxT = bau.wEL;
                                    atu.ncH = boL.xfH.ncH;
                                    atr.wxI = atu;
                                    atr.wxH = 1;
                                    break;
                                }
                                ab.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mediaObj is null");
                                break;
                            case 15:
                                ab.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "is sns sight!");
                                bau = (bau) boL.xfI.wbK.get(0);
                                if (bau != null) {
                                    gVar.lsw = true;
                                    atw atw = new atw();
                                    atw.Url = bau.Url;
                                    ab.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "videoMsg.url = %s", atw.Url);
                                    atr.wxN = atw;
                                    atr.wxH = 6;
                                    break;
                                }
                                ab.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mediaObjSight is null");
                                break;
                        }
                    }
                } else {
                    gVar.lsT = atr;
                    gVar.lsU = str2;
                    gVar.lsV = str3;
                    gVar.lsW = 0;
                    bau = (bau) gVar.boL().xfI.wbK.get(gVar.lsA);
                    if (bau == null) {
                        ab.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mediaObjImage is null");
                        g.dQ(str3, gVar.lsC);
                    } else {
                        gVar.cEZ = bau.Url;
                        d.post(gVar.lsS, "ExdeviceDownloadImage");
                    }
                    bool = Boolean.TRUE;
                    bVar2.cxT = bool.booleanValue();
                }
                aw.Rg().a(new n(atr, str2, str3, i), 0);
                bool = Boolean.TRUE;
                bVar2.cxT = bool.booleanValue();
            }
            AppMethodBeat.o(19176);
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lsd = new com.tencent.mm.sdk.b.c<ew>() {
        {
            AppMethodBeat.i(19177);
            this.xxI = ew.class.getName().hashCode();
            AppMethodBeat.o(19177);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(19178);
            ew ewVar = (ew) bVar;
            com.tencent.mm.ai.f fVar = e.this.lsn;
            if (!fVar.lsv) {
                ab.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "stopScanNetworkDevice...");
                Java2CExDevice.stopScanWCLanDevice();
                fVar.lsv = true;
            }
            aw.RS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(19258);
                    ab.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "releaseWCLanDeviceLib...");
                    Java2CExDevice.releaseWCLanDeviceLib();
                    AppMethodBeat.o(19258);
                }
            });
            aw.Rg().b(1717, fVar);
            j.boN().b(14, fVar.lsO);
            j.boN().b(12, fVar.lsP);
            j.boN().b(13, fVar.lsQ);
            j.boN().b(15, fVar.lsR);
            ewVar.cyq.cxT = true;
            AppMethodBeat.o(19178);
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lse = new com.tencent.mm.sdk.b.c<em>() {
        {
            AppMethodBeat.i(19179);
            this.xxI = em.class.getName().hashCode();
            AppMethodBeat.o(19179);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(19180);
            em emVar = (em) bVar;
            if (ad.boW().bpB().size() > 0) {
                emVar.cxZ.cwB = true;
            } else {
                emVar.cxZ.cwB = false;
            }
            AppMethodBeat.o(19180);
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lsg = new com.tencent.mm.sdk.b.c<dd>() {
        {
            AppMethodBeat.i(19181);
            this.xxI = dd.class.getName().hashCode();
            AppMethodBeat.o(19181);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(19182);
            dd ddVar = (dd) bVar;
            e eVar = e.this;
            String str = ddVar.cwo.ceI;
            g gVar = eVar.lsn;
            gVar.lsG.remove(str);
            if (gVar.lsM.get(str) != null) {
                ab.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cancelWCLanDeviceTask cmdId: " + gVar.lsM.get(str));
                Java2CExDevice.cancelWCLanDeviceTask(((Integer) gVar.lsM.get(str)).intValue());
            }
            AppMethodBeat.o(19182);
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lsh = new com.tencent.mm.sdk.b.c<ee>() {
        {
            AppMethodBeat.i(19183);
            this.xxI = ee.class.getName().hashCode();
            AppMethodBeat.o(19183);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(19184);
            ee eeVar = (ee) bVar;
            e eVar = e.this;
            eeVar = eeVar;
            if (eVar.lsm == null) {
                eVar.lsm = new ExdeviceWCLanSDKUtil();
            }
            ExdeviceWCLanSDKUtil exdeviceWCLanSDKUtil = eVar.lsm;
            if (eeVar.cxF.cwA) {
                ab.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "initWCLanDeviceLib...");
                Java2CExDevice.initWCLanDeviceLib();
                j.boN().a(14, exdeviceWCLanSDKUtil.lsO);
                j.boN().a(10, exdeviceWCLanSDKUtil.ltg);
                j.boN().a(13, exdeviceWCLanSDKUtil.lsQ);
                j.boN().a(16, exdeviceWCLanSDKUtil.lth);
            } else {
                aw.RS().aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(19288);
                        ab.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "releaseWCLanDeviceLib...");
                        Java2CExDevice.releaseWCLanDeviceLib();
                        AppMethodBeat.o(19288);
                    }
                });
                ab.d("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "unregisterReceiver...");
                if (exdeviceWCLanSDKUtil.jIA != null) {
                    exdeviceWCLanSDKUtil.mContext.unregisterReceiver(exdeviceWCLanSDKUtil.jIA);
                    exdeviceWCLanSDKUtil.jIA = null;
                }
                j.boN().b(14, exdeviceWCLanSDKUtil.lsO);
                j.boN().b(10, exdeviceWCLanSDKUtil.ltg);
                j.boN().b(13, exdeviceWCLanSDKUtil.lsQ);
                j.boN().b(16, exdeviceWCLanSDKUtil.lth);
            }
            AppMethodBeat.o(19184);
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lsi = new com.tencent.mm.sdk.b.c<ev>() {
        {
            AppMethodBeat.i(19185);
            this.xxI = ev.class.getName().hashCode();
            AppMethodBeat.o(19185);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(19186);
            if (((ev) bVar).cyp.cwA) {
                ab.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "startScanWCLanDevice...");
                Java2CExDevice.startScanWCLanDevice(new byte[0], 1000);
            } else {
                ab.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "stopScanWCLanDevice...");
                Java2CExDevice.stopScanWCLanDevice();
            }
            AppMethodBeat.o(19186);
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lsj = new com.tencent.mm.sdk.b.c<di>() {
        {
            AppMethodBeat.i(19187);
            this.xxI = di.class.getName().hashCode();
            AppMethodBeat.o(19187);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(19188);
            di diVar = (di) bVar;
            e eVar = e.this;
            diVar = diVar;
            ab.i("MicroMsg.exdevice.ExdeviceEventManager", "ExDeviceConnectLanDeviceEvent: brandName=%s, deviceId=%s, type=%b", diVar.cwC.cwz, diVar.cwC.ceI, Boolean.valueOf(diVar.cwC.cwA));
            if (e.Ke(diVar.cwC.cwz)) {
                com.tencent.mm.plugin.exdevice.h.b Kv = ad.boW().Kv(diVar.cwC.ceI);
                if (Kv == null) {
                    diVar.cwD.cwB = false;
                    ab.e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo null, %s", diVar.cwC.ceI);
                    AppMethodBeat.o(19188);
                    return false;
                } else if (Kv.field_brandName.equals(diVar.cwC.cwz)) {
                    boolean ax = eVar.lsm.ax(diVar.cwC.ceI, diVar.cwC.cwA);
                    diVar.cwD.cwB = ax;
                    AppMethodBeat.o(19188);
                    return ax;
                } else {
                    diVar.cwD.cwB = false;
                    ab.e("MicroMsg.exdevice.ExdeviceEventManager", "brand name not match. %s != %s", Kv.field_brandName, diVar.cwC.cwz);
                    AppMethodBeat.o(19188);
                    return false;
                }
            }
            diVar.cwD.cwB = false;
            AppMethodBeat.o(19188);
            return false;
        }
    };
    public com.tencent.mm.sdk.b.c lsk = new com.tencent.mm.sdk.b.c<ei>() {
        {
            AppMethodBeat.i(19189);
            this.xxI = ei.class.getName().hashCode();
            AppMethodBeat.o(19189);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(19190);
            ei eiVar = (ei) bVar;
            e eVar = e.this;
            eiVar = eiVar;
            ab.i("MicroMsg.exdevice.ExdeviceEventManager", "ExDeviceSendDataToLanDeviceEvent: brandName=%s, deviceId=%s", eiVar.cxN.cwz, eiVar.cxN.ceI);
            if (!e.Ke(eiVar.cxN.cwz) || bo.isNullOrNil(eiVar.cxN.data)) {
                eiVar.cxO.cwB = false;
                AppMethodBeat.o(19190);
                return false;
            } else if (ad.boW().Kv(eiVar.cxN.ceI) == null) {
                ab.e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo error");
                eiVar.cxO.cwB = false;
                AppMethodBeat.o(19190);
                return false;
            } else {
                eiVar.cxO.cwB = eVar.lsm.dR(eiVar.cxN.ceI, eiVar.cxN.data);
                AppMethodBeat.o(19190);
                return true;
            }
        }
    };
    public com.tencent.mm.sdk.b.c lsl = new com.tencent.mm.sdk.b.c<dn>() {
        {
            AppMethodBeat.i(19193);
            this.xxI = dn.class.getName().hashCode();
            AppMethodBeat.o(19193);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(19194);
            boolean c = e.this.c((dn) bVar);
            AppMethodBeat.o(19194);
            return c;
        }
    };
    ExdeviceWCLanSDKUtil lsm;
    g lsn;
    private boolean lso = false;
    private c lsp;
    ak mHandler;

    public interface b {
        void b(String str, byte[] bArr, boolean z);

        void c(String str, int i, long j);

        void p(String str, String str2, boolean z);
    }

    public class a implements b {
        private String cbq;
        private String lst;
        private String lsu;
        private String mURL;

        public a(String str, String str2, String str3, String str4) {
            AppMethodBeat.i(19211);
            this.lst = str;
            this.cbq = str2;
            this.mURL = str3;
            this.lsu = str4;
            ab.d("MicroMsg.exdevice.ExdeviceEventManager", "brandName : %s, mac : %s.", str, str2);
            AppMethodBeat.o(19211);
        }

        public final void p(String str, String str2, boolean z) {
            AppMethodBeat.i(19212);
            if (this.cbq == null || !this.cbq.equals(str2)) {
                ab.d("MicroMsg.exdevice.ExdeviceEventManager", "onScanResult, mac(%s) is null or not correct.(mac : %s, isCompleted : %s)", this.cbq, str2, Boolean.valueOf(z));
                AppMethodBeat.o(19212);
                return;
            }
            AppMethodBeat.o(19212);
        }

        public final void b(String str, byte[] bArr, boolean z) {
            AppMethodBeat.i(19213);
            if (this.cbq == null || !this.cbq.equals(str)) {
                ab.i("MicroMsg.exdevice.ExdeviceEventManager", "onRecvFromDevice, mac(%s) is null or not correct.(mac : %s, succ : %s)", this.cbq, str, Boolean.valueOf(z));
                AppMethodBeat.o(19213);
                return;
            }
            if (z && bArr != null) {
                try {
                    ad.bph();
                    if (e.c(this.cbq, this.lst, bArr)) {
                        AppMethodBeat.o(19213);
                        return;
                    }
                    ab.w("MicroMsg.exdevice.ExdeviceEventManager", "The parser isn't a correct type.");
                    AppMethodBeat.o(19213);
                    return;
                } catch (Exception e) {
                    ab.e("MicroMsg.exdevice.ExdeviceEventManager", "Read data from bytes failed.");
                }
            }
            AppMethodBeat.o(19213);
        }

        public final void c(String str, int i, long j) {
            AppMethodBeat.i(19214);
            if (this.cbq == null || !this.cbq.equals(str)) {
                ab.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, mac(%s) is null or not correct.(mac : %s, state : %s, type : %s)", this.cbq, str, Integer.valueOf(i), Long.valueOf(j));
                AppMethodBeat.o(19214);
                return;
            }
            ab.i("MicroMsg.exdevice.ExdeviceEventManager", "mac(%s), connectState(%s), profileType(%s)", str, Integer.valueOf(i), Long.valueOf(j));
            switch (i) {
                case 0:
                    e.b(this.lst, this.mURL, 0, this.lsu);
                    ab.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device state none.(mac : %s)", str);
                    AppMethodBeat.o(19214);
                    return;
                case 1:
                    ab.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device is connectiong.(mac: %s)", str);
                    e.b(this.lst, this.mURL, 1, this.lsu);
                    AppMethodBeat.o(19214);
                    return;
                case 2:
                    ab.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device connected now start send data to it.(mac : %s)", str);
                    e.b(this.lst, this.mURL, 2, this.lsu);
                    com.tencent.mm.plugin.d.a.b.a.f fVar = new com.tencent.mm.plugin.d.a.b.a.f();
                    fVar.jHc = com.tencent.mm.plugin.d.a.b.a.f.jIf;
                    fVar.jHd = 2;
                    ad.bph().u(this.cbq, com.tencent.mm.plugin.exdevice.j.b.bQ(fVar));
                    AppMethodBeat.o(19214);
                    return;
                case 4:
                    e.b(this.lst, this.mURL, 4, this.lsu);
                    ab.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device disconnected.(mac : %s)", str);
                    AppMethodBeat.o(19214);
                    return;
                default:
                    ab.d("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, out of range(mac : %s, state : %s, type : %s).", str, Integer.valueOf(i), Long.valueOf(j));
                    e.b(this.lst, this.mURL, -1, this.lsu);
                    AppMethodBeat.o(19214);
                    return;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.e$39 */
    class AnonymousClass39 implements com.tencent.mm.plugin.exdevice.model.i.a {
        final /* synthetic */ ed lss;

        AnonymousClass39(ed edVar) {
            this.lss = edVar;
        }

        public final void gM(boolean z) {
            AppMethodBeat.i(19198);
            if (z) {
                e.this.at(this.lss.cxE.op, this.lss.cxE.userName);
            }
            AppMethodBeat.o(19198);
        }
    }

    class c implements Runnable {
        List<com.tencent.mm.plugin.exdevice.h.b> foD;

        public c(List<com.tencent.mm.plugin.exdevice.h.b> list) {
            this.foD = list;
        }

        public final void run() {
            AppMethodBeat.i(19215);
            ab.i("MicroMsg.exdevice.ExdeviceEventManager", "Wifi device heart beat");
            if (this.foD != null && this.foD.size() > 0) {
                for (com.tencent.mm.plugin.exdevice.h.b bVar : this.foD) {
                    u.bpy().a(new com.tencent.mm.plugin.exdevice.i.k(bVar.field_brandName, bVar.field_deviceType, bVar.field_deviceID, 1));
                }
                e.this.mHandler.postDelayed(this, 300000);
            }
            AppMethodBeat.o(19215);
        }
    }

    public e() {
        AppMethodBeat.i(19216);
        HandlerThread anM = d.anM("wifi_device_heart_beat");
        anM.start();
        this.mHandler = new ak(anM.getLooper());
        AppMethodBeat.o(19216);
    }

    /* Access modifiers changed, original: final */
    public final boolean c(com.tencent.mm.sdk.b.b bVar) {
        AppMethodBeat.i(19217);
        dn dnVar = (dn) bVar;
        ab.i("MicroMsg.exdevice.ExdeviceEventManager", "ExDeviceGetLanDeviceInfosEvent: brandName=%s, context=%s", dnVar.cwP.cwz, dnVar.cwP.context);
        if (Ke(dnVar.cwP.cwz)) {
            LinkedList Kx = ad.boW().Kx(dnVar.cwP.cwz);
            JSONArray jSONArray = new JSONArray();
            try {
                Iterator it = Kx.iterator();
                while (it.hasNext()) {
                    com.tencent.mm.plugin.exdevice.h.b bVar2 = (com.tencent.mm.plugin.exdevice.h.b) it.next();
                    if (!Kx.isEmpty() && bo.nullAsNil(bVar2.field_connProto).contains("4")) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("deviceId", bVar2.field_deviceID);
                        if (this.lsm.Ki(bVar2.field_deviceID)) {
                            jSONObject.put("state", "connected");
                        } else {
                            jSONObject.put("state", "disconnected");
                        }
                        jSONArray.put(jSONObject);
                    }
                }
            } catch (Exception e) {
                ab.e("MicroMsg.exdevice.ExdeviceEventManager", "Ex in handleGetDeviceInfosEvent, %s", e.getMessage());
            }
            dnVar.cwQ.cwO = jSONArray;
            dnVar.cwQ.cwB = true;
            ab.i("MicroMsg.exdevice.ExdeviceEventManager", "GetDeviceInfos: %s", jSONArray.toString());
            AppMethodBeat.o(19217);
        } else {
            dnVar.cwQ.cwO = null;
            dnVar.cwQ.cwB = false;
            AppMethodBeat.o(19217);
        }
        return true;
    }

    static boolean i(String str, List<com.tencent.mm.plugin.exdevice.h.b> list) {
        AppMethodBeat.i(19218);
        String host = Uri.parse(str).getHost();
        ab.i("MicroMsg.exdevice.ExdeviceEventManager", "is url...");
        JSONArray jSONArray = null;
        boolean z = false;
        for (com.tencent.mm.plugin.exdevice.h.b bVar : list) {
            String str2 = bVar.dFr;
            String str3 = bVar.dFs;
            if (str3 != null && str3.length() > 0 && str2 != null && str2.contains("wxmsg_url")) {
                JSONArray jSONArray2;
                try {
                    jSONArray2 = new JSONObject(str3).getJSONArray("wxmsg_url");
                } catch (JSONException e) {
                    ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceEventManager", e, "", new Object[0]);
                    jSONArray2 = jSONArray;
                }
                int length = jSONArray2.length();
                int i = 0;
                while (i < length) {
                    try {
                        if (jSONArray2.getString(i).equals(host)) {
                            z = true;
                            break;
                        }
                        i++;
                    } catch (JSONException e2) {
                        ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceEventManager", e2, "", new Object[0]);
                    }
                }
                if (z) {
                    break;
                }
                jSONArray = jSONArray2;
            }
        }
        AppMethodBeat.o(19218);
        return z;
    }

    static boolean j(String str, List<com.tencent.mm.plugin.exdevice.h.b> list) {
        AppMethodBeat.i(19219);
        if (str == null) {
            AppMethodBeat.o(19219);
            return false;
        }
        boolean z;
        id idVar = new id();
        idVar.cDc.cwT = str;
        com.tencent.mm.sdk.b.a.xxA.m(idVar);
        TimeLineObject timeLineObject = idVar.cDd.cDe;
        int i = timeLineObject.xfI.wbJ;
        String str2;
        if (i == 1) {
            ab.i("MicroMsg.exdevice.ExdeviceEventManager", "is photo...");
            for (com.tencent.mm.plugin.exdevice.h.b bVar : list) {
                str2 = bVar.dFr;
                if (str2 != null && str2.contains("wxmsg_image")) {
                    z = true;
                    break;
                }
            }
            z = false;
        } else if (i == 4) {
            ab.i("MicroMsg.exdevice.ExdeviceEventManager", "is music...");
            for (com.tencent.mm.plugin.exdevice.h.b bVar2 : list) {
                str2 = bVar2.dFr;
                if (str2 != null && str2.contains("wxmsg_music")) {
                    z = true;
                    break;
                }
            }
            z = false;
        } else if (i == 15) {
            ab.i("MicroMsg.exdevice.ExdeviceEventManager", "is sight...");
            for (com.tencent.mm.plugin.exdevice.h.b bVar22 : list) {
                str2 = bVar22.dFr;
                if (str2 != null && str2.contains("wxmsg_video")) {
                    z = true;
                    break;
                }
            }
            z = false;
        } else {
            z = i == 3 ? i(timeLineObject.xfI.Url, list) : false;
        }
        ab.i("MicroMsg.exdevice.ExdeviceEventManager", "isSupportsSnsInfo = " + z + ", snsLocalId = " + str);
        AppMethodBeat.o(19219);
        return z;
    }

    static boolean d(com.tencent.mm.sdk.b.b bVar) {
        AppMethodBeat.i(19220);
        dm dmVar = (dm) bVar;
        ab.i("MicroMsg.exdevice.ExdeviceEventManager", "handleGetDeviceInfosEvent: brandName=%s, context=%s", dmVar.cwM.cwz, dmVar.cwM.context);
        LinkedList Kx = ad.boW().Kx(dmVar.cwM.cwz);
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator it = Kx.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.exdevice.h.b bVar2 = (com.tencent.mm.plugin.exdevice.h.b) it.next();
                if (!Kx.isEmpty()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("deviceId", bVar2.field_deviceID);
                    if (u.bpx().hR(bVar2.field_mac)) {
                        jSONObject.put("state", "connected");
                    } else {
                        jSONObject.put("state", "disconnected");
                    }
                    jSONArray.put(jSONObject);
                }
            }
        } catch (Exception e) {
            ab.e("MicroMsg.exdevice.ExdeviceEventManager", "Ex in handleGetDeviceInfosEvent, %s", e.getMessage());
        }
        dmVar.cwN.cwO = jSONArray;
        dmVar.cwN.cwB = true;
        ab.i("MicroMsg.exdevice.ExdeviceEventManager", "GetDeviceInfos: %s", jSONArray.toString());
        AppMethodBeat.o(19220);
        return true;
    }

    static boolean e(com.tencent.mm.sdk.b.b bVar) {
        AppMethodBeat.i(19221);
        eh ehVar = (eh) bVar;
        ab.i("MicroMsg.exdevice.ExdeviceEventManager", "handleSendDataToDeviceEvent: brandName=%s, deviceId=%s", ehVar.cxL.cwz, ehVar.cxL.ceI);
        if (bo.cb(ehVar.cxL.data)) {
            ehVar.cxM.cwB = false;
            AppMethodBeat.o(19221);
            return false;
        }
        com.tencent.mm.plugin.exdevice.h.b Kv = ad.boW().Kv(ehVar.cxL.ceI);
        if (Kv == null) {
            ab.e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo error");
            ehVar.cxM.cwB = false;
            AppMethodBeat.o(19221);
            return false;
        } else if (!u.bpx().hR(Kv.field_mac)) {
            ab.e("MicroMsg.exdevice.ExdeviceEventManager", "haven't connect");
            ehVar.cxM.cwB = false;
            AppMethodBeat.o(19221);
            return false;
        } else if (u.bpx().hX(Kv.field_mac)) {
            if (aa.boT().lsZ) {
                aa.boT().uK(a(Kv));
            }
            u.bpy().a(new com.tencent.mm.plugin.exdevice.i.g(ehVar.cxL.data, 10001, Kv.field_mac));
            ehVar.cxM.cwB = true;
            AppMethodBeat.o(19221);
            return true;
        } else {
            ab.e("MicroMsg.exdevice.ExdeviceEventManager", "haven't authed");
            ehVar.cxM.cwB = false;
            AppMethodBeat.o(19221);
            return false;
        }
    }

    static int a(com.tencent.mm.plugin.exdevice.h.b bVar) {
        AppMethodBeat.i(19222);
        int i = -1;
        if (bo.nullAsNil(bVar.field_connProto).contains("1")) {
            i = 1;
        } else if (bo.nullAsNil(bVar.field_connProto).contains(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
            i = 0;
        }
        AppMethodBeat.o(19222);
        return i;
    }

    /* Access modifiers changed, original: final */
    public final boolean f(com.tencent.mm.sdk.b.b bVar) {
        AppMethodBeat.i(19223);
        final dp dpVar = (dp) bVar;
        ab.i("MicroMsg.exdevice.ExdeviceEventManager", "handleGetTicketEvent: brandName=%s, deviceId=%s, type=%d", dpVar.cwX.cwz, dpVar.cwX.ceI, Integer.valueOf(dpVar.cwX.type));
        ajn ajn = new ajn();
        ajn.wpk = dpVar.cwX.type;
        ajn.wpl = 0;
        ajn.vKM = new asq();
        ajn.vKM.jBE = dpVar.cwX.ceI;
        ajn.vKM.vIk = dpVar.cwX.cwz;
        LinkedList linkedList = new LinkedList();
        linkedList.add(ajn);
        com.tencent.mm.ai.f anonymousClass36 = new com.tencent.mm.ai.f() {
            public final void onSceneEnd(int i, int i2, String str, m mVar) {
                AppMethodBeat.i(19195);
                if (mVar == null || mVar.getType() != 543) {
                    dpVar.cwY.cxa = true;
                    dpVar.cwY.cxb = null;
                    if (dpVar.callback != null) {
                        dpVar.callback.run();
                    }
                    AppMethodBeat.o(19195);
                    return;
                }
                aw.Rg().b(543, (com.tencent.mm.ai.f) this);
                if (i == 0 && i2 == 0) {
                    ajp ajp;
                    ab.i("MicroMsg.exdevice.ExdeviceEventManager", "getTicketSceneEndImpl errType = [%s], errCode = [%s]， errMsg = [%s]", Integer.valueOf(i), Integer.valueOf(i2), str);
                    z zVar = (z) mVar;
                    if (zVar.lty == null || zVar.lty.fsH.fsP == null) {
                        ajp = null;
                    } else {
                        ajp = (ajp) zVar.lty.fsH.fsP;
                    }
                    Iterator it = ajp.wpo.iterator();
                    Object obj = null;
                    while (it.hasNext()) {
                        ajq ajq = (ajq) it.next();
                        if (ajq != null) {
                            String str2 = null;
                            String str3 = null;
                            if (ajq.vKM != null) {
                                str2 = ajq.vKM.jBE;
                                str3 = ajq.vKM.vIk;
                            }
                            if (ajq.Ret != 0 || bo.isNullOrNil(ajq.wdB)) {
                                ab.e("MicroMsg.exdevice.ExdeviceEventManager", "deviceId(%s) get ticket fail. ret=%d, ticket=%s", str2, Integer.valueOf(ajq.Ret), ajq.wdB);
                            } else {
                                Object obj2;
                                ab.i("MicroMsg.exdevice.ExdeviceEventManager", "GetHardDeviceOperTicket end. deviceId=%s, deviceType=%s, ticket=%s, oper=%d", str2, str3, ajq.wdB, Integer.valueOf(ajq.wpk));
                                dpVar.cwY.cxa = true;
                                dpVar.cwY.cxb = ajq.wdB;
                                if (dpVar.callback != null) {
                                    dpVar.callback.run();
                                    obj2 = 1;
                                } else {
                                    obj2 = obj;
                                }
                                obj = obj2;
                            }
                        }
                    }
                    if (obj == null) {
                        dpVar.cwY.cxa = true;
                        dpVar.cwY.cxb = null;
                        if (dpVar.callback != null) {
                            dpVar.callback.run();
                        }
                    }
                    AppMethodBeat.o(19195);
                    return;
                }
                ab.e("MicroMsg.exdevice.ExdeviceEventManager", "getTicketSceneEndImpl errType = [%s], errCode = [%s]， errMsg = [%s]", Integer.valueOf(i), Integer.valueOf(i2), str);
                dpVar.cwY.cxa = true;
                dpVar.cwY.cxb = null;
                if (dpVar.callback != null) {
                    dpVar.callback.run();
                }
                AppMethodBeat.o(19195);
            }
        };
        m zVar = new z(linkedList, dpVar.cwX.cwz, dpVar.cwX.cwZ);
        aw.Rg().a(543, anonymousClass36);
        if (aw.Rg().a(zVar, 0)) {
            AppMethodBeat.o(19223);
            return false;
        }
        ab.e("MicroMsg.exdevice.ExdeviceEventManager", "MMCore.getNetSceneQueue().doScene failed!!!");
        aw.Rg().b(543, anonymousClass36);
        dpVar.cwY.cxa = true;
        dpVar.cwY.cxb = null;
        if (dpVar.callback != null) {
            dpVar.callback.run();
        }
        AppMethodBeat.o(19223);
        return true;
    }

    /* Access modifiers changed, original: final */
    public final boolean g(com.tencent.mm.sdk.b.b bVar) {
        AppMethodBeat.i(19224);
        ef efVar = (ef) bVar;
        ab.i("MicroMsg.exdevice.ExdeviceEventManager", "handleScanDeviceEvent: brandName=%s, op=%s, btVersion=%s", efVar.cxG.cwz, Boolean.valueOf(efVar.cxG.cwA), Integer.valueOf(efVar.cxG.cxI));
        int i = efVar.cxG.cxI;
        if (!(i == 0 || i == 1)) {
            if (com.tencent.mm.plugin.d.a.e.a.dv(ah.getContext())) {
                ab.w("MicroMsg.exdevice.ExdeviceEventManager", "invalid btVersion %s, use defalut BLE", Integer.valueOf(i));
                i = 0;
            } else {
                ab.e("MicroMsg.exdevice.ExdeviceEventManager", "invalid btVersion %s, return fail", Integer.valueOf(i));
                efVar.cxH.cwB = false;
                AppMethodBeat.o(19224);
                return false;
            }
        }
        if (efVar.cxG.cwA) {
            j boT = aa.boT();
            String str = efVar.cxG.cwz;
            AnonymousClass37 anonymousClass37 = new com.tencent.mm.plugin.exdevice.model.aa.a() {
                public final void a(String str, byte[] bArr, boolean z) {
                    AppMethodBeat.i(19196);
                    ab.i("MicroMsg.exdevice.ExdeviceEventManager", "OnScanDevice %s", str);
                    if (bArr == null) {
                        ab.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnScanDeviceResult. deviceId=%s, isCompleted=%s", str, Boolean.valueOf(z));
                    } else {
                        ab.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnScanDeviceResult. deviceId=%s, base64(broadcastData)=%s, isCompleted=%s", str, Base64.encodeToString(bArr, 0), Boolean.valueOf(z));
                    }
                    com.tencent.mm.sdk.b.b ecVar = new ec();
                    ecVar.cxD.cxv = bArr;
                    ecVar.cxD.ceI = str;
                    ecVar.cxD.bcU = z;
                    com.tencent.mm.sdk.b.a.xxA.a(ecVar, Looper.getMainLooper());
                    AppMethodBeat.o(19196);
                }
            };
            ab.i("MicroMsg.exdevice.ScanDeviceLogic", "startScanDevice, brandName=%s", str);
            if (bo.isNullOrNil(str)) {
                ab.i("MicroMsg.exdevice.ScanDeviceLogic", "brand name is null");
            } else {
                boT.lst = str;
                boT.ltN = anonymousClass37;
                boT.ltO.clear();
                Iterator it = boT.ltP.iterator();
                while (it.hasNext()) {
                    m mVar = (m) it.next();
                    if (mVar != null) {
                        aw.Rg().c(mVar);
                    }
                }
                boT.ltP.clear();
                synchronized (aa.cli) {
                    try {
                        aa.ltQ.clear();
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.o(19224);
                        }
                    }
                }
                if (boT.lsZ) {
                    ab.w("MicroMsg.exdevice.ScanDeviceLogic", "still scanning. just change brand name and callback");
                } else {
                    boT.lsZ = true;
                    aw.Rg().a(542, (com.tencent.mm.ai.f) boT);
                    ad.bpd().a(i, boT);
                    ab.i("MicroMsg.exdevice.ScanDeviceLogic", "should start scan, startTimer");
                    boT.gGo.ae(12000, 12000);
                }
            }
        } else {
            aa.boT().uK(i);
        }
        efVar.cxH.cwB = true;
        AppMethodBeat.o(19224);
        return true;
    }

    static boolean Ke(String str) {
        AppMethodBeat.i(19225);
        com.tencent.mm.aj.d qX = f.qX(str);
        if (qX == null) {
            ab.e("MicroMsg.exdevice.ExdeviceEventManager", "bizInfo is null");
            AppMethodBeat.o(19225);
            return false;
        }
        com.tencent.mm.aj.d.b cJ = qX.cJ(false);
        if (cJ == null || cJ.aej() == null || !cJ.aej().aes()) {
            ab.e("MicroMsg.exdevice.ExdeviceEventManager", "this is not hardware biz");
            AppMethodBeat.o(19225);
            return false;
        }
        AppMethodBeat.o(19225);
        return true;
    }

    static boolean a(com.tencent.mm.plugin.exdevice.h.b bVar, int i, int i2) {
        AppMethodBeat.i(19226);
        ab.i("MicroMsg.exdevice.ExdeviceEventManager", "handleSwitchViewEvent");
        if (bVar == null) {
            ab.i("MicroMsg.exdevice.ExdeviceEventManager", "HardDeviceInfo is null.");
            AppMethodBeat.o(19226);
            return false;
        }
        String str = bVar.field_brandName;
        com.tencent.mm.plugin.exdevice.service.f.a hT = u.bpx().hT(bVar.field_mac);
        if (hT == null) {
            ab.i("MicroMsg.exdevice.ExdeviceEventManager", "can not find the hardevice connect state");
            AppMethodBeat.o(19226);
            return false;
        }
        if (hT.cxs == 2) {
            ab.i("MicroMsg.exdevice.ExdeviceEventManager", "notify the connect device %s", str);
            u.bpy().a(new com.tencent.mm.plugin.exdevice.i.j(i, i2, bVar.field_mac));
        }
        ad.bpd().uI(i == 1 ? 1 : 0);
        if (i == 2) {
            ab.i("MicroMsg.exdevice.ExdeviceEventManager", "now exit chattingui, do not notify change the subtitle");
            ap apVar = (ap) ad.bpd().lre.remove(Long.valueOf(bVar.field_mac));
            if (apVar != null) {
                apVar.stopTimer();
            }
            ab.i("MicroMsg.exdevice.ExdeviceEventManager", "Device close strategy(%d)", Integer.valueOf(bVar.field_closeStrategy));
            if (!((bVar.field_closeStrategy & 1) == 0 && u.bpx().hX(hT.lwK) && (2 == hT.cxs || hT.cxs == 0))) {
                ab.i("MicroMsg.exdevice.ExdeviceEventManager", "now the device is not auth or not connect  or closeStrategy is to close after exit, try to stop connetct, connet state is %d, device is %s", Integer.valueOf(hT.cxs), str);
                if (u.bpy().lqX != null) {
                    u.bpy().lqX.hZ(hT.lwK);
                }
            }
            if (f.b(bVar)) {
                ab.i("MicroMsg.exdevice.ExdeviceEventManager", "try to disconnect simpleBTDevice(%s).", Long.valueOf(bVar.field_mac));
                Kf(com.tencent.mm.plugin.exdevice.j.b.ie(bVar.field_mac));
            }
            AppMethodBeat.o(19226);
            return true;
        } else if (2 == hT.cxs || com.tencent.mm.pluginsdk.p.e.vaw == null || !com.tencent.mm.pluginsdk.p.e.vaw.cUr()) {
            AppMethodBeat.o(19226);
            return true;
        } else {
            ab.i("MicroMsg.exdevice.ExdeviceEventManager", "getWearCommand is null or wear has connected in the brandName.");
            AppMethodBeat.o(19226);
            return false;
        }
    }

    /* Access modifiers changed, original: final */
    public final boolean k(List<com.tencent.mm.plugin.exdevice.h.b> list, int i) {
        AppMethodBeat.i(19227);
        ab.i("MicroMsg.exdevice.ExdeviceEventManager", "handleWifiDeviceSwitchViewEvent");
        if (list.size() == 0) {
            ab.i("MicroMsg.exdevice.ExdeviceEventManager", "HardDeviceInfo is null or nil.");
            AppMethodBeat.o(19227);
            return false;
        }
        int i2 = -1;
        switch (i) {
            case 1:
                if (this.lso) {
                    this.mHandler.removeCallbacks(this.lsp);
                }
                this.lsp = new c(list);
                this.mHandler.postDelayed(this.lsp, 300000);
                this.lso = true;
                i2 = 2;
                break;
            case 2:
                if (this.lso) {
                    this.mHandler.removeCallbacks(this.lsp);
                    this.lso = false;
                }
                i2 = 0;
                break;
        }
        for (com.tencent.mm.plugin.exdevice.h.b bVar : list) {
            u.bpy().a(new com.tencent.mm.plugin.exdevice.i.k(bVar.field_brandName, bVar.field_deviceType, bVar.field_deviceID, i2));
        }
        AppMethodBeat.o(19227);
        return true;
    }

    static boolean boG() {
        AppMethodBeat.i(19228);
        LinkedList bpC = ad.boW().bpC();
        if (bpC.isEmpty()) {
            ab.i("MicroMsg.exdevice.ExdeviceEventManager", "get harddevice info is null or empty");
            AppMethodBeat.o(19228);
            return false;
        }
        ad.bpd().uI(2);
        Iterator it = bpC.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.exdevice.h.b bVar = (com.tencent.mm.plugin.exdevice.h.b) it.next();
            aw.ZK();
            ad aoO = com.tencent.mm.model.c.XM().aoO(bVar.field_brandName);
            if (aoO == null || !com.tencent.mm.n.a.jh(aoO.field_type)) {
                ab.e("MicroMsg.exdevice.ExdeviceEventManager", "%s is not my contact now, may be has been deleted", bVar.field_brandName);
            } else if ((bVar.field_connStrategy & 4) == 0) {
                ab.i("MicroMsg.exdevice.ExdeviceEventManager", "Connect Strategy is %d, no need to sync in main ui", Integer.valueOf(bVar.field_connStrategy));
            } else {
                ab.i("MicroMsg.exdevice.ExdeviceEventManager", "now try to connect %s", bVar.field_brandName);
                ad.bpd().a(bVar.field_brandName, bVar.field_mac, 0, true);
            }
        }
        AppMethodBeat.o(19228);
        return true;
    }

    static boolean boH() {
        AppMethodBeat.i(19229);
        ab.i("MicroMsg.exdevice.ExdeviceEventManager", "receive StopAllChannelEvent");
        ad.bpd();
        d.gL(false);
        ad.bpd().boF();
        AppMethodBeat.o(19229);
        return true;
    }

    /* Access modifiers changed, original: final */
    public final boolean at(int i, String str) {
        AppMethodBeat.i(19230);
        ab.v("MicroMsg.exdevice.ExdeviceEventManager", "handleInChattingUI.");
        com.tencent.mm.aj.d qX = f.qX(str);
        if (qX == null) {
            ab.e("MicroMsg.exdevice.ExdeviceEventManager", "bizInfo is null");
            AppMethodBeat.o(19230);
            return false;
        }
        com.tencent.mm.aj.d.b cJ = qX.cJ(false);
        if (cJ != null) {
            com.tencent.mm.aj.d.b.b aej = cJ.aej();
            if (aej != null && aej.aes()) {
                LinkedList<com.tencent.mm.plugin.exdevice.h.b> Kx = ad.boW().Kx(str);
                if (aej.fvJ == 1) {
                    LinkedList<com.tencent.mm.plugin.exdevice.h.b> bpC = ad.boW().bpC();
                    if (bpC.size() != 0) {
                        for (com.tencent.mm.plugin.exdevice.h.b bVar : bpC) {
                            ab.i("MicroMsg.exdevice.ExdeviceEventManager", "BLE hard device info, mac(%s), deviceId(%s), deviceType(%s), SimpleProtol(%d)", Long.valueOf(bVar.field_mac), bVar.field_deviceID, bVar.field_deviceType, Long.valueOf(bVar.dFq));
                            if (0 != (bVar.dFq & 1)) {
                                Kx.add(bVar);
                            }
                        }
                    }
                }
                if (Kx == null) {
                    ab.i("MicroMsg.exdevice.ExdeviceEventManager", "handleInChattingUI, hdInfo is null.");
                    AppMethodBeat.o(19230);
                    return false;
                } else if (Kx.size() == 0) {
                    ab.i("MicroMsg.exdevice.ExdeviceEventManager", "handleInChattingUI, hdInfo size is 0.");
                    AppMethodBeat.o(19230);
                    return true;
                } else {
                    int i2 = 0;
                    int i3 = 0;
                    for (com.tencent.mm.plugin.exdevice.h.b bVar2 : Kx) {
                        if (bVar2 == null) {
                            ab.e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo error");
                        } else if (bo.nullAsNil(bVar2.field_connProto).contains("4")) {
                            ab.i("MicroMsg.exdevice.ExdeviceEventManager", "%s, Wifi biz, continue.", bVar2.field_brandName);
                        } else if ((bVar2.field_connStrategy & 16) != 0) {
                            ab.i("MicroMsg.exdevice.ExdeviceEventManager", "%s, Connect stragegy(%d) ignore connection on chat, continue!!!", bVar2.field_brandName, Integer.valueOf(bVar2.field_connStrategy));
                        } else {
                            int i4;
                            int i5;
                            int i6;
                            int i7;
                            if (bo.nullAsNil(bVar2.field_connProto).contains("1")) {
                                i7 = i2 + 1;
                                if (com.tencent.mm.plugin.d.a.e.a.aVF()) {
                                    i4 = 1;
                                    i5 = i3;
                                    i6 = i7;
                                } else {
                                    ab.e("MicroMsg.exdevice.ExdeviceEventManager", "%s, device is BC, but you phone not support BC.", bVar2.field_brandName);
                                    i2 = i7;
                                }
                            } else if (bo.nullAsNil(bVar2.field_connProto).contains(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                                i7 = i3 + 1;
                                if (com.tencent.mm.plugin.d.a.e.a.dv(ah.getContext())) {
                                    i4 = 0;
                                    i5 = i7;
                                    i6 = i2;
                                } else {
                                    ab.e("MicroMsg.exdevice.ExdeviceEventManager", "device is BLE, but you phone not support BLE.");
                                    i3 = i7;
                                }
                            } else {
                                i4 = -1;
                                i5 = i3;
                                i6 = i2;
                            }
                            ab.i("MicroMsg.exdevice.ExdeviceEventManager", "receive ExDeviceOpInChattingUIEventListener, op(%d), brandName(%s), connProto(%s),", Integer.valueOf(i), bVar2.field_brandName, bVar2.field_connProto);
                            if (i == 0) {
                                d bpd = ad.bpd();
                                long j = bVar2.field_mac;
                                ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "StopSyncTimer, device Id = %d", Long.valueOf(j));
                                if (bpd.lrf.containsKey(Long.valueOf(j))) {
                                    ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "Switch from main view to chatting view before exdevice sync timeout, just stop MTimerHandler");
                                    ap apVar = (ap) bpd.lrf.remove(Long.valueOf(j));
                                    if (apVar != null) {
                                        apVar.stopTimer();
                                    } else {
                                        ab.e("MicroMsg.exdevice.ExdeviceConnectManager", "Remove deviceId(%d) from syncTimeOutMap failed!!!", Long.valueOf(j));
                                    }
                                }
                                if (u.bpx().hR(bVar2.field_mac)) {
                                    ab.i("MicroMsg.exdevice.ExdeviceEventManager", "Enter chatting ui, find this deivce has been connected aready, device name = %s, device id = %d", bVar2.field_brandName, Long.valueOf(bVar2.field_mac));
                                    if (u.bpx().hX(bVar2.field_mac)) {
                                        ab.i("MicroMsg.exdevice.ExdeviceEventManager", "This device is auth aready");
                                        b(bVar2.field_brandName, bVar2.field_url, 2, bVar2.field_deviceID);
                                        i3 = i5;
                                        i2 = i6;
                                    } else {
                                        ab.i("MicroMsg.exdevice.ExdeviceEventManager", "This device has been connected but not auth yet.");
                                        i3 = i5;
                                        i2 = i6;
                                    }
                                } else if (!com.tencent.mm.plugin.exdevice.service.d.dI(ah.getContext())) {
                                    ab.e("MicroMsg.exdevice.ExdeviceEventManager", "service not running");
                                    i3 = i5;
                                    i2 = i6;
                                } else if (f.b(bVar2)) {
                                    ab.i("MicroMsg.exdevice.ExdeviceEventManager", "Connect simple device, mac(%s), brandName(%s)", com.tencent.mm.plugin.exdevice.j.b.ie(bVar2.field_mac), bVar2.field_brandName);
                                    a(bVar2.field_brandName + bVar2.field_mac, new a(bVar2.field_brandName, com.tencent.mm.plugin.exdevice.j.b.ie(bVar2.field_mac), bVar2.field_url, bVar2.field_deviceID));
                                    Kg(com.tencent.mm.plugin.exdevice.j.b.ie(bVar2.field_mac));
                                    i3 = i5;
                                    i2 = i6;
                                } else {
                                    ab.i("MicroMsg.exdevice.ExdeviceEventManager", "Connect AirSync device, mac(%s), brandName(%s)", com.tencent.mm.plugin.exdevice.j.b.ie(bVar2.field_mac), bVar2.field_brandName);
                                    ad.bpd().uI(1);
                                    ad.bpd().a(Long.valueOf(bVar2.field_mac), bVar2.field_connStrategy);
                                    ad.bpd().b(bVar2.field_brandName, bVar2.field_mac, i4);
                                    i3 = i5;
                                    i2 = i6;
                                }
                            } else if (i != 1) {
                                if (i == 2) {
                                    if (f.b(bVar2)) {
                                        Kf(com.tencent.mm.plugin.exdevice.j.b.ie(bVar2.field_mac));
                                        i3 = i5;
                                        i2 = i6;
                                    } else {
                                        ad.bpd();
                                        d.hH(bVar2.field_mac);
                                    }
                                }
                                i3 = i5;
                                i2 = i6;
                            } else if (f.b(bVar2)) {
                                a(bVar2.field_brandName + bVar2.field_mac, new a(bVar2.field_brandName, com.tencent.mm.plugin.exdevice.j.b.ie(bVar2.field_mac), bVar2.field_url, bVar2.field_deviceID));
                                Kg(com.tencent.mm.plugin.exdevice.j.b.ie(bVar2.field_mac));
                                i3 = i5;
                                i2 = i6;
                            } else {
                                ad.bpd().a(Long.valueOf(bVar2.field_mac), bVar2.field_connStrategy);
                                ad.bpd().b(bVar2.field_brandName, bVar2.field_mac, i4);
                                i3 = i5;
                                i2 = i6;
                            }
                        }
                    }
                    if (i2 + i3 <= 0) {
                        cc(str, -1);
                    } else if (!com.tencent.mm.plugin.d.a.e.a.aVH()) {
                        ab.w("MicroMsg.exdevice.ExdeviceEventManager", "System bluetooth is close");
                        cc(str, 0);
                    } else if (i3 > 0 && i2 == 0 && !com.tencent.mm.plugin.d.a.e.a.dv(ah.getContext())) {
                        cc(str, 1);
                    }
                    AppMethodBeat.o(19230);
                    return true;
                }
            }
        }
        ab.e("MicroMsg.exdevice.ExdeviceEventManager", "this is not hardware biz");
        AppMethodBeat.o(19230);
        return false;
    }

    private static boolean boI() {
        AppMethodBeat.i(19231);
        if (!com.tencent.mm.plugin.d.a.e.a.dv(ah.getContext())) {
            ab.e("MicroMsg.exdevice.ExdeviceEventManager", "now sdk version not support ble device : %d", Integer.valueOf(VERSION.SDK_INT));
            AppMethodBeat.o(19231);
            return false;
        } else if (com.tencent.mm.plugin.d.a.e.a.aVH()) {
            AppMethodBeat.o(19231);
            return true;
        } else {
            ab.e("MicroMsg.exdevice.ExdeviceEventManager", "Bluetooth is not open, Just leave");
            AppMethodBeat.o(19231);
            return false;
        }
    }

    public static boolean boJ() {
        AppMethodBeat.i(19232);
        ab.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTScanDevice");
        if (boI()) {
            ad.bpi().boM();
            AppMethodBeat.o(19232);
            return true;
        }
        ab.e("MicroMsg.exdevice.ExdeviceEventManager", "isBTOpenAndBLESupported return false");
        AppMethodBeat.o(19232);
        return false;
    }

    public static boolean Kf(String str) {
        AppMethodBeat.i(19233);
        ab.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTDisconnectDevice, mac(%s).", str);
        if (!boI()) {
            ab.e("MicroMsg.exdevice.ExdeviceEventManager", "isBTOpenAndBLESupported return false");
            AppMethodBeat.o(19233);
            return false;
        } else if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.exdevice.ExdeviceEventManager", "mac is null or nil");
            AppMethodBeat.o(19233);
            return false;
        } else {
            ad.bpi();
            h.hH(com.tencent.mm.plugin.exdevice.j.b.KK(str));
            AppMethodBeat.o(19233);
            return true;
        }
    }

    public final boolean Kg(String str) {
        AppMethodBeat.i(19234);
        ab.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTConnectDevice");
        if (!boI()) {
            ab.e("MicroMsg.exdevice.ExdeviceEventManager", "isBTOpenAndBLESupported return false");
            AppMethodBeat.o(19234);
            return false;
        } else if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.exdevice.ExdeviceEventManager", "mac is null or nil");
            AppMethodBeat.o(19234);
            return false;
        } else {
            ad.bpi().a(com.tencent.mm.plugin.exdevice.j.b.KK(str), new com.tencent.mm.plugin.exdevice.model.h.a() {
                public final void a(long j, int i, int i2, int i3, long j2) {
                    LinkedList<b> linkedList;
                    AppMethodBeat.i(19199);
                    ab.d("MicroMsg.exdevice.ExdeviceEventManager", "mac=%d, oldState=%d, newState=%d, errCode=%d, profileType=%d", Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2));
                    e eVar = e.this;
                    String ie = com.tencent.mm.plugin.exdevice.j.b.ie(j);
                    synchronized (eVar.lrw) {
                        try {
                            linkedList = new LinkedList(eVar.lrw);
                        } finally {
                            while (true) {
                            }
                            AppMethodBeat.o(19199);
                        }
                    }
                    for (b c : linkedList) {
                        c.c(ie, i2, j2);
                    }
                    linkedList.clear();
                    for (b c2 : eVar.lrx.values()) {
                        c2.c(ie, i2, j2);
                    }
                    com.tencent.mm.sdk.b.b epVar = new ep();
                    epVar.cyg.mac = ie;
                    epVar.cyg.cxs = i2;
                    epVar.cyg.cyd = j2;
                    com.tencent.mm.sdk.b.a.xxA.a(epVar, Looper.getMainLooper());
                }
            });
            AppMethodBeat.o(19234);
            return true;
        }
    }

    public final boolean u(String str, byte[] bArr) {
        AppMethodBeat.i(19235);
        String str2;
        String str3;
        Object[] objArr;
        if (bo.isNullOrNil(str) || bo.cb(bArr)) {
            str2 = "MicroMsg.exdevice.ExdeviceEventManager";
            str3 = "input error. mac = %s, dataLen = %d";
            objArr = new Object[2];
            objArr[0] = bo.isNullOrNil(str) ? BuildConfig.COMMAND : "mac";
            objArr[1] = Integer.valueOf(bo.cb(bArr) ? 0 : bArr.length);
            ab.e(str2, str3, objArr);
            AppMethodBeat.o(19235);
            return false;
        }
        str2 = "MicroMsg.exdevice.ExdeviceEventManager";
        str3 = "handleExDeviceSimpleBTSendDataToDevice. mac = %s, dataLen = %d";
        objArr = new Object[2];
        objArr[0] = bo.isNullOrNil(str) ? BuildConfig.COMMAND : str;
        objArr[1] = Integer.valueOf(bo.cb(bArr) ? 0 : bArr.length);
        ab.e(str2, str3, objArr);
        long KK = com.tencent.mm.plugin.exdevice.j.b.KK(str);
        com.tencent.mm.plugin.exdevice.service.f.a hU = ad.bpi().lta.hU(KK);
        if (hU == null) {
            ab.e("MicroMsg.exdevice.ExdeviceEventManager", "can not find the hardevice connect state");
            AppMethodBeat.o(19235);
            return false;
        } else if (hU.cxs != 2) {
            ab.e("MicroMsg.exdevice.ExdeviceEventManager", "device is not connected.");
            AppMethodBeat.o(19235);
            return false;
        } else {
            ad.bpi();
            boolean a = h.a(KK, bArr, new com.tencent.mm.plugin.exdevice.service.t.a() {
                public final void b(long j, int i, int i2, String str) {
                    boolean z;
                    AppMethodBeat.i(19200);
                    String str2 = "MicroMsg.exdevice.ExdeviceEventManager";
                    String str3 = "onSendEnd. mac=%d, errType=%d, errCode=%d, errMsg=%s";
                    Object[] objArr = new Object[4];
                    objArr[0] = Long.valueOf(j);
                    objArr[1] = Integer.valueOf(i);
                    objArr[2] = Integer.valueOf(i2);
                    if (str == null) {
                        str = BuildConfig.COMMAND;
                    }
                    objArr[3] = str;
                    ab.d(str2, str3, objArr);
                    e eVar = e.this;
                    String ie = com.tencent.mm.plugin.exdevice.j.b.ie(j);
                    if (i2 == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    ab.d("MicroMsg.exdevice.ExdeviceEventManager", "notifySimpleBTOnSend, mac : %s, isSucc : %s", ie, Boolean.valueOf(z));
                    if (!z) {
                        LinkedList<b> linkedList;
                        synchronized (eVar.lrw) {
                            try {
                                linkedList = new LinkedList(eVar.lrw);
                            } catch (Throwable th) {
                                while (true) {
                                    AppMethodBeat.o(19200);
                                }
                            }
                        }
                        for (b b : linkedList) {
                            b.b(ie, null, false);
                        }
                        linkedList.clear();
                        for (b b2 : eVar.lrx.values()) {
                            b2.b(ie, null, false);
                        }
                    }
                    AppMethodBeat.o(19200);
                }
            });
            AppMethodBeat.o(19235);
            return a;
        }
    }

    public static boolean c(String str, String str2, byte[] bArr) {
        AppMethodBeat.i(19236);
        String str3;
        String str4;
        Object[] objArr;
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2) || bo.cb(bArr)) {
            str3 = "MicroMsg.exdevice.ExdeviceEventManager";
            str4 = "input error. mac = %s, brandName = %s, dataLen = %d";
            objArr = new Object[3];
            if (bo.isNullOrNil(str)) {
                str = BuildConfig.COMMAND;
            }
            objArr[0] = str;
            if (bo.isNullOrNil(str2)) {
                str2 = BuildConfig.COMMAND;
            }
            objArr[1] = str2;
            objArr[2] = Integer.valueOf(bo.cb(bArr) ? 0 : bArr.length);
            ab.e(str3, str4, objArr);
            AppMethodBeat.o(19236);
            return false;
        }
        str3 = "MicroMsg.exdevice.ExdeviceEventManager";
        str4 = "handleExDeviceSimpleBTUploadDataToServer. mac = %s, brandName = %s, dataLen = %d";
        objArr = new Object[3];
        objArr[0] = bo.isNullOrNil(str) ? BuildConfig.COMMAND : str;
        objArr[1] = bo.isNullOrNil(str2) ? BuildConfig.COMMAND : str2;
        objArr[2] = Integer.valueOf(bo.cb(bArr) ? 0 : bArr.length);
        ab.d(str3, str4, objArr);
        com.tencent.mm.plugin.exdevice.h.b id = ad.boW().id(com.tencent.mm.plugin.exdevice.j.b.KK(str));
        if (id == null) {
            ab.e("MicroMsg.exdevice.ExdeviceEventManager", "device(mac=%s) not found in brand(brandName=%s)", str, str2);
            AppMethodBeat.o(19236);
            return false;
        }
        com.tencent.mm.plugin.d.a.b.a.a at = com.tencent.mm.plugin.d.a.b.a.a.at(bArr);
        if (1 != at.jGw) {
            ab.e("MicroMsg.exdevice.ExdeviceEventManager", "not step profile type %d != %d", Long.valueOf(1), Long.valueOf(at.jGw));
            AppMethodBeat.o(19236);
            return false;
        }
        com.tencent.mm.plugin.d.a.b.a.f fVar = (com.tencent.mm.plugin.d.a.b.a.f) at;
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        ((com.tencent.mm.plugin.sport.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.sport.a.b.class)).b(id.field_deviceID, id.field_deviceType, (int) (instance.getTimeInMillis() / 1000), (int) (System.currentTimeMillis() / 1000), fVar.jIh, "");
        AppMethodBeat.o(19236);
        return true;
    }

    public final void o(String str, String str2, boolean z) {
        LinkedList<b> linkedList;
        AppMethodBeat.i(19237);
        synchronized (this.lrw) {
            try {
                linkedList = new LinkedList(this.lrw);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(19237);
            }
        }
        for (b p : linkedList) {
            p.p(str, str2, z);
        }
        linkedList.clear();
        for (b p2 : this.lrx.values()) {
            p2.p(str, str2, z);
        }
        ab.d("MicroMsg.exdevice.ExdeviceEventManager", "simple BT on scan result: broadcastName=" + str + ", mac=" + str2 + ", isCompleted=" + z);
        com.tencent.mm.sdk.b.b erVar = new er();
        erVar.cyi.cyc = str;
        erVar.cyi.mac = str2;
        erVar.cyi.bcU = z;
        com.tencent.mm.sdk.b.a.xxA.a(erVar, Looper.getMainLooper());
    }

    public static void b(String str, String str2, int i, String str3) {
        AppMethodBeat.i(19238);
        com.tencent.mm.sdk.b.b lqVar = new lq();
        lqVar.cHu.op = 2;
        lqVar.cHu.cEN = str;
        lqVar.cHu.cxs = i;
        lqVar.cHu.url = str2;
        lqVar.cHu.ceI = str3;
        com.tencent.mm.sdk.b.a.xxA.a(lqVar, Looper.getMainLooper());
        AppMethodBeat.o(19238);
    }

    public static void cc(String str, int i) {
        AppMethodBeat.i(19239);
        com.tencent.mm.sdk.b.b lqVar = new lq();
        lqVar.cHu.op = 1;
        lqVar.cHu.cEN = str;
        lqVar.cHu.boZ = i;
        com.tencent.mm.sdk.b.a.xxA.a(lqVar, Looper.getMainLooper());
        AppMethodBeat.o(19239);
    }

    public static void d(String str, String str2, byte[] bArr) {
        AppMethodBeat.i(19240);
        ab.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnRecvDataFromDevice. deviceId=%s, brandName=%s", str, str2);
        com.tencent.mm.sdk.b.b ebVar = new eb();
        ebVar.cxC.ceI = str;
        ebVar.cxC.cwz = str2;
        ebVar.cxC.data = bArr;
        com.tencent.mm.sdk.b.a.xxA.a(ebVar, Looper.getMainLooper());
        AppMethodBeat.o(19240);
    }

    public static void aw(String str, boolean z) {
        AppMethodBeat.i(19241);
        ab.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnDeviceBindStateChange. deviceId=%s, isBound=%s", str, Boolean.valueOf(z));
        com.tencent.mm.sdk.b.b eaVar = new ea();
        eaVar.cxB.ceI = str;
        eaVar.cxB.cww = z;
        com.tencent.mm.sdk.b.a.xxA.a(eaVar, Looper.getMainLooper());
        AppMethodBeat.o(19241);
    }

    public final boolean a(b bVar) {
        AppMethodBeat.i(19242);
        if (this.lrw.contains(bVar)) {
            AppMethodBeat.o(19242);
            return false;
        }
        boolean add = this.lrw.add(bVar);
        AppMethodBeat.o(19242);
        return add;
    }

    public final boolean b(b bVar) {
        AppMethodBeat.i(19243);
        if (this.lrw.remove(bVar)) {
            AppMethodBeat.o(19243);
            return true;
        }
        AppMethodBeat.o(19243);
        return false;
    }

    private b a(String str, b bVar) {
        AppMethodBeat.i(19244);
        b bVar2 = (b) this.lrx.put(str, bVar);
        AppMethodBeat.o(19244);
        return bVar2;
    }

    static boolean boK() {
        AppMethodBeat.i(19245);
        ab.i("MicroMsg.exdevice.ExdeviceEventManager", "Wechat exit, stop ExDeviceService.");
        Context context = ah.getContext();
        try {
            ad.bpd().boF();
        } catch (Exception e) {
            ab.w("MicroMsg.exdevice.ExDeviceServiceHelper", "unbindService() Service is not start by bindService.%s", e.getMessage());
            ab.printErrStackTrace("MicroMsg.exdevice.ExDeviceServiceHelper", e, "", new Object[0]);
        }
        com.tencent.mm.bp.d.l(new Intent(context, ExDeviceService.class), "exdevice");
        AppMethodBeat.o(19245);
        return true;
    }
}
