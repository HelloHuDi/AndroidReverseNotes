package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import a.a.ac;
import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.buh;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.ef;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mmkv.d;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.NoSuchElementException;

@l(dWo = {1, 1, 13}, dWp = {"\u0000H\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0006\u0010\n\u001a\u00020\u000b\u001a\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b\u001a\u0006\u0010\u000e\u001a\u00020\u000f\u001a\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b\u001a\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b\u001a\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\b\u001a\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002\u001a\u000e\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0001\u001a\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0002\u001a\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002\u001a\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002\u001a\u0012\u0010\u001d\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001f\u001a\n\u0010 \u001a\u00020\u0001*\u00020\b\u001a\n\u0010!\u001a\u00020\b*\u00020\b\u001a\n\u0010\f\u001a\u00020\b*\u00020\"\u001a\n\u0010#\u001a\u00020\u001c*\u00020\"\u001a\f\u0010$\u001a\u00020\b*\u00020\u0016H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XD¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XD¢\u0006\u0002\n\u0000\"\u0014\u0010\u0003\u001a\u00020\u00018BX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"*\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\tX\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, dWq = {"SLOT_DURATION", "", "SLOT_SIZE", "currentSlotId", "getCurrentSlotId", "()I", "urlHashCache", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "clearSlots", "", "getContentId", "url", "getCurrentSlot", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getInfoId", "getInvalidId", "getSlot", "id", "getSlotMMKV", "slot", "", "getStrip", "openScene", "hashUrl", "mmkvSlot", "verifySlot", "", "getBuff", "buffer", "Lcom/tencent/mmkv/NativeBuffer;", "getBuffSize", "getContent", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "hasContent", "slotKey", "plugin-brandservice_release"})
public final class b {
    private static final int jQJ = jQJ;
    private static final int jQK = 3;
    private static HashMap<String, String> jQL = new HashMap();

    public static final /* synthetic */ as gK(long j) {
        AppMethodBeat.i(14799);
        as gH = gH(j);
        AppMethodBeat.o(14799);
        return gH;
    }

    static {
        AppMethodBeat.i(14798);
        AppMethodBeat.o(14798);
    }

    public static final as aWO() {
        AppMethodBeat.i(14781);
        as gI = gI((long) aWN());
        AppMethodBeat.o(14781);
        return gI;
    }

    private static final String gG(long j) {
        AppMethodBeat.i(14782);
        String str = "_slots_id_" + (j % ((long) jQK));
        AppMethodBeat.o(14782);
        return str;
    }

    private static final as gH(long j) {
        AppMethodBeat.i(14783);
        as eg = as.eg(gG(j), 2);
        j.o(eg, "MultiProcessMMKV.getMMKV… MMKV.MULTI_PROCESS_MODE)");
        AppMethodBeat.o(14783);
        return eg;
    }

    private static final as gI(long j) {
        AppMethodBeat.i(14784);
        if (!gJ(j)) {
            l.aXy().putLong(gG(j), j);
        }
        as gH = gH(j);
        AppMethodBeat.o(14784);
        return gH;
    }

    private static final boolean gJ(long j) {
        AppMethodBeat.i(14785);
        if (l.aXy().getLong(gG(j), 0) != j) {
            gH(j).clear();
            AppMethodBeat.o(14785);
            return false;
        }
        AppMethodBeat.o(14785);
        return true;
    }

    private static final String FH(String str) {
        int i = 0;
        AppMethodBeat.i(14786);
        String str2;
        if (jQL.containsKey(str)) {
            Object dWu;
            Map map = jQL;
            j.p(map, "receiver$0");
            j.p(map, "receiver$0");
            if (map instanceof ac) {
                dWu = ((ac) map).dWu();
            } else {
                Object obj = map.get(str);
                if (obj != null || map.containsKey(str)) {
                    dWu = obj;
                } else {
                    Throwable noSuchElementException = new NoSuchElementException("Key " + str + " is missing in the map.");
                    AppMethodBeat.o(14786);
                    throw noSuchElementException;
                }
            }
            str2 = (String) dWu;
            AppMethodBeat.o(14786);
            return str2;
        }
        StringBuilder stringBuilder = new StringBuilder("matched_");
        String[] strArr = new String[]{"__biz", "mid", "idx"};
        while (i < 3) {
            String str3 = strArr[i];
            String dg = m.dg(str, str3);
            if (dg == null) {
                str2 = Integer.toString(("not_matched_" + m.FT(str)).hashCode(), a.k.b.UW(16));
                j.o(str2, "java.lang.Integer.toStri…(this, checkRadix(radix))");
                jQL.put(str, str2);
                AppMethodBeat.o(14786);
                return str2;
            }
            stringBuilder.append(str3 + ':' + dg + '-');
            i++;
        }
        str2 = Integer.toString(stringBuilder.toString().hashCode(), a.k.b.UW(16));
        j.o(str2, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        jQL.put(str, str2);
        AppMethodBeat.o(14786);
        return str2;
    }

    public static final String FI(String str) {
        AppMethodBeat.i(14787);
        j.p(str, "url");
        String str2 = "_info_" + FH(str);
        AppMethodBeat.o(14787);
        return str2;
    }

    public static final String FJ(String str) {
        AppMethodBeat.i(14788);
        j.p(str, "url");
        String str2 = "_content_" + FH(str);
        AppMethodBeat.o(14788);
        return str2;
    }

    public static final String FK(String str) {
        AppMethodBeat.i(14789);
        j.p(str, "url");
        String str2 = "_invalid_" + FH(str);
        AppMethodBeat.o(14789);
        return str2;
    }

    public static final as FL(String str) {
        AppMethodBeat.i(14790);
        j.p(str, "id");
        long aWN = (long) aWN();
        as gI = gI(aWN);
        if (gI.containsKey(str)) {
            AppMethodBeat.o(14790);
            return gI;
        }
        gI = gI(aWN - 1);
        if (gI.containsKey(str)) {
            AppMethodBeat.o(14790);
            return gI;
        }
        AppMethodBeat.o(14790);
        return null;
    }

    public static final void aWP() {
        AppMethodBeat.i(14791);
        long aWN = (long) aWN();
        gJ(aWN - 1);
        gJ(aWN);
        gJ(aWN + 1);
        AppMethodBeat.o(14791);
    }

    public static final String a(ef efVar) {
        AppMethodBeat.i(14792);
        j.p(efVar, "receiver$0");
        String str = efVar.Url;
        j.o(str, "this.Url");
        str = FJ(str);
        AppMethodBeat.o(14792);
        return str;
    }

    public static final boolean b(ef efVar) {
        AppMethodBeat.i(14793);
        j.p(efVar, "receiver$0");
        if (FL(a(efVar)) != null) {
            AppMethodBeat.o(14793);
            return true;
        }
        AppMethodBeat.o(14793);
        return false;
    }

    /* JADX WARNING: Missing block: B:3:0x0018, code skipped:
            if (r0 == null) goto L_0x001a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final String FM(String str) {
        String string;
        AppMethodBeat.i(14794);
        j.p(str, "receiver$0");
        as FL = FL(str);
        if (FL != null) {
            string = FL.getString(str, "");
        }
        string = "";
        AppMethodBeat.o(14794);
        return string;
    }

    public static final int a(String str, d dVar) {
        AppMethodBeat.i(14795);
        j.p(str, "receiver$0");
        j.p(dVar, "buffer");
        as FL = FL(str);
        if (FL != null) {
            int writeValueToNativeBuffer = FL.writeValueToNativeBuffer(str, dVar);
            AppMethodBeat.o(14795);
            return writeValueToNativeBuffer;
        }
        AppMethodBeat.o(14795);
        return -1;
    }

    public static final int FN(String str) {
        AppMethodBeat.i(14796);
        j.p(str, "receiver$0");
        as FL = FL(str);
        if (FL != null) {
            int valueActualSize = FL.getValueActualSize(str);
            AppMethodBeat.o(14796);
            return valueActualSize;
        }
        AppMethodBeat.o(14796);
        return -1;
    }

    public static final int sk(int i) {
        Object obj = 1;
        AppMethodBeat.i(14797);
        byte[] decodeBytes = l.aXy().decodeBytes("_msg_scene_strip");
        j.o(decodeBytes, "buff");
        if ((decodeBytes.length == 0 ? 1 : null) != null) {
            obj = null;
        }
        if (obj != null) {
            bui bui = new bui();
            bui.parseFrom(decodeBytes);
            LinkedList<buh> linkedList = bui.vKy;
            j.o(linkedList, "SceneControlSets().apply…(buff) }.SceneControlList");
            for (buh buh : linkedList) {
                if (buh.Scene == i) {
                    ab.i("MicroMsg.AppMsgContextEx", "strip " + i + ':' + buh.wVZ);
                    int i2 = buh.wVZ;
                    AppMethodBeat.o(14797);
                    return i2;
                }
            }
        }
        AppMethodBeat.o(14797);
        return 10;
    }

    private static final int aWN() {
        AppMethodBeat.i(14780);
        int currentTimeMillis = (int) (System.currentTimeMillis() / ((long) jQJ));
        AppMethodBeat.o(14780);
        return currentTimeMillis;
    }
}
