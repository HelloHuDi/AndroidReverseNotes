package com.bumptech.glide.p086c.p092d.p787c;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.p086c.C31967j;
import com.bumptech.glide.p086c.C31968k;
import com.bumptech.glide.p086c.p088b.C17526u;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

/* renamed from: com.bumptech.glide.c.d.c.d */
public final class C41557d implements C31968k<Uri, Drawable> {
    private final Context context;

    /* renamed from: a */
    public final /* synthetic */ C17526u mo2234a(Object obj, int i, int i2, C31967j c31967j) {
        AppMethodBeat.m2504i(92294);
        C17526u m = mo66576m((Uri) obj);
        AppMethodBeat.m2505o(92294);
        return m;
    }

    public C41557d(Context context) {
        AppMethodBeat.m2504i(92290);
        this.context = context.getApplicationContext();
        AppMethodBeat.m2505o(92290);
    }

    /* renamed from: m */
    public final C17526u<Drawable> mo66576m(Uri uri) {
        AppMethodBeat.m2504i(92291);
        int n = m72747n(uri);
        String authority = uri.getAuthority();
        C17526u p = C37183c.m62323p(C8550a.m15197b(this.context, authority.equals(this.context.getPackageName()) ? this.context : m72746a(uri, authority), n));
        AppMethodBeat.m2505o(92291);
        return p;
    }

    /* renamed from: a */
    private Context m72746a(Uri uri, String str) {
        AppMethodBeat.m2504i(92292);
        try {
            Context createPackageContext = this.context.createPackageContext(str, 0);
            AppMethodBeat.m2505o(92292);
            return createPackageContext;
        } catch (NameNotFoundException e) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: ".concat(String.valueOf(uri)), e);
            AppMethodBeat.m2505o(92292);
            throw illegalArgumentException;
        }
    }

    /* renamed from: n */
    private int m72747n(Uri uri) {
        Integer valueOf;
        AppMethodBeat.m2504i(92293);
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
            AppMethodBeat.m2505o(92293);
            throw illegalArgumentException;
        } else if (valueOf.intValue() == 0) {
            illegalArgumentException = new IllegalArgumentException("Failed to obtain resource id for: ".concat(String.valueOf(uri)));
            AppMethodBeat.m2505o(92293);
            throw illegalArgumentException;
        } else {
            int intValue = valueOf.intValue();
            AppMethodBeat.m2505o(92293);
            return intValue;
        }
    }
}
