package com.tencent.p177mm.plugin.story.p536ui.view.gallery;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.C17391c;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p612ui.C5225ah;
import com.tencent.p177mm.plugin.story.p1032c.p1033a.C29274a;
import com.tencent.smtt.sdk.WebView;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u00105\u001a\u00020\u0016H\u0002J\b\u00106\u001a\u00020\u0016H\u0002J\b\u00107\u001a\u00020\u0016H\u0002J\u0012\u00108\u001a\u00020\u00162\b\u00109\u001a\u0004\u0018\u00010:H\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\"\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\"\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR\u0010\u0010$\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u000f\"\u0004\b+\u0010\u0011R\u001a\u0010,\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u000f\"\u0004\b.\u0010\u0011R\u001a\u0010/\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u000f\"\u0004\b1\u0010\u0011R\u001a\u00102\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u000f\"\u0004\b4\u0010\u0011¨\u0006;"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog;", "Landroid/support/design/widget/BottomSheetDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "delete", "Landroid/view/View;", "deleteIcon", "Landroid/widget/ImageView;", "favorite", "favoriteIcon", "favoriteTv", "Landroid/widget/TextView;", "isFavorite", "", "()Z", "setFavorite", "(Z)V", "isPrivacy", "setPrivacy", "onDelete", "Lkotlin/Function0;", "", "getOnDelete", "()Lkotlin/jvm/functions/Function0;", "setOnDelete", "(Lkotlin/jvm/functions/Function0;)V", "onResend", "getOnResend", "setOnResend", "onSetFavorite", "getOnSetFavorite", "setOnSetFavorite", "onSetPrivacy", "getOnSetPrivacy", "setOnSetPrivacy", "privacy", "privacyIcon", "privacyTv", "resend", "resendIcon", "showDelete", "getShowDelete", "setShowDelete", "showFavorite", "getShowFavorite", "setShowFavorite", "showPrivacy", "getShowPrivacy", "setShowPrivacy", "showResend", "getShowResend", "setShowResend", "initDelBtn", "initFavoriteBtn", "initPrivacyBtn", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.a */
public final class C29366a extends C17391c {
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
    C31214a<C37091y> sns;
    C31214a<C37091y> snt;
    C31214a<C37091y> snu;
    C31214a<C37091y> snv;
    boolean snw;
    boolean snx = true;
    boolean sny = true;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.a$c */
    static final class C29367c implements OnClickListener {
        final /* synthetic */ C29366a snz;

        C29367c(C29366a c29366a) {
            this.snz = c29366a;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110699);
            C31214a c31214a = this.snz.snu;
            if (c31214a != null) {
                c31214a.invoke();
            }
            this.snz.dismiss();
            AppMethodBeat.m2505o(110699);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.a$a */
    static final class C29368a implements OnClickListener {
        final /* synthetic */ C29366a snz;

        C29368a(C29366a c29366a) {
            this.snz = c29366a;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(138935);
            C31214a c31214a = this.snz.sns;
            if (c31214a != null) {
                c31214a.invoke();
            }
            this.snz.dismiss();
            AppMethodBeat.m2505o(138935);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.a$b */
    static final class C29369b implements OnClickListener {
        final /* synthetic */ C29366a snz;

        C29369b(C29366a c29366a) {
            this.snz = c29366a;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110698);
            C31214a c31214a = this.snz.snv;
            if (c31214a != null) {
                c31214a.invoke();
            }
            this.snz.dismiss();
            AppMethodBeat.m2505o(110698);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.a$d */
    static final class C29370d implements OnClickListener {
        final /* synthetic */ C29366a snz;

        C29370d(C29366a c29366a) {
            this.snz = c29366a;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110700);
            C31214a c31214a = this.snz.snt;
            if (c31214a != null) {
                c31214a.invoke();
            }
            this.snz.dismiss();
            AppMethodBeat.m2505o(110700);
        }
    }

    public C29366a(Context context) {
        C25052j.m39376p(context, "context");
        super(context);
        AppMethodBeat.m2504i(110703);
        setContentView(2130970875);
        AppMethodBeat.m2505o(110703);
    }

    public final void onCreate(Bundle bundle) {
        View view;
        TextView textView;
        AppMethodBeat.m2504i(110702);
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.addFlags(134218752);
            window.clearFlags(2);
        }
        this.snm = findViewById(2131828097);
        this.snn = findViewById(2131828089);
        this.sno = findViewById(2131828094);
        this.lnv = (ImageView) findViewById(2131828098);
        this.snp = (ImageView) findViewById(2131828090);
        this.snq = (ImageView) findViewById(2131828095);
        this.snr = (TextView) findViewById(2131828096);
        this.slL = findViewById(2131828091);
        this.slL = findViewById(2131828091);
        this.slM = (TextView) findViewById(2131828093);
        this.slN = (ImageView) findViewById(2131828092);
        Context context = getContext();
        C25052j.m39375o(context, "context");
        int color = context.getResources().getColor(C25738R.color.f11671ct);
        ImageView imageView = this.lnv;
        if (imageView != null) {
            imageView.setImageDrawable(C5225ah.m7962f(getContext(), C1318a.delete_icon_nor, color));
        }
        ImageView imageView2 = this.snp;
        if (imageView2 != null) {
            imageView2.setImageDrawable(C5225ah.m7962f(getContext(), C1318a.icons_outlined_refresh, WebView.NIGHT_MODE_COLOR));
        }
        imageView2 = this.slN;
        if (imageView2 != null) {
            imageView2.setImageDrawable(C5225ah.m7962f(getContext(), C1318a.icons_outlined_star, WebView.NIGHT_MODE_COLOR));
        }
        View view2 = this.snn;
        if (view2 != null) {
            view2.setOnClickListener(new C29370d(this));
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
                view2.setOnClickListener(new C29368a(this));
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
                view2.setOnClickListener(new C29367c(this));
            }
            if (this.rvv) {
                imageView2 = this.snq;
                if (imageView2 != null) {
                    imageView2.setImageDrawable(C5225ah.m7962f(getContext(), C1318a.icons_outlined_unlock, WebView.NIGHT_MODE_COLOR));
                }
                textView = this.snr;
                if (textView != null) {
                    textView.setText(getContext().getString(C25738R.string.g_8));
                }
            } else {
                imageView2 = this.snq;
                if (imageView2 != null) {
                    imageView2.setImageDrawable(C5225ah.m7962f(getContext(), C1318a.icons_outlined_lock, WebView.NIGHT_MODE_COLOR));
                }
                textView = this.snr;
                if (textView != null) {
                    textView.setText(getContext().getString(C25738R.string.g_9));
                }
            }
        } else {
            view = this.sno;
            if (view != null) {
                view.setVisibility(8);
            }
        }
        if (this.sny && C29274a.rQZ.cwU()) {
            view = this.slL;
            if (view != null) {
                view.setVisibility(0);
            }
            view2 = this.slL;
            if (view2 != null) {
                view2.setOnClickListener(new C29369b(this));
            }
            if (this.rYr) {
                textView = this.slM;
                if (textView != null) {
                    textView.setText(getContext().getString(C25738R.string.g_7));
                }
            } else {
                textView = this.slM;
                if (textView != null) {
                    textView.setText(getContext().getString(C25738R.string.g_6));
                }
            }
        } else {
            view = this.slL;
            if (view != null) {
                view.setVisibility(8);
            }
        }
        view = findViewById(2131823264);
        if (view != null) {
            view.setBackgroundResource(C25738R.color.a3p);
            AppMethodBeat.m2505o(110702);
            return;
        }
        AppMethodBeat.m2505o(110702);
    }
}
