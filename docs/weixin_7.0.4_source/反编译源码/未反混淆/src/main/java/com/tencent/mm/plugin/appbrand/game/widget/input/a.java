package com.tencent.mm.plugin.appbrand.game.widget.input;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.plugin.appbrand.widget.input.u;
import com.tencent.mm.plugin.appbrand.widget.input.w;

public final class a extends w {
    private static final int huq = R.id.l;
    public a hur;
    private WAGamePanelInputEditText hus;
    private OnClickListener hut;

    public static final class a extends FrameLayout implements com.tencent.mm.plugin.appbrand.widget.input.w.a {
        public View huw;

        public final View getConfirmButton() {
            AppMethodBeat.i(130343);
            if (this.huw == null) {
                this.huw = findViewById(R.id.qp);
            }
            View view = this.huw;
            AppMethodBeat.o(130343);
            return view;
        }

        public a(Context context) {
            super(context);
            AppMethodBeat.i(130344);
            LayoutInflater.from(context).inflate(R.layout.c6, this, true);
            ((Button) findViewById(R.id.qp)).setText(R.string.v8);
            AppMethodBeat.o(130344);
        }

        public final void setIsHide(boolean z) {
            AppMethodBeat.i(130345);
            setVisibility(z ? 8 : 0);
            AppMethodBeat.o(130345);
        }
    }

    private a(Context context) {
        super(context);
        AppMethodBeat.i(130346);
        qE(huq);
        AppMethodBeat.o(130346);
    }

    public static a ck(View view) {
        AppMethodBeat.i(130347);
        a aVar = (a) view.getRootView().findViewById(huq);
        AppMethodBeat.o(130347);
        return aVar;
    }

    public static a cl(View view) {
        AppMethodBeat.i(130348);
        n cG = n.cG(view);
        if (cG.getOnLayoutListener() == null || !(cG.getOnLayoutListener() instanceof u)) {
            cG.setOnLayoutListener(new u());
        }
        a ck = ck(view);
        if (ck == null) {
            ck = new a(view.getContext());
            cG.cH(ck);
        }
        AppMethodBeat.o(130348);
        return ck;
    }

    public final void aBJ() {
        AppMethodBeat.i(130349);
        this.hur.setIsHide(false);
        AppMethodBeat.o(130349);
    }

    public final void aBK() {
        int i;
        int i2 = 0;
        AppMethodBeat.i(130350);
        if ((this.hus.getInputType() & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) > 0) {
            i = 1;
        } else {
            i = 0;
        }
        View confirmButton = this.hur.getConfirmButton();
        if (i == 0) {
            i2 = 8;
        }
        confirmButton.setVisibility(i2);
        AppMethodBeat.o(130350);
    }

    public final WAGamePanelInputEditText getAttachedEditText() {
        AppMethodBeat.i(130351);
        WAGamePanelInputEditText wAGamePanelInputEditText = (WAGamePanelInputEditText) super.getAttachedEditText();
        AppMethodBeat.o(130351);
        return wAGamePanelInputEditText;
    }

    public final void show() {
        AppMethodBeat.i(130352);
        this.jfW = this.hus;
        this.hus.requestFocus();
        super.show();
        AppMethodBeat.o(130352);
    }

    public final void setOnConfirmClickListener(OnClickListener onClickListener) {
        this.hut = onClickListener;
    }

    public final /* synthetic */ View aBL() {
        AppMethodBeat.i(130354);
        a aVar = new a(getContext());
        this.hus = (WAGamePanelInputEditText) aVar.findViewById(R.id.qo);
        aVar.getConfirmButton().setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(130341);
                if (a.this.hut != null) {
                    a.this.hut.onClick(view);
                }
                AppMethodBeat.o(130341);
            }
        });
        this.jfW = this.hus;
        this.hur = aVar;
        AppMethodBeat.o(130354);
        return aVar;
    }
}
