package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.f.e.a.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public class GameSmallAvatarList extends LinearLayout {
    public GameSmallAvatarList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setData(LinkedList<String> linkedList) {
        AppMethodBeat.i(112410);
        if (bo.ek(linkedList)) {
            setVisibility(8);
            AppMethodBeat.o(112410);
            return;
        }
        setVisibility(0);
        while (getChildCount() < linkedList.size()) {
            ImageView imageView = new ImageView(getContext());
            LayoutParams layoutParams = new LayoutParams(getResources().getDimensionPixelSize(R.dimen.k6), getResources().getDimensionPixelSize(R.dimen.k6));
            layoutParams.setMargins(0, 0, getResources().getDimensionPixelSize(R.dimen.k1), 0);
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ScaleType.FIT_XY);
            addView(imageView);
        }
        int i = 0;
        while (i < linkedList.size()) {
            a aVar = new a();
            aVar.eQf = true;
            e.bFH().a((ImageView) getChildAt(i), (String) linkedList.get(i), aVar.bFI());
            getChildAt(i).setVisibility(0);
            i++;
        }
        while (i < getChildCount()) {
            int i2 = i + 1;
            getChildAt(i).setVisibility(8);
            i = i2;
        }
        AppMethodBeat.o(112410);
    }
}
