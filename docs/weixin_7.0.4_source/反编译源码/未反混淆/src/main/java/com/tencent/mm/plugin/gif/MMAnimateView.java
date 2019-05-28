package com.tencent.mm.plugin.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageView;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.a.ih;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.vfs.e;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

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
        AppMethodBeat.i(62358);
        this.nox = R.drawable.emoji_download_icon;
        this.noy = R.drawable.hj;
        this.noz = true;
        this.mDensity = 0.0f;
        if (d.iW(26)) {
            setLayerType(1, null);
        }
        AppMethodBeat.o(62358);
    }

    public void setImageResource(int i) {
        AppMethodBeat.i(62359);
        a(getResources(), i, true);
        AppMethodBeat.o(62359);
    }

    public void setBackgroundResource(int i) {
        AppMethodBeat.i(62360);
        a(getResources(), i, false);
        AppMethodBeat.o(62360);
    }

    public void setImageFilePath(String str) {
        AppMethodBeat.i(62361);
        eF(str, null);
        AppMethodBeat.o(62361);
    }

    public final void eE(String str, String str2) {
        AppMethodBeat.i(62362);
        eF(str, str2);
        AppMethodBeat.o(62362);
    }

    public void setDefaultImageResource(int i) {
        this.nox = i;
    }

    public void setDefaultBackgroundResource(int i) {
        this.nox = i;
    }

    public float getEmojiDensityScale() {
        AppMethodBeat.i(62364);
        if (this.mDensity == 0.0f) {
            this.mDensity = a.getDensity(ah.getContext()) / 2.0f;
            if (this.mDensity < 1.0f) {
                this.mDensity = 1.0f;
            } else if (this.mDensity > 2.0f) {
                this.mDensity = 2.0f;
            }
        }
        float f = this.mDensity;
        AppMethodBeat.o(62364);
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

    public final void a(boolean z, boolean z2, int i, int[] iArr, String str, String str2) {
        AppMethodBeat.i(62365);
        e eVar;
        if (bo.isNullOrNil(str2)) {
            eVar = new e(getContext(), z, z2, i, iArr, str);
            eVar.start();
            setImageDrawable(eVar);
            AppMethodBeat.o(62365);
            return;
        }
        setCacheKey(str2);
        c bFN = c.bFN();
        Context context = getContext();
        if (TextUtils.isEmpty(str)) {
            eVar = null;
        } else {
            if (bFN.nou.get(str2) == null || ((WeakReference) bFN.nou.get(str2)).get() == null) {
                eVar = null;
            } else {
                eVar = (e) ((WeakReference) bFN.nou.get(str2)).get();
            }
            if (eVar == null) {
                eVar = new e(context, z, z2, i, iArr, str);
                bFN.nou.put(str2, new WeakReference(eVar));
            }
        }
        if (eVar != null) {
            eVar.npj = z2;
            if (z == eVar.mIsPlaying) {
                eVar.start();
            } else {
                eVar.lfO = 0;
                eVar.npl = 0;
                eVar.mIsPlaying = true;
                eVar.start();
            }
            setImageDrawable(eVar);
            AppMethodBeat.o(62365);
            return;
        }
        ab.e("MicroMsg.GIF.MMGIFImageView", "can not get drawable.");
        AppMethodBeat.o(62365);
    }

    private void a(Resources resources, int i, boolean z) {
        AppMethodBeat.i(62366);
        try {
            Drawable dVar;
            if (bo.isNullOrNil(null)) {
                dVar = new d(resources, i);
            } else {
                setCacheKey(null);
                dVar = c.bFN().b(resources, i);
            }
            if (z) {
                setImageDrawable(dVar);
                AppMethodBeat.o(62366);
                return;
            }
            setBackgroundDrawable(dVar);
            AppMethodBeat.o(62366);
        } catch (IOException e) {
            ab.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFResource failed. %s" + e.toString());
            if (z) {
                super.setImageResource(i);
                AppMethodBeat.o(62366);
                return;
            }
            super.setBackgroundResource(i);
            AppMethodBeat.o(62366);
        }
    }

    public final void a(String str, k kVar) {
        AppMethodBeat.i(62367);
        try {
            d dVar = new d(str);
            setImageDrawable(dVar);
            dVar.noS = BaseClientBuilder.API_PRIORITY_OTHER;
            dVar.noU = kVar;
            AppMethodBeat.o(62367);
        } catch (MMGIFException e) {
            try {
                a(e);
                if (e.getErrorCode() == 103) {
                    Bitmap decodeStream = com.tencent.mm.sdk.platformtools.d.decodeStream(e.openRead(str));
                    if (decodeStream != null) {
                        decodeStream.setDensity(getEmojiDensity());
                        setImageBitmap(decodeStream);
                        AppMethodBeat.o(62367);
                        return;
                    }
                    ab.w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed bitmap is null. show default and delete file. path:%s", str);
                    init();
                    e.deleteFile(str);
                    AppMethodBeat.o(62367);
                    return;
                }
            } catch (FileNotFoundException e2) {
                ab.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed. %s" + e2.toString());
            }
            ab.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed. %s" + e.toString());
            init();
            AppMethodBeat.o(62367);
        } catch (IOException e3) {
            ab.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed. %s" + e3.toString());
            init();
            AppMethodBeat.o(62367);
        }
    }

    private void eF(String str, String str2) {
        AppMethodBeat.i(62368);
        try {
            if (r.amp(str)) {
                h hVar = new h(e.e(str, 0, -1));
                hVar.start();
                setImageDrawable(hVar);
                AppMethodBeat.o(62368);
                return;
            }
            Drawable dVar;
            if (bo.isNullOrNil(str2)) {
                dVar = new d(str);
            } else {
                setCacheKey(str2);
                dVar = c.bFN().eD(getCacheKey(), str);
            }
            setImageDrawable(dVar);
            AppMethodBeat.o(62368);
        } catch (MMGIFException e) {
            try {
                a(e);
                if (e.getErrorCode() == 103) {
                    try {
                        Bitmap decodeFile = com.tencent.mm.sdk.platformtools.d.decodeFile(str, null);
                        if (decodeFile != null) {
                            decodeFile.setDensity(getEmojiDensity());
                            setImageBitmap(decodeFile);
                            AppMethodBeat.o(62368);
                            return;
                        }
                        ab.w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failedbitmap is null. show default and delete file. path %s", str);
                        init();
                        e.deleteFile(str);
                        AppMethodBeat.o(62368);
                        return;
                    } catch (OutOfMemoryError e2) {
                        ab.printErrStackTrace("MicroMsg.GIF.MMGIFImageView", e2, "setMMGIFFilePath failed, oom happened. show default. path %s", str);
                        init();
                        AppMethodBeat.o(62368);
                    }
                }
                AppMethodBeat.o(62368);
            } catch (Exception e3) {
                ab.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed1. %s", bo.l(e3));
                AppMethodBeat.o(62368);
            }
        } catch (IOException e4) {
            ab.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed3. %s", bo.l(e4));
            e.deleteFile(str);
            init();
            AppMethodBeat.o(62368);
        } catch (NullPointerException e5) {
            init();
            AppMethodBeat.o(62368);
        }
    }

    public final void f(byte[] bArr, String str) {
        AppMethodBeat.i(62369);
        if (bArr == null) {
            try {
                ab.e("MicroMsg.GIF.MMGIFImageView", "[setMMGIFFileByteArray] bytes is null! src:%s cacheKey:%s", Boolean.TRUE, str);
                AppMethodBeat.o(62369);
                return;
            } catch (MMGIFException e) {
                a(e);
                if (e.getErrorCode() == 103) {
                    Bitmap bQ = com.tencent.mm.sdk.platformtools.d.bQ(bArr);
                    if (bQ != null) {
                        bQ.setDensity(getEmojiDensity());
                        setImageBitmap(bQ);
                        AppMethodBeat.o(62369);
                        return;
                    }
                    ab.w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileByteArray failed bitmap is null. bytes %s", bArr.toString());
                    init();
                    AppMethodBeat.o(62369);
                    return;
                }
                ab.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileByteArray failed. %s", e.toString());
            } catch (IOException e2) {
                ab.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileByteArray failed. %s", e2.toString());
            }
        } else {
            Drawable hVar;
            if (bo.isNullOrNil(str)) {
                if (r.bU(bArr)) {
                    hVar = new h(bArr);
                } else {
                    hVar = new d(bArr);
                }
                hVar.start();
            } else {
                setCacheKey(str);
                hVar = c.bFN().x(getCacheKey(), bArr);
            }
            setImageDrawable(hVar);
            AppMethodBeat.o(62369);
            return;
        }
        init();
        AppMethodBeat.o(62369);
    }

    public final void init() {
        AppMethodBeat.i(62370);
        this.noz = f.Mn();
        if (this.noz) {
            if (this.nox > 0) {
                super.setImageResource(this.nox);
                AppMethodBeat.o(62370);
                return;
            }
        } else if (this.noy > 0) {
            super.setImageResource(this.noy);
        }
        AppMethodBeat.o(62370);
    }

    public int getIntrinsicWidth() {
        AppMethodBeat.i(62371);
        if (getDrawable() == null) {
            AppMethodBeat.o(62371);
            return 0;
        }
        int intrinsicWidth = getDrawable().getIntrinsicWidth();
        AppMethodBeat.o(62371);
        return intrinsicWidth;
    }

    public int getIntrinsicHeight() {
        AppMethodBeat.i(62372);
        if (getDrawable() == null) {
            AppMethodBeat.o(62372);
            return 0;
        }
        int intrinsicHeight = getDrawable().getIntrinsicHeight();
        AppMethodBeat.o(62372);
        return intrinsicHeight;
    }

    public final void start() {
        AppMethodBeat.i(62373);
        if (getDrawable() != null && (getDrawable() instanceof b)) {
            ((b) getDrawable()).start();
        }
        AppMethodBeat.o(62373);
    }

    public final void pause() {
        AppMethodBeat.i(62374);
        if (getDrawable() != null && (getDrawable() instanceof b)) {
            ((b) getDrawable()).pause();
        }
        AppMethodBeat.o(62374);
    }

    public final void resume() {
        AppMethodBeat.i(62375);
        if (getDrawable() != null && (getDrawable() instanceof b)) {
            ((b) getDrawable()).resume();
        }
        AppMethodBeat.o(62375);
    }

    public final void stop() {
        AppMethodBeat.i(62376);
        if (getDrawable() != null && (getDrawable() instanceof b)) {
            ((b) getDrawable()).stop();
        }
        AppMethodBeat.o(62376);
    }

    public final void reset() {
        AppMethodBeat.i(62377);
        if (getDrawable() != null && (getDrawable() instanceof b)) {
            ((b) getDrawable()).reset();
        }
        AppMethodBeat.o(62377);
    }

    public static void a(MMGIFException mMGIFException) {
        AppMethodBeat.i(62378);
        ih ihVar = new ih();
        ihVar.cDr.errorCode = mMGIFException.getErrorCode();
        com.tencent.mm.sdk.b.a.xxA.m(ihVar);
        AppMethodBeat.o(62378);
    }

    public final void recycle() {
        AppMethodBeat.i(62379);
        if (getDrawable() != null && (getDrawable() instanceof d)) {
            ((d) getDrawable()).recycle();
        }
        AppMethodBeat.o(62379);
    }

    public final void b(InputStream inputStream, String str) {
        Drawable drawable = null;
        AppMethodBeat.i(62363);
        try {
            if (bo.isNullOrNil(str)) {
                drawable = new d(inputStream);
            } else {
                setCacheKey(str);
                c bFN = c.bFN();
                String cacheKey = getCacheKey();
                if (inputStream != null) {
                    ab.d("MicroMsg.GIF.MMAnimateDrawableCacheMgr", "stream key:%s", cacheKey);
                    if (bFN.nov.get(cacheKey) != null) {
                        drawable = (b) ((WeakReference) bFN.nov.get(cacheKey)).get();
                    }
                    if (drawable == null) {
                        drawable = new d(inputStream);
                        bFN.nov.put(cacheKey, new WeakReference(drawable));
                    }
                }
            }
            setImageDrawable(drawable);
            AppMethodBeat.o(62363);
            return;
        } catch (MMGIFException e) {
            a(e);
            if (e.getErrorCode() == 103) {
                Bitmap decodeStream = com.tencent.mm.sdk.platformtools.d.decodeStream(inputStream);
                if (decodeStream != null) {
                    decodeStream.setDensity(getEmojiDensity());
                    setImageBitmap(decodeStream);
                    AppMethodBeat.o(62363);
                    return;
                }
                ab.w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileInputStream failedbitmap is null. bytes %s");
                init();
                AppMethodBeat.o(62363);
                return;
            }
            ab.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileInputStream failed. %s", e.toString());
        } catch (IOException e2) {
            ab.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileInputStream failed. %s", e2.toString());
        }
        init();
        AppMethodBeat.o(62363);
    }
}
