package com.tencent.mm.plugin.story.ui.view.editor;

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

@l(dWo = {1, 1, 13}, dWp = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001f\u001a\u00020\u0017H\u0002J\b\u0010 \u001a\u00020\u0017H\u0002J\u0012\u0010!\u001a\u00020\u00172\b\u0010\"\u001a\u0004\u0018\u00010#H\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001b¨\u0006$"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/editor/EditorMoreDialog;", "Landroid/support/design/widget/BottomSheetDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "favorite", "Landroid/view/View;", "favoriteIcon", "Landroid/widget/ImageView;", "favoriteTv", "Landroid/widget/TextView;", "isFavorite", "", "()Z", "setFavorite", "(Z)V", "isNotifySns", "setNotifySns", "notifySns", "notifySnsIcon", "notifySnsTv", "onNotifySns", "Lkotlin/Function0;", "", "getOnNotifySns", "()Lkotlin/jvm/functions/Function0;", "setOnNotifySns", "(Lkotlin/jvm/functions/Function0;)V", "onSetFav", "getOnSetFav", "setOnSetFav", "initFavoriteBtn", "initNotifySnsBtn", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "plugin-story_release"})
public final class c extends android.support.design.widget.c {
    boolean rYr;
    private View slI;
    private TextView slJ;
    private ImageView slK;
    private View slL;
    private TextView slM;
    private ImageView slN;
    a.f.a.a<y> slO;
    a.f.a.a<y> slP;
    boolean slQ = true;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements OnClickListener {
        final /* synthetic */ c slR;

        b(c cVar) {
            this.slR = cVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(138924);
            a.f.a.a aVar = this.slR.slO;
            if (aVar != null) {
                aVar.invoke();
            }
            this.slR.dismiss();
            AppMethodBeat.o(138924);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a implements OnClickListener {
        final /* synthetic */ c slR;

        a(c cVar) {
            this.slR = cVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(138923);
            a.f.a.a aVar = this.slR.slP;
            if (aVar != null) {
                aVar.invoke();
            }
            this.slR.dismiss();
            AppMethodBeat.o(138923);
        }
    }

    public c(Context context) {
        j.p(context, "context");
        super(context);
        AppMethodBeat.i(138926);
        setContentView((int) R.layout.ayf);
        AppMethodBeat.o(138926);
    }

    public final void onCreate(Bundle bundle) {
        View view;
        View view2;
        TextView textView;
        ImageView imageView;
        AppMethodBeat.i(138925);
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.addFlags(134218752);
            window.clearFlags(2);
        }
        this.slL = findViewById(R.id.et5);
        this.slM = (TextView) findViewById(R.id.et7);
        this.slN = (ImageView) findViewById(R.id.et6);
        this.slI = findViewById(R.id.et8);
        this.slJ = (TextView) findViewById(R.id.et_);
        this.slK = (ImageView) findViewById(R.id.et9);
        if (com.tencent.mm.plugin.story.c.a.a.rQZ.cxh()) {
            view = this.slI;
            if (view != null) {
                view.setVisibility(0);
            }
            view2 = this.slI;
            if (view2 != null) {
                view2.setOnClickListener(new b(this));
            }
            Context context;
            if (this.slQ) {
                textView = this.slJ;
                if (textView != null) {
                    context = getContext();
                    j.o(context, "context");
                    textView.setText(context.getResources().getString(R.string.g_e));
                }
                imageView = this.slK;
                if (imageView != null) {
                    imageView.setImageDrawable(ah.f(getContext(), R.raw.icons_outlined_moment_off, WebView.NIGHT_MODE_COLOR));
                }
            } else {
                textView = this.slJ;
                if (textView != null) {
                    context = getContext();
                    j.o(context, "context");
                    textView.setText(context.getResources().getString(R.string.g_f));
                }
                imageView = this.slK;
                if (imageView != null) {
                    imageView.setImageDrawable(ah.f(getContext(), R.raw.icons_outlined_moment, WebView.NIGHT_MODE_COLOR));
                }
            }
        } else {
            view = this.slI;
            if (view != null) {
                view.setVisibility(8);
            }
        }
        if (com.tencent.mm.plugin.story.c.a.a.rQZ.cwU()) {
            view = this.slL;
            if (view != null) {
                view.setVisibility(0);
            }
            imageView = this.slN;
            if (imageView != null) {
                imageView.setImageDrawable(ah.f(getContext(), R.raw.icons_outlined_star, WebView.NIGHT_MODE_COLOR));
            }
            view2 = this.slL;
            if (view2 != null) {
                view2.setOnClickListener(new a(this));
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
            AppMethodBeat.o(138925);
            return;
        }
        AppMethodBeat.o(138925);
    }
}
