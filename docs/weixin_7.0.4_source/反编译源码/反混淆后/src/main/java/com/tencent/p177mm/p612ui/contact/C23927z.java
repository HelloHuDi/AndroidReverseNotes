package com.tencent.p177mm.p612ui.contact;

import android.app.Activity;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelmulti.C26451h;
import com.tencent.p177mm.openim.p1210a.C32873b;
import com.tencent.p177mm.openim.p1210a.C32873b.C32874a;
import com.tencent.p177mm.p182ah.C17880h;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p612ui.widget.snackbar.C5670b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import java.util.List;

/* renamed from: com.tencent.mm.ui.contact.z */
public final class C23927z {
    public static String arT(String str) {
        AppMethodBeat.m2504i(33920);
        C17880h qo = C17884o.act().mo33392qo(str);
        C9638aw.m17190ZK();
        C7616ad aoO = C18628c.m29078XM().aoO(str);
        String ba;
        if (aoO == null) {
            AppMethodBeat.m2505o(33920);
            return null;
        } else if (C7616ad.aox(str)) {
            String str2 = aoO.field_openImAppid;
            String c = ((C32873b) C1720g.m3528K(C32873b.class)).mo44307c(aoO.field_openImAppid, "openim_desc_icon", C32874a.TYPE_URL);
            ba = ((C32873b) C1720g.m3528K(C32873b.class)).mo44306ba(aoO.field_openImAppid, aoO.field_descWordingId);
            ba = String.format(" <msg bigheadimgurl=\"%s\" smallheadimgurl=\"%s\" username=\"%s\" nickname=\"%s\" sex=\"%d\"  openimappid=\"%s\" openimdesc=\"%s\" openimdescicon=\"%s\"/>", new Object[]{C5046bo.ani(qo.ack()), C5046bo.ani(qo.acl()), C5046bo.ani(aoO.field_username), C5046bo.ani(aoO.mo16706Oi()), Integer.valueOf(aoO.dtS), str2, C5046bo.ani(ba), C5046bo.ani(c)});
            AppMethodBeat.m2505o(33920);
            return ba;
        } else {
            int i = aoO.dtR;
            if (qo != null) {
                i = qo.dtR;
            }
            C16527d qX = aoO.dsf() ? C17903f.m28104qX(aoO.field_username) : null;
            String str3 = "<msg username=\"%s\" nickname=\"%s\" alias=\"%s\" fullpy=\"%s\" shortpy=\"%s\" imagestatus=\"%d\" scene=\"17\" province=\"%s\" city=\"%s\" sign=\"%s\" percard=\"%d\" sex=\"%d\" certflag=\"%d\" certinfo=\"%s\" certinfoext=\"\" brandIconUrl=\"%s\" brandHomeUrl=\"\" brandSubscriptConfigUrl=\"\" brandFlags=\"\" regionCode=\"%s\"/>";
            Object[] objArr = new Object[15];
            objArr[0] = C5046bo.ani(aoO.field_username);
            objArr[1] = C5046bo.ani(aoO.mo16706Oi());
            objArr[2] = C5046bo.ani(aoO.mo14673Hq());
            objArr[3] = C5046bo.ani(aoO.mo16706Oi());
            objArr[4] = C5046bo.ani(aoO.mo14676Ht());
            objArr[5] = Integer.valueOf(i);
            objArr[6] = C5046bo.ani(aoO.getProvince());
            objArr[7] = C5046bo.ani(aoO.getCity());
            objArr[8] = C5046bo.ani(aoO.signature);
            objArr[9] = Integer.valueOf(aoO.dub);
            objArr[10] = Integer.valueOf(aoO.dtS);
            objArr[11] = Integer.valueOf(aoO.field_verifyFlag);
            objArr[12] = C5046bo.ani(aoO.duh);
            if (qX == null) {
                ba = "";
            } else {
                ba = C5046bo.ani(qX.field_brandIconURL);
            }
            objArr[13] = ba;
            objArr[14] = C5046bo.ani(aoO.dui);
            ba = String.format(str3, objArr);
            AppMethodBeat.m2505o(33920);
            return ba;
        }
    }

    /* renamed from: a */
    public static void m36890a(final Activity activity, String str, List<String> list) {
        AppMethodBeat.m2504i(33921);
        for (String str2 : list) {
            C9638aw.m17182Rg().mo14541a(new C26451h(str, C23927z.arT(str2), C7616ad.aox(str2) ? 66 : 42), 0);
        }
        C5670b.m8523i(activity, activity.getString(C25738R.string.cbn));
        C7060h.pYm.mo8381e(TXCStreamUploader.TXE_UPLOAD_INFO_NET_BUSY, str, Integer.valueOf(3), Integer.valueOf(list.size()));
        activity.setResult(-1);
        C5004al.m7442n(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(33919);
                activity.finish();
                AppMethodBeat.m2505o(33919);
            }
        }, 1800);
        AppMethodBeat.m2505o(33921);
    }
}
