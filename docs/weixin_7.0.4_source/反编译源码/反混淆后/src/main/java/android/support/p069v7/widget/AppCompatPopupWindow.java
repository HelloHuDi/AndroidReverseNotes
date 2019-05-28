package android.support.p069v7.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.p057v4.widget.C0535n;
import android.support.p069v7.p070a.C0555a.C0554a;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;

/* renamed from: android.support.v7.widget.AppCompatPopupWindow */
class AppCompatPopupWindow extends PopupWindow {
    private static final boolean afO = (VERSION.SDK_INT < 21);
    private boolean afP;

    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m1369a(context, attributeSet, i, 0);
    }

    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m1369a(context, attributeSet, i, i2);
    }

    /* renamed from: a */
    private void m1369a(Context context, AttributeSet attributeSet, int i, int i2) {
        C0699bc a = C0699bc.m1555a(context, attributeSet, C0554a.PopupWindow, i, i2);
        if (a.hasValue(2)) {
            m1370aa(a.getBoolean(2, false));
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

    /* renamed from: aa */
    private void m1370aa(boolean z) {
        if (afO) {
            this.afP = z;
        } else {
            C0535n.m1159a((PopupWindow) this, z);
        }
    }
}
