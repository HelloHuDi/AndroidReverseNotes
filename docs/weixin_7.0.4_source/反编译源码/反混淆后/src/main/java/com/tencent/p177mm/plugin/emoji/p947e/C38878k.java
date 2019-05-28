package com.tencent.p177mm.plugin.emoji.p947e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.plugin.emoji.p726f.C27738o;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.emotion.C23520m;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.emoji.e.k */
public final class C38878k {
    public int emW = 79;
    public boolean kUC = true;
    public long kUD = 863913600000L;
    public int kUE = 19;
    public C23520m kUF;
    public HashMap<String, C23520m> kUG = new HashMap();

    /* renamed from: com.tencent.mm.plugin.emoji.e.k$1 */
    public class C277361 implements Runnable {
        /* JADX WARNING: Removed duplicated region for block: B:14:0x004e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            AppMethodBeat.m2504i(52976);
            if (C38878k.this.kUC) {
                C38878k c38878k = C38878k.this;
                if (C42952j.getEmojiStorageMgr().xYu != null) {
                    c38878k.kUF = C42952j.getEmojiStorageMgr().xYu.dvk();
                }
                c38878k = C38878k.this;
                Cursor cursor = null;
                try {
                    cursor = C42952j.getEmojiStorageMgr().xYu.baR();
                    if (cursor != null && cursor.moveToFirst()) {
                        do {
                            C23520m c23520m = new C23520m();
                            c23520m.mo8995d(cursor);
                            c38878k.kUG.put(c23520m.field_prodcutID, c23520m);
                        } while (cursor.moveToNext());
                        if (cursor != null) {
                        }
                    } else if (cursor != null) {
                        cursor.close();
                        AppMethodBeat.m2505o(52976);
                        return;
                    }
                } catch (Exception e) {
                    C4990ab.m7420w("MicroMsg.emoji.EmojiRewardTipMgr", C5046bo.m7574l(e));
                    if (cursor != null) {
                        cursor.close();
                        AppMethodBeat.m2505o(52976);
                        return;
                    }
                } catch (Throwable th) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    AppMethodBeat.m2505o(52976);
                }
            }
            AppMethodBeat.m2505o(52976);
        }
    }

    public C38878k() {
        AppMethodBeat.m2504i(52977);
        AppMethodBeat.m2505o(52977);
    }

    public final void bkc() {
        AppMethodBeat.m2504i(52978);
        if (this.kUF != null) {
            this.kUF.field_continuCount = 0;
            this.kUG.put(this.kUF.field_prodcutID, this.kUF);
            C42952j.getEmojiStorageMgr().xYu.mo27479a(this.kUF);
            this.kUF = null;
        }
        AppMethodBeat.m2505o(52978);
    }

    /* renamed from: Js */
    public final boolean mo61750Js(String str) {
        AppMethodBeat.m2504i(52979);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7416i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip product id is null.");
            AppMethodBeat.m2505o(52979);
            return false;
        } else if (this.kUC || C1853r.m3827YI()) {
            C23520m c23520m;
            if (this.kUG == null || !this.kUG.containsKey(str)) {
                c23520m = new C23520m();
                c23520m.field_prodcutID = str;
            } else {
                c23520m = (C23520m) this.kUG.get(str);
            }
            if (System.currentTimeMillis() - c23520m.field_showTipsTime < this.kUD) {
                C4990ab.m7416i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip in cool down time.");
                bkc();
                AppMethodBeat.m2505o(52979);
                return false;
            }
            String str2;
            String str3;
            Object[] objArr;
            if (c23520m == null || System.currentTimeMillis() - c23520m.field_setFlagTime <= 86400000) {
                str2 = "MicroMsg.emoji.EmojiRewardTipMgr";
                str3 = "no need to get reward today. continue count:%d total count:%d";
                objArr = new Object[2];
                objArr[0] = Integer.valueOf(this.kUF == null ? 0 : this.kUF.field_continuCount);
                objArr[1] = Integer.valueOf(this.kUF == null ? 0 : this.kUF.field_totalCount);
                C4990ab.m7411d(str2, str3, objArr);
            } else if (this.kUF != null && str.equalsIgnoreCase(this.kUF.field_prodcutID) && this.kUF.field_continuCount >= this.kUE - 1 && this.kUF.field_continuCount <= (this.kUE + 5) - 1) {
                C1720g.m3535RO().eJo.mo14541a(new C27738o(str, C27738o.kWY), 0);
            } else if (c23520m.field_totalCount >= this.emW - 1 && c23520m.field_totalCount <= (this.emW + 5) - 1) {
                C1720g.m3535RO().eJo.mo14541a(new C27738o(str, C27738o.kWY), 0);
            }
            if (this.kUF == null || !str.equalsIgnoreCase(this.kUF.field_prodcutID) || this.kUF.field_continuCount < this.kUE) {
                if (c23520m == null || c23520m.field_totalCount < this.emW) {
                    m65946a(c23520m, false);
                    AppMethodBeat.m2505o(52979);
                    return false;
                } else if ((c23520m.field_flag & C27738o.kWZ) != C27738o.kWZ || (c23520m.field_flag & C27738o.kXa) == C27738o.kXa) {
                    str2 = "MicroMsg.emoji.EmojiRewardTipMgr";
                    str3 = "isNeedShowTip:%b productid:%s  total count :%d flag:%d";
                    objArr = new Object[4];
                    objArr[0] = Boolean.FALSE;
                    objArr[1] = str;
                    objArr[2] = Integer.valueOf(this.kUF == null ? 0 : this.kUF.field_totalCount);
                    objArr[3] = Integer.valueOf(this.kUF == null ? 0 : this.kUF.field_flag);
                    C4990ab.m7417i(str2, str3, objArr);
                    m65946a(c23520m, false);
                    AppMethodBeat.m2505o(52979);
                    return false;
                } else {
                    str2 = "MicroMsg.emoji.EmojiRewardTipMgr";
                    str3 = "isNeedShowTip:%b productid:%s  total count :%d";
                    objArr = new Object[3];
                    objArr[0] = Boolean.TRUE;
                    objArr[1] = str;
                    objArr[2] = Integer.valueOf(this.kUF == null ? 0 : this.kUF.field_totalCount);
                    C4990ab.m7417i(str2, str3, objArr);
                    m65946a(c23520m, true);
                    C7060h c7060h = C7060h.pYm;
                    Object[] objArr2 = new Object[2];
                    objArr2[0] = Integer.valueOf(0);
                    objArr2[1] = this.kUF == null ? "" : this.kUF.field_prodcutID;
                    c7060h.mo8381e(12953, objArr2);
                    AppMethodBeat.m2505o(52979);
                    return true;
                }
            } else if ((this.kUF.field_flag & C27738o.kWZ) != C27738o.kWZ || (this.kUF.field_flag & C27738o.kXa) == C27738o.kXa) {
                C4990ab.m7417i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip:%b productid:%s  continue count:%d flag:%d", Boolean.FALSE, str, Integer.valueOf(this.kUF.field_continuCount), Integer.valueOf(this.kUF.field_flag));
                m65946a(c23520m, false);
                AppMethodBeat.m2505o(52979);
                return false;
            } else {
                C4990ab.m7417i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip:%b productid:%s  continue count:%d", Boolean.TRUE, str, Integer.valueOf(this.kUF.field_continuCount));
                m65946a(c23520m, true);
                C7060h.pYm.mo8381e(12953, Integer.valueOf(0), this.kUF.field_prodcutID);
                AppMethodBeat.m2505o(52979);
                return true;
            }
        } else {
            C4990ab.m7417i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip reward tip is disable. mRewardTipEnable:%b isOpenForWallet:%b", Boolean.valueOf(this.kUC), Boolean.valueOf(C1853r.m3827YI()));
            AppMethodBeat.m2505o(52979);
            return false;
        }
    }

