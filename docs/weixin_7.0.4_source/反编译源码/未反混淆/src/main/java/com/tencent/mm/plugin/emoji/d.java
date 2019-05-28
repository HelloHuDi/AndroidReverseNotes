package com.tencent.mm.plugin.emoji;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.plugin.expt.a.a;
import com.tencent.mm.plugin.gif.MMWXGFJNI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.vfs.e;

public final class d implements c {
    private static d kRq;

    public static d biX() {
        AppMethodBeat.i(62307);
        if (kRq == null) {
            kRq = new d();
        }
        d dVar = kRq;
        AppMethodBeat.o(62307);
        return dVar;
    }

    private d() {
    }

    public final boolean biY() {
        AppMethodBeat.i(138079);
        ab.i("MicroMsg.HevcHelperService", "checkHevcReady: %s", Integer.valueOf(MMWXGFJNI.getErrorCode()));
        if (MMWXGFJNI.getErrorCode() == 0) {
            AppMethodBeat.o(138079);
            return true;
        }
        AppMethodBeat.o(138079);
        return false;
    }

    public final String IP(String str) {
        AppMethodBeat.i(62308);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(62308);
            return str;
        }
        str = str + "_hevc";
        AppMethodBeat.o(62308);
        return str;
    }

    public final int dF(String str, String str2) {
        AppMethodBeat.i(62309);
        long yz = bo.yz();
        String amq = r.amq(str);
        int i = 0;
        if (".png".equals(amq)) {
            i = 1;
        } else if (".gif".equals(amq)) {
            i = 3;
        }
        int errorCode = MMWXGFJNI.getErrorCode();
        if (errorCode == 0) {
            int nativePic2Wxam = MMWXGFJNI.nativePic2Wxam(str, str2, i, bjb());
            if (nativePic2Wxam != 0) {
                h.pYm.k(944, 0, 1);
                errorCode = nativePic2Wxam;
            } else {
                h.pYm.k(944, 2, 1);
                h.pYm.k(944, 3, bo.az(yz));
                errorCode = nativePic2Wxam;
            }
        }
        ab.i("MicroMsg.HevcHelperService", "pic2wxam %d, %d, %d, %d, %d", Integer.valueOf(errorCode), Integer.valueOf(i), Long.valueOf(e.asZ(str)), Long.valueOf(e.asZ(str2)), Long.valueOf(bo.az(yz)));
        AppMethodBeat.o(62309);
        return errorCode;
    }

    public final int nativeWxam2Pic(String str, String str2) {
        AppMethodBeat.i(62310);
        long yz = bo.yz();
        int errorCode = MMWXGFJNI.getErrorCode();
        if (errorCode == 0) {
            errorCode = MMWXGFJNI.nativeWxam2Pic(str, str2);
            if (errorCode != 0) {
                h.pYm.k(944, 1, 1);
            } else {
                h.pYm.k(944, 5, 1);
                h.pYm.k(944, 6, bo.az(yz));
            }
        }
        ab.i("MicroMsg.HevcHelperService", "wxam2pic %d, %d, %d, %d", Integer.valueOf(errorCode), Long.valueOf(e.asZ(str)), Long.valueOf(e.asZ(str2)), Long.valueOf(bo.az(yz)));
        AppMethodBeat.o(62310);
        return errorCode;
    }

    public final byte[] aE(byte[] bArr) {
        AppMethodBeat.i(62311);
        long yz = bo.yz();
        int errorCode = MMWXGFJNI.getErrorCode();
        byte[] bArr2 = null;
        if (errorCode == 0) {
            bArr2 = MMWXGFJNI.nativeWxam2PicBuf(bArr);
            if (bArr2 == null) {
                h.pYm.k(944, 1, 1);
            } else {
                h.pYm.k(944, 5, 1);
                h.pYm.k(944, 6, bo.az(yz));
            }
        }
        String str = "MicroMsg.HevcHelperService";
        String str2 = "wxam2pic %d, %d, %d, %d";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(errorCode);
        objArr[1] = Integer.valueOf(bArr.length);
        objArr[2] = Integer.valueOf(bArr2 == null ? 0 : bArr2.length);
        objArr[3] = Long.valueOf(bo.az(yz));
        ab.i(str, str2, objArr);
        AppMethodBeat.o(62311);
        return bArr2;
    }

    public final boolean biZ() {
        AppMethodBeat.i(62312);
        ab.i("MicroMsg.HevcHelperService", "hevc upload %s", Boolean.valueOf(((a) g.K(a.class)).a(a.a.mmc2c_image_upload_hevc_and, false)));
        if (biY() && r0) {
            AppMethodBeat.o(62312);
            return true;
        }
        AppMethodBeat.o(62312);
        return false;
    }

    public final boolean bja() {
        AppMethodBeat.i(62313);
        ab.i("MicroMsg.HevcHelperService", "hevc download %s", Boolean.valueOf(((a) g.K(a.class)).a(a.a.mmc2c_image_download_hevc_and, false)));
        if (biY() && r0) {
            AppMethodBeat.o(62313);
            return true;
        }
        AppMethodBeat.o(62313);
        return false;
    }

    private static int bjb() {
        int i;
        AppMethodBeat.i(62314);
        try {
            i = at.isWifi(ah.getContext()) ? bo.getInt(((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("CompressPicLevelForWifi"), 60) : at.is2G(ah.getContext()) ? bo.getInt(((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("CompressPicLevelFor2G"), 40) : at.is3G(ah.getContext()) ? bo.getInt(((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("CompressPicLevelFor3G"), 40) : bo.getInt(((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("CompressPicLevelFor4G"), 60);
        } catch (Exception e) {
            i = 60;
        }
        i = Math.round(39.0f - (((float) i) / 5.0f));
        AppMethodBeat.o(62314);
        return i;
    }
}
