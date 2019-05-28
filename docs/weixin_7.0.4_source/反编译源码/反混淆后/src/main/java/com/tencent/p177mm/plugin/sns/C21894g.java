package com.tencent.p177mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p201az.C6332h;
import com.tencent.p177mm.p201az.C6332h.C6333a;
import com.tencent.p177mm.p230g.p231a.C6523mp;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.sns.g */
public final class C21894g extends C4884c<C6523mp> {
    public C21894g() {
        AppMethodBeat.m2504i(35620);
        this.xxI = C6523mp.class.getName().hashCode();
        AppMethodBeat.m2505o(35620);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0073  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        AppMethodBeat.m2504i(35621);
        if (!(((C6523mp) c4883b) instanceof C6523mp)) {
            C4990ab.m7414f("MicroMsg.PostSnsAsyncTaskListener", "mismatched event");
            AppMethodBeat.m2505o(35621);
            return false;
        } else if (C13373af.cnn()) {
            AppMethodBeat.m2505o(35621);
            return false;
        } else {
            int i;
            C4990ab.m7410d("MicroMsg.PostSnsAsyncTask", "check PostTaskSnsPost ");
            if (C13373af.cnB() != null) {
                C13373af.cnB().cmp();
            }
            C4990ab.m7410d("MicroMsg.PostSnsAsyncTask", "check AsyncQueue");
            if (C13373af.cnv() != null) {
                C13373af.cnE().cnf();
            }
            C1720g.m3537RQ();
            if (C1720g.m3534RN().mo5161QY()) {
                C1720g.m3537RQ();
                C1720g.m3534RN();
                if (!C1668a.m3393QT()) {
                    i = 1;
                    if (i != 0) {
                        C1720g.m3537RQ();
                        if (C5046bo.m7549fp(C5046bo.m7514a((Long) C1720g.m3536RP().mo5239Ry().get(68390, null), 0)) * 1000 > 3600000) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                        if (i != 0) {
                            LinkedList linkedList = new LinkedList();
                            C1720g.m3537RQ();
                            int a = C5046bo.m7512a((Integer) C1720g.m3536RP().mo5239Ry().get(68388, null), 0);
                            C1720g.m3537RQ();
                            i = C5046bo.m7512a((Integer) C1720g.m3536RP().mo5239Ry().get(68389, null), 0);
                            if (a > 0 || i > 0) {
                                linkedList.add(new C6333a(10077, a + "," + i));
                                C1720g.m3537RQ();
                                C1720g.m3536RP().mo5239Ry().set(68388, Integer.valueOf(0));
                                C1720g.m3537RQ();
                                C1720g.m3536RP().mo5239Ry().set(68389, Integer.valueOf(0));
                            }
                            C1720g.m3537RQ();
                            i = C5046bo.m7512a((Integer) C1720g.m3536RP().mo5239Ry().get(68391, null), 0);
                            if (i > 0) {
                                linkedList.add(new C6333a(28, String.valueOf(i)));
                                C1720g.m3537RQ();
                                C1720g.m3536RP().mo5239Ry().set(68391, Integer.valueOf(0));
                            }
                            C1720g.m3537RQ();
                            a = C5046bo.m7512a((Integer) C1720g.m3536RP().mo5239Ry().get(68392, null), 0);
                            C1720g.m3537RQ();
                            i = C5046bo.m7512a((Integer) C1720g.m3536RP().mo5239Ry().get(68393, null), 0);
                            if (a > 0 || i > 0) {
                                linkedList.add(new C6333a(10072, a + "," + i));
                                C1720g.m3537RQ();
                                C1720g.m3536RP().mo5239Ry().set(68392, Integer.valueOf(0));
                                C1720g.m3537RQ();
                                C1720g.m3536RP().mo5239Ry().set(68393, Integer.valueOf(0));
                            }
                            if (!linkedList.isEmpty()) {
                                C1720g.m3537RQ();
                                ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C6332h(linkedList));
                                C1720g.m3537RQ();
                                C1720g.m3536RP().mo5239Ry().set(68390, Long.valueOf(C5046bo.anT()));
                            }
                        }
                    }
                    AppMethodBeat.m2505o(35621);
                    return true;
                }
            }
            i = 0;
            if (i != 0) {
            }
            AppMethodBeat.m2505o(35621);
            return true;
        }
    }
}
