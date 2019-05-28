package com.tencent.mm.plugin.sns.ui;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;

public final class be {
    ListView nDp;
    int position = -1;
    int rDM = -1;
    int rDN = -1;
    public int rDO = 0;
    boolean rDP = false;
    int rDQ;
    protected long rDR;
    Runnable rDS = new Runnable() {
        public final void run() {
            AppMethodBeat.i(39886);
            if (be.this.nDp != null && be.this.nDp.getCount() > be.this.position) {
                int i;
                int top = be.this.rhq.getTop();
                ab.d("MicroMsg.TimeLineScrollAnimation", "limitCount: " + be.this.rDQ + " footerHeight:" + be.this.rhq.getHeight() + " listOriginalBottom: " + be.this.rpW);
                if (be.this.rDQ = be.this.rDQ - 1 > 0 && (be.this.rro != top || top > be.this.rpW - 200 || be.this.nDp.getBottom() > (be.this.rpW - be.this.rhq.getHeight()) - 150)) {
                    i = 10;
                    if (be.this.rDQ == 0) {
                        i = 200;
                    }
                    new ak().postDelayed(this, (long) i);
                }
                be.this.rro = top;
                i = (be.this.rro - be.this.rDO) - be.this.rDM;
                ab.d("MicroMsg.TimeLineScrollAnimation", "itemH:" + be.this.rDM + " footerTop" + be.this.rro + " list.bottom:" + be.this.nDp.getBottom() + " position: " + be.this.position + " topselection: " + i);
                ab.d("MicroMsg.TimeLineScrollAnimation", "list.getTop(): " + be.this.nDp.getTop() + " marginTop: " + be.this.rDO + " footerTop " + be.this.rro);
                be.this.nDp.setSelectionFromTop(be.this.position + be.this.nDp.getHeaderViewsCount(), i);
            }
            AppMethodBeat.o(39886);
        }
    };
    Runnable rDT = new Runnable() {
        int offset = 0;

        public final void run() {
            AppMethodBeat.i(39887);
            if (be.this.nDp != null && be.this.nDp.getCount() > be.this.position) {
                be.this.rro = be.this.rhq.getTop();
                int i = (be.this.rro - be.this.rDO) - be.this.rDM;
                ab.d("MicroMsg.TimeLineScrollAnimation", "itemH:" + be.this.rDM + " footerTop" + be.this.rro + " list.bottom:" + be.this.nDp.getBottom() + " position: " + be.this.position + " topselection: " + i);
                ab.d("MicroMsg.TimeLineScrollAnimation", "list.getTop(): " + be.this.nDp.getTop() + " marginTop: " + be.this.rDO + " footerTop " + be.this.rro);
                if (i == this.offset) {
                    be.this.nDp.setSelectionFromTop(be.this.position + be.this.nDp.getHeaderViewsCount(), i);
                    this.offset = 0;
                    be.this.rDQ = 0;
                    AppMethodBeat.o(39887);
                    return;
                } else if (be.this.rDQ = be.this.rDQ - 1 > 0) {
                    new ak().postDelayed(this, 100);
                    this.offset = i;
                    AppMethodBeat.o(39887);
                    return;
                } else {
                    this.offset = 0;
                    be.this.rDQ = 0;
                }
            }
            AppMethodBeat.o(39887);
        }
    };
    Runnable rDU = new Runnable() {
        public final void run() {
            AppMethodBeat.i(39888);
            ab.d("MicroMsg.TimeLineScrollAnimation", "originalTop:" + be.this.rDN + " position:" + be.this.position + " list.bottom:" + be.this.nDp.getBottom());
            AppMethodBeat.o(39888);
        }
    };
    SnsCommentFooter rhq;
    public int rpW = -1;
    int rro = -1;

    public be(ListView listView, SnsCommentFooter snsCommentFooter) {
        AppMethodBeat.i(39889);
        this.nDp = listView;
        this.rhq = snsCommentFooter;
        AppMethodBeat.o(39889);
    }

    public final void cuJ() {
        AppMethodBeat.i(39890);
        this.rDP = true;
        new ak().postDelayed(this.rDS, 30);
        this.rDQ = 10;
        ab.e("MicroMsg.TimeLineScrollAnimation", "footerTop when up :" + this.rhq.getTop());
        this.rDR = bo.yz();
        AppMethodBeat.o(39890);
    }

    public final void cuK() {
        AppMethodBeat.i(39891);
        this.rDP = true;
        this.rDQ = 20;
        new ak().postDelayed(this.rDT, 100);
        AppMethodBeat.o(39891);
    }

    public final void cuL() {
        AppMethodBeat.i(39892);
        if (this.rDP) {
            this.rDP = false;
            new ak().postDelayed(this.rDU, 30);
            this.rDQ = 10;
            AppMethodBeat.o(39892);
            return;
        }
        AppMethodBeat.o(39892);
    }
}
