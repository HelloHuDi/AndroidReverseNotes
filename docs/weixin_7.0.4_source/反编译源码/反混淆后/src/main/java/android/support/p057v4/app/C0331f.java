package android.support.p057v4.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

/* renamed from: android.support.v4.app.f */
public abstract class C0331f {
    public abstract View onFindViewById(int i);

    public abstract boolean onHasView();

    public Fragment instantiate(Context context, String str, Bundle bundle) {
        return Fragment.instantiate(context, str, bundle);
    }
}
