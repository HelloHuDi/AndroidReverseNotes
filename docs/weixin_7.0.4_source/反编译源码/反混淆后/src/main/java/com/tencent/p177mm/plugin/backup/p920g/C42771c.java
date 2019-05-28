package com.tencent.p177mm.plugin.backup.p920g;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.hardcoder.C1625i;
import com.tencent.p177mm.jniinterface.AesEcb;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.plugin.backup.p346f.C33701j;
import com.tencent.p177mm.plugin.backup.p921i.C27495x;
import com.tencent.p177mm.plugin.backup.p921i.C38665y;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.pointers.PByteArray;
import com.tencent.p177mm.protocal.protobuf.C40522gu;
import com.tencent.p177mm.protocal.protobuf.C46545gv;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.p177mm.vfs.C5730e;
import java.io.FileInputStream;
import java.util.HashSet;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.backup.g.c */
public final class C42771c extends C19978b {
    private static String TAG = "MicroMsg.BackupDataPushScene";
    private C1202f fur;
    private PByteArray jxc = new PByteArray();
    public C27495x jxp = new C27495x();
    private C38665y jxq = new C38665y();
    private int jxr = 0;
    private C27488a jxs = null;

    /* renamed from: com.tencent.mm.plugin.backup.g.c$b */
    public interface C19983b {
        /* renamed from: g */
        void mo22851g(boolean z, String str, int i);
    }

    /* renamed from: com.tencent.mm.plugin.backup.g.c$a */
    static class C27488a {
        private static String TAG = "MicroMsg.BackupDataPushScene.BackFileOp";
        private FileInputStream fileInputStream = null;
        String filePath = null;
        int frO = 0;
        private HashSet<C42771c> jxv = new HashSet();
        byte[] jxw = null;
        int offset = 0;

