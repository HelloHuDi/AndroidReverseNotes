package com.tencent.mm.view.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;

public final class a {
    public com.tencent.mm.view.f.a Aaj;
    public com.tencent.mm.view.e.a Adi;
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
    public a(EmojiGroupInfo emojiGroupInfo, int i, int i2, com.tencent.mm.view.f.a aVar, com.tencent.mm.view.e.a aVar2, boolean z) {
        AppMethodBeat.i(63015);
        if (emojiGroupInfo == null || bo.isNullOrNil(emojiGroupInfo.field_productID)) {
            ab.i("MicroMsg.emoji.SmileyPanel.SmileyPanelInfo", "catch invalid Smiley Tab want add??!!");
            AppMethodBeat.o(63015);
            return;
        }
        this.Adi = aVar2;
        this.Aaj = aVar;
        this.kWz = emojiGroupInfo.field_productID;
        this.jis = i;
        this.Adn = i2;
        if (z || emojiGroupInfo.field_productID.equalsIgnoreCase(String.valueOf(EmojiGroupInfo.yar))) {
            int aRt;
            com.tencent.mm.view.f.a aVar3;
            String str;
            String str2;
            com.tencent.mm.view.f.a aVar4 = this.Aaj;
            if (emojiGroupInfo != null) {
                int Jp;
                if (emojiGroupInfo.field_productID.equals("TAG_DEFAULT_TAB")) {
                    aRt = e.dqK().aRt();
                    aVar4.dNx();
                } else if (emojiGroupInfo.field_productID.equals(String.valueOf(EmojiGroupInfo.yas))) {
                    aRt = com.tencent.mm.view.f.a.isSDCardAvailable() ? aVar4.dNn() : 0;
                } else if (emojiGroupInfo.field_productID.equals("capture")) {
                    aRt = com.tencent.mm.emoji.a.a.OB().bZ(aVar4.gOW == ChatFooterPanel.vhi).size();
                    if (com.tencent.mm.view.f.a.QL(aVar4.gOW)) {
                        aRt++;
                    }
                } else if (emojiGroupInfo.field_productID.equalsIgnoreCase(String.valueOf(EmojiGroupInfo.yar))) {
                    aRt = com.tencent.mm.view.f.a.isSDCardAvailable() ? 16 : 0;
                } else if (com.tencent.mm.view.f.a.e(emojiGroupInfo)) {
                    aRt = 1;
                    if (emojiGroupInfo != null) {
                        if (emojiGroupInfo.field_count > 0) {
                            aRt = emojiGroupInfo.field_count;
                        } else {
                            Jp = ((d) g.M(d.class)).getProvider().Jp(emojiGroupInfo.field_productID);
                            emojiGroupInfo.field_count = Jp;
                            long currentTimeMillis = System.currentTimeMillis();
                            ((d) g.M(d.class)).getProvider().a(emojiGroupInfo);
                            ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            aRt = Jp;
                        }
                    }
                    if (aRt == 0) {
                        aRt = 1;
                    }
                    if (!com.tencent.mm.view.f.a.isSDCardAvailable()) {
                        aRt = 0;
                    }
                }
                this.Adj = aRt;
                aVar3 = this.Aaj;
                str = this.kWz;
                if (aVar3.jiL > 0 || bo.isNullOrNil(str)) {
                    aRt = 1;
                } else if (str.equals("TAG_STORE_TAB")) {
                    aRt = 1;
                } else {
                    if (str.equals("TAG_DEFAULT_TAB")) {
                        aRt = (aVar3.jiL - aVar3.Ael) / aVar3.atj(str);
                    } else {
                        aRt = aVar3.jiL / aVar3.atj(str);
                    }
                    if (bo.isNullOrNil(str)) {
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
                aVar4 = this.Aaj;
                str2 = this.kWz;
                if (!bo.isNullOrNil(str2)) {
                    aRt = 0;
                } else if (str2.equals("TAG_DEFAULT_TAB")) {
                    if (x.gu(aVar4.Gn)) {
                        aRt = 7;
                    } else {
                        aRt = aVar4.aRB() / aVar4.Aef;
                    }
                } else if (aVar4.jiL <= 0) {
                    aRt = 0;
                } else if (str2.equals("TAG_STORE_TAB")) {
                    aRt = 3;
                } else {
                    aRt = aVar4.aRB() / aVar4.Aec;
                    if (x.gu(aVar4.Gn) && aRt > 4) {
                        aRt = 4;
                    }
                    ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "return calc Col Nums: %d", Integer.valueOf(aRt));
                }
                this.tVB = aRt;
                this.Aaj.a(this);
            }
            aRt = 1;
            this.Adj = aRt;
            aVar3 = this.Aaj;
            str = this.kWz;
            if (aVar3.jiL > 0) {
            }
            aRt = 1;
            this.tVA = aRt;
            aVar4 = this.Aaj;
            str2 = this.kWz;
            if (!bo.isNullOrNil(str2)) {
            }
            this.tVB = aRt;
            this.Aaj.a(this);
        } else {
            this.Adj = 1;
            this.tVA = 1;
            this.tVB = 1;
            this.Aaj.a(this);
        }
        this.Adm = z;
        ab.i("MicroMsg.emoji.SmileyPanel.SmileyPanelInfo", "smiley panel tab: productId: %s, startIndex: %d mAllEmojiNums: %d mRow:%d mCol:%d mSpacing:%d ", this.kWz, Integer.valueOf(i), Integer.valueOf(this.Adj), Integer.valueOf(this.tVA), Integer.valueOf(this.tVB), Integer.valueOf(this.Adk));
        AppMethodBeat.o(63015);
    }

    public final int aRz() {
        return this.tVA * this.tVB;
    }

    public final int dMW() {
        return this.tVA * this.tVB;
    }

    public final int dMX() {
        AppMethodBeat.i(63017);
        int ceil;
        if (aRz() <= 0) {
            AppMethodBeat.o(63017);
            return 0;
        } else if (dMV()) {
            ceil = (int) Math.ceil(((double) this.Adj) / ((double) (aRz() - 1)));
            if (this.Aaj.dNx()) {
                ceil++;
                AppMethodBeat.o(63017);
                return ceil;
            }
            AppMethodBeat.o(63017);
            return ceil;
        } else {
            ceil = (int) Math.ceil(((double) this.Adj) / ((double) aRz()));
            AppMethodBeat.o(63017);
            return ceil;
        }
    }

    public final int getColumnWidth() {
        AppMethodBeat.i(63018);
        int aRB = this.Aaj.aRB() / (this.Aaj.aRB() / this.Aaj.Aec);
        AppMethodBeat.o(63018);
        return aRB;
    }

    private boolean dMV() {
        AppMethodBeat.i(63016);
        boolean equals = "TAG_DEFAULT_TAB".equals(this.kWz);
        AppMethodBeat.o(63016);
        return equals;
    }
}
