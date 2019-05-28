package com.tencent.mm.plugin.emoji.ui.v2;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.ui.v;

public class EmojiStoreV2HotBarView extends LinearLayout {
    private View jcl;
    private View ldN;
    private TextView ldO;
    private View ldP;
    private TextView ldQ;
    private OnClickListener ldR = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(53627);
            Intent intent = new Intent();
            intent.setClass(EmojiStoreV2HotBarView.this.getContext(), EmojiStoreV2RankUI.class);
            EmojiStoreV2HotBarView.this.getContext().startActivity(intent);
            AppMethodBeat.o(53627);
        }
    };

    public EmojiStoreV2HotBarView(Context context) {
        super(context);
        AppMethodBeat.i(53629);
        init();
        AppMethodBeat.o(53629);
    }

    public EmojiStoreV2HotBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(53630);
        init();
        AppMethodBeat.o(53630);
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(53631);
        super.onAttachedToWindow();
        ab.d("MicroMsg.emoji.EmojiStoreV2HotBarView", "onAttachedToWindow");
        AppMethodBeat.o(53631);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(53632);
        super.onDetachedFromWindow();
        ab.d("MicroMsg.emoji.EmojiStoreV2HotBarView", "onAttachedToWindow");
        AppMethodBeat.o(53632);
    }

    @TargetApi(11)
    public EmojiStoreV2HotBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(53633);
        init();
        AppMethodBeat.o(53633);
    }

    private void init() {
        AppMethodBeat.i(53634);
        this.jcl = ((ViewGroup) v.hu(getContext()).inflate(R.layout.uk, this)).findViewById(R.id.l_);
        this.ldN = this.jcl.findViewById(R.id.bgh);
        this.ldO = (TextView) this.jcl.findViewById(R.id.bgj);
        this.ldO.setText(getResources().getText(R.string.bb2) + " ");
        this.ldP = this.jcl.findViewById(R.id.bg9);
        this.ldP.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(53628);
                Intent intent = new Intent();
                intent.setClass(EmojiStoreV2HotBarView.this.getContext(), EmojiStoreV2SingleProductUI.class);
                EmojiStoreV2HotBarView.this.getContext().startActivity(intent);
                AppMethodBeat.o(53628);
            }
        });
        this.ldQ = (TextView) this.jcl.findViewById(R.id.bg8);
        bmf();
        setMoreOnClickListener(this.ldR);
        AppMethodBeat.o(53634);
    }

    public final void bmf() {
        AppMethodBeat.i(53635);
        boolean booleanValue = ((Boolean) g.RP().Ry().get(a.USERINFO_EMOJI_STORE_NEW_DESIGNER_EMOJI_BOOLEAN, Boolean.FALSE)).booleanValue();
        if (this.ldQ != null) {
            this.ldQ.setVisibility(booleanValue ? 0 : 8);
        }
        AppMethodBeat.o(53635);
    }

    public void setMoreOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(53636);
        if (this.ldO != null) {
            this.ldO.setOnClickListener(onClickListener);
        }
        AppMethodBeat.o(53636);
    }

    public View getRootView() {
        return this.jcl;
    }

    public void setDesignerEmojiViewVisibility(int i) {
        AppMethodBeat.i(53637);
        if (this.ldP != null) {
            this.ldP.setVisibility(i);
        }
        AppMethodBeat.o(53637);
    }

    public void setDesignerCatalogViewPadding(boolean z) {
        AppMethodBeat.i(53638);
        if (!(this.ldN == null || z)) {
            int al = com.tencent.mm.bz.a.al(getContext(), R.dimen.ld);
            int al2 = com.tencent.mm.bz.a.al(getContext(), R.dimen.lo);
            int al3 = com.tencent.mm.bz.a.al(getContext(), R.dimen.m4);
            this.ldN.setPadding(al3, al, al3, al2);
        }
        AppMethodBeat.o(53638);
    }

    public void setVisibility(int i) {
        AppMethodBeat.i(53639);
        if (this.jcl != null) {
            this.jcl.setVisibility(i);
            AppMethodBeat.o(53639);
            return;
        }
        super.setVisibility(i);
        AppMethodBeat.o(53639);
    }
}
