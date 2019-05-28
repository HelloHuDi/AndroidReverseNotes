package p000a.p010i.p011b.p012a.p015c.p778f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;
import p000a.p051k.C6163u;

/* renamed from: a.i.b.a.c.f.d */
public final class C8177d {
    /* renamed from: a */
    private static boolean m14437a(C8174b c8174b, C8174b c8174b2) {
        AppMethodBeat.m2504i(121389);
        C25052j.m39376p(c8174b, "receiver$0");
        C25052j.m39376p(c8174b2, DownloadInfoColumns.PACKAGENAME);
        if (C25052j.m39373j(c8174b, c8174b2)) {
            AppMethodBeat.m2505o(121389);
            return true;
        } else if (c8174b2.ehF()) {
            AppMethodBeat.m2505o(121389);
            return true;
        } else {
            String str = c8174b.ByQ.ByV;
            C25052j.m39375o(str, "this.asString()");
            String str2 = c8174b2.ByQ.ByV;
            C25052j.m39375o(str2, "packageName.asString()");
            if (C6163u.m9839jb(str, str2) && str.charAt(str2.length()) == '.') {
                AppMethodBeat.m2505o(121389);
                return true;
            }
            AppMethodBeat.m2505o(121389);
            return false;
        }
    }

    /* renamed from: b */
    public static final C8174b m14438b(C8174b c8174b, C8174b c8174b2) {
        AppMethodBeat.m2504i(121390);
        C25052j.m39376p(c8174b, "receiver$0");
        C25052j.m39376p(c8174b2, "prefix");
        if (!C8177d.m14437a(c8174b, c8174b2) || c8174b2.ehF()) {
            AppMethodBeat.m2505o(121390);
            return c8174b;
        } else if (C25052j.m39373j(c8174b, c8174b2)) {
            c8174b = C8174b.ByP;
            C25052j.m39375o(c8174b, "FqName.ROOT");
            AppMethodBeat.m2505o(121390);
            return c8174b;
        } else {
            String str = c8174b.ByQ.ByV;
            C25052j.m39375o(str, "asString()");
            int length = c8174b2.ByQ.ByV.length() + 1;
            if (str == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.m2505o(121390);
                throw c44941v;
            }
            str = str.substring(length);
            C25052j.m39375o(str, "(this as java.lang.String).substring(startIndex)");
            c8174b = new C8174b(str);
            AppMethodBeat.m2505o(121390);
            return c8174b;
        }
    }
}
