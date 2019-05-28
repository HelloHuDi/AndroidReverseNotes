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
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public final class b extends Preference implements a {
    f ehK;
    String kXM;
    private Context mContext;
    private View mView = null;
    private ImageView qaL = null;

    public b(Context context) {
        super(context);
        AppMethodBeat.i(80903);
        setLayoutResource(R.layout.aku);
        x.a((a) this);
        this.mContext = context;
        AppMethodBeat.o(80903);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.i(80904);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.o(80904);
        return view2;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(80905);
        super.onBindView(view);
        this.qaL = (ImageView) view.findViewById(R.id.dnw);
        if (!bo.isNullOrNil(this.kXM)) {
            Bitmap a = x.a(new q(this.kXM));
            if (a == null || a.isRecycled()) {
                this.qaL.setBackgroundColor(this.mContext.getResources().getColor(R.color.rq));
                this.qaL.setImageBitmap(null);
            } else {
                this.qaL.setImageBitmap(a);
                this.qaL.setBackgroundColor(0);
                AppMethodBeat.o(80905);
                return;
            }
        }
        AppMethodBeat.o(80905);
    }

    public final void m(String str, Bitmap bitmap) {
        AppMethodBeat.i(80906);
        if (!(bo.isNullOrNil(str) || !str.equals(this.kXM) || bitmap == null || bitmap.isRecycled())) {
            this.qaL.setImageBitmap(bitmap);
            this.qaL.setBackgroundColor(0);
            if (this.ehK != null) {
                this.ehK.notifyDataSetChanged();
            }
        }
        AppMethodBeat.o(80906);
    }
}
