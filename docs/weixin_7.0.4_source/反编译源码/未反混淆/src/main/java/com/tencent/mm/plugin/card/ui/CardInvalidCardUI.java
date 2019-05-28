package com.tencent.mm.plugin.card.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.card.model.r;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;

public class CardInvalidCardUI extends CardBaseUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(CardInvalidCardUI cardInvalidCardUI, LinkedList linkedList) {
        AppMethodBeat.i(88544);
        cardInvalidCardUI.H(linkedList);
        AppMethodBeat.o(88544);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(88538);
        super.onCreate(bundle);
        super.initView();
        AppMethodBeat.o(88538);
    }

    public final void initView() {
        AppMethodBeat.i(139165);
        super.initView();
        AppMethodBeat.o(139165);
    }

    public final a aZq() {
        return a.INVALID_TYPE;
    }

    public final void aZp() {
        AppMethodBeat.i(88540);
        setMMTitle((int) R.string.aey);
        addTextOptionMenu(0, getString(R.string.acz), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(88536);
                CardInvalidCardUI.a(CardInvalidCardUI.this);
                AppMethodBeat.o(88536);
                return true;
            }
        });
        if (this.kan.getCount() > 0) {
            enableOptionMenu(true);
            AppMethodBeat.o(88540);
            return;
        }
        enableOptionMenu(false);
        AppMethodBeat.o(88540);
    }

    public final int getLayoutId() {
        return R.layout.j9;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(88541);
        super.onSceneEnd(i, i2, str, mVar);
        if (i == 0 && i2 == 0 && (mVar instanceof r)) {
            if (this.kar) {
                h.bQ(this, getResources().getString(R.string.ad1));
            } else {
                h.bQ(this, getResources().getString(R.string.adi));
            }
        }
        this.kar = false;
        AppMethodBeat.o(88541);
    }

    static /* synthetic */ void a(CardInvalidCardUI cardInvalidCardUI) {
        AppMethodBeat.i(88542);
        d.a(cardInvalidCardUI, new d.a() {
            public final void bdj() {
                AppMethodBeat.i(88537);
                CardInvalidCardUI.this.kar = true;
                CardInvalidCardUI.a(CardInvalidCardUI.this, CardInvalidCardUI.c(CardInvalidCardUI.this));
                AppMethodBeat.o(88537);
            }
        });
        AppMethodBeat.o(88542);
    }

    static /* synthetic */ LinkedList c(CardInvalidCardUI cardInvalidCardUI) {
        AppMethodBeat.i(88543);
        LinkedList linkedList = new LinkedList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < cardInvalidCardUI.kan.getCount()) {
                CardInfo cardInfo = (CardInfo) cardInvalidCardUI.kat.sM(i2);
                if (cardInfo != null) {
                    linkedList.add(cardInfo.field_card_id);
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(88543);
                return linkedList;
            }
        }
    }
}
