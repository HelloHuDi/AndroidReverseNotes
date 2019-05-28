package com.tencent.p177mm.plugin.subapp.p1306a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.apw;
import com.tencent.p177mm.protocal.protobuf.apx;
import com.tencent.p177mm.protocal.protobuf.cmn;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.io.FileOutputStream;

/* renamed from: com.tencent.mm.plugin.subapp.a.a */
public final class C43666a extends C1207m implements C1918k {
    final C7472b ehh;
    private C1202f ehi;
    private C7564ap frk = new C7564ap(new C293811(), true);
    int ssI = 0;

    /* renamed from: com.tencent.mm.plugin.subapp.a.a$1 */
    class C293811 implements C5015a {
        C293811() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(25220);
            if (C43666a.this.ssI < 0) {
                AppMethodBeat.m2505o(25220);
                return false;
            }
            cmn cmn;
            apx apx = (apx) C43666a.this.ehh.fsH.fsP;
            try {
                cmn = (cmn) apx.wtX.get(C43666a.this.ssI);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.NetSceneGetVUserInfo", "get item :" + C43666a.this.ssI + " not Found");
                cmn = null;
            }
            if (!(cmn == null || cmn.xkr == null || cmn.xkr.getBuffer() == null || cmn.xkq == null || cmn.xkq.getBuffer() == null)) {
                C4990ab.m7410d("MicroMsg.NetSceneGetVUserInfo", "onGYNetEnd ver:" + apx.Version + " idx:" + C43666a.this.ssI + " id:" + Integer.toHexString(cmn.f4417ID) + " size:" + cmn.xkq.getILen() + " hdsize:" + cmn.xkr.getILen());
                C43666a.m78195a(cmn.f4417ID, true, cmn.xkr.getBuffer().toByteArray());
                C43666a.m78195a(cmn.f4417ID, false, cmn.xkq.getBuffer().toByteArray());
            }
            C43666a c43666a = C43666a.this;
            c43666a.ssI--;
            AppMethodBeat.m2505o(25220);
            return true;
        }
    }

    public C43666a() {
        int i = 0;
        AppMethodBeat.m2504i(25221);
        C9638aw.m17190ZK();
        int h = C5046bo.m7567h((Integer) C18628c.m29072Ry().get(66052, null));
        if (C26417a.flw.mo37871kA(h)) {
            C9638aw.m17190ZK();
            i = C5046bo.m7567h((Integer) C18628c.m29072Ry().get(66053, null));
        }
        StringBuilder append = new StringBuilder("init: allfileid:").append(Integer.toBinaryString(h)).append(" inver:");
        C9638aw.m17190ZK();
        C4990ab.m7410d("MicroMsg.NetSceneGetVUserInfo", append.append(C5046bo.m7567h((Integer) C18628c.m29072Ry().get(66053, null))).append(" reqver:").append(i).toString());
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new apw();
        c1196a.fsK = new apx();
        c1196a.uri = "/cgi-bin/micromsg-bin/getvuserinfo";
        c1196a.fsI = ErrorCode.STARTDOWNLOAD_8;
        c1196a.fsL = 60;
        c1196a.fsM = 1000000060;
        this.ehh = c1196a.acD();
        ((apw) this.ehh.fsG.fsP).Version = i;
        AppMethodBeat.m2505o(25221);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(25222);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(25222);
        return a;
    }

    public final int getType() {
        return ErrorCode.STARTDOWNLOAD_8;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        int i4 = 0;
        AppMethodBeat.m2504i(25223);
        if (i2 == 0 && i3 == 0) {
            apx apx = (apx) ((C7472b) c1929q).fsH.fsP;
            StringBuilder append = new StringBuilder("onGYNetEnd new version:").append(apx.Version).append(" old version:");
            C9638aw.m17190ZK();
            C4990ab.m7410d("MicroMsg.NetSceneGetVUserInfo", append.append(C5046bo.m7567h((Integer) C18628c.m29072Ry().get(66053, null))).append(" Count:").append(apx.wtX.size()).toString());
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(66053, Integer.valueOf(apx.Version));
            if (apx.wtX.size() <= 0) {
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(25223);
                return;
            }
            int i5 = 0;
            while (true) {
                int i6 = i4;
                if (i5 < apx.wtX.size()) {
                    i4 = i6 | ((cmn) apx.wtX.get(i5)).f4417ID;
                    i5++;
                } else {
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(66052, Integer.valueOf(i6));
                    this.ehi.onSceneEnd(i2, i3, str, this);
                    this.ssI = apx.wtX.size() - 1;
                    this.frk.mo16770ae(50, 50);
                    AppMethodBeat.m2505o(25223);
                    return;
                }
            }
        }
        C4990ab.m7412e("MicroMsg.NetSceneGetVUserInfo", "errType:" + i2 + " errCode:" + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(25223);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x003b A:{SYNTHETIC, Splitter:B:19:0x003b} */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0030 A:{SYNTHETIC, Splitter:B:13:0x0030} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    static boolean m78195a(int i, boolean z, byte[] bArr) {
        Throwable e;
        Throwable th;
        AppMethodBeat.m2504i(25224);
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(C26417a.flw.mo37869B(i, z));
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.close();
                try {
                    fileOutputStream.close();
                } catch (Exception e2) {
                }
                AppMethodBeat.m2505o(25224);
                return true;
            } catch (Exception e3) {
                e = e3;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.NetSceneGetVUserInfo", e, "", new Object[0]);
                    if (fileOutputStream != null) {
                    }
                    AppMethodBeat.m2505o(25224);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                    }
                    AppMethodBeat.m2505o(25224);
                    throw th;
                }
            }
        } catch (Exception e4) {
            e = e4;
            fileOutputStream = null;
            C4990ab.printErrStackTrace("MicroMsg.NetSceneGetVUserInfo", e, "", new Object[0]);
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Exception e5) {
                }
            }
            AppMethodBeat.m2505o(25224);
            return false;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Exception e6) {
                }
            }
            AppMethodBeat.m2505o(25224);
            throw th;
        }
    }
}
