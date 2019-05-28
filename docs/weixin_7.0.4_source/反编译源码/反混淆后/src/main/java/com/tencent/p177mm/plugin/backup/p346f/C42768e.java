package com.tencent.p177mm.plugin.backup.p346f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.backup.p1394h.C38658d;
import com.tencent.p177mm.plugin.backup.p1394h.C45748c;
import com.tencent.p177mm.plugin.backup.p346f.C45745h.C19972a;
import com.tencent.p177mm.plugin.backup.p921i.C19993u;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h;
import com.tencent.p177mm.protocal.protobuf.C40522gu;
import com.tencent.p177mm.storage.C7620bi;
import java.util.HashMap;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.backup.f.e */
public final class C42768e implements C27487l {
    /* renamed from: a */
    public final int mo35220a(String str, C40522gu c40522gu, C7620bi c7620bi) {
        AppMethodBeat.m2504i(17458);
        String str2 = new String(c40522gu.vED.wVI);
        C6977h XO = C38658d.aUr().aUs().mo61498XO();
        c7620bi.setContent(str2);
        switch (c40522gu.jCt) {
            case 50:
                c7620bi.setStatus(6);
                break;
        }
        if (c7620bi.field_msgId == 0) {
            C45748c.m84550l(c7620bi);
        } else {
            XO.mo15302b(c40522gu.ptF, c7620bi);
        }
        AppMethodBeat.m2505o(17458);
        return 0;
    }

    /* renamed from: a */
    public final int mo35219a(C40522gu c40522gu, boolean z, C7620bi c7620bi, String str, LinkedList<C19993u> linkedList, HashMap<Long, C19972a> hashMap, boolean z2, long j) {
        AppMethodBeat.m2504i(17457);
        if (c7620bi.field_content == null) {
            AppMethodBeat.m2505o(17457);
            return 0;
        }
        int length = c7620bi.field_content.getBytes().length;
        AppMethodBeat.m2505o(17457);
        return length;
    }
}
