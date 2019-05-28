package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.a.a.a;
import android.util.AttributeSet;
import android.widget.Button;
import com.google.android.gms.common.util.DeviceProperties;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class SignInButtonImpl extends Button {
    public SignInButtonImpl(Context context) {
        this(context, null);
    }

    public SignInButtonImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 16842824);
    }

    private static int zza(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(61385);
        switch (i) {
            case 0:
                AppMethodBeat.o(61385);
                return i2;
            case 1:
                AppMethodBeat.o(61385);
                return i3;
            case 2:
                AppMethodBeat.o(61385);
                return i4;
            default:
                IllegalStateException illegalStateException = new IllegalStateException("Unknown color scheme: " + i);
                AppMethodBeat.o(61385);
                throw illegalStateException;
        }
    }

    public final void configure(Resources resources, int i, int i2) {
        IllegalStateException illegalStateException;
        AppMethodBeat.i(61384);
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        float f = resources.getDisplayMetrics().density;
        setMinHeight((int) ((f * 48.0f) + 0.5f));
        setMinWidth((int) ((f * 48.0f) + 0.5f));
        int zza = zza(i2, R.drawable.k8, R.drawable.kb, R.drawable.kb);
        int zza2 = zza(i2, R.drawable.ke, R.drawable.ki, R.drawable.ki);
        switch (i) {
            case 0:
            case 1:
                break;
            case 2:
                zza2 = zza;
                break;
            default:
                illegalStateException = new IllegalStateException("Unknown button size: " + i);
                AppMethodBeat.o(61384);
                throw illegalStateException;
        }
        Drawable f2 = a.f(resources.getDrawable(zza2));
        a.a(f2, resources.getColorStateList(R.color.a79));
        a.a(f2, Mode.SRC_ATOP);
        setBackgroundDrawable(f2);
        setTextColor((ColorStateList) Preconditions.checkNotNull(resources.getColorStateList(zza(i2, R.color.a77, R.color.a78, R.color.a78))));
        switch (i) {
            case 0:
                setText(resources.getString(R.string.common_signin_button_text));
                break;
            case 1:
                setText(resources.getString(R.string.common_signin_button_text_long));
                break;
            case 2:
                setText(null);
                break;
            default:
                illegalStateException = new IllegalStateException("Unknown button size: " + i);
                AppMethodBeat.o(61384);
                throw illegalStateException;
        }
        setTransformationMethod(null);
        if (DeviceProperties.isWearable(getContext())) {
            setGravity(19);
        }
        AppMethodBeat.o(61384);
    }

    public final void configure(Resources resources, SignInButtonConfig signInButtonConfig) {
        AppMethodBeat.i(61383);
        configure(resources, signInButtonConfig.getButtonSize(), signInButtonConfig.getColorScheme());
        AppMethodBeat.o(61383);
    }
}
