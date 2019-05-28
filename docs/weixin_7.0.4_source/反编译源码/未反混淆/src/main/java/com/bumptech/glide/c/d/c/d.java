package com.bumptech.glide.c.d.c;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.c.b.u;
import com.bumptech.glide.c.j;
import com.bumptech.glide.c.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class d implements k<Uri, Drawable> {
    private final Context context;

    public final /* synthetic */ u a(Object obj, int i, int i2, j jVar) {
        AppMethodBeat.i(92294);
        u m = m((Uri) obj);
        AppMethodBeat.o(92294);
        return m;
    }

    public d(Context context) {
        AppMethodBeat.i(92290);
        this.context = context.getApplicationContext();
        AppMethodBeat.o(92290);
    }

    public final u<Drawable> m(Uri uri) {
        AppMethodBeat.i(92291);
        int n = n(uri);
        String authority = uri.getAuthority();
        u p = c.p(a.b(this.context, authority.equals(this.context.getPackageName()) ? this.context : a(uri, authority), n));
        AppMethodBeat.o(92291);
        return p;
    }

    private Context a(Uri uri, String str) {
        AppMethodBeat.i(92292);
        try {
            Context createPackageContext = this.context.createPackageContext(str, 0);
            AppMethodBeat.o(92292);
            return createPackageContext;
        } catch (NameNotFoundException e) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: ".concat(String.valueOf(uri)), e);
            AppMethodBeat.o(92292);
            throw illegalArgumentException;
        }
    }

    private int n(Uri uri) {
        Integer valueOf;
        AppMethodBeat.i(92293);
        List pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            String str = (String) pathSegments.get(0);
            String str2 = (String) pathSegments.get(1);
            valueOf = Integer.valueOf(this.context.getResources().getIdentifier(str2, str, uri.getAuthority()));
        } else {
            if (pathSegments.size() == 1) {
                try {
                    valueOf = Integer.valueOf((String) pathSegments.get(0));
                } catch (NumberFormatException e) {
                }
            }
            valueOf = null;
        }
        IllegalArgumentException illegalArgumentException;
        if (valueOf == null) {
            illegalArgumentException = new IllegalArgumentException("Unrecognized Uri format: ".concat(String.valueOf(uri)));
            AppMethodBeat.o(92293);
            throw illegalArgumentException;
        } else if (valueOf.intValue() == 0) {
            illegalArgumentException = new IllegalArgumentException("Failed to obtain resource id for: ".concat(String.valueOf(uri)));
            AppMethodBeat.o(92293);
            throw illegalArgumentException;
        } else {
            int intValue = valueOf.intValue();
            AppMethodBeat.o(92293);
            return intValue;
        }
    }
}
