package com.tencent.p177mm.p612ui.chatting;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelappbrand.C32809i;
import com.tencent.p177mm.modelappbrand.p873a.C37926b;
import com.tencent.p177mm.modelappbrand.p873a.C37926b.C9676i;
import com.tencent.p177mm.p181af.C1192l;
import com.tencent.p177mm.p181af.C32224p;
import com.tencent.p177mm.p181af.C37435f;
import com.tencent.p177mm.p181af.C41728a;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p182ah.C17880h;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.plugin.appbrand.p328r.C38496n;
import com.tencent.p177mm.plugin.biz.p1395a.C27500a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.app.C4733l;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import java.io.ByteArrayOutputStream;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.ui.chatting.l */
public final class C44312l {

    /* renamed from: com.tencent.mm.ui.chatting.l$2 */
    static class C443102 implements C9676i {
        final /* synthetic */ C32224p jPE;

        C443102(C32224p c32224p) {
            this.jPE = c32224p;
        }

        public final void abU() {
        }

        /* renamed from: x */
        public final void mo6524x(Bitmap bitmap) {
            AppMethodBeat.m2504i(30591);
            C4990ab.m7411d("MicroMsg.ChattingEditModeSendToAppBrand", "onBitmapLoaded %s", this.jPE.fjH);
            AppMethodBeat.m2505o(30591);
        }

        /* renamed from: mr */
        public final void mo6522mr() {
        }

        /* renamed from: wP */
        public final String mo6523wP() {
            AppMethodBeat.m2504i(30592);
            String bE = C38496n.m65148bE(this);
            AppMethodBeat.m2505o(30592);
            return bE;
        }
    }

    /* renamed from: b */
    public static void m80096b(String str, C8910b c8910b, String str2) {
        Bitmap bitmap = null;
        AppMethodBeat.m2504i(30593);
        try {
            byte[] bArr = new byte[0];
            if (!C5046bo.isNullOrNil(str2) && (str2.startsWith("http://") || str2.startsWith("https://"))) {
                bitmap = C37926b.abR().mo60681a(str2, null);
            }
            if (bitmap == null || bitmap.isRecycled()) {
                C4990ab.m7412e("MicroMsg.ChattingEditModeSendToAppBrand", "thumb image is null");
            } else {
                C4990ab.m7416i("MicroMsg.ChattingEditModeSendToAppBrand", "thumb image is not null ");
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                bArr = byteArrayOutputStream.toByteArray();
            }
            int i = C1855t.m3896kH(str) ? 1 : 0;
            C4733l.m7087a(c8910b, c8910b.fiQ, c8910b.title, str, null, bArr);
            C7060h.pYm.mo8381e(14127, c8910b.fiQ, c8910b.fiP, c8910b.fiO, c8910b.title, c8910b.description, "", c8910b.url, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(i), str);
            AppMethodBeat.m2505o(30593);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.ChattingEditModeSendToAppBrand", e, "", new Object[0]);
            C4990ab.m7413e("MicroMsg.ChattingEditModeSendToAppBrand", "retransmit sigle app msg error : %s", e.getLocalizedMessage());
            AppMethodBeat.m2505o(30593);
        }
    }

    /* renamed from: a */
    public static C8910b m80095a(String str, C32224p c32224p) {
        AppMethodBeat.m2504i(30594);
        C8910b c8910b = new C8910b();
        c8910b.title = c32224p.title;
        c8910b.description = c32224p.fjz;
        c8910b.type = 33;
        c8910b.fiP = c32224p.fjC;
        c8910b.fiO = c32224p.fjD;
        c8910b.fiQ = c32224p.fjG;
        c8910b.fiZ = c32224p.fjF;
        c8910b.fja = c32224p.fjE;
        c8910b.fiS = "";
        c8910b.fiR = 2;
        c8910b.url = c32224p.url;
        c8910b.fjb = c32224p.fjI;
        c8910b.cMm = "wxapp_" + c32224p.fjG + c32224p.fjD;
        c8910b.cMg = c32224p.fjC;
        c8910b.cMh = c32224p.fjJ;
        C37435f c41728a = new C41728a();
        c41728a.feY = false;
        c41728a.feZ = "";
        c8910b.mo20334a(c41728a);
        if (C5046bo.isNullOrNil(c8910b.thumburl)) {
            C17880h qo = C17884o.act().mo33392qo(str);
            if (qo != null) {
                c8910b.thumburl = qo.ack();
            }
        }
        AppMethodBeat.m2505o(30594);
        return c8910b;
    }

    /* renamed from: f */
    public static boolean m80098f(C7620bi c7620bi, int i) {
        AppMethodBeat.m2504i(30595);
        if (c7620bi == null) {
            AppMethodBeat.m2505o(30595);
            return false;
        } else if (c7620bi.drC()) {
            LinkedList linkedList = ((C27500a) C1720g.m3528K(C27500a.class)).mo35246b(c7620bi.field_msgId, c7620bi.field_content).fjr;
            if (!C5046bo.m7548ek(linkedList)) {
                if (i < 0 || i >= linkedList.size()) {
                    i = 0;
                }
                if (C1192l.m2624mg(((C32224p) linkedList.get(i)).fjC)) {
                    AppMethodBeat.m2505o(30595);
                    return true;
                }
            }
            AppMethodBeat.m2505o(30595);
            return false;
        } else {
            AppMethodBeat.m2505o(30595);
            return false;
        }
    }

    /* renamed from: eU */
    public static void m80097eU(final List<C7620bi> list) {
        AppMethodBeat.m2504i(30596);
        C9638aw.m17180RS().mo10302aa(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(30590);
                List<C7620bi> list = list;
                if (!C5046bo.m7548ek(list)) {
                    for (C7620bi c7620bi : list) {
                        if (c7620bi.drC()) {
                            LinkedList<C32224p> linkedList = ((C27500a) C1720g.m3528K(C27500a.class)).mo35246b(c7620bi.field_msgId, c7620bi.field_content).fjr;
                            if (linkedList != null) {
                                for (C32224p c32224p : linkedList) {
                                    if (!C5046bo.isNullOrNil(c32224p.fjH) && C1192l.m2624mg(c32224p.fjC)) {
                                        C37926b.abR().mo60686a(new C443102(c32224p), c32224p.fjH, null, ((C32809i) C1720g.m3528K(C32809i.class)).mo22292cq(112, 90));
                                    }
                                }
                            }
                        }
                    }
                }
                AppMethodBeat.m2505o(30590);
            }
        });
        AppMethodBeat.m2505o(30596);
    }
}
