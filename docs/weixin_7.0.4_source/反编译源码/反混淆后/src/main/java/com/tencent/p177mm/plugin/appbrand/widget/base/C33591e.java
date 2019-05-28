package com.tencent.p177mm.plugin.appbrand.widget.base;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.base.e */
public final class C33591e {
    public final ViewGroup eAl;
    public final LinkedList<View> iVk = new LinkedList();
    public C33592a iVl;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.base.e$a */
    public static final class C33592a {
        public final long iVm;
        public final long iVn;

        public /* synthetic */ C33592a(long j, long j2, byte b) {
            this(j, j2);
        }

        private C33592a(long j, long j2) {
            this.iVm = j;
            this.iVn = j2;
        }
    }

    public C33591e(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(77400);
        this.eAl = viewGroup;
        AppMethodBeat.m2505o(77400);
    }
}
