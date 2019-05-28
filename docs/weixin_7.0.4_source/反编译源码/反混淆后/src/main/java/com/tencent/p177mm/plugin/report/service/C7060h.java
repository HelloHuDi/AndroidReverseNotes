package com.tencent.p177mm.plugin.report.service;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.mars.BaseEvent;
import com.tencent.mars.smc.IDKey;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p178a.C1171c;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p178a.C1184r;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p230g.p231a.C6523mp;
import com.tencent.p177mm.plugin.report.C3735d;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.plugin.report.p498a.C3730c;
import com.tencent.p177mm.plugin.report.p499b.C7049g;
import com.tencent.p177mm.pointers.PByteArray;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.protobuf.C7248ag;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5047bp;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7580z;
import com.tencent.p177mm.vfs.C5730e;
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

/* renamed from: com.tencent.mm.plugin.report.service.h */
public enum C7060h implements C3735d {
    ;
    
    private long pYn;
    private int pYo;
    private HashMap<String, Long> pYp;
    private int pYq;
    private int pYr;
    private long pYs;
    private volatile boolean pYt;
    private int uin;

    /* renamed from: com.tencent.mm.plugin.report.service.h$1 */
    class C37461 implements Runnable {
        C37461() {
        }

        public final void run() {
            AppMethodBeat.m2504i(72751);
            C7060h.m11792a(C7060h.this);
            AppMethodBeat.m2505o(72751);
        }
    }

    /* renamed from: com.tencent.mm.plugin.report.service.h$2 */
    class C37472 implements Runnable {
        C37472() {
        }

        public final void run() {
            AppMethodBeat.m2504i(72752);
            C7060h.m11796b(C7060h.this);
            AppMethodBeat.m2505o(72752);
        }
    }

