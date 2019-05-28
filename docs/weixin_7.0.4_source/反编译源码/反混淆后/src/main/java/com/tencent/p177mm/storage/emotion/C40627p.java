package com.tencent.p177mm.storage.emotion;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p213cd.C6398g;
import com.tencent.p177mm.p213cd.C6398g.C1361a;
import com.tencent.p177mm.protocal.protobuf.GetEmotionListResponse;
import com.tencent.p177mm.protocal.protobuf.aii;
import com.tencent.p177mm.protocal.protobuf.aml;
import com.tencent.p177mm.protocal.protobuf.cab;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.IOException;

/* renamed from: com.tencent.mm.storage.emotion.p */
public final class C40627p extends C7563j<C30305o> implements C1361a {
    public static final String[] fnj = new String[]{C7563j.m13217a(C30305o.ccO, "GetEmotionListCache")};
    private C4927e bSd;

    static {
        AppMethodBeat.m2504i(62878);
        AppMethodBeat.m2505o(62878);
    }

    public C40627p(C4927e c4927e) {
        this(c4927e, C30305o.ccO, "GetEmotionListCache");
    }

    private C40627p(C4927e c4927e, C4924a c4924a, String str) {
        super(c4927e, c4924a, str, null);
        this.bSd = c4927e;
    }

    /* renamed from: a */
    public final int mo4744a(C6398g c6398g) {
        this.bSd = c6398g;
        return 0;
    }

    private boolean aqr(String str) {
        AppMethodBeat.m2504i(62869);
        if (this.bSd.delete("GetEmotionListCache", "reqType=?", new String[]{str}) > 0) {
            AppMethodBeat.m2505o(62869);
            return true;
        }
        AppMethodBeat.m2505o(62869);
        return false;
    }

    /* renamed from: a */
    public final boolean mo64086a(int i, GetEmotionListResponse getEmotionListResponse) {
        boolean z = false;
        AppMethodBeat.m2504i(62870);
        if (getEmotionListResponse == null) {
            AppMethodBeat.m2505o(62870);
        } else {
            try {
                this.bSd.delete("GetEmotionListCache", "reqType=?", new String[]{String.valueOf(i)});
                C30305o c30305o = new C30305o(String.valueOf(i), getEmotionListResponse.toByteArray());
                C4990ab.m7411d("MicroMsg.emoji.Storage", "insert cache: %d", Integer.valueOf(i));
                z = mo10101b((C4925c) c30305o);
                AppMethodBeat.m2505o(62870);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.emoji.Storage", "exception:%s", C5046bo.m7574l(e));
                AppMethodBeat.m2505o(62870);
            }
        }
        return z;
    }

    /* renamed from: ME */
    public final GetEmotionListResponse mo64085ME(int i) {
        GetEmotionListResponse getEmotionListResponse = null;
        AppMethodBeat.m2504i(62871);
        Cursor a = this.bSd.mo10105a("GetEmotionListCache", null, "reqType=?", new String[]{String.valueOf(i)}, null, null, null, 2);
        if (a != null && a.moveToFirst()) {
            C30305o c30305o = new C30305o(a);
            try {
                GetEmotionListResponse getEmotionListResponse2 = new GetEmotionListResponse();
                getEmotionListResponse2.parseFrom(c30305o.field_cache);
                C4990ab.m7411d("MicroMsg.emoji.Storage", "succed get cache: %d", Integer.valueOf(i));
                getEmotionListResponse = getEmotionListResponse2;
            } catch (IOException e) {
                C4990ab.m7413e("MicroMsg.emoji.Storage", "exception:%s", C5046bo.m7574l(e));
            }
        }
        if (a != null) {
            a.close();
        }
        AppMethodBeat.m2505o(62871);
        return getEmotionListResponse;
    }

    /* renamed from: a */
    public final boolean mo64088a(String str, aml aml) {
        boolean z = false;
        AppMethodBeat.m2504i(62872);
        if (aml == null) {
            AppMethodBeat.m2505o(62872);
        } else {
            try {
                aqr(str);
                z = mo10101b((C4925c) new C30305o(str, aml.toByteArray()));
                AppMethodBeat.m2505o(62872);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.emoji.Storage", "exception:%s", C5046bo.m7574l(e));
                AppMethodBeat.m2505o(62872);
            }
        }
        return z;
    }

