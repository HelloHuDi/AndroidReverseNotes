package com.tencent.p177mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.protocal.protobuf.bcr;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.RegionCodeDecoder;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.model.bp */
public final class C32782bp {
    public String countryCode = "";
    public int dtS = 0;
    public int dub = 0;
    public String dug = "";
    private String fnm = "";
    private String fnn = "";
    public String fno = "";
    public String fnp = "";
    public String signature = "";

    /* renamed from: com.tencent.mm.model.bp$a */
    static class C32781a {
        /* renamed from: am */
        public static boolean m53558am(String str, String str2) {
            AppMethodBeat.m2504i(59924);
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(59924);
                return true;
            }
            String decode = C32781a.decode(C32781a.encode(str));
            if (C5046bo.isNullOrNil(decode) || !decode.equals(str2)) {
                AppMethodBeat.m2505o(59924);
                return true;
            }
            AppMethodBeat.m2505o(59924);
            return false;
        }

        private static String encode(String str) {
            AppMethodBeat.m2504i(59925);
            String str2 = "";
            try {
                for (char c : str.toCharArray()) {
                    str2 = str2 + String.format("%02x", new Object[]{Integer.valueOf(c)});
                }
                AppMethodBeat.m2505o(59925);
                return str2;
            } catch (Exception e) {
                str2 = "";
                AppMethodBeat.m2505o(59925);
                return str2;
            }
        }

