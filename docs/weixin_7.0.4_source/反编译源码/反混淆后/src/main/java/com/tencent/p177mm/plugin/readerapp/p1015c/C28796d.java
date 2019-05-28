package com.tencent.p177mm.plugin.readerapp.p1015c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C32779bl;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.p230g.p231a.C45346ng;
import com.tencent.p177mm.p230g.p231a.C45346ng.C26205b;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.readerapp.c.d */
public final class C28796d extends C4884c<C45346ng> {
    public C28796d() {
        AppMethodBeat.m2504i(76759);
        this.xxI = C45346ng.class.getName().hashCode();
        AppMethodBeat.m2505o(76759);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        AppMethodBeat.m2504i(76760);
        C45346ng c45346ng = (C45346ng) c4883b;
        switch (c45346ng.cJw.opType) {
            case 3:
                boolean a;
                C26205b c26205b = c45346ng.cJx;
                C45316cl c45316cl = c45346ng.cJw.cJy;
                int i = c45346ng.cJw.cJz;
                C4990ab.m7417i("MicroMsg.Sns.GetFavDataSource", "fav info, newsSvrid is %d, tweetId is %s", Integer.valueOf(i), c45346ng.cJw.cJA);
                List fn = C39565g.cdZ().mo53337fn((long) i);
                if (!fn.isEmpty()) {
                    C4990ab.m7416i("MicroMsg.Sns.GetFavDataSource", "fav news msgs");
                    String bc = C5046bo.m7532bc(r1, "");
                    for (int i2 = 0; i2 < fn.size(); i2++) {
                        if (bc.equals(((C32779bl) fn.get(i2)).aaj())) {
                            a = C21568b.m33021a(c45316cl, (C32779bl) fn.get(i2), i2);
                            c26205b.cvi = a;
                            break;
                        }
                    }
                }
                c45316cl.cvA.cvG = C25738R.string.boh;
                a = false;
                c26205b.cvi = a;
            case 4:
                C39565g.cdZ().mo53339kJ(c45346ng.cJw.cJB);
                break;
        }
        AppMethodBeat.m2505o(76760);
        return false;
    }
}
