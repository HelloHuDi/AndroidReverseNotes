package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bcr;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.vfs.e;

public final class bp {
    public String countryCode = "";
    public int dtS = 0;
    public int dub = 0;
    public String dug = "";
    private String fnm = "";
    private String fnn = "";
    public String fno = "";
    public String fnp = "";
    public String signature = "";

    static class a {
        public static boolean am(String str, String str2) {
            AppMethodBeat.i(59924);
            if (bo.isNullOrNil(str)) {
                AppMethodBeat.o(59924);
                return true;
            }
            String decode = decode(encode(str));
            if (bo.isNullOrNil(decode) || !decode.equals(str2)) {
                AppMethodBeat.o(59924);
                return true;
            }
            AppMethodBeat.o(59924);
            return false;
        }

        private static String encode(String str) {
            AppMethodBeat.i(59925);
            String str2 = "";
            try {
                for (char c : str.toCharArray()) {
                    str2 = str2 + String.format("%02x", new Object[]{Integer.valueOf(c)});
                }
                AppMethodBeat.o(59925);
                return str2;
            } catch (Exception e) {
                str2 = "";
                AppMethodBeat.o(59925);
                return str2;
            }
        }

        private static String decode(String str) {
            AppMethodBeat.i(59926);
            String str2 = "";
            if (bo.isNullOrNil(str) || str.length() % 2 != 0) {
                str2 = "";
                AppMethodBeat.o(59926);
                return str2;
            }
            int i = 0;
            while (i < str.length()) {
                try {
                    str2 = str2 + ((char) Integer.parseInt(str.substring(i, i + 2), 16));
                    i += 2;
                } catch (Exception e) {
                    str2 = "";
                    AppMethodBeat.o(59926);
                    return str2;
                }
            }
            AppMethodBeat.o(59926);
            return str2;
        }
    }

    public static bp aao() {
        AppMethodBeat.i(59927);
        bp bpVar = new bp();
        bpVar.dub = 1;
        bpVar.dtS = bo.a((Integer) g.RP().Ry().get(12290, null), 0);
        bpVar.fnm = (String) g.RP().Ry().get(12293, null);
        bpVar.fnn = (String) g.RP().Ry().get(12292, null);
        bpVar.signature = (String) g.RP().Ry().get(12291, null);
        bpVar.dug = (String) g.RP().Ry().get(12307, null);
        bpVar.countryCode = (String) g.RP().Ry().get(12324, null);
        bpVar.fnp = (String) g.RP().Ry().get(12325, null);
        bpVar.fno = (String) g.RP().Ry().get(12326, null);
        AppMethodBeat.o(59927);
        return bpVar;
    }

    public static bp aap() {
        AppMethodBeat.i(59928);
        if (bo.a((Integer) g.RP().Ry().get(12289, null), 0) == 0) {
            AppMethodBeat.o(59928);
            return null;
        }
        bp aao = aao();
        AppMethodBeat.o(59928);
        return aao;
    }

    public static bcr a(bp bpVar) {
        int i;
        AppMethodBeat.i(59929);
        g.RP().Ry().set(12289, Integer.valueOf(bpVar.dub));
        g.RP().Ry().set(12290, Integer.valueOf(bpVar.dtS));
        if (a.am((String) g.RP().Ry().get(12293, null), bpVar.getProvince())) {
            g.RP().Ry().set(12293, bpVar.getProvince());
        }
        if (a.am((String) g.RP().Ry().get(12292, null), bpVar.getCity())) {
            g.RP().Ry().set(12292, bpVar.getCity());
        }
        if (a.am((String) g.RP().Ry().get(12291, null), bpVar.signature)) {
            g.RP().Ry().set(12291, bpVar.signature);
        }
        if (a.am((String) g.RP().Ry().get(12307, null), bpVar.dug)) {
            g.RP().Ry().set(12307, bpVar.dug);
        }
        if (a.am((String) g.RP().Ry().get(12324, null), bpVar.countryCode)) {
            g.RP().Ry().set(12324, bpVar.countryCode);
        }
        if (a.am((String) g.RP().Ry().get(12325, null), bpVar.fnp)) {
            g.RP().Ry().set(12325, bpVar.fnp);
        }
        if (a.am((String) g.RP().Ry().get(12326, null), bpVar.fno)) {
            g.RP().Ry().set(12326, bpVar.fno);
        }
        bcr bcr = new bcr();
        bcr.wGW = 128;
        bcr.wcB = new bts().alV("");
        bcr.wyX = new bts().alV("");
        bcr.vCf = 0;
        bcr.wGX = new bts().alV("");
        bcr.wGY = new bts().alV("");
        bcr.jBT = 0;
        byte[] e = e.e("", 0, -1);
        bcr.wGU = new b(e == null ? new byte[0] : e);
        if (e == null) {
            i = 0;
        } else {
            i = e.length;
        }
        bcr.wGT = i;
        bcr.guN = bpVar.dtS;
        bcr.guR = bpVar.dub;
        bcr.guQ = bo.nullAsNil(bpVar.signature);
        bcr.guP = bo.nullAsNil(bpVar.fno);
        bcr.guO = bo.nullAsNil(bpVar.fnp);
        bcr.vCi = 0;
        bcr.wBV = bo.nullAsNil(bpVar.dug);
        bcr.wHd = 0;
        bcr.guS = "";
        bcr.wBX = 0;
        bcr.wBW = "";
        bcr.guW = bo.nullAsNil(bpVar.countryCode);
        AppMethodBeat.o(59929);
        return bcr;
    }

    public final String getCity() {
        AppMethodBeat.i(59930);
        if (!bo.isNullOrNil(this.countryCode)) {
            if (bo.isNullOrNil(this.fnp)) {
                this.fnn = "";
            } else if (bo.isNullOrNil(this.fno)) {
                RegionCodeDecoder.duj();
                this.fnn = RegionCodeDecoder.id(this.countryCode, this.fnp);
            } else {
                RegionCodeDecoder.duj();
                this.fnn = RegionCodeDecoder.aD(this.countryCode, this.fnp, this.fno);
            }
        }
        String nullAsNil;
        if (bo.isNullOrNil(this.fnn)) {
            nullAsNil = bo.nullAsNil(this.fno);
            AppMethodBeat.o(59930);
            return nullAsNil;
        }
        nullAsNil = this.fnn;
        AppMethodBeat.o(59930);
        return nullAsNil;
    }

    public final String getProvince() {
        AppMethodBeat.i(59931);
        if (!bo.isNullOrNil(this.countryCode)) {
            if (bo.isNullOrNil(this.fnp) || bo.isNullOrNil(this.fno) || !RegionCodeDecoder.apQ(this.countryCode)) {
                RegionCodeDecoder.duj();
                this.fnm = RegionCodeDecoder.apR(this.countryCode);
            } else {
                RegionCodeDecoder.duj();
                this.fnm = RegionCodeDecoder.id(this.countryCode, this.fnp);
            }
        }
        String nullAsNil;
        if (bo.isNullOrNil(this.fnm)) {
            nullAsNil = bo.nullAsNil(this.fnp);
            AppMethodBeat.o(59931);
            return nullAsNil;
        }
        nullAsNil = this.fnm;
        AppMethodBeat.o(59931);
        return nullAsNil;
    }
}
