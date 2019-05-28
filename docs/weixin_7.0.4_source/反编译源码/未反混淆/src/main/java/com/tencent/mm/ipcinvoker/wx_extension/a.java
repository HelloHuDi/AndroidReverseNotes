package com.tencent.mm.ipcinvoker.wx_extension;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ipcinvoker.extension.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class a implements com.tencent.mm.ipcinvoker.extension.a {
    public final boolean aq(Object obj) {
        return obj instanceof b;
    }

    public final void a(Object obj, Parcel parcel) {
        AppMethodBeat.i(126194);
        b bVar = (b) obj;
        c.a(bVar.fsG.fsP, parcel);
        if (ah.bqo()) {
            c.a(bVar.fsH.fsP, parcel);
        } else {
            parcel.writeString(bVar.fsH.fsP.getClass().getName());
        }
        parcel.writeString(bVar.uri);
        parcel.writeInt(bVar.fsI);
        parcel.writeInt(bVar.fsG.cmdId);
        parcel.writeInt(bVar.fsH.cmdId);
        parcel.writeInt(bVar.azs);
        AppMethodBeat.o(126194);
    }

    public final Object d(Parcel parcel) {
        AppMethodBeat.i(126195);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = (com.tencent.mm.bt.a) c.a(d.class.getName(), parcel);
        if (ah.bqo()) {
            try {
                aVar.fsK = (com.tencent.mm.bt.a) Class.forName(parcel.readString()).newInstance();
            } catch (Exception e) {
                ab.e("MicroMsg.XIPC.CommReqRespTransfer", "readFromParcel, mm process initiate resp e = %s", e);
                aVar.fsK = new com.tencent.mm.bt.a();
            }
        } else {
            com.tencent.mm.bt.a aVar2 = (com.tencent.mm.bt.a) c.a(d.class.getName(), parcel);
            if (aVar2 == null) {
                aVar2 = new com.tencent.mm.bt.a();
            }
            aVar.fsK = aVar2;
        }
        aVar.uri = parcel.readString();
        aVar.fsI = parcel.readInt();
        aVar.fsL = parcel.readInt();
        aVar.fsM = parcel.readInt();
        aVar.azs = parcel.readInt();
        b acD = aVar.acD();
        AppMethodBeat.o(126195);
        return acD;
    }
}
