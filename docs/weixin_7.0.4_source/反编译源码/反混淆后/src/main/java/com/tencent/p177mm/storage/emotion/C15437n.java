package com.tencent.p177mm.storage.emotion;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p213cd.C6398g;
import com.tencent.p177mm.p213cd.C6398g.C1361a;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.storage.emotion.n */
public final class C15437n extends C7563j<C23520m> implements C1361a {
    public static final String[] fnj = new String[]{C7563j.m13217a(C23520m.ccO, "EmotionRewardTipInfo")};
    private C4927e bSd;

    static {
        AppMethodBeat.m2504i(62866);
        AppMethodBeat.m2505o(62866);
    }

    public C15437n(C4927e c4927e) {
        this(c4927e, C23520m.ccO, "EmotionRewardTipInfo");
    }

    private C15437n(C4927e c4927e, C4924a c4924a, String str) {
        super(c4927e, c4924a, str, null);
        this.bSd = c4927e;
    }

    /* renamed from: a */
    public final int mo4744a(C6398g c6398g) {
        this.bSd = c6398g;
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0056  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final C23520m dvk() {
        Throwable e;
        AppMethodBeat.m2504i(62863);
        Cursor a;
        try {
            a = this.bSd.mo10104a("select * from EmotionRewardTipInfo order by modifyTime desc limit 1 ", new String[0], 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        C23520m c23520m = new C23520m();
                        c23520m.mo8995d(a);
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.m2505o(62863);
                        return c23520m;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C4990ab.m7413e("MicroMsg.emoji.EmotionRewardTipStorage", "getLastSendProductID failed. :%s", C5046bo.m7574l(e));
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.m2505o(62863);
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        if (a != null) {
                        }
                        AppMethodBeat.m2505o(62863);
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
            AppMethodBeat.m2505o(62863);
            throw e;
        }
        AppMethodBeat.m2505o(62863);
        return null;
    }

    /* renamed from: eu */
    public final boolean mo27481eu(String str, int i) {
        AppMethodBeat.m2504i(62864);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.emoji.EmotionRewardTipStorage", "product id is null.");
            AppMethodBeat.m2505o(62864);
            return false;
        }
        C4990ab.m7417i("MicroMsg.emoji.EmotionRewardTipStorage", "updateFlag result:%b", Boolean.valueOf(this.bSd.mo10108hY("EmotionRewardTipInfo", "UPDATE EmotionRewardTipInfo SET flag=" + i + ",setFlagTime=" + System.currentTimeMillis() + " WHERE prodcutID='" + str + "'")));
        AppMethodBeat.m2505o(62864);
        return this.bSd.mo10108hY("EmotionRewardTipInfo", "UPDATE EmotionRewardTipInfo SET flag=" + i + ",setFlagTime=" + System.currentTimeMillis() + " WHERE prodcutID='" + str + "'");
    }

    /* renamed from: a */
    public final boolean mo27479a(C23520m c23520m) {
        AppMethodBeat.m2504i(62865);
        if (c23520m == null) {
            C4990ab.m7420w("MicroMsg.emoji.EmotionRewardTipStorage", "save failed info is null");
            AppMethodBeat.m2505o(62865);
            return false;
        }
        long replace = this.bSd.replace("EmotionRewardTipInfo", "prodcutID", c23520m.mo10098Hl());
        if (replace > 0) {
            C4990ab.m7416i("MicroMsg.emoji.EmotionRewardTipStorage", "save success");
        } else {
            C4990ab.m7416i("MicroMsg.emoji.EmotionRewardTipStorage", "save failed");
        }
        if (replace > 0) {
            AppMethodBeat.m2505o(62865);
            return true;
        }
        AppMethodBeat.m2505o(62865);
        return false;
    }
}
