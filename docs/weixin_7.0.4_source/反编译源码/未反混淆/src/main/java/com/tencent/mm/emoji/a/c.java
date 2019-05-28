package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.protocal.protobuf.ckw;
import com.tencent.mm.protocal.protobuf.ckx;
import com.tencent.mm.protocal.protobuf.ye;
import com.tencent.mm.protocal.protobuf.yf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.List;

public final class c {
    private static int eyF = 98304;
    private static int eyG = 4;
    private boolean bcU = false;
    private final EmojiInfo exP;
    private boolean eyH;
    private boolean eyI;
    private String eyJ;
    private List<String> eyK;
    private String eyL;
    public b eyM;
    private List<c> eyN = new ArrayList();
    private int eyO;
    private int eyP = 2;
    private int eyQ;
    private long eyR;
    private boolean eyS;

    public interface b {
        void b(int i, int i2, String str, boolean z);
    }

    public class a extends com.tencent.mm.ai.a<yf> {
        public a(EmojiInfo emojiInfo, c cVar, boolean z, boolean z2, String str, List<String> list, String str2) {
            AppMethodBeat.i(62242);
            ye yeVar = new ye();
            ckw ckw = new ckw();
            ckw.wdO = emojiInfo.Aq();
            ckw.ptx = cVar.start;
            ckw.ptw = emojiInfo.field_size;
            ckw.xiE = z;
            ckw.wdD = str;
            ckw.xiG = str2;
            ckw.wdF = emojiInfo.field_lensId;
            ckw.wdE = emojiInfo.field_attachTextColor;
            if (list != null) {
                ckw.xiF.addAll(list);
            }
            yeVar.vIK = z ? 1 : 0;
            yeVar.wdV.add(ckw);
            yeVar.wdX = z2;
            ckw.xiD = new com.tencent.mm.bt.b(a(emojiInfo, cVar.start, cVar.cde));
            com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
            aVar.fsJ = yeVar;
            aVar.fsK = new yf();
            aVar.uri = "/cgi-bin/micromsg-bin/mmemojiupload";
            aVar.fsI = 703;
            this.ehh = aVar.acD();
            AppMethodBeat.o(62242);
        }

        private byte[] a(EmojiInfo emojiInfo, int i, int i2) {
            byte[] bArr;
            AppMethodBeat.i(62243);
            if ((emojiInfo.field_reserved4 & EmojiInfo.zZi) == EmojiInfo.zZi) {
                byte[] l = ((d) g.M(d.class)).getProvider().l(emojiInfo);
                if (bo.cb(l)) {
                    ab.w("CgiEmojiUpload", "buffer is null.");
                    bArr = new byte[0];
                } else {
                    bArr = new byte[i2];
                    ab.d("CgiEmojiUpload", "total length:%d dataLen:%d ", Integer.valueOf(l.length), Integer.valueOf(i2));
                    System.arraycopy(l, i, bArr, 0, i2);
                }
            } else {
                synchronized (c.this.exP) {
                    try {
                        emojiInfo.field_start = i;
                        bArr = emojiInfo.gZ(i, i2);
                        emojiInfo.field_start = 0;
                    } catch (Throwable th) {
                        AppMethodBeat.o(62243);
                    }
                }
            }
            if (bArr == null) {
                bArr = new byte[0];
            }
            AppMethodBeat.o(62243);
            return bArr;
        }
    }

    class c {
        public int cde;
        public boolean eyV;
        public int index;
        public int retryCount;
        public boolean running;
        public int start;

        private c() {
        }

        /* synthetic */ c(c cVar, byte b) {
            this();
        }
    }

    static /* synthetic */ void a(c cVar, int i, int i2, String str, boolean z) {
        AppMethodBeat.i(62247);
        cVar.a(i, i2, str, z);
        AppMethodBeat.o(62247);
    }

