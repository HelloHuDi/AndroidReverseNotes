package com.tencent.p177mm.plugin.card.p355ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.card.base.C45773c;
import com.tencent.p177mm.plugin.card.model.C33771n.C11290a;
import com.tencent.p177mm.plugin.card.model.C42852am;
import com.tencent.p177mm.plugin.card.model.CardInfo;
import com.tencent.p177mm.plugin.card.p355ui.view.C38776aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.card.ui.k */
public final class C2781k extends C11334c {
    private final String TAG = "MicroMsg.CardTicketAdapter";
    private int count = 0;
    private C45773c kgW;
    private C11290a kiz;
    private final String knL = "PRIVATE_TICKET_TITLE";
    private final String knM = "PRIVATE_INVOICE_TITLE";
    private ArrayList<CardInfo> knN;
    private ArrayList<CardInfo> knO;
    private ArrayList<CardInfo> knP;

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.m2504i(88663);
        CardInfo sY = m5015sY(i);
        AppMethodBeat.m2505o(88663);
        return sY;
    }

    public C2781k(Context context, C11290a c11290a) {
        super(context, c11290a);
        AppMethodBeat.m2504i(88654);
        this.kiz = c11290a;
        this.kgW = new C38776aa(context, this);
        this.knN = new ArrayList();
        this.knO = new ArrayList();
        this.knP = new ArrayList();
        AppMethodBeat.m2505o(88654);
    }

    private void bdw() {
        CardInfo cardInfo;
        AppMethodBeat.m2504i(88655);
        int i = 0;
        this.knN.clear();
        this.knO.clear();
        this.knP.clear();
        while (true) {
            int i2 = i;
            if (i2 >= this.count) {
                break;
            }
            cardInfo = (CardInfo) super.getItem(i2);
            if (cardInfo != null) {
                if (cardInfo.aZH()) {
                    this.knP.add(cardInfo);
                } else {
                    this.knO.add(cardInfo);
                }
            }
            i = i2 + 1;
        }
        if (!this.knO.isEmpty()) {
            cardInfo = new CardInfo();
            cardInfo.field_card_id = "PRIVATE_TICKET_TITLE";
            this.knN.add(cardInfo);
            this.knN.addAll(this.knO);
        }
        if (!this.knP.isEmpty()) {
            cardInfo = new CardInfo();
            cardInfo.field_card_id = "PRIVATE_INVOICE_TITLE";
            this.knN.add(cardInfo);
            this.knN.addAll(this.knP);
        }
        this.count = this.knN.size();
        AppMethodBeat.m2505o(88655);
    }

    /* renamed from: KC */
    public final void mo6869KC() {
        AppMethodBeat.m2504i(88656);
        C4990ab.m7418v("MicroMsg.CardTicketAdapter", "resetCursor");
        bIf();
        Cursor a = C42852am.baW().mo45384a(this.kiz);
        if (a != null) {
            this.count = a.getCount();
            C4990ab.m7418v("MicroMsg.CardTicketAdapter", "card count:" + this.count);
        }
        setCursor(a);
        bdw();
        notifyDataSetChanged();
        AppMethodBeat.m2505o(88656);
    }

    /* renamed from: KD */
    public final void mo6870KD() {
        AppMethodBeat.m2504i(88657);
        bIf();
        mo6869KC();
        AppMethodBeat.m2505o(88657);
    }

    /* renamed from: sY */
    private CardInfo m5015sY(int i) {
        AppMethodBeat.m2504i(88658);
        CardInfo cardInfo = (CardInfo) this.knN.get(i);
        AppMethodBeat.m2505o(88658);
        return cardInfo;
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.m2504i(88659);
        CardInfo sY = m5015sY(i);
        if (sY.field_card_id.equals("PRIVATE_TICKET_TITLE") || sY.field_card_id.equals("PRIVATE_INVOICE_TITLE")) {
            AppMethodBeat.m2505o(88659);
            return 0;
        } else if (sY.aZH()) {
            AppMethodBeat.m2505o(88659);
            return 2;
        } else {
            AppMethodBeat.m2505o(88659);
            return 1;
        }
    }

    public final int getCount() {
        AppMethodBeat.m2504i(88660);
        int count;
        if (this.knN.isEmpty()) {
            count = super.getCount();
            AppMethodBeat.m2505o(88660);
            return count;
        }
        count = this.knN.size();
        AppMethodBeat.m2505o(88660);
        return count;
    }

    public final int getViewTypeCount() {
        return 3;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(88661);
        View a = this.kgW.mo6879a(i, view, m5015sY(i));
        AppMethodBeat.m2505o(88661);
        return a;
    }

    public final void release() {
        AppMethodBeat.m2504i(88662);
        bIf();
        this.kgW.release();
        this.kgW = null;
        AppMethodBeat.m2505o(88662);
    }
}
