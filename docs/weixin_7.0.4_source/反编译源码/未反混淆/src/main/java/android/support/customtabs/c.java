package android.support.customtabs;

import android.os.IBinder;

public final class c {
    private final d kI;
    private final a kJ = new a() {
    };

    c(d dVar) {
        this.kI = dVar;
    }

    /* Access modifiers changed, original: final */
    public final IBinder bq() {
        return this.kI.asBinder();
    }

    public final int hashCode() {
        return bq().hashCode();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof c) {
            return ((c) obj).bq().equals(this.kI.asBinder());
        }
        return false;
    }
}
