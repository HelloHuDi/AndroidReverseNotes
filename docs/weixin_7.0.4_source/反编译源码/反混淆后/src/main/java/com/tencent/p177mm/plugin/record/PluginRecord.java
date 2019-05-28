package com.tencent.p177mm.plugin.record;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.bucket.C9562c;
import com.tencent.p177mm.kernel.p238a.p240b.C1655b;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p230g.p231a.C18338na;
import com.tencent.p177mm.plugin.record.p1016a.C21592a;
import com.tencent.p177mm.plugin.record.p1016a.C43427d;
import com.tencent.p177mm.plugin.record.p1016a.C43428e;
import com.tencent.p177mm.plugin.record.p1016a.C46163g;
import com.tencent.p177mm.plugin.record.p492b.C21603j;
import com.tencent.p177mm.plugin.record.p492b.C21606q;
import com.tencent.p177mm.plugin.record.p492b.C25028i;
import com.tencent.p177mm.plugin.record.p492b.C28832r;
import com.tencent.p177mm.plugin.record.p492b.C43435m;
import com.tencent.p177mm.plugin.record.p492b.C43436n;
import com.tencent.p177mm.protocal.p1338b.p1339a.C44099c;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.record.PluginRecord */
public class PluginRecord extends C7597f implements C1655b, C9562c, C21592a {
    private C46163g pIZ;
    private C43428e pJa;
    private C21606q pJb = null;
    private C25028i pJc = null;
    private C28832r pJd = new C28832r();
    private C4884c pJe = new C347911();

    /* renamed from: com.tencent.mm.plugin.record.PluginRecord$1 */
    class C347911 extends C4884c<C18338na> {
        C347911() {
            AppMethodBeat.m2504i(135608);
            this.xxI = C18338na.class.getName().hashCode();
            AppMethodBeat.m2505o(135608);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(135609);
            C18338na c18338na = (C18338na) c4883b;
            String str = c18338na.cJc.cHz;
            long j = c18338na.cJc.cuQ;
            C44099c VI = C43436n.m77547VI(str);
            str = "";
            Iterator it = VI.fjr.iterator();
            while (true) {
                String str2 = str;
                if (it.hasNext()) {
                    str = str2 + C43436n.m77558c((aar) it.next(), j) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D;
                } else {
                    c18338na.cJd.cJe = str2;
                    AppMethodBeat.m2505o(135609);
                    return true;
                }
            }
        }
    }

    public PluginRecord() {
        AppMethodBeat.m2504i(135610);
        AppMethodBeat.m2505o(135610);
    }

    private static void checkDir() {
        AppMethodBeat.m2504i(135611);
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3537RQ();
        File file = new File(stringBuilder.append(C1720g.m3536RP().eJM).append("record/").toString());
        if (!(file.exists() && file.isDirectory())) {
            C4990ab.m7410d("MicroMsg.PluginRecord", "record stg dir[%s] not exsit, create it");
            file.mkdirs();
        }
        AppMethodBeat.m2505o(135611);
    }

    public void parallelsDependency() {
    }

    public void onAccountInitialized(C1705c c1705c) {
        AppMethodBeat.m2504i(135612);
        this.pIZ = new C43435m(C1720g.m3536RP().eJN);
        this.pJa = new C21603j(C1720g.m3536RP().eJN);
        C4990ab.m7416i("MicroMsg.PluginRecord", "on account post reset");
        C4879a.xxA.mo10052c(this.pJd);
        C4879a.xxA.mo10052c(this.pJe);
        PluginRecord.checkDir();
        getRecordMsgService().mo25040a(null);
        C4990ab.m7416i("MicroMsg.PluginRecord", "onAccountInitialized start recordMsgSendService");
        AppMethodBeat.m2505o(135612);
    }

    public void onAccountRelease() {
        AppMethodBeat.m2504i(135613);
        C4990ab.m7410d("MicroMsg.PluginRecord", "on account post release");
        C4879a.xxA.mo10053d(this.pJd);
        C4879a.xxA.mo10053d(this.pJe);
        if (this.pJb != null) {
            C43427d c43427d = this.pJb;
            c43427d.finish();
            C1720g.m3535RO().eJo.mo14546b(632, (C1202f) c43427d);
            ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage().mo37083b(c43427d);
        }
        if (this.pJc != null) {
            this.pJc.finish();
        }
        AppMethodBeat.m2505o(135613);
    }

    public void execute(C1681g c1681g) {
    }

    public C43428e getRecordMsgCDNStorage() {
        return this.pJa;
    }

    public C46163g getRecordMsgInfoStorage() {
        return this.pIZ;
    }

    public C46163g getRecordMsgStorage() {
        AppMethodBeat.m2504i(135614);
        C46163g recordMsgInfoStorage = getRecordMsgInfoStorage();
        AppMethodBeat.m2505o(135614);
        return recordMsgInfoStorage;
    }

    public C21606q getRecordMsgService() {
        AppMethodBeat.m2504i(135615);
        C1720g.m3534RN().mo5159QU();
        if (this.pJb == null) {
            this.pJb = new C21606q();
        }
        C21606q c21606q = this.pJb;
        AppMethodBeat.m2505o(135615);
        return c21606q;
    }

    public C25028i getRecordMsgCDNService() {
        AppMethodBeat.m2504i(135616);
        C1720g.m3534RN().mo5159QU();
        if (this.pJc == null) {
            this.pJc = new C25028i();
        }
        C25028i c25028i = this.pJc;
        AppMethodBeat.m2505o(135616);
        return c25028i;
    }
}
