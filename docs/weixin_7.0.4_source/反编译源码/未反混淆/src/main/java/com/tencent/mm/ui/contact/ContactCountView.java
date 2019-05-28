package com.tencent.mm.ui.contact;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.platformtools.ab;

public class ContactCountView extends FrameLayout {
    private boolean aIB = true;
    private int count = 0;
    private View gbS;
    private TextView nBf;
    private int zlu = 1;

    public ContactCountView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(33601);
        init();
        AppMethodBeat.o(33601);
    }

    public ContactCountView(Context context) {
        super(context);
        AppMethodBeat.i(33602);
        init();
        AppMethodBeat.o(33602);
    }

    private void init() {
        AppMethodBeat.i(33603);
        inflate(getContext(), R.layout.pz, this);
        AppMethodBeat.o(33603);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(33604);
        ab.d("MicroMsg.ContactCountView", "onMeasure");
        if (this.gbS == null) {
            this.gbS = (FrameLayout) findViewById(R.id.b1e);
            this.nBf = (TextView) findViewById(R.id.b1f);
        }
        dHF();
        super.onMeasure(i, i2);
        AppMethodBeat.o(33604);
    }

    public void setContactType(int i) {
        this.zlu = i;
    }

    public final void dHF() {
        AppMethodBeat.i(33605);
        String[] strArr = t.fkY;
        if (this.zlu == 1) {
            aw.ZK();
            this.count = c.XM().b(strArr, r.Yz(), "weixin", "helper_entry", "filehelper");
        } else {
            aw.ZK();
            this.count = c.XM().c(strArr, r.Yz(), "weixin", "helper_entry", "filehelper");
        }
        ab.d("MicroMsg.ContactCountView", "contact count %d", Integer.valueOf(this.count));
        if (this.nBf != null) {
            if (this.zlu == 1) {
                this.nBf.setText(getContext().getResources().getQuantityString(R.plurals.b, this.count, new Object[]{Integer.valueOf(this.count)}));
            } else {
                this.nBf.setText(getContext().getResources().getQuantityString(R.plurals.a, this.count, new Object[]{Integer.valueOf(this.count)}));
            }
        }
        setVisible(this.aIB);
        AppMethodBeat.o(33605);
    }

    public void setVisible(boolean z) {
        AppMethodBeat.i(33606);
        this.aIB = z;
        if (this.gbS != null) {
            View view = this.gbS;
            int i = (!z || this.count <= 0) ? 8 : 0;
            view.setVisibility(i);
        }
        AppMethodBeat.o(33606);
    }
}
