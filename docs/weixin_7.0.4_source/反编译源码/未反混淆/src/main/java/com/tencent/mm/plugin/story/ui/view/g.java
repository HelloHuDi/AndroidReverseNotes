package com.tencent.mm.plugin.story.ui.view;

import a.f.a.a;
import a.f.b.j;
import a.l;
import a.y;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/UserGuideView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "clickListener", "Lkotlin/Function0;", "", "getClickListener", "()Lkotlin/jvm/functions/Function0;", "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "plugin-story_release"})
public final class g extends RelativeLayout {
    private a<y> skn;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.g$2 */
    static final class AnonymousClass2 implements OnClickListener {
        final /* synthetic */ g skp;

        AnonymousClass2(g gVar) {
            this.skp = gVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(110470);
            a clickListener = this.skp.getClickListener();
            if (clickListener != null) {
                clickListener.invoke();
                AppMethodBeat.o(110470);
                return;
            }
            AppMethodBeat.o(110470);
        }
    }

    public g(Context context) {
        j.p(context, "context");
        super(context);
        AppMethodBeat.i(110471);
        View.inflate(context, R.layout.az3, this);
        setBackgroundColor(-13421773);
        View findViewById = findViewById(R.id.euu);
        j.o(findViewById, "findViewById(R.id.story_user_guide_content_2)");
        TextView textView = (TextView) findViewById;
        String string = context.getString(R.string.eti);
        SpannableString spannableString = new SpannableString(string);
        Drawable drawable = getResources().getDrawable(R.raw.chatting_avatar_story_hint);
        int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(context, 10);
        drawable.setBounds(0, 0, fromDPToPix, fromDPToPix);
        spannableString.setSpan(new com.tencent.mm.ui.widget.a(drawable), string.length() - 3, string.length() - 2, 17);
        textView.setText(spannableString);
        setOnClickListener(AnonymousClass1.sko);
        findViewById(R.id.euv).setOnClickListener(new AnonymousClass2(this));
        AppMethodBeat.o(110471);
    }

    public final a<y> getClickListener() {
        return this.skn;
    }

    public final void setClickListener(a<y> aVar) {
        this.skn = aVar;
    }
}
