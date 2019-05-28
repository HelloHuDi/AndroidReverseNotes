package com.tencent.mm.plugin.backup;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.backup.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.FileSystemManager;
import com.tencent.mm.vfs.RC4EncryptedFileSystem;

public class PluginBackup extends f implements a {
    public void configure(g gVar) {
        AppMethodBeat.i(17112);
        if (gVar.SG()) {
            FileSystemManager.dMy().ens().a("msgsynchronize", new RC4EncryptedFileSystem("${storage}/tencent/MicroMsg/${account}/msgsynchronize", "msgsynchronize")).iq("${storage}/tencent/MicroMsg/${account}/msgsynchronize", "msgsynchronize").commit();
            ab.i("VFS.Debug", "msgsynchronize FS registered");
            FileSystemManager.dMy().ens().a("backupRecover", new RC4EncryptedFileSystem("${storage}/tencent/MicroMsg/${account}/backupRecover/backupItem", "backupRecover")).iq("${storage}/tencent/MicroMsg/${account}/backupRecover/backupItem", "backupRecover").commit();
            ab.i("VFS.Debug", "backupRecover FS registered");
        }
        AppMethodBeat.o(17112);
    }

    public void execute(g gVar) {
        AppMethodBeat.i(17113);
        if (gVar.SG()) {
            ab.i("MicroMsg.PluginBackup", "PluginMonitor execute PluginMonitor new BackupCore");
            pin(new q(com.tencent.mm.plugin.backup.j.a.class));
        }
        AppMethodBeat.o(17113);
    }

    public String name() {
        return "plugin-backup";
    }
}
