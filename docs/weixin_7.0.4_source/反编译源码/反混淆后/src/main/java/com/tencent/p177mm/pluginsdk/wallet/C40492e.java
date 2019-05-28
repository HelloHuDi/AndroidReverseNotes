package com.tencent.p177mm.pluginsdk.wallet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p230g.p231a.C37810vb;
import com.tencent.p177mm.p230g.p231a.C45378va;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import java.util.List;

/* renamed from: com.tencent.mm.pluginsdk.wallet.e */
public final class C40492e {
    public static String akq(String str) {
        AppMethodBeat.m2504i(70469);
        List<C7620bi> Rx = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15270Rx(str);
        if (Rx != null) {
            String str2;
            C4990ab.m7417i("MicroMsg.WalletConvDelCheckLogic", "checkUnProcessWalletMsgCount, msgInfoList size: %s", Integer.valueOf(Rx.size()));
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            for (C7620bi c7620bi : Rx) {
                if (C40492e.m69624am(c7620bi)) {
                    if (c7620bi.getType() == 419430449) {
                        i++;
                    } else if (c7620bi.getType() == 436207665) {
                        C8910b me;
                        str2 = c7620bi.field_content;
                        if (str2 != null) {
                            me = C8910b.m16064me(str2);
                        } else {
                            me = null;
                        }
                        if (me != null) {
                            if ("1001".equals(me.fhY)) {
                                i2++;
                            } else {
                                i3++;
                            }
                        }
                    }
                }
                i3 = i3;
            }
            if (i3 > 0 || i2 > 0 || i > 0) {
                if (C1855t.m3896kH(str)) {
                    str2 = C4996ah.getContext().getString(C25738R.string.fe_, new Object[]{Integer.valueOf(i2)});
                    AppMethodBeat.m2505o(70469);
                    return str2;
                } else if (i3 > 0 && i <= 0) {
                    str2 = C4996ah.getContext().getString(C25738R.string.feb, new Object[]{Integer.valueOf(i3)});
                    AppMethodBeat.m2505o(70469);
                    return str2;
                } else if (i > 0 && i3 <= 0) {
                    str2 = C4996ah.getContext().getString(C25738R.string.fec, new Object[]{Integer.valueOf(i)});
                    AppMethodBeat.m2505o(70469);
                    return str2;
                } else if (i > 0 && i3 > 0) {
                    str2 = C4996ah.getContext().getString(C25738R.string.fea, new Object[]{Integer.valueOf(i3), Integer.valueOf(i)});
                    AppMethodBeat.m2505o(70469);
                    return str2;
                }
            }
        }
        AppMethodBeat.m2505o(70469);
        return null;
    }

    /* renamed from: am */
    public static boolean m69624am(C7620bi c7620bi) {
        C8910b c8910b = null;
        AppMethodBeat.m2504i(70470);
        String str;
        int i;
        if (c7620bi.getType() == 419430449) {
            if (c7620bi.field_isSend == 0) {
                C8910b X;
                str = c7620bi.field_content;
                if (str != null) {
                    X = C8910b.m16058X(str, c7620bi.field_reserved);
                } else {
                    X = null;
                }
                if (X != null) {
                    C37810vb c37810vb = new C37810vb();
                    c37810vb.cRW.cEa = X.fhy;
                    C4879a.xxA.mo10055m(c37810vb);
                    i = c37810vb.cRX.status;
                    if (i <= 0) {
                        i = X.fhv;
                    }
                    if (i >= 0 && (i == 1 || i == 7)) {
                        AppMethodBeat.m2505o(70470);
                        return true;
                    }
                }
            }
        } else if (c7620bi.getType() == 436207665 && c7620bi.field_isSend == 0) {
            str = c7620bi.field_content;
            if (str != null) {
                c8910b = C8910b.m16064me(str);
            }
            if (c8910b != null) {
                if (!"1001".equals(c8910b.fhY) && !C1855t.m3896kH(c7620bi.field_talker)) {
                    C45378va c45378va = new C45378va();
                    if (!C5046bo.isNullOrNil(c8910b.fhZ)) {
                        c45378va.cRQ.cRS = c8910b.fhZ;
                        C4879a.xxA.mo10055m(c45378va);
                        if (c45378va.cRR.cRV == 0) {
                            AppMethodBeat.m2505o(70470);
                            return true;
                        }
                    }
                } else if (C1855t.m3896kH(c7620bi.field_talker)) {
                    int i2;
                    str = C1853r.m3846Yz();
                    if (!C5046bo.m7548ek(c8910b.fio)) {
                        for (String split : c8910b.fio) {
                            String[] split2 = split.split(",");
                            if (split2.length == 3 && split2[0].equals(str)) {
                                i = C5046bo.getInt(split2[2], -1);
                                i2 = 1;
                                break;
                            }
                        }
                    }
                    i = 0;
                    i2 = 0;
                    if (i2 != 0 && r0 == 1) {
                        AppMethodBeat.m2505o(70470);
                        return true;
                    }
                }
            }
        }
        AppMethodBeat.m2505o(70470);
        return false;
    }
}