    /* renamed from: com.tencent.mm.plugin.report.service.h$8 */
    class C70598 implements C1202f {
        C70598() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(72760);
            c1207m.ftk = true;
            if (i != 0) {
                C4990ab.m7412e("MicroMsg.cLog", "NetScene failed, code=" + i2 + ", msg=" + str);
                AppMethodBeat.m2505o(72760);
                return;
            }
            final C7248ag c7248ag = ((C7049g) c1207m).pXu;
            C1720g.m3539RS().mo10302aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(72759);
                    try {
                        C7060h.this.pYs = System.currentTimeMillis();
                        C7580z Ry = C1720g.m3536RP().mo5239Ry();
                        Ry.set(C5127a.USERINFO_CLOG_SAMPLING_REFRESH_TIME_LONG, Long.valueOf(C7060h.this.pYs));
                        Ry.dsb();
                        if (C7060h.this.pYq == c7248ag.vBo && C7060h.this.pYr == c7248ag.vBp) {
                            C4990ab.m7417i("MicroMsg.cLog", "Version not changed, use previous settings (%d / %d)", Integer.valueOf(c7248ag.vBo), Integer.valueOf(c7248ag.vBp));
                            AppMethodBeat.m2505o(72759);
                            return;
                        }
                        byte[] toByteArray = c7248ag.toByteArray();
                        C5730e.m8624b(C4996ah.getContext().getFileStreamPath("clog-settings").getPath(), toByteArray, toByteArray.length);
                        C7060h.m11792a(C7060h.this);
                        AppMethodBeat.m2505o(72759);
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace("MicroMsg.cLog", e, "Failed to parse response.", new Object[0]);
                        AppMethodBeat.m2505o(72759);
                    }
                }
            });
            AppMethodBeat.m2505o(72760);
        }
    }

    static {
        AppMethodBeat.m2505o(72793);
    }

    private C7060h(String str) {
        AppMethodBeat.m2504i(72763);
        this.pYn = 0;
        if (C4996ah.bqo()) {
            C1720g.m3539RS().mo10302aa(new C37461());
            final C37472 c37472 = new C37472();
            C4879a.xxA.mo10051b(new C4884c<C6523mp>() {
                /* renamed from: a */
                public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
                    AppMethodBeat.m2504i(72754);
                    if (C7060h.this.pYs <= 0) {
                        Object obj = C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CLOG_SAMPLING_REFRESH_TIME_LONG, null);
                        if (obj != null && (obj instanceof Long)) {
                            C7060h.this.pYs = ((Long) obj).longValue();
                        }
                    }
                    if (C7060h.this.pYt || System.currentTimeMillis() - C7060h.this.pYs > 86400000) {
                        C1720g.m3539RS().mo10310m(c37472, 100);
                    }
                    AppMethodBeat.m2505o(72754);
                    return true;
                }
            });
            C1720g.m3540Rg().mo14539a(701, new C1202f() {
                public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(72755);
                    if (i != 0) {
                        AppMethodBeat.m2505o(72755);
                        return;
                    }
                    C1720g.m3539RS().mo10310m(c37472, 5000);
                    AppMethodBeat.m2505o(72755);
                }
            });
        }
        AppMethodBeat.m2505o(72763);
    }

    /* renamed from: a */
    public static Object m11789a(int i, int[] iArr, int i2, int i3) {
        AppMethodBeat.m2504i(72764);
        Object a = C7053e.m11771a(i, iArr, i2, i3);
        AppMethodBeat.m2505o(72764);
        return a;
    }

    /* renamed from: s */
    public static String m11804s(Object... objArr) {
        String str;
        AppMethodBeat.m2504i(72765);
        if (objArr == null || objArr.length <= 0) {
            C4990ab.m7420w("MicroMsg.ReportManagerKvCheck", "vals is null, use '' as value");
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
        AppMethodBeat.m2505o(72765);
        return str;
    }

    /* renamed from: cT */
    private static String m11798cT(List<String> list) {
        String str;
        AppMethodBeat.m2504i(72766);
        if (list == null || list.isEmpty()) {
            C4990ab.m7420w("MicroMsg.ReportManagerKvCheck", "vals is null, use '' as value");
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
        AppMethodBeat.m2505o(72766);
        return str;
    }

    /* renamed from: a */
    public static void m11790a(int i, int i2, String str, boolean z, boolean z2) {
        AppMethodBeat.m2504i(72767);
        KVReportDataInfo kVReportDataInfo = new KVReportDataInfo();
        kVReportDataInfo.pXX = (long) i;
        kVReportDataInfo.value = str;
        kVReportDataInfo.ctk = (long) i2;
        kVReportDataInfo.pXA = false;
        kVReportDataInfo.pXY = z;
        kVReportDataInfo.pXZ = z2;
        KVCommCrossProcessReceiver.m6055a(kVReportDataInfo);
        AppMethodBeat.m2505o(72767);
    }

    /* renamed from: b */
    public static void m11795b(int i, String str, boolean z, boolean z2) {
        AppMethodBeat.m2504i(72768);
        KVReportDataInfo kVReportDataInfo = new KVReportDataInfo();
        kVReportDataInfo.pXX = (long) i;
        kVReportDataInfo.value = str;
        kVReportDataInfo.ctk = 0;
        kVReportDataInfo.pXA = false;
        kVReportDataInfo.pXY = z;
        kVReportDataInfo.pXZ = z2;
        KVCommCrossProcessReceiver.m6055a(kVReportDataInfo);
        AppMethodBeat.m2505o(72768);
    }

    /* renamed from: j */
    private static void m11803j(long j, long j2, long j3) {
        AppMethodBeat.m2504i(72769);
        StIDKeyDataInfo stIDKeyDataInfo = new StIDKeyDataInfo();
        stIDKeyDataInfo.lhy = j;
        stIDKeyDataInfo.key = j2;
        stIDKeyDataInfo.value = j3;
        stIDKeyDataInfo.pXA = false;
        KVCommCrossProcessReceiver.m6056a(stIDKeyDataInfo);
        AppMethodBeat.m2505o(72769);
    }

    /* renamed from: X */
    public final void mo8374X(int i, String str) {
        AppMethodBeat.m2504i(72770);
        if (C3730c.pXd) {
            boolean z = C3730c.pXe;
            mo8376a(i, str, z, z);
            AppMethodBeat.m2505o(72770);
            return;
        }
        mo8376a(i, str, false, false);
        AppMethodBeat.m2505o(72770);
    }

    /* renamed from: a */
    public final void mo8376a(int i, String str, boolean z, boolean z2) {
        AppMethodBeat.m2504i(72771);
        if (!C4996ah.bqo()) {
            C7060h.m11795b(i, str, z, false);
            AppMethodBeat.m2505o(72771);
        } else if (C3730c.pXd) {
            long j = (long) i;
            boolean z3 = C3730c.pXe;
            C3744e.m6058a(j, str, z3, z3, false);
            AppMethodBeat.m2505o(72771);
        } else {
            C3744e.m6058a((long) i, str, z, false, false);
            AppMethodBeat.m2505o(72771);
        }
    }

    /* renamed from: e */
    public final void mo8381e(int i, Object... objArr) {
        AppMethodBeat.m2504i(72772);
        if (C3730c.pXd) {
            boolean z = C3730c.pXe;
            mo8377a(i, z, z, objArr);
            AppMethodBeat.m2505o(72772);
            return;
        }
        mo8377a(i, false, false, objArr);
        AppMethodBeat.m2505o(72772);
    }

    /* renamed from: a */
    public final void mo8377a(int i, boolean z, boolean z2, Object... objArr) {
        AppMethodBeat.m2504i(72773);
        String s = C7060h.m11804s(objArr);
        if (C4872b.dnO()) {
            C4990ab.m7419v("MicroMsg.ReportManagerKvCheck", "kvTypedStat id:%d [%b,%b] val:%s", Integer.valueOf(i), Boolean.valueOf(z), Boolean.FALSE, s);
        }
        if (C4996ah.bqo()) {
            C3744e.m6058a((long) i, s, z, false, false);
            AppMethodBeat.m2505o(72773);
            return;
        }
        C7060h.m11795b(i, s, z, false);
        AppMethodBeat.m2505o(72773);
    }

    /* renamed from: c */
    public final boolean mo15417c(int i, C1331a c1331a) {
        AppMethodBeat.m2504i(72774);
        try {
            c1331a.getClass().getField("import_ds_").setInt(c1331a, BaseClientBuilder.API_PRIORITY_OTHER);
            long anU = C5046bo.anU();
            if (anU / TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC != this.pYn) {
                try {
                    this.pYo = C5046bo.getInt(new SimpleDateFormat("yyyyMMdd").format(new Date()), 0);
                } catch (Exception e) {
                }
            }
            c1331a.getClass().getField("ds_").setInt(c1331a, this.pYo);
            c1331a.getClass().getField("uin_").setLong(c1331a, ((long) this.uin) & 4294967295L);
            c1331a.getClass().getField("device_").setInt(c1331a, 2);
            c1331a.getClass().getField("clientVersion_").setInt(c1331a, C7243d.vxo);
            c1331a.getClass().getField("time_stamp_").setLong(c1331a, anU);
            try {
                byte[] toByteArray = c1331a.toByteArray();
                if (!C4996ah.bqo()) {
                    C4990ab.m7414f("MicroMsg.ReportManagerKvCheck", "not in MM Process");
                } else if (C3730c.pXd) {
                    long j = (long) i;
                    boolean z = C3730c.pXe;
                    C3744e.m6059a(j, toByteArray, z, z);
                } else {
                    C3744e.m6059a((long) i, toByteArray, false, false);
                }
                AppMethodBeat.m2505o(72774);
                return true;
            } catch (IOException e2) {
                C4990ab.m7413e("MicroMsg.ReportManagerKvCheck", "pbKVStat LocalReportPb error, %d, %s", Integer.valueOf(i), e2.toString());
                AppMethodBeat.m2505o(72774);
                return false;
            }
        } catch (Exception e3) {
            C4990ab.m7413e("MicroMsg.ReportManagerKvCheck", "pbKVStat  set values error, %d, %s", Integer.valueOf(i), e3.toString());
            AppMethodBeat.m2505o(72774);
            return false;
        }
    }

    /* renamed from: g */
    public static void m11802g(int i, List<String> list) {
        AppMethodBeat.m2504i(72775);
        if (C3730c.pXd) {
            C7060h.m11791a(i, list, C3730c.pXe);
            AppMethodBeat.m2505o(72775);
            return;
        }
        C7060h.m11791a(i, list, false);
        AppMethodBeat.m2505o(72775);
    }

    /* renamed from: a */
    private static void m11791a(int i, List<String> list, boolean z) {
        AppMethodBeat.m2504i(72776);
        String cT = C7060h.m11798cT(list);
        if (C4996ah.bqo()) {
            C3744e.m6058a((long) i, cT, z, false, false);
            AppMethodBeat.m2505o(72776);
            return;
        }
        C7060h.m11795b(i, cT, z, false);
        AppMethodBeat.m2505o(72776);
    }

    /* renamed from: z */
    public final void mo15421z(long j, long j2) {
        AppMethodBeat.m2504i(139035);
        mo15419k(j, j2, 1);
        AppMethodBeat.m2505o(139035);
    }

    /* renamed from: k */
    public final void mo15419k(long j, long j2, long j3) {
        AppMethodBeat.m2504i(72778);
        mo8378a(j, j2, j3, false);
        AppMethodBeat.m2505o(72778);
    }

    /* renamed from: a */
    public final void mo8378a(long j, long j2, long j3, boolean z) {
        AppMethodBeat.m2504i(72779);
        if (j < 0 || j2 < 0 || j3 <= 0) {
            C4990ab.m7413e("MicroMsg.ReportManagerKvCheck", "ID %d, key %d, value %d <0", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3));
            AppMethodBeat.m2505o(72779);
        } else if (C4996ah.bqo()) {
            C3744e.m6060b(j, j2, j3, false);
            AppMethodBeat.m2505o(72779);
        } else {
            C7060h.m11803j(j, j2, j3);
            AppMethodBeat.m2505o(72779);
        }
    }

    /* renamed from: b */
    public final void mo8379b(ArrayList<IDKey> arrayList, boolean z) {
        AppMethodBeat.m2504i(72780);
        if (arrayList == null) {
            C4990ab.m7412e("MicroMsg.ReportManagerKvCheck", "report idkeyGroupStat lstIdKeyDataInfos == null return");
            AppMethodBeat.m2505o(72780);
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            IDKey iDKey = (IDKey) it.next();
            if (iDKey == null) {
                C4990ab.m7412e("MicroMsg.ReportManagerKvCheck", "report idkeyGroupStat info == null return");
                AppMethodBeat.m2505o(72780);
                return;
            } else if (iDKey.GetID() < 0 || iDKey.GetKey() < 0) {
                C4990ab.m7413e("MicroMsg.ReportManagerKvCheck", "report idkeyGroupStat ID %d, key %d, value %d <0", Long.valueOf(iDKey.GetID()), Long.valueOf(iDKey.GetKey()), Long.valueOf(iDKey.GetValue()));
                AppMethodBeat.m2505o(72780);
                return;
            } else if (iDKey.GetValue() <= 0) {
                C4990ab.m7413e("MicroMsg.ReportManagerKvCheck", "report idkeyGroupStat ID %d, key %d, value %d <0", Long.valueOf(iDKey.GetID()), Long.valueOf(iDKey.GetKey()), Long.valueOf(iDKey.GetValue()));
                AppMethodBeat.m2505o(72780);
                return;
            }
        }
        if (C4996ah.bqo()) {
            C3744e.m6061d(arrayList, false);
            AppMethodBeat.m2505o(72780);
            return;
        }
        KVCommCrossProcessReceiver.m6053P(arrayList);
        AppMethodBeat.m2505o(72780);
    }

    /* renamed from: a */
    public final void mo8375a(int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
        AppMethodBeat.m2504i(72781);
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
        mo8379b(arrayList, z);
        AppMethodBeat.m2505o(72781);
    }

    /* renamed from: d */
    public final void mo8380d(int i, int i2, int i3, int i4, boolean z) {
        AppMethodBeat.m2504i(72782);
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
        mo8379b(arrayList, false);
        AppMethodBeat.m2505o(72782);
    }

    /* renamed from: ag */
    public final void mo15416ag(int i, int i2, int i3) {
        AppMethodBeat.m2504i(72783);
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
        mo8379b(arrayList, false);
        AppMethodBeat.m2505o(72783);
    }

    public static void cgt() {
        AppMethodBeat.m2504i(72784);
        if (C4996ah.bqo()) {
            BaseEvent.onSingalCrash(0);
            AppMethodBeat.m2505o(72784);
            return;
        }
        KVCommCrossProcessReceiver.cgn();
        AppMethodBeat.m2505o(72784);
    }

    /* renamed from: fP */
    public final void mo15418fP(String str, String str2) {
        AppMethodBeat.m2504i(139036);
        mo8382g(str, str2, null);
        AppMethodBeat.m2505o(139036);
    }

    /* renamed from: g */
    public final void mo8382g(String str, final String str2, final Map<String, Object> map) {
        AppMethodBeat.m2504i(72786);
        m11793a(str, new Callable<JSONArray>() {
            public final /* synthetic */ Object call() {
                AppMethodBeat.m2504i(72756);
                JSONArray put = new JSONArray().put((map == null ? new JSONObject() : new JSONObject(map)).put("info", str2));
                AppMethodBeat.m2505o(72756);
                return put;
            }
        });
        AppMethodBeat.m2505o(72786);
    }

    /* renamed from: q */
    public final void mo15420q(String str, final List<String> list) {
        AppMethodBeat.m2504i(72787);
        m11793a(str, new Callable<JSONArray>() {
            public final /* synthetic */ Object call() {
                AppMethodBeat.m2504i(72757);
                JSONArray jSONArray = new JSONArray();
                for (String put : list) {
                    jSONArray.put(new JSONObject().put("info", put));
                }
                AppMethodBeat.m2505o(72757);
                return jSONArray;
            }
        });
        AppMethodBeat.m2505o(72787);
    }

    /* renamed from: a */
    private void m11793a(String str, Callable<JSONArray> callable) {
        AppMethodBeat.m2504i(72788);
        final long currentTimeMillis = System.currentTimeMillis();
        if (m11794al(str, currentTimeMillis)) {
            final Callable<JSONArray> callable2 = callable;
            final String str2 = str;
            C7305d.post(new Runnable() {
                public final void run() {
                    int QF;
                    String str;
                    int i;
                    String str2 = null;
                    AppMethodBeat.m2504i(72758);
                    if (C4996ah.bqo() && C1720g.m3531RK()) {
                        C1720g.m3534RN();
                        QF = C1668a.m3383QF();
                        if (C1720g.m3536RP().mo5239Ry() != null) {
                            str2 = C1853r.m3846Yz();
                        }
                        str = str2;
                        i = QF;
                    } else {
                        str = null;
                        i = 0;
                    }
                    try {
                        String string = C4996ah.getContext().getSharedPreferences("system_config_prefs", 0).getString("support.weixin.qq.com", "support.weixin.qq.com");
                        JSONArray jSONArray = (JSONArray) callable2.call();
                        int length = jSONArray.length();
                        for (QF = 0; QF < length; QF++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(QF);
                            jSONObject.put("tag", str2);
                            jSONObject.put(OpenSDKTool4Assistant.EXTRA_UIN, i);
                        }
                        byte[] bytes = new JSONObject().put("head", new JSONObject().put("protocol_ver", 1).put("phone", C7243d.DEVICE_NAME).put("os_ver", C7243d.eSg).put("report_time", currentTimeMillis).put("revision", C5046bo.nullAsNil(C5058f.REV))).put("items", jSONArray).toString().getBytes();
                        String toLowerCase = C1178g.m2591x(String.format("weixin#$()%d%d", new Object[]{Integer.valueOf(C7243d.vxo), Integer.valueOf(bytes.length)}).getBytes()).toLowerCase();
                        bytes = C1184r.compress(bytes);
                        PByteArray pByteArray = new PByteArray();
                        C1171c.m2554a(pByteArray, bytes, toLowerCase.getBytes());
                        StringBuilder append = new StringBuilder(256).append("http://").append(string).append("/cgi-bin/mmsupport-bin/stackreport?version=").append(Integer.toHexString(C7243d.vxo)).append("&devicetype=").append(C7243d.eSg).append("&filelength=").append(QF).append("&sum=").append(toLowerCase).append("&reporttype=1&NewReportType=110");
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
                        C4990ab.m7416i("MicroMsg.cLog", "POST returned: ".concat(String.valueOf(C5046bo.convertStreamToString(defaultHttpClient.execute(httpPost).getEntity().getContent()))));
                        AppMethodBeat.m2505o(72758);
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace("MicroMsg.ReportManagerKvCheck", e, "Failed to upload cLog.", new Object[0]);
                        AppMethodBeat.m2505o(72758);
                    }
                }
            }, "ReportManager_cLog");
            AppMethodBeat.m2505o(72788);
            return;
        }
        AppMethodBeat.m2505o(72788);
    }

    /* renamed from: hB */
    public final void mo8383hB(int i) {
        AppMethodBeat.m2504i(72789);
        this.uin = i;
        SmcLogic.setUin((long) i);
        AppMethodBeat.m2505o(72789);
    }

    /* renamed from: al */
    private boolean m11794al(String str, long j) {
        AppMethodBeat.m2504i(72790);
        if (C5047bp.dpL()) {
            C4990ab.m7411d("MicroMsg.cLog", "[%s] Sampling hit: (debug)", str);
            AppMethodBeat.m2505o(72790);
            return true;
        }
        Long l = this.pYp != null ? (Long) this.pYp.get(str) : null;
        if (l != null) {
            byte[] y = C1178g.m2592y((str + this.uin + j).getBytes());
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
                C4990ab.m7411d(str2, str3, objArr);
                AppMethodBeat.m2505o(72790);
                return z;
            }
        }
        C4990ab.m7411d("MicroMsg.cLog", "[%s] Sampling hit: (default)", str);
        AppMethodBeat.m2505o(72790);
        return true;
    }
}
