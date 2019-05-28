package com.tencent.mm.plugin.story.model.d;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cee;
import com.tencent.mm.protocal.protobuf.cei;
import com.tencent.mm.protocal.protobuf.cek;

@l(dWo = {1, 1, 13}, dWp = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u00102\u001a\u000203J\u0013\u00104\u001a\u0002032\b\u00105\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u00106\u001a\u00020\u0003H\u0016J\u0006\u00107\u001a\u000203J\u0006\u00108\u001a\u000203J\b\u00109\u001a\u00020\bH\u0016R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010#\"\u0004\b&\u0010'R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020-X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u0006:"}, dWq = {"Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "", "localId", "", "storyId", "", "createTime", "username", "", "(IJILjava/lang/String;)V", "getCreateTime", "()I", "setCreateTime", "(I)V", "fakeVideoData", "Lcom/tencent/mm/protocal/protobuf/StoryEditorProtoData;", "getFakeVideoData", "()Lcom/tencent/mm/protocal/protobuf/StoryEditorProtoData;", "setFakeVideoData", "(Lcom/tencent/mm/protocal/protobuf/StoryEditorProtoData;)V", "getLocalId", "setLocalId", "location", "Lcom/tencent/mm/protocal/protobuf/StoryLocation;", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/StoryLocation;", "setLocation", "(Lcom/tencent/mm/protocal/protobuf/StoryLocation;)V", "media", "Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "getMedia", "()Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "setMedia", "(Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;)V", "getStoryId", "()J", "timeStamp", "getTimeStamp", "setTimeStamp", "(J)V", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "videoType", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoState;", "getVideoType", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoState;", "setVideoType", "(Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoState;)V", "canPlay", "", "equals", "other", "hashCode", "isFakeVideo", "isNormalVideo", "toString", "plugin-story_release"})
public final class i {
    public int cNE;
    public int fDG;
    public final long rUJ;
    j rWi = j.Normal;
    public cek rWj;
    cei rWk;
    public cee rWl;
    public long timeStamp;
    public String username;

    public i(int i, long j, int i2, String str) {
        j.p(str, "username");
        AppMethodBeat.i(109323);
        this.cNE = i;
        this.rUJ = j;
        this.fDG = i2;
        this.username = str;
        cek cek = new cek();
        cek.Url = "";
        cek.wEH = "";
        cek.Id = "";
        this.rWj = cek;
        AppMethodBeat.o(109323);
    }

    private boolean czd() {
        return this.rWi == j.Normal;
    }

    public final boolean cze() {
        return this.rWi == j.Fake;
    }

    public final boolean czf() {
        return this.rWi != j.Empty;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(109320);
        if (!(obj instanceof i)) {
            AppMethodBeat.o(109320);
            return false;
        } else if (this == obj) {
            AppMethodBeat.o(109320);
            return true;
        } else if (this.rWi == j.Empty && ((i) obj).rWi == j.Empty) {
            AppMethodBeat.o(109320);
            return true;
        } else if (cze() && ((i) obj).cze() && this.timeStamp == ((i) obj).timeStamp) {
            AppMethodBeat.o(109320);
            return true;
        } else if (czd() && ((i) obj).czd() && this.cNE == ((i) obj).cNE) {
            AppMethodBeat.o(109320);
            return true;
        } else {
            AppMethodBeat.o(109320);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(109321);
        int hashCode = super.hashCode();
        AppMethodBeat.o(109321);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(109322);
        String str = "[VideoItem=" + hashCode() + ",localId=:" + this.cNE + ",storyId=" + this.rUJ + ",videoType:=" + this.rWi + ", username=" + this.username + ", url=" + this.rWj.Url + ']';
        AppMethodBeat.o(109322);
        return str;
    }
}
