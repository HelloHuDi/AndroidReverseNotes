package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class g {
    public View mParentView;
    public PopupWindow uPB;
    public a uPC;

    public interface a {
        void deD();

        void deE();

        void deF();

        void deG();
    }

    public g(Context context, View view) {
        AppMethodBeat.i(26779);
        this.mParentView = view;
        View inflate = LayoutInflater.from(context).inflate(R.layout.b7u, null);
        inflate.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        this.uPB = new PopupWindow(inflate, -2, -2, false);
        this.uPB.setClippingEnabled(false);
        inflate.findViewById(R.id.fli).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(26775);
                g.this.uPB.dismiss();
                g.this.mParentView.setVisibility(8);
                if (g.this.uPC != null) {
                    g.this.uPC.deD();
                }
                AppMethodBeat.o(26775);
            }
        });
        inflate.findViewById(R.id.flj).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(26776);
                g.this.uPB.dismiss();
                g.this.mParentView.setVisibility(8);
                if (g.this.uPC != null) {
                    g.this.uPC.deE();
                }
                AppMethodBeat.o(26776);
            }
        });
        inflate.findViewById(R.id.flk).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(26777);
                g.this.uPB.dismiss();
                g.this.mParentView.setVisibility(8);
                if (g.this.uPC != null) {
                    g.this.uPC.deF();
                }
                AppMethodBeat.o(26777);
            }
        });
        inflate.findViewById(R.id.fll).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(26778);
                g.this.uPB.dismiss();
                g.this.mParentView.setVisibility(8);
                if (g.this.uPC != null) {
                    g.this.uPC.deG();
                }
                AppMethodBeat.o(26778);
            }
        });
        AppMethodBeat.o(26779);
    }
}
