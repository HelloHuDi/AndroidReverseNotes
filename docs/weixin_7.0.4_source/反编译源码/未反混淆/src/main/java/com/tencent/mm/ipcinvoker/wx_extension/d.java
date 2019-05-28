package com.tencent.mm.ipcinvoker.wx_extension;

import android.os.Parcel;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.a;
import com.tencent.mm.sdk.platformtools.ab;

public final class d implements a {
    private static final d eGK = new d();

    static {
        AppMethodBeat.i(101704);
        AppMethodBeat.o(101704);
    }

    public static void a(com.tencent.mm.bt.a aVar, Parcel parcel) {
        AppMethodBeat.i(101700);
        eGK.a((Object) aVar, parcel);
        AppMethodBeat.o(101700);
    }

    public static <PB extends com.tencent.mm.bt.a> PB f(Parcel parcel) {
        AppMethodBeat.i(101701);
        com.tencent.mm.bt.a aVar = (com.tencent.mm.bt.a) eGK.d(parcel);
        AppMethodBeat.o(101701);
        return aVar;
    }

    public final boolean aq(Object obj) {
        return obj instanceof com.tencent.mm.bt.a;
    }

    public final void a(Object obj, Parcel parcel) {
        AppMethodBeat.i(101702);
        if (obj == null) {
            parcel.writeString(null);
            AppMethodBeat.o(101702);
            return;
        }
        byte[] toByteArray;
        com.tencent.mm.bt.a aVar = (com.tencent.mm.bt.a) obj;
        parcel.writeString(aVar.getClass().getName());
        try {
            toByteArray = aVar.toByteArray();
        } catch (Exception e) {
            ab.e("MicroMsg.XIPC.MMProtoBufTransfer", "writeToParcel, e = %s", e);
            toByteArray = new byte[0];
        }
        parcel.writeInt(toByteArray.length);
        parcel.writeByteArray(toByteArray);
        AppMethodBeat.o(101702);
    }

    public final Object d(Parcel parcel) {
        AppMethodBeat.i(101703);
        String readString = parcel.readString();
        if (TextUtils.isEmpty(readString)) {
            AppMethodBeat.o(101703);
            return null;
        }
        com.tencent.mm.bt.a aVar;
        byte[] bArr = new byte[parcel.readInt()];
        parcel.readByteArray(bArr);
        try {
            aVar = (com.tencent.mm.bt.a) Class.forName(readString).newInstance();
            aVar.parseFrom(bArr);
        } catch (Exception e) {
            ab.e("MicroMsg.XIPC.MMProtoBufTransfer", "readFromParcel, e = %s", e);
            aVar = null;
        }
        AppMethodBeat.o(101703);
        return aVar;
    }
}
