package com.tencent.p177mm.ipcinvoker.extension;

import android.os.Bundle;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C26341k;
import com.tencent.p177mm.ipcinvoker.p854d.C9547a;

/* renamed from: com.tencent.mm.ipcinvoker.extension.b */
public final class C26336b implements C18508a {
    /* renamed from: aq */
    public final boolean mo20824aq(Object obj) {
        return obj instanceof C9547a;
    }

    /* renamed from: a */
    public final void mo20823a(Object obj, Parcel parcel) {
        AppMethodBeat.m2504i(114079);
        C9547a c9547a = (C9547a) obj;
        parcel.writeString(c9547a.getClass().getName());
        parcel.writeBundle(c9547a.toBundle());
        AppMethodBeat.m2505o(114079);
    }

    /* renamed from: d */
    public final Object mo20825d(Parcel parcel) {
        AppMethodBeat.m2504i(114080);
        String readString = parcel.readString();
        Bundle readBundle = parcel.readBundle();
        C9547a c9547a = (C9547a) C26341k.m41920c(readString, C9547a.class);
        if (c9547a != null) {
            c9547a.fromBundle(readBundle);
            AppMethodBeat.m2505o(114080);
            return c9547a;
        }
        AppMethodBeat.m2505o(114080);
        return null;
    }
}
