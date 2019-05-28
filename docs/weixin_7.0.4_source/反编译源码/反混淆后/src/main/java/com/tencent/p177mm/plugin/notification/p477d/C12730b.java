package com.tencent.p177mm.plugin.notification.p477d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.plugin.notification.p476c.C3557b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.notification.d.b */
public final class C12730b {
    private static final String oVS = (C6457e.eSn + "FailMsgFileCache");

    /* renamed from: com.tencent.mm.plugin.notification.d.b$a */
    public static class C12731a {
        public C3557b oVT = new C3557b();
        public int oVU;
        public ArrayList<Long> oVV = new ArrayList();
        public ArrayList<Long> oVW = new ArrayList();

        public C12731a() {
            AppMethodBeat.m2504i(23120);
            AppMethodBeat.m2505o(23120);
        }

        public C12731a(C3557b c3557b, int i, ArrayList<Long> arrayList, ArrayList<Long> arrayList2) {
            AppMethodBeat.m2504i(23121);
            this.oVT = c3557b;
            this.oVU = i;
            this.oVV = arrayList;
            this.oVW = arrayList2;
            AppMethodBeat.m2505o(23121);
        }

        public final String bWO() {
            AppMethodBeat.m2504i(23122);
            C4990ab.m7410d("MicroMsg.FailMsgFileCache", "CacheObj, serializeToString");
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < this.oVT.oVR.size(); i++) {
                    jSONArray.put(this.oVT.get(i));
                }
                C4990ab.m7411d("MicroMsg.FailMsgFileCache", "serializeToString, msgArray.size:%d", Integer.valueOf(jSONArray.length()));
                jSONObject.put("msg_list", jSONArray);
                C4990ab.m7411d("MicroMsg.FailMsgFileCache", "serializeToString, currentSendIndex:%d", Integer.valueOf(this.oVU));
                jSONObject.put("current_send_index", this.oVU);
                jSONArray = new JSONArray();
                Iterator it = this.oVV.iterator();
                while (it.hasNext()) {
                    jSONArray.put((Long) it.next());
                }
                C4990ab.m7411d("MicroMsg.FailMsgFileCache", "serializeToString, successArray.size:%d", Integer.valueOf(jSONArray.length()));
                jSONObject.put("success_msg_list", jSONArray);
                jSONArray = new JSONArray();
                it = this.oVW.iterator();
                while (it.hasNext()) {
                    jSONArray.put((Long) it.next());
                }
                C4990ab.m7411d("MicroMsg.FailMsgFileCache", "serializeToString, failArray.size:%d", Integer.valueOf(jSONArray.length()));
                jSONObject.put("fail_msg_list", jSONArray);
                String jSONObject2 = jSONObject.toString();
                AppMethodBeat.m2505o(23122);
                return jSONObject2;
            } catch (JSONException e) {
                C4990ab.printErrStackTrace("MicroMsg.FailMsgFileCache", e, "", new Object[0]);
                AppMethodBeat.m2505o(23122);
                return null;
            }
        }

        /* renamed from: TT */
        public final void mo24741TT(String str) {
            AppMethodBeat.m2504i(23123);
            C4990ab.m7410d("MicroMsg.FailMsgFileCache", "CacheObj, createFromFileContent");
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7413e("MicroMsg.FailMsgFileCache", "[createFromFileContent] content is null! stack:%s", C5046bo.dpG());
                AppMethodBeat.m2505o(23123);
                return;
            }
            try {
                int i;
                JSONObject jSONObject = new JSONObject(str);
                JSONArray jSONArray = jSONObject.getJSONArray("msg_list");
                JSONArray jSONArray2 = jSONObject.getJSONArray("fail_msg_list");
                JSONArray jSONArray3 = jSONObject.getJSONArray("success_msg_list");
                C4990ab.m7411d("MicroMsg.FailMsgFileCache", "createFromFileContent, msgArray.size:%d, failArray.size:%d, successArray.size:%d, index:%d", Integer.valueOf(jSONArray.length()), Integer.valueOf(jSONArray2.length()), Integer.valueOf(jSONArray3.length()), Integer.valueOf(jSONObject.getInt("current_send_index")));
                this.oVT.clear();
                this.oVW.clear();
                this.oVV.clear();
                for (i = 0; i < jSONArray.length(); i++) {
                    this.oVT.mo8115js(jSONArray.getLong(i));
                }
                for (i = 0; i < jSONArray2.length(); i++) {
                    this.oVW.add(Long.valueOf(jSONArray2.getLong(i)));
                }
                for (i = 0; i < jSONArray3.length(); i++) {
                    this.oVV.add(Long.valueOf(jSONArray3.getLong(i)));
                }
                this.oVU = r5;
                AppMethodBeat.m2505o(23123);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.FailMsgFileCache", e, str, new Object[0]);
                AppMethodBeat.m2505o(23123);
            }
        }
    }

    static {
        AppMethodBeat.m2504i(23128);
        AppMethodBeat.m2505o(23128);
    }

    public static void init() {
        AppMethodBeat.m2504i(23124);
        C4990ab.m7410d("MicroMsg.FailMsgFileCache", "init FailMsgFileCache");
        new File(oVS).mkdirs();
        AppMethodBeat.m2505o(23124);
    }

    /* renamed from: a */
    public static void m20746a(int i, C12731a c12731a) {
        AppMethodBeat.m2504i(23125);
        String str = null;
        if (i == 1) {
            str = oVS + File.separator + "normalMsg";
        } else if (i == 2) {
            str = oVS + File.separator + "snsMsg";
        }
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.FailMsgFileCache", "flushToDisk error, cannot find filename");
            AppMethodBeat.m2505o(23125);
            return;
        }
        C4990ab.m7411d("MicroMsg.FailMsgFileCache", "flushToDisk, filename:%s", str);
        String bWO = c12731a.bWO();
        C4990ab.m7411d("MicroMsg.FailMsgFileCache", "flushToDisk, cacheContent:%s", bWO);
        if (C5046bo.isNullOrNil(bWO)) {
            C4990ab.m7410d("MicroMsg.FailMsgFileCache", "flushToDisk, content is empty");
            AppMethodBeat.m2505o(23125);
            return;
        }
        C1173e.m2559b(str, bWO.getBytes(), bWO.length());
        AppMethodBeat.m2505o(23125);
    }

    /* renamed from: Ar */
    public static C12731a m20744Ar(int i) {
        String str;
        AppMethodBeat.m2504i(23126);
        if (i == 1) {
            str = oVS + File.separator + "normalMsg";
        } else if (i == 2) {
            str = oVS + File.separator + "snsMsg";
        } else {
            str = null;
        }
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.FailMsgFileCache", "extractFromDisk error, cannot find filename");
            AppMethodBeat.m2505o(23126);
            return null;
        }
        C4990ab.m7411d("MicroMsg.FailMsgFileCache", "extractFromDisk, filename:%s", str);
        try {
            C4990ab.m7411d("MicroMsg.FailMsgFileCache", "extractFromDisk, cacheContent:%s", C1173e.m2566cy(str));
            C12731a c12731a = new C12731a();
            c12731a.mo24741TT(r2);
            AppMethodBeat.m2505o(23126);
            return c12731a;
        } catch (IOException e) {
            C4990ab.printErrStackTrace("MicroMsg.FailMsgFileCache", e, "", new Object[0]);
            C4990ab.m7411d("MicroMsg.FailMsgFileCache", "extractFromDisk error:%s", e.toString());
            AppMethodBeat.m2505o(23126);
            return null;
        }
    }

    /* renamed from: As */
    public static void m20745As(int i) {
        AppMethodBeat.m2504i(23127);
        String str = null;
        if (i == 1) {
            str = oVS + File.separator + "normalMsg";
        } else if (i == 2) {
            str = oVS + File.separator + "snsMsg";
        }
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.FailMsgFileCache", "removeFile error, cannot find filename");
            AppMethodBeat.m2505o(23127);
            return;
        }
        C4990ab.m7411d("MicroMsg.FailMsgFileCache", "removeFile, filename:%s", str);
        if (C1173e.m2561ct(str)) {
            new File(str).delete();
        }
        AppMethodBeat.m2505o(23127);
    }
}
