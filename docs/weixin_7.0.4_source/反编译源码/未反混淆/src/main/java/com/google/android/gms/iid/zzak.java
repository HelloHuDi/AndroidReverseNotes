package com.google.android.gms.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.content.b;
import android.support.v4.f.a;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public final class zzak {
    private SharedPreferences zzcz;
    private final zzn zzda;
    private final Map<String, zzo> zzdb;
    private Context zzk;

    public zzak(Context context) {
        this(context, new zzn());
        AppMethodBeat.i(57549);
        AppMethodBeat.o(57549);
    }

    @VisibleForTesting
    private zzak(Context context, zzn zzn) {
        AppMethodBeat.i(57550);
        this.zzdb = new a();
        this.zzk = context;
        this.zzcz = context.getSharedPreferences("com.google.android.gms.appid", 0);
        this.zzda = zzn;
        File file = new File(b.Q(this.zzk), "com.google.android.gms.appid-no-backup");
        if (!file.exists()) {
            try {
                if (file.createNewFile() && !isEmpty()) {
                    InstanceIDListenerService.zzd(this.zzk, this);
                }
                AppMethodBeat.o(57550);
                return;
            } catch (IOException e) {
                if (Log.isLoggable("InstanceID/Store", 3)) {
                    String str = "Error creating file in no backup dir: ";
                    String valueOf = String.valueOf(e.getMessage());
                    if (valueOf.length() != 0) {
                        str.concat(valueOf);
                        AppMethodBeat.o(57550);
                        return;
                    }
                    valueOf = new String(str);
                }
            }
        }
        AppMethodBeat.o(57550);
    }

    private static String zzd(String str, String str2, String str3) {
        AppMethodBeat.i(57552);
        String stringBuilder = new StringBuilder(((String.valueOf(str).length() + 4) + String.valueOf(str2).length()) + String.valueOf(str3).length()).append(str).append("|T|").append(str2).append("|").append(str3).toString();
        AppMethodBeat.o(57552);
        return stringBuilder;
    }

    static String zzh(String str, String str2) {
        AppMethodBeat.i(57561);
        String stringBuilder = new StringBuilder((String.valueOf(str).length() + 3) + String.valueOf(str2).length()).append(str).append("|S|").append(str2).toString();
        AppMethodBeat.o(57561);
        return stringBuilder;
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized String get(String str) {
        String string;
        AppMethodBeat.i(57553);
        string = this.zzcz.getString(str, null);
        AppMethodBeat.o(57553);
        return string;
    }

    public final boolean isEmpty() {
        AppMethodBeat.i(57551);
        boolean isEmpty = this.zzcz.getAll().isEmpty();
        AppMethodBeat.o(57551);
        return isEmpty;
    }

    public final synchronized void zzd(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(57557);
        String zzd = zzd(str, str2, str3);
        Editor edit = this.zzcz.edit();
        edit.putString(zzd, str4);
        edit.putString("appVersion", str5);
        edit.putString("lastToken", Long.toString(System.currentTimeMillis() / 1000));
        edit.commit();
        AppMethodBeat.o(57557);
    }

    public final synchronized String zze(String str, String str2, String str3) {
        String string;
        AppMethodBeat.i(57556);
        string = this.zzcz.getString(zzd(str, str2, str3), null);
        AppMethodBeat.o(57556);
        return string;
    }

    public final synchronized void zzf(String str, String str2, String str3) {
        AppMethodBeat.i(57558);
        String zzd = zzd(str, str2, str3);
        Editor edit = this.zzcz.edit();
        edit.remove(zzd);
        edit.commit();
        AppMethodBeat.o(57558);
    }

    public final synchronized void zzi(String str) {
        AppMethodBeat.i(57554);
        Editor edit = this.zzcz.edit();
        for (String str2 : this.zzcz.getAll().keySet()) {
            if (str2.startsWith(str)) {
                edit.remove(str2);
            }
        }
        edit.commit();
        AppMethodBeat.o(57554);
    }

    public final synchronized zzo zzj(String str) {
        zzo zzo;
        AppMethodBeat.i(57559);
        zzo = (zzo) this.zzdb.get(str);
        if (zzo != null) {
            AppMethodBeat.o(57559);
        } else {
            try {
                zzo = this.zzda.zze(this.zzk, str);
            } catch (zzp e) {
                InstanceIDListenerService.zzd(this.zzk, this);
                zzo = this.zzda.zzf(this.zzk, str);
            }
            this.zzdb.put(str, zzo);
            AppMethodBeat.o(57559);
        }
        return zzo;
    }

    /* Access modifiers changed, original: final */
    public final void zzk(String str) {
        AppMethodBeat.i(57560);
        synchronized (this) {
            try {
                this.zzdb.remove(str);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(57560);
            }
        }
        zzn.zzg(this.zzk, str);
        zzi(String.valueOf(str).concat("|"));
    }

    public final synchronized void zzx() {
        AppMethodBeat.i(57555);
        this.zzdb.clear();
        zzn.zzi(this.zzk);
        this.zzcz.edit().clear().commit();
        AppMethodBeat.o(57555);
    }
}
