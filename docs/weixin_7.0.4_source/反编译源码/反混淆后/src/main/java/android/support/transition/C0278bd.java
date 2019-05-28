package android.support.transition;

import android.view.View;
import android.view.WindowId;

/* renamed from: android.support.transition.bd */
final class C0278bd implements C8373be {
    /* renamed from: BO */
    private final WindowId f192BO;

    C0278bd(View view) {
        this.f192BO = view.getWindowId();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof C0278bd) && ((C0278bd) obj).f192BO.equals(this.f192BO);
    }

    public final int hashCode() {
        return this.f192BO.hashCode();
    }
}
