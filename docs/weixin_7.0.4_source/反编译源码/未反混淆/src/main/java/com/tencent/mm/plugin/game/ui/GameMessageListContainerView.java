package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.f;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.plugin.game.model.n.i;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public class GameMessageListContainerView extends LinearLayout {
    private Context mContext;

    public GameMessageListContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(112088);
        super.onFinishInflate();
        AppMethodBeat.o(112088);
    }

    public final void a(n nVar, LinkedList<i> linkedList, int i, int i2, f<String, Bitmap> fVar) {
        AppMethodBeat.i(112089);
        if (nVar == null || bo.ek(linkedList)) {
            setVisibility(8);
            AppMethodBeat.o(112089);
            return;
        }
        setVisibility(0);
        int i3 = i > linkedList.size() ? 1 : 2;
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.f15do);
        while (getChildCount() < i3) {
            GameMessageListUserIconView gameMessageListUserIconView = new GameMessageListUserIconView(this.mContext);
            if (getChildCount() > 0) {
                gameMessageListUserIconView.setPadding(0, dimensionPixelSize, 0, 0);
            }
            gameMessageListUserIconView.setSourceScene(i2);
            addView(gameMessageListUserIconView);
        }
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            if (i4 < i3) {
                getChildAt(i4).setVisibility(0);
                GameMessageListUserIconView gameMessageListUserIconView2 = (GameMessageListUserIconView) getChildAt(i4);
                LinkedList linkedList2 = new LinkedList();
                int i5 = i4 * i;
                while (i5 < (i4 + 1) * i && i5 < linkedList.size()) {
                    linkedList2.add(linkedList.get(i5));
                    i5++;
                }
                gameMessageListUserIconView2.a(nVar, linkedList2, fVar);
            } else {
                getChildAt(i4).setVisibility(8);
            }
        }
        AppMethodBeat.o(112089);
    }
}
