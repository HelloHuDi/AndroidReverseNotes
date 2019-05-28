package com.tencent.mm.plugin.story.model.b;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cdv;
import com.tencent.mm.protocal.protobuf.cdw;

@l(dWo = {1, 1, 13}, dWp = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\t\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u0005¢\u0006\u0002\u0010\bJ\b\u0010F\u001a\u00020\u0013H\u0016R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001a\u0010\u001b\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001a\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010 \"\u0004\b$\u0010\"R\u001a\u0010%\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R\u001a\u0010'\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"R\u001a\u0010)\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010 \"\u0004\b*\u0010\"R\u001a\u0010+\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0015\"\u0004\b-\u0010\u0017R\u001a\u0010.\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010 \"\u0004\b0\u0010\"R\u001a\u00101\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\f\"\u0004\b3\u0010\u000eR\u001a\u00104\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\f\"\u0004\b6\u0010\u000eR\u001a\u00107\u001a\u000208X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010=\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0015\"\u0004\b?\u0010\u0017R\u001c\u0010@\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0015\"\u0004\bB\u0010\u0017R\u001a\u0010C\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0015\"\u0004\bE\u0010\u0017¨\u0006G"}, dWq = {"Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "", "commentDetail", "Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;", "(Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;)V", "commentOp", "Lcom/tencent/mm/protocal/protobuf/StoryCommentOp;", "(Lcom/tencent/mm/protocal/protobuf/StoryCommentOp;)V", "()V", "color", "", "getColor", "()I", "setColor", "(I)V", "commentId", "getCommentId", "setCommentId", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "createTime", "getCreateTime", "setCreateTime", "fromUser", "getFromUser", "setFromUser", "isBubble", "", "()Z", "setBubble", "(Z)V", "isEnhance", "setEnhance", "isSelf", "setSelf", "isStoryDeprecated", "setStoryDeprecated", "isUnread", "setUnread", "localId", "getLocalId", "setLocalId", "needShake", "getNeedShake", "setNeedShake", "replyCommentId", "getReplyCommentId", "setReplyCommentId", "state", "getState", "setState", "storyId", "", "getStoryId", "()J", "setStoryId", "(J)V", "storyOwner", "getStoryOwner", "setStoryOwner", "thumbUrl", "getThumbUrl", "setThumbUrl", "toUser", "getToUser", "setToUser", "toString", "plugin-story_release"})
public final class a {
    public String cEV;
    private int color;
    public String content;
    private String czD;
    public int fDG;
    public long rUJ;
    public int rVd;
    public boolean rVh;
    public boolean rVi;
    public boolean rVj;
    public boolean rVk;
    String rVl;
    public int rVm;
    public boolean rVn;
    public String toUser;

    public a() {
        this.cEV = "";
        this.content = "";
        this.czD = "";
        this.color = -1;
        this.toUser = "";
        this.rVl = "";
    }

    public final void aaG(String str) {
        AppMethodBeat.i(138750);
        j.p(str, "<set-?>");
        this.rVl = str;
        AppMethodBeat.o(138750);
    }

    public a(cdv cdv) {
        boolean z;
        boolean z2 = true;
        j.p(cdv, "commentDetail");
        this();
        AppMethodBeat.i(109260);
        this.rUJ = cdv.vQE;
        this.fDG = cdv.pcX;
        this.rVd = cdv.wZG;
        String str = cdv.ndG;
        if (str == null) {
            str = "";
        }
        this.cEV = str;
        str = cdv.ncM;
        if (str == null) {
            str = "";
        }
        this.content = str;
        CharSequence charSequence = cdv.ncM;
        if (charSequence == null || charSequence.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        this.rVi = z;
        if (cdv.xdB != 1) {
            z2 = false;
        }
        this.rVk = z2;
        str = cdv.ndF;
        if (str == null) {
            str = "";
        }
        this.toUser = str;
        this.rVm = cdv.wZF;
        AppMethodBeat.o(109260);
    }

    public a(cdw cdw) {
        boolean z;
        j.p(cdw, "commentOp");
        this();
        AppMethodBeat.i(109261);
        this.rUJ = cdw.rUJ;
        String str = cdw.cEV;
        if (str == null) {
            str = "";
        }
        this.cEV = str;
        str = cdw.content;
        if (str == null) {
            str = "";
        }
        this.content = str;
        this.fDG = cdw.fDG;
        CharSequence charSequence = cdw.content;
        if (charSequence == null || charSequence.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        this.rVi = z;
        str = cdw.toUser;
        if (str == null) {
            str = "";
        }
        this.toUser = str;
        str = cdw.rVl;
        if (str == null) {
            str = "";
        }
        this.rVl = str;
        this.rVm = cdw.rVm;
        this.rVn = false;
        AppMethodBeat.o(109261);
    }

    public final String toString() {
        AppMethodBeat.i(109259);
        String str = "StoryCommentItem(fromUser='" + this.cEV + "', content='" + this.content + "', createTime=" + this.fDG + ", commentId=" + this.rVd + ", isUnread=" + this.rVh + " )";
        AppMethodBeat.o(109259);
        return str;
    }
}
