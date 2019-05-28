package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;

public final class zzfg extends zzhh {
    private long zzadu = -1;
    private char zzaim = 0;
    private String zzain;
    private final zzfi zzaio = new zzfi(this, 6, false, false);
    private final zzfi zzaip = new zzfi(this, 6, true, false);
    private final zzfi zzaiq = new zzfi(this, 6, false, true);
    private final zzfi zzair = new zzfi(this, 5, false, false);
    private final zzfi zzais = new zzfi(this, 5, true, false);
    private final zzfi zzait = new zzfi(this, 5, false, true);
    private final zzfi zzaiu = new zzfi(this, 4, false, false);
    private final zzfi zzaiv = new zzfi(this, 3, false, false);
    private final zzfi zzaiw = new zzfi(this, 2, false, false);

    zzfg(zzgl zzgl) {
        super(zzgl);
        AppMethodBeat.m2504i(68870);
        AppMethodBeat.m2505o(68870);
    }

    @VisibleForTesting
    private static String zza(boolean z, Object obj) {
        AppMethodBeat.m2504i(68877);
        String str;
        if (obj == null) {
            str = "";
            AppMethodBeat.m2505o(68877);
            return str;
        }
        Object valueOf = obj instanceof Integer ? Long.valueOf((long) ((Integer) obj).intValue()) : obj;
        if (valueOf instanceof Long) {
            if (!z) {
                str = String.valueOf(valueOf);
                AppMethodBeat.m2505o(68877);
                return str;
            } else if (Math.abs(((Long) valueOf).longValue()) < 100) {
                str = String.valueOf(valueOf);
                AppMethodBeat.m2505o(68877);
                return str;
            } else {
                Object obj2 = String.valueOf(valueOf).charAt(0) == '-' ? "-" : "";
                String valueOf2 = String.valueOf(Math.abs(((Long) valueOf).longValue()));
                str = new StringBuilder((String.valueOf(obj2).length() + 43) + String.valueOf(obj2).length()).append(obj2).append(Math.round(Math.pow(10.0d, (double) (valueOf2.length() - 1)))).append("...").append(obj2).append(Math.round(Math.pow(10.0d, (double) valueOf2.length()) - 1.0d)).toString();
                AppMethodBeat.m2505o(68877);
                return str;
            }
        } else if (valueOf instanceof Boolean) {
            str = String.valueOf(valueOf);
            AppMethodBeat.m2505o(68877);
            return str;
        } else if (valueOf instanceof Throwable) {
            Throwable th = (Throwable) valueOf;
            StringBuilder stringBuilder = new StringBuilder(z ? th.getClass().getName() : th.toString());
            String zzbn = zzbn(AppMeasurement.class.getCanonicalName());
            String zzbn2 = zzbn(zzgl.class.getCanonicalName());
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                if (!stackTraceElement.isNativeMethod()) {
                    String className = stackTraceElement.getClassName();
                    if (className != null) {
                        className = zzbn(className);
                        if (className.equals(zzbn) || className.equals(zzbn2)) {
                            stringBuilder.append(": ");
                            stringBuilder.append(stackTraceElement);
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
            str = stringBuilder.toString();
            AppMethodBeat.m2505o(68877);
            return str;
        } else if (valueOf instanceof zzfj) {
            str = ((zzfj) valueOf).zzajf;
            AppMethodBeat.m2505o(68877);
            return str;
        } else if (z) {
            str = "-";
            AppMethodBeat.m2505o(68877);
            return str;
        } else {
            str = String.valueOf(valueOf);
            AppMethodBeat.m2505o(68877);
            return str;
        }
    }

    static String zza(boolean z, String str, Object obj, Object obj2, Object obj3) {
        CharSequence str2;
        AppMethodBeat.m2504i(68876);
        if (str2 == null) {
            str2 = "";
        }
        String zza = zza(z, obj);
        String zza2 = zza(z, obj2);
        String zza3 = zza(z, obj3);
        StringBuilder stringBuilder = new StringBuilder();
        String str3 = "";
        if (!TextUtils.isEmpty(str2)) {
            stringBuilder.append(str2);
            str3 = ": ";
        }
        if (!TextUtils.isEmpty(zza)) {
            stringBuilder.append(str3);
            stringBuilder.append(zza);
            str3 = ", ";
        }
        if (!TextUtils.isEmpty(zza2)) {
            stringBuilder.append(str3);
            stringBuilder.append(zza2);
            str3 = ", ";
        }
        if (!TextUtils.isEmpty(zza3)) {
            stringBuilder.append(str3);
            stringBuilder.append(zza3);
        }
        str3 = stringBuilder.toString();
        AppMethodBeat.m2505o(68876);
        return str3;
    }

    protected static Object zzbm(String str) {
        AppMethodBeat.m2504i(68871);
        if (str == null) {
            AppMethodBeat.m2505o(68871);
            return null;
        }
        zzfj zzfj = new zzfj(str);
        AppMethodBeat.m2505o(68871);
        return zzfj;
    }

    private static String zzbn(String str) {
        AppMethodBeat.m2504i(68878);
        if (TextUtils.isEmpty(str)) {
            str = "";
            AppMethodBeat.m2505o(68878);
            return str;
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf == -1) {
            AppMethodBeat.m2505o(68878);
            return str;
        }
        str = str.substring(0, lastIndexOf);
        AppMethodBeat.m2505o(68878);
        return str;
    }

    private final String zziu() {
        String str;
        AppMethodBeat.m2504i(68875);
        synchronized (this) {
            try {
                if (this.zzain == null) {
                    this.zzain = (String) zzew.zzagi.get();
                }
                str = this.zzain;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(68875);
            }
        }
        return str;
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        AppMethodBeat.m2504i(68890);
        Context context = super.getContext();
        AppMethodBeat.m2505o(68890);
        return context;
    }

    /* Access modifiers changed, original: protected|final */
    @VisibleForTesting
    public final boolean isLoggable(int i) {
        AppMethodBeat.m2504i(68873);
        boolean isLoggable = Log.isLoggable(zziu(), i);
        AppMethodBeat.m2505o(68873);
        return isLoggable;
    }

    /* Access modifiers changed, original: protected|final */
    @VisibleForTesting
    public final void zza(int i, String str) {
        AppMethodBeat.m2504i(68874);
        Log.println(i, zziu(), str);
        AppMethodBeat.m2505o(68874);
    }

    /* Access modifiers changed, original: protected|final */
    public final void zza(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        AppMethodBeat.m2504i(68872);
        if (!z && isLoggable(i)) {
            zza(i, zza(false, str, obj, obj2, obj3));
        }
        if (!z2 && i >= 5) {
            Preconditions.checkNotNull(str);
            zzgg zzjq = this.zzacw.zzjq();
            if (zzjq == null) {
                zza(6, "Scheduler not set. Not logging error/warn");
                AppMethodBeat.m2505o(68872);
                return;
            } else if (zzjq.isInitialized()) {
                int i2 = i < 0 ? 0 : i;
                if (i2 >= 9) {
                    i2 = 8;
                }
                zzjq.zzc(new zzfh(this, i2, str, obj, obj2, obj3));
            } else {
                zza(6, "Scheduler not initialized. Not logging error/warn");
                AppMethodBeat.m2505o(68872);
                return;
            }
        }
        AppMethodBeat.m2505o(68872);
    }

    public final /* bridge */ /* synthetic */ void zzab() {
        AppMethodBeat.m2504i(68882);
        super.zzab();
        AppMethodBeat.m2505o(68882);
    }

    public final /* bridge */ /* synthetic */ Clock zzbt() {
        AppMethodBeat.m2504i(68889);
        Clock zzbt = super.zzbt();
        AppMethodBeat.m2505o(68889);
        return zzbt;
    }

    public final /* bridge */ /* synthetic */ void zzfr() {
        AppMethodBeat.m2504i(68880);
        super.zzfr();
        AppMethodBeat.m2505o(68880);
    }

    public final /* bridge */ /* synthetic */ void zzfs() {
        AppMethodBeat.m2504i(68881);
        super.zzfs();
        AppMethodBeat.m2505o(68881);
    }

    public final /* bridge */ /* synthetic */ zzdu zzft() {
        AppMethodBeat.m2504i(68883);
        zzdu zzft = super.zzft();
        AppMethodBeat.m2505o(68883);
        return zzft;
    }

    public final /* bridge */ /* synthetic */ zzhk zzfu() {
        AppMethodBeat.m2504i(68884);
        zzhk zzfu = super.zzfu();
        AppMethodBeat.m2505o(68884);
        return zzfu;
    }

    public final /* bridge */ /* synthetic */ zzfb zzfv() {
        AppMethodBeat.m2504i(68885);
        zzfb zzfv = super.zzfv();
        AppMethodBeat.m2505o(68885);
        return zzfv;
    }

    public final /* bridge */ /* synthetic */ zzeo zzfw() {
        AppMethodBeat.m2504i(68886);
        zzeo zzfw = super.zzfw();
        AppMethodBeat.m2505o(68886);
        return zzfw;
    }

    public final /* bridge */ /* synthetic */ zzii zzfx() {
        AppMethodBeat.m2504i(68887);
        zzii zzfx = super.zzfx();
        AppMethodBeat.m2505o(68887);
        return zzfx;
    }

    public final /* bridge */ /* synthetic */ zzif zzfy() {
        AppMethodBeat.m2504i(68888);
        zzif zzfy = super.zzfy();
        AppMethodBeat.m2505o(68888);
        return zzfy;
    }

    public final /* bridge */ /* synthetic */ zzfc zzfz() {
        AppMethodBeat.m2504i(68891);
        zzfc zzfz = super.zzfz();
        AppMethodBeat.m2505o(68891);
        return zzfz;
    }

    public final /* bridge */ /* synthetic */ zzfe zzga() {
        AppMethodBeat.m2504i(68892);
        zzfe zzga = super.zzga();
        AppMethodBeat.m2505o(68892);
        return zzga;
    }

    public final /* bridge */ /* synthetic */ zzka zzgb() {
        AppMethodBeat.m2504i(68893);
        zzka zzgb = super.zzgb();
        AppMethodBeat.m2505o(68893);
        return zzgb;
    }

    public final /* bridge */ /* synthetic */ zzjh zzgc() {
        AppMethodBeat.m2504i(68894);
        zzjh zzgc = super.zzgc();
        AppMethodBeat.m2505o(68894);
        return zzgc;
    }

    public final /* bridge */ /* synthetic */ zzgg zzgd() {
        AppMethodBeat.m2504i(68895);
        zzgg zzgd = super.zzgd();
        AppMethodBeat.m2505o(68895);
        return zzgd;
    }

    public final /* bridge */ /* synthetic */ zzfg zzge() {
        AppMethodBeat.m2504i(68896);
        zzfg zzge = super.zzge();
        AppMethodBeat.m2505o(68896);
        return zzge;
    }

    public final /* bridge */ /* synthetic */ zzfr zzgf() {
        AppMethodBeat.m2504i(68897);
        zzfr zzgf = super.zzgf();
        AppMethodBeat.m2505o(68897);
        return zzgf;
    }

    public final /* bridge */ /* synthetic */ zzef zzgg() {
        AppMethodBeat.m2504i(68898);
        zzef zzgg = super.zzgg();
        AppMethodBeat.m2505o(68898);
        return zzgg;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean zzhf() {
        return false;
    }

    public final zzfi zzim() {
        return this.zzaio;
    }

    public final zzfi zzin() {
        return this.zzaip;
    }

    public final zzfi zzio() {
        return this.zzaiq;
    }

    public final zzfi zzip() {
        return this.zzair;
    }

    public final zzfi zziq() {
        return this.zzait;
    }

    public final zzfi zzir() {
        return this.zzaiu;
    }

    public final zzfi zzis() {
        return this.zzaiv;
    }

    public final zzfi zzit() {
        return this.zzaiw;
    }

    public final String zziv() {
        AppMethodBeat.m2504i(68879);
        Pair zzfi = zzgf().zzajt.zzfi();
        if (zzfi == null || zzfi == zzfr.zzajs) {
            AppMethodBeat.m2505o(68879);
            return null;
        }
        String valueOf = String.valueOf(zzfi.second);
        String str = (String) zzfi.first;
        str = new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(str).length()).append(valueOf).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(str).toString();
        AppMethodBeat.m2505o(68879);
        return str;
    }
}
