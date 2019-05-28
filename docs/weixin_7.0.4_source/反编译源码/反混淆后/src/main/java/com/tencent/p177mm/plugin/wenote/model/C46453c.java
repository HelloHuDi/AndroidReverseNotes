package com.tencent.p177mm.plugin.wenote.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C45439bw;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C26083af;
import com.tencent.p177mm.p230g.p231a.C32512ae;
import com.tencent.p177mm.plugin.fav.p407a.C11851an;
import com.tencent.p177mm.plugin.fav.p407a.C7604ae;
import com.tencent.p177mm.plugin.record.p1016a.C21592a;
import com.tencent.p177mm.plugin.wenote.p1564a.C40364b;
import com.tencent.p177mm.plugin.wenote.p1564a.C43997a;
import com.tencent.p177mm.plugin.wenote.p1564a.C44793c;
import com.tencent.p177mm.plugin.wenote.p587ui.nativenote.C23191b;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5736j;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.wenote.model.c */
public final class C46453c implements C1816at {
    private static HashMap<Integer, C1366d> eaA = new HashMap();
    private C4884c gRa = new C231811();
    private C40364b uMK = new C40364b();
    private C44793c uML = new C44793c();
    private C43997a uMM = new C43997a();
    public C40369d uMN = null;

    /* renamed from: com.tencent.mm.plugin.wenote.model.c$1 */
    class C231811 extends C4884c<C32512ae> {
        C231811() {
            AppMethodBeat.m2504i(26598);
            this.xxI = C32512ae.class.getName().hashCode();
            AppMethodBeat.m2505o(26598);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(26599);
            C26083af c26083af = new C26083af();
            c26083af.csZ.ctb = new C23191b(C4996ah.getContext());
            C4879a.xxA.mo10055m(c26083af);
            AppMethodBeat.m2505o(26599);
            return false;
        }
    }

    public C46453c() {
        AppMethodBeat.m2504i(26600);
        AppMethodBeat.m2505o(26600);
    }

    public static C46453c ddG() {
        AppMethodBeat.m2504i(26601);
        C9638aw.m17184ZE();
        C46453c c46453c = (C46453c) C45439bw.m83697oJ("plugin.wenote");
        if (c46453c == null) {
            c46453c = new C46453c();
            C9638aw.m17184ZE().mo73244a("plugin.wenote", c46453c);
        }
        AppMethodBeat.m2505o(26601);
        return c46453c;
    }

    static {
        AppMethodBeat.m2504i(26604);
        AppMethodBeat.m2505o(26604);
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return eaA;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        Closeable open;
        OutputStream outputStream = null;
        AppMethodBeat.m2504i(26602);
        C4990ab.m7410d("MicroMsg.SubCoreWNNoteMsg", "on account post reset");
        C4879a.xxA.mo10052c(this.uMK);
        ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage().mo37080a(this.uML);
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15157a(this.uML);
        C4879a.xxA.mo10052c(this.uMM);
        C4879a.xxA.mo10052c(this.gRa);
        C5728b c5728b = new C5728b(C14723i.m22925Yi());
        if (!(c5728b.exists() && c5728b.isDirectory())) {
            C4990ab.m7410d("MicroMsg.SubCoreWNNoteMsg", "record stg dir[%s] not exsit, create it");
            c5728b.mkdirs();
        }
        C5728b c5728b2 = new C5728b(C11851an.bvi());
        C4990ab.m7417i("MicroMsg.SubCoreWNNoteMsg", "copy to path %s", C5736j.m8649w(c5728b2.dMD()));
        if (C7243d.vxr) {
            C4990ab.m7416i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile develop version delete template");
            C5730e.m8618N(C5736j.m8649w(c5728b2.mUri), true);
        } else {
            C11851an.mgz = C11851an.afW();
            if (z) {
                C4990ab.m7417i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile need update assetVersion=%d currentVersion=%d", Integer.valueOf(C11851an.afX()), Integer.valueOf(C11851an.mgz));
                if (C11851an.mgz < C11851an.afX()) {
                    C5730e.m8618N(C5736j.m8649w(c5728b2.mUri), true);
                }
            } else if (C11851an.mgz == 1) {
                C4990ab.m7416i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile need init template");
                C5730e.m8618N(C5736j.m8649w(c5728b2.mUri), true);
            } else {
                C4990ab.m7417i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile currentVersion=%d", Integer.valueOf(C11851an.mgz));
            }
        }
        if (!c5728b2.exists()) {
            c5728b2.mkdirs();
        }
        try {
            open = C4996ah.getContext().getAssets().open("WNNote.zip");
        } catch (IOException e) {
            C4990ab.printErrStackTrace("MicroMsg.SubCoreWNNoteMsg", e, "", new Object[0]);
            open = null;
        }
        if (open == null) {
            C4990ab.m7412e("MicroMsg.SubCoreWNNoteMsg", "file inputStream not found");
            AppMethodBeat.m2505o(26602);
            return;
        }
        C5728b c5728b3 = new C5728b(c5728b2, "WNNote.zip");
        if (c5728b3.exists()) {
            C4990ab.m7416i("MicroMsg.SubCoreWNNoteMsg", "wenote template already exists");
            C5046bo.m7527b(open);
            AppMethodBeat.m2505o(26602);
            return;
        }
        try {
            outputStream = C5730e.m8641q(c5728b3);
        } catch (FileNotFoundException e2) {
            C4990ab.printErrStackTrace("MicroMsg.SubCoreWNNoteMsg", e2, "", new Object[0]);
        }
        if (outputStream != null) {
            try {
                byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                while (true) {
                    int read = open.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    outputStream.write(bArr, 0, read);
                }
            } catch (IOException e3) {
                C4990ab.printErrStackTrace("MicroMsg.SubCoreWNNoteMsg", e3, "", new Object[0]);
            }
        }
        C5046bo.m7527b(open);
        C5046bo.m7527b(outputStream);
        int iu = C5730e.m8636iu(C5736j.m8649w(c5728b3.dMD()), c5728b3.getParent());
        if (iu < 0) {
            C4990ab.m7412e("MicroMsg.SubCoreWNNoteMsg", "unzip fail, ret = " + iu + ", zipFilePath = " + C5736j.m8649w(c5728b3.dMD()) + ", unzipPath = " + c5728b3.getParent());
        }
        AppMethodBeat.m2505o(26602);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(26603);
        C4990ab.m7410d("MicroMsg.SubCoreWNNoteMsg", "on account post release");
        C4879a.xxA.mo10053d(this.uMK);
        if (((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage() != null) {
            ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage().mo37083b(this.uML);
        }
        if (((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage() != null) {
            ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15159b(this.uML);
        }
        C4879a.xxA.mo10053d(this.uMM);
        C4879a.xxA.mo10053d(this.gRa);
        AppMethodBeat.m2505o(26603);
    }
}
