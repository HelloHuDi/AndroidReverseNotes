package com.tencent.p177mm.network;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1818ay;
import com.tencent.p177mm.network.C1899d.C1900a;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5069y;
import com.tencent.ttpic.baseutils.IOUtils;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.network.a */
public final class C37970a extends C1900a implements C1898c {
    byte[] cPB;
    private boolean foreground = false;
    private byte[] gcA;
    private byte[] gcB;
    private byte[] gcC;
    private C37971a gcD = null;
    byte[] gcE;
    String gcF;
    private Map<String, byte[]> gcG = new HashMap();
    private int uin;
    String username;

    /* renamed from: com.tencent.mm.network.a$a */
    public interface C37971a {
    }

    public C37970a(C37971a c37971a) {
        AppMethodBeat.m2504i(58438);
        this.gcD = c37971a;
        amK();
        AppMethodBeat.m2505o(58438);
    }

    public final void reset() {
        AppMethodBeat.m2504i(58439);
        C4990ab.m7416i("MicroMsg.AccInfo", "reset accinfo");
        this.username = "";
        this.gcA = null;
        amK();
        this.uin = 0;
        this.gcB = null;
        this.gcC = null;
        AppMethodBeat.m2505o(58439);
    }

    private void amK() {
        AppMethodBeat.m2504i(58440);
        this.cPB = C5046bo.anf(C1818ay.m3737ZQ().getString("server_id", ""));
        AppMethodBeat.m2505o(58440);
    }

    public final void setUsername(String str) {
        this.username = str;
    }

    /* renamed from: a */
    public final void mo5497a(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        AppMethodBeat.m2504i(58441);
        C4990ab.m7417i("MicroMsg.AccInfo", "summerauth update session info: session single[%s] cli[%s], svr[%s] uin:%d -> %d stack:[%s]", C5046bo.anv(C5046bo.m7539ca(bArr)), C5046bo.anv(C5046bo.m7539ca(bArr2)), C5046bo.anv(C5046bo.m7539ca(bArr3)), Integer.valueOf(this.uin), Integer.valueOf(i), C5046bo.dpG());
        this.gcA = bArr;
        this.gcB = bArr2;
        this.gcC = bArr3;
        this.uin = i;
        if (this.gcD != null) {
            adb();
        }
        AppMethodBeat.m2505o(58441);
    }

    /* renamed from: ab */
    public final void mo5498ab(byte[] bArr) {
        this.cPB = bArr;
    }

    /* renamed from: ac */
    public final void mo5499ac(byte[] bArr) {
        this.gcE = bArr;
    }

    /* renamed from: jQ */
    public final byte[] mo5509jQ(int i) {
        switch (i) {
            case 1:
                return this.gcA;
            case 2:
                return this.gcB;
            case 3:
                return this.gcC;
            default:
                return null;
        }
    }

    public final byte[] adc() {
        return this.gcE;
    }

    public final byte[] ada() {
        return this.cPB;
    }

    public final String getUsername() {
        return this.username;
    }

    /* renamed from: QF */
    public final int mo5495QF() {
        return this.uin;
    }

    public final boolean adb() {
        return this.gcA != null && this.gcB != null && this.gcC != null && this.gcA.length > 0 && this.gcB.length > 0 && this.gcC.length > 0;
    }

    public final String toString() {
        AppMethodBeat.m2504i(58442);
        String str = (((((((("AccInfo:\n" + "|-uin     =" + mo5495QF() + IOUtils.LINE_SEPARATOR_UNIX) + "|-user    =" + getUsername() + IOUtils.LINE_SEPARATOR_UNIX) + "|-wxuser  =" + adD() + IOUtils.LINE_SEPARATOR_UNIX) + "|-wxuser  =" + adD() + IOUtils.LINE_SEPARATOR_UNIX) + "|-singlesession =" + C5046bo.m7539ca(mo5509jQ(1)) + IOUtils.LINE_SEPARATOR_UNIX) + "|-clientsession =" + C5046bo.m7539ca(mo5509jQ(2)) + IOUtils.LINE_SEPARATOR_UNIX) + "|-serversession =" + C5046bo.m7539ca(mo5509jQ(3)) + IOUtils.LINE_SEPARATOR_UNIX) + "|-ecdhkey =" + C5046bo.m7539ca(adc()) + IOUtils.LINE_SEPARATOR_UNIX) + "`-cookie  =" + C5046bo.m7539ca(ada());
        AppMethodBeat.m2505o(58442);
        return str;
    }

    /* renamed from: va */
    public final void mo5514va(String str) {
        this.gcF = str;
    }

    public final String adD() {
        return this.gcF;
    }

    /* renamed from: o */
    public final void mo5510o(String str, byte[] bArr) {
        AppMethodBeat.m2504i(58443);
        this.gcG.put(str, bArr);
        AppMethodBeat.m2505o(58443);
    }

    /* renamed from: qr */
    public final byte[] mo5511qr(String str) {
        AppMethodBeat.m2504i(58444);
        byte[] bArr = (byte[]) this.gcG.get(str);
        AppMethodBeat.m2505o(58444);
        return bArr;
    }

