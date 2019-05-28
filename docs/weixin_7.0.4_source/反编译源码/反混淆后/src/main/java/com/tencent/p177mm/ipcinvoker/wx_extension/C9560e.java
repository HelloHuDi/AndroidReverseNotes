package com.tencent.p177mm.ipcinvoker.wx_extension;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.extension.C18508a;

/* renamed from: com.tencent.mm.ipcinvoker.wx_extension.e */
public final class C9560e implements C18508a {
    /* renamed from: aq */
    public final boolean mo20824aq(Object obj) {
        return obj instanceof Parcel;
    }

    /* renamed from: a */
    public final void mo20823a(Object obj, Parcel parcel) {
        AppMethodBeat.m2504i(126201);
        Parcel parcel2 = (Parcel) obj;
        parcel2.setDataPosition(0);
        parcel.writeInt(parcel2.dataSize());
        parcel.appendFrom(parcel2, 0, parcel2.dataSize());
        AppMethodBeat.m2505o(126201);
    }

    /* renamed from: d */
    public final Object mo20825d(Parcel parcel) {
        AppMethodBeat.m2504i(126202);
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        obtain.appendFrom(parcel, parcel.dataPosition(), parcel.readInt());
        obtain.setDataPosition(0);
        AppMethodBeat.m2505o(126202);
        return obtain;
    }
}
