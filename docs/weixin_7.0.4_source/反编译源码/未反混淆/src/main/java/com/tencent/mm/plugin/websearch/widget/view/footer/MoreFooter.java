package com.tencent.mm.plugin.websearch.widget.view.footer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.v;

public class MoreFooter extends LinearLayout {
    private Context context;
    private TextView gsf;
    private View jWH;

    public MoreFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(91584);
        this.context = context;
        ViewGroup viewGroup = (ViewGroup) v.hu(this.context).inflate(R.layout.b7z, this);
        this.gsf = (TextView) viewGroup.findViewById(R.id.n0);
        this.jWH = viewGroup.findViewById(R.id.l_);
        AppMethodBeat.o(91584);
    }

    public void setTitle(String str) {
        AppMethodBeat.i(91585);
        this.gsf.setText(str);
        AppMethodBeat.o(91585);
    }

    public void setOnClickLsn(OnClickListener onClickListener) {
        AppMethodBeat.i(91586);
        this.jWH.setOnClickListener(onClickListener);
        AppMethodBeat.o(91586);
    }
}
