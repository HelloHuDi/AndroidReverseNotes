package com.tencent.mm.plugin.appbrand.p;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.be.b;
import com.tencent.mm.storage.bi;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.Map;
import org.xwalk.core.XWalkEnvironment;

public final class a implements com.tencent.mm.storage.be.a {
    public final void a(ak akVar, be beVar) {
        AppMethodBeat.i(132729);
        if (!(akVar == null || bo.isNullOrNil(akVar.field_username))) {
            String str = akVar.field_username;
            ad aoO = ((j) g.K(j.class)).XM().aoO(str);
            if (aoO == null || ((int) aoO.ewQ) == 0) {
                ab.e("MicroMsg.AppBrandConversionExtension", "contact is null or contactId is 0 for %s", str);
                AppMethodBeat.o(132729);
                return;
            } else if (ad.mg(str) && !t.nl(str)) {
                ab.i("MicroMsg.AppBrandConversionExtension", "this conversation is a app brand contact!");
                akVar.jj("appbrandcustomerservicemsg");
                ak aoZ = ((j) g.K(j.class)).XR().aoZ("appbrandcustomerservicemsg");
                if (aoZ == null) {
                    ab.i("MicroMsg.AppBrandConversionExtension", "create parentConv");
                    aoZ = new ak("appbrandcustomerservicemsg");
                    aoZ.dsI();
                    a(akVar, aoZ);
                    ((j) g.K(j.class)).XR().d(aoZ);
                    AppMethodBeat.o(132729);
                    return;
                }
                ab.i("MicroMsg.AppBrandConversionExtension", "appBrandSuperConv is created");
                aoZ.jj(null);
                a(akVar, aoZ);
                ((j) g.K(j.class)).XR().a(aoZ, "appbrandcustomerservicemsg");
                AppMethodBeat.o(132729);
                return;
            } else if (t.nH(str)) {
                ab.i("MicroMsg.AppBrandConversionExtension", "appBrandSuperConv is created");
                akVar.jj(null);
            }
        }
        AppMethodBeat.o(132729);
    }

    private static String ac(int i, String str) {
        AppMethodBeat.i(132730);
        String str2 = null;
        if (!bo.isNullOrNil(str)) {
            switch (i) {
                case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
                    Map z = br.z(str, "msg");
                    if (z != null) {
                        str2 = (String) z.get(".msg.appmsg.title");
                        ab.d("MicroMsg.AppBrandConversionExtension", "[oneliang][parseConversationMsgContentTitle] title:%s", str2);
                        break;
                    }
                    break;
            }
        }
        AppMethodBeat.o(132730);
        return str2;
    }

    private static ak aLF() {
        ak akVar;
        AppMethodBeat.i(132731);
        Cursor c = ((j) g.K(j.class)).XR().c(t.fkV, null, "appbrandcustomerservicemsg");
        if (c != null) {
            if (c.getCount() <= 0 || !c.moveToFirst()) {
                akVar = null;
            } else {
                akVar = new ak();
                akVar.d(c);
            }
            c.close();
        } else {
            akVar = null;
        }
        AppMethodBeat.o(132731);
        return akVar;
    }

    private static void a(ak akVar, ak akVar2) {
        bi Rb;
        AppMethodBeat.i(132732);
        ak aLF = aLF();
        if (aLF != null) {
            ab.e("MicroMsg.AppBrandConversionExtension", "The lastest app brand conversation username is %s", aLF.field_username);
            Rb = ((j) g.K(j.class)).bOr().Rb(aLF.field_username);
        } else {
            ab.e("MicroMsg.AppBrandConversionExtension", "The lastest app brand conversation is null");
            Rb = ((j) g.K(j.class)).bOr().Rb(akVar.field_username);
        }
        if (Rb == null || Rb.field_msgId <= 0) {
            ab.e("MicroMsg.AppBrandConversionExtension", "the last of msg is null'");
            akVar2.dsI();
            AppMethodBeat.o(132732);
            return;
        }
        akVar2.ap(Rb);
        akVar2.setContent(Rb.field_talker + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + Rb.field_content);
        akVar2.jg(Integer.toString(Rb.getType()));
        b Cb = ((j) g.K(j.class)).XR().Cb();
        if (Cb != null) {
            PString pString = new PString();
            PString pString2 = new PString();
            PInt pInt = new PInt();
            Rb.ju(akVar.field_parentRef);
            Rb.setContent(akVar2.field_content);
            Cb.a(Rb, pString, pString2, pInt, true);
            String ac = ac(Rb.getType(), Rb.field_content);
            akVar2.jh(bo.nullAsNil(pString.value).concat(bo.isNullOrNil(ac) ? "" : " " + bo.nullAsNil(ac)));
            akVar2.ji(pString2.value);
            akVar2.hP(pInt.value);
        }
        AppMethodBeat.o(132732);
    }
}
