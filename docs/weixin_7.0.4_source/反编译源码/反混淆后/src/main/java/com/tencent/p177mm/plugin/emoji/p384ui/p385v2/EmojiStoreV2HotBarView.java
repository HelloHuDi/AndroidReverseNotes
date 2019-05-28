package com.tencent.p177mm.plugin.emoji.p384ui.p385v2;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;

/* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2HotBarView */
public class EmojiStoreV2HotBarView extends LinearLayout {
    private View jcl;
    private View ldN;
    private TextView ldO;
    private View ldP;
    private TextView ldQ;
    private OnClickListener ldR = new C277691();

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2HotBarView$1 */
    class C277691 implements OnClickListener {
        C277691() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(53627);
            Intent intent = new Intent();
            intent.setClass(EmojiStoreV2HotBarView.this.getContext(), EmojiStoreV2RankUI.class);
            EmojiStoreV2HotBarView.this.getContext().startActivity(intent);
            AppMethodBeat.m2505o(53627);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2HotBarView$2 */
    class C389002 implements OnClickListener {
        C389002() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(53628);
            Intent intent = new Intent();
            intent.setClass(EmojiStoreV2HotBarView.this.getContext(), EmojiStoreV2SingleProductUI.class);
            EmojiStoreV2HotBarView.this.getContext().startActivity(intent);
            AppMethodBeat.m2505o(53628);
        }
    }

    public EmojiStoreV2HotBarView(Context context) {
        super(context);
        AppMethodBeat.m2504i(53629);
        init();
        AppMethodBeat.m2505o(53629);
    }

    public EmojiStoreV2HotBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(53630);
        init();
        AppMethodBeat.m2505o(53630);
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.m2504i(53631);
        super.onAttachedToWindow();
        C4990ab.m7410d("MicroMsg.emoji.EmojiStoreV2HotBarView", "onAttachedToWindow");
        AppMethodBeat.m2505o(53631);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.m2504i(53632);
        super.onDetachedFromWindow();
        C4990ab.m7410d("MicroMsg.emoji.EmojiStoreV2HotBarView", "onAttachedToWindow");
        AppMethodBeat.m2505o(53632);
    }

    @TargetApi(11)
    public EmojiStoreV2HotBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(53633);
        init();
        AppMethodBeat.m2505o(53633);
    }

    private void init() {
        AppMethodBeat.m2504i(53634);
        this.jcl = ((ViewGroup) C5616v.m8409hu(getContext()).inflate(2130969365, this)).findViewById(2131820987);
        this.ldN = this.jcl.findViewById(2131823559);
        this.ldO = (TextView) this.jcl.findViewById(2131823561);
        this.ldO.setText(getResources().getText(C25738R.string.bb2) + " ");
        this.ldP = this.jcl.findViewById(2131823550);
        this.ldP.setOnClickListener(new C389002());
        this.ldQ = (TextView) this.jcl.findViewById(2131823549);
        bmf();
        setMoreOnClickListener(this.ldR);
        AppMethodBeat.m2505o(53634);
    }

    public final void bmf() {
        AppMethodBeat.m2504i(53635);
        boolean booleanValue = ((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_EMOJI_STORE_NEW_DESIGNER_EMOJI_BOOLEAN, Boolean.FALSE)).booleanValue();
        if (this.ldQ != null) {
            this.ldQ.setVisibility(booleanValue ? 0 : 8);
        }
        AppMethodBeat.m2505o(53635);
    }

    public void setMoreOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(53636);
        if (this.ldO != null) {
            this.ldO.setOnClickListener(onClickListener);
        }
        AppMethodBeat.m2505o(53636);
    }

    public View getRootView() {
        return this.jcl;
    }

    public void setDesignerEmojiViewVisibility(int i) {
        AppMethodBeat.m2504i(53637);
        if (this.ldP != null) {
            this.ldP.setVisibility(i);
        }
        AppMethodBeat.m2505o(53637);
    }

    public void setDesignerCatalogViewPadding(boolean z) {
        AppMethodBeat.m2504i(53638);
        if (!(this.ldN == null || z)) {
            int al = C1338a.m2856al(getContext(), C25738R.dimen.f9957ld);
            int al2 = C1338a.m2856al(getContext(), C25738R.dimen.f9966lo);
            int al3 = C1338a.m2856al(getContext(), C25738R.dimen.f9979m4);
            this.ldN.setPadding(al3, al, al3, al2);
        }
        AppMethodBeat.m2505o(53638);
    }

    public void setVisibility(int i) {
        AppMethodBeat.m2504i(53639);
        if (this.jcl != null) {
            this.jcl.setVisibility(i);
            AppMethodBeat.m2505o(53639);
            return;
        }
        super.setVisibility(i);
        AppMethodBeat.m2505o(53639);
    }
}
