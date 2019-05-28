package com.tencent.mm.plugin.wenote.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ld;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.fav.a.an;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wenote.model.f;
import com.tencent.mm.plugin.wenote.model.g;
import com.tencent.mm.plugin.wenote.model.g.AnonymousClass1;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONException;

public final class a extends c<ld> {
    public a() {
        AppMethodBeat.i(26585);
        this.xxI = ld.class.getName().hashCode();
        AppMethodBeat.o(26585);
    }

    private static boolean a(ld ldVar) {
        AppMethodBeat.i(26586);
        switch (ldVar.cGU.type) {
            case 0:
                com.tencent.mm.plugin.wenote.model.c.ddG().uMN.b(ldVar);
                break;
            case 2:
                g gVar = new g();
                com.tencent.mm.plugin.wenote.model.c.ddG().uMN = gVar;
                if (ldVar.cGU.cHa == 4) {
                    long j;
                    h.pYm.e(14789, Integer.valueOf(4));
                    ab.i("MicroMsg.NotifyWNNoteOperationListener", "do OPEN_NOTE_FROM_SNS");
                    Context context = ldVar.cGU.context;
                    abf abf = ldVar.cGU.field_favProto;
                    Bundle bundle = ldVar.cGU.cGZ;
                    boolean z = ldVar.cGU.cHc;
                    String str = "";
                    String str2 = "";
                    if (bundle != null) {
                        str = bundle.getString("noteauthor", "");
                        str2 = bundle.getString("noteeditor", "");
                        j = bundle.getLong("edittime", 0);
                        gVar.uNg = bundle.getString("snslocalid");
                        gVar.uNh = bundle.getString("notexml", "");
                        gVar.uNo = bundle.getString("snsthumbpath", "");
                        gVar.uNp = bundle.getString("snsnotelinkxml", "");
                    } else {
                        j = 0;
                    }
                    gVar.cHh = System.currentTimeMillis();
                    gVar.cHc = z;
                    gVar.uMY = false;
                    gVar.uNl = str + ";" + str2 + ";" + j;
                    gVar.ab(context, 4);
                    aw.RS().aa(new AnonymousClass1(abf));
                    break;
                }
                int i;
                h.pYm.e(14789, Integer.valueOf(1));
                ab.i("MicroMsg.NotifyWNNoteOperationListener", "do OPEN_NOTE_FROM_FAV");
                if (ldVar.cGU.cHa == 5) {
                    i = 1;
                } else {
                    boolean i2 = false;
                }
                if (!(ldVar.cGU.field_favProto == null || ldVar.cGU.field_favProto.wit == null)) {
                    gVar.uNm = ldVar.cGU.field_favProto.wit.cvp;
                }
                if (ldVar.cGU.cGZ != null) {
                    gVar.uNn = ldVar.cGU.cGZ.getLong("edittime", 0);
                }
                if (i2 == 0) {
                    gVar.a(ldVar.cGU.field_localId, ldVar.cGU.context, Boolean.valueOf(ldVar.cGU.cHc), 0, 0, ldVar.cGU.cHd, null);
                    break;
                }
                gVar.uNq = true;
                gVar.a(ldVar.cGU.field_localId, ldVar.cGU.context, Boolean.valueOf(ldVar.cGU.cHc), 0, 0, ldVar.cGU.cHd, ldVar.cGU.field_favProto);
                break;
            case 3:
                ldVar.cGV.path = an.bvj();
                break;
            case 7:
                switch (ldVar.cGU.itemType) {
                    case 2:
                        com.tencent.mm.plugin.wenote.model.h.ae(ldVar.cGU.cHb);
                        break;
                    case 3:
                        try {
                            com.tencent.mm.plugin.wenote.model.h.agZ(ldVar.cGU.cGX);
                            break;
                        } catch (JSONException e) {
                            ab.printErrStackTrace("MicroMsg.NotifyWNNoteOperationListener", e, "", new Object[0]);
                            break;
                        }
                    case 4:
                        com.tencent.mm.plugin.wenote.model.h.q(ldVar.cGU.context, ldVar.cGU.path, ldVar.cGU.cHa);
                        break;
                    case 5:
                        com.tencent.mm.plugin.wenote.model.h.agY(ldVar.cGU.path);
                        break;
                }
                break;
            case 8:
                com.tencent.mm.plugin.wenote.model.h.bq(ldVar.cGU.context, ldVar.cGU.path);
                break;
            case 9:
                ab.i("MicroMsg.NotifyWNNoteOperationListener", "do OPEN_NOTE_FROM_ADD");
                g gVar2 = new g();
                gVar2.cHh = ldVar.cGU.field_localId;
                com.tencent.mm.plugin.wenote.model.c.ddG().uMN = gVar2;
                Context context2 = ldVar.cGU.context;
                gVar2.uMY = true;
                gVar2.ab(context2, 2);
                break;
            case 10:
                f.y(ldVar.cGU.field_localId, ldVar.cGU.path);
                break;
            case 11:
                f.ad(ldVar.cGU.cHb);
                break;
            case 12:
                aw.RS().m(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(26714);
                        ab.i("MicroMsg.Note.NoteDataManager", "NoteDataManager onDestroy");
                        c.this.den();
                        c.this.uPa = null;
                        c.this.uPb = null;
                        c.this.uPc = 0;
                        c.uOZ = null;
                        AppMethodBeat.o(26714);
                    }
                }, 700);
                break;
        }
        AppMethodBeat.o(26586);
        return false;
    }
}
