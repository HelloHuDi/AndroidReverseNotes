package com.tencent.mm.ai;

import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.f;
import com.tencent.mm.protocal.j.c.a;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public abstract class k implements q {
    private d fta;
    public boolean ftb = false;
    private boolean ftc = true;

    public abstract d ZR();

    public final d acF() {
        if (this.fta == null) {
            this.fta = ZR();
            d dVar = this.fta;
            dVar.vye = com.tencent.mm.compatible.e.q.LM();
            dVar.vyd = com.tencent.mm.protocal.d.eSg;
            dVar.vyc = com.tencent.mm.protocal.d.vxo;
            dVar.hB(a.vxR.ZP());
            if (f.vxx && g.RK()) {
                ab.i("MicroMsg.MMReqRespBase", "summerauths check cgi[%s] accHasReady openSwitch[%s] ", Integer.valueOf(getType()), Boolean.valueOf(((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getInt("UseAesGcmSessionKeySwitch", 1) == 0));
                if (((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getInt("UseAesGcmSessionKeySwitch", 1) == 0) {
                    String value = ((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("UseAesGcmSessionKeyCgiList");
                    if (!bo.isNullOrNil(value)) {
                        ab.i("MicroMsg.MMReqRespBase", "summerauths check cgi list[%s]", value);
                        String[] split = value.trim().split(",");
                        if (split.length > 0) {
                            for (String str : split) {
                                if (r3 == bo.getInt(str, 0)) {
                                    this.ftc = false;
                                    ab.i("MicroMsg.MMReqRespBase", "summerauths check cgi list found cgi[%s] singleSession[%s]", str, Boolean.valueOf(this.ftc));
                                    break;
                                }
                            }
                        }
                    }
                }
            } else {
                ab.i("MicroMsg.MMReqRespBase", "summerauths check cgi[%s] USE_ECDH[%s] accHasReady[%s] ", Integer.valueOf(dVar.getCmdId()), Boolean.valueOf(f.vxx), Boolean.valueOf(g.RK()));
            }
        }
        return this.fta;
    }

    public int acC() {
        return 0;
    }

    public final boolean acG() {
        return this.ftb;
    }

    public int acB() {
        return 0;
    }

    public final boolean acH() {
        return this.ftc;
    }
}
