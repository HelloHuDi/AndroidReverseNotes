package android.support.p069v7.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.p069v7.view.C0604b;
import android.support.p069v7.view.C0604b.C0603a;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.p177mm.C25738R;

/* renamed from: android.support.v7.app.i */
public class C6218i extends Dialog implements C0575c {
    private C0576d mDelegate;

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        getDelegate().mo1400fk();
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

    /* renamed from: fA */
    public final boolean mo14042fA() {
        return getDelegate().requestWindowFeature(1);
    }

    public void invalidateOptionsMenu() {
        getDelegate().invalidateOptionsMenu();
    }

    private C0576d getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = C0576d.m1254a((Dialog) this, (C0575c) this);
        }
        return this.mDelegate;
    }

    public void onSupportActionModeStarted(C0604b c0604b) {
    }

    public void onSupportActionModeFinished(C0604b c0604b) {
    }

    public C0604b onWindowStartingSupportActionMode(C0603a c0603a) {
        return null;
    }

    public C6218i(Context context, int i) {
        if (i == 0) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(C25738R.attr.f5639eh, typedValue, true);
            i = typedValue.resourceId;
        }
        super(context, i);
        getDelegate().onCreate(null);
        getDelegate().mo1401fl();
    }
}
