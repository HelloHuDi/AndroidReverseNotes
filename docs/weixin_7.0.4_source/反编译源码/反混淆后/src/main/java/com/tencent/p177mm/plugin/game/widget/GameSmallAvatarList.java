package com.tencent.p177mm.plugin.game.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.game.p428f.C28203e;
import com.tencent.p177mm.plugin.game.p428f.C28203e.C28207a.C12125a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.game.widget.GameSmallAvatarList */
public class GameSmallAvatarList extends LinearLayout {
    public GameSmallAvatarList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setData(LinkedList<String> linkedList) {
        AppMethodBeat.m2504i(112410);
        if (C5046bo.m7548ek(linkedList)) {
            setVisibility(8);
            AppMethodBeat.m2505o(112410);
            return;
        }
        setVisibility(0);
        while (getChildCount() < linkedList.size()) {
            ImageView imageView = new ImageView(getContext());
            LayoutParams layoutParams = new LayoutParams(getResources().getDimensionPixelSize(C25738R.dimen.f9919k6), getResources().getDimensionPixelSize(C25738R.dimen.f9919k6));
            layoutParams.setMargins(0, 0, getResources().getDimensionPixelSize(C25738R.dimen.f9915k1), 0);
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ScaleType.FIT_XY);
            addView(imageView);
        }
        int i = 0;
        while (i < linkedList.size()) {
            C12125a c12125a = new C12125a();
            c12125a.eQf = true;
            C28203e.bFH().mo46098a((ImageView) getChildAt(i), (String) linkedList.get(i), c12125a.bFI());
            getChildAt(i).setVisibility(0);
            i++;
        }
        while (i < getChildCount()) {
            int i2 = i + 1;
            getChildAt(i).setVisibility(8);
            i = i2;
        }
        AppMethodBeat.m2505o(112410);
    }
}
