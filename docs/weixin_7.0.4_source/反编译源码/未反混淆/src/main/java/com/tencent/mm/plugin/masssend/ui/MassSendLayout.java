package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import java.util.ArrayList;
import java.util.List;

public class MassSendLayout extends BasePanelKeybordLayout {
    private View kmS;

    public MassSendLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MassSendLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setPanel(View view) {
        this.kmS = view;
    }

    public List<View> getPanelView() {
        AppMethodBeat.i(22823);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.kmS);
        AppMethodBeat.o(22823);
        return arrayList;
    }
}
