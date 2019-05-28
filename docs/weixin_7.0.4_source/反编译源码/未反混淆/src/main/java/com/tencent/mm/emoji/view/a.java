package com.tencent.mm.emoji.view;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.api.u;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.ui.ak;

@l(dWo = {1, 1, 13}, dWp = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0006\u0010\u0014\u001a\u00020\u0007J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u00020\u0012H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, dWq = {"Lcom/tencent/mm/emoji/view/EmojiPanelBottomSheet;", "", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "darkMode", "", "(Landroid/content/Context;Landroid/view/ViewGroup;Z)V", "getContext", "()Landroid/content/Context;", "panelRoot", "Landroid/widget/FrameLayout;", "getParent", "()Landroid/view/ViewGroup;", "smileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "destroy", "", "dismiss", "isShow", "setCallback", "callback", "Lcom/tencent/mm/api/SmileyPanelCallbackWrapper$Callback;", "show", "plugin-emojisdk_release"})
public class a {
    private final Context context;
    public final FrameLayout eAj = new FrameLayout(this.context);
    public final ChatFooterPanel eAk;
    private final ViewGroup eAl;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class a implements Runnable {
        final /* synthetic */ a eAm;

        a(a aVar) {
            this.eAm = aVar;
        }

        public final void run() {
            AppMethodBeat.i(63307);
            this.eAm.eAj.setVisibility(8);
            this.eAm.eAk.setVisibility(8);
            AppMethodBeat.o(63307);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.emoji.view.a$1 */
    static final class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ a eAm;

        AnonymousClass1(a aVar) {
            this.eAm = aVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(63306);
            this.eAm.dismiss();
            AppMethodBeat.o(63306);
        }
    }

    public a(Context context, ViewGroup viewGroup) {
        j.p(context, "context");
        j.p(viewGroup, "parent");
        AppMethodBeat.i(63310);
        this.context = context;
        this.eAl = viewGroup;
        this.eAl.addView(this.eAj, new LayoutParams(-1, -1));
        this.eAj.setOnClickListener(new AnonymousClass1(this));
        SmileyPanel i = u.i(this.context, false);
        j.o(i, "SmileyPanelFactory.getSm…yPanel(context, darkMode)");
        this.eAk = i;
        this.eAk.AE();
        this.eAk.bf(true);
        this.eAk.j(true, true);
        this.eAk.setBackgroundColor(-1);
        this.eAk.setEntranceScene(ChatFooterPanel.vhl);
        this.eAk.onResume();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, com.tencent.mm.bz.a.fromDPToPix(this.context, 230));
        layoutParams.gravity = 80;
        this.eAj.setPadding(0, 0, 0, ak.fr(this.context));
        this.eAj.addView(this.eAk, layoutParams);
        this.eAj.setVisibility(8);
        ((SmileyPanel) this.eAk).setVisibility(8);
        ((SmileyPanel) this.eAk).setTranslationY((float) layoutParams.height);
        AppMethodBeat.o(63310);
    }

    public void show() {
        AppMethodBeat.i(63308);
        this.eAj.setVisibility(0);
        this.eAk.setVisibility(0);
        this.eAk.animate().translationY(0.0f).start();
        AppMethodBeat.o(63308);
    }

    public void dismiss() {
        AppMethodBeat.i(63309);
        this.eAk.animate().translationY((float) this.eAk.getLayoutParams().height).withEndAction(new a(this));
        AppMethodBeat.o(63309);
    }
}
