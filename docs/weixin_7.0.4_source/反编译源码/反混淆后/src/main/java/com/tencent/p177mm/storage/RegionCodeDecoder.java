package com.tencent.p177mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5732g;
import com.tencent.p177mm.vfs.C5733h;
import com.tencent.p177mm.vfs.C5736j;
import java.io.BufferedReader;
import java.io.Writer;

/* renamed from: com.tencent.mm.storage.RegionCodeDecoder */
public final class RegionCodeDecoder {
    private static RegionCodeDecoder xZR = null;
    public static final String xZS = (C6457e.eSi + "MicroMsg/regioncode/");
    public String xZT = "";
    private String xZU = "";

    /* renamed from: com.tencent.mm.storage.RegionCodeDecoder$DecoderJni */
    static class DecoderJni {
        public static native void buildFromFile(String str);

        public static native Region[] getCities(String str, String str2, String str3);

        public static native Region[] getCountries(String str);

        public static native String getLocName(String str);

        public static native Region[] getProvinces(String str, String str2);

        public static native void release();

        private DecoderJni() {
        }
    }

    /* renamed from: com.tencent.mm.storage.RegionCodeDecoder$Region */
    public static class Region {
        private String code;
        private String countryCode;
        private boolean hasChildren = false;
        private boolean isCity = false;
        private boolean isCountry = false;
        private boolean isProvince = false;
        private String name;
        private Region parent = null;

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }

        public String getCode() {
            return this.code;
        }

        public void setCode(String str) {
            this.code = str;
        }

        public boolean hasChildren() {
            return this.hasChildren;
        }

        public void setHasChildren(boolean z) {
            this.hasChildren = z;
        }

        public void setParent(Region region) {
            this.parent = region;
        }

        public Region getParent() {
            return this.parent;
        }

        public void setCountryCode(String str) {
            this.countryCode = str;
        }

        public String getCountryCode() {
            return this.countryCode;
        }

        public boolean isCountry() {
            return this.isCountry;
        }

        public void setCountry(boolean z) {
            this.isCountry = z;
        }

        public boolean isProvince() {
            return this.isProvince;
        }

        public void setProvince(boolean z) {
            this.isProvince = z;
        }

        public boolean isCity() {
            return this.isCity;
        }

