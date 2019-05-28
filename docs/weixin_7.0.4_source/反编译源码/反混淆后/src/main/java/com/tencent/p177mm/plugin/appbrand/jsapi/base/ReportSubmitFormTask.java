package com.tencent.p177mm.plugin.appbrand.jsapi.base;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.appbrand.config.C16597h;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.protocal.protobuf.C35923ik;
import com.tencent.p177mm.protocal.protobuf.C35924il;
import com.tencent.p177mm.protocal.protobuf.cxy;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.base.ReportSubmitFormTask */
public class ReportSubmitFormTask extends MainProcessTask {
    public static final Creator<ReportSubmitFormTask> CREATOR = new C193222();
    public String appId;
    public int axy;
    public int css;
    public String hCT;
    public String pageId;
    public int type;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.base.ReportSubmitFormTask$2 */
    static class C193222 implements Creator<ReportSubmitFormTask> {
        C193222() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ReportSubmitFormTask[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(130902);
            ReportSubmitFormTask reportSubmitFormTask = new ReportSubmitFormTask();
            reportSubmitFormTask.mo6032g(parcel);
            AppMethodBeat.m2505o(130902);
            return reportSubmitFormTask;
        }
    }

    public ReportSubmitFormTask(C16597h c16597h) {
        this.appId = c16597h.appId;
        this.css = c16597h.hhd.gVt;
        this.axy = c16597h.hhd.gVu;
    }

    public final void asP() {
        AppMethodBeat.m2504i(130903);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C35923ik();
        c1196a.fsK = new C35924il();
        c1196a.uri = "/cgi-bin/mmbiz-bin/wxausrevent/batchrecordwxatemplatemsgevent";
        c1196a.fsI = 1129;
        C7472b acD = c1196a.acD();
        final C35923ik c35923ik = (C35923ik) acD.fsG.fsP;
        c35923ik.vKD = new LinkedList();
        cxy cxy = new cxy();
        cxy.type = this.type;
        cxy.csB = this.appId;
        cxy.xts = this.hCT;
        cxy.xtt = this.pageId;
        cxy.iCZ = this.css;
        cxy.iDa = this.axy;
        c35923ik.vKD.add(cxy);
        synchronized (getClass()) {
            try {
                c35923ik.vKD.addAll(ReportSubmitFormTask.aCI());
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(130903);
            }
        }
        C1226w.m2654a(acD, new C1224a() {
            /* renamed from: a */
            public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
                AppMethodBeat.m2504i(130901);
                if (i == 0 && i2 == 0) {
                    AppMethodBeat.m2505o(130901);
                } else {
                    synchronized (ReportSubmitFormTask.this.getClass()) {
                        try {
                            ReportSubmitFormTask.m29998y(c35923ik.vKD);
                        } finally {
                            while (true) {
                            }
                            AppMethodBeat.m2505o(130901);
                        }
                    }
                    C4990ab.m7413e("MicroMsg.ReportSubmitFormTask", "Error: %d, %d", Integer.valueOf(i), Integer.valueOf(i2));
                }
                return 0;
            }
        });
    }

    private static LinkedList<cxy> aCI() {
        AppMethodBeat.m2504i(130904);
        LinkedList linkedList = new LinkedList();
        try {
            JSONArray jSONArray = new JSONArray((String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_APP_BRAND_FAILED_FORMID_STRING, null));
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
            C4990ab.m7412e("MicroMsg.ReportSubmitFormTask", e.getMessage());
        }
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_APP_BRAND_FAILED_FORMID_STRING, (Object) "");
        AppMethodBeat.m2505o(130904);
        return linkedList;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(130905);
        parcel.writeInt(this.type);
        parcel.writeString(this.appId);
        parcel.writeString(this.hCT);
        parcel.writeString(this.pageId);
        parcel.writeInt(this.css);
        parcel.writeInt(this.axy);
        AppMethodBeat.m2505o(130905);
    }

    /* renamed from: g */
    public final void mo6032g(Parcel parcel) {
        AppMethodBeat.m2504i(130906);
        this.type = parcel.readInt();
        this.appId = parcel.readString();
        this.hCT = parcel.readString();
        this.pageId = parcel.readString();
        this.css = parcel.readInt();
        this.axy = parcel.readInt();
        AppMethodBeat.m2505o(130906);
    }

    static {
        AppMethodBeat.m2504i(130908);
        AppMethodBeat.m2505o(130908);
    }

    /* renamed from: y */
    static /* synthetic */ void m29998y(LinkedList linkedList) {
        AppMethodBeat.m2504i(130907);
        linkedList.addAll(ReportSubmitFormTask.aCI());
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
                C4990ab.m7412e("MicroMsg.ReportSubmitFormTask", e.getMessage());
            }
        }
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_APP_BRAND_FAILED_FORMID_STRING, jSONArray.toString());
        AppMethodBeat.m2505o(130907);
    }
}
