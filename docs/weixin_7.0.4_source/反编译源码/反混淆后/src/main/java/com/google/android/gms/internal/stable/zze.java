package com.google.android.gms.internal.stable;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class zze {

    public static class zza implements BaseColumns {
        private static HashMap<Uri, zzh> zzagq = new HashMap();

        static {
            AppMethodBeat.m2504i(90474);
            AppMethodBeat.m2505o(90474);
        }

        private static zzh zza(ContentResolver contentResolver, Uri uri) {
            AppMethodBeat.m2504i(90471);
            zzh zzh = (zzh) zzagq.get(uri);
            if (zzh == null) {
                zzh = new zzh();
                zzagq.put(uri, zzh);
                contentResolver.registerContentObserver(uri, true, new zzf(null, zzh));
            } else if (zzh.zzagu.getAndSet(false)) {
                synchronized (zzh) {
                    try {
                        zzh.zzags.clear();
                        zzh.zzagt = new Object();
                    } catch (Throwable th) {
                        AppMethodBeat.m2505o(90471);
                    }
                }
            }
            AppMethodBeat.m2505o(90471);
            return zzh;
        }

        /* JADX WARNING: Removed duplicated region for block: B:49:0x0097  */
        /* JADX WARNING: Missing block: B:19:?, code skipped:
            r0 = r10;
            r1 = r11;
            r1 = r0.query(r1, new java.lang.String[]{"value"}, "name=?", new java.lang.String[]{r12}, null);
     */
        /* JADX WARNING: Missing block: B:20:0x0047, code skipped:
            if (r1 == null) goto L_0x004f;
     */
        /* JADX WARNING: Missing block: B:23:0x004d, code skipped:
            if (r1.moveToFirst() != false) goto L_0x0063;
     */
        /* JADX WARNING: Missing block: B:24:0x004f, code skipped:
            zza(r7, r8, r12, null);
     */
        /* JADX WARNING: Missing block: B:25:0x0053, code skipped:
            if (r1 == null) goto L_0x0058;
     */
        /* JADX WARNING: Missing block: B:26:0x0055, code skipped:
            r1.close();
     */
        /* JADX WARNING: Missing block: B:27:0x0058, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(90472);
     */
        /* JADX WARNING: Missing block: B:34:?, code skipped:
            r0 = r1.getString(0);
     */
        /* JADX WARNING: Missing block: B:36:?, code skipped:
            zza(r7, r8, r12, r0);
     */
        /* JADX WARNING: Missing block: B:37:0x006b, code skipped:
            if (r1 == null) goto L_0x0070;
     */
        /* JADX WARNING: Missing block: B:38:0x006d, code skipped:
            r1.close();
     */
        /* JADX WARNING: Missing block: B:39:0x0070, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(90472);
     */
        /* JADX WARNING: Missing block: B:41:0x0075, code skipped:
            r1 = null;
            r0 = null;
     */
        /* JADX WARNING: Missing block: B:43:?, code skipped:
            new java.lang.StringBuilder("Can't get key ").append(r12).append(" from ").append(r11);
     */
        /* JADX WARNING: Missing block: B:44:0x008d, code skipped:
            if (r1 != null) goto L_0x008f;
     */
        /* JADX WARNING: Missing block: B:45:0x008f, code skipped:
            r1.close();
     */
        /* JADX WARNING: Missing block: B:46:0x0093, code skipped:
            r0 = th;
     */
        /* JADX WARNING: Missing block: B:47:0x0094, code skipped:
            r1 = null;
     */
        /* JADX WARNING: Missing block: B:48:0x0095, code skipped:
            if (r1 != null) goto L_0x0097;
     */
        /* JADX WARNING: Missing block: B:49:0x0097, code skipped:
            r1.close();
     */
        /* JADX WARNING: Missing block: B:50:0x009a, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(90472);
     */
        /* JADX WARNING: Missing block: B:51:0x009d, code skipped:
            throw r0;
     */
        /* JADX WARNING: Missing block: B:52:0x009e, code skipped:
            r0 = th;
     */
        /* JADX WARNING: Missing block: B:54:0x00a1, code skipped:
            r0 = null;
     */
        /* JADX WARNING: Missing block: B:63:?, code skipped:
            return null;
     */
        /* JADX WARNING: Missing block: B:64:?, code skipped:
            return r0;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        protected static String zza(ContentResolver contentResolver, Uri uri, String str) {
            zzh zza;
            String str2;
            AppMethodBeat.m2504i(90472);
            synchronized (zza.class) {
                try {
                    zza = zza(contentResolver, uri);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(90472);
                }
            }
            synchronized (zza) {
                try {
                    Object obj = zza.zzagt;
                    if (zza.zzags.containsKey(str)) {
                        str2 = (String) zza.zzags.get(str);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(90472);
                    }
                }
            }
            return str2;
        }

        private static void zza(zzh zzh, Object obj, String str, String str2) {
            AppMethodBeat.m2504i(90473);
            synchronized (zzh) {
                try {
                    if (obj == zzh.zzagt) {
                        zzh.zzags.put(str, str2);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(90473);
                }
            }
        }
    }
}