    public final aml aqs(String str) {
        aml aml = null;
        AppMethodBeat.m2504i(62873);
        Cursor a = this.bSd.mo10105a("GetEmotionListCache", null, "reqType=?", new String[]{str}, null, null, null, 2);
        if (a != null && a.moveToFirst()) {
            C30305o c30305o = new C30305o(a);
            try {
                aml aml2 = new aml();
                aml2.parseFrom(c30305o.field_cache);
                C4990ab.m7411d("MicroMsg.emoji.Storage", "succed get designerID cache: %s", str);
                aml = aml2;
            } catch (IOException e) {
                C4990ab.m7413e("MicroMsg.emoji.Storage", "exception:%s", C5046bo.m7574l(e));
            }
        }
        if (a != null) {
            a.close();
        }
        AppMethodBeat.m2505o(62873);
        return aml;
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0060  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final cab bjU() {
        cab cab;
        Throwable e;
        AppMethodBeat.m2504i(62874);
        Cursor query;
        try {
            query = this.bSd.query("GetEmotionListCache", null, "reqType=?", new String[]{"Smiley_panel_req_type"}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        C30305o c30305o = new C30305o(query);
                        cab = new cab();
                        cab.parseFrom(c30305o.field_cache);
                        if (query != null) {
                            query.close();
                        }
                        AppMethodBeat.m2505o(62874);
                        return cab;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C4990ab.m7413e("MicroMsg.emoji.Storage", "exception:%s", C5046bo.m7574l(e));
                        if (query != null) {
                            query.close();
                            cab = null;
                        } else {
                            cab = null;
                        }
                        AppMethodBeat.m2505o(62874);
                        return cab;
                    } catch (Throwable th) {
                        e = th;
                        if (query != null) {
                            query.close();
                        }
                        AppMethodBeat.m2505o(62874);
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
            AppMethodBeat.m2505o(62874);
            throw e;
        }
        AppMethodBeat.m2505o(62874);
        return cab;
    }

    /* renamed from: b */
    public final boolean mo64091b(cab cab) {
        boolean z = false;
        AppMethodBeat.m2504i(62875);
        if (cab == null) {
            AppMethodBeat.m2505o(62875);
        } else {
            try {
                aqr("Smiley_panel_req_type");
                z = mo10101b((C4925c) new C30305o("Smiley_panel_req_type", cab.toByteArray()));
                AppMethodBeat.m2505o(62875);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.emoji.Storage", "exception:%s", C5046bo.m7574l(e));
                AppMethodBeat.m2505o(62875);
            }
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0071  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final aii aqt(String str) {
        Throwable e;
        AppMethodBeat.m2504i(62876);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.emoji.Storage", "getEmotionActivityByID failed. activityID is null.");
            AppMethodBeat.m2505o(62876);
            return null;
        }
        aii aii;
        Cursor query;
        try {
            query = this.bSd.query("GetEmotionListCache", null, "reqType=?", new String[]{str}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        C30305o c30305o = new C30305o(query);
                        aii = new aii();
                        aii.parseFrom(c30305o.field_cache);
                        if (query != null) {
                            query.close();
                        }
                        AppMethodBeat.m2505o(62876);
                        return aii;
                    }
                } catch (IOException e2) {
                    e = e2;
                    try {
                        C4990ab.m7413e("MicroMsg.emoji.Storage", "exception:%s", C5046bo.m7574l(e));
                        if (query != null) {
                            query.close();
                            aii = null;
                        } else {
                            aii = null;
                        }
                        AppMethodBeat.m2505o(62876);
                        return aii;
                    } catch (Throwable th) {
                        e = th;
                        if (query != null) {
                            query.close();
                        }
                        AppMethodBeat.m2505o(62876);
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
            AppMethodBeat.m2505o(62876);
            throw e;
        }
        AppMethodBeat.m2505o(62876);
        return aii;
    }

    /* renamed from: a */
    public final boolean mo64087a(String str, aii aii) {
        boolean z = false;
        AppMethodBeat.m2504i(62877);
        if (aii == null) {
            AppMethodBeat.m2505o(62877);
        } else {
            try {
                aqr(str);
                z = mo10101b((C4925c) new C30305o(str, aii.toByteArray()));
                AppMethodBeat.m2505o(62877);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.emoji.Storage", "exception:%s", C5046bo.m7574l(e));
                AppMethodBeat.m2505o(62877);
            }
        }
        return z;
    }
}
