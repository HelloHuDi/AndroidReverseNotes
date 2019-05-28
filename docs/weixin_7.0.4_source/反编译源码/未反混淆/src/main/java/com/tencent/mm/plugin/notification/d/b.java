package com.tencent.mm.plugin.notification.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    private static final String oVS = (e.eSn + "FailMsgFileCache");

    public static class a {
        public com.tencent.mm.plugin.notification.c.b oVT = new com.tencent.mm.plugin.notification.c.b();
        public int oVU;
        public ArrayList<Long> oVV = new ArrayList();
        public ArrayList<Long> oVW = new ArrayList();

        public a() {
            AppMethodBeat.i(23120);
            AppMethodBeat.o(23120);
        }

        public a(com.tencent.mm.plugin.notification.c.b bVar, int i, ArrayList<Long> arrayList, ArrayList<Long> arrayList2) {
            AppMethodBeat.i(23121);
            this.oVT = bVar;
            this.oVU = i;
            this.oVV = arrayList;
            this.oVW = arrayList2;
            AppMethodBeat.o(23121);
        }

        public final String bWO() {
            AppMethodBeat.i(23122);
            ab.d("MicroMsg.FailMsgFileCache", "CacheObj, serializeToString");
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < this.oVT.oVR.size(); i++) {
                    jSONArray.put(this.oVT.get(i));
                }
                ab.d("MicroMsg.FailMsgFileCache", "serializeToString, msgArray.size:%d", Integer.valueOf(jSONArray.length()));
                jSONObject.put("msg_list", jSONArray);
                ab.d("MicroMsg.FailMsgFileCache", "serializeToString, currentSendIndex:%d", Integer.valueOf(this.oVU));
                jSONObject.put("current_send_index", this.oVU);
                jSONArray = new JSONArray();
                Iterator it = this.oVV.iterator();
                while (it.hasNext()) {
                    jSONArray.put((Long) it.next());
                }
                ab.d("MicroMsg.FailMsgFileCache", "serializeToString, successArray.size:%d", Integer.valueOf(jSONArray.length()));
                jSONObject.put("success_msg_list", jSONArray);
                jSONArray = new JSONArray();
                it = this.oVW.iterator();
                while (it.hasNext()) {
                    jSONArray.put((Long) it.next());
                }
                ab.d("MicroMsg.FailMsgFileCache", "serializeToString, failArray.size:%d", Integer.valueOf(jSONArray.length()));
                jSONObject.put("fail_msg_list", jSONArray);
                String jSONObject2 = jSONObject.toString();
                AppMethodBeat.o(23122);
                return jSONObject2;
            } catch (JSONException e) {
                ab.printErrStackTrace("MicroMsg.FailMsgFileCache", e, "", new Object[0]);
                AppMethodBeat.o(23122);
                return null;
            }
        }

        public final void TT(String str) {
            AppMethodBeat.i(23123);
            ab.d("MicroMsg.FailMsgFileCache", "CacheObj, createFromFileContent");
            if (bo.isNullOrNil(str)) {
                ab.e("MicroMsg.FailMsgFileCache", "[createFromFileContent] content is null! stack:%s", bo.dpG());
                AppMethodBeat.o(23123);
                return;
            }
            try {
                int i;
                JSONObject jSONObject = new JSONObject(str);
                JSONArray jSONArray = jSONObject.getJSONArray("msg_list");
                JSONArray jSONArray2 = jSONObject.getJSONArray("fail_msg_list");
                JSONArray jSONArray3 = jSONObject.getJSONArray("success_msg_list");
                ab.d("MicroMsg.FailMsgFileCache", "createFromFileContent, msgArray.size:%d, failArray.size:%d, successArray.size:%d, index:%d", Integer.valueOf(jSONArray.length()), Integer.valueOf(jSONArray2.length()), Integer.valueOf(jSONArray3.length()), Integer.valueOf(jSONObject.getInt("current_send_index")));
                this.oVT.clear();
                this.oVW.clear();
                this.oVV.clear();
                for (i = 0; i < jSONArray.length(); i++) {
                    this.oVT.js(jSONArray.getLong(i));
                }
                for (i = 0; i < jSONArray2.length(); i++) {
                    this.oVW.add(Long.valueOf(jSONArray2.getLong(i)));
                }
                for (i = 0; i < jSONArray3.length(); i++) {
                    this.oVV.add(Long.valueOf(jSONArray3.getLong(i)));
                }
                this.oVU = r5;
                AppMethodBeat.o(23123);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.FailMsgFileCache", e, str, new Object[0]);
                AppMethodBeat.o(23123);
            }
        }
    }

    static {
        AppMethodBeat.i(23128);
        AppMethodBeat.o(23128);
    }

    public static void init() {
        AppMethodBeat.i(23124);
        ab.d("MicroMsg.FailMsgFileCache", "init FailMsgFileCache");
        new File(oVS).mkdirs();
        AppMethodBeat.o(23124);
    }

    public static void a(int i, a aVar) {
        AppMethodBeat.i(23125);
        String str = null;
        if (i == 1) {
            str = oVS + File.separator + "normalMsg";
        } else if (i == 2) {
            str = oVS + File.separator + "snsMsg";
        }
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.FailMsgFileCache", "flushToDisk error, cannot find filename");
            AppMethodBeat.o(23125);
            return;
        }
        ab.d("MicroMsg.FailMsgFileCache", "flushToDisk, filename:%s", str);
        String bWO = aVar.bWO();
        ab.d("MicroMsg.FailMsgFileCache", "flushToDisk, cacheContent:%s", bWO);
        if (bo.isNullOrNil(bWO)) {
            ab.d("MicroMsg.FailMsgFileCache", "flushToDisk, content is empty");
            AppMethodBeat.o(23125);
            return;
        }
        com.tencent.mm.a.e.b(str, bWO.getBytes(), bWO.length());
        AppMethodBeat.o(23125);
    }

    public static a Ar(int i) {
        String str;
        AppMethodBeat.i(23126);
        if (i == 1) {
            str = oVS + File.separator + "normalMsg";
        } else if (i == 2) {
            str = oVS + File.separator + "snsMsg";
        } else {
            str = null;
        }
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.FailMsgFileCache", "extractFromDisk error, cannot find filename");
            AppMethodBeat.o(23126);
            return null;
        }
        ab.d("MicroMsg.FailMsgFileCache", "extractFromDisk, filename:%s", str);
        try {
            ab.d("MicroMsg.FailMsgFileCache", "extractFromDisk, cacheContent:%s", com.tencent.mm.a.e.cy(str));
            a aVar = new a();
            aVar.TT(r2);
            AppMethodBeat.o(23126);
            return aVar;
        } catch (IOException e) {
            ab.printErrStackTrace("MicroMsg.FailMsgFileCache", e, "", new Object[0]);
            ab.d("MicroMsg.FailMsgFileCache", "extractFromDisk error:%s", e.toString());
            AppMethodBeat.o(23126);
            return null;
        }
    }

    public static void As(int i) {
        AppMethodBeat.i(23127);
        String str = null;
        if (i == 1) {
            str = oVS + File.separator + "normalMsg";
        } else if (i == 2) {
            str = oVS + File.separator + "snsMsg";
        }
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.FailMsgFileCache", "removeFile error, cannot find filename");
            AppMethodBeat.o(23127);
            return;
        }
        ab.d("MicroMsg.FailMsgFileCache", "removeFile, filename:%s", str);
        if (com.tencent.mm.a.e.ct(str)) {
            new File(str).delete();
        }
        AppMethodBeat.o(23127);
    }
}
