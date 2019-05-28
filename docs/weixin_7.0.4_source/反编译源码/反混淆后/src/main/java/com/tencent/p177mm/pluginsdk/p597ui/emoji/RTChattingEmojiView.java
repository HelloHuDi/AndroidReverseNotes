package com.tencent.p177mm.pluginsdk.p597ui.emoji;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.emoji.view.EmojiStatusView.C37687b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.emoji.PluginEmoji;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C44218ap;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.storage.emotion.EmojiInfo;

/* renamed from: com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView */
public class RTChattingEmojiView extends FrameLayout {
    private EmojiInfo kZa;
    private int mStatus = -1;
    private boolean ngN = true;
    private TextView sLY;
    private int vpL;
    private int vpM;
    private int vpN;
    private int vpO;
    private int vpP;
    public ChattingEmojiView vpQ;
    private ProgressBar vpR;
    private LayoutParams vpS;
    private LayoutParams vpT;

    /* renamed from: com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView$1 */
    class C149461 implements C37687b {
        C149461() {
        }

        /* renamed from: jm */
        public final void mo7155jm(int i) {
            AppMethodBeat.m2504i(62489);
            if (i == 0) {
                RTChattingEmojiView.m69615a(RTChattingEmojiView.this, RTChattingEmojiView.this.ngN ? 0 : 1);
                AppMethodBeat.m2505o(62489);
            } else if (i == -1) {
                RTChattingEmojiView.m69615a(RTChattingEmojiView.this, 3);
                AppMethodBeat.m2505o(62489);
            } else {
                RTChattingEmojiView.m69615a(RTChattingEmojiView.this, 2);
                AppMethodBeat.m2505o(62489);
            }
        }
    }

    public RTChattingEmojiView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RTChattingEmojiView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void initView() {
        AppMethodBeat.m2504i(62490);
        this.vpL = getContext().getResources().getDimensionPixelSize(C25738R.dimen.a1h);
        this.vpM = getContext().getResources().getDimensionPixelSize(C25738R.dimen.a1e);
        this.vpO = getContext().getResources().getDimensionPixelSize(C25738R.dimen.a1k);
        this.vpP = getContext().getResources().getDimensionPixelSize(C25738R.dimen.a1j);
        this.vpQ = new ChattingEmojiView(getContext());
        this.vpR = new ProgressBar(getContext());
        this.vpR.setIndeterminateDrawable(getResources().getDrawable(C25738R.drawable.f6981xi));
        this.sLY = new TextView(getContext());
        this.sLY.setText(C25738R.string.b_u);
        this.sLY.setTextColor(getResources().getColor(C25738R.color.f11954mz));
        this.vpS = new LayoutParams(-2, -2);
        this.vpT = new LayoutParams(-2, -2);
        this.vpS.gravity = 17;
        addView(this.vpR, this.vpS);
        addView(this.sLY, this.vpS);
        AppMethodBeat.m2505o(62490);
    }

    public final void dkQ() {
        AppMethodBeat.m2504i(62491);
        this.vpT.gravity = 3;
        addView(this.vpQ, this.vpT);
        AppMethodBeat.m2505o(62491);
    }

    public final void dkR() {
        AppMethodBeat.m2504i(62492);
        this.vpT.gravity = 5;
        addView(this.vpQ, this.vpT);
        AppMethodBeat.m2505o(62492);
    }

    /* renamed from: a */
    public final void mo64023a(EmojiInfo emojiInfo, long j) {
        AppMethodBeat.m2504i(62493);
        mo64024a(emojiInfo, j, new C44218ap(""));
        AppMethodBeat.m2505o(62493);
    }

    /* renamed from: a */
    public final void mo64024a(EmojiInfo emojiInfo, long j, C44218ap c44218ap) {
        boolean z = false;
        AppMethodBeat.m2504i(62494);
        C4990ab.m7417i("MicroMsg.emoji.RTChattingEmojiView", "setEmojiInfo %s msgId %s", emojiInfo.field_md5, Long.valueOf(j));
        this.kZa = emojiInfo;
        if (this.kZa.mo48552xy()) {
            this.vpQ.setStatus(1);
            m69614Ln(2);
            C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(j);
            boolean z2 = jf.field_status == 2 || jf.field_status == 3 || jf.field_status == 5;
            ChattingEmojiView chattingEmojiView = this.vpQ;
            if (!c44218ap.fWX) {
                z = true;
            }
            chattingEmojiView.mo46174a(z, z2, ((PluginEmoji) C1720g.m3530M(PluginEmoji.class)).getEmojiMgr().mo35658o(emojiInfo), ((PluginEmoji) C1720g.m3530M(PluginEmoji.class)).getEmojiMgr().mo35660p(emojiInfo), emojiInfo.getName(), String.valueOf(j + emojiInfo.getName()));
            AppMethodBeat.m2505o(62494);
            return;
        }
        this.ngN = true;
        this.vpQ.setStatusListener(new C149461());
        this.vpQ.mo74722a(this.kZa, j);
        AppMethodBeat.m2505o(62494);
    }

