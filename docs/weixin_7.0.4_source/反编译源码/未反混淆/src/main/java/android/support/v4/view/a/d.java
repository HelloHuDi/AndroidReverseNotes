package android.support.v4.view.a;

import android.view.accessibility.AccessibilityRecord;

public final class d {
    private final AccessibilityRecord Oq;

    @Deprecated
    private d(Object obj) {
        this.Oq = (AccessibilityRecord) obj;
    }

    @Deprecated
    public static d eu() {
        return new d(AccessibilityRecord.obtain());
    }

    @Deprecated
    public final void setScrollable(boolean z) {
        this.Oq.setScrollable(z);
    }

    @Deprecated
    public final void setItemCount(int i) {
        this.Oq.setItemCount(i);
    }

    @Deprecated
    public final void setFromIndex(int i) {
        this.Oq.setFromIndex(i);
    }

    @Deprecated
    public final void setToIndex(int i) {
        this.Oq.setToIndex(i);
    }

    @Deprecated
    public final int hashCode() {
        return this.Oq == null ? 0 : this.Oq.hashCode();
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
        d dVar = (d) obj;
        if (this.Oq == null) {
            if (dVar.Oq != null) {
                return false;
            }
            return true;
        } else if (this.Oq.equals(dVar.Oq)) {
            return true;
        } else {
            return false;
        }
    }
}
