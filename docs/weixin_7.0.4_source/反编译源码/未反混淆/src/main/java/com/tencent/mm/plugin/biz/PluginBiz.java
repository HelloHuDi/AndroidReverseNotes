package com.tencent.mm.plugin.biz;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.l;
import com.tencent.mm.aj.o;
import com.tencent.mm.aj.z;
import com.tencent.mm.api.h;
import com.tencent.mm.api.i;
import com.tencent.mm.api.j;
import com.tencent.mm.kernel.api.bucket.a;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.biz.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.pluginsdk.ui.applet.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.t;
import com.tencent.mm.vfs.FileSystemManager;
import com.tencent.mm.vfs.RC4EncryptedFileSystem;
import java.util.HashMap;

public class PluginBiz extends f implements a, b {
    public void installed() {
        AppMethodBeat.i(11650);
        alias(b.class);
        AppMethodBeat.o(11650);
    }

    public void dependency() {
        AppMethodBeat.i(11651);
        dependsOn(p.class);
        AppMethodBeat.o(11651);
    }

    public void configure(g gVar) {
        AppMethodBeat.i(11652);
        if (gVar.SG()) {
            FileSystemManager.dMy().ens().a("bizimg", new RC4EncryptedFileSystem("${storage}/tencent/MicroMsg/${account}/bizimg", "mmbiz")).iq("${storage}/tencent/MicroMsg/${account}/bizimg", "bizimg").commit();
            ab.i("VFS.Debug", "bizimg FS registered");
            com.tencent.mm.kernel.g.a(o.class, new e(new l()));
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.biz.a.a.class, new a());
        }
        com.tencent.mm.pluginsdk.ui.applet.p.a.vlj = new d();
        AppMethodBeat.o(11652);
    }

    public void execute(g gVar) {
        AppMethodBeat.i(11653);
        if (gVar.SG()) {
            pin(new q(z.class));
            com.tencent.mm.kernel.g.a(h.class, new com.tencent.mm.model.g());
            com.tencent.mm.kernel.g.a(i.class, new com.tencent.mm.model.h());
            com.tencent.mm.kernel.g.a(j.class, new com.tencent.mm.model.j());
        }
        AppMethodBeat.o(11653);
    }

    public HashMap<Integer, com.tencent.mm.cd.h.d> collectDatabaseFactory() {
        AppMethodBeat.i(11654);
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf("BIZ_MESSAGE_TABLE".hashCode()), new com.tencent.mm.cd.h.d() {
            public final String[] Af() {
                return com.tencent.mm.storage.o.fnj;
            }
        });
        hashMap.put(Integer.valueOf("BIZ_TIME_LINE_TABLE".hashCode()), new com.tencent.mm.cd.h.d() {
            public final String[] Af() {
                return r.fnj;
            }
        });
        hashMap.put(Integer.valueOf("BIZ_TIME_LINE_SINGLE_MSG_TABLE".hashCode()), new com.tencent.mm.cd.h.d() {
            public final String[] Af() {
                return t.fnj;
            }
        });
        AppMethodBeat.o(11654);
        return hashMap;
    }
}
