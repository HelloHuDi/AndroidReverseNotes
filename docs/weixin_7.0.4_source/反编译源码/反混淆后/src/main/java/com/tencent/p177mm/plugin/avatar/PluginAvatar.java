package com.tencent.p177mm.plugin.avatar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.vfs.C5727a;
import com.tencent.p177mm.vfs.FileSystemManager;
import com.tencent.p177mm.vfs.MigrationFileSystem;
import com.tencent.p177mm.vfs.QuotaFileSystem;
import com.tencent.p177mm.vfs.RawFileSystem;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.avatar.PluginAvatar */
public class PluginAvatar extends C7597f implements C27441b {

    /* renamed from: com.tencent.mm.plugin.avatar.PluginAvatar$a */
    static class C42755a implements C5727a {
        private C42755a() {
        }

        /* synthetic */ C42755a(byte b) {
            this();
        }

        /* renamed from: dy */
        private static void m75792dy(int i, int i2) {
            AppMethodBeat.m2504i(79056);
            C7053e.pXa.mo8378a(857, (long) i, (long) i2, false);
            AppMethodBeat.m2505o(79056);
        }

        /* renamed from: b */
        public final void mo11650b(String str, int i, Map<String, Object> map) {
            AppMethodBeat.m2504i(79057);
            if (i == 4) {
                C42755a.m75792dy(1, 1);
                AppMethodBeat.m2505o(79057);
            } else if (i == 5) {
                C42755a.m75792dy(2, 1);
                AppMethodBeat.m2505o(79057);
            } else {
                Integer num;
                if (i == 1) {
                    if (str.equals("avatarQuota")) {
                        C42755a.m75792dy(0, 1);
                        AppMethodBeat.m2505o(79057);
                        return;
                    }
                } else if (i == 3) {
                    if (str.equals("avatarQuota")) {
                        C42755a.m75792dy(6, 1);
                        AppMethodBeat.m2505o(79057);
                        return;
                    } else if (str.equals("avatarMigration")) {
                        int intValue;
                        C42755a.m75792dy(3, 1);
                        num = (Integer) map.get("filesCopied");
                        Integer num2 = (Integer) map.get("filesFailed");
                        Long l = (Long) map.get("sizeCopied");
                        if (num != null) {
                            intValue = num.intValue() + 0;
                        } else {
                            intValue = 0;
                        }
                        if (num2 != null) {
                            intValue += num2.intValue();
                        }
                        if (intValue > 0) {
                            C42755a.m75792dy(7, 1);
                            C42755a.m75792dy(13, intValue);
                        }
                        if (l != null) {
                            C42755a.m75792dy(15, (int) l.longValue());
                        }
                        AppMethodBeat.m2505o(79057);
                        return;
                    }
                } else if ((i == 2 || i == 6) && str.equals("avatarQuota")) {
                    num = (Integer) map.get("fileCount");
                    Long l2 = (Long) map.get("totalSize");
                    if (num != null) {
                        C42755a.m75792dy(9, num.intValue());
                    }
                    if (l2 != null) {
                        C42755a.m75792dy(11, (int) l2.longValue());
                    }
                }
                AppMethodBeat.m2505o(79057);
            }
        }
    }

    public void configure(C1681g c1681g) {
        AppMethodBeat.m2504i(79058);
        if (c1681g.mo5181SG()) {
            C42755a c42755a = new C42755a();
            MigrationFileSystem migrationFileSystem = new MigrationFileSystem(new RawFileSystem("${data}/MicroMsg/${account}/avatar", (byte) 0), new RawFileSystem("${storage}/tencent/MicroMsg/${account}/avatar"));
            migrationFileSystem.mo15899a("avatarMigration", c42755a);
            QuotaFileSystem quotaFileSystem = new QuotaFileSystem(migrationFileSystem);
            quotaFileSystem.mo15899a("avatarQuota", c42755a);
            FileSystemManager.dMy().ens().mo11624a("avatar", quotaFileSystem).mo11626iq("${data}/MicroMsg/${account}/avatar", "avatar").mo11628ri(false);
        }
        AppMethodBeat.m2505o(79058);
    }

    public void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(79059);
        if (c1681g.mo5181SG()) {
            pin(C19935c.aSm());
        }
        AppMethodBeat.m2505o(79059);
    }
}
