package com.tencent.mm.network;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.model.ay;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.ttpic.baseutils.IOUtils;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

public final class a extends com.tencent.mm.network.d.a implements c {
    byte[] cPB;
    private boolean foreground = false;
    private byte[] gcA;
    private byte[] gcB;
    private byte[] gcC;
    private a gcD = null;
    byte[] gcE;
    String gcF;
    private Map<String, byte[]> gcG = new HashMap();
    private int uin;
    String username;

    public interface a {
    }

    public a(a aVar) {
        AppMethodBeat.i(58438);
        this.gcD = aVar;
        amK();
        AppMethodBeat.o(58438);
    }

    public final void reset() {
        AppMethodBeat.i(58439);
        ab.i("MicroMsg.AccInfo", "reset accinfo");
        this.username = "";
        this.gcA = null;
        amK();
        this.uin = 0;
        this.gcB = null;
        this.gcC = null;
        AppMethodBeat.o(58439);
    }

    private void amK() {
        AppMethodBeat.i(58440);
        this.cPB = bo.anf(ay.ZQ().getString("server_id", ""));
        AppMethodBeat.o(58440);
    }

    public final void setUsername(String str) {
        this.username = str;
    }

    public final void a(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        AppMethodBeat.i(58441);
        ab.i("MicroMsg.AccInfo", "summerauth update session info: session single[%s] cli[%s], svr[%s] uin:%d -> %d stack:[%s]", bo.anv(bo.ca(bArr)), bo.anv(bo.ca(bArr2)), bo.anv(bo.ca(bArr3)), Integer.valueOf(this.uin), Integer.valueOf(i), bo.dpG());
        this.gcA = bArr;
        this.gcB = bArr2;
        this.gcC = bArr3;
        this.uin = i;
        if (this.gcD != null) {
            adb();
        }
        AppMethodBeat.o(58441);
    }

    public final void ab(byte[] bArr) {
        this.cPB = bArr;
    }

    public final void ac(byte[] bArr) {
        this.gcE = bArr;
    }