    public final boolean ade() {
        return this.foreground;
    }

    /* renamed from: cE */
    public final void mo5506cE(boolean z) {
        AppMethodBeat.m2504i(58445);
        this.foreground = z;
        C4990ab.m7417i("MicroMsg.AccInfo", "somr accinfo setForeground :%b", Boolean.valueOf(this.foreground));
        AppMethodBeat.m2505o(58445);
    }

    private void clear() {
        this.username = null;
        this.gcA = null;
        this.gcB = null;
        this.gcC = null;
        this.cPB = null;
        this.uin = 0;
        this.gcE = null;
        this.gcF = null;
    }

    private String amL() {
        AppMethodBeat.m2504i(58446);
        String x;
        try {
            ByteBuffer allocate = ByteBuffer.allocate(4096);
            allocate.put(this.gcA).put(this.gcB).put(this.gcC).put(this.gcE).put(this.cPB).putInt(this.uin).put(this.gcF.getBytes()).put(this.username.getBytes());
            x = C1178g.m2591x(allocate.array());
            AppMethodBeat.m2505o(58446);
            return x;
        } catch (Exception e) {
            x = "";
            AppMethodBeat.m2505o(58446);
            return x;
        }
    }

    public final byte[] adf() {
        int i;
        AppMethodBeat.m2504i(58447);
        long anU = C5046bo.anU();
        if (C5046bo.isNullOrNil(this.username)) {
            i = 0;
        } else if (C5046bo.m7540cb(this.gcA)) {
            i = 0;
        } else if (C5046bo.m7540cb(this.gcB)) {
            i = 0;
        } else if (C5046bo.m7540cb(this.gcC)) {
            i = 0;
        } else if (C5046bo.m7540cb(this.cPB)) {
            i = 0;
        } else if (this.uin == 0 || this.uin == -1) {
            i = 0;
        } else if (C5046bo.m7540cb(this.gcE)) {
            i = 0;
        } else if (C5046bo.isNullOrNil(this.gcF)) {
            i = 0;
        } else {
            i = 1;
        }
        if (i == 0) {
            C4990ab.m7412e("MicroMsg.AccInfo", "AccInfoCacheInWorker getCacheBuffer Error : isCacheValid== false");
            AppMethodBeat.m2505o(58447);
            return null;
        }
        try {
            C5069y c5069y = new C5069y();
            c5069y.dog();
            c5069y.amu(this.username);
            c5069y.amu(this.gcF);
            c5069y.mo10391LY(this.uin);
            c5069y.mo10394bY(this.cPB);
            c5069y.mo10394bY(this.gcE);
            c5069y.mo10394bY(this.gcA);
            c5069y.mo10394bY(this.gcB);
            c5069y.mo10394bY(this.gcC);
            c5069y.amu(amL());
            C4990ab.m7417i("MicroMsg.AccInfo", "AccInfoCacheInWorker getCacheBuffer finish time:%s buflen:%s md5:%s", Long.valueOf(C5046bo.m7566gb(anU)), Integer.valueOf(c5069y.doh().length), r6);
            AppMethodBeat.m2505o(58447);
            return r1;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.AccInfo", "AccInfoCacheInWorker getCacheBuffer exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58447);
            return null;
        }
    }

    /* renamed from: S */
    public final int mo5496S(byte[] bArr) {
        AppMethodBeat.m2504i(58448);
        long anU = C5046bo.anU();
        if (adb()) {
            C4990ab.m7412e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : isLogin == true ");
            AppMethodBeat.m2505o(58448);
            return -2;
        }
        try {
            C5069y c5069y = new C5069y();
            if (c5069y.mo10393bX(bArr) != 0) {
                C4990ab.m7413e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : initParse: %s", Integer.valueOf(c5069y.mo10393bX(bArr)));
                AppMethodBeat.m2505o(58448);
                return -3;
            }
            this.username = c5069y.getString();
            this.gcF = c5069y.getString();
            this.uin = c5069y.getInt();
            this.cPB = c5069y.getBuffer();
            this.gcE = c5069y.getBuffer();
            this.gcA = c5069y.getBuffer();
            this.gcB = c5069y.getBuffer();
            this.gcC = c5069y.getBuffer();
            String string = c5069y.getString();
            if (C5046bo.isNullOrNil(string) || !string.equals(amL())) {
                clear();
                C4990ab.m7412e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : checksum failed");
                AppMethodBeat.m2505o(58448);
                return -4;
            }
            C4990ab.m7417i("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf finish time:%s  md5:%s", Long.valueOf(C5046bo.m7566gb(anU)), string);
            AppMethodBeat.m2505o(58448);
            return 0;
        } catch (Exception e) {
            clear();
            C4990ab.m7413e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58448);
            return -5;
        }
    }

    /* renamed from: hB */
    public final void mo5508hB(int i) {
        AppMethodBeat.m2504i(58449);
        C4990ab.m7417i("MicroMsg.AccInfo", "summerauth setuin [%d -> %d], stack[%s]", Integer.valueOf(this.uin), Integer.valueOf(i), C5046bo.dpG());
        this.uin = i;
        AppMethodBeat.m2505o(58449);
    }
}
