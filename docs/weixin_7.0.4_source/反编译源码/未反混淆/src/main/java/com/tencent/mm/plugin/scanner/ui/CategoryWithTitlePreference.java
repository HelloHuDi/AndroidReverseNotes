package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.scanner.util.q;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public final class CategoryWithTitlePreference extends Preference implements a {
    private int cIZ;
    private int cJa;
    private Context context;
    private f ehK;
    private TextView gne;
    private String iconUrl;
    private ImageView iyo;
    private String title;

    public CategoryWithTitlePreference(Context context) {
        this(context, null);
    }

    public CategoryWithTitlePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CategoryWithTitlePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(81001);
        this.title = "";
        this.cIZ = 34;
        this.cJa = 34;
        setLayoutResource(R.layout.ae_);
        this.context = context;
        x.a((a) this);
        AppMethodBeat.o(81001);
    }

    public final void setTitle(CharSequence charSequence) {
        AppMethodBeat.i(81002);
        if (charSequence != null && charSequence.length() > 0) {
            this.title = charSequence.toString();
            if (this.gne != null) {
                this.gne.setVisibility(0);
                this.gne.setText(charSequence);
                ab.v("MicroMsg.scanner.CategoryWithTitlePreference", "title : " + this.gne.getText());
            }
        } else if (this.gne != null) {
            this.gne.setVisibility(8);
        }
        super.setTitle(charSequence);
        AppMethodBeat.o(81002);
    }

    public final void setTitle(int i) {
        AppMethodBeat.i(81003);
        if (this.gne != null) {
            if (this.context != null) {
                this.title = this.context.getString(i);
            }
            if (bo.isNullOrNil(this.title)) {
                this.gne.setVisibility(8);
            } else {
                this.gne.setVisibility(0);
                this.gne.setText(this.title);
            }
        }
        super.setTitle(i);
        AppMethodBeat.o(81003);
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(81004);
        super.onBindView(view);
        this.gne = (TextView) view.findViewById(16908310);
        this.iyo = (ImageView) view.findViewById(R.id.jb);
        LayoutParams layoutParams = this.iyo.getLayoutParams();
        layoutParams.width = b.b(this.context, (float) (this.cIZ / 2));
        layoutParams.height = b.b(this.context, (float) (this.cJa / 2));
        this.iyo.setLayoutParams(layoutParams);
        if (!(this.title == null || this.title.length() <= 0 || this.gne == null)) {
            this.gne.setVisibility(0);
            this.gne.setText(this.title);
            ab.v("MicroMsg.scanner.CategoryWithTitlePreference", "onBindView title : " + this.gne.getText());
        }
        if (!bo.isNullOrNil(this.iconUrl)) {
            Bitmap a = x.a(new q(this.iconUrl));
            if (!(a == null || a.isRecycled())) {
                this.iyo.setImageBitmap(a);
                this.iyo.setVisibility(0);
            }
        }
        AppMethodBeat.o(81004);
    }

    public final void m(String str, final Bitmap bitmap) {
        AppMethodBeat.i(81005);
        ab.d("MicroMsg.scanner.CategoryWithTitlePreference", "get pic:" + str + ", iconurl:" + this.iconUrl);
        if (!(bo.isNullOrNil(str) || !str.equals(this.iconUrl) || bitmap == null || bitmap.isRecycled() || this.iyo == null)) {
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(81000);
                    CategoryWithTitlePreference.this.iyo.setImageBitmap(bitmap);
                    CategoryWithTitlePreference.this.iyo.setVisibility(0);
                    if (CategoryWithTitlePreference.this.ehK != null) {
                        CategoryWithTitlePreference.this.ehK.notifyDataSetChanged();
                    }
                    AppMethodBeat.o(81000);
                }
            });
        }
        AppMethodBeat.o(81005);
    }

    public final /* bridge */ /* synthetic */ CharSequence getTitle() {
        return this.title;
    }
}
