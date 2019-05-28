package android.support.v7.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.view.b;
import android.support.v7.view.b.a;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.R;

public class i extends Dialog implements c {
    private d mDelegate;

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        getDelegate().fk();
        super.onCreate(bundle);
        getDelegate().onCreate(bundle);
    }

    public void setContentView(int i) {
        getDelegate().setContentView(i);
    }

    public void setContentView(View view) {
        getDelegate().setContentView(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        getDelegate().setContentView(view, layoutParams);
    }

    public <T extends View> T findViewById(int i) {
        return getDelegate().findViewById(i);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        getDelegate().setTitle(charSequence);
    }

    public void setTitle(int i) {
        super.setTitle(i);
        getDelegate().setTitle(getContext().getString(i));
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        getDelegate().addContentView(view, layoutParams);
    }

    /* Access modifiers changed, original: protected */
    public void onStop() {
        super.onStop();
        getDelegate().onStop();
    }

    public final boolean fA() {
        return getDelegate().requestWindowFeature(1);
    }

    public void invalidateOptionsMenu() {
        getDelegate().invalidateOptionsMenu();
    }

    private d getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = d.a((Dialog) this, (c) this);
        }
        return this.mDelegate;
    }

    public void onSupportActionModeStarted(b bVar) {
    }

    public void onSupportActionModeFinished(b bVar) {
    }

    public b onWindowStartingSupportActionMode(a aVar) {
        return null;
    }

    public i(Context context, int i) {
        if (i == 0) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.eh, typedValue, true);
            i = typedValue.resourceId;
        }
        super(context, i);
        getDelegate().onCreate(null);
        getDelegate().fl();
    }
}
