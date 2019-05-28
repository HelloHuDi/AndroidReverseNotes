package com.tencent.mm.plugin.story.ui.view.gallery;

import a.f.b.j;
import a.l;
import a.y;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.ah;
import com.tencent.smtt.sdk.WebView;

@l(dWo = {1, 1, 13}, dWp = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u00105\u001a\u00020\u0016H\u0002J\b\u00106\u001a\u00020\u0016H\u0002J\b\u00107\u001a\u00020\u0016H\u0002J\u0012\u00108\u001a\u00020\u00162\b\u00109\u001a\u0004\u0018\u00010:H\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\"\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\"\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR\u0010\u0010$\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u000f\"\u0004\b+\u0010\u0011R\u001a\u0010,\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u000f\"\u0004\b.\u0010\u0011R\u001a\u0010/\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u000f\"\u0004\b1\u0010\u0011R\u001a\u00102\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u000f\"\u0004\b4\u0010\u0011¨\u0006;"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog;", "Landroid/support/design/widget/BottomSheetDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "delete", "Landroid/view/View;", "deleteIcon", "Landroid/widget/ImageView;", "favorite", "favoriteIcon", "favoriteTv", "Landroid/widget/TextView;", "isFavorite", "", "()Z", "setFavorite", "(Z)V", "isPrivacy", "setPrivacy", "onDelete", "Lkotlin/Function0;", "", "getOnDelete", "()Lkotlin/jvm/functions/Function0;", "setOnDelete", "(Lkotlin/jvm/functions/Function0;)V", "onResend", "getOnResend", "setOnResend", "onSetFavorite", "getOnSetFavorite", "setOnSetFavorite", "onSetPrivacy", "getOnSetPrivacy", "setOnSetPrivacy", "privacy", "privacyIcon", "privacyTv", "resend", "resendIcon", "showDelete", "getShowDelete", "setShowDelete", "showFavorite", "getShowFavorite", "setShowFavorite", "showPrivacy", "getShowPrivacy", "setShowPrivacy", "showResend", "getShowResend", "setShowResend", "initDelBtn", "initFavoriteBtn", "initPrivacyBtn", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "plugin-story_release"})
public final class a extends android.support.design.widget.c {
    boolean ixx = true;
    private ImageView lnv;
    boolean rYr;
    boolean rvv;
    private View slL;
    private TextView slM;
    private ImageView slN;
    private View snm;
    private View snn;
    private View sno;
    private ImageView snp;
    private ImageView snq;
    private TextView snr;
    a.f.a.a<y> sns;
    a.f.a.a<y> snt;
    a.f.a.a<y> snu;
    a.f.a.a<y> snv;
    boolean snw;
    boolean snx = true;
    boolean sny = true;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements OnClickListener {
        final /* synthetic */ a snz;

        c(a aVar) {
            this.snz = aVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(110699);
            a.f.a.a aVar = this.snz.snu;
            if (aVar != null) {
                aVar.invoke();
            }
            this.snz.dismiss();
            AppMethodBeat.o(110699);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a implements OnClickListener {
        final /* synthetic */ a snz;

        a(a aVar) {
            this.snz = aVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(138935);
            a.f.a.a aVar = this.snz.sns;
            if (aVar != null) {
                aVar.invoke();
            }
            this.snz.dismiss();
            AppMethodBeat.o(138935);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements OnClickListener {
        final /* synthetic */ a snz;

        b(a aVar) {
            this.snz = aVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(110698);
            a.f.a.a aVar = this.snz.snv;
            if (aVar != null) {
                aVar.invoke();
            }
            this.snz.dismiss();
            AppMethodBeat.o(110698);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class d implements OnClickListener {
        final /* synthetic */ a snz;

        d(a aVar) {
            this.snz = aVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(110700);
            a.f.a.a aVar = this.snz.snt;
            if (aVar != null) {
                aVar.invoke();
            }
            this.snz.dismiss();
            AppMethodBeat.o(110700);
        }
    }

    public a(Context context) {
        j.p(context, "context");
        super(context);
        AppMethodBeat.i(110703);
        setContentView((int) R.layout.ayb);
        AppMethodBeat.o(110703);
    }

    public final void onCreate(Bundle bundle) {
        View view;
        TextView textView;
        AppMethodBeat.i(110702);
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.addFlags(134218752);
            window.clearFlags(2);
        }
        this.snm = findViewById(R.id.es6);
        this.snn = findViewById(R.id.ery);
        this.sno = findViewById(R.id.es3);
        this.lnv = (ImageView) findViewById(R.id.es7);
        this.snp = (ImageView) findViewById(R.id.erz);
        this.snq = (ImageView) findViewById(R.id.es4);
        this.snr = (TextView) findViewById(R.id.es5);
        this.slL = findViewById(R.id.es0);
        this.slL = findViewById(R.id.es0);
        this.slM = (TextView) findViewById(R.id.es2);
        this.slN = (ImageView) findViewById(R.id.es1);
        Context context = getContext();
        j.o(context, "context");
        int color = context.getResources().getColor(R.color.ct);
        ImageView imageView = this.lnv;
        if (imageView != null) {
            imageView.setImageDrawable(ah.f(getContext(), R.raw.delete_icon_nor, color));
        }
        ImageView imageView2 = this.snp;
        if (imageView2 != null) {
            imageView2.setImageDrawable(ah.f(getContext(), R.raw.icons_outlined_refresh, WebView.NIGHT_MODE_COLOR));
        }
        imageView2 = this.slN;
        if (imageView2 != null) {
            imageView2.setImageDrawable(ah.f(getContext(), R.raw.icons_outlined_star, WebView.NIGHT_MODE_COLOR));
        }
        View view2 = this.snn;
        if (view2 != null) {
            view2.setOnClickListener(new d(this));
        }
        if (this.snw) {
            view = this.snn;
            if (view != null) {
                view.setVisibility(0);
            }
        }
        if (this.ixx) {
            view = this.snm;
            if (view != null) {
                view.setVisibility(0);
            }
            view2 = this.snm;
            if (view2 != null) {
                view2.setOnClickListener(new a(this));
            }
        } else {
            view = this.snm;
            if (view != null) {
                view.setVisibility(8);
            }
        }
        if (this.snx) {
            view = this.sno;
            if (view != null) {
                view.setVisibility(0);
            }
            view2 = this.sno;
            if (view2 != null) {
                view2.setOnClickListener(new c(this));
            }
            if (this.rvv) {
                imageView2 = this.snq;
                if (imageView2 != null) {
                    imageView2.setImageDrawable(ah.f(getContext(), R.raw.icons_outlined_unlock, WebView.NIGHT_MODE_COLOR));
                }
                textView = this.snr;
                if (textView != null) {
                    textView.setText(getContext().getString(R.string.g_8));
                }
            } else {
                imageView2 = this.snq;
                if (imageView2 != null) {
                    imageView2.setImageDrawable(ah.f(getContext(), R.raw.icons_outlined_lock, WebView.NIGHT_MODE_COLOR));
                }
                textView = this.snr;
                if (textView != null) {
                    textView.setText(getContext().getString(R.string.g_9));
                }
            }
        } else {
            view = this.sno;
            if (view != null) {
                view.setVisibility(8);
            }
        }
        if (this.sny && com.tencent.mm.plugin.story.c.a.a.rQZ.cwU()) {
            view = this.slL;
            if (view != null) {
                view.setVisibility(0);
            }
            view2 = this.slL;
            if (view2 != null) {
                view2.setOnClickListener(new b(this));
            }
            if (this.rYr) {
                textView = this.slM;
                if (textView != null) {
                    textView.setText(getContext().getString(R.string.g_7));
                }
            } else {
                textView = this.slM;
                if (textView != null) {
                    textView.setText(getContext().getString(R.string.g_6));
                }
            }
        } else {
            view = this.slL;
            if (view != null) {
                view.setVisibility(8);
            }
        }
        view = findViewById(R.id.b9i);
        if (view != null) {
            view.setBackgroundResource(R.color.a3p);
            AppMethodBeat.o(110702);
            return;
        }
        AppMethodBeat.o(110702);
    }
}
