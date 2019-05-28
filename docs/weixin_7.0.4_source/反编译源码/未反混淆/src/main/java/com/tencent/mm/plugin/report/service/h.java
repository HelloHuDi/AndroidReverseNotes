package com.tencent.mm.plugin.report.service;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.mars.BaseEvent;
import com.tencent.mars.smc.IDKey;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.mp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.storage.ac;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

public enum h implements d {
    ;
    
    private long pYn;
    private int pYo;
    private HashMap<String, Long> pYp;
    private int pYq;
    private int pYr;
    private long pYs;
    private volatile boolean pYt;
    private int uin;

    static {
        AppMethodBeat.o(72793);
    }

    private h(String str) {
        AppMethodBeat.i(72763);
        this.pYn = 0;
        if (ah.bqo()) {
            g.RS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(72751);
                    h.a(h.this);
                    AppMethodBeat.o(72751);
                }
            });
            final AnonymousClass2 anonymousClass2 = new Runnable() {
                public final void run() {
                    AppMethodBeat.i(72752);
                    h.b(h.this);
                    AppMethodBeat.o(72752);
                }
            };
            a.xxA.b(new c<mp>() {
                public final /* synthetic */ boolean a(b bVar) {
                    AppMethodBeat.i(72754);
                    if (h.this.pYs <= 0) {
                        Object obj = g.RP().Ry().get(ac.a.USERINFO_CLOG_SAMPLING_REFRESH_TIME_LONG, null);
                        if (obj != null && (obj instanceof Long)) {
                            h.this.pYs = ((Long) obj).longValue();
                        }
                    }
                    if (h.this.pYt || System.currentTimeMillis() - h.this.pYs > 86400000) {
                        g.RS().m(anonymousClass2, 100);
                    }
                    AppMethodBeat.o(72754);
                    return true;
                }
            });
            g.Rg().a(701, new f() {
                public final void onSceneEnd(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(72755);
                    if (i != 0) {
                        AppMethodBeat.o(72755);
                        return;
                    }
                    g.RS().m(anonymousClass2, 5000);
                    AppMethodBeat.o(72755);
                }
            });
        }
        AppMethodBeat.o(72763);
    }

    public static Object a(int i, int[] iArr, int i2, int i3) {
        AppMethodBeat.i(72764);
        Object a = e.a(i, iArr, i2, i3);
        AppMethodBeat.o(72764);
        return a;
    }

    public static String s(Object... objArr) {
        String str;
        AppMethodBeat.i(72765);
        if (objArr == null || objArr.length <= 0) {
            ab.w("MicroMsg.ReportManagerKvCheck", "vals is null, use '' as value");
            str = "";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            int length = objArr.length - 1;
            for (int i = 0; i < length; i++) {
                stringBuilder.append(String.valueOf(objArr[i]).replace(',', ' ')).append(',');
            }
            stringBuilder.append(String.valueOf(objArr[length]));
            str = stringBuilder.toString();
        }
        AppMethodBeat.o(72765);
        return str;
    }

    private static String cT(List<String> list) {
        String str;
        AppMethodBeat.i(72766);
        if (list == null || list.isEmpty()) {
            ab.w("MicroMsg.ReportManagerKvCheck", "vals is null, use '' as value");
            str = "";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            int size = list.size() - 1;
            for (int i = 0; i < size; i++) {
                stringBuilder.append((String) list.get(i)).append(',');
            }
            stringBuilder.append((String) list.get(size));
            str = stringBuilder.toString();
        }
        AppMethodBeat.o(72766);
        return str;
    }

    public static void a(int i, int i2, String str, boolean z, boolean z2) {
        AppMethodBeat.i(72767);
        KVReportDataInfo kVReportDataInfo = new KVReportDataInfo();
        kVReportDataInfo.pXX = (long) i;
        kVReportDataInfo.value = str;
        kVReportDataInfo.ctk = (long) i2;
        kVReportDataInfo.pXA = false;
        kVReportDataInfo.pXY = z;
        kVReportDataInfo.pXZ = z2;
        KVCommCrossProcessReceiver.a(kVReportDataInfo);
        AppMethodBeat.o(72767);
    }

    public static void b(int i, String str, boolean z, boolean z2) {
        AppMethodBeat.i(72768);
        KVReportDataInfo kVReportDataInfo = new KVReportDataInfo();
        kVReportDataInfo.pXX = (long) i;
        kVReportDataInfo.value = str;
        kVReportDataInfo.ctk = 0;
        kVReportDataInfo.pXA = false;
        kVReportDataInfo.pXY = z;
        kVReportDataInfo.pXZ = z2;
        KVCommCrossProcessReceiver.a(kVReportDataInfo);
        AppMethodBeat.o(72768);
    }

    private static void j(long j, long j2, long j3) {
        AppMethodBeat.i(72769);
        StIDKeyDataInfo stIDKeyDataInfo = new StIDKeyDataInfo();
        stIDKeyDataInfo.lhy = j;
        stIDKeyDataInfo.key = j2;
        stIDKeyDataInfo.value = j3;
        stIDKeyDataInfo.pXA = false;
        KVCommCrossProcessReceiver.a(stIDKeyDataInfo);
        AppMethodBeat.o(72769);
    }

    public final void X(int i, String str) {
        AppMethodBeat.i(72770);
        if (com.tencent.mm.plugin.report.a.c.pXd) {
            boolean z = com.tencent.mm.plugin.report.a.c.pXe;
            a(i, str, z, z);
            AppMethodBeat.o(72770);
            return;
        }
        a(i, str, false, false);
        AppMethodBeat.o(72770);
    }

    public final void a(int i, String str, boolean z, boolean z2) {
        AppMethodBeat.i(72771);
        if (!ah.bqo()) {
            b(i, str, z, false);
            AppMethodBeat.o(72771);
        } else if (com.tencent.mm.plugin.report.a.c.pXd) {
            long j = (long) i;
            boolean z3 = com.tencent.mm.plugin.report.a.c.pXe;
            e.a(j, str, z3, z3, false);
            AppMethodBeat.o(72771);
        } else {
            e.a((long) i, str, z, false, false);
            AppMethodBeat.o(72771);
        }
    }

    public final void e(int i, Object... objArr) {
        AppMethodBeat.i(72772);
        if (com.tencent.mm.plugin.report.a.c.pXd) {
            boolean z = com.tencent.mm.plugin.report.a.c.pXe;
            a(i, z, z, objArr);
            AppMethodBeat.o(72772);
            return;
        }
        a(i, false, false, objArr);
        AppMethodBeat.o(72772);
    }

    public final void a(int i, boolean z, boolean z2, Object... objArr) {
        AppMethodBeat.i(72773);
        String s = s(objArr);
        if (com.tencent.mm.sdk.a.b.dnO()) {
            ab.v("MicroMsg.ReportManagerKvCheck", "kvTypedStat id:%d [%b,%b] val:%s", Integer.valueOf(i), Boolean.valueOf(z), Boolean.FALSE, s);
        }
        if (ah.bqo()) {
            e.a((long) i, s, z, false, false);
            AppMethodBeat.o(72773);
            return;
        }
        b(i, s, z, false);
        AppMethodBeat.o(72773);
    }

    public final boolean c(int i, com.tencent.mm.bt.a aVar) {
        AppMethodBeat.i(72774);
        try {
            aVar.getClass().getField("import_ds_").setInt(aVar, BaseClientBuilder.API_PRIORITY_OTHER);
            long anU = bo.anU();
            if (anU / TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC != this.pYn) {
                try {
                    this.pYo = bo.getInt(new SimpleDateFormat("yyyyMMdd").format(new Date()), 0);
                } catch (Exception e) {
                }
            }
            aVar.getClass().getField("ds_").setInt(aVar, this.pYo);
            aVar.getClass().getField("uin_").setLong(aVar, ((long) this.uin) & 4294967295L);
            aVar.getClass().getField("device_").setInt(aVar, 2);
            aVar.getClass().getField("clientVersion_").setInt(aVar, com.tencent.mm.protocal.d.vxo);
            aVar.getClass().getField("time_stamp_").setLong(aVar, anU);
            try {
                byte[] toByteArray = aVar.toByteArray();
                if (!ah.bqo()) {
                    ab.f("MicroMsg.ReportManagerKvCheck", "not in MM Process");
                } else if (com.tencent.mm.plugin.report.a.c.pXd) {
                    long j = (long) i;
                    boolean z = com.tencent.mm.plugin.report.a.c.pXe;
                    e.a(j, toByteArray, z, z);
                } else {
                    e.a((long) i, toByteArray, false, false);
                }
                AppMethodBeat.o(72774);
                return true;
            } catch (IOException e2) {
                ab.e("MicroMsg.ReportManagerKvCheck", "pbKVStat LocalReportPb error, %d, %s", Integer.valueOf(i), e2.toString());
                AppMethodBeat.o(72774);
                return false;
            }
        } catch (Exception e3) {
            ab.e("MicroMsg.ReportManagerKvCheck", "pbKVStat  set values error, %d, %s", Integer.valueOf(i), e3.toString());
            AppMethodBeat.o(72774);
            return false;
        }
    }

    public static void g(int i, List<String> list) {
        AppMethodBeat.i(72775);
        if (com.tencent.mm.plugin.report.a.c.pXd) {
            a(i, list, com.tencent.mm.plugin.report.a.c.pXe);
            AppMethodBeat.o(72775);
            return;
        }
        a(i, list, false);
        AppMethodBeat.o(72775);
    }

    private static void a(int i, List<String> list, boolean z) {
        AppMethodBeat.i(72776);
        String cT = cT(list);
        if (ah.bqo()) {
            e.a((long) i, cT, z, false, false);
            AppMethodBeat.o(72776);
            return;
        }
        b(i, cT, z, false);
        AppMethodBeat.o(72776);
    }

    public final void z(long j, long j2) {
        AppMethodBeat.i(139035);
        k(j, j2, 1);
        AppMethodBeat.o(139035);
    }

    public final void k(long j, long j2, long j3) {
        AppMethodBeat.i(72778);
        a(j, j2, j3, false);
        AppMethodBeat.o(72778);
    }

    public final void a(long j, long j2, long j3, boolean z) {
        AppMethodBeat.i(72779);
        if (j < 0 || j2 < 0 || j3 <= 0) {
            ab.e("MicroMsg.ReportManagerKvCheck", "ID %d, key %d, value %d <0", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3));
            AppMethodBeat.o(72779);
        } else if (ah.bqo()) {
            e.b(j, j2, j3, false);
            AppMethodBeat.o(72779);
        } else {
            j(j, j2, j3);
            AppMethodBeat.o(72779);
        }
    }

    public final void b(ArrayList<IDKey> arrayList, boolean z) {
        AppMethodBeat.i(72780);
        if (arrayList == null) {
            ab.e("MicroMsg.ReportManagerKvCheck", "report idkeyGroupStat lstIdKeyDataInfos == null return");
            AppMethodBeat.o(72780);
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            IDKey iDKey = (IDKey) it.next();
            if (iDKey == null) {
                ab.e("MicroMsg.ReportManagerKvCheck", "report idkeyGroupStat info == null return");
                AppMethodBeat.o(72780);
                return;
            } else if (iDKey.GetID() < 0 || iDKey.GetKey() < 0) {
                ab.e("MicroMsg.ReportManagerKvCheck", "report idkeyGroupStat ID %d, key %d, value %d <0", Long.valueOf(iDKey.GetID()), Long.valueOf(iDKey.GetKey()), Long.valueOf(iDKey.GetValue()));
                AppMethodBeat.o(72780);
                return;
            } else if (iDKey.GetValue() <= 0) {
                ab.e("MicroMsg.ReportManagerKvCheck", "report idkeyGroupStat ID %d, key %d, value %d <0", Long.valueOf(iDKey.GetID()), Long.valueOf(iDKey.GetKey()), Long.valueOf(iDKey.GetValue()));
                AppMethodBeat.o(72780);
                return;
            }
        }
        if (ah.bqo()) {
            e.d(arrayList, false);
            AppMethodBeat.o(72780);
            return;
        }
        KVCommCrossProcessReceiver.P(arrayList);
        AppMethodBeat.o(72780);
    }

    public final void a(int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
        AppMethodBeat.i(72781);
        IDKey iDKey = new IDKey();
        iDKey.SetID(i);
        iDKey.SetKey(i3);
        iDKey.SetValue((long) i5);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(i2);
        iDKey2.SetKey(i4);
        iDKey2.SetValue((long) i6);
        ArrayList arrayList = new ArrayList();
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        b(arrayList, z);
        AppMethodBeat.o(72781);
    }

    public final void d(int i, int i2, int i3, int i4, boolean z) {
        AppMethodBeat.i(72782);
        IDKey iDKey = new IDKey();
        iDKey.SetID(i);
        iDKey.SetKey(i2);
        iDKey.SetValue((long) i4);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(i);
        iDKey2.SetKey(i3);
        iDKey2.SetValue(1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        b(arrayList, false);
        AppMethodBeat.o(72782);
    }

    public final void ag(int i, int i2, int i3) {
        AppMethodBeat.i(72783);
        IDKey iDKey = new IDKey();
        iDKey.SetID(i);
        iDKey.SetKey(i2);
        iDKey.SetValue(1);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(i);
        iDKey2.SetKey(i3);
        iDKey2.SetValue(1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        b(arrayList, false);
        AppMethodBeat.o(72783);
    }

    public static void cgt() {
        AppMethodBeat.i(72784);
        if (ah.bqo()) {
            BaseEvent.onSingalCrash(0);
            AppMethodBeat.o(72784);
            return;
        }
        KVCommCrossProcessReceiver.cgn();
        AppMethodBeat.o(72784);
    }

    public final void fP(String str, String str2) {
        AppMethodBeat.i(139036);
        g(str, str2, null);
        AppMethodBeat.o(139036);
    }

    public final void g(String str, final String str2, final Map<String, Object> map) {
        AppMethodBeat.i(72786);
        a(str, new Callable<JSONArray>() {
            public final /* synthetic */ Object call() {
                AppMethodBeat.i(72756);
                JSONArray put = new JSONArray().put((map == null ? new JSONObject() : new JSONObject(map)).put("info", str2));
                AppMethodBeat.o(72756);
                return put;
            }
        });
        AppMethodBeat.o(72786);
    }

    public final void q(String str, final List<String> list) {
        AppMethodBeat.i(72787);
        a(str, new Callable<JSONArray>() {
            public final /* synthetic */ Object call() {
                AppMethodBeat.i(72757);
                JSONArray jSONArray = new JSONArray();
                for (String put : list) {
                    jSONArray.put(new JSONObject().put("info", put));
                }
                AppMethodBeat.o(72757);
                return jSONArray;
            }
        });
        AppMethodBeat.o(72787);
    }

    private void a(String str, Callable<JSONArray> callable) {
        AppMethodBeat.i(72788);
        final long currentTimeMillis = System.currentTimeMillis();
        if (al(str, currentTimeMillis)) {
            final Callable<JSONArray> callable2 = callable;
            final String str2 = str;
            com.tencent.mm.sdk.g.d.post(new Runnable() {
                public final void run() {
                    int QF;
                    String str;
                    int i;
                    String str2 = null;
                    AppMethodBeat.i(72758);
                    if (ah.bqo() && g.RK()) {
                        g.RN();
                        QF = com.tencent.mm.kernel.a.QF();
                        if (g.RP().Ry() != null) {
                            str2 = r.Yz();
                        }
                        str = str2;
                        i = QF;
                    } else {
                        str = null;
                        i = 0;
                    }
                    try {
                        String string = ah.getContext().getSharedPreferences("system_config_prefs", 0).getString("support.weixin.qq.com", "support.weixin.qq.com");
                        JSONArray jSONArray = (JSONArray) callable2.call();
                        int length = jSONArray.length();
                        for (QF = 0; QF < length; QF++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(QF);
                            jSONObject.put("tag", str2);
                            jSONObject.put(OpenSDKTool4Assistant.EXTRA_UIN, i);
                        }
                        byte[] bytes = new JSONObject().put("head", new JSONObject().put("protocol_ver", 1).put("phone", com.tencent.mm.protocal.d.DEVICE_NAME).put("os_ver", com.tencent.mm.protocal.d.eSg).put("report_time", currentTimeMillis).put("revision", bo.nullAsNil(com.tencent.mm.sdk.platformtools.f.REV))).put("items", jSONArray).toString().getBytes();
                        String toLowerCase = com.tencent.mm.a.g.x(String.format("weixin#$()%d%d", new Object[]{Integer.valueOf(com.tencent.mm.protocal.d.vxo), Integer.valueOf(bytes.length)}).getBytes()).toLowerCase();
                        bytes = com.tencent.mm.a.r.compress(bytes);
                        PByteArray pByteArray = new PByteArray();
                        com.tencent.mm.a.c.a(pByteArray, bytes, toLowerCase.getBytes());
                        StringBuilder append = new StringBuilder(256).append("http://").append(string).append("/cgi-bin/mmsupport-bin/stackreport?version=").append(Integer.toHexString(com.tencent.mm.protocal.d.vxo)).append("&devicetype=").append(com.tencent.mm.protocal.d.eSg).append("&filelength=").append(QF).append("&sum=").append(toLowerCase).append("&reporttype=1&NewReportType=110");
                        if (!(str == null || str.length() == 0)) {
                            append.append("&username=").append(str);
                        }
                        if (i != 0) {
                            append.append("&uin=").append(i);
                        }
                        str2 = append.toString();
                        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
                        HttpPost httpPost = new HttpPost(str2);
                        ByteArrayEntity byteArrayEntity = new ByteArrayEntity(pByteArray.value);
                        byteArrayEntity.setContentType("binary/octet-stream");
                        httpPost.setEntity(byteArrayEntity);
                        ab.i("MicroMsg.cLog", "POST returned: ".concat(String.valueOf(bo.convertStreamToString(defaultHttpClient.execute(httpPost).getEntity().getContent()))));
                        AppMethodBeat.o(72758);
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.ReportManagerKvCheck", e, "Failed to upload cLog.", new Object[0]);
                        AppMethodBeat.o(72758);
                    }
                }
            }, "ReportManager_cLog");
            AppMethodBeat.o(72788);
            return;
        }
        AppMethodBeat.o(72788);
    }

    public final void hB(int i) {
        AppMethodBeat.i(72789);
        this.uin = i;
        SmcLogic.setUin((long) i);
        AppMethodBeat.o(72789);
    }

    private boolean al(String str, long j) {
        AppMethodBeat.i(72790);
        if (bp.dpL()) {
            ab.d("MicroMsg.cLog", "[%s] Sampling hit: (debug)", str);
            AppMethodBeat.o(72790);
            return true;
        }
        Long l = this.pYp != null ? (Long) this.pYp.get(str) : null;
        if (l != null) {
            byte[] y = com.tencent.mm.a.g.y((str + this.uin + j).getBytes());
            if (y != null && y.length == 16) {
                long j2 = (((((long) (((y[0] + y[4]) + y[8]) + y[12])) & 255) | ((((long) (((y[1] + y[5]) + y[9]) + y[13])) & 255) << 8)) | ((((long) (((y[2] + y[6]) + y[10]) + y[14])) & 255) << 16)) | ((((long) (y[15] + ((y[3] + y[7]) + y[11]))) & 255) << 24);
                boolean z = j2 < l.longValue();
                String str2 = "MicroMsg.cLog";
                String str3 = "[%s] Sampling %s: 0x%08x / 0x%08x";
                Object[] objArr = new Object[4];
                objArr[0] = str;
                objArr[1] = z ? "hit" : "miss";
                objArr[2] = Long.valueOf(j2);
                objArr[3] = l;
                ab.d(str2, str3, objArr);
                AppMethodBeat.o(72790);
                return z;
            }
        }
        ab.d("MicroMsg.cLog", "[%s] Sampling hit: (default)", str);
        AppMethodBeat.o(72790);
        return true;
    }
}
