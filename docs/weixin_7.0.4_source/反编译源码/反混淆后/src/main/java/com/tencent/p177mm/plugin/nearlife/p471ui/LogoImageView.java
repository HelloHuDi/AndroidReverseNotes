package com.tencent.p177mm.plugin.nearlife.p471ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.nearlife.ui.LogoImageView */
public class LogoImageView extends ImageView {
    int eTi;
    int eTj;
    C7306ak handler = new C346201();
    String imagePath;
    String url = null;

    /* renamed from: com.tencent.mm.plugin.nearlife.ui.LogoImageView$1 */
    class C346201 extends C7306ak {
        C346201() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(22968);
            byte[] bArr = (byte[]) message.obj;
            if (bArr == null || bArr.length == 0) {
                C4990ab.m7412e("MicroMsg.LogoImageView", "handleMsg fail, data is null");
                AppMethodBeat.m2505o(22968);
                return;
            }
            Bitmap bitmap;
            Bitmap bQ = C5056d.m7652bQ(bArr);
            C4990ab.m7411d("MicroMsg.LogoImageView", "filePath  %s", LogoImageView.this.imagePath + C1178g.m2591x(LogoImageView.this.url.getBytes()));
            C1173e.m2559b(r2, bArr, bArr.length);
            if (bQ == null || LogoImageView.this.eTi <= 0 || LogoImageView.this.eTj <= 0) {
                bitmap = bQ;
            } else {
                bitmap = C5056d.m7615a(bQ, LogoImageView.this.eTj, LogoImageView.this.eTi, true, false);
            }
            LogoImageView.this.setImageBitmap(bitmap);
            AppMethodBeat.m2505o(22968);
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearlife.ui.LogoImageView$a */
    static class C39462a implements Runnable {
        private C7306ak handler;
        private String url;

        C39462a(String str, C7306ak c7306ak) {
            this.url = str;
            this.handler = c7306ak;
        }

        public final void run() {
            AppMethodBeat.m2504i(22969);
            byte[] ano = C5046bo.ano(this.url);
            Message obtain = Message.obtain();
            obtain.obj = ano;
            this.handler.sendMessage(obtain);
            AppMethodBeat.m2505o(22969);
        }
    }

    public LogoImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(22970);
        AppMethodBeat.m2505o(22970);
    }
}
