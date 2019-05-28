package com.tencent.mm.plugin.avatar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.vfs.FileSystemManager;
import com.tencent.mm.vfs.MigrationFileSystem;
import com.tencent.mm.vfs.QuotaFileSystem;
import com.tencent.mm.vfs.RawFileSystem;
import java.util.Map;

public class PluginAvatar extends f implements b {

    static class a implements com.tencent.mm.vfs.a {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        private static void dy(int i, int i2) {
            AppMethodBeat.i(79056);
            e.pXa.a(857, (long) i, (long) i2, false);
            AppMethodBeat.o(79056);
        }

        public final void b(String str, int i, Map<String, Object> map) {
            AppMethodBeat.i(79057);
            if (i == 4) {
                dy(1, 1);
                AppMethodBeat.o(79057);
            } else if (i == 5) {
                dy(2, 1);
                AppMethodBeat.o(79057);
            } else {
                Integer num;
                if (i == 1) {
                    if (str.equals("avatarQuota")) {
                        dy(0, 1);
                        AppMethodBeat.o(79057);
                        return;
                    }
                } else if (i == 3) {
                    if (str.equals("avatarQuota")) {
                        dy(6, 1);
                        AppMethodBeat.o(79057);
                        return;
                    } else if (str.equals("avatarMigration")) {
                        int intValue;
                        dy(3, 1);
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
                            dy(7, 1);
                            dy(13, intValue);
                        }
                        if (l != null) {
                            dy(15, (int) l.longValue());
                        }
                        AppMethodBeat.o(79057);
                        return;
                    }
                } else if ((i == 2 || i == 6) && str.equals("avatarQuota")) {
                    num = (Integer) map.get("fileCount");
                    Long l2 = (Long) map.get("totalSize");
                    if (num != null) {
                        dy(9, num.intValue());
                    }
                    if (l2 != null) {
                        dy(11, (int) l2.longValue());
                    }
                }
                AppMethodBeat.o(79057);
            }
        }
    }

    public void configure(g gVar) {
        AppMethodBeat.i(79058);
        if (gVar.SG()) {
            a aVar = new a();
            MigrationFileSystem migrationFileSystem = new MigrationFileSystem(new RawFileSystem("${data}/MicroMsg/${account}/avatar", (byte) 0), new RawFileSystem("${storage}/tencent/MicroMsg/${account}/avatar"));
            migrationFileSystem.a("avatarMigration", aVar);
            QuotaFileSystem quotaFileSystem = new QuotaFileSystem(migrationFileSystem);
            quotaFileSystem.a("avatarQuota", aVar);
            FileSystemManager.dMy().ens().a("avatar", quotaFileSystem).iq("${data}/MicroMsg/${account}/avatar", "avatar").ri(false);
        }
        AppMethodBeat.o(79058);
    }

    public void execute(g gVar) {
        AppMethodBeat.i(79059);
        if (gVar.SG()) {
            pin(c.aSm());
        }
        AppMethodBeat.o(79059);
    }
}
