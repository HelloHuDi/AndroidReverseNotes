package com.tencent.p177mm.plugin.luckymoney.p449ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.emoji.view.BaseEmojiView;
import com.tencent.p177mm.p612ui.widget.MMEditText;
import com.tencent.p177mm.storage.emotion.EmojiInfo;

/* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyTextInputView */
public class LuckyMoneyTextInputView extends LinearLayout implements C39342c {
    private TextView iDT;
    private C12472g nSr;
    private MMEditText nTP;
    LinearLayout ohX;
    ImageView ohY;
    BaseEmojiView ohZ;
    private OnClickListener oia;

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyTextInputView$2 */
    class C124612 implements OnClickListener {
        C124612() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(43037);
            if (LuckyMoneyTextInputView.this.oia != null) {
                LuckyMoneyTextInputView.this.oia.onClick(view);
            }
            AppMethodBeat.m2505o(43037);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyTextInputView$1 */
    class C432801 implements OnFocusChangeListener {
        C432801() {
        }

        public final void onFocusChange(View view, boolean z) {
            AppMethodBeat.m2504i(43036);
            if (LuckyMoneyTextInputView.this.nSr != null) {
                C12472g a = LuckyMoneyTextInputView.this.nSr;
                LuckyMoneyTextInputView.this.getInputViewId();
                a.bLa();
            }
            AppMethodBeat.m2505o(43036);
        }
    }

    public LuckyMoneyTextInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(43038);
        View inflate = LayoutInflater.from(context).inflate(2130969998, this, true);
        this.nTP = (MMEditText) inflate.findViewById(2131825665);
        this.iDT = (TextView) inflate.findViewById(2131825664);
        this.ohX = (LinearLayout) inflate.findViewById(2131825666);
        this.ohY = (ImageView) inflate.findViewById(2131825667);
        this.ohZ = (BaseEmojiView) inflate.findViewById(2131825470);
        this.nTP.setOnFocusChangeListener(new C432801());
        this.ohX.setOnClickListener(new C124612());
        this.ohX.setVisibility(8);
        AppMethodBeat.m2505o(43038);
    }

    public void setOnInputValidChangerListener(C12472g c12472g) {
        this.nSr = c12472g;
    }

    public void setmOnEmojiSelectClickListener(OnClickListener onClickListener) {
        this.oia = onClickListener;
    }

    public String getInput() {
        AppMethodBeat.m2504i(43039);
        String obj = this.nTP.getText().toString();
        AppMethodBeat.m2505o(43039);
        return obj;
    }

    public void setHintText(String str) {
        AppMethodBeat.m2504i(43040);
        this.nTP.setHint(str);
        AppMethodBeat.m2505o(43040);
    }

    public void setTitle(String str) {
        AppMethodBeat.m2504i(43041);
        this.iDT.setText(str);
        AppMethodBeat.m2505o(43041);
    }

    /* renamed from: iO */
    public final void mo68823iO(boolean z) {
        AppMethodBeat.m2504i(43042);
        if (z) {
            this.ohX.setVisibility(8);
            AppMethodBeat.m2505o(43042);
            return;
        }
        this.ohX.setVisibility(0);
        this.ohY.setVisibility(0);
        this.ohZ.setVisibility(8);
        AppMethodBeat.m2505o(43042);
    }

    /* renamed from: z */
    public final void mo68828z(EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(43043);
        this.ohX.setTag("delete");
        this.ohY.setVisibility(8);
        this.ohZ.setVisibility(0);
        this.ohZ.setEmojiInfo(emojiInfo);
        AppMethodBeat.m2505o(43043);
    }

    public final int bKW() {
        return 0;
    }

    public final void restore() {
    }

    public final void onError() {
    }

    public int getInputViewId() {
        AppMethodBeat.m2504i(43044);
        int id = getId();
        AppMethodBeat.m2505o(43044);
        return id;
    }

    /* renamed from: xH */
    public final String mo36557xH(int i) {
        return null;
    }
}
