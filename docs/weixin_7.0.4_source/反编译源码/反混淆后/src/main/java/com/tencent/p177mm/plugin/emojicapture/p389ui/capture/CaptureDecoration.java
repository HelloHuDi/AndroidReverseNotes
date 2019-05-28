package com.tencent.p177mm.plugin.emojicapture.p389ui.capture;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.emoji.view.BaseEmojiView;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C1677a;
import com.tencent.p177mm.plugin.emoji.p383h.C2933b;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.emojicapture.model.C34006c;
import com.tencent.p177mm.plugin.emojicapture.model.C34006c.C11617a;
import com.tencent.p177mm.plugin.emojicapture.model.p950a.C42971b;
import com.tencent.p177mm.plugin.emojicapture.p389ui.C20443a;
import com.tencent.p177mm.plugin.emojicapture.p389ui.editor.TextEditorItemView;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.ttpic.util.VideoMaterialUtil;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;
import p000a.p051k.C6163u;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0014J\b\u0010(\u001a\u0004\u0018\u00010)J\u0006\u0010*\u001a\u00020\tJ\u0006\u0010+\u001a\u00020%J\u0006\u0010,\u001a\u00020%J\u0006\u0010-\u001a\u00020%J\u0006\u0010.\u001a\u00020%J\u0006\u0010/\u001a\u00020%J\u0010\u00100\u001a\u00020%2\b\u00101\u001a\u0004\u0018\u00010\u0018J\u0010\u00102\u001a\u00020%2\b\u0010 \u001a\u0004\u0018\u00010!J\u0006\u00103\u001a\u00020%J\u0006\u00104\u001a\u00020%J\u001a\u00105\u001a\u00020%2\b\u00106\u001a\u0004\u0018\u00010)2\b\u00107\u001a\u0004\u0018\u00010)R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000¨\u00068"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/capture/CaptureDecoration;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "clipPath", "Landroid/graphics/Path;", "clipRadius", "", "clipRect", "Landroid/graphics/RectF;", "emojiHint", "Lcom/tencent/mm/emoji/view/BaseEmojiView;", "firstSelect", "", "hideStickerHintRunnable", "Ljava/lang/Runnable;", "imitateEmoji", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "showStickerHintRunnable", "stickerHint", "Landroid/view/View;", "stickerHintIcon", "Landroid/widget/ImageView;", "stickerHintText", "Landroid/widget/TextView;", "stickerInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerInfo;", "textHint", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/TextEditorItemView;", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "getText", "", "getTextColor", "hideStickerHint", "onRecordStart", "onRecordStop", "pause", "resume", "setImitateEmoji", "emojiInfo", "setStickerInfo", "showImitateEmoji", "showStickerHint", "showTextHint", "text", "colorString", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.ui.capture.CaptureDecoration */
public final class CaptureDecoration extends FrameLayout {
    C42971b lhH;
    private final Path lkh;
    public final TextEditorItemView lmA;
    final View lmB;
    final ImageView lmC;
    final TextView lmD;
    private EmojiInfo lmE;
    private boolean lmF;
    private final Runnable lmG;
    final Runnable lmH;
    private final RectF lmx;
    private final float lmy;
    public final BaseEmojiView lmz;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.capture.CaptureDecoration$a */
    static final class C20454a implements Runnable {
        final /* synthetic */ CaptureDecoration lmI;

        C20454a(CaptureDecoration captureDecoration) {
            this.lmI = captureDecoration;
        }

