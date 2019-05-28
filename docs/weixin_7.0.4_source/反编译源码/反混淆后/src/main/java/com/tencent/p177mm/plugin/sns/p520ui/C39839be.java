package com.tencent.p177mm.plugin.sns.p520ui;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.sns.ui.be */
public final class C39839be {
    ListView nDp;
    int position = -1;
    int rDM = -1;
    int rDN = -1;
    public int rDO = 0;
    boolean rDP = false;
    int rDQ;
    protected long rDR;
    Runnable rDS = new C398371();
    Runnable rDT = new C398402();
    Runnable rDU = new C398383();
    SnsCommentFooter rhq;
    public int rpW = -1;
    int rro = -1;

    /* renamed from: com.tencent.mm.plugin.sns.ui.be$1 */
    class C398371 implements Runnable {
        C398371() {
        }

        public final void run() {
            AppMethodBeat.m2504i(39886);
            if (C39839be.this.nDp != null && C39839be.this.nDp.getCount() > C39839be.this.position) {
                int i;
                int top = C39839be.this.rhq.getTop();
                C4990ab.m7410d("MicroMsg.TimeLineScrollAnimation", "limitCount: " + C39839be.this.rDQ + " footerHeight:" + C39839be.this.rhq.getHeight() + " listOriginalBottom: " + C39839be.this.rpW);
                if (C39839be.this.rDQ = C39839be.this.rDQ - 1 > 0 && (C39839be.this.rro != top || top > C39839be.this.rpW - 200 || C39839be.this.nDp.getBottom() > (C39839be.this.rpW - C39839be.this.rhq.getHeight()) - 150)) {
                    i = 10;
                    if (C39839be.this.rDQ == 0) {
                        i = 200;
                    }
                    new C7306ak().postDelayed(this, (long) i);
                }
                C39839be.this.rro = top;
                i = (C39839be.this.rro - C39839be.this.rDO) - C39839be.this.rDM;
                C4990ab.m7410d("MicroMsg.TimeLineScrollAnimation", "itemH:" + C39839be.this.rDM + " footerTop" + C39839be.this.rro + " list.bottom:" + C39839be.this.nDp.getBottom() + " position: " + C39839be.this.position + " topselection: " + i);
                C4990ab.m7410d("MicroMsg.TimeLineScrollAnimation", "list.getTop(): " + C39839be.this.nDp.getTop() + " marginTop: " + C39839be.this.rDO + " footerTop " + C39839be.this.rro);
                C39839be.this.nDp.setSelectionFromTop(C39839be.this.position + C39839be.this.nDp.getHeaderViewsCount(), i);
            }
            AppMethodBeat.m2505o(39886);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.be$3 */
    class C398383 implements Runnable {
        C398383() {
        }

        public final void run() {
            AppMethodBeat.m2504i(39888);
            C4990ab.m7410d("MicroMsg.TimeLineScrollAnimation", "originalTop:" + C39839be.this.rDN + " position:" + C39839be.this.position + " list.bottom:" + C39839be.this.nDp.getBottom());
            AppMethodBeat.m2505o(39888);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.be$2 */
    class C398402 implements Runnable {
        int offset = 0;

        C398402() {
        }

        public final void run() {
            AppMethodBeat.m2504i(39887);
            if (C39839be.this.nDp != null && C39839be.this.nDp.getCount() > C39839be.this.position) {
                C39839be.this.rro = C39839be.this.rhq.getTop();
                int i = (C39839be.this.rro - C39839be.this.rDO) - C39839be.this.rDM;
                C4990ab.m7410d("MicroMsg.TimeLineScrollAnimation", "itemH:" + C39839be.this.rDM + " footerTop" + C39839be.this.rro + " list.bottom:" + C39839be.this.nDp.getBottom() + " position: " + C39839be.this.position + " topselection: " + i);
                C4990ab.m7410d("MicroMsg.TimeLineScrollAnimation", "list.getTop(): " + C39839be.this.nDp.getTop() + " marginTop: " + C39839be.this.rDO + " footerTop " + C39839be.this.rro);
                if (i == this.offset) {
                    C39839be.this.nDp.setSelectionFromTop(C39839be.this.position + C39839be.this.nDp.getHeaderViewsCount(), i);
                    this.offset = 0;
                    C39839be.this.rDQ = 0;
                    AppMethodBeat.m2505o(39887);
                    return;
                } else if (C39839be.this.rDQ = C39839be.this.rDQ - 1 > 0) {
                    new C7306ak().postDelayed(this, 100);
                    this.offset = i;
                    AppMethodBeat.m2505o(39887);
                    return;
                } else {
                    this.offset = 0;
                    C39839be.this.rDQ = 0;
                }
            }
            AppMethodBeat.m2505o(39887);
        }
    }

    public C39839be(ListView listView, SnsCommentFooter snsCommentFooter) {
        AppMethodBeat.m2504i(39889);
        this.nDp = listView;
        this.rhq = snsCommentFooter;
        AppMethodBeat.m2505o(39889);
    }

    public final void cuJ() {
        AppMethodBeat.m2504i(39890);
        this.rDP = true;
        new C7306ak().postDelayed(this.rDS, 30);
        this.rDQ = 10;
        C4990ab.m7412e("MicroMsg.TimeLineScrollAnimation", "footerTop when up :" + this.rhq.getTop());
        this.rDR = C5046bo.m7588yz();
        AppMethodBeat.m2505o(39890);
    }

    public final void cuK() {
        AppMethodBeat.m2504i(39891);
        this.rDP = true;
        this.rDQ = 20;
        new C7306ak().postDelayed(this.rDT, 100);
        AppMethodBeat.m2505o(39891);
    }

    public final void cuL() {
        AppMethodBeat.m2504i(39892);
        if (this.rDP) {
            this.rDP = false;
            new C7306ak().postDelayed(this.rDU, 30);
            this.rDQ = 10;
            AppMethodBeat.m2505o(39892);
            return;
        }
        AppMethodBeat.m2505o(39892);
    }
}
