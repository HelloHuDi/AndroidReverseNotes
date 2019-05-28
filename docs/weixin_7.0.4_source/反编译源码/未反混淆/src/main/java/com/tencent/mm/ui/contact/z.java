package com.tencent.mm.ui.contact;

import android.app.Activity;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.o;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import java.util.List;

public final class z {
    public static String arT(String str) {
        AppMethodBeat.i(33920);
        h qo = o.act().qo(str);
        aw.ZK();
        ad aoO = c.XM().aoO(str);
        String ba;
        if (aoO == null) {
            AppMethodBeat.o(33920);
            return null;
        } else if (ad.aox(str)) {
            String str2 = aoO.field_openImAppid;
            String c = ((b) g.K(b.class)).c(aoO.field_openImAppid, "openim_desc_icon", a.TYPE_URL);
            ba = ((b) g.K(b.class)).ba(aoO.field_openImAppid, aoO.field_descWordingId);
            ba = String.format(" <msg bigheadimgurl=\"%s\" smallheadimgurl=\"%s\" username=\"%s\" nickname=\"%s\" sex=\"%d\"  openimappid=\"%s\" openimdesc=\"%s\" openimdescicon=\"%s\"/>", new Object[]{bo.ani(qo.ack()), bo.ani(qo.acl()), bo.ani(aoO.field_username), bo.ani(aoO.Oi()), Integer.valueOf(aoO.dtS), str2, bo.ani(ba), bo.ani(c)});
            AppMethodBeat.o(33920);
            return ba;
        } else {
            int i = aoO.dtR;
            if (qo != null) {
                i = qo.dtR;
            }
            d qX = aoO.dsf() ? f.qX(aoO.field_username) : null;
            String str3 = "<msg username=\"%s\" nickname=\"%s\" alias=\"%s\" fullpy=\"%s\" shortpy=\"%s\" imagestatus=\"%d\" scene=\"17\" province=\"%s\" city=\"%s\" sign=\"%s\" percard=\"%d\" sex=\"%d\" certflag=\"%d\" certinfo=\"%s\" certinfoext=\"\" brandIconUrl=\"%s\" brandHomeUrl=\"\" brandSubscriptConfigUrl=\"\" brandFlags=\"\" regionCode=\"%s\"/>";
            Object[] objArr = new Object[15];
            objArr[0] = bo.ani(aoO.field_username);
            objArr[1] = bo.ani(aoO.Oi());
            objArr[2] = bo.ani(aoO.Hq());
            objArr[3] = bo.ani(aoO.Oi());
            objArr[4] = bo.ani(aoO.Ht());
            objArr[5] = Integer.valueOf(i);
            objArr[6] = bo.ani(aoO.getProvince());
            objArr[7] = bo.ani(aoO.getCity());
            objArr[8] = bo.ani(aoO.signature);
            objArr[9] = Integer.valueOf(aoO.dub);
            objArr[10] = Integer.valueOf(aoO.dtS);
            objArr[11] = Integer.valueOf(aoO.field_verifyFlag);
            objArr[12] = bo.ani(aoO.duh);
            if (qX == null) {
                ba = "";
            } else {
                ba = bo.ani(qX.field_brandIconURL);
            }
            objArr[13] = ba;
            objArr[14] = bo.ani(aoO.dui);
            ba = String.format(str3, objArr);
            AppMethodBeat.o(33920);
            return ba;
        }
    }

    public static void a(final Activity activity, String str, List<String> list) {
        AppMethodBeat.i(33921);
        for (String str2 : list) {
            aw.Rg().a(new com.tencent.mm.modelmulti.h(str, arT(str2), ad.aox(str2) ? 66 : 42), 0);
        }
        com.tencent.mm.ui.widget.snackbar.b.i(activity, activity.getString(R.string.cbn));
        com.tencent.mm.plugin.report.service.h.pYm.e(TXCStreamUploader.TXE_UPLOAD_INFO_NET_BUSY, str, Integer.valueOf(3), Integer.valueOf(list.size()));
        activity.setResult(-1);
        al.n(new Runnable() {
            public final void run() {
                AppMethodBeat.i(33919);
                activity.finish();
                AppMethodBeat.o(33919);
            }
        }, 1800);
        AppMethodBeat.o(33921);
    }
}
