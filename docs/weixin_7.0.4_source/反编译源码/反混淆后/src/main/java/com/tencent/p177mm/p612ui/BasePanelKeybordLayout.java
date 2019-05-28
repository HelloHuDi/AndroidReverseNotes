package com.tencent.p177mm.p612ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.p177mm.compatible.util.C18175j;
import com.tencent.p177mm.sdk.platformtools.C40619x;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.List;

/* renamed from: com.tencent.mm.ui.BasePanelKeybordLayout */
public abstract class BasePanelKeybordLayout extends KeyboardLinearLayout {
    private int voj = -1;
    private C5172a yfw = null;

    /* renamed from: com.tencent.mm.ui.BasePanelKeybordLayout$a */
    public interface C5172a {
    }

    public abstract List<View> getPanelView();

    public BasePanelKeybordLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BasePanelKeybordLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setOnMeasureListener(C5172a c5172a) {
        this.yfw = c5172a;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        C4990ab.m7411d("MicroMsg.BasePanelKeybordLayout", "onMeasure, width: %d, height: %d", Integer.valueOf(size), Integer.valueOf(size2));
        if (size2 >= 0) {
            if (this.voj < 0) {
                this.voj = size2;
            } else {
                int i3 = this.voj - size2;
                this.voj = size2;
                if (i3 != 0) {
                    List<View> panelView = getPanelView();
                    if (panelView != null) {
                        for (View view : panelView) {
                            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                            if (layoutParams == null) {
                                break;
                            }
                            int i4 = layoutParams.height < 0 ? 0 : layoutParams.height - i3;
                            if (i4 < 0) {
                                i4 = 0;
                            }
                            int gq = C40619x.m70071gq(C4996ah.getContext());
                            int gs = C40619x.m70073gs(getContext());
                            if (C18175j.m28617Mv() > 0 && size2 >= C18175j.m28617Mv()) {
                                i4 = gs;
                            }
                            if (i4 > 0 && i4 < gq && view.getVisibility() != 0) {
                                i4 = 0;
                            }
                            if (i4 > gs) {
                                i4 = gs;
                            }
                            if (i4 > 0 && i4 < gs) {
                                i4 = gs;
                            }
                            C4990ab.m7411d("MicroMsg.BasePanelKeybordLayout", "oldHeight: %d, offset: %d newHeight: %d, validPanelHeight: %d", Integer.valueOf(layoutParams.height), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(gs));
                            layoutParams.height = i4;
                            view.setLayoutParams(layoutParams);
                        }
                    }
                }
            }
        }
        super.onMeasure(i, i2);
    }
}
