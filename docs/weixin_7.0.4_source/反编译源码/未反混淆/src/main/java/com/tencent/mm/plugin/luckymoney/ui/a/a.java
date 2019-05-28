package com.tencent.mm.plugin.luckymoney.ui.a;

import android.content.Context;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.t;
import com.tencent.mm.api.u;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;

public final class a {
    public static boolean a(Context context, final ChatFooterPanel chatFooterPanel) {
        AppMethodBeat.i(43088);
        if (chatFooterPanel == null) {
            AppMethodBeat.o(43088);
            return false;
        }
        chatFooterPanel.onPause();
        if (chatFooterPanel.getVisibility() == 0) {
            chatFooterPanel.setVisibility(8);
            Animation loadAnimation = AnimationUtils.loadAnimation(context, R.anim.ce);
            loadAnimation.setAnimationListener(new AnimationListener() {
                public final void onAnimationStart(Animation animation) {
                    AppMethodBeat.i(43086);
                    chatFooterPanel.setVisibility(0);
                    AppMethodBeat.o(43086);
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(43087);
                    chatFooterPanel.onPause();
                    chatFooterPanel.setVisibility(8);
                    AppMethodBeat.o(43087);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            chatFooterPanel.startAnimation(loadAnimation);
            AppMethodBeat.o(43088);
            return true;
        }
        AppMethodBeat.o(43088);
        return false;
    }

    public static void a(ChatFooterPanel chatFooterPanel) {
        AppMethodBeat.i(43089);
        chatFooterPanel.setBackgroundResource(R.drawable.ay1);
        chatFooterPanel.bf(false);
        chatFooterPanel.AE();
        chatFooterPanel.onResume();
        AppMethodBeat.o(43089);
    }

    public static void a(ViewGroup viewGroup, ChatFooterPanel chatFooterPanel, int i, com.tencent.mm.api.t.a aVar) {
        AppMethodBeat.i(43090);
        chatFooterPanel.setEntranceScene(i);
        chatFooterPanel.setVisibility(0);
        LayoutParams layoutParams = new LayoutParams(-1, (int) viewGroup.getResources().getDimension(R.dimen.a43));
        layoutParams.gravity = 80;
        viewGroup.removeAllViews();
        viewGroup.addView(chatFooterPanel, layoutParams);
        t AH = u.AH();
        AH.ccZ = aVar;
        chatFooterPanel.setCallback(AH);
        AppMethodBeat.o(43090);
    }
}
