package com.tencent.p177mm.plugin.exdevice.model;

import android.content.SharedPreferences;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p1597a.C41933a;
import com.tencent.p177mm.compatible.p1597a.C41933a.C41932a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C45439bw;
import com.tencent.p177mm.model.C6673bz.C1837a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.C25815a;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C26114dk;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.exdevice.p390f.p391a.C20473h;
import com.tencent.p177mm.plugin.exdevice.p390f.p391a.C34022c;
import com.tencent.p177mm.plugin.exdevice.p390f.p954b.C38938a;
import com.tencent.p177mm.plugin.exdevice.p390f.p954b.C42989c;
import com.tencent.p177mm.plugin.exdevice.p390f.p954b.p1256b.C20474e;
import com.tencent.p177mm.plugin.exdevice.p390f.p954b.p1256b.C34030a;
import com.tencent.p177mm.plugin.exdevice.p390f.p954b.p1256b.C34031c;
import com.tencent.p177mm.plugin.exdevice.p390f.p954b.p1256b.C38939b;
import com.tencent.p177mm.plugin.exdevice.p390f.p954b.p1256b.C45882d;
import com.tencent.p177mm.plugin.exdevice.p952b.C11635k;
import com.tencent.p177mm.plugin.exdevice.p952b.C11635k.C11636c;
import com.tencent.p177mm.plugin.exdevice.p956h.C11648b;
import com.tencent.p177mm.plugin.exdevice.p956h.C27837c;
import com.tencent.p177mm.plugin.exdevice.p957i.C27839g;
import com.tencent.p177mm.plugin.exdevice.service.C20548u;
import com.tencent.p177mm.plugin.exdevice.service.C27859f;
import com.tencent.p177mm.plugin.exdevice.service.C27859f.C27860a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.ttpic.FilterEnum4Shaka;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.exdevice.model.ad */
public final class C45891ad implements C1816at {
    private static HashMap<Integer, C1366d> eaA;
    private C27845ab lui = new C27845ab();
    private C38951b luj;
    private C27837c luk;
    private C45882d lul;
    private C34030a lum;
    private C38939b lun;
    private C20474e luo;
    private C20495e lup;
    private C2971d luq;
    private C42989c lur;
    private C38938a lus;
    private C34022c lut;
    private C25815a luu = null;
    private C25814c luv = null;
    private C45892af luw;
    private C46907h lux;
    private C1837a luy = new C458908();
    C4937b luz = new C389489();

    /* renamed from: com.tencent.mm.plugin.exdevice.model.ad$3 */
    static class C204803 implements C1366d {
        C204803() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C45882d.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.ad$6 */
    static class C204816 implements C1366d {
        C204816() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C38939b.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.ad$4 */
    static class C278474 implements C1366d {
        C278474() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C34030a.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.ad$5 */
    static class C278485 implements C1366d {
        C278485() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C20474e.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.ad$7 */
    static class C389477 implements C1366d {
        C389477() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C34031c.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.ad$9 */
    class C389489 implements C4937b {
        C389489() {
        }

