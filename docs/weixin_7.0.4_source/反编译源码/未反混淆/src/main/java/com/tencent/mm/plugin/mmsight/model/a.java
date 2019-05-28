package com.tencent.mm.plugin.mmsight.model;

import android.app.ActivityManager;
import android.graphics.Point;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import org.json.JSONObject;

public final class a {
    static a otd;
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

    public a() {
        AppMethodBeat.i(76456);
        AppMethodBeat.o(76456);
    }

    public static a bPi() {
        AppMethodBeat.i(76457);
        if (otd == null) {
            reset();
        }
        a aVar = otd;
        AppMethodBeat.o(76457);
        return aVar;
    }

    public static void reset() {
        AppMethodBeat.i(76458);
        a aVar = new a();
        otd = aVar;
        aVar.fXT = ((ActivityManager) ah.getContext().getSystemService("activity")).getLargeMemoryClass();
        otd.otf = d.ev(ah.getContext());
        otd.otg = m.Lx();
        Point eu = d.eu(ah.getContext());
        otd.oth = eu.x;
        otd.oti = eu.y;
        AppMethodBeat.o(76458);
    }

    public final String bPj() {
        AppMethodBeat.i(76459);
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
                jSONObject.put("presetIndex", j.ouz != null ? j.ouz.ouK : -1);
                jSONObject.put("recorderOption", q.etj.etG);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.CaptureStatistics", e, "buildJson error", new Object[0]);
            }
        }
        String jSONObject2 = this.hwh.toString();
        AppMethodBeat.o(76459);
        return jSONObject2;
    }
}
