package com.tencent.p177mm.plugin.story.p1032c.p1033a;

import android.graphics.Point;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.kernel.C1706e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p242c.C1694a;
import com.tencent.p177mm.media.p867i.C26387d;
import com.tencent.p177mm.media.p867i.C26387d.C26388a;
import com.tencent.p177mm.modelcontrol.VideoTransPara;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.plugin.mmsight.C3475d;
import com.tencent.p177mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.p177mm.plugin.sight.base.C21846d;
import com.tencent.p177mm.plugin.sight.base.C43528a;
import com.tencent.p177mm.plugin.sight.base.SightVideoJNI;
import com.tencent.p177mm.plugin.story.p1032c.C46271b;
import com.tencent.p177mm.plugin.story.proxy.C39913d;
import com.tencent.p177mm.plugin.story.proxy.C39913d.C22249a;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5047bp;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;
import p000a.p051k.C6163u;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, dWq = {"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEncodeElementConfig;", "Lcom/tencent/mm/plugin/story/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEncodeElementConfig$EncodeConfig;", "()V", "RECORDER_TYPE_FFMPEG", "", "RECORDER_TYPE_MEDIACODEC", "TAG", "", "getTAG", "()Ljava/lang/String;", "findVideoFps", "path", "getElementName", "Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ElementName;", "initDefaultConfig", "loadConfig", "", "EncodeConfig", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.c.a.c */
public final class C29275c extends C46271b<C29276a> {
    private static final String TAG = TAG;
    public static final C29275c rRk = new C29275c();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\u0002\b\b\u0018\u0000 W2\u00020\u0001:\u0001WB\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\u000e\u0010>\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020@J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u000eHÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0013HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0003HÆ\u0003J\u0001\u0010P\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u0013HÆ\u0001J\u0013\u0010Q\u001a\u00020\u000e2\b\u0010R\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010S\u001a\u00020\u0003HÖ\u0001J\t\u0010T\u001a\u00020@HÖ\u0001J\u000e\u0010U\u001a\u00020V2\u0006\u0010?\u001a\u00020@R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0010\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001a\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018R\u001a\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010%\"\u0004\b&\u0010'R\u001a\u0010\f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0016\"\u0004\b)\u0010\u0018R\u001a\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0016\"\u0004\b+\u0010\u0018R\u001a\u0010\u0011\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0016\"\u0004\b-\u0010\u0018R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0016\"\u0004\b/\u0010\u0018R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0016\"\u0004\b1\u0010\u0018R\u001a\u0010\u000f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0016\"\u0004\b3\u0010\u0018R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0016\"\u0004\b5\u0010\u0018R\u001a\u00106\u001a\u000207X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0016\"\u0004\b=\u0010\u0018¨\u0006X"}, dWq = {"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEncodeElementConfig$EncodeConfig;", "", "targetWidth", "", "targetHeight", "videoBitrate", "audioBitrate", "frameRate", "videoRotate", "duration", "iFrame", "profileIndex", "presetIndex", "isDefault", "", "thumbSize", "audioSampleRate", "recorderType", "exceedVideoBitrateTolerance", "", "(IIIIIIIIIIZIIIF)V", "getAudioBitrate", "()I", "setAudioBitrate", "(I)V", "getAudioSampleRate", "setAudioSampleRate", "getDuration", "setDuration", "getExceedVideoBitrateTolerance", "()F", "setExceedVideoBitrateTolerance", "(F)V", "getFrameRate", "setFrameRate", "getIFrame", "setIFrame", "()Z", "setDefault", "(Z)V", "getPresetIndex", "setPresetIndex", "getProfileIndex", "setProfileIndex", "getRecorderType", "setRecorderType", "getTargetHeight", "setTargetHeight", "getTargetWidth", "setTargetWidth", "getThumbSize", "setThumbSize", "getVideoBitrate", "setVideoBitrate", "videoParam", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "getVideoParam", "()Lcom/tencent/mm/modelcontrol/VideoTransPara;", "setVideoParam", "(Lcom/tencent/mm/modelcontrol/VideoTransPara;)V", "getVideoRotate", "setVideoRotate", "checkExceedConfigBitrate", "path", "", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "videoConfigForLocalFile", "", "Companion", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.c.a.c$a */
    public static final class C29276a {
        public static final C29277a rRn = new C29277a();
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

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEncodeElementConfig$EncodeConfig$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
        /* renamed from: com.tencent.mm.plugin.story.c.a.c$a$a */
        public static final class C29277a {
            private C29277a() {
            }

            public /* synthetic */ C29277a(byte b) {
                this();
            }
        }

        static {
            AppMethodBeat.m2504i(108960);
            AppMethodBeat.m2505o(108960);
        }

        /* JADX WARNING: Missing block: B:61:0x0096, code skipped:
            if (java.lang.Float.compare(r5.rRm, r6.rRm) == 0) goto L_0x0098;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(Object obj) {
            AppMethodBeat.m2504i(108963);
            if (this != obj) {
                if (obj instanceof C29276a) {
                    C29276a c29276a = (C29276a) obj;
                    if (this.eTi == c29276a.eTi) {
                        if (this.eTj == c29276a.eTj) {
                            if (this.videoBitrate == c29276a.videoBitrate) {
                                if (this.fzS == c29276a.fzS) {
                                    if (this.eTk == c29276a.eTk) {
                                        if (this.eXL == c29276a.eXL) {
                                            if (this.duration == c29276a.duration) {
                                                if (this.fzT == c29276a.fzT) {
                                                    if (this.fzU == c29276a.fzU) {
                                                        if (this.fzV == c29276a.fzV) {
                                                            if (this.isDefault == c29276a.isDefault) {
                                                                if (this.fAf == c29276a.fAf) {
                                                                    if (this.audioSampleRate == c29276a.audioSampleRate) {
                                                                        if (this.etz == c29276a.etz) {
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
                AppMethodBeat.m2505o(108963);
                return false;
            }
            AppMethodBeat.m2505o(108963);
            return true;
        }

        public final int hashCode() {
            AppMethodBeat.m2504i(108962);
            int i = ((((((((((((((((((this.eTi * 31) + this.eTj) * 31) + this.videoBitrate) * 31) + this.fzS) * 31) + this.eTk) * 31) + this.eXL) * 31) + this.duration) * 31) + this.fzT) * 31) + this.fzU) * 31) + this.fzV) * 31;
            int i2 = this.isDefault;
            if (i2 != 0) {
                i2 = 1;
            }
            i2 = ((((((((i2 + i) * 31) + this.fAf) * 31) + this.audioSampleRate) * 31) + this.etz) * 31) + Float.floatToIntBits(this.rRm);
            AppMethodBeat.m2505o(108962);
            return i2;
        }

        public final String toString() {
            AppMethodBeat.m2504i(108961);
            String str = "EncodeConfig(targetWidth=" + this.eTi + ", targetHeight=" + this.eTj + ", videoBitrate=" + this.videoBitrate + ", audioBitrate=" + this.fzS + ", frameRate=" + this.eTk + ", videoRotate=" + this.eXL + ", duration=" + this.duration + ", iFrame=" + this.fzT + ", profileIndex=" + this.fzU + ", presetIndex=" + this.fzV + ", isDefault=" + this.isDefault + ", thumbSize=" + this.fAf + ", audioSampleRate=" + this.audioSampleRate + ", recorderType=" + this.etz + ", exceedVideoBitrateTolerance=" + this.rRm + ")";
            AppMethodBeat.m2505o(108961);
            return str;
        }

        private C29276a() {
            AppMethodBeat.m2504i(108959);
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
            AppMethodBeat.m2505o(108959);
        }

        public /* synthetic */ C29276a(byte b) {
            this();
        }

        public final void aaa(String str) {
            int i;
            int i2;
            int i3;
            int i4;
            AppMethodBeat.m2504i(108957);
            C25052j.m39376p(str, "path");
            C4990ab.m7416i("MicroMsg.IEncodeConfig", "videoConfigForLocalFile: ".concat(String.valueOf(str)));
            C43528a WR = C21846d.m33388WR(str);
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
                    i = C5046bo.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
                    i2 = C5046bo.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
                    i3 = C5046bo.getInt(mediaMetadataRetriever.extractMetadata(20), 0);
                    mediaMetadataRetriever.release();
                } catch (Exception e) {
                }
            }
            if (i4 <= 0) {
                C29275c c29275c = C29275c.rRk;
                i4 = C29275c.m46485ZZ(str);
            }
            int mp4Rotate = SightVideoJNI.getMp4Rotate(str);
            C4990ab.m7416i("MicroMsg.IEncodeConfig", "videoWidth: " + i + " , videoHeight :" + i2 + "  , videoBitrate:" + i3 + " ,videoFrameRate:" + i4 + " , videoRotate : " + mp4Rotate);
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
                i2 = C3475d.m5785yN(i2);
            }
            if (i % 16 != 0) {
                i = C3475d.m5785yN(i);
            }
            if (this.eTk > i4) {
                this.eTk = i4;
            }
            this.eTj = i2;
            this.eTi = i;
            this.eXL = mp4Rotate;
            AppMethodBeat.m2505o(108957);
        }

        public final boolean aab(String str) {
            int i;
            AppMethodBeat.m2504i(108958);
            C25052j.m39376p(str, "path");
            C43528a WR = C21846d.m33388WR(str);
            if (WR != null) {
                i = WR.videoBitrate;
            } else {
                i = 0;
            }
            if (i <= 0) {
                try {
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    mediaMetadataRetriever.setDataSource(str);
                    i = C5046bo.getInt(mediaMetadataRetriever.extractMetadata(20), 0);
                    mediaMetadataRetriever.release();
                } catch (Exception e) {
                }
            }
            C4990ab.m7416i("MicroMsg.IEncodeConfig", "checkExceedConfigBitrate, path:" + str + ", bitrate:" + i + ", videoBitrate:" + this.videoBitrate + ", exceedVideoBitrateTolerance:" + this.rRm);
            if (((float) i) > ((float) this.videoBitrate) * this.rRm) {
                AppMethodBeat.m2505o(108958);
                return true;
            }
            AppMethodBeat.m2505o(108958);
            return false;
        }
    }

    static {
        AppMethodBeat.m2504i(108967);
        AppMethodBeat.m2505o(108967);
    }

    private C29275c() {
    }

    /* renamed from: ZZ */
    public static final /* synthetic */ int m46485ZZ(String str) {
        AppMethodBeat.m2504i(108968);
        int ZY = C29275c.m46484ZY(str);
        AppMethodBeat.m2505o(108968);
        return ZY;
    }

    /* renamed from: Uv */
    public final void mo25945Uv() {
        float f;
        AppMethodBeat.m2504i(108965);
        C29276a c29276a = (C29276a) mo53287Ut();
        C22249a c22249a = C39913d.sbf;
        C39913d.sbe;
        VideoTransPara videoPara = C39913d.getVideoPara();
        C25052j.m39376p(videoPara, "<set-?>");
        c29276a.rRl = videoPara;
        VideoTransPara videoTransPara = ((C29276a) mo53287Ut()).rRl;
        ((C29276a) mo53287Ut()).eTi = videoTransPara.width;
        c29276a = (C29276a) mo53287Ut();
        C26388a c26388a = C26387d.fan;
        int i = videoTransPara.width;
        Point hy = C5222ae.m7953hy(C4996ah.getContext());
        c29276a.eTj = (i * hy.y) / hy.x;
        if (((C29276a) mo53287Ut()).eTj % 16 != 0) {
            ((C29276a) mo53287Ut()).eTj = C3475d.m5785yN(((C29276a) mo53287Ut()).eTj);
        }
        if (((C29276a) mo53287Ut()).eTi % 16 != 0) {
            ((C29276a) mo53287Ut()).eTi = C3475d.m5785yN(((C29276a) mo53287Ut()).eTi);
        }
        ((C29276a) mo53287Ut()).rRl.width = ((C29276a) mo53287Ut()).eTi;
        ((C29276a) mo53287Ut()).rRl.height = ((C29276a) mo53287Ut()).eTj;
        ((C29276a) mo53287Ut()).videoBitrate = videoTransPara.videoBitrate;
        ((C29276a) mo53287Ut()).fzS = videoTransPara.fzS;
        ((C29276a) mo53287Ut()).eTk = videoTransPara.fps;
        ((C29276a) mo53287Ut()).fzT = videoTransPara.fzT;
        ((C29276a) mo53287Ut()).duration = videoTransPara.duration;
        ((C29276a) mo53287Ut()).fzV = videoTransPara.fzV;
        ((C29276a) mo53287Ut()).fzU = videoTransPara.fzU;
        ((C29276a) mo53287Ut()).isDefault = videoTransPara.isDefault;
        ((C29276a) mo53287Ut()).fAf = videoTransPara.fAf;
        ((C29276a) mo53287Ut()).audioSampleRate = videoTransPara.audioSampleRate;
        c29276a = (C29276a) mo53287Ut();
        String str = "StoryCheckSendVideoBitrateLimit";
        C25052j.m39376p(str, "key");
        if (C4996ah.bqo()) {
            C1694a K = C1720g.m3528K(C7234a.class);
            C25052j.m39375o(K, "MMKernel.service<IConfig…onfigService::class.java)");
            f = C5046bo.getFloat(((C7234a) K).mo15608Nu().getValue(str), 1.3f);
        } else {
            f = C5046bo.getFloat(CaptureMMProxy.getInstance().getDynamicConfig(str), 1.3f);
        }
        c29276a.rRm = f;
        if (C1427q.etk.etz != -1) {
            ((C29276a) mo53287Ut()).etz = C1427q.etk.etz;
        }
        if (C5047bp.dpL()) {
            c29276a = (C29276a) mo53287Ut();
            C1706e RP = C1720g.m3536RP();
            C25052j.m39375o(RP, "MMKernel.storage()");
            c29276a.etz = RP.mo5239Ry().getInt(C5127a.USERINFO_TOP_STORY_ENCODER_TYPE_INT, 2);
        }
        C4990ab.m7416i(TAG, "loadConfigFromVideoParam: " + ((C29276a) mo53287Ut()));
        AppMethodBeat.m2505o(108965);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0095  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: ZY */
    private static int m46484ZY(String str) {
        Exception e;
        Throwable th;
        AppMethodBeat.m2504i(108966);
        MediaExtractor mediaExtractor;
        try {
            mediaExtractor = new MediaExtractor();
            try {
                int i;
                mediaExtractor.setDataSource(str);
                int trackCount = mediaExtractor.getTrackCount();
                for (i = 0; i < trackCount; i++) {
                    MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
                    if (trackFormat.containsKey("mime") && !C5046bo.isNullOrNil(trackFormat.getString("mime"))) {
                        String string = trackFormat.getString("mime");
                        C4990ab.m7417i(TAG, "mime: %s", string);
                        C25052j.m39375o(string, "mime");
                        if (C6163u.m9839jb(string, "video/")) {
                            i = trackFormat.getInteger("frame-rate");
                            C4990ab.m7417i(TAG, "fps: %s", Integer.valueOf(i));
                            break;
                        }
                    }
                }
                i = 0;
                mediaExtractor.release();
                AppMethodBeat.m2505o(108966);
                return i;
            } catch (Exception e2) {
                e = e2;
                try {
                    C4990ab.printErrStackTrace(TAG, e, "find fps error", new Object[0]);
                    if (mediaExtractor != null) {
                    }
                    AppMethodBeat.m2505o(108966);
                    return 0;
                } catch (Throwable th2) {
                    th = th2;
                    if (mediaExtractor != null) {
                    }
                    AppMethodBeat.m2505o(108966);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            mediaExtractor = null;
            C4990ab.printErrStackTrace(TAG, e, "find fps error", new Object[0]);
            if (mediaExtractor != null) {
                mediaExtractor.release();
            }
            AppMethodBeat.m2505o(108966);
            return 0;
        } catch (Throwable th3) {
            th = th3;
            mediaExtractor = null;
            if (mediaExtractor != null) {
                mediaExtractor.release();
            }
            AppMethodBeat.m2505o(108966);
            throw th;
        }
    }

    /* renamed from: Uu */
    public final /* synthetic */ Object mo25944Uu() {
        AppMethodBeat.m2504i(108964);
        C29276a c29276a = new C29276a();
        AppMethodBeat.m2505o(108964);
        return c29276a;
    }
}
