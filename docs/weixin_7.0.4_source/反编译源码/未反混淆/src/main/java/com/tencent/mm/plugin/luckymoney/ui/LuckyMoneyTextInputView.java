package com.tencent.mm.plugin.luckymoney.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.widget.MMEditText;

public class LuckyMoneyTextInputView extends LinearLayout implements c {
    private TextView iDT;
    private g nSr;
    private MMEditText nTP;
    LinearLayout ohX;
    ImageView ohY;
    BaseEmojiView ohZ;
    private OnClickListener oia;

    public LuckyMoneyTextInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(43038);
        View inflate = LayoutInflater.from(context).inflate(R.layout.aam, this, true);
        this.nTP = (MMEditText) inflate.findViewById(R.id.d0f);
        this.iDT = (TextView) inflate.findViewById(R.id.d0e);
        this.ohX = (LinearLayout) inflate.findViewById(R.id.d0g);
        this.ohY = (ImageView) inflate.findViewById(R.id.d0h);
        this.ohZ = (BaseEmojiView) inflate.findViewById(R.id.cv6);
        this.nTP.setOnFocusChangeListener(new OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.i(43036);
                if (LuckyMoneyTextInputView.this.nSr != null) {
                    g a = LuckyMoneyTextInputView.this.nSr;
                    LuckyMoneyTextInputView.this.getInputViewId();
                    a.bLa();
                }
                AppMethodBeat.o(43036);
            }
        });
        this.ohX.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(43037);
                if (LuckyMoneyTextInputView.this.oia != null) {
                    LuckyMoneyTextInputView.this.oia.onClick(view);
                }
                AppMethodBeat.o(43037);
            }
        });
        this.ohX.setVisibility(8);
        AppMethodBeat.o(43038);
    }

    public void setOnInputValidChangerListener(g gVar) {
        this.nSr = gVar;
    }

    public void setmOnEmojiSelectClickListener(OnClickListener onClickListener) {
        this.oia = onClickListener;
    }

    public String getInput() {
        AppMethodBeat.i(43039);
        String obj = this.nTP.getText().toString();
        AppMethodBeat.o(43039);
        return obj;
    }

    public void setHintText(String str) {
        AppMethodBeat.i(43040);
        this.nTP.setHint(str);
        AppMethodBeat.o(43040);
    }

    public void setTitle(String str) {
        AppMethodBeat.i(43041);
        this.iDT.setText(str);
        AppMethodBeat.o(43041);
    }

    public final void iO(boolean z) {
        AppMethodBeat.i(43042);
        if (z) {
            this.ohX.setVisibility(8);
            AppMethodBeat.o(43042);
            return;
        }
        this.ohX.setVisibility(0);
        this.ohY.setVisibility(0);
        this.ohZ.setVisibility(8);
        AppMethodBeat.o(43042);
    }

    public final void z(EmojiInfo emojiInfo) {
        AppMethodBeat.i(43043);
        this.ohX.setTag("delete");
        this.ohY.setVisibility(8);
        this.ohZ.setVisibility(0);
        this.ohZ.setEmojiInfo(emojiInfo);
        AppMethodBeat.o(43043);
    }

    public final int bKW() {
        return 0;
    }

    public final void restore() {
    }

    public final void onError() {
    }

    public int getInputViewId() {
        AppMethodBeat.i(43044);
        int id = getId();
        AppMethodBeat.o(43044);
        return id;
    }

    public final String xH(int i) {
        return null;
    }
}
