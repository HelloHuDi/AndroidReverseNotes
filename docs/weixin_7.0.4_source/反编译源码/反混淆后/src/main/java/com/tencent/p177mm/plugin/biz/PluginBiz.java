package com.tencent.p177mm.plugin.biz;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.api.C25782h;
import com.tencent.p177mm.api.C32250j;
import com.tencent.p177mm.api.C8954i;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.bucket.C18523a;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.kernel.p242c.C6625e;
import com.tencent.p177mm.model.C16540h;
import com.tencent.p177mm.model.C45441g;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.model.C9670j;
import com.tencent.p177mm.p184aj.C25771l;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p184aj.C8939o;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.plugin.biz.p1395a.C27500a;
import com.tencent.p177mm.plugin.biz.p1395a.C27501b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C46502p.C35851a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C4739d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C23522t;
import com.tencent.p177mm.storage.C40635r;
import com.tencent.p177mm.storage.C46626o;
import com.tencent.p177mm.vfs.FileSystemManager;
import com.tencent.p177mm.vfs.RC4EncryptedFileSystem;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.biz.PluginBiz */
public class PluginBiz extends C7597f implements C18523a, C27501b {

    /* renamed from: com.tencent.mm.plugin.biz.PluginBiz$1 */
    class C111771 implements C1366d {
        C111771() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C46626o.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.biz.PluginBiz$3 */
    class C111783 implements C1366d {
        C111783() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C23522t.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.biz.PluginBiz$2 */
    class C111792 implements C1366d {
        C111792() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C40635r.fnj;
        }
    }

    public void installed() {
        AppMethodBeat.m2504i(11650);
        alias(C27501b.class);
        AppMethodBeat.m2505o(11650);
    }

    public void dependency() {
        AppMethodBeat.m2504i(11651);
        dependsOn(C6983p.class);
        AppMethodBeat.m2505o(11651);
    }

    public void configure(C1681g c1681g) {
        AppMethodBeat.m2504i(11652);
        if (c1681g.mo5181SG()) {
            FileSystemManager.dMy().ens().mo11624a("bizimg", new RC4EncryptedFileSystem("${storage}/tencent/MicroMsg/${account}/bizimg", "mmbiz")).mo11626iq("${storage}/tencent/MicroMsg/${account}/bizimg", "bizimg").commit();
            C4990ab.m7416i("VFS.Debug", "bizimg FS registered");
            C1720g.m3543a(C8939o.class, new C6625e(new C25771l()));
            C1720g.m3542a(C27500a.class, new C20014a());
        }
        C35851a.vlj = new C4739d();
        AppMethodBeat.m2505o(11652);
    }

    public void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(11653);
        if (c1681g.mo5181SG()) {
            pin(new C7485q(C41747z.class));
            C1720g.m3542a(C25782h.class, new C45441g());
            C1720g.m3542a(C8954i.class, new C16540h());
            C1720g.m3542a(C32250j.class, new C9670j());
        }
        AppMethodBeat.m2505o(11653);
    }

    public HashMap<Integer, C1366d> collectDatabaseFactory() {
        AppMethodBeat.m2504i(11654);
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf("BIZ_MESSAGE_TABLE".hashCode()), new C111771());
        hashMap.put(Integer.valueOf("BIZ_TIME_LINE_TABLE".hashCode()), new C111792());
        hashMap.put(Integer.valueOf("BIZ_TIME_LINE_SINGLE_MSG_TABLE".hashCode()), new C111783());
        AppMethodBeat.m2505o(11654);
        return hashMap;
    }
}
