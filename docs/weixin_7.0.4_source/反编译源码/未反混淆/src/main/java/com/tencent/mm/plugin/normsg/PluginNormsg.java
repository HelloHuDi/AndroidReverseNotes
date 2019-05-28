package com.tencent.mm.plugin.normsg;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.comm.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.normsg.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.zero.a.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class PluginNormsg extends f implements c, o, a {
    private static final String oTI = b.oTE.TQ("\u001c:/-9+\n.\"0:41\r\"!");
    private static final String oTJ = b.oTE.TQ("\u0005#64 2\u0004(,");
    private static final String oTK = b.oTE.TQ("\u0000&31%7\u00009-\f.,");

    static {
        AppMethodBeat.i(10360);
        AppMethodBeat.o(10360);
    }

    public void installed() {
        AppMethodBeat.i(10352);
        alias(a.class);
        AppMethodBeat.o(10352);
    }

    public void dependency() {
        AppMethodBeat.i(10353);
        dependsOn(d.class);
        dependsOn(com.tencent.mm.plugin.report.c.class);
        dependsOn(a.class);
        dependsOn(p.class);
        AppMethodBeat.o(10353);
    }

    public void configure(g gVar) {
        AppMethodBeat.i(10354);
        b.a(b.oTE);
        AppMethodBeat.o(10354);
    }

    public void execute(g gVar) {
    }

    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(10355);
        com.tencent.mm.plugin.normsg.b.a bVT = com.tencent.mm.plugin.normsg.b.a.bVT();
        g Rn = com.tencent.mm.kernel.g.RM().Rn();
        if (com.tencent.mm.plugin.normsg.b.a.c.isEnabled()) {
            int bWa = com.tencent.mm.plugin.normsg.b.a.c.bWa();
            if (bWa <= 0) {
                bWa = 26;
            }
            if (VERSION.SDK_INT > bWa) {
                ab.w("MircoMsg.AEDHLP", "[tomys] unsupported system, aedh is not enabled.");
            } else if (com.tencent.mm.plugin.normsg.b.a.oTR.contains(com.tencent.mm.plugin.normsg.b.a.TS(Rn.eHT))) {
                try {
                    com.tencent.mm.plugin.normsg.b.b bWc = com.tencent.mm.plugin.normsg.b.b.bWc();
                    bWc.initialize(Rn.cc);
                    bWc.ensureInitialized();
                    bWc.oUx.add(bVT);
                    ab.i("MircoMsg.AEDHLP", "[tomys] aed installed.");
                } catch (com.tencent.mm.plugin.normsg.b.b.f e) {
                    ab.printErrStackTrace("MircoMsg.AEDHLP", e, "[tomys] aed install failed.", new Object[0]);
                    bVT.j(e);
                }
            } else {
                ab.w("MircoMsg.AEDHLP", "[tomys] not target process, skip installing aed.");
            }
        } else {
            ab.w("MircoMsg.AEDHLP", "[tomys] aedh is not enabled.");
        }
        ((p) com.tencent.mm.kernel.g.M(p.class)).getSysCmdMsgExtension().a(oTI, (o) this);
        AppMethodBeat.o(10355);
    }

    public void onAccountRelease() {
        AppMethodBeat.i(10356);
        ((p) com.tencent.mm.kernel.g.M(p.class)).getSysCmdMsgExtension().b(oTI, (o) this);
        AppMethodBeat.o(10356);
    }

    public void onNewXmlReceived(String str, Map<String, String> map, com.tencent.mm.ai.e.a aVar) {
        AppMethodBeat.i(10357);
        ab.i("MicroMsg.PluginNormsg", "xml cmd received, subType: %s", str);
        if (oTI.equals(str)) {
            processUpdateCCEncryptKey(map);
            AppMethodBeat.o(10357);
        } else if (oTJ.equals(str)) {
            processUpdateRqtSignKey(map, 0);
            AppMethodBeat.o(10357);
        } else {
            if (oTK.equals(str)) {
                processUpdateRqtSignKey(map, 1);
            }
            AppMethodBeat.o(10357);
        }
    }

    private void processUpdateCCEncryptKey(Map<String, String> map) {
        AppMethodBeat.i(10358);
        String str = (String) map.get(b.oTE.TQ("k5>3,1$b\u0018>+)=/\u000e:6$. %\u00196%s+-4"));
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.PluginNormsg", "uccek: cannot get required url.");
            AppMethodBeat.o(10358);
            return;
        }
        String bVH = Normsg.a.bVH();
        final File file = bVH != null ? new File(bVH) : null;
        if (file == null) {
            ab.e("MicroMsg.PluginNormsg", "uccek: failure to get required path.");
            h.pYm.k(876, 0, 1);
            AppMethodBeat.o(10358);
            return;
        }
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (!(parentFile.exists() || parentFile.mkdirs())) {
                ab.e("MicroMsg.PluginNormsg", "uccek: failure to create required path.");
                h.pYm.k(876, 1, 1);
                AppMethodBeat.o(10358);
                return;
            }
        }
        final File file2 = new File(bVH + "_@tmp");
        if (file2.exists()) {
            file2.delete();
        } else {
            file2.getParentFile().mkdirs();
        }
        com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
        gVar.cRY = false;
        gVar.egm = str;
        gVar.field_fileType = com.tencent.mm.i.a.efP;
        gVar.field_fullpath = file2.getAbsolutePath();
        gVar.field_mediaId = bVH;
        gVar.allow_mobile_net_download = false;
        gVar.egq = true;
        gVar.is_resume_task = false;
        gVar.field_autostart = true;
        gVar.egn = (int) TimeUnit.MINUTES.toSeconds(1);
        gVar.ego = (int) TimeUnit.MINUTES.toSeconds(10);
        gVar.egl = new com.tencent.mm.i.g.a() {
            public final int a(String str, int i, com.tencent.mm.i.c cVar, com.tencent.mm.i.d dVar, boolean z) {
                AppMethodBeat.i(10350);
                if (i == -21006) {
                    ab.w("MicroMsg.PluginNormsg", "uccek: duplicate request to download meta, ignore this request.");
                    AppMethodBeat.o(10350);
                    return 0;
                } else if (i != 0) {
                    ab.e("MicroMsg.PluginNormsg", "uccek: start failed : %d", Integer.valueOf(i));
                    h.pYm.k(876, 3, 1);
                    AppMethodBeat.o(10350);
                    return 0;
                } else {
                    if (dVar != null) {
                        if (dVar.field_retCode != 0) {
                            ab.e("MicroMsg.PluginNormsg", "uccek: download failure, sceneResult.retCode:%d sceneResult[%s]", Integer.valueOf(dVar.field_retCode), dVar);
                            if (cVar != null && cVar.field_finishedLength > 0) {
                                ab.w("MicroMsg.PluginNormsg", "uccek: download interrupt, clear broken file.");
                                file2.delete();
                            }
                            h.pYm.k(876, 4, 1);
                        } else {
                            ab.i("MicroMsg.PluginNormsg", "uccek: cdn trans suceess.");
                            file2.renameTo(file);
                            h.pYm.k(876, 2, 1);
                        }
                    }
                    AppMethodBeat.o(10350);
                    return 0;
                }
            }

            public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            }

            public final byte[] l(String str, byte[] bArr) {
                return new byte[0];
            }
        };
        com.tencent.mm.al.f.afx().b(gVar, -1);
        AppMethodBeat.o(10358);
    }

    private void processUpdateRqtSignKey(Map<String, String> map, int i) {
        AppMethodBeat.i(10359);
        String str = (String) map.get(b.oTE.TQ("b<7:%8-k\u00117\" 4&\u0010,(q++4"));
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.PluginNormsg", "uccek: cannot get required url.");
            AppMethodBeat.o(10359);
            return;
        }
        String Ai = Normsg.a.Ai(i);
        final File file = Ai != null ? new File(Ai) : null;
        if (file == null) {
            ab.e("MicroMsg.PluginNormsg", "urqtk: failure to get required path.");
            h.pYm.k(876, 27, 1);
            AppMethodBeat.o(10359);
            return;
        }
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (!(parentFile.exists() || parentFile.mkdirs())) {
                ab.e("MicroMsg.PluginNormsg", "urqtk: failure to create required path.");
                h.pYm.k(876, 28, 1);
                AppMethodBeat.o(10359);
                return;
            }
        }
        final File file2 = new File(Ai + "_@tmp");
        if (file2.exists()) {
            file2.delete();
        } else {
            file2.getParentFile().mkdirs();
        }
        com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
        gVar.cRY = false;
        gVar.egm = str;
        gVar.field_fileType = com.tencent.mm.i.a.efP;
        gVar.field_fullpath = file2.getAbsolutePath();
        gVar.field_mediaId = Ai;
        gVar.allow_mobile_net_download = false;
        gVar.egq = true;
        gVar.is_resume_task = false;
        gVar.field_autostart = true;
        gVar.egn = (int) TimeUnit.MINUTES.toSeconds(1);
        gVar.ego = (int) TimeUnit.MINUTES.toSeconds(10);
        gVar.egl = new com.tencent.mm.i.g.a() {
            public final int a(String str, int i, com.tencent.mm.i.c cVar, com.tencent.mm.i.d dVar, boolean z) {
                AppMethodBeat.i(10351);
                if (i == -21006) {
                    ab.w("MicroMsg.PluginNormsg", "urqtk: duplicate request to download meta, ignore this request.");
                    AppMethodBeat.o(10351);
                    return 0;
                } else if (i != 0) {
                    ab.e("MicroMsg.PluginNormsg", "urqtk: start failed : %d", Integer.valueOf(i));
                    h.pYm.k(876, 30, 1);
                    AppMethodBeat.o(10351);
                    return 0;
                } else {
                    if (dVar != null) {
                        if (dVar.field_retCode != 0) {
                            ab.e("MicroMsg.PluginNormsg", "urqtk: download failure, sceneResult.retCode:%d sceneResult[%s]", Integer.valueOf(dVar.field_retCode), dVar);
                            if (cVar != null && cVar.field_finishedLength > 0) {
                                ab.w("MicroMsg.PluginNormsg", "urqtk: download interrupt, clear broken file.");
                                file2.delete();
                            }
                            h.pYm.k(876, 31, 1);
                        } else {
                            ab.i("MicroMsg.PluginNormsg", "urqtk: cdn trans suceess.");
                            file2.renameTo(file);
                            h.pYm.k(876, 29, 1);
                        }
                    }
                    AppMethodBeat.o(10351);
                    return 0;
                }
            }

            public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            }

            public final byte[] l(String str, byte[] bArr) {
                return new byte[0];
            }
        };
        com.tencent.mm.al.f.afx().b(gVar, -1);
        AppMethodBeat.o(10359);
    }
}
