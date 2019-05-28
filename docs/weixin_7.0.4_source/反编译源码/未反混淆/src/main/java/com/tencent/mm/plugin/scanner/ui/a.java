package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.scanner.util.q;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public final class a extends Preference implements com.tencent.mm.platformtools.x.a {
    private f iFE;
    private ImageView iUn;
    String kWC;
    private View mView = null;
    private TextView qaI = null;
    String qaJ = null;

    public a(Context context) {
        super(context);
        AppMethodBeat.i(80899);
        setLayoutResource(R.layout.aph);
        x.a((com.tencent.mm.platformtools.x.a) this);
        AppMethodBeat.o(80899);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.i(80900);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.o(80900);
        return view2;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(80901);
        super.onBindView(view);
        this.qaI = (TextView) view.findViewById(R.id.anq);
        this.iUn = (ImageView) view.findViewById(R.id.e5a);
        if (bo.isNullOrNil(this.qaJ)) {
            this.qaI.setVisibility(8);
        } else {
            this.qaI.setText(this.qaJ);
            this.qaI.setVisibility(0);
        }
        if (!bo.isNullOrNil(this.kWC)) {
            Bitmap a = x.a(new q(this.kWC));
            if (!(a == null || a.isRecycled())) {
                this.iUn.setImageBitmap(a);
                this.iUn.setVisibility(0);
            }
        }
        AppMethodBeat.o(80901);
    }

    public final void m(String str, final Bitmap bitmap) {
        AppMethodBeat.i(80902);
        if (!(bo.isNullOrNil(str) || !str.equals(this.kWC) || bitmap == null || bitmap.isRecycled() || this.iUn == null)) {
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(80898);
                    a.this.iUn.setImageBitmap(bitmap);
                    a.this.iUn.setVisibility(0);
                    if (a.this.iFE != null) {
                        a.this.iFE.notifyDataSetChanged();
                    }
                    AppMethodBeat.o(80898);
                }
            });
        }
        AppMethodBeat.o(80902);
    }
}
