package com.tencent.mm.plugin.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.f.e;
import com.tencent.mm.plugin.emoji.f.n;
import com.tencent.mm.plugin.emoji.f.s;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.plugin.emoji.sync.a.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;

public final class a extends c<mp> {
    public a() {
        AppMethodBeat.i(52807);
        this.xxI = mp.class.getName().hashCode();
        AppMethodBeat.o(52807);
    }

    public static void gm(boolean z) {
        long j;
        int i;
        AppMethodBeat.i(52808);
        Object obj = g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_EMOJI_SYNC_STORE_EMOJI_UPLODD_LONG, null);
        if (obj == null || !(obj instanceof Long)) {
            j = 0;
        } else {
            j = ((Long) obj).longValue();
        }
        if (System.currentTimeMillis() - j > 86400000) {
            i = 1;
        } else {
            i = 0;
        }
        if (i != 0 || z) {
            ab.i("MicroMsg.emoji.EmojiPostTaskListener", "uploadStoreEmoji need upload:%b", Boolean.valueOf(j.getEmojiStorageMgr().xYo.duJ()));
            if (j.getEmojiStorageMgr().xYo.duJ() || z) {
                g.RO().eJo.a(new s(j.getEmojiStorageMgr().xYo.duL(), 1), 0);
                AppMethodBeat.o(52808);
                return;
            }
            g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_EMOJI_SYNC_STORE_EMOJI_UPLODD_FINISH_BOOLEAN, Boolean.TRUE);
        }
        AppMethodBeat.o(52808);
    }

    public static void gn(boolean z) {
        int i;
        AppMethodBeat.i(52809);
        boolean i2;
        if (bo.a((Boolean) g.RP().Ry().get(348165, null), false)) {
            long j;
            Object obj = g.RP().Ry().get(348166, null);
            if (obj == null || !(obj instanceof Long)) {
                j = 0;
            } else {
                j = ((Long) obj).longValue();
            }
            if (System.currentTimeMillis() - j > 3600000) {
                i2 = 1;
            } else {
                i2 = false;
            }
        } else {
            i2 = false;
        }
        if (i2 != 0 || z) {
            ArrayList dvh = j.getEmojiStorageMgr().xYn.dvh();
            if (dvh.size() > 0) {
                ab.i("MicroMsg.emoji.EmojiPostTaskListener", "try to sync emoji uploadEmojiList:%d", Integer.valueOf(dvh.size()));
                ArrayList arrayList = new ArrayList();
                int size = dvh.size();
                for (int i3 = 0; i3 < size; i3++) {
                    arrayList.add(new d((String) dvh.get(i3)));
                    ab.i("MicroMsg.emoji.EmojiPostTaskListener", "try to sync emoji upload Emoji:%s", dvh.get(i3));
                }
                j.bkj().kXj.bt(arrayList);
                j.bkj().kXj.bkG();
            } else {
                ab.i("MicroMsg.emoji.EmojiPostTaskListener", "no things need to upload.");
                g.RP().Ry().set(348165, Boolean.FALSE);
            }
            g.RP().Ry().set(348166, Long.valueOf(System.currentTimeMillis()));
        }
        AppMethodBeat.o(52809);
    }

    public static void bjE() {
        int i;
        AppMethodBeat.i(52810);
        boolean a = bo.a((Boolean) g.RP().Ry().get(348162, null), false);
        boolean i2;
        if (bo.a((Boolean) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_EMOJI_BACKUP_OVERSIZE_BOOLEAN, null), false) || !a) {
            i2 = false;
        } else {
            long j;
            Object obj = g.RP().Ry().get(348163, null);
            if (obj == null || !(obj instanceof Long)) {
                j = 0;
            } else {
                j = ((Long) obj).longValue();
            }
            if (System.currentTimeMillis() - j > 3600000) {
                i2 = 1;
            } else {
                i2 = false;
            }
        }
        if (i2 != 0) {
            ab.i("MicroMsg.emoji.EmojiPostTaskListener", "[cpan] start do backup emoji.");
            ArrayList arrayList = (ArrayList) j.getEmojiStorageMgr().xYn.Mz(0);
            if (arrayList.size() <= 0) {
                ab.i("MicroMsg.emoji.EmojiPostTaskListener", "[cpan] no local emoji need not to backup ");
                g.RP().Ry().set(348162, Boolean.FALSE);
                AppMethodBeat.o(52810);
                return;
            }
            g.RP().Ry().set(348163, Long.valueOf(System.currentTimeMillis()));
            ab.i("MicroMsg.emoji.EmojiPostTaskListener", "[cpan] start backup local emoji ");
            if (arrayList.size() > 50) {
                int size = arrayList.size();
                ab.i("MicroMsg.emoji.EmojiPostTaskListener", "count:%d", Integer.valueOf(size / 50));
                for (int i3 = 0; i3 <= r6; i3++) {
                    ArrayList arrayList2 = new ArrayList();
                    int i4 = i3 * 50;
                    int i5 = ((i3 + 1) * 50) + -1 >= size ? size : (i3 + 1) * 50;
                    ab.i("MicroMsg.emoji.EmojiPostTaskListener", "start index:%d to index:%d", Integer.valueOf(i4), Integer.valueOf(i5));
                    if (i5 > i4) {
                        arrayList2.addAll(arrayList.subList(i4, i5));
                        g.RO().eJo.a(new com.tencent.mm.plugin.emoji.f.d(arrayList2), 0);
                    }
                }
                AppMethodBeat.o(52810);
                return;
            }
            g.RO().eJo.a(new com.tencent.mm.plugin.emoji.f.d(arrayList), 0);
        }
        AppMethodBeat.o(52810);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x011f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ boolean a(b bVar) {
        int i;
        AppMethodBeat.i(52811);
        bjE();
        boolean booleanValue = ((Boolean) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_EMOJI_SYNC_CUSTOM_EMOJI_BATCH_DOWNLOAD_BOOLEAN, Boolean.TRUE)).booleanValue();
        if (System.currentTimeMillis() <= ((Long) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_EMOJI_NEXT_CUSTOM_BATCH_DOWNLOAD_TIME_LONG, Long.valueOf(0))).longValue() || !booleanValue) {
            i = 0;
        } else {
            i = 1;
        }
        if (i != 0) {
            g.RO().eJo.a(new e(0), 0);
        }
        booleanValue = ((Boolean) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_EMOJI_SYNC_CAPTURE_EMOJI_BATCH_DOWNLOAD_BOOLEAN, Boolean.TRUE)).booleanValue();
        long longValue = ((Long) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_EMOJI_NEXT_CAPTURE_BATCH_DOWNLOAD_TIME_LONG, Long.valueOf(0))).longValue();
        if (booleanValue && System.currentTimeMillis() > longValue) {
            g.RO().eJo.a(new e(1), 0);
        }
        gn(false);
        gm(false);
        if (((Boolean) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_EMOJI_SYNC_STORE_EMOJI_UPLODD_FINISH_BOOLEAN, Boolean.FALSE)).booleanValue()) {
            long j;
            Object obj = g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_EMOJI_SYNC_STORE_EMOJI_DOWNLOAD_LONG, null);
            if (obj == null || !(obj instanceof Long)) {
                j = 0;
            } else {
                j = ((Long) obj).longValue();
            }
            if (System.currentTimeMillis() - j > 86400000) {
                i = 1;
                if (i != 0) {
                    g.RO().eJo.a(new n(8, 15), 0);
                }
                if (System.currentTimeMillis() - ((Long) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_EMOJI_REPORT_CUSTOM_EMOJI_COUNT_LONG, Long.valueOf(0))).longValue() > 86400000) {
                    i = j.getEmojiStorageMgr().xYn.y(false, true);
                    h.pYm.e(11597, Integer.valueOf(i), Integer.valueOf(0));
                    i = j.getEmojiStorageMgr().xYn.pr(true);
                    h.pYm.e(11597, Integer.valueOf(i), Integer.valueOf(1));
                    g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_EMOJI_REPORT_CUSTOM_EMOJI_COUNT_LONG, Long.valueOf(System.currentTimeMillis()));
                }
                AppMethodBeat.o(52811);
                return false;
            }
        }
        i = 0;
        if (i != 0) {
        }
        if (System.currentTimeMillis() - ((Long) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_EMOJI_REPORT_CUSTOM_EMOJI_COUNT_LONG, Long.valueOf(0))).longValue() > 86400000) {
        }
        AppMethodBeat.o(52811);
        return false;
    }
}
