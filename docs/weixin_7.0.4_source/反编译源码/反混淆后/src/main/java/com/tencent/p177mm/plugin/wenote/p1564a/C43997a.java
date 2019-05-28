package com.tencent.p177mm.plugin.wenote.p1564a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p230g.p231a.C18313ld;
import com.tencent.p177mm.plugin.fav.p407a.C11851an;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wenote.model.C14719f;
import com.tencent.p177mm.plugin.wenote.model.C14720g;
import com.tencent.p177mm.plugin.wenote.model.C14720g.C147211;
import com.tencent.p177mm.plugin.wenote.model.C29980h;
import com.tencent.p177mm.plugin.wenote.model.C46453c;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C40380c.C403811;
import com.tencent.p177mm.protocal.protobuf.abf;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONException;

/* renamed from: com.tencent.mm.plugin.wenote.a.a */
public final class C43997a extends C4884c<C18313ld> {
    public C43997a() {
        AppMethodBeat.m2504i(26585);
        this.xxI = C18313ld.class.getName().hashCode();
        AppMethodBeat.m2505o(26585);
    }

    /* renamed from: a */
    private static boolean m78988a(C18313ld c18313ld) {
        AppMethodBeat.m2504i(26586);
        switch (c18313ld.cGU.type) {
            case 0:
                C46453c.ddG().uMN.mo63730b(c18313ld);
                break;
            case 2:
                C14720g c14720g = new C14720g();
                C46453c.ddG().uMN = c14720g;
                if (c18313ld.cGU.cHa == 4) {
                    long j;
                    C7060h.pYm.mo8381e(14789, Integer.valueOf(4));
                    C4990ab.m7416i("MicroMsg.NotifyWNNoteOperationListener", "do OPEN_NOTE_FROM_SNS");
                    Context context = c18313ld.cGU.context;
                    abf abf = c18313ld.cGU.field_favProto;
                    Bundle bundle = c18313ld.cGU.cGZ;
                    boolean z = c18313ld.cGU.cHc;
                    String str = "";
                    String str2 = "";
                    if (bundle != null) {
                        str = bundle.getString("noteauthor", "");
                        str2 = bundle.getString("noteeditor", "");
                        j = bundle.getLong("edittime", 0);
                        c14720g.uNg = bundle.getString("snslocalid");
                        c14720g.uNh = bundle.getString("notexml", "");
                        c14720g.uNo = bundle.getString("snsthumbpath", "");
                        c14720g.uNp = bundle.getString("snsnotelinkxml", "");
                    } else {
                        j = 0;
                    }
                    c14720g.cHh = System.currentTimeMillis();
                    c14720g.cHc = z;
                    c14720g.uMY = false;
                    c14720g.uNl = str + ";" + str2 + ";" + j;
                    c14720g.mo26988ab(context, 4);
                    C9638aw.m17180RS().mo10302aa(new C147211(abf));
                    break;
                }
                int i;
                C7060h.pYm.mo8381e(14789, Integer.valueOf(1));
                C4990ab.m7416i("MicroMsg.NotifyWNNoteOperationListener", "do OPEN_NOTE_FROM_FAV");
                if (c18313ld.cGU.cHa == 5) {
                    i = 1;
                } else {
                    boolean i2 = false;
                }
                if (!(c18313ld.cGU.field_favProto == null || c18313ld.cGU.field_favProto.wit == null)) {
                    c14720g.uNm = c18313ld.cGU.field_favProto.wit.cvp;
                }
                if (c18313ld.cGU.cGZ != null) {
                    c14720g.uNn = c18313ld.cGU.cGZ.getLong("edittime", 0);
                }
                if (i2 == 0) {
                    c14720g.mo26986a(c18313ld.cGU.field_localId, c18313ld.cGU.context, Boolean.valueOf(c18313ld.cGU.cHc), 0, 0, c18313ld.cGU.cHd, null);
                    break;
                }
                c14720g.uNq = true;
                c14720g.mo26986a(c18313ld.cGU.field_localId, c18313ld.cGU.context, Boolean.valueOf(c18313ld.cGU.cHc), 0, 0, c18313ld.cGU.cHd, c18313ld.cGU.field_favProto);
                break;
            case 3:
                c18313ld.cGV.path = C11851an.bvj();
                break;
            case 7:
                switch (c18313ld.cGU.itemType) {
                    case 2:
                        C29980h.m47438ae(c18313ld.cGU.cHb);
                        break;
                    case 3:
                        try {
                            C29980h.agZ(c18313ld.cGU.cGX);
                            break;
                        } catch (JSONException e) {
                            C4990ab.printErrStackTrace("MicroMsg.NotifyWNNoteOperationListener", e, "", new Object[0]);
                            break;
                        }
                    case 4:
                        C29980h.m47441q(c18313ld.cGU.context, c18313ld.cGU.path, c18313ld.cGU.cHa);
                        break;
                    case 5:
                        C29980h.agY(c18313ld.cGU.path);
                        break;
                }
                break;
            case 8:
                C29980h.m47439bq(c18313ld.cGU.context, c18313ld.cGU.path);
                break;
            case 9:
                C4990ab.m7416i("MicroMsg.NotifyWNNoteOperationListener", "do OPEN_NOTE_FROM_ADD");
                C14720g c14720g2 = new C14720g();
                c14720g2.cHh = c18313ld.cGU.field_localId;
                C46453c.ddG().uMN = c14720g2;
                Context context2 = c18313ld.cGU.context;
                c14720g2.uMY = true;
                c14720g2.mo26988ab(context2, 2);
                break;
            case 10:
                C14719f.m22911y(c18313ld.cGU.field_localId, c18313ld.cGU.path);
                break;
            case 11:
                C14719f.m22906ad(c18313ld.cGU.cHb);
                break;
            case 12:
                C9638aw.m17180RS().mo10310m(new C403811(), 700);
                break;
        }
        AppMethodBeat.m2505o(26586);
        return false;
    }
}