    public c(EmojiInfo emojiInfo, boolean z, boolean z2, String str, List<String> list, String str2) {
        int i;
        AppMethodBeat.i(62244);
        ab.i("MicroMsg.EmojiUploadHelper", "EmojiUploadHelper: isCapture %s", Boolean.valueOf(z));
        this.exP = emojiInfo;
        this.eyH = z;
        this.eyI = z2;
        this.eyJ = str;
        this.eyK = list;
        this.eyL = str2;
        this.eyR = System.currentTimeMillis();
        int i2 = emojiInfo.field_size;
        int ceil = (int) Math.ceil((((double) i2) * 1.0d) / ((double) eyF));
        this.eyO = ceil * 2;
        this.eyQ = 0;
        for (int i3 = 0; i3 < ceil; i3++) {
            int i4 = i3 * eyF;
            i = eyF;
            if (i4 + i > i2) {
                i = i2 - i4;
            }
            c cVar = new c(this, (byte) 0);
            cVar.index = i3;
            cVar.start = i4;
            cVar.cde = i;
            this.eyN.add(cVar);
        }
        ab.i("MicroMsg.EmojiUploadHelper", "start upload emoji, md5 %s, totalLen %d, parts %d, file %s", emojiInfo.Aq(), Integer.valueOf(i2), Integer.valueOf(ceil), emojiInfo.dve());
        for (i = 0; i < eyG; i++) {
            OI();
        }
        AppMethodBeat.o(62244);
    }

    public final void a(b bVar) {
        this.eyM = bVar;
    }

    private synchronized void OI() {
        c cVar = null;
        Object obj = 1;
        Object obj2 = null;
        synchronized (this) {
            AppMethodBeat.i(62245);
            if (this.bcU) {
                AppMethodBeat.o(62245);
            } else {
                for (c cVar2 : this.eyN) {
                    Object obj3;
                    if (cVar2.eyV) {
                        obj3 = obj;
                    } else if (!cVar2.running) {
                        cVar = cVar2;
                        break;
                    } else {
                        obj3 = null;
                    }
                    obj = obj3;
                }
                obj2 = obj;
                if (cVar == null) {
                    if (obj2 != null) {
                        ab.w("MicroMsg.EmojiUploadHelper", "all parts finished but not completed");
                        a(4, 4, null, false);
                    }
                    AppMethodBeat.o(62245);
                } else if (this.eyQ >= this.eyO) {
                    ab.w("MicroMsg.EmojiUploadHelper", "req count is %d, max is %d; toRun part is %d", Integer.valueOf(this.eyQ), Integer.valueOf(this.eyO), Integer.valueOf(cVar.index));
                    a(3, -2, null, false);
                    AppMethodBeat.o(62245);
                } else {
                    this.eyQ++;
                    cVar.retryCount++;
                    cVar.running = true;
                    ab.i("MicroMsg.EmojiUploadHelper", "start part %d, retry count %d", Integer.valueOf(cVar.index), Integer.valueOf(cVar.retryCount));
                    new a(this.exP, cVar, this.eyH, this.eyI, this.eyJ, this.eyK, this.eyL).acy().g(new com.tencent.mm.vending.c.a<Void, com.tencent.mm.ai.a.a<yf>>() {
                        public final /* synthetic */ Object call(Object obj) {
                            AppMethodBeat.i(62241);
                            com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
                            int i = aVar.errType;
                            int i2 = aVar.errCode;
                            cVar.running = false;
                            if (i == 0 && i2 == 0) {
                                Object obj2;
                                yf yfVar = (yf) aVar.fsy;
                                if (yfVar.wdV.size() <= 0) {
                                    ab.w("MicroMsg.EmojiUploadHelper", "part %d resp size error, size is %d", Integer.valueOf(cVar.index), Integer.valueOf(yfVar.wdV.size()));
                                    c.a(c.this, i, i2, null, false);
                                } else {
                                    ckx ckx = (ckx) yfVar.wdV.get(0);
                                    if (ckx == null) {
                                        ab.e("MicroMsg.EmojiUploadHelper", "part %d resp info is null", Integer.valueOf(cVar.index));
                                        c.a(c.this, 4, -2, null, false);
                                    } else if (ckx.xiI) {
                                        ab.e("MicroMsg.EmojiUploadHelper", "part %d resp info IsTooLarge", Integer.valueOf(cVar.index));
                                        c.a(c.this, 3, -2, null, true);
                                    } else if (ckx.Ret != 0) {
                                        ab.w("MicroMsg.EmojiUploadHelper", "part %d resp info error, md5 is %s, ret is %d", Integer.valueOf(cVar.index), ckx.wdO, Integer.valueOf(ckx.Ret));
                                        if (ckx.Ret == -1) {
                                            c.a(c.this);
                                        } else {
                                            c.a(c.this, 4, ckx.Ret, null, false);
                                        }
                                        obj2 = zXH;
                                        AppMethodBeat.o(62241);
                                        return obj2;
                                    } else {
                                        cVar.eyV = true;
                                        ab.i("MicroMsg.EmojiUploadHelper", "finish part %d. completed %b", Integer.valueOf(cVar.index), Boolean.valueOf(ckx.xiH));
                                        if (ckx.xiH) {
                                            c.this.exP.field_activityid = ckx.wot;
                                            c.a(c.this, ckx.wdO);
                                            c.this.bcU = true;
                                            long currentTimeMillis = System.currentTimeMillis() - c.this.eyR;
                                            ab.i("MicroMsg.EmojiUploadHelper", "complete cost %d, size %d, rate %d", Long.valueOf(currentTimeMillis), Integer.valueOf(c.this.exP.field_size), Long.valueOf(((long) c.this.exP.field_size) / currentTimeMillis));
                                            ab.i("MicroMsg.EmojiUploadHelper", "gif md5 is %s", ckx.wdO);
                                            c.a(c.this, i, i2, ckx.wdO, false);
                                        } else {
                                            c.a(c.this);
                                        }
                                    }
                                }
                                obj2 = zXH;
                                AppMethodBeat.o(62241);
                                return obj2;
                            }
                            ab.e("MicroMsg.EmojiUploadHelper", "part %d code or type error, code is %d, type is %d", Integer.valueOf(cVar.index), Integer.valueOf(i2), Integer.valueOf(i));
                            if (!at.isConnected(ah.getContext())) {
                                c.a(c.this, 3, 5, null, false);
                            } else if (at.isWifi(ah.getContext())) {
                                c.a(c.this, 3, 6, null, false);
                            } else {
                                c.a(c.this, 3, 7, null, false);
                            }
                            Void voidR = zXH;
                            AppMethodBeat.o(62241);
                            return voidR;
                        }
                    });
                    AppMethodBeat.o(62245);
                }
            }
        }
    }

