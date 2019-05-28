package com.tencent.mm.plugin.appbrand.permission;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;

public class h implements f {
    protected final i gPI;

    public h(i iVar) {
        this.gPI = iVar;
    }

    public void Dq(String str) {
        AppMethodBeat.i(102303);
        Toast.makeText(this.gPI.getContext(), String.format("jsapi banned %s", new Object[]{str}), 0).show();
        AppMethodBeat.o(102303);
    }
}
