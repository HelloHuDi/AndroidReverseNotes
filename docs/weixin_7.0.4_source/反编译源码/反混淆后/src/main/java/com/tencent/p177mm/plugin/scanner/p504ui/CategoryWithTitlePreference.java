package com.tencent.p177mm.plugin.scanner.p504ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.platformtools.C18764x;
import com.tencent.p177mm.platformtools.C18764x.C18765a;
import com.tencent.p177mm.plugin.scanner.util.C43498q;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.scanner.ui.CategoryWithTitlePreference */
public final class CategoryWithTitlePreference extends Preference implements C18765a {
    private int cIZ;
    private int cJa;
    private Context context;
    private C15541f ehK;
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
        AppMethodBeat.m2504i(81001);
        this.title = "";
        this.cIZ = 34;
        this.cJa = 34;
        setLayoutResource(2130970133);
        this.context = context;
        C18764x.m29326a((C18765a) this);
        AppMethodBeat.m2505o(81001);
    }

    public final void setTitle(CharSequence charSequence) {
        AppMethodBeat.m2504i(81002);
        if (charSequence != null && charSequence.length() > 0) {
            this.title = charSequence.toString();
            if (this.gne != null) {
                this.gne.setVisibility(0);
                this.gne.setText(charSequence);
                C4990ab.m7418v("MicroMsg.scanner.CategoryWithTitlePreference", "title : " + this.gne.getText());
            }
        } else if (this.gne != null) {
            this.gne.setVisibility(8);
        }
        super.setTitle(charSequence);
        AppMethodBeat.m2505o(81002);
    }

    public final void setTitle(int i) {
        AppMethodBeat.m2504i(81003);
        if (this.gne != null) {
            if (this.context != null) {
                this.title = this.context.getString(i);
            }
            if (C5046bo.isNullOrNil(this.title)) {
                this.gne.setVisibility(8);
            } else {
                this.gne.setVisibility(0);
                this.gne.setText(this.title);
            }
        }
        super.setTitle(i);
        AppMethodBeat.m2505o(81003);
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(81004);
        super.onBindView(view);
        this.gne = (TextView) view.findViewById(16908310);
        this.iyo = (ImageView) view.findViewById(2131820915);
        LayoutParams layoutParams = this.iyo.getLayoutParams();
        layoutParams.width = C4977b.m7371b(this.context, (float) (this.cIZ / 2));
        layoutParams.height = C4977b.m7371b(this.context, (float) (this.cJa / 2));
        this.iyo.setLayoutParams(layoutParams);
        if (!(this.title == null || this.title.length() <= 0 || this.gne == null)) {
            this.gne.setVisibility(0);
            this.gne.setText(this.title);
            C4990ab.m7418v("MicroMsg.scanner.CategoryWithTitlePreference", "onBindView title : " + this.gne.getText());
        }
        if (!C5046bo.isNullOrNil(this.iconUrl)) {
            Bitmap a = C18764x.m29325a(new C43498q(this.iconUrl));
            if (!(a == null || a.isRecycled())) {
                this.iyo.setImageBitmap(a);
                this.iyo.setVisibility(0);
            }
        }
        AppMethodBeat.m2505o(81004);
    }

    /* renamed from: m */
    public final void mo8136m(String str, final Bitmap bitmap) {
        AppMethodBeat.m2504i(81005);
        C4990ab.m7410d("MicroMsg.scanner.CategoryWithTitlePreference", "get pic:" + str + ", iconurl:" + this.iconUrl);
        if (!(C5046bo.isNullOrNil(str) || !str.equals(this.iconUrl) || bitmap == null || bitmap.isRecycled() || this.iyo == null)) {
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(81000);
                    CategoryWithTitlePreference.this.iyo.setImageBitmap(bitmap);
                    CategoryWithTitlePreference.this.iyo.setVisibility(0);
                    if (CategoryWithTitlePreference.this.ehK != null) {
                        CategoryWithTitlePreference.this.ehK.notifyDataSetChanged();
                    }
                    AppMethodBeat.m2505o(81000);
                }
            });
        }
        AppMethodBeat.m2505o(81005);
    }

    public final /* bridge */ /* synthetic */ CharSequence getTitle() {
        return this.title;
    }
}
