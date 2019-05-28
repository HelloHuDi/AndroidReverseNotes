package com.tencent.mm.ui.contact;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

public final class u extends LinearLayout {
    private Context context;
    private LinearLayout mpt = null;
    private List<String> zog;
    private a zoh;
    private b zoi;

    public interface a {
    }

    public interface b {
        void qB(boolean z);
    }

    public u(Context context, a aVar) {
        super(context);
        AppMethodBeat.i(33807);
        this.context = context;
        this.zoh = aVar;
        reset();
        AppMethodBeat.o(33807);
    }

    public final int getOpenIMCount() {
        AppMethodBeat.i(33808);
        if (this.zog == null) {
            AppMethodBeat.o(33808);
            return 0;
        }
        int size = this.zog.size();
        AppMethodBeat.o(33808);
        return size;
    }

    public final void reset() {
        AppMethodBeat.i(33809);
        aw.ZK();
        this.zog = c.XM().dsq();
        if (this.zog == null || this.zog.size() <= 0) {
            ab.i("MicroMsg.OpenIMListHeaderView", "openimIdList is null");
            AppMethodBeat.o(33809);
            return;
        }
        ab.i("MicroMsg.OpenIMListHeaderView", "openim list size = %s", Integer.valueOf(this.zog.size()));
        if (this.mpt == null) {
            View.inflate(getContext(), R.layout.ajr, this);
            this.mpt = (LinearLayout) findViewById(R.id.nc);
        }
        this.mpt.removeAllViews();
        for (int i = 0; i < this.zog.size(); i++) {
            v vVar = new v(getContext(), (String) this.zog.get(i));
            this.mpt.addView(vVar);
            if (i == this.zog.size() - 1) {
                View findViewById = vVar.findViewById(R.id.bhx);
                int paddingLeft = findViewById.getPaddingLeft();
                findViewById.setBackgroundResource(R.drawable.a_q);
                findViewById.setPadding(paddingLeft, 0, 0, 0);
            } else {
                vVar.findViewById(R.id.bhx).setBackground(null);
                vVar.findViewById(R.id.bhx).findViewById(R.id.dkm).setBackgroundResource(R.drawable.a_q);
            }
        }
        AppMethodBeat.o(33809);
    }

    public final void setVisibility(int i) {
        AppMethodBeat.i(33810);
        if (!(this.zoi == null || i == getVisibility())) {
            this.zoi.qB(i == 0);
        }
        super.setVisibility(i);
        AppMethodBeat.o(33810);
    }

    public final void setOnVisibilityChangeListener(b bVar) {
        this.zoi = bVar;
    }
}
