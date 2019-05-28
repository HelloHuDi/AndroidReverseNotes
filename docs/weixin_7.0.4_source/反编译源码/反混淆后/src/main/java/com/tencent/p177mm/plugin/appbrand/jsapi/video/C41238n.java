package com.tencent.p177mm.plugin.appbrand.jsapi.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p1087t.C40641d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.n */
public final class C41238n implements C38401e {
    /* renamed from: a */
    public final int mo61110a(String str, C38398c c38398c) {
        int i = -1;
        AppMethodBeat.m2504i(131628);
        AppBrandVideoDownLoadMgr appBrandVideoDownLoadMgr = AppBrandVideoDownLoadMgr.hYI;
        if (str == null || C5046bo.isNullOrNil(str)) {
            C4990ab.m7416i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genPreLoad illegal url or preLoadCallback");
            AppMethodBeat.m2505o(131628);
            return -1;
        }
        C27127a c27127a = new C27127a();
        c27127a.url = str;
        c27127a.hYE = c38398c;
        C4990ab.m7417i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genPreLoad  videoUrl = %s", str);
        String genAdFileExist = appBrandVideoDownLoadMgr.genAdFileExist("gamead", c27127a);
        if (C5046bo.isNullOrNil(genAdFileExist)) {
            String genAdFilePath = appBrandVideoDownLoadMgr.genAdFilePath("gamead", c27127a);
            if (C5046bo.isNullOrNil(genAdFilePath)) {
                AppMethodBeat.m2505o(131628);
                return -4;
            }
            C40641d c40641d = AppBrandVideoDownLoadMgr.hYJ;
            String str2 = c27127a.url;
            if (C40641d.ewX != null) {
                i = C40641d.ewX.mo27489a(str2, genAdFilePath, c40641d);
            }
            C4990ab.m7417i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad downloadVideo path=%s, ret=%d", genAdFilePath, Integer.valueOf(i));
            if (i != 0) {
                AppMethodBeat.m2505o(131628);
                return -3;
            }
            AppBrandVideoDownLoadMgr.hYH.put(c27127a.url, c27127a);
        } else if (genAdFileExist.equalsIgnoreCase("downloading")) {
            AppMethodBeat.m2505o(131628);
            return -2;
        } else {
            AppBrandVideoDownLoadMgr.hYH.put(c27127a.url, c27127a);
            AppBrandVideoDownLoadMgr.m75405ak(c27127a.url, true);
            c27127a.hYE.mo34713cv(c27127a.url, genAdFileExist);
        }
        AppMethodBeat.m2505o(131628);
        return 0;
    }

    public final void report(String str) {
        AppMethodBeat.m2504i(131629);
        AppBrandVideoDownLoadMgr.hYI.report(str);
        AppMethodBeat.m2505o(131629);
    }

    /* renamed from: BR */
    public final String mo61109BR(String str) {
        AppMethodBeat.m2504i(131630);
        AppBrandVideoDownLoadMgr appBrandVideoDownLoadMgr = AppBrandVideoDownLoadMgr.hYI;
        C27127a c27127a = new C27127a();
        c27127a.url = str;
        c27127a.hYE = null;
        String genAdFileExist = appBrandVideoDownLoadMgr.genAdFileExist("gamead", c27127a);
        if (C5046bo.isNullOrNil(genAdFileExist)) {
            AppMethodBeat.m2505o(131630);
            return null;
        } else if (genAdFileExist.equalsIgnoreCase("downloading")) {
            AppMethodBeat.m2505o(131630);
            return null;
        } else {
            AppMethodBeat.m2505o(131630);
            return genAdFileExist;
        }
    }
}
