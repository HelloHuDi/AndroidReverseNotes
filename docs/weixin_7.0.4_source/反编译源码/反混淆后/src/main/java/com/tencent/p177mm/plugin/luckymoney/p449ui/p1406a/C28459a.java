package com.tencent.p177mm.plugin.luckymoney.p449ui.p1406a;

import android.content.Context;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.api.C17918t;
import com.tencent.p177mm.api.C17918t.C17917a;
import com.tencent.p177mm.api.C41757u;
import com.tencent.p177mm.pluginsdk.p597ui.ChatFooterPanel;

/* renamed from: com.tencent.mm.plugin.luckymoney.ui.a.a */
public final class C28459a {
    /* renamed from: a */
    public static boolean m45139a(Context context, final ChatFooterPanel chatFooterPanel) {
        AppMethodBeat.m2504i(43088);
        if (chatFooterPanel == null) {
            AppMethodBeat.m2505o(43088);
            return false;
        }
        chatFooterPanel.onPause();
        if (chatFooterPanel.getVisibility() == 0) {
            chatFooterPanel.setVisibility(8);
            Animation loadAnimation = AnimationUtils.loadAnimation(context, C25738R.anim.f8373ce);
            loadAnimation.setAnimationListener(new AnimationListener() {
                public final void onAnimationStart(Animation animation) {
                    AppMethodBeat.m2504i(43086);
                    chatFooterPanel.setVisibility(0);
                    AppMethodBeat.m2505o(43086);
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.m2504i(43087);
                    chatFooterPanel.onPause();
                    chatFooterPanel.setVisibility(8);
                    AppMethodBeat.m2505o(43087);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            chatFooterPanel.startAnimation(loadAnimation);
            AppMethodBeat.m2505o(43088);
            return true;
        }
        AppMethodBeat.m2505o(43088);
        return false;
    }

    /* renamed from: a */
    public static void m45138a(ChatFooterPanel chatFooterPanel) {
        AppMethodBeat.m2504i(43089);
        chatFooterPanel.setBackgroundResource(C25738R.drawable.ay1);
        chatFooterPanel.mo11691bf(false);
        chatFooterPanel.mo11688AE();
        chatFooterPanel.onResume();
        AppMethodBeat.m2505o(43089);
    }

    /* renamed from: a */
    public static void m45137a(ViewGroup viewGroup, ChatFooterPanel chatFooterPanel, int i, C17917a c17917a) {
        AppMethodBeat.m2504i(43090);
        chatFooterPanel.setEntranceScene(i);
        chatFooterPanel.setVisibility(0);
        LayoutParams layoutParams = new LayoutParams(-1, (int) viewGroup.getResources().getDimension(C25738R.dimen.a43));
        layoutParams.gravity = 80;
        viewGroup.removeAllViews();
        viewGroup.addView(chatFooterPanel, layoutParams);
        C17918t AH = C41757u.m73611AH();
        AH.ccZ = c17917a;
        chatFooterPanel.setCallback(AH);
        AppMethodBeat.m2505o(43090);
    }
}
