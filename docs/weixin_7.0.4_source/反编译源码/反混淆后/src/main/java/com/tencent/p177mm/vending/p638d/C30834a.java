package com.tencent.p177mm.vending.p638d;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.vending.d.a */
public final class C30834a {
    Bundle zXI = null;

    public C30834a(Intent intent) {
        AppMethodBeat.m2504i(126078);
        this.zXI = intent.getExtras();
        AppMethodBeat.m2505o(126078);
    }

    public final int getIntExtra(String str, int i) {
        AppMethodBeat.m2504i(126079);
        if (this.zXI == null) {
            AppMethodBeat.m2505o(126079);
            return i;
        }
        i = this.zXI.getInt(str, i);
        AppMethodBeat.m2505o(126079);
        return i;
    }

    public final String getStringExtra(String str) {
        AppMethodBeat.m2504i(126080);
        if (this.zXI == null) {
            AppMethodBeat.m2505o(126080);
            return null;
        }
        String string = this.zXI.getString(str);
        AppMethodBeat.m2505o(126080);
        return string;
    }
}