    public void setImageBitmap(Bitmap bitmap) {
        AppMethodBeat.m2504i(62495);
        m69614Ln(2);
        if (!(this.vpQ == null || bitmap == null || bitmap.isRecycled())) {
            bitmap.setDensity(this.vpQ.getEmojiDensity());
            this.vpQ.setImageBitmap(bitmap);
        }
        AppMethodBeat.m2505o(62495);
    }

    public boolean performClick() {
        AppMethodBeat.m2504i(62496);
        C4990ab.m7417i("MicroMsg.emoji.RTChattingEmojiView", "performClick: %s", Integer.valueOf(this.mStatus));
        if (this.mStatus == 3) {
            this.ngN = false;
            this.vpQ.reload();
            AppMethodBeat.m2505o(62496);
            return true;
        } else if (this.mStatus == 2) {
            boolean performClick = super.performClick();
            AppMethodBeat.m2505o(62496);
            return performClick;
        } else {
            C4990ab.m7410d("MicroMsg.emoji.RTChattingEmojiView", "do nothing when loading");
            AppMethodBeat.m2505o(62496);
            return true;
        }
    }

    /* renamed from: Ln */
    private void m69614Ln(int i) {
        AppMethodBeat.m2504i(62497);
        this.mStatus = i;
        switch (i) {
            case 0:
                this.vpR.setVisibility(0);
                this.sLY.setVisibility(4);
                this.vpQ.setVisibility(4);
                setBackgroundResource(C25738R.drawable.a8g);
                AppMethodBeat.m2505o(62497);
                return;
            case 1:
                this.vpR.setVisibility(0);
                this.sLY.setVisibility(4);
                this.vpQ.setVisibility(4);
                setBackgroundResource(C25738R.drawable.f6573ik);
                AppMethodBeat.m2505o(62497);
                return;
            case 2:
                this.vpQ.setVisibility(0);
                this.vpR.setVisibility(4);
                this.sLY.setVisibility(4);
                setBackgroundResource(C25738R.drawable.a8g);
                break;
            case 3:
                Drawable drawable = getResources().getDrawable(C25738R.drawable.emoji_download_icon_samll);
                drawable.setBounds(0, 0, this.vpN, this.vpN);
                C4990ab.m7411d("MicroMsg.emoji.RTChattingEmojiView", "iconSize:%d hashcode:%d", Integer.valueOf(this.vpN), Integer.valueOf(hashCode()));
                this.sLY.setCompoundDrawables(null, drawable, null, null);
                this.sLY.setText(C25738R.string.b_u);
                this.sLY.setVisibility(0);
                this.vpR.setVisibility(4);
                this.vpQ.setVisibility(4);
                setBackgroundResource(C25738R.drawable.f6573ik);
                AppMethodBeat.m2505o(62497);
                return;
        }
        AppMethodBeat.m2505o(62497);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(62498);
        if (this.mStatus == 0 || this.mStatus == 1 || this.mStatus == 3) {
            int i3;
            if (this.kZa == null || this.kZa.field_height == 0) {
                i3 = this.vpL;
            } else {
                i3 = (int) (((float) this.kZa.field_height) * this.vpQ.getEmojiDensityScale());
                if (i3 < this.vpM) {
                    i3 = this.vpM;
                }
            }
            if (i3 > this.vpL) {
                i3 = this.vpL;
            }
            this.vpN = this.vpO;
            if (i3 >= this.vpM && i3 < this.vpM + (this.vpO - this.vpP)) {
                this.vpN = this.vpP + (i3 - this.vpM);
            }
            int i4 = this.vpL;
            setMeasuredDimension(i4, i3);
            super.onMeasure(MeasureSpec.makeMeasureSpec(i4, ErrorDialogData.SUPPRESSED), MeasureSpec.makeMeasureSpec(i3, ErrorDialogData.SUPPRESSED));
            m69614Ln(this.mStatus);
            AppMethodBeat.m2505o(62498);
            return;
        }
        super.onMeasure(i, i2);
        AppMethodBeat.m2505o(62498);
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.m2504i(62499);
        super.onAttachedToWindow();
        AppMethodBeat.m2505o(62499);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.m2504i(62500);
        super.onDetachedFromWindow();
        AppMethodBeat.m2505o(62500);
    }
}
