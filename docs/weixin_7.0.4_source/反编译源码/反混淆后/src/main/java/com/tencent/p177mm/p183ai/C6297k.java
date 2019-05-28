package com.tencent.p177mm.p183ai;

import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.protocal.C4815f;
import com.tencent.p177mm.protocal.C4824j.C4823c.C4822a;
import com.tencent.p177mm.protocal.C4836l.C4834d;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.ai.k */
public abstract class C6297k implements C1929q {
    private C4834d fta;
    public boolean ftb = false;
    private boolean ftc = true;

    /* renamed from: ZR */
    public abstract C4834d mo14537ZR();

    public final C4834d acF() {
        if (this.fta == null) {
            this.fta = mo14537ZR();
            C4834d c4834d = this.fta;
            c4834d.vye = C1427q.m3028LM();
            c4834d.vyd = C7243d.eSg;
            c4834d.vyc = C7243d.vxo;
            c4834d.mo10000hB(C4822a.vxR.mo9983ZP());
            if (C4815f.vxx && C1720g.m3531RK()) {
                C4990ab.m7417i("MicroMsg.MMReqRespBase", "summerauths check cgi[%s] accHasReady openSwitch[%s] ", Integer.valueOf(getType()), Boolean.valueOf(((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getInt("UseAesGcmSessionKeySwitch", 1) == 0));
                if (((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getInt("UseAesGcmSessionKeySwitch", 1) == 0) {
                    String value = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("UseAesGcmSessionKeyCgiList");
                    if (!C5046bo.isNullOrNil(value)) {
                        C4990ab.m7417i("MicroMsg.MMReqRespBase", "summerauths check cgi list[%s]", value);
                        String[] split = value.trim().split(",");
                        if (split.length > 0) {
                            for (String str : split) {
                                if (r3 == C5046bo.getInt(str, 0)) {
                                    this.ftc = false;
                                    C4990ab.m7417i("MicroMsg.MMReqRespBase", "summerauths check cgi list found cgi[%s] singleSession[%s]", str, Boolean.valueOf(this.ftc));
                                    break;
                                }
                            }
                        }
                    }
                }
            } else {
                C4990ab.m7417i("MicroMsg.MMReqRespBase", "summerauths check cgi[%s] USE_ECDH[%s] accHasReady[%s] ", Integer.valueOf(c4834d.getCmdId()), Boolean.valueOf(C4815f.vxx), Boolean.valueOf(C1720g.m3531RK()));
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
