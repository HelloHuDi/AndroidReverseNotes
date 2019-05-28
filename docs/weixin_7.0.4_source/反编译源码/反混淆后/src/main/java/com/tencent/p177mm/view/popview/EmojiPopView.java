package com.tencent.p177mm.view.popview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.emoji.view.EmojiStatusView;
import com.tencent.p177mm.emoji.view.EmojiStatusView.C37687b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.view.popview.EmojiPopView */
public class EmojiPopView extends AbstractPopView {
    private EmojiStatusView AdR;
    private LayoutParams AdS;
    private String AdT;
    private int offsetY;
    private ProgressBar ppY;

    /* renamed from: com.tencent.mm.view.popview.EmojiPopView$1 */
    class C160721 implements C37687b {
        C160721() {
        }

        /* renamed from: jm */
        public final void mo7155jm(int i) {
            AppMethodBeat.m2504i(63063);
            if (i == 1) {
                EmojiPopView.this.ppY.setVisibility(8);
                EmojiPopView.this.AdR.setVisibility(0);
                AppMethodBeat.m2505o(63063);
                return;
            }
            EmojiPopView.this.AdR.setVisibility(4);
            EmojiPopView.this.ppY.setVisibility(0);
            AppMethodBeat.m2505o(63063);
        }
    }

    public EmojiPopView(Context context) {
        this(context, null);
    }

    public EmojiPopView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EmojiPopView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(63064);
        EmojiPopView.inflate(context, 2130969344, this);
        this.AdR = (EmojiStatusView) findViewById(2131820629);
        this.ppY = (ProgressBar) findViewById(2131821370);
        setBackgroundResource(C25738R.drawable.b2t);
        this.AdS = new LayoutParams(2, C31128d.MIC_PTU_ZIPAI_GRADIENT_MILKCOFFEE, 1);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(C25738R.dimen.a1b);
        this.AdS.width = dimensionPixelSize;
        this.AdS.height = dimensionPixelSize;
        this.AdS.gravity = 8388659;
        this.offsetY = context.getResources().getDimensionPixelSize(C25738R.dimen.a1_);
        AppMethodBeat.m2505o(63064);
    }

    public void setEmojiInfo(EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(63065);
        if (emojiInfo == null) {
            this.AdR.setVisibility(4);
            this.ppY.setVisibility(0);
            C4990ab.m7416i("MicroMsg.EmojiPopView", "emoji is null. set null");
            AppMethodBeat.m2505o(63065);
            return;
        }
        if (!emojiInfo.mo20410Aq().equals(this.AdT)) {
            this.AdT = emojiInfo.mo20410Aq();
            this.AdR.setStatusListener(new C160721());
            this.AdR.setEmojiInfo(emojiInfo);
        }
        AppMethodBeat.m2505o(63065);
    }

    public LayoutParams getWindowLayoutParams() {
        return this.AdS;
    }

    /* renamed from: fw */
    public final void mo49356fw(View view) {
        AppMethodBeat.m2504i(63066);
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        this.AdS.x = iArr[0] - ((this.AdS.width - view.getMeasuredWidth()) / 2);
        this.AdS.y = (iArr[1] - this.AdS.height) + this.offsetY;
        AppMethodBeat.m2505o(63066);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.m2504i(63067);
        super.onDetachedFromWindow();
        AppMethodBeat.m2505o(63067);
    }
}
