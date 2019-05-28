package com.tencent.mm.vending.d;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    Bundle zXI = null;

    public a(Intent intent) {
        AppMethodBeat.i(126078);
        this.zXI = intent.getExtras();
        AppMethodBeat.o(126078);
    }

    public final int getIntExtra(String str, int i) {
        AppMethodBeat.i(126079);
        if (this.zXI == null) {
            AppMethodBeat.o(126079);
            return i;
        }
        i = this.zXI.getInt(str, i);
        AppMethodBeat.o(126079);
        return i;
    }

    public final String getStringExtra(String str) {
        AppMethodBeat.i(126080);
        if (this.zXI == null) {
            AppMethodBeat.o(126080);
            return null;
        }
        String string = this.zXI.getString(str);
        AppMethodBeat.o(126080);
        return string;
    }
}