        public C27488a(String str) {
            int i;
            AppMethodBeat.m2504i(17643);
            this.filePath = str;
            this.jxw = null;
            String str2 = this.filePath;
            C9638aw.m17190ZK();
            if (str2.startsWith(C18628c.m29093Yb())) {
                EmojiInfo Jd = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35596Jd(this.filePath.substring(this.filePath.lastIndexOf("/") + 1));
                if (Jd == null) {
                    i = 0;
                } else if ((Jd.field_reserved4 & EmojiInfo.zZi) != EmojiInfo.zZi) {
                    i = 0;
                } else {
                    this.jxw = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35656l(Jd);
                    if (C5046bo.m7541cc(this.jxw) <= 0) {
                        i = 0;
                    } else {
                        i = 1;
                    }
                }
            } else {
                i = 0;
            }
            if (i != 0) {
                this.frO = C5046bo.m7541cc(this.jxw);
            } else {
                this.frO = (int) C5730e.asZ(this.filePath);
            }
            if (this.frO < 0) {
                this.frO = 0;
            }
            AppMethodBeat.m2505o(17643);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: b */
        public final boolean mo45287b(byte[] bArr, boolean z) {
            AppMethodBeat.m2504i(17644);
            try {
                if (this.fileInputStream == null) {
                    this.fileInputStream = new FileInputStream(this.filePath);
                }
                if (this.fileInputStream.read(bArr) != bArr.length) {
                    AppMethodBeat.m2505o(17644);
                    return false;
                }
                if (z) {
                    this.fileInputStream.close();
                }
                AppMethodBeat.m2505o(17644);
                return true;
            } catch (Exception e) {
                AppMethodBeat.m2505o(17644);
                return false;
            }
        }

        /* renamed from: a */
        static /* synthetic */ boolean m43612a(C27488a c27488a, C42771c c42771c) {
            AppMethodBeat.m2504i(17645);
            if (!c27488a.jxv.contains(c42771c) && c42771c.jxp.jCy == 2) {
                C4990ab.m7412e(TAG, "checkSceneAllFinish Error!! media scene not in sceneHashSet");
            }
            c27488a.jxv.remove(c42771c);
            boolean isEmpty = c27488a.jxv.isEmpty();
            AppMethodBeat.m2505o(17645);
            return isEmpty;
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.g.c$c */
    public interface C42770c {
        /* renamed from: a */
        void mo22852a(C42771c c42771c);
    }

    /* renamed from: a */
    public static void m75836a(C19983b c19983b, C42770c c42770c, String str, String str2, byte[] bArr) {
        int i;
        AppMethodBeat.m2504i(17647);
        C27488a c27488a = new C27488a(str2);
        if (c27488a.frO <= 0) {
            i = 1;
        } else {
            i = (int) (((long) c27488a.frO) / C1625i.ACTION_MINI_PROGRAM_LAUNCH);
            if (((long) c27488a.frO) % C1625i.ACTION_MINI_PROGRAM_LAUNCH != 0) {
                i++;
            }
        }
        for (int i2 = 0; i2 < i; i2++) {
            c42770c.mo22852a(new C42771c(c19983b, str, c27488a, bArr));
        }
        AppMethodBeat.m2505o(17647);
    }

    /* renamed from: a */
    public static void m75837a(C19983b c19983b, C42770c c42770c, String str, LinkedList<C40522gu> linkedList, byte[] bArr) {
        AppMethodBeat.m2504i(17648);
        c42770c.mo22852a(new C42771c(c19983b, str, (LinkedList) linkedList, bArr));
        AppMethodBeat.m2505o(17648);
    }

    private C42771c(final C19983b c19983b, String str, C27488a c27488a, byte[] bArr) {
        Pair pair;
        AppMethodBeat.m2504i(17649);
        this.jxp.jCx = str;
        this.jxp.jCy = 2;
        this.fur = new C1202f() {
            public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                AppMethodBeat.m2504i(17641);
                C42771c c42771c = (C42771c) c1207m;
                c19983b.mo22851g(C27488a.m43612a(c42771c.jxs, c42771c), c42771c.jxp.jCx, c42771c.aUj());
                AppMethodBeat.m2505o(17641);
            }
        };
        this.jxs = c27488a;
        C27488a.m43613b(c27488a, this);
        C27488a c27488a2 = this.jxs;
        if (c27488a2.frO <= 0) {
            pair = new Pair(Integer.valueOf(0), new byte[0]);
        } else {
            int i = (int) (((long) (c27488a2.frO - c27488a2.offset)) > C1625i.ACTION_MINI_PROGRAM_LAUNCH ? C1625i.ACTION_MINI_PROGRAM_LAUNCH : (long) (c27488a2.frO - c27488a2.offset));
            byte[] bArr2 = new byte[i];
            if (c27488a2.jxw != null) {
                System.arraycopy(c27488a2.jxw, c27488a2.offset, bArr2, 0, i);
            } else {
                c27488a2.mo45287b(bArr2, ((long) i) < C1625i.ACTION_MINI_PROGRAM_LAUNCH);
            }
            int i2 = c27488a2.offset;
            c27488a2.offset += i;
            pair = new Pair(Integer.valueOf(i2), bArr2);
        }
        if (pair.second == null || pair.first == null) {
            C4990ab.m7421w(TAG, "BackupDataPushScene media backFileOp getNext error, file path:%s", this.jxs.filePath);
            this.jxp.jBi = null;
            AppMethodBeat.m2505o(17649);
            return;
        }
        byte[] bArr3 = (byte[]) pair.second;
        this.jxp.jCz = this.jxs.frO;
        this.jxp.jCA = ((Integer) pair.first).intValue();
        this.jxp.jCB = this.jxp.jCA + bArr3.length;
        this.jxp.jBi = C42771c.m75835a(bArr3, this.jxp.jCB == this.jxp.jCz, bArr);
        aUi();
        AppMethodBeat.m2505o(17649);
    }

    private C42771c(final C19983b c19983b, String str, LinkedList<C40522gu> linkedList, byte[] bArr) {
        byte[] toByteArray;
        AppMethodBeat.m2504i(17650);
        this.jxp.jCx = str;
        this.jxp.jCy = 1;
        this.fur = new C1202f() {
            public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                AppMethodBeat.m2504i(17642);
                C42771c c42771c = (C42771c) c1207m;
                c19983b.mo22851g(true, c42771c.jxp.jCx, c42771c.aUj());
                AppMethodBeat.m2505o(17642);
            }
        };
        try {
            C46545gv c46545gv = new C46545gv();
            c46545gv.jBw = linkedList;
            c46545gv.jBv = linkedList.size();
            toByteArray = c46545gv.toByteArray();
        } catch (Exception e) {
            Exception exception = e;
            String str2 = TAG;
            String str3 = "BackupDataPushScene text, BakChatMsgList to buf error, list size[%d], errMsg:%s";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(linkedList == null ? -1 : linkedList.size());
            objArr[1] = exception.getMessage();
            C4990ab.m7413e(str2, str3, objArr);
            toByteArray = null;
        }
        if (toByteArray == null) {
            toByteArray = new byte[0];
        }
        this.jxp.jCA = 0;
        this.jxp.jCB = toByteArray.length;
        this.jxp.jCz = toByteArray.length;
        this.jxp.jBi = C42771c.m75835a(toByteArray, true, bArr);
        aUi();
        AppMethodBeat.m2505o(17650);
    }

