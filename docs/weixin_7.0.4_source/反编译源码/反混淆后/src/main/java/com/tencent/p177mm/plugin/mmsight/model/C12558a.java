package com.tencent.p177mm.plugin.mmsight.model;

import android.app.ActivityManager;
import android.graphics.Point;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.p221e.C45290m;
import com.tencent.p177mm.plugin.mmsight.C3475d;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.mmsight.model.a */
public final class C12558a {
    static C12558a otd;
    public int etA;
    int fXT;
    public int fay;
    public long fileSize;
    JSONObject hwh = null;
    String model = Build.MODEL;
    public int otA;
    public int otB;
    public int otC;
    public long otD;
    public int otE;
    String ote = (VERSION.SDK_INT);
    int otf;
    String otg;
    int oth;
    int oti;
    public String otj;
    public String otk;
    public String otl;
    public String otm;
    public int otn;
    public int oto;
    public int otp;
    public int otq;
    public int otr;
    public int ots;
    public int ott;
    public int otu;
    public int otv;
    public int otw;
    public int otx;
    public int oty;
    int otz;
    public int rotate = 0;
    public int videoBitrate;

    public C12558a() {
        AppMethodBeat.m2504i(76456);
        AppMethodBeat.m2505o(76456);
    }

    public static C12558a bPi() {
        AppMethodBeat.m2504i(76457);
        if (otd == null) {
            C12558a.reset();
        }
        C12558a c12558a = otd;
        AppMethodBeat.m2505o(76457);
        return c12558a;
    }

    public static void reset() {
        AppMethodBeat.m2504i(76458);
        C12558a c12558a = new C12558a();
        otd = c12558a;
        c12558a.fXT = ((ActivityManager) C4996ah.getContext().getSystemService("activity")).getLargeMemoryClass();
        otd.otf = C3475d.m5782ev(C4996ah.getContext());
        otd.otg = C45290m.m83510Lx();
        Point eu = C3475d.m5780eu(C4996ah.getContext());
        otd.oth = eu.x;
        otd.oti = eu.y;
        AppMethodBeat.m2505o(76458);
    }

    public final String bPj() {
        AppMethodBeat.m2504i(76459);
        if (this.hwh == null) {
            try {
                this.hwh = new JSONObject();
                JSONObject jSONObject = new JSONObject();
                this.hwh.put("wxcamera", jSONObject);
                jSONObject.put("model", this.model);
                jSONObject.put("apiLevel", this.ote);
                jSONObject.put("screen", String.format("%dx%d", new Object[]{Integer.valueOf(this.oth), Integer.valueOf(this.oti)}));
                jSONObject.put("crop", String.format("%dx%d", new Object[]{Integer.valueOf(this.otn), Integer.valueOf(this.oto)}));
                jSONObject.put("preview", String.format("%dx%d", new Object[]{Integer.valueOf(this.otp), Integer.valueOf(this.otq)}));
                jSONObject.put(FFmpegMetadataRetriever.METADATA_KEY_ENCODER, String.format("%dx%d", new Object[]{Integer.valueOf(this.otr), Integer.valueOf(this.ots)}));
                jSONObject.put(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, this.rotate);
                jSONObject.put("deviceoutfps", this.ott);
                jSONObject.put("recordfps", this.otu);
                jSONObject.put("recordertype", this.otv);
                jSONObject.put("needRotateEachFrame", this.etA);
                jSONObject.put("isNeedRealtimeScale", this.otw);
                jSONObject.put("resolutionLimit", this.fay);
                jSONObject.put("videoBitrate", this.videoBitrate);
                jSONObject.put("wait2playtime", this.otD);
                jSONObject.put("useback", this.otE);
                jSONObject.put("presetIndex", C12563j.ouz != null ? C12563j.ouz.ouK : -1);
                jSONObject.put("recorderOption", C1427q.etj.etG);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.CaptureStatistics", e, "buildJson error", new Object[0]);
            }
        }
        String jSONObject2 = this.hwh.toString();
        AppMethodBeat.m2505o(76459);
        return jSONObject2;
    }
}
