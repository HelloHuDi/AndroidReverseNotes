package com.tencent.mm.plugin.appbrand.widget.base;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class e {
    public final ViewGroup eAl;
    public final LinkedList<View> iVk = new LinkedList();
    public a iVl;

    public static final class a {
        public final long iVm;
        public final long iVn;

        public /* synthetic */ a(long j, long j2, byte b) {
            this(j, j2);
        }

        private a(long j, long j2) {
            this.iVm = j;
            this.iVn = j2;
        }
    }

    public e(ViewGroup viewGroup) {
        AppMethodBeat.i(77400);
        this.eAl = viewGroup;
        AppMethodBeat.o(77400);
    }
}
