package com.tencent.p177mm.plugin.story.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p187al.C37458c;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.plugin.story.model.p533d.C35201i;
import com.tencent.p177mm.plugin.story.p532h.C29298n;
import com.tencent.p177mm.protocal.protobuf.cee;
import com.tencent.p177mm.protocal.protobuf.cek;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0015\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0017\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004J\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u001b"}, dWq = {"Lcom/tencent/mm/plugin/story/model/StoryVideoLogic;", "", "()V", "STORY_VIDEO_PREFIX", "", "TAG", "createForFake", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCache;", "videoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "createForPost", "", "storyId", "", "media", "Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "username", "genCdnMediaId", "createTime", "", "url", "genFileName", "snsLocalId", "getOrCreate", "getStoryVideoDir", "getStoryVideoPath", "getStoryVideoTmpPath", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.model.s */
public final class C43649s {
    private static final String TAG = TAG;
    private static final String rTU = rTU;
    public static final C43649s rTV = new C43649s();

    static {
        AppMethodBeat.m2504i(109170);
        AppMethodBeat.m2505o(109170);
    }

    private C43649s() {
    }

    /* renamed from: be */
    public static String m78156be(int i, String str) {
        String concat;
        AppMethodBeat.m2504i(109165);
        if (str == null) {
            concat = "story_local_video_".concat(String.valueOf(i));
        } else {
            concat = C37458c.m63162a("storyvideo", (long) i, "story", str);
        }
        if (C5046bo.isNullOrNil(concat)) {
            AppMethodBeat.m2505o(109165);
            return null;
        }
        AppMethodBeat.m2505o(109165);
        return concat;
    }

    public static String aaF(String str) {
        AppMethodBeat.m2504i(109166);
        C29309l c29309l = C29309l.rTg;
        C4990ab.m7417i(TAG, "get story video dir %s username %s", C29309l.aar(str) + "/video/", str);
        AppMethodBeat.m2505o(109166);
        return C29309l.aar(str) + "/video/";
    }

    /* renamed from: a */
    public static String m78155a(cek cek, String str) {
        AppMethodBeat.m2504i(109167);
        if (cek == null) {
            AppMethodBeat.m2505o(109167);
            return null;
        }
        C29309l c29309l = C29309l.rTg;
        C4990ab.m7417i(TAG, "get story video path %s", C29309l.m46529gy(cek.Url, str));
        AppMethodBeat.m2505o(109167);
        return C29309l.m46529gy(cek.Url, str);
    }

    /* renamed from: a */
    public static String m78154a(cek cek) {
        AppMethodBeat.m2504i(109168);
        if (cek == null) {
            AppMethodBeat.m2505o(109168);
            return null;
        }
        C29309l c29309l = C29309l.rTg;
        String aat = C29309l.aat(cek.f4416Id);
        AppMethodBeat.m2505o(109168);
        return aat;
    }

    /* renamed from: a */
    public static C29298n m78153a(C35201i c35201i) {
        AppMethodBeat.m2504i(109169);
        C25052j.m39376p(c35201i, "videoItem");
        String str;
        C29298n c29298n;
        if (c35201i.cze()) {
            C25052j.m39376p(c35201i, "videoItem");
            cee cee = c35201i.rWl;
            str = cee != null ? cee.videoPath : null;
            int asZ = (int) C5730e.asZ(str);
            c29298n = new C29298n();
            c29298n.field_storyId = c35201i.rUJ;
            c29298n.field_url = "";
            c29298n.field_cacheSize = asZ;
            c29298n.field_totalSize = asZ;
            c29298n.field_filePath = str;
            AppMethodBeat.m2505o(109169);
            return c29298n;
        }
        int i;
        String a = C43649s.m78155a(c35201i.rWj, c35201i.username);
        C29309l c29309l = C29309l.rTg;
        if (a == null) {
            str = "";
        } else {
            str = a;
        }
        C29309l.aax(str);
        C4133a c4133a = C43644j.rST;
        C29298n lz = C4133a.cxX().mo25976lz(c35201i.rUJ);
        if (lz == null) {
            lz = new C29298n();
            lz.field_storyId = c35201i.rUJ;
            lz.field_url = c35201i.rWj.Url;
            lz.field_cacheSize = 0;
            lz.field_totalSize = 0;
            lz.field_filePath = a;
            C4133a c4133a2 = C43644j.rST;
            C4133a.cxX().mo25973a(lz);
            c29298n = lz;
        } else {
            c29298n = lz;
        }
        CharSequence charSequence = c29298n.field_filePath;
        if (charSequence == null || charSequence.length() == 0) {
            i = 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            c29298n.field_filePath = a;
        }
        AppMethodBeat.m2505o(109169);
        return c29298n;
    }
}
