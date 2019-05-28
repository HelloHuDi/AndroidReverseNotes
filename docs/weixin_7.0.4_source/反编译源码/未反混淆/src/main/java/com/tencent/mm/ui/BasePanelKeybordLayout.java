package com.tencent.mm.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public abstract class BasePanelKeybordLayout extends KeyboardLinearLayout {
    private int voj = -1;
    private a yfw = null;

    public interface a {
    }

    public abstract List<View> getPanelView();

    public BasePanelKeybordLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BasePanelKeybordLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setOnMeasureListener(a aVar) {
        this.yfw = aVar;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        ab.d("MicroMsg.BasePanelKeybordLayout", "onMeasure, width: %d, height: %d", Integer.valueOf(size), Integer.valueOf(size2));
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
                            int gq = x.gq(ah.getContext());
                            int gs = x.gs(getContext());
                            if (j.Mv() > 0 && size2 >= j.Mv()) {
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
                            ab.d("MicroMsg.BasePanelKeybordLayout", "oldHeight: %d, offset: %d newHeight: %d, validPanelHeight: %d", Integer.valueOf(layoutParams.height), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(gs));
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
