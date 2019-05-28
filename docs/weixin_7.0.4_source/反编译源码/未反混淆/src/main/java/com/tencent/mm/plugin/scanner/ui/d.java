package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.scanner.util.q;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.io.IOException;

public final class d extends Preference implements a {
    private f ehK;
    private TextView iDT = null;
    private ImageView kEn = null;
    String kux;
    private View mView = null;
    String mXp;
    private TextView qcc = null;
    String qcd;

    public d(Context context) {
        super(context);
        AppMethodBeat.i(81006);
        setLayoutResource(R.layout.akw);
        x.a((a) this);
        AppMethodBeat.o(81006);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.i(81007);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.o(81007);
        return view2;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(81008);
        super.onBindView(view);
        this.kEn = (ImageView) view.findViewById(R.id.dny);
        this.iDT = (TextView) view.findViewById(R.id.dnz);
        this.qcc = (TextView) view.findViewById(R.id.do0);
        if (bo.isNullOrNil(this.qcd)) {
            this.kEn.setVisibility(8);
        } else {
            Bitmap a = x.a(new q(this.qcd));
            if (a == null || a.isRecycled()) {
                try {
                    this.kEn.setImageBitmap(b.b(ah.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.bz.a.getDensity(null)));
                } catch (IOException e) {
                    this.kEn.setImageBitmap(null);
                }
            } else {
                this.kEn.setImageBitmap(a);
                this.kEn.setBackgroundColor(0);
            }
        }
        if (bo.isNullOrNil(this.kux)) {
            this.iDT.setVisibility(8);
        } else {
            this.iDT.setText(j.b(this.mContext, this.kux, this.iDT.getTextSize()));
        }
        if (bo.isNullOrNil(this.mXp)) {
            this.qcc.setVisibility(8);
        } else {
            this.qcc.setText(this.mXp);
        }
        if (bo.isNullOrNil(this.kux) && bo.isNullOrNil(this.qcd)) {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.dnx);
            LayoutParams layoutParams = linearLayout.getLayoutParams();
            layoutParams.height = this.mContext.getResources().getDimensionPixelSize(R.dimen.a7b);
            linearLayout.setPadding(b.b(this.mContext, 9.0f), 0, 0, 0);
            linearLayout.setLayoutParams(layoutParams);
        }
        AppMethodBeat.o(81008);
    }

    public final void m(String str, Bitmap bitmap) {
        AppMethodBeat.i(81009);
        if (!(bo.isNullOrNil(str) || !str.equals(this.qcd) || bitmap == null || bitmap.isRecycled())) {
            this.kEn.setImageBitmap(bitmap);
            this.kEn.setBackgroundColor(0);
            if (this.ehK != null) {
                this.ehK.notifyDataSetChanged();
            }
        }
        AppMethodBeat.o(81009);
    }
}
