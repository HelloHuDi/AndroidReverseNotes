package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.gif.c;
import com.tencent.mm.plugin.gif.d;
import com.tencent.mm.plugin.gif.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.IOException;

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
        AppMethodBeat.i(62475);
        init(context);
        AppMethodBeat.o(62475);
    }

    public MMEmojiView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(62476);
        this.vpG = false;
        this.vpH = false;
        this.vpI = false;
        init(context);
        AppMethodBeat.o(62476);
    }

    private void init(Context context) {
        AppMethodBeat.i(62477);
        this.vpE = context.getResources().getDimensionPixelSize(R.dimen.a1h);
        this.vpF = context.getResources().getDimensionPixelSize(R.dimen.a1f);
        this.mScreenWidth = a.gd(context);
        setAdjustViewBounds(true);
        setMaxWidth(this.vpE);
        setMaxHeight(this.vpE);
        setMinimumWidth(this.vpF);
        setMinimumHeight(this.vpF);
        AppMethodBeat.o(62477);
    }

    public final void a(EmojiInfo emojiInfo, String str) {
        AppMethodBeat.i(62478);
        this.kZa = emojiInfo;
        String dve = emojiInfo.dve();
        if ((emojiInfo.field_reserved4 & EmojiInfo.zZi) != EmojiInfo.zZi) {
            eE(dve, str);
            AppMethodBeat.o(62478);
        } else if (c.bFN().Ox(str) != null) {
            setImageDrawable(c.bFN().Ox(str));
            AppMethodBeat.o(62478);
        } else {
            EmojiInfo emojiInfo2 = this.kZa;
            byte[] l = ((PluginEmoji) g.M(PluginEmoji.class)).getProvider().l(this.kZa);
            this.kZa = emojiInfo2;
            try {
                if (!bo.cb(l)) {
                    Drawable hVar;
                    if (bo.isNullOrNil(str)) {
                        if (r.bU(l) && ((PluginEmoji) g.M(PluginEmoji.class)).getProvider().bjX()) {
                            hVar = new h(l);
                            this.vpH = true;
                        } else {
                            ab.v("MicroMsg.emoji.MMEmojiView", "set with gif");
                            hVar = new d(l);
                        }
                        if (!hVar.isRunning()) {
                            hVar.reset();
                        }
                    } else {
                        setCacheKey(str);
                        hVar = c.bFN().x(getCacheKey(), l);
                    }
                    setImageDrawable(hVar);
                    AppMethodBeat.o(62478);
                    return;
                }
            } catch (MMGIFException e) {
                MMAnimateView.a(e);
                if (e.getErrorCode() == 103) {
                    ab.d("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray D_GIF_ERR_NOT_GIF_FILE");
                    Bitmap bQ = com.tencent.mm.sdk.platformtools.d.bQ(l);
                    if (bQ != null) {
                        bQ.setDensity(getEmojiDensity());
                        setImageBitmap(bQ);
                        AppMethodBeat.o(62478);
                        return;
                    }
                    ab.w("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed bitmap is null. bytes %s", l.toString());
                    if (this.kZa != null) {
                        this.kZa.duQ();
                        ab.i("MicroMsg.emoji.MMEmojiView", "delete file.");
                    }
                    init();
                    AppMethodBeat.o(62478);
                    return;
                }
                ab.e("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed. %s", e.toString());
                if (this.kZa != null) {
                    this.kZa.duQ();
                    ab.i("MicroMsg.emoji.MMEmojiView", "delete file.");
                }
            } catch (IOException e2) {
                ab.e("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed. %s", e2.toString());
            } catch (NullPointerException e3) {
                ab.e("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed. %s", e3.toString());
            }
            if (this.kZa != null) {
                this.kZa.duQ();
                ab.i("MicroMsg.emoji.MMEmojiView", "delete file.");
            }
            init();
            AppMethodBeat.o(62478);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        AppMethodBeat.i(62479);
        super.setImageDrawable(drawable);
        if (!(drawable == null || this.kZa == null)) {
            float f = 1.0f;
            if (drawable instanceof d) {
                f = ((d) drawable).getEmojiDensityScale();
            } else if (drawable instanceof h) {
                f = ((h) drawable).getEmojiDensityScale();
            } else if (!(drawable instanceof BitmapDrawable)) {
                AppMethodBeat.o(62479);
                return;
            }
            float intrinsicWidth = ((float) drawable.getIntrinsicWidth()) / f;
            f = ((float) drawable.getIntrinsicHeight()) / f;
            if (this.vpI && (this.kZa.field_width == 0 || this.kZa.field_height == 0)) {
                this.kZa.field_width = (int) intrinsicWidth;
                this.kZa.field_height = (int) f;
                ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().updateEmojiInfo(this.kZa);
            }
        }
        AppMethodBeat.o(62479);
    }

    public void setIsMaxSizeLimit(boolean z) {
        AppMethodBeat.i(62480);
        this.vpG = z;
        if (z) {
            setAdjustViewBounds(true);
            setMaxWidth(this.vpE);
            setMaxHeight(this.vpE);
            AppMethodBeat.o(62480);
            return;
        }
        setMaxHeight(BaseClientBuilder.API_PRIORITY_OTHER);
        setMaxHeight(BaseClientBuilder.API_PRIORITY_OTHER);
        AppMethodBeat.o(62480);
    }

    public void setMaxSize(int i) {
        this.vpE = i;
    }

    public void setUpdateEmojiSize(boolean z) {
        this.vpI = z;
    }
}
