package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.vfs.e;

public class SimpleImageView extends ImageView {
    public int eTi;
    public int eTj;
    public ak handler = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(113527);
            byte[] bArr = (byte[]) message.obj;
            if (bArr == null || bArr.length == 0) {
                ab.e("MicroMsg.SimpleImageView", "handleMsg fail, data is null");
                AppMethodBeat.o(113527);
                return;
            }
            Bitmap bitmap;
            Bitmap bQ = d.bQ(bArr);
            ab.d("MicroMsg.SimpleImageView", "filePath  %s", SimpleImageView.this.imagePath + g.x(SimpleImageView.this.url.getBytes()));
            e.b(r2, bArr, bArr.length);
            if (bQ == null || SimpleImageView.this.eTi <= 0 || SimpleImageView.this.eTj <= 0) {
                bitmap = bQ;
            } else {
                bitmap = d.a(bQ, SimpleImageView.this.eTj, SimpleImageView.this.eTi, true, false);
            }
            SimpleImageView.this.setImageBitmap(bitmap);
            AppMethodBeat.o(113527);
        }
    };
    public String imagePath;
    public String url = null;

    public static class a implements Runnable {
        private ak handler;
        private String url;

        public a(String str, ak akVar) {
            this.url = str;
            this.handler = akVar;
        }

        public final void run() {
            AppMethodBeat.i(113528);
            byte[] ano = bo.ano(this.url);
            Message obtain = Message.obtain();
            obtain.obj = ano;
            this.handler.sendMessage(obtain);
            AppMethodBeat.o(113528);
        }
    }

    public SimpleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(113529);
        AppMethodBeat.o(113529);
    }
}
