package com.tencent.p177mm.emoji.p227a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.protocal.protobuf.C15399ye;
import com.tencent.p177mm.protocal.protobuf.C15400yf;
import com.tencent.p177mm.protocal.protobuf.ckw;
import com.tencent.p177mm.protocal.protobuf.ckx;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vfs.C5730e;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.emoji.a.c */
public final class C1506c {
    private static int eyF = 98304;
    private static int eyG = 4;
    private boolean bcU = false;
    private final EmojiInfo exP;
    private boolean eyH;
    private boolean eyI;
    private String eyJ;
    private List<String> eyK;
    private String eyL;
    public C1507b eyM;
    private List<C1509c> eyN = new ArrayList();
    private int eyO;
    private int eyP = 2;
    private int eyQ;
    private long eyR;
    private boolean eyS;

    /* renamed from: com.tencent.mm.emoji.a.c$b */
    public interface C1507b {
        /* renamed from: b */
        void mo4971b(int i, int i2, String str, boolean z);
    }

    /* renamed from: com.tencent.mm.emoji.a.c$a */
    public class C1508a extends C37440a<C15400yf> {
        public C1508a(EmojiInfo emojiInfo, C1509c c1509c, boolean z, boolean z2, String str, List<String> list, String str2) {
            AppMethodBeat.m2504i(62242);
            C15399ye c15399ye = new C15399ye();
            ckw ckw = new ckw();
            ckw.wdO = emojiInfo.mo20410Aq();
            ckw.ptx = c1509c.start;
            ckw.ptw = emojiInfo.field_size;
            ckw.xiE = z;
            ckw.wdD = str;
            ckw.xiG = str2;
            ckw.wdF = emojiInfo.field_lensId;
            ckw.wdE = emojiInfo.field_attachTextColor;
            if (list != null) {
                ckw.xiF.addAll(list);
            }
            c15399ye.vIK = z ? 1 : 0;
            c15399ye.wdV.add(ckw);
            c15399ye.wdX = z2;
            ckw.xiD = new C1332b(m3147a(emojiInfo, c1509c.start, c1509c.cde));
            C1196a c1196a = new C1196a();
            c1196a.fsJ = c15399ye;
            c1196a.fsK = new C15400yf();
            c1196a.uri = "/cgi-bin/micromsg-bin/mmemojiupload";
            c1196a.fsI = 703;
            this.ehh = c1196a.acD();
            AppMethodBeat.m2505o(62242);
        }

        /* renamed from: a */
        private byte[] m3147a(EmojiInfo emojiInfo, int i, int i2) {
            byte[] bArr;
            AppMethodBeat.m2504i(62243);
            if ((emojiInfo.field_reserved4 & EmojiInfo.zZi) == EmojiInfo.zZi) {
                byte[] l = ((C6835d) C1720g.m3530M(C6835d.class)).getProvider().mo35656l(emojiInfo);
                if (C5046bo.m7540cb(l)) {
                    C4990ab.m7420w("CgiEmojiUpload", "buffer is null.");
                    bArr = new byte[0];
                } else {
                    bArr = new byte[i2];
                    C4990ab.m7411d("CgiEmojiUpload", "total length:%d dataLen:%d ", Integer.valueOf(l.length), Integer.valueOf(i2));
                    System.arraycopy(l, i, bArr, 0, i2);
                }
            } else {
                synchronized (C1506c.this.exP) {
                    try {
                        emojiInfo.field_start = i;
                        bArr = emojiInfo.mo48536gZ(i, i2);
                        emojiInfo.field_start = 0;
                    } catch (Throwable th) {
                        AppMethodBeat.m2505o(62243);
                    }
                }
            }
            if (bArr == null) {
                bArr = new byte[0];
            }
            AppMethodBeat.m2505o(62243);
            return bArr;
        }
    }

    /* renamed from: com.tencent.mm.emoji.a.c$c */
    class C1509c {
        public int cde;
        public boolean eyV;
        public int index;
        public int retryCount;
        public boolean running;
        public int start;

        private C1509c() {
        }

