package com.tencent.mm.plugin.backup.g;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.hardcoder.i;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.backup.f.j;
import com.tencent.mm.plugin.backup.i.x;
import com.tencent.mm.plugin.backup.i.y;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.gu;
import com.tencent.mm.protocal.protobuf.gv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.e;
import java.io.FileInputStream;
import java.util.HashSet;
import java.util.LinkedList;

public final class c extends b {
    private static String TAG = "MicroMsg.BackupDataPushScene";
    private f fur;
    private PByteArray jxc = new PByteArray();
    public x jxp = new x();
    private y jxq = new y();
    private int jxr = 0;
    private a jxs = null;

    public interface b {
        void g(boolean z, String str, int i);
    }

    static class a {
        private static String TAG = "MicroMsg.BackupDataPushScene.BackFileOp";
        private FileInputStream fileInputStream = null;
        String filePath = null;
        int frO = 0;
        private HashSet<c> jxv = new HashSet();
        byte[] jxw = null;
        int offset = 0;

        public a(String str) {
            int i;
            AppMethodBeat.i(17643);
            this.filePath = str;
            this.jxw = null;
            String str2 = this.filePath;
            aw.ZK();
            if (str2.startsWith(com.tencent.mm.model.c.Yb())) {
                EmojiInfo Jd = ((d) g.M(d.class)).getEmojiMgr().Jd(this.filePath.substring(this.filePath.lastIndexOf("/") + 1));
                if (Jd == null) {
                    i = 0;
                } else if ((Jd.field_reserved4 & EmojiInfo.zZi) != EmojiInfo.zZi) {
                    i = 0;
                } else {
                    this.jxw = ((d) g.M(d.class)).getEmojiMgr().l(Jd);
                    if (bo.cc(this.jxw) <= 0) {
                        i = 0;
                    } else {
                        i = 1;
                    }
                }
            } else {
                i = 0;
            }
            if (i != 0) {
                this.frO = bo.cc(this.jxw);
            } else {
                this.frO = (int) e.asZ(this.filePath);
            }
            if (this.frO < 0) {
                this.frO = 0;
            }
            AppMethodBeat.o(17643);
        }

        /* Access modifiers changed, original: final */
        public final boolean b(byte[] bArr, boolean z) {
            AppMethodBeat.i(17644);
            try {
                if (this.fileInputStream == null) {
                    this.fileInputStream = new FileInputStream(this.filePath);
                }
                if (this.fileInputStream.read(bArr) != bArr.length) {
                    AppMethodBeat.o(17644);
                    return false;
                }
                if (z) {
                    this.fileInputStream.close();
                }
                AppMethodBeat.o(17644);
                return true;
            } catch (Exception e) {
                AppMethodBeat.o(17644);
                return false;
            }
        }

        static /* synthetic */ boolean a(a aVar, c cVar) {
            AppMethodBeat.i(17645);
            if (!aVar.jxv.contains(cVar) && cVar.jxp.jCy == 2) {
                ab.e(TAG, "checkSceneAllFinish Error!! media scene not in sceneHashSet");
            }
            aVar.jxv.remove(cVar);
            boolean isEmpty = aVar.jxv.isEmpty();
            AppMethodBeat.o(17645);
            return isEmpty;
        }
    }

    public interface c {
        void a(c cVar);
    }

    public static void a(b bVar, c cVar, String str, String str2, byte[] bArr) {
        int i;
        AppMethodBeat.i(17647);
        a aVar = new a(str2);
        if (aVar.frO <= 0) {
            i = 1;
        } else {
            i = (int) (((long) aVar.frO) / i.ACTION_MINI_PROGRAM_LAUNCH);
            if (((long) aVar.frO) % i.ACTION_MINI_PROGRAM_LAUNCH != 0) {
                i++;
            }
        }
        for (int i2 = 0; i2 < i; i2++) {
            cVar.a(new c(bVar, str, aVar, bArr));
        }
        AppMethodBeat.o(17647);
    }

    public static void a(b bVar, c cVar, String str, LinkedList<gu> linkedList, byte[] bArr) {
        AppMethodBeat.i(17648);
        cVar.a(new c(bVar, str, (LinkedList) linkedList, bArr));
        AppMethodBeat.o(17648);
    }

