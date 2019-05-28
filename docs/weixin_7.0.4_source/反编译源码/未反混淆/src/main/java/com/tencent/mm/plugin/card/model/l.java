package com.tencent.mm.plugin.card.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;

public final class l extends j<k> {
    public static final String[] fnj = new String[]{j.a(k.ccO, "CardQrCodeDataInfo")};
    public e bSd;

    static {
        AppMethodBeat.i(87848);
        AppMethodBeat.o(87848);
    }

    public l(e eVar) {
        super(eVar, k.ccO, "CardQrCodeDataInfo", k.diI);
        this.bSd = eVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0047 A:{REMOVE} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final List<k> Gw(String str) {
        AppMethodBeat.i(87843);
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = this.bSd.rawQuery("select * from CardQrCodeDataInfo where card_id =? AND status=0", new String[]{str});
        while (rawQuery != null) {
            try {
                if (!rawQuery.moveToNext()) {
                    break;
                }
                k kVar = new k();
                kVar.d(rawQuery);
                arrayList.add(kVar);
            } catch (Exception e) {
                ab.e("MicroMsg.CardQrCodeDataInfoStorage", "getCardQrcodeByCardId error!", e.getMessage());
                return arrayList;
            } finally {
                if (rawQuery != null) {
                    rawQuery.close();
                }
                AppMethodBeat.o(87843);
            }
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final k Gx(String str) {
        k kVar;
        Exception e;
        AppMethodBeat.i(87844);
        Cursor rawQuery = this.bSd.rawQuery("select * from CardQrCodeDataInfo where card_id =? AND status=0  limit 1", new String[]{str});
        if (rawQuery != null) {
            try {
                if (rawQuery.getCount() > 0) {
                    rawQuery.moveToPosition(0);
                    kVar = new k();
                    try {
                        kVar.d(rawQuery);
                        ab.i("MicroMsg.CardQrCodeDataInfoStorage", "getOneCardQrcodeByCardId  success! card_id = %s, code_id = %s ", str, kVar.field_code_id);
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            ab.e("MicroMsg.CardQrCodeDataInfoStorage", "getOneCardQrcodeByCardId error!", e.getMessage());
                            if (rawQuery != null) {
                                rawQuery.close();
                            }
                            AppMethodBeat.o(87844);
                            return kVar;
                        } catch (Throwable th) {
                            if (rawQuery != null) {
                                rawQuery.close();
                            }
                            AppMethodBeat.o(87844);
                        }
                    }
                    AppMethodBeat.o(87844);
                    return kVar;
                }
            } catch (Exception e3) {
                e = e3;
                kVar = null;
                ab.e("MicroMsg.CardQrCodeDataInfoStorage", "getOneCardQrcodeByCardId error!", e.getMessage());
                if (rawQuery != null) {
                }
                AppMethodBeat.o(87844);
                return kVar;
            }
        }
        ab.e("MicroMsg.CardQrCodeDataInfoStorage", "getOneCardQrcodeByCardId  is empty! card_id = %s", str);
        kVar = null;
        if (rawQuery != null) {
        }
        AppMethodBeat.o(87844);
        return kVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final k Gy(String str) {
        k kVar;
        Exception e;
        AppMethodBeat.i(87845);
        Cursor rawQuery = this.bSd.rawQuery("select * from CardQrCodeDataInfo where card_id =? AND status=1  limit 1", new String[]{str});
        if (rawQuery != null) {
            try {
                if (rawQuery.getCount() > 0) {
                    rawQuery.moveToPosition(0);
                    kVar = new k();
                    try {
                        kVar.d(rawQuery);
                        ab.i("MicroMsg.CardQrCodeDataInfoStorage", "getCardQrcodeShowingByCardId  success! card_id = %s, code_id = %s ", str, kVar.field_code_id);
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            ab.e("MicroMsg.CardQrCodeDataInfoStorage", "getCardQrcodeShowingByCardId error!", e.getMessage());
                            if (rawQuery != null) {
                                rawQuery.close();
                            }
                            AppMethodBeat.o(87845);
                            return kVar;
                        } catch (Throwable th) {
                            if (rawQuery != null) {
                                rawQuery.close();
                            }
                            AppMethodBeat.o(87845);
                        }
                    }
                    AppMethodBeat.o(87845);
                    return kVar;
                }
            } catch (Exception e3) {
                e = e3;
                kVar = null;
                ab.e("MicroMsg.CardQrCodeDataInfoStorage", "getCardQrcodeShowingByCardId error!", e.getMessage());
                if (rawQuery != null) {
                }
                AppMethodBeat.o(87845);
                return kVar;
            }
        }
        ab.e("MicroMsg.CardQrCodeDataInfoStorage", "getCardQrcodeShowingByCardId  is empty! card_id = %s", str);
        kVar = null;
        if (rawQuery != null) {
        }
        AppMethodBeat.o(87845);
        return kVar;
    }

    public final boolean dm(String str, String str2) {
        AppMethodBeat.i(87846);
        k kVar = new k();
        kVar.field_card_id = str;
        kVar.field_code_id = str2;
        boolean a = a((c) kVar, "card_id", "code_id");
        if (a) {
            ab.i("MicroMsg.CardQrCodeDataInfoStorage", "delete qrCodeData  success! card_id = %s, code_id = %s", kVar.field_card_id, kVar.field_code_id);
        } else {
            ab.e("MicroMsg.CardQrCodeDataInfoStorage", "delete qrCodeData  failure! card_id = %s, code_id = %s", kVar.field_card_id, kVar.field_code_id);
        }
        AppMethodBeat.o(87846);
        return a;
    }

    public final boolean pI(String str) {
        AppMethodBeat.i(87847);
        k kVar = new k();
        kVar.field_card_id = str;
        boolean a = a((c) kVar, "card_id");
        if (a) {
            ab.i("MicroMsg.CardQrCodeDataInfoStorage", "delete qrCodeData by cardId  success! card_id = %s", str);
        } else {
            ab.e("MicroMsg.CardQrCodeDataInfoStorage", "delete qrCodeData by cardId  failure! card_id = %s", str);
        }
        AppMethodBeat.o(87847);
        return a;
    }
}
