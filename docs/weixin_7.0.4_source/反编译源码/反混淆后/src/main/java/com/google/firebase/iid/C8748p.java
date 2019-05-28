package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.p057v4.content.C0380b;
import android.support.p057v4.p065f.C6197a;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/* renamed from: com.google.firebase.iid.p */
final class C8748p {
    private final Context bvF;
    private final SharedPreferences bwa;
    private final C41650af bwb;
    private final Map<String, C45073ag> bwc;

    public C8748p(Context context) {
        this(context, new C41650af());
        AppMethodBeat.m2504i(108749);
        AppMethodBeat.m2505o(108749);
    }

    private C8748p(Context context, C41650af c41650af) {
        AppMethodBeat.m2504i(108750);
        this.bwc = new C6197a();
        this.bvF = context;
        this.bwa = context.getSharedPreferences("com.google.android.gms.appid", 0);
        this.bwb = c41650af;
        File file = new File(C0380b.m646Q(this.bvF), "com.google.android.gms.appid-no-backup");
        if (!file.exists()) {
            try {
                if (file.createNewFile() && !isEmpty()) {
                    zzag();
                    FirebaseInstanceId.m40567uD().mo43239uI();
                }
                AppMethodBeat.m2505o(108750);
                return;
            } catch (IOException e) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String str = "Error creating file in no backup dir: ";
                    String valueOf = String.valueOf(e.getMessage());
                    if (valueOf.length() != 0) {
                        str.concat(valueOf);
                        AppMethodBeat.m2505o(108750);
                        return;
                    }
                    valueOf = new String(str);
                }
            }
        }
        AppMethodBeat.m2505o(108750);
    }

    /* renamed from: c */
    private static String m15566c(String str, String str2, String str3) {
        AppMethodBeat.m2504i(108754);
        String stringBuilder = new StringBuilder(((String.valueOf(str).length() + 4) + String.valueOf(str2).length()) + String.valueOf(str3).length()).append(str).append("|T|").append(str2).append("|").append(str3).toString();
        AppMethodBeat.m2505o(108754);
        return stringBuilder;
    }

    private final synchronized boolean isEmpty() {
        boolean isEmpty;
        AppMethodBeat.m2504i(108753);
        isEmpty = this.bwa.getAll().isEmpty();
        AppMethodBeat.m2505o(108753);
        return isEmpty;
    }

    /* renamed from: o */
    static String m15567o(String str, String str2) {
        AppMethodBeat.m2504i(108755);
        String stringBuilder = new StringBuilder((String.valueOf(str).length() + 3) + String.valueOf(str2).length()).append(str).append("|S|").append(str2).toString();
        AppMethodBeat.m2505o(108755);
        return stringBuilder;
    }

    /* renamed from: aZ */
    public final synchronized void mo19767aZ(String str) {
        AppMethodBeat.m2504i(108760);
        String concat = String.valueOf(str).concat("|T|");
        Editor edit = this.bwa.edit();
        for (String str2 : this.bwa.getAll().keySet()) {
            if (str2.startsWith(concat)) {
                edit.remove(str2);
            }
        }
        edit.commit();
        AppMethodBeat.m2505o(108760);
    }

    /* renamed from: b */
    public final synchronized void mo19768b(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.m2504i(108758);
        String b = C45074q.m82700b(str4, str5, System.currentTimeMillis());
        if (b == null) {
            AppMethodBeat.m2505o(108758);
        } else {
            Editor edit = this.bwa.edit();
            edit.putString(C8748p.m15566c(str, str2, str3), b);
            edit.commit();
            AppMethodBeat.m2505o(108758);
        }
    }

    /* renamed from: d */
    public final synchronized C45074q mo19769d(String str, String str2, String str3) {
        C45074q ba;
        AppMethodBeat.m2504i(108757);
        ba = C45074q.m82701ba(this.bwa.getString(C8748p.m15566c(str, str2, str3), null));
        AppMethodBeat.m2505o(108757);
        return ba;
    }

    /* renamed from: uT */
    public final synchronized String mo19770uT() {
        String str = null;
        synchronized (this) {
            AppMethodBeat.m2504i(108751);
            String string = this.bwa.getString("topic_operaion_queue", null);
            if (string != null) {
                String[] split = string.split(",");
                if (split.length > 1 && !TextUtils.isEmpty(split[1])) {
                    str = split[1];
                    AppMethodBeat.m2505o(108751);
                }
            }
            AppMethodBeat.m2505o(108751);
        }
        return str;
    }

    public final synchronized boolean zzf(String str) {
        boolean z;
        AppMethodBeat.m2504i(108752);
        String string = this.bwa.getString("topic_operaion_queue", "");
        String valueOf = String.valueOf(",");
        String valueOf2 = String.valueOf(str);
        if (string.startsWith(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf))) {
            valueOf = String.valueOf(",");
            valueOf2 = String.valueOf(str);
            this.bwa.edit().putString("topic_operaion_queue", string.substring((valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).length())).apply();
            z = true;
            AppMethodBeat.m2505o(108752);
        } else {
            z = false;
            AppMethodBeat.m2505o(108752);
        }
        return z;
    }

    public final synchronized void zzag() {
        AppMethodBeat.m2504i(108756);
        this.bwc.clear();
        for (File file : C41650af.m73027aq(this.bvF).listFiles()) {
            if (file.getName().startsWith("com.google.InstanceId")) {
                file.delete();
            }
        }
        this.bwa.edit().clear().commit();
        AppMethodBeat.m2505o(108756);
    }

    /* renamed from: aY */
    public final synchronized C45073ag mo19766aY(String str) {
        C45073ag c45073ag;
        AppMethodBeat.m2504i(108759);
        c45073ag = (C45073ag) this.bwc.get(str);
        if (c45073ag != null) {
            AppMethodBeat.m2505o(108759);
        } else {
            try {
                Context context = this.bvF;
                c45073ag = C41650af.m73031l(context, str);
                if (c45073ag == null) {
                    c45073ag = C41650af.m73030k(context, str);
                }
            } catch (C8747ah e) {
                FirebaseInstanceId.m40567uD().mo43239uI();
                c45073ag = C41650af.m73030k(this.bvF, str);
            }
            this.bwc.put(str, c45073ag);
            AppMethodBeat.m2505o(108759);
        }
        return c45073ag;
    }
}
