package com.tencent.mm.plugin.websearch.widget.view.footer;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.plugin.websearch.widget.view.footer.a.a;
import com.tencent.mm.ui.v;

public class DownArrowSwitchFooter extends LinearLayout implements a {
    private Context context;
    private ImageView iPN;
    private c udB;
    private TextView uei;
    private View uej;
    private a uel;

    public DownArrowSwitchFooter(Context context) {
        super(context);
        AppMethodBeat.i(91578);
        c.a aVar = new c.a();
        this.udB = aVar.ahG();
        this.context = context;
        init();
        AppMethodBeat.o(91578);
    }

    public DownArrowSwitchFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(91579);
        c.a aVar = new c.a();
        this.udB = aVar.ahG();
        this.context = context;
        init();
        AppMethodBeat.o(91579);
    }

    private void init() {
        AppMethodBeat.i(91580);
        ViewGroup viewGroup = (ViewGroup) v.hu(this.context).inflate(R.layout.b82, this);
        this.uej = viewGroup.findViewById(R.id.flu);
        this.uei = (TextView) viewGroup.findViewById(R.id.flo);
        this.iPN = (ImageView) viewGroup.findViewById(R.id.fln);
        viewGroup.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(91577);
                if (DownArrowSwitchFooter.this.uel != null) {
                    DownArrowSwitchFooter.this.uel.cWf();
                }
                AppMethodBeat.o(91577);
            }
        });
        AppMethodBeat.o(91580);
    }

    public void setTitle(String str) {
        AppMethodBeat.i(91581);
        this.uei.setText(str);
        AppMethodBeat.o(91581);
    }

    public void setIcon(String str) {
        AppMethodBeat.i(91582);
        if (TextUtils.isEmpty(str)) {
            this.iPN.setVisibility(8);
            AppMethodBeat.o(91582);
            return;
        }
        this.iPN.setVisibility(0);
        com.tencent.mm.at.a.a.ahv().a(str, this.iPN, this.udB);
        AppMethodBeat.o(91582);
    }

    public void setCallback(a aVar) {
        AppMethodBeat.i(91583);
        this.uel = aVar;
        if (aVar != null) {
            if (aVar.getItemCount() > 1) {
                this.uej.setVisibility(0);
                AppMethodBeat.o(91583);
                return;
            }
            this.uej.setVisibility(8);
        }
        AppMethodBeat.o(91583);
    }
}
