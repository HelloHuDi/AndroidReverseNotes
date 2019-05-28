package com.tencent.p177mm.plugin.appbrand.game.widget.input;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.appbrand.widget.input.C38606u;
import com.tencent.p177mm.plugin.appbrand.widget.input.C38609w;
import com.tencent.p177mm.plugin.appbrand.widget.input.C38609w.C11043a;
import com.tencent.p177mm.plugin.appbrand.widget.input.C42740n;

/* renamed from: com.tencent.mm.plugin.appbrand.game.widget.input.a */
public final class C42449a extends C38609w {
    private static final int huq = 2131820555;
    public C33207a hur;
    private WAGamePanelInputEditText hus;
    private OnClickListener hut;

    /* renamed from: com.tencent.mm.plugin.appbrand.game.widget.input.a$a */
    public static final class C33207a extends FrameLayout implements C11043a {
        public View huw;

        public final View getConfirmButton() {
            AppMethodBeat.m2504i(130343);
            if (this.huw == null) {
                this.huw = findViewById(2131821188);
            }
            View view = this.huw;
            AppMethodBeat.m2505o(130343);
            return view;
        }

        public C33207a(Context context) {
            super(context);
            AppMethodBeat.m2504i(130344);
            LayoutInflater.from(context).inflate(2130968682, this, true);
            ((Button) findViewById(2131821188)).setText(C25738R.string.f9276v8);
            AppMethodBeat.m2505o(130344);
        }

        public final void setIsHide(boolean z) {
            AppMethodBeat.m2504i(130345);
            setVisibility(z ? 8 : 0);
            AppMethodBeat.m2505o(130345);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.widget.input.a$1 */
    class C424501 implements OnClickListener {
        C424501() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(130341);
            if (C42449a.this.hut != null) {
                C42449a.this.hut.onClick(view);
            }
            AppMethodBeat.m2505o(130341);
        }
    }

    private C42449a(Context context) {
        super(context);
        AppMethodBeat.m2504i(130346);
        mo61417qE(huq);
        AppMethodBeat.m2505o(130346);
    }

    /* renamed from: ck */
    public static C42449a m75189ck(View view) {
        AppMethodBeat.m2504i(130347);
        C42449a c42449a = (C42449a) view.getRootView().findViewById(huq);
        AppMethodBeat.m2505o(130347);
        return c42449a;
    }

    /* renamed from: cl */
    public static C42449a m75190cl(View view) {
        AppMethodBeat.m2504i(130348);
        C42740n cG = C42740n.m75740cG(view);
        if (cG.getOnLayoutListener() == null || !(cG.getOnLayoutListener() instanceof C38606u)) {
            cG.setOnLayoutListener(new C38606u());
        }
        C42449a ck = C42449a.m75189ck(view);
        if (ck == null) {
            ck = new C42449a(view.getContext());
            cG.mo68193cH(ck);
        }
        AppMethodBeat.m2505o(130348);
        return ck;
    }

    public final void aBJ() {
        AppMethodBeat.m2504i(130349);
        this.hur.setIsHide(false);
        AppMethodBeat.m2505o(130349);
    }

    public final void aBK() {
        int i;
        int i2 = 0;
        AppMethodBeat.m2504i(130350);
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
        AppMethodBeat.m2505o(130350);
    }

    public final WAGamePanelInputEditText getAttachedEditText() {
        AppMethodBeat.m2504i(130351);
        WAGamePanelInputEditText wAGamePanelInputEditText = (WAGamePanelInputEditText) super.getAttachedEditText();
        AppMethodBeat.m2505o(130351);
        return wAGamePanelInputEditText;
    }

    public final void show() {
        AppMethodBeat.m2504i(130352);
        this.jfW = this.hus;
        this.hus.requestFocus();
        super.show();
        AppMethodBeat.m2505o(130352);
    }

    public final void setOnConfirmClickListener(OnClickListener onClickListener) {
        this.hut = onClickListener;
    }

    public final /* synthetic */ View aBL() {
        AppMethodBeat.m2504i(130354);
        C33207a c33207a = new C33207a(getContext());
        this.hus = (WAGamePanelInputEditText) c33207a.findViewById(2131821187);
        c33207a.getConfirmButton().setOnClickListener(new C424501());
        this.jfW = this.hus;
        this.hur = c33207a;
        AppMethodBeat.m2505o(130354);
        return c33207a;
    }
}
