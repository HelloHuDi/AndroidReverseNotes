package com.tencent.p177mm.plugin.appbrand.widget.sms;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.sms.EditVerifyCodeView */
public class EditVerifyCodeView extends RelativeLayout {
    private ImageView[] joP;
    private TextView[] joQ;
    OnKeyListener joR;
    public C33651a joS;
    private StringBuilder mBuilder;
    private Context mContext;
    /* renamed from: tc */
    private EditText f15042tc;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.sms.EditVerifyCodeView$2 */
    class C110542 extends NumberKeyListener {
        C110542() {
        }

        /* Access modifiers changed, original: protected|final */
        public final char[] getAcceptedChars() {
            return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        }

        public final int getInputType() {
            return 3;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.sms.EditVerifyCodeView$1 */
    class C199291 implements TextWatcher {
        C199291() {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(134402);
            if (editable == null || editable.length() == 0) {
                AppMethodBeat.m2505o(134402);
                return;
            }
            C4990ab.m7417i("MicroMsg.EditVerifyCodeView", "afterTextChanged:%s", editable.toString());
            if (EditVerifyCodeView.this.mBuilder.length() < 6) {
                EditVerifyCodeView.this.mBuilder.append(editable.toString());
                EditVerifyCodeView.m54956b(EditVerifyCodeView.this);
            }
            editable.delete(0, editable.length());
            AppMethodBeat.m2505o(134402);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.sms.EditVerifyCodeView$a */
    public interface C33651a {
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.sms.EditVerifyCodeView$3 */
    class C336523 implements OnKeyListener {
        C336523() {
        }

        public final boolean onKey(View view, int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(134403);
            if (i == 67 && keyEvent.getAction() == 1) {
                EditVerifyCodeView.m54957c(EditVerifyCodeView.this);
                AppMethodBeat.m2505o(134403);
                return true;
            }
            AppMethodBeat.m2505o(134403);
            return false;
        }
    }

    public EditVerifyCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(134404);
        this.mBuilder = new StringBuilder();
        this.joP = new ImageView[6];
        this.joQ = new TextView[6];
        this.joR = new C336523();
        m54958dq(context);
        AppMethodBeat.m2505o(134404);
    }

    public EditVerifyCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(134405);
        this.mBuilder = new StringBuilder();
        this.joP = new ImageView[6];
        this.joQ = new TextView[6];
        this.joR = new C336523();
        m54958dq(context);
        AppMethodBeat.m2505o(134405);
    }

    public String getText() {
        AppMethodBeat.m2504i(134406);
        String stringBuilder = this.mBuilder.toString();
        AppMethodBeat.m2505o(134406);
        return stringBuilder;
    }

    public void setText(String str) {
        AppMethodBeat.m2504i(134407);
        this.mBuilder.delete(0, this.mBuilder.length());
        this.mBuilder.append(str);
        String stringBuilder = this.mBuilder.toString();
        int length = stringBuilder.length();
        C4990ab.m7416i("MicroMsg.EditVerifyCodeView", "mBuilder:" + this.mBuilder);
        int i;
        if (length > 0) {
            for (i = 0; i < length; i++) {
                this.joQ[i].setVisibility(0);
                this.joQ[i].setText(String.valueOf(stringBuilder.charAt(i)));
                this.joP[i].setVisibility(4);
            }
            AppMethodBeat.m2505o(134407);
            return;
        }
        for (i = 0; i < 6; i++) {
            this.joQ[i].setVisibility(4);
            this.joQ[i].setText("");
            this.joP[i].setVisibility(0);
        }
        AppMethodBeat.m2505o(134407);
    }

    @SuppressLint({"InflateParams"})
    /* renamed from: dq */
    private void m54958dq(Context context) {
        AppMethodBeat.m2504i(134408);
        this.mContext = context;
        View inflate = LayoutInflater.from(this.mContext).inflate(2130969320, null);
        TextView textView = (TextView) inflate.findViewById(2131823392);
        TextView textView2 = (TextView) inflate.findViewById(2131823394);
        TextView textView3 = (TextView) inflate.findViewById(2131823396);
        TextView textView4 = (TextView) inflate.findViewById(2131823398);
        TextView textView5 = (TextView) inflate.findViewById(2131823400);
        this.joQ[0] = (TextView) inflate.findViewById(2131823390);
        this.joQ[1] = textView;
        this.joQ[2] = textView2;
        this.joQ[3] = textView3;
        this.joQ[4] = textView4;
        this.joQ[5] = textView5;
        ImageView imageView = (ImageView) inflate.findViewById(2131823393);
        ImageView imageView2 = (ImageView) inflate.findViewById(2131823395);
        ImageView imageView3 = (ImageView) inflate.findViewById(2131823397);
        ImageView imageView4 = (ImageView) inflate.findViewById(2131823399);
        ImageView imageView5 = (ImageView) inflate.findViewById(2131823401);
        this.joP[0] = (ImageView) inflate.findViewById(2131823391);
        this.joP[1] = imageView;
        this.joP[2] = imageView2;
        this.joP[3] = imageView3;
        this.joP[4] = imageView4;
        this.joP[5] = imageView5;
        this.f15042tc = (EditText) inflate.findViewById(2131823402);
        this.f15042tc.addTextChangedListener(new C199291());
        this.f15042tc.setKeyListener(new C110542());
        this.f15042tc.setOnKeyListener(this.joR);
        addView(inflate, new LayoutParams(-1, -1));
        AppMethodBeat.m2505o(134408);
    }

    public void setCodeEditCompleListener(C33651a c33651a) {
        this.joS = c33651a;
    }

    /* renamed from: b */
    static /* synthetic */ void m54956b(EditVerifyCodeView editVerifyCodeView) {
        AppMethodBeat.m2504i(134409);
        String stringBuilder = editVerifyCodeView.mBuilder.toString();
        C4990ab.m7416i("MicroMsg.EditVerifyCodeView", "mBuilder:" + editVerifyCodeView.mBuilder);
        int length = stringBuilder.length();
        if (length > 0 && length <= 6) {
            editVerifyCodeView.joQ[length - 1].setVisibility(0);
            editVerifyCodeView.joQ[length - 1].setText(String.valueOf(stringBuilder.charAt(length - 1)));
            editVerifyCodeView.joP[length - 1].setVisibility(4);
        }
        AppMethodBeat.m2505o(134409);
    }

    /* renamed from: c */
    static /* synthetic */ void m54957c(EditVerifyCodeView editVerifyCodeView) {
        AppMethodBeat.m2504i(134410);
        String stringBuilder = editVerifyCodeView.mBuilder.toString();
        C4990ab.m7416i("MicroMsg.EditVerifyCodeView", "del before str:" + editVerifyCodeView.mBuilder);
        int length = stringBuilder.length();
        if (length != 0) {
            if (length > 0 && length <= 6) {
                editVerifyCodeView.mBuilder.delete(length - 1, length);
                editVerifyCodeView.joQ[length - 1].setVisibility(4);
                editVerifyCodeView.joQ[length - 1].setText("");
                editVerifyCodeView.joP[length - 1].setVisibility(0);
            }
            C4990ab.m7416i("MicroMsg.EditVerifyCodeView", "del after str:" + editVerifyCodeView.mBuilder);
        }
        AppMethodBeat.m2505o(134410);
    }
}