    /* renamed from: a */
    private void m65946a(C23520m c23520m, boolean z) {
        AppMethodBeat.m2504i(52980);
        if (c23520m == null) {
            C4990ab.m7420w("MicroMsg.emoji.EmojiRewardTipMgr", "updateLastRewardTipInfo failed. reward tip info is null.");
            AppMethodBeat.m2505o(52980);
            return;
        }
        int i = (this.kUF == null || this.kUF.field_prodcutID.equalsIgnoreCase(c23520m.field_prodcutID)) ? 1 : 0;
        if (i == 0) {
            this.kUF.field_continuCount = 0;
            this.kUG.put(this.kUF.field_prodcutID, this.kUF);
            C42952j.getEmojiStorageMgr().xYu.mo27479a(this.kUF);
        }
        this.kUF = c23520m;
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
        C42952j.getEmojiStorageMgr().xYu.mo27479a(this.kUF);
        AppMethodBeat.m2505o(52980);
    }

    /* renamed from: ca */
    public final void mo61752ca(String str, int i) {
        AppMethodBeat.m2504i(52981);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.emoji.EmojiRewardTipMgr", "updateProductFlag failed. no such product id.");
            AppMethodBeat.m2505o(52981);
        } else if (this.kUG == null || !this.kUG.containsKey(str)) {
            C4990ab.m7417i("MicroMsg.emoji.EmojiRewardTipMgr", "updateProductFlag map no contains this product id :%s", str);
            AppMethodBeat.m2505o(52981);
        } else {
            ((C23520m) this.kUG.get(str)).field_flag = i;
            ((C23520m) this.kUG.get(str)).field_setFlagTime = System.currentTimeMillis();
            AppMethodBeat.m2505o(52981);
        }
    }
}
