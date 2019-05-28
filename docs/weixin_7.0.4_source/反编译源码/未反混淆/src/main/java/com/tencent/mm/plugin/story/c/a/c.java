package com.tencent.mm.plugin.story.c.a;

import a.f.b.j;
import a.k.u;
import a.l;
import android.graphics.Point;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.plugin.story.c.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.ui.ae;

@l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, dWq = {"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEncodeElementConfig;", "Lcom/tencent/mm/plugin/story/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEncodeElementConfig$EncodeConfig;", "()V", "RECORDER_TYPE_FFMPEG", "", "RECORDER_TYPE_MEDIACODEC", "TAG", "", "getTAG", "()Ljava/lang/String;", "findVideoFps", "path", "getElementName", "Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ElementName;", "initDefaultConfig", "loadConfig", "", "EncodeConfig", "plugin-story_release"})
public final class c extends b<a> {
    private static final String TAG = TAG;
    public static final c rRk = new c();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\u0002\b\b\u0018\u0000 W2\u00020\u0001:\u0001WB\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\u000e\u0010>\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020@J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u000eHÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0013HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0003HÆ\u0003J\u0001\u0010P\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u0013HÆ\u0001J\u0013\u0010Q\u001a\u00020\u000e2\b\u0010R\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010S\u001a\u00020\u0003HÖ\u0001J\t\u0010T\u001a\u00020@HÖ\u0001J\u000e\u0010U\u001a\u00020V2\u0006\u0010?\u001a\u00020@R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0010\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001a\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018R\u001a\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010%\"\u0004\b&\u0010'R\u001a\u0010\f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0016\"\u0004\b)\u0010\u0018R\u001a\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0016\"\u0004\b+\u0010\u0018R\u001a\u0010\u0011\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0016\"\u0004\b-\u0010\u0018R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0016\"\u0004\b/\u0010\u0018R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0016\"\u0004\b1\u0010\u0018R\u001a\u0010\u000f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0016\"\u0004\b3\u0010\u0018R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0016\"\u0004\b5\u0010\u0018R\u001a\u00106\u001a\u000207X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0016\"\u0004\b=\u0010\u0018¨\u0006X"}, dWq = {"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEncodeElementConfig$EncodeConfig;", "", "targetWidth", "", "targetHeight", "videoBitrate", "audioBitrate", "frameRate", "videoRotate", "duration", "iFrame", "profileIndex", "presetIndex", "isDefault", "", "thumbSize", "audioSampleRate", "recorderType", "exceedVideoBitrateTolerance", "", "(IIIIIIIIIIZIIIF)V", "getAudioBitrate", "()I", "setAudioBitrate", "(I)V", "getAudioSampleRate", "setAudioSampleRate", "getDuration", "setDuration", "getExceedVideoBitrateTolerance", "()F", "setExceedVideoBitrateTolerance", "(F)V", "getFrameRate", "setFrameRate", "getIFrame", "setIFrame", "()Z", "setDefault", "(Z)V", "getPresetIndex", "setPresetIndex", "getProfileIndex", "setProfileIndex", "getRecorderType", "setRecorderType", "getTargetHeight", "setTargetHeight", "getTargetWidth", "setTargetWidth", "getThumbSize", "setThumbSize", "getVideoBitrate", "setVideoBitrate", "videoParam", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "getVideoParam", "()Lcom/tencent/mm/modelcontrol/VideoTransPara;", "setVideoParam", "(Lcom/tencent/mm/modelcontrol/VideoTransPara;)V", "getVideoRotate", "setVideoRotate", "checkExceedConfigBitrate", "path", "", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "videoConfigForLocalFile", "", "Companion", "plugin-story_release"})
    public static final class a {
        public static final a rRn = new a();
        public int audioSampleRate;
        public int duration;
        public int eTi;
        public int eTj;
        public int eTk;
        public int eXL;
        public int etz;
        int fAf;
        public int fzS;
        int fzT;
        int fzU;
        int fzV;
        boolean isDefault;
        public VideoTransPara rRl;
        float rRm;
        public int videoBitrate;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEncodeElementConfig$EncodeConfig$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b) {
                this();
            }
        }

        static {
            AppMethodBeat.i(108960);
            AppMethodBeat.o(108960);
        }

        /* JADX WARNING: Missing block: B:61:0x0096, code skipped:
            if (java.lang.Float.compare(r5.rRm, r6.rRm) == 0) goto L_0x0098;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(Object obj) {
            AppMethodBeat.i(108963);
            if (this != obj) {
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    if (this.eTi == aVar.eTi) {
                        if (this.eTj == aVar.eTj) {
                            if (this.videoBitrate == aVar.videoBitrate) {
                                if (this.fzS == aVar.fzS) {
                                    if (this.eTk == aVar.eTk) {
                                        if (this.eXL == aVar.eXL) {
                                            if (this.duration == aVar.duration) {
                                                if (this.fzT == aVar.fzT) {
                                                    if (this.fzU == aVar.fzU) {
                                                        if (this.fzV == aVar.fzV) {
                                                            if (this.isDefault == aVar.isDefault) {
                                                                if (this.fAf == aVar.fAf) {
                                                                    if (this.audioSampleRate == aVar.audioSampleRate) {
                                                                        if (this.etz == aVar.etz) {
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                AppMethodBeat.o(108963);
                return false;
            }
            AppMethodBeat.o(108963);
            return true;
        }

        public final int hashCode() {
            AppMethodBeat.i(108962);
            int i = ((((((((((((((((((this.eTi * 31) + this.eTj) * 31) + this.videoBitrate) * 31) + this.fzS) * 31) + this.eTk) * 31) + this.eXL) * 31) + this.duration) * 31) + this.fzT) * 31) + this.fzU) * 31) + this.fzV) * 31;
            int i2 = this.isDefault;
            if (i2 != 0) {
                i2 = 1;
            }
            i2 = ((((((((i2 + i) * 31) + this.fAf) * 31) + this.audioSampleRate) * 31) + this.etz) * 31) + Float.floatToIntBits(this.rRm);
            AppMethodBeat.o(108962);
            return i2;
        }

        public final String toString() {
            AppMethodBeat.i(108961);
            String str = "EncodeConfig(targetWidth=" + this.eTi + ", targetHeight=" + this.eTj + ", videoBitrate=" + this.videoBitrate + ", audioBitrate=" + this.fzS + ", frameRate=" + this.eTk + ", videoRotate=" + this.eXL + ", duration=" + this.duration + ", iFrame=" + this.fzT + ", profileIndex=" + this.fzU + ", presetIndex=" + this.fzV + ", isDefault=" + this.isDefault + ", thumbSize=" + this.fAf + ", audioSampleRate=" + this.audioSampleRate + ", recorderType=" + this.etz + ", exceedVideoBitrateTolerance=" + this.rRm + ")";
            AppMethodBeat.o(108961);
            return str;
        }

        private a() {
            AppMethodBeat.i(108959);
            this.eTi = 0;
            this.eTj = 0;
            this.videoBitrate = 0;
            this.fzS = 0;
            this.eTk = 0;
            this.eXL = 0;
            this.duration = 0;
            this.fzT = 0;
            this.fzU = 0;
            this.fzV = 0;
            this.isDefault = false;
            this.fAf = 0;
            this.audioSampleRate = 0;
            this.etz = 2;
            this.rRm = 1.3f;
            this.rRl = new VideoTransPara();
            AppMethodBeat.o(108959);
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public final void aaa(String str) {
            int i;
            int i2;
            int i3;
            int i4;
            AppMethodBeat.i(108957);
            j.p(str, "path");
            ab.i("MicroMsg.IEncodeConfig", "videoConfigForLocalFile: ".concat(String.valueOf(str)));
            com.tencent.mm.plugin.sight.base.a WR = d.WR(str);
            if (WR != null) {
                i = WR.width;
                i2 = WR.height;
                i3 = WR.videoBitrate;
                i4 = WR.eTk;
            } else {
                i4 = 0;
                i3 = 0;
                i2 = 0;
                i = 0;
            }
            if (i2 <= 0 || r2 <= 0) {
                try {
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    mediaMetadataRetriever.setDataSource(str);
                    i = bo.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
                    i2 = bo.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
                    i3 = bo.getInt(mediaMetadataRetriever.extractMetadata(20), 0);
                    mediaMetadataRetriever.release();
                } catch (Exception e) {
                }
            }
            if (i4 <= 0) {
                c cVar = c.rRk;
                i4 = c.ZZ(str);
            }
            int mp4Rotate = SightVideoJNI.getMp4Rotate(str);
            ab.i("MicroMsg.IEncodeConfig", "videoWidth: " + i + " , videoHeight :" + i2 + "  , videoBitrate:" + i3 + " ,videoFrameRate:" + i4 + " , videoRotate : " + mp4Rotate);
            if (i3 < this.videoBitrate) {
                this.videoBitrate = i3;
            }
            if (mp4Rotate == 90 || mp4Rotate == 270) {
                if (i2 > this.eTi && i2 - this.eTi > 16) {
                    i = (int) ((((float) this.eTi) / ((float) i2)) * ((float) i));
                    i2 = this.eTi;
                }
            } else if (i > this.eTi && i - this.eTi > 16) {
                i2 = (int) (((float) i2) * (((float) this.eTi) / ((float) i)));
                i = this.eTi;
            }
            if (i2 % 16 != 0) {
                i2 = com.tencent.mm.plugin.mmsight.d.yN(i2);
            }
            if (i % 16 != 0) {
                i = com.tencent.mm.plugin.mmsight.d.yN(i);
            }
            if (this.eTk > i4) {
                this.eTk = i4;
            }
            this.eTj = i2;
            this.eTi = i;
            this.eXL = mp4Rotate;
            AppMethodBeat.o(108957);
        }

        public final boolean aab(String str) {
            int i;
            AppMethodBeat.i(108958);
            j.p(str, "path");
            com.tencent.mm.plugin.sight.base.a WR = d.WR(str);
            if (WR != null) {
                i = WR.videoBitrate;
            } else {
                i = 0;
            }
            if (i <= 0) {
                try {
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    mediaMetadataRetriever.setDataSource(str);
                    i = bo.getInt(mediaMetadataRetriever.extractMetadata(20), 0);
                    mediaMetadataRetriever.release();
                } catch (Exception e) {
                }
            }
            ab.i("MicroMsg.IEncodeConfig", "checkExceedConfigBitrate, path:" + str + ", bitrate:" + i + ", videoBitrate:" + this.videoBitrate + ", exceedVideoBitrateTolerance:" + this.rRm);
            if (((float) i) > ((float) this.videoBitrate) * this.rRm) {
                AppMethodBeat.o(108958);
                return true;
            }
            AppMethodBeat.o(108958);
            return false;
        }
    }

    static {
        AppMethodBeat.i(108967);
        AppMethodBeat.o(108967);
    }

    private c() {
    }

    public static final /* synthetic */ int ZZ(String str) {
        AppMethodBeat.i(108968);
        int ZY = ZY(str);
        AppMethodBeat.o(108968);
        return ZY;
    }

    public final void Uv() {
        float f;
        AppMethodBeat.i(108965);
        a aVar = (a) Ut();
        com.tencent.mm.plugin.story.proxy.d.a aVar2 = com.tencent.mm.plugin.story.proxy.d.sbf;
        com.tencent.mm.plugin.story.proxy.d.sbe;
        VideoTransPara videoPara = com.tencent.mm.plugin.story.proxy.d.getVideoPara();
        j.p(videoPara, "<set-?>");
        aVar.rRl = videoPara;
        VideoTransPara videoTransPara = ((a) Ut()).rRl;
        ((a) Ut()).eTi = videoTransPara.width;
        aVar = (a) Ut();
        com.tencent.mm.media.i.d.a aVar3 = com.tencent.mm.media.i.d.fan;
        int i = videoTransPara.width;
        Point hy = ae.hy(ah.getContext());
        aVar.eTj = (i * hy.y) / hy.x;
        if (((a) Ut()).eTj % 16 != 0) {
            ((a) Ut()).eTj = com.tencent.mm.plugin.mmsight.d.yN(((a) Ut()).eTj);
        }
        if (((a) Ut()).eTi % 16 != 0) {
            ((a) Ut()).eTi = com.tencent.mm.plugin.mmsight.d.yN(((a) Ut()).eTi);
        }
        ((a) Ut()).rRl.width = ((a) Ut()).eTi;
        ((a) Ut()).rRl.height = ((a) Ut()).eTj;
        ((a) Ut()).videoBitrate = videoTransPara.videoBitrate;
        ((a) Ut()).fzS = videoTransPara.fzS;
        ((a) Ut()).eTk = videoTransPara.fps;
        ((a) Ut()).fzT = videoTransPara.fzT;
        ((a) Ut()).duration = videoTransPara.duration;
        ((a) Ut()).fzV = videoTransPara.fzV;
        ((a) Ut()).fzU = videoTransPara.fzU;
        ((a) Ut()).isDefault = videoTransPara.isDefault;
        ((a) Ut()).fAf = videoTransPara.fAf;
        ((a) Ut()).audioSampleRate = videoTransPara.audioSampleRate;
        aVar = (a) Ut();
        String str = "StoryCheckSendVideoBitrateLimit";
        j.p(str, "key");
        if (ah.bqo()) {
            com.tencent.mm.kernel.c.a K = g.K(com.tencent.mm.plugin.zero.b.a.class);
            j.o(K, "MMKernel.service<IConfig…onfigService::class.java)");
            f = bo.getFloat(((com.tencent.mm.plugin.zero.b.a) K).Nu().getValue(str), 1.3f);
        } else {
            f = bo.getFloat(CaptureMMProxy.getInstance().getDynamicConfig(str), 1.3f);
        }
        aVar.rRm = f;
        if (q.etk.etz != -1) {
            ((a) Ut()).etz = q.etk.etz;
        }
        if (bp.dpL()) {
            aVar = (a) Ut();
            e RP = g.RP();
            j.o(RP, "MMKernel.storage()");
            aVar.etz = RP.Ry().getInt(com.tencent.mm.storage.ac.a.USERINFO_TOP_STORY_ENCODER_TYPE_INT, 2);
        }
        ab.i(TAG, "loadConfigFromVideoParam: " + ((a) Ut()));
        AppMethodBeat.o(108965);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0095  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int ZY(String str) {
        Exception e;
        Throwable th;
        AppMethodBeat.i(108966);
        MediaExtractor mediaExtractor;
        try {
            mediaExtractor = new MediaExtractor();
            try {
                int i;
                mediaExtractor.setDataSource(str);
                int trackCount = mediaExtractor.getTrackCount();
                for (i = 0; i < trackCount; i++) {
                    MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
                    if (trackFormat.containsKey("mime") && !bo.isNullOrNil(trackFormat.getString("mime"))) {
                        String string = trackFormat.getString("mime");
                        ab.i(TAG, "mime: %s", string);
                        j.o(string, "mime");
                        if (u.jb(string, "video/")) {
                            i = trackFormat.getInteger("frame-rate");
                            ab.i(TAG, "fps: %s", Integer.valueOf(i));
                            break;
                        }
                    }
                }
                i = 0;
                mediaExtractor.release();
                AppMethodBeat.o(108966);
                return i;
            } catch (Exception e2) {
                e = e2;
                try {
                    ab.printErrStackTrace(TAG, e, "find fps error", new Object[0]);
                    if (mediaExtractor != null) {
                    }
                    AppMethodBeat.o(108966);
                    return 0;
                } catch (Throwable th2) {
                    th = th2;
                    if (mediaExtractor != null) {
                    }
                    AppMethodBeat.o(108966);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            mediaExtractor = null;
            ab.printErrStackTrace(TAG, e, "find fps error", new Object[0]);
            if (mediaExtractor != null) {
                mediaExtractor.release();
            }
            AppMethodBeat.o(108966);
            return 0;
        } catch (Throwable th3) {
            th = th3;
            mediaExtractor = null;
            if (mediaExtractor != null) {
                mediaExtractor.release();
            }
            AppMethodBeat.o(108966);
            throw th;
        }
    }

    public final /* synthetic */ Object Uu() {
        AppMethodBeat.i(108964);
        a aVar = new a();
        AppMethodBeat.o(108964);
        return aVar;
    }
}
