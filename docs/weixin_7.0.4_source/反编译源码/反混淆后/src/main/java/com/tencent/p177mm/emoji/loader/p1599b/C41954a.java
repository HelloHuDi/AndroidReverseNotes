package com.tencent.p177mm.emoji.loader.p1599b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.emoji.loader.C37682a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C1677a;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.gif.C3266d;
import com.tencent.p177mm.plugin.gif.C36775h;
import com.tencent.p177mm.plugin.gif.MMGIFException;
import com.tencent.p177mm.pluginsdk.p1336a.C44039e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C5063r;
import com.tencent.p177mm.storage.emotion.EmojiGroupInfo;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import java.io.IOException;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;
import p000a.p051k.C31820v;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JL\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2:\b\u0002\u0010\u000b\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\fR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, dWq = {"Lcom/tencent/mm/emoji/loader/decoder/AnimateDecoder;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "decode", "Landroid/graphics/drawable/Drawable;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "sizeCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "width", "height", "", "plugin-emojisdk_release"})
/* renamed from: com.tencent.mm.emoji.loader.b.a */
public final class C41954a {
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
    /* renamed from: a */
    public final Drawable mo67590a(EmojiInfo emojiInfo, C31591m<? super Integer, ? super Integer, C37091y> c31591m) {
        Drawable drawable;
        int i;
        int i2;
        Drawable drawable2;
        MMGIFException mMGIFException;
        Drawable drawable3;
        IOException e;
        int i3 = 0;
        AppMethodBeat.m2504i(63171);
        C25052j.m39376p(emojiInfo, "emojiInfo");
        String name;
        Context context;
        Context context2;
        if (emojiInfo.getGroup() == EmojiGroupInfo.yas || emojiInfo.getGroup() == EmojiInfo.yaA || emojiInfo.getGroup() == EmojiInfo.yaz) {
            name = emojiInfo.getName();
            C25052j.m39375o(name, "emojiInfo.name");
            C4990ab.m7411d(this.TAG, "emoji drawable name is %s", (String) C31820v.m51524a((CharSequence) name, new String[]{"."}).get(i3));
            context = C4996ah.getContext();
            C25052j.m39375o(context, "MMApplicationContext.getContext()");
            int identifier = context.getResources().getIdentifier(name, "drawable", C4996ah.getPackageName());
            context = C4996ah.getContext();
            C25052j.m39375o(context, "MMApplicationContext.getContext()");
            drawable = context.getResources().getDrawable(identifier);
            i = i3;
            i2 = i3;
        } else if (emojiInfo.duS()) {
            name = emojiInfo.getName();
            C25052j.m39375o(name, "emojiInfo.name");
            C4990ab.m7411d(this.TAG, "emoji drawable name is %s", (String) C31820v.m51524a((CharSequence) name, new String[]{"."}).get(i3));
            context = C4996ah.getContext();
            C25052j.m39375o(context, "MMApplicationContext.getContext()");
            int identifier2 = context.getResources().getIdentifier(name, "drawable", C4996ah.getPackageName());
            context2 = C4996ah.getContext();
            C25052j.m39375o(context2, "MMApplicationContext.getContext()");
            drawable = new C3266d(context2.getResources().openRawResource(identifier2));
            i = i3;
            i2 = i3;
        } else if (emojiInfo.duP()) {
            C1677a M = C1720g.m3530M(C6835d.class);
            C25052j.m39375o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
            byte[] l = ((C6835d) M).getProvider().mo35656l(emojiInfo);
            if (C5046bo.m7540cb(l)) {
                C4990ab.m7416i(this.TAG, "decode: file decode error " + emojiInfo.mo20410Aq());
                emojiInfo.duQ();
                AppMethodBeat.m2505o(63171);
                return null;
            }
            try {
                if (C5063r.m7679bU(l)) {
                    drawable = new C36775h(l);
                    try {
                        C1677a M2 = C1720g.m3530M(C6835d.class);
                        C25052j.m39375o(M2, "MMKernel.plugin(IPluginEmoji::class.java)");
                        C44039e provider = ((C6835d) M2).getProvider();
                        C25052j.m39375o(provider, "MMKernel.plugin(IPluginEmoji::class.java).provider");
                        if (provider.bjX()) {
                            drawable2 = drawable;
                        } else {
                            C4990ab.m7420w(this.TAG, "decode: file type and config not match");
                            emojiInfo.duQ();
                            C37682a c37682a = C37682a.exs;
                            C37682a.m63722a(emojiInfo, null);
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
                        AppMethodBeat.m2505o(63171);
                        return drawable;
                    } catch (IOException e3) {
                        e = e3;
                        drawable2 = drawable;
                        i2 = i3;
                        C4990ab.printErrStackTrace(this.TAG, e, "", new Object[i3]);
                        drawable = drawable2;
                        i = i3;
                        if (drawable != null) {
                        }
                        AppMethodBeat.m2505o(63171);
                        return drawable;
                    }
                }
                drawable2 = new C3266d(l);
                try {
                    if (drawable2 instanceof C3266d) {
                        i2 = ((C3266d) drawable2).bFO();
                        try {
                            drawable = drawable2;
                            i = ((C3266d) drawable2).bFP();
                        } catch (MMGIFException e4) {
                            mMGIFException = e4;
                            drawable3 = drawable2;
                            if (mMGIFException.getErrorCode() == 103) {
                                Bitmap bQ = C5056d.m7652bQ(l);
                                if (bQ == null) {
                                    C4990ab.m7416i(this.TAG, "decode: bitmap is null");
                                    emojiInfo.duQ();
                                    AppMethodBeat.m2505o(63171);
                                    return null;
                                }
                                bQ.setDensity(320);
                                context2 = C4996ah.getContext();
                                C25052j.m39375o(context2, "MMApplicationContext.getContext()");
                                drawable = new BitmapDrawable(context2.getResources(), bQ);
                                i2 = bQ.getWidth();
                                i = bQ.getHeight();
                            } else {
                                drawable = drawable3;
                                i = i3;
                            }
                            if (drawable != null) {
                            }
                            AppMethodBeat.m2505o(63171);
                            return drawable;
                        } catch (IOException e5) {
                            e = e5;
                            C4990ab.printErrStackTrace(this.TAG, e, "", new Object[i3]);
                            drawable = drawable2;
                            i = i3;
                            if (drawable != null) {
                            }
                            AppMethodBeat.m2505o(63171);
                            return drawable;
                        }
                    }
                    i2 = ((C36775h) drawable2).bFO();
                    drawable = drawable2;
                    i = ((C36775h) drawable2).bFP();
                } catch (MMGIFException e42) {
                    mMGIFException = e42;
                    drawable3 = drawable2;
                    i2 = i3;
                } catch (IOException e6) {
                    e = e6;
                    i2 = i3;
                    C4990ab.printErrStackTrace(this.TAG, e, "", new Object[i3]);
                    drawable = drawable2;
                    i = i3;
                    if (drawable != null) {
                    }
                    AppMethodBeat.m2505o(63171);
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
                AppMethodBeat.m2505o(63171);
                return drawable;
            } catch (IOException e7) {
                e = e7;
                drawable2 = null;
                i2 = i3;
                C4990ab.printErrStackTrace(this.TAG, e, "", new Object[i3]);
                drawable = drawable2;
                i = i3;
                if (drawable != null) {
                }
                AppMethodBeat.m2505o(63171);
                return drawable;
            }
        } else {
            AppMethodBeat.m2505o(63171);
            return null;
        }
        if (drawable != null) {
            emojiInfo.duQ();
        } else if (c31591m != null) {
            c31591m.mo212m(Integer.valueOf(i2), Integer.valueOf(i));
        }
        AppMethodBeat.m2505o(63171);
        return drawable;
    }
}
