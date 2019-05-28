package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import javax.annotation.Nullable;

public class StringResourceValueReader {
    private final Resources zzvb;
    private final String zzvc = this.zzvb.getResourcePackageName(R.string.common_google_play_services_unknown_issue);

    public StringResourceValueReader(Context context) {
        AppMethodBeat.i(89721);
        Preconditions.checkNotNull(context);
        this.zzvb = context.getResources();
        AppMethodBeat.o(89721);
    }

    @Nullable
    public String getString(String str) {
        AppMethodBeat.i(89722);
        int identifier = this.zzvb.getIdentifier(str, "string", this.zzvc);
        if (identifier == 0) {
            AppMethodBeat.o(89722);
            return null;
        }
        String string = this.zzvb.getString(identifier);
        AppMethodBeat.o(89722);
        return string;
    }
}
