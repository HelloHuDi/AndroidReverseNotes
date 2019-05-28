package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.emoji.f.o;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.m;
import java.util.HashMap;

public final class k {
    public int emW = 79;
    public boolean kUC = true;
    public long kUD = 863913600000L;
    public int kUE = 19;
    public m kUF;
    public HashMap<String, m> kUG = new HashMap();

    public k() {
        AppMethodBeat.i(52977);
        AppMethodBeat.o(52977);
    }

    public final void bkc() {
        AppMethodBeat.i(52978);
        if (this.kUF != null) {
            this.kUF.field_continuCount = 0;
            this.kUG.put(this.kUF.field_prodcutID, this.kUF);
            j.getEmojiStorageMgr().xYu.a(this.kUF);
            this.kUF = null;
        }
        AppMethodBeat.o(52978);
    }

    public final boolean Js(String str) {
        AppMethodBeat.i(52979);
        if (bo.isNullOrNil(str)) {
            ab.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip product id is null.");
            AppMethodBeat.o(52979);
            return false;
        } else if (this.kUC || r.YI()) {
            m mVar;
            if (this.kUG == null || !this.kUG.containsKey(str)) {
                mVar = new m();
                mVar.field_prodcutID = str;
            } else {
                mVar = (m) this.kUG.get(str);
            }
            if (System.currentTimeMillis() - mVar.field_showTipsTime < this.kUD) {
                ab.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip in cool down time.");
                bkc();
                AppMethodBeat.o(52979);
                return false;
            }
            String str2;
            String str3;
            Object[] objArr;
            if (mVar == null || System.currentTimeMillis() - mVar.field_setFlagTime <= 86400000) {
                str2 = "MicroMsg.emoji.EmojiRewardTipMgr";
                str3 = "no need to get reward today. continue count:%d total count:%d";
                objArr = new Object[2];
                objArr[0] = Integer.valueOf(this.kUF == null ? 0 : this.kUF.field_continuCount);
                objArr[1] = Integer.valueOf(this.kUF == null ? 0 : this.kUF.field_totalCount);
                ab.d(str2, str3, objArr);
            } else if (this.kUF != null && str.equalsIgnoreCase(this.kUF.field_prodcutID) && this.kUF.field_continuCount >= this.kUE - 1 && this.kUF.field_continuCount <= (this.kUE + 5) - 1) {
                g.RO().eJo.a(new o(str, o.kWY), 0);
            } else if (mVar.field_totalCount >= this.emW - 1 && mVar.field_totalCount <= (this.emW + 5) - 1) {
                g.RO().eJo.a(new o(str, o.kWY), 0);
            }
            if (this.kUF == null || !str.equalsIgnoreCase(this.kUF.field_prodcutID) || this.kUF.field_continuCount < this.kUE) {
                if (mVar == null || mVar.field_totalCount < this.emW) {
                    a(mVar, false);
                    AppMethodBeat.o(52979);
                    return false;
                } else if ((mVar.field_flag & o.kWZ) != o.kWZ || (mVar.field_flag & o.kXa) == o.kXa) {
                    str2 = "MicroMsg.emoji.EmojiRewardTipMgr";
                    str3 = "isNeedShowTip:%b productid:%s  total count :%d flag:%d";
                    objArr = new Object[4];
                    objArr[0] = Boolean.FALSE;
                    objArr[1] = str;
                    objArr[2] = Integer.valueOf(this.kUF == null ? 0 : this.kUF.field_totalCount);
                    objArr[3] = Integer.valueOf(this.kUF == null ? 0 : this.kUF.field_flag);
                    ab.i(str2, str3, objArr);
                    a(mVar, false);
                    AppMethodBeat.o(52979);
                    return false;
                } else {
                    str2 = "MicroMsg.emoji.EmojiRewardTipMgr";
                    str3 = "isNeedShowTip:%b productid:%s  total count :%d";
                    objArr = new Object[3];
                    objArr[0] = Boolean.TRUE;
                    objArr[1] = str;
                    objArr[2] = Integer.valueOf(this.kUF == null ? 0 : this.kUF.field_totalCount);
                    ab.i(str2, str3, objArr);
                    a(mVar, true);
                    h hVar = h.pYm;
                    Object[] objArr2 = new Object[2];
                    objArr2[0] = Integer.valueOf(0);
                    objArr2[1] = this.kUF == null ? "" : this.kUF.field_prodcutID;
                    hVar.e(12953, objArr2);
                    AppMethodBeat.o(52979);
                    return true;
                }
            } else if ((this.kUF.field_flag & o.kWZ) != o.kWZ || (this.kUF.field_flag & o.kXa) == o.kXa) {
                ab.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip:%b productid:%s  continue count:%d flag:%d", Boolean.FALSE, str, Integer.valueOf(this.kUF.field_continuCount), Integer.valueOf(this.kUF.field_flag));
                a(mVar, false);
                AppMethodBeat.o(52979);
                return false;
            } else {
                ab.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip:%b productid:%s  continue count:%d", Boolean.TRUE, str, Integer.valueOf(this.kUF.field_continuCount));
                a(mVar, true);
                h.pYm.e(12953, Integer.valueOf(0), this.kUF.field_prodcutID);
                AppMethodBeat.o(52979);
                return true;
            }
        } else {
            ab.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip reward tip is disable. mRewardTipEnable:%b isOpenForWallet:%b", Boolean.valueOf(this.kUC), Boolean.valueOf(r.YI()));
            AppMethodBeat.o(52979);
            return false;
        }
    }

    private void a(m mVar, boolean z) {
        AppMethodBeat.i(52980);
        if (mVar == null) {
            ab.w("MicroMsg.emoji.EmojiRewardTipMgr", "updateLastRewardTipInfo failed. reward tip info is null.");
            AppMethodBeat.o(52980);
            return;
        }
        int i = (this.kUF == null || this.kUF.field_prodcutID.equalsIgnoreCase(mVar.field_prodcutID)) ? 1 : 0;
        if (i == 0) {
            this.kUF.field_continuCount = 0;
            this.kUG.put(this.kUF.field_prodcutID, this.kUF);
            j.getEmojiStorageMgr().xYu.a(this.kUF);
        }
        this.kUF = mVar;
        if (z) {
            this.kUF.field_modifyTime = 0;
            this.kUF.field_showTipsTime = System.currentTimeMillis();
            this.kUF.field_totalCount = 0;
            this.kUF.field_continuCount = 0;
        } else {
            if (i != 0) {
                this.kUF.field_continuCount++;
            } else {
                this.kUF.field_continuCount = 1;
            }
            this.kUF.field_totalCount++;
            this.kUF.field_modifyTime = System.currentTimeMillis();
        }
        this.kUG.put(this.kUF.field_prodcutID, this.kUF);
        j.getEmojiStorageMgr().xYu.a(this.kUF);
        AppMethodBeat.o(52980);
    }

    public final void ca(String str, int i) {
        AppMethodBeat.i(52981);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.emoji.EmojiRewardTipMgr", "updateProductFlag failed. no such product id.");
            AppMethodBeat.o(52981);
        } else if (this.kUG == null || !this.kUG.containsKey(str)) {
            ab.i("MicroMsg.emoji.EmojiRewardTipMgr", "updateProductFlag map no contains this product id :%s", str);
            AppMethodBeat.o(52981);
        } else {
            ((m) this.kUG.get(str)).field_flag = i;
            ((m) this.kUG.get(str)).field_setFlagTime = System.currentTimeMillis();
            AppMethodBeat.o(52981);
        }
    }
}
