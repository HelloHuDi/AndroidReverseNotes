package com.tencent.p177mm.plugin.websearch.widget.view.footer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.C5616v;

/* renamed from: com.tencent.mm.plugin.websearch.widget.view.footer.MoreFooter */
public class MoreFooter extends LinearLayout {
    private Context context;
    private TextView gsf;
    private View jWH;

    public MoreFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(91584);
        this.context = context;
        ViewGroup viewGroup = (ViewGroup) C5616v.m8409hu(this.context).inflate(2130971236, this);
        this.gsf = (TextView) viewGroup.findViewById(2131821051);
        this.jWH = viewGroup.findViewById(2131820987);
        AppMethodBeat.m2505o(91584);
    }

    public void setTitle(String str) {
        AppMethodBeat.m2504i(91585);
        this.gsf.setText(str);
        AppMethodBeat.m2505o(91585);
    }

    public void setOnClickLsn(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(91586);
        this.jWH.setOnClickListener(onClickListener);
        AppMethodBeat.m2505o(91586);
    }
}
