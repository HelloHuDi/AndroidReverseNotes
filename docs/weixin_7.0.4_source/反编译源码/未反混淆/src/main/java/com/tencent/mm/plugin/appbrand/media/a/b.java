package com.tencent.mm.plugin.appbrand.media.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.e;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    public static com.tencent.mm.ag.b b(String str, String str2, String str3, String str4, String str5, String str6) {
        AppMethodBeat.i(137804);
        if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3)) {
            ab.e("MicroMsg.Audio.AudioPlayerParamParser", "parseAudioPlayParam, sourceData or src is null, sourceData:%s, src:%s", str4, str3);
            AppMethodBeat.o(137804);
            return null;
        }
        ab.i("MicroMsg.Audio.AudioPlayerParamParser", "parseAudioPlayParam audioId:%s, sourceData:%s", str2, str4);
        com.tencent.mm.ag.b bVar = new com.tencent.mm.ag.b();
        bVar.appId = str;
        bVar.ckD = str2;
        bVar.processName = str6;
        bVar.clP = str3;
        bVar.fromScene = 0;
        try {
            JSONObject jSONObject = new JSONObject(str4);
            int optInt = jSONObject.optInt("startTime", 0);
            boolean optBoolean = jSONObject.optBoolean("autoplay", false);
            boolean optBoolean2 = jSONObject.optBoolean("loop", false);
            double optDouble = jSONObject.optDouble("volume", 1.0d);
            bVar.startTime = optInt;
            bVar.fqJ = optInt;
            bVar.fqK = optBoolean;
            bVar.fqL = optBoolean2;
            bVar.fqN = optDouble;
        } catch (JSONException e) {
            ab.printErrStackTrace("MicroMsg.Audio.AudioPlayerParamParser", e, "parseAudioPlayParam", new Object[0]);
        }
        if (str3.startsWith("file://")) {
            bVar.filePath = str3.substring(7);
            ab.i("MicroMsg.Audio.AudioPlayerParamParser", "filePath:%s", bVar.filePath);
        } else if (!(str3.startsWith("http://") || str3.startsWith("https://"))) {
            e cC = f.cC(str3, str5);
            if (cC.isOpen()) {
                bVar.filePath = str3;
                bVar.fqV = cC;
            } else {
                ab.e("MicroMsg.Audio.AudioPlayerParamParser", "the wxa audioDataSource not found for src %s", str3);
                try {
                    cC.close();
                } catch (IOException e2) {
                    ab.printErrStackTrace("MicroMsg.Audio.AudioPlayerParamParser", e2, "", new Object[0]);
                }
                AppMethodBeat.o(137804);
                return null;
            }
        }
        AppMethodBeat.o(137804);
        return bVar;
    }
}
