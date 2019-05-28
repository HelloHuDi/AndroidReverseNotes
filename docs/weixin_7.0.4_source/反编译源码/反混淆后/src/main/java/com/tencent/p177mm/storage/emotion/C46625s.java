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
import java.util.ArrayList;

/* renamed from: com.tencent.mm.storage.emotion.s */
public final class C46625s extends C7563j<C40628r> implements C1361a {
    public static final String[] fnj = new String[]{C7563j.m13217a(C40628r.ccO, "SmileyPanelConfigInfo")};
    private static final String[] ybf = new String[]{"position", "key"};
    public C4927e bSd;

    static {
        AppMethodBeat.m2504i(62890);
        AppMethodBeat.m2505o(62890);
    }

    public C46625s(C4927e c4927e) {
        this(c4927e, C40628r.ccO, "SmileyPanelConfigInfo");
    }

    private C46625s(C4927e c4927e, C4924a c4924a, String str) {
        super(c4927e, c4924a, str, null);
        this.bSd = c4927e;
    }

    /* renamed from: a */
    public final int mo4744a(C6398g c6398g) {
        this.bSd = c6398g;
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0055  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final ArrayList<C40628r> bjP() {
        Throwable e;
        AppMethodBeat.m2504i(62889);
        ArrayList arrayList = new ArrayList();
        Cursor a;
        try {
            a = this.bSd.mo10105a("SmileyPanelConfigInfo", ybf, null, null, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        do {
                            C40628r c40628r = new C40628r();
                            c40628r.mo8995d(a);
                            arrayList.add(c40628r);
                        } while (a.moveToNext());
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C4990ab.m7412e("MicroMsg.emoji.SmileyPanelConfigInfoStorage", C5046bo.m7574l(e));
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.m2505o(62889);
                        return arrayList;
                    } catch (Throwable th) {
                        e = th;
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.m2505o(62889);
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
            }
            AppMethodBeat.m2505o(62889);
            throw e;
        }
        AppMethodBeat.m2505o(62889);
        return arrayList;
    }
}
