package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.content.b;
import android.support.v4.f.a;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.util.Map;

final class p {
    private final Context bvF;
    private final SharedPreferences bwa;
    private final af bwb;
    private final Map<String, ag> bwc;

    public p(Context context) {
        this(context, new af());
        AppMethodBeat.i(108749);
        AppMethodBeat.o(108749);
    }

    private p(Context context, af afVar) {
        AppMethodBeat.i(108750);
        this.bwc = new a();
        this.bvF = context;
        this.bwa = context.getSharedPreferences("com.google.android.gms.appid", 0);
        this.bwb = afVar;
        File file = new File(b.Q(this.bvF), "com.google.android.gms.appid-no-backup");
        if (!file.exists()) {
            try {
                if (file.createNewFile() && !isEmpty()) {
                    zzag();
                    FirebaseInstanceId.uD().uI();
                }
                AppMethodBeat.o(108750);
                return;
            } catch (IOException e) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String str = "Error creating file in no backup dir: ";
                    String valueOf = String.valueOf(e.getMessage());
                    if (valueOf.length() != 0) {
                        str.concat(valueOf);
                        AppMethodBeat.o(108750);
                        return;
                    }
                    valueOf = new String(str);
                }
            }
        }
        AppMethodBeat.o(108750);
    }

    private static String c(String str, String str2, String str3) {
        AppMethodBeat.i(108754);
        String stringBuilder = new StringBuilder(((String.valueOf(str).length() + 4) + String.valueOf(str2).length()) + String.valueOf(str3).length()).append(str).append("|T|").append(str2).append("|").append(str3).toString();
        AppMethodBeat.o(108754);
        return stringBuilder;
    }

    private final synchronized boolean isEmpty() {
        boolean isEmpty;
        AppMethodBeat.i(108753);
        isEmpty = this.bwa.getAll().isEmpty();
        AppMethodBeat.o(108753);
        return isEmpty;
    }

    static String o(String str, String str2) {
        AppMethodBeat.i(108755);
        String stringBuilder = new StringBuilder((String.valueOf(str).length() + 3) + String.valueOf(str2).length()).append(str).append("|S|").append(str2).toString();
        AppMethodBeat.o(108755);
        return stringBuilder;
    }

    public final synchronized void aZ(String str) {
        AppMethodBeat.i(108760);
        String concat = String.valueOf(str).concat("|T|");
        Editor edit = this.bwa.edit();
        for (String str2 : this.bwa.getAll().keySet()) {
            if (str2.startsWith(concat)) {
                edit.remove(str2);
            }
        }
        edit.commit();
        AppMethodBeat.o(108760);
    }

    public final synchronized void b(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(108758);
        String b = q.b(str4, str5, System.currentTimeMillis());
        if (b == null) {
            AppMethodBeat.o(108758);
        } else {
            Editor edit = this.bwa.edit();
            edit.putString(c(str, str2, str3), b);
            edit.commit();
            AppMethodBeat.o(108758);
        }
    }

    public final synchronized q d(String str, String str2, String str3) {
        q ba;
        AppMethodBeat.i(108757);
        ba = q.ba(this.bwa.getString(c(str, str2, str3), null));
        AppMethodBeat.o(108757);
        return ba;
    }

    public final synchronized String uT() {
        String str = null;
        synchronized (this) {
            AppMethodBeat.i(108751);
            String string = this.bwa.getString("topic_operaion_queue", null);
            if (string != null) {
                String[] split = string.split(",");
                if (split.length > 1 && !TextUtils.isEmpty(split[1])) {
                    str = split[1];
                    AppMethodBeat.o(108751);
                }
            }
            AppMethodBeat.o(108751);
        }
        return str;
    }

    public final synchronized boolean zzf(String str) {
        boolean z;
        AppMethodBeat.i(108752);
        String string = this.bwa.getString("topic_operaion_queue", "");
        String valueOf = String.valueOf(",");
        String valueOf2 = String.valueOf(str);
        if (string.startsWith(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf))) {
            valueOf = String.valueOf(",");
            valueOf2 = String.valueOf(str);
            this.bwa.edit().putString("topic_operaion_queue", string.substring((valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).length())).apply();
            z = true;
            AppMethodBeat.o(108752);
        } else {
            z = false;
            AppMethodBeat.o(108752);
        }
        return z;
    }

    public final synchronized void zzag() {
        AppMethodBeat.i(108756);
        this.bwc.clear();
        for (File file : af.aq(this.bvF).listFiles()) {
            if (file.getName().startsWith("com.google.InstanceId")) {
                file.delete();
            }
        }
        this.bwa.edit().clear().commit();
        AppMethodBeat.o(108756);
    }

    public final synchronized ag aY(String str) {
        ag agVar;
        AppMethodBeat.i(108759);
        agVar = (ag) this.bwc.get(str);
        if (agVar != null) {
            AppMethodBeat.o(108759);
        } else {
            try {
                Context context = this.bvF;
                agVar = af.l(context, str);
                if (agVar == null) {
                    agVar = af.k(context, str);
                }
            } catch (ah e) {
                FirebaseInstanceId.uD().uI();
                agVar = af.k(this.bvF, str);
            }
            this.bwc.put(str, agVar);
            AppMethodBeat.o(108759);
        }
        return agVar;
    }
}
