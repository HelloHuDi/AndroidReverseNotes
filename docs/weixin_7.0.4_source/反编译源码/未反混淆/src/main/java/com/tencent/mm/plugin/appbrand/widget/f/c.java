package com.tencent.mm.plugin.appbrand.widget.f;

import a.f.b.j;
import a.l;
import a.v;
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
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.svg.a.a;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.statusbar.d;

@l(dWo = {1, 1, 13}, dWp = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\f\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/widget/prompt/AppBrandPopupToast;", "Lcom/tencent/mm/ui/base/MMPopupWindow;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mIconImage", "Landroid/widget/ImageView;", "mMessageText", "Landroid/widget/TextView;", "setIconDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "setMessage", "message", "", "show", "", "plugin-appbrand-integration_release"})
public final class c extends o {
    private final TextView jmD;
    private final ImageView jmE;

    public c(Context context) {
        j.p(context, "context");
        super(context);
        AppMethodBeat.i(135265);
        LayoutInflater from = LayoutInflater.from(context);
        View contentView = getContentView();
        if (contentView == null) {
            v vVar = new v("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(135265);
            throw vVar;
        }
        setContentView(from.inflate(R.layout.dl, (ViewGroup) contentView, false));
        contentView = getContentView().findViewById(R.id.vm);
        j.o(contentView, "contentView.findViewById<View>(R.id.progress)");
        contentView.setVisibility(8);
        contentView = getContentView().findViewById(R.id.vn);
        j.o(contentView, "contentView.findViewById(R.id.iv_icon)");
        this.jmE = (ImageView) contentView;
        contentView = getContentView().findViewById(R.id.cx);
        j.o(contentView, "contentView.findViewById(R.id.title)");
        this.jmD = (TextView) contentView;
        Drawable f = a.f(context.getResources(), R.raw.app_brand_show_toast_success);
        this.jmE.setVisibility(0);
        this.jmE.setScaleType(ScaleType.FIT_CENTER);
        this.jmE.setImageDrawable(f);
        AppMethodBeat.o(135265);
    }

    public final c F(CharSequence charSequence) {
        AppMethodBeat.i(135263);
        int i = (charSequence == null || charSequence.length() == 0) ? 1 : 0;
        if (i == 0) {
            this.jmD.setLineSpacing(0.0f, 1.0f);
            TextView textView = this.jmD;
            View contentView = getContentView();
            j.o(contentView, "contentView");
            textView.setSpannableFactory(new e(com.tencent.mm.bz.a.fromDPToPix(contentView.getContext(), 18)));
            this.jmD.setText(charSequence, BufferType.SPANNABLE);
            this.jmD.setVisibility(0);
            View contentView2 = getContentView();
            j.o(contentView2, "contentView");
            getContentView().findViewById(R.id.vl).setPadding(0, com.tencent.mm.bz.a.fromDPToPix(contentView2.getContext(), 27), 0, 0);
        } else {
            this.jmD.setVisibility(4);
        }
        AppMethodBeat.o(135263);
        return this;
    }

    public final void show() {
        AppMethodBeat.i(135264);
        View contentView = getContentView();
        j.o(contentView, "contentView");
        Activity cY = d.cY(contentView.getContext());
        if (cY != null) {
            super.showAtLocation(cY.findViewById(16908290), 17, 0, 0);
            al.n(new d(this), 1500);
            AppMethodBeat.o(135264);
            return;
        }
        AppMethodBeat.o(135264);
    }
}
