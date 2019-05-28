package com.tencent.p177mm.plugin.appbrand.p290g;

import android.support.p056d.C0252a;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.InputStream;

/* renamed from: com.tencent.mm.plugin.appbrand.g.b */
public final class C2154b {
    /* renamed from: j */
    public static int m4368j(InputStream inputStream) {
        int i = 0;
        AppMethodBeat.m2504i(65352);
        if (inputStream == null) {
            AppMethodBeat.m2505o(65352);
        } else {
            try {
                i = new C0252a(inputStream).getAttributeInt(C0252a.TAG_ORIENTATION, 1);
                AppMethodBeat.m2505o(65352);
            } catch (Exception e) {
                AppMethodBeat.m2505o(65352);
            }
        }
        return i;
    }

    /* renamed from: bY */
    public static void m4366bY(String str, String str2) {
        AppMethodBeat.m2504i(65353);
        if (C2154b.m4367ct(str) && C2154b.m4367ct(str2)) {
            C0252a c0252a = new C0252a(str2);
            C33182a.m54272a(new C0252a(str), c0252a);
            c0252a.setAttribute(C0252a.TAG_ORIENTATION, null);
            c0252a.setAttribute(C0252a.TAG_IMAGE_WIDTH, null);
            c0252a.setAttribute(C0252a.TAG_THUMBNAIL_IMAGE_WIDTH, null);
            c0252a.saveAttributes();
            AppMethodBeat.m2505o(65353);
            return;
        }
        AppMethodBeat.m2505o(65353);
    }

    /* renamed from: a */
    public static void m4365a(InputStream inputStream, String str) {
        AppMethodBeat.m2504i(65354);
        if (inputStream == null || !C2154b.m4367ct(str)) {
            AppMethodBeat.m2505o(65354);
            return;
        }
        C0252a c0252a = new C0252a(str);
        C33182a.m54272a(new C0252a(inputStream), c0252a);
        c0252a.setAttribute(C0252a.TAG_ORIENTATION, null);
        c0252a.setAttribute(C0252a.TAG_IMAGE_WIDTH, null);
        c0252a.setAttribute(C0252a.TAG_THUMBNAIL_IMAGE_WIDTH, null);
        c0252a.saveAttributes();
        AppMethodBeat.m2505o(65354);
    }

    /* renamed from: ct */
    private static boolean m4367ct(String str) {
        AppMethodBeat.m2504i(65355);
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            AppMethodBeat.m2505o(65355);
            return false;
        }
        AppMethodBeat.m2505o(65355);
        return true;
    }
}
