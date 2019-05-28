package com.tencent.p177mm.plugin.topstory.p541ui.widget;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.base.FlowLayout;
import com.tencent.p177mm.protocal.protobuf.abz;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.topstory.ui.widget.b */
public final class C46312b extends Dialog {
    private View contentView;
    private Set<abz> sHQ = new HashSet();
    private View sHR;
    private View sHS;
    private TextView sHT;
    private FlowLayout sHU;
    private final abz sHV = new abz();

    /* renamed from: com.tencent.mm.plugin.topstory.ui.widget.b$a */
    public interface C35321a {
        /* renamed from: j */
        void mo9153j(Set<abz> set);

        void onDismiss();
    }

    public C46312b(final Context context, List<abz> list, final C35321a c35321a) {
        super(context, C25738R.style.f11263ut);
        AppMethodBeat.m2504i(2230);
        this.sHV.cEh = context.getString(C25738R.string.ex0);
        for (abz abz : list) {
            if (abz.wjP) {
                this.sHV.f16202id = abz.f16202id;
                this.sHV.cEh = abz.cEh;
                list.remove(abz);
                break;
            }
        }
        this.contentView = LayoutInflater.from(context).inflate(2130970937, null, false);
        this.sHR = this.contentView.findViewById(2131828252);
        this.sHS = this.contentView.findViewById(2131828257);
        this.sHT = (TextView) this.contentView.findViewById(2131828254);
        this.sHT.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(2227);
                if (C46312b.this.sHQ.isEmpty()) {
                    C46312b.this.sHQ.add(C46312b.this.sHV);
                }
                c35321a.mo9153j(C46312b.this.sHQ);
                C46312b.this.dismiss();
                AppMethodBeat.m2505o(2227);
            }
        });
        this.sHU = (FlowLayout) this.contentView.findViewById(2131828255);
        for (final abz abz2 : list) {
            View inflate = LayoutInflater.from(context).inflate(2130970938, this.sHU, false);
            final TextView textView = (TextView) inflate.findViewById(2131828258);
            textView.setText(abz2.cEh);
            textView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(2228);
                    if (C46312b.this.sHQ.contains(abz2)) {
                        C46312b.this.sHQ.remove(abz2);
                        textView.setTextColor(context.getResources().getColor(C25738R.color.a3h));
                        textView.setBackgroundResource(C25738R.drawable.a42);
                    } else {
                        C46312b.this.sHQ.add(abz2);
                        textView.setTextColor(context.getResources().getColor(C25738R.color.a3g));
                        textView.setBackgroundResource(C25738R.drawable.a41);
                    }
                    if (C46312b.this.sHQ.isEmpty()) {
                        C46312b.this.sHT.setText(C46312b.this.sHV.cEh);
                        AppMethodBeat.m2505o(2228);
                        return;
                    }
                    C46312b.this.sHT.setText(context.getString(C25738R.string.ex1));
                    AppMethodBeat.m2505o(2228);
                }
            });
            this.sHU.addView(inflate);
        }
        setContentView(this.contentView);
        setCanceledOnTouchOutside(true);
        setOnDismissListener(new OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(2229);
                c35321a.onDismiss();
                AppMethodBeat.m2505o(2229);
            }
        });
        AppMethodBeat.m2505o(2230);
    }

    /* renamed from: a */
    public final void mo74508a(View view, boolean z, int i, int i2) {
        AppMethodBeat.m2504i(2231);
        super.show();
        Context context = view.getContext();
        View view2 = this.contentView;
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int height = view.getHeight();
        int i3 = C5222ae.m7953hy(context).x;
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
        AppMethodBeat.m2505o(2231);
    }
}
