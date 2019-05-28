package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.mm.pluginsdk.ui.chat.f;

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
    protected a vhf;
    protected f vhg;

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

    public interface a {
        void aRg();

        void aYY();

        void append(String str);

        void fC(boolean z);
    }

    public abstract void AC();

    public abstract void AD();

    public abstract void AE();

    public abstract void AF();

    public abstract void AG();

    public abstract void bf(boolean z);

    public abstract void j(boolean z, boolean z2);

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

    public void setOnTextOperationListener(a aVar) {
        this.vhf = aVar;
    }

    public void setCallback(f fVar) {
        this.vhg = fVar;
    }

    public void setFooterType(int i) {
        this.ubu = i;
    }

    public void destroy() {
    }
}