        /* renamed from: a */
        public final void mo10136a(int i, C7298n c7298n, final Object obj) {
            AppMethodBeat.m2504i(19384);
            try {
                if (C9638aw.m17179RK()) {
                    if (obj instanceof String) {
                        C9638aw.m17180RS().mo10310m(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(19383);
                                String str = (String) obj;
                                if (C45891ad.boY().mo54561Kp(str)) {
                                    C9638aw.m17190ZK();
                                    if (!C18628c.m29078XM().aoJ(str)) {
                                        C9638aw.m17182Rg().mo14541a(new C20473h(str, null), 0);
                                    }
                                }
                                AppMethodBeat.m2505o(19383);
                            }
                        }, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
                    }
                    AppMethodBeat.m2505o(19384);
                    return;
                }
                C4990ab.m7420w("MicroMsg.exdevice.SubCoreExDevice", "onNotifyChange,acc has not ready");
                AppMethodBeat.m2505o(19384);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.exdevice.SubCoreExDevice", "ap : onNotifyChange exception %s", e.getMessage());
                AppMethodBeat.m2505o(19384);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.ad$2 */
    class C429932 implements Runnable {
        C429932() {
        }

        public final void run() {
            AppMethodBeat.m2504i(19381);
            boolean hasSystemFeature = C4996ah.getContext().getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter");
            boolean hasSystemFeature2 = C4996ah.getContext().getPackageManager().hasSystemFeature("android.hardware.sensor.stepdetector");
            if (hasSystemFeature && hasSystemFeature2) {
                C7060h.pYm.mo8376a(11891, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, true, true);
            } else if (hasSystemFeature) {
                C7060h.pYm.mo8376a(11891, "1", true, true);
            } else if (hasSystemFeature2) {
                C7060h.pYm.mo8376a(11891, "2", true, true);
            }
            C4990ab.m7417i("MicroMsg.exdevice.SubCoreExDevice", "[hakon][step] deviceFeatures stepCounter %s, stepDetector %s", Boolean.valueOf(hasSystemFeature), Boolean.valueOf(hasSystemFeature2));
            AppMethodBeat.m2505o(19381);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.ad$10 */
    class C4588810 implements C41932a {
        C4588810() {
        }

        public final void run() {
            AppMethodBeat.m2504i(19385);
            C45891ad.m85024a(C45891ad.this);
            AppMethodBeat.m2505o(19385);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.ad$1 */
    static class C458891 implements C1366d {
        C458891() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C27837c.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.ad$8 */
    class C458908 implements C1837a {
        C458908() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:7:0x0031  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public final void mo5414a(C1197a c1197a) {
            AppMethodBeat.m2504i(19382);
            if (C45891ad.bpc() != null) {
                Object obj;
                C45891ad.bpc();
                C7254cm c7254cm = c1197a.eAB;
                C4990ab.m7416i("MicroMsg.exdevice.ExDeviceWifiStatusMessageHandler", "parseMessageFromServer");
                String a = C1946aa.m4148a(c7254cm.vED);
                if (C5046bo.isNullOrNil(a)) {
                    C4990ab.m7412e("MicroMsg.exdevice.ExDeviceWifiStatusMessageHandler", "msg content is null");
                } else {
                    Map z = C5049br.m7595z(a, "sysmsg");
                    if (z != null && z.size() > 0) {
                        a = (String) z.get(".sysmsg.$type");
                        if (!C5046bo.isNullOrNil(a) && a.equalsIgnoreCase("wcdevicemsg")) {
                            a = (String) z.get(".sysmsg.wcdevicemsg.xml.ToUserName");
                            String str = (String) z.get(".sysmsg.wcdevicemsg.xml.FromUserName");
                            long j = C5046bo.getLong((String) z.get(".sysmsg.wcdevicemsg.xml.CreateTime"), -1);
                            String str2 = (String) z.get(".sysmsg.wcdevicemsg.xml.MsgType");
                            String str3 = (String) z.get(".sysmsg.wcdevicemsg.xml.DeviceType");
                            String str4 = (String) z.get(".sysmsg.wcdevicemsg.xml.DeviceID");
                            int i = C5046bo.getInt((String) z.get(".sysmsg.wcdevicemsg.xml.DeviceStatus"), -1);
                            C4990ab.m7416i("MicroMsg.exdevice.ExDeviceWifiStatusMessageHandler", "parseMessageFromServer:tousr=" + a + ",fromuser=" + str + ",createtime=" + j + ",msgtype=" + str2 + ",devicetype=" + str3 + ",deviceid=" + str4 + ",devicestatus=" + i);
                            C11648b Kv = C45891ad.boW().mo45701Kv(str4);
                            if (Kv != null && C5046bo.nullAsNil(Kv.field_connProto).contains("4") && C5046bo.nullAsNil(str2).contains("device_status")) {
                                if (i != 0) {
                                    C45891ad.bph();
                                    C20495e.m31663b(Kv.field_brandName, Kv.field_url, 2, Kv.field_deviceID);
                                } else {
                                    C45891ad.bph();
                                    C20495e.m31663b(Kv.field_brandName, Kv.field_url, 4, Kv.field_deviceID);
                                }
                                obj = 1;
                                if (obj == null) {
                                    a = C1946aa.m4148a(c7254cm.vED);
                                    if (C5046bo.isNullOrNil(a)) {
                                        C4990ab.m7412e("MicroMsg.exdevice.ExDeviceMessageService", "msg content is null");
                                        AppMethodBeat.m2505o(19382);
                                        return;
                                    }
                                    Map z2 = C5049br.m7595z(a, "sysmsg");
                                    if (z2 == null || z2.size() <= 0) {
                                        C4990ab.m7412e("MicroMsg.exdevice.ExDeviceMessageService", "receiveMessage, no sysmsg");
                                        AppMethodBeat.m2505o(19382);
                                        return;
                                    }
                                    a = (String) z2.get(".sysmsg.$type");
                                    if (C5046bo.isNullOrNil(a) || !a.equalsIgnoreCase("wcdevicemsg")) {
                                        C4990ab.m7412e("MicroMsg.exdevice.ExDeviceMessageService", "receiveMessage, type not wcdevicemsg");
                                        AppMethodBeat.m2505o(19382);
                                        return;
                                    }
                                    C4990ab.m7417i("MicroMsg.exdevice.ExDeviceMessageService", "newXml wcdevicemsg msgType = %s", C5046bo.nullAsNil((String) z2.get(".sysmsg.wcdevicemsg.xml.MsgType")));
                                    if (C5046bo.nullAsNil((String) z2.get(".sysmsg.wcdevicemsg.xml.MsgType")).equals("device_relation")) {
                                        C26114dk c26114dk = new C26114dk();
                                        c26114dk.cwH.cwI = true;
                                        C4879a.xxA.mo10055m(c26114dk);
                                        AppMethodBeat.m2505o(19382);
                                        return;
                                    }
                                    a = (String) z2.get(".sysmsg.wcdevicemsg.xml.Content");
                                    C4990ab.m7417i("MicroMsg.exdevice.ExDeviceMessageService", "contentBase64 = %s", a);
                                    if (C5046bo.isNullOrNil(a)) {
                                        C4990ab.m7412e("MicroMsg.exdevice.ExDeviceMessageService", "Fuck off: contentBase64 is null");
                                        AppMethodBeat.m2505o(19382);
                                        return;
                                    }
                                    try {
                                        byte[] decode = Base64.decode(a, 0);
                                        if (C5046bo.m7540cb(decode)) {
                                            C4990ab.m7412e("MicroMsg.exdevice.ExDeviceMessageService", "null == decodedContent");
                                            AppMethodBeat.m2505o(19382);
                                            return;
                                        }
                                        long j2 = C5046bo.getLong((String) z2.get(".sysmsg.wcdevicemsg.xml.SessionID"), -1);
                                        C4990ab.m7417i("MicroMsg.exdevice.ExDeviceMessageService", "------NewXml Receive------sessionId = %d, deviceId = %s, message content = %s, length = %d", Long.valueOf(j2), (String) z2.get(".sysmsg.wcdevicemsg.xml.DeviceID"), a, Integer.valueOf(decode.length));
                                        Kv = C45891ad.boW().mo45701Kv(str);
                                        if (Kv == null) {
                                            C4990ab.m7412e("MicroMsg.exdevice.ExDeviceMessageService", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
                                            AppMethodBeat.m2505o(19382);
                                            return;
                                        } else if (0 == j2) {
                                            C20548u.bpy().mo54568a(new C27839g(decode, 0, Kv.field_mac));
                                            AppMethodBeat.m2505o(19382);
                                            return;
                                        } else {
                                            C11635k bow = C11635k.bow();
                                            C4990ab.m7417i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Recivce sendDataToManufacturerResponse, sessionId = %d", Long.valueOf(j2));
                                            Assert.assertTrue(j2 >= 0);
                                            C11636c c11636c = new C11636c();
                                            c11636c.mSessionId = j2;
                                            c11636c.mData = decode;
                                            bow.mHandler.obtainMessage(3, c11636c).sendToTarget();
                                        }
                                    } catch (Exception e) {
                                        C4990ab.m7413e("MicroMsg.exdevice.ExDeviceMessageService", "decode failed!!! %s", e.getMessage());
                                        C4990ab.printErrStackTrace("MicroMsg.exdevice.ExDeviceMessageService", e, "", new Object[0]);
                                        AppMethodBeat.m2505o(19382);
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
                obj = null;
                if (obj == null) {
                }
            }
            AppMethodBeat.m2505o(19382);
        }
    }

    static {
        AppMethodBeat.m2504i(19405);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("HARDDEVICEINFO_TABLE".hashCode()), new C458891());
        eaA.put(Integer.valueOf("HARDDEVICERANKINFO_TABLE".hashCode()), new C204803());
        eaA.put(Integer.valueOf("HARDDEVICERANKFOLLOWINFO_TABLE".hashCode()), new C278474());
        eaA.put(Integer.valueOf("HARDDEVICELIKEINFO_TABLE".hashCode()), new C278485());
        eaA.put(Integer.valueOf("HARDDEVICECHAMPIONINFO_TABLE".hashCode()), new C204816());
        eaA.put(Integer.valueOf("HARDDEVICERANKDETAILINFO_TABLE".hashCode()), new C389477());
        AppMethodBeat.m2505o(19405);
    }

    public C45891ad() {
        AppMethodBeat.m2504i(19386);
        if (this.luq == null) {
            this.luq = new C2971d();
        }
        if (this.lup == null) {
            this.lup = new C20495e();
        }
        C4990ab.m7416i("MicroMsg.exdevice.SubCoreExDevice", "create SubCoreExDevice.");
        C4879a.xxA.mo10052c(this.lup.lrZ);
        AppMethodBeat.m2505o(19386);
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return eaA;
    }

    private static C45891ad boV() {
        AppMethodBeat.m2504i(19387);
        C9638aw.m17184ZE();
        C45891ad c45891ad = (C45891ad) C45439bw.m83697oJ("plugin.exdevice");
        if (c45891ad == null) {
            C4990ab.m7420w("MicroMsg.exdevice.SubCoreExDevice", "not found in MMCore, new one");
            c45891ad = new C45891ad();
            C9638aw.m17184ZE().mo73244a("plugin.exdevice", c45891ad);
        }
        AppMethodBeat.m2505o(19387);
        return c45891ad;
    }

    public static C27837c boW() {
        AppMethodBeat.m2504i(19388);
        C1720g.m3534RN().mo5159QU();
        if (C45891ad.boV().luk == null) {
            C45891ad boV = C45891ad.boV();
            C9638aw.m17190ZK();
            boV.luk = new C27837c(C18628c.m29069Ru());
        }
        C27837c c27837c = C45891ad.boV().luk;
        AppMethodBeat.m2505o(19388);
        return c27837c;
    }

    public static C45882d boX() {
        AppMethodBeat.m2504i(19389);
        C1720g.m3534RN().mo5159QU();
        if (C45891ad.boV().lul == null) {
            C45891ad boV = C45891ad.boV();
            C9638aw.m17190ZK();
            boV.lul = new C45882d(C18628c.m29069Ru());
        }
        C45882d c45882d = C45891ad.boV().lul;
        AppMethodBeat.m2505o(19389);
        return c45882d;
    }

    public static C34030a boY() {
        AppMethodBeat.m2504i(19390);
        C1720g.m3534RN().mo5159QU();
        if (C45891ad.boV().lum == null) {
            C45891ad boV = C45891ad.boV();
            C9638aw.m17190ZK();
            boV.lum = new C34030a(C18628c.m29069Ru());
        }
        C34030a c34030a = C45891ad.boV().lum;
        AppMethodBeat.m2505o(19390);
        return c34030a;
    }

    public static C25815a boZ() {
        AppMethodBeat.m2504i(19391);
        if (C45891ad.boV().luu == null) {
            C45891ad.boV().luu = C32291o.ahp();
        }
        C25815a c25815a = C45891ad.boV().luu;
        AppMethodBeat.m2505o(19391);
        return c25815a;
    }

    /* renamed from: Kk */
    public static C25814c m85023Kk(String str) {
        AppMethodBeat.m2504i(19392);
        C25814c c25814c;
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.exdevice.SubCoreExDevice", "newImageOptions failed, url is null or nil, return default.");
            C45891ad boV = C45891ad.boV();
            if (boV.luv == null) {
                C17927a c17927a = new C17927a();
                C32291o.ahq();
                c17927a.ePY = null;
                c17927a.ePO = 640;
                c17927a.ePN = 640;
                c17927a.ePF = false;
                c17927a.ePH = true;
                boV.luv = c17927a.ahG();
            }
            c25814c = C45891ad.boV().luv;
            AppMethodBeat.m2505o(19392);
            return c25814c;
        }
        C17927a c17927a2 = new C17927a();
        c17927a2.ePO = 640;
        c17927a2.ePN = 640;
        c17927a2.ePF = false;
        c17927a2.ePG = true;
        C9638aw.m17190ZK();
        c17927a2.ePK = C18628c.m29088XW();
        c25814c = c17927a2.ahG();
        AppMethodBeat.m2505o(19392);
        return c25814c;
    }

    public static C38939b bpa() {
        AppMethodBeat.m2504i(19393);
        C1720g.m3534RN().mo5159QU();
        if (C45891ad.boV().lun == null) {
            C45891ad boV = C45891ad.boV();
            C9638aw.m17190ZK();
            boV.lun = new C38939b(C18628c.m29069Ru());
        }
        C38939b c38939b = C45891ad.boV().lun;
        AppMethodBeat.m2505o(19393);
        return c38939b;
    }

    public static C20474e bpb() {
        AppMethodBeat.m2504i(19394);
        C1720g.m3534RN().mo5159QU();
        if (C45891ad.boV().luo == null) {
            C45891ad boV = C45891ad.boV();
            C9638aw.m17190ZK();
            boV.luo = new C20474e(C18628c.m29069Ru());
        }
        C20474e c20474e = C45891ad.boV().luo;
        AppMethodBeat.m2505o(19394);
        return c20474e;
    }

    public static C38951b bpc() {
        AppMethodBeat.m2504i(19395);
        C1720g.m3534RN().mo5159QU();
        if (C45891ad.boV().luj == null) {
            C45891ad.boV().luj = new C38951b();
        }
        C38951b c38951b = C45891ad.boV().luj;
        AppMethodBeat.m2505o(19395);
        return c38951b;
    }

    public static C2971d bpd() {
        AppMethodBeat.m2504i(19396);
        if (C45891ad.boV().luq == null) {
            C45891ad.boV().luq = new C2971d();
        }
        C2971d c2971d = C45891ad.boV().luq;
        AppMethodBeat.m2505o(19396);
        return c2971d;
    }

    public static C42989c bpe() {
        AppMethodBeat.m2504i(19397);
        if (C45891ad.boV().lur == null) {
            C45891ad.boV().lur = new C42989c();
        }
        C42989c c42989c = C45891ad.boV().lur;
        AppMethodBeat.m2505o(19397);
        return c42989c;
    }

    public static C38938a bpf() {
        AppMethodBeat.m2504i(19398);
        if (C45891ad.boV().lus == null) {
            C45891ad.boV().lus = new C38938a();
        }
        C38938a c38938a = C45891ad.boV().lus;
        AppMethodBeat.m2505o(19398);
        return c38938a;
    }

    public static C34022c bpg() {
        AppMethodBeat.m2504i(19399);
        if (C45891ad.boV().lut == null) {
            C45891ad.boV().lut = new C34022c();
        }
        C34022c c34022c = C45891ad.boV().lut;
        AppMethodBeat.m2505o(19399);
        return c34022c;
    }

    public static C20495e bph() {
        AppMethodBeat.m2504i(19400);
        if (C45891ad.boV().lup == null) {
            C45891ad.boV().lup = new C20495e();
        }
        C20495e c20495e = C45891ad.boV().lup;
        AppMethodBeat.m2505o(19400);
        return c20495e;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(19401);
        C9638aw.m17190ZK();
        C18628c.m29078XM().mo10118a(this.luz);
        C9638aw.m17182Rg().mo14539a(538, C11635k.bow());
        this.luw = new C45892af();
        C4879a.xxA.mo10052c(this.lui);
        C9638aw.getSysCmdMsgExtension().mo14900a("wcdevicemsg", this.luy, true);
        C4879a.xxA.mo10052c(C45891ad.bph().lrA);
        C4879a.xxA.mo10052c(C45891ad.bph().lrB);
        C4879a.xxA.mo10052c(C45891ad.bph().lrC);
        C4879a.xxA.mo10052c(C45891ad.bph().lrV);
        C4879a.xxA.mo10052c(C45891ad.bph().lrz);
        C4879a.xxA.mo10052c(C45891ad.bph().lry);
        C4879a.xxA.mo10052c(C45891ad.bph().lrD);
        C4879a.xxA.mo10052c(C45891ad.bph().lrE);
        C4879a.xxA.mo10052c(C45891ad.bph().lrF);
        C4879a.xxA.mo10052c(C45891ad.bph().lrW);
        C4879a.xxA.mo10052c(C45891ad.bph().lrG);
        C4879a.xxA.mo10052c(C45891ad.bph().lrH);
        C4879a.xxA.mo10052c(C45891ad.bph().lrI);
        C4879a.xxA.mo10052c(C45891ad.bph().lrK);
        C4879a.xxA.mo10052c(C45891ad.bph().lrJ);
        C4879a.xxA.mo10052c(C45891ad.bph().lrO);
        C4879a.xxA.mo10052c(C45891ad.bph().lrM);
        C4879a.xxA.mo10052c(C45891ad.bph().lrN);
        C4879a.xxA.mo10052c(C45891ad.bph().lrP);
        C4879a.xxA.mo10052c(C45891ad.bph().lrX);
        C4879a.xxA.mo10052c(C45891ad.bph().jDf);
        C4879a.xxA.mo10052c(C45891ad.bph().lrL);
        C4879a.xxA.mo10052c(C45891ad.bph().lrQ);
        C4879a.xxA.mo10052c(C45891ad.bph().lrR);
        C4879a.xxA.mo10052c(C45891ad.bph().lrS);
        C4879a.xxA.mo10052c(C45891ad.bph().lrT);
        C4879a.xxA.mo10052c(C45891ad.bph().lsh);
        C4879a.xxA.mo10052c(C45891ad.bph().lsi);
        C4879a.xxA.mo10052c(C45891ad.bph().lsj);
        C4879a.xxA.mo10052c(C45891ad.bph().lsl);
        C4879a.xxA.mo10052c(C45891ad.bph().lsk);
        C4879a.xxA.mo10052c(C45891ad.bph().lsa);
        C4879a.xxA.mo10052c(C45891ad.bph().lsb);
        C4879a.xxA.mo10052c(C45891ad.bph().lsc);
        C4879a.xxA.mo10052c(C45891ad.bph().lsd);
        C4879a.xxA.mo10052c(C45891ad.bph().lse);
        C4879a.xxA.mo10052c(C45891ad.bph().lsg);
        C4879a.xxA.mo10052c(C45891ad.bph().lrY);
        C4879a.xxA.mo10052c(C45891ad.bph().lrZ);
        C1202f c1202f = C38954i.lto;
        C4990ab.m7416i("MicroMsg.exdevice.GetBoundDeviceLogic", "addSceneEndListener");
        C9638aw.m17182Rg().mo14539a(539, c1202f);
        C41933a.m74069a(19, new C4588810());
        AppMethodBeat.m2505o(19401);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(19402);
        C9638aw.m17190ZK();
        C18628c.m29078XM().mo10121b(this.luz);
        C4879a.xxA.mo10053d(C45891ad.bph().lrA);
        C4879a.xxA.mo10053d(C45891ad.bph().lrB);
        C4879a.xxA.mo10053d(C45891ad.bph().lrC);
        C4879a.xxA.mo10053d(C45891ad.bph().lrV);
        C4879a.xxA.mo10053d(C45891ad.bph().lrX);
        C4879a.xxA.mo10053d(C45891ad.bph().lrz);
        C4879a.xxA.mo10053d(C45891ad.bph().lry);
        C4879a.xxA.mo10053d(C45891ad.bph().lrD);
        C4879a.xxA.mo10053d(C45891ad.bph().lrE);
        C4879a.xxA.mo10053d(C45891ad.bph().lrF);
        C4879a.xxA.mo10053d(C45891ad.bph().lrW);
        C4879a.xxA.mo10053d(C45891ad.bph().lsh);
        C4879a.xxA.mo10053d(C45891ad.bph().lsi);
        C4879a.xxA.mo10053d(C45891ad.bph().lsj);
        C4879a.xxA.mo10053d(C45891ad.bph().lsl);
        C4879a.xxA.mo10053d(C45891ad.bph().lsk);
        C4879a.xxA.mo10053d(C45891ad.bph().lsa);
        C4879a.xxA.mo10053d(C45891ad.bph().lsb);
        C4879a.xxA.mo10053d(C45891ad.bph().lsc);
        C4879a.xxA.mo10053d(C45891ad.bph().lsd);
        C4879a.xxA.mo10053d(C45891ad.bph().lse);
        C4879a.xxA.mo10053d(C45891ad.bph().lsg);
        C4879a.xxA.mo10053d(C45891ad.bph().lrH);
        C4879a.xxA.mo10053d(C45891ad.bph().lrY);
        C4879a.xxA.mo10053d(C45891ad.bph().lrZ);
        C4990ab.m7416i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "releaseAllSharePreferences");
        SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("exdevice_pref", 0);
        if (sharedPreferences == null) {
            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == sp");
        } else if (!sharedPreferences.edit().clear().commit()) {
            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "sp.edit().clear().commit() Failed!!!");
        }
        C27859f bpx = C20548u.bpx();
        C4990ab.m7416i("MicroMsg.exdevice.ExdeviceInfoManager", "delAllDeviceAuthFlag");
        if (bpx.lwJ == null) {
            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceInfoManager", "null == exdeviceInfoList");
        } else {
            for (Entry entry : bpx.lwJ.entrySet()) {
                C27860a c27860a = (C27860a) entry.getValue();
                c27860a.lwN = false;
                entry.setValue(c27860a);
            }
        }
        C9638aw.m17182Rg().mo14546b(538, C11635k.bow());
        C11635k.lqI = null;
        C4879a.xxA.mo10053d(this.lui);
        C9638aw.getSysCmdMsgExtension().mo14903b("wcdevicemsg", this.luy, true);
        C4879a.xxA.mo10053d(C45891ad.bph().lrG);
        if (C45891ad.boV().luj != null) {
            C45891ad.boV();
        }
        C1202f c1202f = C38954i.lto;
        C4990ab.m7416i("MicroMsg.exdevice.GetBoundDeviceLogic", "removeSceneEndListener");
        C9638aw.m17182Rg().mo14546b(539, c1202f);
        C2971d c2971d = C45891ad.boV().luq;
        if (!(c2971d.lre == null || c2971d.lre.isEmpty())) {
            for (Entry entry2 : c2971d.lre.entrySet()) {
                ((C7564ap) entry2.getValue()).stopTimer();
            }
            c2971d.lre.clear();
        }
        if (C45891ad.boV().lur != null) {
            c1202f = C45891ad.boV().lur;
            C9638aw.m17182Rg().mo14546b(1042, c1202f);
            C9638aw.m17182Rg().mo14546b(1041, c1202f);
            C9638aw.m17182Rg().mo14546b((int) FilterEnum4Shaka.MIC_SHAKA_ADD2_8, c1202f);
            C9638aw.m17182Rg().mo14546b(1040, c1202f);
        }
        if (C45891ad.boV().luu != null) {
            C45891ad.boV().luu.detach();
        }
        C4879a.xxA.mo10053d(this.luw.ecA);
        AppMethodBeat.m2505o(19402);
    }

    public static C46907h bpi() {
        AppMethodBeat.m2504i(19403);
        if (C45891ad.boV().lux == null) {
            C45891ad.boV().lux = new C46907h();
        }
        C46907h c46907h = C45891ad.boV().lux;
        AppMethodBeat.m2505o(19403);
        return c46907h;
    }

    /* renamed from: a */
    static /* synthetic */ void m85024a(C45891ad c45891ad) {
        AppMethodBeat.m2504i(19404);
        try {
            C5004al.m7442n(new C429932(), 30000);
            AppMethodBeat.m2505o(19404);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.exdevice.SubCoreExDevice", "[hakon][step] exception in deviceFeaturesKVStat, %s", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.exdevice.SubCoreExDevice", e, "", new Object[0]);
            AppMethodBeat.m2505o(19404);
        }
    }
}
