package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.protocal.protobuf.cxy;
import com.tencent.mm.protocal.protobuf.ik;
import com.tencent.mm.protocal.protobuf.il;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReportSubmitFormTask extends MainProcessTask {
    public static final Creator<ReportSubmitFormTask> CREATOR = new Creator<ReportSubmitFormTask>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ReportSubmitFormTask[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(130902);
            ReportSubmitFormTask reportSubmitFormTask = new ReportSubmitFormTask();
            reportSubmitFormTask.g(parcel);
            AppMethodBeat.o(130902);
            return reportSubmitFormTask;
        }
    };
    public String appId;
    public int axy;
    public int css;
    public String hCT;
    public String pageId;
    public int type;

    public ReportSubmitFormTask(h hVar) {
        this.appId = hVar.appId;
        this.css = hVar.hhd.gVt;
        this.axy = hVar.hhd.gVu;
    }

    public final void asP() {
        AppMethodBeat.i(130903);
        a aVar = new a();
        aVar.fsJ = new ik();
        aVar.fsK = new il();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxausrevent/batchrecordwxatemplatemsgevent";
        aVar.fsI = 1129;
        b acD = aVar.acD();
        final ik ikVar = (ik) acD.fsG.fsP;
        ikVar.vKD = new LinkedList();
        cxy cxy = new cxy();
        cxy.type = this.type;
        cxy.csB = this.appId;
        cxy.xts = this.hCT;
        cxy.xtt = this.pageId;
        cxy.iCZ = this.css;
        cxy.iDa = this.axy;
        ikVar.vKD.add(cxy);
        synchronized (getClass()) {
            try {
                ikVar.vKD.addAll(aCI());
            } finally {
                while (true) {
                }
                AppMethodBeat.o(130903);
            }
        }
        w.a(acD, new w.a() {
            public final int a(int i, int i2, String str, b bVar, m mVar) {
                AppMethodBeat.i(130901);
                if (i == 0 && i2 == 0) {
                    AppMethodBeat.o(130901);
                } else {
                    synchronized (ReportSubmitFormTask.this.getClass()) {
                        try {
                            ReportSubmitFormTask.y(ikVar.vKD);
                        } finally {
                            while (true) {
                            }
                            AppMethodBeat.o(130901);
                        }
                    }
                    ab.e("MicroMsg.ReportSubmitFormTask", "Error: %d, %d", Integer.valueOf(i), Integer.valueOf(i2));
                }
                return 0;
            }
        });
    }

    private static LinkedList<cxy> aCI() {
        AppMethodBeat.i(130904);
        LinkedList linkedList = new LinkedList();
        try {
            JSONArray jSONArray = new JSONArray((String) g.RP().Ry().get(ac.a.USERINFO_APP_BRAND_FAILED_FORMID_STRING, null));
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                cxy cxy = new cxy();
                cxy.type = jSONObject.getInt("type");
                cxy.csB = jSONObject.getString("appid");
                cxy.xts = jSONObject.getString("formid");
                cxy.xtt = jSONObject.getString("pageid");
                cxy.iCZ = jSONObject.getInt("appstate");
                cxy.iDa = jSONObject.getInt("appversion");
                linkedList.add(cxy);
            }
        } catch (Exception e) {
            ab.e("MicroMsg.ReportSubmitFormTask", e.getMessage());
        }
        g.RP().Ry().set(ac.a.USERINFO_APP_BRAND_FAILED_FORMID_STRING, (Object) "");
        AppMethodBeat.o(130904);
        return linkedList;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(130905);
        parcel.writeInt(this.type);
        parcel.writeString(this.appId);
        parcel.writeString(this.hCT);
        parcel.writeString(this.pageId);
        parcel.writeInt(this.css);
        parcel.writeInt(this.axy);
        AppMethodBeat.o(130905);
    }

    public final void g(Parcel parcel) {
        AppMethodBeat.i(130906);
        this.type = parcel.readInt();
        this.appId = parcel.readString();
        this.hCT = parcel.readString();
        this.pageId = parcel.readString();
        this.css = parcel.readInt();
        this.axy = parcel.readInt();
        AppMethodBeat.o(130906);
    }

    static {
        AppMethodBeat.i(130908);
        AppMethodBeat.o(130908);
    }

    static /* synthetic */ void y(LinkedList linkedList) {
        AppMethodBeat.i(130907);
        linkedList.addAll(aCI());
        JSONArray jSONArray = new JSONArray();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            cxy cxy = (cxy) it.next();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", cxy.type);
                jSONObject.put("appid", cxy.csB);
                jSONObject.put("formid", cxy.xts);
                jSONObject.put("pageid", cxy.xtt);
                jSONObject.put("appstate", cxy.iCZ);
                jSONObject.put("appversion", cxy.iDa);
                jSONArray.put(jSONObject);
            } catch (Exception e) {
                ab.e("MicroMsg.ReportSubmitFormTask", e.getMessage());
            }
        }
        g.RP().Ry().set(ac.a.USERINFO_APP_BRAND_FAILED_FORMID_STRING, jSONArray.toString());
        AppMethodBeat.o(130907);
    }
}
