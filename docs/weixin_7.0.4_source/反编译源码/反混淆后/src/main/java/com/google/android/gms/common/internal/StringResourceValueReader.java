package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import javax.annotation.Nullable;

public class StringResourceValueReader {
    private final Resources zzvb;
    private final String zzvc = this.zzvb.getResourcePackageName(C25738R.string.common_google_play_services_unknown_issue);

    public StringResourceValueReader(Context context) {
        AppMethodBeat.m2504i(89721);
        Preconditions.checkNotNull(context);
        this.zzvb = context.getResources();
        AppMethodBeat.m2505o(89721);
    }

    @Nullable
    public String getString(String str) {
        AppMethodBeat.m2504i(89722);
        int identifier = this.zzvb.getIdentifier(str, "string", this.zzvc);
        if (identifier == 0) {
            AppMethodBeat.m2505o(89722);
            return null;
        }
        String string = this.zzvb.getString(identifier);
        AppMethodBeat.m2505o(89722);
        return string;
    }
}
