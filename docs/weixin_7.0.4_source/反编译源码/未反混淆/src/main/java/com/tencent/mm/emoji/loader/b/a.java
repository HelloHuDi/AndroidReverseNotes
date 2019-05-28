package com.tencent.mm.emoji.loader.b;

import a.f.a.m;
import a.f.b.j;
import a.k.v;
import a.l;
import a.y;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.gif.d;
import com.tencent.mm.plugin.gif.h;
import com.tencent.mm.pluginsdk.a.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.IOException;

@l(dWo = {1, 1, 13}, dWp = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JL\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2:\b\u0002\u0010\u000b\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\fR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, dWq = {"Lcom/tencent/mm/emoji/loader/decoder/AnimateDecoder;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "decode", "Landroid/graphics/drawable/Drawable;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "sizeCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "width", "height", "", "plugin-emojisdk_release"})
public final class a {
    private final String TAG = "MicroMsg.EmojiLoader.AnimateDecoder";

    /* JADX WARNING: Removed duplicated region for block: B:55:0x020b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x020b  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0227  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01bb  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x020b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x020b  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x020b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01bb  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0227  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x020b  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x020b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x007f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final Drawable a(EmojiInfo emojiInfo, m<? super Integer, ? super Integer, y> mVar) {
        Drawable drawable;
        int i;
        int i2;
        Drawable drawable2;
        MMGIFException mMGIFException;
        Drawable drawable3;
        IOException e;
        int i3 = 0;
        AppMethodBeat.i(63171);
        j.p(emojiInfo, "emojiInfo");
        String name;
        Context context;
        Context context2;
        if (emojiInfo.getGroup() == EmojiGroupInfo.yas || emojiInfo.getGroup() == EmojiInfo.yaA || emojiInfo.getGroup() == EmojiInfo.yaz) {
            name = emojiInfo.getName();
            j.o(name, "emojiInfo.name");
            ab.d(this.TAG, "emoji drawable name is %s", (String) v.a((CharSequence) name, new String[]{"."}).get(i3));
            context = ah.getContext();
            j.o(context, "MMApplicationContext.getContext()");
            int identifier = context.getResources().getIdentifier(name, "drawable", ah.getPackageName());
            context = ah.getContext();
            j.o(context, "MMApplicationContext.getContext()");
            drawable = context.getResources().getDrawable(identifier);
            i = i3;
            i2 = i3;
        } else if (emojiInfo.duS()) {
            name = emojiInfo.getName();
            j.o(name, "emojiInfo.name");
            ab.d(this.TAG, "emoji drawable name is %s", (String) v.a((CharSequence) name, new String[]{"."}).get(i3));
            context = ah.getContext();
            j.o(context, "MMApplicationContext.getContext()");
            int identifier2 = context.getResources().getIdentifier(name, "drawable", ah.getPackageName());
            context2 = ah.getContext();
            j.o(context2, "MMApplicationContext.getContext()");
            drawable = new d(context2.getResources().openRawResource(identifier2));
            i = i3;
            i2 = i3;
        } else if (emojiInfo.duP()) {
            com.tencent.mm.kernel.b.a M = g.M(com.tencent.mm.plugin.emoji.b.d.class);
            j.o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
            byte[] l = ((com.tencent.mm.plugin.emoji.b.d) M).getProvider().l(emojiInfo);
            if (bo.cb(l)) {
                ab.i(this.TAG, "decode: file decode error " + emojiInfo.Aq());
                emojiInfo.duQ();
                AppMethodBeat.o(63171);
                return null;
            }
            try {
                if (r.bU(l)) {
                    drawable = new h(l);
                    try {
                        com.tencent.mm.kernel.b.a M2 = g.M(com.tencent.mm.plugin.emoji.b.d.class);
                        j.o(M2, "MMKernel.plugin(IPluginEmoji::class.java)");
                        e provider = ((com.tencent.mm.plugin.emoji.b.d) M2).getProvider();
                        j.o(provider, "MMKernel.plugin(IPluginEmoji::class.java).provider");
                        if (provider.bjX()) {
                            drawable2 = drawable;
                        } else {
                            ab.w(this.TAG, "decode: file type and config not match");
                            emojiInfo.duQ();
                            com.tencent.mm.emoji.loader.a aVar = com.tencent.mm.emoji.loader.a.exs;
                            com.tencent.mm.emoji.loader.a.a(emojiInfo, null);
                            drawable2 = drawable;
                        }
                    } catch (MMGIFException e2) {
                        mMGIFException = e2;
                        drawable3 = drawable;
                        i2 = i3;
                        if (mMGIFException.getErrorCode() == 103) {
                        }
                        if (drawable != null) {
                        }
                        AppMethodBeat.o(63171);
                        return drawable;
                    } catch (IOException e3) {
                        e = e3;
                        drawable2 = drawable;
                        i2 = i3;
                        ab.printErrStackTrace(this.TAG, e, "", new Object[i3]);
                        drawable = drawable2;
                        i = i3;
                        if (drawable != null) {
                        }
                        AppMethodBeat.o(63171);
                        return drawable;
                    }
                }
                drawable2 = new d(l);
                try {
                    if (drawable2 instanceof d) {
                        i2 = ((d) drawable2).bFO();
                        try {
                            drawable = drawable2;
                            i = ((d) drawable2).bFP();
                        } catch (MMGIFException e4) {
                            mMGIFException = e4;
                            drawable3 = drawable2;
                            if (mMGIFException.getErrorCode() == 103) {
                                Bitmap bQ = com.tencent.mm.sdk.platformtools.d.bQ(l);
                                if (bQ == null) {
                                    ab.i(this.TAG, "decode: bitmap is null");
                                    emojiInfo.duQ();
                                    AppMethodBeat.o(63171);
                                    return null;
                                }
                                bQ.setDensity(320);
                                context2 = ah.getContext();
                                j.o(context2, "MMApplicationContext.getContext()");
                                drawable = new BitmapDrawable(context2.getResources(), bQ);
                                i2 = bQ.getWidth();
                                i = bQ.getHeight();
                            } else {
                                drawable = drawable3;
                                i = i3;
                            }
                            if (drawable != null) {
                            }
                            AppMethodBeat.o(63171);
                            return drawable;
                        } catch (IOException e5) {
                            e = e5;
                            ab.printErrStackTrace(this.TAG, e, "", new Object[i3]);
                            drawable = drawable2;
                            i = i3;
                            if (drawable != null) {
                            }
                            AppMethodBeat.o(63171);
                            return drawable;
                        }
                    }
                    i2 = ((h) drawable2).bFO();
                    drawable = drawable2;
                    i = ((h) drawable2).bFP();
                } catch (MMGIFException e42) {
                    mMGIFException = e42;
                    drawable3 = drawable2;
                    i2 = i3;
                } catch (IOException e6) {
                    e = e6;
                    i2 = i3;
                    ab.printErrStackTrace(this.TAG, e, "", new Object[i3]);
                    drawable = drawable2;
                    i = i3;
                    if (drawable != null) {
                    }
                    AppMethodBeat.o(63171);
                    return drawable;
                }
            } catch (MMGIFException e422) {
                mMGIFException = e422;
                drawable3 = null;
                i2 = i3;
                if (mMGIFException.getErrorCode() == 103) {
                }
                if (drawable != null) {
                }
                AppMethodBeat.o(63171);
                return drawable;
            } catch (IOException e7) {
                e = e7;
                drawable2 = null;
                i2 = i3;
                ab.printErrStackTrace(this.TAG, e, "", new Object[i3]);
                drawable = drawable2;
                i = i3;
                if (drawable != null) {
                }
                AppMethodBeat.o(63171);
                return drawable;
            }
        } else {
            AppMethodBeat.o(63171);
            return null;
        }
        if (drawable != null) {
            emojiInfo.duQ();
        } else if (mVar != null) {
            mVar.m(Integer.valueOf(i2), Integer.valueOf(i));
        }
        AppMethodBeat.o(63171);
        return drawable;
    }
}
