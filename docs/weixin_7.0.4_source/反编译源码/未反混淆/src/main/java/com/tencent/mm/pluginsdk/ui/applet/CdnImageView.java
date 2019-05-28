package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.at.c;
import com.tencent.mm.at.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.MMImageView;

public class CdnImageView extends MMImageView implements com.tencent.mm.ui.e.a {
    private static final String tOJ = (e.eSn + "wallet/images/");
    private int eTi;
    private int eTj;
    private ak handler;
    private String url;
    private String vjW;
    private String vjX;
    private boolean vjY;
    private boolean vjZ;

    static class a implements Runnable {
        private ak handler;
        private String url;

        a(String str, ak akVar) {
            this.url = str;
            this.handler = akVar;
        }

        public final void run() {
            AppMethodBeat.i(79717);
            byte[] ano = bo.ano(this.url);
            Message obtain = Message.obtain();
            Bundle bundle = new Bundle();
            bundle.putByteArray("k_data", ano);
            bundle.putString("k_url", this.url);
            obtain.setData(bundle);
            this.handler.sendMessage(obtain);
            AppMethodBeat.o(79717);
        }
    }

    static {
        AppMethodBeat.i(79730);
        AppMethodBeat.o(79730);
    }

    public CdnImageView(Context context) {
        this(context, null);
    }

