package com.tencent.mm.plugin.wear.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.protocal.protobuf.cty;
import com.tencent.mm.protocal.protobuf.ctz;
import java.util.List;

public final class h extends b {
    private long cSh;
    private String cSi;
    private List<String> cSj;
    private long cvx;

    public h(long j, long j2, String str, List<String> list) {
        this.cvx = j;
        this.cSh = j2;
        this.cSi = str;
        this.cSj = list;
    }

    /* Access modifiers changed, original: protected|final */
    public final void send() {
        AppMethodBeat.i(26446);
        cty cty = new cty();
        cty.xqz = this.cSh;
        cty.vIs = this.cvx;
        cty.xqA = this.cSi;
        try {
            if (this.cSj != null) {
                for (String split : this.cSj) {
                    String[] split2 = split.split("=");
                    ctz ctz = new ctz();
                    ctz.wyw = split2[0];
                    ctz.jCH = split2[1];
                    if (ctz.jCH.startsWith("wxid")) {
                        ctz.jCH = s.mJ(ctz.jCH);
                    }
                    ctz.xqz = Long.valueOf(split2[2]).longValue();
                    cty.xqB.add(ctz);
                }
            }
            a.cUn();
            r.b(20015, cty.toByteArray(), true);
        } catch (Exception e) {
        }
        if (this.cSh > 0) {
            com.tencent.mm.plugin.wear.model.c.a.nD(true);
            AppMethodBeat.o(26446);
            return;
        }
        com.tencent.mm.plugin.wear.model.c.a.nD(false);
        AppMethodBeat.o(26446);
    }

    public final String getName() {
        return "WearLuckyReceiveTask";
    }
}
