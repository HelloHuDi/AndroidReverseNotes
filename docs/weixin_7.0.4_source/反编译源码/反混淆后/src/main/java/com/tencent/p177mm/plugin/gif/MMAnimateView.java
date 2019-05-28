package com.tencent.p177mm.plugin.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.p069v7.widget.AppCompatImageView;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C37736ih;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C5063r;
import com.tencent.p177mm.vfs.C5730e;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.plugin.gif.MMAnimateView */
public class MMAnimateView extends AppCompatImageView {
    private String kRZ;
    private float mDensity;
    private int nox;
    private int noy;
    private boolean noz;

    public MMAnimateView(Context context) {
        this(context, null);
    }

    public MMAnimateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public MMAnimateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(62358);
        this.nox = C25738R.drawable.emoji_download_icon;
        this.noy = C25738R.drawable.f6539hj;
        this.noz = true;
        this.mDensity = 0.0f;
        if (C1443d.m3068iW(26)) {
            setLayerType(1, null);
        }
        AppMethodBeat.m2505o(62358);
    }

    public void setImageResource(int i) {
        AppMethodBeat.m2504i(62359);
        m44845a(getResources(), i, true);
        AppMethodBeat.m2505o(62359);
    }

    public void setBackgroundResource(int i) {
        AppMethodBeat.m2504i(62360);
        m44845a(getResources(), i, false);
        AppMethodBeat.m2505o(62360);
    }

    public void setImageFilePath(String str) {
        AppMethodBeat.m2504i(62361);
        m44847eF(str, null);
        AppMethodBeat.m2505o(62361);
    }

    /* renamed from: eE */
    public final void mo46176eE(String str, String str2) {
        AppMethodBeat.m2504i(62362);
        m44847eF(str, str2);
        AppMethodBeat.m2505o(62362);
    }

    public void setDefaultImageResource(int i) {
        this.nox = i;
    }

    public void setDefaultBackgroundResource(int i) {
        this.nox = i;
    }

    public float getEmojiDensityScale() {
        AppMethodBeat.m2504i(62364);
        if (this.mDensity == 0.0f) {
            this.mDensity = C1338a.getDensity(C4996ah.getContext()) / 2.0f;
            if (this.mDensity < 1.0f) {
                this.mDensity = 1.0f;
            } else if (this.mDensity > 2.0f) {
                this.mDensity = 2.0f;
            }
        }
        float f = this.mDensity;
        AppMethodBeat.m2505o(62364);
        return f;
    }

    public int getEmojiDensity() {
        return 320;
    }

    public String getCacheKey() {
        return this.kRZ;
    }

    public void setCacheKey(String str) {
        this.kRZ = str;
    }

    /* renamed from: a */
    public final void mo46174a(boolean z, boolean z2, int i, int[] iArr, String str, String str2) {
        AppMethodBeat.m2504i(62365);
        C3273e c3273e;
        if (C5046bo.isNullOrNil(str2)) {
            c3273e = new C3273e(getContext(), z, z2, i, iArr, str);
            c3273e.start();
            setImageDrawable(c3273e);
            AppMethodBeat.m2505o(62365);
            return;
        }
        setCacheKey(str2);
        C12215c bFN = C12215c.bFN();
        Context context = getContext();
        if (TextUtils.isEmpty(str)) {
            c3273e = null;
        } else {
            if (bFN.nou.get(str2) == null || ((WeakReference) bFN.nou.get(str2)).get() == null) {
                c3273e = null;
            } else {
                c3273e = (C3273e) ((WeakReference) bFN.nou.get(str2)).get();
            }
            if (c3273e == null) {
                c3273e = new C3273e(context, z, z2, i, iArr, str);
                bFN.nou.put(str2, new WeakReference(c3273e));
            }
        }
        if (c3273e != null) {
            c3273e.npj = z2;
            if (z == c3273e.mIsPlaying) {
                c3273e.start();
            } else {
                c3273e.lfO = 0;
                c3273e.npl = 0;
                c3273e.mIsPlaying = true;
                c3273e.start();
            }
            setImageDrawable(c3273e);
            AppMethodBeat.m2505o(62365);
            return;
        }
        C4990ab.m7412e("MicroMsg.GIF.MMGIFImageView", "can not get drawable.");
        AppMethodBeat.m2505o(62365);
    }

    /* renamed from: a */
    private void m44845a(Resources resources, int i, boolean z) {
        AppMethodBeat.m2504i(62366);
        try {
            Drawable c3266d;
            if (C5046bo.isNullOrNil(null)) {
                c3266d = new C3266d(resources, i);
            } else {
                setCacheKey(null);
                c3266d = C12215c.bFN().mo24059b(resources, i);
            }
            if (z) {
                setImageDrawable(c3266d);
                AppMethodBeat.m2505o(62366);
                return;
            }
            setBackgroundDrawable(c3266d);
            AppMethodBeat.m2505o(62366);
        } catch (IOException e) {
            C4990ab.m7412e("MicroMsg.GIF.MMGIFImageView", "setMMGIFResource failed. %s" + e.toString());
            if (z) {
                super.setImageResource(i);
                AppMethodBeat.m2505o(62366);
                return;
            }
            super.setBackgroundResource(i);
            AppMethodBeat.m2505o(62366);
        }
    }

    /* renamed from: a */
    public final void mo46173a(String str, C39243k c39243k) {
        AppMethodBeat.m2504i(62367);
        try {
            C3266d c3266d = new C3266d(str);
            setImageDrawable(c3266d);
            c3266d.noS = BaseClientBuilder.API_PRIORITY_OTHER;
            c3266d.noU = c39243k;
            AppMethodBeat.m2505o(62367);
        } catch (MMGIFException e) {
            try {
                MMAnimateView.m44846a(e);
                if (e.getErrorCode() == 103) {
                    Bitmap decodeStream = C5056d.decodeStream(C5730e.openRead(str));
                    if (decodeStream != null) {
                        decodeStream.setDensity(getEmojiDensity());
                        setImageBitmap(decodeStream);
                        AppMethodBeat.m2505o(62367);
                        return;
                    }
                    C4990ab.m7421w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed bitmap is null. show default and delete file. path:%s", str);
                    init();
                    C5730e.deleteFile(str);
                    AppMethodBeat.m2505o(62367);
                    return;
                }
            } catch (FileNotFoundException e2) {
                C4990ab.m7412e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed. %s" + e2.toString());
            }
            C4990ab.m7412e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed. %s" + e.toString());
            init();
            AppMethodBeat.m2505o(62367);
        } catch (IOException e3) {
            C4990ab.m7412e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed. %s" + e3.toString());
            init();
            AppMethodBeat.m2505o(62367);
        }
    }

    /* renamed from: eF */
    private void m44847eF(String str, String str2) {
        AppMethodBeat.m2504i(62368);
        try {
            if (C5063r.amp(str)) {
                C36775h c36775h = new C36775h(C5730e.m8632e(str, 0, -1));
                c36775h.start();
                setImageDrawable(c36775h);
                AppMethodBeat.m2505o(62368);
                return;
            }
            Drawable c3266d;
            if (C5046bo.isNullOrNil(str2)) {
                c3266d = new C3266d(str);
            } else {
                setCacheKey(str2);
                c3266d = C12215c.bFN().mo24060eD(getCacheKey(), str);
            }
            setImageDrawable(c3266d);
            AppMethodBeat.m2505o(62368);
        } catch (MMGIFException e) {
            try {
                MMAnimateView.m44846a(e);
                if (e.getErrorCode() == 103) {
                    try {
                        Bitmap decodeFile = C5056d.decodeFile(str, null);
                        if (decodeFile != null) {
                            decodeFile.setDensity(getEmojiDensity());
                            setImageBitmap(decodeFile);
                            AppMethodBeat.m2505o(62368);
                            return;
                        }
                        C4990ab.m7421w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failedbitmap is null. show default and delete file. path %s", str);
                        init();
                        C5730e.deleteFile(str);
                        AppMethodBeat.m2505o(62368);
                        return;
                    } catch (OutOfMemoryError e2) {
                        C4990ab.printErrStackTrace("MicroMsg.GIF.MMGIFImageView", e2, "setMMGIFFilePath failed, oom happened. show default. path %s", str);
                        init();
                        AppMethodBeat.m2505o(62368);
                    }
                }
                AppMethodBeat.m2505o(62368);
            } catch (Exception e3) {
                C4990ab.m7413e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed1. %s", C5046bo.m7574l(e3));
                AppMethodBeat.m2505o(62368);
            }
        } catch (IOException e4) {
            C4990ab.m7413e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed3. %s", C5046bo.m7574l(e4));
            C5730e.deleteFile(str);
            init();
            AppMethodBeat.m2505o(62368);
        } catch (NullPointerException e5) {
            init();
            AppMethodBeat.m2505o(62368);
        }
    }

    /* renamed from: f */
    public final void mo46177f(byte[] bArr, String str) {
        AppMethodBeat.m2504i(62369);
        if (bArr == null) {
            try {
                C4990ab.m7413e("MicroMsg.GIF.MMGIFImageView", "[setMMGIFFileByteArray] bytes is null! src:%s cacheKey:%s", Boolean.TRUE, str);
                AppMethodBeat.m2505o(62369);
                return;
            } catch (MMGIFException e) {
                MMAnimateView.m44846a(e);
                if (e.getErrorCode() == 103) {
                    Bitmap bQ = C5056d.m7652bQ(bArr);
                    if (bQ != null) {
                        bQ.setDensity(getEmojiDensity());
                        setImageBitmap(bQ);
                        AppMethodBeat.m2505o(62369);
                        return;
                    }
                    C4990ab.m7421w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileByteArray failed bitmap is null. bytes %s", bArr.toString());
                    init();
                    AppMethodBeat.m2505o(62369);
                    return;
                }
                C4990ab.m7413e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileByteArray failed. %s", e.toString());
            } catch (IOException e2) {
                C4990ab.m7413e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileByteArray failed. %s", e2.toString());
            }
        } else {
            Drawable c36775h;
            if (C5046bo.isNullOrNil(str)) {
                if (C5063r.m7679bU(bArr)) {
                    c36775h = new C36775h(bArr);
                } else {
                    c36775h = new C3266d(bArr);
                }
                c36775h.start();
            } else {
                setCacheKey(str);
                c36775h = C12215c.bFN().mo24061x(getCacheKey(), bArr);
            }
            setImageDrawable(c36775h);
            AppMethodBeat.m2505o(62369);
            return;
        }
        init();
        AppMethodBeat.m2505o(62369);
    }

    public final void init() {
        AppMethodBeat.m2504i(62370);
        this.noz = C1445f.m3070Mn();
        if (this.noz) {
            if (this.nox > 0) {
                super.setImageResource(this.nox);
                AppMethodBeat.m2505o(62370);
                return;
            }
        } else if (this.noy > 0) {
            super.setImageResource(this.noy);
        }
        AppMethodBeat.m2505o(62370);
    }

    public int getIntrinsicWidth() {
        AppMethodBeat.m2504i(62371);
        if (getDrawable() == null) {
            AppMethodBeat.m2505o(62371);
            return 0;
        }
        int intrinsicWidth = getDrawable().getIntrinsicWidth();
        AppMethodBeat.m2505o(62371);
        return intrinsicWidth;
    }

    public int getIntrinsicHeight() {
        AppMethodBeat.m2504i(62372);
        if (getDrawable() == null) {
            AppMethodBeat.m2505o(62372);
            return 0;
        }
        int intrinsicHeight = getDrawable().getIntrinsicHeight();
        AppMethodBeat.m2505o(62372);
        return intrinsicHeight;
    }

    public final void start() {
        AppMethodBeat.m2504i(62373);
        if (getDrawable() != null && (getDrawable() instanceof C34323b)) {
            ((C34323b) getDrawable()).start();
        }
        AppMethodBeat.m2505o(62373);
    }

    public final void pause() {
        AppMethodBeat.m2504i(62374);
        if (getDrawable() != null && (getDrawable() instanceof C34323b)) {
            ((C34323b) getDrawable()).pause();
        }
        AppMethodBeat.m2505o(62374);
    }

    public final void resume() {
        AppMethodBeat.m2504i(62375);
        if (getDrawable() != null && (getDrawable() instanceof C34323b)) {
            ((C34323b) getDrawable()).resume();
        }
        AppMethodBeat.m2505o(62375);
    }

    public final void stop() {
        AppMethodBeat.m2504i(62376);
        if (getDrawable() != null && (getDrawable() instanceof C34323b)) {
            ((C34323b) getDrawable()).stop();
        }
        AppMethodBeat.m2505o(62376);
    }

    public final void reset() {
        AppMethodBeat.m2504i(62377);
        if (getDrawable() != null && (getDrawable() instanceof C34323b)) {
            ((C34323b) getDrawable()).reset();
        }
        AppMethodBeat.m2505o(62377);
    }

    /* renamed from: a */
    public static void m44846a(MMGIFException mMGIFException) {
        AppMethodBeat.m2504i(62378);
        C37736ih c37736ih = new C37736ih();
        c37736ih.cDr.errorCode = mMGIFException.getErrorCode();
        C4879a.xxA.mo10055m(c37736ih);
        AppMethodBeat.m2505o(62378);
    }

    public final void recycle() {
        AppMethodBeat.m2504i(62379);
        if (getDrawable() != null && (getDrawable() instanceof C3266d)) {
            ((C3266d) getDrawable()).recycle();
        }
        AppMethodBeat.m2505o(62379);
    }

    /* renamed from: b */
    public final void mo46175b(InputStream inputStream, String str) {
        Drawable drawable = null;
        AppMethodBeat.m2504i(62363);
        try {
            if (C5046bo.isNullOrNil(str)) {
                drawable = new C3266d(inputStream);
            } else {
                setCacheKey(str);
                C12215c bFN = C12215c.bFN();
                String cacheKey = getCacheKey();
                if (inputStream != null) {
                    C4990ab.m7411d("MicroMsg.GIF.MMAnimateDrawableCacheMgr", "stream key:%s", cacheKey);
                    if (bFN.nov.get(cacheKey) != null) {
                        drawable = (C34323b) ((WeakReference) bFN.nov.get(cacheKey)).get();
                    }
                    if (drawable == null) {
                        drawable = new C3266d(inputStream);
                        bFN.nov.put(cacheKey, new WeakReference(drawable));
                    }
                }
            }
            setImageDrawable(drawable);
            AppMethodBeat.m2505o(62363);
            return;
        } catch (MMGIFException e) {
            MMAnimateView.m44846a(e);
            if (e.getErrorCode() == 103) {
                Bitmap decodeStream = C5056d.decodeStream(inputStream);
                if (decodeStream != null) {
                    decodeStream.setDensity(getEmojiDensity());
                    setImageBitmap(decodeStream);
                    AppMethodBeat.m2505o(62363);
                    return;
                }
                C4990ab.m7420w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileInputStream failedbitmap is null. bytes %s");
                init();
                AppMethodBeat.m2505o(62363);
                return;
            }
            C4990ab.m7413e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileInputStream failed. %s", e.toString());
        } catch (IOException e2) {
            C4990ab.m7413e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileInputStream failed. %s", e2.toString());
        }
        init();
        AppMethodBeat.m2505o(62363);
    }
}
