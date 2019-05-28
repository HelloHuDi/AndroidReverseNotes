package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.g;
import com.tencent.mm.vfs.h;
import com.tencent.mm.vfs.j;
import java.io.BufferedReader;
import java.io.Writer;

public final class RegionCodeDecoder {
    private static RegionCodeDecoder xZR = null;
    public static final String xZS = (e.eSi + "MicroMsg/regioncode/");
    public String xZT = "";
    private String xZU = "";

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
        AppMethodBeat.i(60229);
        AppMethodBeat.o(60229);
    }

    public static RegionCodeDecoder duj() {
        AppMethodBeat.i(60211);
        if (xZR == null) {
            xZR = new RegionCodeDecoder();
        }
        RegionCodeDecoder regionCodeDecoder = xZR;
        if (!aa.dor().equals(regionCodeDecoder.xZT)) {
            regionCodeDecoder.drS();
        }
        regionCodeDecoder = xZR;
        AppMethodBeat.o(60211);
        return regionCodeDecoder;
    }

    public final void drS() {
        AppMethodBeat.i(60212);
        b bVar = new b(xZS);
        if (!bVar.exists()) {
            bVar.mkdirs();
            n(bVar);
        }
        String[] list = bVar.list();
        if (list == null || list.length == 0) {
            n(bVar);
        }
        this.xZT = aa.dor();
        String duk = duk();
        if (bo.isNullOrNil(duk)) {
            ab.e("MicroMsg.RegionCodeDecoder", "buildMap error, no codeFile found, curLang: " + this.xZT);
            AppMethodBeat.o(60212);
            return;
        }
        duk = xZS + duk;
        String apO = apO(duk);
        if (bo.isNullOrNil(apO)) {
            ab.e("MicroMsg.RegionCodeDecoder", "buildMap error, no codeFile found after verify, curLang: " + this.xZT);
            AppMethodBeat.o(60212);
        } else if (!bo.isNullOrNil(this.xZU) && this.xZU.equals(duk) && duk.equals(apO)) {
            AppMethodBeat.o(60212);
        } else {
            ab.w("MicroMsg.RegionCodeDecoder", "buildMap, after verify, codeFile %s is used. curLang: %s", new b(apO).getName(), this.xZT);
            this.xZU = apO;
            DecoderJni.buildFromFile(this.xZU);
            AppMethodBeat.o(60212);
        }
    }

    private static String apO(String str) {
        boolean z;
        AppMethodBeat.i(60213);
        b bVar = new b(str);
        String l = l(bVar);
        if (bo.isNullOrNil(l)) {
            z = false;
        } else {
            z = l.equals(m(bVar));
        }
        if (z) {
            AppMethodBeat.o(60213);
            return str;
        }
        int i;
        b bVar2;
        if (com.tencent.mm.vfs.e.y("assets:///regioncode/" + bVar.getName(), str) > 0) {
            i = 1;
        } else {
            i = 0;
        }
        if (i == 0) {
            bVar2 = new b(bVar.dMC(), "mmregioncode_en.txt");
            str = j.w(bVar2.dMD());
            if (com.tencent.mm.vfs.e.y("assets:///regioncode/mmregioncode_en.txt", j.w(bVar2.dMD())) > 0) {
                i = 1;
            } else {
                i = 0;
            }
            if (i == 0) {
                AppMethodBeat.o(60213);
                return null;
            }
        }
        bVar2 = new b(str);
        a(bVar2, bVar2.dMC());
        ab.w("MicroMsg.RegionCodeDecoder", "Verifying codeFile: %s failed, after fallback, %s will be used.", bVar.getName(), bVar2.getName());
        AppMethodBeat.o(60213);
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0064 A:{SYNTHETIC, Splitter:B:21:0x0064} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static String l(b bVar) {
        Throwable th;
        String str = null;
        AppMethodBeat.i(60214);
        b bVar2 = new b(j.w(bVar.dMD()) + ".hash");
        if (bVar2.exists()) {
            BufferedReader bufferedReader;
            try {
                bufferedReader = new BufferedReader(new g(bVar2));
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
                AppMethodBeat.o(60214);
                throw th;
            }
            AppMethodBeat.o(60214);
        } else {
            AppMethodBeat.o(60214);
        }
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0089 A:{SYNTHETIC, Splitter:B:28:0x0089} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0079 A:{SYNTHETIC, Splitter:B:20:0x0079} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(b bVar, b bVar2) {
        Writer hVar;
        Throwable th;
        AppMethodBeat.i(60215);
        ab.i("MicroMsg.RegionCodeDecoder", "Generating hash file for: %s", bVar.getName());
        b bVar3 = new b(bVar2, bVar.getName() + ".hash");
        String m = m(bVar);
        if (!bo.isNullOrNil(m)) {
            if (!bVar3.exists()) {
                bVar3.dMC().mkdirs();
            }
            try {
                hVar = new h(bVar3);
            } catch (Throwable th2) {
                th = th2;
                hVar = null;
                if (hVar != null) {
                }
                AppMethodBeat.o(60215);
                throw th;
            }
            try {
                hVar.write(m);
                try {
                    hVar.close();
                    AppMethodBeat.o(60215);
                    return;
                } catch (Throwable th3) {
                    AppMethodBeat.o(60215);
                    return;
                }
            } catch (Throwable th4) {
                th = th4;
                ab.printErrStackTrace("MicroMsg.RegionCodeDecoder", th, "Failed to save hash file of %s", bVar.getName());
                if (hVar != null) {
                }
                AppMethodBeat.o(60215);
            }
        }
        AppMethodBeat.o(60215);
    }

    private synchronized void n(b bVar) {
        synchronized (this) {
            AppMethodBeat.i(60217);
            String[] strArr = null;
            if (bVar.exists()) {
                strArr = bVar.list();
            }
            if (!bVar.exists() || strArr == null || strArr.length == 0) {
                try {
                    for (Object obj : ah.getContext().getAssets().list("regioncode")) {
                        ab.i("MicroMsg.RegionCodeDecoder", "from:%s,  to:%s", "regioncode/".concat(String.valueOf(obj)), j.w(bVar.mUri) + "/" + obj);
                        String str = j.w(bVar.mUri) + "/" + obj;
                        com.tencent.mm.vfs.e.y("assets:///regioncode/".concat(String.valueOf(obj)), str);
                        a(new b(str), bVar);
                    }
                    AppMethodBeat.o(60217);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.RegionCodeDecoder", e, "", new Object[0]);
                    AppMethodBeat.o(60217);
                }
            } else {
                AppMethodBeat.o(60217);
            }
        }
        return;
    }

    public final String duk() {
        AppMethodBeat.i(60218);
        String str = "mmregioncode_" + (this.xZT.equalsIgnoreCase("zh_HK") ? "zh_TW" : this.xZT) + ".txt";
        String str2 = "mmregioncode_en.txt";
        b bVar = new b(xZS);
        if (bVar.exists()) {
            String[] list = bVar.list();
            if (list == null || list.length == 0) {
                AppMethodBeat.o(60218);
                return null;
            }
            Object obj = null;
            for (String str3 : list) {
                if (str3.equals(str)) {
                    AppMethodBeat.o(60218);
                    return str3;
                }
                if (obj == null && str3.equals(str2)) {
                    obj = 1;
                }
            }
            if (obj != null) {
                AppMethodBeat.o(60218);
                return str2;
            }
            AppMethodBeat.o(60218);
            return null;
        }
        bVar.mkdirs();
        AppMethodBeat.o(60218);
        return null;
    }

    public static final String aC(String str, String str2, String str3) {
        AppMethodBeat.i(60219);
        StringBuffer stringBuffer = new StringBuffer();
        if (!bo.isNullOrNil(str)) {
            stringBuffer.append(str);
            if (!bo.isNullOrNil(str2)) {
                stringBuffer.append('_');
                stringBuffer.append(str2);
                if (!bo.isNullOrNil(str3)) {
                    stringBuffer.append('_');
                    stringBuffer.append(str3);
                }
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(60219);
        return stringBuffer2;
    }

    public static String apP(String str) {
        AppMethodBeat.i(60220);
        if (bo.isNullOrNil(str) || !aa.amv(str)) {
            AppMethodBeat.o(60220);
            return null;
        }
        if (str.equalsIgnoreCase("zh_HK")) {
            str = "zh_TW";
        }
        String str2 = xZS + "mmregioncode_" + str + ".txt";
        AppMethodBeat.o(60220);
        return str2;
    }

    public static final boolean apQ(String str) {
        AppMethodBeat.i(60221);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(60221);
            return false;
        }
        boolean equalsIgnoreCase = str.equalsIgnoreCase("cn");
        AppMethodBeat.o(60221);
        return equalsIgnoreCase;
    }

    public static String getLocName(String str) {
        AppMethodBeat.i(60222);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(60222);
            return null;
        }
        String locName = DecoderJni.getLocName(str);
        AppMethodBeat.o(60222);
        return locName;
    }

    public final Region[] dul() {
        AppMethodBeat.i(60226);
        if (bo.isNullOrNil(this.xZU)) {
            AppMethodBeat.o(60226);
            return null;
        }
        Region[] countries = DecoderJni.getCountries(this.xZU);
        AppMethodBeat.o(60226);
        return countries;
    }

    public final Region[] apS(String str) {
        AppMethodBeat.i(60227);
        if (bo.isNullOrNil(this.xZU) || bo.isNullOrNil(str)) {
            AppMethodBeat.o(60227);
            return null;
        }
        Region[] provinces = DecoderJni.getProvinces(this.xZU, str);
        AppMethodBeat.o(60227);
        return provinces;
    }

    public final Region[] ie(String str, String str2) {
        AppMethodBeat.i(60228);
        if (bo.isNullOrNil(this.xZU) || bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
            AppMethodBeat.o(60228);
            return null;
        }
        Region[] cities = DecoderJni.getCities(this.xZU, str, str2);
        AppMethodBeat.o(60228);
        return cities;
    }

    private static String m(b bVar) {
        AppMethodBeat.i(60216);
        String atg = com.tencent.mm.vfs.e.atg(j.w(bVar.mUri));
        if (bo.isNullOrNil(atg)) {
            ab.e("MicroMsg.RegionCodeDecoder", "Failed to calculate hash for file %s", bVar.getName());
            AppMethodBeat.o(60216);
            return null;
        }
        atg = ag.ck(atg + "#" + bVar.lastModified() + "#" + q.LK());
        AppMethodBeat.o(60216);
        return atg;
    }

    public static String apR(String str) {
        AppMethodBeat.i(60223);
        String locName = getLocName(str);
        if (bo.isNullOrNil(locName)) {
            locName = bo.nullAsNil(str);
            AppMethodBeat.o(60223);
            return locName;
        }
        AppMethodBeat.o(60223);
        return locName;
    }

    public static String id(String str, String str2) {
        String str3 = null;
        AppMethodBeat.i(60224);
        if (!(bo.isNullOrNil(str) || bo.isNullOrNil(str2))) {
            str3 = getLocName(aC(str, str2, null));
        }
        if (bo.isNullOrNil(str3)) {
            str3 = bo.nullAsNil(str2);
            AppMethodBeat.o(60224);
            return str3;
        }
        AppMethodBeat.o(60224);
        return str3;
    }

    public static String aD(String str, String str2, String str3) {
        String str4;
        AppMethodBeat.i(60225);
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2) || bo.isNullOrNil(str3)) {
            str4 = null;
        } else {
            str4 = getLocName(aC(str, str2, str3));
        }
        if (bo.isNullOrNil(str4)) {
            str4 = bo.nullAsNil(str3);
            AppMethodBeat.o(60225);
            return str4;
        }
        AppMethodBeat.o(60225);
        return str4;
    }
}