        public void setCity(boolean z) {
            this.isCity = z;
        }
    }

    static {
        AppMethodBeat.m2504i(60229);
        AppMethodBeat.m2505o(60229);
    }

    public static RegionCodeDecoder duj() {
        AppMethodBeat.m2504i(60211);
        if (xZR == null) {
            xZR = new RegionCodeDecoder();
        }
        RegionCodeDecoder regionCodeDecoder = xZR;
        if (!C4988aa.dor().equals(regionCodeDecoder.xZT)) {
            regionCodeDecoder.drS();
        }
        regionCodeDecoder = xZR;
        AppMethodBeat.m2505o(60211);
        return regionCodeDecoder;
    }

    public final void drS() {
        AppMethodBeat.m2504i(60212);
        C5728b c5728b = new C5728b(xZS);
        if (!c5728b.exists()) {
            c5728b.mkdirs();
            m7801n(c5728b);
        }
        String[] list = c5728b.list();
        if (list == null || list.length == 0) {
            m7801n(c5728b);
        }
        this.xZT = C4988aa.dor();
        String duk = duk();
        if (C5046bo.isNullOrNil(duk)) {
            C4990ab.m7412e("MicroMsg.RegionCodeDecoder", "buildMap error, no codeFile found, curLang: " + this.xZT);
            AppMethodBeat.m2505o(60212);
            return;
        }
        duk = xZS + duk;
        String apO = RegionCodeDecoder.apO(duk);
        if (C5046bo.isNullOrNil(apO)) {
            C4990ab.m7412e("MicroMsg.RegionCodeDecoder", "buildMap error, no codeFile found after verify, curLang: " + this.xZT);
            AppMethodBeat.m2505o(60212);
        } else if (!C5046bo.isNullOrNil(this.xZU) && this.xZU.equals(duk) && duk.equals(apO)) {
            AppMethodBeat.m2505o(60212);
        } else {
            C4990ab.m7421w("MicroMsg.RegionCodeDecoder", "buildMap, after verify, codeFile %s is used. curLang: %s", new C5728b(apO).getName(), this.xZT);
            this.xZU = apO;
            DecoderJni.buildFromFile(this.xZU);
            AppMethodBeat.m2505o(60212);
        }
    }

    private static String apO(String str) {
        boolean z;
        AppMethodBeat.m2504i(60213);
        C5728b c5728b = new C5728b(str);
        String l = RegionCodeDecoder.m7799l(c5728b);
        if (C5046bo.isNullOrNil(l)) {
            z = false;
        } else {
            z = l.equals(RegionCodeDecoder.m7800m(c5728b));
        }
        if (z) {
            AppMethodBeat.m2505o(60213);
            return str;
        }
        int i;
        C5728b c5728b2;
        if (C5730e.m8644y("assets:///regioncode/" + c5728b.getName(), str) > 0) {
            i = 1;
        } else {
            i = 0;
        }
        if (i == 0) {
            c5728b2 = new C5728b(c5728b.dMC(), "mmregioncode_en.txt");
            str = C5736j.m8649w(c5728b2.dMD());
            if (C5730e.m8644y("assets:///regioncode/mmregioncode_en.txt", C5736j.m8649w(c5728b2.dMD())) > 0) {
                i = 1;
            } else {
                i = 0;
            }
            if (i == 0) {
                AppMethodBeat.m2505o(60213);
                return null;
            }
        }
        c5728b2 = new C5728b(str);
        RegionCodeDecoder.m7795a(c5728b2, c5728b2.dMC());
        C4990ab.m7421w("MicroMsg.RegionCodeDecoder", "Verifying codeFile: %s failed, after fallback, %s will be used.", c5728b.getName(), c5728b2.getName());
        AppMethodBeat.m2505o(60213);
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0064 A:{SYNTHETIC, Splitter:B:21:0x0064} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: l */
    private static String m7799l(C5728b c5728b) {
        Throwable th;
        String str = null;
        AppMethodBeat.m2504i(60214);
        C5728b c5728b2 = new C5728b(C5736j.m8649w(c5728b.dMD()) + ".hash");
        if (c5728b2.exists()) {
            BufferedReader bufferedReader;
            try {
                bufferedReader = new BufferedReader(new C5732g(c5728b2));
                try {
                    str = bufferedReader.readLine();
                    try {
                        bufferedReader.close();
                    } catch (Throwable th2) {
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = str;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th5) {
                    }
                }
                AppMethodBeat.m2505o(60214);
                throw th;
            }
            AppMethodBeat.m2505o(60214);
        } else {
            AppMethodBeat.m2505o(60214);
        }
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0089 A:{SYNTHETIC, Splitter:B:28:0x0089} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0079 A:{SYNTHETIC, Splitter:B:20:0x0079} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static void m7795a(C5728b c5728b, C5728b c5728b2) {
        Writer c5733h;
        Throwable th;
        AppMethodBeat.m2504i(60215);
        C4990ab.m7417i("MicroMsg.RegionCodeDecoder", "Generating hash file for: %s", c5728b.getName());
        C5728b c5728b3 = new C5728b(c5728b2, c5728b.getName() + ".hash");
        String m = RegionCodeDecoder.m7800m(c5728b);
        if (!C5046bo.isNullOrNil(m)) {
            if (!c5728b3.exists()) {
                c5728b3.dMC().mkdirs();
            }
            try {
                c5733h = new C5733h(c5728b3);
            } catch (Throwable th2) {
                th = th2;
                c5733h = null;
                if (c5733h != null) {
                }
                AppMethodBeat.m2505o(60215);
                throw th;
            }
            try {
                c5733h.write(m);
                try {
                    c5733h.close();
                    AppMethodBeat.m2505o(60215);
                    return;
                } catch (Throwable th3) {
                    AppMethodBeat.m2505o(60215);
                    return;
                }
            } catch (Throwable th4) {
                th = th4;
                C4990ab.printErrStackTrace("MicroMsg.RegionCodeDecoder", th, "Failed to save hash file of %s", c5728b.getName());
                if (c5733h != null) {
                }
                AppMethodBeat.m2505o(60215);
            }
        }
        AppMethodBeat.m2505o(60215);
    }

    /* renamed from: n */
    private synchronized void m7801n(C5728b c5728b) {
        synchronized (this) {
            AppMethodBeat.m2504i(60217);
            String[] strArr = null;
            if (c5728b.exists()) {
                strArr = c5728b.list();
            }
            if (!c5728b.exists() || strArr == null || strArr.length == 0) {
                try {
                    for (Object obj : C4996ah.getContext().getAssets().list("regioncode")) {
                        C4990ab.m7417i("MicroMsg.RegionCodeDecoder", "from:%s,  to:%s", "regioncode/".concat(String.valueOf(obj)), C5736j.m8649w(c5728b.mUri) + "/" + obj);
                        String str = C5736j.m8649w(c5728b.mUri) + "/" + obj;
                        C5730e.m8644y("assets:///regioncode/".concat(String.valueOf(obj)), str);
                        RegionCodeDecoder.m7795a(new C5728b(str), c5728b);
                    }
                    AppMethodBeat.m2505o(60217);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.RegionCodeDecoder", e, "", new Object[0]);
                    AppMethodBeat.m2505o(60217);
                }
            } else {
                AppMethodBeat.m2505o(60217);
            }
        }
        return;
    }

    public final String duk() {
        AppMethodBeat.m2504i(60218);
        String str = "mmregioncode_" + (this.xZT.equalsIgnoreCase("zh_HK") ? "zh_TW" : this.xZT) + ".txt";
        String str2 = "mmregioncode_en.txt";
        C5728b c5728b = new C5728b(xZS);
        if (c5728b.exists()) {
            String[] list = c5728b.list();
            if (list == null || list.length == 0) {
                AppMethodBeat.m2505o(60218);
                return null;
            }
            Object obj = null;
            for (String str3 : list) {
                if (str3.equals(str)) {
                    AppMethodBeat.m2505o(60218);
                    return str3;
                }
                if (obj == null && str3.equals(str2)) {
                    obj = 1;
                }
            }
            if (obj != null) {
                AppMethodBeat.m2505o(60218);
                return str2;
            }
            AppMethodBeat.m2505o(60218);
            return null;
        }
        c5728b.mkdirs();
        AppMethodBeat.m2505o(60218);
        return null;
    }

    /* renamed from: aC */
    public static final String m7796aC(String str, String str2, String str3) {
        AppMethodBeat.m2504i(60219);
        StringBuffer stringBuffer = new StringBuffer();
        if (!C5046bo.isNullOrNil(str)) {
            stringBuffer.append(str);
            if (!C5046bo.isNullOrNil(str2)) {
                stringBuffer.append('_');
                stringBuffer.append(str2);
                if (!C5046bo.isNullOrNil(str3)) {
                    stringBuffer.append('_');
                    stringBuffer.append(str3);
                }
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(60219);
        return stringBuffer2;
    }

    public static String apP(String str) {
        AppMethodBeat.m2504i(60220);
        if (C5046bo.isNullOrNil(str) || !C4988aa.amv(str)) {
            AppMethodBeat.m2505o(60220);
            return null;
        }
        if (str.equalsIgnoreCase("zh_HK")) {
            str = "zh_TW";
        }
        String str2 = xZS + "mmregioncode_" + str + ".txt";
        AppMethodBeat.m2505o(60220);
        return str2;
    }

    public static final boolean apQ(String str) {
        AppMethodBeat.m2504i(60221);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(60221);
            return false;
        }
        boolean equalsIgnoreCase = str.equalsIgnoreCase("cn");
        AppMethodBeat.m2505o(60221);
        return equalsIgnoreCase;
    }

    public static String getLocName(String str) {
        AppMethodBeat.m2504i(60222);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(60222);
            return null;
        }
        String locName = DecoderJni.getLocName(str);
        AppMethodBeat.m2505o(60222);
        return locName;
    }

    public final Region[] dul() {
        AppMethodBeat.m2504i(60226);
        if (C5046bo.isNullOrNil(this.xZU)) {
            AppMethodBeat.m2505o(60226);
            return null;
        }
        Region[] countries = DecoderJni.getCountries(this.xZU);
        AppMethodBeat.m2505o(60226);
        return countries;
    }

    public final Region[] apS(String str) {
        AppMethodBeat.m2504i(60227);
        if (C5046bo.isNullOrNil(this.xZU) || C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(60227);
            return null;
        }
        Region[] provinces = DecoderJni.getProvinces(this.xZU, str);
        AppMethodBeat.m2505o(60227);
        return provinces;
    }

    /* renamed from: ie */
    public final Region[] mo10524ie(String str, String str2) {
        AppMethodBeat.m2504i(60228);
        if (C5046bo.isNullOrNil(this.xZU) || C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2)) {
            AppMethodBeat.m2505o(60228);
            return null;
        }
        Region[] cities = DecoderJni.getCities(this.xZU, str, str2);
        AppMethodBeat.m2505o(60228);
        return cities;
    }

    /* renamed from: m */
    private static String m7800m(C5728b c5728b) {
        AppMethodBeat.m2504i(60216);
        String atg = C5730e.atg(C5736j.m8649w(c5728b.mUri));
        if (C5046bo.isNullOrNil(atg)) {
            C4990ab.m7413e("MicroMsg.RegionCodeDecoder", "Failed to calculate hash for file %s", c5728b.getName());
            AppMethodBeat.m2505o(60216);
            return null;
        }
        atg = C4995ag.m7428ck(atg + "#" + c5728b.lastModified() + "#" + C1427q.m3026LK());
        AppMethodBeat.m2505o(60216);
        return atg;
    }

    public static String apR(String str) {
        AppMethodBeat.m2504i(60223);
        String locName = RegionCodeDecoder.getLocName(str);
        if (C5046bo.isNullOrNil(locName)) {
            locName = C5046bo.nullAsNil(str);
            AppMethodBeat.m2505o(60223);
            return locName;
        }
        AppMethodBeat.m2505o(60223);
        return locName;
    }

    /* renamed from: id */
    public static String m7798id(String str, String str2) {
        String str3 = null;
        AppMethodBeat.m2504i(60224);
        if (!(C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2))) {
            str3 = RegionCodeDecoder.getLocName(RegionCodeDecoder.m7796aC(str, str2, null));
        }
        if (C5046bo.isNullOrNil(str3)) {
            str3 = C5046bo.nullAsNil(str2);
            AppMethodBeat.m2505o(60224);
            return str3;
        }
        AppMethodBeat.m2505o(60224);
        return str3;
    }

    /* renamed from: aD */
    public static String m7797aD(String str, String str2, String str3) {
        String str4;
        AppMethodBeat.m2504i(60225);
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2) || C5046bo.isNullOrNil(str3)) {
            str4 = null;
        } else {
            str4 = RegionCodeDecoder.getLocName(RegionCodeDecoder.m7796aC(str, str2, str3));
        }
        if (C5046bo.isNullOrNil(str4)) {
            str4 = C5046bo.nullAsNil(str3);
            AppMethodBeat.m2505o(60225);
            return str4;
        }
        AppMethodBeat.m2505o(60225);
        return str4;
    }
}
