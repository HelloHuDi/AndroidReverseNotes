package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;

public class LogoImageView extends ImageView {
    int eTi;
    int eTj;
    ak handler = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(22968);
            byte[] bArr = (byte[]) message.obj;
            if (bArr == null || bArr.length == 0) {
                ab.e("MicroMsg.LogoImageView", "handleMsg fail, data is null");
                AppMethodBeat.o(22968);
                return;
            }
            Bitmap bitmap;
            Bitmap bQ = d.bQ(bArr);
            ab.d("MicroMsg.LogoImageView", "filePath  %s", LogoImageView.this.imagePath + g.x(LogoImageView.this.url.getBytes()));
            e.b(r2, bArr, bArr.length);
            if (bQ == null || LogoImageView.this.eTi <= 0 || LogoImageView.this.eTj <= 0) {
                bitmap = bQ;
            } else {
                bitmap = d.a(bQ, LogoImageView.this.eTj, LogoImageView.this.eTi, true, false);
            }
            LogoImageView.this.setImageBitmap(bitmap);
            AppMethodBeat.o(22968);
        }
    };
    String imagePath;
    String url = null;

    static class a implements Runnable {
        private ak handler;
        private String url;

        a(String str, ak akVar) {
            this.url = str;
            this.handler = akVar;
        }

        public final void run() {
            AppMethodBeat.i(22969);
            byte[] ano = bo.ano(this.url);
            Message obtain = Message.obtain();
            obtain.obj = ano;
            this.handler.sendMessage(obtain);
            AppMethodBeat.o(22969);
        }
    }

    public LogoImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(22970);
        AppMethodBeat.o(22970);
    }
}
