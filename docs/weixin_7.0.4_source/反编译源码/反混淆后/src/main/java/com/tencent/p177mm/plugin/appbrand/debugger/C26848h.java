package com.tencent.p177mm.plugin.appbrand.debugger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appcache.C33076av.C33079c;
import com.tencent.p177mm.plugin.appbrand.appusage.C42374al;
import com.tencent.p177mm.plugin.appbrand.config.C26842p;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Map;
import p000a.C0220l;
import p000a.C44941v;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0005\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bH\u0016J!\u0010\t\u001a\u0004\u0018\u00010\u0004*\u0004\u0018\u00010\u00042\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000bH\bR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/debugger/MonkeyUpdateWxaUsageListNotify;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgPushingXmlHandler$IMessageHandler;", "()V", "SAMPLE", "", "handleMessage", "", "parsedKV", "", "nilAs", "as", "Lkotlin/Function0;", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.debugger.h */
public final class C26848h implements C33079c {
    private final String hjm = "<sysmsg type=\"AppBrandTestUpdateWxaUsageListNotify\">\n\n<AppBrandTestUpdateWxaUsageListNotify>\n\n    <DeleteCount></DeleteCount>\n\n    <DeleteList>\n\n        <DeleteAppInfo>\n\n            <UserName>%s</UserName>\n\n            <AppID>%s</AppID>\n\n            <AppType>%d</AppType>\n\n        </DeleteAppInfo>\n\n    </DeleteList>\n\n</AppBrandTestUpdateWxaUsageListNotify></sysmsg>";

    /* JADX WARNING: Missing block: B:22:0x00c1, code skipped:
            if (r2 == 0) goto L_0x00c3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: u */
    public final void mo5821u(Map<String, String> map) {
        AppMethodBeat.m2504i(134601);
        if (map == null) {
            AppMethodBeat.m2505o(134601);
            return;
        }
        String str = ".sysmsg.AppBrandTestUpdateWxaUsageListNotify";
        int i = C5046bo.getInt((String) map.get(str + ".DeleteCount"), 0);
        if (i <= 0) {
            AppMethodBeat.m2505o(134601);
            return;
        }
        if (i >= 0) {
            int i2 = 0;
            while (true) {
                int i3;
                String str2 = str + ".DeleteList.DeleteAppInfo" + (i2 == 0 ? "" : Integer.valueOf(i2));
                String str3 = (String) map.get(str2 + ".UserName");
                String str4 = (String) map.get(str2 + ".AppID");
                int i4 = C5046bo.getInt((String) map.get(str2 + ".AppType"), 0);
                CharSequence charSequence = str3;
                if (charSequence == null || charSequence.length() == 0) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                if (i3 != 0) {
                    charSequence = str4;
                    i3 = (charSequence == null || charSequence.length() == 0) ? 1 : 0;
                }
                charSequence = str3;
                if (charSequence == null || charSequence.length() == 0) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                if (i3 != 0) {
                    str3 = C26842p.m42742zo(str4);
                }
                if (str4 != null) {
                    C42374al.m74968k(str3, str4, i4);
                    if (i2 == i) {
                        break;
                    }
                    i2++;
                } else {
                    C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlin.String");
                    AppMethodBeat.m2505o(134601);
                    throw c44941v;
                }
            }
        }
        AppMethodBeat.m2505o(134601);
    }
}
