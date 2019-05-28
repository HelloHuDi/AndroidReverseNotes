package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mmkv.C5766d;
import com.tencent.p177mm.protocal.protobuf.C40515ef;
import com.tencent.p177mm.protocal.protobuf.buh;
import com.tencent.p177mm.protocal.protobuf.bui;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5018as;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.NoSuchElementException;
import p000a.C0220l;
import p000a.p001a.C0000ac;
import p000a.p005f.p007b.C25052j;
import p000a.p051k.C17354b;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000H\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0006\u0010\n\u001a\u00020\u000b\u001a\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b\u001a\u0006\u0010\u000e\u001a\u00020\u000f\u001a\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b\u001a\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b\u001a\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\b\u001a\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002\u001a\u000e\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0001\u001a\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0002\u001a\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002\u001a\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002\u001a\u0012\u0010\u001d\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001f\u001a\n\u0010 \u001a\u00020\u0001*\u00020\b\u001a\n\u0010!\u001a\u00020\b*\u00020\b\u001a\n\u0010\f\u001a\u00020\b*\u00020\"\u001a\n\u0010#\u001a\u00020\u001c*\u00020\"\u001a\f\u0010$\u001a\u00020\b*\u00020\u0016H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XD¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XD¢\u0006\u0002\n\u0000\"\u0014\u0010\u0003\u001a\u00020\u00018BX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"*\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\tX\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, dWq = {"SLOT_DURATION", "", "SLOT_SIZE", "currentSlotId", "getCurrentSlotId", "()I", "urlHashCache", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "clearSlots", "", "getContentId", "url", "getCurrentSlot", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getInfoId", "getInvalidId", "getSlot", "id", "getSlotMMKV", "slot", "", "getStrip", "openScene", "hashUrl", "mmkvSlot", "verifySlot", "", "getBuff", "buffer", "Lcom/tencent/mmkv/NativeBuffer;", "getBuffSize", "getContent", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "hasContent", "slotKey", "plugin-brandservice_release"})
/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.b */
public final class C2702b {
    private static final int jQJ = jQJ;
    private static final int jQK = 3;
    private static HashMap<String, String> jQL = new HashMap();

    /* renamed from: gK */
    public static final /* synthetic */ C5018as m4934gK(long j) {
        AppMethodBeat.m2504i(14799);
        C5018as gH = C2702b.m4931gH(j);
        AppMethodBeat.m2505o(14799);
        return gH;
    }

    static {
        AppMethodBeat.m2504i(14798);
        AppMethodBeat.m2505o(14798);
    }

    public static final C5018as aWO() {
        AppMethodBeat.m2504i(14781);
        C5018as gI = C2702b.m4932gI((long) C2702b.aWN());
        AppMethodBeat.m2505o(14781);
        return gI;
    }

    /* renamed from: gG */
    private static final String m4930gG(long j) {
        AppMethodBeat.m2504i(14782);
        String str = "_slots_id_" + (j % ((long) jQK));
        AppMethodBeat.m2505o(14782);
        return str;
    }

    /* renamed from: gH */
    private static final C5018as m4931gH(long j) {
        AppMethodBeat.m2504i(14783);
        C5018as eg = C5018as.m7465eg(C2702b.m4930gG(j), 2);
        C25052j.m39375o(eg, "MultiProcessMMKV.getMMKV… MMKV.MULTI_PROCESS_MODE)");
        AppMethodBeat.m2505o(14783);
        return eg;
    }

    /* renamed from: gI */
    private static final C5018as m4932gI(long j) {
        AppMethodBeat.m2504i(14784);
        if (!C2702b.m4933gJ(j)) {
            C20086l.aXy().putLong(C2702b.m4930gG(j), j);
        }
        C5018as gH = C2702b.m4931gH(j);
        AppMethodBeat.m2505o(14784);
        return gH;
    }

    /* renamed from: gJ */
    private static final boolean m4933gJ(long j) {
        AppMethodBeat.m2504i(14785);
        if (C20086l.aXy().getLong(C2702b.m4930gG(j), 0) != j) {
            C2702b.m4931gH(j).clear();
            AppMethodBeat.m2505o(14785);
            return false;
        }
        AppMethodBeat.m2505o(14785);
        return true;
    }

    /* renamed from: FH */
    private static final String m4920FH(String str) {
        int i = 0;
        AppMethodBeat.m2504i(14786);
        String str2;
        if (jQL.containsKey(str)) {
            Object dWu;
            Map map = jQL;
            C25052j.m39376p(map, "receiver$0");
            C25052j.m39376p(map, "receiver$0");
            if (map instanceof C0000ac) {
                dWu = ((C0000ac) map).dWu();
            } else {
                Object obj = map.get(str);
                if (obj != null || map.containsKey(str)) {
                    dWu = obj;
                } else {
                    Throwable noSuchElementException = new NoSuchElementException("Key " + str + " is missing in the map.");
                    AppMethodBeat.m2505o(14786);
                    throw noSuchElementException;
                }
            }
            str2 = (String) dWu;
            AppMethodBeat.m2505o(14786);
            return str2;
        }
        StringBuilder stringBuilder = new StringBuilder("matched_");
        String[] strArr = new String[]{"__biz", "mid", "idx"};
        while (i < 3) {
            String str3 = strArr[i];
            String dg = C27540m.m43710dg(str, str3);
            if (dg == null) {
                str2 = Integer.toString(("not_matched_" + C27540m.m43704FT(str)).hashCode(), C17354b.m26870UW(16));
                C25052j.m39375o(str2, "java.lang.Integer.toStri…(this, checkRadix(radix))");
                jQL.put(str, str2);
                AppMethodBeat.m2505o(14786);
                return str2;
            }
            stringBuilder.append(str3 + ':' + dg + '-');
            i++;
        }
        str2 = Integer.toString(stringBuilder.toString().hashCode(), C17354b.m26870UW(16));
        C25052j.m39375o(str2, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        jQL.put(str, str2);
        AppMethodBeat.m2505o(14786);
        return str2;
    }

    /* renamed from: FI */
    public static final String m4921FI(String str) {
        AppMethodBeat.m2504i(14787);
        C25052j.m39376p(str, "url");
        String str2 = "_info_" + C2702b.m4920FH(str);
        AppMethodBeat.m2505o(14787);
        return str2;
    }

    /* renamed from: FJ */
    public static final String m4922FJ(String str) {
        AppMethodBeat.m2504i(14788);
        C25052j.m39376p(str, "url");
        String str2 = "_content_" + C2702b.m4920FH(str);
        AppMethodBeat.m2505o(14788);
        return str2;
    }

    /* renamed from: FK */
    public static final String m4923FK(String str) {
        AppMethodBeat.m2504i(14789);
        C25052j.m39376p(str, "url");
        String str2 = "_invalid_" + C2702b.m4920FH(str);
        AppMethodBeat.m2505o(14789);
        return str2;
    }

    /* renamed from: FL */
    public static final C5018as m4924FL(String str) {
        AppMethodBeat.m2504i(14790);
        C25052j.m39376p(str, "id");
        long aWN = (long) C2702b.aWN();
        C5018as gI = C2702b.m4932gI(aWN);
        if (gI.containsKey(str)) {
            AppMethodBeat.m2505o(14790);
            return gI;
        }
        gI = C2702b.m4932gI(aWN - 1);
        if (gI.containsKey(str)) {
            AppMethodBeat.m2505o(14790);
            return gI;
        }
        AppMethodBeat.m2505o(14790);
        return null;
    }

    public static final void aWP() {
        AppMethodBeat.m2504i(14791);
        long aWN = (long) C2702b.aWN();
        C2702b.m4933gJ(aWN - 1);
        C2702b.m4933gJ(aWN);
        C2702b.m4933gJ(aWN + 1);
        AppMethodBeat.m2505o(14791);
    }

    /* renamed from: a */
    public static final String m4928a(C40515ef c40515ef) {
        AppMethodBeat.m2504i(14792);
        C25052j.m39376p(c40515ef, "receiver$0");
        String str = c40515ef.Url;
        C25052j.m39375o(str, "this.Url");
        str = C2702b.m4922FJ(str);
        AppMethodBeat.m2505o(14792);
        return str;
    }

    /* renamed from: b */
    public static final boolean m4929b(C40515ef c40515ef) {
        AppMethodBeat.m2504i(14793);
        C25052j.m39376p(c40515ef, "receiver$0");
        if (C2702b.m4924FL(C2702b.m4928a(c40515ef)) != null) {
            AppMethodBeat.m2505o(14793);
            return true;
        }
        AppMethodBeat.m2505o(14793);
        return false;
    }

    /* JADX WARNING: Missing block: B:3:0x0018, code skipped:
            if (r0 == null) goto L_0x001a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: FM */
    public static final String m4925FM(String str) {
        String string;
        AppMethodBeat.m2504i(14794);
        C25052j.m39376p(str, "receiver$0");
        C5018as FL = C2702b.m4924FL(str);
        if (FL != null) {
            string = FL.getString(str, "");
        }
        string = "";
        AppMethodBeat.m2505o(14794);
        return string;
    }

    /* renamed from: a */
    public static final int m4927a(String str, C5766d c5766d) {
        AppMethodBeat.m2504i(14795);
        C25052j.m39376p(str, "receiver$0");
        C25052j.m39376p(c5766d, "buffer");
        C5018as FL = C2702b.m4924FL(str);
        if (FL != null) {
            int writeValueToNativeBuffer = FL.writeValueToNativeBuffer(str, c5766d);
            AppMethodBeat.m2505o(14795);
            return writeValueToNativeBuffer;
        }
        AppMethodBeat.m2505o(14795);
        return -1;
    }

    /* renamed from: FN */
    public static final int m4926FN(String str) {
        AppMethodBeat.m2504i(14796);
        C25052j.m39376p(str, "receiver$0");
        C5018as FL = C2702b.m4924FL(str);
        if (FL != null) {
            int valueActualSize = FL.getValueActualSize(str);
            AppMethodBeat.m2505o(14796);
            return valueActualSize;
        }
        AppMethodBeat.m2505o(14796);
        return -1;
    }

    /* renamed from: sk */
    public static final int m4935sk(int i) {
        Object obj = 1;
        AppMethodBeat.m2504i(14797);
        byte[] decodeBytes = C20086l.aXy().decodeBytes("_msg_scene_strip");
        C25052j.m39375o(decodeBytes, "buff");
        if ((decodeBytes.length == 0 ? 1 : null) != null) {
            obj = null;
        }
        if (obj != null) {
            bui bui = new bui();
            bui.parseFrom(decodeBytes);
            LinkedList<buh> linkedList = bui.vKy;
            C25052j.m39375o(linkedList, "SceneControlSets().apply…(buff) }.SceneControlList");
            for (buh buh : linkedList) {
                if (buh.Scene == i) {
                    C4990ab.m7416i("MicroMsg.AppMsgContextEx", "strip " + i + ':' + buh.wVZ);
                    int i2 = buh.wVZ;
                    AppMethodBeat.m2505o(14797);
                    return i2;
                }
            }
        }
        AppMethodBeat.m2505o(14797);
        return 10;
    }

    private static final int aWN() {
        AppMethodBeat.m2504i(14780);
        int currentTimeMillis = (int) (System.currentTimeMillis() / ((long) jQJ));
        AppMethodBeat.m2505o(14780);
        return currentTimeMillis;
    }
}
