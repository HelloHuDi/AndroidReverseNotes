package com.tencent.p177mm.plugin.location.p446ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.MMImageButton;

/* renamed from: com.tencent.mm.plugin.location.ui.ShareHeader */
public class ShareHeader extends LinearLayout {
    private TextView gne;
    private Context mContext;
    private ViewGroup nMu;
    private MMImageButton nMv;
    private MMImageButton nMw;

    @TargetApi(11)
    public ShareHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(113485);
        this.mContext = context;
        init();
        AppMethodBeat.m2505o(113485);
    }

    public ShareHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(113486);
        this.mContext = context;
        init();
        AppMethodBeat.m2505o(113486);
    }

    private void init() {
        AppMethodBeat.m2504i(113487);
        View inflate = View.inflate(this.mContext, 2130970663, this);
        this.nMu = (ViewGroup) inflate.findViewById(2131825945);
        this.nMv = (MMImageButton) inflate.findViewById(2131827535);
        this.nMw = (MMImageButton) inflate.findViewById(2131827537);
        this.gne = (TextView) inflate.findViewById(2131820678);
        AppMethodBeat.m2505o(113487);
    }

    public ViewGroup getHeaderBar() {
        return this.nMu;
    }

    public void setOnLeftClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(113488);
        this.nMv.setOnClickListener(onClickListener);
        AppMethodBeat.m2505o(113488);
    }

    public void setOnRightClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(113489);
        this.nMw.setOnClickListener(onClickListener);
        AppMethodBeat.m2505o(113489);
    }

    public void setTitle(String str) {
        AppMethodBeat.m2504i(113490);
        this.gne.setText(str);
        AppMethodBeat.m2505o(113490);
    }

    public void setTitleColor(int i) {
        AppMethodBeat.m2504i(113491);
        this.gne.setTextColor(i);
        AppMethodBeat.m2505o(113491);
    }
}
