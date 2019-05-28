package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.net.Uri;
import com.tencent.luggage.g.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.a.p;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.appbrand.appcache.ar;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing;
import com.tencent.mm.plugin.appbrand.appstorage.h;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.t;
import com.tencent.mm.plugin.appbrand.appstorage.v;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.b;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public final class al extends t {
    public al(o oVar, a aVar) {
        super(oVar);
        AppMethodBeat.i(131077);
        this.gYd.clear();
        IWxaFileSystemWithModularizing o = ar.o(oVar);
        m mVar = new m(AppBrandLocalMediaObjectManager.gXo + oVar.mAppId + "/", oVar.mAppId, "wxfile://");
        mVar.gXU = aVar.bQD * 1048576;
        w cg = cg(p.getString(oVar.atI().uin), oVar.mAppId);
        cg.gYk = aVar.bQD * 1048576;
        w ch = ch(p.getString(oVar.atI().uin), oVar.mAppId);
        ch.gYk = aVar.hgg * 1048576;
        this.gYd.add(ch);
        this.gYd.add(cg);
        this.gYd.add(mVar);
        this.gYd.add(o);
        initialize();
        AppMethodBeat.o(131077);
    }

    public final j a(String str, com.tencent.mm.plugin.appbrand.r.j<List<h>> jVar) {
        AppMethodBeat.i(131078);
        Uri parse = Uri.parse(str);
        j jVar2;
        if ("wxfile".equals(parse.getScheme()) && bo.isNullOrNil(parse.getAuthority())) {
            LinkedList linkedList = new LinkedList();
            ((m) ae(m.class)).a("", (com.tencent.mm.plugin.appbrand.r.j) jVar);
            if (!bo.ek((List) jVar.value)) {
                for (h hVar : (List) jVar.value) {
                    hVar.fileName = hVar.fileName.replaceFirst(Pattern.quote("wxfile://"), "");
                }
            }
            c.c(linkedList, (List) jVar.value);
            ((w) ym("wxfile://usr")).a("wxfile://usr", (com.tencent.mm.plugin.appbrand.r.j) jVar);
            c.c(linkedList, (List) jVar.value);
            jVar.value = linkedList;
            jVar2 = j.OK;
            AppMethodBeat.o(131078);
            return jVar2;
        }
        jVar2 = super.a(str, (com.tencent.mm.plugin.appbrand.r.j) jVar);
        AppMethodBeat.o(131078);
        return jVar2;
    }

    public final j a(File file, String str, boolean z, com.tencent.mm.plugin.appbrand.r.j<String> jVar) {
        AppMethodBeat.i(131079);
        j a = ((m) ae(m.class)).a(file, str, z, jVar);
        AppMethodBeat.o(131079);
        return a;
    }

    public final b yh(String str) {
        AppMethodBeat.i(131080);
        b yh = ((m) ae(m.class)).yh(str);
        AppMethodBeat.o(131080);
        return yh;
    }

    public final List<v> awQ() {
        AppMethodBeat.i(131081);
        List awR = ((m) ae(m.class)).gXT.awR();
        AppMethodBeat.o(131081);
        return awR;
    }

    public static w cg(String str, String str2) {
        AppMethodBeat.i(131082);
        w wVar = new w(l(str, str2), "wxfile://usr");
        AppMethodBeat.o(131082);
        return wVar;
    }

    public static w ch(String str, String str2) {
        AppMethodBeat.i(131083);
        w wVar = new w(l(str, str2, "opendata"), "wxfile://opendata");
        AppMethodBeat.o(131083);
        return wVar;
    }

    private static String l(String... strArr) {
        String str;
        File file;
        AppMethodBeat.i(131084);
        StringBuilder stringBuilder = new StringBuilder(";");
        for (String nullAsNil : strArr) {
            stringBuilder.append(bo.nullAsNil(nullAsNil)).append(';');
        }
        String x = g.x(stringBuilder.toString().getBytes());
        if (f.Mn()) {
            str = com.tencent.mm.loader.j.b.eSn;
            if (!str.endsWith("/")) {
                str = str + "/";
            }
            file = new File(str + "wxanewfiles/");
        } else {
            file = null;
        }
        if (file == null) {
            ab.e("MicroMsg.AppBrand.LuggageFileSystemRegistryWC", "getIndependentRootPath, extRoot NULL");
            AppMethodBeat.o(131084);
            return null;
        }
        str = new File(file.getPath() + "/" + x).getPath();
        AppMethodBeat.o(131084);
        return str;
    }
}
