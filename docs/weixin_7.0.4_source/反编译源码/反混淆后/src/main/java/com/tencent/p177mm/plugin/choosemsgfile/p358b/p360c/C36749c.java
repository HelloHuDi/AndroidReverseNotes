package com.tencent.p177mm.plugin.choosemsgfile.p358b.p360c;

import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p359b.C11376a;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p359b.C38787m;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p359b.C46904l;
import com.tencent.p177mm.plugin.choosemsgfile.p361ui.C42890a;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.choosemsgfile.b.c.c */
public final class C36749c extends C38788a implements C33817g {
    boolean kuX;

    public C36749c(C42890a c42890a, List<C11376a> list) {
        super(c42890a, list);
    }

    public final boolean bfz() {
        return this.kuX;
    }

    /* renamed from: a */
    public final C41531v mo4976a(ViewGroup viewGroup, int i) {
        AppMethodBeat.m2504i(54335);
        C41531v m;
        switch (i) {
            case 0:
                m = C46904l.m89273m(viewGroup);
                AppMethodBeat.m2505o(54335);
                return m;
            default:
                m = C38787m.m65810m(viewGroup);
                AppMethodBeat.m2505o(54335);
                return m;
        }
    }

    /* renamed from: gU */
    public final int mo58598gU(long j) {
        AppMethodBeat.m2504i(54336);
        int i = -1;
        for (C11376a c11376a : this.iJL) {
            i++;
            if (c11376a.kua != null && c11376a.kua.field_msgId == j) {
                AppMethodBeat.m2505o(54336);
                return i;
            }
        }
        AppMethodBeat.m2505o(54336);
        return -1;
    }
}
