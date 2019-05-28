package com.tencent.mm.plugin.topstory.ui.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.FlowLayout;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class b extends Dialog {
    private View contentView;
    private Set<abz> sHQ = new HashSet();
    private View sHR;
    private View sHS;
    private TextView sHT;
    private FlowLayout sHU;
    private final abz sHV = new abz();

    public interface a {
        void j(Set<abz> set);

        void onDismiss();
    }

    public b(final Context context, List<abz> list, final a aVar) {
        super(context, R.style.ut);
        AppMethodBeat.i(2230);
        this.sHV.cEh = context.getString(R.string.ex0);
        for (abz abz : list) {
            if (abz.wjP) {
                this.sHV.id = abz.id;
                this.sHV.cEh = abz.cEh;
                list.remove(abz);
                break;
            }
        }
        this.contentView = LayoutInflater.from(context).inflate(R.layout.azy, null, false);
        this.sHR = this.contentView.findViewById(R.id.ewc);
        this.sHS = this.contentView.findViewById(R.id.ewh);
        this.sHT = (TextView) this.contentView.findViewById(R.id.ewe);
        this.sHT.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(2227);
                if (b.this.sHQ.isEmpty()) {
                    b.this.sHQ.add(b.this.sHV);
                }
                aVar.j(b.this.sHQ);
                b.this.dismiss();
                AppMethodBeat.o(2227);
            }
        });
        this.sHU = (FlowLayout) this.contentView.findViewById(R.id.ewf);
        for (final abz abz2 : list) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.azz, this.sHU, false);
            final TextView textView = (TextView) inflate.findViewById(R.id.ewi);
            textView.setText(abz2.cEh);
            textView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(2228);
                    if (b.this.sHQ.contains(abz2)) {
                        b.this.sHQ.remove(abz2);
                        textView.setTextColor(context.getResources().getColor(R.color.a3h));
                        textView.setBackgroundResource(R.drawable.a42);
                    } else {
                        b.this.sHQ.add(abz2);
                        textView.setTextColor(context.getResources().getColor(R.color.a3g));
                        textView.setBackgroundResource(R.drawable.a41);
                    }
                    if (b.this.sHQ.isEmpty()) {
                        b.this.sHT.setText(b.this.sHV.cEh);
                        AppMethodBeat.o(2228);
                        return;
                    }
                    b.this.sHT.setText(context.getString(R.string.ex1));
                    AppMethodBeat.o(2228);
                }
            });
            this.sHU.addView(inflate);
        }
        setContentView(this.contentView);
        setCanceledOnTouchOutside(true);
        setOnDismissListener(new OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(2229);
                aVar.onDismiss();
                AppMethodBeat.o(2229);
            }
        });
        AppMethodBeat.o(2230);
    }

    public final void a(View view, boolean z, int i, int i2) {
        AppMethodBeat.i(2231);
        super.show();
        Context context = view.getContext();
        View view2 = this.contentView;
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int height = view.getHeight();
        int i3 = ae.hy(context).x;
        view2.measure(0, 0);
        int measuredHeight = view2.getMeasuredHeight();
        int measuredWidth = view2.getMeasuredWidth();
        if (z) {
            iArr[0] = i3 - measuredWidth;
            iArr[1] = iArr2[1] - measuredHeight;
        } else {
            iArr[0] = i3 - measuredWidth;
            iArr[1] = iArr2[1] + height;
        }
        if (z) {
            this.sHS.setVisibility(0);
            this.sHR.setVisibility(8);
        } else {
            this.sHS.setVisibility(8);
            this.sHR.setVisibility(0);
        }
        iArr[0] = iArr[0] + i;
        iArr[1] = iArr[1] + i2;
        Window window = getWindow();
        window.setLayout(-2, -2);
        LayoutParams attributes = window.getAttributes();
        attributes.width = -2;
        attributes.height = -2;
        attributes.x = iArr[0];
        attributes.y = iArr[1];
        attributes.gravity = 8388659;
        window.setAttributes(attributes);
        AppMethodBeat.o(2231);
    }
}
