package com.tencent.p177mm.pluginsdk.p597ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.p177mm.pluginsdk.p597ui.chat.C44082f;

/* renamed from: com.tencent.mm.pluginsdk.ui.ChatFooterPanel */
public abstract class ChatFooterPanel extends LinearLayout {
    public static int vhh = 0;
    public static int vhi = 1;
    public static int vhj = 2;
    public static int vhk = 3;
    public static int vhl = 4;
    public static int vhm = 5;
    public static int vhn = 6;
    public static int vho = 7;
    public static int vhp = 8;
    public static int vhq = 9;
    public static int vhr = 10;
    public static int vhs = 11;
    protected int ubu;
    protected C44073a vhf;
    protected C44082f vhg;

    /* renamed from: com.tencent.mm.pluginsdk.ui.ChatFooterPanel$RecommendView */
    public static abstract class RecommendView extends LinearLayout {
        public abstract void setProductID(String str);

        public RecommendView(Context context) {
            super(context);
        }

        public RecommendView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public RecommendView(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.ChatFooterPanel$a */
    public interface C44073a {
        void aRg();

        void aYY();

        void append(String str);

        /* renamed from: fC */
        void mo24351fC(boolean z);
    }

    /* renamed from: AC */
    public abstract void mo11686AC();

    /* renamed from: AD */
    public abstract void mo11687AD();

    /* renamed from: AE */
    public abstract void mo11688AE();

    /* renamed from: AF */
    public abstract void mo11689AF();

    /* renamed from: AG */
    public abstract void mo11690AG();

    /* renamed from: bf */
    public abstract void mo11691bf(boolean z);

    /* renamed from: j */
    public abstract void mo11696j(boolean z, boolean z2);

    public abstract void onPause();

    public abstract void onResume();

    public abstract void refresh();

    public abstract void setDefaultEmojiByDetail(String str);

    public abstract void setEntranceScene(int i);

    public abstract void setPortHeightPx(int i);

    public abstract void setSendButtonEnable(boolean z);

    public abstract void setTalkerName(String str);

    public ChatFooterPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnTextOperationListener(C44073a c44073a) {
        this.vhf = c44073a;
    }

    public void setCallback(C44082f c44082f) {
        this.vhg = c44082f;
    }

    public void setFooterType(int i) {
        this.ubu = i;
    }

    public void destroy() {
    }
}
