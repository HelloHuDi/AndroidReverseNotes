package com.tencent.p177mm.plugin.websearch.api;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.p248j.C1761b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5736j;
import com.tencent.xweb.util.C6037d;
import java.util.Iterator;
import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.websearch.api.ao */
public final class C40190ao {
    private String ubb = "";
    private int ubc = 1;
    private long ubd;
    private String ube;
    String ubf;
    String ubg;

    public C40190ao(String str, String str2, String str3) {
        this.ube = str;
        this.ubf = str2;
        this.ubg = str3;
    }

    public final int afW() {
        AppMethodBeat.m2504i(124242);
        if (this.ubc <= 1 || cVB().lastModified() > this.ubd) {
            cVA();
        }
        int i = this.ubc;
        AppMethodBeat.m2505o(124242);
        return i;
    }

    public final String cVz() {
        AppMethodBeat.m2504i(124243);
        if (C5046bo.isNullOrNil(this.ubb) || cVB().lastModified() > this.ubd) {
            cVA();
        }
        String str = this.ubb;
        AppMethodBeat.m2505o(124243);
        return str;
    }

    public final void cVA() {
        AppMethodBeat.m2504i(124244);
        Properties k = C46400aa.m87338k(cVB());
        this.ubc = Integer.valueOf(k.getProperty("version", "1")).intValue();
        this.ubb = k.getProperty("buildjsmd5", "");
        this.ubd = System.currentTimeMillis();
        AppMethodBeat.m2505o(124244);
    }

    private C5728b cVB() {
        AppMethodBeat.m2504i(124245);
        C5728b c5728b = new C5728b(aLD(), "config.conf");
        AppMethodBeat.m2505o(124245);
        return c5728b;
    }

    private static String afT() {
        AppMethodBeat.m2504i(124246);
        String replace = C1761b.eSk.replace("/data/user/0", "/data/data");
        AppMethodBeat.m2505o(124246);
        return replace;
    }

    public final String aLD() {
        AppMethodBeat.m2504i(124247);
        C5728b c5728b = new C5728b(C40190ao.afT(), this.ube);
        if (!c5728b.exists()) {
            c5728b.mkdirs();
        }
        String w = C5736j.m8649w(c5728b.dMD());
        AppMethodBeat.m2505o(124247);
        return w;
    }

    public final String cVC() {
        AppMethodBeat.m2504i(124248);
        String w = C5736j.m8649w(new C5728b(aLD(), this.ubf).dMD());
        AppMethodBeat.m2505o(124248);
        return w;
    }

    public final boolean cVD() {
        AppMethodBeat.m2504i(124249);
        String property = C46400aa.m87338k(cVB()).getProperty("jsmd5");
        if (TextUtils.isEmpty(property)) {
            AppMethodBeat.m2505o(124249);
            return true;
        }
        try {
            JSONArray jSONArray = new JSONArray(property);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    property = (String) keys.next();
                    String cz = C6037d.m9501cz(aLD() + "/dist/" + property);
                    String string = jSONObject.getString(property);
                    if (!TextUtils.isEmpty(cz)) {
                        if (!cz.equals(string)) {
                        }
                    }
                    C4990ab.m7421w("MicroMsg.WebSearch.WebSearchTemplate", "isMd5Valid fail, fileName %s, fileMd5 %s, expect md5 %s", property, cz, string);
                    AppMethodBeat.m2505o(124249);
                    return false;
                }
            }
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("MicroMsg.WebSearch.WebSearchTemplate", e, "", new Object[0]);
        }
        AppMethodBeat.m2505o(124249);
        return true;
    }
}
