package com.tencent.p177mm.plugin.story.p536ui.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.widget.C5664a;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/UserGuideView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "clickListener", "Lkotlin/Function0;", "", "getClickListener", "()Lkotlin/jvm/functions/Function0;", "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.view.g */
public final class C22308g extends RelativeLayout {
    private C31214a<C37091y> skn;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.g$1 */
    static final class C223091 implements OnClickListener {
        public static final C223091 sko = new C223091();

        static {
            AppMethodBeat.m2504i(110469);
            AppMethodBeat.m2505o(110469);
        }

        C223091() {
        }

        public final void onClick(View view) {
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.g$2 */
    static final class C223102 implements OnClickListener {
        final /* synthetic */ C22308g skp;

        C223102(C22308g c22308g) {
            this.skp = c22308g;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110470);
            C31214a clickListener = this.skp.getClickListener();
            if (clickListener != null) {
                clickListener.invoke();
                AppMethodBeat.m2505o(110470);
                return;
            }
            AppMethodBeat.m2505o(110470);
        }
    }

    public C22308g(Context context) {
        C25052j.m39376p(context, "context");
        super(context);
        AppMethodBeat.m2504i(110471);
        View.inflate(context, 2130970903, this);
        setBackgroundColor(-13421773);
        View findViewById = findViewById(2131828196);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_user_guide_content_2)");
        TextView textView = (TextView) findViewById;
        String string = context.getString(C25738R.string.eti);
        SpannableString spannableString = new SpannableString(string);
        Drawable drawable = getResources().getDrawable(C1318a.chatting_avatar_story_hint);
        int fromDPToPix = C1338a.fromDPToPix(context, 10);
        drawable.setBounds(0, 0, fromDPToPix, fromDPToPix);
        spannableString.setSpan(new C5664a(drawable), string.length() - 3, string.length() - 2, 17);
        textView.setText(spannableString);
        setOnClickListener(C223091.sko);
        findViewById(2131828197).setOnClickListener(new C223102(this));
        AppMethodBeat.m2505o(110471);
    }

    public final C31214a<C37091y> getClickListener() {
        return this.skn;
    }

    public final void setClickListener(C31214a<C37091y> c31214a) {
        this.skn = c31214a;
    }
}
