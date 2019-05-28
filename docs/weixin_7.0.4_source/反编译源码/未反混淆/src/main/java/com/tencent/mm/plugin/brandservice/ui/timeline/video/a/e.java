package com.tencent.mm.plugin.brandservice.ui.timeline.video.a;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.b;
import com.tencent.mm.protocal.protobuf.dx;
import com.tencent.mm.protocal.protobuf.dy;
import com.tencent.mm.protocal.protobuf.ea;
import com.tencent.mm.protocal.protobuf.to;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.s;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

@l(dWo = {1, 1, 13}, dWp = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002J\u000e\u0010\u001c\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000eJ\u001e\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002J\u000e\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\u0016J\u0016\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u001fJ\b\u0010'\u001a\u00020\u0016H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R6\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007`\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006("}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPDataReportHelper;", "", "()V", "TAG", "", "commentExposureMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/CommentExposure;", "Lkotlin/collections/HashMap;", "getCommentExposureMap", "()Ljava/util/HashMap;", "setCommentExposureMap", "(Ljava/util/HashMap;)V", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoController;", "enterTimeInMs", "", "getEnterTimeInMs", "()J", "setEnterTimeInMs", "(J)V", "addCommReportItem", "", "key", "value", "items", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommReportItem;", "init", "logReportData", "kv", "", "onCommentExposure", "comment", "Lcom/tencent/mm/protocal/protobuf/BizComment;", "onDestroy", "report10380", "actionType", "sharePageType", "report10945", "plugin-brandservice_release"})
public final class e {
    private final String TAG = "MicroMsg.MPDataReportHelper";
    public b jWx;
    public HashMap<String, to> jYB = new HashMap();
    public long jYC = System.currentTimeMillis();

    public e() {
        AppMethodBeat.i(15329);
        AppMethodBeat.o(15329);
    }

    public final void sF(int i) {
        AppMethodBeat.i(15326);
        dy dyVar = new dy();
        dx dxVar = new dx();
        dxVar.type = 2;
        String str = "Vid";
        b bVar = this.jWx;
        if (bVar == null) {
            j.avw("controller");
        }
        String str2 = bVar.fgd;
        LinkedList linkedList = dxVar.vCQ;
        j.o(linkedList, "reportData.item");
        a(str, str2, linkedList);
        str2 = at.gB(ah.getContext());
        linkedList = dxVar.vCQ;
        j.o(linkedList, "reportData.item");
        a("Network", str2, linkedList);
        linkedList = dxVar.vCQ;
        j.o(linkedList, "reportData.item");
        a("SharePageType", "2", linkedList);
        str = "ContentUrl";
        bVar = this.jWx;
        if (bVar == null) {
            j.avw("controller");
        }
        str2 = bVar.url;
        linkedList = dxVar.vCQ;
        j.o(linkedList, "reportData.item");
        a(str, str2, linkedList);
        str2 = s.getSessionId();
        linkedList = dxVar.vCQ;
        j.o(linkedList, "reportData.item");
        a("SessionId", str2, linkedList);
        str = "EnterId";
        bVar = this.jWx;
        if (bVar == null) {
            j.avw("controller");
        }
        str2 = String.valueOf(bVar.jVF);
        linkedList = dxVar.vCQ;
        j.o(linkedList, "reportData.item");
        a(str, str2, linkedList);
        linkedList = dxVar.vCQ;
        j.o(linkedList, "reportData.item");
        a("NativePage", "1", linkedList);
        str = "#AppMsgUrl#";
        bVar = this.jWx;
        if (bVar == null) {
            j.avw("controller");
        }
        str2 = bVar.url;
        linkedList = dxVar.vCQ;
        j.o(linkedList, "reportData.item");
        a(str, str2, linkedList);
        str2 = String.valueOf(i);
        linkedList = dxVar.vCQ;
        j.o(linkedList, "reportData.item");
        a("ActionType", str2, linkedList);
        dyVar.vFM.add(dxVar);
        b bVar2 = this.jWx;
        if (bVar2 == null) {
            j.avw("controller");
        }
        bVar2.a(dyVar);
        LinkedList linkedList2 = dxVar.vCQ;
        j.o(linkedList2, "reportData.item");
        b(10380, linkedList2);
        AppMethodBeat.o(15326);
    }

    public final void b(int i, LinkedList<ea> linkedList) {
        AppMethodBeat.i(15327);
        if (ab.getLogLevel() <= 0 && !bo.ek(linkedList)) {
            StringBuilder stringBuilder = new StringBuilder();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                ea eaVar = (ea) it.next();
                stringBuilder.append(eaVar.key).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(eaVar.fns).append("  ");
            }
            ab.v(this.TAG, i + ", " + stringBuilder);
        }
        AppMethodBeat.o(15327);
    }

    public static void a(String str, String str2, LinkedList<ea> linkedList) {
        AppMethodBeat.i(15328);
        ea eaVar = new ea();
        eaVar.key = str;
        eaVar.fns = str2;
        linkedList.add(eaVar);
        AppMethodBeat.o(15328);
    }
}
