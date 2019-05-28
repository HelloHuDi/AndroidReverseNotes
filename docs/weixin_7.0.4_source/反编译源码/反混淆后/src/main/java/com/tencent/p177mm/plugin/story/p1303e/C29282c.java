package com.tencent.p177mm.plugin.story.p1303e;

import android.graphics.Point;
import android.media.MediaMetadataRetriever;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.media.p1464e.C32742a;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.platformtools.C45477q;
import com.tencent.p177mm.plugin.mmsight.C3475d;
import com.tencent.p177mm.plugin.sight.base.C21846d;
import com.tencent.p177mm.plugin.sight.base.C43528a;
import com.tencent.p177mm.plugin.sight.base.SightVideoJNI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vfs.C5730e;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, dWq = {"Lcom/tencent/mm/plugin/story/data/StoryUtil;", "", "()V", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.e.c */
public final class C29282c {
    private static final String TAG = TAG;
    private static final String qGf = qGf;
    private static final String rRP = rRP;
    private static final float rRQ = rRQ;
    private static final String rRR = rRR;
    public static final C29283a rRS = new C29283a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001:\u0001$B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0012\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u0004J\u000e\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004J\u000e\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\"R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006%"}, dWq = {"Lcom/tencent/mm/plugin/story/data/StoryUtil$Companion;", "", "()V", "B_PRE", "", "INVALID_GEO", "", "getINVALID_GEO", "()F", "LOCAL_PATH_PRE", "getLOCAL_PATH_PRE", "()Ljava/lang/String;", "RESPONE_COUNT", "TAG", "bitmapAvailable", "", "bm", "Landroid/graphics/Bitmap;", "dumpMedia", "media", "Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "exportVideo", "", "videoPath", "getFullStrSeq", "stringSeq", "getStoryResponeCount", "", "getVideoInfo", "Lcom/tencent/mm/plugin/story/data/StoryUtil$Companion$VideoInfo;", "path", "getVideoMIME", "longToFullString", "seq", "", "longToString", "VideoInfo", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.e.c$a */
    public static final class C29283a {

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003JO\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006\""}, dWq = {"Lcom/tencent/mm/plugin/story/data/StoryUtil$Companion$VideoInfo;", "", "width", "", "height", "duration", "rotate", "videoBitrate", "fps", "matchScreenRatio", "", "(IIIIIIZ)V", "getDuration", "()I", "getFps", "getHeight", "getMatchScreenRatio", "()Z", "getRotate", "getVideoBitrate", "getWidth", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "", "plugin-story_release"})
        /* renamed from: com.tencent.mm.plugin.story.e.c$a$a */
        public static final class C29281a {
            public final int duration;
            public final int fps;
            public final int height;
            public final boolean rRT;
            private final int rotate;
            public final int videoBitrate;
            public final int width;

            public final boolean equals(Object obj) {
                if (this != obj) {
                    if (!(obj instanceof C29281a)) {
                        return false;
                    }
                    C29281a c29281a = (C29281a) obj;
                    if (!(this.width == c29281a.width)) {
                        return false;
                    }
                    if (!(this.height == c29281a.height)) {
                        return false;
                    }
                    if (!(this.duration == c29281a.duration)) {
                        return false;
                    }
                    if (!(this.rotate == c29281a.rotate)) {
                        return false;
                    }
                    if (!(this.videoBitrate == c29281a.videoBitrate)) {
                        return false;
                    }
                    if (!(this.fps == c29281a.fps)) {
                        return false;
                    }
                    if (!(this.rRT == c29281a.rRT)) {
                        return false;
                    }
                }
                return true;
            }

            public final int hashCode() {
                int i = ((((((((((this.width * 31) + this.height) * 31) + this.duration) * 31) + this.rotate) * 31) + this.videoBitrate) * 31) + this.fps) * 31;
                int i2 = this.rRT;
                if (i2 != 0) {
                    i2 = 1;
                }
                return i2 + i;
            }

            public final String toString() {
                AppMethodBeat.m2504i(108993);
                String str = "VideoInfo(width=" + this.width + ", height=" + this.height + ", duration=" + this.duration + ", rotate=" + this.rotate + ", videoBitrate=" + this.videoBitrate + ", fps=" + this.fps + ", matchScreenRatio=" + this.rRT + ")";
                AppMethodBeat.m2505o(108993);
                return str;
            }

            public C29281a(int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
                this.width = i;
                this.height = i2;
                this.duration = i3;
                this.rotate = i4;
                this.videoBitrate = i5;
                this.fps = i6;
                this.rRT = z;
            }
        }

        private C29283a() {
        }

        public /* synthetic */ C29283a(byte b) {
            this();
        }

        public static void aai(String str) {
            AppMethodBeat.m2504i(108994);
            C25052j.m39376p(str, "videoPath");
            if (C1720g.m3536RP().mo5239Ry().getBoolean(C5127a.USERINFO_WEIXIN_CAMERASAVEVIDEO_STATE_BOOLEAN, true)) {
                String RL = C3475d.m5764RL("mp4");
                C25052j.m39375o(RL, "MMSightUtil.getExportImagePath(\"mp4\")");
                C4990ab.m7417i(C29282c.TAG, "auto save " + str + " exportPath " + RL, str, RL);
                C5730e.m8644y(str, RL);
                C45477q.m83805a(RL, C4996ah.getContext());
            }
            AppMethodBeat.m2505o(108994);
        }

        public static C29281a aaj(String str) {
            boolean z = true;
            AppMethodBeat.m2504i(108995);
            C25052j.m39376p(str, "path");
            C43528a WR = C21846d.m33388WR(str);
            if (WR == null) {
                AppMethodBeat.m2505o(108995);
                return null;
            }
            if (WR.height <= 0 || WR.width <= 0) {
                try {
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    mediaMetadataRetriever.setDataSource(str);
                    WR.width = C5046bo.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
                    WR.height = C5046bo.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
                    WR.videoBitrate = C5046bo.getInt(mediaMetadataRetriever.extractMetadata(20), 0);
                    mediaMetadataRetriever.release();
                } catch (Exception e) {
                }
            }
            int mp4Rotate = SightVideoJNI.getMp4Rotate(str);
            Point hy = C5222ae.m7953hy(C4996ah.getContext());
            boolean z2 = mp4Rotate == 270 || mp4Rotate == 90;
            if (((double) Math.abs((((float) (z2 ? WR.height : WR.width)) / ((float) (z2 ? WR.width : WR.height))) - (((float) hy.x) / ((float) hy.y)))) > 0.01d) {
                z = false;
            }
            C29281a c29281a = new C29281a(WR.width, WR.height, WR.eWK, mp4Rotate, WR.videoBitrate, WR.eTk, z);
            AppMethodBeat.m2505o(108995);
            return c29281a;
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0041  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static String aak(String str) {
            Throwable th;
            C32742a c32742a;
            AppMethodBeat.m2504i(108996);
            C25052j.m39376p(str, "path");
            String str2;
            if (C5046bo.isNullOrNil(str)) {
                str2 = "";
                AppMethodBeat.m2505o(108996);
                return str2;
            }
            C32742a c32742a2 = null;
            try {
                C32742a c32742a3 = new C32742a(str);
                try {
                    str2 = c32742a3.mo53292UV();
                    if (str2 == null) {
                        str2 = "";
                    }
                    c32742a3.release();
                    AppMethodBeat.m2505o(108996);
                    return str2;
                } catch (Exception e) {
                    c32742a2 = c32742a3;
                    if (c32742a2 != null) {
                    }
                    str2 = "";
                    AppMethodBeat.m2505o(108996);
                    return str2;
                } catch (Throwable th2) {
                    th = th2;
                    c32742a = c32742a3;
                    if (c32742a != null) {
                    }
                    AppMethodBeat.m2505o(108996);
                    throw th;
                }
            } catch (Exception e2) {
                if (c32742a2 != null) {
                    c32742a2.release();
                }
                str2 = "";
                AppMethodBeat.m2505o(108996);
                return str2;
            } catch (Throwable th3) {
                th = th3;
                c32742a = null;
                if (c32742a != null) {
                    c32742a.release();
                }
                AppMethodBeat.m2505o(108996);
                throw th;
            }
        }
    }

    static {
        AppMethodBeat.m2504i(108997);
        AppMethodBeat.m2505o(108997);
    }
}