        /* synthetic */ C1509c(C1506c c1506c, byte b) {
            this();
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m3140a(C1506c c1506c, int i, int i2, String str, boolean z) {
        AppMethodBeat.m2504i(62247);
        c1506c.m3138a(i, i2, str, z);
        AppMethodBeat.m2505o(62247);
    }

    public C1506c(EmojiInfo emojiInfo, boolean z, boolean z2, String str, List<String> list, String str2) {
        int i;
        AppMethodBeat.m2504i(62244);
        C4990ab.m7417i("MicroMsg.EmojiUploadHelper", "EmojiUploadHelper: isCapture %s", Boolean.valueOf(z));
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
            C1509c c1509c = new C1509c(this, (byte) 0);
            c1509c.index = i3;
            c1509c.start = i4;
            c1509c.cde = i;
            this.eyN.add(c1509c);
        }
        C4990ab.m7417i("MicroMsg.EmojiUploadHelper", "start upload emoji, md5 %s, totalLen %d, parts %d, file %s", emojiInfo.mo20410Aq(), Integer.valueOf(i2), Integer.valueOf(ceil), emojiInfo.dve());
        for (i = 0; i < eyG; i++) {
            m3137OI();
        }
        AppMethodBeat.m2505o(62244);
    }

    /* renamed from: a */
    public final void mo4970a(C1507b c1507b) {
        this.eyM = c1507b;
    }

    /* renamed from: OI */
    private synchronized void m3137OI() {
        C1509c c1509c = null;
        Object obj = 1;
        Object obj2 = null;
        synchronized (this) {
            AppMethodBeat.m2504i(62245);
            if (this.bcU) {
                AppMethodBeat.m2505o(62245);
            } else {
                for (C1509c c1509c2 : this.eyN) {
                    Object obj3;
                    if (c1509c2.eyV) {
                        obj3 = obj;
                    } else if (!c1509c2.running) {
                        c1509c = c1509c2;
                        break;
                    } else {
                        obj3 = null;
                    }
                    obj = obj3;
                }
                obj2 = obj;
                if (c1509c == null) {
                    if (obj2 != null) {
                        C4990ab.m7420w("MicroMsg.EmojiUploadHelper", "all parts finished but not completed");
                        m3138a(4, 4, null, false);
                    }
                    AppMethodBeat.m2505o(62245);
                } else if (this.eyQ >= this.eyO) {
                    C4990ab.m7421w("MicroMsg.EmojiUploadHelper", "req count is %d, max is %d; toRun part is %d", Integer.valueOf(this.eyQ), Integer.valueOf(this.eyO), Integer.valueOf(c1509c.index));
                    m3138a(3, -2, null, false);
                    AppMethodBeat.m2505o(62245);
                } else {
                    this.eyQ++;
                    c1509c.retryCount++;
                    c1509c.running = true;
                    C4990ab.m7417i("MicroMsg.EmojiUploadHelper", "start part %d, retry count %d", Integer.valueOf(c1509c.index), Integer.valueOf(c1509c.retryCount));
                    new C1508a(this.exP, c1509c, this.eyH, this.eyI, this.eyJ, this.eyK, this.eyL).acy().mo60491g(new C5681a<Void, C37441a<C15400yf>>() {
                        public final /* synthetic */ Object call(Object obj) {
                            AppMethodBeat.m2504i(62241);
                            C37441a c37441a = (C37441a) obj;
                            int i = c37441a.errType;
                            int i2 = c37441a.errCode;
                            c1509c.running = false;
                            if (i == 0 && i2 == 0) {
                                Object obj2;
                                C15400yf c15400yf = (C15400yf) c37441a.fsy;
                                if (c15400yf.wdV.size() <= 0) {
                                    C4990ab.m7421w("MicroMsg.EmojiUploadHelper", "part %d resp size error, size is %d", Integer.valueOf(c1509c.index), Integer.valueOf(c15400yf.wdV.size()));
                                    C1506c.m3140a(C1506c.this, i, i2, null, false);
                                } else {
                                    ckx ckx = (ckx) c15400yf.wdV.get(0);
                                    if (ckx == null) {
                                        C4990ab.m7413e("MicroMsg.EmojiUploadHelper", "part %d resp info is null", Integer.valueOf(c1509c.index));
                                        C1506c.m3140a(C1506c.this, 4, -2, null, false);
                                    } else if (ckx.xiI) {
                                        C4990ab.m7413e("MicroMsg.EmojiUploadHelper", "part %d resp info IsTooLarge", Integer.valueOf(c1509c.index));
                                        C1506c.m3140a(C1506c.this, 3, -2, null, true);
                                    } else if (ckx.Ret != 0) {
                                        C4990ab.m7421w("MicroMsg.EmojiUploadHelper", "part %d resp info error, md5 is %s, ret is %d", Integer.valueOf(c1509c.index), ckx.wdO, Integer.valueOf(ckx.Ret));
                                        if (ckx.Ret == -1) {
                                            C1506c.m3139a(C1506c.this);
                                        } else {
                                            C1506c.m3140a(C1506c.this, 4, ckx.Ret, null, false);
                                        }
                                        obj2 = zXH;
                                        AppMethodBeat.m2505o(62241);
                                        return obj2;
                                    } else {
                                        c1509c.eyV = true;
                                        C4990ab.m7417i("MicroMsg.EmojiUploadHelper", "finish part %d. completed %b", Integer.valueOf(c1509c.index), Boolean.valueOf(ckx.xiH));
                                        if (ckx.xiH) {
                                            C1506c.this.exP.field_activityid = ckx.wot;
                                            C1506c.m3141a(C1506c.this, ckx.wdO);
                                            C1506c.this.bcU = true;
                                            long currentTimeMillis = System.currentTimeMillis() - C1506c.this.eyR;
                                            C4990ab.m7417i("MicroMsg.EmojiUploadHelper", "complete cost %d, size %d, rate %d", Long.valueOf(currentTimeMillis), Integer.valueOf(C1506c.this.exP.field_size), Long.valueOf(((long) C1506c.this.exP.field_size) / currentTimeMillis));
                                            C4990ab.m7417i("MicroMsg.EmojiUploadHelper", "gif md5 is %s", ckx.wdO);
                                            C1506c.m3140a(C1506c.this, i, i2, ckx.wdO, false);
                                        } else {
                                            C1506c.m3139a(C1506c.this);
                                        }
                                    }
                                }
                                obj2 = zXH;
                                AppMethodBeat.m2505o(62241);
                                return obj2;
                            }
                            C4990ab.m7413e("MicroMsg.EmojiUploadHelper", "part %d code or type error, code is %d, type is %d", Integer.valueOf(c1509c.index), Integer.valueOf(i2), Integer.valueOf(i));
                            if (!C5023at.isConnected(C4996ah.getContext())) {
                                C1506c.m3140a(C1506c.this, 3, 5, null, false);
                            } else if (C5023at.isWifi(C4996ah.getContext())) {
                                C1506c.m3140a(C1506c.this, 3, 6, null, false);
                            } else {
                                C1506c.m3140a(C1506c.this, 3, 7, null, false);
                            }
                            Void voidR = zXH;
                            AppMethodBeat.m2505o(62241);
                            return voidR;
                        }
                    });
                    AppMethodBeat.m2505o(62245);
                }
            }
        }
    }

