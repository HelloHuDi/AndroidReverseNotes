package android.support.v7.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.widget.n;
import android.support.v7.a.a.a;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;

class AppCompatPopupWindow extends PopupWindow {
    private static final boolean afO = (VERSION.SDK_INT < 21);
    private boolean afP;

    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet, i, 0);
    }

    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(context, attributeSet, i, i2);
    }

    private void a(Context context, AttributeSet attributeSet, int i, int i2) {
        bc a = bc.a(context, attributeSet, a.PopupWindow, i, i2);
        if (a.hasValue(2)) {
            aa(a.getBoolean(2, false));
        }
        setBackgroundDrawable(a.getDrawable(0));
        a.atG.recycle();
    }

    public void showAsDropDown(View view, int i, int i2) {
        if (afO && this.afP) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (afO && this.afP) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }

    public void update(View view, int i, int i2, int i3, int i4) {
        int height;
        if (afO && this.afP) {
            height = i2 - view.getHeight();
        } else {
            height = i2;
        }
        super.update(view, i, height, i3, i4);
    }

    private void aa(boolean z) {
        if (afO) {
            this.afP = z;
        } else {
            n.a((PopupWindow) this, z);
        }
    }
}
