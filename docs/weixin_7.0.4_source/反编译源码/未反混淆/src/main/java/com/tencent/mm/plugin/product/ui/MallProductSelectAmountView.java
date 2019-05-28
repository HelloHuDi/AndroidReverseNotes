package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.ugc.TXRecordCommon;

public class MallProductSelectAmountView extends LinearLayout {
    private TextView gng = null;
    private ImageView pje = null;
    private ImageView pjf = null;
    private int pjg = BaseClientBuilder.API_PRIORITY_OTHER;
    private int pjh = 1;
    private int pji = 1;
    private int pjj = this.pji;
    private a pjk = null;

    public interface a {
        void eZ(int i, int i2);

        void gF(int i);
    }

    static /* synthetic */ boolean f(MallProductSelectAmountView mallProductSelectAmountView) {
        AppMethodBeat.i(44104);
        boolean cag = mallProductSelectAmountView.cag();
        AppMethodBeat.o(44104);
        return cag;
    }

    public void setOnAmountChangeListener(a aVar) {
        this.pjk = aVar;
    }

    public MallProductSelectAmountView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(44097);
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.ala, this, true);
        this.gng = (TextView) inflate.findViewById(R.id.dot);
        this.pje = (ImageView) inflate.findViewById(R.id.dou);
        this.pjf = (ImageView) inflate.findViewById(R.id.dos);
        this.gng.setText(this.pjj);
        this.pje.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(44095);
                if (MallProductSelectAmountView.this.pjj + 1 > MallProductSelectAmountView.this.pjg) {
                    if (MallProductSelectAmountView.this.pjk != null) {
                        MallProductSelectAmountView.this.pjk.eZ(MallProductSelectAmountView.this.pjj, MallProductSelectAmountView.this.pjh);
                    }
                    AppMethodBeat.o(44095);
                    return;
                }
                MallProductSelectAmountView.this.pjj = MallProductSelectAmountView.this.pjj + 1;
                if (MallProductSelectAmountView.f(MallProductSelectAmountView.this)) {
                    MallProductSelectAmountView.this.gng.setText(MallProductSelectAmountView.this.pjj);
                }
                if (MallProductSelectAmountView.this.pjk != null) {
                    MallProductSelectAmountView.this.pjk.gF(MallProductSelectAmountView.this.pjj);
                }
                AppMethodBeat.o(44095);
            }
        });
        this.pjf.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(44096);
                if (MallProductSelectAmountView.this.pjj - 1 < MallProductSelectAmountView.this.pji) {
                    if (MallProductSelectAmountView.this.pjk != null) {
                        MallProductSelectAmountView.this.pjk.eZ(MallProductSelectAmountView.this.pjj, 2);
                    }
                    AppMethodBeat.o(44096);
                    return;
                }
                MallProductSelectAmountView.this.pjj = MallProductSelectAmountView.this.pjj - 1;
                if (MallProductSelectAmountView.f(MallProductSelectAmountView.this)) {
                    MallProductSelectAmountView.this.gng.setText(MallProductSelectAmountView.this.pjj);
                }
                MallProductSelectAmountView.f(MallProductSelectAmountView.this);
                if (MallProductSelectAmountView.this.pjk != null) {
                    MallProductSelectAmountView.this.pjk.gF(MallProductSelectAmountView.this.pjj);
                }
                AppMethodBeat.o(44096);
            }
        });
        AppMethodBeat.o(44097);
    }

    public void setAmount(int i) {
        AppMethodBeat.i(44098);
        this.pjj = i;
        if (cag()) {
            this.gng.setText(this.pjj);
            if (this.pjk != null) {
                this.pjk.gF(this.pjj);
            }
        }
        AppMethodBeat.o(44098);
    }

    private boolean cag() {
        AppMethodBeat.i(44099);
        if (this.pjj > this.pjg) {
            this.pjj = this.pjg;
            if (this.pjk != null) {
                this.pjk.gF(this.pjj);
            }
            if (this.pjk != null) {
                this.pjk.eZ(this.pjj, this.pjh);
            }
            this.gng.setText(this.pjj);
            AppMethodBeat.o(44099);
            return false;
        }
        if (this.pjj > this.pji) {
            this.pjf.setEnabled(true);
        } else if (this.pjj == this.pji) {
            this.pjf.setEnabled(false);
        } else {
            this.pjf.setEnabled(false);
            this.pjj = this.pji;
            if (this.pjk != null) {
                this.pjk.gF(this.pjj);
            }
            if (this.pjk != null) {
                this.pjk.eZ(this.pjj, 2);
            }
            this.gng.setText(this.pjj);
            AppMethodBeat.o(44099);
            return false;
        }
        AppMethodBeat.o(44099);
        return true;
    }

    public void setAddEnable(boolean z) {
        AppMethodBeat.i(TXRecordCommon.AUDIO_SAMPLERATE_44100);
        this.pje.setEnabled(z);
        AppMethodBeat.o(TXRecordCommon.AUDIO_SAMPLERATE_44100);
    }

    public void setRemoveEnable(boolean z) {
        AppMethodBeat.i(44101);
        this.pjf.setEnabled(z);
        AppMethodBeat.o(44101);
    }

    public final void eY(int i, int i2) {
        AppMethodBeat.i(44102);
        if (i > i2) {
            this.pjh = 3;
            this.pjg = i2;
        } else {
            this.pjh = 1;
            this.pjg = i;
        }
        cag();
        if (this.pjk != null) {
            this.pjk.gF(this.pjj);
        }
        AppMethodBeat.o(44102);
    }

    public void setMinAmount(int i) {
        AppMethodBeat.i(44103);
        this.pji = i;
        cag();
        AppMethodBeat.o(44103);
    }
}
