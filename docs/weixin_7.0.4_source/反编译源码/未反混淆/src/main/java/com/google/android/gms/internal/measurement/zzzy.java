package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class zzzy {
    private static final zzzi zzbsw = zzzi.zzte();
    private zzyw zzbsx;
    private volatile zzaal zzbsy;
    private volatile zzyw zzbsz;

    static {
        AppMethodBeat.i(3602);
        AppMethodBeat.o(3602);
    }

    private final zzaal zzb(zzaal zzaal) {
        if (this.zzbsy == null) {
            synchronized (this) {
                if (this.zzbsy != null) {
                } else {
                    try {
                        this.zzbsy = zzaal;
                        this.zzbsz = zzyw.zzbqx;
                    } catch (zzzt e) {
                        this.zzbsy = zzaal;
                        this.zzbsz = zzyw.zzbqx;
                    }
                }
            }
        }
        return this.zzbsy;
    }

    private final zzyw zztp() {
        zzyw zzyw;
        AppMethodBeat.i(3601);
        if (this.zzbsz != null) {
            zzyw = this.zzbsz;
            AppMethodBeat.o(3601);
            return zzyw;
        }
        synchronized (this) {
            try {
                if (this.zzbsz != null) {
                    zzyw = this.zzbsz;
                } else {
                    if (this.zzbsy == null) {
                        this.zzbsz = zzyw.zzbqx;
                    } else {
                        this.zzbsz = this.zzbsy.zztp();
                    }
                    zzyw = this.zzbsz;
                    AppMethodBeat.o(3601);
                    return zzyw;
                }
            } finally {
                AppMethodBeat.o(3601);
            }
        }
        return zzyw;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(3600);
        if (this == obj) {
            AppMethodBeat.o(3600);
            return true;
        } else if (obj instanceof zzzy) {
            zzzy zzzy = (zzzy) obj;
            zzaal zzaal = this.zzbsy;
            zzaal zzaal2 = zzzy.zzbsy;
            boolean equals;
            if (zzaal == null && zzaal2 == null) {
                equals = zztp().equals(zzzy.zztp());
                AppMethodBeat.o(3600);
                return equals;
            } else if (zzaal != null && zzaal2 != null) {
                equals = zzaal.equals(zzaal2);
                AppMethodBeat.o(3600);
                return equals;
            } else if (zzaal != null) {
                equals = zzaal.equals(zzzy.zzb(zzaal.zztz()));
                AppMethodBeat.o(3600);
                return equals;
            } else {
                equals = zzb(zzaal2.zztz()).equals(zzaal2);
                AppMethodBeat.o(3600);
                return equals;
            }
        } else {
            AppMethodBeat.o(3600);
            return false;
        }
    }

    public int hashCode() {
        return 1;
    }

    public final zzaal zzc(zzaal zzaal) {
        zzaal zzaal2 = this.zzbsy;
        this.zzbsx = null;
        this.zzbsz = null;
        this.zzbsy = zzaal;
        return zzaal2;
    }
}
