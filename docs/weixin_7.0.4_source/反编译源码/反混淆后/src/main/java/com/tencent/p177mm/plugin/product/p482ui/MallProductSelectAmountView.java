package com.tencent.p177mm.plugin.product.p482ui;

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
import com.tencent.ugc.TXRecordCommon;

/* renamed from: com.tencent.mm.plugin.product.ui.MallProductSelectAmountView */
public class MallProductSelectAmountView extends LinearLayout {
    private TextView gng = null;
    private ImageView pje = null;
    private ImageView pjf = null;
    private int pjg = BaseClientBuilder.API_PRIORITY_OTHER;
    private int pjh = 1;
    private int pji = 1;
    private int pjj = this.pji;
    private C21442a pjk = null;

    /* renamed from: com.tencent.mm.plugin.product.ui.MallProductSelectAmountView$1 */
    class C128191 implements OnClickListener {
        C128191() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(44095);
            if (MallProductSelectAmountView.this.pjj + 1 > MallProductSelectAmountView.this.pjg) {
                if (MallProductSelectAmountView.this.pjk != null) {
                    MallProductSelectAmountView.this.pjk.mo36911eZ(MallProductSelectAmountView.this.pjj, MallProductSelectAmountView.this.pjh);
                }
                AppMethodBeat.m2505o(44095);
                return;
            }
            MallProductSelectAmountView.this.pjj = MallProductSelectAmountView.this.pjj + 1;
            if (MallProductSelectAmountView.m32885f(MallProductSelectAmountView.this)) {
                MallProductSelectAmountView.this.gng.setText(MallProductSelectAmountView.this.pjj);
            }
            if (MallProductSelectAmountView.this.pjk != null) {
                MallProductSelectAmountView.this.pjk.mo36912gF(MallProductSelectAmountView.this.pjj);
            }
            AppMethodBeat.m2505o(44095);
        }
    }

    /* renamed from: com.tencent.mm.plugin.product.ui.MallProductSelectAmountView$2 */
    class C128202 implements OnClickListener {
        C128202() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(44096);
            if (MallProductSelectAmountView.this.pjj - 1 < MallProductSelectAmountView.this.pji) {
                if (MallProductSelectAmountView.this.pjk != null) {
                    MallProductSelectAmountView.this.pjk.mo36911eZ(MallProductSelectAmountView.this.pjj, 2);
                }
                AppMethodBeat.m2505o(44096);
                return;
            }
            MallProductSelectAmountView.this.pjj = MallProductSelectAmountView.this.pjj - 1;
            if (MallProductSelectAmountView.m32885f(MallProductSelectAmountView.this)) {
                MallProductSelectAmountView.this.gng.setText(MallProductSelectAmountView.this.pjj);
            }
            MallProductSelectAmountView.m32885f(MallProductSelectAmountView.this);
            if (MallProductSelectAmountView.this.pjk != null) {
                MallProductSelectAmountView.this.pjk.mo36912gF(MallProductSelectAmountView.this.pjj);
            }
            AppMethodBeat.m2505o(44096);
        }
    }

    /* renamed from: com.tencent.mm.plugin.product.ui.MallProductSelectAmountView$a */
    public interface C21442a {
        /* renamed from: eZ */
        void mo36911eZ(int i, int i2);

        /* renamed from: gF */
        void mo36912gF(int i);
    }

    /* renamed from: f */
    static /* synthetic */ boolean m32885f(MallProductSelectAmountView mallProductSelectAmountView) {
        AppMethodBeat.m2504i(44104);
        boolean cag = mallProductSelectAmountView.cag();
        AppMethodBeat.m2505o(44104);
        return cag;
    }

    public void setOnAmountChangeListener(C21442a c21442a) {
        this.pjk = c21442a;
    }

    public MallProductSelectAmountView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(44097);
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(2130970394, this, true);
        this.gng = (TextView) inflate.findViewById(2131826604);
        this.pje = (ImageView) inflate.findViewById(2131826605);
        this.pjf = (ImageView) inflate.findViewById(2131826603);
        this.gng.setText(this.pjj);
        this.pje.setOnClickListener(new C128191());
        this.pjf.setOnClickListener(new C128202());
        AppMethodBeat.m2505o(44097);
    }

    public void setAmount(int i) {
        AppMethodBeat.m2504i(44098);
        this.pjj = i;
        if (cag()) {
            this.gng.setText(this.pjj);
            if (this.pjk != null) {
                this.pjk.mo36912gF(this.pjj);
            }
        }
        AppMethodBeat.m2505o(44098);
    }

    private boolean cag() {
        AppMethodBeat.m2504i(44099);
        if (this.pjj > this.pjg) {
            this.pjj = this.pjg;
            if (this.pjk != null) {
                this.pjk.mo36912gF(this.pjj);
            }
            if (this.pjk != null) {
                this.pjk.mo36911eZ(this.pjj, this.pjh);
            }
            this.gng.setText(this.pjj);
            AppMethodBeat.m2505o(44099);
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
                this.pjk.mo36912gF(this.pjj);
            }
            if (this.pjk != null) {
                this.pjk.mo36911eZ(this.pjj, 2);
            }
            this.gng.setText(this.pjj);
            AppMethodBeat.m2505o(44099);
            return false;
        }
        AppMethodBeat.m2505o(44099);
        return true;
    }

    public void setAddEnable(boolean z) {
        AppMethodBeat.m2504i(TXRecordCommon.AUDIO_SAMPLERATE_44100);
        this.pje.setEnabled(z);
        AppMethodBeat.m2505o(TXRecordCommon.AUDIO_SAMPLERATE_44100);
    }

    public void setRemoveEnable(boolean z) {
        AppMethodBeat.m2504i(44101);
        this.pjf.setEnabled(z);
        AppMethodBeat.m2505o(44101);
    }

    /* renamed from: eY */
    public final void mo36905eY(int i, int i2) {
        AppMethodBeat.m2504i(44102);
        if (i > i2) {
            this.pjh = 3;
            this.pjg = i2;
        } else {
            this.pjh = 1;
            this.pjg = i;
        }
        cag();
        if (this.pjk != null) {
            this.pjk.mo36912gF(this.pjj);
        }
        AppMethodBeat.m2505o(44102);
    }

    public void setMinAmount(int i) {
        AppMethodBeat.m2504i(44103);
        this.pji = i;
        cag();
        AppMethodBeat.m2505o(44103);
    }
}
