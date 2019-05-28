package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.plugin.game.d.cw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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

public final class aa {
    public String mAppId = "";
    public List<a> mXO = new LinkedList();

    public static class a implements Serializable {
        public String cIS;
        public long mEA;
        public int mXP;
        public int mXQ;
        public boolean mXR;
        public String mXS;
        public String tag;
    }

    public aa(String str) {
        AppMethodBeat.i(111366);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(111366);
            return;
        }
        this.mAppId = str;
        this.mXO.addAll(bEH());
        AppMethodBeat.o(111366);
    }

    public aa(String str, List<cw> list) {
        AppMethodBeat.i(111367);
        if (bo.isNullOrNil(str) || list == null || list.isEmpty()) {
            AppMethodBeat.o(111367);
            return;
        }
        this.mAppId = str;
        this.mXO.clear();
        for (cw cwVar : list) {
            a aVar = new a();
            aVar.mXP = cwVar.ndr;
            aVar.cIS = cwVar.jBB;
            aVar.tag = cwVar.Label;
            aVar.mEA = cwVar.nds;
            aVar.mXR = cwVar.ndt;
            aVar.mXQ = cwVar.ndu;
            aVar.mXS = cwVar.ndv;
            this.mXO.add(aVar);
        }
        bEI();
        AppMethodBeat.o(111367);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0077 A:{SYNTHETIC, Splitter:B:28:0x0077} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006a A:{SYNTHETIC, Splitter:B:20:0x006a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private List<a> bEH() {
        Throwable e;
        AppMethodBeat.i(111368);
        String str = this.mAppId + "_ranks";
        LinkedList linkedList = new LinkedList();
        byte[] NK = ((c) g.K(c.class)).bCZ().NK(str);
        if (NK == null) {
            AppMethodBeat.o(111368);
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
                    ab.printErrStackTrace("MicroMsg.GamePBDataDetailRank", e, "", new Object[0]);
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e5) {
                    }
                    if (objectInputStream != null) {
                    }
                    AppMethodBeat.o(111368);
                    return linkedList;
                } catch (Throwable th) {
                    e = th;
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e6) {
                    }
                    if (objectInputStream != null) {
                    }
                    AppMethodBeat.o(111368);
                    throw e;
                }
            }
        } catch (Exception e7) {
            e = e7;
            objectInputStream = null;
            ab.printErrStackTrace("MicroMsg.GamePBDataDetailRank", e, "", new Object[0]);
            byteArrayInputStream.close();
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e8) {
                }
            }
            AppMethodBeat.o(111368);
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
            AppMethodBeat.o(111368);
            throw e;
        }
        AppMethodBeat.o(111368);
        return linkedList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0071 A:{SYNTHETIC, Splitter:B:27:0x0071} */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005e A:{SYNTHETIC, Splitter:B:17:0x005e} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bEI() {
        Throwable e;
        AppMethodBeat.i(111369);
        String str = this.mAppId + "_ranks";
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutput objectOutputStream;
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(this.mXO);
                ((c) g.K(c.class)).bCZ().w(str, byteArrayOutputStream.toByteArray());
                try {
                    objectOutputStream.close();
                } catch (IOException e2) {
                }
                try {
                    byteArrayOutputStream.close();
                    AppMethodBeat.o(111369);
                } catch (IOException e3) {
                    AppMethodBeat.o(111369);
                }
            } catch (Exception e4) {
                e = e4;
                try {
                    ab.printErrStackTrace("MicroMsg.GamePBDataDetailRank", e, "", new Object[0]);
                    if (objectOutputStream != null) {
                    }
                    try {
                        byteArrayOutputStream.close();
                        AppMethodBeat.o(111369);
                    } catch (IOException e5) {
                        AppMethodBeat.o(111369);
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
                    AppMethodBeat.o(111369);
                    throw e;
                }
            }
        } catch (Exception e8) {
            e = e8;
            objectOutputStream = null;
            ab.printErrStackTrace("MicroMsg.GamePBDataDetailRank", e, "", new Object[0]);
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e9) {
                }
            }
            byteArrayOutputStream.close();
            AppMethodBeat.o(111369);
        } catch (Throwable th2) {
            e = th2;
            objectOutputStream = null;
            if (objectOutputStream != null) {
            }
            byteArrayOutputStream.close();
            AppMethodBeat.o(111369);
            throw e;
        }
    }
}
