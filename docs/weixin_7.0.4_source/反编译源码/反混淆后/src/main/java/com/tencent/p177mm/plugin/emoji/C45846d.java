package com.tencent.p177mm.plugin.emoji;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.emoji.p725b.C27730c;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.gif.MMWXGFJNI;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5063r;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.plugin.emoji.d */
public final class C45846d implements C27730c {
    private static C45846d kRq;

    public static C45846d biX() {
        AppMethodBeat.m2504i(62307);
        if (kRq == null) {
            kRq = new C45846d();
        }
        C45846d c45846d = kRq;
        AppMethodBeat.m2505o(62307);
        return c45846d;
    }

    private C45846d() {
    }

    public final boolean biY() {
        AppMethodBeat.m2504i(138079);
        C4990ab.m7417i("MicroMsg.HevcHelperService", "checkHevcReady: %s", Integer.valueOf(MMWXGFJNI.getErrorCode()));
        if (MMWXGFJNI.getErrorCode() == 0) {
            AppMethodBeat.m2505o(138079);
            return true;
        }
        AppMethodBeat.m2505o(138079);
        return false;
    }

    /* renamed from: IP */
    public final String mo45564IP(String str) {
        AppMethodBeat.m2504i(62308);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(62308);
            return str;
        }
        str = str + "_hevc";
        AppMethodBeat.m2505o(62308);
        return str;
    }

    /* renamed from: dF */
    public final int mo45569dF(String str, String str2) {
        AppMethodBeat.m2504i(62309);
        long yz = C5046bo.m7588yz();
        String amq = C5063r.amq(str);
        int i = 0;
        if (".png".equals(amq)) {
            i = 1;
        } else if (".gif".equals(amq)) {
            i = 3;
        }
        int errorCode = MMWXGFJNI.getErrorCode();
        if (errorCode == 0) {
            int nativePic2Wxam = MMWXGFJNI.nativePic2Wxam(str, str2, i, C45846d.bjb());
            if (nativePic2Wxam != 0) {
                C7060h.pYm.mo15419k(944, 0, 1);
                errorCode = nativePic2Wxam;
            } else {
                C7060h.pYm.mo15419k(944, 2, 1);
                C7060h.pYm.mo15419k(944, 3, C5046bo.m7525az(yz));
                errorCode = nativePic2Wxam;
            }
        }
        C4990ab.m7417i("MicroMsg.HevcHelperService", "pic2wxam %d, %d, %d, %d, %d", Integer.valueOf(errorCode), Integer.valueOf(i), Long.valueOf(C5730e.asZ(str)), Long.valueOf(C5730e.asZ(str2)), Long.valueOf(C5046bo.m7525az(yz)));
        AppMethodBeat.m2505o(62309);
        return errorCode;
    }

    public final int nativeWxam2Pic(String str, String str2) {
        AppMethodBeat.m2504i(62310);
        long yz = C5046bo.m7588yz();
        int errorCode = MMWXGFJNI.getErrorCode();
        if (errorCode == 0) {
            errorCode = MMWXGFJNI.nativeWxam2Pic(str, str2);
            if (errorCode != 0) {
                C7060h.pYm.mo15419k(944, 1, 1);
            } else {
                C7060h.pYm.mo15419k(944, 5, 1);
                C7060h.pYm.mo15419k(944, 6, C5046bo.m7525az(yz));
            }
        }
        C4990ab.m7417i("MicroMsg.HevcHelperService", "wxam2pic %d, %d, %d, %d", Integer.valueOf(errorCode), Long.valueOf(C5730e.asZ(str)), Long.valueOf(C5730e.asZ(str2)), Long.valueOf(C5046bo.m7525az(yz)));
        AppMethodBeat.m2505o(62310);
        return errorCode;
    }

    /* renamed from: aE */
    public final byte[] mo45565aE(byte[] bArr) {
        AppMethodBeat.m2504i(62311);
        long yz = C5046bo.m7588yz();
        int errorCode = MMWXGFJNI.getErrorCode();
        byte[] bArr2 = null;
        if (errorCode == 0) {
            bArr2 = MMWXGFJNI.nativeWxam2PicBuf(bArr);
            if (bArr2 == null) {
                C7060h.pYm.mo15419k(944, 1, 1);
            } else {
                C7060h.pYm.mo15419k(944, 5, 1);
                C7060h.pYm.mo15419k(944, 6, C5046bo.m7525az(yz));
            }
        }
        String str = "MicroMsg.HevcHelperService";
        String str2 = "wxam2pic %d, %d, %d, %d";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(errorCode);
        objArr[1] = Integer.valueOf(bArr.length);
        objArr[2] = Integer.valueOf(bArr2 == null ? 0 : bArr2.length);
        objArr[3] = Long.valueOf(C5046bo.m7525az(yz));
        C4990ab.m7417i(str, str2, objArr);
        AppMethodBeat.m2505o(62311);
        return bArr2;
    }

    public final boolean biZ() {
        AppMethodBeat.m2504i(62312);
        C4990ab.m7417i("MicroMsg.HevcHelperService", "hevc upload %s", Boolean.valueOf(((C34069a) C1720g.m3528K(C34069a.class)).mo54614a(C11745a.mmc2c_image_upload_hevc_and, false)));
        if (biY() && r0) {
            AppMethodBeat.m2505o(62312);
            return true;
        }
        AppMethodBeat.m2505o(62312);
        return false;
    }

    public final boolean bja() {
        AppMethodBeat.m2504i(62313);
        C4990ab.m7417i("MicroMsg.HevcHelperService", "hevc download %s", Boolean.valueOf(((C34069a) C1720g.m3528K(C34069a.class)).mo54614a(C11745a.mmc2c_image_download_hevc_and, false)));
        if (biY() && r0) {
            AppMethodBeat.m2505o(62313);
            return true;
        }
        AppMethodBeat.m2505o(62313);
        return false;
    }

    private static int bjb() {
        int i;
        AppMethodBeat.m2504i(62314);
        try {
            i = C5023at.isWifi(C4996ah.getContext()) ? C5046bo.getInt(((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("CompressPicLevelForWifi"), 60) : C5023at.is2G(C4996ah.getContext()) ? C5046bo.getInt(((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("CompressPicLevelFor2G"), 40) : C5023at.is3G(C4996ah.getContext()) ? C5046bo.getInt(((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("CompressPicLevelFor3G"), 40) : C5046bo.getInt(((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("CompressPicLevelFor4G"), 60);
        } catch (Exception e) {
            i = 60;
        }
        i = Math.round(39.0f - (((float) i) / 5.0f));
        AppMethodBeat.m2505o(62314);
        return i;
    }
}
