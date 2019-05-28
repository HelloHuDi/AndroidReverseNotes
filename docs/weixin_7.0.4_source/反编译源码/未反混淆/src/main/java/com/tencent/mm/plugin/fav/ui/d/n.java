package com.tencent.mm.plugin.fav.ui.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.protocal.protobuf.abh;

public final class n extends a {
    public n(l lVar) {
        super(lVar);
    }

    public final View a(View view, ViewGroup viewGroup, g gVar) {
        AppMethodBeat.i(74653);
        View view2 = new View(viewGroup.getContext());
        AppMethodBeat.o(74653);
        return view2;
    }

    public final void a(View view, abh abh) {
        AppMethodBeat.i(74654);
        if (view != null) {
            Toast.makeText(view.getContext(), R.string.bs6, 0).show();
        }
        AppMethodBeat.o(74654);
    }
}
