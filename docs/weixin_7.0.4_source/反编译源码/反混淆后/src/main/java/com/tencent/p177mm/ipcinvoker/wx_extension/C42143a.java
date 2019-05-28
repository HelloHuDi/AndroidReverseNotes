package com.tencent.p177mm.ipcinvoker.wx_extension;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.extension.C18508a;
import com.tencent.p177mm.ipcinvoker.extension.C18509c;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.ipcinvoker.wx_extension.a */
public final class C42143a implements C18508a {
    /* renamed from: aq */
    public final boolean mo20824aq(Object obj) {
        return obj instanceof C7472b;
    }

    /* renamed from: a */
    public final void mo20823a(Object obj, Parcel parcel) {
        AppMethodBeat.m2504i(126194);
        C7472b c7472b = (C7472b) obj;
        C18509c.m28814a(c7472b.fsG.fsP, parcel);
        if (C4996ah.bqo()) {
            C18509c.m28814a(c7472b.fsH.fsP, parcel);
        } else {
            parcel.writeString(c7472b.fsH.fsP.getClass().getName());
        }
        parcel.writeString(c7472b.uri);
        parcel.writeInt(c7472b.fsI);
        parcel.writeInt(c7472b.fsG.cmdId);
        parcel.writeInt(c7472b.fsH.cmdId);
        parcel.writeInt(c7472b.azs);
        AppMethodBeat.m2505o(126194);
    }

    /* renamed from: d */
    public final Object mo20825d(Parcel parcel) {
        AppMethodBeat.m2504i(126195);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = (C1331a) C18509c.m28812a(C45414d.class.getName(), parcel);
        if (C4996ah.bqo()) {
            try {
                c1196a.fsK = (C1331a) Class.forName(parcel.readString()).newInstance();
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.XIPC.CommReqRespTransfer", "readFromParcel, mm process initiate resp e = %s", e);
                c1196a.fsK = new C1331a();
            }
        } else {
            C1331a c1331a = (C1331a) C18509c.m28812a(C45414d.class.getName(), parcel);
            if (c1331a == null) {
                c1331a = new C1331a();
            }
            c1196a.fsK = c1331a;
        }
        c1196a.uri = parcel.readString();
        c1196a.fsI = parcel.readInt();
        c1196a.fsL = parcel.readInt();
        c1196a.fsM = parcel.readInt();
        c1196a.azs = parcel.readInt();
        C7472b acD = c1196a.acD();
        AppMethodBeat.m2505o(126195);
        return acD;
    }
}
