package com.tencent.p177mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.game.p1268a.C45983c;
import com.tencent.p177mm.plugin.game.p731d.C34272cw;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.game.model.aa */
public final class C28219aa {
    public String mAppId = "";
    public List<C28220a> mXO = new LinkedList();

    /* renamed from: com.tencent.mm.plugin.game.model.aa$a */
    public static class C28220a implements Serializable {
        public String cIS;
        public long mEA;
        public int mXP;
        public int mXQ;
        public boolean mXR;
        public String mXS;
        public String tag;
    }

    public C28219aa(String str) {
        AppMethodBeat.m2504i(111366);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(111366);
            return;
        }
        this.mAppId = str;
        this.mXO.addAll(bEH());
        AppMethodBeat.m2505o(111366);
    }

    public C28219aa(String str, List<C34272cw> list) {
        AppMethodBeat.m2504i(111367);
        if (C5046bo.isNullOrNil(str) || list == null || list.isEmpty()) {
            AppMethodBeat.m2505o(111367);
            return;
        }
        this.mAppId = str;
        this.mXO.clear();
        for (C34272cw c34272cw : list) {
            C28220a c28220a = new C28220a();
            c28220a.mXP = c34272cw.ndr;
            c28220a.cIS = c34272cw.jBB;
            c28220a.tag = c34272cw.Label;
            c28220a.mEA = c34272cw.nds;
            c28220a.mXR = c34272cw.ndt;
            c28220a.mXQ = c34272cw.ndu;
            c28220a.mXS = c34272cw.ndv;
            this.mXO.add(c28220a);
        }
        bEI();
        AppMethodBeat.m2505o(111367);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0077 A:{SYNTHETIC, Splitter:B:28:0x0077} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006a A:{SYNTHETIC, Splitter:B:20:0x006a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private List<C28220a> bEH() {
        Throwable e;
        AppMethodBeat.m2504i(111368);
        String str = this.mAppId + "_ranks";
        LinkedList linkedList = new LinkedList();
        byte[] NK = ((C45983c) C1720g.m3528K(C45983c.class)).bCZ().mo54825NK(str);
        if (NK == null) {
            AppMethodBeat.m2505o(111368);
            return linkedList;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(NK);
        ObjectInput objectInputStream;
        try {
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            try {
                linkedList.addAll((List) objectInputStream.readObject());
                try {
                    byteArrayInputStream.close();
                } catch (IOException e2) {
                }
                try {
                    objectInputStream.close();
                } catch (IOException e3) {
                }
            } catch (Exception e4) {
                e = e4;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.GamePBDataDetailRank", e, "", new Object[0]);
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e5) {
                    }
                    if (objectInputStream != null) {
                    }
                    AppMethodBeat.m2505o(111368);
                    return linkedList;
                } catch (Throwable th) {
                    e = th;
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e6) {
                    }
                    if (objectInputStream != null) {
                    }
                    AppMethodBeat.m2505o(111368);
                    throw e;
                }
            }
        } catch (Exception e7) {
            e = e7;
            objectInputStream = null;
            C4990ab.printErrStackTrace("MicroMsg.GamePBDataDetailRank", e, "", new Object[0]);
            byteArrayInputStream.close();
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e8) {
                }
            }
            AppMethodBeat.m2505o(111368);
            return linkedList;
        } catch (Throwable th2) {
            e = th2;
            objectInputStream = null;
            byteArrayInputStream.close();
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e9) {
                }
            }
            AppMethodBeat.m2505o(111368);
            throw e;
        }
        AppMethodBeat.m2505o(111368);
        return linkedList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0071 A:{SYNTHETIC, Splitter:B:27:0x0071} */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005e A:{SYNTHETIC, Splitter:B:17:0x005e} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bEI() {
        Throwable e;
        AppMethodBeat.m2504i(111369);
        String str = this.mAppId + "_ranks";
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutput objectOutputStream;
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(this.mXO);
                ((C45983c) C1720g.m3528K(C45983c.class)).bCZ().mo54827w(str, byteArrayOutputStream.toByteArray());
                try {
                    objectOutputStream.close();
                } catch (IOException e2) {
                }
                try {
                    byteArrayOutputStream.close();
                    AppMethodBeat.m2505o(111369);
                } catch (IOException e3) {
                    AppMethodBeat.m2505o(111369);
                }
            } catch (Exception e4) {
                e = e4;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.GamePBDataDetailRank", e, "", new Object[0]);
                    if (objectOutputStream != null) {
                    }
                    try {
                        byteArrayOutputStream.close();
                        AppMethodBeat.m2505o(111369);
                    } catch (IOException e5) {
                        AppMethodBeat.m2505o(111369);
                    }
                } catch (Throwable th) {
                    e = th;
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e6) {
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e7) {
                    }
                    AppMethodBeat.m2505o(111369);
                    throw e;
                }
            }
        } catch (Exception e8) {
            e = e8;
            objectOutputStream = null;
            C4990ab.printErrStackTrace("MicroMsg.GamePBDataDetailRank", e, "", new Object[0]);
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e9) {
                }
            }
            byteArrayOutputStream.close();
            AppMethodBeat.m2505o(111369);
        } catch (Throwable th2) {
            e = th2;
            objectOutputStream = null;
            if (objectOutputStream != null) {
            }
            byteArrayOutputStream.close();
            AppMethodBeat.m2505o(111369);
            throw e;
        }
    }
}
