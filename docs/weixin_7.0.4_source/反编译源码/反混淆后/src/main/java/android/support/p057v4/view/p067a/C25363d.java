package android.support.p057v4.view.p067a;

import android.view.accessibility.AccessibilityRecord;

/* renamed from: android.support.v4.view.a.d */
public final class C25363d {
    /* renamed from: Oq */
    private final AccessibilityRecord f5195Oq;

    @Deprecated
    private C25363d(Object obj) {
        this.f5195Oq = (AccessibilityRecord) obj;
    }

    @Deprecated
    /* renamed from: eu */
    public static C25363d m40021eu() {
        return new C25363d(AccessibilityRecord.obtain());
    }

    @Deprecated
    public final void setScrollable(boolean z) {
        this.f5195Oq.setScrollable(z);
    }

    @Deprecated
    public final void setItemCount(int i) {
        this.f5195Oq.setItemCount(i);
    }

    @Deprecated
    public final void setFromIndex(int i) {
        this.f5195Oq.setFromIndex(i);
    }

    @Deprecated
    public final void setToIndex(int i) {
        this.f5195Oq.setToIndex(i);
    }

    @Deprecated
    public final int hashCode() {
        return this.f5195Oq == null ? 0 : this.f5195Oq.hashCode();
    }

    @Deprecated
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        C25363d c25363d = (C25363d) obj;
        if (this.f5195Oq == null) {
            if (c25363d.f5195Oq != null) {
                return false;
            }
            return true;
        } else if (this.f5195Oq.equals(c25363d.f5195Oq)) {
            return true;
        } else {
            return false;
        }
    }
}
