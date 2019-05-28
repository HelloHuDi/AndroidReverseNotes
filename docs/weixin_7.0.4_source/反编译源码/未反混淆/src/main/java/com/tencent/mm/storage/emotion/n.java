package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.g;
import com.tencent.mm.cd.g.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class n extends j<m> implements a {
    public static final String[] fnj = new String[]{j.a(m.ccO, "EmotionRewardTipInfo")};
    private e bSd;

    static {
        AppMethodBeat.i(62866);
        AppMethodBeat.o(62866);
    }

    public n(e eVar) {
        this(eVar, m.ccO, "EmotionRewardTipInfo");
    }

    private n(e eVar, c.a aVar, String str) {
        super(eVar, aVar, str, null);
        this.bSd = eVar;
    }

    public final int a(g gVar) {
        this.bSd = gVar;
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0056  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final m dvk() {
        Throwable e;
        AppMethodBeat.i(62863);
        Cursor a;
        try {
            a = this.bSd.a("select * from EmotionRewardTipInfo order by modifyTime desc limit 1 ", new String[0], 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        m mVar = new m();
                        mVar.d(a);
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.o(62863);
                        return mVar;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        ab.e("MicroMsg.emoji.EmotionRewardTipStorage", "getLastSendProductID failed. :%s", bo.l(e));
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.o(62863);
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        if (a != null) {
                        }
                        AppMethodBeat.o(62863);
                        throw e;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
        } catch (Throwable th2) {
            e = th2;
            a = null;
            if (a != null) {
                a.close();
            }
            AppMethodBeat.o(62863);
            throw e;
        }
        AppMethodBeat.o(62863);
        return null;
    }

    public final boolean eu(String str, int i) {
        AppMethodBeat.i(62864);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.emoji.EmotionRewardTipStorage", "product id is null.");
            AppMethodBeat.o(62864);
            return false;
        }
        ab.i("MicroMsg.emoji.EmotionRewardTipStorage", "updateFlag result:%b", Boolean.valueOf(this.bSd.hY("EmotionRewardTipInfo", "UPDATE EmotionRewardTipInfo SET flag=" + i + ",setFlagTime=" + System.currentTimeMillis() + " WHERE prodcutID='" + str + "'")));
        AppMethodBeat.o(62864);
        return this.bSd.hY("EmotionRewardTipInfo", "UPDATE EmotionRewardTipInfo SET flag=" + i + ",setFlagTime=" + System.currentTimeMillis() + " WHERE prodcutID='" + str + "'");
    }

    public final boolean a(m mVar) {
        AppMethodBeat.i(62865);
        if (mVar == null) {
            ab.w("MicroMsg.emoji.EmotionRewardTipStorage", "save failed info is null");
            AppMethodBeat.o(62865);
            return false;
        }
        long replace = this.bSd.replace("EmotionRewardTipInfo", "prodcutID", mVar.Hl());
        if (replace > 0) {
            ab.i("MicroMsg.emoji.EmotionRewardTipStorage", "save success");
        } else {
            ab.i("MicroMsg.emoji.EmotionRewardTipStorage", "save failed");
        }
        if (replace > 0) {
            AppMethodBeat.o(62865);
            return true;
        }
        AppMethodBeat.o(62865);
        return false;
    }
}
