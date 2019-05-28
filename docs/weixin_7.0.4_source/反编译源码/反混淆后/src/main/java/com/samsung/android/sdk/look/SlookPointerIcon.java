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

    /* renamed from: com.samsung.android.sdk.look.SlookPointerIcon$1 */
    class C177181 implements OnHoverListener {
        C177181() {
        }

        public boolean onHover(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(117192);
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
            AppMethodBeat.m2505o(117192);
            return false;
        }
    }

    public SlookPointerIcon() {
        AppMethodBeat.m2504i(117272);
        AppMethodBeat.m2505o(117272);
    }

    public void setHoverIcon(View view, Drawable drawable) {
        AppMethodBeat.m2504i(117273);
        if (!isSupport(1)) {
            AppMethodBeat.m2505o(117273);
        } else if (view == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("view is null.");
            AppMethodBeat.m2505o(117273);
            throw illegalArgumentException;
        } else if (drawable == null) {
            view.setOnHoverListener(null);
            try {
                PointerIcon.setHoveringSpenIcon(1, -1);
                AppMethodBeat.m2505o(117273);
            } catch (RemoteException e) {
                AppMethodBeat.m2505o(117273);
            }
        } else {
            this.mDrawable = drawable;
            view.setOnHoverListener(new C177181());
            AppMethodBeat.m2505o(117273);
        }
    }

    private boolean isSupport(int i) {
        AppMethodBeat.m2504i(117274);
        if (this.mSlook.isFeatureEnabled(4)) {
            AppMethodBeat.m2505o(117274);
            return true;
        }
        AppMethodBeat.m2505o(117274);
        return false;
    }
}
