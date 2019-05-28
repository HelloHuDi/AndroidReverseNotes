package com.bumptech.glide.p086c.p090c;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.bumptech.glide.p086c.C31967j;
import com.bumptech.glide.p086c.p090c.C37175n.C37176a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.File;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.c.c.u */
public final class C44992u<Data> implements C37175n<String, Data> {
    private final C37175n<Uri, Data> aEG;

    /* renamed from: com.bumptech.glide.c.c.u$a */
    public static final class C17539a implements C31953o<String, AssetFileDescriptor> {
        /* renamed from: a */
        public final C37175n<String, AssetFileDescriptor> mo2219a(C8536r c8536r) {
            AppMethodBeat.m2504i(92134);
            C44992u c44992u = new C44992u(c8536r.mo18638b(Uri.class, AssetFileDescriptor.class));
            AppMethodBeat.m2505o(92134);
            return c44992u;
        }
    }

    /* renamed from: com.bumptech.glide.c.c.u$b */
    public static class C41552b implements C31953o<String, ParcelFileDescriptor> {
        /* renamed from: a */
        public final C37175n<String, ParcelFileDescriptor> mo2219a(C8536r c8536r) {
            AppMethodBeat.m2504i(92135);
            C44992u c44992u = new C44992u(c8536r.mo18638b(Uri.class, ParcelFileDescriptor.class));
            AppMethodBeat.m2505o(92135);
            return c44992u;
        }
    }

    /* renamed from: com.bumptech.glide.c.c.u$c */
    public static class C41553c implements C31953o<String, InputStream> {
        /* renamed from: a */
        public final C37175n<String, InputStream> mo2219a(C8536r c8536r) {
            AppMethodBeat.m2504i(92136);
            C44992u c44992u = new C44992u(c8536r.mo18638b(Uri.class, InputStream.class));
            AppMethodBeat.m2505o(92136);
            return c44992u;
        }
    }

    /* renamed from: X */
    public final /* bridge */ /* synthetic */ boolean mo2224X(Object obj) {
        return true;
    }

    /* renamed from: b */
    public final /* synthetic */ C37176a mo2225b(Object obj, int i, int i2, C31967j c31967j) {
        Object obj2;
        AppMethodBeat.m2504i(92138);
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            obj2 = null;
        } else if (str.charAt(0) == IOUtils.DIR_SEPARATOR_UNIX) {
            obj2 = C44992u.m82389ab(str);
        } else {
            obj2 = Uri.parse(str);
            if (obj2.getScheme() == null) {
                obj2 = C44992u.m82389ab(str);
            }
        }
        if (obj2 == null) {
            AppMethodBeat.m2505o(92138);
            return null;
        }
        C37176a b = this.aEG.mo2225b(obj2, i, i2, c31967j);
        AppMethodBeat.m2505o(92138);
        return b;
    }

    public C44992u(C37175n<Uri, Data> c37175n) {
        this.aEG = c37175n;
    }

    /* renamed from: ab */
    private static Uri m82389ab(String str) {
        AppMethodBeat.m2504i(92137);
        Uri fromFile = Uri.fromFile(new File(str));
        AppMethodBeat.m2505o(92137);
        return fromFile;
    }
}
