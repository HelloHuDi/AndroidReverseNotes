package com.tencent.p177mm.plugin.wear.model.p576f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.plugin.wear.model.C43841a;
import com.tencent.p177mm.plugin.wear.model.p1662c.C46393a;
import com.tencent.p177mm.plugin.wear.model.p575e.C40185r;
import com.tencent.p177mm.protocal.protobuf.cty;
import com.tencent.p177mm.protocal.protobuf.ctz;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.wear.model.f.h */
public final class C46397h extends C14413b {
    private long cSh;
    private String cSi;
    private List<String> cSj;
    private long cvx;

    public C46397h(long j, long j2, String str, List<String> list) {
        this.cvx = j;
        this.cSh = j2;
        this.cSi = str;
        this.cSj = list;
    }

    /* Access modifiers changed, original: protected|final */
    public final void send() {
        AppMethodBeat.m2504i(26446);
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
                        ctz.jCH = C1854s.m3866mJ(ctz.jCH);
                    }
                    ctz.xqz = Long.valueOf(split2[2]).longValue();
                    cty.xqB.add(ctz);
                }
            }
            C43841a.cUn();
            C40185r.m68920b(20015, cty.toByteArray(), true);
        } catch (Exception e) {
        }
        if (this.cSh > 0) {
            C46393a.m87277nD(true);
            AppMethodBeat.m2505o(26446);
            return;
        }
        C46393a.m87277nD(false);
        AppMethodBeat.m2505o(26446);
    }

    public final String getName() {
        return "WearLuckyReceiveTask";
    }
}
