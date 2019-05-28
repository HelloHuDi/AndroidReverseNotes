package android.support.transition;

import android.os.IBinder;

/* renamed from: android.support.transition.bc */
final class C16503bc implements C8373be {
    /* renamed from: BN */
    private final IBinder f3507BN;

    C16503bc(IBinder iBinder) {
        this.f3507BN = iBinder;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof C16503bc) && ((C16503bc) obj).f3507BN.equals(this.f3507BN);
    }

    public final int hashCode() {
        return this.f3507BN.hashCode();
    }
}
