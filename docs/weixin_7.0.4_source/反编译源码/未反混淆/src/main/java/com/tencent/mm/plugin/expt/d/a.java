package com.tencent.mm.plugin.expt.d;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bh;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.reflect.Field;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a extends bh {
    public static com.tencent.mm.sdk.e.c.a ccO;
    private HashMap<String, String> ckP = null;

    public final com.tencent.mm.sdk.e.c.a Ag() {
        return ccO;
    }

    public final boolean La(String str) {
        AppMethodBeat.i(93268);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(93268);
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String aVar = toString();
            this.field_exptContent = str;
            this.field_exptId = jSONObject.optInt("ExptId");
            this.field_groupId = jSONObject.optInt("GroupId");
            this.field_exptSeq = jSONObject.optInt("ExptSequence");
            this.field_startTime = jSONObject.optLong("StartTime");
            this.field_endTime = jSONObject.optLong("EndTime");
            this.field_exptType = jSONObject.optInt("ExptType");
            ab.v("MicroMsg.ExptItem", "convertFrom new [%s] old[%s] args[%s]", toString(), aVar, str);
            AppMethodBeat.o(93268);
            return true;
        } catch (Exception e) {
            Exception exception = e;
            e.pXa.a(863, 5, 1, false);
            ab.e("MicroMsg.ExptItem", "%d convertFrom [%s] error [%s]", Integer.valueOf(hashCode()), str, exception.toString());
            AppMethodBeat.o(93268);
            return false;
        }
    }

    public final String toString() {
        AppMethodBeat.i(93269);
        String str = "{ Id: " + this.field_exptId + " group: " + this.field_groupId + " seq: " + this.field_exptSeq + " startTime: " + this.field_startTime + " endTime: " + this.field_endTime + " content: " + this.field_exptContent + " type: " + this.field_exptType + " }";
        AppMethodBeat.o(93269);
        return str;
    }

    public final boolean isReady() {
        boolean z = false;
        AppMethodBeat.i(93270);
        if (this.field_exptSeq >= 0) {
            long anT = bo.anT();
            if (anT >= this.field_startTime && (this.field_endTime <= 0 || anT <= this.field_endTime)) {
                z = true;
            }
        }
        AppMethodBeat.o(93270);
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
        AppMethodBeat.i(93271);
        if (this.ckP != null) {
            HashMap hashMap3 = this.ckP;
            AppMethodBeat.o(93271);
            return hashMap3;
        }
        if (bo.isNullOrNil(this.field_exptContent)) {
            hashMap = null;
        } else {
            try {
                Object obj = new JSONObject(this.field_exptContent).get("Args");
                if (obj == null) {
                    AppMethodBeat.o(93271);
                    return null;
                }
                HashMap hashMap4 = new HashMap();
                try {
                    if (obj instanceof JSONArray) {
                        JSONArray jSONArray = (JSONArray) obj;
                        if (jSONArray != null) {
                            for (int i = 0; i < jSONArray.length(); i++) {
                                a(hashMap4, jSONArray.getJSONObject(i));
                            }
                        }
                        hashMap = hashMap4;
                    } else {
                        if (obj instanceof JSONObject) {
                            a(hashMap4, (JSONObject) obj);
                        }
                        hashMap = hashMap4;
                    }
                } catch (Exception e) {
                    exception = e;
                    hashMap = hashMap4;
                    ab.e("MicroMsg.ExptItem", "get expt item error [%s] exptId[%d]", exception.toString(), Integer.valueOf(this.field_exptId));
                    this.ckP = hashMap;
                    hashMap2 = this.ckP;
                    AppMethodBeat.o(93271);
                    return hashMap2;
                }
            } catch (Exception e2) {
                exception = e2;
                hashMap = null;
            }
        }
        this.ckP = hashMap;
        hashMap2 = this.ckP;
        AppMethodBeat.o(93271);
        return hashMap2;
    }

    private static void a(HashMap<String, String> hashMap, JSONObject jSONObject) {
        AppMethodBeat.i(93272);
        if (jSONObject == null) {
            AppMethodBeat.o(93272);
            return;
        }
        String optString = jSONObject.optString("Key");
        String optString2 = jSONObject.optString("Val");
        if (!(bo.isNullOrNil(optString) || bo.isNullOrNil(optString2))) {
            hashMap.put(optString, new String(Base64.decode(optString2, 0)));
        }
        AppMethodBeat.o(93272);
    }

    static {
        AppMethodBeat.i(93273);
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.xDb = new Field[7];
        aVar.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "exptId";
        aVar.xDd.put("exptId", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" exptId INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "exptId";
        aVar.columns[1] = "groupId";
        aVar.xDd.put("groupId", "INTEGER");
        stringBuilder.append(" groupId INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "exptSeq";
        aVar.xDd.put("exptSeq", "INTEGER");
        stringBuilder.append(" exptSeq INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "exptContent";
        aVar.xDd.put("exptContent", "TEXT");
        stringBuilder.append(" exptContent TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "startTime";
        aVar.xDd.put("startTime", "LONG");
        stringBuilder.append(" startTime LONG");
        stringBuilder.append(", ");
        aVar.columns[5] = "endTime";
        aVar.xDd.put("endTime", "LONG");
        stringBuilder.append(" endTime LONG");
        stringBuilder.append(", ");
        aVar.columns[6] = "exptType";
        aVar.xDd.put("exptType", "INTEGER");
        stringBuilder.append(" exptType INTEGER");
        aVar.columns[7] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(93273);
    }
}