    /* renamed from: a */
    private void m3138a(int i, int i2, String str, boolean z) {
        AppMethodBeat.m2504i(62246);
        if (!(this.eyM == null || this.eyS)) {
            C32498b c32498b;
            this.eyS = true;
            if (i2 == -434) {
                if (this.eyH) {
                    c32498b = C32498b.eyD;
                    C32498b.m53218cf(true);
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_SYNC_CAPTURE_EMOJI_BATCH_DOWNLOAD_BOOLEAN, Boolean.TRUE);
                } else {
                    c32498b = C32498b.eyD;
                    C32498b.m53217ce(true);
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_SYNC_CUSTOM_EMOJI_BATCH_DOWNLOAD_BOOLEAN, Boolean.TRUE);
                }
            }
            this.eyM.mo4971b(i, i2, str, z);
            if (i2 == 0) {
                if (this.eyH) {
                    C32497a.m53203OB().mo53141cd(true);
                } else {
                    C32497a.m53203OB().mo53139cb(true);
                    C32497a.m53203OB().mo53138ca(true);
                }
                c32498b = C32498b.eyD;
                C32498b.m53215OG();
            }
        }
        AppMethodBeat.m2505o(62246);
    }

    /* renamed from: a */
    static /* synthetic */ void m3141a(C1506c c1506c, String str) {
        AppMethodBeat.m2504i(62249);
        C4990ab.m7411d("MicroMsg.EmojiUploadHelper", "save emoji gif md5, wxam %b, md5 %s", Boolean.valueOf(c1506c.exP.duV()), str);
        if (!c1506c.exP.duV() || C5046bo.isNullOrNil(str)) {
            ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiStorageMgr().xYn.mo48555G(c1506c.exP);
            AppMethodBeat.m2505o(62249);
            return;
        }
        C5730e.m8644y(c1506c.exP.dve(), EmojiInfo.dvg() + str);
        ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiStorageMgr().xYn.aqj(c1506c.exP.field_md5);
        c1506c.exP.field_md5 = str;
        ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiStorageMgr().xYn.mo48553E(c1506c.exP);
        AppMethodBeat.m2505o(62249);
    }
}
