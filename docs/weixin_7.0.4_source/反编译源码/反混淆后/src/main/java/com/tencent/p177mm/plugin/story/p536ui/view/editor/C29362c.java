package com.tencent.p177mm.plugin.story.p536ui.view.editor;

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

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001f\u001a\u00020\u0017H\u0002J\b\u0010 \u001a\u00020\u0017H\u0002J\u0012\u0010!\u001a\u00020\u00172\b\u0010\"\u001a\u0004\u0018\u00010#H\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001b¨\u0006$"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/editor/EditorMoreDialog;", "Landroid/support/design/widget/BottomSheetDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "favorite", "Landroid/view/View;", "favoriteIcon", "Landroid/widget/ImageView;", "favoriteTv", "Landroid/widget/TextView;", "isFavorite", "", "()Z", "setFavorite", "(Z)V", "isNotifySns", "setNotifySns", "notifySns", "notifySnsIcon", "notifySnsTv", "onNotifySns", "Lkotlin/Function0;", "", "getOnNotifySns", "()Lkotlin/jvm/functions/Function0;", "setOnNotifySns", "(Lkotlin/jvm/functions/Function0;)V", "onSetFav", "getOnSetFav", "setOnSetFav", "initFavoriteBtn", "initNotifySnsBtn", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.view.editor.c */
public final class C29362c extends C17391c {
    boolean rYr;
    private View slI;
    private TextView slJ;
    private ImageView slK;
    private View slL;
    private TextView slM;
    private ImageView slN;
    C31214a<C37091y> slO;
    C31214a<C37091y> slP;
    boolean slQ = true;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.c$b */
    static final class C29363b implements OnClickListener {
        final /* synthetic */ C29362c slR;

        C29363b(C29362c c29362c) {
            this.slR = c29362c;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(138924);
            C31214a c31214a = this.slR.slO;
            if (c31214a != null) {
                c31214a.invoke();
            }
            this.slR.dismiss();
            AppMethodBeat.m2505o(138924);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.c$a */
    static final class C29364a implements OnClickListener {
        final /* synthetic */ C29362c slR;

        C29364a(C29362c c29362c) {
            this.slR = c29362c;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(138923);
            C31214a c31214a = this.slR.slP;
            if (c31214a != null) {
                c31214a.invoke();
            }
            this.slR.dismiss();
            AppMethodBeat.m2505o(138923);
        }
    }

    public C29362c(Context context) {
        C25052j.m39376p(context, "context");
        super(context);
        AppMethodBeat.m2504i(138926);
        setContentView(2130970879);
        AppMethodBeat.m2505o(138926);
    }

    public final void onCreate(Bundle bundle) {
        View view;
        View view2;
        TextView textView;
        ImageView imageView;
        AppMethodBeat.m2504i(138925);
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.addFlags(134218752);
            window.clearFlags(2);
        }
        this.slL = findViewById(2131828133);
        this.slM = (TextView) findViewById(2131828135);
        this.slN = (ImageView) findViewById(2131828134);
        this.slI = findViewById(2131828136);
        this.slJ = (TextView) findViewById(2131828138);
        this.slK = (ImageView) findViewById(2131828137);
        if (C29274a.rQZ.cxh()) {
            view = this.slI;
            if (view != null) {
                view.setVisibility(0);
            }
            view2 = this.slI;
            if (view2 != null) {
                view2.setOnClickListener(new C29363b(this));
            }
            Context context;
            if (this.slQ) {
                textView = this.slJ;
                if (textView != null) {
                    context = getContext();
                    C25052j.m39375o(context, "context");
                    textView.setText(context.getResources().getString(C25738R.string.g_e));
                }
                imageView = this.slK;
                if (imageView != null) {
                    imageView.setImageDrawable(C5225ah.m7962f(getContext(), C1318a.icons_outlined_moment_off, WebView.NIGHT_MODE_COLOR));
                }
            } else {
                textView = this.slJ;
                if (textView != null) {
                    context = getContext();
                    C25052j.m39375o(context, "context");
                    textView.setText(context.getResources().getString(C25738R.string.g_f));
                }
                imageView = this.slK;
                if (imageView != null) {
                    imageView.setImageDrawable(C5225ah.m7962f(getContext(), C1318a.icons_outlined_moment, WebView.NIGHT_MODE_COLOR));
                }
            }
        } else {
            view = this.slI;
            if (view != null) {
                view.setVisibility(8);
            }
        }
        if (C29274a.rQZ.cwU()) {
            view = this.slL;
            if (view != null) {
                view.setVisibility(0);
            }
            imageView = this.slN;
            if (imageView != null) {
                imageView.setImageDrawable(C5225ah.m7962f(getContext(), C1318a.icons_outlined_star, WebView.NIGHT_MODE_COLOR));
            }
            view2 = this.slL;
            if (view2 != null) {
                view2.setOnClickListener(new C29364a(this));
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
            AppMethodBeat.m2505o(138925);
            return;
        }
        AppMethodBeat.m2505o(138925);
    }
}
