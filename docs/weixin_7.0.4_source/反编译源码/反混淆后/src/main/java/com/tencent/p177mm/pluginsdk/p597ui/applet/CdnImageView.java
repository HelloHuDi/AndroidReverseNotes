package com.tencent.p177mm.pluginsdk.p597ui.applet;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p190at.C17937c;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p612ui.MMImageView;
import com.tencent.p177mm.p612ui.p627e.C5507a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.pluginsdk.ui.applet.CdnImageView */
public class CdnImageView extends MMImageView implements C5507a {
    private static final String tOJ = (C6457e.eSn + "wallet/images/");
    private int eTi;
    private int eTj;
    private C7306ak handler;
    private String url;
    private String vjW;
    private String vjX;
    private boolean vjY;
    private boolean vjZ;

    /* renamed from: com.tencent.mm.pluginsdk.ui.applet.CdnImageView$1 */
    class C232671 extends C7306ak {
        C232671() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(79716);
            String bc = C5046bo.m7532bc(message.getData().getString("k_url"), "");
            CdnImageView.this.url = C5046bo.m7532bc(CdnImageView.this.url, "");
            if (C5046bo.isNullOrNil(CdnImageView.this.url) && C5046bo.isNullOrNil(bc)) {
                CdnImageView.this.setImageBitmap(null);
                CdnImageView.this.setImageBitmapCompleted(null);
                AppMethodBeat.m2505o(79716);
            } else if (CdnImageView.this.url.equals(bc)) {
                byte[] byteArray = message.getData().getByteArray("k_data");
                if (byteArray == null || byteArray.length == 0) {
                    C4990ab.m7412e("MicroMsg.CdnImageView", "handleMsg fail, data is null");
                    AppMethodBeat.m2505o(79716);
                    return;
                }
                Bitmap bQ = C5056d.m7652bQ(byteArray);
                C32291o.ahk();
                C17937c.m28185h(CdnImageView.this.url, bQ);
                if (CdnImageView.this.vjZ) {
                    CdnImageView.m35750a(CdnImageView.this, bQ);
                }
                if (bQ != null && CdnImageView.this.eTi > 0 && CdnImageView.this.eTj > 0) {
                    bQ = C5056d.m7615a(bQ, CdnImageView.this.eTj, CdnImageView.this.eTi, true, false);
                }
                if (CdnImageView.this.vjY && bQ != null) {
                    bQ = C5056d.m7616a(bQ, false, ((float) bQ.getWidth()) * 0.5f);
                }
                if (bQ != null) {
                    CdnImageView.this.setImageBitmap(bQ);
                }
                CdnImageView.this.setImageBitmapCompleted(bQ);
                AppMethodBeat.m2505o(79716);
            } else {
                C4990ab.m7410d("MicroMsg.CdnImageView", "hy: url not equal. abort this msg");
                AppMethodBeat.m2505o(79716);
            }
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.applet.CdnImageView$a */
    static class C23268a implements Runnable {
        private C7306ak handler;
        private String url;

        C23268a(String str, C7306ak c7306ak) {
            this.url = str;
            this.handler = c7306ak;
        }

        public final void run() {
            AppMethodBeat.m2504i(79717);
            byte[] ano = C5046bo.ano(this.url);
            Message obtain = Message.obtain();
            Bundle bundle = new Bundle();
            bundle.putByteArray("k_data", ano);
            bundle.putString("k_url", this.url);
            obtain.setData(bundle);
            this.handler.sendMessage(obtain);
            AppMethodBeat.m2505o(79717);
        }
    }

    static {
        AppMethodBeat.m2504i(79730);
        AppMethodBeat.m2505o(79730);
    }

    public CdnImageView(Context context) {
        this(context, null);
    }

    public CdnImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CdnImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(79718);
        this.url = null;
        this.vjZ = false;
        this.handler = new C232671();
        AppMethodBeat.m2505o(79718);
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
        AppMethodBeat.m2504i(79719);
        mo38954n(str, 0, 0, -1);
        AppMethodBeat.m2505o(79719);
    }

    /* renamed from: eb */
    public final void mo38952eb(String str, int i) {
        AppMethodBeat.m2504i(79720);
        mo38954n(str, 0, 0, i);
        AppMethodBeat.m2505o(79720);
    }

    /* renamed from: am */
    public final void mo11120am(String str, int i, int i2) {
        AppMethodBeat.m2504i(79721);
        mo38954n(str, i, i2, -1);
        AppMethodBeat.m2505o(79721);
    }

    /* renamed from: hI */
    public final void mo38953hI(String str, String str2) {
        AppMethodBeat.m2504i(79722);
        m35751a(str, -1, 0, 0, str2);
        AppMethodBeat.m2505o(79722);
    }

