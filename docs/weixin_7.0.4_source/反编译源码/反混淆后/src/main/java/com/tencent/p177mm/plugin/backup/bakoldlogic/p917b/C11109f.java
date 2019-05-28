package com.tencent.p177mm.plugin.backup.bakoldlogic.p917b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.backup.bakoldlogic.p918d.C11124b;
import com.tencent.p177mm.plugin.backup.bakoldlogic.p918d.C11131d;
import com.tencent.p177mm.plugin.backup.p921i.C19993u;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h;
import com.tencent.p177mm.protocal.protobuf.C40522gu;
import com.tencent.p177mm.storage.C7620bi;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.b.f */
public final class C11109f implements C45737j {
    /* renamed from: a */
    public final int mo22812a(String str, C40522gu c40522gu, C7620bi c7620bi) {
        AppMethodBeat.m2504i(17792);
        String str2 = new String(c40522gu.vED.wVI);
        C6977h XO = C11124b.aUY().aUZ().mo45269XO();
        c7620bi.setContent(str2);
        switch (c40522gu.jCt) {
            case 50:
                c7620bi.setStatus(6);
                break;
        }
        if (c7620bi.field_msgId == 0) {
            C11131d.m18845l(c7620bi);
        } else {
            XO.mo15302b(c40522gu.ptF, c7620bi);
        }
        AppMethodBeat.m2505o(17792);
        return 0;
    }

    /* renamed from: a */
    public final int mo22811a(C40522gu c40522gu, C7620bi c7620bi, LinkedList<C19993u> linkedList) {
        AppMethodBeat.m2504i(17791);
        if (c7620bi.field_content == null) {
            AppMethodBeat.m2505o(17791);
            return 0;
        }
        int length = c7620bi.field_content.getBytes().length;
        AppMethodBeat.m2505o(17791);
        return length;
    }
}
