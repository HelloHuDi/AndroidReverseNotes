package com.tencent.p177mm.plugin.game.p433ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.plugin.game.model.C28229n;
import com.tencent.p177mm.plugin.game.model.C28229n.C28233i;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.game.ui.GameMessageListContainerView */
public class GameMessageListContainerView extends LinearLayout {
    private Context mContext;

    public GameMessageListContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.m2504i(112088);
        super.onFinishInflate();
        AppMethodBeat.m2505o(112088);
    }

    /* renamed from: a */
    public final void mo54842a(C28229n c28229n, LinkedList<C28233i> linkedList, int i, int i2, C1177f<String, Bitmap> c1177f) {
        AppMethodBeat.m2504i(112089);
        if (c28229n == null || C5046bo.m7548ek(linkedList)) {
            setVisibility(8);
            AppMethodBeat.m2505o(112089);
            return;
        }
        setVisibility(0);
        int i3 = i > linkedList.size() ? 1 : 2;
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f9723do);
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
                gameMessageListUserIconView2.mo46135a(c28229n, linkedList2, c1177f);
            } else {
                getChildAt(i4).setVisibility(8);
            }
        }
        AppMethodBeat.m2505o(112089);
    }
}
