package com.tencent.mm.plugin.websearch.api;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.j;
import com.tencent.xweb.util.d;
import java.util.Iterator;
import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ao {
    private String ubb = "";
    private int ubc = 1;
    private long ubd;
    private String ube;
    String ubf;
    String ubg;

    public ao(String str, String str2, String str3) {
        this.ube = str;
        this.ubf = str2;
        this.ubg = str3;
    }

    public final int afW() {
        AppMethodBeat.i(124242);
        if (this.ubc <= 1 || cVB().lastModified() > this.ubd) {
            cVA();
        }
        int i = this.ubc;
        AppMethodBeat.o(124242);
        return i;
    }

    public final String cVz() {
        AppMethodBeat.i(124243);
        if (bo.isNullOrNil(this.ubb) || cVB().lastModified() > this.ubd) {
            cVA();
        }
        String str = this.ubb;
        AppMethodBeat.o(124243);
        return str;
    }

    public final void cVA() {
        AppMethodBeat.i(124244);
        Properties k = aa.k(cVB());
        this.ubc = Integer.valueOf(k.getProperty("version", "1")).intValue();
        this.ubb = k.getProperty("buildjsmd5", "");
        this.ubd = System.currentTimeMillis();
        AppMethodBeat.o(124244);
    }

    private b cVB() {
        AppMethodBeat.i(124245);
        b bVar = new b(aLD(), "config.conf");
        AppMethodBeat.o(124245);
        return bVar;
    }

    private static String afT() {
        AppMethodBeat.i(124246);
        String replace = com.tencent.mm.loader.j.b.eSk.replace("/data/user/0", "/data/data");
        AppMethodBeat.o(124246);
        return replace;
    }

    public final String aLD() {
        AppMethodBeat.i(124247);
        b bVar = new b(afT(), this.ube);
        if (!bVar.exists()) {
            bVar.mkdirs();
        }
        String w = j.w(bVar.dMD());
        AppMethodBeat.o(124247);
        return w;
    }

    public final String cVC() {
        AppMethodBeat.i(124248);
        String w = j.w(new b(aLD(), this.ubf).dMD());
        AppMethodBeat.o(124248);
        return w;
    }

    public final boolean cVD() {
        AppMethodBeat.i(124249);
        String property = aa.k(cVB()).getProperty("jsmd5");
        if (TextUtils.isEmpty(property)) {
            AppMethodBeat.o(124249);
            return true;
        }
        try {
            JSONArray jSONArray = new JSONArray(property);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    property = (String) keys.next();
                    String cz = d.cz(aLD() + "/dist/" + property);
                    String string = jSONObject.getString(property);
                    if (!TextUtils.isEmpty(cz)) {
                        if (!cz.equals(string)) {
                        }
                    }
                    ab.w("MicroMsg.WebSearch.WebSearchTemplate", "isMd5Valid fail, fileName %s, fileMd5 %s, expect md5 %s", property, cz, string);
                    AppMethodBeat.o(124249);
                    return false;
                }
            }
        } catch (JSONException e) {
            ab.printErrStackTrace("MicroMsg.WebSearch.WebSearchTemplate", e, "", new Object[0]);
        }
        AppMethodBeat.o(124249);
        return true;
    }
}
