package com.tencent.p177mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p213cd.C6398g;
import com.tencent.p177mm.p213cd.C6398g.C1361a;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.storage.emotion.f */
public final class C23517f extends C7563j<C30304e> implements C1361a {
    public static final String[] fnj = new String[]{C7563j.m13217a(C30304e.ccO, "EmojiSuggestDescInfo")};
    private C4927e bSd;

    static {
        AppMethodBeat.m2504i(62848);
        AppMethodBeat.m2505o(62848);
    }

    public C23517f(C4927e c4927e) {
        this(c4927e, C30304e.ccO, "EmojiSuggestDescInfo");
    }

    private C23517f(C4927e c4927e, C4924a c4924a, String str) {
        super(c4927e, c4924a, str, null);
        this.bSd = c4927e;
    }

    /* renamed from: a */
    public final int mo4744a(C6398g c6398g) {
        this.bSd = c6398g;
        return 0;
    }

    /* renamed from: am */
    public final boolean mo39186am(ArrayList<ArrayList<String>> arrayList) {
        AppMethodBeat.m2504i(62847);
        if (arrayList.isEmpty()) {
            C4990ab.m7416i("MicroMsg.emoji.EmojiDescMapStorage", "group list is null.");
            AppMethodBeat.m2505o(62847);
        } else {
            long iV;
            C7480h c7480h;
            if (this.bSd instanceof C7480h) {
                C7480h c7480h2 = (C7480h) this.bSd;
                iV = c7480h2.mo15639iV(Thread.currentThread().getId());
                c7480h = c7480h2;
            } else {
                iV = -1;
                c7480h = null;
            }
            this.bSd.delete("EmojiSuggestDescInfo", "", null);
            Iterator it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                ArrayList arrayList2 = (ArrayList) it.next();
                if (!(arrayList2 == null || arrayList2.isEmpty())) {
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        String str = (String) it2.next();
                        if (!C5046bo.isNullOrNil(str)) {
                            C4990ab.m7411d("MicroMsg.emoji.EmojiDescMapStorage", "insert groupID%s, word:%s", String.valueOf(i), str);
                            mo10101b((C4925c) new C30304e(String.valueOf(i), str));
                        }
                    }
                    i++;
                }
                i = i;
            }
            if (c7480h != null) {
                c7480h.mo15640mB(iV);
            }
            AppMethodBeat.m2505o(62847);
        }
        return false;
    }
}
