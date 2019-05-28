package com.samsung.android.sdk.look;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.View.OnHoverListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SlookPointerIcon {
    private static final String TAG = "SlookPointerIcon";
    private Drawable mDrawable;
    private Slook mSlook = new Slook();

    public SlookPointerIcon() {
        AppMethodBeat.i(117272);
        AppMethodBeat.o(117272);
    }

    public void setHoverIcon(View view, Drawable drawable) {
        AppMethodBeat.i(117273);
        if (!isSupport(1)) {
            AppMethodBeat.o(117273);
        } else if (view == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("view is null.");
            AppMethodBeat.o(117273);
            throw illegalArgumentException;
        } else if (drawable == null) {
            view.setOnHoverListener(null);
            try {
                PointerIcon.setHoveringSpenIcon(1, -1);
                AppMethodBeat.o(117273);
            } catch (RemoteException e) {
                AppMethodBeat.o(117273);
            }
        } else {
            this.mDrawable = drawable;
            view.setOnHoverListener(new OnHoverListener() {
                public boolean onHover(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(117192);
                    switch (motionEvent.getAction()) {
                        case 9:
                            try {
                                PointerIcon.setHoveringSpenIcon(0, SlookPointerIcon.this.mDrawable);
                                break;
                            } catch (RemoteException e) {
                                break;
                            }
                        case 10:
                            try {
                                PointerIcon.setHoveringSpenIcon(1, -1);
                                break;
                            } catch (RemoteException e2) {
                                break;
                            }
                    }
                    AppMethodBeat.o(117192);
                    return false;
                }
            });
            AppMethodBeat.o(117273);
        }
    }

    private boolean isSupport(int i) {
        AppMethodBeat.i(117274);
        if (this.mSlook.isFeatureEnabled(4)) {
            AppMethodBeat.o(117274);
            return true;
        }
        AppMethodBeat.o(117274);
        return false;
    }
}
