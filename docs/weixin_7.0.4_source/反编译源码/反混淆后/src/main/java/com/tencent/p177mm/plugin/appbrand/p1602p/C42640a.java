package com.tencent.p177mm.plugin.appbrand.p1602p;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.pointers.PString;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C7310be;
import com.tencent.p177mm.storage.C7310be.C5132a;
import com.tencent.p177mm.storage.C7310be.C5133b;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.Map;
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.tencent.mm.plugin.appbrand.p.a */
public final class C42640a implements C5132a {
    /* renamed from: a */
    public final void mo10531a(C7617ak c7617ak, C7310be c7310be) {
        AppMethodBeat.m2504i(132729);
        if (!(c7617ak == null || C5046bo.isNullOrNil(c7617ak.field_username))) {
            String str = c7617ak.field_username;
            C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
            if (aoO == null || ((int) aoO.ewQ) == 0) {
                C4990ab.m7413e("MicroMsg.AppBrandConversionExtension", "contact is null or contactId is 0 for %s", str);
                AppMethodBeat.m2505o(132729);
                return;
            } else if (C7616ad.m13549mg(str) && !C1855t.m3943nl(str)) {
                C4990ab.m7416i("MicroMsg.AppBrandConversionExtension", "this conversation is a app brand contact!");
                c7617ak.mo14760jj("appbrandcustomerservicemsg");
                C7617ak aoZ = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aoZ("appbrandcustomerservicemsg");
                if (aoZ == null) {
                    C4990ab.m7416i("MicroMsg.AppBrandConversionExtension", "create parentConv");
                    aoZ = new C7617ak("appbrandcustomerservicemsg");
                    aoZ.dsI();
                    C42640a.m75506a(c7617ak, aoZ);
                    ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15807d(aoZ);
                    AppMethodBeat.m2505o(132729);
                    return;
                }
                C4990ab.m7416i("MicroMsg.AppBrandConversionExtension", "appBrandSuperConv is created");
                aoZ.mo14760jj(null);
                C42640a.m75506a(c7617ak, aoZ);
                ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15767a(aoZ, "appbrandcustomerservicemsg");
                AppMethodBeat.m2505o(132729);
                return;
            } else if (C1855t.m3922nH(str)) {
                C4990ab.m7416i("MicroMsg.AppBrandConversionExtension", "appBrandSuperConv is created");
                c7617ak.mo14760jj(null);
            }
        }
        AppMethodBeat.m2505o(132729);
    }

    /* renamed from: ac */
    private static String m75507ac(int i, String str) {
        AppMethodBeat.m2504i(132730);
        String str2 = null;
        if (!C5046bo.isNullOrNil(str)) {
            switch (i) {
                case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
                    Map z = C5049br.m7595z(str, "msg");
                    if (z != null) {
                        str2 = (String) z.get(".msg.appmsg.title");
                        C4990ab.m7411d("MicroMsg.AppBrandConversionExtension", "[oneliang][parseConversationMsgContentTitle] title:%s", str2);
                        break;
                    }
                    break;
            }
        }
        AppMethodBeat.m2505o(132730);
        return str2;
    }

    private static C7617ak aLF() {
        C7617ak c7617ak;
        AppMethodBeat.m2504i(132731);
        Cursor c = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15804c(C1855t.fkV, null, "appbrandcustomerservicemsg");
        if (c != null) {
            if (c.getCount() <= 0 || !c.moveToFirst()) {
                c7617ak = null;
            } else {
                c7617ak = new C7617ak();
                c7617ak.mo8995d(c);
            }
            c.close();
        } else {
            c7617ak = null;
        }
        AppMethodBeat.m2505o(132731);
        return c7617ak;
    }

    /* renamed from: a */
    private static void m75506a(C7617ak c7617ak, C7617ak c7617ak2) {
        C7620bi Rb;
        AppMethodBeat.m2504i(132732);
        C7617ak aLF = C42640a.aLF();
        if (aLF != null) {
            C4990ab.m7413e("MicroMsg.AppBrandConversionExtension", "The lastest app brand conversation username is %s", aLF.field_username);
            Rb = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15248Rb(aLF.field_username);
        } else {
            C4990ab.m7412e("MicroMsg.AppBrandConversionExtension", "The lastest app brand conversation is null");
            Rb = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15248Rb(c7617ak.field_username);
        }
        if (Rb == null || Rb.field_msgId <= 0) {
            C4990ab.m7412e("MicroMsg.AppBrandConversionExtension", "the last of msg is null'");
            c7617ak2.dsI();
            AppMethodBeat.m2505o(132732);
            return;
        }
        c7617ak2.mo17068ap(Rb);
        c7617ak2.setContent(Rb.field_talker + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + Rb.field_content);
        c7617ak2.mo14757jg(Integer.toString(Rb.getType()));
        C5133b Cb = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15765Cb();
        if (Cb != null) {
            PString pString = new PString();
            PString pString2 = new PString();
            PInt pInt = new PInt();
            Rb.mo14794ju(c7617ak.field_parentRef);
            Rb.setContent(c7617ak2.field_content);
            Cb.mo10533a(Rb, pString, pString2, pInt, true);
            String ac = C42640a.m75507ac(Rb.getType(), Rb.field_content);
            c7617ak2.mo14758jh(C5046bo.nullAsNil(pString.value).concat(C5046bo.isNullOrNil(ac) ? "" : " " + C5046bo.nullAsNil(ac)));
            c7617ak2.mo14759ji(pString2.value);
            c7617ak2.mo14751hP(pInt.value);
        }
        AppMethodBeat.m2505o(132732);
    }
}
