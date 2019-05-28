package com.tencent.p177mm.pluginsdk.p597ui.emoji;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.emoji.PluginEmoji;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.gif.C12215c;
import com.tencent.p177mm.plugin.gif.C3266d;
import com.tencent.p177mm.plugin.gif.C36775h;
import com.tencent.p177mm.plugin.gif.MMAnimateView;
import com.tencent.p177mm.plugin.gif.MMGIFException;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C5063r;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import java.io.IOException;

/* renamed from: com.tencent.mm.pluginsdk.ui.emoji.MMEmojiView */
public class MMEmojiView extends MMAnimateView {
    protected EmojiInfo kZa;
    private int mScreenWidth;
    protected int vpE;
    protected int vpF;
    private boolean vpG;
    private boolean vpH;
    private boolean vpI;

    public MMEmojiView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
        AppMethodBeat.m2504i(62475);
        init(context);
        AppMethodBeat.m2505o(62475);
    }

    public MMEmojiView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(62476);
        this.vpG = false;
        this.vpH = false;
        this.vpI = false;
        init(context);
        AppMethodBeat.m2505o(62476);
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(62477);
        this.vpE = context.getResources().getDimensionPixelSize(C25738R.dimen.a1h);
        this.vpF = context.getResources().getDimensionPixelSize(C25738R.dimen.a1f);
        this.mScreenWidth = C1338a.m2868gd(context);
        setAdjustViewBounds(true);
        setMaxWidth(this.vpE);
        setMaxHeight(this.vpE);
        setMinimumWidth(this.vpF);
        setMinimumHeight(this.vpF);
        AppMethodBeat.m2505o(62477);
    }

    /* renamed from: a */
    public final void mo56663a(EmojiInfo emojiInfo, String str) {
        AppMethodBeat.m2504i(62478);
        this.kZa = emojiInfo;
        String dve = emojiInfo.dve();
        if ((emojiInfo.field_reserved4 & EmojiInfo.zZi) != EmojiInfo.zZi) {
            mo46176eE(dve, str);
            AppMethodBeat.m2505o(62478);
        } else if (C12215c.bFN().mo24058Ox(str) != null) {
            setImageDrawable(C12215c.bFN().mo24058Ox(str));
            AppMethodBeat.m2505o(62478);
        } else {
            EmojiInfo emojiInfo2 = this.kZa;
            byte[] l = ((PluginEmoji) C1720g.m3530M(PluginEmoji.class)).getProvider().mo35656l(this.kZa);
            this.kZa = emojiInfo2;
            try {
                if (!C5046bo.m7540cb(l)) {
                    Drawable c36775h;
                    if (C5046bo.isNullOrNil(str)) {
                        if (C5063r.m7679bU(l) && ((PluginEmoji) C1720g.m3530M(PluginEmoji.class)).getProvider().bjX()) {
                            c36775h = new C36775h(l);
                            this.vpH = true;
                        } else {
                            C4990ab.m7418v("MicroMsg.emoji.MMEmojiView", "set with gif");
                            c36775h = new C3266d(l);
                        }
                        if (!c36775h.isRunning()) {
                            c36775h.reset();
                        }
                    } else {
                        setCacheKey(str);
                        c36775h = C12215c.bFN().mo24061x(getCacheKey(), l);
                    }
                    setImageDrawable(c36775h);
                    AppMethodBeat.m2505o(62478);
                    return;
                }
            } catch (MMGIFException e) {
                MMAnimateView.m44846a(e);
                if (e.getErrorCode() == 103) {
                    C4990ab.m7410d("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray D_GIF_ERR_NOT_GIF_FILE");
                    Bitmap bQ = C5056d.m7652bQ(l);
                    if (bQ != null) {
                        bQ.setDensity(getEmojiDensity());
                        setImageBitmap(bQ);
                        AppMethodBeat.m2505o(62478);
                        return;
                    }
                    C4990ab.m7421w("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed bitmap is null. bytes %s", l.toString());
                    if (this.kZa != null) {
                        this.kZa.duQ();
                        C4990ab.m7416i("MicroMsg.emoji.MMEmojiView", "delete file.");
                    }
                    init();
                    AppMethodBeat.m2505o(62478);
                    return;
                }
                C4990ab.m7413e("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed. %s", e.toString());
                if (this.kZa != null) {
                    this.kZa.duQ();
                    C4990ab.m7416i("MicroMsg.emoji.MMEmojiView", "delete file.");
                }
            } catch (IOException e2) {
                C4990ab.m7413e("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed. %s", e2.toString());
            } catch (NullPointerException e3) {
                C4990ab.m7413e("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed. %s", e3.toString());
            }
            if (this.kZa != null) {
                this.kZa.duQ();
                C4990ab.m7416i("MicroMsg.emoji.MMEmojiView", "delete file.");
            }
            init();
            AppMethodBeat.m2505o(62478);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        AppMethodBeat.m2504i(62479);
        super.setImageDrawable(drawable);
        if (!(drawable == null || this.kZa == null)) {
            float f = 1.0f;
            if (drawable instanceof C3266d) {
                f = ((C3266d) drawable).getEmojiDensityScale();
            } else if (drawable instanceof C36775h) {
                f = ((C36775h) drawable).getEmojiDensityScale();
            } else if (!(drawable instanceof BitmapDrawable)) {
                AppMethodBeat.m2505o(62479);
                return;
            }
            float intrinsicWidth = ((float) drawable.getIntrinsicWidth()) / f;
            f = ((float) drawable.getIntrinsicHeight()) / f;
            if (this.vpI && (this.kZa.field_width == 0 || this.kZa.field_height == 0)) {
                this.kZa.field_width = (int) intrinsicWidth;
                this.kZa.field_height = (int) f;
                ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().updateEmojiInfo(this.kZa);
            }
        }
        AppMethodBeat.m2505o(62479);
    }

    public void setIsMaxSizeLimit(boolean z) {
        AppMethodBeat.m2504i(62480);
        this.vpG = z;
        if (z) {
            setAdjustViewBounds(true);
            setMaxWidth(this.vpE);
            setMaxHeight(this.vpE);
            AppMethodBeat.m2505o(62480);
            return;
        }
        setMaxHeight(BaseClientBuilder.API_PRIORITY_OTHER);
        setMaxHeight(BaseClientBuilder.API_PRIORITY_OTHER);
        AppMethodBeat.m2505o(62480);
    }

    public void setMaxSize(int i) {
        this.vpE = i;
    }

    public void setUpdateEmojiSize(boolean z) {
        this.vpI = z;
    }
}
