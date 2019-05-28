package com.tencent.p177mm.plugin.backup;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.plugin.backup.p1392a.C27442a;
import com.tencent.p177mm.plugin.backup.p347j.C6798a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vfs.FileSystemManager;
import com.tencent.p177mm.vfs.RC4EncryptedFileSystem;

/* renamed from: com.tencent.mm.plugin.backup.PluginBackup */
public class PluginBackup extends C7597f implements C27442a {
    public void configure(C1681g c1681g) {
        AppMethodBeat.m2504i(17112);
        if (c1681g.mo5181SG()) {
            FileSystemManager.dMy().ens().mo11624a("msgsynchronize", new RC4EncryptedFileSystem("${storage}/tencent/MicroMsg/${account}/msgsynchronize", "msgsynchronize")).mo11626iq("${storage}/tencent/MicroMsg/${account}/msgsynchronize", "msgsynchronize").commit();
            C4990ab.m7416i("VFS.Debug", "msgsynchronize FS registered");
            FileSystemManager.dMy().ens().mo11624a("backupRecover", new RC4EncryptedFileSystem("${storage}/tencent/MicroMsg/${account}/backupRecover/backupItem", "backupRecover")).mo11626iq("${storage}/tencent/MicroMsg/${account}/backupRecover/backupItem", "backupRecover").commit();
            C4990ab.m7416i("VFS.Debug", "backupRecover FS registered");
        }
        AppMethodBeat.m2505o(17112);
    }

    public void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(17113);
        if (c1681g.mo5181SG()) {
            C4990ab.m7416i("MicroMsg.PluginBackup", "PluginMonitor execute PluginMonitor new BackupCore");
            pin(new C7485q(C6798a.class));
        }
        AppMethodBeat.m2505o(17113);
    }

    public String name() {
        return "plugin-backup";
    }
}