        public final void run() {
            AppMethodBeat.m2504i(2988);
            this.lmI.lmC.setImageDrawable(null);
            this.lmI.lmB.setVisibility(8);
            AppMethodBeat.m2505o(2988);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.capture.CaptureDecoration$b */
    static final class C34016b implements Runnable {
        final /* synthetic */ CaptureDecoration lmI;

        C34016b(CaptureDecoration captureDecoration) {
            this.lmI = captureDecoration;
        }

        public final void run() {
            AppMethodBeat.m2504i(2989);
            CaptureDecoration captureDecoration = this.lmI;
            captureDecoration.lmB.animate().cancel();
            captureDecoration.lmB.animate().alpha(0.0f).withEndAction(new C20454a(captureDecoration));
            AppMethodBeat.m2505o(2989);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.capture.CaptureDecoration$c */
    static final class C34017c implements Runnable {
        final /* synthetic */ CaptureDecoration lmI;

        C34017c(CaptureDecoration captureDecoration) {
            this.lmI = captureDecoration;
        }

        public final void run() {
            AppMethodBeat.m2504i(2990);
            CaptureDecoration captureDecoration = this.lmI;
            captureDecoration.lmz.setVisibility(8);
            captureDecoration.lmB.setVisibility(0);
            captureDecoration.lmB.animate().cancel();
            captureDecoration.lmB.setAlpha(1.0f);
            C42971b c42971b = captureDecoration.lhH;
            if (c42971b != null) {
                captureDecoration.lmD.setText(c42971b.kfM);
                AnimationDrawable animationDrawable = new AnimationDrawable();
                for (String bitmapDrawable : c42971b.lhM) {
                    animationDrawable.addFrame(new BitmapDrawable(captureDecoration.getResources(), bitmapDrawable), 300);
                }
                captureDecoration.lmC.setImageDrawable(animationDrawable);
                animationDrawable.start();
            }
            captureDecoration.postDelayed(captureDecoration.lmH, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
            AppMethodBeat.m2505o(2990);
        }
    }

    public CaptureDecoration(Context context, AttributeSet attributeSet, int i) {
        C25052j.m39376p(context, "context");
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(2999);
        this.lkh = new Path();
        this.lmx = new RectF();
        this.lmy = context.getResources().getDimension(C25738R.dimen.f9629f);
        this.lmF = true;
        this.lmG = new C34017c(this);
        this.lmH = new C34016b(this);
        View.inflate(context, 2130969327, this);
        View findViewById = findViewById(2131823436);
        C25052j.m39375o(findViewById, "findViewById(R.id.emoji_capture_emoji_hint)");
        this.lmz = (BaseEmojiView) findViewById;
        findViewById = findViewById(2131823440);
        C25052j.m39375o(findViewById, "findViewById(R.id.emoji_capture_text_hint)");
        this.lmA = (TextEditorItemView) findViewById;
        findViewById = findViewById(2131823437);
        C25052j.m39375o(findViewById, "findViewById(R.id.emoji_capture_sticker_hint)");
        this.lmB = findViewById;
        findViewById = findViewById(2131823438);
        C25052j.m39375o(findViewById, "findViewById(R.id.emoji_capture_sticker_hint_icon)");
        this.lmC = (ImageView) findViewById;
        findViewById = findViewById(2131823439);
        C25052j.m39375o(findViewById, "findViewById(R.id.emoji_capture_sticker_hint_text)");
        this.lmD = (TextView) findViewById;
        float dimension = context.getResources().getDimension(C25738R.dimen.f9630g);
        this.lmA.mo35774a(new RectF(0.0f, 0.0f, dimension, dimension), this.lmy);
        AppMethodBeat.m2505o(2999);
    }

    public CaptureDecoration(Context context, AttributeSet attributeSet) {
        C25052j.m39376p(context, "context");
        this(context, attributeSet, 0);
        AppMethodBeat.m2504i(AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
        AppMethodBeat.m2505o(AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dispatchDraw(Canvas canvas) {
        AppMethodBeat.m2504i(2991);
        C25052j.m39376p(canvas, VideoMaterialUtil.CRAZYFACE_CANVAS);
        this.lmx.set(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight());
        this.lkh.addRoundRect(this.lmx, this.lmy, this.lmy, Direction.CW);
        canvas.clipPath(this.lkh);
        super.dispatchDraw(canvas);
        AppMethodBeat.m2505o(2991);
    }

    public final void setImitateEmoji(EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(2992);
        this.lmE = emojiInfo;
        bnZ();
        AppMethodBeat.m2505o(2992);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0082  */
    /* JADX WARNING: Missing block: B:21:0x0063, code skipped:
            if (r0 == null) goto L_0x0065;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setStickerInfo(C42971b c42971b) {
        String str = null;
        AppMethodBeat.m2504i(2993);
        if ((C25052j.m39373j(this.lhH, c42971b) ^ 1) != 0) {
            this.lhH = c42971b;
            this.lmB.setVisibility(8);
            this.lmz.setVisibility(8);
            this.lmA.setVisibility(8);
            this.lmA.mo35775a(null, -1, true);
            removeCallbacks(this.lmH);
            removeCallbacks(this.lmG);
            if (c42971b != null) {
                String str2;
                boolean z;
                String str3 = c42971b.title;
                if (this.lmE != null) {
                    String str4 = c42971b.lgY;
                    EmojiInfo emojiInfo = this.lmE;
                    if (C25052j.m39373j(str4, emojiInfo != null ? emojiInfo.field_lensId : null) && this.lmF) {
                        this.lmF = false;
                        emojiInfo = this.lmE;
                        if (emojiInfo != null) {
                            str = emojiInfo.field_attachedText;
                        }
                        if (!C5046bo.isNullOrNil(str)) {
                            emojiInfo = this.lmE;
                            if (emojiInfo != null) {
                                str2 = emojiInfo.field_attachedText;
                            }
                            str2 = "";
                            m55730dP(str2, c42971b.fhL);
                            if (C6163u.m9837ar(c42971b.kfM) || !c42971b.lhM.isEmpty()) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                postDelayed(this.lmG, 500);
                                AppMethodBeat.m2505o(2993);
                                return;
                            }
                        }
                    }
                }
                str2 = str3;
                m55730dP(str2, c42971b.fhL);
                if (C6163u.m9837ar(c42971b.kfM)) {
                }
                z = true;
                if (z) {
                }
            } else if (this.lmE != null) {
                bnZ();
                AppMethodBeat.m2505o(2993);
                return;
            } else {
                this.lmz.setVisibility(8);
            }
        }
        AppMethodBeat.m2505o(2993);
    }

    private void bnZ() {
        AppMethodBeat.m2504i(2994);
        EmojiInfo emojiInfo = this.lmE;
        if (emojiInfo != null) {
            String Jh;
            this.lmz.setVisibility(0);
            this.lmz.setEmojiInfo(emojiInfo);
            if (C2933b.m5225w(emojiInfo)) {
                C1677a M = C1720g.m3530M(C6835d.class);
                C25052j.m39375o(M, "plugin(IPluginEmoji::class.java)");
                Jh = ((C6835d) M).getProvider().mo35600Jh(emojiInfo.mo20410Aq());
            } else {
                Jh = emojiInfo.field_attachedText;
            }
            m55730dP(Jh, emojiInfo.field_attachTextColor);
            AppMethodBeat.m2505o(2994);
            return;
        }
        AppMethodBeat.m2505o(2994);
    }

    /* renamed from: dP */
    private void m55730dP(String str, String str2) {
        AppMethodBeat.m2504i(2995);
        if (!C5046bo.isNullOrNil(str)) {
            CharSequence charSequence = str2;
            int i = (charSequence == null || C6163u.m9837ar(charSequence)) ? true : 0;
            if (i == 0) {
                C11617a c11617a = C34006c.lhw;
                i = C20443a.m31594uA(C11617a.m19436Ka(str2));
            } else {
                i = -1;
            }
            this.lmA.mo35775a(str, i, true);
            this.lmA.setVisibility(0);
        }
        AppMethodBeat.m2505o(2995);
    }

    public final String getText() {
        AppMethodBeat.m2504i(2996);
        CharSequence text = this.lmA.getText();
        if (text != null) {
            String obj = text.toString();
            AppMethodBeat.m2505o(2996);
            return obj;
        }
        AppMethodBeat.m2505o(2996);
        return null;
    }

    public final int getTextColor() {
        AppMethodBeat.m2504i(2997);
        int textColor = this.lmA.getTextColor();
        if (textColor != 0) {
            textColor = C20443a.m31594uA(textColor);
        } else {
            textColor = -1;
        }
        AppMethodBeat.m2505o(2997);
        return textColor;
    }

    public final void resume() {
        AppMethodBeat.m2504i(2998);
        this.lmz.resume();
        this.lmA.boc();
        AppMethodBeat.m2505o(2998);
    }
}
