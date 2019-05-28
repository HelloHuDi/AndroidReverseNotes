package com.tencent.p177mm.plugin.appbrand.widget.p1236f;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.C46633o;
import com.tencent.p177mm.p612ui.statusbar.C5546d;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.svg.p610a.C5147a;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\f\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/widget/prompt/AppBrandPopupToast;", "Lcom/tencent/mm/ui/base/MMPopupWindow;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mIconImage", "Landroid/widget/ImageView;", "mMessageText", "Landroid/widget/TextView;", "setIconDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "setMessage", "message", "", "show", "", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.widget.f.c */
public final class C38592c extends C46633o {
    private final TextView jmD;
    private final ImageView jmE;

    public C38592c(Context context) {
        C25052j.m39376p(context, "context");
        super(context);
        AppMethodBeat.m2504i(135265);
        LayoutInflater from = LayoutInflater.from(context);
        View contentView = getContentView();
        if (contentView == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.m2505o(135265);
            throw c44941v;
        }
        setContentView(from.inflate(2130968735, (ViewGroup) contentView, false));
        contentView = getContentView().findViewById(2131821370);
        C25052j.m39375o(contentView, "contentView.findViewById<View>(R.id.progress)");
        contentView.setVisibility(8);
        contentView = getContentView().findViewById(2131821371);
        C25052j.m39375o(contentView, "contentView.findViewById(R.id.iv_icon)");
        this.jmE = (ImageView) contentView;
        contentView = getContentView().findViewById(2131820678);
        C25052j.m39375o(contentView, "contentView.findViewById(R.id.title)");
        this.jmD = (TextView) contentView;
        Drawable f = C5147a.m7837f(context.getResources(), C1318a.app_brand_show_toast_success);
        this.jmE.setVisibility(0);
        this.jmE.setScaleType(ScaleType.FIT_CENTER);
        this.jmE.setImageDrawable(f);
        AppMethodBeat.m2505o(135265);
    }

    /* renamed from: F */
    public final C38592c mo61377F(CharSequence charSequence) {
        AppMethodBeat.m2504i(135263);
        int i = (charSequence == null || charSequence.length() == 0) ? 1 : 0;
        if (i == 0) {
            this.jmD.setLineSpacing(0.0f, 1.0f);
            TextView textView = this.jmD;
            View contentView = getContentView();
            C25052j.m39375o(contentView, "contentView");
            textView.setSpannableFactory(new C19856e(C1338a.fromDPToPix(contentView.getContext(), 18)));
            this.jmD.setText(charSequence, BufferType.SPANNABLE);
            this.jmD.setVisibility(0);
            View contentView2 = getContentView();
            C25052j.m39375o(contentView2, "contentView");
            getContentView().findViewById(2131821369).setPadding(0, C1338a.fromDPToPix(contentView2.getContext(), 27), 0, 0);
        } else {
            this.jmD.setVisibility(4);
        }
        AppMethodBeat.m2505o(135263);
        return this;
    }

    public final void show() {
        AppMethodBeat.m2504i(135264);
        View contentView = getContentView();
        C25052j.m39375o(contentView, "contentView");
        Activity cY = C5546d.m8371cY(contentView.getContext());
        if (cY != null) {
            super.showAtLocation(cY.findViewById(16908290), 17, 0, 0);
            C5004al.m7442n(new C27393d(this), 1500);
            AppMethodBeat.m2505o(135264);
            return;
        }
        AppMethodBeat.m2505o(135264);
    }
}
