package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.e.j;
import java.util.LinkedList;

public class GameListSocialView extends LinearLayout {
    public GameListSocialView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(112063);
        super.onFinishInflate();
        AppMethodBeat.o(112063);
    }

    public void setData(LinkedList<String> linkedList) {
        int i = 0;
        AppMethodBeat.i(112064);
        if (linkedList == null || linkedList.size() == 0 || linkedList.size() % 2 != 0) {
            setVisibility(8);
            AppMethodBeat.o(112064);
            return;
        }
        int i2;
        setVisibility(0);
        if (getChildCount() < linkedList.size() / 2) {
            int size = (linkedList.size() / 2) - getChildCount();
            for (i2 = 0; i2 < size; i2++) {
                inflate(getContext(), R.layout.a4q, this);
            }
        }
        for (i2 = 0; i2 < getChildCount(); i2++) {
            if (i2 < linkedList.size() / 2) {
                getChildAt(i2).setVisibility(0);
            } else {
                getChildAt(i2).setVisibility(8);
            }
        }
        while (true) {
            int i3 = i;
            if (i3 < linkedList.size() / 2) {
                View childAt = getChildAt(i3);
                TextView textView = (TextView) childAt.findViewById(R.id.c7f);
                TextView textView2 = (TextView) childAt.findViewById(R.id.c7g);
                textView.setText(j.b(getContext(), (CharSequence) linkedList.get(i3 * 2), textView.getTextSize()));
                textView2.setText(j.b(getContext(), (CharSequence) linkedList.get((i3 * 2) + 1), textView2.getTextSize()));
                i = i3 + 1;
            } else {
                AppMethodBeat.o(112064);
                return;
            }
        }
    }
}