    /* renamed from: rw */
    public final void mo6711rw(int i) {
        AppMethodBeat.m2504i(17651);
        this.fur.onSceneEnd(0, this.jxq.jBT, "", this);
        AppMethodBeat.m2505o(17651);
    }

    private void aUi() {
        AppMethodBeat.m2504i(17652);
        this.jxr = C19978b.aUe();
        try {
            C33701j.m55070a(this.jxp.toByteArray(), this.jxr, (short) 6, this.jxc, C19978b.jqS);
            mo35225a(this.jxr, this.jxc);
            AppMethodBeat.m2505o(17652);
        } catch (Exception e) {
            C4990ab.printErrStackTrace(TAG, e, "PacketBackupDataPush to buf fail:%s", e.toString());
            AppMethodBeat.m2505o(17652);
        }
    }

    public final boolean aUc() {
        AppMethodBeat.m2504i(17653);
        byte[] bArr = this.jxc.value;
        int i = this.jxr;
        if (C19978b.jxg != null) {
            C4990ab.m7417i("MicroMsg.BackupBaseScene", "doSceneSameThread ret[%d], sendSeq[%d], type[%d], buflen[%d]", Integer.valueOf(C19978b.jxg.mo35223j(i, bArr)), Integer.valueOf(i), Integer.valueOf(getType()), Integer.valueOf(bArr.length));
        }
        AppMethodBeat.m2505o(17653);
        return true;
    }

    /* renamed from: a */
    private static C1332b m75835a(byte[] bArr, boolean z, byte[] bArr2) {
        AppMethodBeat.m2504i(17654);
        C1332b c1332b;
        if (C5046bo.m7541cc(bArr2) <= 0 || C5046bo.m7541cc(bArr) <= 0) {
            c1332b = new C1332b(bArr);
            AppMethodBeat.m2505o(17654);
            return c1332b;
        }
        c1332b = new C1332b(AesEcb.aesCryptEcb(bArr, bArr2, true, z));
        AppMethodBeat.m2505o(17654);
        return c1332b;
    }

    public final int aUj() {
        if (this.jxc.value == null) {
            return 0;
        }
        return this.jxc.value.length;
    }

    public final C1331a aTS() {
        return this.jxq;
    }

    public final C1331a aTT() {
        return this.jxp;
    }

    public final int getType() {
        return 6;
    }
}
