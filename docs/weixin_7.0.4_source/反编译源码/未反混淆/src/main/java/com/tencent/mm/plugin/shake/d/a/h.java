package com.tencent.mm.plugin.shake.d.a;

import android.bluetooth.BluetoothAdapter;
import android.location.LocationManager;
import android.os.Build.VERSION;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.shake.b.e;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.protocal.protobuf.aty;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class h extends b implements f {
    public static int qtP = 3;
    private float ecs = -85.0f;
    private float ect = -1000.0f;
    private com.tencent.mm.modelgeo.b.a ecy = new com.tencent.mm.modelgeo.b.a() {
        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            AppMethodBeat.i(24619);
            if (z) {
                h.this.ecs = f2;
                h.this.ect = f;
                h.this.qfw = (int) d2;
                AppMethodBeat.o(24619);
                return false;
            }
            AppMethodBeat.o(24619);
            return true;
        }
    };
    private d fwu;
    private int qfw = -1000;
    private d qtK;
    public Collection<a> qtL = null;
    private int qtM = 10001;
    private int qtN = 10002;
    private int qtO = 10003;

    public static final class a {
        public String eCq = null;
        public double fNN = 0.0d;
        public int major = 0;
        public int minor = 0;
        public String qtR = "";
        public double qtS = 0.0d;
        public int qtT = 0;
    }

    public h(com.tencent.mm.plugin.shake.b.l.a aVar) {
        super(aVar);
        AppMethodBeat.i(24623);
        AppMethodBeat.o(24623);
    }

    public final void init() {
        AppMethodBeat.i(24624);
        aw.Rg().a(658, (f) this);
        cjv();
        AppMethodBeat.o(24624);
    }

    public final void reset() {
        AppMethodBeat.i(24625);
        if (this.qtK != null) {
            aw.Rg().c(this.qtK);
        }
        AppMethodBeat.o(24625);
    }

    public final void start() {
        AppMethodBeat.i(24626);
        ab.i("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb]:start");
        init();
        reset();
        if (this.fwu == null) {
            cjv();
        }
        this.fwu.b(this.ecy, true);
        if (!(VERSION.RELEASE.equals("6.0") || VERSION.RELEASE.equals("6.0.0") || VERSION.SDK_INT < 23)) {
            boolean isProviderEnabled;
            LocationManager locationManager = (LocationManager) ah.getContext().getSystemService(FirebaseAnalytics.b.LOCATION);
            if (locationManager != null) {
                isProviderEnabled = locationManager.isProviderEnabled("gps");
            } else {
                isProviderEnabled = true;
            }
            if (!isProviderEnabled) {
                new ak().postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(24620);
                        h.this.qrT.b(null, 8);
                        AppMethodBeat.o(24620);
                    }
                }, 1000);
                AppMethodBeat.o(24626);
                return;
            }
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null && defaultAdapter.getState() != 12) {
            new ak().postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(24621);
                    h.this.qrT.b(null, 9);
                    AppMethodBeat.o(24621);
                }
            }, 1000);
            AppMethodBeat.o(24626);
        } else if (defaultAdapter == null) {
            new ak().postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(24622);
                    h.this.qrT.b(null, 10);
                    AppMethodBeat.o(24622);
                }
            }, 1000);
            AppMethodBeat.o(24626);
        } else {
            int size;
            String str = "MicroMsg.ShakeIbeaconService";
            String str2 = "[oneliang][ShakeIbeaconService][shakezb]:beaconCollection.size:%d";
            Object[] objArr = new Object[1];
            if (this.qtL != null) {
                size = this.qtL.size();
            } else {
                size = 0;
            }
            objArr[0] = Integer.valueOf(size);
            ab.i(str, str2, objArr);
            this.qtK = new d(this.qtL, this.ecs, this.ect, this.qfw);
            aw.Rg().a(this.qtK, 0);
            AppMethodBeat.o(24626);
        }
    }

    private void cjv() {
        AppMethodBeat.i(24629);
        this.fwu = d.agz();
        this.fwu.a(this.ecy, true);
        AppMethodBeat.o(24629);
    }

    public final void cjw() {
        AppMethodBeat.i(24630);
        super.cjw();
        aw.Rg().b(658, (f) this);
        AppMethodBeat.o(24630);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(24631);
        ab.i("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService]onSceneEnd :netId:%s,errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(mVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str);
        if (i == 0 && i2 == 0) {
            d dVar = (d) mVar;
            if (658 == mVar.getType() && dVar.action == 1) {
                aty aty = (aty) dVar.fAT.fsH.fsP;
                if (aty.wxY.vYu == 0) {
                    ab.i("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb]onSceneEnd :message:%s,tips:%s,result:%s", aty.wxY.mZR, aty.wxY.phA, Integer.valueOf(aty.wxY.vYu));
                    try {
                        JSONObject jSONObject = new JSONObject(aty.wxY.mZR);
                        JSONArray jSONArray = jSONObject.getJSONArray("msgs");
                        JSONObject jSONObject2 = jSONObject.getJSONObject("guide_switch");
                        int i3 = jSONObject2.getInt("channel_open_method");
                        long j = jSONObject2.getLong("channel_open_time");
                        int i4 = jSONObject2.getInt("shake_tab_display");
                        int i5 = jSONObject.getJSONObject("gated_launch_option").getInt("tab_state");
                        aw.ZK();
                        c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_IBEACON_PUSH_CHANNEL_OPEN_METHOD_INT, Integer.valueOf(i3));
                        aw.ZK();
                        c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_IBEACON_PUSH_CHANNEL_OPEN_TIME_LONG, Long.valueOf(j));
                        aw.ZK();
                        c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_IBEACON_SHAKE_TAB_DISPLAY_INT, Integer.valueOf(i4));
                        aw.ZK();
                        c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_IBEACON_SHAKE_TAB_IS_UIN_RESIDENT_INT, Integer.valueOf(i5));
                        ab.i("MicroMsg.ShakeIbeaconService", "[shakezb]channel_open_method is " + i3 + " ,channel_open_time is " + j + ", shake_tab_display is " + i4);
                        int length = jSONArray.length();
                        List list = null;
                        e cjS = com.tencent.mm.plugin.shake.b.m.cjS();
                        cjS.cjI();
                        if (length > 0) {
                            list = new ArrayList();
                            for (i5 = 0; i5 < length; i5++) {
                                com.tencent.mm.plugin.shake.b.d dVar2 = new com.tencent.mm.plugin.shake.b.d();
                                JSONObject jSONObject3 = jSONArray.getJSONObject(i5);
                                String string = jSONObject3.getString("url");
                                String string2 = jSONObject3.getString(FirebaseAnalytics.b.CONTENT);
                                String string3 = jSONObject3.getString("title");
                                String string4 = jSONObject3.getString("picurl");
                                String string5 = jSONObject3.getString("shopid");
                                JSONObject jSONObject4 = jSONObject3.getJSONObject("beacon");
                                String string6 = jSONObject4.getString("uuid");
                                String string7 = jSONObject4.getString("major");
                                String string8 = jSONObject4.getString("minor");
                                int i6 = jSONObject3.getInt("guide_state");
                                String string9 = jSONObject3.getString("wxa_username");
                                String string10 = jSONObject3.getString("wxa_path");
                                int i7 = jSONObject3.getInt("wxa_version_type");
                                dVar2.field_type = 11;
                                dVar2.field_username = string3;
                                dVar2.field_nickname = string3;
                                dVar2.field_signature = string2;
                                dVar2.field_province = string4;
                                dVar2.field_city = string;
                                if (i6 == 1) {
                                    dVar2.field_sex = qtP;
                                }
                                dVar2.field_lvbuffer = (String.valueOf(string5) + "," + String.valueOf(string6) + "," + String.valueOf(string7) + "," + String.valueOf(string8)).getBytes(ProtocolPackage.ServerEncoding);
                                dVar2.field_insertBatch = 2;
                                dVar2.field_reserved3 = string9 + "," + string10 + "," + i7;
                                list.add(dVar2);
                                cjS.a(dVar2, true);
                                if (dVar2.field_sex == qtP && i3 == 1) {
                                    a(dVar2);
                                }
                            }
                        }
                        this.qrT.b(list, 1);
                        AppMethodBeat.o(24631);
                        return;
                    } catch (Exception e) {
                        ab.e("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb] parse error.%s", bo.nullAsNil(e.getMessage()));
                        this.qrT.b(null, 1);
                        AppMethodBeat.o(24631);
                        return;
                    }
                } else if (aty.wxY.vYu == this.qtM) {
                    this.qrT.b(null, 6);
                    AppMethodBeat.o(24631);
                    return;
                } else if (aty.wxY.vYu == this.qtN) {
                    this.qrT.b(null, 7);
                    AppMethodBeat.o(24631);
                    return;
                } else if (aty.wxY.vYu == this.qtO) {
                    this.qrT.b(null, 8);
                    AppMethodBeat.o(24631);
                    return;
                } else {
                    this.qrT.b(null, 1);
                }
            }
            AppMethodBeat.o(24631);
            return;
        }
        this.qrT.b(null, 3);
        AppMethodBeat.o(24631);
    }

    public static void a(com.tencent.mm.plugin.shake.b.d dVar) {
        AppMethodBeat.i(24632);
        if (dVar != null && dVar.field_sex == qtP) {
            String str;
            aw.ZK();
            c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, Boolean.TRUE);
            long anT = bo.anT();
            aw.ZK();
            c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_IBEACON_PUSH_OPEN_TIEMSTAMP_LONG, Long.valueOf(anT));
            try {
                str = new String(dVar.field_lvbuffer, ProtocolPackage.ServerEncoding);
            } catch (UnsupportedEncodingException e) {
                ab.printErrStackTrace("MicroMsg.ShakeIbeaconService", e, "%s", "Unsupported");
                str = null;
            }
            if (str != null) {
                String[] split = str.split(",");
                if (split.length == 4) {
                    aw.ZK();
                    c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_IBEACON_PUSH_SHOP_ID_LONG, Long.valueOf(split[0]));
                }
            }
        }
        AppMethodBeat.o(24632);
    }

    public static void b(com.tencent.mm.plugin.shake.b.d dVar) {
        AppMethodBeat.i(24633);
        if (dVar != null) {
            String str;
            try {
                str = new String(dVar.field_lvbuffer, ProtocolPackage.ServerEncoding);
            } catch (UnsupportedEncodingException e) {
                ab.printErrStackTrace("MicroMsg.ShakeIbeaconService", e, "%s", "Unsupported");
                str = null;
            }
            if (str != null) {
                String[] split = str.split(",");
                if (split.length == 4) {
                    String str2 = split[1];
                    String str3 = split[2];
                    str = split[3];
                    a aVar = new a();
                    aVar.eCq = str2;
                    aVar.major = bo.getInt(str3, 0);
                    aVar.minor = bo.getInt(str, 0);
                }
            }
        }
        AppMethodBeat.o(24633);
    }

    public final void pause() {
        AppMethodBeat.i(24627);
        if (this.fwu != null) {
            this.fwu.c(this.ecy);
        }
        AppMethodBeat.o(24627);
    }

    public final void resume() {
        AppMethodBeat.i(24628);
        if (this.fwu != null) {
            this.fwu.a(this.ecy, true);
        }
        AppMethodBeat.o(24628);
    }
}
