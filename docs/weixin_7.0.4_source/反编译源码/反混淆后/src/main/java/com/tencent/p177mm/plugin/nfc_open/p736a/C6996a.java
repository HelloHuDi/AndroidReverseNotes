package com.tencent.p177mm.plugin.nfc_open.p736a;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C42013j;
import com.tencent.p177mm.plugin.nfc.p1002a.C34621a;
import com.tencent.p177mm.plugin.nfc.p1004c.C12717a;
import com.tencent.p177mm.plugin.nfc.p472b.C3552a;
import com.tencent.p177mm.plugin.nfc.p472b.p1003a.C46113a;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.nfc_open.a.a */
public final class C6996a extends C4884c<C42013j> {
    public C6996a() {
        AppMethodBeat.m2504i(23057);
        this.xxI = C42013j.class.getName().hashCode();
        AppMethodBeat.m2505o(23057);
    }

    /* renamed from: a */
    private static boolean m11661a(C42013j c42013j) {
        AppMethodBeat.m2504i(23058);
        if (!(c42013j instanceof C42013j)) {
            AppMethodBeat.m2505o(23058);
            return false;
        } else if (c42013j.csb == null) {
            AppMethodBeat.m2505o(23058);
            return false;
        } else {
            int i = c42013j.csb.actionCode;
            Context context = c42013j.csb.context;
            if (context == null) {
                context = C4996ah.getContext();
            }
            Bundle bundle = new Bundle();
            String str;
            switch (i) {
                case WearableStatusCodes.DUPLICATE_LISTENER /*4001*/:
                    bundle.putInt("status", C46113a.bVz().mo74059eF(context));
                    break;
                case WearableStatusCodes.UNKNOWN_LISTENER /*4002*/:
                    C4990ab.m7417i("MicroMsg.ApduEngineFuncListener", "alvinluo NFC connect status: %d", Integer.valueOf(C46113a.bVz().mo74060eG(context)));
                    bundle.putInt("status", r0);
                    break;
                case WearableStatusCodes.DATA_ITEM_TOO_LARGE /*4003*/:
                    str = c42013j.csb.csd;
                    if (!C5046bo.isNullOrNil(str)) {
                        try {
                            bundle.putString("result", C46113a.bVz().mo74057a(new C34621a(str)).toString());
                            break;
                        } catch (Exception e) {
                            C4990ab.m7412e("MicroMsg.ApduEngineFuncListener", "alex: execute nfc command exception");
                            C4990ab.printErrStackTrace("MicroMsg.ApduEngineFuncListener", e, "", new Object[0]);
                            bundle.putString("result", null);
                            break;
                        }
                    }
                    C4990ab.m7412e("MicroMsg.ApduEngineFuncListener", "[NFC] transceive apdu is null");
                    break;
                case WearableStatusCodes.INVALID_TARGET_NODE /*4004*/:
                    try {
                        str = c42013j.csb.csd;
                        boolean z = c42013j.csb.cse;
                        boolean z2 = c42013j.csb.csf;
                        if (C5046bo.isNullOrNil(str)) {
                            C4990ab.m7412e("MicroMsg.ApduEngineFuncListener", "[NFC] transceive apdu is null");
                            break;
                        }
                        String[] split = str.split("\\|");
                        ArrayList<C3552a> arrayList = new ArrayList();
                        for (String str2 : split) {
                            if (C5046bo.isNullOrNil(str2)) {
                                C4990ab.m7420w("MicroMsg.ApduEngineFuncListener", "[NFC] batch transceive apduStr is null");
                            } else {
                                String[] split2 = str2.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                                if (split2 == null || split2.length < 2) {
                                    C4990ab.m7420w("MicroMsg.ApduEngineFuncListener", "[NFC] transceive apdu's size is wrong");
                                } else {
                                    int i2 = C5046bo.getInt(split2[0], 0);
                                    arrayList.add(new C3552a(i2, String.valueOf(i2), new C34621a(split2[1])));
                                }
                            }
                        }
                        C46113a.bVz().mo74058a(arrayList, z, z2);
                        StringBuilder stringBuilder = new StringBuilder();
                        for (C3552a c3552a : arrayList) {
                            if (c3552a.oTl == null) {
                                bundle.putString("result", stringBuilder.toString());
                                break;
                            }
                            stringBuilder.append(c3552a.f1275id);
                            stringBuilder.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                            stringBuilder.append(c3552a.oTl.toString());
                            stringBuilder.append("|");
                        }
                        bundle.putString("result", stringBuilder.toString());
                    } catch (Exception e2) {
                        C4990ab.m7412e("MicroMsg.ApduEngineFuncListener", "alex: execute nfc command exception");
                        C4990ab.printErrStackTrace("MicroMsg.ApduEngineFuncListener", e2, "", new Object[0]);
                        bundle.putString("result", null);
                        break;
                    }
                    break;
                case WearableStatusCodes.ASSET_UNAVAILABLE /*4005*/:
                    bundle.putString("id", C12717a.byteArrayToHexString(C46113a.bVz().oTn));
                    break;
                case WearableStatusCodes.WIFI_CREDENTIAL_SYNC_NO_CREDENTIAL_FETCHED /*4008*/:
                    bundle.putString("info", C46113a.bVz().getInfo());
                    break;
            }
            c42013j.csc.csg = bundle;
            AppMethodBeat.m2505o(23058);
            return false;
        }
    }
}
