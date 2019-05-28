package com.tencent.p177mm.storage.emotion;

import android.database.Cursor;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p213cd.C6398g;
import com.tencent.p177mm.p213cd.C6398g.C1361a;
import com.tencent.p177mm.protocal.protobuf.aia;
import com.tencent.p177mm.protocal.protobuf.aic;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.IOException;

/* renamed from: com.tencent.mm.storage.emotion.h */
public final class C46624h extends C7563j<C44223g> implements C1361a {
    public static final String[] fnj = new String[]{C7563j.m13217a(C44223g.ccO, "EmotionDesignerInfo")};
    public C4927e bSd;

    /* renamed from: com.tencent.mm.storage.emotion.h$a */
    public enum C23518a {
        DesignerSimpleInfo(0),
        PersonalDesigner(1),
        DesignerEmojiList(2);
        
        public int value;

        static {
            AppMethodBeat.m2505o(62852);
        }

        private C23518a(int i) {
            this.value = i;
        }
    }

    static {
        AppMethodBeat.m2504i(62855);
        AppMethodBeat.m2505o(62855);
    }

    public C46624h(C4927e c4927e) {
        super(c4927e, C44223g.ccO, "EmotionDesignerInfo", null);
        this.bSd = c4927e;
    }

    /* renamed from: a */
    public final int mo4744a(C6398g c6398g) {
        this.bSd = c6398g;
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final aic aqn(String str) {
        Throwable e;
        AppMethodBeat.m2504i(62853);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.emoji.EmotionDesignerInfo", "getDesignerSimpleInfoResponseByID failed. Designer ID is null.");
            AppMethodBeat.m2505o(62853);
            return null;
        }
        aic aic;
        Cursor a;
        try {
            a = this.bSd.mo10105a("EmotionDesignerInfo", new String[]{C8741b.CONTENT}, "designerIDAndType=? ", new String[]{str + C23518a.DesignerSimpleInfo.value}, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        aic = new aic();
                        aic.parseFrom(a.getBlob(0));
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.m2505o(62853);
                        return aic;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C4990ab.m7413e("MicroMsg.emoji.EmotionDesignerInfo", "exception:%s", C5046bo.m7574l(e));
                        if (a != null) {
                            a.close();
                            aic = null;
                        } else {
                            aic = null;
                        }
                        AppMethodBeat.m2505o(62853);
                        return aic;
                    } catch (Throwable th) {
                        e = th;
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.m2505o(62853);
                        throw e;
                    }
                }
            }
            aic = null;
            if (a != null) {
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
        } catch (Throwable th2) {
            e = th2;
            a = null;
            if (a != null) {
            }
            AppMethodBeat.m2505o(62853);
            throw e;
        }
        AppMethodBeat.m2505o(62853);
        return aic;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final aia aqo(String str) {
        Throwable e;
        AppMethodBeat.m2504i(62854);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.emoji.EmotionDesignerInfo", "getDesignerEmojiListResponseByUIN failed. Designer UIN is null.");
            AppMethodBeat.m2505o(62854);
            return null;
        }
        aia aia;
        Cursor a;
        try {
            a = this.bSd.mo10105a("EmotionDesignerInfo", new String[]{C8741b.CONTENT}, "designerIDAndType=? ", new String[]{str + C23518a.DesignerEmojiList.value}, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        aia = new aia();
                        aia.parseFrom(a.getBlob(0));
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.m2505o(62854);
                        return aia;
                    }
                } catch (IOException e2) {
                    e = e2;
                    try {
                        C4990ab.m7413e("MicroMsg.emoji.EmotionDesignerInfo", "exception:%s", C5046bo.m7574l(e));
                        if (a != null) {
                            a.close();
                            aia = null;
                        } else {
                            aia = null;
                        }
                        AppMethodBeat.m2505o(62854);
                        return aia;
                    } catch (Throwable th) {
                        e = th;
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.m2505o(62854);
                        throw e;
                    }
                }
            }
            aia = null;
            if (a != null) {
            }
        } catch (IOException e3) {
            e = e3;
            a = null;
        } catch (Throwable th2) {
            e = th2;
            a = null;
            if (a != null) {
            }
            AppMethodBeat.m2505o(62854);
            throw e;
        }
        AppMethodBeat.m2505o(62854);
        return aia;
    }
}
