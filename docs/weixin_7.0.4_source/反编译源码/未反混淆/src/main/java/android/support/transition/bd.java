package android.support.transition;

import android.view.View;
import android.view.WindowId;

final class bd implements be {
    private final WindowId BO;

    bd(View view) {
        this.BO = view.getWindowId();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof bd) && ((bd) obj).BO.equals(this.BO);
    }

    public final int hashCode() {
        return this.BO.hashCode();
    }
}
