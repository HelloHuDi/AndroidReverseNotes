package com.tencent.p177mm.plugin.normsg;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.C1671c;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.p235i.C42130g;
import com.tencent.p177mm.p235i.C42130g.C1628a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.plugin.comm.p1247a.C27697a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C3473o;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.plugin.normsg.Normsg.C12721a;
import com.tencent.p177mm.plugin.normsg.p473a.C6998b;
import com.tencent.p177mm.plugin.normsg.p474b.C21384a;
import com.tencent.p177mm.plugin.normsg.p474b.C21384a.C21386c;
import com.tencent.p177mm.plugin.normsg.p474b.C28614b;
import com.tencent.p177mm.plugin.normsg.p474b.C28614b.C21390f;
import com.tencent.p177mm.plugin.report.C7051c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.zero.p591a.C44035d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* renamed from: com.tencent.mm.plugin.normsg.PluginNormsg */
public class PluginNormsg extends C7597f implements C1671c, C3473o, C21383a {
    private static final String oTI = C28622b.oTE.mo8093TQ("\u001c:/-9+\n.\"0:41\r\"!");
    private static final String oTJ = C28622b.oTE.mo8093TQ("\u0005#64 2\u0004(,");
    private static final String oTK = C28622b.oTE.mo8093TQ("\u0000&31%7\u00009-\f.,");

    static {
        AppMethodBeat.m2504i(10360);
        AppMethodBeat.m2505o(10360);
    }

    public void installed() {
        AppMethodBeat.m2504i(10352);
        alias(C21383a.class);
        AppMethodBeat.m2505o(10352);
    }

    public void dependency() {
        AppMethodBeat.m2504i(10353);
        dependsOn(C44035d.class);
        dependsOn(C7051c.class);
        dependsOn(C27697a.class);
        dependsOn(C6983p.class);
        AppMethodBeat.m2505o(10353);
    }

    public void configure(C1681g c1681g) {
        AppMethodBeat.m2504i(10354);
        C6998b.m11683a(C28622b.oTE);
        AppMethodBeat.m2505o(10354);
    }

    public void execute(C1681g c1681g) {
    }

    public void onAccountInitialized(C1705c c1705c) {
        AppMethodBeat.m2504i(10355);
        C21384a bVT = C21384a.bVT();
        C1681g Rn = C1720g.m3533RM().mo5224Rn();
        if (C21386c.isEnabled()) {
            int bWa = C21386c.bWa();
            if (bWa <= 0) {
                bWa = 26;
            }
            if (VERSION.SDK_INT > bWa) {
                C4990ab.m7420w("MircoMsg.AEDHLP", "[tomys] unsupported system, aedh is not enabled.");
            } else if (C21384a.oTR.contains(C21384a.m32804TS(Rn.eHT))) {
                try {
                    C28614b bWc = C28614b.bWc();
                    bWc.initialize(Rn.f1233cc);
                    bWc.ensureInitialized();
                    bWc.oUx.add(bVT);
                    C4990ab.m7416i("MircoMsg.AEDHLP", "[tomys] aed installed.");
                } catch (C21390f e) {
                    C4990ab.printErrStackTrace("MircoMsg.AEDHLP", e, "[tomys] aed install failed.", new Object[0]);
                    bVT.mo36843j(e);
                }
            } else {
                C4990ab.m7420w("MircoMsg.AEDHLP", "[tomys] not target process, skip installing aed.");
            }
        } else {
            C4990ab.m7420w("MircoMsg.AEDHLP", "[tomys] aedh is not enabled.");
        }
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14902a(oTI, (C3473o) this);
        AppMethodBeat.m2505o(10355);
    }

    public void onAccountRelease() {
        AppMethodBeat.m2504i(10356);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14905b(oTI, (C3473o) this);
        AppMethodBeat.m2505o(10356);
    }

