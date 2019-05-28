package com.tencent.p177mm.plugin.webview.p1068e;

import android.arch.lifecycle.MutableLiveData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p187al.C37458c;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.p235i.C42130g;
import com.tencent.p177mm.p235i.C42130g.C1628a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.plugin.webview.model.C43917h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.webview.e.b */
public final class C43865b {
    String appId;
    public String hWL;
    private C22785a uKL = new C22785a(this, (byte) 0);
    Map<String, String> uKM = new HashMap();
    public MutableLiveData<String> uKN = new MutableLiveData();
    public C29765b uKO = C29765b.NONE;

    /* renamed from: com.tencent.mm.plugin.webview.e.b$a */
    class C22785a implements C1628a {
        private C22785a() {
        }

        /* synthetic */ C22785a(C43865b c43865b, byte b) {
            this();
        }

        /* renamed from: a */
        public final int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z) {
            AppMethodBeat.m2504i(10132);
            C4990ab.m7411d("MicroMsg.VestImgUploadEngine", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i), c18496c, c9545d);
            synchronized (C43865b.this) {
                if (c9545d != null) {
                    try {
                        if (c9545d.field_retCode == 0 && i == 0) {
                            String str2 = (String) C43865b.this.uKM.get(str);
                            if (C43865b.this.hWL.equals(str2)) {
                                C4990ab.m7417i("MicroMsg.VestImgUploadEngine", "CDN upload success, file url = %s", c9545d.field_fileUrl);
                                C1720g.m3540Rg().mo14541a(new C43917h(c9545d.field_fileUrl, C43865b.this.appId, str2), 0);
                                AppMethodBeat.m2505o(10132);
                            } else {
                                C4990ab.m7417i("MicroMsg.VestImgUploadEngine", "currentPath=%s,callbackPath=%s, path updated after CDNTaskCallback", C43865b.this.hWL, str2);
                            }
                        }
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(10132);
                    }
                }
                AppMethodBeat.m2505o(10132);
            }
            return 0;
        }

        /* renamed from: a */
        public final void mo5083a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        /* renamed from: l */
        public final byte[] mo5084l(String str, byte[] bArr) {
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.e.b$b */
    public enum C29765b {
        NONE,
        LOADING,
        SUCCESS,
        FAIL;

        static {
            AppMethodBeat.m2505o(10135);
        }
    }

    public C43865b() {
        AppMethodBeat.m2504i(10136);
        AppMethodBeat.m2505o(10136);
    }

    /* renamed from: ho */
    public final void mo69551ho(String str, String str2) {
        AppMethodBeat.m2504i(10137);
        this.appId = str2;
        this.hWL = str;
        this.uKO = C29765b.LOADING;
        long currentTimeMillis = System.currentTimeMillis();
        String a = C37458c.m63162a("vestacountavatar", currentTimeMillis, C1853r.m3850Zd().field_username, String.valueOf(currentTimeMillis));
        this.uKM.put(C5046bo.nullAsNil(a), str);
        m78656hp(str, a);
        AppMethodBeat.m2505o(10137);
    }

    /* renamed from: hp */
    private void m78656hp(String str, String str2) {
        AppMethodBeat.m2504i(10138);
        C42130g c42130g = new C42130g();
        c42130g.egl = this.uKL;
        c42130g.field_mediaId = str2;
        c42130g.field_fullpath = str;
        c42130g.field_fileType = C42129a.efN;
        c42130g.field_priority = C42129a.efB;
        c42130g.field_needStorage = true;
        c42130g.field_isStreamMedia = false;
        c42130g.field_appType = 200;
        c42130g.field_bzScene = 2;
        if (!C37461f.afx().mo51225e(c42130g)) {
            C4990ab.m7413e("MicroMsg.VestImgUploadEngine", "hy: cdntra addSendTask failed. clientid:%s", str2);
            this.uKO = C29765b.FAIL;
        }
        AppMethodBeat.m2505o(10138);
    }
}
