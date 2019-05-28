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

public class DirectionSwitchFooter extends LinearLayout implements a {
    private Context context;
    private ImageView iPN;
    private c udB;
    private TextView uei;
    private a uel;
    private View uen;
    private View ueo;
    private View uep;
    private View ueq;

    public DirectionSwitchFooter(Context context) {
        super(context);
        AppMethodBeat.i(91571);
        c.a aVar = new c.a();
        this.udB = aVar.ahG();
        this.context = context;
        init();
        AppMethodBeat.o(91571);
    }

    public DirectionSwitchFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(91572);
        c.a aVar = new c.a();
        this.udB = aVar.ahG();
        this.context = context;
        init();
        AppMethodBeat.o(91572);
    }

    private void init() {
        AppMethodBeat.i(91573);
        ViewGroup viewGroup = (ViewGroup) v.hu(this.context).inflate(R.layout.b81, this);
        this.uei = (TextView) viewGroup.findViewById(R.id.flo);
        this.iPN = (ImageView) viewGroup.findViewById(R.id.fln);
        this.uen = viewGroup.findViewById(R.id.fls);
        this.ueo = viewGroup.findViewById(R.id.z_);
        this.uep = viewGroup.findViewById(R.id.flr);
        this.ueq = viewGroup.findViewById(R.id.flt);
        this.uep.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(91569);
                if (DirectionSwitchFooter.this.uel != null) {
                    DirectionSwitchFooter.this.uel.cWh();
                }
                AppMethodBeat.o(91569);
            }
        });
        this.ueq.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(91570);
                if (DirectionSwitchFooter.this.uel != null) {
                    DirectionSwitchFooter.this.uel.cWg();
                }
                AppMethodBeat.o(91570);
            }
        });
        AppMethodBeat.o(91573);
    }

    public void setTitle(String str) {
        AppMethodBeat.i(91574);
        this.uei.setText(str);
        AppMethodBeat.o(91574);
    }

    public void setIcon(String str) {
        AppMethodBeat.i(91575);
        if (TextUtils.isEmpty(str)) {
            this.iPN.setVisibility(8);
            AppMethodBeat.o(91575);
            return;
        }
        this.iPN.setVisibility(0);
        com.tencent.mm.at.a.a.ahv().a(str, this.iPN, this.udB);
        AppMethodBeat.o(91575);
    }

    public void setCallback(a aVar) {
        AppMethodBeat.i(91576);
        this.uel = aVar;
        if (aVar != null) {
            if (aVar.getItemCount() == 1) {
                this.uep.setVisibility(8);
                this.ueq.setVisibility(8);
            }
            if (this.uel != null) {
                if (this.uel.hasNext()) {
                    this.ueo.setEnabled(true);
                    this.ueq.setEnabled(true);
                } else {
                    this.ueq.setEnabled(false);
                    this.ueo.setEnabled(false);
                }
                if (this.uel.hasPrevious()) {
                    this.uep.setEnabled(true);
                    this.uen.setEnabled(true);
                } else {
                    this.uen.setEnabled(false);
                    this.uep.setEnabled(false);
                    AppMethodBeat.o(91576);
                    return;
                }
            }
        }
        AppMethodBeat.o(91576);
    }
}
