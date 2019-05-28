package com.bumptech.glide.c.c;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.c.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.InputStream;

public final class s<Data> implements n<Integer, Data> {
    private final n<Uri, Data> aEG;
    private final Resources aEH;

    public static class b implements o<Integer, ParcelFileDescriptor> {
        private final Resources aEH;

        public b(Resources resources) {
            this.aEH = resources;
        }

        public final n<Integer, ParcelFileDescriptor> a(r rVar) {
            AppMethodBeat.i(92127);
            s sVar = new s(this.aEH, rVar.b(Uri.class, ParcelFileDescriptor.class));
            AppMethodBeat.o(92127);
            return sVar;
        }
    }

    public static class d implements o<Integer, Uri> {
        private final Resources aEH;

        public d(Resources resources) {
            this.aEH = resources;
        }

        public final n<Integer, Uri> a(r rVar) {
            AppMethodBeat.i(92129);
            s sVar = new s(this.aEH, v.nk());
            AppMethodBeat.o(92129);
            return sVar;
        }
    }

    public static class c implements o<Integer, InputStream> {
        private final Resources aEH;

        public c(Resources resources) {
            this.aEH = resources;
        }

        public final n<Integer, InputStream> a(r rVar) {
            AppMethodBeat.i(92128);
            s sVar = new s(this.aEH, rVar.b(Uri.class, InputStream.class));
            AppMethodBeat.o(92128);
            return sVar;
        }
    }

    public static final class a implements o<Integer, AssetFileDescriptor> {
        private final Resources aEH;

        public a(Resources resources) {
            this.aEH = resources;
        }

        public final n<Integer, AssetFileDescriptor> a(r rVar) {
            AppMethodBeat.i(92126);
            s sVar = new s(this.aEH, rVar.b(Uri.class, AssetFileDescriptor.class));
            AppMethodBeat.o(92126);
            return sVar;
        }
    }

    public final /* bridge */ /* synthetic */ boolean X(Object obj) {
        return true;
    }

    public final /* synthetic */ com.bumptech.glide.c.c.n.a b(Object obj, int i, int i2, j jVar) {
        AppMethodBeat.i(92131);
        Uri a = a((Integer) obj);
        if (a == null) {
            AppMethodBeat.o(92131);
            return null;
        }
        com.bumptech.glide.c.c.n.a b = this.aEG.b(a, i, i2, jVar);
        AppMethodBeat.o(92131);
        return b;
    }

    public s(Resources resources, n<Uri, Data> nVar) {
        this.aEH = resources;
        this.aEG = nVar;
    }

    private Uri a(Integer num) {
        AppMethodBeat.i(92130);
        try {
            Uri parse = Uri.parse("android.resource://" + this.aEH.getResourcePackageName(num.intValue()) + IOUtils.DIR_SEPARATOR_UNIX + this.aEH.getResourceTypeName(num.intValue()) + IOUtils.DIR_SEPARATOR_UNIX + this.aEH.getResourceEntryName(num.intValue()));
            AppMethodBeat.o(92130);
            return parse;
        } catch (NotFoundException e) {
            if (Log.isLoggable("ResourceLoader", 5)) {
                new StringBuilder("Received invalid resource id: ").append(num);
            }
            AppMethodBeat.o(92130);
            return null;
        }
    }
}
