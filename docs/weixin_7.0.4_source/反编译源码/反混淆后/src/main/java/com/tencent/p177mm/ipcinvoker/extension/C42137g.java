package com.tencent.p177mm.ipcinvoker.extension;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C26341k;

/* renamed from: com.tencent.mm.ipcinvoker.extension.g */
public final class C42137g implements C18508a {
    /* renamed from: aq */
    public final boolean mo20824aq(Object obj) {
        return obj instanceof C42136f;
    }

    /* renamed from: a */
    public final void mo20823a(Object obj, Parcel parcel) {
        AppMethodBeat.m2504i(114101);
        C42136f c42136f = (C42136f) obj;
        parcel.writeString(c42136f.getClass().getName());
        c42136f.mo5956e(parcel);
        AppMethodBeat.m2505o(114101);
    }

    /* renamed from: d */
    public final Object mo20825d(Parcel parcel) {
        AppMethodBeat.m2504i(114102);
        C42136f c42136f = (C42136f) C26341k.m41920c(parcel.readString(), C42136f.class);
        if (c42136f != null) {
            c42136f.readFromParcel(parcel);
            AppMethodBeat.m2505o(114102);
            return c42136f;
        }
        AppMethodBeat.m2505o(114102);
        return null;
    }
}
