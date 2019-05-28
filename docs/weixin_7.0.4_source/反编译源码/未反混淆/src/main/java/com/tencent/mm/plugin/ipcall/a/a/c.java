package com.tencent.mm.plugin.ipcall.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;
import com.tencent.mm.protocal.protobuf.blt;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.Iterator;
import java.util.LinkedList;

public final class c {
    public String cMr;
    public String cOz;
    public int hGH;
    public LinkedList<blt> jud = new LinkedList();
    public int luT;
    public String luU;
    public String nickname;
    public int nwA;
    public String nwB;
    public int nwC;
    public int nwD;
    public int nwE;
    public int nwF;
    public boolean nwG = false;
    public boolean nwH = false;
    public boolean nwI = false;
    public boolean nwJ = true;
    public int nwK = 0;
    public int nwL;
    public int nwM;
    public int nwN;
    public b nwO;
    public int nwP;
    public int nwQ;
    public b nwR;
    public LinkedList<blt> nwS = new LinkedList();
    public int nwT = 999;
    public LinkedList<d> nwU = new LinkedList();
    public String nwV;
    public String nwW;
    public String nwX;
    public int nwY;
    public boolean nwZ = false;
    public int nwu;
    public long nwv;
    public long nww;
    public int nwx;
    public int nwy;
    public int nwz;

    public c() {
        AppMethodBeat.i(21793);
        AppMethodBeat.o(21793);
    }

    public final int bHG() {
        AppMethodBeat.i(21794);
        int i;
        if (this.nwU == null || this.nwU.size() <= 0) {
            i = this.nwD;
            AppMethodBeat.o(21794);
            return i;
        }
        i = ((d) this.nwU.get(0)).nwD;
        AppMethodBeat.o(21794);
        return i;
    }

    public final int bHH() {
        AppMethodBeat.i(21795);
        int i;
        if (this.nwU == null || this.nwU.size() <= 0) {
            i = this.hGH;
            AppMethodBeat.o(21795);
            return i;
        }
        i = ((d) this.nwU.get(0)).eIV;
        AppMethodBeat.o(21795);
        return i;
    }

    public final String toString() {
        AppMethodBeat.i(21796);
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("IPCallInfo: ");
        stringBuilder.append(String.format("[roomId: %d, roomKey: %d, callSeq: %d, inviteId: %d, roomMemberId: %d, syncKey: %d, syncInterval: %d, currentStatus: %d, ErrMsg: %s, ErrCode：%d, ErrLevel：%d]\n", new Object[]{Integer.valueOf(this.nwu), Long.valueOf(this.nwv), Long.valueOf(this.nww), Integer.valueOf(this.nwx), Integer.valueOf(this.nwC), Integer.valueOf(this.nwD), Integer.valueOf(this.nwE), Integer.valueOf(this.hGH), this.luU, Integer.valueOf(this.luT), Integer.valueOf(this.nwA)}));
        stringBuilder.append(String.format("[toUsername: %s, toPhoneNumber: %s]\n", new Object[]{this.cMr, this.nwW}));
        stringBuilder.append("[addrList: ");
        Iterator it = this.jud.iterator();
        while (it.hasNext()) {
            blt blt = (blt) it.next();
            stringBuilder.append(String.format("{IP: %s, port: %d}", new Object[]{blt.wCK, Integer.valueOf(blt.wOO)}));
        }
        stringBuilder.append("]");
        stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
        if (this.nwU == null || this.nwU.size() <= 0) {
            stringBuilder.append("userInfoList is empty");
        } else {
            stringBuilder.append("[userInfoList: ");
            it = this.nwU.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                stringBuilder.append("{");
                stringBuilder.append(dVar.toString());
                stringBuilder.append("}");
            }
            stringBuilder.append("]");
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(21796);
        return stringBuilder2;
    }
}