    public final byte[] jQ(int i) {
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

    public final int QF() {
        return this.uin;
    }

    public final boolean adb() {
        return this.gcA != null && this.gcB != null && this.gcC != null && this.gcA.length > 0 && this.gcB.length > 0 && this.gcC.length > 0;
    }

    public final String toString() {
        AppMethodBeat.i(58442);
        String str = (((((((("AccInfo:\n" + "|-uin     =" + QF() + IOUtils.LINE_SEPARATOR_UNIX) + "|-user    =" + getUsername() + IOUtils.LINE_SEPARATOR_UNIX) + "|-wxuser  =" + adD() + IOUtils.LINE_SEPARATOR_UNIX) + "|-wxuser  =" + adD() + IOUtils.LINE_SEPARATOR_UNIX) + "|-singlesession =" + bo.ca(jQ(1)) + IOUtils.LINE_SEPARATOR_UNIX) + "|-clientsession =" + bo.ca(jQ(2)) + IOUtils.LINE_SEPARATOR_UNIX) + "|-serversession =" + bo.ca(jQ(3)) + IOUtils.LINE_SEPARATOR_UNIX) + "|-ecdhkey =" + bo.ca(adc()) + IOUtils.LINE_SEPARATOR_UNIX) + "`-cookie  =" + bo.ca(ada());
        AppMethodBeat.o(58442);
        return str;
    }

    public final void va(String str) {
        this.gcF = str;
    }

    public final String adD() {
        return this.gcF;
    }

    public final void o(String str, byte[] bArr) {
        AppMethodBeat.i(58443);
        this.gcG.put(str, bArr);
        AppMethodBeat.o(58443);
    }

    public final byte[] qr(String str) {
        AppMethodBeat.i(58444);
        byte[] bArr = (byte[]) this.gcG.get(str);
        AppMethodBeat.o(58444);
        return bArr;
    }

    public final boolean ade() {
        return this.foreground;
    }

    public final void cE(boolean z) {
        AppMethodBeat.i(58445);
        this.foreground = z;
        ab.i("MicroMsg.AccInfo", "somr accinfo setForeground :%b", Boolean.valueOf(this.foreground));
        AppMethodBeat.o(58445);
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
        AppMethodBeat.i(58446);
        String x;
        try {
            ByteBuffer allocate = ByteBuffer.allocate(4096);
            allocate.put(this.gcA).put(this.gcB).put(this.gcC).put(this.gcE).put(this.cPB).putInt(this.uin).put(this.gcF.getBytes()).put(this.username.getBytes());
            x = g.x(allocate.array());
            AppMethodBeat.o(58446);
            return x;
        } catch (Exception e) {
            x = "";
            AppMethodBeat.o(58446);
            return x;
        }
    }

    public final byte[] adf() {
        int i;
        AppMethodBeat.i(58447);
        long anU = bo.anU();
        if (bo.isNullOrNil(this.username)) {
            i = 0;
        } else if (bo.cb(this.gcA)) {
            i = 0;
        } else if (bo.cb(this.gcB)) {
            i = 0;
        } else if (bo.cb(this.gcC)) {
            i = 0;
        } else if (bo.cb(this.cPB)) {
            i = 0;
        } else if (this.uin == 0 || this.uin == -1) {
            i = 0;
        } else if (bo.cb(this.gcE)) {
            i = 0;
        } else if (bo.isNullOrNil(this.gcF)) {
            i = 0;
        } else {
            i = 1;
        }
        if (i == 0) {
            ab.e("MicroMsg.AccInfo", "AccInfoCacheInWorker getCacheBuffer Error : isCacheValid== false");
            AppMethodBeat.o(58447);
            return null;
        }
        try {
            y yVar = new y();
            yVar.dog();
            yVar.amu(this.username);
            yVar.amu(this.gcF);
            yVar.LY(this.uin);
            yVar.bY(this.cPB);
            yVar.bY(this.gcE);
            yVar.bY(this.gcA);
            yVar.bY(this.gcB);
            yVar.bY(this.gcC);
            yVar.amu(amL());
            ab.i("MicroMsg.AccInfo", "AccInfoCacheInWorker getCacheBuffer finish time:%s buflen:%s md5:%s", Long.valueOf(bo.gb(anU)), Integer.valueOf(yVar.doh().length), r6);
            AppMethodBeat.o(58447);
            return r1;
        } catch (Exception e) {
            ab.e("MicroMsg.AccInfo", "AccInfoCacheInWorker getCacheBuffer exception:%s", bo.l(e));
            AppMethodBeat.o(58447);
            return null;
        }
    }

    public final int S(byte[] bArr) {
        AppMethodBeat.i(58448);
        long anU = bo.anU();
        if (adb()) {
            ab.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : isLogin == true ");
            AppMethodBeat.o(58448);
            return -2;
        }
        try {
            y yVar = new y();
            if (yVar.bX(bArr) != 0) {
                ab.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : initParse: %s", Integer.valueOf(yVar.bX(bArr)));
                AppMethodBeat.o(58448);
                return -3;
            }
            this.username = yVar.getString();
            this.gcF = yVar.getString();
            this.uin = yVar.getInt();
            this.cPB = yVar.getBuffer();
            this.gcE = yVar.getBuffer();
            this.gcA = yVar.getBuffer();
            this.gcB = yVar.getBuffer();
            this.gcC = yVar.getBuffer();
            String string = yVar.getString();
            if (bo.isNullOrNil(string) || !string.equals(amL())) {
                clear();
                ab.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : checksum failed");
                AppMethodBeat.o(58448);
                return -4;
            }
            ab.i("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf finish time:%s  md5:%s", Long.valueOf(bo.gb(anU)), string);
            AppMethodBeat.o(58448);
            return 0;
        } catch (Exception e) {
            clear();
            ab.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf exception:%s", bo.l(e));
            AppMethodBeat.o(58448);
            return -5;
        }
    }

    public final void hB(int i) {
        AppMethodBeat.i(58449);
        ab.i("MicroMsg.AccInfo", "summerauth setuin [%d -> %d], stack[%s]", Integer.valueOf(this.uin), Integer.valueOf(i), bo.dpG());
        this.uin = i;
        AppMethodBeat.o(58449);
    }
}
