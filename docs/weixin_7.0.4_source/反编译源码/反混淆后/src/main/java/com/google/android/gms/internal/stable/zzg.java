package com.google.android.gms.internal.stable;

import android.content.ContentResolver;
import android.net.Uri;
import com.google.android.gms.internal.stable.zze.zza;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzg extends zza {
    private static final Uri CONTENT_URI = Uri.parse("content://com.google.settings/partner");

    static {
        AppMethodBeat.m2504i(90479);
        AppMethodBeat.m2505o(90479);
    }

    public static int getInt(ContentResolver contentResolver, String str, int i) {
        int i2 = -1;
        AppMethodBeat.m2504i(90478);
        String string = getString(contentResolver, str);
        if (string != null) {
            try {
                i2 = Integer.parseInt(string);
            } catch (NumberFormatException e) {
            }
        }
        AppMethodBeat.m2505o(90478);
        return i2;
    }

    private static String getString(ContentResolver contentResolver, String str) {
        AppMethodBeat.m2504i(90476);
        String zza = zza.zza(contentResolver, CONTENT_URI, str);
        AppMethodBeat.m2505o(90476);
        return zza;
    }

    public static String zza(ContentResolver contentResolver, String str, String str2) {
        AppMethodBeat.m2504i(90477);
        String string = getString(contentResolver, str);
        if (string != null) {
            str2 = string;
        }
        AppMethodBeat.m2505o(90477);
        return str2;
    }
}
