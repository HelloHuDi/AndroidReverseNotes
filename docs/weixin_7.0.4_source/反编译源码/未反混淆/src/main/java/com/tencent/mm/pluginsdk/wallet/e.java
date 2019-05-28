package com.tencent.mm.pluginsdk.wallet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.a.va;
import com.tencent.mm.g.a.vb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.List;

public final class e {
    public static String akq(String str) {
        AppMethodBeat.i(70469);
        List<bi> Rx = ((j) g.K(j.class)).bOr().Rx(str);
        if (Rx != null) {
            String str2;
            ab.i("MicroMsg.WalletConvDelCheckLogic", "checkUnProcessWalletMsgCount, msgInfoList size: %s", Integer.valueOf(Rx.size()));
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            for (bi biVar : Rx) {
                if (am(biVar)) {
                    if (biVar.getType() == 419430449) {
                        i++;
                    } else if (biVar.getType() == 436207665) {
                        b me;
                        str2 = biVar.field_content;
                        if (str2 != null) {
                            me = b.me(str2);
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
                if (t.kH(str)) {
                    str2 = ah.getContext().getString(R.string.fe_, new Object[]{Integer.valueOf(i2)});
                    AppMethodBeat.o(70469);
                    return str2;
                } else if (i3 > 0 && i <= 0) {
                    str2 = ah.getContext().getString(R.string.feb, new Object[]{Integer.valueOf(i3)});
                    AppMethodBeat.o(70469);
                    return str2;
                } else if (i > 0 && i3 <= 0) {
                    str2 = ah.getContext().getString(R.string.fec, new Object[]{Integer.valueOf(i)});
                    AppMethodBeat.o(70469);
                    return str2;
                } else if (i > 0 && i3 > 0) {
                    str2 = ah.getContext().getString(R.string.fea, new Object[]{Integer.valueOf(i3), Integer.valueOf(i)});
                    AppMethodBeat.o(70469);
                    return str2;
                }
            }
        }
        AppMethodBeat.o(70469);
        return null;
    }

    public static boolean am(bi biVar) {
        b bVar = null;
        AppMethodBeat.i(70470);
        String str;
        int i;
        if (biVar.getType() == 419430449) {
            if (biVar.field_isSend == 0) {
                b X;
                str = biVar.field_content;
                if (str != null) {
                    X = b.X(str, biVar.field_reserved);
                } else {
                    X = null;
                }
                if (X != null) {
                    vb vbVar = new vb();
                    vbVar.cRW.cEa = X.fhy;
                    a.xxA.m(vbVar);
                    i = vbVar.cRX.status;
                    if (i <= 0) {
                        i = X.fhv;
                    }
                    if (i >= 0 && (i == 1 || i == 7)) {
                        AppMethodBeat.o(70470);
                        return true;
                    }
                }
            }
        } else if (biVar.getType() == 436207665 && biVar.field_isSend == 0) {
            str = biVar.field_content;
            if (str != null) {
                bVar = b.me(str);
            }
            if (bVar != null) {
                if (!"1001".equals(bVar.fhY) && !t.kH(biVar.field_talker)) {
                    va vaVar = new va();
                    if (!bo.isNullOrNil(bVar.fhZ)) {
                        vaVar.cRQ.cRS = bVar.fhZ;
                        a.xxA.m(vaVar);
                        if (vaVar.cRR.cRV == 0) {
                            AppMethodBeat.o(70470);
                            return true;
                        }
                    }
                } else if (t.kH(biVar.field_talker)) {
                    int i2;
                    str = r.Yz();
                    if (!bo.ek(bVar.fio)) {
                        for (String split : bVar.fio) {
                            String[] split2 = split.split(",");
                            if (split2.length == 3 && split2[0].equals(str)) {
                                i = bo.getInt(split2[2], -1);
                                i2 = 1;
                                break;
                            }
                        }
                    }
                    i = 0;
                    i2 = 0;
                    if (i2 != 0 && r0 == 1) {
                        AppMethodBeat.o(70470);
                        return true;
                    }
                }
            }
        }
        AppMethodBeat.o(70470);
        return false;
    }
}
