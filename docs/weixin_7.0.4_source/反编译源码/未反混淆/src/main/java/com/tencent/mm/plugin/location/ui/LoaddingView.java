package com.tencent.mm.plugin.location.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.baseutils.IOUtils;

public class LoaddingView extends LinearLayout implements c {
    private Animation De;
    private TextView nLs;
    private ProgressBar nLt;
    private View nLu;
    private boolean nLv = false;
    private String nLw = "";

    @TargetApi(11)
    public LoaddingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(113425);
        init(context);
        AppMethodBeat.o(113425);
    }

    public LoaddingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(113426);
        init(context);
        AppMethodBeat.o(113426);
    }

    private void init(Context context) {
        AppMethodBeat.i(113427);
        this.De = AnimationUtils.loadAnimation(context, R.anim.dx);
        View inflate = LayoutInflater.from(context).inflate(R.layout.a_9, this, true);
        this.nLt = (ProgressBar) inflate.findViewById(R.id.cpw);
        this.nLs = (TextView) inflate.findViewById(R.id.cpx);
        this.nLu = inflate.findViewById(R.id.cpu);
        this.nLs.setText("");
        this.nLs.setVisibility(0);
        this.nLt.setVisibility(0);
        AppMethodBeat.o(113427);
    }

    public void setProgressAlwaysGone(boolean z) {
        AppMethodBeat.i(113428);
        this.nLv = z;
        this.nLt.setVisibility(8);
        this.nLs.setVisibility(8);
        AppMethodBeat.o(113428);
    }

    public void setText(String str) {
        AppMethodBeat.i(113429);
        if (this.nLs == null || this.nLt == null || this.nLv) {
            AppMethodBeat.o(113429);
        } else if (bo.isNullOrNil(str)) {
            this.nLs.setText("");
            this.nLs.setVisibility(0);
            this.nLt.setVisibility(0);
            AppMethodBeat.o(113429);
        } else {
            this.nLs.setText(String.valueOf(str));
            this.nLt.setVisibility(8);
            this.nLs.setVisibility(0);
            AppMethodBeat.o(113429);
        }
    }

    public void setPreText(String str) {
        AppMethodBeat.i(113430);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(113430);
            return;
        }
        this.nLw = str + IOUtils.LINE_SEPARATOR_UNIX;
        AppMethodBeat.o(113430);
    }

    public String getPreText() {
        return this.nLw;
    }
}
