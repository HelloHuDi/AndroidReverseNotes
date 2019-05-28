package com.tencent.p177mm.emoji.decode;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Process;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.hardcoder.WXHardCoderJNI;
import com.tencent.p177mm.plugin.gif.MMGIFJNI;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.InputStream;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0018\u001a\u00020\u0011H\u0016J\b\u0010\u0019\u001a\u00020\u0011H\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0016J\b\u0010\u001b\u001a\u00020\rH\u0016R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, dWq = {"Lcom/tencent/mm/emoji/decode/MMGIFDecoder;", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "bytes", "", "([B)V", "stream", "Ljava/io/InputStream;", "(Ljava/io/InputStream;)V", "TAG", "", "gifPointer", "", "lastValidFrame", "Landroid/graphics/Bitmap;", "metadata", "", "startPerformance", "", "decodeNextFrame", "", "destroy", "drawFrameBitmap", "", "bitmap", "frameHeight", "frameTime", "frameWidth", "getFrame", "plugin-emojisdk_release"})
/* renamed from: com.tencent.mm.emoji.decode.d */
public final class C41951d implements C26076b {
    private final String TAG;
    private int ehv;
    private Bitmap exl;
    private long exm;
    private final int[] exn;

    public C41951d(byte[] bArr) {
        C25052j.m39376p(bArr, "bytes");
        AppMethodBeat.m2504i(63143);
        this.TAG = "MicroMsg.GIF.MMGIFDecoder";
        this.exn = new int[6];
        this.ehv = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcGifEnable, WXHardCoderJNI.hcGifDelay, WXHardCoderJNI.hcGifCPU, WXHardCoderJNI.hcGifIO, WXHardCoderJNI.hcGifThr ? Process.myTid() : 0, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, this.TAG);
        this.exm = MMGIFJNI.openByByteArray(bArr, this.exn);
        if (this.exn[0] > 1024 || this.exn[1] > 1024) {
            C4990ab.m7421w(this.TAG, "emoji width or height over size. Width:%d Height:%d", Integer.valueOf(this.exn[0]), Integer.valueOf(this.exn[1]));
            C7060h.pYm.mo8378a(401, 2, 1, false);
        }
        Bitmap createBitmap = Bitmap.createBitmap(this.exn[0], this.exn[1], Config.ARGB_8888);
        C25052j.m39375o(createBitmap, "Bitmap.createBitmap(fram… Bitmap.Config.ARGB_8888)");
        this.exl = createBitmap;
        AppMethodBeat.m2505o(63143);
    }

    public C41951d(InputStream inputStream) {
        int myTid;
        C25052j.m39376p(inputStream, "stream");
        AppMethodBeat.m2504i(63144);
        this.TAG = "MicroMsg.GIF.MMGIFDecoder";
        this.exn = new int[6];
        boolean z = WXHardCoderJNI.hcGifEnable;
        int i = WXHardCoderJNI.hcGifDelay;
        int i2 = WXHardCoderJNI.hcGifCPU;
        int i3 = WXHardCoderJNI.hcGifIO;
        if (WXHardCoderJNI.hcGifThr) {
            myTid = Process.myTid();
        } else {
            myTid = 0;
        }
        this.ehv = WXHardCoderJNI.startPerformance(z, i, i2, i3, myTid, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, this.TAG);
        this.exm = MMGIFJNI.openByInputStrem(inputStream, this.exn);
        if (this.exn[0] > 1024 || this.exn[1] > 1024) {
            C4990ab.m7421w(this.TAG, "emoji width or height over size. Width:%d Height:%d", Integer.valueOf(this.exn[0]), Integer.valueOf(this.exn[1]));
            C7060h.pYm.mo8378a(401, 2, 1, false);
        }
        Bitmap createBitmap = Bitmap.createBitmap(this.exn[0], this.exn[1], Config.ARGB_8888);
        C25052j.m39375o(createBitmap, "Bitmap.createBitmap(fram… Bitmap.Config.ARGB_8888)");
        this.exl = createBitmap;
        AppMethodBeat.m2505o(63144);
    }

    /* renamed from: Or */
    public final void mo33669Or() {
        AppMethodBeat.m2504i(63141);
        MMGIFJNI.drawFrameBitmap(this.exm, this.exl, this.exn);
        AppMethodBeat.m2505o(63141);
    }

    /* renamed from: Os */
    public final Bitmap mo33670Os() {
        return this.exl;
    }

    /* renamed from: Ot */
    public final int mo33671Ot() {
        return this.exn[2] == 1 ? BaseClientBuilder.API_PRIORITY_OTHER : this.exn[4];
    }

    /* renamed from: Ou */
    public final int mo33672Ou() {
        return this.exn[0];
    }

    /* renamed from: Ov */
    public final int mo33673Ov() {
        return this.exn[1];
    }

    public final void destroy() {
        AppMethodBeat.m2504i(63142);
        if (this.ehv != 0) {
            boolean z = WXHardCoderJNI.hcGifEnable || WXHardCoderJNI.hcGifFrameEnable;
            WXHardCoderJNI.stopPerformance(z, this.ehv);
            this.ehv = 0;
        }
        long j = this.exm;
        this.exm = 0;
        MMGIFJNI.recycle(j);
        AppMethodBeat.m2505o(63142);
    }
}
