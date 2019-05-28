package com.tencent.p177mm.plugin.card.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.card.model.l */
public final class C11289l extends C7563j<C11288k> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C11288k.ccO, "CardQrCodeDataInfo")};
    public C4927e bSd;

    static {
        AppMethodBeat.m2504i(87848);
        AppMethodBeat.m2505o(87848);
    }

    public C11289l(C4927e c4927e) {
        super(c4927e, C11288k.ccO, "CardQrCodeDataInfo", C11288k.diI);
        this.bSd = c4927e;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0047 A:{REMOVE} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: Gw */
    public final List<C11288k> mo22983Gw(String str) {
        AppMethodBeat.m2504i(87843);
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = this.bSd.rawQuery("select * from CardQrCodeDataInfo where card_id =? AND status=0", new String[]{str});
        while (rawQuery != null) {
            try {
                if (!rawQuery.moveToNext()) {
                    break;
                }
                C11288k c11288k = new C11288k();
                c11288k.mo8995d(rawQuery);
                arrayList.add(c11288k);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.CardQrCodeDataInfoStorage", "getCardQrcodeByCardId error!", e.getMessage());
                return arrayList;
            } finally {
                if (rawQuery != null) {
                    rawQuery.close();
                }
                AppMethodBeat.m2505o(87843);
            }
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: Gx */
    public final C11288k mo22984Gx(String str) {
        C11288k c11288k;
        Exception e;
        AppMethodBeat.m2504i(87844);
        Cursor rawQuery = this.bSd.rawQuery("select * from CardQrCodeDataInfo where card_id =? AND status=0  limit 1", new String[]{str});
        if (rawQuery != null) {
            try {
                if (rawQuery.getCount() > 0) {
                    rawQuery.moveToPosition(0);
                    c11288k = new C11288k();
                    try {
                        c11288k.mo8995d(rawQuery);
                        C4990ab.m7417i("MicroMsg.CardQrCodeDataInfoStorage", "getOneCardQrcodeByCardId  success! card_id = %s, code_id = %s ", str, c11288k.field_code_id);
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            C4990ab.m7413e("MicroMsg.CardQrCodeDataInfoStorage", "getOneCardQrcodeByCardId error!", e.getMessage());
                            if (rawQuery != null) {
                                rawQuery.close();
                            }
                            AppMethodBeat.m2505o(87844);
                            return c11288k;
                        } catch (Throwable th) {
                            if (rawQuery != null) {
                                rawQuery.close();
                            }
                            AppMethodBeat.m2505o(87844);
                        }
                    }
                    AppMethodBeat.m2505o(87844);
                    return c11288k;
                }
            } catch (Exception e3) {
                e = e3;
                c11288k = null;
                C4990ab.m7413e("MicroMsg.CardQrCodeDataInfoStorage", "getOneCardQrcodeByCardId error!", e.getMessage());
                if (rawQuery != null) {
                }
                AppMethodBeat.m2505o(87844);
                return c11288k;
            }
        }
        C4990ab.m7413e("MicroMsg.CardQrCodeDataInfoStorage", "getOneCardQrcodeByCardId  is empty! card_id = %s", str);
        c11288k = null;
        if (rawQuery != null) {
        }
        AppMethodBeat.m2505o(87844);
        return c11288k;
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: Gy */
    public final C11288k mo22985Gy(String str) {
        C11288k c11288k;
        Exception e;
        AppMethodBeat.m2504i(87845);
        Cursor rawQuery = this.bSd.rawQuery("select * from CardQrCodeDataInfo where card_id =? AND status=1  limit 1", new String[]{str});
        if (rawQuery != null) {
            try {
                if (rawQuery.getCount() > 0) {
                    rawQuery.moveToPosition(0);
                    c11288k = new C11288k();
                    try {
                        c11288k.mo8995d(rawQuery);
                        C4990ab.m7417i("MicroMsg.CardQrCodeDataInfoStorage", "getCardQrcodeShowingByCardId  success! card_id = %s, code_id = %s ", str, c11288k.field_code_id);
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            C4990ab.m7413e("MicroMsg.CardQrCodeDataInfoStorage", "getCardQrcodeShowingByCardId error!", e.getMessage());
                            if (rawQuery != null) {
                                rawQuery.close();
                            }
                            AppMethodBeat.m2505o(87845);
                            return c11288k;
                        } catch (Throwable th) {
                            if (rawQuery != null) {
                                rawQuery.close();
                            }
                            AppMethodBeat.m2505o(87845);
                        }
                    }
                    AppMethodBeat.m2505o(87845);
                    return c11288k;
                }
            } catch (Exception e3) {
                e = e3;
                c11288k = null;
                C4990ab.m7413e("MicroMsg.CardQrCodeDataInfoStorage", "getCardQrcodeShowingByCardId error!", e.getMessage());
                if (rawQuery != null) {
                }
                AppMethodBeat.m2505o(87845);
                return c11288k;
            }
        }
        C4990ab.m7413e("MicroMsg.CardQrCodeDataInfoStorage", "getCardQrcodeShowingByCardId  is empty! card_id = %s", str);
        c11288k = null;
        if (rawQuery != null) {
        }
        AppMethodBeat.m2505o(87845);
        return c11288k;
    }

    /* renamed from: dm */
    public final boolean mo22986dm(String str, String str2) {
        AppMethodBeat.m2504i(87846);
        C11288k c11288k = new C11288k();
        c11288k.field_card_id = str;
        c11288k.field_code_id = str2;
        boolean a = mo16760a((C4925c) c11288k, "card_id", "code_id");
        if (a) {
            C4990ab.m7417i("MicroMsg.CardQrCodeDataInfoStorage", "delete qrCodeData  success! card_id = %s, code_id = %s", c11288k.field_card_id, c11288k.field_code_id);
        } else {
            C4990ab.m7413e("MicroMsg.CardQrCodeDataInfoStorage", "delete qrCodeData  failure! card_id = %s, code_id = %s", c11288k.field_card_id, c11288k.field_code_id);
        }
        AppMethodBeat.m2505o(87846);
        return a;
    }

    /* renamed from: pI */
    public final boolean mo22987pI(String str) {
        AppMethodBeat.m2504i(87847);
        C11288k c11288k = new C11288k();
        c11288k.field_card_id = str;
        boolean a = mo16760a((C4925c) c11288k, "card_id");
        if (a) {
            C4990ab.m7417i("MicroMsg.CardQrCodeDataInfoStorage", "delete qrCodeData by cardId  success! card_id = %s", str);
        } else {
            C4990ab.m7413e("MicroMsg.CardQrCodeDataInfoStorage", "delete qrCodeData by cardId  failure! card_id = %s", str);
        }
        AppMethodBeat.m2505o(87847);
        return a;
    }
}
