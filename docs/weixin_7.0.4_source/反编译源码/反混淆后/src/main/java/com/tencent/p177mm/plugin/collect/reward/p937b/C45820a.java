package com.tencent.p177mm.plugin.collect.reward.p937b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.p248j.C1761b;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p187al.C37458c;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.p235i.C42130g;
import com.tencent.p177mm.p235i.C42130g.C1628a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.collect.reward.b.a */
public final class C45820a implements C1628a {
    private static final String kDC = (C1761b.eSj + "wallet/img/");
    private static C45820a kDD;
    private String filename;
    public Map<String, C11433a> jxd;

    /* renamed from: com.tencent.mm.plugin.collect.reward.b.a$a */
    public interface C11433a {
        /* renamed from: P */
        void mo23175P(String str, int i, int i2);
    }

    static {
        AppMethodBeat.m2504i(41061);
        AppMethodBeat.m2505o(41061);
    }

    public static C45820a bgS() {
        AppMethodBeat.m2504i(41055);
        if (kDD == null) {
            kDD = new C45820a();
        }
        C45820a c45820a = kDD;
        AppMethodBeat.m2505o(41055);
        return c45820a;
    }

    /* renamed from: a */
    public final boolean mo73622a(String str, String str2, C11433a c11433a) {
        AppMethodBeat.m2504i(41056);
        C4990ab.m7417i("MicroMsg.QrRewardCdnDownloadHelper", "downloadImage. imageId:%s", str);
        File file = new File(kDC);
        if (!file.exists()) {
            file.mkdirs();
        }
        C42130g c42130g = new C42130g();
        c42130g.cRY = false;
        c42130g.egl = this;
        c42130g.field_fullpath = kDC + bgU();
        c42130g.field_mediaId = C5046bo.nullAsNil(C37458c.m63162a("QrRewardImg", C5046bo.anU(), C1853r.m3850Zd().field_username, ""));
        c42130g.field_fileId = str;
        c42130g.field_aesKey = str2;
        c42130g.field_fileType = C42129a.MediaType_FILE;
        c42130g.field_priority = C42129a.efC;
        c42130g.field_needStorage = false;
        c42130g.field_isStreamMedia = false;
        c42130g.field_appType = 0;
        c42130g.field_bzScene = 0;
        if (this.jxd == null) {
            this.jxd = new HashMap();
        }
        this.jxd.put(c42130g.field_mediaId, c11433a);
        if (C37461f.afx().mo51222b(c42130g, -1)) {
            AppMethodBeat.m2505o(41056);
            return true;
        }
        C4990ab.m7413e("MicroMsg.QrRewardCdnDownloadHelper", "ljd: cdntra addSendTask failed. imageId:%s", str);
        AppMethodBeat.m2505o(41056);
        return false;
    }

    public final boolean bgT() {
        AppMethodBeat.m2504i(41057);
        boolean exists = new File(kDC + bgU()).exists();
        AppMethodBeat.m2505o(41057);
        return exists;
    }

    private String bgU() {
        AppMethodBeat.m2504i(41058);
        if (C5046bo.isNullOrNil(this.filename)) {
            this.filename = C4995ag.m7428ck(C1853r.m3846Yz() + "_reward_img");
        }
        String str = this.filename;
        AppMethodBeat.m2505o(41058);
        return str;
    }

    public final String bgV() {
        AppMethodBeat.m2504i(41059);
        String str = kDC + bgU();
        AppMethodBeat.m2505o(41059);
        return str;
    }

    /* renamed from: a */
    public final int mo5082a(final String str, final int i, C18496c c18496c, final C9545d c9545d, boolean z) {
        AppMethodBeat.m2504i(41060);
        C4990ab.m7417i("MicroMsg.QrRewardCdnDownloadHelper", "cdn callback, id: %s, ret: %s, sceneResult: %s", str, Integer.valueOf(i), c9545d);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(41054);
                C11433a c11433a = (C11433a) C45820a.this.jxd.get(str);
                if (c11433a == null) {
                    C4990ab.m7420w("MicroMsg.QrRewardCdnDownloadHelper", "no callback");
                    AppMethodBeat.m2505o(41054);
                } else if (c9545d != null) {
                    c11433a.mo23175P(str, i, c9545d.field_retCode);
                    C45820a.this.jxd.remove(str);
                    if (c9545d.field_retCode == 0) {
                        C7060h.pYm.mo8378a(724, 8, 1, false);
                        AppMethodBeat.m2505o(41054);
                        return;
                    }
                    C7060h.pYm.mo8378a(724, 9, 1, false);
                    AppMethodBeat.m2505o(41054);
                } else {
                    C4990ab.m7418v("MicroMsg.QrRewardCdnDownloadHelper", "download is not end");
                    AppMethodBeat.m2505o(41054);
                }
            }
        });
        AppMethodBeat.m2505o(41060);
        return 0;
    }

    /* renamed from: a */
    public final void mo5083a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    /* renamed from: l */
    public final byte[] mo5084l(String str, byte[] bArr) {
        return new byte[0];
    }
}
