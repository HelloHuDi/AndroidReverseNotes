package com.tencent.p177mm.plugin.location.p446ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.plugin.location.ui.SimpleImageView */
public class SimpleImageView extends ImageView {
    public int eTi;
    public int eTj;
    public C7306ak handler = new C283711();
    public String imagePath;
    public String url = null;

    /* renamed from: com.tencent.mm.plugin.location.ui.SimpleImageView$1 */
    class C283711 extends C7306ak {
        C283711() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(113527);
            byte[] bArr = (byte[]) message.obj;
            if (bArr == null || bArr.length == 0) {
                C4990ab.m7412e("MicroMsg.SimpleImageView", "handleMsg fail, data is null");
                AppMethodBeat.m2505o(113527);
                return;
            }
            Bitmap bitmap;
            Bitmap bQ = C5056d.m7652bQ(bArr);
            C4990ab.m7411d("MicroMsg.SimpleImageView", "filePath  %s", SimpleImageView.this.imagePath + C1178g.m2591x(SimpleImageView.this.url.getBytes()));
            C5730e.m8624b(r2, bArr, bArr.length);
            if (bQ == null || SimpleImageView.this.eTi <= 0 || SimpleImageView.this.eTj <= 0) {
                bitmap = bQ;
            } else {
                bitmap = C5056d.m7615a(bQ, SimpleImageView.this.eTj, SimpleImageView.this.eTi, true, false);
            }
            SimpleImageView.this.setImageBitmap(bitmap);
            AppMethodBeat.m2505o(113527);
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.SimpleImageView$a */
    public static class C34410a implements Runnable {
        private C7306ak handler;
        private String url;

        public C34410a(String str, C7306ak c7306ak) {
            this.url = str;
            this.handler = c7306ak;
        }

        public final void run() {
            AppMethodBeat.m2504i(113528);
            byte[] ano = C5046bo.ano(this.url);
            Message obtain = Message.obtain();
            obtain.obj = ano;
            this.handler.sendMessage(obtain);
            AppMethodBeat.m2505o(113528);
        }
    }

    public SimpleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(113529);
        AppMethodBeat.m2505o(113529);
    }
}
