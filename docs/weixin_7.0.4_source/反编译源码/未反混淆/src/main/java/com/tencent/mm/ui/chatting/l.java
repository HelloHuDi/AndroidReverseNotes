package com.tencent.mm.ui.chatting;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.a;
import com.tencent.mm.af.f;
import com.tencent.mm.af.j.b;
import com.tencent.mm.af.p;
import com.tencent.mm.ah.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.modelappbrand.a.b.i;
import com.tencent.mm.plugin.appbrand.r.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.io.ByteArrayOutputStream;
import java.util.LinkedList;
import java.util.List;

public final class l {

    /* renamed from: com.tencent.mm.ui.chatting.l$2 */
    static class AnonymousClass2 implements i {
        final /* synthetic */ p jPE;

        AnonymousClass2(p pVar) {
            this.jPE = pVar;
        }

        public final void abU() {
        }

        public final void x(Bitmap bitmap) {
            AppMethodBeat.i(30591);
            ab.d("MicroMsg.ChattingEditModeSendToAppBrand", "onBitmapLoaded %s", this.jPE.fjH);
            AppMethodBeat.o(30591);
        }

        public final void mr() {
        }

        public final String wP() {
            AppMethodBeat.i(30592);
            String bE = n.bE(this);
            AppMethodBeat.o(30592);
            return bE;
        }
    }

    public static void b(String str, b bVar, String str2) {
        Bitmap bitmap = null;
        AppMethodBeat.i(30593);
        try {
            byte[] bArr = new byte[0];
            if (!bo.isNullOrNil(str2) && (str2.startsWith("http://") || str2.startsWith("https://"))) {
                bitmap = com.tencent.mm.modelappbrand.a.b.abR().a(str2, null);
            }
            if (bitmap == null || bitmap.isRecycled()) {
                ab.e("MicroMsg.ChattingEditModeSendToAppBrand", "thumb image is null");
            } else {
                ab.i("MicroMsg.ChattingEditModeSendToAppBrand", "thumb image is not null ");
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                bArr = byteArrayOutputStream.toByteArray();
            }
            int i = t.kH(str) ? 1 : 0;
            com.tencent.mm.pluginsdk.model.app.l.a(bVar, bVar.fiQ, bVar.title, str, null, bArr);
            h.pYm.e(14127, bVar.fiQ, bVar.fiP, bVar.fiO, bVar.title, bVar.description, "", bVar.url, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(i), str);
            AppMethodBeat.o(30593);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.ChattingEditModeSendToAppBrand", e, "", new Object[0]);
            ab.e("MicroMsg.ChattingEditModeSendToAppBrand", "retransmit sigle app msg error : %s", e.getLocalizedMessage());
            AppMethodBeat.o(30593);
        }
    }

    public static b a(String str, p pVar) {
        AppMethodBeat.i(30594);
        b bVar = new b();
        bVar.title = pVar.title;
        bVar.description = pVar.fjz;
        bVar.type = 33;
        bVar.fiP = pVar.fjC;
        bVar.fiO = pVar.fjD;
        bVar.fiQ = pVar.fjG;
        bVar.fiZ = pVar.fjF;
        bVar.fja = pVar.fjE;
        bVar.fiS = "";
        bVar.fiR = 2;
        bVar.url = pVar.url;
        bVar.fjb = pVar.fjI;
        bVar.cMm = "wxapp_" + pVar.fjG + pVar.fjD;
        bVar.cMg = pVar.fjC;
        bVar.cMh = pVar.fjJ;
        f aVar = new a();
        aVar.feY = false;
        aVar.feZ = "";
        bVar.a(aVar);
        if (bo.isNullOrNil(bVar.thumburl)) {
            com.tencent.mm.ah.h qo = o.act().qo(str);
            if (qo != null) {
                bVar.thumburl = qo.ack();
            }
        }
        AppMethodBeat.o(30594);
        return bVar;
    }

    public static boolean f(bi biVar, int i) {
        AppMethodBeat.i(30595);
        if (biVar == null) {
            AppMethodBeat.o(30595);
            return false;
        } else if (biVar.drC()) {
            LinkedList linkedList = ((com.tencent.mm.plugin.biz.a.a) g.K(com.tencent.mm.plugin.biz.a.a.class)).b(biVar.field_msgId, biVar.field_content).fjr;
            if (!bo.ek(linkedList)) {
                if (i < 0 || i >= linkedList.size()) {
                    i = 0;
                }
                if (com.tencent.mm.af.l.mg(((p) linkedList.get(i)).fjC)) {
                    AppMethodBeat.o(30595);
                    return true;
                }
            }
            AppMethodBeat.o(30595);
            return false;
        } else {
            AppMethodBeat.o(30595);
            return false;
        }
    }

    public static void eU(final List<bi> list) {
        AppMethodBeat.i(30596);
        aw.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(30590);
                List<bi> list = list;
                if (!bo.ek(list)) {
                    for (bi biVar : list) {
                        if (biVar.drC()) {
                            LinkedList<p> linkedList = ((com.tencent.mm.plugin.biz.a.a) g.K(com.tencent.mm.plugin.biz.a.a.class)).b(biVar.field_msgId, biVar.field_content).fjr;
                            if (linkedList != null) {
                                for (p pVar : linkedList) {
                                    if (!bo.isNullOrNil(pVar.fjH) && com.tencent.mm.af.l.mg(pVar.fjC)) {
                                        com.tencent.mm.modelappbrand.a.b.abR().a(new AnonymousClass2(pVar), pVar.fjH, null, ((com.tencent.mm.modelappbrand.i) g.K(com.tencent.mm.modelappbrand.i.class)).cq(112, 90));
                                    }
                                }
                            }
                        }
                    }
                }
                AppMethodBeat.o(30590);
            }
        });
        AppMethodBeat.o(30596);
    }
}
