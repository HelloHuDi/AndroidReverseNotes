package com.bumptech.glide.p086c.p090c;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.p086c.C31967j;
import com.bumptech.glide.p086c.p090c.C37175n.C37176a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.c.c.s */
public final class C25438s<Data> implements C37175n<Integer, Data> {
    private final C37175n<Uri, Data> aEG;
    private final Resources aEH;

    /* renamed from: com.bumptech.glide.c.c.s$b */
    public static class C8540b implements C31953o<Integer, ParcelFileDescriptor> {
        private final Resources aEH;

        public C8540b(Resources resources) {
            this.aEH = resources;
        }

        /* renamed from: a */
        public final C37175n<Integer, ParcelFileDescriptor> mo2219a(C8536r c8536r) {
            AppMethodBeat.m2504i(92127);
            C25438s c25438s = new C25438s(this.aEH, c8536r.mo18638b(Uri.class, ParcelFileDescriptor.class));
            AppMethodBeat.m2505o(92127);
            return c25438s;
        }
    }

    /* renamed from: com.bumptech.glide.c.c.s$d */
    public static class C17538d implements C31953o<Integer, Uri> {
        private final Resources aEH;

        public C17538d(Resources resources) {
            this.aEH = resources;
        }

        /* renamed from: a */
        public final C37175n<Integer, Uri> mo2219a(C8536r c8536r) {
            AppMethodBeat.m2504i(92129);
            C25438s c25438s = new C25438s(this.aEH, C41195v.m71692nk());
            AppMethodBeat.m2505o(92129);
            return c25438s;
        }
    }

    /* renamed from: com.bumptech.glide.c.c.s$c */
    public static class C25437c implements C31953o<Integer, InputStream> {
        private final Resources aEH;

        public C25437c(Resources resources) {
            this.aEH = resources;
        }

        /* renamed from: a */
        public final C37175n<Integer, InputStream> mo2219a(C8536r c8536r) {
            AppMethodBeat.m2504i(92128);
            C25438s c25438s = new C25438s(this.aEH, c8536r.mo18638b(Uri.class, InputStream.class));
            AppMethodBeat.m2505o(92128);
            return c25438s;
        }
    }

    /* renamed from: com.bumptech.glide.c.c.s$a */
    public static final class C25439a implements C31953o<Integer, AssetFileDescriptor> {
        private final Resources aEH;

        public C25439a(Resources resources) {
            this.aEH = resources;
        }

        /* renamed from: a */
        public final C37175n<Integer, AssetFileDescriptor> mo2219a(C8536r c8536r) {
            AppMethodBeat.m2504i(92126);
            C25438s c25438s = new C25438s(this.aEH, c8536r.mo18638b(Uri.class, AssetFileDescriptor.class));
            AppMethodBeat.m2505o(92126);
            return c25438s;
        }
    }

    /* renamed from: X */
    public final /* bridge */ /* synthetic */ boolean mo2224X(Object obj) {
        return true;
    }

    /* renamed from: b */
    public final /* synthetic */ C37176a mo2225b(Object obj, int i, int i2, C31967j c31967j) {
        AppMethodBeat.m2504i(92131);
        Uri a = m40203a((Integer) obj);
        if (a == null) {
            AppMethodBeat.m2505o(92131);
            return null;
        }
        C37176a b = this.aEG.mo2225b(a, i, i2, c31967j);
        AppMethodBeat.m2505o(92131);
        return b;
    }

    public C25438s(Resources resources, C37175n<Uri, Data> c37175n) {
        this.aEH = resources;
        this.aEG = c37175n;
    }

    /* renamed from: a */
    private Uri m40203a(Integer num) {
        AppMethodBeat.m2504i(92130);
        try {
            Uri parse = Uri.parse("android.resource://" + this.aEH.getResourcePackageName(num.intValue()) + IOUtils.DIR_SEPARATOR_UNIX + this.aEH.getResourceTypeName(num.intValue()) + IOUtils.DIR_SEPARATOR_UNIX + this.aEH.getResourceEntryName(num.intValue()));
            AppMethodBeat.m2505o(92130);
            return parse;
        } catch (NotFoundException e) {
            if (Log.isLoggable("ResourceLoader", 5)) {
                new StringBuilder("Received invalid resource id: ").append(num);
            }
            AppMethodBeat.m2505o(92130);
            return null;
        }
    }
}
