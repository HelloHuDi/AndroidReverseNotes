package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.g;
import com.tencent.mm.cd.g.a;
import com.tencent.mm.protocal.protobuf.GetEmotionListResponse;
import com.tencent.mm.protocal.protobuf.aii;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.cab;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;

public final class p extends j<o> implements a {
    public static final String[] fnj = new String[]{j.a(o.ccO, "GetEmotionListCache")};
    private e bSd;

    static {
        AppMethodBeat.i(62878);
        AppMethodBeat.o(62878);
    }

    public p(e eVar) {
        this(eVar, o.ccO, "GetEmotionListCache");
    }

    private p(e eVar, c.a aVar, String str) {
        super(eVar, aVar, str, null);
        this.bSd = eVar;
    }

    public final int a(g gVar) {
        this.bSd = gVar;
        return 0;
    }

    private boolean aqr(String str) {
        AppMethodBeat.i(62869);
        if (this.bSd.delete("GetEmotionListCache", "reqType=?", new String[]{str}) > 0) {
            AppMethodBeat.o(62869);
            return true;
        }
        AppMethodBeat.o(62869);
        return false;
    }

    public final boolean a(int i, GetEmotionListResponse getEmotionListResponse) {
        boolean z = false;
        AppMethodBeat.i(62870);
        if (getEmotionListResponse == null) {
            AppMethodBeat.o(62870);
        } else {
            try {
                this.bSd.delete("GetEmotionListCache", "reqType=?", new String[]{String.valueOf(i)});
                o oVar = new o(String.valueOf(i), getEmotionListResponse.toByteArray());
                ab.d("MicroMsg.emoji.Storage", "insert cache: %d", Integer.valueOf(i));
                z = b((c) oVar);
                AppMethodBeat.o(62870);
            } catch (Exception e) {
                ab.e("MicroMsg.emoji.Storage", "exception:%s", bo.l(e));
                AppMethodBeat.o(62870);
            }
        }
        return z;
    }

    public final GetEmotionListResponse ME(int i) {
        GetEmotionListResponse getEmotionListResponse = null;
        AppMethodBeat.i(62871);
        Cursor a = this.bSd.a("GetEmotionListCache", null, "reqType=?", new String[]{String.valueOf(i)}, null, null, null, 2);
        if (a != null && a.moveToFirst()) {
            o oVar = new o(a);
            try {
                GetEmotionListResponse getEmotionListResponse2 = new GetEmotionListResponse();
                getEmotionListResponse2.parseFrom(oVar.field_cache);
                ab.d("MicroMsg.emoji.Storage", "succed get cache: %d", Integer.valueOf(i));
                getEmotionListResponse = getEmotionListResponse2;
            } catch (IOException e) {
                ab.e("MicroMsg.emoji.Storage", "exception:%s", bo.l(e));
            }
        }
        if (a != null) {
            a.close();
        }
        AppMethodBeat.o(62871);
        return getEmotionListResponse;
    }

    public final boolean a(String str, aml aml) {
        boolean z = false;
        AppMethodBeat.i(62872);
        if (aml == null) {
            AppMethodBeat.o(62872);
        } else {
            try {
                aqr(str);
                z = b((c) new o(str, aml.toByteArray()));
                AppMethodBeat.o(62872);
            } catch (Exception e) {
                ab.e("MicroMsg.emoji.Storage", "exception:%s", bo.l(e));
                AppMethodBeat.o(62872);
            }
        }
        return z;
    }

