package com.tencent.p177mm.media.p251b;

import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.EncoderCapabilities;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;
import p000a.p051k.C6163u;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010*\u001a\u00020+R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001a\u0010'\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\b¨\u0006-"}, dWq = {"Lcom/tencent/mm/media/config/VideoCodecConfig;", "Lcom/tencent/mm/media/config/BaseCodecConfig;", "()V", "bitrate", "", "getBitrate", "()I", "setBitrate", "(I)V", "codecInfo", "Landroid/media/MediaCodecInfo;", "getCodecInfo", "()Landroid/media/MediaCodecInfo;", "setCodecInfo", "(Landroid/media/MediaCodecInfo;)V", "colorFormat", "getColorFormat", "setColorFormat", "frameRate", "getFrameRate", "setFrameRate", "iFrameInterval", "getIFrameInterval", "setIFrameInterval", "initError", "", "getInitError", "()Z", "setInitError", "(Z)V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "targetHeight", "getTargetHeight", "setTargetHeight", "targetWidth", "getTargetWidth", "setTargetWidth", "configToFormat", "Landroid/media/MediaFormat;", "Companion", "plugin-mediaeditor_release"})
/* renamed from: com.tencent.mm.media.b.c */
public final class C24670c extends C18579a {
    public static final C24671a eTp = new C24671a();
    public int bitrate;
    public int eTi;
    public int eTj;
    public int eTk;
    private int eTl = 2130708361;
    private int eTm = 1;
    public boolean eTn;
    private MediaCodecInfo eTo;
    public String name;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/media/config/VideoCodecConfig$Companion;", "", "()V", "TAG", "", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.b.c$a */
    public static final class C24671a {
        private C24671a() {
        }

        public /* synthetic */ C24671a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.m2504i(12850);
        AppMethodBeat.m2505o(12850);
    }

    public C24670c() {
        MediaCodecInfo codecInfoAt;
        AppMethodBeat.m2504i(12849);
        String str = "video/avc";
        C25052j.m39376p(str, "<set-?>");
        this.MIME_TYPE = str;
        String str2 = this.MIME_TYPE;
        C25052j.m39376p(str2, "mimeType");
        int codecCount = MediaCodecList.getCodecCount();
        loop0:
        for (int i = 0; i < codecCount; i++) {
            codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            C25052j.m39375o(codecInfoAt, "codecInfo");
            if (codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                C25052j.m39375o(supportedTypes, "types");
                int length = supportedTypes.length;
                for (int i2 = 0; i2 < length; i2++) {
                    C4990ab.m7416i(C18579a.TAG, "selectCodec :  " + codecCount + "  type: " + supportedTypes[i2]);
                    if (C6163u.m9833I(supportedTypes[i2], str2, true)) {
                        break loop0;
                    }
                }
                continue;
            }
        }
        codecInfoAt = null;
        this.eTo = codecInfoAt;
        if (this.eTo == null) {
            C7060h.pYm.mo15419k(1047, 0, 1);
            this.eTn = true;
            AppMethodBeat.m2505o(12849);
            return;
        }
        codecInfoAt = this.eTo;
        if (codecInfoAt == null) {
            C25052j.dWJ();
        }
        this.name = codecInfoAt.getName();
        this.eTm = ((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_media_iframe, 1);
        C4990ab.m7416i("MicroMsg.VideoCodecConfig", "codecInfo.name : " + this.name + "  iFrameInterval " + this.eTm);
        AppMethodBeat.m2505o(12849);
    }

    /* renamed from: Ux */
    public final MediaFormat mo41565Ux() {
        AppMethodBeat.m2504i(12848);
        C4990ab.m7416i("MicroMsg.VideoCodecConfig", "targetWidth:" + this.eTi + ", targetHeight:" + this.eTj + ", bitrate:" + this.bitrate + ", frameRate:" + this.eTk + ", colorFormat:" + this.eTl + ", iFrameInterval:" + this.eTm);
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(this.MIME_TYPE, this.eTi, this.eTj);
        MediaCodecInfo mediaCodecInfo = this.eTo;
        if (mediaCodecInfo == null) {
            C25052j.dWJ();
        }
        C25052j.m39375o(createVideoFormat, "mediaFormat");
        mo33813a(mediaCodecInfo, createVideoFormat);
        mediaCodecInfo = this.eTo;
        if (mediaCodecInfo == null) {
            C25052j.dWJ();
        }
        C25052j.m39376p(mediaCodecInfo, "codecInfo");
        C25052j.m39376p(createVideoFormat, "mediaFormat");
        try {
            if (C1443d.m3068iW(21)) {
                CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(this.MIME_TYPE);
                if (capabilitiesForType != null) {
                    EncoderCapabilities encoderCapabilities = capabilitiesForType.getEncoderCapabilities();
                    if (encoderCapabilities != null) {
                        if (encoderCapabilities.isBitrateModeSupported(1)) {
                            C4990ab.m7416i(C18579a.TAG, "support vbr bitrate mode");
                            createVideoFormat.setInteger("bitrate-mode", 1);
                        } else if (encoderCapabilities.isBitrateModeSupported(2)) {
                            C4990ab.m7416i(C18579a.TAG, "support cbr bitrate mode");
                            createVideoFormat.setInteger("bitrate-mode", 2);
                        } else {
                            C4990ab.m7416i(C18579a.TAG, "both vbr and cbr bitrate mode not support!");
                        }
                    }
                }
            }
        } catch (Exception e) {
            C4990ab.m7413e(C18579a.TAG, "trySetBitRateMode error: %s", e.getMessage());
        }
        createVideoFormat.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, this.bitrate);
        createVideoFormat.setInteger("frame-rate", this.eTk);
        createVideoFormat.setInteger("color-format", this.eTl);
        createVideoFormat.setInteger("i-frame-interval", this.eTm);
        AppMethodBeat.m2505o(12848);
        return createVideoFormat;
    }
}
