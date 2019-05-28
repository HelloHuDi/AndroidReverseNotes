package com.tencent.mm.pluginsdk.ui.emoji;

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
import com.tencent.mm.R;
import com.tencent.mm.emoji.view.EmojiStatusView.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiInfo;

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

    public RTChattingEmojiView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RTChattingEmojiView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void initView() {
        AppMethodBeat.i(62490);
        this.vpL = getContext().getResources().getDimensionPixelSize(R.dimen.a1h);
        this.vpM = getContext().getResources().getDimensionPixelSize(R.dimen.a1e);
        this.vpO = getContext().getResources().getDimensionPixelSize(R.dimen.a1k);
        this.vpP = getContext().getResources().getDimensionPixelSize(R.dimen.a1j);
        this.vpQ = new ChattingEmojiView(getContext());
        this.vpR = new ProgressBar(getContext());
        this.vpR.setIndeterminateDrawable(getResources().getDrawable(R.drawable.xi));
        this.sLY = new TextView(getContext());
        this.sLY.setText(R.string.b_u);
        this.sLY.setTextColor(getResources().getColor(R.color.mz));
        this.vpS = new LayoutParams(-2, -2);
        this.vpT = new LayoutParams(-2, -2);
        this.vpS.gravity = 17;
        addView(this.vpR, this.vpS);
        addView(this.sLY, this.vpS);
        AppMethodBeat.o(62490);
    }

    public final void dkQ() {
        AppMethodBeat.i(62491);
        this.vpT.gravity = 3;
        addView(this.vpQ, this.vpT);
        AppMethodBeat.o(62491);
    }

    public final void dkR() {
        AppMethodBeat.i(62492);
        this.vpT.gravity = 5;
        addView(this.vpQ, this.vpT);
        AppMethodBeat.o(62492);
    }

    public final void a(EmojiInfo emojiInfo, long j) {
        AppMethodBeat.i(62493);
        a(emojiInfo, j, new ap(""));
        AppMethodBeat.o(62493);
    }

    public final void a(EmojiInfo emojiInfo, long j, ap apVar) {
        boolean z = false;
        AppMethodBeat.i(62494);
        ab.i("MicroMsg.emoji.RTChattingEmojiView", "setEmojiInfo %s msgId %s", emojiInfo.field_md5, Long.valueOf(j));
        this.kZa = emojiInfo;
        if (this.kZa.xy()) {
            this.vpQ.setStatus(1);
            Ln(2);
            bi jf = ((j) g.K(j.class)).bOr().jf(j);
            boolean z2 = jf.field_status == 2 || jf.field_status == 3 || jf.field_status == 5;
            ChattingEmojiView chattingEmojiView = this.vpQ;
            if (!apVar.fWX) {
                z = true;
            }
            chattingEmojiView.a(z, z2, ((PluginEmoji) g.M(PluginEmoji.class)).getEmojiMgr().o(emojiInfo), ((PluginEmoji) g.M(PluginEmoji.class)).getEmojiMgr().p(emojiInfo), emojiInfo.getName(), String.valueOf(j + emojiInfo.getName()));
            AppMethodBeat.o(62494);
            return;
        }
        this.ngN = true;
        this.vpQ.setStatusListener(new b() {
            public final void jm(int i) {
                AppMethodBeat.i(62489);
                if (i == 0) {
                    RTChattingEmojiView.a(RTChattingEmojiView.this, RTChattingEmojiView.this.ngN ? 0 : 1);
                    AppMethodBeat.o(62489);
                } else if (i == -1) {
                    RTChattingEmojiView.a(RTChattingEmojiView.this, 3);
                    AppMethodBeat.o(62489);
                } else {
                    RTChattingEmojiView.a(RTChattingEmojiView.this, 2);
                    AppMethodBeat.o(62489);
                }
            }
        });
        this.vpQ.a(this.kZa, j);
        AppMethodBeat.o(62494);
    }

    public void setImageBitmap(Bitmap bitmap) {
        AppMethodBeat.i(62495);
        Ln(2);
        if (!(this.vpQ == null || bitmap == null || bitmap.isRecycled())) {
            bitmap.setDensity(this.vpQ.getEmojiDensity());
            this.vpQ.setImageBitmap(bitmap);
        }
        AppMethodBeat.o(62495);
    }

    public boolean performClick() {
        AppMethodBeat.i(62496);
        ab.i("MicroMsg.emoji.RTChattingEmojiView", "performClick: %s", Integer.valueOf(this.mStatus));
        if (this.mStatus == 3) {
            this.ngN = false;
            this.vpQ.reload();
            AppMethodBeat.o(62496);
            return true;
        } else if (this.mStatus == 2) {
            boolean performClick = super.performClick();
            AppMethodBeat.o(62496);
            return performClick;
        } else {
            ab.d("MicroMsg.emoji.RTChattingEmojiView", "do nothing when loading");
            AppMethodBeat.o(62496);
            return true;
        }
    }

    private void Ln(int i) {
        AppMethodBeat.i(62497);
        this.mStatus = i;
        switch (i) {
            case 0:
                this.vpR.setVisibility(0);
                this.sLY.setVisibility(4);
                this.vpQ.setVisibility(4);
                setBackgroundResource(R.drawable.a8g);
                AppMethodBeat.o(62497);
                return;
            case 1:
                this.vpR.setVisibility(0);
                this.sLY.setVisibility(4);
                this.vpQ.setVisibility(4);
                setBackgroundResource(R.drawable.ik);
                AppMethodBeat.o(62497);
                return;
            case 2:
                this.vpQ.setVisibility(0);
                this.vpR.setVisibility(4);
                this.sLY.setVisibility(4);
                setBackgroundResource(R.drawable.a8g);
                break;
            case 3:
                Drawable drawable = getResources().getDrawable(R.drawable.emoji_download_icon_samll);
                drawable.setBounds(0, 0, this.vpN, this.vpN);
                ab.d("MicroMsg.emoji.RTChattingEmojiView", "iconSize:%d hashcode:%d", Integer.valueOf(this.vpN), Integer.valueOf(hashCode()));
                this.sLY.setCompoundDrawables(null, drawable, null, null);
                this.sLY.setText(R.string.b_u);
                this.sLY.setVisibility(0);
                this.vpR.setVisibility(4);
                this.vpQ.setVisibility(4);
                setBackgroundResource(R.drawable.ik);
                AppMethodBeat.o(62497);
                return;
        }
        AppMethodBeat.o(62497);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(62498);
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
            Ln(this.mStatus);
            AppMethodBeat.o(62498);
            return;
        }
        super.onMeasure(i, i2);
        AppMethodBeat.o(62498);
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(62499);
        super.onAttachedToWindow();
        AppMethodBeat.o(62499);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(62500);
        super.onDetachedFromWindow();
        AppMethodBeat.o(62500);
    }
}
