package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.c;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.card.ui.view.aa;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

public final class k extends c {
    private final String TAG = "MicroMsg.CardTicketAdapter";
    private int count = 0;
    private c kgW;
    private a kiz;
    private final String knL = "PRIVATE_TICKET_TITLE";
    private final String knM = "PRIVATE_INVOICE_TITLE";
    private ArrayList<CardInfo> knN;
    private ArrayList<CardInfo> knO;
    private ArrayList<CardInfo> knP;

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.i(88663);
        CardInfo sY = sY(i);
        AppMethodBeat.o(88663);
        return sY;
    }

    public k(Context context, a aVar) {
        super(context, aVar);
        AppMethodBeat.i(88654);
        this.kiz = aVar;
        this.kgW = new aa(context, this);
        this.knN = new ArrayList();
        this.knO = new ArrayList();
        this.knP = new ArrayList();
        AppMethodBeat.o(88654);
    }

    private void bdw() {
        CardInfo cardInfo;
        AppMethodBeat.i(88655);
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
        AppMethodBeat.o(88655);
    }

    public final void KC() {
        AppMethodBeat.i(88656);
        ab.v("MicroMsg.CardTicketAdapter", "resetCursor");
        bIf();
        Cursor a = am.baW().a(this.kiz);
        if (a != null) {
            this.count = a.getCount();
            ab.v("MicroMsg.CardTicketAdapter", "card count:" + this.count);
        }
        setCursor(a);
        bdw();
        notifyDataSetChanged();
        AppMethodBeat.o(88656);
    }

    public final void KD() {
        AppMethodBeat.i(88657);
        bIf();
        KC();
        AppMethodBeat.o(88657);
    }

    private CardInfo sY(int i) {
        AppMethodBeat.i(88658);
        CardInfo cardInfo = (CardInfo) this.knN.get(i);
        AppMethodBeat.o(88658);
        return cardInfo;
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.i(88659);
        CardInfo sY = sY(i);
        if (sY.field_card_id.equals("PRIVATE_TICKET_TITLE") || sY.field_card_id.equals("PRIVATE_INVOICE_TITLE")) {
            AppMethodBeat.o(88659);
            return 0;
        } else if (sY.aZH()) {
            AppMethodBeat.o(88659);
            return 2;
        } else {
            AppMethodBeat.o(88659);
            return 1;
        }
    }

    public final int getCount() {
        AppMethodBeat.i(88660);
        int count;
        if (this.knN.isEmpty()) {
            count = super.getCount();
            AppMethodBeat.o(88660);
            return count;
        }
        count = this.knN.size();
        AppMethodBeat.o(88660);
        return count;
    }

    public final int getViewTypeCount() {
        return 3;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(88661);
        View a = this.kgW.a(i, view, sY(i));
        AppMethodBeat.o(88661);
        return a;
    }

    public final void release() {
        AppMethodBeat.i(88662);
        bIf();
        this.kgW.release();
        this.kgW = null;
        AppMethodBeat.o(88662);
    }
}
