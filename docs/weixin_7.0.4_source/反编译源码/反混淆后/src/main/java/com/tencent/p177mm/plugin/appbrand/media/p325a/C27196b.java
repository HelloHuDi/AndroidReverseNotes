package com.tencent.p177mm.plugin.appbrand.media.p325a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p1176ag.C17875b;
import com.tencent.p177mm.p1176ag.C45139e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.media.a.b */
public final class C27196b {
    /* renamed from: b */
    public static C17875b m43209b(String str, String str2, String str3, String str4, String str5, String str6) {
        AppMethodBeat.m2504i(137804);
        if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3)) {
            C4990ab.m7413e("MicroMsg.Audio.AudioPlayerParamParser", "parseAudioPlayParam, sourceData or src is null, sourceData:%s, src:%s", str4, str3);
            AppMethodBeat.m2505o(137804);
            return null;
        }
        C4990ab.m7417i("MicroMsg.Audio.AudioPlayerParamParser", "parseAudioPlayParam audioId:%s, sourceData:%s", str2, str4);
        C17875b c17875b = new C17875b();
        c17875b.appId = str;
        c17875b.ckD = str2;
        c17875b.processName = str6;
        c17875b.clP = str3;
        c17875b.fromScene = 0;
        try {
            JSONObject jSONObject = new JSONObject(str4);
            int optInt = jSONObject.optInt("startTime", 0);
            boolean optBoolean = jSONObject.optBoolean("autoplay", false);
            boolean optBoolean2 = jSONObject.optBoolean("loop", false);
            double optDouble = jSONObject.optDouble("volume", 1.0d);
            c17875b.startTime = optInt;
            c17875b.fqJ = optInt;
            c17875b.fqK = optBoolean;
            c17875b.fqL = optBoolean2;
            c17875b.fqN = optDouble;
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("MicroMsg.Audio.AudioPlayerParamParser", e, "parseAudioPlayParam", new Object[0]);
        }
        if (str3.startsWith("file://")) {
            c17875b.filePath = str3.substring(7);
            C4990ab.m7417i("MicroMsg.Audio.AudioPlayerParamParser", "filePath:%s", c17875b.filePath);
        } else if (!(str3.startsWith("http://") || str3.startsWith("https://"))) {
            C45139e cC = C33446f.m54656cC(str3, str5);
            if (cC.isOpen()) {
                c17875b.filePath = str3;
                c17875b.fqV = cC;
            } else {
                C4990ab.m7413e("MicroMsg.Audio.AudioPlayerParamParser", "the wxa audioDataSource not found for src %s", str3);
                try {
                    cC.close();
                } catch (IOException e2) {
                    C4990ab.printErrStackTrace("MicroMsg.Audio.AudioPlayerParamParser", e2, "", new Object[0]);
                }
                AppMethodBeat.m2505o(137804);
                return null;
            }
        }
        AppMethodBeat.m2505o(137804);
        return c17875b;
    }
}
