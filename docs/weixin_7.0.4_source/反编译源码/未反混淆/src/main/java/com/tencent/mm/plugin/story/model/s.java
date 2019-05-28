package com.tencent.mm.plugin.story.model;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.c;
import com.tencent.mm.plugin.story.h.n;
import com.tencent.mm.plugin.story.model.d.i;
import com.tencent.mm.plugin.story.model.j.a;
import com.tencent.mm.protocal.protobuf.cee;
import com.tencent.mm.protocal.protobuf.cek;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;

@l(dWo = {1, 1, 13}, dWp = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0015\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0017\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004J\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u001b"}, dWq = {"Lcom/tencent/mm/plugin/story/model/StoryVideoLogic;", "", "()V", "STORY_VIDEO_PREFIX", "", "TAG", "createForFake", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCache;", "videoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "createForPost", "", "storyId", "", "media", "Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "username", "genCdnMediaId", "createTime", "", "url", "genFileName", "snsLocalId", "getOrCreate", "getStoryVideoDir", "getStoryVideoPath", "getStoryVideoTmpPath", "plugin-story_release"})
public final class s {
    private static final String TAG = TAG;
    private static final String rTU = rTU;
    public static final s rTV = new s();

    static {
        AppMethodBeat.i(109170);
        AppMethodBeat.o(109170);
    }

    private s() {
    }

    public static String be(int i, String str) {
        String concat;
        AppMethodBeat.i(109165);
        if (str == null) {
            concat = "story_local_video_".concat(String.valueOf(i));
        } else {
            concat = c.a("storyvideo", (long) i, "story", str);
        }
        if (bo.isNullOrNil(concat)) {
            AppMethodBeat.o(109165);
            return null;
        }
        AppMethodBeat.o(109165);
        return concat;
    }

    public static String aaF(String str) {
        AppMethodBeat.i(109166);
        l lVar = l.rTg;
        ab.i(TAG, "get story video dir %s username %s", l.aar(str) + "/video/", str);
        AppMethodBeat.o(109166);
        return l.aar(str) + "/video/";
    }

    public static String a(cek cek, String str) {
        AppMethodBeat.i(109167);
        if (cek == null) {
            AppMethodBeat.o(109167);
            return null;
        }
        l lVar = l.rTg;
        ab.i(TAG, "get story video path %s", l.gy(cek.Url, str));
        AppMethodBeat.o(109167);
        return l.gy(cek.Url, str);
    }

    public static String a(cek cek) {
        AppMethodBeat.i(109168);
        if (cek == null) {
            AppMethodBeat.o(109168);
            return null;
        }
        l lVar = l.rTg;
        String aat = l.aat(cek.Id);
        AppMethodBeat.o(109168);
        return aat;
    }

    public static n a(i iVar) {
        AppMethodBeat.i(109169);
        j.p(iVar, "videoItem");
        String str;
        n nVar;
        if (iVar.cze()) {
            j.p(iVar, "videoItem");
            cee cee = iVar.rWl;
            str = cee != null ? cee.videoPath : null;
            int asZ = (int) e.asZ(str);
            nVar = new n();
            nVar.field_storyId = iVar.rUJ;
            nVar.field_url = "";
            nVar.field_cacheSize = asZ;
            nVar.field_totalSize = asZ;
            nVar.field_filePath = str;
            AppMethodBeat.o(109169);
            return nVar;
        }
        int i;
        String a = a(iVar.rWj, iVar.username);
        l lVar = l.rTg;
        if (a == null) {
            str = "";
        } else {
            str = a;
        }
        l.aax(str);
        a aVar = j.rST;
        n lz = a.cxX().lz(iVar.rUJ);
        if (lz == null) {
            lz = new n();
            lz.field_storyId = iVar.rUJ;
            lz.field_url = iVar.rWj.Url;
            lz.field_cacheSize = 0;
            lz.field_totalSize = 0;
            lz.field_filePath = a;
            a aVar2 = j.rST;
            a.cxX().a(lz);
            nVar = lz;
        } else {
            nVar = lz;
        }
        CharSequence charSequence = nVar.field_filePath;
        if (charSequence == null || charSequence.length() == 0) {
            i = 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            nVar.field_filePath = a;
        }
        AppMethodBeat.o(109169);
        return nVar;
    }
}
