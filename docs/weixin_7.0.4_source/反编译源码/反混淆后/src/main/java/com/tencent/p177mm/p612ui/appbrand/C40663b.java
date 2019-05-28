package com.tencent.p177mm.p612ui.appbrand;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelappbrand.C6676o;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p230g.p231a.C45374tz;
import com.tencent.p177mm.p230g.p231a.C45374tz.C18404a;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.p177mm.plugin.appbrand.service.C42686d;
import com.tencent.p177mm.protocal.protobuf.aka;
import com.tencent.p177mm.protocal.protobuf.cfx;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.ui.appbrand.b */
public final class C40663b {

    /* renamed from: com.tencent.mm.ui.appbrand.b$2 */
    public static class C154912 implements C1224a {
        /* renamed from: a */
        public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
            AppMethodBeat.m2504i(29953);
            C4990ab.m7417i("MicroMsg.AppBrandServiceHelper", "callback, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
            aka aka = (aka) c7472b.fsH.fsP;
            if (i == 0 && i2 == 0 && aka != null && aka.wpA != null) {
                StringBuilder stringBuilder = new StringBuilder();
                Iterator it = aka.wpA.iterator();
                while (it.hasNext()) {
                    stringBuilder.append(((String) it.next()) + "|");
                }
                C4990ab.m7411d("MicroMsg.AppBrandServiceHelper", "block_qr_prefix:%s, size:%d", stringBuilder.toString(), Integer.valueOf(aka.wpA.size()));
                C1720g.m3536RP().mo5239Ry().set(C5127a.APPBRAND_BLOCK_QRCODE_PREFIX_STRING_SYNC, stringBuilder.toString());
            }
            AppMethodBeat.m2505o(29953);
            return 0;
        }
    }

    /* renamed from: k */
    public static void m70234k(final Context context, final String str, final boolean z) {
        int i = 1;
        AppMethodBeat.m2504i(29954);
        C45374tz c45374tz = new C45374tz();
        c45374tz.cQf.csl = str;
        c45374tz.cQf.action = z ? 2 : 1;
        c45374tz.cQf.cQh = 2;
        C4879a.xxA.mo10055m(c45374tz);
        LinkedList linkedList = new LinkedList();
        cfx cfx = new cfx();
        cfx.xeX = str;
        if (!z) {
            i = 0;
        }
        cfx.xeW = i;
        cfx.jCt = 3;
        linkedList.add(cfx);
        C9638aw.m17182Rg().mo14539a(1176, new C1202f() {
            public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                int i3 = 1;
                AppMethodBeat.m2504i(29952);
                C9638aw.m17182Rg().mo14546b(1176, (C1202f) this);
                C4990ab.m7411d("MicroMsg.AppBrandServiceHelper", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.TRUE);
                if (i == 0 && i2 == 0) {
                    AppMethodBeat.m2505o(29952);
                    return;
                }
                C23639t.makeText(context, C25738R.string.d_u, 0).show();
                C45374tz c45374tz = new C45374tz();
                c45374tz.cQf.csl = str;
                C18404a c18404a = c45374tz.cQf;
                if (!z) {
                    i3 = 2;
                }
                c18404a.action = i3;
                c45374tz.cQf.cQh = 2;
                C4879a.xxA.mo10055m(c45374tz);
                AppMethodBeat.m2505o(29952);
            }
        });
        C9638aw.m17182Rg().mo14541a(new C6676o(linkedList), 0);
        AppMethodBeat.m2505o(29954);
    }

    public static String aqJ(String str) {
        AppMethodBeat.m2504i(29955);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(29955);
            return null;
        }
        WxaAttributes zb = ((C42686d) C1720g.m3528K(C42686d.class)).mo44618zb(str);
        if (zb == null || zb.ayJ() == null) {
            C4990ab.m7412e("MicroMsg.AppBrandServiceHelper", "attr is null or getAppInfo return null");
            AppMethodBeat.m2505o(29955);
            return null;
        }
        String str2 = zb.ayJ().hhY;
        AppMethodBeat.m2505o(29955);
        return str2;
    }

    /* renamed from: zm */
    public static String m70235zm(String str) {
        AppMethodBeat.m2504i(29956);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(29956);
            return null;
        }
        WxaAttributes zb = ((C42686d) C1720g.m3528K(C42686d.class)).mo44618zb(str);
        if (zb == null || zb.ayJ() == null) {
            C4990ab.m7412e("MicroMsg.AppBrandServiceHelper", "attr is null or getAppInfo return null");
            AppMethodBeat.m2505o(29956);
            return null;
        }
        String str2 = zb.field_appId;
        AppMethodBeat.m2505o(29956);
        return str2;
    }

    public static String aqK(String str) {
        AppMethodBeat.m2504i(29957);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(29957);
            return null;
        }
        WxaAttributes zb = ((C42686d) C1720g.m3528K(C42686d.class)).mo44618zb(str);
        if (zb != null) {
            String str2 = zb.field_nickname;
            AppMethodBeat.m2505o(29957);
            return str2;
        }
        C4990ab.m7412e("MicroMsg.AppBrandServiceHelper", "attr is null or getAppInfo return null");
        AppMethodBeat.m2505o(29957);
        return null;
    }
}
