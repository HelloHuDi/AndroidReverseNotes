package com.tencent.p177mm.ipcinvoker.wx_extension;

import android.os.Parcel;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.extension.C18508a;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ipcinvoker.wx_extension.d */
public final class C45414d implements C18508a {
    private static final C45414d eGK = new C45414d();

    static {
        AppMethodBeat.m2504i(101704);
        AppMethodBeat.m2505o(101704);
    }

    /* renamed from: a */
    public static void m83635a(C1331a c1331a, Parcel parcel) {
        AppMethodBeat.m2504i(101700);
        eGK.mo20823a((Object) c1331a, parcel);
        AppMethodBeat.m2505o(101700);
    }

    /* renamed from: f */
    public static <PB extends C1331a> PB m83636f(Parcel parcel) {
        AppMethodBeat.m2504i(101701);
        C1331a c1331a = (C1331a) eGK.mo20825d(parcel);
        AppMethodBeat.m2505o(101701);
        return c1331a;
    }

    /* renamed from: aq */
    public final boolean mo20824aq(Object obj) {
        return obj instanceof C1331a;
    }

    /* renamed from: a */
    public final void mo20823a(Object obj, Parcel parcel) {
        AppMethodBeat.m2504i(101702);
        if (obj == null) {
            parcel.writeString(null);
            AppMethodBeat.m2505o(101702);
            return;
        }
        byte[] toByteArray;
        C1331a c1331a = (C1331a) obj;
        parcel.writeString(c1331a.getClass().getName());
        try {
            toByteArray = c1331a.toByteArray();
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.XIPC.MMProtoBufTransfer", "writeToParcel, e = %s", e);
            toByteArray = new byte[0];
        }
        parcel.writeInt(toByteArray.length);
        parcel.writeByteArray(toByteArray);
        AppMethodBeat.m2505o(101702);
    }

    /* renamed from: d */
    public final Object mo20825d(Parcel parcel) {
        AppMethodBeat.m2504i(101703);
        String readString = parcel.readString();
        if (TextUtils.isEmpty(readString)) {
            AppMethodBeat.m2505o(101703);
            return null;
        }
        C1331a c1331a;
        byte[] bArr = new byte[parcel.readInt()];
        parcel.readByteArray(bArr);
        try {
            c1331a = (C1331a) Class.forName(readString).newInstance();
            c1331a.parseFrom(bArr);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.XIPC.MMProtoBufTransfer", "readFromParcel, e = %s", e);
            c1331a = null;
        }
        AppMethodBeat.m2505o(101703);
        return c1331a;
    }
}
