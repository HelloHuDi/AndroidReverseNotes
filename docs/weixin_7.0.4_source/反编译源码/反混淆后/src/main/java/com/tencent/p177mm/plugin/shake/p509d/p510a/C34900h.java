package com.tencent.p177mm.plugin.shake.p509d.p510a;

import android.bluetooth.BluetoothAdapter;
import android.location.LocationManager;
import android.os.Build.VERSION;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelgeo.C26443d;
import com.tencent.p177mm.modelgeo.C42207b.C42206a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.shake.p1019b.C13247e;
import com.tencent.p177mm.plugin.shake.p1019b.C28987m;
import com.tencent.p177mm.plugin.shake.p1019b.C34894d;
import com.tencent.p177mm.plugin.shake.p1019b.C39691l.C21826a;
import com.tencent.p177mm.plugin.shake.p1019b.C39691l.C21828b;
import com.tencent.p177mm.protocal.protobuf.aty;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.shake.d.a.h */
public final class C34900h extends C21828b implements C1202f {
    public static int qtP = 3;
    private float ecs = -85.0f;
    private float ect = -1000.0f;
    private C42206a ecy = new C349011();
    private C26443d fwu;
    private int qfw = -1000;
    private C13260d qtK;
    public Collection<C3825a> qtL = null;
    private int qtM = 10001;
    private int qtN = 10002;
    private int qtO = 10003;

    /* renamed from: com.tencent.mm.plugin.shake.d.a.h$a */
    public static final class C3825a {
        public String eCq = null;
        public double fNN = 0.0d;
        public int major = 0;
        public int minor = 0;
        public String qtR = "";
        public double qtS = 0.0d;
        public int qtT = 0;
    }

    /* renamed from: com.tencent.mm.plugin.shake.d.a.h$3 */
    class C348993 implements Runnable {
        C348993() {
        }

