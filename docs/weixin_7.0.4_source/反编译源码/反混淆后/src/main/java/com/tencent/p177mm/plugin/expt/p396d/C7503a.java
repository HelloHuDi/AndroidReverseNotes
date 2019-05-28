package com.tencent.p177mm.plugin.expt.p396d;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C6566bh;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.reflect.Field;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.expt.d.a */
public final class C7503a extends C6566bh {
    public static C4924a ccO;
    private HashMap<String, String> ckP = null;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    /* renamed from: La */
    public final boolean mo16726La(String str) {
        AppMethodBeat.m2504i(93268);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(93268);
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String c7503a = toString();
            this.field_exptContent = str;
            this.field_exptId = jSONObject.optInt("ExptId");
            this.field_groupId = jSONObject.optInt("GroupId");
            this.field_exptSeq = jSONObject.optInt("ExptSequence");
            this.field_startTime = jSONObject.optLong("StartTime");
            this.field_endTime = jSONObject.optLong("EndTime");
            this.field_exptType = jSONObject.optInt("ExptType");
            C4990ab.m7419v("MicroMsg.ExptItem", "convertFrom new [%s] old[%s] args[%s]", toString(), c7503a, str);
            AppMethodBeat.m2505o(93268);
            return true;
        } catch (Exception e) {
            Exception exception = e;
            C7053e.pXa.mo8378a(863, 5, 1, false);
            C4990ab.m7413e("MicroMsg.ExptItem", "%d convertFrom [%s] error [%s]", Integer.valueOf(hashCode()), str, exception.toString());
            AppMethodBeat.m2505o(93268);
            return false;
        }
    }

    public final String toString() {
        AppMethodBeat.m2504i(93269);
        String str = "{ Id: " + this.field_exptId + " group: " + this.field_groupId + " seq: " + this.field_exptSeq + " startTime: " + this.field_startTime + " endTime: " + this.field_endTime + " content: " + this.field_exptContent + " type: " + this.field_exptType + " }";
        AppMethodBeat.m2505o(93269);
        return str;
    }

    public final boolean isReady() {
        boolean z = false;
        AppMethodBeat.m2504i(93270);
        if (this.field_exptSeq >= 0) {
            long anT = C5046bo.anT();
            if (anT >= this.field_startTime && (this.field_endTime <= 0 || anT <= this.field_endTime)) {
                z = true;
            }
        }
        AppMethodBeat.m2505o(93270);
        return z;
    }

    public final boolean bro() {
        return this.field_exptType == 10;
    }

    public final boolean brp() {
        return this.field_exptType == 2;
    }

    public final HashMap<String, String> brq() {
        HashMap hashMap;
        Exception exception;
        HashMap<String, String> hashMap2;
        AppMethodBeat.m2504i(93271);
        if (this.ckP != null) {
            HashMap hashMap3 = this.ckP;
            AppMethodBeat.m2505o(93271);
            return hashMap3;
        }
        if (C5046bo.isNullOrNil(this.field_exptContent)) {
            hashMap = null;
        } else {
            try {
                Object obj = new JSONObject(this.field_exptContent).get("Args");
                if (obj == null) {
                    AppMethodBeat.m2505o(93271);
                    return null;
                }
                HashMap hashMap4 = new HashMap();
                try {
                    if (obj instanceof JSONArray) {
                        JSONArray jSONArray = (JSONArray) obj;
                        if (jSONArray != null) {
                            for (int i = 0; i < jSONArray.length(); i++) {
                                C7503a.m13047a(hashMap4, jSONArray.getJSONObject(i));
                            }
                        }
                        hashMap = hashMap4;
                    } else {
                        if (obj instanceof JSONObject) {
                            C7503a.m13047a(hashMap4, (JSONObject) obj);
                        }
                        hashMap = hashMap4;
                    }
                } catch (Exception e) {
                    exception = e;
                    hashMap = hashMap4;
                    C4990ab.m7413e("MicroMsg.ExptItem", "get expt item error [%s] exptId[%d]", exception.toString(), Integer.valueOf(this.field_exptId));
                    this.ckP = hashMap;
                    hashMap2 = this.ckP;
                    AppMethodBeat.m2505o(93271);
                    return hashMap2;
                }
            } catch (Exception e2) {
                exception = e2;
                hashMap = null;
            }
        }
        this.ckP = hashMap;
        hashMap2 = this.ckP;
        AppMethodBeat.m2505o(93271);
        return hashMap2;
    }

    /* renamed from: a */
    private static void m13047a(HashMap<String, String> hashMap, JSONObject jSONObject) {
        AppMethodBeat.m2504i(93272);
        if (jSONObject == null) {
            AppMethodBeat.m2505o(93272);
            return;
        }
        String optString = jSONObject.optString("Key");
        String optString2 = jSONObject.optString("Val");
        if (!(C5046bo.isNullOrNil(optString) || C5046bo.isNullOrNil(optString2))) {
            hashMap.put(optString, new String(Base64.decode(optString2, 0)));
        }
        AppMethodBeat.m2505o(93272);
    }

    static {
        AppMethodBeat.m2504i(93273);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[7];
        c4924a.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "exptId";
        c4924a.xDd.put("exptId", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" exptId INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "exptId";
        c4924a.columns[1] = "groupId";
        c4924a.xDd.put("groupId", "INTEGER");
        stringBuilder.append(" groupId INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[2] = "exptSeq";
        c4924a.xDd.put("exptSeq", "INTEGER");
        stringBuilder.append(" exptSeq INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[3] = "exptContent";
        c4924a.xDd.put("exptContent", "TEXT");
        stringBuilder.append(" exptContent TEXT");
        stringBuilder.append(", ");
        c4924a.columns[4] = "startTime";
        c4924a.xDd.put("startTime", "LONG");
        stringBuilder.append(" startTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[5] = "endTime";
        c4924a.xDd.put("endTime", "LONG");
        stringBuilder.append(" endTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[6] = "exptType";
        c4924a.xDd.put("exptType", "INTEGER");
        stringBuilder.append(" exptType INTEGER");
        c4924a.columns[7] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(93273);
    }
}