    private c(final b bVar, String str, a aVar, byte[] bArr) {
        Pair pair;
        AppMethodBeat.i(17649);
        this.jxp.jCx = str;
        this.jxp.jCy = 2;
        this.fur = new f() {
            public final void onSceneEnd(int i, int i2, String str, m mVar) {
                AppMethodBeat.i(17641);
                c cVar = (c) mVar;
                bVar.g(a.a(cVar.jxs, cVar), cVar.jxp.jCx, cVar.aUj());
                AppMethodBeat.o(17641);
            }
        };
        this.jxs = aVar;
        a.b(aVar, this);
        a aVar2 = this.jxs;
        if (aVar2.frO <= 0) {
            pair = new Pair(Integer.valueOf(0), new byte[0]);
        } else {
            int i = (int) (((long) (aVar2.frO - aVar2.offset)) > i.ACTION_MINI_PROGRAM_LAUNCH ? i.ACTION_MINI_PROGRAM_LAUNCH : (long) (aVar2.frO - aVar2.offset));
            byte[] bArr2 = new byte[i];
            if (aVar2.jxw != null) {
                System.arraycopy(aVar2.jxw, aVar2.offset, bArr2, 0, i);
            } else {
                aVar2.b(bArr2, ((long) i) < i.ACTION_MINI_PROGRAM_LAUNCH);
            }
            int i2 = aVar2.offset;
            aVar2.offset += i;
            pair = new Pair(Integer.valueOf(i2), bArr2);
        }
        if (pair.second == null || pair.first == null) {
            ab.w(TAG, "BackupDataPushScene media backFileOp getNext error, file path:%s", this.jxs.filePath);
            this.jxp.jBi = null;
            AppMethodBeat.o(17649);
            return;
        }
        byte[] bArr3 = (byte[]) pair.second;
        this.jxp.jCz = this.jxs.frO;
        this.jxp.jCA = ((Integer) pair.first).intValue();
        this.jxp.jCB = this.jxp.jCA + bArr3.length;
        this.jxp.jBi = a(bArr3, this.jxp.jCB == this.jxp.jCz, bArr);
        aUi();
        AppMethodBeat.o(17649);
    }

    private c(final b bVar, String str, LinkedList<gu> linkedList, byte[] bArr) {
        byte[] toByteArray;
        AppMethodBeat.i(17650);
        this.jxp.jCx = str;
        this.jxp.jCy = 1;
        this.fur = new f() {
            public final void onSceneEnd(int i, int i2, String str, m mVar) {
                AppMethodBeat.i(17642);
                c cVar = (c) mVar;
                bVar.g(true, cVar.jxp.jCx, cVar.aUj());
                AppMethodBeat.o(17642);
            }
        };
        try {
            gv gvVar = new gv();
            gvVar.jBw = linkedList;
            gvVar.jBv = linkedList.size();
            toByteArray = gvVar.toByteArray();
        } catch (Exception e) {
            Exception exception = e;
            String str2 = TAG;
            String str3 = "BackupDataPushScene text, BakChatMsgList to buf error, list size[%d], errMsg:%s";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(linkedList == null ? -1 : linkedList.size());
            objArr[1] = exception.getMessage();
            ab.e(str2, str3, objArr);
            toByteArray = null;
        }
        if (toByteArray == null) {
            toByteArray = new byte[0];
        }
        this.jxp.jCA = 0;
        this.jxp.jCB = toByteArray.length;
        this.jxp.jCz = toByteArray.length;
        this.jxp.jBi = a(toByteArray, true, bArr);
        aUi();
        AppMethodBeat.o(17650);
    }

    public final void rw(int i) {
        AppMethodBeat.i(17651);
        this.fur.onSceneEnd(0, this.jxq.jBT, "", this);
        AppMethodBeat.o(17651);
    }

    private void aUi() {
        AppMethodBeat.i(17652);
        this.jxr = b.aUe();
        try {
            j.a(this.jxp.toByteArray(), this.jxr, (short) 6, this.jxc, b.jqS);
            a(this.jxr, this.jxc);
            AppMethodBeat.o(17652);
        } catch (Exception e) {
            ab.printErrStackTrace(TAG, e, "PacketBackupDataPush to buf fail:%s", e.toString());
            AppMethodBeat.o(17652);
        }
    }

    public final boolean aUc() {
        AppMethodBeat.i(17653);
        byte[] bArr = this.jxc.value;
        int i = this.jxr;
        if (b.jxg != null) {
            ab.i("MicroMsg.BackupBaseScene", "doSceneSameThread ret[%d], sendSeq[%d], type[%d], buflen[%d]", Integer.valueOf(b.jxg.j(i, bArr)), Integer.valueOf(i), Integer.valueOf(getType()), Integer.valueOf(bArr.length));
        }
        AppMethodBeat.o(17653);
        return true;
    }

    private static com.tencent.mm.bt.b a(byte[] bArr, boolean z, byte[] bArr2) {
        AppMethodBeat.i(17654);
        com.tencent.mm.bt.b bVar;
        if (bo.cc(bArr2) <= 0 || bo.cc(bArr) <= 0) {
            bVar = new com.tencent.mm.bt.b(bArr);
            AppMethodBeat.o(17654);
            return bVar;
        }
        bVar = new com.tencent.mm.bt.b(AesEcb.aesCryptEcb(bArr, bArr2, true, z));
        AppMethodBeat.o(17654);
        return bVar;
    }

    public final int aUj() {
        if (this.jxc.value == null) {
            return 0;
        }
        return this.jxc.value.length;
    }

    public final com.tencent.mm.bt.a aTS() {
        return this.jxq;
    }

    public final com.tencent.mm.bt.a aTT() {
        return this.jxp;
    }

    public final int getType() {
        return 6;
    }
}