        public final void run() {
            AppMethodBeat.m2504i(24621);
            C34900h.this.qrT.mo25340b(null, 9);
            AppMethodBeat.m2505o(24621);
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.d.a.h$1 */
    class C349011 implements C42206a {
        C349011() {
        }

        /* renamed from: a */
        public final boolean mo5861a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            AppMethodBeat.m2504i(24619);
            if (z) {
                C34900h.this.ecs = f2;
                C34900h.this.ect = f;
                C34900h.this.qfw = (int) d2;
                AppMethodBeat.m2505o(24619);
                return false;
            }
            AppMethodBeat.m2505o(24619);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.d.a.h$2 */
    class C349022 implements Runnable {
        C349022() {
        }

        public final void run() {
            AppMethodBeat.m2504i(24620);
            C34900h.this.qrT.mo25340b(null, 8);
            AppMethodBeat.m2505o(24620);
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.d.a.h$4 */
    class C349034 implements Runnable {
        C349034() {
        }

        public final void run() {
            AppMethodBeat.m2504i(24622);
            C34900h.this.qrT.mo25340b(null, 10);
            AppMethodBeat.m2505o(24622);
        }
    }

    public C34900h(C21826a c21826a) {
        super(c21826a);
        AppMethodBeat.m2504i(24623);
        AppMethodBeat.m2505o(24623);
    }

    public final void init() {
        AppMethodBeat.m2504i(24624);
        C9638aw.m17182Rg().mo14539a(658, (C1202f) this);
        cjv();
        AppMethodBeat.m2505o(24624);
    }

    public final void reset() {
        AppMethodBeat.m2504i(24625);
        if (this.qtK != null) {
            C9638aw.m17182Rg().mo14547c(this.qtK);
        }
        AppMethodBeat.m2505o(24625);
    }

    public final void start() {
        AppMethodBeat.m2504i(24626);
        C4990ab.m7416i("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb]:start");
        init();
        reset();
        if (this.fwu == null) {
            cjv();
        }
        this.fwu.mo44207b(this.ecy, true);
        if (!(VERSION.RELEASE.equals("6.0") || VERSION.RELEASE.equals("6.0.0") || VERSION.SDK_INT < 23)) {
            boolean isProviderEnabled;
            LocationManager locationManager = (LocationManager) C4996ah.getContext().getSystemService(C8741b.LOCATION);
            if (locationManager != null) {
                isProviderEnabled = locationManager.isProviderEnabled("gps");
            } else {
                isProviderEnabled = true;
            }
            if (!isProviderEnabled) {
                new C7306ak().postDelayed(new C349022(), 1000);
                AppMethodBeat.m2505o(24626);
                return;
            }
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null && defaultAdapter.getState() != 12) {
            new C7306ak().postDelayed(new C348993(), 1000);
            AppMethodBeat.m2505o(24626);
        } else if (defaultAdapter == null) {
            new C7306ak().postDelayed(new C349034(), 1000);
            AppMethodBeat.m2505o(24626);
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
            C4990ab.m7417i(str, str2, objArr);
            this.qtK = new C13260d(this.qtL, this.ecs, this.ect, this.qfw);
            C9638aw.m17182Rg().mo14541a(this.qtK, 0);
            AppMethodBeat.m2505o(24626);
        }
    }

    private void cjv() {
        AppMethodBeat.m2504i(24629);
        this.fwu = C26443d.agz();
        this.fwu.mo44204a(this.ecy, true);
        AppMethodBeat.m2505o(24629);
    }

    public final void cjw() {
        AppMethodBeat.m2504i(24630);
        super.cjw();
        C9638aw.m17182Rg().mo14546b(658, (C1202f) this);
        AppMethodBeat.m2505o(24630);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(24631);
        C4990ab.m7417i("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService]onSceneEnd :netId:%s,errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(c1207m.getType()), Integer.valueOf(i), Integer.valueOf(i2), str);
        if (i == 0 && i2 == 0) {
            C13260d c13260d = (C13260d) c1207m;
            if (658 == c1207m.getType() && c13260d.action == 1) {
                aty aty = (aty) c13260d.fAT.fsH.fsP;
                if (aty.wxY.vYu == 0) {
                    C4990ab.m7417i("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb]onSceneEnd :message:%s,tips:%s,result:%s", aty.wxY.mZR, aty.wxY.phA, Integer.valueOf(aty.wxY.vYu));
                    try {
                        JSONObject jSONObject = new JSONObject(aty.wxY.mZR);
                        JSONArray jSONArray = jSONObject.getJSONArray("msgs");
                        JSONObject jSONObject2 = jSONObject.getJSONObject("guide_switch");
                        int i3 = jSONObject2.getInt("channel_open_method");
                        long j = jSONObject2.getLong("channel_open_time");
                        int i4 = jSONObject2.getInt("shake_tab_display");
                        int i5 = jSONObject.getJSONObject("gated_launch_option").getInt("tab_state");
                        C9638aw.m17190ZK();
                        C18628c.m29072Ry().set(C5127a.USERINFO_IBEACON_PUSH_CHANNEL_OPEN_METHOD_INT, Integer.valueOf(i3));
                        C9638aw.m17190ZK();
                        C18628c.m29072Ry().set(C5127a.USERINFO_IBEACON_PUSH_CHANNEL_OPEN_TIME_LONG, Long.valueOf(j));
                        C9638aw.m17190ZK();
                        C18628c.m29072Ry().set(C5127a.USERINFO_IBEACON_SHAKE_TAB_DISPLAY_INT, Integer.valueOf(i4));
                        C9638aw.m17190ZK();
                        C18628c.m29072Ry().set(C5127a.USERINFO_IBEACON_SHAKE_TAB_IS_UIN_RESIDENT_INT, Integer.valueOf(i5));
                        C4990ab.m7416i("MicroMsg.ShakeIbeaconService", "[shakezb]channel_open_method is " + i3 + " ,channel_open_time is " + j + ", shake_tab_display is " + i4);
                        int length = jSONArray.length();
                        List list = null;
                        C13247e cjS = C28987m.cjS();
                        cjS.cjI();
                        if (length > 0) {
                            list = new ArrayList();
                            for (i5 = 0; i5 < length; i5++) {
                                C34894d c34894d = new C34894d();
                                JSONObject jSONObject3 = jSONArray.getJSONObject(i5);
                                String string = jSONObject3.getString("url");
                                String string2 = jSONObject3.getString(C8741b.CONTENT);
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
                                c34894d.field_type = 11;
                                c34894d.field_username = string3;
                                c34894d.field_nickname = string3;
                                c34894d.field_signature = string2;
                                c34894d.field_province = string4;
                                c34894d.field_city = string;
                                if (i6 == 1) {
                                    c34894d.field_sex = qtP;
                                }
                                c34894d.field_lvbuffer = (String.valueOf(string5) + "," + String.valueOf(string6) + "," + String.valueOf(string7) + "," + String.valueOf(string8)).getBytes(ProtocolPackage.ServerEncoding);
                                c34894d.field_insertBatch = 2;
                                c34894d.field_reserved3 = string9 + "," + string10 + "," + i7;
                                list.add(c34894d);
                                cjS.mo25304a(c34894d, true);
                                if (c34894d.field_sex == qtP && i3 == 1) {
                                    C34900h.m57313a(c34894d);
                                }
                            }
                        }
                        this.qrT.mo25340b(list, 1);
                        AppMethodBeat.m2505o(24631);
                        return;
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb] parse error.%s", C5046bo.nullAsNil(e.getMessage()));
                        this.qrT.mo25340b(null, 1);
                        AppMethodBeat.m2505o(24631);
                        return;
                    }
                } else if (aty.wxY.vYu == this.qtM) {
                    this.qrT.mo25340b(null, 6);
                    AppMethodBeat.m2505o(24631);
                    return;
                } else if (aty.wxY.vYu == this.qtN) {
                    this.qrT.mo25340b(null, 7);
                    AppMethodBeat.m2505o(24631);
                    return;
                } else if (aty.wxY.vYu == this.qtO) {
                    this.qrT.mo25340b(null, 8);
                    AppMethodBeat.m2505o(24631);
                    return;
                } else {
                    this.qrT.mo25340b(null, 1);
                }
            }
            AppMethodBeat.m2505o(24631);
            return;
        }
        this.qrT.mo25340b(null, 3);
        AppMethodBeat.m2505o(24631);
    }

    /* renamed from: a */
    public static void m57313a(C34894d c34894d) {
        AppMethodBeat.m2504i(24632);
        if (c34894d != null && c34894d.field_sex == qtP) {
            String str;
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(C5127a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, Boolean.TRUE);
            long anT = C5046bo.anT();
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(C5127a.USERINFO_IBEACON_PUSH_OPEN_TIEMSTAMP_LONG, Long.valueOf(anT));
            try {
                str = new String(c34894d.field_lvbuffer, ProtocolPackage.ServerEncoding);
            } catch (UnsupportedEncodingException e) {
                C4990ab.printErrStackTrace("MicroMsg.ShakeIbeaconService", e, "%s", "Unsupported");
                str = null;
            }
            if (str != null) {
                String[] split = str.split(",");
                if (split.length == 4) {
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(C5127a.USERINFO_IBEACON_PUSH_SHOP_ID_LONG, Long.valueOf(split[0]));
                }
            }
        }
        AppMethodBeat.m2505o(24632);
    }

    /* renamed from: b */
    public static void m57316b(C34894d c34894d) {
        AppMethodBeat.m2504i(24633);
        if (c34894d != null) {
            String str;
            try {
                str = new String(c34894d.field_lvbuffer, ProtocolPackage.ServerEncoding);
            } catch (UnsupportedEncodingException e) {
                C4990ab.printErrStackTrace("MicroMsg.ShakeIbeaconService", e, "%s", "Unsupported");
                str = null;
            }
            if (str != null) {
                String[] split = str.split(",");
                if (split.length == 4) {
                    String str2 = split[1];
                    String str3 = split[2];
                    str = split[3];
                    C3825a c3825a = new C3825a();
                    c3825a.eCq = str2;
                    c3825a.major = C5046bo.getInt(str3, 0);
                    c3825a.minor = C5046bo.getInt(str, 0);
                }
            }
        }
        AppMethodBeat.m2505o(24633);
    }

    public final void pause() {
        AppMethodBeat.m2504i(24627);
        if (this.fwu != null) {
            this.fwu.mo44208c(this.ecy);
        }
        AppMethodBeat.m2505o(24627);
    }

    public final void resume() {
        AppMethodBeat.m2504i(24628);
        if (this.fwu != null) {
            this.fwu.mo44204a(this.ecy, true);
        }
        AppMethodBeat.m2505o(24628);
    }
}
