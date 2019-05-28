package com.tencent.p177mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C6477fg;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C21925g;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.b */
public final class C34933b extends C4884c<C6477fg> {
    public C34933b() {
        AppMethodBeat.m2504i(35597);
        this.xxI = C6477fg.class.getName().hashCode();
        AppMethodBeat.m2505o(35597);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        boolean z = false;
        AppMethodBeat.m2504i(35598);
        C6477fg c6477fg = (C6477fg) c4883b;
        if (!(c6477fg instanceof C6477fg)) {
            C4990ab.m7414f("MicroMsg.ExtGetSnsDataEventListener", "mismatched event");
            AppMethodBeat.m2505o(35598);
            return false;
        } else if (c6477fg.cyJ.cyL == null) {
            AppMethodBeat.m2505o(35598);
            return false;
        } else {
            C46236n c46236n = new C46236n();
            c46236n.mo8995d(c6477fg.cyJ.cyL);
            if (c46236n.reX <= 0) {
                C4990ab.m7412e("MicroMsg.ExtGetSnsDataEventListener", "sns == null || sns.getLocalid()<=0");
                AppMethodBeat.m2505o(35598);
                return false;
            }
            TimeLineObject cqu = c46236n.cqu();
            c6477fg.cyK.cyQ = 0;
            c6477fg.cyK.cyU = 0;
            c6477fg.cyK.cyV = 0;
            c6477fg.cyK.cyS = new LinkedList();
            c6477fg.cyK.cyT = new LinkedList();
            if (cqu.xfI != null) {
                c6477fg.cyK.cyQ = cqu.xfI.wbJ;
                if (cqu.xfI.wbJ != 1 && cqu.xfI.wbJ != 7 && cqu.xfI.wbJ != 8) {
                    c6477fg.cyK.cyS.add(cqu.xfI.Url);
                } else if (cqu.xfI.wbK != null) {
                    while (true) {
                        boolean z2 = z;
                        if (z2 >= cqu.xfI.wbK.size()) {
                            break;
                        }
                        List list = c6477fg.cyK.cyS;
                        C13373af.cnC();
                        list.add(C21925g.m33539r((bau) cqu.xfI.wbK.get(z2)));
                        list = c6477fg.cyK.cyT;
                        C13373af.cnC();
                        list.add(C21925g.m33540s((bau) cqu.xfI.wbK.get(z2)));
                        if (!(z2 || cqu.xfI.wbK.get(z2) == null)) {
                            c6477fg.cyK.cyU = (int) ((bau) cqu.xfI.wbK.get(z2)).wEK.wFx;
                            c6477fg.cyK.cyV = (int) ((bau) cqu.xfI.wbK.get(z2)).wEK.wFy;
                        }
                        z = z2 + 1;
                    }
                }
            }
            c6477fg.cyK.cyR = c6477fg.cyK.cyS.size();
            c6477fg.cyK.cyN = c46236n.reX;
            c6477fg.cyK.cyM = c46236n.field_userName;
            c6477fg.cyK.cyO = cqu.xfF;
            c6477fg.cyK.cyP = (long) cqu.pcX;
            AppMethodBeat.m2505o(35598);
            return true;
        }
    }
}
