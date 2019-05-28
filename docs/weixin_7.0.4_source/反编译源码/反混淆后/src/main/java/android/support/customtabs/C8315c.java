package android.support.customtabs;

import android.os.IBinder;

/* renamed from: android.support.customtabs.c */
public final class C8315c {
    /* renamed from: kI */
    private final C25293d f2157kI;
    /* renamed from: kJ */
    private final C41481a f2158kJ = new C83161();

    /* renamed from: android.support.customtabs.c$1 */
    class C83161 extends C41481a {
        C83161() {
        }
    }

    C8315c(C25293d c25293d) {
        this.f2157kI = c25293d;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: bq */
    public final IBinder mo18101bq() {
        return this.f2157kI.asBinder();
    }

    public final int hashCode() {
        return mo18101bq().hashCode();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C8315c) {
            return ((C8315c) obj).mo18101bq().equals(this.f2157kI.asBinder());
        }
        return false;
    }
}
