package android.support.transition;

import android.os.IBinder;

final class bc implements be {
    private final IBinder BN;

    bc(IBinder iBinder) {
        this.BN = iBinder;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof bc) && ((bc) obj).BN.equals(this.BN);
    }

    public final int hashCode() {
        return this.BN.hashCode();
    }
}
