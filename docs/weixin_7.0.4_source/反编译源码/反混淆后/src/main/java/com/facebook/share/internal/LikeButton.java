package com.facebook.share.internal;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.FacebookButtonBase;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;

@Deprecated
public class LikeButton extends FacebookButtonBase {
    @Deprecated
    public LikeButton(Context context, boolean z) {
        super(context, null, 0, 0, AnalyticsEvents.EVENT_LIKE_BUTTON_CREATE, AnalyticsEvents.EVENT_LIKE_BUTTON_DID_TAP);
        AppMethodBeat.m2504i(97084);
        setSelected(z);
        AppMethodBeat.m2505o(97084);
    }

    @Deprecated
    public void setSelected(boolean z) {
        AppMethodBeat.m2504i(97085);
        super.setSelected(z);
        updateForLikeStatus();
        AppMethodBeat.m2505o(97085);
    }

    public void configureButton(Context context, AttributeSet attributeSet, int i, int i2) {
        AppMethodBeat.m2504i(97086);
        super.configureButton(context, attributeSet, i, i2);
        updateForLikeStatus();
        AppMethodBeat.m2505o(97086);
    }

    public int getDefaultRequestCode() {
        return 0;
    }

    public int getDefaultStyleResource() {
        return C25738R.style.f11400za;
    }

    private void updateForLikeStatus() {
        AppMethodBeat.m2504i(97087);
        if (isSelected()) {
            setCompoundDrawablesWithIntrinsicBounds(C25738R.drawable.a_9, 0, 0, 0);
            setText(getResources().getString(C25738R.string.f8617y));
            AppMethodBeat.m2505o(97087);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(C25738R.drawable.f6616jy, 0, 0, 0);
        setText(getResources().getString(C25738R.string.f8618z));
        AppMethodBeat.m2505o(97087);
    }
}
