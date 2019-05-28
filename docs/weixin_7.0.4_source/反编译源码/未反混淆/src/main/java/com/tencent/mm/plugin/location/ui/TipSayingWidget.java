package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.r;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bo;

public class TipSayingWidget extends LinearLayout {
    private Context context;
    private String ecX;
    private TextView eku;
    private ImageView nNH;
    private Chronometer nNI;
    private int nNJ = 0;

    public TipSayingWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(113552);
        this.context = context;
        View inflate = View.inflate(this.context, R.layout.azo, this);
        this.nNH = (ImageView) inflate.findViewById(R.id.evx);
        this.eku = (TextView) inflate.findViewById(R.id.evy);
        this.nNI = (Chronometer) findViewById(R.id.dkg);
        AppMethodBeat.o(113552);
    }

    public void setCurSaying(String str) {
        AppMethodBeat.i(113553);
        if (bo.isNullOrNil(str)) {
            setVisibility(8);
            AppMethodBeat.o(113553);
            return;
        }
        setVisibility(0);
        b.t(this.nNH, str);
        if (bo.isNullOrNil(this.ecX)) {
            this.ecX = r.Yz();
        }
        if (this.ecX.equals(str)) {
            this.eku.setText(this.context.getString(R.string.ext, new Object[]{str}));
            this.nNI.setVisibility(0);
            AppMethodBeat.o(113553);
            return;
        }
        this.eku.setText(this.context.getString(R.string.ext, new Object[]{str}));
        this.nNI.setVisibility(8);
        AppMethodBeat.o(113553);
    }
}
