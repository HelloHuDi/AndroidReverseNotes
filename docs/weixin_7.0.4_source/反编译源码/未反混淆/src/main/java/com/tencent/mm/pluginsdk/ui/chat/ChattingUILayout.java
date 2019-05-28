package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import java.util.ArrayList;
import java.util.List;

public class ChattingUILayout extends BasePanelKeybordLayout {
    private ChatFooterBottom vol;

    public ChattingUILayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private ChatFooterBottom t(ViewGroup viewGroup) {
        AppMethodBeat.i(27946);
        ChatFooterBottom chatFooterBottom;
        if (this.vol != null) {
            chatFooterBottom = this.vol;
            AppMethodBeat.o(27946);
            return chatFooterBottom;
        } else if (viewGroup == null || viewGroup.getChildCount() <= 0) {
            chatFooterBottom = this.vol;
            AppMethodBeat.o(27946);
            return chatFooterBottom;
        } else {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < viewGroup.getChildCount()) {
                    View childAt = viewGroup.getChildAt(i2);
                    if (childAt instanceof ChatFooterBottom) {
                        this.vol = (ChatFooterBottom) childAt;
                        chatFooterBottom = this.vol;
                        AppMethodBeat.o(27946);
                        return chatFooterBottom;
                    } else if (!(childAt instanceof ViewGroup) || t((ViewGroup) childAt) == null) {
                        i = i2 + 1;
                    } else {
                        chatFooterBottom = this.vol;
                        AppMethodBeat.o(27946);
                        return chatFooterBottom;
                    }
                }
                chatFooterBottom = this.vol;
                AppMethodBeat.o(27946);
                return chatFooterBottom;
            }
        }
    }

    public List<View> getPanelView() {
        AppMethodBeat.i(27947);
        ArrayList arrayList = new ArrayList();
        arrayList.add(t(this));
        AppMethodBeat.o(27947);
        return arrayList;
    }
}
