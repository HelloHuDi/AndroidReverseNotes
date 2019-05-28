package com.tencent.mm.plugin.wear.model.e;

import android.database.Cursor;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.wear.model.c.a;
import com.tencent.mm.protocal.protobuf.ctk;
import com.tencent.mm.protocal.protobuf.ctq;
import com.tencent.mm.protocal.protobuf.ctr;
import com.tencent.mm.protocal.protobuf.cun;
import com.tencent.mm.protocal.protobuf.cuo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.contact.s;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c extends a {
    public final List<Integer> cUA() {
        AppMethodBeat.i(26389);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_PUBLISH_START));
        arrayList.add(Integer.valueOf(11009));
        AppMethodBeat.o(26389);
        return arrayList;
    }

    /* Access modifiers changed, original: protected|final */
    public final byte[] p(int i, byte[] bArr) {
        int i2 = 5;
        AppMethodBeat.i(26390);
        byte[] toByteArray;
        if (i == TXCStreamUploader.TXE_UPLOAD_INFO_PUBLISH_START) {
            a.HH(6);
            cun cun = new cun();
            try {
                cun.parseFrom(bArr);
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(s.dIf());
                linkedList.addAll(s.dIg());
                aw.ZK();
                Cursor t = com.tencent.mm.model.c.XR().t(linkedList, cun.vOq);
                if (cun.vOq != 0) {
                    i2 = 20;
                }
                cuo cuo = new cuo();
                cuo.vOq = cun.vOq;
                while (t != null && t.moveToNext()) {
                    String string = t.getString(t.getColumnIndex("username"));
                    aw.ZK();
                    ad aoO = com.tencent.mm.model.c.XM().aoO(string);
                    cuo.vOq++;
                    if (!(aoO.dsf() || aoO.Oa())) {
                        ctk ctk = new ctk();
                        ctk.jCH = com.tencent.mm.model.s.c(aoO);
                        ctk.jBB = aoO.field_username;
                        cuo.woe.add(ctk);
                        if (cuo.woe.size() >= i2) {
                            cuo.xqq = t.moveToNext();
                            break;
                        }
                    }
                }
                ab.d("MicroMsg.Wear.HttpContactServer", "request offset: %d | return offset: %d | return size: %d", Integer.valueOf(cun.vOq), Integer.valueOf(cuo.vOq), Integer.valueOf(cuo.woe.size()));
                if (t != null) {
                    t.close();
                }
                try {
                    toByteArray = cuo.toByteArray();
                    AppMethodBeat.o(26390);
                    return toByteArray;
                } catch (IOException e) {
                    AppMethodBeat.o(26390);
                    return null;
                }
            } catch (IOException e2) {
                ab.printErrStackTrace("MicroMsg.Wear.HttpContactServer", e2, "", new Object[0]);
                AppMethodBeat.o(26390);
                return null;
            }
        } else if (i == 11009) {
            a.HH(7);
            ctq ctq = new ctq();
            try {
                ctq.parseFrom(bArr);
                ctr ctr = new ctr();
                aw.ZK();
                Cursor eC = com.tencent.mm.model.c.XM().eC(null);
                int i3 = ctq.vOq;
                while (eC != null && eC.moveToNext()) {
                    if (i3 > 0) {
                        i3--;
                    } else {
                        String string2 = eC.getString(0);
                        aw.ZK();
                        ad aoO2 = com.tencent.mm.model.c.XM().aoO(string2);
                        ctk ctk2 = new ctk();
                        ctk2.jCH = com.tencent.mm.model.s.c(aoO2);
                        ctk2.jBB = aoO2.field_username;
                        ctr.woe.add(ctk2);
                        if (ctr.woe.size() >= 5) {
                            ctr.xqq = eC.moveToNext();
                            break;
                        }
                    }
                }
                if (eC != null) {
                    eC.close();
                }
                ctr.vOq = ctq.vOq + ctr.woe.size();
                try {
                    toByteArray = ctr.toByteArray();
                    AppMethodBeat.o(26390);
                    return toByteArray;
                } catch (IOException e22) {
                    ab.printErrStackTrace("MicroMsg.Wear.HttpContactServer", e22, "", new Object[0]);
                    AppMethodBeat.o(26390);
                    return null;
                }
            } catch (IOException e222) {
                ab.printErrStackTrace("MicroMsg.Wear.HttpContactServer", e222, "", new Object[0]);
                AppMethodBeat.o(26390);
                return null;
            }
        } else {
            AppMethodBeat.o(26390);
            return null;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean HJ(int i) {
        AppMethodBeat.i(26391);
        if (i == TXCStreamUploader.TXE_UPLOAD_INFO_PUBLISH_START) {
            AppMethodBeat.o(26391);
            return true;
        } else if (i == 11009) {
            AppMethodBeat.o(26391);
            return true;
        } else {
            boolean HJ = super.HJ(i);
            AppMethodBeat.o(26391);
            return HJ;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean HI(int i) {
        AppMethodBeat.i(26392);
        if (i == TXCStreamUploader.TXE_UPLOAD_INFO_PUBLISH_START) {
            AppMethodBeat.o(26392);
            return true;
        } else if (i == 11009) {
            AppMethodBeat.o(26392);
            return true;
        } else {
            boolean HI = super.HI(i);
            AppMethodBeat.o(26392);
            return HI;
        }
    }
}
