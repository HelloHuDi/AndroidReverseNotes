package com.tencent.p177mm.plugin.appbrand.jsapi.file;

import android.net.Uri;
import com.tencent.luggage.p147g.C37400c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.loader.p248j.C1761b;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.plugin.appbrand.C41243o;
import com.tencent.p177mm.plugin.appbrand.appcache.C2051ar;
import com.tencent.p177mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.p177mm.plugin.appbrand.appstorage.C2061v;
import com.tencent.p177mm.plugin.appbrand.appstorage.C2062w;
import com.tencent.p177mm.plugin.appbrand.appstorage.C26753h;
import com.tencent.p177mm.plugin.appbrand.appstorage.C36710t;
import com.tencent.p177mm.plugin.appbrand.appstorage.C42368m;
import com.tencent.p177mm.plugin.appbrand.appstorage.C45518j;
import com.tencent.p177mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing;
import com.tencent.p177mm.plugin.appbrand.p328r.C19681j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5728b;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.file.al */
public final class C38296al extends C36710t {
    public C38296al(C41243o c41243o, C33305a c33305a) {
        super(c41243o);
        AppMethodBeat.m2504i(131077);
        this.gYd.clear();
        IWxaFileSystemWithModularizing o = C2051ar.m4211o(c41243o);
        C42368m c42368m = new C42368m(AppBrandLocalMediaObjectManager.gXo + c41243o.mAppId + "/", c41243o.mAppId, "wxfile://");
        c42368m.gXU = c33305a.bQD * 1048576;
        C2062w cg = C38296al.m64798cg(C1183p.getString(c41243o.atI().uin), c41243o.mAppId);
        cg.gYk = c33305a.bQD * 1048576;
        C2062w ch = C38296al.m64799ch(C1183p.getString(c41243o.atI().uin), c41243o.mAppId);
        ch.gYk = c33305a.hgg * 1048576;
        this.gYd.add(ch);
        this.gYd.add(cg);
        this.gYd.add(c42368m);
        this.gYd.add(o);
        initialize();
        AppMethodBeat.m2505o(131077);
    }

    /* renamed from: a */
    public final C45518j mo5837a(String str, C19681j<List<C26753h>> c19681j) {
        AppMethodBeat.m2504i(131078);
        Uri parse = Uri.parse(str);
        C45518j c45518j;
        if ("wxfile".equals(parse.getScheme()) && C5046bo.isNullOrNil(parse.getAuthority())) {
            LinkedList linkedList = new LinkedList();
            ((C42368m) mo53654ae(C42368m.class)).mo5837a("", (C19681j) c19681j);
            if (!C5046bo.m7548ek((List) c19681j.value)) {
                for (C26753h c26753h : (List) c19681j.value) {
                    c26753h.fileName = c26753h.fileName.replaceFirst(Pattern.quote("wxfile://"), "");
                }
            }
            C37400c.m63005c(linkedList, (List) c19681j.value);
            ((C2062w) mo53655ym("wxfile://usr")).mo5837a("wxfile://usr", (C19681j) c19681j);
            C37400c.m63005c(linkedList, (List) c19681j.value);
            c19681j.value = linkedList;
            c45518j = C45518j.OK;
            AppMethodBeat.m2505o(131078);
            return c45518j;
        }
        c45518j = super.mo5837a(str, (C19681j) c19681j);
        AppMethodBeat.m2505o(131078);
        return c45518j;
    }

    /* renamed from: a */
    public final C45518j mo5835a(File file, String str, boolean z, C19681j<String> c19681j) {
        AppMethodBeat.m2504i(131079);
        C45518j a = ((C42368m) mo53654ae(C42368m.class)).mo5835a(file, str, z, c19681j);
        AppMethodBeat.m2505o(131079);
        return a;
    }

    /* renamed from: yh */
    public final C5728b mo34315yh(String str) {
        AppMethodBeat.m2504i(131080);
        C5728b yh = ((C42368m) mo53654ae(C42368m.class)).mo34315yh(str);
        AppMethodBeat.m2505o(131080);
        return yh;
    }

    public final List<C2061v> awQ() {
        AppMethodBeat.m2504i(131081);
        List awR = ((C42368m) mo53654ae(C42368m.class)).gXT.awR();
        AppMethodBeat.m2505o(131081);
        return awR;
    }

    /* renamed from: cg */
    public static C2062w m64798cg(String str, String str2) {
        AppMethodBeat.m2504i(131082);
        C2062w c2062w = new C2062w(C38296al.m64800l(str, str2), "wxfile://usr");
        AppMethodBeat.m2505o(131082);
        return c2062w;
    }

    /* renamed from: ch */
    public static C2062w m64799ch(String str, String str2) {
        AppMethodBeat.m2504i(131083);
        C2062w c2062w = new C2062w(C38296al.m64800l(str, str2, "opendata"), "wxfile://opendata");
        AppMethodBeat.m2505o(131083);
        return c2062w;
    }

    /* renamed from: l */
    private static String m64800l(String... strArr) {
        String str;
        File file;
        AppMethodBeat.m2504i(131084);
        StringBuilder stringBuilder = new StringBuilder(";");
        for (String nullAsNil : strArr) {
            stringBuilder.append(C5046bo.nullAsNil(nullAsNil)).append(';');
        }
        String x = C1178g.m2591x(stringBuilder.toString().getBytes());
        if (C1445f.m3070Mn()) {
            str = C1761b.eSn;
            if (!str.endsWith("/")) {
                str = str + "/";
            }
            file = new File(str + "wxanewfiles/");
        } else {
            file = null;
        }
        if (file == null) {
            C4990ab.m7412e("MicroMsg.AppBrand.LuggageFileSystemRegistryWC", "getIndependentRootPath, extRoot NULL");
            AppMethodBeat.m2505o(131084);
            return null;
        }
        str = new File(file.getPath() + "/" + x).getPath();
        AppMethodBeat.m2505o(131084);
        return str;
    }
}