    public void onNewXmlReceived(String str, Map<String, String> map, C1197a c1197a) {
        AppMethodBeat.m2504i(10357);
        C4990ab.m7417i("MicroMsg.PluginNormsg", "xml cmd received, subType: %s", str);
        if (oTI.equals(str)) {
            processUpdateCCEncryptKey(map);
            AppMethodBeat.m2505o(10357);
        } else if (oTJ.equals(str)) {
            processUpdateRqtSignKey(map, 0);
            AppMethodBeat.m2505o(10357);
        } else {
            if (oTK.equals(str)) {
                processUpdateRqtSignKey(map, 1);
            }
            AppMethodBeat.m2505o(10357);
        }
    }

    private void processUpdateCCEncryptKey(Map<String, String> map) {
        AppMethodBeat.m2504i(10358);
        String str = (String) map.get(C28622b.oTE.mo8093TQ("k5>3,1$b\u0018>+)=/\u000e:6$. %\u00196%s+-4"));
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.PluginNormsg", "uccek: cannot get required url.");
            AppMethodBeat.m2505o(10358);
            return;
        }
        String bVH = C12721a.bVH();
        final File file = bVH != null ? new File(bVH) : null;
        if (file == null) {
            C4990ab.m7412e("MicroMsg.PluginNormsg", "uccek: failure to get required path.");
            C7060h.pYm.mo15419k(876, 0, 1);
            AppMethodBeat.m2505o(10358);
            return;
        }
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (!(parentFile.exists() || parentFile.mkdirs())) {
                C4990ab.m7412e("MicroMsg.PluginNormsg", "uccek: failure to create required path.");
                C7060h.pYm.mo15419k(876, 1, 1);
                AppMethodBeat.m2505o(10358);
                return;
            }
        }
        final File file2 = new File(bVH + "_@tmp");
        if (file2.exists()) {
            file2.delete();
        } else {
            file2.getParentFile().mkdirs();
        }
        C42130g c42130g = new C42130g();
        c42130g.cRY = false;
        c42130g.egm = str;
        c42130g.field_fileType = C42129a.efP;
        c42130g.field_fullpath = file2.getAbsolutePath();
        c42130g.field_mediaId = bVH;
        c42130g.allow_mobile_net_download = false;
        c42130g.egq = true;
        c42130g.is_resume_task = false;
        c42130g.field_autostart = true;
        c42130g.egn = (int) TimeUnit.MINUTES.toSeconds(1);
        c42130g.ego = (int) TimeUnit.MINUTES.toSeconds(10);
        c42130g.egl = new C1628a() {
            /* renamed from: a */
            public final int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z) {
                AppMethodBeat.m2504i(10350);
                if (i == -21006) {
                    C4990ab.m7420w("MicroMsg.PluginNormsg", "uccek: duplicate request to download meta, ignore this request.");
                    AppMethodBeat.m2505o(10350);
                    return 0;
                } else if (i != 0) {
                    C4990ab.m7413e("MicroMsg.PluginNormsg", "uccek: start failed : %d", Integer.valueOf(i));
                    C7060h.pYm.mo15419k(876, 3, 1);
                    AppMethodBeat.m2505o(10350);
                    return 0;
                } else {
                    if (c9545d != null) {
                        if (c9545d.field_retCode != 0) {
                            C4990ab.m7413e("MicroMsg.PluginNormsg", "uccek: download failure, sceneResult.retCode:%d sceneResult[%s]", Integer.valueOf(c9545d.field_retCode), c9545d);
                            if (c18496c != null && c18496c.field_finishedLength > 0) {
                                C4990ab.m7420w("MicroMsg.PluginNormsg", "uccek: download interrupt, clear broken file.");
                                file2.delete();
                            }
                            C7060h.pYm.mo15419k(876, 4, 1);
                        } else {
                            C4990ab.m7416i("MicroMsg.PluginNormsg", "uccek: cdn trans suceess.");
                            file2.renameTo(file);
                            C7060h.pYm.mo15419k(876, 2, 1);
                        }
                    }
                    AppMethodBeat.m2505o(10350);
                    return 0;
                }
            }

            /* renamed from: a */
            public final void mo5083a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            }

            /* renamed from: l */
            public final byte[] mo5084l(String str, byte[] bArr) {
                return new byte[0];
            }
        };
        C37461f.afx().mo51222b(c42130g, -1);
        AppMethodBeat.m2505o(10358);
    }

    private void processUpdateRqtSignKey(Map<String, String> map, int i) {
        AppMethodBeat.m2504i(10359);
        String str = (String) map.get(C28622b.oTE.mo8093TQ("b<7:%8-k\u00117\" 4&\u0010,(q++4"));
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.PluginNormsg", "uccek: cannot get required url.");
            AppMethodBeat.m2505o(10359);
            return;
        }
        String Ai = C12721a.m20741Ai(i);
        final File file = Ai != null ? new File(Ai) : null;
        if (file == null) {
            C4990ab.m7412e("MicroMsg.PluginNormsg", "urqtk: failure to get required path.");
            C7060h.pYm.mo15419k(876, 27, 1);
            AppMethodBeat.m2505o(10359);
            return;
        }
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (!(parentFile.exists() || parentFile.mkdirs())) {
                C4990ab.m7412e("MicroMsg.PluginNormsg", "urqtk: failure to create required path.");
                C7060h.pYm.mo15419k(876, 28, 1);
                AppMethodBeat.m2505o(10359);
                return;
            }
        }
        final File file2 = new File(Ai + "_@tmp");
        if (file2.exists()) {
            file2.delete();
        } else {
            file2.getParentFile().mkdirs();
        }
        C42130g c42130g = new C42130g();
        c42130g.cRY = false;
        c42130g.egm = str;
        c42130g.field_fileType = C42129a.efP;
        c42130g.field_fullpath = file2.getAbsolutePath();
        c42130g.field_mediaId = Ai;
        c42130g.allow_mobile_net_download = false;
        c42130g.egq = true;
        c42130g.is_resume_task = false;
        c42130g.field_autostart = true;
        c42130g.egn = (int) TimeUnit.MINUTES.toSeconds(1);
        c42130g.ego = (int) TimeUnit.MINUTES.toSeconds(10);
        c42130g.egl = new C1628a() {
            /* renamed from: a */
            public final int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z) {
                AppMethodBeat.m2504i(10351);
                if (i == -21006) {
                    C4990ab.m7420w("MicroMsg.PluginNormsg", "urqtk: duplicate request to download meta, ignore this request.");
                    AppMethodBeat.m2505o(10351);
                    return 0;
                } else if (i != 0) {
                    C4990ab.m7413e("MicroMsg.PluginNormsg", "urqtk: start failed : %d", Integer.valueOf(i));
                    C7060h.pYm.mo15419k(876, 30, 1);
                    AppMethodBeat.m2505o(10351);
                    return 0;
                } else {
                    if (c9545d != null) {
                        if (c9545d.field_retCode != 0) {
                            C4990ab.m7413e("MicroMsg.PluginNormsg", "urqtk: download failure, sceneResult.retCode:%d sceneResult[%s]", Integer.valueOf(c9545d.field_retCode), c9545d);
                            if (c18496c != null && c18496c.field_finishedLength > 0) {
                                C4990ab.m7420w("MicroMsg.PluginNormsg", "urqtk: download interrupt, clear broken file.");
                                file2.delete();
                            }
                            C7060h.pYm.mo15419k(876, 31, 1);
                        } else {
                            C4990ab.m7416i("MicroMsg.PluginNormsg", "urqtk: cdn trans suceess.");
                            file2.renameTo(file);
                            C7060h.pYm.mo15419k(876, 29, 1);
                        }
                    }
                    AppMethodBeat.m2505o(10351);
                    return 0;
                }
            }

            /* renamed from: a */
            public final void mo5083a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            }

            /* renamed from: l */
            public final byte[] mo5084l(String str, byte[] bArr) {
                return new byte[0];
            }
        };
        C37461f.afx().mo51222b(c42130g, -1);
        AppMethodBeat.m2505o(10359);
    }
}
