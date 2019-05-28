package com.tencent.mm.plugin.nfc_open.a;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.j;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;

public final class a extends c<j> {
    public a() {
        AppMethodBeat.i(23057);
        this.xxI = j.class.getName().hashCode();
        AppMethodBeat.o(23057);
    }

    private static boolean a(j jVar) {
        AppMethodBeat.i(23058);
        if (!(jVar instanceof j)) {
            AppMethodBeat.o(23058);
            return false;
        } else if (jVar.csb == null) {
            AppMethodBeat.o(23058);
            return false;
        } else {
            int i = jVar.csb.actionCode;
            Context context = jVar.csb.context;
            if (context == null) {
                context = ah.getContext();
            }
            Bundle bundle = new Bundle();
            String str;
            switch (i) {
                case WearableStatusCodes.DUPLICATE_LISTENER /*4001*/:
                    bundle.putInt("status", com.tencent.mm.plugin.nfc.b.a.a.bVz().eF(context));
                    break;
                case WearableStatusCodes.UNKNOWN_LISTENER /*4002*/:
                    ab.i("MicroMsg.ApduEngineFuncListener", "alvinluo NFC connect status: %d", Integer.valueOf(com.tencent.mm.plugin.nfc.b.a.a.bVz().eG(context)));
                    bundle.putInt("status", r0);
                    break;
                case WearableStatusCodes.DATA_ITEM_TOO_LARGE /*4003*/:
                    str = jVar.csb.csd;
                    if (!bo.isNullOrNil(str)) {
                        try {
                            bundle.putString("result", com.tencent.mm.plugin.nfc.b.a.a.bVz().a(new com.tencent.mm.plugin.nfc.a.a(str)).toString());
                            break;
                        } catch (Exception e) {
                            ab.e("MicroMsg.ApduEngineFuncListener", "alex: execute nfc command exception");
                            ab.printErrStackTrace("MicroMsg.ApduEngineFuncListener", e, "", new Object[0]);
                            bundle.putString("result", null);
                            break;
                        }
                    }
                    ab.e("MicroMsg.ApduEngineFuncListener", "[NFC] transceive apdu is null");
                    break;
                case WearableStatusCodes.INVALID_TARGET_NODE /*4004*/:
                    try {
                        str = jVar.csb.csd;
                        boolean z = jVar.csb.cse;
                        boolean z2 = jVar.csb.csf;
                        if (bo.isNullOrNil(str)) {
                            ab.e("MicroMsg.ApduEngineFuncListener", "[NFC] transceive apdu is null");
                            break;
                        }
                        String[] split = str.split("\\|");
                        ArrayList<com.tencent.mm.plugin.nfc.b.a> arrayList = new ArrayList();
                        for (String str2 : split) {
                            if (bo.isNullOrNil(str2)) {
                                ab.w("MicroMsg.ApduEngineFuncListener", "[NFC] batch transceive apduStr is null");
                            } else {
                                String[] split2 = str2.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                                if (split2 == null || split2.length < 2) {
                                    ab.w("MicroMsg.ApduEngineFuncListener", "[NFC] transceive apdu's size is wrong");
                                } else {
                                    int i2 = bo.getInt(split2[0], 0);
                                    arrayList.add(new com.tencent.mm.plugin.nfc.b.a(i2, String.valueOf(i2), new com.tencent.mm.plugin.nfc.a.a(split2[1])));
                                }
                            }
                        }
                        com.tencent.mm.plugin.nfc.b.a.a.bVz().a(arrayList, z, z2);
                        StringBuilder stringBuilder = new StringBuilder();
                        for (com.tencent.mm.plugin.nfc.b.a aVar : arrayList) {
                            if (aVar.oTl == null) {
                                bundle.putString("result", stringBuilder.toString());
                                break;
                            }
                            stringBuilder.append(aVar.id);
                            stringBuilder.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                            stringBuilder.append(aVar.oTl.toString());
                            stringBuilder.append("|");
                        }
                        bundle.putString("result", stringBuilder.toString());
                    } catch (Exception e2) {
                        ab.e("MicroMsg.ApduEngineFuncListener", "alex: execute nfc command exception");
                        ab.printErrStackTrace("MicroMsg.ApduEngineFuncListener", e2, "", new Object[0]);
                        bundle.putString("result", null);
                        break;
                    }
                    break;
                case WearableStatusCodes.ASSET_UNAVAILABLE /*4005*/:
                    bundle.putString("id", com.tencent.mm.plugin.nfc.c.a.byteArrayToHexString(com.tencent.mm.plugin.nfc.b.a.a.bVz().oTn));
                    break;
                case WearableStatusCodes.WIFI_CREDENTIAL_SYNC_NO_CREDENTIAL_FETCHED /*4008*/:
                    bundle.putString("info", com.tencent.mm.plugin.nfc.b.a.a.bVz().getInfo());
                    break;
            }
            jVar.csc.csg = bundle;
            AppMethodBeat.o(23058);
            return false;
        }
    }
}
