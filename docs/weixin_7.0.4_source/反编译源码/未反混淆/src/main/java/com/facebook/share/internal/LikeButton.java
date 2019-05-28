package com.facebook.share.internal;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.FacebookButtonBase;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

@Deprecated
public class LikeButton extends FacebookButtonBase {
    @Deprecated
    public LikeButton(Context context, boolean z) {
        super(context, null, 0, 0, AnalyticsEvents.EVENT_LIKE_BUTTON_CREATE, AnalyticsEvents.EVENT_LIKE_BUTTON_DID_TAP);
        AppMethodBeat.i(97084);
        setSelected(z);
        AppMethodBeat.o(97084);
    }

    @Deprecated
    public void setSelected(boolean z) {
        AppMethodBeat.i(97085);
        super.setSelected(z);
        updateForLikeStatus();
        AppMethodBeat.o(97085);
    }

    public void configureButton(Context context, AttributeSet attributeSet, int i, int i2) {
        AppMethodBeat.i(97086);
        super.configureButton(context, attributeSet, i, i2);
        updateForLikeStatus();
        AppMethodBeat.o(97086);
    }

    public int getDefaultRequestCode() {
        return 0;
    }

    public int getDefaultStyleResource() {
        return R.style.za;
    }

    private void updateForLikeStatus() {
        AppMethodBeat.i(97087);
        if (isSelected()) {
            setCompoundDrawablesWithIntrinsicBounds(R.drawable.a_9, 0, 0, 0);
            setText(getResources().getString(R.string.y));
            AppMethodBeat.o(97087);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(R.drawable.jy, 0, 0, 0);
        setText(getResources().getString(R.string.z));
        AppMethodBeat.o(97087);
    }
}
