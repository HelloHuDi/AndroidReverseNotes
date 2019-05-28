package com.tencent.p177mm.pluginsdk.p597ui.chat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.BasePanelKeybordLayout;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.pluginsdk.ui.chat.ChattingUILayout */
public class ChattingUILayout extends BasePanelKeybordLayout {
    private ChatFooterBottom vol;

    public ChattingUILayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* renamed from: t */
    private ChatFooterBottom m69542t(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(27946);
        ChatFooterBottom chatFooterBottom;
        if (this.vol != null) {
            chatFooterBottom = this.vol;
            AppMethodBeat.m2505o(27946);
            return chatFooterBottom;
        } else if (viewGroup == null || viewGroup.getChildCount() <= 0) {
            chatFooterBottom = this.vol;
            AppMethodBeat.m2505o(27946);
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
                        AppMethodBeat.m2505o(27946);
                        return chatFooterBottom;
                    } else if (!(childAt instanceof ViewGroup) || m69542t((ViewGroup) childAt) == null) {
                        i = i2 + 1;
                    } else {
                        chatFooterBottom = this.vol;
                        AppMethodBeat.m2505o(27946);
                        return chatFooterBottom;
                    }
                }
                chatFooterBottom = this.vol;
                AppMethodBeat.m2505o(27946);
                return chatFooterBottom;
            }
        }
    }

    public List<View> getPanelView() {
        AppMethodBeat.m2504i(27947);
        ArrayList arrayList = new ArrayList();
        arrayList.add(m69542t(this));
        AppMethodBeat.m2505o(27947);
        return arrayList;
    }
}
