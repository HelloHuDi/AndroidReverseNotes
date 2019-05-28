package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class c extends j<b> {
    public static final String[] fnj = new String[]{j.a(b.ccO, "appattach")};
    e bSd;

    public final /* synthetic */ boolean c(com.tencent.mm.sdk.e.c cVar, String[] strArr) {
        AppMethodBeat.i(79235);
        boolean a = a((b) cVar, strArr);
        AppMethodBeat.o(79235);
        return a;
    }

    static {
        AppMethodBeat.i(79236);
        AppMethodBeat.o(79236);
    }

    public c(e eVar) {
        super(eVar, b.ccO, "appattach", null);
        this.bSd = eVar;
    }

    public final void lY(long j) {
        AppMethodBeat.i(79231);
        this.bSd.hY("appattach", " update appattach set status = 198 , lastModifyTime = " + bo.anT() + " where rowid = " + j);
        doNotify();
        AppMethodBeat.o(79231);
    }

    public final b aiE(String str) {
        AppMethodBeat.i(79232);
        b bVar = new b();
        bVar.field_mediaSvrId = str;
        if (b((com.tencent.mm.sdk.e.c) bVar, "mediaSvrId")) {
            AppMethodBeat.o(79232);
            return bVar;
        }
        if (b((com.tencent.mm.sdk.e.c) bVar, "mediaId")) {
            AppMethodBeat.o(79232);
            return bVar;
        }
        AppMethodBeat.o(79232);
        return null;
    }

    public final boolean a(b bVar, String... strArr) {
        AppMethodBeat.i(79233);
        ab.d("MicroMsg.AppAttachInfoStorage", "update AppAttachInfo field_mediaId %s field_mediaSvrId %s ret %s %s", bVar.field_mediaId, bVar.field_mediaSvrId, Boolean.valueOf(super.c(bVar, strArr)), "");
        AppMethodBeat.o(79233);
        return super.c(bVar, strArr);
    }

    public final b lZ(long j) {
        AppMethodBeat.i(79234);
        b bVar = new b();
        bVar.field_msgInfoId = j;
        if (b((com.tencent.mm.sdk.e.c) bVar, "msgInfoId")) {
            AppMethodBeat.o(79234);
            return bVar;
        }
        AppMethodBeat.o(79234);
        return null;
    }
}
