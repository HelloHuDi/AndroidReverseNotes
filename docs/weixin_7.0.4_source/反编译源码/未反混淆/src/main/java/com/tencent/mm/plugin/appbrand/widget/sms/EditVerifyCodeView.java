package com.tencent.mm.plugin.appbrand.widget.sms;

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
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;

public class EditVerifyCodeView extends RelativeLayout {
    private ImageView[] joP;
    private TextView[] joQ;
    OnKeyListener joR;
    public a joS;
    private StringBuilder mBuilder;
    private Context mContext;
    private EditText tc;

    public interface a {
    }

    public EditVerifyCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(134404);
        this.mBuilder = new StringBuilder();
        this.joP = new ImageView[6];
        this.joQ = new TextView[6];
        this.joR = new OnKeyListener() {
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                AppMethodBeat.i(134403);
                if (i == 67 && keyEvent.getAction() == 1) {
                    EditVerifyCodeView.c(EditVerifyCodeView.this);
                    AppMethodBeat.o(134403);
                    return true;
                }
                AppMethodBeat.o(134403);
                return false;
            }
        };
        dq(context);
        AppMethodBeat.o(134404);
    }

    public EditVerifyCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(134405);
        this.mBuilder = new StringBuilder();
        this.joP = new ImageView[6];
        this.joQ = new TextView[6];
        this.joR = /* anonymous class already generated */;
        dq(context);
        AppMethodBeat.o(134405);
    }

    public String getText() {
        AppMethodBeat.i(134406);
        String stringBuilder = this.mBuilder.toString();
        AppMethodBeat.o(134406);
        return stringBuilder;
    }

    public void setText(String str) {
        AppMethodBeat.i(134407);
        this.mBuilder.delete(0, this.mBuilder.length());
        this.mBuilder.append(str);
        String stringBuilder = this.mBuilder.toString();
        int length = stringBuilder.length();
        ab.i("MicroMsg.EditVerifyCodeView", "mBuilder:" + this.mBuilder);
        int i;
        if (length > 0) {
            for (i = 0; i < length; i++) {
                this.joQ[i].setVisibility(0);
                this.joQ[i].setText(String.valueOf(stringBuilder.charAt(i)));
                this.joP[i].setVisibility(4);
            }
            AppMethodBeat.o(134407);
            return;
        }
        for (i = 0; i < 6; i++) {
            this.joQ[i].setVisibility(4);
            this.joQ[i].setText("");
            this.joP[i].setVisibility(0);
        }
        AppMethodBeat.o(134407);
    }

    @SuppressLint({"InflateParams"})
    private void dq(Context context) {
        AppMethodBeat.i(134408);
        this.mContext = context;
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.tc, null);
        TextView textView = (TextView) inflate.findViewById(R.id.bbz);
        TextView textView2 = (TextView) inflate.findViewById(R.id.bc1);
        TextView textView3 = (TextView) inflate.findViewById(R.id.bc3);
        TextView textView4 = (TextView) inflate.findViewById(R.id.bc5);
        TextView textView5 = (TextView) inflate.findViewById(R.id.bc7);
        this.joQ[0] = (TextView) inflate.findViewById(R.id.bbx);
        this.joQ[1] = textView;
        this.joQ[2] = textView2;
        this.joQ[3] = textView3;
        this.joQ[4] = textView4;
        this.joQ[5] = textView5;
        ImageView imageView = (ImageView) inflate.findViewById(R.id.bc0);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.bc2);
        ImageView imageView3 = (ImageView) inflate.findViewById(R.id.bc4);
        ImageView imageView4 = (ImageView) inflate.findViewById(R.id.bc6);
        ImageView imageView5 = (ImageView) inflate.findViewById(R.id.bc8);
        this.joP[0] = (ImageView) inflate.findViewById(R.id.bby);
        this.joP[1] = imageView;
        this.joP[2] = imageView2;
        this.joP[3] = imageView3;
        this.joP[4] = imageView4;
        this.joP[5] = imageView5;
        this.tc = (EditText) inflate.findViewById(R.id.bc9);
        this.tc.addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(134402);
                if (editable == null || editable.length() == 0) {
                    AppMethodBeat.o(134402);
                    return;
                }
                ab.i("MicroMsg.EditVerifyCodeView", "afterTextChanged:%s", editable.toString());
                if (EditVerifyCodeView.this.mBuilder.length() < 6) {
                    EditVerifyCodeView.this.mBuilder.append(editable.toString());
                    EditVerifyCodeView.b(EditVerifyCodeView.this);
                }
                editable.delete(0, editable.length());
                AppMethodBeat.o(134402);
            }
        });
        this.tc.setKeyListener(new NumberKeyListener() {
            /* Access modifiers changed, original: protected|final */
            public final char[] getAcceptedChars() {
                return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
            }

            public final int getInputType() {
                return 3;
            }
        });
        this.tc.setOnKeyListener(this.joR);
        addView(inflate, new LayoutParams(-1, -1));
        AppMethodBeat.o(134408);
    }

    public void setCodeEditCompleListener(a aVar) {
        this.joS = aVar;
    }

    static /* synthetic */ void b(EditVerifyCodeView editVerifyCodeView) {
        AppMethodBeat.i(134409);
        String stringBuilder = editVerifyCodeView.mBuilder.toString();
        ab.i("MicroMsg.EditVerifyCodeView", "mBuilder:" + editVerifyCodeView.mBuilder);
        int length = stringBuilder.length();
        if (length > 0 && length <= 6) {
            editVerifyCodeView.joQ[length - 1].setVisibility(0);
            editVerifyCodeView.joQ[length - 1].setText(String.valueOf(stringBuilder.charAt(length - 1)));
            editVerifyCodeView.joP[length - 1].setVisibility(4);
        }
        AppMethodBeat.o(134409);
    }

    static /* synthetic */ void c(EditVerifyCodeView editVerifyCodeView) {
        AppMethodBeat.i(134410);
        String stringBuilder = editVerifyCodeView.mBuilder.toString();
        ab.i("MicroMsg.EditVerifyCodeView", "del before str:" + editVerifyCodeView.mBuilder);
        int length = stringBuilder.length();
        if (length != 0) {
            if (length > 0 && length <= 6) {
                editVerifyCodeView.mBuilder.delete(length - 1, length);
                editVerifyCodeView.joQ[length - 1].setVisibility(4);
                editVerifyCodeView.joQ[length - 1].setText("");
                editVerifyCodeView.joP[length - 1].setVisibility(0);
            }
            ab.i("MicroMsg.EditVerifyCodeView", "del after str:" + editVerifyCodeView.mBuilder);
        }
        AppMethodBeat.o(134410);
    }
}