    private void a(int i, int i2, String str, boolean z) {
        AppMethodBeat.i(62246);
        if (!(this.eyM == null || this.eyS)) {
            b bVar;
            this.eyS = true;
            if (i2 == -434) {
                if (this.eyH) {
                    bVar = b.eyD;
                    b.cf(true);
                    g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_EMOJI_SYNC_CAPTURE_EMOJI_BATCH_DOWNLOAD_BOOLEAN, Boolean.TRUE);
                } else {
                    bVar = b.eyD;
                    b.ce(true);
                    g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_EMOJI_SYNC_CUSTOM_EMOJI_BATCH_DOWNLOAD_BOOLEAN, Boolean.TRUE);
                }
            }
            this.eyM.b(i, i2, str, z);
            if (i2 == 0) {
                if (this.eyH) {
                    a.OB().cd(true);
                } else {
                    a.OB().cb(true);
                    a.OB().ca(true);
                }
                bVar = b.eyD;
                b.OG();
            }
        }
        AppMethodBeat.o(62246);
    }

    static /* synthetic */ void a(c cVar, String str) {
        AppMethodBeat.i(62249);
        ab.d("MicroMsg.EmojiUploadHelper", "save emoji gif md5, wxam %b, md5 %s", Boolean.valueOf(cVar.exP.duV()), str);
        if (!cVar.exP.duV() || bo.isNullOrNil(str)) {
            ((d) g.M(d.class)).getEmojiStorageMgr().xYn.G(cVar.exP);
            AppMethodBeat.o(62249);
            return;
        }
        e.y(cVar.exP.dve(), EmojiInfo.dvg() + str);
        ((d) g.M(d.class)).getEmojiStorageMgr().xYn.aqj(cVar.exP.field_md5);
        cVar.exP.field_md5 = str;
        ((d) g.M(d.class)).getEmojiStorageMgr().xYn.E(cVar.exP);
        AppMethodBeat.o(62249);
    }
}
