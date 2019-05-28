package com.tencent.p177mm.view.p1627c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.emoji.p227a.C32497a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p211cb.C26003e;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.pluginsdk.p597ui.ChatFooterPanel;
import com.tencent.p177mm.sdk.platformtools.C40619x;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.emotion.EmojiGroupInfo;
import com.tencent.p177mm.view.p1097f.C16067a;
import com.tencent.p177mm.view.p646e.C17070a;

/* renamed from: com.tencent.mm.view.c.a */
public final class C44418a {
    public C16067a Aaj;
    public C17070a Adi;
    public int Adj;
    public int Adk;
    public int Adl;
    public boolean Adm = false;
    public int Adn;
    private final String TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanelInfo";
    public int jis;
    public String kWz;
    public int tVA;
    public int tVB;

    /* JADX WARNING: Removed duplicated region for block: B:77:0x01db  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0082  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C44418a(EmojiGroupInfo emojiGroupInfo, int i, int i2, C16067a c16067a, C17070a c17070a, boolean z) {
        AppMethodBeat.m2504i(63015);
        if (emojiGroupInfo == null || C5046bo.isNullOrNil(emojiGroupInfo.field_productID)) {
            C4990ab.m7416i("MicroMsg.emoji.SmileyPanel.SmileyPanelInfo", "catch invalid Smiley Tab want add??!!");
            AppMethodBeat.m2505o(63015);
            return;
        }
        this.Adi = c17070a;
        this.Aaj = c16067a;
        this.kWz = emojiGroupInfo.field_productID;
        this.jis = i;
        this.Adn = i2;
        if (z || emojiGroupInfo.field_productID.equalsIgnoreCase(String.valueOf(EmojiGroupInfo.yar))) {
            int aRt;
            C16067a c16067a2;
            String str;
            String str2;
            C16067a c16067a3 = this.Aaj;
            if (emojiGroupInfo != null) {
                int Jp;
                if (emojiGroupInfo.field_productID.equals("TAG_DEFAULT_TAB")) {
                    aRt = C26003e.dqK().aRt();
                    c16067a3.dNx();
                } else if (emojiGroupInfo.field_productID.equals(String.valueOf(EmojiGroupInfo.yas))) {
                    aRt = C16067a.isSDCardAvailable() ? c16067a3.dNn() : 0;
                } else if (emojiGroupInfo.field_productID.equals("capture")) {
                    aRt = C32497a.m53203OB().mo53137bZ(c16067a3.gOW == ChatFooterPanel.vhi).size();
                    if (C16067a.m24369QL(c16067a3.gOW)) {
                        aRt++;
                    }
                } else if (emojiGroupInfo.field_productID.equalsIgnoreCase(String.valueOf(EmojiGroupInfo.yar))) {
                    aRt = C16067a.isSDCardAvailable() ? 16 : 0;
                } else if (C16067a.m24373e(emojiGroupInfo)) {
                    aRt = 1;
                    if (emojiGroupInfo != null) {
                        if (emojiGroupInfo.field_count > 0) {
                            aRt = emojiGroupInfo.field_count;
                        } else {
                            Jp = ((C6835d) C1720g.m3530M(C6835d.class)).getProvider().mo35608Jp(emojiGroupInfo.field_productID);
                            emojiGroupInfo.field_count = Jp;
                            long currentTimeMillis = System.currentTimeMillis();
                            ((C6835d) C1720g.m3530M(C6835d.class)).getProvider().mo35622a(emojiGroupInfo);
                            C4990ab.m7411d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            aRt = Jp;
                        }
                    }
                    if (aRt == 0) {
                        aRt = 1;
                    }
                    if (!C16067a.isSDCardAvailable()) {
                        aRt = 0;
                    }
                }
                this.Adj = aRt;
                c16067a2 = this.Aaj;
                str = this.kWz;
                if (c16067a2.jiL > 0 || C5046bo.isNullOrNil(str)) {
                    aRt = 1;
                } else if (str.equals("TAG_STORE_TAB")) {
                    aRt = 1;
                } else {
                    if (str.equals("TAG_DEFAULT_TAB")) {
                        aRt = (c16067a2.jiL - c16067a2.Ael) / c16067a2.atj(str);
                    } else {
                        aRt = c16067a2.jiL / c16067a2.atj(str);
                    }
                    if (C5046bo.isNullOrNil(str)) {
                        Jp = 0;
                    } else if (str.equals("TAG_DEFAULT_TAB")) {
                        Jp = 3;
                    } else {
                        Jp = 2;
                    }
                    if (aRt > Jp) {
                        aRt = Jp;
                    }
                    if (aRt <= 0) {
                        aRt = 1;
                    }
                }
                this.tVA = aRt;
                c16067a3 = this.Aaj;
                str2 = this.kWz;
                if (!C5046bo.isNullOrNil(str2)) {
                    aRt = 0;
                } else if (str2.equals("TAG_DEFAULT_TAB")) {
                    if (C40619x.m70075gu(c16067a3.f3007Gn)) {
                        aRt = 7;
                    } else {
                        aRt = c16067a3.aRB() / c16067a3.Aef;
                    }
                } else if (c16067a3.jiL <= 0) {
                    aRt = 0;
                } else if (str2.equals("TAG_STORE_TAB")) {
                    aRt = 3;
                } else {
                    aRt = c16067a3.aRB() / c16067a3.Aec;
                    if (C40619x.m70075gu(c16067a3.f3007Gn) && aRt > 4) {
                        aRt = 4;
                    }
                    C4990ab.m7411d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "return calc Col Nums: %d", Integer.valueOf(aRt));
                }
                this.tVB = aRt;
                this.Aaj.mo28459a(this);
            }
            aRt = 1;
            this.Adj = aRt;
            c16067a2 = this.Aaj;
            str = this.kWz;
            if (c16067a2.jiL > 0) {
            }
            aRt = 1;
            this.tVA = aRt;
            c16067a3 = this.Aaj;
            str2 = this.kWz;
            if (!C5046bo.isNullOrNil(str2)) {
            }
            this.tVB = aRt;
            this.Aaj.mo28459a(this);
        } else {
            this.Adj = 1;
            this.tVA = 1;
            this.tVB = 1;
            this.Aaj.mo28459a(this);
        }
        this.Adm = z;
        C4990ab.m7417i("MicroMsg.emoji.SmileyPanel.SmileyPanelInfo", "smiley panel tab: productId: %s, startIndex: %d mAllEmojiNums: %d mRow:%d mCol:%d mSpacing:%d ", this.kWz, Integer.valueOf(i), Integer.valueOf(this.Adj), Integer.valueOf(this.tVA), Integer.valueOf(this.tVB), Integer.valueOf(this.Adk));
        AppMethodBeat.m2505o(63015);
    }

    public final int aRz() {
        return this.tVA * this.tVB;
    }

    public final int dMW() {
        return this.tVA * this.tVB;
    }

    public final int dMX() {
        AppMethodBeat.m2504i(63017);
        int ceil;
        if (aRz() <= 0) {
            AppMethodBeat.m2505o(63017);
            return 0;
        } else if (dMV()) {
            ceil = (int) Math.ceil(((double) this.Adj) / ((double) (aRz() - 1)));
            if (this.Aaj.dNx()) {
                ceil++;
                AppMethodBeat.m2505o(63017);
                return ceil;
            }
            AppMethodBeat.m2505o(63017);
            return ceil;
        } else {
            ceil = (int) Math.ceil(((double) this.Adj) / ((double) aRz()));
            AppMethodBeat.m2505o(63017);
            return ceil;
        }
    }

    public final int getColumnWidth() {
        AppMethodBeat.m2504i(63018);
        int aRB = this.Aaj.aRB() / (this.Aaj.aRB() / this.Aaj.Aec);
        AppMethodBeat.m2505o(63018);
        return aRB;
    }

    private boolean dMV() {
        AppMethodBeat.m2504i(63016);
        boolean equals = "TAG_DEFAULT_TAB".equals(this.kWz);
        AppMethodBeat.m2505o(63016);
        return equals;
    }
}
