package a.i.b.a.c.f;

import a.f.b.j;
import a.k.u;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;

public final class d {
    private static boolean a(b bVar, b bVar2) {
        AppMethodBeat.i(121389);
        j.p(bVar, "receiver$0");
        j.p(bVar2, DownloadInfoColumns.PACKAGENAME);
        if (j.j(bVar, bVar2)) {
            AppMethodBeat.o(121389);
            return true;
        } else if (bVar2.ehF()) {
            AppMethodBeat.o(121389);
            return true;
        } else {
            String str = bVar.ByQ.ByV;
            j.o(str, "this.asString()");
            String str2 = bVar2.ByQ.ByV;
            j.o(str2, "packageName.asString()");
            if (u.jb(str, str2) && str.charAt(str2.length()) == '.') {
                AppMethodBeat.o(121389);
                return true;
            }
            AppMethodBeat.o(121389);
            return false;
        }
    }

    public static final b b(b bVar, b bVar2) {
        AppMethodBeat.i(121390);
        j.p(bVar, "receiver$0");
        j.p(bVar2, "prefix");
        if (!a(bVar, bVar2) || bVar2.ehF()) {
            AppMethodBeat.o(121390);
            return bVar;
        } else if (j.j(bVar, bVar2)) {
            bVar = b.ByP;
            j.o(bVar, "FqName.ROOT");
            AppMethodBeat.o(121390);
            return bVar;
        } else {
            String str = bVar.ByQ.ByV;
            j.o(str, "asString()");
            int length = bVar2.ByQ.ByV.length() + 1;
            if (str == null) {
                v vVar = new v("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(121390);
                throw vVar;
            }
            str = str.substring(length);
            j.o(str, "(this as java.lang.String).substring(startIndex)");
            bVar = new b(str);
            AppMethodBeat.o(121390);
            return bVar;
        }
    }
}
