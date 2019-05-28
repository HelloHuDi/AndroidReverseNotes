package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.video.p929a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.video.C45767b;
import com.tencent.p177mm.protocal.protobuf.C15331ea;
import com.tencent.p177mm.protocal.protobuf.C23382dx;
import com.tencent.p177mm.protocal.protobuf.C23383dy;
import com.tencent.p177mm.protocal.protobuf.C30227to;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C30309s;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002J\u000e\u0010\u001c\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000eJ\u001e\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002J\u000e\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\u0016J\u0016\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u001fJ\b\u0010'\u001a\u00020\u0016H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R6\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007`\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006("}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPDataReportHelper;", "", "()V", "TAG", "", "commentExposureMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/CommentExposure;", "Lkotlin/collections/HashMap;", "getCommentExposureMap", "()Ljava/util/HashMap;", "setCommentExposureMap", "(Ljava/util/HashMap;)V", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoController;", "enterTimeInMs", "", "getEnterTimeInMs", "()J", "setEnterTimeInMs", "(J)V", "addCommReportItem", "", "key", "value", "items", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommReportItem;", "init", "logReportData", "kv", "", "onCommentExposure", "comment", "Lcom/tencent/mm/protocal/protobuf/BizComment;", "onDestroy", "report10380", "actionType", "sharePageType", "report10945", "plugin-brandservice_release"})
/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.a.e */
public final class C38715e {
    private final String TAG = "MicroMsg.MPDataReportHelper";
    public C45767b jWx;
    public HashMap<String, C30227to> jYB = new HashMap();
    public long jYC = System.currentTimeMillis();

    public C38715e() {
        AppMethodBeat.m2504i(15329);
        AppMethodBeat.m2505o(15329);
    }

    /* renamed from: sF */
    public final void mo61573sF(int i) {
        AppMethodBeat.m2504i(15326);
        C23383dy c23383dy = new C23383dy();
        C23382dx c23382dx = new C23382dx();
        c23382dx.type = 2;
        String str = "Vid";
        C45767b c45767b = this.jWx;
        if (c45767b == null) {
            C25052j.avw("controller");
        }
        String str2 = c45767b.fgd;
        LinkedList linkedList = c23382dx.vCQ;
        C25052j.m39375o(linkedList, "reportData.item");
        C38715e.m65664a(str, str2, linkedList);
        str2 = C5023at.m7471gB(C4996ah.getContext());
        linkedList = c23382dx.vCQ;
        C25052j.m39375o(linkedList, "reportData.item");
        C38715e.m65664a("Network", str2, linkedList);
        linkedList = c23382dx.vCQ;
        C25052j.m39375o(linkedList, "reportData.item");
        C38715e.m65664a("SharePageType", "2", linkedList);
        str = "ContentUrl";
        c45767b = this.jWx;
        if (c45767b == null) {
            C25052j.avw("controller");
        }
        str2 = c45767b.url;
        linkedList = c23382dx.vCQ;
        C25052j.m39375o(linkedList, "reportData.item");
        C38715e.m65664a(str, str2, linkedList);
        str2 = C30309s.getSessionId();
        linkedList = c23382dx.vCQ;
        C25052j.m39375o(linkedList, "reportData.item");
        C38715e.m65664a("SessionId", str2, linkedList);
        str = "EnterId";
        c45767b = this.jWx;
        if (c45767b == null) {
            C25052j.avw("controller");
        }
        str2 = String.valueOf(c45767b.jVF);
        linkedList = c23382dx.vCQ;
        C25052j.m39375o(linkedList, "reportData.item");
        C38715e.m65664a(str, str2, linkedList);
        linkedList = c23382dx.vCQ;
        C25052j.m39375o(linkedList, "reportData.item");
        C38715e.m65664a("NativePage", "1", linkedList);
        str = "#AppMsgUrl#";
        c45767b = this.jWx;
        if (c45767b == null) {
            C25052j.avw("controller");
        }
        str2 = c45767b.url;
        linkedList = c23382dx.vCQ;
        C25052j.m39375o(linkedList, "reportData.item");
        C38715e.m65664a(str, str2, linkedList);
        str2 = String.valueOf(i);
        linkedList = c23382dx.vCQ;
        C25052j.m39375o(linkedList, "reportData.item");
        C38715e.m65664a("ActionType", str2, linkedList);
        c23383dy.vFM.add(c23382dx);
        C45767b c45767b2 = this.jWx;
        if (c45767b2 == null) {
            C25052j.avw("controller");
        }
        c45767b2.mo73553a(c23383dy);
        LinkedList linkedList2 = c23382dx.vCQ;
        C25052j.m39375o(linkedList2, "reportData.item");
        mo61572b(10380, linkedList2);
        AppMethodBeat.m2505o(15326);
    }

    /* renamed from: b */
    public final void mo61572b(int i, LinkedList<C15331ea> linkedList) {
        AppMethodBeat.m2504i(15327);
        if (C4990ab.getLogLevel() <= 0 && !C5046bo.m7548ek(linkedList)) {
            StringBuilder stringBuilder = new StringBuilder();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                C15331ea c15331ea = (C15331ea) it.next();
                stringBuilder.append(c15331ea.key).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(c15331ea.fns).append("  ");
            }
            C4990ab.m7418v(this.TAG, i + ", " + stringBuilder);
        }
        AppMethodBeat.m2505o(15327);
    }

    /* renamed from: a */
    public static void m65664a(String str, String str2, LinkedList<C15331ea> linkedList) {
        AppMethodBeat.m2504i(15328);
        C15331ea c15331ea = new C15331ea();
        c15331ea.key = str;
        c15331ea.fns = str2;
        linkedList.add(c15331ea);
        AppMethodBeat.m2505o(15328);
    }
}
