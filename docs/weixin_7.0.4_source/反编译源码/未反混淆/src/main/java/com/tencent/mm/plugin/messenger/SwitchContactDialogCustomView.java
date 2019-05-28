package com.tencent.mm.plugin.messenger;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a.b;

public class SwitchContactDialogCustomView extends LinearLayout {
    private TextView TF;
    private TextView opN;
    private ImageView opO;
    private TextView opP;
    private TextView opQ;

    public SwitchContactDialogCustomView(Context context) {
        this(context, null);
    }

    public SwitchContactDialogCustomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(136912);
        LayoutInflater.from(context).inflate(R.layout.b6, this);
        this.TF = (TextView) findViewById(R.id.cx);
        this.opN = (TextView) findViewById(R.id.m5);
        this.opO = (ImageView) findViewById(R.id.o6);
        this.opP = (TextView) findViewById(R.id.o7);
        this.opQ = (TextView) findViewById(R.id.o8);
        AppMethodBeat.o(136912);
    }

    public void setTilte(String str) {
        AppMethodBeat.i(136913);
        this.TF.setText(str);
        AppMethodBeat.o(136913);
    }

    public void setContent(String str) {
        AppMethodBeat.i(136914);
        this.opN.setText(str);
        AppMethodBeat.o(136914);
    }

    public void setDesc(String str) {
        AppMethodBeat.i(136915);
        this.opP.setText(str);
        AppMethodBeat.o(136915);
    }

    public void setSubDesc(String str) {
        AppMethodBeat.i(136916);
        this.opQ.setText(str);
        AppMethodBeat.o(136916);
    }

    public void setPhoto(String str) {
        AppMethodBeat.i(136917);
        b.b(this.opO, str);
        AppMethodBeat.o(136917);
    }

    public void setOnPhotoOnClick(OnClickListener onClickListener) {
        AppMethodBeat.i(136918);
        if (this.opO != null) {
            this.opO.setOnClickListener(onClickListener);
        }
        AppMethodBeat.o(136918);
    }
}
