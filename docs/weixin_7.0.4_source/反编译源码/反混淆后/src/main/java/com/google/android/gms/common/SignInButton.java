package com.google.android.gms.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.google.android.gms.base.C25568R;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.SignInButtonCreator;
import com.google.android.gms.common.internal.SignInButtonImpl;
import com.google.android.gms.dynamic.RemoteCreator.RemoteCreatorException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class SignInButton extends FrameLayout implements OnClickListener {
    public static final int COLOR_AUTO = 2;
    public static final int COLOR_DARK = 0;
    public static final int COLOR_LIGHT = 1;
    public static final int SIZE_ICON_ONLY = 2;
    public static final int SIZE_STANDARD = 0;
    public static final int SIZE_WIDE = 1;
    private int mColor;
    private int mSize;
    private View zzbw;
    private OnClickListener zzbx;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ButtonSize {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ColorScheme {
    }

    public SignInButton(Context context) {
        this(context, null);
    }

    public SignInButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SignInButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(60463);
        this.zzbx = null;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C25568R.styleable.SignInButton, 0, 0);
        try {
            this.mSize = obtainStyledAttributes.getInt(0, 0);
            this.mColor = obtainStyledAttributes.getInt(1, 2);
            obtainStyledAttributes.recycle();
            setStyle(this.mSize, this.mColor);
            AppMethodBeat.m2505o(60463);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            AppMethodBeat.m2505o(60463);
        }
    }

    public final void onClick(View view) {
        AppMethodBeat.m2504i(60471);
        if (this.zzbx != null && view == this.zzbw) {
            this.zzbx.onClick(this);
        }
        AppMethodBeat.m2505o(60471);
    }

    public final void setColorScheme(int i) {
        AppMethodBeat.m2504i(60465);
        setStyle(this.mSize, i);
        AppMethodBeat.m2505o(60465);
    }

    public final void setEnabled(boolean z) {
        AppMethodBeat.m2504i(60470);
        super.setEnabled(z);
        this.zzbw.setEnabled(z);
        AppMethodBeat.m2505o(60470);
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(60469);
        this.zzbx = onClickListener;
        if (this.zzbw != null) {
            this.zzbw.setOnClickListener(this);
        }
        AppMethodBeat.m2505o(60469);
    }

    @Deprecated
    public final void setScopes(Scope[] scopeArr) {
        AppMethodBeat.m2504i(60466);
        setStyle(this.mSize, this.mColor);
        AppMethodBeat.m2505o(60466);
    }

    public final void setSize(int i) {
        AppMethodBeat.m2504i(60464);
        setStyle(i, this.mColor);
        AppMethodBeat.m2505o(60464);
    }

    public final void setStyle(int i, int i2) {
        AppMethodBeat.m2504i(60467);
        this.mSize = i;
        this.mColor = i2;
        Context context = getContext();
        if (this.zzbw != null) {
            removeView(this.zzbw);
        }
        try {
            this.zzbw = SignInButtonCreator.createView(context, this.mSize, this.mColor);
        } catch (RemoteCreatorException e) {
            int i3 = this.mSize;
            int i4 = this.mColor;
            SignInButtonImpl signInButtonImpl = new SignInButtonImpl(context);
            signInButtonImpl.configure(context.getResources(), i3, i4);
            this.zzbw = signInButtonImpl;
        }
        addView(this.zzbw);
        this.zzbw.setEnabled(isEnabled());
        this.zzbw.setOnClickListener(this);
        AppMethodBeat.m2505o(60467);
    }

    @Deprecated
    public final void setStyle(int i, int i2, Scope[] scopeArr) {
        AppMethodBeat.m2504i(60468);
        setStyle(i, i2);
        AppMethodBeat.m2505o(60468);
    }
}
