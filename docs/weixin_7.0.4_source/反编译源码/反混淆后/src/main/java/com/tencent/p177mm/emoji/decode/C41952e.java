package com.tencent.p177mm.emoji.decode;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.gif.MMGIFException;
import com.tencent.p177mm.plugin.gif.MMWXGFJNI;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0017\u001a\u00020\bH\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\bH\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, dWq = {"Lcom/tencent/mm/emoji/decode/MMWXGFDecoder;", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "bytes", "", "([B)V", "TAG", "", "currFrame", "", "currFrameTime", "frameMetadata", "", "gifHandle", "", "lastValidFrame", "Landroid/graphics/Bitmap;", "metadata", "decodeNextFrame", "", "destroy", "drawFrameBitmap", "", "bitmap", "frameHeight", "frameTime", "frameWidth", "getFrame", "plugin-emojisdk_release"})
/* renamed from: com.tencent.mm.emoji.decode.e */
public final class C41952e implements C26076b {
    private final String TAG = "MicroMsg.GIF.MMWXGFDecoder";
    private int currFrame = -1;
    private Bitmap exl;
    private final int[] exn = new int[4];
    private long exo = MMWXGFJNI.nativeInitWxAMDecoder();
    private final int[] exp = new int[4];
    private int exq = 100;

    public C41952e(byte[] bArr) {
        C25052j.m39376p(bArr, "bytes");
        AppMethodBeat.m2504i(63149);
        Throwable mMGIFException;
        if (this.exo == 0 || this.exo == -901) {
            C4990ab.m7421w(this.TAG, "Cpan init wxam decoder failed. gifHandle:%d", Long.valueOf(this.exo));
            if (this.exo == -901) {
                C7060h.pYm.mo8378a(711, 5, 1, false);
            }
            C7060h.pYm.mo8378a(711, 4, 1, false);
            mMGIFException = new MMGIFException(201);
            AppMethodBeat.m2505o(63149);
            throw mMGIFException;
        }
        int nativeDecodeBufferHeader = MMWXGFJNI.nativeDecodeBufferHeader(this.exo, bArr, bArr.length);
        if (nativeDecodeBufferHeader != 0) {
            C4990ab.m7421w(this.TAG, "Cpan WXGF decode buffer header failed. result:%d", Integer.valueOf(nativeDecodeBufferHeader));
            if (nativeDecodeBufferHeader == -904) {
                C7060h.pYm.mo8378a(711, 8, 1, false);
            } else {
                C7060h.pYm.mo8378a(711, 3, 1, false);
            }
            mMGIFException = new MMGIFException(nativeDecodeBufferHeader);
            AppMethodBeat.m2505o(63149);
            throw mMGIFException;
        }
        nativeDecodeBufferHeader = MMWXGFJNI.nativeGetOption(this.exo, bArr, bArr.length, this.exn);
        if (nativeDecodeBufferHeader != 0) {
            C4990ab.m7421w(this.TAG, "Cpan WXGF get option failed. result:%d", Integer.valueOf(nativeDecodeBufferHeader));
            if (nativeDecodeBufferHeader == -903) {
                C7060h.pYm.mo8378a(711, 7, 1, false);
            } else {
                C7060h.pYm.mo8378a(711, 3, 1, false);
            }
            mMGIFException = new MMGIFException(nativeDecodeBufferHeader);
            AppMethodBeat.m2505o(63149);
            throw mMGIFException;
        }
        Bitmap createBitmap = Bitmap.createBitmap(this.exn[1], this.exn[2], Config.ARGB_8888);
        C25052j.m39375o(createBitmap, "Bitmap.createBitmap(fram… Bitmap.Config.ARGB_8888)");
        this.exl = createBitmap;
        AppMethodBeat.m2505o(63149);
    }

    /* renamed from: Or */
    public final void mo33669Or() {
        AppMethodBeat.m2504i(63147);
        int nativeDecodeBufferFrame = MMWXGFJNI.nativeDecodeBufferFrame(this.exo, null, 0, this.exl, this.exp);
        if (nativeDecodeBufferFrame == -904) {
            C4990ab.m7416i(this.TAG, "nativeDecodeBufferFrame failed. func is null.");
            C7060h.pYm.mo8378a(401, 8, 1, false);
        } else if (nativeDecodeBufferFrame == -909) {
            C4990ab.m7416i(this.TAG, "nativeDecodeBufferFrame failed. frame is null.");
            C7060h.pYm.mo8378a(401, 11, 1, false);
        } else if (nativeDecodeBufferFrame == -1) {
            C4990ab.m7416i(this.TAG, "nativeDecodeBufferFrame failed.");
        }
        this.currFrame++;
        if (this.currFrame >= this.exn[0] || nativeDecodeBufferFrame == 1) {
            this.currFrame = -1;
            if (MMWXGFJNI.nativeRewindBuffer(this.exo) == -905) {
                C7060h.pYm.mo8378a(711, 9, 1, false);
                C4990ab.m7420w(this.TAG, "Cpan Rewind buffer failed.");
            }
        }
        if (this.exp[0] > 0) {
            nativeDecodeBufferFrame = this.exp[0];
        } else {
            nativeDecodeBufferFrame = 100;
        }
        this.exq = nativeDecodeBufferFrame;
        AppMethodBeat.m2505o(63147);
    }

    /* renamed from: Os */
    public final Bitmap mo33670Os() {
        return this.exl;
    }

    /* renamed from: Ot */
    public final int mo33671Ot() {
        return this.exn[0] == 1 ? BaseClientBuilder.API_PRIORITY_OTHER : this.exq;
    }

    /* renamed from: Ou */
    public final int mo33672Ou() {
        return this.exn[1];
    }

    /* renamed from: Ov */
    public final int mo33673Ov() {
        return this.exn[2];
    }

    public final void destroy() {
        AppMethodBeat.m2504i(63148);
        long j = this.exo;
        this.exo = 0;
        if (MMWXGFJNI.nativeUninit(j) == -906) {
            C7060h.pYm.mo8378a(401, 10, 1, false);
        }
        C4990ab.m7411d(this.TAG, "nativeUninit result:%d gifHandle:%s", Integer.valueOf(r0), Long.valueOf(j));
        AppMethodBeat.m2505o(63148);
    }
}
