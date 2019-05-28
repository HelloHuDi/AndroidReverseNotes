package com.tencent.p177mm.plugin.card.p355ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.card.base.CardBaseUI;
import com.tencent.p177mm.plugin.card.model.C33771n.C11290a;
import com.tencent.p177mm.plugin.card.model.C6817r;
import com.tencent.p177mm.plugin.card.model.CardInfo;
import com.tencent.p177mm.plugin.card.p931d.C42840d;
import com.tencent.p177mm.plugin.card.p931d.C42840d.C27574a;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.card.ui.CardInvalidCardUI */
public class CardInvalidCardUI extends CardBaseUI {

    /* renamed from: com.tencent.mm.plugin.card.ui.CardInvalidCardUI$2 */
    class C387592 extends C27574a {
        C387592() {
        }

        public final void bdj() {
            AppMethodBeat.m2504i(88537);
            CardInvalidCardUI.this.kar = true;
            CardInvalidCardUI.m76104a(CardInvalidCardUI.this, CardInvalidCardUI.m76106c(CardInvalidCardUI.this));
            AppMethodBeat.m2505o(88537);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardInvalidCardUI$1 */
    class C428631 implements OnMenuItemClickListener {
        C428631() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(88536);
            CardInvalidCardUI.m76103a(CardInvalidCardUI.this);
            AppMethodBeat.m2505o(88536);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m76104a(CardInvalidCardUI cardInvalidCardUI, LinkedList linkedList) {
        AppMethodBeat.m2504i(88544);
        cardInvalidCardUI.mo54293H(linkedList);
        AppMethodBeat.m2505o(88544);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(88538);
        super.onCreate(bundle);
        super.initView();
        AppMethodBeat.m2505o(88538);
    }

    public final void initView() {
        AppMethodBeat.m2504i(139165);
        super.initView();
        AppMethodBeat.m2505o(139165);
    }

    public final C11290a aZq() {
        return C11290a.INVALID_TYPE;
    }

    public final void aZp() {
        AppMethodBeat.m2504i(88540);
        setMMTitle((int) C25738R.string.aey);
        addTextOptionMenu(0, getString(C25738R.string.acz), new C428631());
        if (this.kan.getCount() > 0) {
            enableOptionMenu(true);
            AppMethodBeat.m2505o(88540);
            return;
        }
        enableOptionMenu(false);
        AppMethodBeat.m2505o(88540);
    }

    public final int getLayoutId() {
        return 2130968944;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(88541);
        super.onSceneEnd(i, i2, str, c1207m);
        if (i == 0 && i2 == 0 && (c1207m instanceof C6817r)) {
            if (this.kar) {
                C30379h.m48465bQ(this, getResources().getString(C25738R.string.ad1));
            } else {
                C30379h.m48465bQ(this, getResources().getString(C25738R.string.adi));
            }
        }
        this.kar = false;
        AppMethodBeat.m2505o(88541);
    }

    /* renamed from: a */
    static /* synthetic */ void m76103a(CardInvalidCardUI cardInvalidCardUI) {
        AppMethodBeat.m2504i(88542);
        C42840d.m76034a(cardInvalidCardUI, new C387592());
        AppMethodBeat.m2505o(88542);
    }

    /* renamed from: c */
    static /* synthetic */ LinkedList m76106c(CardInvalidCardUI cardInvalidCardUI) {
        AppMethodBeat.m2504i(88543);
        LinkedList linkedList = new LinkedList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < cardInvalidCardUI.kan.getCount()) {
                CardInfo cardInfo = (CardInfo) cardInvalidCardUI.kat.mo35381sM(i2);
                if (cardInfo != null) {
                    linkedList.add(cardInfo.field_card_id);
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(88543);
                return linkedList;
            }
        }
    }
}
