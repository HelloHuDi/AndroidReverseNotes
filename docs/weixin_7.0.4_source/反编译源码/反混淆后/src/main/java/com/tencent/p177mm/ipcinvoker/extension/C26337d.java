package com.tencent.p177mm.ipcinvoker.extension;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ipcinvoker.extension.d */
public final class C26337d implements C18508a {
    /* renamed from: aq */
    public final boolean mo20824aq(Object obj) {
        return obj instanceof Parcelable;
    }

    /* renamed from: a */
    public final void mo20823a(Object obj, Parcel parcel) {
        AppMethodBeat.m2504i(114086);
        parcel.writeParcelable((Parcelable) obj, 0);
        AppMethodBeat.m2505o(114086);
    }

    /* renamed from: d */
    public final Object mo20825d(Parcel parcel) {
        AppMethodBeat.m2504i(114087);
        Parcelable readParcelable = parcel.readParcelable(getClass().getClassLoader());
        AppMethodBeat.m2505o(114087);
        return readParcelable;
    }
}
