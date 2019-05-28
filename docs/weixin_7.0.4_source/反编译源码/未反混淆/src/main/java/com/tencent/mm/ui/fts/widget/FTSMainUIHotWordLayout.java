package com.tencent.mm.ui.fts.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class FTSMainUIHotWordLayout extends LinearLayout {
    private TextView gnB = null;
    protected OnClickListener mJH;
    protected List<LinearLayout> mMf = null;
    protected int zyb = 2;
    protected boolean zyc = true;
    public b zyd = null;

    public static class a {
        public int cKJ;
        public String jumpUrl;
        public String zye;
        public int zyf;
    }

    static class b {
        public String hlm;
    }

    public FTSMainUIHotWordLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(91590);
        initView();
        AppMethodBeat.o(91590);
    }

    public FTSMainUIHotWordLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(91591);
        initView();
        AppMethodBeat.o(91591);
    }

    private void initView() {
        AppMethodBeat.i(91592);
        setOrientation(1);
        this.mMf = new ArrayList();
        AppMethodBeat.o(91592);
    }

    public void setOnCellClickListener(OnClickListener onClickListener) {
        this.mJH = onClickListener;
    }

    public String getSearchId() {
        if (this.zyd == null || this.zyd.hlm == null) {
            return "";
        }
        return this.zyd.hlm;
    }

    public void setVisibility(int i) {
        Object obj;
        AppMethodBeat.i(91593);
        if (this.mMf.size() > 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            i = 8;
        }
        super.setVisibility(i);
        AppMethodBeat.o(91593);
    }
}
