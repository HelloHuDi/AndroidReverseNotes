package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.scanner.util.q;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.Preference;

public final class f extends Preference implements a {
    com.tencent.mm.ui.base.preference.f ehK;
    String kXM;
    private Context mContext;
    private View mView = null;
    private ImageView qaL = null;

    public f(Context context) {
        super(context);
        AppMethodBeat.i(81031);
        setLayoutResource(R.layout.al8);
        x.a((a) this);
        this.mContext = context;
        AppMethodBeat.o(81031);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.i(81032);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.o(81032);
        return view2;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(81033);
        super.onBindView(view);
        this.qaL = (ImageView) view.findViewById(R.id.akx);
        if (!bo.isNullOrNil(this.kXM)) {
            Bitmap a = x.a(new q(this.kXM));
            if (a == null || a.isRecycled()) {
                this.qaL.setBackgroundColor(this.mContext.getResources().getColor(R.color.rq));
                this.qaL.setImageBitmap(null);
            } else {
                this.qaL.setImageBitmap(a);
                this.qaL.setBackgroundColor(0);
            }
            ((ImageView) view.findViewById(R.id.doq)).setVisibility(0);
        }
        AppMethodBeat.o(81033);
    }

    public final void m(String str, final Bitmap bitmap) {
        AppMethodBeat.i(81034);
        if (!(bo.isNullOrNil(str) || !str.equals(this.kXM) || bitmap == null || bitmap.isRecycled())) {
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(81030);
                    f.this.qaL.setImageBitmap(bitmap);
                    f.this.qaL.setBackgroundColor(0);
                    if (f.this.ehK != null) {
                        f.this.ehK.notifyDataSetChanged();
                    }
                    AppMethodBeat.o(81030);
                }
            });
        }
        AppMethodBeat.o(81034);
    }
}
