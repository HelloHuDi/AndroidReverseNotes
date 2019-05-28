package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.downloader_app.b.d;
import com.tencent.mm.plugin.downloader_app.b.d.c;

public class DeleteTaskFooterView extends LinearLayout {
    private boolean Sr = true;
    private LinearLayout kPU;
    ImageView kPV;
    LinearLayout kPW;
    TextView kPX;
    ImageView kPY;
    boolean kPZ = false;
    private c kQa = new c() {
        public final void gh(boolean z) {
            AppMethodBeat.i(136215);
            DeleteTaskFooterView deleteTaskFooterView = DeleteTaskFooterView.this;
            if (z) {
                deleteTaskFooterView.kPW.setClickable(true);
                deleteTaskFooterView.kPY.setImageResource(R.drawable.au1);
                deleteTaskFooterView.kPX.setTextColor(deleteTaskFooterView.getContext().getResources().getColor(R.color.sp));
                AppMethodBeat.o(136215);
                return;
            }
            deleteTaskFooterView.kPW.setClickable(false);
            deleteTaskFooterView.kPY.setImageResource(R.drawable.au2);
            deleteTaskFooterView.kPX.setTextColor(deleteTaskFooterView.getContext().getResources().getColor(R.color.so));
            AppMethodBeat.o(136215);
        }
    };

    public DeleteTaskFooterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(136218);
        AppMethodBeat.o(136218);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(136219);
        super.onFinishInflate();
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.s0, this, true);
        this.kPU = (LinearLayout) inflate.findViewById(R.id.b9_);
        this.kPV = (ImageView) inflate.findViewById(R.id.b9a);
        this.kPU.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(136216);
                if (DeleteTaskFooterView.this.kPZ) {
                    DeleteTaskFooterView.this.kPZ = false;
                    DeleteTaskFooterView.this.kPV.setImageResource(R.drawable.at6);
                } else {
                    DeleteTaskFooterView.this.kPZ = true;
                    DeleteTaskFooterView.this.kPV.setImageResource(R.drawable.at5);
                }
                if (DeleteTaskFooterView.this.Sr) {
                    DeleteTaskFooterView.gi(DeleteTaskFooterView.this.kPZ);
                }
                DeleteTaskFooterView.this.Sr = true;
                AppMethodBeat.o(136216);
            }
        });
        this.kPW = (LinearLayout) inflate.findViewById(R.id.b9b);
        this.kPW.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(136217);
                DeleteTaskFooterView.biS();
                AppMethodBeat.o(136217);
            }
        });
        this.kPW.setClickable(false);
        this.kPX = (TextView) inflate.findViewById(R.id.b9d);
        this.kPY = (ImageView) inflate.findViewById(R.id.b9c);
        AppMethodBeat.o(136219);
    }

    public void onAttachedToWindow() {
        AppMethodBeat.i(136220);
        super.onAttachedToWindow();
        d.a(this.kQa);
        AppMethodBeat.o(136220);
    }

    public void onDetachedFromWindow() {
        AppMethodBeat.i(136221);
        super.onDetachedFromWindow();
        d.b(this.kQa);
        AppMethodBeat.o(136221);
    }

    static /* synthetic */ void gi(boolean z) {
        AppMethodBeat.i(136222);
        d.ge(z);
        AppMethodBeat.o(136222);
    }

    static /* synthetic */ void biS() {
        AppMethodBeat.i(136223);
        d.biJ();
        AppMethodBeat.o(136223);
    }
}
