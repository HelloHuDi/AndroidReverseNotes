package com.tencent.mm.plugin.story.e;

import a.f.b.j;
import a.l;
import android.graphics.Point;
import android.media.MediaMetadataRetriever;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.ae;
import com.tencent.mm.vfs.e;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, dWq = {"Lcom/tencent/mm/plugin/story/data/StoryUtil;", "", "()V", "Companion", "plugin-story_release"})
public final class c {
    private static final String TAG = TAG;
    private static final String qGf = qGf;
    private static final String rRP = rRP;
    private static final float rRQ = rRQ;
    private static final String rRR = rRR;
    public static final a rRS = new a();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001:\u0001$B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0012\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u0004J\u000e\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004J\u000e\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\"R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006%"}, dWq = {"Lcom/tencent/mm/plugin/story/data/StoryUtil$Companion;", "", "()V", "B_PRE", "", "INVALID_GEO", "", "getINVALID_GEO", "()F", "LOCAL_PATH_PRE", "getLOCAL_PATH_PRE", "()Ljava/lang/String;", "RESPONE_COUNT", "TAG", "bitmapAvailable", "", "bm", "Landroid/graphics/Bitmap;", "dumpMedia", "media", "Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "exportVideo", "", "videoPath", "getFullStrSeq", "stringSeq", "getStoryResponeCount", "", "getVideoInfo", "Lcom/tencent/mm/plugin/story/data/StoryUtil$Companion$VideoInfo;", "path", "getVideoMIME", "longToFullString", "seq", "", "longToString", "VideoInfo", "plugin-story_release"})
    public static final class a {

        @l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003JO\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006\""}, dWq = {"Lcom/tencent/mm/plugin/story/data/StoryUtil$Companion$VideoInfo;", "", "width", "", "height", "duration", "rotate", "videoBitrate", "fps", "matchScreenRatio", "", "(IIIIIIZ)V", "getDuration", "()I", "getFps", "getHeight", "getMatchScreenRatio", "()Z", "getRotate", "getVideoBitrate", "getWidth", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "", "plugin-story_release"})
        public static final class a {
            public final int duration;
            public final int fps;
            public final int height;
            public final boolean rRT;
            private final int rotate;
            public final int videoBitrate;
            public final int width;

            public final boolean equals(Object obj) {
                if (this != obj) {
                    if (!(obj instanceof a)) {
                        return false;
                    }
                    a aVar = (a) obj;
                    if (!(this.width == aVar.width)) {
                        return false;
                    }
                    if (!(this.height == aVar.height)) {
                        return false;
                    }
                    if (!(this.duration == aVar.duration)) {
                        return false;
                    }
                    if (!(this.rotate == aVar.rotate)) {
                        return false;
                    }
                    if (!(this.videoBitrate == aVar.videoBitrate)) {
                        return false;
                    }
                    if (!(this.fps == aVar.fps)) {
                        return false;
                    }
                    if (!(this.rRT == aVar.rRT)) {
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
                AppMethodBeat.i(108993);
                String str = "VideoInfo(width=" + this.width + ", height=" + this.height + ", duration=" + this.duration + ", rotate=" + this.rotate + ", videoBitrate=" + this.videoBitrate + ", fps=" + this.fps + ", matchScreenRatio=" + this.rRT + ")";
                AppMethodBeat.o(108993);
                return str;
            }

            public a(int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
                this.width = i;
                this.height = i2;
                this.duration = i3;
                this.rotate = i4;
                this.videoBitrate = i5;
                this.fps = i6;
                this.rRT = z;
            }
        }

        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public static void aai(String str) {
            AppMethodBeat.i(108994);
            j.p(str, "videoPath");
            if (g.RP().Ry().getBoolean(com.tencent.mm.storage.ac.a.USERINFO_WEIXIN_CAMERASAVEVIDEO_STATE_BOOLEAN, true)) {
                String RL = d.RL("mp4");
                j.o(RL, "MMSightUtil.getExportImagePath(\"mp4\")");
                ab.i(c.TAG, "auto save " + str + " exportPath " + RL, str, RL);
                e.y(str, RL);
                q.a(RL, ah.getContext());
            }
            AppMethodBeat.o(108994);
        }

        public static a aaj(String str) {
            boolean z = true;
            AppMethodBeat.i(108995);
            j.p(str, "path");
            com.tencent.mm.plugin.sight.base.a WR = com.tencent.mm.plugin.sight.base.d.WR(str);
            if (WR == null) {
                AppMethodBeat.o(108995);
                return null;
            }
            if (WR.height <= 0 || WR.width <= 0) {
                try {
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    mediaMetadataRetriever.setDataSource(str);
                    WR.width = bo.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
                    WR.height = bo.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
                    WR.videoBitrate = bo.getInt(mediaMetadataRetriever.extractMetadata(20), 0);
                    mediaMetadataRetriever.release();
                } catch (Exception e) {
                }
            }
            int mp4Rotate = SightVideoJNI.getMp4Rotate(str);
            Point hy = ae.hy(ah.getContext());
            boolean z2 = mp4Rotate == 270 || mp4Rotate == 90;
            if (((double) Math.abs((((float) (z2 ? WR.height : WR.width)) / ((float) (z2 ? WR.width : WR.height))) - (((float) hy.x) / ((float) hy.y)))) > 0.01d) {
                z = false;
            }
            a aVar = new a(WR.width, WR.height, WR.eWK, mp4Rotate, WR.videoBitrate, WR.eTk, z);
            AppMethodBeat.o(108995);
            return aVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0041  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static String aak(String str) {
            Throwable th;
            com.tencent.mm.media.e.a aVar;
            AppMethodBeat.i(108996);
            j.p(str, "path");
            String str2;
            if (bo.isNullOrNil(str)) {
                str2 = "";
                AppMethodBeat.o(108996);
                return str2;
            }
            com.tencent.mm.media.e.a aVar2 = null;
            try {
                com.tencent.mm.media.e.a aVar3 = new com.tencent.mm.media.e.a(str);
                try {
                    str2 = aVar3.UV();
                    if (str2 == null) {
                        str2 = "";
                    }
                    aVar3.release();
                    AppMethodBeat.o(108996);
                    return str2;
                } catch (Exception e) {
                    aVar2 = aVar3;
                    if (aVar2 != null) {
                    }
                    str2 = "";
                    AppMethodBeat.o(108996);
                    return str2;
                } catch (Throwable th2) {
                    th = th2;
                    aVar = aVar3;
                    if (aVar != null) {
                    }
                    AppMethodBeat.o(108996);
                    throw th;
                }
            } catch (Exception e2) {
                if (aVar2 != null) {
                    aVar2.release();
                }
                str2 = "";
                AppMethodBeat.o(108996);
                return str2;
            } catch (Throwable th3) {
                th = th3;
                aVar = null;
                if (aVar != null) {
                    aVar.release();
                }
                AppMethodBeat.o(108996);
                throw th;
            }
        }
    }

    static {
        AppMethodBeat.i(108997);
        AppMethodBeat.o(108997);
    }
}
