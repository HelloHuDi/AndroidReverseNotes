package com.tencent.p177mm.plugin.wear.model.p575e;

import android.database.Cursor;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p612ui.contact.C15830s;
import com.tencent.p177mm.plugin.wear.model.p1662c.C46393a;
import com.tencent.p177mm.protocal.protobuf.ctk;
import com.tencent.p177mm.protocal.protobuf.ctq;
import com.tencent.p177mm.protocal.protobuf.ctr;
import com.tencent.p177mm.protocal.protobuf.cun;
import com.tencent.p177mm.protocal.protobuf.cuo;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7616ad;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.wear.model.e.c */
public final class C4503c extends C46394a {
    public final List<Integer> cUA() {
        AppMethodBeat.m2504i(26389);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_PUBLISH_START));
        arrayList.add(Integer.valueOf(11009));
        AppMethodBeat.m2505o(26389);
        return arrayList;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: p */
    public final byte[] mo9572p(int i, byte[] bArr) {
        int i2 = 5;
        AppMethodBeat.m2504i(26390);
        byte[] toByteArray;
        if (i == TXCStreamUploader.TXE_UPLOAD_INFO_PUBLISH_START) {
            C46393a.m87275HH(6);
            cun cun = new cun();
            try {
                cun.parseFrom(bArr);
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(C15830s.dIf());
                linkedList.addAll(C15830s.dIg());
                C9638aw.m17190ZK();
                Cursor t = C18628c.m29083XR().mo15825t(linkedList, cun.vOq);
                if (cun.vOq != 0) {
                    i2 = 20;
                }
                cuo cuo = new cuo();
                cuo.vOq = cun.vOq;
                while (t != null && t.moveToNext()) {
                    String string = t.getString(t.getColumnIndex("username"));
                    C9638aw.m17190ZK();
                    C7616ad aoO = C18628c.m29078XM().aoO(string);
                    cuo.vOq++;
                    if (!(aoO.dsf() || aoO.mo16698Oa())) {
                        ctk ctk = new ctk();
                        ctk.jCH = C1854s.m3862c(aoO);
                        ctk.jBB = aoO.field_username;
                        cuo.woe.add(ctk);
                        if (cuo.woe.size() >= i2) {
                            cuo.xqq = t.moveToNext();
                            break;
                        }
                    }
                }
                C4990ab.m7411d("MicroMsg.Wear.HttpContactServer", "request offset: %d | return offset: %d | return size: %d", Integer.valueOf(cun.vOq), Integer.valueOf(cuo.vOq), Integer.valueOf(cuo.woe.size()));
                if (t != null) {
                    t.close();
                }
                try {
                    toByteArray = cuo.toByteArray();
                    AppMethodBeat.m2505o(26390);
                    return toByteArray;
                } catch (IOException e) {
                    AppMethodBeat.m2505o(26390);
                    return null;
                }
            } catch (IOException e2) {
                C4990ab.printErrStackTrace("MicroMsg.Wear.HttpContactServer", e2, "", new Object[0]);
                AppMethodBeat.m2505o(26390);
                return null;
            }
        } else if (i == 11009) {
            C46393a.m87275HH(7);
            ctq ctq = new ctq();
            try {
                ctq.parseFrom(bArr);
                ctr ctr = new ctr();
                C9638aw.m17190ZK();
                Cursor eC = C18628c.m29078XM().mo15753eC(null);
                int i3 = ctq.vOq;
                while (eC != null && eC.moveToNext()) {
                    if (i3 > 0) {
                        i3--;
                    } else {
                        String string2 = eC.getString(0);
                        C9638aw.m17190ZK();
                        C7616ad aoO2 = C18628c.m29078XM().aoO(string2);
                        ctk ctk2 = new ctk();
                        ctk2.jCH = C1854s.m3862c(aoO2);
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
                    AppMethodBeat.m2505o(26390);
                    return toByteArray;
                } catch (IOException e22) {
                    C4990ab.printErrStackTrace("MicroMsg.Wear.HttpContactServer", e22, "", new Object[0]);
                    AppMethodBeat.m2505o(26390);
                    return null;
                }
            } catch (IOException e222) {
                C4990ab.printErrStackTrace("MicroMsg.Wear.HttpContactServer", e222, "", new Object[0]);
                AppMethodBeat.m2505o(26390);
                return null;
            }
        } else {
            AppMethodBeat.m2505o(26390);
            return null;
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: HJ */
    public final boolean mo9570HJ(int i) {
        AppMethodBeat.m2504i(26391);
        if (i == TXCStreamUploader.TXE_UPLOAD_INFO_PUBLISH_START) {
            AppMethodBeat.m2505o(26391);
            return true;
        } else if (i == 11009) {
            AppMethodBeat.m2505o(26391);
            return true;
        } else {
            boolean HJ = super.mo9570HJ(i);
            AppMethodBeat.m2505o(26391);
            return HJ;
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: HI */
    public final boolean mo9569HI(int i) {
        AppMethodBeat.m2504i(26392);
        if (i == TXCStreamUploader.TXE_UPLOAD_INFO_PUBLISH_START) {
            AppMethodBeat.m2505o(26392);
            return true;
        } else if (i == 11009) {
            AppMethodBeat.m2505o(26392);
            return true;
        } else {
            boolean HI = super.mo9569HI(i);
            AppMethodBeat.m2505o(26392);
            return HI;
        }
    }
}