        private static String decode(String str) {
            AppMethodBeat.m2504i(59926);
            String str2 = "";
            if (C5046bo.isNullOrNil(str) || str.length() % 2 != 0) {
                str2 = "";
                AppMethodBeat.m2505o(59926);
                return str2;
            }
            int i = 0;
            while (i < str.length()) {
                try {
                    str2 = str2 + ((char) Integer.parseInt(str.substring(i, i + 2), 16));
                    i += 2;
                } catch (Exception e) {
                    str2 = "";
                    AppMethodBeat.m2505o(59926);
                    return str2;
                }
            }
            AppMethodBeat.m2505o(59926);
            return str2;
        }
    }

    public static C32782bp aao() {
        AppMethodBeat.m2504i(59927);
        C32782bp c32782bp = new C32782bp();
        c32782bp.dub = 1;
        c32782bp.dtS = C5046bo.m7512a((Integer) C1720g.m3536RP().mo5239Ry().get(12290, null), 0);
        c32782bp.fnm = (String) C1720g.m3536RP().mo5239Ry().get(12293, null);
        c32782bp.fnn = (String) C1720g.m3536RP().mo5239Ry().get(12292, null);
        c32782bp.signature = (String) C1720g.m3536RP().mo5239Ry().get(12291, null);
        c32782bp.dug = (String) C1720g.m3536RP().mo5239Ry().get(12307, null);
        c32782bp.countryCode = (String) C1720g.m3536RP().mo5239Ry().get(12324, null);
        c32782bp.fnp = (String) C1720g.m3536RP().mo5239Ry().get(12325, null);
        c32782bp.fno = (String) C1720g.m3536RP().mo5239Ry().get(12326, null);
        AppMethodBeat.m2505o(59927);
        return c32782bp;
    }

    public static C32782bp aap() {
        AppMethodBeat.m2504i(59928);
        if (C5046bo.m7512a((Integer) C1720g.m3536RP().mo5239Ry().get(12289, null), 0) == 0) {
            AppMethodBeat.m2505o(59928);
            return null;
        }
        C32782bp aao = C32782bp.aao();
        AppMethodBeat.m2505o(59928);
        return aao;
    }

    /* renamed from: a */
    public static bcr m53559a(C32782bp c32782bp) {
        int i;
        AppMethodBeat.m2504i(59929);
        C1720g.m3536RP().mo5239Ry().set(12289, Integer.valueOf(c32782bp.dub));
        C1720g.m3536RP().mo5239Ry().set(12290, Integer.valueOf(c32782bp.dtS));
        if (C32781a.m53558am((String) C1720g.m3536RP().mo5239Ry().get(12293, null), c32782bp.getProvince())) {
            C1720g.m3536RP().mo5239Ry().set(12293, c32782bp.getProvince());
        }
        if (C32781a.m53558am((String) C1720g.m3536RP().mo5239Ry().get(12292, null), c32782bp.getCity())) {
            C1720g.m3536RP().mo5239Ry().set(12292, c32782bp.getCity());
        }
        if (C32781a.m53558am((String) C1720g.m3536RP().mo5239Ry().get(12291, null), c32782bp.signature)) {
            C1720g.m3536RP().mo5239Ry().set(12291, c32782bp.signature);
        }
        if (C32781a.m53558am((String) C1720g.m3536RP().mo5239Ry().get(12307, null), c32782bp.dug)) {
            C1720g.m3536RP().mo5239Ry().set(12307, c32782bp.dug);
        }
        if (C32781a.m53558am((String) C1720g.m3536RP().mo5239Ry().get(12324, null), c32782bp.countryCode)) {
            C1720g.m3536RP().mo5239Ry().set(12324, c32782bp.countryCode);
        }
        if (C32781a.m53558am((String) C1720g.m3536RP().mo5239Ry().get(12325, null), c32782bp.fnp)) {
            C1720g.m3536RP().mo5239Ry().set(12325, c32782bp.fnp);
        }
        if (C32781a.m53558am((String) C1720g.m3536RP().mo5239Ry().get(12326, null), c32782bp.fno)) {
            C1720g.m3536RP().mo5239Ry().set(12326, c32782bp.fno);
        }
        bcr bcr = new bcr();
        bcr.wGW = 128;
        bcr.wcB = new bts().alV("");
        bcr.wyX = new bts().alV("");
        bcr.vCf = 0;
        bcr.wGX = new bts().alV("");
        bcr.wGY = new bts().alV("");
        bcr.jBT = 0;
        byte[] e = C5730e.m8632e("", 0, -1);
        bcr.wGU = new C1332b(e == null ? new byte[0] : e);
        if (e == null) {
            i = 0;
        } else {
            i = e.length;
        }
        bcr.wGT = i;
        bcr.guN = c32782bp.dtS;
        bcr.guR = c32782bp.dub;
        bcr.guQ = C5046bo.nullAsNil(c32782bp.signature);
        bcr.guP = C5046bo.nullAsNil(c32782bp.fno);
        bcr.guO = C5046bo.nullAsNil(c32782bp.fnp);
        bcr.vCi = 0;
        bcr.wBV = C5046bo.nullAsNil(c32782bp.dug);
        bcr.wHd = 0;
        bcr.guS = "";
        bcr.wBX = 0;
        bcr.wBW = "";
        bcr.guW = C5046bo.nullAsNil(c32782bp.countryCode);
        AppMethodBeat.m2505o(59929);
        return bcr;
    }

    public final String getCity() {
        AppMethodBeat.m2504i(59930);
        if (!C5046bo.isNullOrNil(this.countryCode)) {
            if (C5046bo.isNullOrNil(this.fnp)) {
                this.fnn = "";
            } else if (C5046bo.isNullOrNil(this.fno)) {
                RegionCodeDecoder.duj();
                this.fnn = RegionCodeDecoder.m7798id(this.countryCode, this.fnp);
            } else {
                RegionCodeDecoder.duj();
                this.fnn = RegionCodeDecoder.m7797aD(this.countryCode, this.fnp, this.fno);
            }
        }
        String nullAsNil;
        if (C5046bo.isNullOrNil(this.fnn)) {
            nullAsNil = C5046bo.nullAsNil(this.fno);
            AppMethodBeat.m2505o(59930);
            return nullAsNil;
        }
        nullAsNil = this.fnn;
        AppMethodBeat.m2505o(59930);
        return nullAsNil;
    }

    public final String getProvince() {
        AppMethodBeat.m2504i(59931);
        if (!C5046bo.isNullOrNil(this.countryCode)) {
            if (C5046bo.isNullOrNil(this.fnp) || C5046bo.isNullOrNil(this.fno) || !RegionCodeDecoder.apQ(this.countryCode)) {
                RegionCodeDecoder.duj();
                this.fnm = RegionCodeDecoder.apR(this.countryCode);
            } else {
                RegionCodeDecoder.duj();
                this.fnm = RegionCodeDecoder.m7798id(this.countryCode, this.fnp);
            }
        }
        String nullAsNil;
        if (C5046bo.isNullOrNil(this.fnm)) {
            nullAsNil = C5046bo.nullAsNil(this.fnp);
            AppMethodBeat.m2505o(59931);
            return nullAsNil;
        }
        nullAsNil = this.fnm;
        AppMethodBeat.m2505o(59931);
        return nullAsNil;
    }
}