    public CdnImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CdnImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(79718);
        this.url = null;
        this.vjZ = false;
        this.handler = new ak() {
            public final void handleMessage(Message message) {
                AppMethodBeat.i(79716);
                String bc = bo.bc(message.getData().getString("k_url"), "");
                CdnImageView.this.url = bo.bc(CdnImageView.this.url, "");
                if (bo.isNullOrNil(CdnImageView.this.url) && bo.isNullOrNil(bc)) {
                    CdnImageView.this.setImageBitmap(null);
                    CdnImageView.this.setImageBitmapCompleted(null);
                    AppMethodBeat.o(79716);
                } else if (CdnImageView.this.url.equals(bc)) {
                    byte[] byteArray = message.getData().getByteArray("k_data");
                    if (byteArray == null || byteArray.length == 0) {
                        ab.e("MicroMsg.CdnImageView", "handleMsg fail, data is null");
                        AppMethodBeat.o(79716);
                        return;
                    }
                    Bitmap bQ = d.bQ(byteArray);
                    o.ahk();
                    c.h(CdnImageView.this.url, bQ);
                    if (CdnImageView.this.vjZ) {
                        CdnImageView.a(CdnImageView.this, bQ);
                    }
                    if (bQ != null && CdnImageView.this.eTi > 0 && CdnImageView.this.eTj > 0) {
                        bQ = d.a(bQ, CdnImageView.this.eTj, CdnImageView.this.eTi, true, false);
                    }
                    if (CdnImageView.this.vjY && bQ != null) {
                        bQ = d.a(bQ, false, ((float) bQ.getWidth()) * 0.5f);
                    }
                    if (bQ != null) {
                        CdnImageView.this.setImageBitmap(bQ);
                    }
                    CdnImageView.this.setImageBitmapCompleted(bQ);
                    AppMethodBeat.o(79716);
                } else {
                    ab.d("MicroMsg.CdnImageView", "hy: url not equal. abort this msg");
                    AppMethodBeat.o(79716);
                }
            }
        };
        AppMethodBeat.o(79718);
    }

    public void setImageBitmapCompleted(Bitmap bitmap) {
    }

    public void setUseSdcardCache(boolean z) {
        this.vjZ = z;
    }

    public void setImgSavedPath(String str) {
        this.vjW = str;
    }

    public void setImgSavedDir(String str) {
        this.vjX = str;
    }

    public void setUrl(String str) {
        AppMethodBeat.i(79719);
        n(str, 0, 0, -1);
        AppMethodBeat.o(79719);
    }

    public final void eb(String str, int i) {
        AppMethodBeat.i(79720);
        n(str, 0, 0, i);
        AppMethodBeat.o(79720);
    }

    public final void am(String str, int i, int i2) {
        AppMethodBeat.i(79721);
        n(str, i, i2, -1);
        AppMethodBeat.o(79721);
    }

    public final void hI(String str, String str2) {
        AppMethodBeat.i(79722);
        a(str, -1, 0, 0, str2);
        AppMethodBeat.o(79722);
    }

    public final void n(String str, int i, int i2, int i3) {
        AppMethodBeat.i(79723);
        a(str, i, i2, i3, null);
        AppMethodBeat.o(79723);
    }

    private void a(String str, int i, int i2, int i3, String str2) {
        AppMethodBeat.i(79724);
        this.url = str;
        this.eTi = i;
        this.eTj = i2;
        this.vjW = str2;
        if (!bo.isNullOrNil(this.vjW)) {
            Bitmap aml = d.aml(this.vjW);
            if (aml != null && aml.getWidth() > 0 && aml.getHeight() > 0) {
                setImageBitmap(aml);
                setImageBitmapCompleted(aml);
                AppMethodBeat.o(79724);
                return;
            }
        }
        if (str == null || str.length() == 0) {
            setVisibility(8);
            AppMethodBeat.o(79724);
        } else if (str.startsWith("http")) {
            ec(str, i3);
            AppMethodBeat.o(79724);
        } else {
            ajB(str);
            AppMethodBeat.o(79724);
        }
    }

    private String getCacheFilePath() {
        String str;
        AppMethodBeat.i(79725);
        if (!bo.isNullOrNil(this.vjW)) {
            str = this.vjW;
        } else if (bo.isNullOrNil(this.vjX)) {
            com.tencent.mm.vfs.e.tf(tOJ);
            str = tOJ + g.x(this.url.getBytes());
        } else {
            str = this.vjX + g.x(this.url.getBytes());
        }
        AppMethodBeat.o(79725);
        return str;
    }

    public void setRoundCorner(boolean z) {
        this.vjY = z;
    }

    private void ajB(String str) {
        AppMethodBeat.i(79726);
        if (com.tencent.mm.vfs.e.ct(str)) {
            Bitmap aml;
            if (this.eTi <= 0 || this.eTj <= 0) {
                aml = d.aml(str);
            } else {
                aml = d.d(str, this.eTi, this.eTj, true);
            }
            if (aml == null) {
                setVisibility(8);
                AppMethodBeat.o(79726);
                return;
            }
            if (this.vjY && aml != null) {
                aml = d.a(aml, false, ((float) aml.getWidth()) * 0.5f);
            }
            setImageBitmap(aml);
            setImageBitmapCompleted(aml);
            AppMethodBeat.o(79726);
            return;
        }
        setVisibility(8);
        AppMethodBeat.o(79726);
    }

    private boolean dju() {
        AppMethodBeat.i(79727);
        try {
            String cacheFilePath = getCacheFilePath();
            ab.d("MicroMsg.CdnImageView", "useSdcardCache, path: %s", cacheFilePath);
            if (com.tencent.mm.vfs.e.ct(cacheFilePath)) {
                Bitmap aml = d.aml(cacheFilePath);
                ab.d("MicroMsg.CdnImageView", "get bitmap from cache path: %s", aml);
                if (aml != null) {
                    if (this.eTi > 0 && this.eTj > 0) {
                        aml = d.a(aml, this.eTj, this.eTi, true, false);
                    }
                    if (this.vjY && aml != null) {
                        aml = d.a(aml, false, ((float) aml.getWidth()) * 0.5f);
                    }
                    setImageBitmap(aml);
                    setImageBitmapCompleted(aml);
                    AppMethodBeat.o(79727);
                    return true;
                }
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.CdnImageView", e, "setBitmapFromLocalCache error: %s", e.getMessage());
        }
        AppMethodBeat.o(79727);
        return false;
    }

    private void ec(String str, int i) {
        AppMethodBeat.i(79728);
        o.ahk();
        Bitmap kR = c.kR(str);
        if (kR != null) {
            if (this.eTi > 0 && this.eTj > 0) {
                kR = d.a(kR, this.eTi, this.eTj, true, false);
            }
            if (this.vjY && kR != null) {
                kR = d.a(kR, false, ((float) kR.getWidth()) * 0.5f);
            }
            setImageBitmap(kR);
            setImageBitmapCompleted(kR);
            AppMethodBeat.o(79728);
        } else if (this.vjZ && dju()) {
            AppMethodBeat.o(79728);
        } else {
            if (i > 0) {
                setImageResource(i);
            } else {
                setImageBitmap(null);
            }
            com.tencent.mm.sdk.g.d.post(new a(str, this.handler), "CdnImageView_download");
            AppMethodBeat.o(79728);
        }
    }
}