    /* renamed from: n */
    public final void mo38954n(String str, int i, int i2, int i3) {
        AppMethodBeat.m2504i(79723);
        m35751a(str, i, i2, i3, null);
        AppMethodBeat.m2505o(79723);
    }

    /* renamed from: a */
    private void m35751a(String str, int i, int i2, int i3, String str2) {
        AppMethodBeat.m2504i(79724);
        this.url = str;
        this.eTi = i;
        this.eTj = i2;
        this.vjW = str2;
        if (!C5046bo.isNullOrNil(this.vjW)) {
            Bitmap aml = C5056d.aml(this.vjW);
            if (aml != null && aml.getWidth() > 0 && aml.getHeight() > 0) {
                setImageBitmap(aml);
                setImageBitmapCompleted(aml);
                AppMethodBeat.m2505o(79724);
                return;
            }
        }
        if (str == null || str.length() == 0) {
            setVisibility(8);
            AppMethodBeat.m2505o(79724);
        } else if (str.startsWith("http")) {
            m35756ec(str, i3);
            AppMethodBeat.m2505o(79724);
        } else {
            ajB(str);
            AppMethodBeat.m2505o(79724);
        }
    }

    private String getCacheFilePath() {
        String str;
        AppMethodBeat.m2504i(79725);
        if (!C5046bo.isNullOrNil(this.vjW)) {
            str = this.vjW;
        } else if (C5046bo.isNullOrNil(this.vjX)) {
            C5730e.m8643tf(tOJ);
            str = tOJ + C1178g.m2591x(this.url.getBytes());
        } else {
            str = this.vjX + C1178g.m2591x(this.url.getBytes());
        }
        AppMethodBeat.m2505o(79725);
        return str;
    }

    public void setRoundCorner(boolean z) {
        this.vjY = z;
    }

    private void ajB(String str) {
        AppMethodBeat.m2504i(79726);
        if (C5730e.m8628ct(str)) {
            Bitmap aml;
            if (this.eTi <= 0 || this.eTj <= 0) {
                aml = C5056d.aml(str);
            } else {
                aml = C5056d.m7659d(str, this.eTi, this.eTj, true);
            }
            if (aml == null) {
                setVisibility(8);
                AppMethodBeat.m2505o(79726);
                return;
            }
            if (this.vjY && aml != null) {
                aml = C5056d.m7616a(aml, false, ((float) aml.getWidth()) * 0.5f);
            }
            setImageBitmap(aml);
            setImageBitmapCompleted(aml);
            AppMethodBeat.m2505o(79726);
            return;
        }
        setVisibility(8);
        AppMethodBeat.m2505o(79726);
    }

    private boolean dju() {
        AppMethodBeat.m2504i(79727);
        try {
            String cacheFilePath = getCacheFilePath();
            C4990ab.m7411d("MicroMsg.CdnImageView", "useSdcardCache, path: %s", cacheFilePath);
            if (C5730e.m8628ct(cacheFilePath)) {
                Bitmap aml = C5056d.aml(cacheFilePath);
                C4990ab.m7411d("MicroMsg.CdnImageView", "get bitmap from cache path: %s", aml);
                if (aml != null) {
                    if (this.eTi > 0 && this.eTj > 0) {
                        aml = C5056d.m7615a(aml, this.eTj, this.eTi, true, false);
                    }
                    if (this.vjY && aml != null) {
                        aml = C5056d.m7616a(aml, false, ((float) aml.getWidth()) * 0.5f);
                    }
                    setImageBitmap(aml);
                    setImageBitmapCompleted(aml);
                    AppMethodBeat.m2505o(79727);
                    return true;
                }
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.CdnImageView", e, "setBitmapFromLocalCache error: %s", e.getMessage());
        }
        AppMethodBeat.m2505o(79727);
        return false;
    }

    /* renamed from: ec */
    private void m35756ec(String str, int i) {
        AppMethodBeat.m2504i(79728);
        C32291o.ahk();
        Bitmap kR = C17937c.m28186kR(str);
        if (kR != null) {
            if (this.eTi > 0 && this.eTj > 0) {
                kR = C5056d.m7615a(kR, this.eTi, this.eTj, true, false);
            }
            if (this.vjY && kR != null) {
                kR = C5056d.m7616a(kR, false, ((float) kR.getWidth()) * 0.5f);
            }
            setImageBitmap(kR);
            setImageBitmapCompleted(kR);
            AppMethodBeat.m2505o(79728);
        } else if (this.vjZ && dju()) {
            AppMethodBeat.m2505o(79728);
        } else {
            if (i > 0) {
                setImageResource(i);
            } else {
                setImageBitmap(null);
            }
            C7305d.post(new C23268a(str, this.handler), "CdnImageView_download");
            AppMethodBeat.m2505o(79728);
        }
    }
}
