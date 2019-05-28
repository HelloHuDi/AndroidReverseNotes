package com.bumptech.glide.c.c;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.bumptech.glide.c.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.File;
import java.io.InputStream;

public final class u<Data> implements n<String, Data> {
    private final n<Uri, Data> aEG;

    public static final class a implements o<String, AssetFileDescriptor> {
        public final n<String, AssetFileDescriptor> a(r rVar) {
            AppMethodBeat.i(92134);
            u uVar = new u(rVar.b(Uri.class, AssetFileDescriptor.class));
            AppMethodBeat.o(92134);
            return uVar;
        }
    }

    public static class b implements o<String, ParcelFileDescriptor> {
        public final n<String, ParcelFileDescriptor> a(r rVar) {
            AppMethodBeat.i(92135);
            u uVar = new u(rVar.b(Uri.class, ParcelFileDescriptor.class));
            AppMethodBeat.o(92135);
            return uVar;
        }
    }

    public static class c implements o<String, InputStream> {
        public final n<String, InputStream> a(r rVar) {
            AppMethodBeat.i(92136);
            u uVar = new u(rVar.b(Uri.class, InputStream.class));
            AppMethodBeat.o(92136);
            return uVar;
        }
    }

    public final /* bridge */ /* synthetic */ boolean X(Object obj) {
        return true;
    }

    public final /* synthetic */ com.bumptech.glide.c.c.n.a b(Object obj, int i, int i2, j jVar) {
        Object obj2;
        AppMethodBeat.i(92138);
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            obj2 = null;
        } else if (str.charAt(0) == IOUtils.DIR_SEPARATOR_UNIX) {
            obj2 = ab(str);
        } else {
            obj2 = Uri.parse(str);
            if (obj2.getScheme() == null) {
                obj2 = ab(str);
            }
        }
        if (obj2 == null) {
            AppMethodBeat.o(92138);
            return null;
        }
        com.bumptech.glide.c.c.n.a b = this.aEG.b(obj2, i, i2, jVar);
        AppMethodBeat.o(92138);
        return b;
    }

    public u(n<Uri, Data> nVar) {
        this.aEG = nVar;
    }

    private static Uri ab(String str) {
        AppMethodBeat.i(92137);
        Uri fromFile = Uri.fromFile(new File(str));
        AppMethodBeat.o(92137);
        return fromFile;
    }
}
