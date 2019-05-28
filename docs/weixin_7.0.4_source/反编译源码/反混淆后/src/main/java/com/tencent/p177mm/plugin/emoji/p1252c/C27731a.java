package com.tencent.p177mm.plugin.emoji.p1252c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C6523mp;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.plugin.emoji.p726f.C11554d;
import com.tencent.p177mm.plugin.emoji.p726f.C20375n;
import com.tencent.p177mm.plugin.emoji.p726f.C27737e;
import com.tencent.p177mm.plugin.emoji.p726f.C45857s;
import com.tencent.p177mm.plugin.emoji.sync.p948a.C11561d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.emoji.c.a */
public final class C27731a extends C4884c<C6523mp> {
    public C27731a() {
        AppMethodBeat.m2504i(52807);
        this.xxI = C6523mp.class.getName().hashCode();
        AppMethodBeat.m2505o(52807);
    }

    /* renamed from: gm */
    public static void m44046gm(boolean z) {
        long j;
        int i;
        AppMethodBeat.m2504i(52808);
        Object obj = C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_EMOJI_SYNC_STORE_EMOJI_UPLODD_LONG, null);
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
            C4990ab.m7417i("MicroMsg.emoji.EmojiPostTaskListener", "uploadStoreEmoji need upload:%b", Boolean.valueOf(C42952j.getEmojiStorageMgr().xYo.duJ()));
            if (C42952j.getEmojiStorageMgr().xYo.duJ() || z) {
                C1720g.m3535RO().eJo.mo14541a(new C45857s(C42952j.getEmojiStorageMgr().xYo.duL(), 1), 0);
                AppMethodBeat.m2505o(52808);
                return;
            }
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_SYNC_STORE_EMOJI_UPLODD_FINISH_BOOLEAN, Boolean.TRUE);
        }
        AppMethodBeat.m2505o(52808);
    }

    /* renamed from: gn */
    public static void m44047gn(boolean z) {
        int i;
        AppMethodBeat.m2504i(52809);
        boolean i2;
        if (C5046bo.m7517a((Boolean) C1720g.m3536RP().mo5239Ry().get(348165, null), false)) {
            long j;
            Object obj = C1720g.m3536RP().mo5239Ry().get(348166, null);
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
            ArrayList dvh = C42952j.getEmojiStorageMgr().xYn.dvh();
            if (dvh.size() > 0) {
                C4990ab.m7417i("MicroMsg.emoji.EmojiPostTaskListener", "try to sync emoji uploadEmojiList:%d", Integer.valueOf(dvh.size()));
                ArrayList arrayList = new ArrayList();
                int size = dvh.size();
                for (int i3 = 0; i3 < size; i3++) {
                    arrayList.add(new C11561d((String) dvh.get(i3)));
                    C4990ab.m7417i("MicroMsg.emoji.EmojiPostTaskListener", "try to sync emoji upload Emoji:%s", dvh.get(i3));
                }
                C42952j.bkj().kXj.mo7137bt(arrayList);
                C42952j.bkj().kXj.bkG();
            } else {
                C4990ab.m7416i("MicroMsg.emoji.EmojiPostTaskListener", "no things need to upload.");
                C1720g.m3536RP().mo5239Ry().set(348165, Boolean.FALSE);
            }
            C1720g.m3536RP().mo5239Ry().set(348166, Long.valueOf(System.currentTimeMillis()));
        }
        AppMethodBeat.m2505o(52809);
    }

    public static void bjE() {
        int i;
        AppMethodBeat.m2504i(52810);
        boolean a = C5046bo.m7517a((Boolean) C1720g.m3536RP().mo5239Ry().get(348162, null), false);
        boolean i2;
        if (C5046bo.m7517a((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_EMOJI_BACKUP_OVERSIZE_BOOLEAN, null), false) || !a) {
            i2 = false;
        } else {
            long j;
            Object obj = C1720g.m3536RP().mo5239Ry().get(348163, null);
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
            C4990ab.m7416i("MicroMsg.emoji.EmojiPostTaskListener", "[cpan] start do backup emoji.");
            ArrayList arrayList = (ArrayList) C42952j.getEmojiStorageMgr().xYn.mo48564Mz(0);
            if (arrayList.size() <= 0) {
                C4990ab.m7416i("MicroMsg.emoji.EmojiPostTaskListener", "[cpan] no local emoji need not to backup ");
                C1720g.m3536RP().mo5239Ry().set(348162, Boolean.FALSE);
                AppMethodBeat.m2505o(52810);
                return;
            }
            C1720g.m3536RP().mo5239Ry().set(348163, Long.valueOf(System.currentTimeMillis()));
            C4990ab.m7416i("MicroMsg.emoji.EmojiPostTaskListener", "[cpan] start backup local emoji ");
            if (arrayList.size() > 50) {
                int size = arrayList.size();
                C4990ab.m7417i("MicroMsg.emoji.EmojiPostTaskListener", "count:%d", Integer.valueOf(size / 50));
                for (int i3 = 0; i3 <= r6; i3++) {
                    ArrayList arrayList2 = new ArrayList();
                    int i4 = i3 * 50;
                    int i5 = ((i3 + 1) * 50) + -1 >= size ? size : (i3 + 1) * 50;
                    C4990ab.m7417i("MicroMsg.emoji.EmojiPostTaskListener", "start index:%d to index:%d", Integer.valueOf(i4), Integer.valueOf(i5));
                    if (i5 > i4) {
                        arrayList2.addAll(arrayList.subList(i4, i5));
                        C1720g.m3535RO().eJo.mo14541a(new C11554d(arrayList2), 0);
                    }
                }
                AppMethodBeat.m2505o(52810);
                return;
            }
            C1720g.m3535RO().eJo.mo14541a(new C11554d(arrayList), 0);
        }
        AppMethodBeat.m2505o(52810);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x011f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        int i;
        AppMethodBeat.m2504i(52811);
        C27731a.bjE();
        boolean booleanValue = ((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_EMOJI_SYNC_CUSTOM_EMOJI_BATCH_DOWNLOAD_BOOLEAN, Boolean.TRUE)).booleanValue();
        if (System.currentTimeMillis() <= ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_EMOJI_NEXT_CUSTOM_BATCH_DOWNLOAD_TIME_LONG, Long.valueOf(0))).longValue() || !booleanValue) {
            i = 0;
        } else {
            i = 1;
        }
        if (i != 0) {
            C1720g.m3535RO().eJo.mo14541a(new C27737e(0), 0);
        }
        booleanValue = ((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_EMOJI_SYNC_CAPTURE_EMOJI_BATCH_DOWNLOAD_BOOLEAN, Boolean.TRUE)).booleanValue();
        long longValue = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_EMOJI_NEXT_CAPTURE_BATCH_DOWNLOAD_TIME_LONG, Long.valueOf(0))).longValue();
        if (booleanValue && System.currentTimeMillis() > longValue) {
            C1720g.m3535RO().eJo.mo14541a(new C27737e(1), 0);
        }
        C27731a.m44047gn(false);
        C27731a.m44046gm(false);
        if (((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_EMOJI_SYNC_STORE_EMOJI_UPLODD_FINISH_BOOLEAN, Boolean.FALSE)).booleanValue()) {
            long j;
            Object obj = C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_EMOJI_SYNC_STORE_EMOJI_DOWNLOAD_LONG, null);
            if (obj == null || !(obj instanceof Long)) {
                j = 0;
            } else {
                j = ((Long) obj).longValue();
            }
            if (System.currentTimeMillis() - j > 86400000) {
                i = 1;
                if (i != 0) {
                    C1720g.m3535RO().eJo.mo14541a(new C20375n(8, 15), 0);
                }
                if (System.currentTimeMillis() - ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_EMOJI_REPORT_CUSTOM_EMOJI_COUNT_LONG, Long.valueOf(0))).longValue() > 86400000) {
                    i = C42952j.getEmojiStorageMgr().xYn.mo48592y(false, true);
                    C7060h.pYm.mo8381e(11597, Integer.valueOf(i), Integer.valueOf(0));
                    i = C42952j.getEmojiStorageMgr().xYn.mo48589pr(true);
                    C7060h.pYm.mo8381e(11597, Integer.valueOf(i), Integer.valueOf(1));
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_REPORT_CUSTOM_EMOJI_COUNT_LONG, Long.valueOf(System.currentTimeMillis()));
                }
                AppMethodBeat.m2505o(52811);
                return false;
            }
        }
        i = 0;
        if (i != 0) {
        }
        if (System.currentTimeMillis() - ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_EMOJI_REPORT_CUSTOM_EMOJI_COUNT_LONG, Long.valueOf(0))).longValue() > 86400000) {
        }
        AppMethodBeat.m2505o(52811);
        return false;
    }
}