    public final aml aqs(String str) {
        aml aml = null;
        AppMethodBeat.i(62873);
        Cursor a = this.bSd.a("GetEmotionListCache", null, "reqType=?", new String[]{str}, null, null, null, 2);
        if (a != null && a.moveToFirst()) {
            o oVar = new o(a);
            try {
                aml aml2 = new aml();
                aml2.parseFrom(oVar.field_cache);
                ab.d("MicroMsg.emoji.Storage", "succed get designerID cache: %s", str);
                aml = aml2;
            } catch (IOException e) {
                ab.e("MicroMsg.emoji.Storage", "exception:%s", bo.l(e));
            }
        }
        if (a != null) {
            a.close();
        }
        AppMethodBeat.o(62873);
        return aml;
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0060  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final cab bjU() {
        cab cab;
        Throwable e;
        AppMethodBeat.i(62874);
        Cursor query;
        try {
            query = this.bSd.query("GetEmotionListCache", null, "reqType=?", new String[]{"Smiley_panel_req_type"}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        o oVar = new o(query);
                        cab = new cab();
                        cab.parseFrom(oVar.field_cache);
                        if (query != null) {
                            query.close();
                        }
                        AppMethodBeat.o(62874);
                        return cab;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        ab.e("MicroMsg.emoji.Storage", "exception:%s", bo.l(e));
                        if (query != null) {
                            query.close();
                            cab = null;
                        } else {
                            cab = null;
                        }
                        AppMethodBeat.o(62874);
                        return cab;
                    } catch (Throwable th) {
                        e = th;
                        if (query != null) {
                            query.close();
                        }
                        AppMethodBeat.o(62874);
                        throw e;
                    }
                }
            }
            cab = null;
            if (query != null) {
            }
        } catch (Exception e3) {
            e = e3;
            query = null;
        } catch (Throwable th2) {
            e = th2;
            query = null;
            if (query != null) {
            }
            AppMethodBeat.o(62874);
            throw e;
        }
        AppMethodBeat.o(62874);
        return cab;
    }

    public final boolean b(cab cab) {
        boolean z = false;
        AppMethodBeat.i(62875);
        if (cab == null) {
            AppMethodBeat.o(62875);
        } else {
            try {
                aqr("Smiley_panel_req_type");
                z = b((c) new o("Smiley_panel_req_type", cab.toByteArray()));
                AppMethodBeat.o(62875);
            } catch (Exception e) {
                ab.e("MicroMsg.emoji.Storage", "exception:%s", bo.l(e));
                AppMethodBeat.o(62875);
            }
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0071  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final aii aqt(String str) {
        Throwable e;
        AppMethodBeat.i(62876);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.emoji.Storage", "getEmotionActivityByID failed. activityID is null.");
            AppMethodBeat.o(62876);
            return null;
        }
        aii aii;
        Cursor query;
        try {
            query = this.bSd.query("GetEmotionListCache", null, "reqType=?", new String[]{str}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        o oVar = new o(query);
                        aii = new aii();
                        aii.parseFrom(oVar.field_cache);
                        if (query != null) {
                            query.close();
                        }
                        AppMethodBeat.o(62876);
                        return aii;
                    }
                } catch (IOException e2) {
                    e = e2;
                    try {
                        ab.e("MicroMsg.emoji.Storage", "exception:%s", bo.l(e));
                        if (query != null) {
                            query.close();
                            aii = null;
                        } else {
                            aii = null;
                        }
                        AppMethodBeat.o(62876);
                        return aii;
                    } catch (Throwable th) {
                        e = th;
                        if (query != null) {
                            query.close();
                        }
                        AppMethodBeat.o(62876);
                        throw e;
                    }
                }
            }
            aii = null;
            if (query != null) {
            }
        } catch (IOException e3) {
            e = e3;
            query = null;
        } catch (Throwable th2) {
            e = th2;
            query = null;
            if (query != null) {
            }
            AppMethodBeat.o(62876);
            throw e;
        }
        AppMethodBeat.o(62876);
        return aii;
    }

    public final boolean a(String str, aii aii) {
        boolean z = false;
        AppMethodBeat.i(62877);
        if (aii == null) {
            AppMethodBeat.o(62877);
        } else {
            try {
                aqr(str);
                z = b((c) new o(str, aii.toByteArray()));
                AppMethodBeat.o(62877);
            } catch (Exception e) {
                ab.e("MicroMsg.emoji.Storage", "exception:%s", bo.l(e));
                AppMethodBeat.o(62877);
            }
        }
        return z;
    }
}
