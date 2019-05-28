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

public class BtnSwitchFooter extends LinearLayout implements a {
    private Context context;
    private ImageView iPN;
    private c udB;
    private TextView uei;
    private View uej;
    private View uek;
    private a uel;

    public BtnSwitchFooter(Context context) {
        super(context);
        AppMethodBeat.i(91561);
        c.a aVar = new c.a();
        this.udB = aVar.ahG();
        this.context = context;
        init();
        AppMethodBeat.o(91561);
    }

    public BtnSwitchFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(91562);
        c.a aVar = new c.a();
        this.udB = aVar.ahG();
        this.context = context;
        init();
        AppMethodBeat.o(91562);
    }

    private void init() {
        AppMethodBeat.i(91563);
        ViewGroup viewGroup = (ViewGroup) v.hu(this.context).inflate(R.layout.b80, this);
        this.uek = viewGroup.findViewById(R.id.flp);
        this.uej = viewGroup.findViewById(R.id.flq);
        this.uei = (TextView) viewGroup.findViewById(R.id.flo);
        this.iPN = (ImageView) viewGroup.findViewById(R.id.fln);
        this.uek.setVisibility(8);
        this.uej.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(91560);
                if (BtnSwitchFooter.this.uel != null) {
                    BtnSwitchFooter.this.uel.cWf();
                }
                AppMethodBeat.o(91560);
            }
        });
        AppMethodBeat.o(91563);
    }

    public void setSwitchClickLsn(OnClickListener onClickListener) {
        AppMethodBeat.i(91564);
        this.uej.setOnClickListener(onClickListener);
        AppMethodBeat.o(91564);
    }

    public void setSwitchVisible(int i) {
        AppMethodBeat.i(91565);
        this.uej.setVisibility(i);
        AppMethodBeat.o(91565);
    }

    public void setTitle(String str) {
        AppMethodBeat.i(91566);
        this.uei.setText(str);
        AppMethodBeat.o(91566);
    }

    public void setIcon(String str) {
        AppMethodBeat.i(91567);
        if (TextUtils.isEmpty(str)) {
            this.iPN.setVisibility(8);
            AppMethodBeat.o(91567);
            return;
        }
        this.iPN.setVisibility(0);
        com.tencent.mm.at.a.a.ahv().a(str, this.iPN, this.udB);
        AppMethodBeat.o(91567);
    }

    public void setCallback(a aVar) {
        AppMethodBeat.i(91568);
        this.uel = aVar;
        if (aVar != null) {
            if (aVar.getItemCount() > 1) {
                this.uej.setVisibility(0);
                AppMethodBeat.o(91568);
                return;
            }
            this.uej.setVisibility(8);
        }
        AppMethodBeat.o(91568);
    }
}
